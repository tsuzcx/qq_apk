package com.tencent.qapmsdk.base.config;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/WhiteUrl$Companion;", "", "()V", "TAG", "", "whiteHttpHosts", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "addWhiteHost", "", "url", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class WhiteUrl$Companion
{
  @JvmStatic
  public final void addWhiteHost(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      paramString = new URL(paramString);
      WhiteUrl.whiteHttpHosts.add(paramString.getHost());
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_base_WhiteUrl", (Throwable)paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.WhiteUrl.Companion
 * JD-Core Version:    0.7.0.1
 */