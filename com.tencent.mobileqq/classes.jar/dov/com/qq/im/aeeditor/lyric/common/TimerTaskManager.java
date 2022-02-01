package dov.com.qq.im.aeeditor.lyric.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerTaskManager
{
  private Map<String, TimerTaskManager.InternalTaskEntry> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  
  public TimerTaskManager()
  {
    a();
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor == null) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new TimerTaskManager.1(this, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 34 2 0
    //   12: checkcast 36	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +128 -> 145
    //   20: ldc 38
    //   22: ldc 40
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: invokestatic 46	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   38: pop
    //   39: aload_3
    //   40: invokestatic 55	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry;)Ljava/util/concurrent/ScheduledFuture;
    //   43: ifnull +14 -> 57
    //   46: aload_3
    //   47: invokestatic 55	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry;)Ljava/util/concurrent/ScheduledFuture;
    //   50: iconst_1
    //   51: invokeinterface 61 2 0
    //   56: pop
    //   57: aload_0
    //   58: getfield 22	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   61: aload_3
    //   62: invokestatic 64	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry;)Ljava/lang/Runnable;
    //   65: invokevirtual 70	java/util/concurrent/ScheduledThreadPoolExecutor:remove	(Ljava/lang/Runnable;)Z
    //   68: istore_2
    //   69: aload_0
    //   70: getfield 22	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   73: invokevirtual 73	java/util/concurrent/ScheduledThreadPoolExecutor:purge	()V
    //   76: ldc 38
    //   78: new 75	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   85: ldc 78
    //   87: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_2
    //   91: invokevirtual 85	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: ldc 87
    //   96: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 22	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor	Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    //   103: invokevirtual 91	java/util/concurrent/ScheduledThreadPoolExecutor:toString	()Ljava/lang/String;
    //   106: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 95	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   115: pop
    //   116: aload_3
    //   117: invokestatic 98	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry;)Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   120: iconst_0
    //   121: invokestatic 103	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$TimerTaskRunnable:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$TimerTaskRunnable;Z)Z
    //   124: pop
    //   125: aload_3
    //   126: aconst_null
    //   127: invokestatic 106	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry:a	(Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$InternalTaskEntry;Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$TimerTaskRunnable;)Ldov/com/qq/im/aeeditor/lyric/common/TimerTaskManager$TimerTaskRunnable;
    //   130: pop
    //   131: aload_0
    //   132: getfield 17	dov/com/qq/im/aeeditor/lyric/common/TimerTaskManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   135: aload_1
    //   136: invokeinterface 108 2 0
    //   141: pop
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: ldc 38
    //   147: ldc 110
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: invokestatic 46	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 52	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   163: pop
    //   164: goto -22 -> 142
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	TimerTaskManager
    //   0	172	1	paramString	String
    //   68	23	2	bool	boolean
    //   15	111	3	localInternalTaskEntry	TimerTaskManager.InternalTaskEntry
    // Exception table:
    //   from	to	target	type
    //   2	16	167	finally
    //   20	57	167	finally
    //   57	142	167	finally
    //   145	164	167	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.common.TimerTaskManager
 * JD-Core Version:    0.7.0.1
 */