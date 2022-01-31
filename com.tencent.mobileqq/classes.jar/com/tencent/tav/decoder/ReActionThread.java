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
      if (Logger.LOG_VERBOSE) {
        Logger.d("ReActionThread", "action: " + this + " " + hashCode());
      }
      return;
    }
    finally {}
  }
  
  protected abstract void doAction();
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   6: ifne +27 -> 33
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: invokevirtual 27	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorenter
    //   24: aload_0
    //   25: ldc2_w 66
    //   28: invokevirtual 71	java/lang/Object:wait	(J)V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 74	java/lang/InterruptedException:printStackTrace	()V
    //   56: goto -23 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	ReActionThread
    //   36	4	1	localObject1	Object
    //   41	4	1	localObject2	Object
    //   46	4	1	localObject3	Object
    //   51	2	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   16	22	36	finally
    //   37	39	36	finally
    //   2	16	41	finally
    //   22	24	41	finally
    //   39	41	41	finally
    //   49	51	41	finally
    //   52	56	41	finally
    //   24	33	46	finally
    //   47	49	46	finally
    //   22	24	51	java/lang/InterruptedException
    //   49	51	51	java/lang/InterruptedException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 34	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   9: ldc 77
    //   11: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: ldc 47
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 51	java/lang/Object:hashCode	()I
    //   27: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 62	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   40: ifne +76 -> 116
    //   43: aload_0
    //   44: getfield 19	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   47: ifne +37 -> 84
    //   50: aload_0
    //   51: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   54: ifne +30 -> 84
    //   57: aload_0
    //   58: monitorenter
    //   59: aload_0
    //   60: ldc2_w 78
    //   63: invokevirtual 71	java/lang/Object:wait	(J)V
    //   66: aload_0
    //   67: monitorexit
    //   68: goto -25 -> 43
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 74	java/lang/InterruptedException:printStackTrace	()V
    //   81: goto -15 -> 66
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 19	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   89: aload_0
    //   90: getfield 17	com/tencent/tav/decoder/ReActionThread:release	Z
    //   93: ifne +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 81	com/tencent/tav/decoder/ReActionThread:doAction	()V
    //   100: aload_0
    //   101: monitorenter
    //   102: aload_0
    //   103: invokevirtual 27	java/lang/Object:notifyAll	()V
    //   106: aload_0
    //   107: monitorexit
    //   108: goto -72 -> 36
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    //   116: ldc 8
    //   118: new 34	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   125: ldc 83
    //   127: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: ldc 47
    //   136: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 51	java/lang/Object:hashCode	()I
    //   143: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 62	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ReActionThread
    //   71	4	1	localObject1	Object
    //   76	2	1	localInterruptedException	java.lang.InterruptedException
    //   111	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   77	81	71	finally
    //   59	66	76	java/lang/InterruptedException
    //   102	108	111	finally
    //   112	114	111	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.ReActionThread
 * JD-Core Version:    0.7.0.1
 */