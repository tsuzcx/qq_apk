package com.tencent.rmonitor.fd.dump.dumpers;

import com.tencent.rmonitor.fd.dump.data.FdThreadData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class FdThreadsDumper
  extends BaseFdDumper
{
  private static List<String> a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if (paramArrayOfStackTraceElement == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfStackTraceElement.length);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfStackTraceElement[i].toString());
      i += 1;
    }
    return localArrayList;
  }
  
  @NotNull
  public static List<FdThreadData> c()
  {
    Map localMap = Thread.getAllStackTraces();
    ArrayList localArrayList = new ArrayList(localMap.size());
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Thread localThread = (Thread)localIterator.next();
      localArrayList.add(new FdThreadData(localThread, a((StackTraceElement[])localMap.get(localThread))));
    }
    return localArrayList;
  }
  
  public int a()
  {
    return 2;
  }
  
  /* Error */
  protected com.tencent.rmonitor.fd.dump.FdLeakDumpResult b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 91	java/io/FileWriter
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 94	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: new 96	java/io/BufferedWriter
    //   17: dup
    //   18: aload 4
    //   20: invokespecial 99	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   23: astore_2
    //   24: invokestatic 101	com/tencent/rmonitor/fd/dump/dumpers/FdThreadsDumper:c	()Ljava/util/List;
    //   27: astore_3
    //   28: aload_3
    //   29: invokeinterface 102 1 0
    //   34: astore 5
    //   36: aload 5
    //   38: invokeinterface 66 1 0
    //   43: ifeq +31 -> 74
    //   46: aload_2
    //   47: aload 5
    //   49: invokeinterface 70 1 0
    //   54: checkcast 72	com/tencent/rmonitor/fd/dump/data/FdThreadData
    //   57: invokevirtual 103	com/tencent/rmonitor/fd/dump/data/FdThreadData:toString	()Ljava/lang/String;
    //   60: invokevirtual 106	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: invokevirtual 109	java/io/BufferedWriter:newLine	()V
    //   67: aload_2
    //   68: invokevirtual 109	java/io/BufferedWriter:newLine	()V
    //   71: goto -35 -> 36
    //   74: aload_2
    //   75: invokevirtual 112	java/io/BufferedWriter:flush	()V
    //   78: aload_0
    //   79: aload_1
    //   80: aload_3
    //   81: invokevirtual 115	com/tencent/rmonitor/fd/dump/dumpers/FdThreadsDumper:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;
    //   84: astore_3
    //   85: aload 4
    //   87: invokestatic 120	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_1
    //   93: invokestatic 120	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   96: aload_3
    //   97: areturn
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: goto +12 -> 113
    //   104: astore_3
    //   105: aload_2
    //   106: astore_1
    //   107: goto +18 -> 125
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_3
    //   113: aload 4
    //   115: astore_2
    //   116: aload_1
    //   117: astore 4
    //   119: goto +84 -> 203
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_1
    //   125: aload 4
    //   127: astore_2
    //   128: goto +17 -> 145
    //   131: astore 4
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload_1
    //   138: astore_3
    //   139: goto +64 -> 203
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_1
    //   145: new 122	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   152: astore 4
    //   154: aload 4
    //   156: ldc 125
    //   158: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: aload_3
    //   165: invokevirtual 132	java/io/IOException:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 134
    //   174: aload 4
    //   176: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 141	com/tencent/rmonitor/fd/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: iconst_5
    //   184: aload_3
    //   185: invokevirtual 132	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 144	com/tencent/rmonitor/fd/dump/dumpers/FdThreadsDumper:a	(ILjava/lang/String;)Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;
    //   191: astore_3
    //   192: aload_2
    //   193: invokestatic 120	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   196: goto -104 -> 92
    //   199: astore 4
    //   201: aload_1
    //   202: astore_3
    //   203: aload_2
    //   204: invokestatic 120	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   207: aload_3
    //   208: invokestatic 120	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   211: goto +6 -> 217
    //   214: aload 4
    //   216: athrow
    //   217: goto -3 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	FdThreadsDumper
    //   0	220	1	paramString	String
    //   3	201	2	localObject1	java.lang.Object
    //   1	100	3	localObject2	java.lang.Object
    //   104	1	3	localIOException1	java.io.IOException
    //   112	1	3	localObject3	java.lang.Object
    //   122	14	3	localIOException2	java.io.IOException
    //   138	1	3	str	String
    //   142	43	3	localIOException3	java.io.IOException
    //   191	17	3	localObject4	java.lang.Object
    //   12	114	4	localObject5	java.lang.Object
    //   131	1	4	localObject6	java.lang.Object
    //   152	23	4	localStringBuilder	java.lang.StringBuilder
    //   199	16	4	localObject7	java.lang.Object
    //   34	14	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   24	36	98	finally
    //   36	71	98	finally
    //   74	85	98	finally
    //   24	36	104	java/io/IOException
    //   36	71	104	java/io/IOException
    //   74	85	104	java/io/IOException
    //   14	24	110	finally
    //   14	24	122	java/io/IOException
    //   4	14	131	finally
    //   4	14	142	java/io/IOException
    //   145	192	199	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.dumpers.FdThreadsDumper
 * JD-Core Version:    0.7.0.1
 */