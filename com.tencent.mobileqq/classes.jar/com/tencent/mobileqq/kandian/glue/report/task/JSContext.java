package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.Map;
import java.util.Timer;

public class JSContext
{
  public Task a;
  public Map<Integer, Timer> b;
  private long c;
  private long d;
  private Map<String, JSContext.Callback> e;
  
  /* Error */
  public JSContext()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 24	java/util/HashMap
    //   8: dup
    //   9: invokespecial 25	java/util/HashMap:<init>	()V
    //   12: putfield 27	com/tencent/mobileqq/kandian/glue/report/task/JSContext:b	Ljava/util/Map;
    //   15: aload_0
    //   16: new 24	java/util/HashMap
    //   19: dup
    //   20: invokespecial 25	java/util/HashMap:<init>	()V
    //   23: putfield 29	com/tencent/mobileqq/kandian/glue/report/task/JSContext:e	Ljava/util/Map;
    //   26: ldc 2
    //   28: monitorenter
    //   29: aload_0
    //   30: aload_0
    //   31: invokespecial 33	com/tencent/mobileqq/kandian/glue/report/task/JSContext:createGroup	()J
    //   34: putfield 35	com/tencent/mobileqq/kandian/glue/report/task/JSContext:d	J
    //   37: aload_0
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 35	com/tencent/mobileqq/kandian/glue/report/task/JSContext:d	J
    //   43: invokespecial 39	com/tencent/mobileqq/kandian/glue/report/task/JSContext:create	(J)J
    //   46: putfield 41	com/tencent/mobileqq/kandian/glue/report/task/JSContext:c	J
    //   49: goto +142 -> 191
    //   52: astore_1
    //   53: goto +142 -> 195
    //   56: astore_1
    //   57: new 43	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   64: astore_2
    //   65: aload_2
    //   66: ldc 46
    //   68: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: aload_1
    //   74: invokevirtual 54	java/lang/Error:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 56
    //   83: iconst_2
    //   84: aload_2
    //   85: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: new 43	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: ldc 46
    //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: aload_1
    //   108: invokevirtual 54	java/lang/Error:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 69	com/tencent/mobileqq/kandian/glue/report/task/TaskException:b	(Ljava/lang/String;)V
    //   122: goto +69 -> 191
    //   125: astore_1
    //   126: new 43	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: ldc 71
    //   137: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 72	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: ldc 56
    //   152: iconst_2
    //   153: aload_2
    //   154: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: new 43	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   167: astore_2
    //   168: aload_2
    //   169: ldc 71
    //   171: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 72	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 69	com/tencent/mobileqq/kandian/glue/report/task/TaskException:b	(Ljava/lang/String;)V
    //   191: ldc 2
    //   193: monitorexit
    //   194: return
    //   195: ldc 2
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	JSContext
    //   52	1	1	localObject	Object
    //   56	52	1	localError	java.lang.Error
    //   125	74	1	localException	java.lang.Exception
    //   64	121	2	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	49	52	finally
    //   57	122	52	finally
    //   126	191	52	finally
    //   191	194	52	finally
    //   195	198	52	finally
    //   29	49	56	java/lang/Error
    //   29	49	125	java/lang/Exception
  }
  
  private native long create(long paramLong);
  
  private native long createGroup();
  
  private native Object evaluteStringWithException(long paramLong, String paramString, StringBuffer paramStringBuffer);
  
  private native void initRIJStrorage(long paramLong);
  
  private native void registerFunction(long paramLong, String paramString);
  
  private native void release(long paramLong1, long paramLong2);
  
  public Object a(String paramString, StringBuffer paramStringBuffer)
  {
    return evaluteStringWithException(this.c, paramString, paramStringBuffer);
  }
  
  public void a()
  {
    initRIJStrorage(this.c);
  }
  
  public void a(String paramString, JSContext.Callback paramCallback)
  {
    this.e.put(paramString, paramCallback);
    registerFunction(this.c, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.JSContext
 * JD-Core Version:    0.7.0.1
 */