package com.tencent.mobileqq.minigame.widget;

import android.animation.AnimatorSet;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;

class BlockAdView$1
  implements Runnable
{
  BlockAdView$1(BlockAdView paramBlockAdView) {}
  
  public void run()
  {
    try
    {
      if (BlockAdView.access$100(this.this$0)) {
        break label182;
      }
      if (BlockAdView.access$200(this.this$0) == 0) {
        BlockAdView.access$300(this.this$0).setStartDelay(1000L);
      } else if (BlockAdView.access$200(this.this$0) % (BlockAdView.access$400(this.this$0) * 2) == 0) {
        BlockAdView.access$300(this.this$0).setStartDelay(BlockAdView.access$400(this.this$0) * 600);
      } else {
        BlockAdView.access$300(this.this$0).setStartDelay(120L);
      }
      int i = BlockAdView.access$200(this.this$0) % BlockAdView.access$400(this.this$0);
      if ((BlockAdView.access$500(this.this$0).size() <= 0) || (BlockAdView.access$500(this.this$0).size() <= i)) {
        break label182;
      }
      BlockAdView.SingleBlockAdView localSingleBlockAdView = (BlockAdView.SingleBlockAdView)BlockAdView.access$500(this.this$0).get(i);
      BlockAdView.access$300(this.this$0).setTarget(localSingleBlockAdView);
      BlockAdView.access$300(this.this$0).start();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label174:
      label182:
      break label174;
    }
    QLog.e("[minigame]BlockAdView", 1, "catch IndexOutOfBoundsException during aniPlayMulti because of clear");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.1
 * JD-Core Version:    0.7.0.1
 */