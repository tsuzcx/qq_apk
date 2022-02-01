package com.tencent.mobileqq.troopgift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopInteractGiftAnimationController$1$1$1
  implements View.OnClickListener
{
  TroopInteractGiftAnimationController$1$1$1(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.b.this$0.d();
    Object localObject = this.a.b.this$0;
    ((TroopInteractGiftAnimationController)localObject).f += 1;
    if (this.a.b.this$0.g)
    {
      this.a.b.this$0.g = false;
      this.a.b.this$0.a(this.a.b.b, this.a.b.b.frienduin, this.a.b.b.interactId, this.a.b.b.animationPackageId, this.a.b.this$0.f, false);
    }
    if (this.a.b.this$0.f % 5 == 0)
    {
      localObject = this.a.b.this$0.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.b.b.animationPackageId);
      localStringBuilder.append("");
      ((TroopGiftActionButton)localObject).a(localStringBuilder.toString());
    }
    ReportController.b(null, "dc00899", "Grp_flower", "", "inter_gift", "clk_ball", 0, 0, this.a.b.b.frienduin, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1.1
 * JD-Core Version:    0.7.0.1
 */