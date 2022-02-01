package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;

public abstract class ReActionThread
  extends Thread
{
  private static final String TAG = "ReActionThread";
  private boolean hasAction = false;
  private boolean release = false;
  
  public ReActionThread(String paramString)
  {
    super(paramString);
  }
  
  public void action()
  {
    this.hasAction = true;
    try
    {
      notifyAll();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action: ");
      localStringBuilder.append(this);
      localStringBuilder.append(" ");
      localStringBuilder.append(hashCode());
      Logger.v("ReActionThread", localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  protected abstract void doAction();
  
  public void release()
  {
    try
    {
      if (!this.release)
      {
        this.release = true;
        try
        {
          notifyAll();
          try
          {
            try
            {
              wait(20L);
            }
            finally {}
            localObject2 = finally;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        finally {}
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 29	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 74
    //   11: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: ldc 42
    //   24: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: aload_0
    //   30: invokevirtual 46	java/lang/Object:hashCode	()I
    //   33: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 8
    //   39: aload_1
    //   40: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 77	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   50: ifne +79 -> 129
    //   53: aload_0
    //   54: getfield 19	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   57: ifne +40 -> 97
    //   60: aload_0
    //   61: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   64: ifne +33 -> 97
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_0
    //   70: ldc2_w 78
    //   73: invokevirtual 68	java/lang/Object:wait	(J)V
    //   76: goto +12 -> 88
    //   79: astore_1
    //   80: goto +13 -> 93
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 71	java/lang/InterruptedException:printStackTrace	()V
    //   88: aload_0
    //   89: monitorexit
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 19	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   102: aload_0
    //   103: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   106: ifne +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 81	com/tencent/tav/decoder/ReActionThread:doAction	()V
    //   113: aload_0
    //   114: monitorenter
    //   115: aload_0
    //   116: invokevirtual 27	java/lang/Object:notifyAll	()V
    //   119: aload_0
    //   120: monitorexit
    //   121: goto -75 -> 46
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: new 29	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   136: astore_1
    //   137: aload_1
    //   138: ldc 83
    //   140: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_1
    //   145: aload_0
    //   146: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: ldc 42
    //   153: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: aload_0
    //   159: invokevirtual 46	java/lang/Object:hashCode	()I
    //   162: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 8
    //   168: aload_1
    //   169: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 77	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ReActionThread
    //   7	33	1	localStringBuilder1	StringBuilder
    //   79	1	1	localObject1	Object
    //   83	13	1	localInterruptedException	InterruptedException
    //   124	4	1	localObject2	Object
    //   136	33	1	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	76	79	finally
    //   84	88	79	finally
    //   88	90	79	finally
    //   93	95	79	finally
    //   69	76	83	java/lang/InterruptedException
    //   115	121	124	finally
    //   125	127	124	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.ReActionThread
 * JD-Core Version:    0.7.0.1
 */