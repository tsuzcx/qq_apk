package com.tencent.tmassistant.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import java.io.File;
import java.util.List;

public class a
{
  static long a(File paramFile)
  {
    if (paramFile == null) {
      return 0L;
    }
    long l3 = System.currentTimeMillis();
    long l1 = paramFile.lastModified();
    try
    {
      l2 = a(paramFile, l1);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      long l2;
      label24:
      break label24;
    }
    l2 = System.currentTimeMillis();
    ab.c("AnalysisUtil_", String.format("%-60s -last modify time:%-30s -time cost: %-5dms\n", new Object[] { paramFile.getAbsolutePath(), GlobalUtil.getDay(l1), Long.valueOf(l2 - l3) }));
    return l1;
  }
  
  private static long a(File paramFile, long paramLong)
  {
    if (paramFile == null) {}
    String str;
    long l1;
    do
    {
      return paramLong;
      str = GlobalUtil.getCurrentDay();
      if (TextUtils.equals(GlobalUtil.getDay(paramLong), str))
      {
        ab.c("AnalysisUtil_", "[findLastModifyTimeInternal] currentLastModifyTime is today:" + str);
        return paramLong;
      }
      l1 = paramFile.lastModified();
      l2 = l1;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
    } while (paramFile == null);
    int j = paramFile.length;
    int i = 0;
    long l2 = l1;
    if (i < j)
    {
      l2 = a(paramFile[i], paramLong);
      if (l2 <= l1) {
        break label164;
      }
      l1 = l2;
    }
    label164:
    for (;;)
    {
      if (TextUtils.equals(GlobalUtil.getDay(l1), str))
      {
        ab.c("AnalysisUtil_", "[findLastModifyTimeInternal] found today file:" + str);
        return l1;
      }
      i += 1;
      break;
      return l2;
    }
  }
  
  static String a(String paramString, List<String> paramList)
  {
    Object localObject = GlobalUtil.getInstance().getContext();
    if ((localObject == null) || (paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    localObject = ((Context)localObject).getPackageManager();
    try
    {
      paramString = b(((PackageManager)localObject).getPackageInfo(paramString, 1).applicationInfo.sourceDir, paramList);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return "";
  }
  
  /* Error */
  private static String b(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 106 1 0
    //   6: istore_3
    //   7: iload_3
    //   8: newarray int
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: new 141	java/util/zip/ZipFile
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 144	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: iload_3
    //   28: if_icmpge +32 -> 60
    //   31: aload_0
    //   32: aload_1
    //   33: iload_2
    //   34: invokeinterface 148 2 0
    //   39: checkcast 44	java/lang/String
    //   42: invokevirtual 152	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: iload_2
    //   51: iconst_1
    //   52: iastore
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -31 -> 26
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   68: new 66	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   75: astore_0
    //   76: iconst_0
    //   77: istore_2
    //   78: iload_2
    //   79: iload_3
    //   80: if_icmpge +58 -> 138
    //   83: aload_0
    //   84: aload 5
    //   86: iload_2
    //   87: iaload
    //   88: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_0
    //   93: ldc 160
    //   95: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iload_2
    //   100: iconst_1
    //   101: iadd
    //   102: istore_2
    //   103: goto -25 -> 78
    //   106: astore_0
    //   107: aload 4
    //   109: astore_0
    //   110: aload_0
    //   111: ifnull -43 -> 68
    //   114: aload_0
    //   115: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   118: goto -50 -> 68
    //   121: astore_0
    //   122: goto -54 -> 68
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   136: aload_1
    //   137: athrow
    //   138: aload_0
    //   139: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: areturn
    //   143: astore_0
    //   144: goto -76 -> 68
    //   147: astore_0
    //   148: goto -12 -> 136
    //   151: astore_1
    //   152: goto -24 -> 128
    //   155: astore_1
    //   156: goto -46 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   0	159	1	paramList	List<String>
    //   25	78	2	i	int
    //   6	75	3	j	int
    //   13	95	4	localObject	Object
    //   10	75	5	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   15	24	106	java/io/IOException
    //   114	118	121	java/io/IOException
    //   15	24	125	finally
    //   64	68	143	java/io/IOException
    //   132	136	147	java/io/IOException
    //   31	48	151	finally
    //   31	48	155	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.a.a
 * JD-Core Version:    0.7.0.1
 */