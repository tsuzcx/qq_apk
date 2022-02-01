package com.tencent.mobileqq.kandian.biz.reward;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$showRewardCoinPopupWindow$2
  implements Runnable
{
  RIJVideoRewardCoinManager$showRewardCoinPopupWindow$2(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void run()
  {
    ImageView localImageView = RIJVideoRewardCoinManager.a(this.this$0);
    if (localImageView != null) {
      localImageView.setImageDrawable((Drawable)RIJVideoRewardCoinManager.a(this.this$0, "https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */