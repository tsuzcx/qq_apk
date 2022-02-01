package com.tencent.rmonitor.fd.dump.dumpers;

import android.annotation.SuppressLint;
import com.tencent.rmonitor.fd.cluser.FdCluster;
import com.tencent.rmonitor.fd.cluser.FdClusterItem;
import com.tencent.rmonitor.fd.data.FdCountable;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class FdProcFdDumper
  extends BaseFdDumper
{
  private static final Pattern a = Pattern.compile("[^0-9]+");
  private static int b = -1;
  private static String d;
  private final FdCluster c = new FdCluster();
  
  private String a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((int)(paramFloat * 10000.0F) / 100.0F);
    localStringBuilder.append("%");
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void a(Map<Integer, FdClusterItem> paramMap, float paramFloat, BufferedWriter paramBufferedWriter)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FdClusterItem)paramMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
      paramBufferedWriter.write(String.format("%s,%d,%s", new Object[] { b(((FdClusterItem)localObject).a()), Integer.valueOf(((FdClusterItem)localObject).b()), a(((FdClusterItem)localObject).b() / paramFloat) }));
      paramBufferedWriter.newLine();
      localObject = ((FdClusterItem)localObject).d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        FdCountable localFdCountable = (FdCountable)((Iterator)localObject).next();
        paramBufferedWriter.write(String.format("%s,%d", new Object[] { localFdCountable.getItem(), Integer.valueOf(localFdCountable.getCount()) }));
        paramBufferedWriter.newLine();
      }
      paramBufferedWriter.newLine();
    }
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "others";
            }
            return "file";
          }
          return "dmabuf";
        }
        return "ashmem";
      }
      return "eventfd";
    }
    return "socket";
  }
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:b	I
    //   3: istore_0
    //   4: iload_0
    //   5: iconst_m1
    //   6: if_icmpeq +5 -> 11
    //   9: iload_0
    //   10: ireturn
    //   11: new 159	java/io/FileReader
    //   14: dup
    //   15: invokestatic 162	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:g	()Ljava/lang/String;
    //   18: invokespecial 164	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 166	java/io/BufferedReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 169	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   30: astore_3
    //   31: aload_1
    //   32: astore 4
    //   34: aload_3
    //   35: astore 5
    //   37: aload_3
    //   38: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 6
    //   43: aload_1
    //   44: astore_2
    //   45: aload_3
    //   46: astore 4
    //   48: aload 6
    //   50: ifnull +97 -> 147
    //   53: aload_1
    //   54: astore 4
    //   56: aload_3
    //   57: astore 5
    //   59: aload 6
    //   61: ldc 174
    //   63: invokevirtual 178	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifeq -35 -> 31
    //   69: aload_1
    //   70: astore 4
    //   72: aload_3
    //   73: astore 5
    //   75: aload 6
    //   77: invokestatic 181	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:c	(Ljava/lang/String;)I
    //   80: putstatic 26	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:b	I
    //   83: goto -52 -> 31
    //   86: astore 6
    //   88: aload_1
    //   89: astore_2
    //   90: aload_3
    //   91: astore_1
    //   92: goto +37 -> 129
    //   95: astore_2
    //   96: aconst_null
    //   97: astore 5
    //   99: goto +65 -> 164
    //   102: astore 6
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: astore_1
    //   110: goto +19 -> 129
    //   113: astore_2
    //   114: aconst_null
    //   115: astore 5
    //   117: aload 5
    //   119: astore_1
    //   120: goto +44 -> 164
    //   123: astore 6
    //   125: aconst_null
    //   126: astore_1
    //   127: aload_1
    //   128: astore_2
    //   129: aload_2
    //   130: astore 4
    //   132: aload_1
    //   133: astore 5
    //   135: ldc 183
    //   137: ldc 185
    //   139: aload 6
    //   141: invokestatic 190	com/tencent/rmonitor/fd/utils/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_1
    //   145: astore 4
    //   147: aload_2
    //   148: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   151: aload 4
    //   153: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   156: getstatic 26	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:b	I
    //   159: ireturn
    //   160: astore_2
    //   161: aload 4
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   168: aload 5
    //   170: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   173: goto +5 -> 178
    //   176: aload_2
    //   177: athrow
    //   178: goto -2 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	7	0	i	int
    //   21	144	1	localObject1	Object
    //   44	46	2	localObject2	Object
    //   95	1	2	localObject3	Object
    //   107	1	2	localObject4	Object
    //   113	1	2	localObject5	Object
    //   128	20	2	localObject6	Object
    //   160	17	2	localObject7	Object
    //   30	79	3	localBufferedReader	java.io.BufferedReader
    //   32	130	4	localObject8	Object
    //   35	134	5	localObject9	Object
    //   41	35	6	str	String
    //   86	1	6	localIOException1	java.io.IOException
    //   102	1	6	localIOException2	java.io.IOException
    //   123	17	6	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   37	43	86	java/io/IOException
    //   59	69	86	java/io/IOException
    //   75	83	86	java/io/IOException
    //   22	31	95	finally
    //   22	31	102	java/io/IOException
    //   11	22	113	finally
    //   11	22	123	java/io/IOException
    //   37	43	160	finally
    //   59	69	160	finally
    //   75	83	160	finally
    //   135	144	160	finally
  }
  
  public static int c(String paramString)
  {
    paramString = a.split(paramString);
    if (paramString.length > 1) {
      paramString = paramString[1];
    } else {
      paramString = null;
    }
    if (paramString != null) {}
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label34:
      StringBuilder localStringBuilder;
      break label34;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseMaxOpenFiles failed: ");
    localStringBuilder.append(paramString);
    LogUtils.d("ProcFdDump", localStringBuilder.toString());
    return -1;
  }
  
  public static int d()
  {
    File[] arrayOfFile = new File(f()).listFiles();
    if (arrayOfFile != null) {
      return arrayOfFile.length;
    }
    return 2147483647;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  private static String d(String paramString)
  {
    // Byte code:
    //   0: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +70 -> 75
    //   8: aload_0
    //   9: invokestatic 234	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: aconst_null
    //   14: putstatic 236	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:d	Ljava/lang/String;
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   24: putstatic 236	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:d	Ljava/lang/String;
    //   27: new 38	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   34: astore_2
    //   35: aload_2
    //   36: ldc 241
    //   38: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: aload_0
    //   44: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc 243
    //   51: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: aload_1
    //   57: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   60: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 183
    //   66: aload_2
    //   67: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 209	com/tencent/rmonitor/fd/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aconst_null
    //   74: areturn
    //   75: new 38	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: ldc 245
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: aload_0
    //   92: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 7
    //   102: invokestatic 251	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   105: aload 7
    //   107: invokevirtual 255	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   110: invokevirtual 261	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   113: astore_0
    //   114: new 263	java/io/InputStreamReader
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 266	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   122: astore_3
    //   123: new 166	java/io/BufferedReader
    //   126: dup
    //   127: aload_3
    //   128: invokespecial 169	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   131: astore 6
    //   133: aload_0
    //   134: astore_1
    //   135: aload_3
    //   136: astore_2
    //   137: aload 6
    //   139: astore 4
    //   141: aload 6
    //   143: invokevirtual 172	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   146: astore 5
    //   148: aload_0
    //   149: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   152: aload_3
    //   153: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   156: aload 6
    //   158: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   161: aload 5
    //   163: areturn
    //   164: astore_1
    //   165: aload_0
    //   166: astore 5
    //   168: aload 6
    //   170: astore_0
    //   171: aload_1
    //   172: astore 6
    //   174: goto +60 -> 234
    //   177: astore_1
    //   178: aconst_null
    //   179: astore 4
    //   181: aload_3
    //   182: astore_2
    //   183: aload_1
    //   184: astore_3
    //   185: goto +154 -> 339
    //   188: astore 6
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_0
    //   193: astore 5
    //   195: aload_1
    //   196: astore_0
    //   197: goto +37 -> 234
    //   200: astore_1
    //   201: goto +14 -> 215
    //   204: astore 6
    //   206: aload_0
    //   207: astore 5
    //   209: goto +21 -> 230
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_2
    //   217: aconst_null
    //   218: astore 4
    //   220: aload_1
    //   221: astore_3
    //   222: goto +117 -> 339
    //   225: astore 6
    //   227: aconst_null
    //   228: astore 5
    //   230: aconst_null
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_0
    //   234: aload 5
    //   236: astore_1
    //   237: aload_3
    //   238: astore_2
    //   239: aload_0
    //   240: astore 4
    //   242: new 38	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   249: astore 8
    //   251: aload 5
    //   253: astore_1
    //   254: aload_3
    //   255: astore_2
    //   256: aload_0
    //   257: astore 4
    //   259: aload 8
    //   261: aload 7
    //   263: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 5
    //   269: astore_1
    //   270: aload_3
    //   271: astore_2
    //   272: aload_0
    //   273: astore 4
    //   275: aload 8
    //   277: ldc_w 268
    //   280: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 5
    //   286: astore_1
    //   287: aload_3
    //   288: astore_2
    //   289: aload_0
    //   290: astore 4
    //   292: aload 8
    //   294: aload 6
    //   296: invokevirtual 269	java/io/IOException:getMessage	()Ljava/lang/String;
    //   299: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 5
    //   305: astore_1
    //   306: aload_3
    //   307: astore_2
    //   308: aload_0
    //   309: astore 4
    //   311: ldc 183
    //   313: aload 8
    //   315: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 209	com/tencent/rmonitor/fd/utils/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 5
    //   323: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   326: aload_3
    //   327: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   330: aload_0
    //   331: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   334: aconst_null
    //   335: areturn
    //   336: astore_3
    //   337: aload_1
    //   338: astore_0
    //   339: aload_0
    //   340: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   343: aload_2
    //   344: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   347: aload 4
    //   349: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   352: aload_3
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramString	String
    //   12	6	1	str1	String
    //   19	38	1	localException	java.lang.Exception
    //   82	53	1	localObject1	Object
    //   164	8	1	localIOException1	java.io.IOException
    //   177	7	1	localObject2	Object
    //   191	5	1	localObject3	Object
    //   200	1	1	localObject4	Object
    //   212	9	1	localObject5	Object
    //   236	102	1	localObject6	Object
    //   34	310	2	localObject7	Object
    //   122	205	3	localObject8	Object
    //   336	17	3	localObject9	Object
    //   139	209	4	localObject10	Object
    //   146	176	5	str2	String
    //   131	42	6	localObject11	Object
    //   188	1	6	localIOException2	java.io.IOException
    //   204	1	6	localIOException3	java.io.IOException
    //   225	70	6	localIOException4	java.io.IOException
    //   100	162	7	str3	String
    //   249	65	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	17	19	java/lang/Exception
    //   141	148	164	java/io/IOException
    //   123	133	177	finally
    //   123	133	188	java/io/IOException
    //   114	123	200	finally
    //   114	123	204	java/io/IOException
    //   102	114	212	finally
    //   102	114	225	java/io/IOException
    //   141	148	336	finally
    //   242	251	336	finally
    //   259	267	336	finally
    //   275	284	336	finally
    //   292	303	336	finally
    //   311	321	336	finally
  }
  
  @NotNull
  public static List<String> e()
  {
    File[] arrayOfFile = new File(f()).listFiles();
    if (arrayOfFile == null)
    {
      LogUtils.c("ProcFdDump", "dumpFdList failed");
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      String str = d(arrayOfFile[i].getAbsolutePath());
      if (str != null) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static String f()
  {
    return "/proc/self/fd";
  }
  
  private static String g()
  {
    return "/proc/self/limits";
  }
  
  public int a()
  {
    return 1;
  }
  
  /* Error */
  protected com.tencent.rmonitor.fd.dump.FdLeakDumpResult b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 300	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:e	()Ljava/util/List;
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 35	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:c	Lcom/tencent/rmonitor/fd/cluser/FdCluster;
    //   8: aload_3
    //   9: invokevirtual 303	com/tencent/rmonitor/fd/cluser/FdCluster:a	(Ljava/util/List;)Ljava/util/Map;
    //   12: astore 4
    //   14: aload_3
    //   15: invokeinterface 306 1 0
    //   20: ifne +182 -> 202
    //   23: aload 4
    //   25: invokeinterface 307 1 0
    //   30: ifeq +6 -> 36
    //   33: goto +169 -> 202
    //   36: aload_3
    //   37: invokeinterface 310 1 0
    //   42: i2f
    //   43: fstore_2
    //   44: aconst_null
    //   45: astore_3
    //   46: aconst_null
    //   47: astore 6
    //   49: new 312	java/io/FileWriter
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 313	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   57: astore 5
    //   59: new 117	java/io/BufferedWriter
    //   62: dup
    //   63: aload 5
    //   65: invokespecial 316	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   68: astore_3
    //   69: aload_0
    //   70: aload 4
    //   72: fload_2
    //   73: aload_3
    //   74: invokespecial 318	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:a	(Ljava/util/Map;FLjava/io/BufferedWriter;)V
    //   77: aload_3
    //   78: invokevirtual 321	java/io/BufferedWriter:flush	()V
    //   81: aload_0
    //   82: aload_1
    //   83: aload 4
    //   85: invokevirtual 324	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;
    //   88: astore_1
    //   89: aload 5
    //   91: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   94: aload_3
    //   95: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   98: aload_1
    //   99: areturn
    //   100: astore_1
    //   101: aload_3
    //   102: astore 4
    //   104: goto +12 -> 116
    //   107: astore 4
    //   109: goto +20 -> 129
    //   112: astore_1
    //   113: aconst_null
    //   114: astore 4
    //   116: aload 5
    //   118: astore_3
    //   119: aload_1
    //   120: astore 5
    //   122: goto +68 -> 190
    //   125: astore 4
    //   127: aconst_null
    //   128: astore_3
    //   129: aload 5
    //   131: astore_1
    //   132: goto +18 -> 150
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: goto +50 -> 190
    //   143: astore 4
    //   145: aconst_null
    //   146: astore_3
    //   147: aload 6
    //   149: astore_1
    //   150: ldc 183
    //   152: ldc_w 326
    //   155: aload 4
    //   157: invokestatic 190	com/tencent/rmonitor/fd/utils/LogUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_0
    //   161: iconst_5
    //   162: aload 4
    //   164: invokevirtual 269	java/io/IOException:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 329	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:a	(ILjava/lang/String;)Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;
    //   170: astore 4
    //   172: aload_1
    //   173: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   176: aload_3
    //   177: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   180: aload 4
    //   182: areturn
    //   183: astore 5
    //   185: aload_3
    //   186: astore 4
    //   188: aload_1
    //   189: astore_3
    //   190: aload_3
    //   191: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   194: aload 4
    //   196: invokestatic 195	com/tencent/rmonitor/fd/utils/IOUtil:a	(Ljava/io/Closeable;)V
    //   199: aload 5
    //   201: athrow
    //   202: aload_0
    //   203: bipush 11
    //   205: getstatic 236	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:d	Ljava/lang/String;
    //   208: invokevirtual 329	com/tencent/rmonitor/fd/dump/dumpers/FdProcFdDumper:a	(ILjava/lang/String;)Lcom/tencent/rmonitor/fd/dump/FdLeakDumpResult;
    //   211: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	FdProcFdDumper
    //   0	212	1	paramString	String
    //   43	30	2	f	float
    //   3	188	3	localObject1	Object
    //   12	91	4	localObject2	Object
    //   107	1	4	localIOException1	java.io.IOException
    //   114	1	4	localObject3	Object
    //   125	1	4	localIOException2	java.io.IOException
    //   138	1	4	localObject4	Object
    //   143	20	4	localIOException3	java.io.IOException
    //   170	25	4	localObject5	Object
    //   57	73	5	localObject6	Object
    //   135	1	5	localObject7	Object
    //   183	17	5	localObject8	Object
    //   47	101	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   69	89	100	finally
    //   69	89	107	java/io/IOException
    //   59	69	112	finally
    //   59	69	125	java/io/IOException
    //   49	59	135	finally
    //   49	59	143	java/io/IOException
    //   150	172	183	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper
 * JD-Core Version:    0.7.0.1
 */