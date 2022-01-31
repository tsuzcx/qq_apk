package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;

public class FilterEngineFactory
{
  private static FilterEngineFactory sIntance;
  private Handler handler;
  private FilterContext mFilterContext = null;
  private HandlerThread mGlThread;
  String mThreadOwner;
  
  private FilterEngineFactory()
  {
    initGlThread();
  }
  
  public static void destroyInstance()
  {
    if (sIntance != null) {
      sIntance.destroy();
    }
  }
  
  /* Error */
  public static FilterEngineFactory getInstance()
  {
    // Byte code:
    //   0: getstatic 44	com/tencent/view/FilterEngineFactory:sIntance	Lcom/tencent/view/FilterEngineFactory;
    //   3: ifnonnull +33 -> 36
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 44	com/tencent/view/FilterEngineFactory:sIntance	Lcom/tencent/view/FilterEngineFactory;
    //   12: ifnonnull +21 -> 33
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/view/FilterEngineFactory
    //   21: dup
    //   22: invokespecial 51	com/tencent/view/FilterEngineFactory:<init>	()V
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: putstatic 44	com/tencent/view/FilterEngineFactory:sIntance	Lcom/tencent/view/FilterEngineFactory;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 44	com/tencent/view/FilterEngineFactory:sIntance	Lcom/tencent/view/FilterEngineFactory;
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: goto -12 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	5	0	localFilterEngineFactory	FilterEngineFactory
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    //   52	1	0	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	26	40	finally
    //   41	44	40	finally
    //   9	18	46	finally
    //   29	33	46	finally
    //   33	36	46	finally
    //   44	46	46	finally
    //   47	50	46	finally
    //   26	29	52	finally
  }
  
  private void initGlThread()
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        FilterEngineFactory.access$002(FilterEngineFactory.this, new FilterContext());
        FilterEngineFactory.this.mFilterContext.usecurruntContext();
        FilterEngineFactory.this.mThreadOwner = Thread.currentThread().getName();
      }
    };
    this.mGlThread = new HandlerThread("GlThread")
    {
      protected void onLooperPrepared()
      {
        super.onLooperPrepared();
      }
    };
    this.mGlThread.start();
    this.handler = new Handler(this.mGlThread.getLooper());
    this.handler.post(local2);
  }
  
  public void destroy()
  {
    queue(new Runnable()
    {
      public void run()
      {
        if (FilterEngineFactory.this.mFilterContext != null)
        {
          FilterEngineFactory.this.mFilterContext.destroyEgl();
          FilterEngineFactory.access$002(FilterEngineFactory.this, null);
        }
        if ((FilterEngineFactory.this.mGlThread != null) && (FilterEngineFactory.this.mGlThread.isAlive()))
        {
          FilterEngineFactory.this.mGlThread.quit();
          FilterEngineFactory.access$102(FilterEngineFactory.this, null);
        }
        FilterEngineFactory.access$202(null);
      }
    });
  }
  
  public void queue(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
  
  public boolean usecurruntContext()
  {
    if (this.mFilterContext != null) {
      return this.mFilterContext.usecurruntContext();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.view.FilterEngineFactory
 * JD-Core Version:    0.7.0.1
 */