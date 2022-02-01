package com.tencent.mobileqq.vas.troopgift;

import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.Loader;
import com.tencent.mobileqq.vas.ui.PagViewProxy;
import com.tencent.mobileqq.vas.ui.PagViewProxy.Companion;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AbsTroopGiftController$startAnimation$1
  implements Runnable
{
  AbsTroopGiftController$startAnimation$1(AbsTroopGiftController paramAbsTroopGiftController) {}
  
  public final void run()
  {
    synchronized (this.this$0.m())
    {
      QLog.d(this.this$0.b(), 2, "startAnimation");
      AbsTroopGiftController.a(this.this$0, PagViewProxy.d.b().a());
      this.this$0.a();
      AbsTroopGiftController.b(this.this$0);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.AbsTroopGiftController.startAnimation.1
 * JD-Core Version:    0.7.0.1
 */