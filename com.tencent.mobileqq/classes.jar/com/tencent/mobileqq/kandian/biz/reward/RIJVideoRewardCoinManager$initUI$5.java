package com.tencent.mobileqq.kandian.biz.reward;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJVideoRewardCoinManager$initUI$5
  implements View.OnClickListener
{
  RIJVideoRewardCoinManager$initUI$5(RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager) {}
  
  public final void onClick(View paramView)
  {
    if (RIJVideoRewardCoinManager.a(this.a))
    {
      paramView = RIJVideoRewardCoinManager.a(this.a);
      if (paramView != null) {
        paramView.a("投币中，请稍等～", RIJVideoRewardCoinManager.a(this.a));
      }
    }
    int i = RIJVideoRewardCoinManager.a.a(RIJVideoRewardCoinManager.b(this.a));
    paramView = RIJVideoRewardCoinManager.a(this.a);
    if (paramView != null)
    {
      if (!TextUtils.isEmpty((CharSequence)paramView.b()))
      {
        RIJVideoRewardCoinManager.a(this.a, true);
        Object localObject = this.a;
        RIJVideoRewardCoinManager.b((RIJVideoRewardCoinManager)localObject, RIJVideoRewardCoinManager.b((RIJVideoRewardCoinManager)localObject));
        localObject = ReadInJoyLogicEngine.a();
        String str = paramView.b();
        long l;
        if (str != null) {
          l = Long.parseLong(str);
        } else {
          l = 0L;
        }
        ((ReadInJoyLogicEngine)localObject).a(l, i, paramView.a(), null);
        return;
      }
      paramView = RIJVideoRewardCoinManager.a(this.a);
      if (paramView != null) {
        paramView.a(false, "投币失败", RIJVideoRewardCoinManager.b(this.a), RIJVideoRewardCoinManager.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.initUI.5
 * JD-Core Version:    0.7.0.1
 */