package com.tencent.timi.game.expand.hall.impl.mic;

import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/mic/MicOperationUtil$doOnMic$1", "Lcom/tencent/timi/game/mic/api/CheckMicPermissionCallback;", "onChecked", "", "permissionEnable", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MicOperationUtil$doOnMic$1
  implements CheckMicPermissionCallback
{
  MicOperationUtil$doOnMic$1(OnMicOptCallback paramOnMicOptCallback, long paramLong) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    if (!paramBoolean)
    {
      Logger.a("MicOperationUtil_", 1, "doOnMic# permissionEnable false!");
      return;
    }
    MicOperationUtil.a(MicOperationUtil.a, this.b, (IResultListener)this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicOperationUtil.doOnMic.1
 * JD-Core Version:    0.7.0.1
 */