package com.tencent.mobileqq.nearby.now;

import afak;
import afal;
import afan;
import afao;
import afap;
import afaq;
import afas;
import afat;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.av.utils.UITools;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel.OnDataComeListener;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.InfinitePlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.PlayListDataModel;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.utils.StorageCenter;
import com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView.GestureListener;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.StoryNewGuideDialog;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
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

public class StoryPlayController
  implements ViewPager.OnPageChangeListener, StuffContainerView.GestureListener
{
  public int a;
  public Context a;
  public Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler = new afak(this);
  public QQAppInterface a;
  public ActCallBack a;
  BasePlayListDataModel.OnDataComeListener jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel$OnDataComeListener = new afal(this);
  public BasePlayListDataModel a;
  public MagazinePlayerView a;
  public QQStoryVideoPlayerErrorView a;
  public StuffContainerView a;
  public VideoPlayerPagerAdapter a;
  private StoryNewGuideDialog jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new afat(this);
  private String jdField_a_of_type_JavaLangString = "";
  public HashMap a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private boolean k = true;
  
  public StoryPlayController(Context paramContext, StuffContainerView paramStuffContainerView, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, QQAppInterface paramQQAppInterface, ActCallBack paramActCallBack)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = paramStuffContainerView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView = new MagazinePlayerView(paramContext, paramActCallBack, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = paramQQStoryVideoPlayerErrorView;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramContext = a("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.jdField_d_of_type_Boolean = StorageCenter.a("short_video_player_guide_shown", false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack = paramActCallBack;
  }
  
  private void a(int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    
    if ((NetworkUtil.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (!paramVideoData.jdField_d_of_type_Boolean))
    {
      QQToast.a(a(), "你正在非wifi环境下观看，将消耗流量", 1).a();
      this.j = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack.a();
    }
    if ((paramVideoViewHolder != null) && (paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a((VideoPlayerView.VideoInfoListener)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_Int)));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, new afap(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(paramInt, 0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "playShortVideovideoDataIndex is: " + paramInt + " percent is: " + 0);
    }
  }
  
  private void b(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
    }
  }
  
  private void b(int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(true);
    paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new afaq(this, paramVideoViewHolder, paramVideoData));
    if (paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt) instanceof ShortVideoCommentsView))
      {
        ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
        StoryRelayoutUtil.a(paramVideoViewHolder, ((ImageData)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int, ((ImageData)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, paramVideoData, localShortVideoCommentsView);
      }
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(paramVideoData);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {}
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.e);
        localVideoViewHolder = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
      } while ((localVideoViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() <= 1) || (this.jdField_d_of_type_Boolean));
      if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog != null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog = new StoryNewGuideDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog.a("左右滑动可切换");
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog.setOnDismissListener(new afas(this, localVideoViewHolder, localHashMap));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStoryNewGuideDialog.show();
    this.jdField_d_of_type_Boolean = true;
    StorageCenter.a("short_video_player_guide_shown", true);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a(String paramString)
  {
    Object localObject = "";
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return localObject;
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        return "";
      }
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("raw_url");
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
        for (;;)
        {
          QLog.w("VideoPlayController", 1, localException + "getValue no value in url key=" + paramString);
          paramString = "";
        }
      }
      localObject = paramString;
    } while (!TextUtils.isEmpty(paramString));
    return "";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList == null)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() <= 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() > 1))
      {
        NowVideoReporter.b = "3";
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).jdField_g_of_type_Int == 4) {
        NowVideoReporter.b = "2";
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).jdField_g_of_type_Int == 4);
    NowVideoReporter.b = "1";
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
    if (localVideoViewHolder == null) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoPlayController", 2, "startPlayVideo: videoViewHolder == null videoDataIndex=" + paramInt + "  mAdapter.realIndex" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Int);
      }
    }
    VideoData localVideoData;
    do
    {
      do
      {
        return;
        localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
      } while (localVideoData == null);
      QualityReporter.a(localVideoData.jdField_a_of_type_JavaLangString, 2, "0", "0");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "startPlayVideo:videoItem=" + localVideoData + ",videoItem.anchorUin=" + localVideoData.jdField_a_of_type_Long + ",videoItem.anchorNickName=" + localVideoData.jdField_g_of_type_JavaLangString);
      }
      if (localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.jdField_a_of_type_Long;
        localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    if (localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      localVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b();
    }
    this.jdField_b_of_type_Int = localVideoData.jdField_g_of_type_Int;
    if (localVideoData.jdField_g_of_type_Int != 4)
    {
      a(paramInt, localVideoViewHolder, localVideoData);
      if ((NetworkUtil.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (!localVideoData.jdField_d_of_type_Boolean))
      {
        QQToast.a(a(), "你正在非wifi环境下观看，将消耗流量", 1).a();
        this.k = false;
      }
      b(paramInt);
      return;
    }
    b(paramInt, localVideoViewHolder, localVideoData);
    new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
    ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).g(localVideoData.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    int m = 2;
    if (paramBundle.getBoolean("play_list", true))
    {
      if (!"2".equals(paramBundle.getString("play_mode", "1"))) {
        break label629;
      }
      this.g = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel = new PlayListDataModel();
      if ("1".equals(paramBundle.getString("isLocal"))) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(true);
      }
    }
    for (;;)
    {
      Object localObject = paramBundle.getString("raw_url");
      QLog.i("VideoPlayController", 1, "rawUrl = " + (String)localObject);
      this.jdField_a_of_type_JavaLangString = a("feeds_id");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = a("feed_id");
        QLog.i("VideoPlayController", 1, " feeds_id is null,feed_id ==" + this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(false);
      localObject = paramBundle.getString("processbar");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        n = Integer.parseInt((String)localObject);
        if (n == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(false);
          label230:
          this.h = paramBundle.getBoolean("should_show_comment_view", false);
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel$OnDataComeListener);
          QualityReporter.a();
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a();
          paramBundle = new VideoData();
          localObject = a("preLoadParams");
          bool = a("feed_type").equals("4");
          QLog.i("VideoPlayController", 1, "preLoadJson~ in init = " + (String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localObject = URLDecoder.decode((String)localObject);
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          int n;
          boolean bool;
          this.jdField_a_of_type_Boolean = true;
          localObject = new JSONObject((String)localObject);
          paramBundle.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("id");
          paramBundle.f = ((JSONObject)localObject).optString("headerUrl");
          paramBundle.b = ((JSONObject)localObject).optString("videoUrl");
          paramBundle.h = ((JSONObject)localObject).optInt("videoHeight");
          paramBundle.i = ((JSONObject)localObject).optInt("videoWidth");
          paramBundle.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("coverUrl");
          paramBundle.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("doodleUrl");
          paramBundle.jdField_d_of_type_Long = ((JSONObject)localObject).optLong("video_timelong");
          if (((JSONObject)localObject).optLong("is_local") == 1L) {
            m = 4;
          }
          paramBundle.jdField_a_of_type_Int = m;
          paramBundle.jdField_d_of_type_Boolean = true;
          paramBundle.jdField_g_of_type_Int = 3;
          if (bool)
          {
            paramBundle.jdField_g_of_type_Int = 4;
            paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject = new ImageData();
            ((ImageData)localObject).jdField_b_of_type_Int = paramBundle.h;
            ((ImageData)localObject).jdField_a_of_type_Int = paramBundle.i;
            ((ImageData)localObject).jdField_a_of_type_JavaLangString = paramBundle.jdField_c_of_type_JavaLangString;
            paramBundle.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          if (paramBundle.jdField_a_of_type_Int == 4) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a().add(paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(this.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel$OnDataComeListener.a(1, 0);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(0, false);
            return;
            label629:
            this.g = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel = new InfinitePlayListDataModel();
            break;
            if (n != 2) {
              break label230;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler.a(true);
            break label230;
            localException = localException;
            QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
            break label230;
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.b();
          }
          return;
        }
        catch (JSONException paramBundle)
        {
          QLog.i("VideoPlayController", 1, "no preload params~ in init");
        }
      }
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder) {}
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView, String paramString, VideoInfoListenerImpl paramVideoInfoListenerImpl)
  {
    ImageLoader.a().a(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), UITools.a(this.jdField_a_of_type_AndroidContentContext) / 2, UITools.b(this.jdField_a_of_type_AndroidContentContext) / 2, new afan(this, paramVideoInfoListenerImpl), false);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData, boolean paramBoolean, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    a(paramVideoViewHolder, paramVideoData, paramBoolean, paramShortVideoCommentsView, true);
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData, boolean paramBoolean1, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData() called with: holder = [" + paramVideoViewHolder + "], videoData = [" + paramVideoData + "], willToPlay = [" + paramBoolean1 + "], commentsView = [" + paramShortVideoCommentsView + "]");
    }
    paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
    paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    paramShortVideoCommentsView = new VideoInfoListenerImpl(paramVideoViewHolder, this, paramShortVideoCommentsView, StoryRelayoutUtil.a(paramVideoViewHolder, paramVideoData.i, paramVideoData.h));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramVideoViewHolder.jdField_a_of_type_Int), paramShortVideoCommentsView);
    if (paramVideoData.jdField_a_of_type_Int == 4)
    {
      paramVideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
      if (paramVideoViewHolder.jdField_a_of_type_AndroidViewView != null) {
        paramVideoViewHolder.jdField_a_of_type_AndroidViewView.findViewById(2131370609).setVisibility(4);
      }
    }
    a(paramBoolean1, paramVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, paramShortVideoCommentsView, paramBoolean2);
  }
  
  public void a(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, VideoInfoListenerImpl paramVideoInfoListenerImpl, boolean paramBoolean2)
  {
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131366383);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131370633);
    localImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView1.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "prepare() called with: willToPlay = [" + paramBoolean1 + "], rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "], videoInfoListener = [" + paramVideoInfoListenerImpl + "], loadCover = [" + paramBoolean2 + "]");
    }
    if ((paramBoolean2) && (paramVideoData.jdField_c_of_type_JavaLangString != null))
    {
      if (paramVideoData.jdField_d_of_type_Boolean) {
        break label196;
      }
      a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramVideoInfoListenerImpl);
    }
    for (;;)
    {
      ImageLoader.a().a(localImageView2, paramVideoData.jdField_d_of_type_JavaLangString, new ColorDrawable(0), new ColorDrawable(0), new afao(this, paramVideoInfoListenerImpl));
      return;
      label196:
      paramRelativeLayout = AbsDownloader.a(paramVideoData.jdField_c_of_type_JavaLangString);
      if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoPlayController", 2, "load cover,localFile exists,filepath = " + paramRelativeLayout.getAbsolutePath());
          }
          localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
          paramVideoInfoListenerImpl.a(paramVideoData.i, paramVideoData.h, true);
        }
        catch (OutOfMemoryError paramRelativeLayout)
        {
          QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
          a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramVideoInfoListenerImpl);
        }
      } else {
        a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramVideoInfoListenerImpl);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.d();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.b();
    if ((NetworkUtil.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a.jdField_d_of_type_Boolean)) {
      QQToast.a(a(), "你正在非wifi环境下观看，将消耗流量", 1).a();
    }
    this.i = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a();
  }
  
  public void d()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a != null)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.b();
      l2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.c();
      if (l1 == 0L) {
        break label100;
      }
    }
    label100:
    for (double d1 = l2 / l1;; d1 = 0.0D)
    {
      QualityReporter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a.jdField_a_of_type_JavaLangString, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(QualityReporter.b()), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a());
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.c();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a();
      this.e = true;
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack.b();
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList == null)) {
      QLog.e("VideoPlayController", 1, "updateVideoLabelState mAdapter.mVideoViewHolderList == null || mAdapter.mVideoDataList == null !!!!");
    }
  }
  
  public void l()
  {
    VideoInfoListenerImpl localVideoInfoListenerImpl = (VideoInfoListenerImpl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localVideoInfoListenerImpl != null) {
      localVideoInfoListenerImpl.e();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() == 1) {}
    while (paramInt == this.jdField_d_of_type_Int) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "onPageScrollStateChanged SCROLL_STATE_IDLE currentIndex is: " + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if (((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "videoItem.isReady state = [" + paramInt + "]");
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.b();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "startPlayVideo state = [" + paramInt + "]");
        }
        QualityReporter.a(1);
        a(this.jdField_a_of_type_Int);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewMagazinePlayerView.a();
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Int + (paramInt - 50);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onPageSelected index is: " + paramInt + " mCurrentIndex=" + this.jdField_a_of_type_Int);
    }
    if (paramInt < 0) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a();
    }
    if (paramInt < 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel.b();
    }
    if (paramInt > this.jdField_a_of_type_Int) {
      new NowVideoReporter().h("video").i("playpage_right_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramInt < this.jdField_a_of_type_Int) {
      new NowVideoReporter().h("video").i("playpage_left_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController
 * JD-Core Version:    0.7.0.1
 */