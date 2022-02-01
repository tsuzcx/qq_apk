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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

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
  
  /* Error */
  private final void addClick(MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 108	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:currentClick	Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 108	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:currentClick	Lcom/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +6 -> 30
    //   27: invokestatic 111	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   30: aload_1
    //   31: invokevirtual 117	android/view/MotionEvent:getActionIndex	()I
    //   34: istore_2
    //   35: aload_1
    //   36: iload_2
    //   37: invokevirtual 121	android/view/MotionEvent:getX	(I)F
    //   40: aload_3
    //   41: invokevirtual 127	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartX	()F
    //   44: fsub
    //   45: invokestatic 133	java/lang/Math:abs	(F)F
    //   48: fconst_1
    //   49: fcmpl
    //   50: ifgt -35 -> 15
    //   53: aload_1
    //   54: iload_2
    //   55: invokevirtual 136	android/view/MotionEvent:getY	(I)F
    //   58: aload_3
    //   59: invokevirtual 139	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartY	()F
    //   62: fsub
    //   63: invokestatic 133	java/lang/Math:abs	(F)F
    //   66: fconst_1
    //   67: fcmpl
    //   68: ifgt -53 -> 15
    //   71: aload_3
    //   72: aload_1
    //   73: iload_2
    //   74: invokevirtual 121	android/view/MotionEvent:getX	(I)F
    //   77: invokevirtual 143	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setEndX	(F)V
    //   80: aload_3
    //   81: aload_1
    //   82: iload_2
    //   83: invokevirtual 136	android/view/MotionEvent:getY	(I)F
    //   86: invokevirtual 146	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setEndY	(F)V
    //   89: aload_3
    //   90: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   93: aload_3
    //   94: invokevirtual 155	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getTimestamp	()J
    //   97: lsub
    //   98: invokevirtual 159	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setDuration	(J)V
    //   101: aload_3
    //   102: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   105: invokevirtual 162	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setTimestamp	(J)V
    //   108: aload_0
    //   109: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   112: aload_3
    //   113: invokeinterface 166 2 0
    //   118: pop
    //   119: aload_0
    //   120: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   123: invokeinterface 169 1 0
    //   128: bipush 10
    //   130: if_icmple -115 -> 15
    //   133: aload_0
    //   134: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   137: invokeinterface 173 1 0
    //   142: pop
    //   143: goto -128 -> 15
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	TouchEventManager
    //   0	151	1	paramMotionEvent	MotionEvent
    //   34	49	2	i	int
    //   10	103	3	localClick	TouchEventManager.Click
    // Exception table:
    //   from	to	target	type
    //   6	11	146	finally
    //   18	23	146	finally
    //   27	30	146	finally
    //   30	143	146	finally
  }
  
  /* Error */
  private final ArrayList<TTTouchEvents> getCurTouchListCopy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: checkcast 92	java/util/ArrayList
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 95	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mCurTouchList	Ljava/util/ArrayList;
    //   11: checkcast 175	java/util/Collection
    //   14: invokeinterface 179 1 0
    //   19: ifne +35 -> 54
    //   22: iconst_1
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq +25 -> 50
    //   28: new 92	java/util/ArrayList
    //   31: dup
    //   32: aload_0
    //   33: getfield 95	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mCurTouchList	Ljava/util/ArrayList;
    //   36: checkcast 175	java/util/Collection
    //   39: invokespecial 182	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 95	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mCurTouchList	Ljava/util/ArrayList;
    //   47: invokevirtual 184	java/util/ArrayList:clear	()V
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: areturn
    //   54: iconst_0
    //   55: istore_1
    //   56: goto -32 -> 24
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	TouchEventManager
    //   23	33	1	i	int
    //   6	47	2	localArrayList	ArrayList
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	59	finally
    //   28	50	59	finally
  }
  
  private final void onTouch(int paramInt)
  {
    this.mTTTouchEvents.action = paramInt;
    TTTouchEvents localTTTouchEvents = this.mTTTouchEvents.copy();
    if (localTTTouchEvents.action == 5) {
      localTTTouchEvents.action = 0;
    }
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localTTTouchEvents, "touchEvent");
      handleTouchEvent(localTTTouchEvents);
      return;
      if (localTTTouchEvents.action == 6) {
        localTTTouchEvents.action = 1;
      }
    }
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
    if (localArrayList != null) {
      if (((Collection)localArrayList).isEmpty()) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.listener.invoke(localArrayList);
      }
      return;
    }
  }
  
  @NotNull
  public final String getLastClicks()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      Iterator localIterator = this.lastClicks.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        TouchEventManager.Click localClick = (TouchEventManager.Click)localIterator.next();
        if (i == 0) {
          localStringBuilder.append(',');
        }
        i = 0;
        localStringBuilder.append('[').append(localClick.getStartX()).append(',').append(localClick.getStartY()).append(',').append(localClick.getEndX()).append(',').append(localClick.getEndY()).append(',').append(localClick.getTimestamp()).append("]");
      }
      localObject.append("]");
    }
    finally {}
    String str = localObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "sb.toString()");
    return str;
  }
  
  @NotNull
  public final String getTheLastClickInfo()
  {
    try
    {
      Object localObject1 = new JSONObject();
      TouchEventManager.Click localClick = (TouchEventManager.Click)CollectionsKt.last((Iterable)this.lastClicks);
      ((JSONObject)localObject1).put("tsx", Float.valueOf(localClick.getStartX()));
      ((JSONObject)localObject1).put("tsy", Float.valueOf(localClick.getStartY()));
      ((JSONObject)localObject1).put("tex", Float.valueOf(localClick.getEndX()));
      ((JSONObject)localObject1).put("tey", Float.valueOf(localClick.getEndY()));
      ((JSONObject)localObject1).put("td", localClick.getDuration());
      localObject1 = ((JSONObject)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "res.toString()");
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public final void handleTouchEvent(@NotNull TTTouchEvents paramTTTouchEvents)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramTTTouchEvents, "touchEvent");
      paramTTTouchEvents.timeStamp = (System.currentTimeMillis() - this.mGameBeginTime);
      this.mCurTouchList.add(paramTTTouchEvents);
      return;
    }
    finally
    {
      paramTTTouchEvents = finally;
      throw paramTTTouchEvents;
    }
  }
  
  public final boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "motionEvent");
    int k = paramMotionEvent.getActionIndex();
    int n = paramMotionEvent.getPointerId(k);
    float f1 = paramMotionEvent.getX(k) / this.mScreenScale;
    float f2 = paramMotionEvent.getY(k) / this.mScreenScale;
    int m = paramMotionEvent.getActionMasked();
    this.mTTTouchEvents.changedTouches.clear();
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
    case 1: 
      for (;;)
      {
        return true;
        Touch localTouch = new Touch(n, f1, f2);
        this.mTTTouchEvents.touches.add(localTouch);
        this.mTTTouchEvents.changedTouches.add(localTouch);
        onTouch(m);
        if (m == 0)
        {
          this.currentClick = new TouchEventManager.Click(paramMotionEvent.getX(k), paramMotionEvent.getY(k));
          continue;
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
          if (this.mTTTouchEvents.changedTouches.size() > 0)
          {
            onTouch(m);
            continue;
            do
            {
              j += 1;
              if (j >= this.mTTTouchEvents.touches.size()) {
                break;
              }
              localTouch = (Touch)this.mTTTouchEvents.touches.get(j);
            } while (localTouch.identifier != n);
            this.mTTTouchEvents.changedTouches.add(localTouch);
            this.mTTTouchEvents.touches.clear();
            onTouch(m);
            addClick(paramMotionEvent);
          }
        }
      }
    case 6: 
      do
      {
        i += 1;
        if (i >= this.mTTTouchEvents.touches.size()) {
          break;
        }
        paramMotionEvent = (Touch)this.mTTTouchEvents.touches.get(i);
      } while (paramMotionEvent.identifier != n);
      this.mTTTouchEvents.changedTouches.add(paramMotionEvent);
    }
    for (;;)
    {
      if ((this.mTTTouchEvents.touches.size() > 0) && (this.mTTTouchEvents.touches.size() > i)) {
        this.mTTTouchEvents.touches.remove(i);
      }
      onTouch(m);
      break;
      this.mTTTouchEvents.changedTouches.addAll((Collection)this.mTTTouchEvents.touches);
      this.mTTTouchEvents.touches.clear();
      onTouch(m);
      break;
      i = k;
    }
  }
  
  public final void setBeginTime(long paramLong)
  {
    this.mGameBeginTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.touch.TouchEventManager
 * JD-Core Version:    0.7.0.1
 */