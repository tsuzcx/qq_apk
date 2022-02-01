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
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.CropHomeing;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.CropHomingAnimator;

public class CropNewView
  extends View
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, ScaleGestureDetector.OnScaleGestureListener, Runnable
{
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private CropHomingAnimator jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator;
  private CropNewImage jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage = new CropNewImage();
  private CropNewView.CropListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
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
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new CropNewView.MoveAdapter(this, null));
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    paramCanvas.save();
    RectF localRectF = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a();
    paramCanvas.rotate(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(), localRectF.centerX(), localRectF.centerY());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(paramCanvas);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(paramCanvas, getScrollX(), getScrollY());
      paramCanvas.restore();
    }
  }
  
  private void a(CropHomeing paramCropHomeing)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c(paramCropHomeing.c);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(paramCropHomeing.d);
    if (!a(Math.round(paramCropHomeing.a), Math.round(paramCropHomeing.b))) {
      invalidate();
    }
  }
  
  private void a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator = new CropHomingAnimator();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.addUpdateListener(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.addListener(this);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.a(paramCropHomeing1, paramCropHomeing2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.start();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    CropHomeing localCropHomeing = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY(), -paramFloat1, -paramFloat2);
    if (localCropHomeing != null)
    {
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener != null) && (!this.b))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener.b();
        setCrop(true);
      }
      a(localCropHomeing);
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
    CropHomeing localCropHomeing1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(getScrollX(), getScrollY());
    CropHomeing localCropHomeing2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c(getScrollX(), getScrollY());
    if (this.jdField_a_of_type_Boolean)
    {
      setResetHome(false);
      localCropHomeing2.a = 0.0F;
      localCropHomeing2.b = 0.0F;
    }
    a(localCropHomeing1, localCropHomeing2);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.cancel();
    }
  }
  
  public Bitmap a()
  {
    float f = 1.0F / this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c();
    RectF localRectF = new RectF(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a());
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(), localRectF.centerX(), localRectF.centerY());
    ((Matrix)localObject).mapRect(localRectF);
    ((Matrix)localObject).setScale(f, f, localRectF.left, localRectF.top);
    ((Matrix)localObject).mapRect(localRectF);
    int i = Math.round(localRectF.width());
    int j = Math.round(localRectF.height());
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    localObject = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.translate(-localRectF.left, -localRectF.top);
    localCanvas.scale(f, f, localRectF.left, localRectF.top);
    a(localCanvas, false);
    return localObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c();
    e();
    setCrop(false);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener.a(paramInt);
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.d(getScrollX(), getScrollY());
      e();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener.b();
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
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(paramMotionEvent.getX(), paramMotionEvent.getY());
      a(1);
      return bool;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c(getScrollX(), getScrollY());
    a(2);
    e();
    return bool;
  }
  
  public void b()
  {
    if (!b())
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(-90);
      e();
    }
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.isRunning());
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(true);
    setResetHome(true);
    e();
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(true);
    setResetHome(true);
    e();
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a();
    e();
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationCancel!");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.a());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationEnd!");
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.a())) {
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(getScrollX(), getScrollY()));
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CropNewView", 0, "onAnimationStart!");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiAnimationCropHomingAnimator.a());
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.d(paramValueAnimator.getAnimatedFraction());
    a((CropHomeing)paramValueAnimator.getAnimatedValue());
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas, true);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.b(paramScaleGestureDetector.getScaleFactor(), getScrollX() + paramScaleGestureDetector.getFocusX(), getScrollY() + paramScaleGestureDetector.getFocusY());
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.jdField_a_of_type_Int > 1)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.d();
      return true;
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.e();
    VideoEditReport.b("0X800A9AB");
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
  
  public void setCropListener(CropNewView.CropListener paramCropListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewView$CropListener = paramCropListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiCropCropNewImage.a(paramBitmap);
    setResetHome(false);
    setCrop(false);
    invalidate();
  }
  
  public void setResetHome(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropNewView
 * JD-Core Version:    0.7.0.1
 */