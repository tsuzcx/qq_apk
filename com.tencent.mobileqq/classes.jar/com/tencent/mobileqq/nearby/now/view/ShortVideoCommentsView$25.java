package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.ListView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.model.Comments;
import java.util.List;

class ShortVideoCommentsView$25
  implements Runnable
{
  ShortVideoCommentsView$25(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void run()
  {
    int i = UITools.b(this.this$0.getContext());
    if (ShortVideoCommentsView.access$2400() * this.this$0.mComments.a.size() + ShortVideoCommentsView.access$2500(this.this$0).getMeasuredHeight() >= i)
    {
      ShortVideoCommentsView.access$1800(this.this$0).setSelectionFromTop(1, ShortVideoCommentsView.access$2400() + ShortVideoCommentsView.access$2500(this.this$0).getMeasuredHeight());
      return;
    }
    ShortVideoCommentsView.access$1800(this.this$0).setSelection(this.this$0.mComments.a.size() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.25
 * JD-Core Version:    0.7.0.1
 */