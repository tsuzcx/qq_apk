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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/XATimeline;", "Lcom/tencent/xaction/api/ITimeline;", "id", "", "(I)V", "animStateListenerList", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/impl/AnimStateListener;", "Lkotlin/collections/ArrayList;", "callback", "", "currentRepeatCount", "fpstime", "", "frame", "frameCallback", "Lcom/tencent/xaction/impl/XATimeline$XAFrameCallback;", "frameDurationNs", "frameRate", "frameTime", "", "getId", "()I", "setId", "isReverse", "", "lastFrameTimeNs", "running", "speed", "timelineList", "tp", "Lcom/tencent/xaction/api/data/TimeProp;", "getTp", "()Lcom/tencent/xaction/api/data/TimeProp;", "setTp", "(Lcom/tencent/xaction/api/data/TimeProp;)V", "addAnimStateListener", "", "animState", "addTimeline", "timeline", "cancel", "clear", "doFrame", "frameTimeNanos", "getFpsTime", "isRunning", "()Ljava/lang/Boolean;", "notifyUpdate", "pause", "postFrameCallback", "removeAnimStateListener", "removeFrameCallback", "stopRunning", "removeTimeline", "resume", "setFps", "fps", "start", "stop", "Companion", "XAFrameCallback", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class XATimeline
  implements ITimeline
{
  public static final XATimeline.Companion a;
  @NotNull
  private static final ArrayList<XATimeline> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_c_of_type_Boolean;
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private TimeProp jdField_a_of_type_ComTencentXactionApiDataTimeProp;
  @RequiresApi(16)
  private final XATimeline.XAFrameCallback jdField_a_of_type_ComTencentXactionImplXATimeline$XAFrameCallback;
  private Object jdField_a_of_type_JavaLangObject;
  private final ArrayList<ITimeline> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private ArrayList<AnimStateListener> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float d;
  
  static
  {
    jdField_a_of_type_ComTencentXactionImplXATimeline$Companion = new XATimeline.Companion(null);
  }
  
  public XATimeline(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentXactionApiDataTimeProp = new TimeProp();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Int = 60;
    this.jdField_c_of_type_Float = (1000.0F / this.jdField_b_of_type_Int / Math.abs(this.jdField_a_of_type_Float));
    this.d = (1000000000 / this.jdField_b_of_type_Int / Math.abs(this.jdField_a_of_type_Float));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentXactionImplXATimeline$XAFrameCallback = new XATimeline.XAFrameCallback(this);
  }
  
  private final void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ITimeline)localIterator.next()).doFrame(paramLong);
    }
  }
  
  private final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_c_of_type_Float = (1000.0F / this.jdField_b_of_type_Int / Math.abs(this.jdField_a_of_type_Float));
    this.d = (1000000000 / this.jdField_b_of_type_Int / Math.abs(this.jdField_a_of_type_Float));
  }
  
  private final void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && (Build.VERSION.SDK_INT >= 16)) {
      Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback)this.jdField_a_of_type_JavaLangObject);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      Intrinsics.checkExpressionValueIsNotNull(localIterator, "animStateListenerList.iterator()");
      while (localIterator.hasNext())
      {
        ((AnimStateListener)localIterator.next()).c();
        localIterator.remove();
      }
    }
  }
  
  private final void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(false);
      if (Build.VERSION.SDK_INT >= 16) {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this.jdField_a_of_type_ComTencentXactionImplXATimeline$XAFrameCallback);
      }
    }
  }
  
  public final long a()
  {
    return this.jdField_c_of_type_Float;
  }
  
  @NotNull
  public final TimeProp a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiDataTimeProp;
  }
  
  @Nullable
  public final Boolean a()
  {
    return Boolean.valueOf(this.jdField_a_of_type_Boolean);
  }
  
  public final void a()
  {
    if (this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getFps() != this.jdField_b_of_type_Int) {
      b(this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getFps());
    }
    Iterator localIterator = ((Iterable)this.jdField_b_of_type_JavaUtilArrayList).iterator();
    while (localIterator.hasNext()) {
      ((AnimStateListener)localIterator.next()).a();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = System.nanoTime();
      f();
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull ITimeline paramITimeline)
  {
    Intrinsics.checkParameterIsNotNull(paramITimeline, "timeline");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramITimeline);
  }
  
  public final void a(@NotNull AnimStateListener paramAnimStateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramAnimStateListener, "animState");
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramAnimStateListener)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAnimStateListener);
    }
  }
  
  public final void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.nanoTime();
    f();
  }
  
  public final void c()
  {
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    b(true);
  }
  
  public final void d()
  {
    c();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void doFrame(long paramLong)
  {
    if (jdField_c_of_type_Boolean)
    {
      jdField_c_of_type_JavaUtilArrayList.add(this);
      return;
    }
    f();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramLong = System.nanoTime();
    float f2 = (float)(paramLong - this.jdField_a_of_type_Long) / this.d;
    if (f2 < 0.8D) {
      return;
    }
    if (f2 > 3)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
    }
    float f3 = this.jdField_b_of_type_Float;
    float f1 = f2;
    if (this.jdField_b_of_type_Boolean) {
      f1 = -f2;
    }
    this.jdField_b_of_type_Float = (f3 + f1);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Long = ((this.jdField_c_of_type_Float * this.jdField_b_of_type_Float));
    a(this.jdField_b_of_type_Long);
    if ((this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getDuration() <= this.jdField_b_of_type_Long) || (this.jdField_b_of_type_Float <= 0.0F))
    {
      if (this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getRc() == -1)
      {
        XATimeline.Companion.a(jdField_a_of_type_ComTencentXactionImplXATimeline$Companion, this);
        return;
      }
      if (this.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getRc())
      {
        this.jdField_c_of_type_Int += 1;
        XATimeline.Companion.a(jdField_a_of_type_ComTencentXactionImplXATimeline$Companion, this);
        return;
      }
      if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_ComTencentXactionApiDataTimeProp.getRc()) {
        b(true);
      }
    }
  }
  
  public final void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animStateListenerList.iterator()");
    while (localIterator.hasNext())
    {
      ((AnimStateListener)localIterator.next()).b();
      localIterator.remove();
    }
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XATimeline
 * JD-Core Version:    0.7.0.1
 */