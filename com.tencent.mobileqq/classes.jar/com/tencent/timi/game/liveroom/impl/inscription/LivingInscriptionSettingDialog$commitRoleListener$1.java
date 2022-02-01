package com.tencent.timi.game.liveroom.impl.inscription;

import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetAnchorGameEquipRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$commitRoleListener$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionSettingDialog$commitRoleListener$1
  implements IResultListener<GameDataServerOuterClass.SetAnchorGameEquipRoleRsp>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    CustomToastView.a("切换失败，请稍后重试");
    if (!LivingInscriptionSettingDialog.c(this.a)) {
      this.a.c();
    }
  }
  
  public void a(@Nullable GameDataServerOuterClass.SetAnchorGameEquipRoleRsp paramSetAnchorGameEquipRoleRsp)
  {
    CustomToastView.a("出装铭文设置成功");
    if (!LivingInscriptionSettingDialog.c(this.a))
    {
      this.a.c();
      paramSetAnchorGameEquipRoleRsp = this.a.a();
      if (paramSetAnchorGameEquipRoleRsp != null) {
        paramSetAnchorGameEquipRoleRsp.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog.commitRoleListener.1
 * JD-Core Version:    0.7.0.1
 */