package com.tencent.mobileqq.nearby.now.view;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class ShortVideoCommentsView$BottomAreaRunnable
  implements Runnable
{
  private int a = 2;
  
  ShortVideoCommentsView$BottomAreaRunnable(ShortVideoCommentsView paramShortVideoCommentsView, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        ShortVideoCommentsView.access$2800(this.this$0).setVisibility(8);
        ShortVideoCommentsView.access$2700(this.this$0).setVisibility(8);
        return;
      }
      ShortVideoCommentsView.access$2800(this.this$0).setVisibility(8);
      if ((ShortVideoCommentsView.access$000(this.this$0) != null) && (ShortVideoCommentsView.access$000(this.this$0).b != 4)) {
        ShortVideoCommentsView.access$2700(this.this$0).setVisibility(0);
      }
      ShortVideoCommentsView.access$2900(this.this$0);
      return;
    }
    ShortVideoCommentsView.access$2700(this.this$0).setVisibility(8);
    ShortVideoCommentsView.access$2800(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.BottomAreaRunnable
 * JD-Core Version:    0.7.0.1
 */