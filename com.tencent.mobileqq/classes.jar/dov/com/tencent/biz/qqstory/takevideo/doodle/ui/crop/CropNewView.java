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
import boyh;
import boyi;
import boyk;
import boym;
import boyn;
import com.tencent.TMG.utils.QLog;
import ykw;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private boyi jdField_a_of_type_Boyi;
  private boyk jdField_a_of_type_Boyk = new boyk();
  private boym jdField_a_of_type_Boym;
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new boyn(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Boyk.a();
    paramCanvas.rotate(this.jdField_a_of_type_Boyk.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Boyk.a(paramCanvas);
    this.jdField_a_of_type_Boyk.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Boyk.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(boyh paramboyh)
  {
    this.jdField_a_of_type_Boyk.c(paramboyh.c);
    this.jdField_a_of_type_Boyk.b(paramboyh.d);
    if (!a(Math.round(paramboyh.a), Math.round(paramboyh.b))) {
      invalidate();
    }
  }
  
  private void a(boyh paramboyh1, boyh paramboyh2)
  {
    if (this.jdField_a_of_type_Boyi == null)
    {
      this.jdField_a_of_type_Boyi = new boyi();
      this.jdField_a_of_type_Boyi.addUpdateListener(this);
      this.jdField_a_of_type_Boyi.addListener(this);
    }
    this.jdField_a_of_type_Boyi.a(paramboyh1, paramboyh2);
    this.jdField_a_of_type_Boyi.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    boyh localboyh = this.jdField_a_of_type_Boyk.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localboyh != null)
    {
      if ((this.jdField_a_of_type_Boym != null) && (!this.b))
      {
        this.jdField_a_of_type_Boym.b();
        setCrop(true);
      }
      a(localboyh);
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
    boyh localboyh1 = this.jdField_a_of_type_Boyk.b(getScrollX(), getScrollY());
    boyh localboyh2 = this.jdField_a_of_type_Boyk.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localboyh2.a = 0.0F;
      localboyh2.b = 0.0F;
    }
    a(localboyh1, localboyh2);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Boyi != null) {
      this.jdField_a_of_type_Boyi.cancel();
    }
  }
  
  public Bitmap a()
  {
    float f = 1.0F / this.jdField_a_of_type_Boyk.c();
    RectF localRectF = new RectF(this.jdField_a_of_type_Boyk.a());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_Boyk.b(), localRectF.centerX(), localRectF.centerY());
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
    this.jdField_a_of_type_Boyk.c();
    e();
    setCrop(false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boym != null) {
      this.jdField_a_of_type_Boym.a(paramInt);
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
      this.jdField_a_of_type_Boyk.d(getScrollX(), getScrollY());
      e();
      if (this.jdField_a_of_type_Boym != null) {
        this.jdField_a_of_type_Boym.b();
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
      this.jdField_a_of_type_Boyk.b(paramMotionEvent.getX(), paramMotionEvent.getY());
      a(1);
      return bool;
    }
    this.jdField_a_of_type_Boyk.c(getScrollX(), getScrollY());
    a(2);
    e();
    return bool;
  }
  
  public void b()
  {
    if (!b())
    {
      this.jdField_a_of_type_Boyk.a(-90);
      e();
    }
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_Boyi != null) && (this.jdField_a_of_type_Boyi.isRunning());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boyk.b();
    this.jdField_a_of_type_Boyk.b(true);
    setResetHome(true);
    e();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_Boyk.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_Boyk.b(true);
    setResetHome(true);
    e();
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boyk.a();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_Boyk.c(this.jdField_a_of_type_Boyi.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_Boyk.a(getScrollX(), getScrollY(), this.jdField_a_of_type_Boyi.a())) {
      a(this.jdField_a_of_type_Boyk.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.jdField_a_of_type_Boyk.a(this.jdField_a_of_type_Boyi.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Boyk.d(paramValueAnimator.getAnimatedFraction());
    a((boyh)paramValueAnimator.getAnimatedValue());
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
      this.jdField_a_of_type_Boyk.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Boyk.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Boyk.d();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Boyk.e();
    ykw.b("0X800A9AB");
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
  
  public void setCropListener(boym paramboym)
  {
    this.jdField_a_of_type_Boym = paramboym;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boyk.a(this);
    this.jdField_a_of_type_Boyk.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */