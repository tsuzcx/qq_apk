package com.tencent.mobileqq.transfile.quic.internal;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QuicDownloadRunnable
  extends AbTransportRunnable
{
  private static final int INIT_TASK_ID = 65534;
  private static HashMap<String, Integer> allRunningTaskMap = new HashMap();
  private static AtomicInteger sUniqueID = new AtomicInteger(65534);
  private static ConcurrentHashMap<String, QuicDownloadTask> taskHashMap = new ConcurrentHashMap();
  protected QuicDownloadTask task;
  
  public static int getTaskID(String paramString)
  {
    try
    {
      paramString = (Integer)allRunningTaskMap.get(paramString);
      if (paramString == null) {
        throw new IllegalArgumentException("task id is null!!");
      }
    }
    finally {}
    int i = paramString.intValue();
    return i;
  }
  
  /* Error */
  public static boolean isExistTaskAddIfNeed(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: getstatic 31	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:allRunningTaskMap	Ljava/util/HashMap;
    //   22: aload_0
    //   23: invokevirtual 71	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifeq +8 -> 34
    //   29: iconst_1
    //   30: istore_1
    //   31: goto -17 -> 14
    //   34: getstatic 31	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:allRunningTaskMap	Ljava/util/HashMap;
    //   37: aload_0
    //   38: getstatic 38	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:sUniqueID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   41: invokevirtual 74	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   44: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 82	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: goto -37 -> 14
    //   54: astore_0
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramString	String
    //   1	30	1	bool1	boolean
    //   9	2	2	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	54	finally
    //   19	29	54	finally
    //   34	51	54	finally
  }
  
  /* Error */
  public static void removeRunningTask(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: getstatic 31	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:allRunningTaskMap	Ljava/util/HashMap;
    //   19: aload_0
    //   20: invokevirtual 86	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 48	java/lang/Integer
    //   26: astore_0
    //   27: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +22 -> 52
    //   33: ldc 94
    //   35: iconst_4
    //   36: iconst_2
    //   37: anewarray 96	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 98
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_0
    //   48: aastore
    //   49: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   52: getstatic 31	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:allRunningTaskMap	Ljava/util/HashMap;
    //   55: invokevirtual 104	java/util/HashMap:isEmpty	()Z
    //   58: ifeq +11 -> 69
    //   61: getstatic 38	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:sUniqueID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   64: ldc 7
    //   66: invokevirtual 107	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   69: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq -60 -> 12
    //   75: ldc 94
    //   77: iconst_4
    //   78: iconst_3
    //   79: anewarray 96	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: ldc 109
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: getstatic 31	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:allRunningTaskMap	Ljava/util/HashMap;
    //   92: invokevirtual 112	java/util/HashMap:size	()I
    //   95: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_2
    //   101: new 114	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   108: ldc 117
    //   110: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 38	com/tencent/mobileqq/transfile/quic/internal/QuicDownloadRunnable:sUniqueID	Ljava/util/concurrent/atomic/AtomicInteger;
    //   116: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   126: goto -114 -> 12
    //   129: astore_0
    //   130: ldc 2
    //   132: monitorexit
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramString	String
    //   7	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	129	finally
    //   16	52	129	finally
    //   52	69	129	finally
    //   69	126	129	finally
  }
  
  public void enqueue(QuicDownloadTask paramQuicDownloadTask)
  {
    this.message.what = 9;
    this.message.obj = paramQuicDownloadTask;
    handleMessage(this.message);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.task = ((QuicDownloadTask)paramMessage.obj);
            taskHashMap.put(this.task.report.tempPath, this.task);
            this.task.prepare(this);
            this.task.startConnect();
            return;
            paramMessage = (Bundle)paramMessage.obj;
            if (paramMessage.getInt("ID", 0) != 0)
            {
              Iterator localIterator = taskHashMap.entrySet().iterator();
              Object localObject;
              while (localIterator.hasNext())
              {
                localObject = (Map.Entry)localIterator.next();
                localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramMessage.getInt("ID", 0))) {
                  ((QuicDownloadTask)localObject).sendData();
                }
              }
              continue;
              paramMessage = (Bundle)paramMessage.obj;
              if (paramMessage.getByteArray("DATA") != null)
              {
                localIterator = taskHashMap.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  localObject = (Map.Entry)localIterator.next();
                  localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                  if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramMessage.getInt("ID", 0))) {
                    ((QuicDownloadTask)localObject).receiveResponse(paramMessage.getByteArray("DATA"), paramMessage.getInt("LEN", 0));
                  }
                }
                continue;
                paramMessage = (Bundle)paramMessage.obj;
                if (paramMessage.getInt("ID", 0) != 0)
                {
                  localIterator = taskHashMap.entrySet().iterator();
                  while (localIterator.hasNext())
                  {
                    localObject = (Map.Entry)localIterator.next();
                    localObject = (QuicDownloadTask)taskHashMap.get(((Map.Entry)localObject).getKey());
                    if ((localObject != null) && (((QuicDownloadTask)localObject).running) && (((QuicDownloadTask)localObject).report.id == paramMessage.getInt("ID", 0))) {
                      ((QuicDownloadTask)localObject).connectionClose(paramMessage.getInt("CODE", 0), paramMessage.getString("DESC"));
                    }
                  }
                }
              }
            }
          }
          paramMessage = (Task)paramMessage.obj;
        } while ((paramMessage == null) || (paramMessage.netListener == null) || (!paramMessage.running) || (!(paramMessage.netListener instanceof DownloadListener)));
        ((DownloadListener)paramMessage.netListener).onDownloadSucceed(paramMessage.report.url, paramMessage.report);
        return;
        paramMessage = (Task)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.netListener == null) || (!paramMessage.running) || (!(paramMessage.netListener instanceof DownloadListener)));
      ((DownloadListener)paramMessage.netListener).onDownloadFailed(paramMessage.report.url, paramMessage.report);
      return;
      this.task = ((QuicDownloadTask)paramMessage.obj);
      if (taskHashMap.containsValue(this.task)) {
        taskHashMap.remove(this.task.report.tempPath);
      }
      removeRunningTask(this.task.report.tempPath);
    } while (!QLog.isColorLevel());
    QLog.d("quic", 4, new Object[] { "taskHashMap.size: ", Integer.valueOf(taskHashMap.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.QuicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */