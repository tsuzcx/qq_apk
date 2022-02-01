package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class ReadInJoyCommentComponentFragment$13
  implements View.OnClickListener
{
  ReadInJoyCommentComponentFragment$13(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131429562: 
      ReadInJoyCommentComponentFragment.n(this.a);
      if (ReadInJoyCommentComponentFragment.o(this.a) != null)
      {
        if (ReadInJoyCommentComponentFragment.p(this.a) >= ReadInJoyCommentComponentFragment.o(this.a).length) {
          ReadInJoyCommentComponentFragment.b(this.a, 0);
        }
        this.a.u.setText(ReadInJoyCommentComponentFragment.o(this.a)[ReadInJoyCommentComponentFragment.p(this.a)]);
        return;
      }
      break;
    case 2131429556: 
      ReadInJoyCommentComponentFragment.m(this.a);
      return;
    case 2131429555: 
      if (this.a.E)
      {
        ReadInJoyCommentComponentFragment.d(this.a, false);
        return;
      }
      ReadInJoyCommentComponentFragment.d(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.13
 * JD-Core Version:    0.7.0.1
 */