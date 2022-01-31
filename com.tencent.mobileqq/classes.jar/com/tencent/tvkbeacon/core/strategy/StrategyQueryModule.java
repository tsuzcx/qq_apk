package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import com.tencent.tvkbeacon.core.a.d;
import com.tencent.tvkbeacon.core.b.g;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.event.UserAction;
import com.tencent.tvkbeacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StrategyQueryModule
  extends com.tencent.tvkbeacon.core.b
{
  public static final int CheckApp = 1;
  public static final int EndQuery = 3;
  public static final String LAST_SUCCESS_STRATEGY_QUERY_TIME = "last_success_strategy_query_time";
  public static final int Launch = 0;
  private static final Object QUERY_STATE_LOCK = new Object();
  public static final int StartQuery = 2;
  public static final String TODAY_SUCCESS_STRATEGY_QUERY_TIMES = "today_success_strategy_query_times";
  public static final int WaitNextQuery = 4;
  private static StrategyQueryModule mInstance = null;
  private boolean atLeastAComQueryEnd = false;
  private boolean atLeastAComQuerySuccess = false;
  private int commonQueryTime = 0;
  protected int currentQueryStep = 0;
  protected boolean isAppFirstRun = false;
  private InitHandleListener mInitHandleListener;
  protected b strategy = null;
  private com.tencent.tvkbeacon.core.b.f strategyHandler = null;
  private e strategyQueryRunner = null;
  protected g uploadHandler = null;
  
  private StrategyQueryModule(Context paramContext)
  {
    super(paramContext);
    this.uploadHandler = h.a(paramContext);
    this.strategy = b.a();
    this.strategyHandler = new f(paramContext);
    this.uploadHandler.a(101, getStrategyHandler());
    this.strategyQueryRunner = new e(paramContext);
  }
  
  public static StrategyQueryModule getInstance()
  {
    try
    {
      StrategyQueryModule localStrategyQueryModule = mInstance;
      return localStrategyQueryModule;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static StrategyQueryModule getInstance(Context paramContext)
  {
    try
    {
      if ((mInstance == null) && (paramContext != null)) {
        mInstance = new StrategyQueryModule(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static g getMyUpload()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 46	com/tencent/tvkbeacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/tvkbeacon/core/strategy/StrategyQueryModule;
    //   6: ifnull +15 -> 21
    //   9: getstatic 46	com/tencent/tvkbeacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/tvkbeacon/core/strategy/StrategyQueryModule;
    //   12: invokespecial 110	com/tencent/tvkbeacon/core/strategy/StrategyQueryModule:getStrategyUploadHandler	()Lcom/tencent/tvkbeacon/core/b/g;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aconst_null
    //   22: astore_0
    //   23: goto -7 -> 16
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	8	0	localg	g
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  private g getStrategyUploadHandler()
  {
    try
    {
      g localg = this.uploadHandler;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCommonQueryTime()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      int i = this.commonQueryTime;
      return i;
    }
  }
  
  public int getCurrentQueryStep()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      int i = this.currentQueryStep;
      return i;
    }
  }
  
  public b getStrategy()
  {
    try
    {
      b localb = this.strategy;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public com.tencent.tvkbeacon.core.b.f getStrategyHandler()
  {
    try
    {
      com.tencent.tvkbeacon.core.b.f localf = this.strategyHandler;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAppFirstRun()
  {
    try
    {
      boolean bool = this.isAppFirstRun;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAtLeastAComQueryEnd()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      boolean bool = this.atLeastAComQueryEnd;
      return bool;
    }
  }
  
  public boolean isAtLeastAComQuerySuccess()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      boolean bool = this.atLeastAComQuerySuccess;
      return bool;
    }
  }
  
  public void notifyModuleDetailChanged(int paramInt, Map<String, String> paramMap)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.tvkbeacon.core.b)localIterator.next()).onModuleStrategyUpdated(paramInt, paramMap);
    }
  }
  
  public void notifyStrategyChanged(b paramb)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.tvkbeacon.core.b localb = (com.tencent.tvkbeacon.core.b)localIterator.next();
      try
      {
        localb.onStrategyUpdated(paramb);
      }
      catch (Throwable localThrowable)
      {
        c.a(localThrowable);
        c.d("[strategy] error %s", new Object[] { localThrowable.toString() });
      }
    }
  }
  
  public void onFirstStrategyQueryFinished()
  {
    super.onFirstStrategyQueryFinished();
    if (this.mInitHandleListener != null) {
      this.mInitHandleListener.onInitEnd();
    }
  }
  
  public void onSDKInit(Context paramContext)
  {
    super.onSDKInit(paramContext);
    c.b("[module] strategy module > TRUE", new Object[0]);
    startQuery();
    d.a().a(paramContext, new StrategyQueryModule.1(this, paramContext));
  }
  
  public void onStrategyQueryFinished()
  {
    super.onStrategyQueryFinished();
    if (this.mInitHandleListener != null) {
      this.mInitHandleListener.onStrategyQuerySuccess();
    }
  }
  
  public void onStrategyUpdated(b paramb)
  {
    super.onStrategyUpdated(paramb);
    this.strategy.j();
  }
  
  public void setAppFirstRun(boolean paramBoolean)
  {
    try
    {
      this.isAppFirstRun = paramBoolean;
      c.f("[strategy] set isFirst: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAtLeastAComQueryEnd(boolean paramBoolean)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.atLeastAComQueryEnd = paramBoolean;
      return;
    }
  }
  
  public void setAtLeastAComQuerySuccess(boolean paramBoolean)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.atLeastAComQuerySuccess = paramBoolean;
      return;
    }
  }
  
  public void setCommonQueryTime(int paramInt)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.commonQueryTime = paramInt;
      return;
    }
  }
  
  public void setCommonStrategy(b paramb)
  {
    try
    {
      this.strategy = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void setCurrentQueryStep(int paramInt)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.currentQueryStep = paramInt;
      c.f("[strategy] current query step:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 3) {
        setAtLeastAComQueryEnd(true);
      }
      return;
    }
  }
  
  public void setInitHandleListener(InitHandleListener paramInitHandleListener)
  {
    this.mInitHandleListener = paramInitHandleListener;
  }
  
  public void startQuery()
  {
    try
    {
      if (!this.strategyQueryRunner.a) {
        com.tencent.tvkbeacon.core.a.b.d().a(this.strategyQueryRunner);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.StrategyQueryModule
 * JD-Core Version:    0.7.0.1
 */