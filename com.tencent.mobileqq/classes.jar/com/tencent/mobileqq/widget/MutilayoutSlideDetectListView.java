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
    label88:
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.jdField_e_of_type_Boolean == true)
        {
          return false;
          this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
          this.jdField_e_of_type_Boolean = false;
          i = a(this.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_AndroidViewView != null) && (a(i) == this.jdField_a_of_type_AndroidViewView))
          {
            if (paramMotionEvent.getX() < this.jdField_a_of_type_AndroidViewView.getWidth() - this.d) {
              continue;
            }
            if ((this.jdField_e_of_type_Int <= 0) || (this.jdField_a_of_type_AndroidViewView.getHeight() <= 0)) {
              break label372;
            }
            View localView1 = a(this.jdField_a_of_type_AndroidViewView);
            if (localView1 != null)
            {
              View localView2 = (View)localView1.getParent();
              i = a(localView1);
              i = localView2.getHeight() / 2 + i;
              int j = this.jdField_e_of_type_Int / 2;
              int k = this.jdField_e_of_type_Int / 2;
              if ((this.jdField_a_of_type_Int <= j + i) && (this.jdField_a_of_type_Int >= i - k)) {
                break label372;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.jdField_a_of_type_AndroidViewView.getHeight() + "deleareaHeight:" + this.jdField_e_of_type_Int);
              }
              i = 0;
            }
          }
        }
      }
    }
    while (i != 0)
    {
      this.jdField_e_of_type_Boolean = true;
      return false;
      i = 0;
      continue;
      if (this.jdField_a_of_type_Boolean != true) {
        break;
      }
      return true;
      this.b = false;
      break;
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Boolean == true)) {
        return true;
      }
      if (this.b) {
        break label88;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      label372:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutilayoutSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */