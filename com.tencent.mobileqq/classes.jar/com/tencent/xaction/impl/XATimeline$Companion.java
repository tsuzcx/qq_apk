package com.tencent.xaction.impl;

import com.tencent.xaction.api.data.TimeProp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XATimeline$Companion;", "", "()V", "RESTART", "", "REVERSE", "SECOND_IN_NANOS", "pauseAll", "", "getPauseAll", "()Z", "setPauseAll", "(Z)V", "pauseTimelineList", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/impl/XATimeline;", "Lkotlin/collections/ArrayList;", "getPauseTimelineList", "()Ljava/util/ArrayList;", "frameRepeat", "", "xaTimeline", "resumeAll", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XATimeline$Companion
{
  private final void a(XATimeline paramXATimeline)
  {
    if (paramXATimeline.a().getRm() == 1)
    {
      XATimeline.a(paramXATimeline, 0.0F);
      return;
    }
    if (paramXATimeline.a().getRm() == 2)
    {
      XATimeline.a(paramXATimeline, XATimeline.a(paramXATimeline) ^ true);
      float f1 = XATimeline.a(paramXATimeline);
      float f2 = 0;
      if (f1 > f2)
      {
        XATimeline.a(paramXATimeline, paramXATimeline.a().getDuration() / XATimeline.b(paramXATimeline));
        return;
      }
      if (XATimeline.a(paramXATimeline) < f2) {
        XATimeline.a(paramXATimeline, 0.0F);
      }
    }
  }
  
  @NotNull
  public final ArrayList<XATimeline> a()
  {
    return XATimeline.a();
  }
  
  public final void a()
  {
    Companion localCompanion = (Companion)this;
    Iterator localIterator = ((Iterable)localCompanion.a()).iterator();
    while (localIterator.hasNext()) {
      ((XATimeline)localIterator.next()).b();
    }
    localCompanion.a().clear();
  }
  
  public final void a(boolean paramBoolean)
  {
    XATimeline.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XATimeline.Companion
 * JD-Core Version:    0.7.0.1
 */