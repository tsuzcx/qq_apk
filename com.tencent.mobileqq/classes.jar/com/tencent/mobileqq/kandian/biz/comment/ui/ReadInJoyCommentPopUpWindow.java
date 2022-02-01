package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;

public class ReadInJoyCommentPopUpWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int b = Color.parseColor("#376099");
  protected Activity a;
  private boolean c;
  private ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener d;
  private View e;
  private ReadinjoyCommentListBaseAdapter f;
  
  private void a()
  {
    if (this.e != null)
    {
      this.a.getWindowManager().removeView(this.e);
      this.e = null;
    }
  }
  
  public void onClick(View paramView)
  {
    this.c = false;
    dismiss();
    int i = paramView.getId();
    if ((i != 2131430713) && (i == 2131430715)) {
      i = 2;
    } else {
      i = 3;
    }
    paramView = this.d;
    if (paramView != null) {
      paramView.c(i);
    }
    paramView = this.f;
    if (paramView != null)
    {
      paramView.c();
      if (i == 3)
      {
        paramView = this.f;
        if ((paramView instanceof ReadInJoyCommentListAdapter)) {
          ((ReadInJoyCommentListAdapter)paramView).k();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentPopUpWindow
 * JD-Core Version:    0.7.0.1
 */