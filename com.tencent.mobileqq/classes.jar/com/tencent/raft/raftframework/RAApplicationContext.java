package com.tencent.raft.raftframework;

import android.content.Context;
import com.tencent.raft.raftframework.declare.IRADeclareManager;
import com.tencent.raft.raftframework.declare.RADeclareManager;
import com.tencent.raft.raftframework.log.ILogDelegate;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.IRAServiceManager;
import com.tencent.raft.raftframework.service.RAServiceManager;
import com.tencent.raft.raftframework.sla.SLAReporter;

public class RAApplicationContext
{
  public static final String INIT_CLASS = "com.tencent.raft.generate.RaftServiceEntryMap";
  public static final String TAG = "RAApplicationContext";
  private static RAApplicationContext sInstance;
  private Context mContext;
  private IRADeclareManager mDeclareManager;
  private boolean mHasStartUp = false;
  private SLAReporter mSLAReporter;
  private IRAServiceManager mServiceManager;
  
  public static RAApplicationContext getGlobalContext()
  {
    if (sInstance == null) {
      sInstance = new RAApplicationContext();
    }
    return sInstance;
  }
  
  public static RAApplicationContext newInstance()
  {
    return new RAApplicationContext();
  }
  
  public static void setLogDelegate(ILogDelegate paramILogDelegate)
  {
    RLog.setLogDelegate(paramILogDelegate);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getDeclareConstant(String paramString)
  {
    try
    {
      paramString = this.mDeclareManager.getDeclareConstant(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public Object getDeclareService(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 62	java/lang/System:nanoTime	()J
    //   5: lstore_2
    //   6: aload_0
    //   7: getfield 50	com/tencent/raft/raftframework/RAApplicationContext:mDeclareManager	Lcom/tencent/raft/raftframework/declare/IRADeclareManager;
    //   10: aload_1
    //   11: invokeinterface 64 2 0
    //   16: astore_1
    //   17: aload_0
    //   18: getfield 66	com/tencent/raft/raftframework/RAApplicationContext:mSLAReporter	Lcom/tencent/raft/raftframework/sla/SLAReporter;
    //   21: astore 5
    //   23: aload_1
    //   24: ifnull +18 -> 42
    //   27: iconst_1
    //   28: istore 4
    //   30: aload 5
    //   32: lload_2
    //   33: iload 4
    //   35: invokevirtual 72	com/tencent/raft/raftframework/sla/SLAReporter:reportGetServiceFinish	(JZ)V
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: iconst_0
    //   43: istore 4
    //   45: goto -15 -> 30
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	RAApplicationContext
    //   0	53	1	paramString	String
    //   5	28	2	l	long
    //   28	16	4	bool	boolean
    //   21	10	5	localSLAReporter	SLAReporter
    // Exception table:
    //   from	to	target	type
    //   2	23	48	finally
    //   30	38	48	finally
  }
  
  public <T> T getService(Class<T> paramClass)
  {
    try
    {
      paramClass = getService(paramClass, null);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  public <T> T getService(Class<T> paramClass, IServiceProvider paramIServiceProvider)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 62	java/lang/System:nanoTime	()J
    //   5: lstore_3
    //   6: aload_0
    //   7: getfield 81	com/tencent/raft/raftframework/RAApplicationContext:mServiceManager	Lcom/tencent/raft/raftframework/service/IRAServiceManager;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 84 3 0
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 66	com/tencent/raft/raftframework/RAApplicationContext:mSLAReporter	Lcom/tencent/raft/raftframework/sla/SLAReporter;
    //   22: astore_2
    //   23: aload_1
    //   24: ifnull +17 -> 41
    //   27: iconst_1
    //   28: istore 5
    //   30: aload_2
    //   31: lload_3
    //   32: iload 5
    //   34: invokevirtual 72	com/tencent/raft/raftframework/sla/SLAReporter:reportGetServiceFinish	(JZ)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: iconst_0
    //   42: istore 5
    //   44: goto -14 -> 30
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	RAApplicationContext
    //   0	52	1	paramClass	Class<T>
    //   0	52	2	paramIServiceProvider	IServiceProvider
    //   5	27	3	l	long
    //   28	15	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	47	finally
    //   30	37	47	finally
  }
  
  public boolean hasStartUp()
  {
    return this.mHasStartUp;
  }
  
  public void shutdown()
  {
    try
    {
      RLog.d("RAApplicationContext", new Object[] { "shutdown [" + hashCode() + "]" });
      this.mHasStartUp = false;
      this.mServiceManager.destroy();
      this.mServiceManager = null;
      this.mDeclareManager.destroy();
      this.mDeclareManager = null;
      if (this.mSLAReporter != null)
      {
        this.mSLAReporter.release();
        this.mSLAReporter = null;
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  public void startup(Context paramContext)
  {
    try
    {
      startup(paramContext, true);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void startup(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (this.mSLAReporter == null) {
        this.mSLAReporter = new SLAReporter(paramContext);
      }
      this.mSLAReporter.open(paramBoolean);
      this.mSLAReporter.reportOnFrameworkStartup();
      RLog.d("RAApplicationContext", new Object[] { "startup [" + hashCode() + "], current RAFT version:" + "com.raft.uas/v1alpha2" });
      if (this.mHasStartUp)
      {
        RLog.e("RAApplicationContext", new Object[] { "cannot startup again" });
        throw new IllegalStateException("cannot startup again");
      }
    }
    finally {}
    this.mContext = paramContext;
    this.mServiceManager = new RAServiceManager("com.tencent.raft.generate.RaftServiceEntryMap");
    this.mDeclareManager = new RADeclareManager("com.tencent.raft.generate.RaftServiceEntryMap");
    this.mHasStartUp = true;
    this.mSLAReporter.reportOnFrameworkStartupFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.RAApplicationContext
 * JD-Core Version:    0.7.0.1
 */