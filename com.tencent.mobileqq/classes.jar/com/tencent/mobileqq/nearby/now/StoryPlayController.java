package com.tencent.mobileqq.nearby.now;

import ajjy;
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
import ascz;
import askc;
import askf;
import aski;
import askj;
import askl;
import askm;
import askn;
import asko;
import askq;
import askz;
import asla;
import asld;
import asle;
import asln;
import aslv;
import asmq;
import asmr;
import asms;
import asmt;
import asmu;
import asna;
import asod;
import asoh;
import asor;
import asos;
import asre;
import aszm;
import axoa;
import azue;
import bbmy;
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
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mjg;
import mpq;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayController
  implements ViewPager.OnPageChangeListener, asod
{
  public int a;
  public Context a;
  public Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler = new aski(this);
  public askc a;
  public askz a;
  asla jdField_a_of_type_Asla = new askj(this);
  public asna a;
  private asre jdField_a_of_type_Asre;
  public QQAppInterface a;
  public QQStoryVideoPlayerErrorView a;
  public StuffContainerView a;
  public VideoPlayerPagerAdapter a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryPlayController.9(this);
  private String jdField_a_of_type_JavaLangString = "";
  public HashMap<Integer, asos> a;
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
  
  public StoryPlayController(Context paramContext, StuffContainerView paramStuffContainerView, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, QQAppInterface paramQQAppInterface, askc paramaskc)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = paramStuffContainerView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asna = new asna(paramContext, paramaskc, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = paramQQStoryVideoPlayerErrorView;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramContext = a("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.jdField_d_of_type_Boolean = asmt.a("short_video_player_guide_shown", false);
    this.jdField_a_of_type_Askc = paramaskc;
  }
  
  private void a(int paramInt, asoh paramasoh, VideoData paramVideoData)
  {
    
    if ((mpq.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!paramVideoData.jdField_d_of_type_Boolean))
    {
      bbmy.a(a(), ajjy.a(2131648750), 1).a();
      this.j = true;
    }
    if (this.jdField_a_of_type_Askc != null) {
      this.jdField_a_of_type_Askc.a();
    }
    if ((paramasoh != null) && (paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
      this.jdField_a_of_type_Asna.a((asor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramasoh.jdField_a_of_type_Int)));
      this.jdField_a_of_type_Asna.a(paramasoh.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, new askn(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Askf.a(paramInt, 0);
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
  
  private void b(int paramInt, asoh paramasoh, VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Askf.a(true);
    paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new asko(this, paramasoh, paramVideoData));
    if (paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt) instanceof ShortVideoCommentsView))
      {
        ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
        asmu.a(paramasoh, ((asld)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int, ((asld)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, paramVideoData, localShortVideoCommentsView);
      }
      paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(paramVideoData);
      e();
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {}
    asoh localasoh;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.e);
        localasoh = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
      } while ((localasoh == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() <= 1) || (this.jdField_d_of_type_Boolean));
      if ((localasoh != null) && (localasoh.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_a_of_type_Asna.a();
      }
    } while (this.jdField_a_of_type_Asre != null);
    this.jdField_a_of_type_Asre = new asre(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Asre.a(ajjy.a(2131648760));
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_Asre.setOnDismissListener(new askq(this, localasoh, localHashMap));
    this.jdField_a_of_type_Asre.show();
    this.jdField_d_of_type_Boolean = true;
    asmt.a("short_video_player_guide_shown", true);
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
        asmr.b = "3";
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4) {
        asmr.b = "2";
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4);
    asmr.b = "1";
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    asoh localasoh = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
    if (localasoh == null) {
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
      asms.a(localVideoData.jdField_a_of_type_JavaLangString, 2, "0", "0");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "startPlayVideo:videoItem=" + localVideoData + ",videoItem.anchorUin=" + localVideoData.jdField_a_of_type_Long + ",videoItem.anchorNickName=" + localVideoData.g);
      }
      if (localasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.jdField_a_of_type_Long;
        localasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    if (localasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      localasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b();
    }
    this.jdField_b_of_type_Int = localVideoData.j;
    if (localVideoData.j == 4)
    {
      b(paramInt, localasoh, localVideoData);
      new aslv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((aszm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    if (localVideoData.j == 6)
    {
      new aslv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((aszm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    a(paramInt, localasoh, localVideoData);
    if ((mpq.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!localVideoData.jdField_d_of_type_Boolean))
    {
      bbmy.a(a(), ajjy.a(2131648757), 1).a();
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
      this.jdField_a_of_type_Askz = new asln();
      if ("1".equals(paramBundle.getString("isLocal"))) {
        this.jdField_a_of_type_Askz.a(true);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Askf.a(false);
      localObject = paramBundle.getString("processbar");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        n = Integer.parseInt((String)localObject);
        if (n == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Askf.a(false);
          label230:
          this.h = paramBundle.getBoolean("should_show_comment_view", false);
          this.jdField_a_of_type_Askz.a(paramBundle);
          this.jdField_a_of_type_Askz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          this.jdField_a_of_type_Askz.a(this.jdField_a_of_type_Asla);
          asms.a();
          this.jdField_a_of_type_Askz.a();
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
            localObject = new asld();
            ((asld)localObject).jdField_b_of_type_Int = paramBundle.k;
            ((asld)localObject).jdField_a_of_type_Int = paramBundle.l;
            ((asld)localObject).jdField_a_of_type_JavaLangString = paramBundle.jdField_c_of_type_JavaLangString;
            paramBundle.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          if (paramBundle.jdField_a_of_type_Int == 4) {
            this.jdField_a_of_type_Askz.a(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_Askz.a().add(paramBundle);
            this.jdField_a_of_type_Askz.a(this.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Asla.a(1, 0);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(0, false);
            return;
            label629:
            this.g = true;
            this.jdField_a_of_type_Askz = new asle();
            break;
            if (n != 2) {
              break label230;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Askf.a(true);
            break label230;
            localException = localException;
            QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
            break label230;
            this.jdField_a_of_type_Askz.b();
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
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, asoh paramasoh) {}
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView, String paramString, asos paramasos)
  {
    asmq.a().a(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), mjg.a(this.jdField_a_of_type_AndroidContentContext) / 2, mjg.b(this.jdField_a_of_type_AndroidContentContext) / 2, new askl(this, paramImageView, paramasos), false);
  }
  
  public void a(asoh paramasoh, VideoData paramVideoData, boolean paramBoolean, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    a(paramasoh, paramVideoData, paramBoolean, paramShortVideoCommentsView, true);
  }
  
  public void a(asoh paramasoh, VideoData paramVideoData, boolean paramBoolean1, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData() called with: holder = [" + paramasoh + "], videoData = [" + paramVideoData + "], willToPlay = [" + paramBoolean1 + "], commentsView = [" + paramShortVideoCommentsView + "]");
    }
    paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
    paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    if ((paramVideoData.jdField_c_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramVideoData.jdField_c_of_type_JavaLangString))) {
      paramasoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    for (;;)
    {
      paramShortVideoCommentsView = new asos(paramasoh, this, paramShortVideoCommentsView, asmu.a(paramasoh, paramVideoData.l, paramVideoData.k));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramasoh.jdField_a_of_type_Int), paramShortVideoCommentsView);
      if (paramVideoData.jdField_a_of_type_Int == 4)
      {
        paramasoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
        if (paramasoh.jdField_a_of_type_AndroidViewView != null) {
          paramasoh.jdField_a_of_type_AndroidViewView.findViewById(2131311581).setVisibility(4);
        }
      }
      a(paramBoolean1, paramasoh.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, paramShortVideoCommentsView, paramBoolean2);
      return;
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(azue.t);
      paramasoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, asos paramasos, boolean paramBoolean2)
  {
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131302919);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131299747);
    localImageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView1.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "prepare() called with: willToPlay = [" + paramBoolean1 + "], rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "], videoInfoListener = [" + paramasos + "], loadCover = [" + paramBoolean2 + "]");
    }
    if ((paramBoolean2) && (paramVideoData.jdField_c_of_type_JavaLangString != null))
    {
      if (paramVideoData.jdField_d_of_type_Boolean) {
        break label196;
      }
      a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramasos);
    }
    for (;;)
    {
      asmq.a().a(localImageView2, paramVideoData.jdField_d_of_type_JavaLangString, new ColorDrawable(0), new ColorDrawable(0), new askm(this, paramasos));
      return;
      label196:
      paramRelativeLayout = axoa.a(paramVideoData.jdField_c_of_type_JavaLangString);
      if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoPlayController", 2, "load cover,localFile exists,filepath = " + paramRelativeLayout.getAbsolutePath());
          }
          localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
          paramasos.a(paramVideoData.l, paramVideoData.k, true);
        }
        catch (OutOfMemoryError paramRelativeLayout)
        {
          QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
          a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramasos);
        }
      } else {
        a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramasos);
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
    this.jdField_a_of_type_Asna.b();
    if ((mpq.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Asna.a != null) && (!this.jdField_a_of_type_Asna.a.jdField_d_of_type_Boolean)) {
      bbmy.a(a(), ajjy.a(2131648761), 1).a();
    }
    this.i = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Asna.a();
  }
  
  public void d()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_Asna.a != null)
    {
      l1 = this.jdField_a_of_type_Asna.b();
      l2 = this.jdField_a_of_type_Asna.c();
      if (l1 == 0L) {
        break label100;
      }
    }
    label100:
    for (double d1 = l2 / l1;; d1 = 0.0D)
    {
      asms.a(this.jdField_a_of_type_Asna.a.jdField_a_of_type_JavaLangString, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(asms.b()), this.jdField_a_of_type_Asna.a());
      this.jdField_a_of_type_Asna.c();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a();
      this.e = true;
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Askc != null) {
      this.jdField_a_of_type_Askc.b();
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
    asos localasos = (asos)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localasos != null) {
      localasos.e();
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
        this.jdField_a_of_type_Asna.b();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "startPlayVideo state = [" + paramInt + "]");
        }
        asms.a(1);
        a(this.jdField_a_of_type_Int);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        this.jdField_a_of_type_Asna.a();
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
      this.jdField_a_of_type_Askz.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Askz.a();
    }
    if (paramInt < 2)
    {
      this.jdField_a_of_type_Askz.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Askz.b();
    }
    if (paramInt < this.jdField_a_of_type_Int) {
      new asmr().h("video").i("playpage_left_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    localVideoData.jdField_c_of_type_Boolean = false;
    if (paramInt > this.jdField_a_of_type_Int)
    {
      new asmr().h("video").i("playpage_right_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ThreadManagerV2.excute(new StoryPlayController.7(this, localVideoData, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController
 * JD-Core Version:    0.7.0.1
 */