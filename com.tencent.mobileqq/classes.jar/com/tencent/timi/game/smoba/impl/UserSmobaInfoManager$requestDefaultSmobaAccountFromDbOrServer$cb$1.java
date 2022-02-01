package com.tencent.timi.game.smoba.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/UserSmobaInfoManager$requestDefaultSmobaAccountFromDbOrServer$cb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoManager$requestDefaultSmobaAccountFromDbOrServer$cb$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  UserSmobaInfoManager$requestDefaultSmobaAccountFromDbOrServer$cb$1(IUserSmobaInfoService.Callback paramCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    if ((paramBoolean) && (paramGetSmobaDefaultRoleRsp != null))
    {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new UserSmobaInfoManager.requestDefaultSmobaAccountFromDbOrServer.cb.1.onResult.1(this, paramGetSmobaDefaultRoleRsp));
      return;
    }
    this.a.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.requestDefaultSmobaAccountFromDbOrServer.cb.1
 * JD-Core Version:    0.7.0.1
 */