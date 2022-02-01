package com.tencent.qapmsdk.base.monitorplugin;

import android.app.Application;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/monitorplugin/QAPMMonitorPlugin;", "", "()V", "pluginConfig", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "getPluginConfig", "()Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "setPluginConfig", "(Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;)V", "initApplication", "", "app", "Landroid/app/Application;", "setListener", "listener", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "start", "stop", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class QAPMMonitorPlugin
{
  @Nullable
  private DefaultPluginConfig pluginConfig;
  
  @Nullable
  public final DefaultPluginConfig getPluginConfig()
  {
    return this.pluginConfig;
  }
  
  public final void initApplication(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "app");
    com.tencent.qapmsdk.base.meta.BaseInfo.app = paramApplication;
    FileUtil.Companion.setApp(paramApplication);
  }
  
  public abstract void setListener(@NotNull IBaseListener paramIBaseListener);
  
  public final void setPluginConfig(@Nullable DefaultPluginConfig paramDefaultPluginConfig)
  {
    this.pluginConfig = paramDefaultPluginConfig;
  }
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin
 * JD-Core Version:    0.7.0.1
 */