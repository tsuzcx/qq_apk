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
  private FrameLayout a;
  private TVK_IProxyFactory b;
  private View c;
  private TVK_IMediaPlayer d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  private String k;
  private boolean l = false;
  private ImageView m;
  private long n = SystemClock.elapsedRealtime();
  private long o = SystemClock.elapsedRealtime();
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video play initviews");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.equals(this.i, "sensor_auto"))
        {
          if (TextUtils.equals(this.i, "portrait"))
          {
            i1 = 1;
            setRequestedOrientation(i1);
          }
        }
        else
        {
          setContentViewNoTitle(2131628487);
          this.b = TVK_SDKMgr.getProxyFactory();
          if (this.b != null)
          {
            this.a = ((FrameLayout)findViewById(2131449941));
            this.c = ((View)this.b.createVideoView(getApplication()));
            this.c.setBackgroundColor(-16777216);
            Object localObject = new FrameLayout.LayoutParams(-1, -1);
            this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.c.setVisibility(0);
            this.a.addView(this.c);
            if (this.l)
            {
              this.m = new ImageView(this);
              localObject = new FrameLayout.LayoutParams(-2, -2);
              i1 = UIUtils.a(this, 20.0F);
              ((FrameLayout.LayoutParams)localObject).setMargins(i1, i1, 0, 0);
              this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
              this.m.setImageResource(2130844389);
              this.a.addView(this.m);
              this.m.setOnClickListener(new VipVideoPlayActivity.1(this));
            }
            long l1 = System.currentTimeMillis();
            this.d = this.b.createMediaPlayer(getApplication(), (IVideoViewBase)this.c);
            long l2 = System.currentTimeMillis();
            if (this.d != null)
            {
              this.d.attachDanmuView();
              this.d.setOnControllerClickListener(new VipVideoPlayActivity.VideoPlayerControllerClickListener(this));
              this.d.setOnVideoPreparedListener(new VipVideoPlayActivity.VideoPlayerPreparedListener(this));
              this.d.setOnErrorListener(new VipVideoPlayActivity.VideoPlayerErrorListener(this));
              this.d.attachControllerView();
              if (this.l)
              {
                localObject = new Properties();
                ((Properties)localObject).setProperty("mHaveBackBtn", "false");
                ((Properties)localObject).setProperty("mHaveBackLiteBtn", "false");
                this.d.attachControllerView((Properties)localObject);
              }
              else
              {
                this.d.attachControllerView();
              }
              long l3 = System.currentTimeMillis();
              localObject = null;
              if (!TextUtils.isEmpty(this.g))
              {
                localObject = new HashMap();
                ((Map)localObject).put("cookies", this.g);
              }
              a(this.e, (Map)localObject, this.f, this.h, this.j);
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
      int i1 = 0;
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
      paramString1.append(this.e);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.f);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.h);
      paramString1.append("|");
      localStringBuilder1.append(paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(this.j);
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
    this.o = SystemClock.elapsedRealtime();
    a("play_start", 0, 0, this.o - this.n, "");
    localObject1 = new TVK_PlayerVideoInfo(paramInt, paramString1, "");
    if (!TextUtils.isEmpty(this.k))
    {
      localObject2 = new HashMap();
      ((Map)localObject2).put("shouq_bus_type", this.k);
      ((TVK_PlayerVideoInfo)localObject1).setReportInfoMap((Map)localObject2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      this.d.openMediaPlayer(getApplication(), localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject1, paramString3, 0L, 0L);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      ((TVK_PlayerVideoInfo)localObject1).setPlayMode("yunbo");
      this.d.openMediaPlayerByUrl(getApplication(), paramString2, 0L, 0L, paramMap, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject1);
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
    this.n = SystemClock.elapsedRealtime();
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.e = paramBundle.getStringExtra("vid");
    this.f = paramBundle.getStringExtra("video_url");
    this.g = paramBundle.getStringExtra("video_url_cookies");
    this.h = paramBundle.getStringExtra("videoFormat");
    this.i = paramBundle.getStringExtra("screenOrientation");
    this.j = paramBundle.getIntExtra("vtype", 0);
    this.k = paramBundle.getStringExtra("report_bus_type");
    this.l = paramBundle.getBooleanExtra("is_show_default_back_btn", false);
    a("play_open", 0, 0, 0L, "");
    if (((TextUtils.isEmpty(this.e)) && (TextUtils.isEmpty(this.f))) || ((!TextUtils.isEmpty(this.e)) && (TextUtils.isEmpty(this.h))) || (this.j <= 0))
    {
      a("play_initfail", 4, -1, 0L, "");
      setResult(4);
      finish();
    }
    if (VipVideoManager.a(getApplication()))
    {
      int i1 = a();
      if (i1 != 0)
      {
        a("play_initfail", i1, -1, 0L, "");
        setResult(i1);
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
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.d;
    if (localTVK_IMediaPlayer != null)
    {
      localTVK_IMediaPlayer.stop();
      this.d.release();
      this.d = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */