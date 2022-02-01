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
    if ((this.mAdapter.d.size() > 1) && (!this.mIsShownNewGuide))
    {
      if ((localVideoViewHolder != null) && (localVideoViewHolder.c != null)) {
        ((IVideoPlayerView)this.mVideoPlayer).pause();
      }
      if (this.mNewGuideDialog != null) {
        return;
      }
      this.mNewGuideDialog = new StoryNewGuideDialog(this.stuffContainerView.a);
      this.mNewGuideDialog.a(HardCodeUtil.a(2131911864));
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
    this.stuffContainerView.h.a(true);
    paramVideoViewHolder.e.setRelayoutListener(new StoryPlayControllerImpl.6(this, paramVideoViewHolder, paramVideoData));
    if (paramVideoData.M.get(0) != null)
    {
      if ((this.mAdapter.d(paramInt) instanceof IShortVideoCommentsView))
      {
        IShortVideoCommentsView localIShortVideoCommentsView = (IShortVideoCommentsView)this.mAdapter.d(paramInt);
        ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicLayoutStoryImageContainerView(paramVideoViewHolder, ((ImageData)paramVideoData.M.get(0)).c, ((ImageData)paramVideoData.M.get(0)).b, paramVideoData, localIShortVideoCommentsView);
      }
      paramVideoViewHolder.e.setVisibility(8);
      paramVideoViewHolder.e.a(paramVideoData);
      hideRootCover();
    }
  }
  
  private void playShortVideo(int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    
    if (NetworkUtil.b(getContext()) != 1)
    {
      int i = this.mCurrentMediaType;
      if ((i != 4) && (i != VideoData.a) && (!paramVideoData.L))
      {
        QQToast.makeText(getContext(), HardCodeUtil.a(2131911854), 1).show();
        this.mHasShowToast = true;
      }
    }
    ActCallBack localActCallBack = this.callBack;
    if (localActCallBack != null) {
      localActCallBack.d();
    }
    if ((paramVideoViewHolder != null) && (paramVideoViewHolder.d != null))
    {
      paramVideoViewHolder.d.a(paramVideoData);
      ((IVideoPlayerView)this.mVideoPlayer).setOnVideoInfoListener((IVideoInfoListener)this.itemListeners.get(Integer.valueOf(paramVideoViewHolder.a)));
      ((IVideoPlayerView)this.mVideoPlayer).play(paramVideoViewHolder.c, paramVideoData, new StoryPlayControllerImpl.5(this));
    }
    this.stuffContainerView.h.a(paramInt, 0);
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
      QualityReporter.a(this.mVideoPlayer.getVideoData().c, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(QualityReporter.h()), ((IVideoPlayerView)this.mVideoPlayer).isPlaying());
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
    if (NetworkUtil.b(getContext()) != 1)
    {
      int i = this.mCurrentMediaType;
      if ((i != 4) && (i != VideoData.a) && (this.mVideoPlayer.getVideoData() != null) && (!this.mVideoPlayer.getVideoData().L)) {
        QQToast.makeText(getContext(), HardCodeUtil.a(2131911865), 1).show();
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
      localActCallBack.e();
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
      if (localVideoPlayerPagerAdapter.d == null) {
        return;
      }
      if (this.mAdapter.d.size() > 0) {
        if ((!this.mAdapter.c(0).L) && (this.mAdapter.d.size() <= 1))
        {
          if (this.mAdapter.c(0).G == 4) {
            ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedType("2");
          }
          if (this.mAdapter.c(0).G != 4) {
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
    this.stuffContainerView.h.a(false);
    localObject = paramBundle.getString("processbar");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject);
    int i = 2;
    if (!bool) {}
    try
    {
      int j = Integer.parseInt((String)localObject);
      if (j == 1) {
        this.stuffContainerView.h.a(false);
      } else if (j == 2) {
        this.stuffContainerView.h.a(true);
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
    paramBundle.c = this.app;
    paramBundle.a(this.mDataComeListener);
    QualityReporter.a();
    this.mPlayListDataModel.b();
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
      paramBundle.c = ((JSONObject)localObject).optString("id");
      paramBundle.m = ((JSONObject)localObject).optString("headerUrl");
      paramBundle.d = ((JSONObject)localObject).optString("videoUrl");
      paramBundle.H = ((JSONObject)localObject).optInt("videoHeight");
      paramBundle.I = ((JSONObject)localObject).optInt("videoWidth");
      paramBundle.e = ((JSONObject)localObject).optString("coverUrl");
      paramBundle.f = ((JSONObject)localObject).optString("doodleUrl");
      paramBundle.z = ((JSONObject)localObject).optLong("video_timelong");
      if (((JSONObject)localObject).optLong("is_local") == 1L) {
        i = 4;
      }
      paramBundle.b = i;
      paramBundle.L = true;
      paramBundle.G = 3;
      if (bool)
      {
        paramBundle.G = 4;
        paramBundle.M = new ArrayList();
        localObject = new ImageData();
        ((ImageData)localObject).c = paramBundle.H;
        ((ImageData)localObject).b = paramBundle.I;
        ((ImageData)localObject).a = paramBundle.e;
        paramBundle.M.add(localObject);
      }
      if (paramBundle.b == 4) {
        this.mPlayListDataModel.a(true);
      } else {
        this.mPlayListDataModel.c();
      }
      this.mPlayListDataModel.a().add(paramBundle);
      this.mPlayListDataModel.a(this.mFeedId, paramBundle.c);
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
    return this.mPlayListDataModel.e();
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
    paramObject1.d.a(paramVideoData);
    paramObject1.d.a(true);
    if ((paramVideoData.e != null) && (!TextUtils.isEmpty(paramVideoData.e)))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.e, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.t);
      paramObject1.c.setBackgroundDrawable((Drawable)localObject);
    }
    else
    {
      paramObject1.c.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    boolean bool = ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(paramObject1, paramVideoData.I, paramVideoData.H);
    paramObject2 = ((IVideoInfoListener)QRoute.api(IVideoInfoListener.class)).init(paramObject1, this, paramObject2, bool);
    this.itemListeners.put(Integer.valueOf(paramObject1.a), paramObject2);
    if (paramVideoData.b == 4)
    {
      paramObject1.d.setVisibility(8);
      if (paramObject1.g != null) {
        paramObject1.g.findViewById(2131447530).setVisibility(4);
      }
    }
    prepare(paramBoolean1, paramObject1.c, paramVideoData, paramObject2, paramBoolean2);
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
    if (this.mAdapter.d.size() == 1) {
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
      if (this.mCurrentIndex >= this.mAdapter.d.size()) {
        return;
      }
      if (((VideoData)this.mAdapter.d.get(this.mCurrentIndex)).K)
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
    paramInt = paramInt - 50 + this.mAdapter.h;
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
    if (this.mAdapter.d.size() == 0) {
      return;
    }
    if (paramInt >= this.mAdapter.d.size() - 2)
    {
      this.mPlayListDataModel.a(this.mFeedId, ((VideoData)this.mAdapter.d.get(this.mAdapter.d.size() - 1)).c);
      this.mFeedId = ((VideoData)this.mAdapter.d.get(this.mAdapter.d.size() - 1)).c;
      this.mPlayListDataModel.b();
    }
    if (paramInt < 2)
    {
      this.mPlayListDataModel.a(this.mFeedId, ((VideoData)this.mAdapter.d.get(0)).c);
      this.mFeedId = ((VideoData)this.mAdapter.d.get(0)).c;
      this.mPlayListDataModel.c();
    }
    if (paramInt < this.mCurrentIndex) {
      ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_left_slide").genderInd1().reportByVideo(this.app);
    }
    Object localObject = (VideoData)this.mAdapter.d.get(this.mCurrentIndex);
    ((VideoData)localObject).K = false;
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
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131436334);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131432065);
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
    if ((paramBoolean2) && (paramVideoData.e != null)) {
      if (!paramVideoData.L)
      {
        loadCoverImage(localImageView1, paramVideoData.e, paramObject);
      }
      else
      {
        paramRelativeLayout = AbsDownloader.getFile(paramVideoData.e);
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
            ((IVideoPlayerView.VideoInfoListener)paramObject).onCoverComplete(paramVideoData.I, paramVideoData.H, true);
          }
          catch (OutOfMemoryError paramRelativeLayout)
          {
            QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
            loadCoverImage(localImageView1, paramVideoData.e, paramObject);
          }
        } else {
          loadCoverImage(localImageView1, paramVideoData.e, paramObject);
        }
      }
    }
    ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(localImageView2, paramVideoData.f, new ColorDrawable(0), new ColorDrawable(0), new StoryPlayControllerImpl.4(this, paramObject));
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
        ((StringBuilder)localObject).append(this.mAdapter.h);
        QLog.e("VideoPlayController", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    VideoData localVideoData = (VideoData)this.mAdapter.d.get(paramInt);
    if (localVideoData != null)
    {
      QualityReporter.a(localVideoData.c, 2, "0", "0");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlayVideo:videoItem=");
        localStringBuilder.append(localVideoData);
        localStringBuilder.append(",videoItem.anchorUin=");
        localStringBuilder.append(localVideoData.i);
        localStringBuilder.append(",videoItem.anchorNickName=");
        localStringBuilder.append(localVideoData.s);
        QLog.i("VideoPlayController", 2, localStringBuilder.toString());
      }
      if (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d != null)
      {
        long l = localVideoData.i;
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d.setCurrentAnchorUin(l);
      }
      if (paramInt != this.mCurrentIndex) {
        return;
      }
      if (((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d != null) {
        ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).d.b();
      }
      this.mCurrentMediaType = localVideoData.G;
      if (localVideoData.G == 4)
      {
        playPictuer(paramInt, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localVideoData);
        ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(localVideoData.c, null);
        ((INearbyMomentManager)this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(localVideoData.c);
        return;
      }
      if (localVideoData.G == VideoData.a)
      {
        ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.app).reportPlay(localVideoData.c, null);
        ((INearbyMomentManager)this.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(localVideoData.c);
        return;
      }
      playShortVideo(paramInt, (VideoPlayerPagerAdapter.VideoViewHolder)localObject, localVideoData);
      if (NetworkUtil.b(getContext()) != 1)
      {
        int i = this.mCurrentMediaType;
        if ((i != 4) && (i != VideoData.a) && (!localVideoData.L))
        {
          QQToast.makeText(getContext(), HardCodeUtil.a(2131911861), 1).show();
          this.mFirstPlayShow = false;
        }
      }
      showSlideGuide(paramInt);
    }
  }
  
  public void updateVideoLabelState()
  {
    if ((this.mAdapter.b != null) && (this.mAdapter.d != null)) {
      return;
    }
    QLog.e("VideoPlayController", 1, "updateVideoLabelState mAdapter.mVideoViewHolderList == null || mAdapter.mVideoDataList == null !!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.impl.StoryPlayControllerImpl
 * JD-Core Version:    0.7.0.1
 */