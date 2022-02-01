package com.tencent.mobileqq.vas.troopgift;

import com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawRsp;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class StaffGiftController$startDrawNetwork$1$1
  implements Runnable
{
  StaffGiftController$startDrawNetwork$1$1(StaffGiftController.startDrawNetwork.1 param1, Object paramObject, String paramString) {}
  
  public final void run()
  {
    this.this$0.a.a(this.this$0.b, ((StaffGiftDrawBean.DrawRsp)this.a).isWin(), this.b);
    if (((StaffGiftDrawBean.DrawRsp)this.a).isWin())
    {
      StaffGiftController.a(this.this$0.a, true);
      this.this$0.a.f().getRuleManager().registerRuleLine("$SUCCESS_TEXT", new StaffGiftController.startDrawNetwork.1.1.1(this));
      this.this$0.c.invoke("show");
      return;
    }
    this.this$0.a.f().getRuleManager().registerRuleLine("$FAIL_TEXT", new StaffGiftController.startDrawNetwork.1.1.2(this));
    this.this$0.c.invoke("hide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.StaffGiftController.startDrawNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */