package com.tencent.timi.game.tim.api.impl;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import mqq.util.LogUtil;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/TimiGameTimApiImpl$internalDirectLogin$2", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameTimApiImpl$internalDirectLogin$2
  implements V2TIMCallback
{
  TimiGameTimApiImpl$internalDirectLogin$2(String paramString) {}
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("errorCode = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], p1 = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(']');
    Logger.a("TimManager", ((StringBuilder)localObject).toString());
    TimiGameTimApiImpl.a(this.a, false);
    localObject = ((Iterable)TimiGameTimApiImpl.b(this.a)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ILoginCallback)((Iterator)localObject).next()).a(paramInt, paramString);
    }
    TimiGameTimApiImpl.b(this.a).clear();
  }
  
  public void onSuccess()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("login suc ");
    ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(this.b));
    Logger.a("TimManager", ((StringBuilder)localObject).toString());
    TimiGameTimApiImpl.a(this.a, false);
    localObject = ((Iterable)TimiGameTimApiImpl.b(this.a)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ILoginCallback)((Iterator)localObject).next()).a();
    }
    TimiGameTimApiImpl.b(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.internalDirectLogin.2
 * JD-Core Version:    0.7.0.1
 */