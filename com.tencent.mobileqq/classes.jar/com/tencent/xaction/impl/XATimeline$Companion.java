package com.tencent.xaction.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XATimeline$Companion;", "", "()V", "RESTART", "", "REVERSE", "SECOND_IN_NANOS", "pauseAll", "", "getPauseAll", "()Z", "setPauseAll", "(Z)V", "pauseTimelineList", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/impl/XATimeline;", "Lkotlin/collections/ArrayList;", "getPauseTimelineList", "()Ljava/util/ArrayList;", "resumeAll", "", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class XATimeline$Companion
{
  @NotNull
  public final ArrayList<XATimeline> a()
  {
    return XATimeline.a();
  }
  
  public final void a()
  {
    Iterator localIterator = ((Iterable)((Companion)this).a()).iterator();
    while (localIterator.hasNext()) {
      ((XATimeline)localIterator.next()).b();
    }
    ((Companion)this).a().clear();
  }
  
  public final void a(boolean paramBoolean)
  {
    XATimeline.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.XATimeline.Companion
 * JD-Core Version:    0.7.0.1
 */