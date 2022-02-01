package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/initer/impl/TGGroundInterfaceWrapper;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onApplicationBackground", "", "onApplicationForeground", "onBackgroundTimeTick", "tick", "", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "onScreensStateChanged", "isEnabled", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGGroundInterfaceWrapper
  implements IGuardInterface
{
  @NotNull
  private final String a = "TGGroundInterfaceWrapper";
  
  public void onApplicationBackground()
  {
    Logger.INSTANCE.i(new String[] { this.a, "onApplicationBackground" });
    ThreadPool.a((Runnable)TGGroundInterfaceWrapper.onApplicationBackground.1.a);
  }
  
  public void onApplicationForeground()
  {
    Logger.INSTANCE.i(new String[] { this.a, "onApplicationForeground" });
    ThreadPool.a((Runnable)TGGroundInterfaceWrapper.onApplicationForeground.1.a);
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean)
  {
    Logger localLogger = Logger.INSTANCE;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScreensStateChanged ");
    localStringBuilder.append(paramBoolean);
    localLogger.i(new String[] { str, localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.TGGroundInterfaceWrapper
 * JD-Core Version:    0.7.0.1
 */