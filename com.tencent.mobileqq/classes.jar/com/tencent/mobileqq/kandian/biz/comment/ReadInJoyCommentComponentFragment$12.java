package com.tencent.mobileqq.kandian.biz.comment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class ReadInJoyCommentComponentFragment$12
  implements View.OnClickListener
{
  ReadInJoyCommentComponentFragment$12(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363649: 
      ReadInJoyCommentComponentFragment.b(this.a);
      if (ReadInJoyCommentComponentFragment.a(this.a) != null)
      {
        if (ReadInJoyCommentComponentFragment.c(this.a) >= ReadInJoyCommentComponentFragment.a(this.a).length) {
          ReadInJoyCommentComponentFragment.a(this.a, 0);
        }
        this.a.c.setText(ReadInJoyCommentComponentFragment.a(this.a)[ReadInJoyCommentComponentFragment.c(this.a)]);
        return;
      }
      break;
    case 2131363643: 
      ReadInJoyCommentComponentFragment.c(this.a);
      return;
    case 2131363642: 
      if (this.a.b)
      {
        ReadInJoyCommentComponentFragment.a(this.a, false);
        return;
      }
      ReadInJoyCommentComponentFragment.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.12
 * JD-Core Version:    0.7.0.1
 */