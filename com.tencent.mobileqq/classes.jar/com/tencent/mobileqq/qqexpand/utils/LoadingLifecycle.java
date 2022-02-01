package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/LoadingLifecycle;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "applicationBackgroundListener", "Lcom/tencent/mobileqq/qqexpand/utils/OnApplicationBackgroundListener;", "(Lcom/tencent/mobileqq/qqexpand/utils/OnApplicationBackgroundListener;)V", "getApplicationBackgroundListener", "()Lcom/tencent/mobileqq/qqexpand/utils/OnApplicationBackgroundListener;", "setApplicationBackgroundListener", "onApplicationBackground", "", "onApplicationForeground", "onBackgroundTimeTick", "tick", "", "onBackgroundUnguardTimeTick", "onLiteTimeTick", "onScreensStateChanged", "isEnabled", "", "removeOnBackgroundListener", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class LoadingLifecycle
  implements IGuardInterface
{
  @Nullable
  private OnApplicationBackgroundListener a;
  
  public LoadingLifecycle(@Nullable OnApplicationBackgroundListener paramOnApplicationBackgroundListener)
  {
    this.a = paramOnApplicationBackgroundListener;
  }
  
  public final void a()
  {
    this.a = ((OnApplicationBackgroundListener)null);
  }
  
  public void onApplicationBackground()
  {
    OnApplicationBackgroundListener localOnApplicationBackgroundListener = this.a;
    if (localOnApplicationBackgroundListener != null) {
      localOnApplicationBackgroundListener.a();
    }
  }
  
  public void onApplicationForeground() {}
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.LoadingLifecycle
 * JD-Core Version:    0.7.0.1
 */