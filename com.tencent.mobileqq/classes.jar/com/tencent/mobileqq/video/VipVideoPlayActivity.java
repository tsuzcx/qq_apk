package com.tencent.mobileqq.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import mqq.manager.TicketManager;

public class VipVideoPlayActivity
  extends IphoneTitleBarActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = SystemClock.elapsedRealtime();
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video play initviews");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(this.e, "sensor_auto"))
        {
          if (TextUtils.equals(this.e, "portrait"))
          {
            i = 1;
            setRequestedOrientation(i);
          }
        }
        else
        {
          setContentViewNoTitle(2131562061);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
          {
            this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131380951));
            this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(getApplication()));
            this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
            Object localObject = new FrameLayout.LayoutParams(-1, -1);
            this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
              localObject = new FrameLayout.LayoutParams(-2, -2);
              i = UIUtils.a(this, 20.0F);
              ((FrameLayout.LayoutParams)localObject).setMargins(i, i, 0, 0);
              this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843435);
              this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
              this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new VipVideoPlayActivity.1(this));
            }
            long l1 = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplication(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
            long l2 = System.currentTimeMillis();
            if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
            {
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachDanmuView();
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnControllerClickListener(new VipVideoPlayActivity.VideoPlayerControllerClickListener(this));
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new VipVideoPlayActivity.VideoPlayerPreparedListener(this));
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new VipVideoPlayActivity.VideoPlayerErrorListener(this));
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachControllerView();
              if (this.jdField_a_of_type_Boolean)
              {
                localObject = new Properties();
                ((Properties)localObject).setProperty("mHaveBackBtn", "false");
                ((Properties)localObject).setProperty("mHaveBackLiteBtn", "false");
                this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachControllerView((Properties)localObject);
              }
              else
              {
                this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachControllerView();
              }
              long l3 = System.currentTimeMillis();
              localObject = null;
              if (!TextUtils.isEmpty(this.c))
              {
                localObject = new HashMap();
                ((Map)localObject).put("cookies", this.c);
              }
              a(this.jdField_a_of_type_JavaLangString, (Map)localObject, this.jdField_b_of_type_JavaLangString, this.d, this.jdField_a_of_type_Int);
              long l4 = System.currentTimeMillis();
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("initView time1 = ");
                ((StringBuilder)localObject).append(l2 - l1);
                ((StringBuilder)localObject).append(", time2 = ");
                ((StringBuilder)localObject).append(l3 - l2);
                ((StringBuilder)localObject).append(", time3 = ");
                ((StringBuilder)localObject).append(l4 - l3);
                QLog.d("VipVideoPlayActivity", 2, ((StringBuilder)localObject).toString());
              }
              return 0;
            }
          }
          return 2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("video play initviews exception=");
          localStringBuilder.append(localException.getMessage());
          QLog.d("VipVideoPlayActivity", 2, localStringBuilder.toString());
        }
        return 3;
      }
      int i = 0;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("|");
      localStringBuilder1.append(localStringBuilder2.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_a_of_type_JavaLangString);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_b_of_type_JavaLangString);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.d);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.jdField_a_of_type_Int);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramInt1);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramInt2);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramLong);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      localStringBuilder1.append(paramString2);
      DcReportUtil.a(null, "b_sng_qqvip_videosdk|mediaplay", localStringBuilder1.toString(), true);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, int paramInt)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    Object localObject1 = new StringBuilder();
    Object localObject2 = (TicketManager)this.app.getManager(2);
    ((StringBuilder)localObject1).append("luin=o0");
    ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append("uin=o0");
    ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append("skey=");
    ((StringBuilder)localObject1).append(((TicketManager)localObject2).getSkey(this.app.getCurrentAccountUin()));
    localTVK_UserInfo.setLoginCookie(((StringBuilder)localObject1).toString());
    localTVK_UserInfo.setUin(this.app.getCurrentAccountUin());
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    a("play_start", 0, 0, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, "");
    localObject1 = new TVK_PlayerVideoInfo(paramInt, paramString1, "");
    if (!TextUtils.isEmpty(this.f))
    {
      localObject2 = new HashMap();
      ((Map)localObject2).put("shouq_bus_type", this.f);
      ((TVK_PlayerVideoInfo)localObject1).setReportInfoMap((Map)localObject2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(getApplication(), localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject1, paramString3, 0L, 0L);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      ((TVK_PlayerVideoInfo)localObject1).setPlayMode("yunbo");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getApplication(), paramString2, 0L, 0L, paramMap, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject1);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("vid");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("video_url");
    this.c = paramBundle.getStringExtra("video_url_cookies");
    this.d = paramBundle.getStringExtra("videoFormat");
    this.e = paramBundle.getStringExtra("screenOrientation");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("vtype", 0);
    this.f = paramBundle.getStringExtra("report_bus_type");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("is_show_default_back_btn", false);
    a("play_open", 0, 0, 0L, "");
    if (((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.d))) || (this.jdField_a_of_type_Int <= 0))
    {
      a("play_initfail", 4, -1, 0L, "");
      setResult(4);
      finish();
    }
    if (VipVideoManager.a(getApplication()))
    {
      int i = a();
      if (i != 0)
      {
        a("play_initfail", i, -1, 0L, "");
        setResult(i);
        finish();
        return false;
      }
      return true;
    }
    a("play_initfail", 1, -1, 0L, "");
    setResult(1);
    finish();
    return false;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "doOnDestroy()");
    }
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "onBackEvent++++++++++++++++++++++");
    }
    if (getRequestedOrientation() == 0)
    {
      setRequestedOrientation(1);
      return true;
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */