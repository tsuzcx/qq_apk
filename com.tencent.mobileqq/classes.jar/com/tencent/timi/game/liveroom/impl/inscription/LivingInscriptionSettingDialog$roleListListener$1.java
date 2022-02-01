package com.tencent.timi.game.liveroom.impl.inscription;

import android.view.View;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.utils.IResultListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorGameRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$roleListListener$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionSettingDialog$roleListListener$1
  implements IResultListener<GameDataServerOuterClass.GetAnchorGameRoleListRsp>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    if (!LivingInscriptionSettingDialog.c(this.a))
    {
      paramString = LivingInscriptionSettingDialog.d(this.a);
      if (paramString != null) {
        ViewExKt.a((View)paramString, true);
      }
    }
  }
  
  public void a(@Nullable GameDataServerOuterClass.GetAnchorGameRoleListRsp paramGetAnchorGameRoleListRsp)
  {
    if (!LivingInscriptionSettingDialog.c(this.a))
    {
      Object localObject = LivingInscriptionSettingDialog.d(this.a);
      boolean bool2 = true;
      if (localObject != null) {
        ViewExKt.a((View)localObject, true);
      }
      if (paramGetAnchorGameRoleListRsp != null)
      {
        localObject = paramGetAnchorGameRoleListRsp.equip_status;
        if (localObject != null)
        {
          i = ((PBInt32Field)localObject).get();
          break label62;
        }
      }
      int i = -1;
      label62:
      LivingInscriptionSettingDialog.e(this.a).clear();
      if (paramGetAnchorGameRoleListRsp != null)
      {
        paramGetAnchorGameRoleListRsp = paramGetAnchorGameRoleListRsp.role_list;
        if (paramGetAnchorGameRoleListRsp != null)
        {
          paramGetAnchorGameRoleListRsp = paramGetAnchorGameRoleListRsp.get();
          if (paramGetAnchorGameRoleListRsp != null) {
            LivingInscriptionSettingDialog.e(this.a).addAll((Collection)paramGetAnchorGameRoleListRsp);
          }
        }
      }
      paramGetAnchorGameRoleListRsp = this.a;
      boolean bool1;
      if (i != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      LivingInscriptionSettingDialog.b(paramGetAnchorGameRoleListRsp, bool1);
      LivingInscriptionSettingDialog.f(this.a);
      paramGetAnchorGameRoleListRsp = this.a;
      if (i != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      LivingInscriptionSettingDialog.a(paramGetAnchorGameRoleListRsp, bool1);
      LivingInscriptionSettingDialog.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog.roleListListener.1
 * JD-Core Version:    0.7.0.1
 */