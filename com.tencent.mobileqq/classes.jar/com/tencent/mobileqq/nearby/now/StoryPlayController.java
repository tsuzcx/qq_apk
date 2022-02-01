package com.tencent.mobileqq.nearby.now;

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
import anzj;
import axup;
import aybt;
import aybw;
import aybz;
import ayca;
import aycc;
import aycd;
import ayce;
import aycf;
import aych;
import aycq;
import aycr;
import aycu;
import aycv;
import ayde;
import aydm;
import ayej;
import ayek;
import ayel;
import ayem;
import ayen;
import ayet;
import ayfw;
import ayga;
import aygk;
import aygl;
import ayix;
import ayrf;
import beqz;
import bhez;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import mvd;
import nny;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayController
  implements ViewPager.OnPageChangeListener, ayfw
{
  public int a;
  public Context a;
  public Bundle a;
  Handler jdField_a_of_type_AndroidOsHandler = new aybz(this);
  public aybt a;
  public aycq a;
  aycr jdField_a_of_type_Aycr = new ayca(this);
  public ayet a;
  private ayix jdField_a_of_type_Ayix;
  public QQAppInterface a;
  public QQStoryVideoPlayerErrorView a;
  public StuffContainerView a;
  public VideoPlayerPagerAdapter a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryPlayController.9(this);
  private String jdField_a_of_type_JavaLangString = "";
  public HashMap<Integer, aygl> a;
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
  
  public StoryPlayController(Context paramContext, StuffContainerView paramStuffContainerView, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, Bundle paramBundle, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, QQAppInterface paramQQAppInterface, aybt paramaybt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView = paramStuffContainerView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = paramVideoPlayerPagerAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ayet = new ayet(paramContext, paramaybt, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = paramQQStoryVideoPlayerErrorView;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramContext = a("repeat");
    if ((paramContext != null) && (paramContext.equals("1"))) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("is_multi_progress_bar", false);
    this.jdField_d_of_type_Boolean = ayem.a("short_video_player_guide_shown", false);
    this.jdField_a_of_type_Aybt = paramaybt;
  }
  
  private void a(int paramInt, ayga paramayga, VideoData paramVideoData)
  {
    
    if ((nny.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!paramVideoData.jdField_d_of_type_Boolean))
    {
      QQToast.a(a(), anzj.a(2131713344), 1).a();
      this.j = true;
    }
    if (this.jdField_a_of_type_Aybt != null) {
      this.jdField_a_of_type_Aybt.a();
    }
    if ((paramayga != null) && (paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null))
    {
      paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
      this.jdField_a_of_type_Ayet.a((aygk)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramayga.jdField_a_of_type_Int)));
      this.jdField_a_of_type_Ayet.a(paramayga.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, new ayce(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Aybw.a(paramInt, 0);
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
  
  private void b(int paramInt, ayga paramayga, VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Aybw.a(true);
    paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setRelayoutListener(new aycf(this, paramayga, paramVideoData));
    if (paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt) instanceof ShortVideoCommentsView))
      {
        ShortVideoCommentsView localShortVideoCommentsView = (ShortVideoCommentsView)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
        ayen.a(paramayga, ((aycu)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int, ((aycu)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, paramVideoData, localShortVideoCommentsView);
      }
      paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(paramVideoData);
      e();
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {}
    ayga localayga;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.e);
        localayga = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
      } while ((localayga == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() <= 1) || (this.jdField_d_of_type_Boolean));
      if ((localayga != null) && (localayga.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        this.jdField_a_of_type_Ayet.a();
      }
    } while (this.jdField_a_of_type_Ayix != null);
    this.jdField_a_of_type_Ayix = new ayix(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Ayix.a(anzj.a(2131713354));
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_Ayix.setOnDismissListener(new aych(this, localayga, localHashMap));
    this.jdField_a_of_type_Ayix.show();
    this.jdField_d_of_type_Boolean = true;
    ayem.a("short_video_player_guide_shown", true);
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
        ayek.b = "3";
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4) {
        ayek.b = "2";
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(0).j == 4);
    ayek.b = "1";
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    ayga localayga = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramInt);
    if (localayga == null) {
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
      ayel.a(localVideoData.jdField_a_of_type_JavaLangString, 2, "0", "0");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayController", 2, "startPlayVideo:videoItem=" + localVideoData + ",videoItem.anchorUin=" + localVideoData.jdField_a_of_type_Long + ",videoItem.anchorNickName=" + localVideoData.g);
      }
      if (localayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null)
      {
        long l = localVideoData.jdField_a_of_type_Long;
        localayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setCurrentAnchorUin(l);
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    if (localayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      localayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.b();
    }
    this.jdField_b_of_type_Int = localVideoData.j;
    if (localVideoData.j == 4)
    {
      b(paramInt, localayga, localVideoData);
      new aydm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    if (localVideoData.j == 6)
    {
      new aydm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localVideoData.jdField_a_of_type_JavaLangString, null);
      ((ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).f(localVideoData.jdField_a_of_type_JavaLangString);
      return;
    }
    a(paramInt, localayga, localVideoData);
    if ((nny.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (!localVideoData.jdField_d_of_type_Boolean))
    {
      QQToast.a(a(), anzj.a(2131713351), 1).a();
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
      this.jdField_a_of_type_Aycq = new ayde();
      if ("1".equals(paramBundle.getString("isLocal"))) {
        this.jdField_a_of_type_Aycq.a(true);
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
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Aybw.a(false);
      localObject = paramBundle.getString("processbar");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        n = Integer.parseInt((String)localObject);
        if (n == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Aybw.a(false);
          label230:
          this.h = paramBundle.getBoolean("should_show_comment_view", false);
          this.jdField_a_of_type_Aycq.a(paramBundle);
          this.jdField_a_of_type_Aycq.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          this.jdField_a_of_type_Aycq.a(this.jdField_a_of_type_Aycr);
          ayel.a();
          this.jdField_a_of_type_Aycq.a();
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
            localObject = new aycu();
            ((aycu)localObject).jdField_b_of_type_Int = paramBundle.k;
            ((aycu)localObject).jdField_a_of_type_Int = paramBundle.l;
            ((aycu)localObject).jdField_a_of_type_JavaLangString = paramBundle.jdField_c_of_type_JavaLangString;
            paramBundle.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
          if (paramBundle.jdField_a_of_type_Int == 4) {
            this.jdField_a_of_type_Aycq.a(true);
          }
          for (;;)
          {
            this.jdField_a_of_type_Aycq.a().add(paramBundle);
            this.jdField_a_of_type_Aycq.a(this.jdField_a_of_type_JavaLangString, paramBundle.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_Aycr.a(1, 0);
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.setCurrentItem(0, false);
            return;
            label629:
            this.g = true;
            this.jdField_a_of_type_Aycq = new aycv();
            break;
            if (n != 2) {
              break label230;
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.jdField_a_of_type_Aybw.a(true);
            break label230;
            localException = localException;
            QLog.w("VideoPlayController", 1, "bad url parameter in arguments 'progressbar'");
            break label230;
            this.jdField_a_of_type_Aycq.b();
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
  
  public void a(LayoutInflater paramLayoutInflater, VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, ayga paramayga) {}
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView, String paramString, aygl paramaygl)
  {
    ayej.a().a(paramImageView, paramString, new ColorDrawable(0), new ColorDrawable(0), mvd.a(this.jdField_a_of_type_AndroidContentContext) / 2, mvd.b(this.jdField_a_of_type_AndroidContentContext) / 2, new aycc(this, paramImageView, paramaygl), false);
  }
  
  public void a(ayga paramayga, VideoData paramVideoData, boolean paramBoolean, ShortVideoCommentsView paramShortVideoCommentsView)
  {
    a(paramayga, paramVideoData, paramBoolean, paramShortVideoCommentsView, true);
  }
  
  public void a(ayga paramayga, VideoData paramVideoData, boolean paramBoolean1, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "onFillData() called with: holder = [" + paramayga + "], videoData = [" + paramVideoData + "], willToPlay = [" + paramBoolean1 + "], commentsView = [" + paramShortVideoCommentsView + "]");
    }
    paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(paramVideoData);
    paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    if ((paramVideoData.jdField_c_of_type_JavaLangString == null) || (TextUtils.isEmpty(paramVideoData.jdField_c_of_type_JavaLangString))) {
      paramayga.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-16777216));
    }
    for (;;)
    {
      paramShortVideoCommentsView = new aygl(paramayga, this, paramShortVideoCommentsView, ayen.a(paramayga, paramVideoData.l, paramVideoData.k));
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramayga.jdField_a_of_type_Int), paramShortVideoCommentsView);
      if (paramVideoData.jdField_a_of_type_Int == 4)
      {
        paramayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.setVisibility(8);
        if (paramayga.jdField_a_of_type_AndroidViewView != null) {
          paramayga.jdField_a_of_type_AndroidViewView.findViewById(2131378988).setVisibility(4);
        }
      }
      a(paramBoolean1, paramayga.jdField_a_of_type_AndroidWidgetRelativeLayout, paramVideoData, paramShortVideoCommentsView, paramBoolean2);
      return;
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "now_blur";
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(paramVideoData.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bhez.u);
      paramayga.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, RelativeLayout paramRelativeLayout, VideoData paramVideoData, aygl paramaygl, boolean paramBoolean2)
  {
    ImageView localImageView1 = (ImageView)paramRelativeLayout.findViewById(2131369184);
    ImageView localImageView2 = (ImageView)paramRelativeLayout.findViewById(2131365679);
    localImageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localImageView1.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayController", 2, "prepare() called with: willToPlay = [" + paramBoolean1 + "], rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "], videoInfoListener = [" + paramaygl + "], loadCover = [" + paramBoolean2 + "]");
    }
    if ((paramBoolean2) && (paramVideoData.jdField_c_of_type_JavaLangString != null))
    {
      if (paramVideoData.jdField_d_of_type_Boolean) {
        break label196;
      }
      a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramaygl);
    }
    for (;;)
    {
      ayej.a().a(localImageView2, paramVideoData.jdField_d_of_type_JavaLangString, new ColorDrawable(0), new ColorDrawable(0), new aycd(this, paramaygl));
      return;
      label196:
      paramRelativeLayout = beqz.a(paramVideoData.jdField_c_of_type_JavaLangString);
      if ((paramRelativeLayout != null) && (paramRelativeLayout.exists())) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoPlayController", 2, "load cover,localFile exists,filepath = " + paramRelativeLayout.getAbsolutePath());
          }
          localImageView1.setImageDrawable(new ImageDrawable(BitmapReference.getBitmapReference(BitmapFactory.decodeFile(paramRelativeLayout.getAbsolutePath()))));
          paramaygl.a(paramVideoData.l, paramVideoData.k, true);
        }
        catch (OutOfMemoryError paramRelativeLayout)
        {
          QLog.e("VideoPlayController", 1, paramRelativeLayout, new Object[0]);
          a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramaygl);
        }
      } else {
        a(localImageView1, paramVideoData.jdField_c_of_type_JavaLangString, paramaygl);
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
    this.jdField_a_of_type_Ayet.b();
    if ((nny.a(a()) != 1) && (this.jdField_b_of_type_Int != 4) && (this.jdField_b_of_type_Int != 6) && (this.jdField_a_of_type_Ayet.a != null) && (!this.jdField_a_of_type_Ayet.a.jdField_d_of_type_Boolean)) {
      QQToast.a(a(), anzj.a(2131713355), 1).a();
    }
    this.i = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ayet.a();
  }
  
  public void d()
  {
    long l1;
    long l2;
    if (this.jdField_a_of_type_Ayet.a != null)
    {
      l1 = this.jdField_a_of_type_Ayet.b();
      l2 = this.jdField_a_of_type_Ayet.c();
      if (l1 == 0L) {
        break label100;
      }
    }
    label100:
    for (double d1 = l2 / l1;; d1 = 0.0D)
    {
      ayel.a(this.jdField_a_of_type_Ayet.a.jdField_a_of_type_JavaLangString, 2, String.valueOf(d1), String.valueOf(l1), String.valueOf(l2), String.valueOf(ayel.b()), this.jdField_a_of_type_Ayet.a());
      this.jdField_a_of_type_Ayet.c();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a();
      this.e = true;
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aybt != null) {
      this.jdField_a_of_type_Aybt.b();
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
    aygl localaygl = (aygl)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localaygl != null) {
      localaygl.e();
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
        this.jdField_a_of_type_Ayet.b();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "startPlayVideo state = [" + paramInt + "]");
        }
        ayel.a(1);
        a(this.jdField_a_of_type_Int);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayController", 2, "onPageScrollStateChanged mVideoPlayer.pause()");
        }
        this.jdField_a_of_type_Ayet.a();
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
      this.jdField_a_of_type_Aycq.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.size() - 1)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Aycq.a();
    }
    if (paramInt < 2)
    {
      this.jdField_a_of_type_Aycq.a(this.jdField_a_of_type_JavaLangString, ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Aycq.b();
    }
    if (paramInt < this.jdField_a_of_type_Int) {
      new ayek().h("video").i("playpage_left_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    VideoData localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    localVideoData.jdField_c_of_type_Boolean = false;
    if (paramInt > this.jdField_a_of_type_Int)
    {
      new ayek().h("video").i("playpage_right_slide").b().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ThreadManagerV2.excute(new StoryPlayController.7(this, localVideoData, (axup)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.StoryPlayController
 * JD-Core Version:    0.7.0.1
 */