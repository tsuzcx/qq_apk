package dov.com.qq.im.ae.camera.ui.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.util.AECommonUtil;
import dov.com.qq.im.ae.util.AEQLog;

public class AECircleBottomWrapLayout
  extends RelativeLayout
{
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public AECircleBottomWrapLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECircleBottomWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECircleBottomWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
    if ((Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > 100.0F) && (paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() < 100L) && (AECommonUtil.a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent)) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367155);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)findViewById(2131377419));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
    {
      AEQLog.a("AECircleBottomLayout", "in onInterceptTouchEvent true.");
      paramMotionEvent.setAction(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.dispatchTouchEvent(paramMotionEvent);
      this.b = false;
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleBottomWrapLayout
 * JD-Core Version:    0.7.0.1
 */