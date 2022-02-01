package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler;", "", "()V", "eventObservers", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler$ObserverWrapper;", "dispatchEvent", "", "event", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "registerObserver", "observer", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventObserver;", "eventFilter", "Lkotlin/Function1;", "", "unregisterObserver", "ObserverWrapper", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PanelEventHandler
{
  private final List<PanelEventHandler.ObserverWrapper> a = (List)new ArrayList();
  
  public final void a(@NotNull PanelEvent paramPanelEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelEvent, "event");
    Object localObject2 = (Iterable)this.a;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((Boolean)((PanelEventHandler.ObserverWrapper)localObject3).a().invoke(paramPanelEvent)).booleanValue()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((PanelEventHandler.ObserverWrapper)((Iterator)localObject1).next()).b().a(paramPanelEvent);
    }
  }
  
  public final void a(@NotNull PanelEventObserver paramPanelEventObserver, @NotNull Function1<? super PanelEvent, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelEventObserver, "observer");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "eventFilter");
    List localList = this.a;
    CollectionsKt.removeAll(localList, (Function1)new PanelEventHandler.registerObserver..inlined.run.lambda.1(paramPanelEventObserver, paramFunction1));
    localList.add(new PanelEventHandler.ObserverWrapper(paramFunction1, paramPanelEventObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler
 * JD-Core Version:    0.7.0.1
 */