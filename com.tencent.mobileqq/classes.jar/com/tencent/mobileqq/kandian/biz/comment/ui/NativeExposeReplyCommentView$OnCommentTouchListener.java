package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class NativeExposeReplyCommentView$OnCommentTouchListener
  implements View.OnTouchListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  
  public NativeExposeReplyCommentView$OnCommentTouchListener(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return false;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849680));
        return false;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849653));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeExposeReplyCommentView.OnCommentTouchListener
 * JD-Core Version:    0.7.0.1
 */