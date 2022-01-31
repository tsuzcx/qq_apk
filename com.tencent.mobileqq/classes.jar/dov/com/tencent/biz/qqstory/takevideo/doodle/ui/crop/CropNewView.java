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
import bkdg;
import bkdh;
import bkdj;
import bkdl;
import bkdm;
import com.tencent.TMG.utils.QLog;
import vej;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private int jdField_a_of_type_Int;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private bkdh jdField_a_of_type_Bkdh;
  private bkdj jdField_a_of_type_Bkdj = new bkdj();
  private bkdl jdField_a_of_type_Bkdl;
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new bkdm(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_Bkdj.a();
    paramCanvas.rotate(this.jdField_a_of_type_Bkdj.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_Bkdj.a(paramCanvas);
    this.jdField_a_of_type_Bkdj.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_Bkdj.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(bkdg parambkdg)
  {
    this.jdField_a_of_type_Bkdj.c(parambkdg.c);
    this.jdField_a_of_type_Bkdj.b(parambkdg.d);
    if (!a(Math.round(parambkdg.a), Math.round(parambkdg.b))) {
      invalidate();
    }
  }
  
  private void a(bkdg parambkdg1, bkdg parambkdg2)
  {
    if (this.jdField_a_of_type_Bkdh == null)
    {
      this.jdField_a_of_type_Bkdh = new bkdh();
      this.jdField_a_of_type_Bkdh.addUpdateListener(this);
      this.jdField_a_of_type_Bkdh.addListener(this);
    }
    this.jdField_a_of_type_Bkdh.a(parambkdg1, parambkdg2);
    this.jdField_a_of_type_Bkdh.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    bkdg localbkdg = this.jdField_a_of_type_Bkdj.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localbkdg != null)
    {
      if ((this.jdField_a_of_type_Bkdl != null) && (!this.b))
      {
        this.jdField_a_of_type_Bkdl.c();
        setCrop(true);
      }
      a(localbkdg);
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
    bkdg localbkdg1 = this.jdField_a_of_type_Bkdj.b(getScrollX(), getScrollY());
    bkdg localbkdg2 = this.jdField_a_of_type_Bkdj.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localbkdg2.a = 0.0F;
      localbkdg2.b = 0.0F;
    }
    a(localbkdg1, localbkdg2);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bkdh != null) {
      this.jdField_a_of_type_Bkdh.cancel();
    }
  }
  
  public Bitmap a()
  {
    float f = 1.0F / this.jdField_a_of_type_Bkdj.c();
    RectF localRectF = new RectF(this.jdField_a_of_type_Bkdj.a());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_Bkdj.b(), localRectF.centerX(), localRectF.centerY());
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
    this.jdField_a_of_type_Bkdj.c();
    e();
    setCrop(false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bkdl != null) {
      this.jdField_a_of_type_Bkdl.a(paramInt);
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
      this.jdField_a_of_type_Bkdj.d(getScrollX(), getScrollY());
      e();
      if (this.jdField_a_of_type_Bkdl != null) {
        this.jdField_a_of_type_Bkdl.c();
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
      this.jdField_a_of_type_Bkdj.b(paramMotionEvent.getX(), paramMotionEvent.getY());
      a(1);
      return bool;
    }
    this.jdField_a_of_type_Bkdj.c(getScrollX(), getScrollY());
    a(2);
    e();
    return bool;
  }
  
  public void b()
  {
    if (!b())
    {
      this.jdField_a_of_type_Bkdj.a(-90);
      e();
    }
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_Bkdh != null) && (this.jdField_a_of_type_Bkdh.isRunning());
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bkdj.b();
    this.jdField_a_of_type_Bkdj.b(true);
    setResetHome(true);
    e();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_Bkdj.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_Bkdj.b(true);
    setResetHome(true);
    e();
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bkdj.a();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_Bkdj.c(this.jdField_a_of_type_Bkdh.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_Bkdj.a(getScrollX(), getScrollY(), this.jdField_a_of_type_Bkdh.a())) {
      a(this.jdField_a_of_type_Bkdj.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.jdField_a_of_type_Bkdj.a(this.jdField_a_of_type_Bkdh.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Bkdj.d(paramValueAnimator.getAnimatedFraction());
    a((bkdg)paramValueAnimator.getAnimatedValue());
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
      this.jdField_a_of_type_Bkdj.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bkdj.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_Bkdj.d();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Bkdj.e();
    vej.b("0X800A9AB");
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
  
  public void setCropListener(bkdl parambkdl)
  {
    this.jdField_a_of_type_Bkdl = parambkdl;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Bkdj.a(this);
    this.jdField_a_of_type_Bkdj.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */