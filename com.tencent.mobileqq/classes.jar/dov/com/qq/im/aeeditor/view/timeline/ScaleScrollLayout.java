package dov.com.qq.im.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import bnrh;
import dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar;

public class ScaleScrollLayout
  extends RelativeLayout
{
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ScaleScrollLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleScrollLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleScrollLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Point a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public void a()
  {
    this.b = false;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    bnrh.a("MvCutFragment", paramMotionEvent.getAction() + "");
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
    if ((paramMotionEvent.getActionMasked() == 1) || (paramMotionEvent.getActionMasked() == 3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(0);
        this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(localMotionEvent);
        this.jdField_a_of_type_Boolean = true;
      }
      return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((paramMotionEvent.getPointerCount() > 1) && ((localView instanceof ScaleTimeBar))) {
        return localView.onTouchEvent(paramMotionEvent);
      }
      i += 1;
    }
    return true;
  }
  
  public void setHandleView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timeline.ScaleScrollLayout
 * JD-Core Version:    0.7.0.1
 */