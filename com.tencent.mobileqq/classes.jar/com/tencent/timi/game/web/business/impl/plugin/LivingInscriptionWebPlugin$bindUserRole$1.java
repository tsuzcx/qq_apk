package com.tencent.timi.game.web.business.impl.plugin;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class LivingInscriptionWebPlugin$bindUserRole$1
  implements Runnable
{
  LivingInscriptionWebPlugin$bindUserRole$1(QBaseActivity paramQBaseActivity, LivingInscriptionWebPlugin.bindUserRole.bindListener.1 param1) {}
  
  public final void run()
  {
    QBaseActivity localQBaseActivity = this.a;
    if (localQBaseActivity != null) {
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(localQBaseActivity, true, null, (IUserSmobaInfoService.BindSmobaAccountCallback)this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin.bindUserRole.1
 * JD-Core Version:    0.7.0.1
 */