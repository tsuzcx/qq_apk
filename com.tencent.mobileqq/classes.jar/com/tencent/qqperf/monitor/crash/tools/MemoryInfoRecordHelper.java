package com.tencent.qqperf.monitor.crash.tools;

import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MemoryInfoRecordHelper
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(c());
    localStringBuilder.append(a(20));
    localStringBuilder.append(b());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: new 13	java/lang/StringBuilder
    //   3: dup
    //   4: iconst_5
    //   5: invokespecial 16	java/lang/StringBuilder:<init>	(I)V
    //   8: astore 7
    //   10: aload 7
    //   12: ldc 36
    //   14: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: ldc 38
    //   22: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 7
    //   28: ldc 36
    //   30: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: new 40	java/util/HashMap
    //   37: dup
    //   38: invokespecial 41	java/util/HashMap:<init>	()V
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 6
    //   46: aconst_null
    //   47: astore_3
    //   48: new 43	java/io/BufferedReader
    //   51: dup
    //   52: new 45	java/io/FileReader
    //   55: dup
    //   56: ldc 47
    //   58: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   61: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   64: astore 4
    //   66: aload 4
    //   68: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_3
    //   72: iconst_0
    //   73: istore_1
    //   74: aload_3
    //   75: ifnull +175 -> 250
    //   78: aload_3
    //   79: ldc 58
    //   81: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   84: astore 8
    //   86: aload 8
    //   88: iconst_0
    //   89: aaload
    //   90: ldc 66
    //   92: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: iconst_0
    //   96: aaload
    //   97: astore 6
    //   99: aload 8
    //   101: iconst_0
    //   102: aaload
    //   103: ldc 66
    //   105: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   108: iconst_1
    //   109: aaload
    //   110: astore 8
    //   112: aload_3
    //   113: ldc 68
    //   115: invokevirtual 72	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   118: istore_1
    //   119: aload_3
    //   120: ldc 74
    //   122: invokevirtual 72	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   125: istore_2
    //   126: iload_1
    //   127: iconst_m1
    //   128: if_icmpeq +12 -> 140
    //   131: aload_3
    //   132: iload_1
    //   133: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   136: astore_3
    //   137: goto +17 -> 154
    //   140: iload_2
    //   141: iconst_m1
    //   142: if_icmpeq +290 -> 432
    //   145: aload_3
    //   146: iload_2
    //   147: invokevirtual 77	java/lang/String:substring	(I)Ljava/lang/String;
    //   150: astore_3
    //   151: goto +3 -> 154
    //   154: aload 5
    //   156: aload_3
    //   157: invokevirtual 81	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   160: ifne +37 -> 197
    //   163: aload 5
    //   165: aload_3
    //   166: aload 8
    //   168: bipush 16
    //   170: invokestatic 87	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   173: invokevirtual 91	java/lang/Long:longValue	()J
    //   176: aload 6
    //   178: bipush 16
    //   180: invokestatic 87	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   183: invokevirtual 91	java/lang/Long:longValue	()J
    //   186: lsub
    //   187: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   190: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: goto +47 -> 241
    //   197: aload 5
    //   199: aload_3
    //   200: aload 5
    //   202: aload_3
    //   203: invokevirtual 102	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: checkcast 83	java/lang/Long
    //   209: invokevirtual 91	java/lang/Long:longValue	()J
    //   212: aload 8
    //   214: bipush 16
    //   216: invokestatic 87	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   219: invokevirtual 91	java/lang/Long:longValue	()J
    //   222: aload 6
    //   224: bipush 16
    //   226: invokestatic 87	java/lang/Long:valueOf	(Ljava/lang/String;I)Ljava/lang/Long;
    //   229: invokevirtual 91	java/lang/Long:longValue	()J
    //   232: lsub
    //   233: ladd
    //   234: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   237: invokevirtual 98	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: pop
    //   241: aload 4
    //   243: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   246: astore_3
    //   247: goto -175 -> 72
    //   250: aload 5
    //   252: invokestatic 105	com/tencent/qqperf/monitor/crash/tools/MemoryInfoRecordHelper:a	(Ljava/util/HashMap;)Ljava/util/HashMap;
    //   255: astore_3
    //   256: aload_3
    //   257: ifnull +90 -> 347
    //   260: aload_3
    //   261: invokevirtual 109	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   264: invokeinterface 115 1 0
    //   269: astore_3
    //   270: aload_3
    //   271: invokeinterface 121 1 0
    //   276: ifeq +71 -> 347
    //   279: aload_3
    //   280: invokeinterface 125 1 0
    //   285: checkcast 127	java/util/Map$Entry
    //   288: astore 5
    //   290: iload_1
    //   291: iload_0
    //   292: if_icmpge -22 -> 270
    //   295: aload 7
    //   297: aload 5
    //   299: invokeinterface 130 1 0
    //   304: checkcast 60	java/lang/String
    //   307: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 7
    //   313: ldc 132
    //   315: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 7
    //   321: aload 5
    //   323: invokeinterface 135 1 0
    //   328: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 7
    //   334: ldc 36
    //   336: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: iload_1
    //   341: iconst_1
    //   342: iadd
    //   343: istore_1
    //   344: goto -74 -> 270
    //   347: aload 4
    //   349: invokevirtual 141	java/io/BufferedReader:close	()V
    //   352: goto +47 -> 399
    //   355: astore_3
    //   356: goto +49 -> 405
    //   359: astore 5
    //   361: goto +20 -> 381
    //   364: astore 5
    //   366: aload_3
    //   367: astore 4
    //   369: aload 5
    //   371: astore_3
    //   372: goto +33 -> 405
    //   375: astore 5
    //   377: aload 6
    //   379: astore 4
    //   381: aload 4
    //   383: astore_3
    //   384: aload 5
    //   386: invokevirtual 144	java/lang/Throwable:printStackTrace	()V
    //   389: aload 4
    //   391: ifnull +8 -> 399
    //   394: aload 4
    //   396: invokevirtual 141	java/io/BufferedReader:close	()V
    //   399: aload 7
    //   401: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: areturn
    //   405: aload 4
    //   407: ifnull +8 -> 415
    //   410: aload 4
    //   412: invokevirtual 141	java/io/BufferedReader:close	()V
    //   415: goto +5 -> 420
    //   418: aload_3
    //   419: athrow
    //   420: goto -2 -> 418
    //   423: astore_3
    //   424: goto -25 -> 399
    //   427: astore 4
    //   429: goto -14 -> 415
    //   432: ldc 146
    //   434: astore_3
    //   435: goto -281 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramInt	int
    //   73	271	1	i	int
    //   125	22	2	j	int
    //   47	233	3	localObject1	Object
    //   355	12	3	localObject2	Object
    //   371	48	3	localObject3	Object
    //   423	1	3	localThrowable1	Throwable
    //   434	1	3	str1	String
    //   64	347	4	localObject4	Object
    //   427	1	4	localThrowable2	Throwable
    //   41	281	5	localObject5	Object
    //   359	1	5	localThrowable3	Throwable
    //   364	6	5	localObject6	Object
    //   375	10	5	localThrowable4	Throwable
    //   44	334	6	str2	String
    //   8	392	7	localStringBuilder	StringBuilder
    //   84	129	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   66	72	355	finally
    //   78	126	355	finally
    //   131	137	355	finally
    //   145	151	355	finally
    //   154	194	355	finally
    //   197	241	355	finally
    //   241	247	355	finally
    //   250	256	355	finally
    //   260	270	355	finally
    //   270	290	355	finally
    //   295	340	355	finally
    //   66	72	359	java/lang/Throwable
    //   78	126	359	java/lang/Throwable
    //   131	137	359	java/lang/Throwable
    //   145	151	359	java/lang/Throwable
    //   154	194	359	java/lang/Throwable
    //   197	241	359	java/lang/Throwable
    //   241	247	359	java/lang/Throwable
    //   250	256	359	java/lang/Throwable
    //   260	270	359	java/lang/Throwable
    //   270	290	359	java/lang/Throwable
    //   295	340	359	java/lang/Throwable
    //   48	66	364	finally
    //   384	389	364	finally
    //   48	66	375	java/lang/Throwable
    //   347	352	423	java/lang/Throwable
    //   394	399	423	java/lang/Throwable
    //   410	415	427	java/lang/Throwable
  }
  
  private static HashMap<String, Long> a(HashMap<String, Long> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new MemoryInfoRecordHelper.1());
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(5);
    try
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        Object localObject = new Debug.MemoryInfo();
        Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
        localObject = ((Debug.MemoryInfo)localObject).getMemoryStats();
        localStringBuilder.append("\nDebug.getMemoryInfo:\n");
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localStringBuilder.append((String)localEntry.getKey());
          localStringBuilder.append(" : ");
          localStringBuilder.append((String)localEntry.getValue());
          localStringBuilder.append("kB\n");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      label117:
      break label117;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: new 13	java/lang/StringBuilder
    //   3: dup
    //   4: iconst_5
    //   5: invokespecial 16	java/lang/StringBuilder:<init>	(I)V
    //   8: astore_2
    //   9: new 43	java/io/BufferedReader
    //   12: dup
    //   13: new 45	java/io/FileReader
    //   16: dup
    //   17: ldc 198
    //   19: invokespecial 50	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_1
    //   31: aload_2
    //   32: ldc 200
    //   34: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: ifnull +54 -> 93
    //   42: aload_1
    //   43: ldc 202
    //   45: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   48: ifne +12 -> 60
    //   51: aload_1
    //   52: ldc 208
    //   54: invokevirtual 206	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +28 -> 85
    //   60: aload_1
    //   61: ldc 210
    //   63: ldc 212
    //   65: invokevirtual 216	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: pop
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 219	java/lang/String:trim	()Ljava/lang/String;
    //   74: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 221
    //   81: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore_1
    //   90: goto -52 -> 38
    //   93: aload_2
    //   94: ldc 36
    //   96: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: invokevirtual 141	java/io/BufferedReader:close	()V
    //   104: goto +32 -> 136
    //   107: astore_1
    //   108: goto +9 -> 117
    //   111: goto +18 -> 129
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 141	java/io/BufferedReader:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: aconst_null
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull +6 -> 136
    //   133: goto -33 -> 100
    //   136: aload_2
    //   137: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: areturn
    //   141: astore_0
    //   142: goto -15 -> 127
    //   145: astore_1
    //   146: goto -35 -> 111
    //   149: astore_0
    //   150: goto -14 -> 136
    //   153: astore_0
    //   154: goto -29 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	105	0	localBufferedReader	java.io.BufferedReader
    //   141	1	0	localThrowable1	Throwable
    //   149	1	0	localThrowable2	Throwable
    //   153	1	0	localThrowable3	Throwable
    //   30	60	1	str	String
    //   107	1	1	localObject1	Object
    //   114	12	1	localObject2	Object
    //   145	1	1	localThrowable4	Throwable
    //   8	129	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	38	107	finally
    //   42	60	107	finally
    //   60	85	107	finally
    //   85	90	107	finally
    //   93	100	107	finally
    //   9	26	114	finally
    //   9	26	141	java/lang/Throwable
    //   26	38	145	java/lang/Throwable
    //   42	60	145	java/lang/Throwable
    //   60	85	145	java/lang/Throwable
    //   85	90	145	java/lang/Throwable
    //   93	100	145	java/lang/Throwable
    //   100	104	149	java/lang/Throwable
    //   121	125	153	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.MemoryInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */