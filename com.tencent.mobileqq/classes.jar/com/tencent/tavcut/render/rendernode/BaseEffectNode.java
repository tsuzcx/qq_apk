package com.tencent.tavcut.render.rendernode;

import com.tencent.tavkit.report.IReportable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/BaseEffectNode;", "Lcom/tencent/tavkit/report/IReportable;", "()V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "nodeIndex", "", "getNodeIndex", "()I", "setNodeIndex", "(I)V", "createFilter", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode$Filter;", "release", "", "Companion", "Filter", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract class BaseEffectNode
  implements IReportable
{
  public static final BaseEffectNode.Companion a = new BaseEffectNode.Companion(null);
  private int b = -1;
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
  
  @NotNull
  public abstract BaseEffectNode.Filter c();
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.BaseEffectNode
 * JD-Core Version:    0.7.0.1
 */