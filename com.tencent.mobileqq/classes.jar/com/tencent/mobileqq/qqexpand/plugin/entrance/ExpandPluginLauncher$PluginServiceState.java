package com.tencent.mobileqq.qqexpand.plugin.entrance;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_STARTED", "STARTING", "STARTED", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public enum ExpandPluginLauncher$PluginServiceState
{
  private final int value;
  
  static
  {
    PluginServiceState localPluginServiceState1 = new PluginServiceState("NOT_STARTED", 0, 0);
    NOT_STARTED = localPluginServiceState1;
    PluginServiceState localPluginServiceState2 = new PluginServiceState("STARTING", 1, 1);
    STARTING = localPluginServiceState2;
    PluginServiceState localPluginServiceState3 = new PluginServiceState("STARTED", 2, 2);
    STARTED = localPluginServiceState3;
    $VALUES = new PluginServiceState[] { localPluginServiceState1, localPluginServiceState2, localPluginServiceState3 };
  }
  
  private ExpandPluginLauncher$PluginServiceState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.PluginServiceState
 * JD-Core Version:    0.7.0.1
 */