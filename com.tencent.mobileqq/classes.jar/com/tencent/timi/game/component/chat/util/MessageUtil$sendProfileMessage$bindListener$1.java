package com.tencent.timi.game.component.chat.util;

import android.content.Context;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/util/MessageUtil$sendProfileMessage$bindListener$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "bindCancel", "", "bindFailed", "errorCode", "", "errorMsg", "", "bindSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onDialogShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtil$sendProfileMessage$bindListener$1
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  MessageUtil$sendProfileMessage$bindListener$1(CommonOuterClass.QQUserId paramQQUserId, IMsgManager paramIMsgManager, Context paramContext) {}
  
  public void a()
  {
    Logger.a(MessageUtil.a(MessageUtil.a), "sendProfileMessage bindCancel ");
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Logger.a(MessageUtil.a(MessageUtil.a), "sendProfileMessage bindFailed ");
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "selectedDefaultAccount");
    Logger.a(MessageUtil.a(MessageUtil.a), "sendProfileMessage bindSucceed ");
    MessageUtil.a(MessageUtil.a, this.a, this.b, this.c);
  }
  
  public void b()
  {
    Logger.a(MessageUtil.a(MessageUtil.a), "sendProfileMessage onDialogShow ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.util.MessageUtil.sendProfileMessage.bindListener.1
 * JD-Core Version:    0.7.0.1
 */