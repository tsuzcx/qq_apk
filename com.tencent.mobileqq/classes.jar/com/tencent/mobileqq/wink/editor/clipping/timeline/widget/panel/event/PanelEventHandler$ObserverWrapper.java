package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventHandler$ObserverWrapper;", "", "eventFilter", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEvent;", "", "observer", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventObserver;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventObserver;)V", "getEventFilter", "()Lkotlin/jvm/functions/Function1;", "getObserver", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/PanelEventObserver;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
final class PanelEventHandler$ObserverWrapper
{
  @NotNull
  private final Function1<PanelEvent, Boolean> a;
  @NotNull
  private final PanelEventObserver b;
  
  public PanelEventHandler$ObserverWrapper(@NotNull Function1<? super PanelEvent, Boolean> paramFunction1, @NotNull PanelEventObserver paramPanelEventObserver)
  {
    this.a = paramFunction1;
    this.b = paramPanelEventObserver;
  }
  
  @NotNull
  public final Function1<PanelEvent, Boolean> a()
  {
    return this.a;
  }
  
  @NotNull
  public final PanelEventObserver b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ObserverWrapper))
      {
        paramObject = (ObserverWrapper)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObserverWrapper(eventFilter=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", observer=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */