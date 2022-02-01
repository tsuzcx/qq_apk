package com.tencent.tavcut.render;

import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.render.rendernode.NodeOrderUtils;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/EffectDispatcher;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "()V", "dispatcherFilter", "Lcom/tencent/tavcut/render/EffectDispatcher$DispatcherFilter;", "effectDispatchListener", "Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;", "getEffectDispatchListener", "()Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;", "setEffectDispatchListener", "(Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;)V", "effectNodes", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode;", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "addNode", "", "effectNode", "addNode$lib_tavcut_release", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "removeNode", "removeNode$lib_tavcut_release", "setRenderTimeRange", "setRenderTimeRange$lib_tavcut_release", "Companion", "DispatcherFilter", "EffectDispatchListener", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class EffectDispatcher
  implements TAVVideoMixEffect
{
  public static final EffectDispatcher.Companion a = new EffectDispatcher.Companion(null);
  private final CopyOnWriteArrayList<BaseEffectNode> b = new CopyOnWriteArrayList();
  @Nullable
  private EffectDispatcher.EffectDispatchListener c;
  private EffectDispatcher.DispatcherFilter d;
  
  public final void a(@Nullable EffectDispatcher.EffectDispatchListener paramEffectDispatchListener)
  {
    this.c = paramEffectDispatchListener;
  }
  
  public final void a(@NotNull BaseEffectNode paramBaseEffectNode)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseEffectNode, "effectNode");
    if (!this.b.contains(paramBaseEffectNode))
    {
      Object localObject;
      if (paramBaseEffectNode.a() == -1)
      {
        localObject = NodeOrderUtils.a.a();
        if (((HashMap)localObject).get(paramBaseEffectNode.getClass().getSimpleName()) != null)
        {
          localObject = ((HashMap)localObject).get(paramBaseEffectNode.getClass().getSimpleName());
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          paramBaseEffectNode.a(((Number)localObject).intValue());
        }
      }
      if (paramBaseEffectNode.a() == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("当前节点没有设置渲染顺序的index，默认配置中也没有配置当前节点顺序，");
        ((StringBuilder)localObject).append("不会加入渲染链中，请检查EffectNodeOrderUtils中配置！！节点EffectId：");
        ((StringBuilder)localObject).append(paramBaseEffectNode);
        ((StringBuilder)localObject).append(".effectId");
        TavLogger.e("tavCut-EffectDispatcher", ((StringBuilder)localObject).toString());
        return;
      }
      this.b.add(paramBaseEffectNode);
    }
  }
  
  @NotNull
  public TAVVideoMixEffect.Filter createFilter()
  {
    EffectDispatcher.DispatcherFilter localDispatcherFilter = this.d;
    if (localDispatcherFilter == null) {
      localDispatcherFilter = new EffectDispatcher.DispatcherFilter((List)this.b, this.c);
    }
    this.d = localDispatcherFilter;
    return (TAVVideoMixEffect.Filter)localDispatcherFilter;
  }
  
  @Nullable
  public String effectId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tavCut-EffectDispatcher@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.EffectDispatcher
 * JD-Core Version:    0.7.0.1
 */