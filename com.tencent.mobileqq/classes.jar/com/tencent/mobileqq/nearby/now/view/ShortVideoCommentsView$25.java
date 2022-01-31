package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.nearby.now.model.Comments;
import java.util.List;
import muf;

class ShortVideoCommentsView$25
  implements Runnable
{
  ShortVideoCommentsView$25(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    int i = muf.b(this.this$0.getContext());
    if (ShortVideoCommentsView.a() * this.this$0.a.a.size() + ShortVideoCommentsView.b(this.this$0).getMeasuredHeight() >= i)
    {
      ShortVideoCommentsView.a(this.this$0).setSelectionFromTop(1, ShortVideoCommentsView.a() + ShortVideoCommentsView.b(this.this$0).getMeasuredHeight());
      return;
    }
    ShortVideoCommentsView.a(this.this$0).setSelection(this.this$0.a.a.size() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.25
 * JD-Core Version:    0.7.0.1
 */