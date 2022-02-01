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
  private static final String TAG = "CPUMonitor";
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
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        long l = ((Long)localEntry.getKey()).longValue();
        localStringBuilder.append(TIME_FORMATTER.format(Long.valueOf(l)));
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append("\r\n");
      }
      return localStringBuilder.toString();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  /* Error */
  private static void getCpuTime()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 157	java/io/BufferedReader
    //   7: dup
    //   8: new 159	java/io/InputStreamReader
    //   11: dup
    //   12: new 161	java/io/FileInputStream
    //   15: dup
    //   16: ldc 163
    //   18: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: sipush 1000
    //   27: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 173	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: ifnonnull +6 -> 45
    //   42: ldc 175
    //   44: astore_1
    //   45: getstatic 57	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   48: ifne +9 -> 57
    //   51: invokestatic 181	android/os/Process:myPid	()I
    //   54: putstatic 57	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   57: new 96	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   64: astore_3
    //   65: aload_3
    //   66: ldc 183
    //   68: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: getstatic 57	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:pid	I
    //   76: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: ldc 188
    //   83: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 157	java/io/BufferedReader
    //   90: dup
    //   91: new 159	java/io/InputStreamReader
    //   94: dup
    //   95: new 161	java/io/FileInputStream
    //   98: dup
    //   99: aload_3
    //   100: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   106: invokespecial 167	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: sipush 1000
    //   112: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 173	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore 4
    //   122: aload 4
    //   124: astore_2
    //   125: aload 4
    //   127: ifnonnull +6 -> 133
    //   130: ldc 175
    //   132: astore_2
    //   133: aload_1
    //   134: aload_2
    //   135: invokestatic 192	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:parseCpuRate	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_0
    //   139: putstatic 73	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:isError	Z
    //   142: aload_0
    //   143: invokevirtual 195	java/io/BufferedReader:close	()V
    //   146: aload_3
    //   147: invokevirtual 195	java/io/BufferedReader:close	()V
    //   150: return
    //   151: astore_1
    //   152: aload_3
    //   153: astore_2
    //   154: goto +68 -> 222
    //   157: astore_2
    //   158: aload_3
    //   159: astore_1
    //   160: goto +10 -> 170
    //   163: astore_1
    //   164: goto +58 -> 222
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: goto +14 -> 184
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_0
    //   176: goto +46 -> 222
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_3
    //   183: astore_0
    //   184: iconst_1
    //   185: putstatic 73	com/tencent/qqmini/sdk/monitor/service/CPUMonitor:isError	Z
    //   188: aload_2
    //   189: invokevirtual 198	java/lang/Throwable:printStackTrace	()V
    //   192: aload_0
    //   193: ifnull +10 -> 203
    //   196: aload_0
    //   197: invokevirtual 195	java/io/BufferedReader:close	()V
    //   200: goto +3 -> 203
    //   203: aload_1
    //   204: ifnull +12 -> 216
    //   207: aload_1
    //   208: invokevirtual 195	java/io/BufferedReader:close	()V
    //   211: return
    //   212: aload_0
    //   213: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   216: return
    //   217: astore_3
    //   218: aload_1
    //   219: astore_2
    //   220: aload_3
    //   221: astore_1
    //   222: aload_0
    //   223: ifnull +10 -> 233
    //   226: aload_0
    //   227: invokevirtual 195	java/io/BufferedReader:close	()V
    //   230: goto +3 -> 233
    //   233: aload_2
    //   234: ifnull +14 -> 248
    //   237: aload_2
    //   238: invokevirtual 195	java/io/BufferedReader:close	()V
    //   241: goto +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 199	java/io/IOException:printStackTrace	()V
    //   248: aload_1
    //   249: athrow
    //   250: astore_0
    //   251: goto -39 -> 212
    //   254: astore_0
    //   255: goto -11 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	215	0	localObject1	Object
    //   250	1	0	localIOException1	java.io.IOException
    //   254	1	0	localIOException2	java.io.IOException
    //   37	97	1	localObject2	Object
    //   151	1	1	localObject3	Object
    //   159	1	1	localObject4	Object
    //   163	1	1	localObject5	Object
    //   169	1	1	localObject6	Object
    //   173	1	1	localObject7	Object
    //   181	68	1	localObject8	Object
    //   1	153	2	localObject9	Object
    //   157	1	2	localThrowable1	java.lang.Throwable
    //   167	1	2	localThrowable2	java.lang.Throwable
    //   179	10	2	localThrowable3	java.lang.Throwable
    //   219	19	2	localObject10	Object
    //   3	180	3	localObject11	Object
    //   217	4	3	localObject12	Object
    //   120	6	4	str	String
    // Exception table:
    //   from	to	target	type
    //   116	122	151	finally
    //   133	142	151	finally
    //   116	122	157	java/lang/Throwable
    //   133	142	157	java/lang/Throwable
    //   31	36	163	finally
    //   45	57	163	finally
    //   57	116	163	finally
    //   31	36	167	java/lang/Throwable
    //   45	57	167	java/lang/Throwable
    //   57	116	167	java/lang/Throwable
    //   4	31	173	finally
    //   4	31	179	java/lang/Throwable
    //   184	192	217	finally
    //   142	150	250	java/io/IOException
    //   196	200	250	java/io/IOException
    //   207	211	250	java/io/IOException
    //   226	230	254	java/io/IOException
    //   237	241	254	java/io/IOException
  }
  
  public static boolean isCPUbusy(long paramLong1, long paramLong2)
  {
    if (paramLong2 - paramLong1 > 1000L) {}
    for (;;)
    {
      long l;
      synchronized (map)
      {
        Iterator localIterator = map.entrySet().iterator();
        paramLong2 = 0L;
        if (localIterator.hasNext())
        {
          l = ((Long)((Map.Entry)localIterator.next()).getKey()).longValue();
          if ((paramLong1 - 1000L >= l) || (l >= paramLong1 + 1000L)) {
            continue;
          }
          if ((paramLong2 == 0L) || (l - paramLong2 <= 1200L)) {
            break label126;
          }
          return true;
        }
      }
      return false;
      label126:
      paramLong2 = l;
    }
  }
  
  public static boolean isError()
  {
    return isError;
  }
  
  private static void parseCpuRate(String arg0, String paramString2)
  {
    ??? = ???.split(" ");
    if (??? != null)
    {
      if (???.length < 9) {
        return;
      }
      long l1 = Long.parseLong(???[2]);
      long l5 = Long.parseLong(???[3]);
      long l2 = Long.parseLong(???[4]);
      long l3 = Long.parseLong(???[5]);
      long l4 = Long.parseLong(???[6]);
      l5 = l5 + l1 + l2 + l3 + l4 + Long.parseLong(???[7]) + Long.parseLong(???[8]);
      ??? = paramString2.split(" ");
      if (??? != null)
      {
        if (???.length < 17) {
          return;
        }
        long l6 = Long.parseLong(???[13]) + Long.parseLong(???[14]) + Long.parseLong(???[15]) + Long.parseLong(???[16]);
        if (totalLast != 0L)
        {
          paramString2 = new StringBuilder();
          long l7 = idleLast;
          long l8 = l5 - totalLast;
          paramString2.append("cpu:");
          paramString2.append((l8 - (l3 - l7)) * 100L / l8);
          paramString2.append("% ");
          paramString2.append("app:");
          paramString2.append((l6 - appCpuTimeLast) * 100L / l8);
          paramString2.append("% ");
          paramString2.append("[");
          paramString2.append("user:");
          paramString2.append((l1 - userLast) * 100L / l8);
          paramString2.append("% ");
          paramString2.append("system:");
          paramString2.append((l2 - systemLast) * 100L / l8);
          paramString2.append("% ");
          paramString2.append("iowait:");
          paramString2.append((l4 - iowaitLast) * 100L / l8);
          paramString2.append("% ]");
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
          }
        }
        userLast = l1;
        systemLast = l2;
        idleLast = l3;
        iowaitLast = l4;
        totalLast = l5;
        appCpuTimeLast = l6;
      }
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
    Object localObject = mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(getCPURunnable);
    }
    localObject = newHT;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.CPUMonitor
 * JD-Core Version:    0.7.0.1
 */