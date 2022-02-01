package com.tencent.mobileqq.splashad;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vassplash.model.SplashUIdata;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class SplashADView
  extends RelativeLayout
{
  private static SplashADView q;
  public SplashUIdata a;
  public TVK_IMediaPlayer b;
  TextView c;
  ImageView d;
  View e;
  View f;
  View g;
  TextView h;
  RelativeLayout i;
  ImageView j;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  RelativeLayout n;
  private SplashADView.SplashADViewPresenter o;
  private int p = 0;
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext)
  {
    this(paramSplashUIdata, paramContext, null);
  }
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramSplashUIdata, paramContext, paramAttributeSet, 0);
  }
  
  public SplashADView(SplashUIdata paramSplashUIdata, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramSplashUIdata;
    this.k = a(paramContext);
    this.l = true;
    QLog.i("QSplash@VasSplashUtil", 1, "@SplashADView start");
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -16777216;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("#"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      int i1 = Color.parseColor((String)localObject);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  getValidTextColor error color = ");
      localStringBuilder.append((String)localObject);
      QLog.e("QSplash@VasSplashUtil", 1, localStringBuilder.toString(), paramString);
    }
    return -16777216;
  }
  
  public static SplashADView a(SplashUIdata paramSplashUIdata, Context paramContext)
  {
    try
    {
      if ((q == null) && (paramSplashUIdata != null) && (paramContext != null)) {
        q = new SplashADView(paramSplashUIdata, paramContext);
      }
      paramSplashUIdata = q;
      return paramSplashUIdata;
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mAdEntry =");
    ((StringBuilder)localObject).append(this.a.toString());
    QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
    LayoutInflater.from(paramContext).inflate(2131629301, this, true);
    this.c = ((TextView)findViewById(2131436701));
    f();
    if ((this.a.e == 1) && (this.a.c == 0)) {
      this.c.setText(HardCodeUtil.a(2131911653));
    }
    this.c.setVisibility(0);
    this.d = ((ImageView)findViewById(2131439080));
    if ((this.a.a == 2) && (this.a.h))
    {
      this.e = findViewById(2131450142);
      this.e.setVisibility(0);
    }
    this.n = ((RelativeLayout)findViewById(2131446251));
    this.f = findViewById(2131431474);
    int i1 = this.a.a;
    if (i1 != 0)
    {
      if (i1 != 2) {
        return false;
      }
      SplashADUtil.d(paramContext);
      if (TVK_SDKMgr.isInstalled(paramContext)) {
        return a(paramContext, this.a);
      }
      QLog.i("SplashAD", 1, "TVK_SDK not Installed");
      return false;
    }
    paramContext = new ImageView(paramContext);
    paramContext.setTag("image");
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    ((BitmapFactory.Options)localObject).inMutable = true;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("respath =");
      localStringBuilder.append(this.a.b);
      QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
      paramContext.setImageBitmap(BitmapManager.a(this.a.b, (BitmapFactory.Options)localObject));
      paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.n.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return true;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.e("SplashAD", 1, paramContext.toString());
    }
    return false;
  }
  
  private boolean a(Context paramContext, SplashUIdata paramSplashUIdata)
  {
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (localTVK_IProxyFactory != null)
    {
      try
      {
        this.g = ((View)localTVK_IProxyFactory.createVideoView_Scroll(BaseApplicationImpl.getContext()));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QSplash@VasSplashUtil", 1, " mVideoView init error", localThrowable);
        this.g = ((View)localTVK_IProxyFactory.createVideoView_Scroll(paramContext));
      }
      paramContext = this.g;
      if (paramContext != null)
      {
        paramContext.setBackgroundColor(-1);
        paramContext = new RelativeLayout.LayoutParams(-1, -1);
        paramContext.addRule(13, -1);
        this.g.setLayoutParams(paramContext);
        this.g.setTag("video");
        this.b = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), (IVideoViewBase)this.g);
        paramContext = this.b;
        if (paramContext == null) {
          return false;
        }
        paramContext.setOnVideoPreparedListener(new SplashADView.1(this));
        QLog.i("QSplash@VasSplashUtil", 1, "initVideo addView");
        this.n.addView(this.g);
        if (paramSplashUIdata.g)
        {
          this.d.setVisibility(0);
          this.d.setOnClickListener(new SplashADView.2(this));
        }
        return true;
      }
    }
    return false;
  }
  
  private Drawable b(String paramString)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    GradientDrawable localGradientDrawable = d(paramString);
    localStateListDrawable.addState(new int[] { -16842919 }, localGradientDrawable);
    paramString = c(paramString);
    localStateListDrawable.addState(new int[] { 16842919 }, paramString);
    return localStateListDrawable;
  }
  
  private Drawable c(String paramString)
  {
    return new LayerDrawable(new Drawable[] { d(paramString), h() });
  }
  
  private GradientDrawable d(String paramString)
  {
    return e(paramString);
  }
  
  private GradientDrawable e(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(6.0F));
    localGradientDrawable.setColor(a(paramString));
    return localGradientDrawable;
  }
  
  private void f()
  {
    this.h = ((TextView)findViewById(2131446248));
    this.i = ((RelativeLayout)findViewById(2131444944));
    this.j = ((ImageView)findViewById(2131436362));
    if ((this.i != null) && (this.j != null))
    {
      Object localObject = this.h;
      if (localObject == null) {
        return;
      }
      if (this.a == null)
      {
        ((TextView)localObject).setVisibility(8);
        this.i.setVisibility(8);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initSplashEntryText], btnType:");
      ((StringBuilder)localObject).append(this.a.n);
      ((StringBuilder)localObject).append(",id:");
      QLog.i("splash.tag.SplashADView", 1, ((StringBuilder)localObject).toString());
      if ((this.a.n != 0) && (this.a.n != 2))
      {
        if (this.a.n == 1) {
          g();
        }
      }
      else
      {
        if (TextUtils.isEmpty(this.a.k))
        {
          this.h.setVisibility(8);
          this.i.setVisibility(8);
          return;
        }
        this.h.setVisibility(0);
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setText(this.a.k);
        this.h.setTextColor(a(this.a.l));
        this.h.setBackgroundDrawable(b(this.a.m));
      }
    }
  }
  
  private void g()
  {
    try
    {
      QLog.i("splash.tag.SplashADView", 1, "[setEntryBtnStaticImage]");
      if (this.a != null)
      {
        if (this.a.n != 1) {
          return;
        }
        this.h.setVisibility(8);
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        ThreadManager.getFileThreadHandler().post(new -..Lambda.SplashADView.aGCnaWErORvdKXogZZ5CdZ2N9nQ(this));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("splash.tag.SplashADView", 1, localThrowable, new Object[0]);
    }
  }
  
  private GradientDrawable h()
  {
    return e("#26000000");
  }
  
  public void a()
  {
    if (this.b != null)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "startVideo");
      this.b.start();
      this.p = 2;
    }
  }
  
  public void b()
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (!((TVK_IMediaPlayer)localObject1).isPlaying()))
    {
      this.b.setLoopback(false);
      this.b.setXYaxis(2);
      localObject1 = this.a.f;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("videopath =");
      ((StringBuilder)localObject2).append(this.a.f);
      QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject2).toString());
      this.p = 1;
      localObject2 = new TVK_PlayerVideoInfo();
      if (Build.VERSION.SDK_INT >= 21) {
        ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("shouq_bus_type", "bus_type_spashad");
      ((TVK_PlayerVideoInfo)localObject2).setReportInfoMap(localHashMap);
      QLog.i("QSplash@VasSplashUtil", 1, "openMediaPlayerByUrl ");
      this.b.openMediaPlayerByUrl(getContext(), (String)localObject1, 0L, 0L, (TVK_PlayerVideoInfo)localObject2);
      this.b.setOutputMute(true);
    }
  }
  
  public void c()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if ((localTVK_IMediaPlayer != null) && (this.p == 2)) {
      localTVK_IMediaPlayer.start();
    }
  }
  
  public void d()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.pause();
    }
  }
  
  public void e()
  {
    try
    {
      boolean bool = this.m;
      if (bool) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SplashAD", 2, "release splash res");
      }
      this.m = true;
      q = null;
      this.p = 0;
      int i1 = this.a.a;
      if ((i1 != 0) && (i1 == 2) && (this.b != null))
      {
        this.b.stop();
        this.b.release();
        this.b = null;
        if (QLog.isColorLevel()) {
          QLog.i("SplashAD", 2, "release splash resvideo");
        }
      }
      return;
    }
    finally {}
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.h.setOnClickListener(paramOnClickListener);
    this.c.setOnClickListener(paramOnClickListener);
    RelativeLayout localRelativeLayout = this.i;
    if (localRelativeLayout != null) {
      localRelativeLayout.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnCompletionListener(TVK_IMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
    }
  }
  
  public void setOnErrorListener(TVK_IMediaPlayer.OnErrorListener paramOnErrorListener)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.b;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.setOnErrorListener(paramOnErrorListener);
    }
  }
  
  public void setPresenter(SplashADView.SplashADViewPresenter paramSplashADViewPresenter)
  {
    this.o = paramSplashADViewPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView
 * JD-Core Version:    0.7.0.1
 */