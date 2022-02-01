package com.tencent.timi.game.web.business.impl.plugin;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.web.business.impl.inscription.InscriptionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin$getMySmobaRoleList$callback$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionWebPlugin$getMySmobaRoleList$callback$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    if (!paramBoolean)
    {
      localObject = LivingInscriptionWebPlugin.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acquireRoleList error ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(',');
      localStringBuilder.append(paramString);
      localStringBuilder.append(' ');
      Logger.c((String)localObject, localStringBuilder.toString());
    }
    if (paramGetUserSmobaRoleListRsp != null)
    {
      paramString = paramGetUserSmobaRoleListRsp.role_list;
      if (paramString != null)
      {
        paramString = paramString.get();
        break label95;
      }
    }
    paramString = null;
    label95:
    Object localObject = InscriptionUtil.a.a(paramString);
    if (paramBoolean) {
      paramInt = 0;
    }
    ((JSONObject)localObject).put("code", paramInt);
    paramString = this.a;
    paramGetUserSmobaRoleListRsp = LivingInscriptionWebPlugin.d(paramString);
    localObject = ((JSONObject)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "json.toString()");
    LivingInscriptionWebPlugin.a(paramString, paramGetUserSmobaRoleListRsp, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin.getMySmobaRoleList.callback.1
 * JD-Core Version:    0.7.0.1
 */