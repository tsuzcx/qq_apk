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
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        long l1 = 0L;
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
    long l2 = 0L;
    return l2;
  }
  
  static void checkAndTrimCache()
  {
    HashMap localHashMap = new HashMap();
    long l3 = System.currentTimeMillis();
    long l1 = calcCacheSize(getSonicCacheDirPath(), localHashMap);
    long l4 = SonicEngine.getInstance().getConfig().SONIC_CACHE_MAX_SIZE;
    List localList;
    int i;
    if (l1 > l4 * 0.8D)
    {
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, "now try clear cache, current cache size: " + l1 / 1024L / 1024L + "m");
      localList = SonicDataHelper.getAllSessionByHitCount();
      i = 0;
    }
    for (;;)
    {
      long l2;
      if (i < localList.size())
      {
        Object localObject = (List)localHashMap.get(((SonicDataHelper.SessionData)localList.get(i)).sessionId);
        l2 = l1;
        if (localObject != null)
        {
          l2 = l1;
          if (((List)localObject).size() > 0)
          {
            localObject = ((List)localObject).iterator();
            for (;;)
            {
              l2 = l1;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              File localFile = new File((String)((Iterator)localObject).next());
              if ((localFile.isFile()) && (localFile.exists()))
              {
                String str = localFile.getName();
                l2 = localFile.length();
                if (localFile.delete())
                {
                  l1 -= l2;
                  SonicDataHelper.removeSessionData(str);
                  SonicUtils.log("SonicSdk_SonicFileUtils", 4, "delete " + localFile.getAbsolutePath());
                }
              }
            }
          }
        }
        if (l2 > l4 * 0.25D) {}
      }
      else
      {
        SonicUtils.log("SonicSdk_SonicFileUtils", 4, "checkAndTrimCache: finish , cost " + (System.currentTimeMillis() - l3) + "ms.");
        return;
      }
      i += 1;
      l1 = l2;
    }
  }
  
  static void checkAndTrimResourceCache()
  {
    HashMap localHashMap = new HashMap();
    long l3 = System.currentTimeMillis();
    long l1 = calcCacheSize(getSonicCacheDirPath(), localHashMap);
    long l4 = SonicEngine.getInstance().getConfig().SONIC_RESOURCE_CACHE_MAX_SIZE;
    List localList;
    int i;
    if (l1 > l4 * 0.8D)
    {
      SonicUtils.log("SonicSdk_SonicFileUtils", 4, "now try clear cache, current cache size: " + l1 / 1024L / 1024L + "m");
      localList = SonicResourceDataHelper.getAllResourceData();
      i = 0;
    }
    for (;;)
    {
      long l2;
      if (i < localList.size())
      {
        Object localObject = (List)localHashMap.get(((SonicResourceDataHelper.ResourceData)localList.get(i)).resourceId);
        l2 = l1;
        if (localObject != null)
        {
          l2 = l1;
          if (((List)localObject).size() > 0)
          {
            localObject = ((List)localObject).iterator();
            for (;;)
            {
              l2 = l1;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              File localFile = new File((String)((Iterator)localObject).next());
              if ((localFile.isFile()) && (localFile.exists()))
              {
                String str = localFile.getName();
                l2 = localFile.length();
                if (localFile.delete())
                {
                  l1 -= l2;
                  SonicResourceDataHelper.removeResourceData(str);
                  SonicUtils.log("SonicSdk_SonicFileUtils", 4, "delete " + localFile.getAbsolutePath());
                }
              }
            }
          }
        }
        if (l2 > l4 * 0.25D) {}
      }
      else
      {
        SonicUtils.log("SonicSdk_SonicFileUtils", 4, "checkAndTrimCache: finish , cost " + (System.currentTimeMillis() - l3) + "ms.");
        return;
      }
      i += 1;
      l1 = l2;
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
              localStringBuilder.append(str1).append(" : ");
              localStringBuilder.append(str2).append("\r\n");
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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.exists())
      {
        if (!paramFile.isFile()) {
          break label37;
        }
        bool1 = paramFile.delete();
      }
    }
    label37:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramFile.isDirectory());
      paramFile = paramFile.listFiles();
      bool1 = bool2;
    } while (paramFile == null);
    int j = paramFile.length;
    int i = 0;
    bool2 = bool3;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      bool2 &= deleteAllChildFiles(paramFile[i]);
      i += 1;
    }
  }
  
  static boolean deleteResourceFiles(String paramString)
  {
    boolean bool1 = true;
    File localFile = new File(getSonicResourcePath(paramString));
    if (localFile.exists()) {
      bool1 = localFile.delete();
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
    boolean bool2 = true;
    File localFile = new File(getSonicHtmlPath(paramString));
    if (localFile.exists()) {
      bool2 = localFile.delete();
    }
    localFile = new File(getSonicTemplatePath(paramString));
    boolean bool1 = bool2;
    if (localFile.exists()) {
      bool1 = bool2 & localFile.delete();
    }
    localFile = new File(getSonicDataPath(paramString));
    bool2 = bool1;
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
    String str2 = SonicEngine.getInstance().getRuntime().getSonicCacheDir().getAbsolutePath();
    String str1 = str2;
    if (!str2.endsWith(File.separator)) {
      str1 = str2 + File.separator;
    }
    return str1;
  }
  
  static String getSonicDataPath(String paramString)
  {
    return getSonicCacheDirPath() + paramString + ".data";
  }
  
  static String getSonicHeaderPath(String paramString)
  {
    return getSonicCacheDirPath() + paramString + ".header";
  }
  
  static String getSonicHtmlPath(String paramString)
  {
    return getSonicCacheDirPath() + paramString + ".html";
  }
  
  static String getSonicResourceCachePath()
  {
    String str2 = SonicEngine.getInstance().getRuntime().getSonicResourceCacheDir().getAbsolutePath();
    String str1 = str2;
    if (!str2.endsWith(File.separator)) {
      str1 = str2 + File.separator;
    }
    return str1;
  }
  
  public static String getSonicResourceHeaderPath(String paramString)
  {
    return getSonicResourceCachePath() + paramString + ".header";
  }
  
  public static String getSonicResourcePath(String paramString)
  {
    return getSonicResourceCachePath() + paramString;
  }
  
  static String getSonicTemplatePath(String paramString)
  {
    return getSonicCacheDirPath() + paramString + ".tpl";
  }
  
  /* Error */
  static String readFile(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 43	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 307	java/io/File:canRead	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aconst_null
    //   21: astore_3
    //   22: aconst_null
    //   23: astore 7
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore 6
    //   31: aconst_null
    //   32: astore 5
    //   34: new 309	java/io/BufferedInputStream
    //   37: dup
    //   38: new 311	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 317	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_2
    //   50: new 319	java/io/InputStreamReader
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 320	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 54	java/io/File:length	()J
    //   63: l2i
    //   64: istore_1
    //   65: iload_1
    //   66: sipush 12288
    //   69: if_icmple +194 -> 263
    //   72: sipush 4096
    //   75: newarray char
    //   77: astore 4
    //   79: new 114	java/lang/StringBuilder
    //   82: dup
    //   83: sipush 12288
    //   86: invokespecial 321	java/lang/StringBuilder:<init>	(I)V
    //   89: astore 5
    //   91: aload_3
    //   92: aload 4
    //   94: invokevirtual 325	java/io/InputStreamReader:read	([C)I
    //   97: istore_1
    //   98: iconst_m1
    //   99: iload_1
    //   100: if_icmpeq +137 -> 237
    //   103: aload 5
    //   105: aload 4
    //   107: iconst_0
    //   108: iload_1
    //   109: invokevirtual 328	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: goto -22 -> 91
    //   116: astore 6
    //   118: aload_3
    //   119: astore 5
    //   121: aload_2
    //   122: astore_3
    //   123: aload 5
    //   125: astore 4
    //   127: ldc 17
    //   129: bipush 6
    //   131: new 114	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 330
    //   141: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   148: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 332
    //   154: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 6
    //   159: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   179: aload 5
    //   181: ifnull -163 -> 18
    //   184: aload 5
    //   186: invokevirtual 339	java/io/InputStreamReader:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_2
    //   192: ldc 17
    //   194: bipush 6
    //   196: new 114	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 341
    //   206: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   213: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc_w 332
    //   219: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_2
    //   223: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aconst_null
    //   236: areturn
    //   237: aload 5
    //   239: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: astore 4
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   252: aload_3
    //   253: ifnull +332 -> 585
    //   256: aload_3
    //   257: invokevirtual 339	java/io/InputStreamReader:close	()V
    //   260: aload 4
    //   262: areturn
    //   263: iload_1
    //   264: newarray char
    //   266: astore 4
    //   268: new 171	java/lang/String
    //   271: dup
    //   272: aload 4
    //   274: iconst_0
    //   275: aload_3
    //   276: aload 4
    //   278: invokevirtual 325	java/io/InputStreamReader:read	([C)I
    //   281: invokespecial 345	java/lang/String:<init>	([CII)V
    //   284: astore 4
    //   286: goto -42 -> 244
    //   289: astore_2
    //   290: ldc 17
    //   292: bipush 6
    //   294: new 114	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 341
    //   304: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_0
    //   308: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   311: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 332
    //   317: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_2
    //   321: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto -81 -> 252
    //   336: astore_2
    //   337: ldc 17
    //   339: bipush 6
    //   341: new 114	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 341
    //   351: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   358: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 332
    //   364: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_2
    //   368: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   371: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload 4
    //   382: areturn
    //   383: astore_2
    //   384: ldc 17
    //   386: bipush 6
    //   388: new 114	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 341
    //   398: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_0
    //   402: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   405: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 332
    //   411: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_2
    //   415: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   418: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: goto -248 -> 179
    //   430: astore_2
    //   431: aload_3
    //   432: ifnull +7 -> 439
    //   435: aload_3
    //   436: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   439: aload 4
    //   441: ifnull +8 -> 449
    //   444: aload 4
    //   446: invokevirtual 339	java/io/InputStreamReader:close	()V
    //   449: aload_2
    //   450: athrow
    //   451: astore_3
    //   452: ldc 17
    //   454: bipush 6
    //   456: new 114	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 341
    //   466: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_0
    //   470: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   473: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 332
    //   479: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_3
    //   483: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -56 -> 439
    //   498: astore_3
    //   499: ldc 17
    //   501: bipush 6
    //   503: new 114	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 341
    //   513: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   520: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc_w 332
    //   526: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_3
    //   530: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   533: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: goto -93 -> 449
    //   545: astore 5
    //   547: aload_2
    //   548: astore_3
    //   549: aload 6
    //   551: astore 4
    //   553: aload 5
    //   555: astore_2
    //   556: goto -125 -> 431
    //   559: astore 5
    //   561: aload_3
    //   562: astore 4
    //   564: aload_2
    //   565: astore_3
    //   566: aload 5
    //   568: astore_2
    //   569: goto -138 -> 431
    //   572: astore 6
    //   574: aload 7
    //   576: astore_2
    //   577: goto -456 -> 121
    //   580: astore 6
    //   582: goto -461 -> 121
    //   585: aload 4
    //   587: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramFile	File
    //   64	200	1	i	int
    //   49	127	2	localBufferedInputStream	java.io.BufferedInputStream
    //   191	58	2	localException1	java.lang.Exception
    //   289	32	2	localException2	java.lang.Exception
    //   336	32	2	localException3	java.lang.Exception
    //   383	32	2	localException4	java.lang.Exception
    //   430	118	2	localObject1	Object
    //   555	22	2	localObject2	Object
    //   21	415	3	localObject3	Object
    //   451	32	3	localException5	java.lang.Exception
    //   498	32	3	localException6	java.lang.Exception
    //   548	18	3	localObject4	Object
    //   26	560	4	localObject5	Object
    //   32	206	5	localObject6	Object
    //   545	9	5	localObject7	Object
    //   559	8	5	localObject8	Object
    //   29	1	6	localObject9	Object
    //   116	434	6	localThrowable1	java.lang.Throwable
    //   572	1	6	localThrowable2	java.lang.Throwable
    //   580	1	6	localThrowable3	java.lang.Throwable
    //   23	552	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   59	65	116	java/lang/Throwable
    //   72	91	116	java/lang/Throwable
    //   91	98	116	java/lang/Throwable
    //   103	113	116	java/lang/Throwable
    //   237	244	116	java/lang/Throwable
    //   263	286	116	java/lang/Throwable
    //   184	189	191	java/lang/Exception
    //   248	252	289	java/lang/Exception
    //   256	260	336	java/lang/Exception
    //   175	179	383	java/lang/Exception
    //   34	50	430	finally
    //   127	171	430	finally
    //   435	439	451	java/lang/Exception
    //   444	449	498	java/lang/Exception
    //   50	59	545	finally
    //   59	65	559	finally
    //   72	91	559	finally
    //   91	98	559	finally
    //   103	113	559	finally
    //   237	244	559	finally
    //   263	286	559	finally
    //   34	50	572	java/lang/Throwable
    //   50	59	580	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] readFileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 43	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 307	java/io/File:canRead	()Z
    //   15: ifne +7 -> 22
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_3
    //   21: areturn
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 4
    //   33: new 309	java/io/BufferedInputStream
    //   36: dup
    //   37: new 311	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 317	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_2
    //   49: aload 6
    //   51: astore_3
    //   52: aload_0
    //   53: invokevirtual 54	java/io/File:length	()J
    //   56: l2i
    //   57: istore_1
    //   58: iload_1
    //   59: sipush 12288
    //   62: if_icmple +168 -> 230
    //   65: aload 6
    //   67: astore_3
    //   68: new 349	java/io/ByteArrayOutputStream
    //   71: dup
    //   72: invokespecial 350	java/io/ByteArrayOutputStream:<init>	()V
    //   75: astore 5
    //   77: sipush 4096
    //   80: newarray byte
    //   82: astore_3
    //   83: aload_2
    //   84: aload_3
    //   85: invokevirtual 353	java/io/BufferedInputStream:read	([B)I
    //   88: istore_1
    //   89: iload_1
    //   90: iconst_m1
    //   91: if_icmpeq +123 -> 214
    //   94: aload 5
    //   96: aload_3
    //   97: iconst_0
    //   98: iload_1
    //   99: invokevirtual 357	java/io/ByteArrayOutputStream:write	([BII)V
    //   102: goto -19 -> 83
    //   105: astore 5
    //   107: aload_2
    //   108: astore_3
    //   109: ldc 17
    //   111: bipush 6
    //   113: new 114	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 330
    //   123: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   130: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 332
    //   136: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload 4
    //   155: astore_3
    //   156: aload_2
    //   157: ifnull -137 -> 20
    //   160: aload_2
    //   161: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   164: aload 4
    //   166: areturn
    //   167: astore_2
    //   168: ldc 17
    //   170: bipush 6
    //   172: new 114	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 341
    //   182: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   189: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 332
    //   195: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_2
    //   199: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 4
    //   213: areturn
    //   214: aload 5
    //   216: invokevirtual 361	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   219: astore_3
    //   220: aload_2
    //   221: ifnull +175 -> 396
    //   224: aload_2
    //   225: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   228: aload_3
    //   229: areturn
    //   230: aload 6
    //   232: astore_3
    //   233: iload_1
    //   234: newarray byte
    //   236: astore 4
    //   238: aload 4
    //   240: astore_3
    //   241: aload_2
    //   242: aload 4
    //   244: invokevirtual 353	java/io/BufferedInputStream:read	([B)I
    //   247: pop
    //   248: aload 4
    //   250: astore_3
    //   251: goto -31 -> 220
    //   254: astore_2
    //   255: ldc 17
    //   257: bipush 6
    //   259: new 114	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   266: ldc_w 341
    //   269: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   276: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 332
    //   282: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_2
    //   286: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   289: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload_3
    //   299: areturn
    //   300: astore_2
    //   301: aload_3
    //   302: ifnull +7 -> 309
    //   305: aload_3
    //   306: invokevirtual 338	java/io/BufferedInputStream:close	()V
    //   309: aload_2
    //   310: athrow
    //   311: astore_3
    //   312: ldc 17
    //   314: bipush 6
    //   316: new 114	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 341
    //   326: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   333: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 332
    //   339: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_3
    //   343: invokevirtual 342	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   346: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -46 -> 309
    //   358: astore 4
    //   360: aload_2
    //   361: astore_3
    //   362: aload 4
    //   364: astore_2
    //   365: goto -64 -> 301
    //   368: astore 4
    //   370: aload_2
    //   371: astore_3
    //   372: aload 4
    //   374: astore_2
    //   375: goto -74 -> 301
    //   378: astore_3
    //   379: aload 5
    //   381: astore_2
    //   382: aload_3
    //   383: astore 5
    //   385: goto -278 -> 107
    //   388: astore 5
    //   390: aload_3
    //   391: astore 4
    //   393: goto -286 -> 107
    //   396: aload_3
    //   397: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	paramFile	File
    //   57	177	1	i	int
    //   48	113	2	localBufferedInputStream	java.io.BufferedInputStream
    //   167	75	2	localException1	java.lang.Exception
    //   254	32	2	localException2	java.lang.Exception
    //   300	61	2	localObject1	Object
    //   364	18	2	localObject2	Object
    //   19	287	3	localObject3	Object
    //   311	32	3	localException3	java.lang.Exception
    //   361	11	3	localObject4	Object
    //   378	19	3	localThrowable1	java.lang.Throwable
    //   31	218	4	arrayOfByte	byte[]
    //   358	5	4	localObject5	Object
    //   368	5	4	localObject6	Object
    //   391	1	4	localThrowable2	java.lang.Throwable
    //   25	70	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   105	275	5	localThrowable3	java.lang.Throwable
    //   383	1	5	localThrowable4	java.lang.Throwable
    //   388	1	5	localThrowable5	java.lang.Throwable
    //   28	203	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   77	83	105	java/lang/Throwable
    //   83	89	105	java/lang/Throwable
    //   94	102	105	java/lang/Throwable
    //   214	220	105	java/lang/Throwable
    //   160	164	167	java/lang/Exception
    //   224	228	254	java/lang/Exception
    //   33	49	300	finally
    //   109	153	300	finally
    //   305	309	311	java/lang/Exception
    //   52	58	358	finally
    //   68	77	358	finally
    //   233	238	358	finally
    //   241	248	358	finally
    //   77	83	368	finally
    //   83	89	368	finally
    //   94	102	368	finally
    //   214	220	368	finally
    //   33	49	378	java/lang/Throwable
    //   52	58	388	java/lang/Throwable
    //   68	77	388	java/lang/Throwable
    //   233	238	388	java/lang/Throwable
    //   241	248	388	java/lang/Throwable
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
    //   8: astore 6
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: aload 4
    //   18: astore_3
    //   19: aload 6
    //   21: invokevirtual 43	java/io/File:exists	()Z
    //   24: ifne +73 -> 97
    //   27: aload 4
    //   29: astore_3
    //   30: aload 6
    //   32: invokevirtual 382	java/io/File:createNewFile	()Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +60 -> 97
    //   40: iconst_0
    //   41: ifeq +11 -> 52
    //   44: new 384	java/lang/NullPointerException
    //   47: dup
    //   48: invokespecial 385	java/lang/NullPointerException:<init>	()V
    //   51: athrow
    //   52: iconst_0
    //   53: ireturn
    //   54: astore_0
    //   55: ldc 17
    //   57: bipush 6
    //   59: new 114	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 387
    //   69: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 332
    //   79: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: iconst_0
    //   96: ireturn
    //   97: aload 4
    //   99: astore_3
    //   100: new 389	java/io/FileOutputStream
    //   103: dup
    //   104: aload 6
    //   106: invokespecial 390	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   109: astore 4
    //   111: aload 4
    //   113: aload_0
    //   114: invokevirtual 393	java/io/FileOutputStream:write	([B)V
    //   117: aload 4
    //   119: invokevirtual 396	java/io/FileOutputStream:flush	()V
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 397	java/io/FileOutputStream:close	()V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: ldc 17
    //   137: bipush 6
    //   139: new 114	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 387
    //   149: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_1
    //   153: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 332
    //   159: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: goto -43 -> 132
    //   178: astore 4
    //   180: aload 5
    //   182: astore_0
    //   183: aload_0
    //   184: astore_3
    //   185: ldc 17
    //   187: bipush 6
    //   189: new 114	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 399
    //   199: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_1
    //   203: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 332
    //   209: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 4
    //   214: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_0
    //   227: ifnull -175 -> 52
    //   230: aload_0
    //   231: invokevirtual 397	java/io/FileOutputStream:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: ldc 17
    //   239: bipush 6
    //   241: new 114	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 387
    //   251: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 332
    //   261: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   268: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iconst_0
    //   278: ireturn
    //   279: astore_0
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 397	java/io/FileOutputStream:close	()V
    //   288: aload_0
    //   289: athrow
    //   290: astore_3
    //   291: ldc 17
    //   293: bipush 6
    //   295: new 114	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 387
    //   305: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 332
    //   315: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 335	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: goto -43 -> 288
    //   334: astore_0
    //   335: aload 4
    //   337: astore_3
    //   338: goto -58 -> 280
    //   341: astore_3
    //   342: aload 4
    //   344: astore_0
    //   345: aload_3
    //   346: astore 4
    //   348: goto -165 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramArrayOfByte	byte[]
    //   0	351	1	paramString	String
    //   35	2	2	bool	boolean
    //   18	267	3	localObject1	Object
    //   290	29	3	localThrowable1	java.lang.Throwable
    //   337	1	3	localThrowable2	java.lang.Throwable
    //   341	5	3	localThrowable3	java.lang.Throwable
    //   11	117	4	localFileOutputStream	java.io.FileOutputStream
    //   178	165	4	localThrowable4	java.lang.Throwable
    //   346	1	4	localObject2	Object
    //   14	167	5	localObject3	Object
    //   8	97	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   44	52	54	java/lang/Throwable
    //   127	132	134	java/lang/Throwable
    //   19	27	178	java/lang/Throwable
    //   30	36	178	java/lang/Throwable
    //   100	111	178	java/lang/Throwable
    //   230	234	236	java/lang/Throwable
    //   19	27	279	finally
    //   30	36	279	finally
    //   100	111	279	finally
    //   185	226	279	finally
    //   284	288	290	java/lang/Throwable
    //   111	122	334	finally
    //   111	122	341	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicFileUtils
 * JD-Core Version:    0.7.0.1
 */