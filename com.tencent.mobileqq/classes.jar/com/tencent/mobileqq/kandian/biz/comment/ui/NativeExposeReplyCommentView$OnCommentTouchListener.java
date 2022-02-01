package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class NativeExposeReplyCommentView$OnCommentTouchListener
  implements View.OnTouchListener
{
  private Context a;
  private View b;
  
  public NativeExposeReplyCommentView$OnCommentTouchListener(Context paramContext, View paramView)
  {
    this.a = paramContext;
    this.b = paramView;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return false;
        }
        this.b.setBackgroundDrawable(this.a.getResources().getDrawable(2130851385));
        return false;
      }
      this.b.setBackgroundDrawable(this.a.getResources().getDrawable(2130851358));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.NativeExposeReplyCommentView.OnCommentTouchListener
 * JD-Core Version:    0.7.0.1
 */