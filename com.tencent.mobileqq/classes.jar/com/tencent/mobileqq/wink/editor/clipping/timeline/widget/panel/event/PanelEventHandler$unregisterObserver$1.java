package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler$ObserverWrapper;", "invoke"}, k=3, mv={1, 1, 16})
final class PanelEventHandler$unregisterObserver$1
  extends Lambda
  implements Function1<PanelEventHandler.ObserverWrapper, Boolean>
{
  PanelEventHandler$unregisterObserver$1(PanelEventObserver paramPanelEventObserver)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull PanelEventHandler.ObserverWrapper paramObserverWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramObserverWrapper, "it");
    return paramObserverWrapper.b() == this.$observer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler.unregisterObserver.1
 * JD-Core Version:    0.7.0.1
 */