package com.tencent.mobileqq.kandian.biz.reward;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "popupWindow", "Lcom/tencent/mobileqq/kandian/biz/video/discovery/BubblePopupWindow;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJRewardVideoTipsManager$showRewardCoinGuide$1$1
  extends Lambda
  implements Function1<BubblePopupWindow, Unit>
{
  RIJRewardVideoTipsManager$showRewardCoinGuide$1$1(ViewGroup paramViewGroup)
  {
    super(1);
  }
  
  public final void invoke(@Nullable BubblePopupWindow paramBubblePopupWindow)
  {
    if (ReadInJoyHelper.b())
    {
      if (paramBubblePopupWindow != null) {
        paramBubblePopupWindow.d(21);
      }
    }
    else
    {
      if (paramBubblePopupWindow != null) {
        paramBubblePopupWindow.d(85);
      }
      if (paramBubblePopupWindow != null) {
        paramBubblePopupWindow.a(0, this.$it.getWidth() / 2 + ViewUtils.a(3.0F), 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager.showRewardCoinGuide.1.1
 * JD-Core Version:    0.7.0.1
 */