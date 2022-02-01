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
    switch (this.a)
    {
    default: 
      ShortVideoCommentsView.b(this.this$0).setVisibility(8);
      ShortVideoCommentsView.a(this.this$0).setVisibility(8);
      return;
    case 0: 
      ShortVideoCommentsView.a(this.this$0).setVisibility(8);
      ShortVideoCommentsView.b(this.this$0).setVisibility(0);
      return;
    }
    ShortVideoCommentsView.b(this.this$0).setVisibility(8);
    if ((ShortVideoCommentsView.a(this.this$0) != null) && (ShortVideoCommentsView.a(this.this$0).a != 4)) {
      ShortVideoCommentsView.a(this.this$0).setVisibility(0);
    }
    ShortVideoCommentsView.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.BottomAreaRunnable
 * JD-Core Version:    0.7.0.1
 */