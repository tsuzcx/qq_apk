package com.tencent.viola.vinstance;

import android.os.Looper;
import com.tencent.viola.core.ViolaInstance;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class BlockVInstanceAction
  extends VInstanceAction
{
  private static final int ACQUIRE_LOCK_MAX_WAIT_TIME = 300;
  private static final String TAG = "BlockVInstanceAction";
  private static final int UPDATE_MAX_WAIT_TIME = 200;
  private int acquireLockMaxWaitTime = 300;
  private final Lock updateLock = new ReentrantLock(true);
  private int updateMaxWaitTime = 200;
  private final Condition updateReady = this.updateLock.newCondition();
  
  public BlockVInstanceAction(Preconditor paramPreconditor, ViolaInstance paramViolaInstance, JSONObject paramJSONObject)
  {
    super(paramPreconditor, paramViolaInstance, paramJSONObject);
  }
  
  /* Error */
  private void tryWaitingJSOrSdkInit(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +11 -> 12
    //   4: aload_0
    //   5: getfield 51	com/tencent/viola/vinstance/BlockVInstanceAction:violaInstance	Lcom/tencent/viola/core/ViolaInstance;
    //   8: aload_1
    //   9: invokevirtual 57	com/tencent/viola/core/ViolaInstance:updateInstance	(Ljava/lang/String;)V
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_0
    //   15: getfield 30	com/tencent/viola/vinstance/BlockVInstanceAction:updateLock	Ljava/util/concurrent/locks/Lock;
    //   18: aload_0
    //   19: getfield 42	com/tencent/viola/vinstance/BlockVInstanceAction:acquireLockMaxWaitTime	I
    //   22: i2l
    //   23: getstatic 63	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   26: invokeinterface 67 4 0
    //   31: istore_3
    //   32: iload_3
    //   33: istore_2
    //   34: goto +41 -> 75
    //   37: astore_1
    //   38: new 69	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 74
    //   51: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: aload_1
    //   58: invokevirtual 82	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 11
    //   67: aload 4
    //   69: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 91	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: iload_2
    //   76: ifeq +87 -> 163
    //   79: aload_0
    //   80: getfield 38	com/tencent/viola/vinstance/BlockVInstanceAction:updateReady	Ljava/util/concurrent/locks/Condition;
    //   83: aload_0
    //   84: getfield 40	com/tencent/viola/vinstance/BlockVInstanceAction:updateMaxWaitTime	I
    //   87: i2l
    //   88: getstatic 63	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   91: invokeinterface 96 4 0
    //   96: pop
    //   97: aload_0
    //   98: getfield 30	com/tencent/viola/vinstance/BlockVInstanceAction:updateLock	Ljava/util/concurrent/locks/Lock;
    //   101: invokeinterface 99 1 0
    //   106: return
    //   107: astore_1
    //   108: goto +44 -> 152
    //   111: astore_1
    //   112: new 69	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   119: astore 4
    //   121: aload 4
    //   123: ldc 101
    //   125: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: aload_1
    //   132: invokevirtual 82	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 11
    //   141: aload 4
    //   143: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 91	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -52 -> 97
    //   152: aload_0
    //   153: getfield 30	com/tencent/viola/vinstance/BlockVInstanceAction:updateLock	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 99 1 0
    //   161: aload_1
    //   162: athrow
    //   163: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	BlockVInstanceAction
    //   0	164	1	paramString	String
    //   0	164	2	paramBoolean	boolean
    //   31	2	3	bool	boolean
    //   45	97	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	32	37	java/lang/InterruptedException
    //   79	97	107	finally
    //   112	149	107	finally
    //   79	97	111	java/lang/InterruptedException
  }
  
  public void addVInstance(String paramString1, String paramString2)
  {
    super.addVInstance(paramString1, paramString2);
    this.updateLock.lock();
    this.updateReady.signal();
    this.updateLock.unlock();
  }
  
  public void createVInstance(String paramString1, String paramString2)
  {
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      updateInstance(paramString1, paramString2);
      return;
    }
    throw new AssertionError();
  }
  
  public void doInit(boolean paramBoolean)
  {
    this.preconditor.process(paramBoolean);
  }
  
  public void setAcquireLockMaxWaitTime(int paramInt)
  {
    this.acquireLockMaxWaitTime = paramInt;
  }
  
  public void setUpdateMaxWaitTime(int paramInt)
  {
    this.updateMaxWaitTime = paramInt;
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    int i = this.state.get();
    if (i == 3)
    {
      tryWaitingJSOrSdkInit(paramString2, true);
      return;
    }
    if (i == 1)
    {
      addFailQueue(paramString1, paramString2);
      tryWaitingJSOrSdkInit(paramString2, false);
      return;
    }
    retryInit();
    addFailQueue(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.BlockVInstanceAction
 * JD-Core Version:    0.7.0.1
 */