package com.tencent.mobileqq.qqexpand.plugin.entrance;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginMode$NumberedMode;", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginMode;", "mode", "", "(I)V", "getMode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLauncher$PluginMode$NumberedMode
  extends ExpandPluginLauncher.PluginMode
{
  private final int a;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NumberedMode))
      {
        paramObject = (NumberedMode)paramObject;
        if (this.a == paramObject.a) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NumberedMode(mode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher.PluginMode.NumberedMode
 * JD-Core Version:    0.7.0.1
 */