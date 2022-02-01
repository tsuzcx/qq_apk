package com.tencent.rmonitor.resource.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rmonitor.common.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/TemperatureCollector;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class TemperatureCollector
  extends BroadcastReceiver
{
  public static final TemperatureCollector.Companion a = new TemperatureCollector.Companion(null);
  private static volatile double b = (0.0D / 0.0D);
  
  public static final double a()
  {
    TemperatureCollector.Companion localCompanion = a;
    return b;
  }
  
  @JvmStatic
  @NotNull
  public static final IntentFilter b()
  {
    return a.a();
  }
  
  public void onReceive(@NotNull Context paramContext, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramIntent != null) {
      try
      {
        if (Intrinsics.areEqual("android.intent.action.BATTERY_CHANGED", paramIntent.getAction()))
        {
          int i = paramIntent.getIntExtra("temperature", -10000);
          double d1 = i;
          Double.isNaN(d1);
          double d2 = 10;
          Double.isNaN(d2);
          d1 = d1 * 1.0D / d2;
          b = d1;
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramIntent = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append(": override BroadcastReceiver onReceive error.");
        paramIntent.d(new String[] { "RMonitor_common_TemperatureCollector", localStringBuilder.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.TemperatureCollector
 * JD-Core Version:    0.7.0.1
 */