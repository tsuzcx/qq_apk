package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FloatIconLayout
  extends FloatBaseLayout
  implements ValueAnimator.AnimatorUpdateListener, View.OnClickListener, URLDrawable.URLDrawableListener
{
  View A;
  View B;
  float C;
  ValueAnimator D;
  DownloadParams.DecodeHandler E = new FloatIconLayout.2(this);
  RelativeLayout o;
  ImageView p;
  ImageView q;
  String r;
  ValueAnimator s;
  int t;
  boolean u = false;
  boolean v = false;
  URLDrawable w;
  ImageView x;
  Paint y;
  int z;
  
  public FloatIconLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    i();
  }
  
  private void a(float paramFloat)
  {
    float f1 = this.B.getRotation();
    float f2 = paramFloat - f1;
    if (Math.abs(f2) < 0.5F)
    {
      this.B.setRotation(paramFloat);
      return;
    }
    ValueAnimator localValueAnimator = this.D;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.D.cancel();
    }
    this.D = ValueAnimator.ofFloat(new float[] { f1, paramFloat });
    this.D.setDuration((Math.abs(f2) * 200.0F / 28.0F));
    this.D.addUpdateListener(new FloatIconLayout.1(this));
    this.D.start();
  }
  
  private void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateMusicIcon url:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" mAlbumUrl:");
      ((StringBuilder)localObject).append(this.r);
      QLog.i("FloatBaseLayout.Icon", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.equals(paramString, this.r)) {
      return;
    }
    this.r = paramString;
    this.A.setRotation(0.0F);
    if (!TextUtils.isEmpty(this.r))
    {
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mMemoryCacheKeySuffix = "round";
      int i = this.t;
      paramString.mRequestWidth = i;
      paramString.mRequestHeight = i;
      paramString.mFailedDrawable = URLDrawableHelperConstants.a;
      paramString.mLoadingDrawable = URLDrawableHelperConstants.a;
      localObject = this.w;
      if (localObject != null)
      {
        ((URLDrawable)localObject).setURLDrawableListener(null);
        this.w = null;
      }
      this.w = URLDrawable.getDrawable(this.r, paramString);
      this.w.setDecodeHandler(this.E);
      this.w.startDownload();
      this.w.setURLDrawableListener(this);
      this.p.setImageDrawable(this.w);
      return;
    }
    paramString = this.w;
    if (paramString != null)
    {
      paramString.setURLDrawableListener(null);
      this.w = null;
    }
    this.p.setImageDrawable(null);
    k();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ((ImageView)findViewById(paramInt1)).setImageResource(paramInt2);
  }
  
  private void i()
  {
    Object localObject = LayoutInflater.from(getContext()).inflate(2131627277, null);
    this.o = ((RelativeLayout)((View)localObject).findViewById(2131435248));
    this.q = ((ImageView)((View)localObject).findViewById(2131430825));
    this.p = ((ImageView)((View)localObject).findViewById(2131439044));
    this.x = ((ImageView)((View)localObject).findViewById(2131439045));
    this.A = ((View)localObject).findViewById(2131445169);
    this.B = ((View)localObject).findViewById(2131439065);
    addView((View)localObject, new FrameLayout.LayoutParams(-2, -2));
    this.q.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.p.setContentDescription(HardCodeUtil.a(2131902632));
    this.q.setContentDescription(HardCodeUtil.a(2131902633));
    this.b = ((int)getResources().getDimension(2131297752));
    this.c = ((int)getResources().getDimension(2131297751));
    this.t = AIOUtils.b(40.0F, getResources());
    this.e.width = this.b;
    this.e.height = this.c;
    this.s = ValueAnimator.ofFloat(new float[] { 0.0F, 360.0F });
    localObject = new LinearInterpolator();
    this.s.setInterpolator((TimeInterpolator)localObject);
    this.s.addUpdateListener(this);
    this.s.setDuration(10000L);
    this.s.setRepeatCount(-1);
    this.A.setPivotX(AIOUtils.b(40.0F, getResources()) / 2);
    this.A.setPivotY(AIOUtils.b(40.0F, getResources()) / 2);
    this.y = new Paint();
    this.y.setAntiAlias(true);
    this.y.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    this.z = this.y.getColor();
    this.B.setPivotX(AIOUtils.b(20.0F, getResources()));
    this.B.setPivotY(AIOUtils.b(3.0F, getResources()));
    this.B.setRotation(-28.0F);
    this.C = 0.0F;
    k();
  }
  
  private void j()
  {
    if (d())
    {
      if (this.u)
      {
        if (!this.v)
        {
          this.C = 0.0F;
          this.s.start();
          this.v = true;
          a(0.0F);
        }
      }
      else
      {
        this.s.cancel();
        this.C = 0.0F;
        a(-28.0F);
        this.v = false;
      }
    }
    else
    {
      this.s.cancel();
      this.C = 0.0F;
      this.v = false;
    }
  }
  
  private void k()
  {
    this.x.setVisibility(8);
  }
  
  private void l()
  {
    this.x.setVisibility(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("FloatBaseLayout.Icon", 1, String.format("[float-icon] onMutualLevelChange mutualLevel=%d vasSkinShowing=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      return;
    }
    int i = 2130846220;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramInt = i;
        } else {
          paramInt = 2130846223;
        }
      }
      else {
        paramInt = 2130846222;
      }
    }
    else {
      paramInt = 2130846221;
    }
    b(2131439036, paramInt);
    this.B.setBackgroundResource(2130846226);
    b(2131439072, 2130846225);
    b(2131430825, 2130846224);
  }
  
  public void a(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return;
    }
    if ((paramFloatParams.k) && (!paramFloatParams.l) && (paramFloatParams.h)) {
      a(paramFloatParams.g);
    }
    paramFloatParams.c = this.b;
    paramFloatParams.d = this.c;
  }
  
  public boolean b(FloatParams paramFloatParams)
  {
    if (paramFloatParams == null) {
      return false;
    }
    boolean bool2 = d();
    boolean bool1;
    if ((paramFloatParams.k) && (!paramFloatParams.l) && (paramFloatParams.h)) {
      bool1 = a();
    } else {
      bool1 = c();
    }
    if (bool2 != d()) {
      j();
    }
    return bool1 ^ true;
  }
  
  public int c(FloatParams paramFloatParams)
  {
    return paramFloatParams.a - this.b / 2;
  }
  
  public boolean c()
  {
    boolean bool = super.c();
    j();
    return bool;
  }
  
  public int d(FloatParams paramFloatParams)
  {
    return paramFloatParams.b - this.c / 2;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i;
    if ((!"1103".equals(ThemeUtil.curThemeId)) && (!"2920".equals(ThemeUtil.curThemeId))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (this.y.getColorFilter() == null) {
        this.y.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      this.y.setColor(this.z);
      paramCanvas.saveLayer(null, this.y, 31);
    }
    super.dispatchDraw(paramCanvas);
    if (i != 0) {
      paramCanvas.restore();
    }
  }
  
  public void e()
  {
    super.e();
    URLDrawable localURLDrawable = this.w;
    if (localURLDrawable != null)
    {
      localURLDrawable.setURLDrawableListener(null);
      this.w = null;
    }
    this.s.cancel();
  }
  
  protected void f()
  {
    super.f();
    this.p.setAlpha(1.0F);
    this.q.setAlpha(1.0F);
  }
  
  protected void g()
  {
    super.g();
    this.p.setAlpha(1.0F);
    this.q.setAlpha(1.0F);
  }
  
  public void h()
  {
    invalidate();
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f3 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = this.A.getRotation() + (f3 - this.C);
    float f1 = f2;
    if (f2 > 360.0F) {
      f1 = f2 - 360.0F;
    }
    this.A.setRotation(f1);
    this.C = f3;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131430825)
    {
      if ((i == 2131439044) && (this.a != null)) {
        this.a.c();
      }
    }
    else if (this.a != null) {
      this.a.d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    k();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    l();
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.u = paramBoolean;
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout
 * JD-Core Version:    0.7.0.1
 */