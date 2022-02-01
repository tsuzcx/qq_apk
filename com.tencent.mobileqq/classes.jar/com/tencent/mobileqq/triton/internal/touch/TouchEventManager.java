package com.tencent.mobileqq.triton.internal.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.triton.touch.TTTouchEvents;
import com.tencent.mobileqq.triton.touch.Touch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager;", "", "mScreenScale", "", "listener", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/touch/TTTouchEvents;", "", "(FLkotlin/jvm/functions/Function1;)V", "curTouchListCopy", "getCurTouchListCopy", "()Ljava/util/ArrayList;", "currentClick", "Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;", "lastClicks", "Ljava/util/Queue;", "mCurTouchList", "mGameBeginTime", "", "mTTTouchEvents", "addClick", "motionEvent", "Landroid/view/MotionEvent;", "clear", "flushTouchEvents", "getLastClicks", "", "getTheLastClickInfo", "handleTouchEvent", "touchEvent", "onTouch", "action", "", "onTouchEvent", "", "setBeginTime", "time", "Click", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
final class TouchEventManager
{
  public static final TouchEventManager.Companion Companion = new TouchEventManager.Companion(null);
  private static final int MAX_CLICKS = 10;
  private TouchEventManager.Click currentClick;
  private final Queue<TouchEventManager.Click> lastClicks;
  private final Function1<ArrayList<TTTouchEvents>, Unit> listener;
  private final ArrayList<TTTouchEvents> mCurTouchList;
  private long mGameBeginTime;
  private final float mScreenScale;
  private final TTTouchEvents mTTTouchEvents;
  
  public TouchEventManager(float paramFloat, @NotNull Function1<? super ArrayList<TTTouchEvents>, Unit> paramFunction1)
  {
    this.mScreenScale = paramFloat;
    this.listener = paramFunction1;
    this.mTTTouchEvents = new TTTouchEvents();
    this.mCurTouchList = new ArrayList();
    this.lastClicks = ((Queue)new LinkedList());
  }
  
