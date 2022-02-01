package com.tencent.mobileqq.ocr.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScanOcrView
  extends View
{
  ScanOcrView.ScanRectAniParam A;
  ScanOcrView.ScanRectAniParam B;
  AnimatorSet C;
  AnimatorSet D;
  Drawable a;
  Drawable b;
  Paint c;
  public boolean d = false;
  long e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s;
  Context t;
  int u = 1;
  Handler v = new ScanOcrView.1(this);
  Drawable w;
  boolean x = false;
  boolean y = false;
  ScanOcrView.ScanRectAniParam z;
  
  public ScanOcrView(Context paramContext)
  {
    super(paramContext);
    this.t = paramContext;
    g();
  }
  
  public ScanOcrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.t = paramContext;
    g();
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  private ScanOcrView.ScanRectAniParam a(int paramInt, ScanOcrView.ScanRectAniParam paramScanRectAniParam)
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(100.0F, getResources());
    Object localObject1 = new Random();
    int i3 = ((Random)localObject1).nextInt(i1) % (i1 - i2 + 1) + i2;
    int i4 = this.m;
    int i5 = this.o;
    float f1 = i4;
    int i6 = (int)(f1 * 0.3F + this.r + 0.5F);
    float f2 = i5;
    int i8 = (int)(0.3F * f2 + this.p + 0.5F);
    int i7 = (int)(i6 + f1 * 0.4F + 0.5F);
    int i9 = (int)(i8 + f2 * 0.4F + 0.5F);
    Object localObject2 = new ArrayList();
    i1 = 0;
    while (i1 < 2)
    {
      ((List)localObject2).add(Integer.valueOf(i1));
      i1 += 1;
    }
    if ((paramInt != 0) && (paramScanRectAniParam != null))
    {
      ((List)localObject2).remove(Integer.valueOf(paramScanRectAniParam.i));
      if (((List)localObject2).size() > 0) {
        i1 = ((Random)localObject1).nextInt(((List)localObject2).size());
      } else {
        i1 = 0;
      }
    }
    else
    {
      i1 = ((Random)localObject1).nextInt(2);
    }
    if (i1 < ((List)localObject2).size()) {
      i1 = ((Integer)((List)localObject2).get(i1)).intValue();
    } else {
      i1 = 0;
    }
    i2 = i1;
    if (i1 >= 2) {
      i2 = 1;
    }
    i9 = (i9 - i8) / 2;
    i1 = i8 + i9 * i2;
    i8 = i9 + i1;
    paramScanRectAniParam = new Rect(i6, i1, i7, i8);
    i9 = ((Random)localObject1).nextInt(i7);
    int i10 = ((Random)localObject1).nextInt(i8);
    localObject2 = new Rect();
    int i11 = i3 / 2;
    ((Rect)localObject2).left = (i9 % (i7 - i6 + 1) + i6 - i11);
    ((Rect)localObject2).top = (i10 % (i8 - i1 + 1) + i1 - i11);
    ((Rect)localObject2).right = (((Rect)localObject2).left + i3);
    ((Rect)localObject2).bottom = (((Rect)localObject2).top + i3);
    localObject1 = new ScanOcrView.ScanRectAniParam();
    ((ScanOcrView.ScanRectAniParam)localObject1).e = 500;
    ((ScanOcrView.ScanRectAniParam)localObject1).f = 700;
    if (((ScanOcrView.ScanRectAniParam)localObject1).f < 0) {
      ((ScanOcrView.ScanRectAniParam)localObject1).f = 0;
    }
    ((ScanOcrView.ScanRectAniParam)localObject1).c = i3;
    ((ScanOcrView.ScanRectAniParam)localObject1).d = i3;
    ((ScanOcrView.ScanRectAniParam)localObject1).b = ((Rect)localObject2);
    ((ScanOcrView.ScanRectAniParam)localObject1).g = new Rect((Rect)localObject2);
    ((ScanOcrView.ScanRectAniParam)localObject1).h = 0;
    ((ScanOcrView.ScanRectAniParam)localObject1).a = paramScanRectAniParam;
    ((ScanOcrView.ScanRectAniParam)localObject1).i = i2;
    if (QLog.isColorLevel())
    {
      paramScanRectAniParam = new StringBuilder();
      paramScanRectAniParam.append("generateScanRectAniParam, hasDoneCnt=");
      paramScanRectAniParam.append(paramInt);
      paramScanRectAniParam.append(",");
      paramScanRectAniParam.append(i4);
      paramScanRectAniParam.append("*");
      paramScanRectAniParam.append(i5);
      paramScanRectAniParam.append("\n");
      paramScanRectAniParam.append(localObject1);
      QLog.i("ScanOcrView", 2, paramScanRectAniParam.toString());
    }
    return localObject1;
  }
  
  @TargetApi(12)
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("realPlayScanRectAnimation, hasDoneCnt=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",mScanRectPlaying=");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(",mPlaying=");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 2) {
      return;
    }
    this.B = this.z;
    this.z = a(paramInt, this.B);
    Object localObject = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    ((ValueAnimator)localObject).addUpdateListener(new ScanOcrView.2(this));
    ((ValueAnimator)localObject).setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ScanOcrView.3(this));
    localValueAnimator.setDuration(200L);
    localValueAnimator.addListener(new ScanOcrView.4(this, paramInt));
    int i1 = this.z.f;
    if (paramInt == 0) {
      i1 = this.z.e;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject, localValueAnimator });
    this.C = localAnimatorSet;
    localAnimatorSet.setStartDelay(i1);
    localAnimatorSet.start();
    invalidate();
  }
  
  private void g()
  {
    this.a = getResources().getDrawable(2130847255);
    this.b = getResources().getDrawable(2130847254);
    this.w = getResources().getDrawable(2130847256);
    this.c = new Paint(1);
    this.c.setColor(1275068416);
    this.h = a(10.0F, this.t.getResources());
    this.j = a(5.0F, this.t.getResources());
    this.k = a(212.0F, this.t.getResources());
    this.k = a(212.0F, this.t.getResources());
    this.l = a(110.0F, this.t.getResources());
  }
  
  private void h()
  {
    int i1 = this.u;
    if (i1 == 0)
    {
      this.o = (this.n - this.l);
      return;
    }
    if (i1 == 1) {
      this.o = this.n;
    }
  }
  
  private ScanOcrView.ScanRectAniParam i()
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(200.0F, getResources());
    int i4 = this.m;
    int i3 = this.o;
    i4 /= 2;
    i3 /= 2;
    Object localObject = new Rect();
    ((Rect)localObject).left = (i4 - i1 / 2);
    ((Rect)localObject).top = (i3 - i2 / 2);
    ((Rect)localObject).right = (((Rect)localObject).left + i1);
    ((Rect)localObject).bottom = (((Rect)localObject).top + i2);
    ScanOcrView.ScanRectAniParam localScanRectAniParam = new ScanOcrView.ScanRectAniParam();
    localScanRectAniParam.b = ((Rect)localObject);
    localScanRectAniParam.c = i1;
    localScanRectAniParam.d = i2;
    localScanRectAniParam.g = new Rect((Rect)localObject);
    localScanRectAniParam.h = 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateScanRectHoldAniParam, \n");
      ((StringBuilder)localObject).append(localScanRectAniParam);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    return localScanRectAniParam;
  }
  
  @TargetApi(12)
  private void j()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("realPlayScanRectHoldAnimation, ,mScanRectHoldPlaying=");
      ((StringBuilder)localObject1).append(this.y);
      ((StringBuilder)localObject1).append(",mPlaying=");
      ((StringBuilder)localObject1).append(this.d);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject1).toString());
    }
    this.A = i();
    Object localObject1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    Object localObject2 = this.A;
    ((ValueAnimator)localObject1).addUpdateListener(new ScanOcrView.5(this, (ScanOcrView.ScanRectAniParam)localObject2));
    ((ValueAnimator)localObject1).setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ScanOcrView.6(this, (ScanOcrView.ScanRectAniParam)localObject2));
    localValueAnimator.setDuration(100L);
    localValueAnimator.setRepeatCount(3);
    localValueAnimator.setRepeatMode(2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localObject1, localValueAnimator });
    this.D = ((AnimatorSet)localObject2);
    ((AnimatorSet)localObject2).start();
    invalidate();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopScan, mPlaying=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",scanType=");
      localStringBuilder.append(this.u);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    this.v.removeMessages(0);
    this.d = false;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScan, mPlaying=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",scanType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mScanType=");
      localStringBuilder.append(this.u);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    this.v.removeMessages(0);
    if (paramInt != this.u)
    {
      a();
      d();
    }
    if (!this.d)
    {
      this.i = 0;
      this.e = System.currentTimeMillis();
      this.u = paramInt;
      h();
      this.d = true;
      invalidate();
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScanRectAnimation, mScanRectPlaying=");
      localStringBuilder.append(this.x);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    if (!this.x)
    {
      this.x = true;
      b(0);
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopScanRectAnimation, mScanRectPlaying=");
      ((StringBuilder)localObject).append(this.x);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    this.x = false;
    Object localObject = this.C;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    invalidate();
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScanRectHoldAni, mScanRectHoldPlaying=");
      localStringBuilder.append(this.y);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    if (!this.y)
    {
      this.y = true;
      j();
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void f()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopScanRectHoldAni, mScanRectHoldPlaying=");
      ((StringBuilder)localObject).append(this.y);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    this.y = false;
    Object localObject = this.C;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    if (this.d)
    {
      int i1 = this.i;
      if (i1 >= this.o)
      {
        this.i = 0;
        a();
        d();
        if (this.u == 0) {
          c();
        }
        this.v.removeMessages(0);
        paramCanvas = Message.obtain(this.v, 0, this.u, 0);
        this.v.sendMessageDelayed(paramCanvas, 2000L);
        return;
      }
      if (i1 != 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.e;
        i1 = this.o;
        i2 = (int)((l1 - l2) * i1 / 2000L);
        i3 = this.i;
        if (i3 + i2 > i1) {
          this.i = i1;
        } else {
          this.i = (i3 + i2);
        }
      }
      else
      {
        this.i = 10;
      }
      int i2 = this.i - this.k;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      localObject = this.b;
      i2 = this.r;
      ((Drawable)localObject).setBounds(i2, i1, this.m + i2, this.i);
      this.b.draw(paramCanvas);
      localObject = this.a;
      i1 = this.r;
      i2 = this.i;
      int i3 = this.h;
      int i4 = this.j;
      ((Drawable)localObject).setBounds(i1, i2 - i3 + i4, this.m + i1, i2 + i4);
      this.a.draw(paramCanvas);
      this.e = System.currentTimeMillis();
      invalidate();
    }
    if (this.x)
    {
      localObject = this.z;
      if (localObject != null)
      {
        this.w.setAlpha(((ScanOcrView.ScanRectAniParam)localObject).h);
        this.w.setBounds(this.z.g.left, this.z.g.top, this.z.g.right, this.z.g.bottom);
        this.w.draw(paramCanvas);
      }
    }
    if (this.y)
    {
      localObject = this.A;
      if (localObject != null)
      {
        this.w.setAlpha(((ScanOcrView.ScanRectAniParam)localObject).h);
        this.w.setBounds(this.A.g.left, this.A.g.top, this.A.g.right, this.A.g.bottom);
        this.w.draw(paramCanvas);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.m = (this.f - this.r - this.s);
    this.n = (this.g - this.p - this.q);
    h();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.r = paramInt1;
    this.s = paramInt3;
    this.p = paramInt2;
    this.q = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView
 * JD-Core Version:    0.7.0.1
 */