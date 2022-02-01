package com.tencent.xaction.impl;

import android.view.Choreographer.FrameCallback;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XATimeline$XAFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "(Lcom/tencent/xaction/impl/XATimeline;)V", "timelineWef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "doFrame", "", "frameTimeNanos", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
@RequiresApi(16)
public final class XATimeline$XAFrameCallback
  implements Choreographer.FrameCallback
{
  private final WeakReference<XATimeline> a;
  
  public XATimeline$XAFrameCallback(@NotNull XATimeline paramXATimeline)
  {
    this.a = new WeakReference(paramXATimeline);
  }
  
  public void doFrame(long paramLong)
  {
    XATimeline localXATimeline = (XATimeline)this.a.get();
    if (localXATimeline != null) {
      localXATimeline.doFrame(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XATimeline.XAFrameCallback
 * JD-Core Version:    0.7.0.1
 */