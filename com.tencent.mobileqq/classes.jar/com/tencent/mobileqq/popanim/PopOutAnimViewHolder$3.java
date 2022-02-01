package com.tencent.mobileqq.popanim;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

class PopOutAnimViewHolder$3
  implements Runnable
{
  PopOutAnimViewHolder$3(PopOutAnimViewHolder paramPopOutAnimViewHolder) {}
  
  public void run()
  {
    if (this.this$0.b.getParent() != null) {
      ((ViewGroup)this.this$0.b.getParent()).removeView(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutAnimViewHolder.3
 * JD-Core Version:    0.7.0.1
 */