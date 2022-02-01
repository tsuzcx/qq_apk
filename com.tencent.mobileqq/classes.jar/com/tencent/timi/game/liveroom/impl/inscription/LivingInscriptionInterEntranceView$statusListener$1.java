package com.tencent.timi.game.liveroom.impl.inscription;

import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$statusListener$1", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "onFail", "", "errCode", "", "errMsg", "", "onReceive", "data", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionInterEntranceView$statusListener$1
  implements IQQCmdPushCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    String str = LivingInscriptionInterEntranceView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("statusListener onError ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
  }
  
  public void a(@Nullable byte[] paramArrayOfByte)
  {
    Logger.a(LivingInscriptionInterEntranceView.d(this.a), "IQQCmdPushCallback ");
    if ((paramArrayOfByte instanceof byte[]))
    {
      MessageOuterClass.TimMsgBody localTimMsgBody = new MessageOuterClass.TimMsgBody();
      int i;
      try
      {
        localTimMsgBody.mergeFrom(paramArrayOfByte);
        i = 1;
      }
      catch (Exception paramArrayOfByte)
      {
        String str = LivingInscriptionInterEntranceView.d(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("statusListener onError ");
        localStringBuilder.append(paramArrayOfByte);
        Logger.c(str, localStringBuilder.toString());
        i = 0;
      }
      if (i != 0) {
        LivingInscriptionInterEntranceView.a(this.a, localTimMsgBody);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView.statusListener.1
 * JD-Core Version:    0.7.0.1
 */