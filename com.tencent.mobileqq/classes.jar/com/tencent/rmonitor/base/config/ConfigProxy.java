package com.tencent.rmonitor.base.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/ConfigProxy;", "", "()V", "config", "Lcom/tencent/rmonitor/base/config/ConfigCenter;", "getConfig", "()Lcom/tencent/rmonitor/base/config/ConfigCenter;", "setConfig", "(Lcom/tencent/rmonitor/base/config/ConfigCenter;)V", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ConfigProxy
{
  public static final ConfigProxy INSTANCE = new ConfigProxy();
  @NotNull
  private static ConfigCenter config = new ConfigCenter();
  
  @NotNull
  public final ConfigCenter getConfig()
  {
    return config;
  }
  
  public final void setConfig(@NotNull ConfigCenter paramConfigCenter)
  {
    Intrinsics.checkParameterIsNotNull(paramConfigCenter, "<set-?>");
    config = paramConfigCenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.ConfigProxy
 * JD-Core Version:    0.7.0.1
 */