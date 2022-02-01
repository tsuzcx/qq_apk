package com.tencent.timi.game.tim.api.impl;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$logout$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "p0", "", "p1", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$logout$1
  implements V2TIMCallback
{
  public void onError(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("logout error, errorCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] errMsg[");
    localStringBuilder.append(paramString);
    localStringBuilder.append(']');
    Logger.b("TimManager", localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    Logger.b("TimManager", "logout success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.logout.1
 * JD-Core Version:    0.7.0.1
 */