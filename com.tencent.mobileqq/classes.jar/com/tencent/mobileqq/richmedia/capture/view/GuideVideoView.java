package com.tencent.mobileqq.richmedia.capture.view;

import afsn;
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
import anvx;
import bbja;
import bbjb;
import bbjc;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
  implements afsn, View.OnClickListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbja jdField_a_of_type_Bbja;
  private bbjb jdField_a_of_type_Bbjb;
  private bbjc jdField_a_of_type_Bbjc;
  private FadedButton jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private FadedButton jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  
  public GuideVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList.add("https://sqdd.myapp.com/myapp/qqteam/QIM/Test-QIM/ad_dancegame.mp4");
    b();
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "OnDownloadCallback " + paramString);
    }
  }
  
  View a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        View localView = (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(getContext());
        return localView;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (!this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare");
      }
      c();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "handleMessage");
    }
  }
  
  public void b()
  {
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    int i = ScreenUtil.getInstantScreenHeight(getContext()) - ScreenUtil.dip2px(95.0F) * 2;
    double d1 = 0.0D;
    if (Double.isNaN(0.0D)) {
      d1 = 0.6D;
    }
    int m = (int)(d1 * i);
    int n = (ScreenUtil.SCREEN_WIDTH - m) / 2;
    setPadding(n, ScreenUtil.dip2px(95.0F), n, 0);
    setOrientation(1);
    setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding((int)(i * 0.05D), (int)(i * 0.06D), (int)(i * 0.05D), (int)(i * 0.05D));
    localObject1 = new LinearLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
    localObject1 = new LinearLayout.LayoutParams(-1, (int)(i * 0.782D));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    localObject1 = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    ((LinearLayout.LayoutParams)localObject1).topMargin = ((int)(i * 0.01D));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131704902));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton = new FadedButton(getContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setBackgroundResource(2130845927);
    localObject1 = new LinearLayout.LayoutParams(ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(40.0F));
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).topMargin = 16;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setOnClickListener(this);
    addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton);
    if (!this.c)
    {
      TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.c = true;
    }
    if (!TVK_SDKMgr.isInstalled(getContext())) {
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "TVK_SDK is not installed");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = a();
    } while (this.jdField_a_of_type_AndroidViewView == null);
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView);
    int j = (int)(m * 0.95D - n);
    int k = (int)(i * 0.782D);
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "width and height invalid, biW : " + j + " bgWidth : " + m + " LRPadding : " + n + " biH : " + k + " bgHeight : " + i + " containerRatio : " + 0.782D);
    }
    if (j > 0)
    {
      i = k;
      if (k > 0) {}
    }
    else
    {
      j = 106;
      i = 140;
    }
    localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
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
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton = new FadedButton(getContext());
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "ERROR : mVideoProxyFactory is null");
        }
        return;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getContext(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
    }
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
    localTVK_PlayerVideoInfo.setPlayType(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_capture_guide");
    localTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), (String[])this.jdField_a_of_type_JavaUtilList.toArray(new String[0]), 0L, 0L, localTVK_PlayerVideoInfo, null);
    this.d = true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton) {
      if (this.jdField_a_of_type_Bbja != null) {
        this.jdField_a_of_type_Bbja.a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewFadedButton.setVisibility(8);
        if (this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "has prepared, now start");
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        }
        else if (!this.d)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasn't opening URL, now prepare video");
          }
          a();
        }
      }
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_Bbjb != null) {
      this.jdField_a_of_type_Bbjb.a();
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (this.jdField_a_of_type_Bbjc != null) {
      this.jdField_a_of_type_Bbjc.a("onError sdkError : " + paramInt1 + "  sdkDetailError : " + paramInt2);
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
  
  public void setOnCloseListener(bbja parambbja)
  {
    this.jdField_a_of_type_Bbja = parambbja;
  }
  
  public void setOnCompleteListener(bbjb parambbjb)
  {
    this.jdField_a_of_type_Bbjb = parambbjb;
  }
  
  public void setOnErrorListener(bbjc parambbjc)
  {
    this.jdField_a_of_type_Bbjc = parambbjc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.GuideVideoView
 * JD-Core Version:    0.7.0.1
 */