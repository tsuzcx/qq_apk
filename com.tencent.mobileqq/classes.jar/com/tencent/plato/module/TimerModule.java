package com.tencent.plato.module;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.IFunction;

public class TimerModule
  extends ExportedModule
{
  private final SparseArray<TimerRunnable> mRunnableArray = new SparseArray();
  
  public TimerModule()
  {
    super("Timer");
  }
  
  @Exported("clearInterval")
  public void clearInterval(IPlatoRuntime paramIPlatoRuntime, int paramInt)
  {
    TimerRunnable localTimerRunnable = (TimerRunnable)this.mRunnableArray.get(paramInt);
    if (localTimerRunnable != null)
    {
      this.mRunnableArray.remove(paramInt);
      paramIPlatoRuntime.getThreadHandler().removeCallbacks(localTimerRunnable);
      localTimerRunnable.timerFunc.free();
    }
  }
  
  @Exported("clearTimeout")
  public void clearTimeout(IPlatoRuntime paramIPlatoRuntime, int paramInt)
  {
    TimerRunnable localTimerRunnable = (TimerRunnable)this.mRunnableArray.get(paramInt);
    if (localTimerRunnable != null)
    {
      this.mRunnableArray.remove(paramInt);
      paramIPlatoRuntime.getThreadHandler().removeCallbacks(localTimerRunnable);
      localTimerRunnable.timerFunc.free();
    }
  }
  
  @Exported("setInterval")
  public void setInterval(final IPlatoRuntime paramIPlatoRuntime, int paramInt, final IFunction paramIFunction, final long paramLong)
  {
    paramIFunction = new TimerRunnable(paramIFunction)
    {
      public void run()
      {
        paramIFunction.invokeAlive(new Object[0]);
        paramIPlatoRuntime.getThreadHandler().postDelayed(this, paramLong);
      }
    };
    this.mRunnableArray.put(paramInt, paramIFunction);
    paramIPlatoRuntime.getThreadHandler().postDelayed(paramIFunction, paramLong);
  }
  
  @Exported("setTimeout")
  public void setTimeout(IPlatoRuntime paramIPlatoRuntime, final int paramInt, final IFunction paramIFunction, long paramLong)
  {
    paramIFunction = new TimerRunnable(paramIFunction)
    {
      public void run()
      {
        TimerModule.this.mRunnableArray.remove(paramInt);
        paramIFunction.invoke(new Object[0]);
      }
    };
    this.mRunnableArray.put(paramInt, paramIFunction);
    paramIPlatoRuntime.getThreadHandler().postDelayed(paramIFunction, paramLong);
  }
  
  private static abstract class TimerRunnable
    implements Runnable
  {
    final IFunction timerFunc;
    
    TimerRunnable(IFunction paramIFunction)
    {
      this.timerFunc = paramIFunction;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.module.TimerModule
 * JD-Core Version:    0.7.0.1
 */