package com.tencent.mobileqq.cmshow.engine.script.plugin;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "", "(Ljava/lang/String;I)V", "UI", "GENERAL", "DATA", "SSO", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum PluginCmdConstant$PlugPriority
{
  static
  {
    PlugPriority localPlugPriority1 = new PlugPriority("UI", 0);
    UI = localPlugPriority1;
    PlugPriority localPlugPriority2 = new PlugPriority("GENERAL", 1);
    GENERAL = localPlugPriority2;
    PlugPriority localPlugPriority3 = new PlugPriority("DATA", 2);
    DATA = localPlugPriority3;
    PlugPriority localPlugPriority4 = new PlugPriority("SSO", 3);
    SSO = localPlugPriority4;
    $VALUES = new PlugPriority[] { localPlugPriority1, localPlugPriority2, localPlugPriority3, localPlugPriority4 };
  }
  
  private PluginCmdConstant$PlugPriority() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority
 * JD-Core Version:    0.7.0.1
 */