package com.tencent.timi.game.web.business.impl.plugin;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$bindUserRole$bindListener$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "bindCancel", "", "bindFailed", "errorCode", "", "errorMsg", "", "bindSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onDialogShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionWebPlugin$bindUserRole$bindListener$1
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  public void a()
  {
    Logger.a(LivingInscriptionWebPlugin.a(this.a), "showSmobaAccountSelectDialog bindCancel ");
    LivingInscriptionWebPlugin localLivingInscriptionWebPlugin = this.a;
    String str1 = LivingInscriptionWebPlugin.b(localLivingInscriptionWebPlugin);
    String str2 = LivingInscriptionWebPlugin.a(this.a, -1).toString();
    Intrinsics.checkExpressionValueIsNotNull(str2, "errorJson(-1).toString()");
    LivingInscriptionWebPlugin.a(localLivingInscriptionWebPlugin, str1, str2);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    paramString = this.a;
    String str1 = LivingInscriptionWebPlugin.b(paramString);
    String str2 = LivingInscriptionWebPlugin.a(this.a, -1).toString();
    Intrinsics.checkExpressionValueIsNotNull(str2, "errorJson(-1).toString()");
    LivingInscriptionWebPlugin.a(paramString, str1, str2);
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "selectedDefaultAccount");
    Logger.a(LivingInscriptionWebPlugin.a(this.a), "showSmobaAccountSelectDialog bindSucceed ");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("code", 0);
    ((JSONObject)localObject).put("isBind", true);
    paramGetSmobaDefaultRoleRsp = this.a;
    String str = LivingInscriptionWebPlugin.b(paramGetSmobaDefaultRoleRsp);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "json.toString()");
    LivingInscriptionWebPlugin.a(paramGetSmobaDefaultRoleRsp, str, (String)localObject);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin.bindUserRole.bindListener.1
 * JD-Core Version:    0.7.0.1
 */