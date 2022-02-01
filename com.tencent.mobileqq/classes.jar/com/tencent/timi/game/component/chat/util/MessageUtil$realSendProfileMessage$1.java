package com.tencent.timi.game.component.chat.util;

import android.content.Context;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/util/MessageUtil$realSendProfileMessage$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtil$realSendProfileMessage$1
  implements IResultListener<IUserInfo>
{
  MessageUtil$realSendProfileMessage$1(IMsgManager paramIMsgManager, CommonOuterClass.QQUserId paramQQUserId, Context paramContext, long paramLong) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    MessageUtil.a(MessageUtil.a, this.c, this.d);
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null)
    {
      Object localObject = this.a;
      if (localObject != null) {
        ((IMsgManager)localObject).a(this.b, 79, MessageUtil.a(MessageUtil.a, this.b, paramIUserInfo));
      }
      paramIUserInfo = paramIUserInfo.c();
      if (paramIUserInfo != null)
      {
        paramIUserInfo = paramIUserInfo.role_name;
        if (paramIUserInfo != null)
        {
          paramIUserInfo = paramIUserInfo.get();
          break label67;
        }
      }
      paramIUserInfo = null;
      label67:
      localObject = MessageUtil.a(MessageUtil.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realSendProfileMessage roleName= ");
      localStringBuilder.append(paramIUserInfo);
      localStringBuilder.append(' ');
      localStringBuilder.append(Logger.b(this.b.uid.get()));
      Logger.c((String)localObject, localStringBuilder.toString());
      return;
    }
    MessageUtil.a(MessageUtil.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.util.MessageUtil.realSendProfileMessage.1
 * JD-Core Version:    0.7.0.1
 */