package com.tencent.mobileqq.kandian.biz.reddot;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.skin.BaseSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.mobileqq.kandian.glue.utils.RIJSmartCropUtils;
import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, RedDotView<IEntranceButtonDataSource>, ReadInJoySkinManager.OnSkinChangedListener
{
  private View.OnClickListener A;
  private ApngDrawable.OnPlayRepeatListener B;
  private boolean C = false;
  private boolean D = false;
  private ImageView E;
  private KanDianUrlRoundCornerImageView F;
  private RelativeLayout G;
  private RelativeLayout H;
  private ImageView I;
  private TextView J;
  private TextView K;
  private TextView L;
  private LinearLayout M;
  private boolean N = false;
  private AnimatorSet O;
  private AnimatorSet P;
  private URLDrawableDownListener Q = new ColorBandVideoEntranceButton.1(this);
  private Function1<Canvas, Unit> R = new ColorBandVideoEntranceButton.14(this);
  private Function1<Canvas, Unit> S = new ColorBandVideoEntranceButton.15(this);
  protected ImageView a;
  protected ImageView b;
  protected KanDianUrlRoundCornerImageView c;
  protected URLImageView d;
  protected URLDrawable e;
  protected Drawable f;
  public boolean g = false;
  Animator h;
  Animator i;
  Animator j;
  Animator k;
  ReadInJoyObserver l = new ColorBandVideoEntranceButton.10(this);
  Runnable m = new ColorBandVideoEntranceButton.12(this);
  Runnable n = new ColorBandVideoEntranceButton.13(this);
  private View o;
  private ImageView p;
  private ImageView q;
  private Drawable r;
  private AnimatorSet s;
  private AnimatorSet t;
  private boolean u;
  private IEntranceButtonDataSource v;
  private int w;
  private int x;
  private URLDrawable y;
  private long z;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    j();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    j();
  }
  
  private Drawable a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f = getImageDrawable();
    } else if (this.f == null) {
      this.f = getImageDrawable();
    }
    return this.f;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return "";
        }
        return HardCodeUtil.a(2131915805);
      }
      return HardCodeUtil.a(2131915807);
    }
    return HardCodeUtil.a(2131915806);
  }
  
  private String a(EntranceIconInfo paramEntranceIconInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramEntranceIconInfo.g));
    localStringBuilder.append(" ");
    localStringBuilder.append(a(paramEntranceIconInfo.h));
    return localStringBuilder.toString();
  }
  
  private void a(View paramView)
  {
    if (s())
    {
      this.z = System.currentTimeMillis();
      c();
      this.u = false;
      this.y = null;
      View.OnClickListener localOnClickListener = this.A;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
    }
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.clearAnimation();
    paramView.setScaleX(paramFloat);
    paramView.setScaleX(paramFloat);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView = paramImageView.getLayoutParams();
    this.w = paramImageView.width;
    this.x = paramImageView.height;
    if (QLog.isColorLevel())
    {
      paramImageView = new StringBuilder();
      paramImageView.append("initCoverImageSize, width: ");
      paramImageView.append(this.w);
      paramImageView.append(", height: ");
      paramImageView.append(this.x);
      QLog.d("ColorBandVideoEntranceButton", 2, paramImageView.toString());
    }
  }
  
  private void a(ApngDrawable paramApngDrawable)
  {
    if (this.B == null) {
      this.B = new ColorBandVideoEntranceButton.11(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.B);
    paramApngDrawable.repaly();
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable))) {
      postDelayed(this.n, 1800L);
    }
  }
  
  private void a(RIJColumnDataSource paramRIJColumnDataSource)
  {
    if (!this.g) {
      return;
    }
    if (paramRIJColumnDataSource != null)
    {
      if ((this.J != null) && (!TextUtils.isEmpty(paramRIJColumnDataSource.a))) {
        this.J.setText(paramRIJColumnDataSource.a);
      }
      if ((this.K != null) && (!TextUtils.isEmpty(paramRIJColumnDataSource.b))) {
        this.K.setText(paramRIJColumnDataSource.b);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.c == null) {
      return;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.o, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.o, "scaleY", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.c, "scaleX", new float[] { 0.2F, 1.0F }), ObjectAnimator.ofFloat(this.c, "scaleY", new float[] { 0.2F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    if (!TextUtils.isEmpty(paramString)) {
      localAnimatorSet.addListener(new ColorBandVideoEntranceButton.6(this, paramString));
    }
    localAnimatorSet.start();
  }
  
  private void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("target")) && (paramMap.containsKey("channelid")))
    {
      String str = (String)paramMap.get("target");
      paramMap = (String)paramMap.get("channelid");
      if (("2".equals(str)) && (String.valueOf(70).equals(paramMap))) {
        RIJSPUtils.a("key_sp_entrance_follow", Boolean.valueOf(true));
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.r;
    localURLDrawableOptions.mRequestWidth = this.w;
    localURLDrawableOptions.mRequestHeight = this.x;
    if (paramBoolean1)
    {
      localURLDrawableOptions.mUseApngImage = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 1);
      localURLDrawableOptions.mExtraInfo = localBundle;
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramBoolean2)
    {
      if (paramString.getStatus() == 1)
      {
        onLoadSuccessed(paramString);
        return;
      }
      paramString.setURLDrawableListener(this);
      paramString.startDownload();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1) {
      localObject = this.H;
    } else if (paramBoolean2) {
      localObject = this.c;
    } else {
      localObject = this.a;
    }
    try
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      int i1 = ((FrameLayout.LayoutParams)localObject).bottomMargin;
      int i3 = ((FrameLayout.LayoutParams)localObject).rightMargin;
      int i2 = ((FrameLayout.LayoutParams)localObject).width;
      localObject = (FrameLayout.LayoutParams)this.p.getLayoutParams();
      i3 -= DisplayUtil.a(getContext(), 12.0F);
      i1 = DisplayUtil.a(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width + i2 + i1;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i1;
      ((FrameLayout.LayoutParams)localObject).rightMargin = i3;
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.q.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = i1;
      ((FrameLayout.LayoutParams)localObject).rightMargin = i3;
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSkinPosition error!  msg=");
      localStringBuilder.append(localException);
      QLog.d("ColorBandVideoEntranceButton", 1, localStringBuilder.toString());
    }
  }
  
  private String b(String paramString)
  {
    int i1 = 0;
    float f1 = 0.0F;
    while (i1 < paramString.length())
    {
      float f2;
      if (StringUtil.isChinese(paramString.charAt(i1))) {
        f2 = 2.0F;
      } else {
        f2 = 1.0F;
      }
      f1 += f2;
      if (f1 > 16.0F)
      {
        i2 = 1;
        break label63;
      }
      i1 += 1;
    }
    int i2 = 0;
    label63:
    Object localObject = paramString;
    if (i2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, i1));
      ((StringBuilder)localObject).append("...");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.E.setImageDrawable(paramURLDrawable);
      if ((this.v instanceof RIJColumnDataSource)) {
        this.D = true;
      } else {
        this.N = true;
      }
    }
    else
    {
      this.F.setImageDrawable(paramURLDrawable);
      this.C = true;
    }
    if ((this.C) && (this.D))
    {
      paramURLDrawable = this.E.getDrawable();
      if ((paramURLDrawable instanceof ApngDrawable))
      {
        a((ApngDrawable)paramURLDrawable);
        this.C = false;
        this.D = false;
      }
    }
  }
  
  private void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if ((paramIEntranceButtonDataSource instanceof EntranceIconInfo)) {
      a(URLUtil.a(((EntranceIconInfo)paramIEntranceButtonDataSource).d));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    c(paramBoolean);
    Object localObject = this.a;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((ImageView)localObject).setVisibility(i1);
    this.c.setVisibility(4);
    this.o.setVisibility(4);
    this.b.setVisibility(4);
    if (paramBoolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.l);
      this.G.setOnClickListener(this);
      this.H.setOnClickListener(this);
      u();
      a(this.F);
      this.F.setCorner(this.w / 2);
    }
    else
    {
      a(this.c);
      this.c.setCorner(this.w / 2);
      ReadInJoyLogicEngineEventDispatcher.a().b(this.l);
    }
    a(true);
    a(this.g, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showColumnDiandian! showColumnDiandian=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
  }
  
  private void c(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    post(new ColorBandVideoEntranceButton.5(this, paramIEntranceButtonDataSource));
  }
  
  private void c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadUpdateAnimation: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
    localObject = new ApngOptions();
    ((ApngOptions)localObject).a(new ColorDrawable(7));
    ((ApngOptions)localObject).b(this.w);
    ((ApngOptions)localObject).c(this.x);
    ((ApngOptions)localObject).a(1);
    setUpdateImageAnimation(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, (ApngOptions)localObject));
  }
  
  private void c(boolean paramBoolean)
  {
    this.E.setImageDrawable(getImageDrawable());
    ImageView localImageView = this.E;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localImageView.setVisibility(i1);
    a(this.G, 0.0F);
    a(this.F, 0.0F);
    a(this.I, 0.0F);
    removeCallbacks(this.m);
    this.G.setClickable(false);
  }
  
  private void d(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.w;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.x;
    }
    try
    {
      URLDrawable.getDrawable(new URL(paramString), (URLDrawable.URLDrawableOptions)localObject).startDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url format error: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean d(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    return paramIEntranceButtonDataSource instanceof EntranceIconInfo;
  }
  
  private void e(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    if (paramIEntranceButtonDataSource.c())
    {
      f(paramIEntranceButtonDataSource);
      return;
    }
    d(paramIEntranceButtonDataSource.d());
  }
  
  private void f(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource == null) {
      return;
    }
    if (this.g)
    {
      if ((paramIEntranceButtonDataSource instanceof RIJColumnDataSource))
      {
        a((RIJColumnDataSource)paramIEntranceButtonDataSource);
        v();
        a(true, RIJColumnDataSource.i, true);
        a(false, paramIEntranceButtonDataSource.d(), true);
      }
    }
    else
    {
      Object localObject;
      if (paramIEntranceButtonDataSource.a())
      {
        if (!TextUtils.isEmpty(paramIEntranceButtonDataSource.b()))
        {
          try
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions1.mLoadingDrawable = this.r;
            localURLDrawableOptions1.mRequestWidth = this.w;
            localURLDrawableOptions1.mRequestHeight = this.x;
            localURLDrawableOptions1.mPlayGifImage = true;
            this.y = URLDrawable.getDrawable(paramIEntranceButtonDataSource.b(), localURLDrawableOptions1);
            this.y.setURLDrawableListener(this);
            this.y.startDownload();
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break label199;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("url error: ");
          ((StringBuilder)localObject).append(localException1.getMessage());
          QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
        }
        label199:
        d(paramIEntranceButtonDataSource.d());
        return;
      }
      String str = paramIEntranceButtonDataSource.d();
      if (!TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("rawUrl: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
        }
        str = RIJSmartCropUtils.a(str, this.w, this.x);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showCover(): startDownload smartCutUrl: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("，mWidth:");
          ((StringBuilder)localObject).append(this.w);
          ((StringBuilder)localObject).append(", mHeight:");
          ((StringBuilder)localObject).append(this.x);
          QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
        }
        try
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.r;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.w;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.x;
          this.y = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
          if ((this.y.getStatus() == 1) && ((this.y.getCurrDrawable() instanceof RegionDrawable)))
          {
            onLoadSuccessed(this.y);
          }
          else
          {
            this.y.setURLDrawableListener(this);
            this.y.startDownload();
          }
          paramIEntranceButtonDataSource.a(str);
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label504;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("url error: ");
        ((StringBuilder)localObject).append(localException2.getMessage());
        QLog.d("ColorBandVideoEntranceButton", 2, ((StringBuilder)localObject).toString());
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
      }
      label504:
      if ((paramIEntranceButtonDataSource.e()) && (!TextUtils.isEmpty(paramIEntranceButtonDataSource.f())))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mLoadingDrawable = a(false);
        localURLDrawableOptions2.mRequestWidth = this.w;
        localURLDrawableOptions2.mRequestHeight = this.x;
        this.e = URLDrawable.getDrawable(paramIEntranceButtonDataSource.f(), localURLDrawableOptions2);
        this.e.startDownload();
      }
    }
  }
  
  private Drawable getImageDrawable()
  {
    int i1;
    if (!this.g) {
      i1 = RecommendFeedsDiandianEntranceManager.getDefaultFeedsIconSrcId();
    } else {
      i1 = 2130843846;
    }
    return getResources().getDrawable(i1);
  }
  
  private void j()
  {
    inflate(getContext(), 2131626156, this);
    this.o = findViewById(2131449802);
    this.a = ((ImageView)findViewById(2131444295));
    this.a.setOnClickListener(this);
    this.b = ((ImageView)findViewById(2131436551));
    this.c = ((KanDianUrlRoundCornerImageView)findViewById(2131444297));
    this.c.setOnClickListener(this);
    a(this.c);
    this.c.setCorner(this.w / 2);
    this.p = ((ImageView)findViewById(2131449850));
    this.q = ((ImageView)findViewById(2131449849));
    this.r = getResources().getDrawable(2130841253);
    this.d = ((URLImageView)findViewById(2131444296));
    this.L = ((TextView)findViewById(2131439326));
    this.M = ((LinearLayout)findViewById(2131439325));
    l();
    this.E = ((ImageView)findViewById(2131430996));
    this.F = ((KanDianUrlRoundCornerImageView)findViewById(2131430990));
    this.I = ((ImageView)findViewById(2131444531));
    this.G = ((RelativeLayout)findViewById(2131431000));
    this.H = ((RelativeLayout)findViewById(2131430999));
    this.J = ((TextView)findViewById(2131431004));
    this.K = ((TextView)findViewById(2131431003));
  }
  
  private void k()
  {
    Object localObject = this.o;
    if ((localObject != null) && (this.c != null))
    {
      if (this.a == null) {
        return;
      }
      ((View)localObject).setScaleX(0.2F);
      this.o.setScaleY(0.2F);
      this.c.setScaleX(0.2F);
      this.c.setScaleY(0.2F);
      localObject = ObjectAnimator.ofFloat(this.a, "translationX", new float[] { 0.0F, AIOUtils.b(21.0F, getResources()) });
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.a, "translationY", new float[] { 0.0F, AIOUtils.b(21.0F, getResources()) });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[] { 1.0F, 0.38F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[] { 1.0F, 0.38F });
      this.s = new AnimatorSet();
      this.s.playTogether(new Animator[] { localObject, localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
      this.s.setDuration(333L);
      this.t = new AnimatorSet();
      this.t.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.o, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.o, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.c, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.c, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
      this.t.setDuration(400L);
      ((ObjectAnimator)localObject).addUpdateListener(new ColorBandVideoEntranceButton.3(this));
      this.s.start();
    }
  }
  
  private void l()
  {
    Object localObject = (ReadInJoySkinManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)localObject).a(3);
    if (localBaseSkinRes != null) {
      this.p.setImageDrawable(localBaseSkinRes.a());
    }
    localObject = ((ReadInJoySkinManager)localObject).a(2);
    if (localObject != null) {
      this.q.setImageDrawable(((BaseSkinRes)localObject).a());
    }
  }
  
  private void m()
  {
    p();
    a();
  }
  
  private void n()
  {
    AnimatorSet localAnimatorSet = this.O;
    if ((localAnimatorSet != null) && (localAnimatorSet.isStarted())) {
      this.O.cancel();
    }
    this.O = new AnimatorSet();
    this.O.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.M, "scaleX", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.M, "scaleY", new float[] { 0.5F, 1.0F }), ObjectAnimator.ofFloat(this.M, "translationX", new float[] { 2.0F, 0.0F }), ObjectAnimator.ofFloat(this.M, "translationY", new float[] { 40.0F, 20.0F, 0.0F }) });
    this.O.setDuration(300L);
    this.O.addListener(new ColorBandVideoEntranceButton.7(this));
    this.O.start();
  }
  
  private void o()
  {
    Object localObject = this.M;
    ((LinearLayout)localObject).setPivotX(((LinearLayout)localObject).getWidth());
    localObject = this.M;
    ((LinearLayout)localObject).setPivotY(((LinearLayout)localObject).getHeight());
    localObject = this.P;
    if ((localObject != null) && (((AnimatorSet)localObject).isStarted())) {
      this.P.cancel();
    }
    this.P = new AnimatorSet();
    this.P.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.M, "scaleX", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.M, "scaleY", new float[] { 1.0F, 0.5F }), ObjectAnimator.ofFloat(this.M, "translationX", new float[] { 0.0F, 2.0F }), ObjectAnimator.ofFloat(this.M, "translationY", new float[] { 0.0F, 20.0F, 40.0F }) });
    this.P.setDuration(300L);
    this.P.addListener(new ColorBandVideoEntranceButton.8(this));
    this.M.postDelayed(new ColorBandVideoEntranceButton.9(this), 2500L);
  }
  
  private void p()
  {
    AnimatorSet localAnimatorSet = this.s;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      this.s.cancel();
    }
    localAnimatorSet = this.t;
    if ((localAnimatorSet != null) && (localAnimatorSet.isRunning())) {
      this.t.cancel();
    }
  }
  
  private void q()
  {
    this.a.setVisibility(0);
    if (!this.u)
    {
      k();
      this.u = true;
      return;
    }
    a(null);
  }
  
  private void r()
  {
    this.a.setVisibility(8);
    Object localObject = this.v;
    if ((localObject instanceof EntranceIconInfo)) {
      localObject = ((EntranceIconInfo)localObject).c;
    } else {
      localObject = "https://pub.idqqimg.com/pc/misc/files/20200805/6b42a020cbde489889a5c7ea52bdd5ed.png";
    }
    if (!this.u)
    {
      a((String)localObject);
      this.u = true;
      return;
    }
    a((String)localObject);
  }
  
  private boolean s()
  {
    return System.currentTimeMillis() - this.z > 1000L;
  }
  
  private void setNicknamePopupAttributes(EntranceIconInfo paramEntranceIconInfo)
  {
    if (this.M != null)
    {
      this.L.setText(a(paramEntranceIconInfo));
      this.M.setVisibility(0);
      n();
    }
  }
  
  private void setUpdateImageAnimation(URLDrawable paramURLDrawable)
  {
    if (!this.u)
    {
      QLog.d("ColorBandVideoEntranceButton", 1, "has no red dot");
      return;
    }
    QLog.d("ColorBandVideoEntranceButton", 1, "isHasRedDot updateAnimation");
    this.d.setVisibility(0);
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)) && (((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage() != null))
    {
      Bitmap localBitmap = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage().getCurrentFrame();
      if (localBitmap != null) {
        localBitmap.eraseColor(0);
      }
    }
    if (paramURLDrawable != null)
    {
      this.d.setURLDrawableDownListener(this.Q);
      this.d.setImageDrawable(paramURLDrawable);
      if (paramURLDrawable.getStatus() == 1) {
        a(paramURLDrawable);
      }
    }
  }
  
  private void t()
  {
    if (ReadInJoyHelper.L())
    {
      if (!this.g)
      {
        this.g = true;
        b(this.g);
        setDataSource(null);
        this.N = false;
      }
    }
    else if (this.g)
    {
      this.g = false;
      b(this.g);
    }
  }
  
  private void u()
  {
    if (this.h == null) {
      this.h = AnimatorInflater.loadAnimator(getContext(), 2130903063);
    }
    if (this.i == null) {
      this.i = AnimatorInflater.loadAnimator(getContext(), 2130903064);
    }
    if (this.j == null) {
      this.j = AnimatorInflater.loadAnimator(getContext(), 2130903065);
    }
    if (this.k == null) {
      this.k = AnimatorInflater.loadAnimator(getContext(), 2130903062);
    }
  }
  
  private void v()
  {
    a(this.E, 1.0F);
    a(this.G, 0.0F);
    a(this.F, 0.0F);
    a(this.I, 0.0F);
  }
  
  public void a()
  {
    d();
    this.u = false;
    a(this.g, false);
    this.d.setVisibility(8);
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (paramIEntranceButtonDataSource != null) {
      c(paramIEntranceButtonDataSource);
    }
  }
  
  public void b()
  {
    ImageView localImageView = this.a;
    if ((localImageView != null) && (!this.g)) {
      onClick(localImageView);
    }
  }
  
  protected void c()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.5F, 1.0F }), ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.5F, 1.0F }) });
    int[] arrayOfInt1 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    Object localObject = this.o;
    if (this.g) {
      localObject = this.H;
    }
    ((View)localObject).getLocationOnScreen(arrayOfInt2);
    setPivotX(arrayOfInt2[0] - arrayOfInt1[0] + this.w / 2);
    setPivotY(arrayOfInt2[1] - arrayOfInt1[1] + this.x / 2);
    localAnimatorSet.setDuration(600L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.addListener(new ColorBandVideoEntranceButton.4(this));
    localAnimatorSet.start();
  }
  
  protected void d()
  {
    boolean bool = this.g;
    if (bool)
    {
      c(bool);
      return;
    }
    if (this.o.getVisibility() == 0) {
      this.o.setVisibility(4);
    }
    if (this.a.getVisibility() != 0) {
      this.a.setVisibility(0);
    }
    this.a.setTranslationX(0.0F);
    this.a.setTranslationY(0.0F);
    this.a.setScaleX(1.0F);
    this.a.setScaleY(1.0F);
    KanDianUrlRoundCornerImageView localKanDianUrlRoundCornerImageView = this.c;
    if ((localKanDianUrlRoundCornerImageView != null) && (localKanDianUrlRoundCornerImageView.getVisibility() != 8))
    {
      this.c.setVisibility(8);
      this.c.setImageDrawable(null);
    }
    this.a.setImageDrawable(a(false));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.S);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.R);
  }
  
  public void e()
  {
    t();
    if (this.v == null)
    {
      p();
      d();
      if ((!this.N) && (this.g)) {
        a(true, RIJColumnDataSource.j, true);
      }
    }
  }
  
  public void f()
  {
    IEntranceButtonDataSource localIEntranceButtonDataSource = this.v;
    if ((localIEntranceButtonDataSource != null) && (localIEntranceButtonDataSource.a()))
    {
      AbstractGifImage.pauseAll();
      GifHelper.b();
    }
  }
  
  public void g()
  {
    IEntranceButtonDataSource localIEntranceButtonDataSource = this.v;
    if ((localIEntranceButtonDataSource != null) && (localIEntranceButtonDataSource.a()))
    {
      AbstractGifImage.resumeAll();
      GifHelper.a();
    }
  }
  
  public View getAnchorView()
  {
    return this.c;
  }
  
  public int getCoverHeight()
  {
    return this.x;
  }
  
  public int getCoverWidth()
  {
    return this.w;
  }
  
  public IEntranceButtonDataSource getDataSource()
  {
    return this.v;
  }
  
  public ImageView getRefreshIcon()
  {
    return this.b;
  }
  
  public void h()
  {
    if ((this.G != null) && ((this.v instanceof RIJColumnDataSource)))
    {
      u();
      this.G.setClickable(true);
      RelativeLayout localRelativeLayout = this.G;
      localRelativeLayout.setPivotX(localRelativeLayout.getWidth());
      localRelativeLayout = this.G;
      localRelativeLayout.setPivotY(localRelativeLayout.getHeight() / 2);
      this.h.setTarget(this.G);
      this.h.start();
      this.i.setTarget(this.F);
      this.i.start();
      this.j.setTarget(this.I);
      this.j.start();
      postDelayed(this.m, 3000L);
    }
  }
  
  public void i()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.l);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131431000: 
      paramView.setTag(Integer.valueOf(RIJColumnDataSource.l));
      a(paramView);
      return;
    }
    a(paramView);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    this.y = null;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadCanceled");
    }
    this.y = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFialed: ");
      paramURLDrawable.append(paramThrowable.getMessage());
      QLog.e("ColorBandVideoEntranceButton", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadSuccess, start setImage, dataSource=");
    ((StringBuilder)localObject).append(this.v);
    QLog.d("ColorBandVideoEntranceButton", 1, ((StringBuilder)localObject).toString());
    if (this.g)
    {
      b(paramURLDrawable);
      return;
    }
    if (this.v == null) {
      return;
    }
    localObject = this.o;
    if ((localObject != null) && (((View)localObject).getVisibility() != 0)) {
      this.o.setVisibility(0);
    }
    localObject = this.c;
    if ((localObject != null) && (((KanDianUrlRoundCornerImageView)localObject).getVisibility() != 0)) {
      this.c.setVisibility(0);
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((KanDianUrlRoundCornerImageView)localObject).setImageDrawable(paramURLDrawable);
      if ((this.v instanceof EntranceIconInfo)) {
        r();
      } else {
        q();
      }
      a(this.g, true);
      if ((this.a != null) && (this.v.e()) && (!TextUtils.isEmpty(this.v.f()))) {
        this.a.setImageDrawable(this.e);
      }
    }
    this.y = null;
  }
  
  public void setDataSource(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDataSource: ");
    localStringBuilder.append(paramIEntranceButtonDataSource);
    QLog.d("ColorBandVideoEntranceButton", 1, localStringBuilder.toString());
    this.v = paramIEntranceButtonDataSource;
    b(paramIEntranceButtonDataSource);
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    this.a.setImageDrawable(this.f);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.width = AIOUtils.b(paramInt1, getContext().getResources());
    localLayoutParams.height = AIOUtils.b(paramInt2, getContext().getResources());
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public void setNotMsg()
  {
    post(new ColorBandVideoEntranceButton.2(this));
  }
  
  public void setOnVideoCoverClickListener(View.OnClickListener paramOnClickListener)
  {
    this.A = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */