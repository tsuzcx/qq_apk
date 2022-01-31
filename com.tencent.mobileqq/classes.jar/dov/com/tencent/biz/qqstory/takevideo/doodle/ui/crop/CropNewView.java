package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import bmoq;
import bmor;
import bmot;
import bmov;
import bmow;
import com.tencent.TMG.utils.QLog;
import wtb;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private bmor jdField_a_of_type_Bmor;
  private bmot jdField_a_of_type_Bmot = new bmot();
  private bmov jdField_a_of_type_Bmov;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CropNewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new bmow(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Bmot.a();
    paramCanvas.rotate(this.jdField_a_of_type_Bmot.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Bmot.a(paramCanvas);
    this.jdField_a_of_type_Bmot.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Bmot.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(bmoq parambmoq)
  {
    this.jdField_a_of_type_Bmot.c(parambmoq.c);
    this.jdField_a_of_type_Bmot.b(parambmoq.d);
    if (!a(Math.round(parambmoq.a), Math.round(parambmoq.b))) {
      invalidate();
    }
  }
  
  private void a(bmoq parambmoq1, bmoq parambmoq2)
  {
    if (this.jdField_a_of_type_Bmor == null)
    {
      this.jdField_a_of_type_Bmor = new bmor();
      this.jdField_a_of_type_Bmor.addUpdateListener(this);
      this.jdField_a_of_type_Bmor.addListener(this);
    }
    this.jdField_a_of_type_Bmor.a(parambmoq1, parambmoq2);
    this.jdField_a_of_type_Bmor.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    bmoq localbmoq = this.jdField_a_of_type_Bmot.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localbmoq != null)
    {
      if ((this.jdField_a_of_type_Bmov != null) && (!this.b))
      {
        this.jdField_a_of_type_Bmov.c();
        setCrop(true);
      }
      a(localbmoq);
      return true;
    }
    return a(getScrollX() + Math.round(paramFloat1), getScrollY() + Math.round(paramFloat2));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((getScrollX() != paramInt1) || (getScrollY() != paramInt2))
    {
      scrollTo(paramInt1, paramInt2);
      return true;
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  private void e()
  {
    invalidate();
    f();
    bmoq localbmoq1 = this.jdField_a_of_type_Bmot.b(getScrollX(), getScrollY());
    bmoq localbmoq2 = this.jdField_a_of_type_Bmot.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localbmoq2.a = 0.0F;
      localbmoq2.b = 0.0F;
    }
    a(localbmoq1, localbmoq2);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bmor != null) {
      this.jdField_a_of_type_Bmor.cancel();
    }
  }
  
  public Bitmap a()
  {
    float f = 1.0F / this.jdField_a_of_type_Bmot.c();
    RectF localRectF = new RectF(this.jdField_a_of_type_Bmot.a());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_Bmot.b(), localRectF.centerX(), localRectF.centerY());
    ((Matrix)localObject).mapRect(localRectF);
    ((Matrix)localObject).setScale(f, f, localRectF.left, localRectF.top);
    ((Matrix)localObject).mapRect(localRectF);
    localObject = Bitmap.createBitmap(Math.round(localRectF.width()), Math.round(localRectF.height()), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.translate(-localRectF.left, -localRectF.top);
    localCanvas.scale(f, f, localRectF.left, localRectF.top);
    a(localCanvas, false);
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bmot.c();
    e();
    setCrop(false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmov != null) {
      this.jdField_a_of_type_Bmov.a(paramInt);
    }
  }
  
  boolean a()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onSteady: isHoming=" + b());
    }
    if (!b())
    {
      this.jdField_a_of_type_Bmot.d(getScrollX(), getScrollY());
      e();
      if (this.jdField_a_of_type_Bmov != null) {
        this.jdField_a_of_type_Bmov.c();
      }
      bool = true;
    }
    return bool;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    if (b()) {
      return false;
    }
    this.jdField_a_of_type_Int = paramMotionEvent.getPointerCount();
    boolean bool = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent) | b(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      return bool;
    case 0: 
      this.jdField_a_of_type_Bmot.b(paramMotionEvent.getX(), paramMotionEvent.getY());
      a(1);
      return bool;
    }
    this.jdField_a_of_type_Bmot.c(getScrollX(), getScrollY());
    a(2);
    e();
    return bool;
  }
  
  public void b()
  {
    if (!b())
    {
      this.jdField_a_of_type_Bmot.a(-90);
      e();
    }
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_Bmor != null) && (this.jdField_a_of_type_Bmor.isRunning());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bmot.b();
    this.jdField_a_of_type_Bmot.b(true);
    setResetHome(true);
    e();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_Bmot.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_Bmot.b(true);
    setResetHome(true);
    e();
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bmot.a();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_Bmot.c(this.jdField_a_of_type_Bmor.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_Bmot.a(getScrollX(), getScrollY(), this.jdField_a_of_type_Bmor.a())) {
      a(this.jdField_a_of_type_Bmot.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.jdField_a_of_type_Bmot.a(this.jdField_a_of_type_Bmor.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bmot.d(paramValueAnimator.getAnimatedFraction());
    a((bmoq)paramValueAnimator.getAnimatedValue());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas, true);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      this.jdField_a_of_type_Bmot.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bmot.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bmot.d();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Bmot.e();
    wtb.b("0X800A9AB");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return a(paramMotionEvent);
      removeCallbacks(this);
      continue;
      postDelayed(this, 1000L);
    }
  }
  
  public void run()
  {
    if (!a()) {
      postDelayed(this, 400L);
    }
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setCropListener(bmov parambmov)
  {
    this.jdField_a_of_type_Bmov = parambmov;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Bmot.a(this);
    this.jdField_a_of_type_Bmot.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */