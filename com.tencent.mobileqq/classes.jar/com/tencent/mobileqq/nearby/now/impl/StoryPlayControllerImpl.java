package com.tencent.mobileqq.nearby.now.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel.OnDataComeListener;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.InfinitePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.PlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.GestureListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayControllerImpl
  implements ViewPager.OnPageChangeListener, IStoryPlayController, StuffContainerView.GestureListener
{
  public static final int MSG_CHECK_GUIDE = 1001;
  public static final String TAG = "VideoPlayController";
  public static final int UNSUPPORT_IMAGE_ERROR_CODE = 1000730;
  public QQAppInterface app;
  public ActCallBack callBack;
  public QQStoryVideoPlayerErrorView errorView;
  private Runnable hideNewGuideRunnable = new StoryPlayControllerImpl.9(this);
  boolean isUrlProvided = false;
  public HashMap<Integer, IVideoInfoListener> itemListeners = new HashMap();
  public VideoPlayerPagerAdapter mAdapter;
  public Bundle mBundle;
  public Context mContext;
  public int mCurrentIndex;
  public int mCurrentMediaType;
  BasePlayListDataModel.OnDataComeListener mDataComeListener = new StoryPlayControllerImpl.2(this);
  private String mFeedId = "";
  private boolean mFirstPlayShow = true;
  private boolean mFirstResume = true;
  public int mFirstShowIndex = 0;
  Handler mHandler = new StoryPlayControllerImpl.1(this);
  private boolean mHasShowToast = false;
  private boolean mInfiniteFirstPlay = false;
  private boolean mIsDestroy;
  private boolean mIsFirstGetData = true;
  private boolean mIsInfinite = false;
  public boolean mIsMultiProgressBar = false;
  private boolean mIsShownNewGuide;
  public boolean mNeedRepeat = false;
  private StoryNewGuideDialog mNewGuideDialog;
  private int mOldState = -1;
  public BasePlayListDataModel mPlayListDataModel;
  public QQStoryLoadingView mProgressBar;
  private boolean mShouldOpenComment = false;
  public IMagazinePlayerView mVideoPlayer;
  public StuffContainerView stuffContainerView;
  
  private void checkNewGuide(int paramInt)
  {
    if (paramInt != this.mCurrentIndex) {
      return;
    }
    if (this.mIsDestroy) {
      return;
    }
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = this.mAdapter.a(paramInt);
    if (localVideoViewHolder == null) {
      return;
    }
    if ((this.mAdapter.jdField_a_of_type_JavaUtilList.size() > 1) && (!this.mIsShownNewGuide))
    {
      if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        ((IVideoPlayerView)this.mVideoPlayer).pause();
      }
      if (this.mNewGuideDialog != null) {
        return;
      }
      this.mNewGuideDialog = new StoryNewGuideDialog(this.stuffContainerView.jdField_a_of_type_AndroidAppActivity);
      this.mNewGuideDialog.a(HardCodeUtil.a(2131714350));
      HashMap localHashMap = this.itemListeners;
      this.mNewGuideDialog.setOnDismissListener(new StoryPlayControllerImpl.8(this, localVideoViewHolder, localHashMap));
      this.mNewGuideDialog.show();
      this.mIsShownNewGuide = true;
      ((IStorageCenter)QRoute.api(IStorageCenter.class)).putBoolean("short_video_player_guide_shown", true);
      ThreadManager.getUIHandler().postDelayed(this.hideNewGuideRunnable, 3000L);
    }
  }
  
  private void playPictuer(int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    this.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(true);
    paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new StoryPlayControllerImpl.6(this, paramVideoViewHolder, paramVideoData));
    if (paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
    {
      if ((this.mAdapter.a(paramInt) instanceof IShortVideoCommentsView))
      {
        IShortVideoCommentsView localIShortVideoCommentsView = (IShortVideoCommentsView)this.mAdapter.a(paramInt);
        ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicLayoutStoryImageContainerView(paramVideoViewHolder, ((ImageData)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int, ((ImageData)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, paramVideoData, localIShortVideoCommentsView);
      }
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(paramVideoData);
      hideRootCover();
    }
  }
  
  private void playShortVideo(int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    
    if (NetworkUtil.a(getContext()) != 1)
    {
      int i = this.mCurrentMediaType;
      if ((i != 4) && (i != VideoData.jdField_a_of_type_Int) && (!paramVideoData.jdField_d_of_type_Boolean))
      {
        QQToast.a(getContext(), HardCodeUtil.a(2131714340), 1).a();
        this.mHasShowToast = true;
      }
    }
    ActCallBack localActCallBack = this.callBack;
    if (localActCallBack != null) {
      localActCallBack.a();
    }
    if ((paramVideoViewHolder != null) && (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
      ((IVideoPlayerView)this.mVideoPlayer).setOnVideoInfoListener((IVideoInfoListener)this.itemListeners.get(Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_Int)));
      ((IVideoPlayerView)this.mVideoPlayer).play(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, new StoryPlayControllerImpl.5(this));
    }
    this.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(paramInt, 0);
    if (QLog.isColorLevel())
    {
      paramVideoViewHolder = new StringBuilder();
      paramVideoViewHolder.append("playShortVideovideoDataIndex is: ");
      paramVideoViewHolder.append(paramInt);
      paramVideoViewHolder.append(" percent is: ");
      paramVideoViewHolder.append(0);
      QLog.i("VideoPlayController", 2, paramVideoViewHolder.toString());
    }
  }
  
  private void showSlideGuide(int paramInt)
  {
    if (!this.mIsShownNewGuide)
    {
      this.mHandler.removeMessages(1001);
      this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void doOnDestroy()
  {
    if (this.mVideoPlayer.getVideoData() != null)
    {
      double d1 = 0.0D;
      long l1 = ((IVideoPlayerView)this.mVideoPlayer).getFileSize();
      long l2 = ((IVideoPlayerView)this.mVideoPlayer).getDownloadOffset();
      if (l1 != 0L)
      {
        d1 = l2;
        double d2 = l1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
      }
      QualityReporter.a(this.mVideoPlayer.getVideoData().jdField_a_of_type_JavaLangString, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(QualityReporter.b()), ((IVideoPlayerView)this.mVideoPlayer).isPlaying());
    }
    ((IVideoPlayerView)this.mVideoPlayer).suspend();
    this.mAdapter.a();
    this.mIsDestroy = true;
  }
  
  public void doOnPause()
  {
    ((IVideoPlayerView)this.mVideoPlayer).pause();
  }
  
  public void doOnResume()
  {
    ((IVideoPlayerView)this.mVideoPlayer).resume();
    if (NetworkUtil.a(getContext()) != 1)
    {
      int i = this.mCurrentMediaType;
      if ((i != 4) && (i != VideoData.jdField_a_of_type_Int) && (this.mVideoPlayer.getVideoData() != null) && (!this.mVideoPlayer.getVideoData().jdField_d_of_type_Boolean)) {
        QQToast.a(getContext(), HardCodeUtil.a(2131714351), 1).a();
      }
    }
    this.mFirstResume = false;
  }
  
  public Object getAdapter()
  {
    return this.mAdapter;
  }
  
  public Object getBasePlayListDataModel()
  {
    return this.mPlayListDataModel;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getCurrentIndex()
  {
    return this.mCurrentIndex;
  }
  
  public int getCurrentMediaType()
  {
    return this.mCurrentMediaType;
  }
  
  protected int getCurrentProgressIndex(int paramInt)
  {
    return paramInt;
  }
  
  public int getFirstShowIndex()
  {
    return this.mFirstShowIndex;
  }
  
  public HashMap<Integer, Object> getItemListeners()
  {
    return this.itemListeners;
  }
  
  public int getOldState()
  {
    return this.mOldState;
  }
  
  public Object getStuffContainerView()
  {
    return this.stuffContainerView;
  }
  
  public String getValue(String paramString)
  {
    Object localObject = this.mBundle;
    if (localObject != null) {
      localObject = ((Bundle)localObject).getString(paramString);
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = this.mBundle;
    if (localObject == null) {
      return "";
    }
    localObject = ((Bundle)localObject).getString("raw_url");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    localObject = Uri.parse((String)localObject);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException);
      localStringBuilder.append("getValue no value in url key=");
      localStringBuilder.append(paramString);
      QLog.w("VideoPlayController", 1, localStringBuilder.toString());
      paramString = "";
    }
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString;
  }
  
  public Object getVideoPlayer()
  {
    return this.mVideoPlayer;
  }
  
  public void handleDeviceNavChange()
  {
    IVideoInfoListener localIVideoInfoListener = (IVideoInfoListener)this.itemListeners.get(Integer.valueOf(this.mCurrentIndex));
    if (localIVideoInfoListener != null) {
      localIVideoInfoListener.handleDeviceNavChange();
    }
  }
  
  public void hideRootCover()
  {
    ActCallBack localActCallBack = this.callBack;
    if (localActCallBack != null) {
      localActCallBack.b();
    }
  }
  
  public StoryPlayControllerImpl init(Context paramContext, Object paramObject1, Object paramObject2, Bundle paramBundle, Object paramObject3, AppInterface paramAppInterface, ActCallBack paramActCallBack)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    this.app = paramAppInterface;
    this.stuffContainerView = ((StuffContainerView)paramObject1);
    this.mAdapter = ((VideoPlayerPagerAdapter)paramObject2);
    this.mContext = paramContext;
    this.mVideoPlayer = ((IMagazinePlayerViewCreater)QRoute.api(IMagazinePlayerViewCreater.class)).create(paramContext, paramActCallBack, paramAppInterface);
    this.errorView = ((QQStoryVideoPlayerErrorView)paramObject3);
    this.mBundle = paramBundle;
    paramContext = getValue("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.mNeedRepeat = true;
    }
    this.mIsMultiProgressBar = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.mIsShownNewGuide = ((IStorageCenter)QRoute.api(IStorageCenter.class)).getBoolean("short_video_player_guide_shown", false);
    this.callBack = paramActCallBack;
    return this;
  }
  
  public void initReporterFeedType()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = this.mAdapter;
    if (localVideoPlayerPagerAdapter != null)
    {
      if (localVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      if (this.mAdapter.jdField_a_of_type_JavaUtilList.size() > 0) {
        if ((!this.mAdapter.a(0).jdField_d_of_type_Boolean) && (this.mAdapter.jdField_a_of_type_JavaUtilList.size() <= 1))
        {
          if (this.mAdapter.a(0).k == 4) {
            ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedType("2");
          }
          if (this.mAdapter.a(0).k != 4) {
            ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedType("1");
          }
        }
        else
        {
          ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedType("3");
        }
      }
    }
  }
  
  public void initialize(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("play_list", true)) {
      if ("2".equals(paramBundle.getString("play_mode", "1")))
      {
        this.mIsInfinite = false;
        this.mPlayListDataModel = new PlayListDataModel();
        if ("1".equals(paramBundle.getString("isLocal"))) {
          this.mPlayListDataModel.a(true);
        }
      }
      else
      {
        this.mIsInfinite = true;
        this.mPlayListDataModel = new InfinitePlayListDataModel();
      }
    }
    Object localObject = paramBundle.getString("raw_url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rawUrl = ");
    localStringBuilder.append((String)localObject);
    QLog.i("VideoPlayController", 1, localStringBuilder.toString());
    this.mFeedId = getValue("feeds_id");
    if (TextUtils.isEmpty(this.mFeedId))
    {
      this.mFeedId = getValue("feed_id");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" feeds_id is null,feed_id ==");
      ((StringBuilder)localObject).append(this.mFeedId);
      QLog.i("VideoPlayController", 1, ((StringBuilder)localObject).toString());
    }
    if (this.mFeedId == null) {
      this.mFeedId = "";
    }
    this.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(false);
    localObject = paramBundle.getString("processbar");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int i = 2;
    if (!bool) {}
    try
    {
      int j = Integer.parseInt((String)localObject);
      if (j == 1) {
        this.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(false);
      } else if (j == 2) {
        this.stuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(true);
      }
    }
    catch (Exception localException)
    {
      label297:
      break label297;
    }
    QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
    this.mShouldOpenComment = paramBundle.getBoolean("should_show_comment_view", false);
    this.mPlayListDataModel.a(paramBundle);
    paramBundle = this.mPlayListDataModel;
    paramBundle.a = this.app;
    paramBundle.a(this.mDataComeListener);
    QualityReporter.a();
    this.mPlayListDataModel.a();
    paramBundle = new VideoData();
    localObject = getValue("preLoadParams");
    bool = getValue("feed_type").equals("4");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("preLoadJson~ in init = ");
    localStringBuilder.append((String)localObject);
    QLog.i("VideoPlayController", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = URLDecoder.decode((String)localObject);
    }
    try
    {
      this.isUrlProvided = true;
      localObject = new JSONObject((String)localObject);
      paramBundle.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id");
      paramBundle.f = ((JSONObject)localObject).optString("headerUrl");
      paramBundle.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
      paramBundle.l = ((JSONObject)localObject).optInt("videoHeight");
      paramBundle.m = ((JSONObject)localObject).optInt("videoWidth");
      paramBundle.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("coverUrl");
      paramBundle.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("doodleUrl");
      paramBundle.jdField_g_of_type_Long = ((JSONObject)localObject).optLong("video_timelong");
      if (((JSONObject)localObject).optLong("is_local") == 1L) {
        i = 4;
      }
      paramBundle.jdField_b_of_type_Int = i;
      paramBundle.jdField_d_of_type_Boolean = true;
      paramBundle.k = 3;
      if (bool)
      {
        paramBundle.k = 4;
        paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject = new ImageData();
        ((ImageData)localObject).jdField_b_of_type_Int = paramBundle.l;
        ((ImageData)localObject).jdField_a_of_type_Int = paramBundle.m;
        ((ImageData)localObject).jdField_a_of_type_JavaLangString = paramBundle.jdField_c_of_type_JavaLangString;
        paramBundle.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      if (paramBundle.jdField_b_of_type_Int == 4) {
        this.mPlayListDataModel.a(true);
      } else {
        this.mPlayListDataModel.b();
      }
      this.mPlayListDataModel.a().add(paramBundle);
      this.mPlayListDataModel.a(this.mFeedId, paramBundle.jdField_a_of_type_JavaLangString);
      this.mDataComeListener.a(1, 0);
      this.stuffContainerView.setCurrentItem(0, false);
      return;
    }
    catch (JSONException paramBundle)
    {
      label724:
      break label724;
    }
    QLog.i("VideoPlayController", 1, "no preload params~ in init");
  }
  
  public boolean isIsMultiProgressBar()
  {
    return this.mIsMultiProgressBar;
  }
  
  public boolean isMultiProgressBar()
  {
    return this.mIsMultiProgressBar;
  }
  
  public boolean isNeedRepeat()
  {
    return this.mNeedRepeat;
  }
  
  public boolean isRefreshCurrentItem()
  {
    return this.mIsInfinite;
  }
  
  protected boolean isVideoListEnd()
  {
    return this.mPlayListDataModel.a();
  }
  
  public void loadCoverImage(ImageView paramImageView, String paramString, Object paramObject)
  {
    paramObject = (IVideoInfoListener)paramObject;
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), UITools.a(this.mContext) / 2, UITools.b(this.mContext) / 2, new StoryPlayControllerImpl.3(this, paramImageView, paramObject), false);
  }
  
  public void onFillData(Object paramObject1, VideoData paramVideoData, boolean paramBoolean, Object paramObject2)
  {
    onFillData((VideoPlayerPagerAdapter.VideoViewHolder)paramObject1, paramVideoData, paramBoolean, (IShortVideoCommentsView)paramObject2, true);
  }
  
  public void onFillData(Object paramObject1, VideoData paramVideoData, boolean paramBoolean1, Object paramObject2, boolean paramBoolean2)
  {
    paramObject1 = (VideoPlayerPagerAdapter.VideoViewHolder)paramObject1;
    paramObject2 = (IShortVideoCommentsView)paramObject2;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFillData() called with: holder = [");
      ((StringBuilder)localObject).append(paramObject1);
      ((StringBuilder)localObject).append("], videoData = [");
      ((StringBuilder)localObject).append(paramVideoData);
      ((StringBuilder)localObject).append("], willToPlay = [");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], commentsView = [");
      ((StringBuilder)localObject).append(paramObject2);
      ((StringBuilder)localObject).append("]");
      QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    paramObject1.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
    paramObject1.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    if ((paramVideoData.jdField_c_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramVideoData.jdField_c_of_type_JavaLangString)))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.s);
      paramObject1.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
    else
    {
      paramObject1.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    boolean bool = ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(paramObject1, paramVideoData.m, paramVideoData.l);
    paramObject2 = ((IVideoInfoListener)QRoute.api(IVideoInfoListener.class)).init(paramObject1, this, paramObject2, bool);
    this.itemListeners.put(Integer.valueOf(paramObject1.jdField_a_of_type_Int), paramObject2);
    if (paramVideoData.jdField_b_of_type_Int == 4)
    {
      paramObject1.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
      if (paramObject1.jdField_a_of_type_AndroidViewView != null) {
        paramObject1.jdField_a_of_type_AndroidViewView.findViewById(2131378833).setVisibility(4);
      }
    }
    prepare(paramBoolean1, paramObject1.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, paramObject2, paramBoolean2);
  }
  
  public void onFlingDown() {}
  
  public void onFlingLeft() {}
  
  public void onFlingRight() {}
  
  public void onFlingUp() {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.stuffContainerView.d();
      return true;
    }
    return false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.mAdapter.jdField_a_of_type_JavaUtilList.size() == 1) {
      return;
    }
    if (paramInt == this.mOldState) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        ((IVideoPlayerView)this.mVideoPlayer).pause();
      }
    }
    else
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPageScrollStateChanged SCROLL_STATE_IDLE currentIndex is: ");
        localStringBuilder.append(this.mCurrentIndex);
        QLog.i("VideoPlayController", 2, localStringBuilder.toString());
      }
      if (this.mCurrentIndex >= this.mAdapter.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      if (((VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(this.mCurrentIndex)).jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("videoItem.isReady state = [");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("]");
          QLog.i("VideoPlayController", 2, localStringBuilder.toString());
        }
        ((IVideoPlayerView)this.mVideoPlayer).resume();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startPlayVideo state = [");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("]");
          QLog.i("VideoPlayController", 2, localStringBuilder.toString());
        }
        QualityReporter.a(1);
        startPlayVideo(this.mCurrentIndex);
      }
    }
    this.mOldState = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    paramInt = paramInt - 50 + this.mAdapter.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected index is: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mCurrentIndex=");
      ((StringBuilder)localObject).append(this.mCurrentIndex);
      QLog.i("VideoPlayController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt < 0) {
      return;
    }
    if (this.mAdapter.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (paramInt >= this.mAdapter.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      this.mPlayListDataModel.a(this.mFeedId, ((VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(this.mAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString);
      this.mFeedId = ((VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(this.mAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString;
      this.mPlayListDataModel.a();
    }
    if (paramInt < 2)
    {
      this.mPlayListDataModel.a(this.mFeedId, ((VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
      this.mFeedId = ((VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      this.mPlayListDataModel.b();
    }
    if (paramInt < this.mCurrentIndex) {
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_left_slide").genderInd1().reportByVideo(this.app);
    }
    Object localObject = (VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(this.mCurrentIndex);
    ((VideoData)localObject).jdField_c_of_type_Boolean = false;
    if (paramInt > this.mCurrentIndex)
    {
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_right_slide").genderInd1().reportByVideo(this.app);
      ThreadManagerV2.excute(new StoryPlayControllerImpl.7(this, (VideoData)localObject, (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    }
    this.mCurrentIndex = paramInt;
  }
  
  public void onPagerItemClick(View paramView) {}
  
  public void onSingleTap() {}
  
  public void onViewConstruct(LayoutInflater paramLayoutInflater, Object paramObject1, Object paramObject2) {}
  
  public void prepare(boolean paramBoolean, RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject)
  {
    prepare(paramBoolean, paramRelativeLayout, paramVideoData, (IVideoInfoListener)paramObject, true);
  }
  
  public void prepare(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject, boolean paramBoolean2)
  {
    paramObject = (IVideoInfoListener)paramObject;
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131369331);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131365808);
    localImageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView1.setVisibility(0);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepare() called with: willToPlay = [");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], rootView = [");
      localStringBuilder.append(paramRelativeLayout);
      localStringBuilder.append("], videoData = [");
      localStringBuilder.append(paramVideoData);
      localStringBuilder.append("], videoInfoListener = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("], loadCover = [");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("]");
      QLog.i("VideoPlayController", 2, localStringBuilder.toString());
    }
    if ((paramBoolean2) && (paramVideoData.jdField_c_of_type_JavaLangString != null)) {
      if (!paramVideoData.jdField_d_of_type_Boolean)
      {
        loadCoverImage(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramObject);
      }
      else
      {
        paramRelativeLayout = AbsDownloader.getFile(paramVideoData.jdField_c_of_type_JavaLangString);
        if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
          try
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("load cover,localFile exists,filepath = ");
              localStringBuilder.append(paramRelativeLayout.getAbsolutePath());
              QLog.e("VideoPlayController", 2, localStringBuilder.toString());
            }
            localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
            ((IVideoPlayerView.VideoInfoListener)paramObject).onCoverComplete(paramVideoData.m, paramVideoData.l, true);
          }
          catch (OutOfMemoryError paramRelativeLayout)
          {
            QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
            loadCoverImage(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramObject);
          }
        } else {
          loadCoverImage(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramObject);
        }
      }
    }
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(localImageView2, paramVideoData.jdField_d_of_type_JavaLangString, new ColorDrawable(0), new ColorDrawable(0), new StoryPlayControllerImpl.4(this, paramObject));
  }
  
  public void returnBack()
  {
    this.stuffContainerView.d();
  }
  
  public void setCurrentIndex(int paramInt)
  {
    this.mCurrentIndex = paramInt;
  }
  
  public void setCurrentMediaType(int paramInt)
  {
    this.mCurrentMediaType = paramInt;
  }
  
  public void setFirstShowIndex(int paramInt)
  {
    this.mFirstShowIndex = paramInt;
  }
  
  public void setIsMultiProgressBar(boolean paramBoolean)
  {
    this.mIsMultiProgressBar = paramBoolean;
  }
  
  public void setNeedRepeat(boolean paramBoolean)
  {
    this.mNeedRepeat = paramBoolean;
  }
  
  public void setOldState(int paramInt)
  {
    this.mOldState = paramInt;
  }
  
  public void setVideoPlayer(Object paramObject)
  {
    this.mVideoPlayer = ((IMagazinePlayerView)paramObject);
  }
  
  @TargetApi(14)
  public void startPlayVideo(int paramInt)
  {
    Object localObject = this.mAdapter.a(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startPlayVideo: videoViewHolder == null videoDataIndex=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("  mAdapter.realIndex");
        ((StringBuilder)localObject).append(this.mAdapter.jdField_a_of_type_Int);
        QLog.e("VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    VideoData localVideoData = (VideoData)this.mAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localVideoData != null)
    {
      QualityReporter.a(localVideoData.jdField_a_of_type_JavaLangString, 2, "0", "0");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlayVideo:videoItem=");
        localStringBuilder.append(localVideoData);
        localStringBuilder.append(",videoItem.anchorUin=");
        localStringBuilder.append(localVideoData.jdField_a_of_type_Long);
        localStringBuilder.append(",videoItem.anchorNickName=");
        localStringBuilder.append(localVideoData.jdField_g_of_type_JavaLangString);
        QLog.i("VideoPlayController", 2, localStringBuilder.toString());
      }
      if (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.jdField_a_of_type_Long;
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
      if (paramInt != this.mCurrentIndex) {
        return;
      }
      if (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b();
      }
      this.mCurrentMediaType = localVideoData.k;
      if (localVideoData.k == 4)
      {
        playPictuer(paramInt, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localVideoData);
        ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(localVideoData.jdField_a_of_type_JavaLangString, null);
        ((INearbyMomentManager)this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(localVideoData.jdField_a_of_type_JavaLangString);
        return;
      }
      if (localVideoData.k == VideoData.jdField_a_of_type_Int)
      {
        ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(localVideoData.jdField_a_of_type_JavaLangString, null);
        ((INearbyMomentManager)this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(localVideoData.jdField_a_of_type_JavaLangString);
        return;
      }
      playShortVideo(paramInt, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localVideoData);
      if (NetworkUtil.a(getContext()) != 1)
      {
        int i = this.mCurrentMediaType;
        if ((i != 4) && (i != VideoData.jdField_a_of_type_Int) && (!localVideoData.jdField_d_of_type_Boolean))
        {
          QQToast.a(getContext(), HardCodeUtil.a(2131714347), 1).a();
          this.mFirstPlayShow = false;
        }
      }
      showSlideGuide(paramInt);
    }
  }
  
  public void updateVideoLabelState()
  {
    if ((this.mAdapter.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.mAdapter.jdField_a_of_type_JavaUtilList != null)) {
      return;
    }
    QLog.e("VideoPlayController", 1, "updateVideoLabelState mAdapter.mVideoViewHolderList == null || mAdapter.mVideoDataList == null !!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl
 * JD-Core Version:    0.7.0.1
 */