package com.tencent.rmonitor.resource.collector;

import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/TemperatureCollector$Companion;", "", "()V", "TAG", "", "temperature", "", "temperature$annotations", "getTemperature", "()D", "setTemperature", "(D)V", "getFilter", "Landroid/content/IntentFilter;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class TemperatureCollector$Companion
{
  @JvmStatic
  @NotNull
  public final IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
    return localIntentFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.TemperatureCollector.Companion
 * JD-Core Version:    0.7.0.1
 */