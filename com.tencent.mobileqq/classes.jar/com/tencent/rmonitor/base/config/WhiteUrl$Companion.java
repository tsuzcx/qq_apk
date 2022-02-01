package com.tencent.rmonitor.base.config;

import com.tencent.rmonitor.common.logger.Logger;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/config/WhiteUrl$Companion;", "", "()V", "TAG", "", "whiteHttpHosts", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "addWhiteHost", "", "url", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class WhiteUrl$Companion
{
  @JvmStatic
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      paramString = new URL(paramString);
      WhiteUrl.a.add(paramString.getHost());
      return;
    }
    catch (Exception paramString)
    {
      Logger.b.a("RMonitor_config_WhiteUrl", (Throwable)paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.WhiteUrl.Companion
 * JD-Core Version:    0.7.0.1
 */