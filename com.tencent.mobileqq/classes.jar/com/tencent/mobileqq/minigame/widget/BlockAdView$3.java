package com.tencent.mobileqq.minigame.widget;

import android.animation.AnimatorSet;

class BlockAdView$3
  implements Runnable
{
  BlockAdView$3(BlockAdView paramBlockAdView) {}
  
  public void run()
  {
    if (!BlockAdView.access$100(this.this$0))
    {
      if (BlockAdView.access$200(this.this$0) == 0) {
        BlockAdView.access$300(this.this$0).setStartDelay(1000L);
      } else if (BlockAdView.access$200(this.this$0) % 3 == 0) {
        BlockAdView.access$300(this.this$0).setStartDelay(2520L);
      } else {
        BlockAdView.access$300(this.this$0).setStartDelay(520L);
      }
      BlockAdView.access$300(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.3
 * JD-Core Version:    0.7.0.1
 */