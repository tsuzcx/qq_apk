package com.tencent.timi.game.web.business.impl.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$getSmobaRoleBindStatus$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionWebPlugin$getSmobaRoleBindStatus$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    if (paramGetSmobaDefaultRoleRsp != null)
    {
      paramString = paramGetSmobaDefaultRoleRsp.role_info;
      if (paramString != null)
      {
        paramString = paramString.role_name;
        if (paramString != null)
        {
          paramString = paramString.get();
          break label34;
        }
      }
    }
    paramString = null;
    label34:
    boolean bool = TextUtils.isEmpty((CharSequence)paramString);
    Object localObject = new JSONObject();
    if (paramBoolean) {
      paramInt = 0;
    }
    ((JSONObject)localObject).put("code", paramInt);
    ((JSONObject)localObject).put("isBind", bool ^ true);
    paramString = this.a;
    paramGetSmobaDefaultRoleRsp = LivingInscriptionWebPlugin.c(paramString);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "json.toString()");
    LivingInscriptionWebPlugin.a(paramString, paramGetSmobaDefaultRoleRsp, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin.getSmobaRoleBindStatus.1
 * JD-Core Version:    0.7.0.1
 */