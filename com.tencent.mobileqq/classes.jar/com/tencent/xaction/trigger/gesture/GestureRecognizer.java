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
  public static final GestureRecognizer.Companion a;
  private float jdField_a_of_type_Float;
  private Gesture jdField_a_of_type_AndroidGestureGesture;
  private GestureLibrary jdField_a_of_type_AndroidGestureGestureLibrary;
  @Nullable
  private GestureListener jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener;
  private final ArrayList<GesturePoint> jdField_a_of_type_JavaUtilArrayList = new ArrayList(100);
  private final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  
  static
  {
    jdField_a_of_type_ComTencentXactionTriggerGestureGestureRecognizer$Companion = new GestureRecognizer.Companion(null);
  }
  
  public GestureRecognizer(@NotNull File paramFile)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute((Runnable)new GestureRecognizer.1(this, paramFile));
  }
  
  private final void a(Gesture paramGesture)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject = this.jdField_a_of_type_AndroidGestureGestureLibrary;
      if (localObject != null) {
        paramGesture = ((GestureLibrary)localObject).recognize(paramGesture);
      } else {
        paramGesture = null;
      }
      if ((paramGesture != null) && (!paramGesture.isEmpty()))
      {
        localObject = this.jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener;
        if (localObject != null) {
          ((GestureListener)localObject).a((List)paramGesture);
        }
      }
      else
      {
        paramGesture = this.jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener;
        if (paramGesture != null) {
          paramGesture.b();
        }
      }
    }
    else
    {
      paramGesture = this.jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener;
      if (paramGesture != null) {
        paramGesture.b();
      }
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramMotionEvent.getX();
    this.jdField_b_of_type_Float = paramMotionEvent.getY();
    this.c = 0.0F;
    if (this.jdField_a_of_type_AndroidGestureGesture == null) {
      this.jdField_a_of_type_AndroidGestureGesture = new Gesture();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new GesturePoint(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getEventTime()));
  }
  
  private final void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    paramMotionEvent = this.jdField_a_of_type_AndroidGestureGesture;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.addStroke(new GestureStroke(this.jdField_a_of_type_JavaUtilArrayList));
      if (!paramBoolean) {
        a(paramMotionEvent);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGestureGesture = ((Gesture)null);
  }
  
  private final void b(MotionEvent paramMotionEvent)
  {
    float f2 = this.jdField_a_of_type_Float;
    float f1 = this.jdField_b_of_type_Float;
    f2 = Math.abs(paramMotionEvent.getX() - f2);
    f1 = Math.abs(paramMotionEvent.getY() - f1);
    if ((f2 >= 3.0F) || (f1 >= 3.0F))
    {
      paramMotionEvent.getX();
      paramMotionEvent.getY();
      this.jdField_a_of_type_JavaUtilArrayList.add(new GesturePoint(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getEventTime()));
      if (!this.jdField_b_of_type_Boolean)
      {
        this.c += (float)Math.hypot(f2, f1);
        this.jdField_b_of_type_Boolean = true;
        paramMotionEvent = this.jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
    }
  }
  
  private final boolean b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return false;
          }
          a(paramMotionEvent, true);
          return false;
        }
        b(paramMotionEvent);
        return false;
      }
      a(paramMotionEvent, false);
      return false;
    }
    a(paramMotionEvent);
    return false;
  }
  
  public final void a(@Nullable GestureListener paramGestureListener)
  {
    this.jdField_a_of_type_ComTencentXactionTriggerGestureGestureListener = paramGestureListener;
  }
  
  public final boolean a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    b(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.gesture.GestureRecognizer
 * JD-Core Version:    0.7.0.1
 */