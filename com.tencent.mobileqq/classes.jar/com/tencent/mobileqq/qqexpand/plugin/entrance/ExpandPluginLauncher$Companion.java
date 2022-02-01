package com.tencent.mobileqq.qqexpand.plugin.entrance;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$Companion;", "", "()V", "KEY_ENTER_TIME", "", "KEY_PLUGIN_PROCESS_ID", "PLUGIN_ENTRY_ACTIVITY", "PLUGIN_ID", "PLUGIN_ID_APK", "PLUGIN_PRELOAD_PACKAGE_NAME", "PLUGIN_PRELOAD_SERVICE", "PLUGIN_PRELOAD_SERVICE_NAME", "TAG", "instance", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "instance$annotations", "getInstance", "()Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "instance$delegate", "Lkotlin/Lazy;", "mStartIntent", "Landroid/content/Intent;", "setPluginMode", "", "mode", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginMode;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher$Companion
{
  @NotNull
  public final ExpandPluginLauncher a()
  {
    Lazy localLazy = ExpandPluginLauncher.c();
    Companion localCompanion = ExpandPluginLauncher.a;
    return (ExpandPluginLauncher)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.Companion
 * JD-Core Version:    0.7.0.1
 */