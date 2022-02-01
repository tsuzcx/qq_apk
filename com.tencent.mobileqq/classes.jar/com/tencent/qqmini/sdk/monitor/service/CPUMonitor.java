package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CPUMonitor
{
  private static final int BUSY_TIME = 1200;
  private static final int INTERVAL_TIME = 1000;
  private static final String TAG = CPUMonitor.class.getSimpleName();
  private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
  private static final int TOTAL_SIZE = 10;
  private static long appCpuTimeLast;
  private static Runnable getCPURunnable = new CPUMonitor.1();
  private static volatile boolean hasStart;
  private static long idleLast;
  private static long iowaitLast;
  private static boolean isError;
  private static Handler mHandler;
  private static LinkedHashMap<Long, String> map = new LinkedHashMap();
  private static HandlerThread newHT;
  private static int pid = 0;
  private static long systemLast;
  private static long totalLast;
  private static long userLast = 0L;
  
  static
  {
    systemLast = 0L;
    idleLast = 0L;
    iowaitLast = 0L;
    totalLast = 0L;
    appCpuTimeLast = 0L;
    hasStart = false;
    isError = false;
  }
  
  public static String getCPURateInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (map)
    {
      Iterator localIterator = map.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        long l = ((Long)localEntry.getKey()).longValue();
        localStringBuilder.append(TIME_FORMATTER.format(Long.valueOf(l)));
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("\r\n");
      }
    }
    return localObject.toString();
  }
  
  /* Error */
  private static void getCpuTime()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 162	java/io/BufferedReader
    //   8: dup
    //   9: new 164	java/io/InputStreamReader
    //   12: dup
    //   13: new 166	java/io/FileInputStream
    //   16: dup
    //   17: ldc 168
    //   19: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 1000
    //   28: invokespecial 175	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 178	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +231 -> 269
    //   41: ldc 180
    //   43: astore_2
    //   44: getstatic 63	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   47: ifne +9 -> 56
    //   50: invokestatic 186	android/os/Process:myPid	()I
    //   53: putstatic 63	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   56: new 162	java/io/BufferedReader
    //   59: dup
    //   60: new 164	java/io/InputStreamReader
    //   63: dup
    //   64: new 166	java/io/FileInputStream
    //   67: dup
    //   68: new 101	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   75: ldc 188
    //   77: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: getstatic 63	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   83: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 193
    //   88: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   97: invokespecial 172	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: sipush 1000
    //   103: invokespecial 175	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 178	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   111: astore 4
    //   113: aload 4
    //   115: astore_3
    //   116: aload 4
    //   118: ifnonnull +6 -> 124
    //   121: ldc 180
    //   123: astore_3
    //   124: aload_2
    //   125: aload_3
    //   126: invokestatic 197	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:parseCPURate	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: iconst_0
    //   130: putstatic 79	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:isError	Z
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 200	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 200	java/io/BufferedReader:close	()V
    //   149: return
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_3
    //   160: astore_1
    //   161: iconst_1
    //   162: putstatic 79	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:isError	Z
    //   165: aload_2
    //   166: invokevirtual 204	java/lang/Throwable:printStackTrace	()V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 200	java/io/BufferedReader:close	()V
    //   177: aload_1
    //   178: ifnull -29 -> 149
    //   181: aload_1
    //   182: invokevirtual 200	java/io/BufferedReader:close	()V
    //   185: return
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_1
    //   195: aload 4
    //   197: astore_2
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 200	java/io/BufferedReader:close	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 200	java/io/BufferedReader:close	()V
    //   214: aload_0
    //   215: athrow
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   221: goto -7 -> 214
    //   224: astore_0
    //   225: aload 4
    //   227: astore_2
    //   228: goto -30 -> 198
    //   231: astore_3
    //   232: aload_0
    //   233: astore_2
    //   234: aload_3
    //   235: astore_0
    //   236: goto -38 -> 198
    //   239: astore_2
    //   240: aload_0
    //   241: astore_3
    //   242: aload_2
    //   243: astore_0
    //   244: aload_1
    //   245: astore_2
    //   246: aload_3
    //   247: astore_1
    //   248: goto -50 -> 198
    //   251: astore_2
    //   252: aload_1
    //   253: astore_0
    //   254: aload_3
    //   255: astore_1
    //   256: goto -95 -> 161
    //   259: astore_2
    //   260: aload_1
    //   261: astore_3
    //   262: aload_0
    //   263: astore_1
    //   264: aload_3
    //   265: astore_0
    //   266: goto -105 -> 161
    //   269: goto -225 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   106	40	0	localBufferedReader	java.io.BufferedReader
    //   150	2	0	localIOException1	java.io.IOException
    //   158	16	0	localObject1	Object
    //   186	2	0	localIOException2	java.io.IOException
    //   192	23	0	localObject2	Object
    //   224	9	0	localObject3	Object
    //   235	31	0	localObject4	Object
    //   31	172	1	localObject5	Object
    //   216	29	1	localIOException3	java.io.IOException
    //   247	17	1	localObject6	Object
    //   36	89	2	str1	String
    //   156	10	2	localThrowable1	java.lang.Throwable
    //   197	37	2	localObject7	Object
    //   239	4	2	localObject8	Object
    //   245	1	2	localIOException4	java.io.IOException
    //   251	1	2	localThrowable2	java.lang.Throwable
    //   259	1	2	localThrowable3	java.lang.Throwable
    //   4	156	3	str2	String
    //   231	4	3	localObject9	Object
    //   241	24	3	localObject10	Object
    //   1	225	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   137	141	150	java/io/IOException
    //   145	149	150	java/io/IOException
    //   5	32	156	java/lang/Throwable
    //   173	177	186	java/io/IOException
    //   181	185	186	java/io/IOException
    //   5	32	192	finally
    //   202	206	216	java/io/IOException
    //   210	214	216	java/io/IOException
    //   32	37	224	finally
    //   44	56	224	finally
    //   56	107	224	finally
    //   107	113	231	finally
    //   124	133	231	finally
    //   161	169	239	finally
    //   32	37	251	java/lang/Throwable
    //   44	56	251	java/lang/Throwable
    //   56	107	251	java/lang/Throwable
    //   107	113	259	java/lang/Throwable
    //   124	133	259	java/lang/Throwable
  }
  
  public static boolean isCPUbusy(long paramLong1, long paramLong2)
  {
    if (paramLong2 - paramLong1 > 1000L)
    {
      long l1;
      for (paramLong2 = 0L;; paramLong2 = l1)
      {
        synchronized (map)
        {
          Iterator localIterator = map.entrySet().iterator();
          if (localIterator.hasNext())
          {
            long l2 = ((Long)((Map.Entry)localIterator.next()).getKey()).longValue();
            if ((paramLong1 - 1000L >= l2) || (l2 >= paramLong1 + 1000L)) {
              break label132;
            }
            l1 = l2;
            if (paramLong2 == 0L) {
              continue;
            }
            l1 = l2;
            if (l2 - paramLong2 <= 1200L) {
              continue;
            }
            return true;
          }
        }
        label132:
        l1 = paramLong2;
      }
    }
    return false;
  }
  
  public static boolean isError()
  {
    return isError;
  }
  
  private static void parseCPURate(String arg0, String paramString2)
  {
    ??? = ???.split(" ");
    if ((??? == null) || (???.length < 9)) {}
    long l1;
    long l5;
    long l2;
    long l3;
    long l4;
    do
    {
      return;
      l1 = Long.parseLong(???[2]);
      l5 = Long.parseLong(???[3]);
      l2 = Long.parseLong(???[4]);
      l3 = Long.parseLong(???[5]);
      l4 = Long.parseLong(???[6]);
      l5 = l5 + l1 + l2 + l3 + l4 + Long.parseLong(???[7]) + Long.parseLong(???[8]);
      ??? = paramString2.split(" ");
    } while ((??? == null) || (???.length < 17));
    long l6 = Long.parseLong(???[13]) + Long.parseLong(???[14]) + Long.parseLong(???[15]) + Long.parseLong(???[16]);
    if (totalLast != 0L)
    {
      paramString2 = new StringBuilder();
      long l7 = idleLast;
      long l8 = l5 - totalLast;
      paramString2.append("cpu:").append((l8 - (l3 - l7)) * 100L / l8).append("% ");
      paramString2.append("app:").append((l6 - appCpuTimeLast) * 100L / l8).append("% ");
      paramString2.append("[").append("user:").append((l1 - userLast) * 100L / l8).append("% ");
      paramString2.append("system:").append((l2 - systemLast) * 100L / l8).append("% ");
      paramString2.append("iowait:").append((l4 - iowaitLast) * 100L / l8).append("% ]");
    }
    synchronized (map)
    {
      map.put(Long.valueOf(System.currentTimeMillis()), paramString2.toString());
      if (map.size() > 10)
      {
        paramString2 = map.entrySet().iterator();
        if (paramString2.hasNext())
        {
          paramString2 = (Long)((Map.Entry)paramString2.next()).getKey();
          map.remove(paramString2);
        }
      }
      userLast = l1;
      systemLast = l2;
      idleLast = l3;
      iowaitLast = l4;
      totalLast = l5;
      appCpuTimeLast = l6;
      return;
    }
  }
  
  private static void reset()
  {
    userLast = 0L;
    systemLast = 0L;
    idleLast = 0L;
    iowaitLast = 0L;
    totalLast = 0L;
    appCpuTimeLast = 0L;
  }
  
  public static void start()
  {
    if (hasStart) {
      return;
    }
    reset();
    newHT = new HandlerThread("qzminiapp-monitor", 10);
    newHT.start();
    Looper localLooper = newHT.getLooper();
    if (localLooper != null)
    {
      mHandler = new Handler(localLooper);
      mHandler.removeCallbacks(getCPURunnable);
      mHandler.postDelayed(getCPURunnable, 1000L);
    }
    hasStart = true;
  }
  
  public static void stop()
  {
    hasStart = false;
    if (mHandler != null) {
      mHandler.removeCallbacks(getCPURunnable);
    }
    if (newHT != null) {
      newHT.quitSafely();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.CPUMonitor
 * JD-Core Version:    0.7.0.1
 */