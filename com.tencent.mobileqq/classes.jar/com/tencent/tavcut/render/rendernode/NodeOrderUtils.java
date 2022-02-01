package com.tencent.tavcut.render.rendernode;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/NodeOrderUtils;", "", "()V", "defaultOrderConfig", "Ljava/util/HashMap;", "", "", "getDefaultOrderConfig", "()Ljava/util/HashMap;", "getOrderConfigByScene", "renderScene", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class NodeOrderUtils
{
  public static final NodeOrderUtils a = new NodeOrderUtils();
  @NotNull
  private static final HashMap<String, Integer> b = new HashMap();
  
  static
  {
    Map localMap = (Map)b;
    String str = LightRenderNode.class.getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(str, "LightRenderNode::class.java.simpleName");
    localMap.put(str, Integer.valueOf(0));
  }
  
  @NotNull
  public final HashMap<String, Integer> a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.NodeOrderUtils
 * JD-Core Version:    0.7.0.1
 */