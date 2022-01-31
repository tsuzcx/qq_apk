package com.tencent.qapmsdk.common.activty;

import android.app.Activity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/activty/IForeBackInterface;", "", "onBackground", "", "activity", "Landroid/app/Activity;", "onCreate", "onDestroy", "onForeground", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IForeBackInterface
{
  public abstract void onBackground(@NotNull Activity paramActivity);
  
  public abstract void onCreate(@NotNull Activity paramActivity);
  
  public abstract void onDestroy(@NotNull Activity paramActivity);
  
  public abstract void onForeground(@NotNull Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.activty.IForeBackInterface
 * JD-Core Version:    0.7.0.1
 */