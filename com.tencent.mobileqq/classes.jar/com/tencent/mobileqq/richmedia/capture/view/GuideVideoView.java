package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuideVideoView
  extends LinearLayout
  implements View.OnClickListener, Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  TVK_IProxyFactory a;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  private LinearLayout f;
  private FadedButton g;
  private FadedButton h;
  private RelativeLayout i;
  private ImageView j;
  private TVK_IMediaPlayer k;
  private View l;
  private TextView m;
  private GuideVideoView.OnCloseListener n;
  private GuideVideoView.OnCompleteListener o;
  private GuideVideoView.OnErrorListener p;
  private List<String> q = new ArrayList();
  private int r = -1;
  
  public GuideVideoView(Context paramContext)
  {
    super(paramContext);
    this.q.add("https://sqdd.myapp.com/myapp/qqteam/QIM/Test-QIM/ad_dancegame.mp4");
    b();
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDownloadCallback ");
      localStringBuilder.append(paramString);
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    if (!this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare");
      }
      c();
    }
  }
  
  public void b()
  {
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    int i1 = ScreenUtil.getInstantScreenHeight(getContext()) - ScreenUtil.dip2px(95.0F) * 2;
    double d1 = 0.0D;
    if (Double.isNaN(0.0D)) {
      d1 = 0.6D;
    }
    double d2 = i1;
    Double.isNaN(d2);
    int i4 = (int)(d1 * d2);
    int i5 = (ScreenUtil.SCREEN_WIDTH - i4) / 2;
    setPadding(i5, ScreenUtil.dip2px(95.0F), i5, 0);
    setOrientation(1);
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.f = new LinearLayout(getContext());
    localObject1 = this.f;
    Double.isNaN(d2);
    int i2 = (int)(0.05D * d2);
    Double.isNaN(d2);
    ((LinearLayout)localObject1).setPadding(i2, (int)(0.06D * d2), i2, i2);
    localObject1 = new LinearLayout.LayoutParams(-1, i1);
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.f.setOrientation(1);
    this.i = new RelativeLayout(getContext());
    Double.isNaN(d2);
    int i3 = (int)(d2 * 0.782D);
    localObject1 = new LinearLayout.LayoutParams(-1, i3);
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.i.setBackgroundColor(-16777216);
    this.f.addView(this.i);
    this.m = new TextView(getContext());
    localObject1 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    Double.isNaN(d2);
    ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(d2 * 0.01D));
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.m.setGravity(17);
    this.m.setText(HardCodeUtil.a(2131903406));
    this.m.setTextSize(1, 14.0F);
    this.m.setTextColor(-1);
    this.f.addView(this.m);
    addView(this.f);
    this.g = new FadedButton(getContext());
    this.g.setBackgroundResource(2130847594);
    localObject1 = new LinearLayout.LayoutParams(ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(40.0F));
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).topMargin = 16;
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.g.setOnClickListener(this);
    addView(this.g);
    if (!this.d)
    {
      TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.d = true;
    }
    if (!TVK_SDKMgr.isInstalled(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "TVK_SDK is not installed");
      }
      return;
    }
    this.l = d();
    if (this.l == null) {
      return;
    }
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.l.setBackgroundColor(-16777216);
    ((IVideoViewBase)this.l).addViewCallBack(this);
    this.i.addView(this.l);
    d1 = i4;
    Double.isNaN(d1);
    d2 = i5;
    Double.isNaN(d2);
    i2 = (int)(d1 * 0.95D - d2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("width and height invalid, biW : ");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(" bgWidth : ");
      ((StringBuilder)localObject1).append(i4);
      ((StringBuilder)localObject1).append(" LRPadding : ");
      ((StringBuilder)localObject1).append(i5);
      ((StringBuilder)localObject1).append(" biH : ");
      ((StringBuilder)localObject1).append(i3);
      ((StringBuilder)localObject1).append(" bgHeight : ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(" containerRatio : ");
      ((StringBuilder)localObject1).append(0.782D);
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, ((StringBuilder)localObject1).toString());
    }
    if (i2 > 0)
    {
      i1 = i3;
      if (i3 > 0) {}
    }
    else
    {
      i2 = 106;
      i1 = 140;
    }
    localObject1 = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
    Object localObject2 = new Canvas((Bitmap)localObject1);
    Paint localPaint = new Paint();
    localPaint.setColor(Color.parseColor("#350070"));
    ((Canvas)localObject2).drawRect(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), localPaint);
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).restore();
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    localObject1 = URLDrawable.getDrawable("https://sqdd.myapp.com/myapp/qqteam/iPhoneQQ/dancegame/dancethumb.jpg", (URLDrawable.URLDrawableOptions)localObject2);
    this.j = new ImageView(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.j.setImageDrawable((Drawable)localObject1);
    this.i.addView(this.j);
    this.h = new FadedButton(getContext());
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.h.setOnClickListener(this);
    this.i.addView(this.h);
  }
  
  public void c()
  {
    if (this.k == null)
    {
      localObject = this.a;
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "ERROR : mVideoProxyFactory is null");
        }
        return;
      }
      this.k = ((TVK_IProxyFactory)localObject).createMediaPlayer(getContext(), (IVideoViewBase)this.l);
      this.k.setOnCompletionListener(this);
      this.k.setOnErrorListener(this);
      this.k.setOnVideoPreparedListener(this);
      this.k.setOnInfoListener(this);
      this.k.setOnNetVideoInfoListener(this);
      this.k.setOnVideoPreparingListener(this);
      this.k.setOnDownloadCallback(this);
    }
    Object localObject = new TVK_PlayerVideoInfo();
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("keep_last_frame", "true");
    ((TVK_PlayerVideoInfo)localObject).setPlayMode("cache_extend_video");
    ((TVK_PlayerVideoInfo)localObject).setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_capture_guide");
    ((TVK_PlayerVideoInfo)localObject).setReportInfoMap(localHashMap);
    this.k.openMediaPlayerByUrl(getContext(), (String[])this.q.toArray(new String[0]), 0L, 0L, (TVK_PlayerVideoInfo)localObject, null);
    this.e = true;
  }
  
  View d()
  {
    try
    {
      this.a = TVK_SDKMgr.getProxyFactory();
      if (this.a != null)
      {
        View localView = (View)this.a.createVideoView_Scroll(getContext());
        return localView;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "handleMessage");
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.g)
    {
      localObject = this.n;
      if (localObject != null) {
        ((GuideVideoView.OnCloseListener)localObject).a();
      }
    }
    else
    {
      localObject = this.h;
      if (paramView == localObject)
      {
        this.c = true;
        ((FadedButton)localObject).setVisibility(8);
        if (this.b)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "has prepared, now start");
          }
          this.j.setVisibility(8);
          this.k.start();
        }
        else if (!this.e)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare video");
          }
          a();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer = this.o;
    if (paramTVK_IMediaPlayer != null) {
      paramTVK_IMediaPlayer.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = this.p;
    if (paramTVK_IMediaPlayer != null)
    {
      paramString = new StringBuilder();
      paramString.append("onError sdkError : ");
      paramString.append(paramInt1);
      paramString.append("  sdkDetailError : ");
      paramString.append(paramInt2);
      paramTVK_IMediaPlayer.a(paramString.toString());
    }
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onInfo");
    }
    return false;
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onNetVideoInfo");
    }
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onSurfaceDestory");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    post(new GuideVideoView.1(this));
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "onVideoPreparing");
    }
  }
  
  public void setOnCloseListener(GuideVideoView.OnCloseListener paramOnCloseListener)
  {
    this.n = paramOnCloseListener;
  }
  
  public void setOnCompleteListener(GuideVideoView.OnCompleteListener paramOnCompleteListener)
  {
    this.o = paramOnCompleteListener;
  }
  
  public void setOnErrorListener(GuideVideoView.OnErrorListener paramOnErrorListener)
  {
    this.p = paramOnErrorListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.GuideVideoView
 * JD-Core Version:    0.7.0.1
 */