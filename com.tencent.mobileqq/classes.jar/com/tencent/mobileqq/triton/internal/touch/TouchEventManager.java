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
    //   41: invokevirtual 126	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartX	()I
    //   44: i2f
    //   45: aload_0
    //   46: getfield 83	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mScreenScale	F
    //   49: fmul
    //   50: fsub
    //   51: invokestatic 132	java/lang/Math:abs	(F)F
    //   54: fconst_1
    //   55: fcmpl
    //   56: ifgt -41 -> 15
    //   59: aload_1
    //   60: iload_2
    //   61: invokevirtual 135	android/view/MotionEvent:getY	(I)F
    //   64: aload_3
    //   65: invokevirtual 138	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getStartY	()I
    //   68: i2f
    //   69: aload_0
    //   70: getfield 83	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mScreenScale	F
    //   73: fmul
    //   74: fsub
    //   75: invokestatic 132	java/lang/Math:abs	(F)F
    //   78: fconst_1
    //   79: fcmpl
    //   80: ifgt -65 -> 15
    //   83: aload_3
    //   84: aload_1
    //   85: iload_2
    //   86: invokevirtual 121	android/view/MotionEvent:getX	(I)F
    //   89: aload_0
    //   90: getfield 83	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mScreenScale	F
    //   93: fdiv
    //   94: f2i
    //   95: invokevirtual 142	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setEndX	(I)V
    //   98: aload_3
    //   99: aload_1
    //   100: iload_2
    //   101: invokevirtual 135	android/view/MotionEvent:getY	(I)F
    //   104: aload_0
    //   105: getfield 83	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mScreenScale	F
    //   108: fdiv
    //   109: f2i
    //   110: invokevirtual 145	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setEndY	(I)V
    //   113: aload_3
    //   114: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   117: aload_3
    //   118: invokevirtual 154	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:getTimestamp	()J
    //   121: lsub
    //   122: invokevirtual 158	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setDuration	(J)V
    //   125: aload_3
    //   126: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   129: invokevirtual 161	com/tencent/mobileqq/triton/internal/touch/TouchEventManager$Click:setTimestamp	(J)V
    //   132: aload_0
    //   133: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   136: aload_3
    //   137: invokeinterface 165 2 0
    //   142: pop
    //   143: aload_0
    //   144: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   147: invokeinterface 168 1 0
    //   152: bipush 10
    //   154: if_icmple -139 -> 15
    //   157: aload_0
    //   158: getfield 102	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:lastClicks	Ljava/util/Queue;
    //   161: invokeinterface 172 1 0
    //   166: pop
    //   167: goto -152 -> 15
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	TouchEventManager
    //   0	175	1	paramMotionEvent	MotionEvent
    //   34	67	2	i	int
    //   10	127	3	localClick	TouchEventManager.Click
    // Exception table:
    //   from	to	target	type
    //   6	11	170	finally
    //   18	23	170	finally
    //   27	30	170	finally
    //   30	167	170	finally
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
    //   11: checkcast 174	java/util/Collection
    //   14: invokeinterface 178 1 0
    //   19: ifne +35 -> 54
    //   22: iconst_1
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq +25 -> 50
    //   28: new 92	java/util/ArrayList
    //   31: dup
    //   32: aload_0
    //   33: getfield 95	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mCurTouchList	Ljava/util/ArrayList;
    //   36: checkcast 174	java/util/Collection
    //   39: invokespecial 181	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 95	com/tencent/mobileqq/triton/internal/touch/TouchEventManager:mCurTouchList	Ljava/util/ArrayList;
    //   47: invokevirtual 183	java/util/ArrayList:clear	()V
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
          this.currentClick = new TouchEventManager.Click((int)(paramMotionEvent.getX(k) / this.mScreenScale), (int)(paramMotionEvent.getY(k) / this.mScreenScale));
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