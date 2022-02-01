package com.tencent.tavcut.render;

import com.tencent.tavcut.render.rendernode.BaseEffectNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "o1", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode;", "o2", "compare"}, k=3, mv={1, 1, 16})
final class EffectDispatcher$DispatcherFilter$1<T>
  implements Comparator<BaseEffectNode>
{
  public static final 1 a = new 1();
  
  public final int a(@NotNull BaseEffectNode paramBaseEffectNode1, @NotNull BaseEffectNode paramBaseEffectNode2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseEffectNode1, "o1");
    Intrinsics.checkParameterIsNotNull(paramBaseEffectNode2, "o2");
    if (paramBaseEffectNode1.a() < paramBaseEffectNode2.a()) {
      return -1;
    }
    if (paramBaseEffectNode1.a() > paramBaseEffectNode2.a()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.EffectDispatcher.DispatcherFilter.1
 * JD-Core Version:    0.7.0.1
 */