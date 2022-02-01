package dov.com.qq.im.aeeditor.view.timebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.annotation.RequiresApi;
import bmov;
import bmow;
import bmox;
import bmoz;

public class ScaleView
  extends View
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new bmov(this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private bmow jdField_a_of_type_Bmow;
  private bmox jdField_a_of_type_Bmox;
  public bmoz a;
  private ScaleView.MotionModel jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
  private int b;
  private int c;
  
  public ScaleView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    paramInt1 -= paramInt2;
    if (paramInt1 > 0)
    {
      paramInt2 = a();
      if (getScrollX() + paramInt1 - paramInt2 > 0) {}
    }
    while (getScrollX() + paramInt1 >= 0)
    {
      return paramInt1;
      return 0;
    }
    return 0;
  }
  
  private int a(long paramLong)
  {
    return (int)(this.jdField_a_of_type_Bmoz.a() * this.jdField_a_of_type_Bmoz.a(paramLong));
  }
  
  private long a()
  {
    if (a() == getScrollX()) {
      return this.jdField_a_of_type_Bmoz.b();
    }
    return this.jdField_a_of_type_Bmoz.c();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(getContext(), this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.b = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(500);
    int i = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    if ((Math.abs(i) > this.b) && (Math.abs(i) < this.c))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.FlingScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.fling(paramInt1, paramInt2, -i, 0, 0, a(), 0, getHeight());
      awakenScrollBars(this.jdField_a_of_type_AndroidWidgetScroller.getDuration());
      invalidate();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bmoz != null) {
        this.jdField_a_of_type_Bmoz.a();
      }
    } while (this.jdField_a_of_type_Bmow == null);
    this.jdField_a_of_type_Bmow.b(getScrollX());
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Down;
    this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
  }
  
  private void b()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Zoom;
    this.jdField_a_of_type_Long = a();
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel != ScaleView.MotionModel.Zoom) && ((this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Down) || (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Move)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Move;
      int i = (int)paramMotionEvent.getX();
      scrollBy(a(this.jdField_a_of_type_Int, i), 0);
      this.jdField_a_of_type_Int = i;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bmox != null) {
      this.jdField_a_of_type_Bmox.a();
    }
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
    int i = getScrollX();
    int j = getScrollY();
    if (i < 0)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.ComputeScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, -i, -j);
      return;
    }
    if (i > a())
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.ComputeScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, a() - i, -j);
      return;
    }
    a(i, j);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    scrollTo(a(this.jdField_a_of_type_Long), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bmoz.a(this.jdField_a_of_type_Bmoz.b());
  }
  
  public void a(long paramLong)
  {
    int i = this.jdField_a_of_type_Bmoz.a(paramLong);
    int j = getScrollX();
    int k = getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, k, i - j, -k, 0);
    postInvalidate();
  }
  
  @RequiresApi(api=16)
  public void a(long paramLong, int paramInt)
  {
    int i = this.jdField_a_of_type_Bmoz.a(paramLong);
    int j = getScrollX();
    int k = getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, k, i - j, -k, paramInt);
    postInvalidateOnAnimation();
  }
  
  public void a(bmoz parambmoz)
  {
    setScaleAdapter(parambmoz, a());
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        while (this.jdField_a_of_type_Bmoz == null)
        {
          return;
          if ((this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.ComputeScroll) || (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.FlingScroll)) {
            this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
          }
        }
        this.jdField_a_of_type_Bmoz.a();
      } while (this.jdField_a_of_type_Bmow == null);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.None)
      {
        this.jdField_a_of_type_Bmow.b(getScrollX());
        return;
      }
    } while ((this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel != ScaleView.MotionModel.Move) && (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel != ScaleView.MotionModel.FlingScroll));
    this.jdField_a_of_type_Bmow.a(getScrollX());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
      return true;
    }
    c(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
      return true;
    case 0: 
      a(paramMotionEvent);
      return true;
    case 5: 
      b();
      return true;
    case 2: 
      b(paramMotionEvent);
      return true;
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Zoom)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
      return true;
    }
    c();
    return true;
  }
  
  public void setCurrTime(long paramLong)
  {
    if (paramLong < this.jdField_a_of_type_Bmoz.a()) {}
    while (paramLong > this.jdField_a_of_type_Bmoz.b()) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    d();
    this.jdField_a_of_type_Bmoz.a();
    postInvalidate();
  }
  
  public void setMoveByUserListener(bmox parambmox)
  {
    this.jdField_a_of_type_Bmox = parambmox;
  }
  
  public void setOnBarMoveListener(bmow parambmow)
  {
    this.jdField_a_of_type_Bmow = parambmow;
  }
  
  public void setScaleAdapter(bmoz parambmoz)
  {
    this.jdField_a_of_type_Bmoz = parambmoz;
    this.jdField_a_of_type_Bmoz.a(this);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bmoz.a();
  }
  
  public void setScaleAdapter(bmoz parambmoz, long paramLong)
  {
    this.jdField_a_of_type_Bmoz = parambmoz;
    this.jdField_a_of_type_Bmoz.a(this);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bmoz.a();
    setCurrTime(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timebar.ScaleView
 * JD-Core Version:    0.7.0.1
 */