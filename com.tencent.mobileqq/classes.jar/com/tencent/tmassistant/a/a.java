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
    if (paramFile == null) {
      return paramLong;
    }
    String str = GlobalUtil.getCurrentDay();
    if (TextUtils.equals(GlobalUtil.getDay(paramLong), str))
    {
      paramFile = new StringBuilder();
      paramFile.append("[findLastModifyTimeInternal] currentLastModifyTime is today:");
      paramFile.append(str);
      ab.c("AnalysisUtil_", paramFile.toString());
      return paramLong;
    }
    long l1 = paramFile.lastModified();
    long l2 = l1;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return paramLong;
      }
      int j = paramFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        long l3 = a(paramFile[i], paramLong);
        l2 = l1;
        if (l3 > l1) {
          l2 = l3;
        }
        if (TextUtils.equals(GlobalUtil.getDay(l2), str))
        {
          paramFile = new StringBuilder();
          paramFile.append("[findLastModifyTimeInternal] found today file:");
          paramFile.append(str);
          ab.c("AnalysisUtil_", paramFile.toString());
          return l2;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  static String a(String paramString, List<String> paramList)
  {
    Context localContext = GlobalUtil.getInstance().getContext();
    String str = "";
    Object localObject = str;
    if (localContext != null)
    {
      localObject = str;
      if (paramList != null)
      {
        if (paramList.size() == 0) {
          return "";
        }
        localObject = localContext.getPackageManager();
      }
    }
    try
    {
      localObject = b(((PackageManager)localObject).getPackageInfo(paramString, 1).applicationInfo.sourceDir, paramList);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return "";
  }
  
  /* Error */
  private static String b(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 108 1 0
    //   6: istore 4
    //   8: iload 4
    //   10: newarray int
    //   12: astore 6
    //   14: iconst_0
    //   15: istore_3
    //   16: new 141	java/util/zip/ZipFile
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 144	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: iconst_0
    //   26: istore_2
    //   27: aload_0
    //   28: astore 5
    //   30: iload_2
    //   31: iload 4
    //   33: if_icmpge +45 -> 78
    //   36: aload_0
    //   37: aload_1
    //   38: iload_2
    //   39: invokeinterface 148 2 0
    //   44: checkcast 44	java/lang/String
    //   47: invokevirtual 152	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   50: ifnull +8 -> 58
    //   53: aload 6
    //   55: iload_2
    //   56: iconst_1
    //   57: iastore
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: istore_2
    //   62: goto -35 -> 27
    //   65: astore 5
    //   67: aload_0
    //   68: astore_1
    //   69: aload 5
    //   71: astore_0
    //   72: goto +17 -> 89
    //   75: goto +26 -> 101
    //   78: aload 5
    //   80: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   83: goto +28 -> 111
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 155	java/util/zip/ZipFile:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +9 -> 111
    //   105: aload_0
    //   106: astore 5
    //   108: goto -30 -> 78
    //   111: new 66	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   118: astore_0
    //   119: iload_3
    //   120: istore_2
    //   121: iload_2
    //   122: iload 4
    //   124: if_icmpge +26 -> 150
    //   127: aload_0
    //   128: aload 6
    //   130: iload_2
    //   131: iaload
    //   132: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_0
    //   137: ldc 160
    //   139: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: iload_2
    //   144: iconst_1
    //   145: iadd
    //   146: istore_2
    //   147: goto -26 -> 121
    //   150: aload_0
    //   151: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: areturn
    //   155: astore_0
    //   156: goto -57 -> 99
    //   159: astore_1
    //   160: goto -85 -> 75
    //   163: astore_0
    //   164: goto -53 -> 111
    //   167: astore_1
    //   168: goto -71 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramString	String
    //   0	171	1	paramList	List<String>
    //   26	121	2	i	int
    //   15	105	3	j	int
    //   6	119	4	k	int
    //   28	1	5	str1	String
    //   65	14	5	localObject	Object
    //   106	1	5	str2	String
    //   12	117	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   36	53	65	finally
    //   16	25	86	finally
    //   16	25	155	java/io/IOException
    //   36	53	159	java/io/IOException
    //   78	83	163	java/io/IOException
    //   93	97	167	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.a.a
 * JD-Core Version:    0.7.0.1
 */