  private final void addClick(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      try
      {
        if (this.currentClick != null)
        {
          TouchEventManager.Click localClick = this.currentClick;
          if (localClick == null) {
            Intrinsics.throwNpe();
          }
          int i = paramMotionEvent.getActionIndex();
          if ((Math.abs(paramMotionEvent.getX(i) - localClick.getStartX() * this.mScreenScale) <= 1.0F) && (Math.abs(paramMotionEvent.getY(i) - localClick.getStartY() * this.mScreenScale) <= 1.0F))
          {
            localClick.setEndX((int)(paramMotionEvent.getX(i) / this.mScreenScale));
            localClick.setEndY((int)(paramMotionEvent.getY(i) / this.mScreenScale));
            localClick.setDuration(System.currentTimeMillis() - localClick.getTimestamp());
            localClick.setTimestamp(System.currentTimeMillis());
            this.lastClicks.offer(localClick);
            if (this.lastClicks.size() > 10) {
              this.lastClicks.poll();
            }
            return;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  private final ArrayList<TTTouchEvents> getCurTouchListCopy()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)null;
      if ((((Collection)this.mCurTouchList).isEmpty() ^ true))
      {
        localArrayList = new ArrayList((Collection)this.mCurTouchList);
        this.mCurTouchList.clear();
      }
      return localArrayList;
    }
    finally {}
  }
  
  private final void onTouch(int paramInt)
  {
    TTTouchEvents localTTTouchEvents = this.mTTTouchEvents;
    localTTTouchEvents.action = paramInt;
    localTTTouchEvents = localTTTouchEvents.copy();
    if (localTTTouchEvents.action == 5) {
      localTTTouchEvents.action = 0;
    } else if (localTTTouchEvents.action == 6) {
      localTTTouchEvents.action = 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(localTTTouchEvents, "touchEvent");
    handleTouchEvent(localTTTouchEvents);
  }
  
  public final void clear()
  {
    this.mTTTouchEvents.touches.clear();
    this.mTTTouchEvents.changedTouches.clear();
    this.mCurTouchList.clear();
    this.lastClicks.clear();
  }
  
  public final void flushTouchEvents()
  {
    ArrayList localArrayList = getCurTouchListCopy();
    if ((localArrayList != null) && ((((Collection)localArrayList).isEmpty() ^ true))) {
      this.listener.invoke(localArrayList);
    }
  }
  
  @NotNull
  public final String getLastClicks()
  {
    try
    {
      Object localObject1 = new StringBuilder("[");
      int i = 1;
      Iterator localIterator = this.lastClicks.iterator();
      while (localIterator.hasNext())
      {
        TouchEventManager.Click localClick = (TouchEventManager.Click)localIterator.next();
        if (i == 0) {
          ((StringBuilder)localObject1).append(',');
        }
        i = 0;
        ((StringBuilder)localObject1).append('[');
        ((StringBuilder)localObject1).append(localClick.getStartX());
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(localClick.getStartY());
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(localClick.getEndX());
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(localClick.getEndY());
        ((StringBuilder)localObject1).append(',');
        ((StringBuilder)localObject1).append(localClick.getTimestamp());
        ((StringBuilder)localObject1).append("]");
      }
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "sb.toString()");
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  @NotNull
  public final String getTheLastClickInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 263	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 264	org/json/JSONObject:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   14: checkcast 266	java/lang/Iterable
    //   17: invokestatic 272	kotlin/collections/CollectionsKt:last	(Ljava/lang/Iterable;)Ljava/lang/Object;
    //   20: checkcast 123	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click
    //   23: astore_2
    //   24: aload_1
    //   25: ldc_w 274
    //   28: aload_2
    //   29: invokevirtual 126	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartX	()I
    //   32: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   35: pop
    //   36: aload_1
    //   37: ldc_w 280
    //   40: aload_2
    //   41: invokevirtual 138	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartY	()I
    //   44: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 282
    //   52: aload_2
    //   53: invokevirtual 242	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getEndX	()I
    //   56: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_1
    //   61: ldc_w 284
    //   64: aload_2
    //   65: invokevirtual 245	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getEndY	()I
    //   68: invokevirtual 278	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_1
    //   73: ldc_w 286
    //   76: aload_2
    //   77: invokevirtual 289	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getDuration	()J
    //   80: invokevirtual 292	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_1
    //   85: invokevirtual 293	org/json/JSONObject:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload_1
    //   90: ldc_w 295
    //   93: invokestatic 194	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: areturn
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: goto -22 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	TouchEventManager
    //   9	90	1	localObject1	Object
    //   100	4	1	localObject2	Object
    //   23	54	2	localClick	TouchEventManager.Click
    //   105	1	2	localNoSuchElementException	java.util.NoSuchElementException
    // Exception table:
    //   from	to	target	type
    //   2	10	100	finally
    //   10	84	100	finally
    //   84	96	100	finally
    //   10	84	105	java/util/NoSuchElementException
  }
  
  public final void handleTouchEvent(@NotNull TTTouchEvents paramTTTouchEvents)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramTTTouchEvents, "touchEvent");
      double d1 = System.currentTimeMillis();
      long l = this.mGameBeginTime;
      double d2 = l;
      Double.isNaN(d1);
      Double.isNaN(d2);
      paramTTTouchEvents.timeStamp = (d1 - d2);
      this.mCurTouchList.add(paramTTTouchEvents);
      return;
    }
    finally {}
  }
  
  public final boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "motionEvent");
    int k = paramMotionEvent.getActionIndex();
    int n = paramMotionEvent.getPointerId(k);
    float f1 = paramMotionEvent.getX(k) / this.mScreenScale;
    float f2 = paramMotionEvent.getY(k) / this.mScreenScale;
    int m = paramMotionEvent.getActionMasked();
    this.mTTTouchEvents.changedTouches.clear();
    if (m != 0)
    {
      int i = 0;
      int j = 0;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 5)
            {
              i = j;
              if (m != 6) {
                return true;
              }
              for (;;)
              {
                j = k;
                if (i >= this.mTTTouchEvents.touches.size()) {
                  break;
                }
                paramMotionEvent = (Touch)this.mTTTouchEvents.touches.get(i);
                if (paramMotionEvent.identifier == n)
                {
                  this.mTTTouchEvents.changedTouches.add(paramMotionEvent);
                  j = i;
                  break;
                }
                i += 1;
              }
              if ((this.mTTTouchEvents.touches.size() > 0) && (this.mTTTouchEvents.touches.size() > j)) {
                this.mTTTouchEvents.touches.remove(j);
              }
              onTouch(m);
              return true;
            }
          }
          else
          {
            this.mTTTouchEvents.changedTouches.addAll((Collection)this.mTTTouchEvents.touches);
            this.mTTTouchEvents.touches.clear();
            onTouch(m);
            return true;
          }
        }
        else
        {
          i = 0;
          while (i < paramMotionEvent.getPointerCount())
          {
            k = paramMotionEvent.getPointerId(i);
            j = 0;
            while (j < this.mTTTouchEvents.touches.size())
            {
              localTouch = (Touch)this.mTTTouchEvents.touches.get(j);
              if (localTouch.identifier == k)
              {
                f1 = paramMotionEvent.getX(i) / this.mScreenScale;
                f2 = paramMotionEvent.getY(i) / this.mScreenScale;
                if ((Math.abs(localTouch.screenX - f1) >= 0.01F) || (Math.abs(localTouch.screenY - f2) >= 0.01F))
                {
                  localTouch.setLocation(f1, f2);
                  this.mTTTouchEvents.changedTouches.add(localTouch);
                }
              }
              j += 1;
            }
            i += 1;
          }
          if (this.mTTTouchEvents.changedTouches.size() <= 0) {
            break label626;
          }
          onTouch(m);
          return true;
        }
      }
      else
      {
        while (i < this.mTTTouchEvents.touches.size())
        {
          localTouch = (Touch)this.mTTTouchEvents.touches.get(i);
          if (localTouch.identifier == n)
          {
            this.mTTTouchEvents.changedTouches.add(localTouch);
            break;
          }
          i += 1;
        }
        this.mTTTouchEvents.touches.clear();
        onTouch(m);
        addClick(paramMotionEvent);
        return true;
      }
    }
    Touch localTouch = new Touch(n, f1, f2);
    this.mTTTouchEvents.touches.add(localTouch);
    this.mTTTouchEvents.changedTouches.add(localTouch);
    onTouch(m);
    if (m == 0) {
      this.currentClick = new TouchEventManager.Click((int)(paramMotionEvent.getX(k) / this.mScreenScale), (int)(paramMotionEvent.getY(k) / this.mScreenScale));
    }
    label626:
    return true;
  }
  
  public final void setBeginTime(long paramLong)
  {
    this.mGameBeginTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchEventManager
 * JD-Core Version:    0.7.0.1
 */