package com.tencent.qapmsdk.common.resource;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/TemperatureCollector;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class TemperatureCollector
  extends BroadcastReceiver
{
  public static final TemperatureCollector.Companion Companion = new TemperatureCollector.Companion(null);
  private static final String TAG = "QAPM_common_TemperatureCollector";
  private static volatile double temperature = (0.0D / 0.0D);
  
  @JvmStatic
  @NotNull
  public static final IntentFilter getFilter()
  {
    return Companion.getFilter();
  }
  
  public static final double getTemperature()
  {
    TemperatureCollector.Companion localCompanion = Companion;
    return temperature;
  }
  
  public static final void setTemperature(double paramDouble)
  {
    TemperatureCollector.Companion localCompanion = Companion;
    temperature = paramDouble;
  }
  
  public void onReceive(@NotNull Context paramContext, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramIntent != null) {}
    try
    {
      if (Intrinsics.areEqual("android.intent.action.BATTERY_CHANGED", paramIntent.getAction())) {
        temperature = paramIntent.getIntExtra("temperature", -10000) * 1.0D / 10;
      }
      return;
    }
    catch (Exception paramContext)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_common_TemperatureCollector", paramContext + ": override BroadcastReceiver onReceive error." });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.TemperatureCollector
 * JD-Core Version:    0.7.0.1
 */