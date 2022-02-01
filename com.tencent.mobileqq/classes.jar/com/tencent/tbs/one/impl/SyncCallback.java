package com.tencent.tbs.one.impl;

import com.tencent.tbs.one.TBSOneCallback;

public class SyncCallback<T>
  extends TBSOneCallback<T>
{
  private String mDescription;
  private int mErrorCode = 0;
  private boolean mNotified;
  private T mResult;
  
  private void notifyResult()
  {
    try
    {
      this.mNotified = true;
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public int getErrorCode()
  {
    return this.mErrorCode;
  }
  
  public T getResult()
  {
    return this.mResult;
  }
  
  public void onCompleted(T paramT)
  {
    this.mResult = paramT;
    notifyResult();
  }
  
  public void onError(int paramInt, String paramString)
  {
    this.mErrorCode = paramInt;
    this.mDescription = paramString;
    notifyResult();
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2) {}
  
  /* Error */
  public void waitFroResult()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/tbs/one/impl/SyncCallback:mNotified	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: invokevirtual 56	java/lang/Object:wait	()V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_2
    //   19: aload_0
    //   20: bipush 103
    //   22: putfield 20	com/tencent/tbs/one/impl/SyncCallback:mErrorCode	I
    //   25: aload_0
    //   26: ldc 58
    //   28: putfield 33	com/tencent/tbs/one/impl/SyncCallback:mDescription	Ljava/lang/String;
    //   31: goto -16 -> 15
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	SyncCallback
    //   6	2	1	bool	boolean
    //   18	1	2	localInterruptedException	java.lang.InterruptedException
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	15	18	java/lang/InterruptedException
    //   2	7	34	finally
    //   11	15	34	finally
    //   19	31	34	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.SyncCallback
 * JD-Core Version:    0.7.0.1
 */