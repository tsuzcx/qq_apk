package com.tencent.qapmsdk.common.resource;

import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/TemperatureCollector$Companion;", "", "()V", "TAG", "", "temperature", "", "temperature$annotations", "getTemperature", "()D", "setTemperature", "(D)V", "getFilter", "Landroid/content/IntentFilter;", "common_release"}, k=1, mv={1, 1, 15})
public final class TemperatureCollector$Companion
{
  @JvmStatic
  @NotNull
  public final IntentFilter getFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
    return localIntentFilter;
  }
  
  public final double getTemperature()
  {
    return TemperatureCollector.access$getTemperature$cp();
  }
  
  public final void setTemperature(double paramDouble)
  {
    TemperatureCollector.access$setTemperature$cp(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.TemperatureCollector.Companion
 * JD-Core Version:    0.7.0.1
 */