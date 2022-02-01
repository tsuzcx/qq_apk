package com.tencent.mobileqq.nearby.now;

import amtj;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import awhw;
import awpb;
import awpe;
import awph;
import awpi;
import awpk;
import awpl;
import awpm;
import awpn;
import awpp;
import awpy;
import awpz;
import awqc;
import awqd;
import awqm;
import awqu;
import awrr;
import awrs;
import awrt;
import awru;
import awrv;
import awsb;
import awte;
import awti;
import awts;
import awtt;
import awwf;
import axen;
import bfol;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import mum;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayController
  implements ViewPager.OnPageChangeListener, awte
{
  public int a;
  public Context a;
  public Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler = new awph(this);
  public awpb a;
  public awpy a;
  awpz jdField_a_of_type_Awpz = new awpi(this);
  public awsb a;
  private awwf jdField_a_of_type_Awwf;
  public QQAppInterface a;
  public QQStoryVideoPlayerErrorView a;
  public StuffContainerView a;
  public VideoPlayerPagerAdapter a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryPlayController.9(this);
  private String jdField_a_of_type_JavaLangString = "";
  public HashMap<Integer, awtt> a;
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
  
  public StoryPlayController(Context paramContext, StuffContainerView paramStuffContainerView, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, QQAppInterface paramQQAppInterface, awpb paramawpb)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = paramStuffContainerView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Awsb = new awsb(paramContext, paramawpb, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = paramQQStoryVideoPlayerErrorView;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramContext = a("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.jdField_d_of_type_Boolean = awru.a("short_video_player_guide_shown", false);
    this.jdField_a_of_type_Awpb = paramawpb;
  }
  
  private void a(int paramInt, awti paramawti, VideoData paramVideoData)
  {
    
    if ((NetworkUtil.getNetworkType(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!paramVideoData.jdField_d_of_type_Boolean))
    {
      QQToast.a(a(), amtj.a(2131713576), 1).a();
      this.j = true;
    }
    if (this.jdField_a_of_type_Awpb != null) {
      this.jdField_a_of_type_Awpb.a();
    }
    if ((paramawti != null) && (paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
      this.jdField_a_of_type_Awsb.a((awts)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramawti.jdField_a_of_type_Int)));
      this.jdField_a_of_type_Awsb.a(paramawti.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, new awpm(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Awpe.a(paramInt, 0);
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
  
  private void b(int paramInt, awti paramawti, VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Awpe.a(true);
    paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new awpn(this, paramawti, paramVideoData));
    if (paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt) instanceof ShortVideoCommentsView))
      {
        ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
        awrv.a(paramawti, ((awqc)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int, ((awqc)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, paramVideoData, localShortVideoCommentsView);
      }
      paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(paramVideoData);
      e();
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {}
    awti localawti;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.e);
        localawti = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
      } while ((localawti == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() <= 1) || (this.jdField_d_of_type_Boolean));
      if ((localawti != null) && (localawti.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_a_of_type_Awsb.a();
      }
    } while (this.jdField_a_of_type_Awwf != null);
    this.jdField_a_of_type_Awwf = new awwf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Awwf.a(amtj.a(2131713586));
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_Awwf.setOnDismissListener(new awpp(this, localawti, localHashMap));
    this.jdField_a_of_type_Awwf.show();
    this.jdField_d_of_type_Boolean = true;
    awru.a("short_video_player_guide_shown", true);
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
        awrs.b = "3";
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4) {
        awrs.b = "2";
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4);
    awrs.b = "1";
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    awti localawti = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
    if (localawti == null) {
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
      awrt.a(localVideoData.jdField_a_of_type_JavaLangString, 2, "0", "0");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "startPlayVideo:videoItem=" + localVideoData + ",videoItem.anchorUin=" + localVideoData.jdField_a_of_type_Long + ",videoItem.anchorNickName=" + localVideoData.g);
      }
      if (localawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.jdField_a_of_type_Long;
        localawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    if (localawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      localawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b();
    }
    this.jdField_b_of_type_Int = localVideoData.j;
    if (localVideoData.j == 4)
    {
      b(paramInt, localawti, localVideoData);
      new awqu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((axen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    if (localVideoData.j == 6)
    {
      new awqu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((axen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    a(paramInt, localawti, localVideoData);
    if ((NetworkUtil.getNetworkType(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!localVideoData.jdField_d_of_type_Boolean))
    {
      QQToast.a(a(), amtj.a(2131713583), 1).a();
      this.k = false;
    }
    b(paramInt);
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
      this.jdField_a_of_type_Awpy = new awqm();
      if ("1".equals(paramBundle.getString("isLocal"))) {
        this.jdField_a_of_type_Awpy.a(true);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Awpe.a(false);
      localObject = paramBundle.getString("processbar");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        n = Integer.parseInt((String)localObject);
        if (n == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Awpe.a(false);
          label230:
          this.h = paramBundle.getBoolean("should_show_comment_view", false);
          this.jdField_a_of_type_Awpy.a(paramBundle);
          this.jdField_a_of_type_Awpy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          this.jdField_a_of_type_Awpy.a(this.jdField_a_of_type_Awpz);
          awrt.a();
          this.jdField_a_of_type_Awpy.a();
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
          paramBundle.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("headerUrl");
          paramBundle.b = ((JSONObject)localObject).optString("videoUrl");
          paramBundle.k = ((JSONObject)localObject).optInt("videoHeight");
          paramBundle.l = ((JSONObject)localObject).optInt("videoWidth");
          paramBundle.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("coverUrl");
          paramBundle.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("doodleUrl");
          paramBundle.jdField_f_of_type_Long = ((JSONObject)localObject).optLong("video_timelong");
          if (((JSONObject)localObject).optLong("is_local") == 1L) {
            m = 4;
          }
          paramBundle.jdField_a_of_type_Int = m;
          paramBundle.jdField_d_of_type_Boolean = true;
          paramBundle.j = 3;
          if (bool)
          {
            paramBundle.j = 4;
            paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            localObject = new awqc();
            ((awqc)localObject).jdField_b_of_type_Int = paramBundle.k;
            ((awqc)localObject).jdField_a_of_type_Int = paramBundle.l;
            ((awqc)localObject).jdField_a_of_type_JavaLangString = paramBundle.jdField_c_of_type_JavaLangString;
            paramBundle.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          if (paramBundle.jdField_a_of_type_Int == 4) {
            this.jdField_a_of_type_Awpy.a(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_Awpy.a().add(paramBundle);
            this.jdField_a_of_type_Awpy.a(this.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Awpz.a(1, 0);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(0, false);
            return;
            label629:
            this.g = true;
            this.jdField_a_of_type_Awpy = new awqd();
            break;
            if (n != 2) {
              break label230;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Awpe.a(true);
            break label230;
            localException = localException;
            QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
            break label230;
            this.jdField_a_of_type_Awpy.b();
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
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, awti paramawti) {}
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView, String paramString, awtt paramawtt)
  {
    awrr.a().a(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), mum.a(this.jdField_a_of_type_AndroidContentContext) / 2, mum.b(this.jdField_a_of_type_AndroidContentContext) / 2, new awpk(this, paramImageView, paramawtt), false);
  }
  
  public void a(awti paramawti, VideoData paramVideoData, boolean paramBoolean, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    a(paramawti, paramVideoData, paramBoolean, paramShortVideoCommentsView, true);
  }
  
  public void a(awti paramawti, VideoData paramVideoData, boolean paramBoolean1, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData() called with: holder = [" + paramawti + "], videoData = [" + paramVideoData + "], willToPlay = [" + paramBoolean1 + "], commentsView = [" + paramShortVideoCommentsView + "]");
    }
    paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
    paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    if ((paramVideoData.jdField_c_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramVideoData.jdField_c_of_type_JavaLangString))) {
      paramawti.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    for (;;)
    {
      paramShortVideoCommentsView = new awtt(paramawti, this, paramShortVideoCommentsView, awrv.a(paramawti, paramVideoData.l, paramVideoData.k));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramawti.jdField_a_of_type_Int), paramShortVideoCommentsView);
      if (paramVideoData.jdField_a_of_type_Int == 4)
      {
        paramawti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
        if (paramawti.jdField_a_of_type_AndroidViewView != null) {
          paramawti.jdField_a_of_type_AndroidViewView.findViewById(2131378757).setVisibility(4);
        }
      }
      a(paramBoolean1, paramawti.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, paramShortVideoCommentsView, paramBoolean2);
      return;
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bfol.u);
      paramawti.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, awtt paramawtt, boolean paramBoolean2)
  {
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131369207);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131365712);
    localImageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView1.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "prepare() called with: willToPlay = [" + paramBoolean1 + "], rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "], videoInfoListener = [" + paramawtt + "], loadCover = [" + paramBoolean2 + "]");
    }
    if ((paramBoolean2) && (paramVideoData.jdField_c_of_type_JavaLangString != null))
    {
      if (paramVideoData.jdField_d_of_type_Boolean) {
        break label196;
      }
      a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramawtt);
    }
    for (;;)
    {
      awrr.a().a(localImageView2, paramVideoData.jdField_d_of_type_JavaLangString, new ColorDrawable(0), new ColorDrawable(0), new awpl(this, paramawtt));
      return;
      label196:
      paramRelativeLayout = AbsDownloader.getFile(paramVideoData.jdField_c_of_type_JavaLangString);
      if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoPlayController", 2, "load cover,localFile exists,filepath = " + paramRelativeLayout.getAbsolutePath());
          }
          localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
          paramawtt.a(paramVideoData.l, paramVideoData.k, true);
        }
        catch (OutOfMemoryError paramRelativeLayout)
        {
          QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
          a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramawtt);
        }
      } else {
        a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramawtt);
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
    this.jdField_a_of_type_Awsb.b();
    if ((NetworkUtil.getNetworkType(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Awsb.a != null) && (!this.jdField_a_of_type_Awsb.a.jdField_d_of_type_Boolean)) {
      QQToast.a(a(), amtj.a(2131713587), 1).a();
    }
    this.i = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Awsb.a();
  }
  
  public void d()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_Awsb.a != null)
    {
      l1 = this.jdField_a_of_type_Awsb.b();
      l2 = this.jdField_a_of_type_Awsb.c();
      if (l1 == 0L) {
        break label100;
      }
    }
    label100:
    for (double d1 = l2 / l1;; d1 = 0.0D)
    {
      awrt.a(this.jdField_a_of_type_Awsb.a.jdField_a_of_type_JavaLangString, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(awrt.b()), this.jdField_a_of_type_Awsb.a());
      this.jdField_a_of_type_Awsb.c();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a();
      this.e = true;
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Awpb != null) {
      this.jdField_a_of_type_Awpb.b();
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
    awtt localawtt = (awtt)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localawtt != null) {
      localawtt.e();
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
        this.jdField_a_of_type_Awsb.b();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "startPlayVideo state = [" + paramInt + "]");
        }
        awrt.a(1);
        a(this.jdField_a_of_type_Int);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        this.jdField_a_of_type_Awsb.a();
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    paramInt = paramInt - 50 + this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onPageSelected index is: " + paramInt + " mCurrentIndex=" + this.jdField_a_of_type_Int);
    }
    if (paramInt < 0) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      this.jdField_a_of_type_Awpy.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Awpy.a();
    }
    if (paramInt < 2)
    {
      this.jdField_a_of_type_Awpy.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Awpy.b();
    }
    if (paramInt < this.jdField_a_of_type_Int) {
      new awrs().h("video").i("playpage_left_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    localVideoData.jdField_c_of_type_Boolean = false;
    if (paramInt > this.jdField_a_of_type_Int)
    {
      new awrs().h("video").i("playpage_right_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ThreadManagerV2.excute(new StoryPlayController.7(this, localVideoData, (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController
 * JD-Core Version:    0.7.0.1
 */