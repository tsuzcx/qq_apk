package com.tencent.xaction.impl;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.data.TimeProp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XATimeline;", "Lcom/tencent/xaction/api/ITimeline;", "id", "", "(I)V", "animList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "animStateListenerList", "Lcom/tencent/xaction/impl/AnimStateListener;", "currentRepeatCount", "fpstime", "", "frame", "frameCallback", "Lcom/tencent/xaction/impl/XATimeline$XAFrameCallback;", "frameDurationNs", "frameRate", "frameTime", "", "getId", "()I", "setId", "isReverse", "", "lastFrameTimeNs", "running", "speed", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "addAnimStateListener", "", "animState", "addTimeline", "timeline", "cancel", "clear", "doFrame", "frameTimeNanos", "end", "getFpsTime", "isRunning", "()Ljava/lang/Boolean;", "notifyUpdate", "pause", "postFrameCallback", "removeAnimStateListener", "removeFrameCallback", "stopRunning", "removeTimeline", "resume", "setFps", "fps", "start", "stop", "Companion", "XAFrameCallback", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XATimeline
  implements ITimeline
{
  public static final XATimeline.Companion a = new XATimeline.Companion(null);
  private static int q = 60;
  private static boolean r;
  @NotNull
  private static final ArrayList<XATimeline> s = new ArrayList();
  private int b;
  @NotNull
  private TimeProp c;
  private final float d;
  private int e;
  private long f;
  private float g;
  private boolean h;
  private float i;
  private boolean j;
  private float k;
  private final ArrayList<ITimeline> l;
  private int m;
  private long n;
  private ArrayList<AnimStateListener> o;
  @RequiresApi(16)
  private final XATimeline.XAFrameCallback p;
  
  public XATimeline(int paramInt)
  {
    this.b = paramInt;
    this.c = new TimeProp();
    this.d = 1.0F;
    this.e = q;
    this.i = (1000.0F / this.e / Math.abs(this.d));
    this.k = (1000000000 / this.e / Math.abs(this.d));
    this.l = new ArrayList();
    this.o = new ArrayList();
    this.p = new XATimeline.XAFrameCallback(this);
  }
  
  private final void a(long paramLong)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((ITimeline)localIterator.next()).doFrame(paramLong);
    }
  }
  
  private final void b(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback)this.p);
    }
    if (paramBoolean)
    {
      this.h = false;
      Iterator localIterator = this.o.iterator();
      Intrinsics.checkExpressionValueIsNotNull(localIterator, "animStateListenerList.iterator()");
      while (localIterator.hasNext())
      {
        ((AnimStateListener)localIterator.next()).c();
        localIterator.remove();
      }
    }
  }
  
  private final void c(int paramInt)
  {
    this.e = paramInt;
    this.i = (1000.0F / this.e / Math.abs(this.d));
    this.k = (1000000000 / this.e / Math.abs(this.d));
  }
  
  private final void l()
  {
    if (this.h)
    {
      b(false);
      if (Build.VERSION.SDK_INT >= 16) {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this.p);
      }
    }
  }
  
  @NotNull
  public final TimeProp a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@NotNull ITimeline paramITimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramITimeline, "timeline");
    this.l.add(paramITimeline);
  }
  
  public final void a(@NotNull AnimStateListener paramAnimStateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimStateListener, "animState");
    if (!this.o.contains(paramAnimStateListener)) {
      this.o.add(paramAnimStateListener);
    }
  }
  
  public final long b()
  {
    return this.i;
  }
  
  public final void c()
  {
    if (this.c.getFps() != this.e) {
      c(this.c.getFps());
    }
    Iterator localIterator = ((Iterable)this.o).iterator();
    while (localIterator.hasNext()) {
      ((AnimStateListener)localIterator.next()).a();
    }
    if (!this.h)
    {
      this.h = true;
      this.f = System.nanoTime();
      l();
    }
  }
  
  public final void d()
  {
    this.h = true;
    this.f = System.nanoTime();
    l();
  }
  
  public void doFrame(long paramLong)
  {
    if (r)
    {
      s.add(this);
      return;
    }
    l();
    if (!this.h) {
      return;
    }
    paramLong = System.nanoTime();
    float f2 = (float)(paramLong - this.f) / this.k;
    if (f2 < 0.7F) {
      return;
    }
    if (f2 > 2.0F)
    {
      this.f = paramLong;
      return;
    }
    float f3 = this.g;
    float f1 = f2;
    if (this.j) {
      f1 = -f2;
    }
    this.g = (f3 + f1);
    this.f = paramLong;
    this.n = ((this.i * this.g));
    a(this.n);
    if ((this.c.getDuration() <= this.n) || (this.g <= 0.0F))
    {
      if (this.c.getRc() == -1)
      {
        XATimeline.Companion.a(a, this);
        return;
      }
      if (this.m < this.c.getRc())
      {
        this.m += 1;
        XATimeline.Companion.a(a, this);
        return;
      }
      if (this.m >= this.c.getRc()) {
        b(true);
      }
    }
  }
  
  public final void e()
  {
    this.g = 0.0F;
    this.m = 0;
    this.n = 0L;
    this.j = false;
    b(true);
  }
  
  public final void f()
  {
    e();
    h();
    this.l.clear();
  }
  
  public final void g()
  {
    this.h = false;
    this.g = 0.0F;
    this.m = 0;
    this.n = 0L;
    this.j = false;
    h();
    this.l.clear();
    Iterator localIterator = this.o.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animStateListenerList.iterator()");
    while (localIterator.hasNext())
    {
      ((AnimStateListener)localIterator.next()).b();
      localIterator.remove();
    }
    b(false);
  }
  
  public final void h()
  {
    if (this.c.getDuration() > this.n) {
      a(this.c.getDuration() + 17);
    }
  }
  
  @Nullable
  public final Boolean i()
  {
    return Boolean.valueOf(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.XATimeline
 * JD-Core Version:    0.7.0.1
 */