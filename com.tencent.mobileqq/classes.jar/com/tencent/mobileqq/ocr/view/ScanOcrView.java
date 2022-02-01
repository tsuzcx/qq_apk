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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  Context jdField_a_of_type_AndroidContentContext;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new ScanOcrView.1(this);
  ScanOcrView.ScanRectAniParam jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
  public boolean a;
  int jdField_b_of_type_Int;
  AnimatorSet jdField_b_of_type_AndroidAnimationAnimatorSet;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  ScanOcrView.ScanRectAniParam jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  ScanOcrView.ScanRectAniParam jdField_c_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
  boolean jdField_c_of_type_Boolean = false;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o = 1;
  
  public ScanOcrView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    f();
  }
  
  public ScanOcrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    f();
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  private ScanOcrView.ScanRectAniParam a()
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(200.0F, getResources());
    int i4 = this.h;
    int i3 = this.j;
    i4 /= 2;
    i3 /= 2;
    Object localObject = new Rect();
    ((Rect)localObject).left = (i4 - i1 / 2);
    ((Rect)localObject).top = (i3 - i2 / 2);
    ((Rect)localObject).right = (((Rect)localObject).left + i1);
    ((Rect)localObject).bottom = (((Rect)localObject).top + i2);
    ScanOcrView.ScanRectAniParam localScanRectAniParam = new ScanOcrView.ScanRectAniParam();
    localScanRectAniParam.jdField_b_of_type_AndroidGraphicsRect = ((Rect)localObject);
    localScanRectAniParam.jdField_a_of_type_Int = i1;
    localScanRectAniParam.jdField_b_of_type_Int = i2;
    localScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect = new Rect((Rect)localObject);
    localScanRectAniParam.e = 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("generateScanRectHoldAniParam, \n");
      ((StringBuilder)localObject).append(localScanRectAniParam);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    return localScanRectAniParam;
  }
  
  private ScanOcrView.ScanRectAniParam a(int paramInt, ScanOcrView.ScanRectAniParam paramScanRectAniParam)
  {
    int i1 = a(200.0F, getResources());
    int i2 = a(100.0F, getResources());
    Object localObject1 = new Random();
    int i3 = ((Random)localObject1).nextInt(i1) % (i1 - i2 + 1) + i2;
    int i4 = this.h;
    int i5 = this.j;
    float f1 = i4;
    int i6 = (int)(f1 * 0.3F + this.m + 0.5F);
    float f2 = i5;
    int i8 = (int)(0.3F * f2 + this.k + 0.5F);
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
      ((List)localObject2).remove(Integer.valueOf(paramScanRectAniParam.f));
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
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_c_of_type_Int = 500;
    ((ScanOcrView.ScanRectAniParam)localObject1).d = 700;
    if (((ScanOcrView.ScanRectAniParam)localObject1).d < 0) {
      ((ScanOcrView.ScanRectAniParam)localObject1).d = 0;
    }
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_a_of_type_Int = i3;
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_b_of_type_Int = i3;
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_b_of_type_AndroidGraphicsRect = ((Rect)localObject2);
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_c_of_type_AndroidGraphicsRect = new Rect((Rect)localObject2);
    ((ScanOcrView.ScanRectAniParam)localObject1).e = 0;
    ((ScanOcrView.ScanRectAniParam)localObject1).jdField_a_of_type_AndroidGraphicsRect = paramScanRectAniParam;
    ((ScanOcrView.ScanRectAniParam)localObject1).f = i2;
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
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(",mPlaying=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 2) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam = a(paramInt, this.jdField_c_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam);
    Object localObject = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    ((ValueAnimator)localObject).addUpdateListener(new ScanOcrView.2(this));
    ((ValueAnimator)localObject).setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ScanOcrView.3(this));
    localValueAnimator.setDuration(200L);
    localValueAnimator.addListener(new ScanOcrView.4(this, paramInt));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.d;
    if (paramInt == 0) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_Int;
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject, localValueAnimator });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = localAnimatorSet;
    localAnimatorSet.setStartDelay(i1);
    localAnimatorSet.start();
    invalidate();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845785);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845784);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845786);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1275068416);
    this.jdField_c_of_type_Int = a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.e = a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = a(212.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.f = a(212.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = a(110.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void g()
  {
    int i1 = this.o;
    if (i1 == 0)
    {
      this.j = (this.i - this.g);
      return;
    }
    if (i1 == 1) {
      this.j = this.i;
    }
  }
  
  @TargetApi(12)
  private void h()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("realPlayScanRectHoldAnimation, ,mScanRectHoldPlaying=");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject1).append(",mPlaying=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam = a();
    Object localObject1 = ValueAnimator.ofFloat(new float[] { 1.1F, 1.0F });
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
    ((ValueAnimator)localObject1).addUpdateListener(new ScanOcrView.5(this, (ScanOcrView.ScanRectAniParam)localObject2));
    ((ValueAnimator)localObject1).setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.addUpdateListener(new ScanOcrView.6(this, (ScanOcrView.ScanRectAniParam)localObject2));
    localValueAnimator.setDuration(100L);
    localValueAnimator.setRepeatCount(3);
    localValueAnimator.setRepeatMode(2);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playSequentially(new Animator[] { localObject1, localValueAnimator });
    this.jdField_b_of_type_AndroidAnimationAnimatorSet = ((AnimatorSet)localObject2);
    ((AnimatorSet)localObject2).start();
    invalidate();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopScan, mPlaying=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",scanType=");
      localStringBuilder.append(this.o);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScan, mPlaying=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",scanType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mScanType=");
      localStringBuilder.append(this.o);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (paramInt != this.o)
    {
      a();
      c();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.d = 0;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.o = paramInt;
      g();
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScanRectAnimation, mScanRectPlaying=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b(0);
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopScanRectAnimation, mScanRectPlaying=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    invalidate();
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startScanRectHoldAni, mScanRectHoldPlaying=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.i("ScanOcrView", 2, localStringBuilder.toString());
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      h();
      invalidate();
    }
  }
  
  @TargetApi(12)
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopScanRectHoldAni, mScanRectHoldPlaying=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.i("ScanOcrView", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      int i1 = this.d;
      if (i1 >= this.j)
      {
        this.d = 0;
        a();
        c();
        if (this.o == 0) {
          b();
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        paramCanvas = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 0, this.o, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramCanvas, 2000L);
        return;
      }
      if (i1 != 0)
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Long;
        i1 = this.j;
        i2 = (int)((l1 - l2) * i1 / 2000L);
        i3 = this.d;
        if (i3 + i2 > i1) {
          this.d = i1;
        } else {
          this.d = (i3 + i2);
        }
      }
      else
      {
        this.d = 10;
      }
      int i2 = this.d - this.f;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      i2 = this.m;
      ((Drawable)localObject).setBounds(i2, i1, this.h + i2, this.d);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      i1 = this.m;
      i2 = this.d;
      int i3 = this.jdField_c_of_type_Int;
      int i4 = this.e;
      ((Drawable)localObject).setBounds(i1, i2 - i3 + i4, this.h + i1, i2 + i4);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      invalidate();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
      if (localObject != null)
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((ScanOcrView.ScanRectAniParam)localObject).e);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam;
      if (localObject != null)
      {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((ScanOcrView.ScanRectAniParam)localObject).e);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_ComTencentMobileqqOcrViewScanOcrView$ScanRectAniParam.jdField_c_of_type_AndroidGraphicsRect.bottom);
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.h = (this.jdField_a_of_type_Int - this.m - this.n);
    this.i = (this.jdField_b_of_type_Int - this.k - this.l);
    g();
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = paramInt1;
    this.n = paramInt3;
    this.k = paramInt2;
    this.l = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.ScanOcrView
 * JD-Core Version:    0.7.0.1
 */