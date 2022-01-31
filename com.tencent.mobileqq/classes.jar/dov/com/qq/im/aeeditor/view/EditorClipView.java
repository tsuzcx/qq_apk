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
import bllp;
import bllr;
import blls;
import bllt;
import bllu;
import bmoq;
import bmor;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;

public class EditorClipView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private bllp jdField_a_of_type_Bllp = new bllp();
  private bllr jdField_a_of_type_Bllr;
  private blls jdField_a_of_type_Blls;
  private bllt jdField_a_of_type_Bllt;
  private bmor jdField_a_of_type_Bmor;
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new bllu(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.drawColor(getContext().getResources().getColor(2131165218));
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Bllp.a();
    paramCanvas.rotate(this.jdField_a_of_type_Bllp.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Bllp.a(paramCanvas);
    this.jdField_a_of_type_Bllp.a(paramCanvas, getScrollX(), getScrollY());
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Bllp.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(bmoq parambmoq)
  {
    this.jdField_a_of_type_Bllp.c(parambmoq.c);
    this.jdField_a_of_type_Bllp.b(parambmoq.d);
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
    bmoq localbmoq1 = this.jdField_a_of_type_Bllp.b(getScrollX(), getScrollY());
    bmoq localbmoq2 = this.jdField_a_of_type_Bllp.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localbmoq2.a = 0.0F;
      localbmoq2.b = 0.0F;
    }
    a(localbmoq1, localbmoq2);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bmor != null) {
      this.jdField_a_of_type_Bmor.cancel();
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Bllp.b();
  }
  
  public EditorPicInfo a()
  {
    return a(this.jdField_a_of_type_Bllp.b(), this.jdField_a_of_type_Bllp.a());
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
    this.jdField_a_of_type_Bllp.a();
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bllt != null) {
      this.jdField_a_of_type_Bllt.a(paramInt);
    }
  }
  
  boolean a()
  {
    if (!b())
    {
      this.jdField_a_of_type_Bllp.c(getScrollX(), getScrollY());
      c();
      if (this.jdField_a_of_type_Bllt != null) {
        this.jdField_a_of_type_Bllt.a();
      }
      return true;
    }
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    bmoq localbmoq = this.jdField_a_of_type_Bllp.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localbmoq != null)
    {
      if ((this.jdField_a_of_type_Bllt != null) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_Bllt.a();
        setCrop(true);
      }
      a(localbmoq);
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
      this.jdField_a_of_type_Bllp.a(paramMotionEvent.getX(), paramMotionEvent.getY(), false);
      a(1);
      continue;
      this.jdField_a_of_type_Bllp.b(getScrollX(), getScrollY());
      a(2);
      c();
    }
  }
  
  public RectF b()
  {
    return this.jdField_a_of_type_Bllp.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bllp.d();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bllp.a(paramInt);
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_Bmor != null) && (this.jdField_a_of_type_Bmor.isRunning());
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bllp.b(this.jdField_a_of_type_Bmor.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Bllp.a(getScrollX(), getScrollY(), this.jdField_a_of_type_Bmor.a())) {
      a(this.jdField_a_of_type_Bllp.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bllp.a(this.jdField_a_of_type_Bmor.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bllp.d(paramValueAnimator.getAnimatedFraction());
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
    int i = (int)(paramInt3 - paramInt1 - 10.0F);
    if (this.jdField_b_of_type_Int != i)
    {
      if (this.jdField_a_of_type_Blls != null) {
        this.jdField_a_of_type_Blls.a(i);
      }
      this.jdField_b_of_type_Int = i;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Bllp.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bllp.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bllp.b();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Bllp.c();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bllr != null) {
      this.jdField_a_of_type_Bllr.a();
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
  
  public void setClipViewOperateListener(bllr parambllr)
  {
    this.jdField_a_of_type_Bllr = parambllr;
  }
  
  public void setClipWindowWidthChangeListener(blls paramblls)
  {
    this.jdField_a_of_type_Blls = paramblls;
  }
  
  public void setCrop(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCropListener(bllt parambllt)
  {
    this.jdField_a_of_type_Bllt = parambllt;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Bllp.a(this);
    this.jdField_a_of_type_Bllp.a(paramBitmap);
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