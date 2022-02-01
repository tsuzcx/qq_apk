package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class MutilayoutSlideDetectListView
  extends SlideDetectListView
{
  public MutilayoutSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View a(View paramView)
  {
    if ((paramView instanceof ShaderAnimLayout)) {
      return paramView;
    }
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          View localView = a(paramView.getChildAt(i));
          if ((localView instanceof ShaderAnimLayout)) {
            return localView;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public int a(View paramView)
  {
    paramView = (View)paramView.getParent();
    int i = paramView.getTop();
    while (paramView != this.jdField_a_of_type_AndroidViewView)
    {
      paramView = (View)paramView.getParent();
      i += paramView.getTop();
    }
    return i;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector == null)
    {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener, new Handler(Looper.getMainLooper()));
      this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 1) {
        this.b = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
      this.jdField_e_of_type_Boolean = false;
      i = a(this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (a(i) == this.jdField_a_of_type_AndroidViewView))
      {
        if (paramMotionEvent.getX() >= this.jdField_a_of_type_AndroidViewView.getWidth() - this.d)
        {
          if ((this.jdField_e_of_type_Int > 0) && (this.jdField_a_of_type_AndroidViewView.getHeight() > 0))
          {
            Object localObject = a(this.jdField_a_of_type_AndroidViewView);
            if (localObject != null)
            {
              View localView = (View)((View)localObject).getParent();
              i = a((View)localObject) + localView.getHeight() / 2;
              int j = this.jdField_e_of_type_Int / 2;
              int k = this.jdField_e_of_type_Int / 2;
              if ((this.jdField_a_of_type_Int <= j + i) && (this.jdField_a_of_type_Int >= i - k)) {
                break label319;
              }
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("accurate in delete:ycenter:");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append(",motionheight:");
                ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidViewView.getHeight());
                ((StringBuilder)localObject).append("deleareaHeight:");
                ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
                QLog.d("SlideDetectListView", 2, ((StringBuilder)localObject).toString());
              }
            }
            i = 0;
            break label321;
          }
          label319:
          i = 1;
          label321:
          if (i != 0)
          {
            this.jdField_e_of_type_Boolean = true;
            return false;
          }
        }
      }
      else if (this.jdField_a_of_type_Boolean == true) {
        return true;
      }
    }
    if (this.jdField_e_of_type_Boolean == true) {
      return false;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_Boolean == true) {
        return true;
      }
      if (this.b) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutilayoutSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */