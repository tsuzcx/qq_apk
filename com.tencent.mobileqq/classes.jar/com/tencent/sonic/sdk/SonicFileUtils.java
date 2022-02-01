package com.tencent.sonic.sdk;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SonicFileUtils
{
  private static final String DATA_EXT = ".data";
  private static final String HEADER_EXT = ".header";
  private static final String HTML_EXT = ".html";
  private static final String TAG = "SonicSdk_SonicFileUtils";
  private static final String TEMPLATE_EXT = ".tpl";
  private static final double THRESHOLD_OF_CACHE_MAX_PERCENT = 0.8D;
  private static final double THRESHOLD_OF_CACHE_MIN_PERCENT = 0.25D;
  
  private static long calcCacheSize(String paramString, Map<String, List<String>> paramMap)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      l2 = l1;
      if (paramString.isDirectory())
      {
        File[] arrayOfFile = paramString.listFiles();
        l2 = l1;
        if (arrayOfFile != null)
        {
          l2 = l1;
          if (arrayOfFile.length > 0)
          {
            int j = arrayOfFile.length;
            int i = 0;
            for (;;)
            {
              l2 = l1;
              if (i >= j) {
                break;
              }
              File localFile = arrayOfFile[i];
              l1 += localFile.length();
              String str = localFile.getName();
              List localList = (List)paramMap.get(str);
              paramString = localList;
              if (localList == null) {
                paramString = new ArrayList();
              }
              paramString.add(localFile.getAbsolutePath());
              paramMap.put(str, paramString);
              i += 1;
            }
          }
        }
      }
    }
    return l2;
  }
  
  static void checkAndTrimCache()
  {
    Object localObject1 = new HashMap();
    long l3 = System.currentTimeMillis();
    long l1 = calcCacheSize(getSonicCacheDirPath(), (Map)localObject1);
    long l2 = SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_SIZE;
    double d2 = l1;
    double d1 = l2;
    Double.isNaN(d1);
    if (d2 > 0.8D * d1)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("now try clear cache, current cache size: ");
      ((StringBuilder)localObject2).append(l1 / 1024L / 1024L);
      ((StringBuilder)localObject2).append("m");
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject2).toString());
      localObject2 = SonicDataHelper.getAllSessionByHitCount();
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        Object localObject3 = (List)((HashMap)localObject1).get(((SonicDataHelper.SessionData)((List)localObject2).get(i)).sessionId);
        l2 = l1;
        if (localObject3 != null)
        {
          l2 = l1;
          if (((List)localObject3).size() > 0)
          {
            localObject3 = ((List)localObject3).iterator();
            for (;;)
            {
              l2 = l1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              File localFile = new File((String)((Iterator)localObject3).next());
              if ((localFile.isFile()) && (localFile.exists()))
              {
                Object localObject4 = localFile.getName();
                l2 = localFile.length();
                if (localFile.delete())
                {
                  l1 -= l2;
                  SonicDataHelper.removeSessionData((String)localObject4);
                  SonicChunkDataHelper.removeChunkData((String)localObject4);
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("delete ");
                  ((StringBuilder)localObject4).append(localFile.getAbsolutePath());
                  SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject4).toString());
                }
              }
            }
          }
        }
        d2 = l2;
        Double.isNaN(d1);
        if (d2 <= 0.25D * d1) {
          break;
        }
        i += 1;
        l1 = l2;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAndTrimCache: finish , cost ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l3);
      ((StringBuilder)localObject1).append("ms.");
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  static void checkAndTrimResourceCache()
  {
    Object localObject1 = new HashMap();
    long l3 = System.currentTimeMillis();
    long l1 = calcCacheSize(getSonicResourceCachePath(), (Map)localObject1);
    long l2 = SonicEngine.getInstance().getConfig().SONIC_RESOURCE_CACHE_MAX_SIZE;
    double d2 = l1;
    double d1 = l2;
    Double.isNaN(d1);
    if (d2 > 0.8D * d1)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("now try clear cache, current cache size: ");
      ((StringBuilder)localObject2).append(l1 / 1024L / 1024L);
      ((StringBuilder)localObject2).append("m");
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject2).toString());
      localObject2 = SonicResourceDataHelper.getAllResourceData();
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        Object localObject3 = (List)((HashMap)localObject1).get(((SonicResourceDataHelper.ResourceData)((List)localObject2).get(i)).resourceId);
        l2 = l1;
        if (localObject3 != null)
        {
          l2 = l1;
          if (((List)localObject3).size() > 0)
          {
            localObject3 = ((List)localObject3).iterator();
            for (;;)
            {
              l2 = l1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              File localFile = new File((String)((Iterator)localObject3).next());
              if ((localFile.isFile()) && (localFile.exists()))
              {
                Object localObject4 = localFile.getName();
                l2 = localFile.length();
                if (localFile.delete())
                {
                  l1 -= l2;
                  SonicResourceDataHelper.removeResourceData((String)localObject4);
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("delete ");
                  ((StringBuilder)localObject4).append(localFile.getAbsolutePath());
                  SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject4).toString());
                }
              }
            }
          }
        }
        d2 = l2;
        Double.isNaN(d1);
        if (d2 <= 0.25D * d1) {
          break;
        }
        i += 1;
        l1 = l2;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkAndTrimCache: finish , cost ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l3);
      ((StringBuilder)localObject1).append("ms.");
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  static String convertHeadersToString(Map<String, List<String>> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        if (!TextUtils.isEmpty(str1))
        {
          localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            if (!TextUtils.isEmpty(str2))
            {
              localStringBuilder.append(str1);
              localStringBuilder.append(" : ");
              localStringBuilder.append(str2);
              localStringBuilder.append("\r\n");
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  static boolean deleteAllChildFiles(File paramFile)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool3;
    if (paramFile != null)
    {
      bool2 = bool3;
      if (paramFile.exists())
      {
        if (paramFile.isFile()) {
          return paramFile.delete();
        }
        bool2 = bool3;
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          bool2 = bool3;
          if (paramFile != null)
          {
            int j = paramFile.length;
            int i = 0;
            for (;;)
            {
              bool2 = bool1;
              if (i >= j) {
                break;
              }
              bool1 &= deleteAllChildFiles(paramFile[i]);
              i += 1;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  static boolean deleteResourceFiles(String paramString)
  {
    File localFile = new File(getSonicResourcePath(paramString));
    boolean bool1;
    if (localFile.exists()) {
      bool1 = localFile.delete();
    } else {
      bool1 = true;
    }
    paramString = new File(getSonicHeaderPath(paramString));
    boolean bool2 = bool1;
    if (paramString.exists()) {
      bool2 = bool1 & paramString.delete();
    }
    return bool2;
  }
  
  static boolean deleteSonicFiles(String paramString)
  {
    File localFile = new File(getSonicHtmlPath(paramString));
    if (localFile.exists()) {
      bool2 = localFile.delete();
    } else {
      bool2 = true;
    }
    localFile = new File(getSonicTemplatePath(paramString));
    boolean bool1 = bool2;
    if (localFile.exists()) {
      bool1 = bool2 & localFile.delete();
    }
    localFile = new File(getSonicDataPath(paramString));
    boolean bool2 = bool1;
    if (localFile.exists()) {
      bool2 = bool1 & localFile.delete();
    }
    paramString = new File(getSonicHeaderPath(paramString));
    bool1 = bool2;
    if (paramString.exists()) {
      bool1 = bool2 & paramString.delete();
    }
    return bool1;
  }
  
  public static Map<String, List<String>> getHeaderFromLocalCache(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = new File(paramString);
    if (paramString.exists())
    {
      paramString = readFile(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString1 = paramString.split("\r\n");
        if (arrayOfString1.length > 0)
        {
          int j = arrayOfString1.length;
          int i = 0;
          while (i < j)
          {
            String[] arrayOfString2 = arrayOfString1[i].split(" : ");
            if (arrayOfString2.length == 2)
            {
              String str = arrayOfString2[0].trim();
              List localList = (List)localHashMap.get(str.toLowerCase());
              paramString = localList;
              if (localList == null)
              {
                paramString = new ArrayList(1);
                localHashMap.put(str.toLowerCase(), paramString);
              }
              paramString.add(arrayOfString2[1].trim());
            }
            i += 1;
          }
        }
      }
    }
    return localHashMap;
  }
  
  static String getSonicCacheDirPath()
  {
    String str = SonicEngine.getInstance().getRuntime().getSonicCacheDir().getAbsolutePath();
    Object localObject = str;
    if (!str.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  static String getSonicDataPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicCacheDirPath());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".data");
    return localStringBuilder.toString();
  }
  
  static String getSonicHeaderPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicCacheDirPath());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".header");
    return localStringBuilder.toString();
  }
  
  static String getSonicHtmlPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicCacheDirPath());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".html");
    return localStringBuilder.toString();
  }
  
  static String getSonicResourceCachePath()
  {
    String str = SonicEngine.getInstance().getRuntime().getSonicResourceCacheDir().getAbsolutePath();
    Object localObject = str;
    if (!str.endsWith(File.separator))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String getSonicResourceHeaderPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicResourceCachePath());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".header");
    return localStringBuilder.toString();
  }
  
  public static String getSonicResourcePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicResourceCachePath());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  static String getSonicTemplatePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSonicCacheDirPath());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".tpl");
    return localStringBuilder.toString();
  }
  
  /* Error */
  static String readFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +727 -> 731
    //   7: aload_0
    //   8: invokevirtual 43	java/io/File:exists	()Z
    //   11: ifeq +720 -> 731
    //   14: aload_0
    //   15: invokevirtual 318	java/io/File:canRead	()Z
    //   18: ifne +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 320	java/io/BufferedInputStream
    //   26: dup
    //   27: new 322	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 328	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: new 330	java/io/InputStreamReader
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 331	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: astore 6
    //   49: aload_2
    //   50: astore_3
    //   51: aload 6
    //   53: astore 4
    //   55: aload_0
    //   56: invokevirtual 54	java/io/File:length	()J
    //   59: l2i
    //   60: istore_1
    //   61: iload_1
    //   62: sipush 12288
    //   65: if_icmple +91 -> 156
    //   68: aload_2
    //   69: astore_3
    //   70: aload 6
    //   72: astore 4
    //   74: sipush 4096
    //   77: newarray char
    //   79: astore 5
    //   81: aload_2
    //   82: astore_3
    //   83: aload 6
    //   85: astore 4
    //   87: new 120	java/lang/StringBuilder
    //   90: dup
    //   91: sipush 12288
    //   94: invokespecial 332	java/lang/StringBuilder:<init>	(I)V
    //   97: astore 8
    //   99: aload_2
    //   100: astore_3
    //   101: aload 6
    //   103: astore 4
    //   105: aload 6
    //   107: aload 5
    //   109: invokevirtual 336	java/io/InputStreamReader:read	([C)I
    //   112: istore_1
    //   113: iconst_m1
    //   114: iload_1
    //   115: if_icmpeq +22 -> 137
    //   118: aload_2
    //   119: astore_3
    //   120: aload 6
    //   122: astore 4
    //   124: aload 8
    //   126: aload 5
    //   128: iconst_0
    //   129: iload_1
    //   130: invokevirtual 339	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: goto -35 -> 99
    //   137: aload_2
    //   138: astore_3
    //   139: aload 6
    //   141: astore 4
    //   143: aload 8
    //   145: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 5
    //   150: aload 5
    //   152: astore_3
    //   153: goto +42 -> 195
    //   156: aload_2
    //   157: astore_3
    //   158: aload 6
    //   160: astore 4
    //   162: iload_1
    //   163: newarray char
    //   165: astore 5
    //   167: aload_2
    //   168: astore_3
    //   169: aload 6
    //   171: astore 4
    //   173: new 177	java/lang/String
    //   176: dup
    //   177: aload 5
    //   179: iconst_0
    //   180: aload 6
    //   182: aload 5
    //   184: invokevirtual 336	java/io/InputStreamReader:read	([C)I
    //   187: invokespecial 342	java/lang/String:<init>	([CII)V
    //   190: astore 5
    //   192: aload 5
    //   194: astore_3
    //   195: aload_2
    //   196: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   199: goto +63 -> 262
    //   202: astore_2
    //   203: new 120	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   210: astore 4
    //   212: aload 4
    //   214: ldc_w 347
    //   217: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: aload_0
    //   224: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   227: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 4
    //   233: ldc_w 349
    //   236: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: aload_2
    //   243: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 17
    //   252: bipush 6
    //   254: aload 4
    //   256: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload 6
    //   264: invokevirtual 353	java/io/InputStreamReader:close	()V
    //   267: aload_3
    //   268: areturn
    //   269: astore_2
    //   270: new 120	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   277: astore 4
    //   279: aload 4
    //   281: ldc_w 347
    //   284: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 4
    //   290: aload_0
    //   291: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   294: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: ldc_w 349
    //   303: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 4
    //   309: aload_2
    //   310: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc 17
    //   319: bipush 6
    //   321: aload 4
    //   323: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_3
    //   330: areturn
    //   331: astore_3
    //   332: aload_2
    //   333: astore 5
    //   335: aload 6
    //   337: astore_2
    //   338: aload_3
    //   339: astore 6
    //   341: goto +40 -> 381
    //   344: astore_3
    //   345: aconst_null
    //   346: astore 4
    //   348: goto +237 -> 585
    //   351: astore 6
    //   353: aconst_null
    //   354: astore_3
    //   355: aload_2
    //   356: astore 5
    //   358: aload_3
    //   359: astore_2
    //   360: goto +21 -> 381
    //   363: astore_3
    //   364: aconst_null
    //   365: astore 4
    //   367: aload 4
    //   369: astore_2
    //   370: goto +215 -> 585
    //   373: astore 6
    //   375: aconst_null
    //   376: astore 5
    //   378: aload 5
    //   380: astore_2
    //   381: aload 5
    //   383: astore_3
    //   384: aload_2
    //   385: astore 4
    //   387: new 120	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   394: astore 8
    //   396: aload 5
    //   398: astore_3
    //   399: aload_2
    //   400: astore 4
    //   402: aload 8
    //   404: ldc_w 355
    //   407: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 5
    //   413: astore_3
    //   414: aload_2
    //   415: astore 4
    //   417: aload 8
    //   419: aload_0
    //   420: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   423: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 5
    //   429: astore_3
    //   430: aload_2
    //   431: astore 4
    //   433: aload 8
    //   435: ldc_w 349
    //   438: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 5
    //   444: astore_3
    //   445: aload_2
    //   446: astore 4
    //   448: aload 8
    //   450: aload 6
    //   452: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 5
    //   461: astore_3
    //   462: aload_2
    //   463: astore 4
    //   465: ldc 17
    //   467: bipush 6
    //   469: aload 8
    //   471: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload 5
    //   479: ifnull +71 -> 550
    //   482: aload 5
    //   484: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   487: goto +63 -> 550
    //   490: astore_3
    //   491: new 120	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   498: astore 4
    //   500: aload 4
    //   502: ldc_w 347
    //   505: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: aload_0
    //   512: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   515: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 4
    //   521: ldc_w 349
    //   524: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 4
    //   530: aload_3
    //   531: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   534: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: ldc 17
    //   540: bipush 6
    //   542: aload 4
    //   544: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aload_2
    //   551: ifnull +25 -> 576
    //   554: aload_2
    //   555: invokevirtual 353	java/io/InputStreamReader:close	()V
    //   558: aconst_null
    //   559: areturn
    //   560: astore_2
    //   561: new 120	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   568: astore 4
    //   570: aload 7
    //   572: astore_3
    //   573: goto -294 -> 279
    //   576: aconst_null
    //   577: areturn
    //   578: astore 5
    //   580: aload_3
    //   581: astore_2
    //   582: aload 5
    //   584: astore_3
    //   585: aload_2
    //   586: ifnull +70 -> 656
    //   589: aload_2
    //   590: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   593: goto +63 -> 656
    //   596: astore_2
    //   597: new 120	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   604: astore 5
    //   606: aload 5
    //   608: ldc_w 347
    //   611: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 5
    //   617: aload_0
    //   618: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   621: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: aload 5
    //   627: ldc_w 349
    //   630: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 5
    //   636: aload_2
    //   637: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   640: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: ldc 17
    //   646: bipush 6
    //   648: aload 5
    //   650: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: aload 4
    //   658: ifnull +71 -> 729
    //   661: aload 4
    //   663: invokevirtual 353	java/io/InputStreamReader:close	()V
    //   666: goto +63 -> 729
    //   669: astore_2
    //   670: new 120	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   677: astore 4
    //   679: aload 4
    //   681: ldc_w 347
    //   684: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 4
    //   690: aload_0
    //   691: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   694: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 4
    //   700: ldc_w 349
    //   703: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload 4
    //   709: aload_2
    //   710: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   713: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: ldc 17
    //   719: bipush 6
    //   721: aload 4
    //   723: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: aload_3
    //   730: athrow
    //   731: aconst_null
    //   732: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	paramFile	File
    //   60	103	1	i	int
    //   38	158	2	localBufferedInputStream	java.io.BufferedInputStream
    //   202	41	2	localException1	java.lang.Exception
    //   269	64	2	localException2	java.lang.Exception
    //   337	218	2	localObject1	Object
    //   560	1	2	localException3	java.lang.Exception
    //   581	9	2	localObject2	Object
    //   596	41	2	localException4	java.lang.Exception
    //   669	41	2	localException5	java.lang.Exception
    //   50	280	3	localObject3	Object
    //   331	8	3	localThrowable1	java.lang.Throwable
    //   344	1	3	localObject4	Object
    //   354	5	3	localObject5	Object
    //   363	1	3	localObject6	Object
    //   383	79	3	localObject7	Object
    //   490	41	3	localException6	java.lang.Exception
    //   572	158	3	localObject8	Object
    //   53	669	4	localObject9	Object
    //   79	404	5	localObject10	Object
    //   578	5	5	localObject11	Object
    //   604	45	5	localStringBuilder1	StringBuilder
    //   47	293	6	localObject12	Object
    //   351	1	6	localThrowable2	java.lang.Throwable
    //   373	78	6	localThrowable3	java.lang.Throwable
    //   1	570	7	localObject13	Object
    //   97	373	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   195	199	202	java/lang/Exception
    //   262	267	269	java/lang/Exception
    //   55	61	331	java/lang/Throwable
    //   74	81	331	java/lang/Throwable
    //   87	99	331	java/lang/Throwable
    //   105	113	331	java/lang/Throwable
    //   124	134	331	java/lang/Throwable
    //   143	150	331	java/lang/Throwable
    //   162	167	331	java/lang/Throwable
    //   173	192	331	java/lang/Throwable
    //   39	49	344	finally
    //   39	49	351	java/lang/Throwable
    //   23	39	363	finally
    //   23	39	373	java/lang/Throwable
    //   482	487	490	java/lang/Exception
    //   554	558	560	java/lang/Exception
    //   55	61	578	finally
    //   74	81	578	finally
    //   87	99	578	finally
    //   105	113	578	finally
    //   124	134	578	finally
    //   143	150	578	finally
    //   162	167	578	finally
    //   173	192	578	finally
    //   387	396	578	finally
    //   402	411	578	finally
    //   417	427	578	finally
    //   433	442	578	finally
    //   448	459	578	finally
    //   465	477	578	finally
    //   589	593	596	java/lang/Exception
    //   661	666	669	java/lang/Exception
  }
  
  /* Error */
  public static byte[] readFileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: ifnull +451 -> 460
    //   12: aload_0
    //   13: invokevirtual 43	java/io/File:exists	()Z
    //   16: ifeq +444 -> 460
    //   19: aload_0
    //   20: invokevirtual 318	java/io/File:canRead	()Z
    //   23: ifne +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 320	java/io/BufferedInputStream
    //   31: dup
    //   32: new 322	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 325	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 328	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_3
    //   44: aload 4
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 54	java/io/File:length	()J
    //   51: l2i
    //   52: istore_1
    //   53: iload_1
    //   54: sipush 12288
    //   57: if_icmple +71 -> 128
    //   60: aload 4
    //   62: astore_2
    //   63: new 360	java/io/ByteArrayOutputStream
    //   66: dup
    //   67: invokespecial 361	java/io/ByteArrayOutputStream:<init>	()V
    //   70: astore 5
    //   72: aload 4
    //   74: astore_2
    //   75: sipush 4096
    //   78: newarray byte
    //   80: astore 6
    //   82: aload 4
    //   84: astore_2
    //   85: aload_3
    //   86: aload 6
    //   88: invokevirtual 364	java/io/BufferedInputStream:read	([B)I
    //   91: istore_1
    //   92: iload_1
    //   93: iconst_m1
    //   94: if_icmpeq +18 -> 112
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: aload 6
    //   104: iconst_0
    //   105: iload_1
    //   106: invokevirtual 368	java/io/ByteArrayOutputStream:write	([BII)V
    //   109: goto -27 -> 82
    //   112: aload 4
    //   114: astore_2
    //   115: aload 5
    //   117: invokevirtual 372	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   120: astore 4
    //   122: aload 4
    //   124: astore_2
    //   125: goto +24 -> 149
    //   128: aload 4
    //   130: astore_2
    //   131: iload_1
    //   132: newarray byte
    //   134: astore 4
    //   136: aload 4
    //   138: astore_2
    //   139: aload_3
    //   140: aload 4
    //   142: invokevirtual 364	java/io/BufferedInputStream:read	([B)I
    //   145: pop
    //   146: aload 4
    //   148: astore_2
    //   149: aload_3
    //   150: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   153: aload_2
    //   154: areturn
    //   155: astore_3
    //   156: new 120	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   163: astore 4
    //   165: aload 4
    //   167: ldc_w 347
    //   170: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 4
    //   176: aload_0
    //   177: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   180: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: ldc_w 349
    //   189: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: aload_3
    //   196: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 17
    //   205: bipush 6
    //   207: aload 4
    //   209: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_2
    //   216: areturn
    //   217: astore_2
    //   218: goto +169 -> 387
    //   221: astore 5
    //   223: aload_2
    //   224: astore 4
    //   226: goto +21 -> 247
    //   229: astore 4
    //   231: aload_2
    //   232: astore_3
    //   233: aload 4
    //   235: astore_2
    //   236: goto +151 -> 387
    //   239: astore 5
    //   241: aconst_null
    //   242: astore 4
    //   244: aload 6
    //   246: astore_3
    //   247: aload_3
    //   248: astore_2
    //   249: new 120	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   256: astore 6
    //   258: aload_3
    //   259: astore_2
    //   260: aload 6
    //   262: ldc_w 355
    //   265: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: astore_2
    //   271: aload 6
    //   273: aload_0
    //   274: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   277: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_3
    //   282: astore_2
    //   283: aload 6
    //   285: ldc_w 349
    //   288: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_3
    //   293: astore_2
    //   294: aload 6
    //   296: aload 5
    //   298: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   301: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_3
    //   306: astore_2
    //   307: ldc 17
    //   309: bipush 6
    //   311: aload 6
    //   313: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_3
    //   320: ifnull +64 -> 384
    //   323: aload_3
    //   324: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   327: goto +57 -> 384
    //   330: astore_2
    //   331: new 120	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   338: astore_3
    //   339: aload_3
    //   340: ldc_w 347
    //   343: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_3
    //   348: aload_0
    //   349: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   352: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_3
    //   357: ldc_w 349
    //   360: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_3
    //   365: aload_2
    //   366: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: ldc 17
    //   375: bipush 6
    //   377: aload_3
    //   378: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 4
    //   386: areturn
    //   387: aload_3
    //   388: ifnull +70 -> 458
    //   391: aload_3
    //   392: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   395: goto +63 -> 458
    //   398: astore_3
    //   399: new 120	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   406: astore 4
    //   408: aload 4
    //   410: ldc_w 347
    //   413: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload 4
    //   419: aload_0
    //   420: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   423: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 4
    //   429: ldc_w 349
    //   432: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 4
    //   438: aload_3
    //   439: invokevirtual 352	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc 17
    //   448: bipush 6
    //   450: aload 4
    //   452: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload_2
    //   459: athrow
    //   460: aconst_null
    //   461: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramFile	File
    //   52	80	1	i	int
    //   1	215	2	localObject1	Object
    //   217	15	2	localObject2	Object
    //   235	72	2	localObject3	Object
    //   330	129	2	localException1	java.lang.Exception
    //   43	107	3	localBufferedInputStream	java.io.BufferedInputStream
    //   155	41	3	localException2	java.lang.Exception
    //   232	160	3	localObject4	Object
    //   398	41	3	localException3	java.lang.Exception
    //   6	219	4	localObject5	Object
    //   229	5	4	localObject6	Object
    //   242	209	4	localObject7	Object
    //   70	46	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   221	1	5	localThrowable1	java.lang.Throwable
    //   239	58	5	localThrowable2	java.lang.Throwable
    //   3	309	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   149	153	155	java/lang/Exception
    //   47	53	217	finally
    //   63	72	217	finally
    //   75	82	217	finally
    //   85	92	217	finally
    //   100	109	217	finally
    //   115	122	217	finally
    //   131	136	217	finally
    //   139	146	217	finally
    //   47	53	221	java/lang/Throwable
    //   63	72	221	java/lang/Throwable
    //   75	82	221	java/lang/Throwable
    //   85	92	221	java/lang/Throwable
    //   100	109	221	java/lang/Throwable
    //   115	122	221	java/lang/Throwable
    //   131	136	221	java/lang/Throwable
    //   139	146	221	java/lang/Throwable
    //   28	44	229	finally
    //   249	258	229	finally
    //   260	269	229	finally
    //   271	281	229	finally
    //   283	292	229	finally
    //   294	305	229	finally
    //   307	319	229	finally
    //   28	44	239	java/lang/Throwable
    //   323	327	330	java/lang/Exception
    //   391	395	398	java/lang/Exception
  }
  
  static boolean verifyData(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.equals(SonicUtils.getSHA1(paramString1)));
  }
  
  public static boolean verifyData(byte[] paramArrayOfByte, String paramString)
  {
    return (paramArrayOfByte != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(SonicUtils.getSHA1(paramArrayOfByte)));
  }
  
  static boolean writeFile(String paramString1, String paramString2)
  {
    return writeFile(paramString1.getBytes(), paramString2);
  }
  
  /* Error */
  static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_3
    //   16: astore_2
    //   17: aload 5
    //   19: invokevirtual 43	java/io/File:exists	()Z
    //   22: ifne +15 -> 37
    //   25: aload_3
    //   26: astore_2
    //   27: aload 5
    //   29: invokevirtual 393	java/io/File:createNewFile	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_3
    //   38: astore_2
    //   39: new 395	java/io/FileOutputStream
    //   42: dup
    //   43: aload 5
    //   45: invokespecial 396	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_3
    //   49: aload_3
    //   50: aload_0
    //   51: invokevirtual 399	java/io/FileOutputStream:write	([B)V
    //   54: aload_3
    //   55: invokevirtual 402	java/io/FileOutputStream:flush	()V
    //   58: aload_3
    //   59: invokevirtual 403	java/io/FileOutputStream:close	()V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_0
    //   65: new 120	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   72: astore_2
    //   73: aload_2
    //   74: ldc_w 405
    //   77: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: aload_1
    //   83: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc_w 349
    //   91: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_2
    //   96: aload_0
    //   97: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 17
    //   106: bipush 6
    //   108: aload_2
    //   109: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: iconst_1
    //   116: ireturn
    //   117: astore_0
    //   118: aload_3
    //   119: astore_2
    //   120: goto +150 -> 270
    //   123: astore_2
    //   124: aload_3
    //   125: astore_0
    //   126: aload_2
    //   127: astore_3
    //   128: goto +11 -> 139
    //   131: astore_0
    //   132: goto +138 -> 270
    //   135: astore_3
    //   136: aload 4
    //   138: astore_0
    //   139: aload_0
    //   140: astore_2
    //   141: new 120	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   148: astore 4
    //   150: aload_0
    //   151: astore_2
    //   152: aload 4
    //   154: ldc_w 407
    //   157: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: astore_2
    //   163: aload 4
    //   165: aload_1
    //   166: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_0
    //   171: astore_2
    //   172: aload 4
    //   174: ldc_w 349
    //   177: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_0
    //   182: astore_2
    //   183: aload 4
    //   185: aload_3
    //   186: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   189: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_0
    //   194: astore_2
    //   195: ldc 17
    //   197: bipush 6
    //   199: aload 4
    //   201: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_0
    //   208: ifnull +60 -> 268
    //   211: aload_0
    //   212: invokevirtual 403	java/io/FileOutputStream:close	()V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_0
    //   218: new 120	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   225: astore_2
    //   226: aload_2
    //   227: ldc_w 405
    //   230: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_2
    //   235: aload_1
    //   236: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc_w 349
    //   244: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_2
    //   249: aload_0
    //   250: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   253: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 17
    //   259: bipush 6
    //   261: aload_2
    //   262: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iconst_0
    //   269: ireturn
    //   270: aload_2
    //   271: ifnull +61 -> 332
    //   274: aload_2
    //   275: invokevirtual 403	java/io/FileOutputStream:close	()V
    //   278: goto +54 -> 332
    //   281: astore_2
    //   282: new 120	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   289: astore_3
    //   290: aload_3
    //   291: ldc_w 405
    //   294: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_3
    //   299: aload_1
    //   300: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_3
    //   305: ldc_w 349
    //   308: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_3
    //   313: aload_2
    //   314: invokevirtual 356	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   317: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 17
    //   323: bipush 6
    //   325: aload_3
    //   326: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 143	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: aload_0
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramArrayOfByte	byte[]
    //   0	334	1	paramString	String
    //   16	104	2	localObject1	Object
    //   123	4	2	localThrowable1	java.lang.Throwable
    //   140	135	2	localObject2	Object
    //   281	33	2	localThrowable2	java.lang.Throwable
    //   14	114	3	localObject3	Object
    //   135	51	3	localThrowable3	java.lang.Throwable
    //   289	37	3	localStringBuilder1	StringBuilder
    //   11	189	4	localStringBuilder2	StringBuilder
    //   8	36	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   58	62	64	java/lang/Throwable
    //   49	58	117	finally
    //   49	58	123	java/lang/Throwable
    //   17	25	131	finally
    //   27	35	131	finally
    //   39	49	131	finally
    //   141	150	131	finally
    //   152	161	131	finally
    //   163	170	131	finally
    //   172	181	131	finally
    //   183	193	131	finally
    //   195	207	131	finally
    //   17	25	135	java/lang/Throwable
    //   27	35	135	java/lang/Throwable
    //   39	49	135	java/lang/Throwable
    //   211	215	217	java/lang/Throwable
    //   274	278	281	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicFileUtils
 * JD-Core Version:    0.7.0.1
 */