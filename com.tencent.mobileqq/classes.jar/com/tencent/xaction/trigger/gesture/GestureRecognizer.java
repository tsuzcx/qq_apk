package com.tencent.xaction.trigger.gesture;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GesturePoint;
import android.gesture.GestureStroke;
import android.view.MotionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/gesture/GestureRecognizer;", "", "gestureFile", "Ljava/io/File;", "(Ljava/io/File;)V", "currentGesture", "Landroid/gesture/Gesture;", "eventX", "", "eventY", "gestureLibrary", "Landroid/gesture/GestureLibrary;", "gestureListener", "Lcom/tencent/xaction/trigger/gesture/GestureListener;", "getGestureListener", "()Lcom/tencent/xaction/trigger/gesture/GestureListener;", "setGestureListener", "(Lcom/tencent/xaction/trigger/gesture/GestureListener;)V", "isGesturing", "", "isListeningForGestures", "isPrepared", "Ljava/util/concurrent/atomic/AtomicBoolean;", "singleExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "strokeBuffer", "Ljava/util/ArrayList;", "Landroid/gesture/GesturePoint;", "Lkotlin/collections/ArrayList;", "totalLength", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "processEvent", "recognize", "", "gesture", "touchDown", "touchMove", "touchUp", "isCancel", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class GestureRecognizer
{
  public static final GestureRecognizer.Companion a = new GestureRecognizer.Companion(null);
  @Nullable
  private GestureListener b;
  private boolean c;
  private boolean d;
  private float e;
  private float f;
  private Gesture g;
  private float h;
  private final ArrayList<GesturePoint> i = new ArrayList(100);
  private GestureLibrary j;
  private AtomicBoolean k = new AtomicBoolean(false);
  private final ExecutorService l = Executors.newSingleThreadExecutor();
  
  public GestureRecognizer(@NotNull File paramFile)
  {
    this.l.execute((Runnable)new GestureRecognizer.1(this, paramFile));
  }
  
  private final void a(Gesture paramGesture)
  {
    if (this.k.get())
    {
      Object localObject = this.j;
      if (localObject != null) {
        paramGesture = ((GestureLibrary)localObject).recognize(paramGesture);
      } else {
        paramGesture = null;
      }
      if ((paramGesture != null) && (!paramGesture.isEmpty()))
      {
        localObject = this.b;
        if (localObject != null) {
          ((GestureListener)localObject).a((List)paramGesture);
        }
      }
      else
      {
        paramGesture = this.b;
        if (paramGesture != null) {
          paramGesture.b();
        }
      }
    }
    else
    {
      paramGesture = this.b;
      if (paramGesture != null) {
        paramGesture.b();
      }
    }
  }
  
  private final void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.c = false;
    paramMotionEvent = this.g;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.addStroke(new GestureStroke(this.i));
      if (!paramBoolean) {
        a(paramMotionEvent);
      }
    }
    this.i.clear();
    this.d = false;
    this.g = ((Gesture)null);
  }
  
  private final boolean b(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return false;
          }
          a(paramMotionEvent, true);
          return false;
        }
        d(paramMotionEvent);
        return false;
      }
      a(paramMotionEvent, false);
      return false;
    }
    c(paramMotionEvent);
    return false;
  }
  
  private final void c(MotionEvent paramMotionEvent)
  {
    this.c = true;
    this.e = paramMotionEvent.getX();
    this.f = paramMotionEvent.getY();
    this.h = 0.0F;
    if (this.g == null) {
      this.g = new Gesture();
    }
    this.i.add(new GesturePoint(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getEventTime()));
  }
  
  private final void d(MotionEvent paramMotionEvent)
  {
    float f2 = this.e;
    float f1 = this.f;
    f2 = Math.abs(paramMotionEvent.getX() - f2);
    f1 = Math.abs(paramMotionEvent.getY() - f1);
    if ((f2 >= 3.0F) || (f1 >= 3.0F))
    {
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      this.i.add(new GesturePoint(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getEventTime()));
      if (!this.d)
      {
        this.h += (float)Math.hypot(f2, f1);
        this.d = true;
        paramMotionEvent = this.b;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
    }
  }
  
  public final void a(@Nullable GestureListener paramGestureListener)
  {
    this.b = paramGestureListener;
  }
  
  public final boolean a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    b(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.gesture.GestureRecognizer
 * JD-Core Version:    0.7.0.1
 */