package com.tencent.qapmsdk.base.reporter.proxy;

import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.reporter.config.ConfigApply;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/proxy/ConfigProxy;", "", "()V", "config", "Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply;", "getConfig", "()Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply;", "setConfig", "(Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply;)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ConfigProxy
{
  public static final ConfigProxy INSTANCE = new ConfigProxy();
  @NotNull
  private static ConfigApply config = new ConfigApply(new URL(BaseInfo.urlMeta.getConfigUrl()));
  
  @NotNull
  public final ConfigApply getConfig()
  {
    return config;
  }
  
  public final void setConfig(@NotNull ConfigApply paramConfigApply)
  {
    Intrinsics.checkParameterIsNotNull(paramConfigApply, "<set-?>");
    config = paramConfigApply;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.proxy.ConfigProxy
 * JD-Core Version:    0.7.0.1
 */