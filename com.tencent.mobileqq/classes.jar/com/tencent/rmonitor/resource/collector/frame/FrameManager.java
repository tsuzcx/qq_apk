package com.tencent.rmonitor.resource.collector.frame;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/resource/collector/frame/FrameManager;", "Landroid/view/Choreographer$FrameCallback;", "()V", "TAG", "", "callbackList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/rmonitor/resource/collector/frame/IFrame;", "choreographer", "Landroid/view/Choreographer;", "isOpen", "", "isStart", "doFrame", "", "frameTimeNanos", "", "register", "listener", "start", "stop", "unRegister", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FrameManager
  implements Choreographer.FrameCallback
{
  public static final FrameManager a = new FrameManager();
  private static final ConcurrentLinkedQueue<IFrame> b = new ConcurrentLinkedQueue();
  private static Choreographer c;
  private static boolean d;
  private static boolean e;
  
  static
  {
    if (!AndroidVersion.a.b()) {
      Logger.b.d(new String[] { "RMonitor_frame_FrameManager", "build version is low" });
    }
    new Handler(Looper.getMainLooper()).postAtFrontOfQueue((Runnable)FrameManager.1.a);
  }
  
  private final void b()
  {
    if (!d) {
      return;
    }
    d = false;
    Choreographer localChoreographer = c;
    if (localChoreographer != null) {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }
  }
  
  public final void a()
  {
    if ((d) && (b.size() == 0)) {
      return;
    }
    Object localObject = c;
    if (localObject != null)
    {
      d = true;
      ((Choreographer)localObject).postFrameCallback((Choreographer.FrameCallback)a);
      if (localObject != null) {
        return;
      }
    }
    Logger.b.d(new String[] { "RMonitor_frame_FrameManager", "choreographer is not prepare!" });
    localObject = Unit.INSTANCE;
  }
  
  public final void a(@NotNull IFrame paramIFrame)
  {
    Intrinsics.checkParameterIsNotNull(paramIFrame, "listener");
    b.add(paramIFrame);
  }
  
  public void doFrame(long paramLong)
  {
    e = false;
    Object localObject2 = (Iterable)b;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((IFrame)localObject3).b()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IFrame)((Iterator)localObject1).next();
      e = true;
      ((IFrame)localObject2).a(paramLong);
    }
    if (e)
    {
      localObject1 = c;
      if (localObject1 != null) {
        ((Choreographer)localObject1).postFrameCallback((Choreographer.FrameCallback)this);
      }
    }
    else
    {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.collector.frame.FrameManager
 * JD-Core Version:    0.7.0.1
 */