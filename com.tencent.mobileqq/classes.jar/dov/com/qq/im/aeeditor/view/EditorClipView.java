package dov.com.qq.im.aeeditor.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import blqb;
import blqd;
import blqe;
import blqf;
import blqg;
import bmtc;
import bmtd;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class EditorClipView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private blqb jdField_a_of_type_Blqb = new blqb();
  private blqd jdField_a_of_type_Blqd;
  private blqe jdField_a_of_type_Blqe;
  private blqf jdField_a_of_type_Blqf;
  private bmtd jdField_a_of_type_Bmtd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  
  public EditorClipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditorClipView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new blqg(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.drawColor(getContext().getResources().getColor(2131165218));
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Blqb.a();
    paramCanvas.rotate(this.jdField_a_of_type_Blqb.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Blqb.a(paramCanvas);
    this.jdField_a_of_type_Blqb.a(paramCanvas, getScrollX(), getScrollY());
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Blqb.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(bmtc parambmtc)
  {
    this.jdField_a_of_type_Blqb.c(parambmtc.c);
    this.jdField_a_of_type_Blqb.b(parambmtc.d);
    if (!a(Math.round(parambmtc.a), Math.round(parambmtc.b))) {
      invalidate();
    }
  }
  
  private void a(bmtc parambmtc1, bmtc parambmtc2)
  {
    if (this.jdField_a_of_type_Bmtd == null)
    {
      this.jdField_a_of_type_Bmtd = new bmtd();
      this.jdField_a_of_type_Bmtd.addUpdateListener(this);
      this.jdField_a_of_type_Bmtd.addListener(this);
    }
    this.jdField_a_of_type_Bmtd.a(parambmtc1, parambmtc2);
    this.jdField_a_of_type_Bmtd.start();
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
  
  private void c()
  {
    invalidate();
    d();
    bmtc localbmtc1 = this.jdField_a_of_type_Blqb.b(getScrollX(), getScrollY());
    bmtc localbmtc2 = this.jdField_a_of_type_Blqb.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localbmtc2.a = 0.0F;
      localbmtc2.b = 0.0F;
    }
    a(localbmtc1, localbmtc2);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmtd != null) {
      this.jdField_a_of_type_Bmtd.cancel();
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Blqb.b();
  }
  
  public EditorPicInfo a()
  {
    return a(this.jdField_a_of_type_Blqb.b(), this.jdField_a_of_type_Blqb.a());
  }
  
  public EditorPicInfo a(RectF paramRectF1, RectF paramRectF2)
  {
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    float f1 = paramRectF1.width();
    float f2 = paramRectF1.height();
    float f3 = paramRectF2.width();
    float f4 = paramRectF2.height();
    localEditorPicInfo.x = ((paramRectF2.left - paramRectF1.left) / f1);
    localEditorPicInfo.y = ((paramRectF2.top - paramRectF1.top) / f2);
    localEditorPicInfo.w = (f3 / f1);
    localEditorPicInfo.h = (f4 / f2);
    return localEditorPicInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blqb.a();
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Blqf != null) {
      this.jdField_a_of_type_Blqf.a(paramInt);
    }
  }
  
  boolean a()
  {
    if (!b())
    {
      this.jdField_a_of_type_Blqb.c(getScrollX(), getScrollY());
      c();
      if (this.jdField_a_of_type_Blqf != null) {
        this.jdField_a_of_type_Blqf.a();
      }
      return true;
    }
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    bmtc localbmtc = this.jdField_a_of_type_Blqb.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localbmtc != null)
    {
      if ((this.jdField_a_of_type_Blqf != null) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Blqf.a();
        setCrop(true);
      }
      a(localbmtc);
      return true;
    }
    return a(getScrollX() + Math.round(paramFloat1), getScrollY() + Math.round(paramFloat2));
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    if (b()) {
      return false;
    }
    this.jdField_a_of_type_Int = paramMotionEvent.getPointerCount();
    boolean bool1 = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    boolean bool2 = b(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return bool1 | bool2;
      this.jdField_a_of_type_Blqb.a(paramMotionEvent.getX(), paramMotionEvent.getY(), false);
      a(1);
      continue;
      this.jdField_a_of_type_Blqb.b(getScrollX(), getScrollY());
      a(2);
      c();
    }
  }
  
  public RectF b()
  {
    return this.jdField_a_of_type_Blqb.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blqb.d();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Blqb.a(paramInt);
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_Bmtd != null) && (this.jdField_a_of_type_Bmtd.isRunning());
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Blqb.b(this.jdField_a_of_type_Bmtd.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Blqb.a(getScrollX(), getScrollY(), this.jdField_a_of_type_Bmtd.a())) {
      a(this.jdField_a_of_type_Blqb.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_Blqb.a(this.jdField_a_of_type_Bmtd.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Blqb.d(paramValueAnimator.getAnimatedFraction());
    a((bmtc)paramValueAnimator.getAnimatedValue());
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
    int i = (int)(paramInt3 - paramInt1 - 10.0F);
    if (this.jdField_b_of_type_Int != i)
    {
      if (this.jdField_a_of_type_Blqe != null) {
        this.jdField_a_of_type_Blqe.a(i);
      }
      this.jdField_b_of_type_Int = i;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Blqb.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Blqb.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Blqb.b();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Blqb.c();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Blqd != null) {
      this.jdField_a_of_type_Blqd.a();
    }
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
  
  public void setClipViewOperateListener(blqd paramblqd)
  {
    this.jdField_a_of_type_Blqd = paramblqd;
  }
  
  public void setClipWindowWidthChangeListener(blqe paramblqe)
  {
    this.jdField_a_of_type_Blqe = paramblqe;
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCropListener(blqf paramblqf)
  {
    this.jdField_a_of_type_Blqf = paramblqf;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Blqb.a(this);
    this.jdField_a_of_type_Blqb.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setRate(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.EditorClipView
 * JD-Core Version:    0.7.0.1
 */