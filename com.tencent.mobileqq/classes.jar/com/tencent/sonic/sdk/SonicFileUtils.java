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
    long l1 = 0L;
    paramString = new File(paramString);
    long l2 = l1;
    if (paramString.exists())
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
              l2 = localFile.length();
              String str = localFile.getName();
              List localList = (List)paramMap.get(str);
              paramString = localList;
              if (localList == null) {
                paramString = new ArrayList();
              }
              paramString.add(localFile.getAbsolutePath());
              paramMap.put(str, paramString);
              i += 1;
              l1 = l2 + l1;
            }
          }
        }
      }
    }
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
                  SonicChunkDataHelper.removeChunkData(str);
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
    long l1 = calcCacheSize(getSonicResourceCachePath(), localHashMap);
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
    for (bool2 = bool3;; bool2 = bool1 & bool2)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      bool1 = deleteAllChildFiles(paramFile[i]);
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
    //   0: aconst_null
    //   1: astore 7
    //   3: aload 7
    //   5: astore_3
    //   6: aload_0
    //   7: ifnull +23 -> 30
    //   10: aload 7
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 43	java/io/File:exists	()Z
    //   17: ifeq +13 -> 30
    //   20: aload_0
    //   21: invokevirtual 312	java/io/File:canRead	()Z
    //   24: ifne +8 -> 32
    //   27: aload 7
    //   29: astore_3
    //   30: aload_3
    //   31: areturn
    //   32: new 314	java/io/BufferedInputStream
    //   35: dup
    //   36: new 316	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_3
    //   48: new 324	java/io/InputStreamReader
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 325	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: astore 6
    //   58: aload 6
    //   60: astore 5
    //   62: aload_3
    //   63: astore 4
    //   65: aload_0
    //   66: invokevirtual 54	java/io/File:length	()J
    //   69: l2i
    //   70: istore_1
    //   71: iload_1
    //   72: sipush 12288
    //   75: if_icmple +280 -> 355
    //   78: aload 6
    //   80: astore 5
    //   82: aload_3
    //   83: astore 4
    //   85: sipush 4096
    //   88: newarray char
    //   90: astore_2
    //   91: aload 6
    //   93: astore 5
    //   95: aload_3
    //   96: astore 4
    //   98: new 114	java/lang/StringBuilder
    //   101: dup
    //   102: sipush 12288
    //   105: invokespecial 326	java/lang/StringBuilder:<init>	(I)V
    //   108: astore 8
    //   110: aload 6
    //   112: astore 5
    //   114: aload_3
    //   115: astore 4
    //   117: aload 6
    //   119: aload_2
    //   120: invokevirtual 330	java/io/InputStreamReader:read	([C)I
    //   123: istore_1
    //   124: iconst_m1
    //   125: iload_1
    //   126: if_icmpeq +148 -> 274
    //   129: aload 6
    //   131: astore 5
    //   133: aload_3
    //   134: astore 4
    //   136: aload 8
    //   138: aload_2
    //   139: iconst_0
    //   140: iload_1
    //   141: invokevirtual 333	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: goto -35 -> 110
    //   148: astore 4
    //   150: aload 6
    //   152: astore_2
    //   153: aload 4
    //   155: astore 6
    //   157: aload_2
    //   158: astore 5
    //   160: aload_3
    //   161: astore 4
    //   163: ldc 17
    //   165: bipush 6
    //   167: new 114	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 335
    //   177: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   184: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc_w 337
    //   190: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 6
    //   195: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   215: aload 7
    //   217: astore_3
    //   218: aload_2
    //   219: ifnull -189 -> 30
    //   222: aload_2
    //   223: invokevirtual 344	java/io/InputStreamReader:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_2
    //   229: ldc 17
    //   231: bipush 6
    //   233: new 114	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 346
    //   243: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   250: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 337
    //   256: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_2
    //   260: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aconst_null
    //   273: areturn
    //   274: aload 6
    //   276: astore 5
    //   278: aload_3
    //   279: astore 4
    //   281: aload 8
    //   283: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   295: aload_2
    //   296: astore_3
    //   297: aload 6
    //   299: ifnull -269 -> 30
    //   302: aload 6
    //   304: invokevirtual 344	java/io/InputStreamReader:close	()V
    //   307: aload_2
    //   308: areturn
    //   309: astore_3
    //   310: ldc 17
    //   312: bipush 6
    //   314: new 114	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 346
    //   324: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   331: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 337
    //   337: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_3
    //   341: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload_2
    //   354: areturn
    //   355: aload 6
    //   357: astore 5
    //   359: aload_3
    //   360: astore 4
    //   362: iload_1
    //   363: newarray char
    //   365: astore_2
    //   366: aload 6
    //   368: astore 5
    //   370: aload_3
    //   371: astore 4
    //   373: new 171	java/lang/String
    //   376: dup
    //   377: aload_2
    //   378: iconst_0
    //   379: aload 6
    //   381: aload_2
    //   382: invokevirtual 330	java/io/InputStreamReader:read	([C)I
    //   385: invokespecial 350	java/lang/String:<init>	([CII)V
    //   388: astore_2
    //   389: goto -102 -> 287
    //   392: astore_3
    //   393: ldc 17
    //   395: bipush 6
    //   397: new 114	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 346
    //   407: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   414: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w 337
    //   420: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_3
    //   424: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   427: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: goto -141 -> 295
    //   439: astore_3
    //   440: ldc 17
    //   442: bipush 6
    //   444: new 114	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 346
    //   454: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   461: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 337
    //   467: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: aload_3
    //   471: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: goto -268 -> 215
    //   486: astore_2
    //   487: aconst_null
    //   488: astore 5
    //   490: aconst_null
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   500: aload 5
    //   502: ifnull +8 -> 510
    //   505: aload 5
    //   507: invokevirtual 344	java/io/InputStreamReader:close	()V
    //   510: aload_2
    //   511: athrow
    //   512: astore_3
    //   513: ldc 17
    //   515: bipush 6
    //   517: new 114	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 346
    //   527: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_0
    //   531: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   534: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 337
    //   540: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_3
    //   544: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   556: goto -56 -> 500
    //   559: astore_3
    //   560: ldc 17
    //   562: bipush 6
    //   564: new 114	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   571: ldc_w 346
    //   574: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_0
    //   578: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   581: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 337
    //   587: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_3
    //   591: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: goto -93 -> 510
    //   606: astore_2
    //   607: aconst_null
    //   608: astore 5
    //   610: goto -118 -> 492
    //   613: astore_2
    //   614: aload 4
    //   616: astore_3
    //   617: goto -125 -> 492
    //   620: astore 6
    //   622: aconst_null
    //   623: astore_2
    //   624: aconst_null
    //   625: astore_3
    //   626: goto -469 -> 157
    //   629: astore 6
    //   631: aconst_null
    //   632: astore_2
    //   633: goto -476 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramFile	File
    //   70	293	1	i	int
    //   90	133	2	localObject1	Object
    //   228	32	2	localException1	java.lang.Exception
    //   286	103	2	localObject2	Object
    //   486	25	2	localObject3	Object
    //   606	1	2	localObject4	Object
    //   613	1	2	localObject5	Object
    //   623	10	2	localObject6	Object
    //   5	292	3	localObject7	Object
    //   309	62	3	localException2	java.lang.Exception
    //   392	32	3	localException3	java.lang.Exception
    //   439	32	3	localException4	java.lang.Exception
    //   491	6	3	localObject8	Object
    //   512	32	3	localException5	java.lang.Exception
    //   559	32	3	localException6	java.lang.Exception
    //   616	10	3	localObject9	Object
    //   63	72	4	localObject10	Object
    //   148	6	4	localThrowable1	java.lang.Throwable
    //   161	454	4	localObject11	Object
    //   60	549	5	localObject12	Object
    //   56	324	6	localObject13	Object
    //   620	1	6	localThrowable2	java.lang.Throwable
    //   629	1	6	localThrowable3	java.lang.Throwable
    //   1	215	7	localObject14	Object
    //   108	174	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	71	148	java/lang/Throwable
    //   85	91	148	java/lang/Throwable
    //   98	110	148	java/lang/Throwable
    //   117	124	148	java/lang/Throwable
    //   136	145	148	java/lang/Throwable
    //   281	287	148	java/lang/Throwable
    //   362	366	148	java/lang/Throwable
    //   373	389	148	java/lang/Throwable
    //   222	226	228	java/lang/Exception
    //   302	307	309	java/lang/Exception
    //   291	295	392	java/lang/Exception
    //   211	215	439	java/lang/Exception
    //   32	48	486	finally
    //   496	500	512	java/lang/Exception
    //   505	510	559	java/lang/Exception
    //   48	58	606	finally
    //   65	71	613	finally
    //   85	91	613	finally
    //   98	110	613	finally
    //   117	124	613	finally
    //   136	145	613	finally
    //   163	207	613	finally
    //   281	287	613	finally
    //   362	366	613	finally
    //   373	389	613	finally
    //   32	48	620	java/lang/Throwable
    //   48	58	629	java/lang/Throwable
  }
  
  /* Error */
  public static byte[] readFileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload_0
    //   8: ifnull +21 -> 29
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 43	java/io/File:exists	()Z
    //   17: ifeq +12 -> 29
    //   20: aload_0
    //   21: invokevirtual 312	java/io/File:canRead	()Z
    //   24: ifne +7 -> 31
    //   27: aload_3
    //   28: astore_2
    //   29: aload_2
    //   30: areturn
    //   31: new 314	java/io/BufferedInputStream
    //   34: dup
    //   35: new 316	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore 5
    //   48: aload 5
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 54	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: iload_1
    //   58: sipush 12288
    //   61: if_icmple +234 -> 295
    //   64: aload 5
    //   66: astore_2
    //   67: new 354	java/io/ByteArrayOutputStream
    //   70: dup
    //   71: invokespecial 355	java/io/ByteArrayOutputStream:<init>	()V
    //   74: astore_3
    //   75: aload 5
    //   77: astore_2
    //   78: sipush 4096
    //   81: newarray byte
    //   83: astore 4
    //   85: aload 5
    //   87: astore_2
    //   88: aload 5
    //   90: aload 4
    //   92: invokevirtual 358	java/io/BufferedInputStream:read	([B)I
    //   95: istore_1
    //   96: iload_1
    //   97: iconst_m1
    //   98: if_icmpeq +129 -> 227
    //   101: aload 5
    //   103: astore_2
    //   104: aload_3
    //   105: aload 4
    //   107: iconst_0
    //   108: iload_1
    //   109: invokevirtual 362	java/io/ByteArrayOutputStream:write	([BII)V
    //   112: goto -27 -> 85
    //   115: astore 4
    //   117: aload 6
    //   119: astore_3
    //   120: aload 5
    //   122: astore_2
    //   123: ldc 17
    //   125: bipush 6
    //   127: new 114	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 335
    //   137: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   144: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 337
    //   150: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_3
    //   168: astore_2
    //   169: aload 5
    //   171: ifnull -142 -> 29
    //   174: aload 5
    //   176: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   179: aload_3
    //   180: areturn
    //   181: astore_2
    //   182: ldc 17
    //   184: bipush 6
    //   186: new 114	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 346
    //   196: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   203: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc_w 337
    //   209: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_3
    //   226: areturn
    //   227: aload 5
    //   229: astore_2
    //   230: aload_3
    //   231: invokevirtual 366	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   234: astore_3
    //   235: aload_3
    //   236: astore_2
    //   237: aload 5
    //   239: ifnull -210 -> 29
    //   242: aload 5
    //   244: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   247: aload_3
    //   248: areturn
    //   249: astore_2
    //   250: ldc 17
    //   252: bipush 6
    //   254: new 114	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 346
    //   264: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   271: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 337
    //   277: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   284: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_3
    //   294: areturn
    //   295: aload 5
    //   297: astore_2
    //   298: iload_1
    //   299: newarray byte
    //   301: astore_3
    //   302: aload 5
    //   304: astore_2
    //   305: aload 5
    //   307: aload_3
    //   308: invokevirtual 358	java/io/BufferedInputStream:read	([B)I
    //   311: pop
    //   312: goto -77 -> 235
    //   315: astore_3
    //   316: aconst_null
    //   317: astore_2
    //   318: aload_2
    //   319: ifnull +7 -> 326
    //   322: aload_2
    //   323: invokevirtual 343	java/io/BufferedInputStream:close	()V
    //   326: aload_3
    //   327: athrow
    //   328: astore_2
    //   329: ldc 17
    //   331: bipush 6
    //   333: new 114	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 346
    //   343: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   350: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 337
    //   356: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_2
    //   360: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   363: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: goto -46 -> 326
    //   375: astore_3
    //   376: goto -58 -> 318
    //   379: astore 4
    //   381: aconst_null
    //   382: astore 5
    //   384: aload 6
    //   386: astore_3
    //   387: goto -267 -> 120
    //   390: astore 4
    //   392: goto -272 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramFile	File
    //   56	243	1	i	int
    //   6	163	2	localObject1	Object
    //   181	32	2	localException1	java.lang.Exception
    //   229	8	2	localObject2	Object
    //   249	32	2	localException2	java.lang.Exception
    //   297	26	2	localObject3	Object
    //   328	32	2	localException3	java.lang.Exception
    //   4	304	3	localObject4	Object
    //   315	12	3	localObject5	Object
    //   375	1	3	localObject6	Object
    //   386	1	3	localObject7	Object
    //   83	23	4	arrayOfByte	byte[]
    //   115	39	4	localThrowable1	java.lang.Throwable
    //   379	1	4	localThrowable2	java.lang.Throwable
    //   390	1	4	localThrowable3	java.lang.Throwable
    //   46	337	5	localBufferedInputStream	java.io.BufferedInputStream
    //   1	384	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   51	57	115	java/lang/Throwable
    //   67	75	115	java/lang/Throwable
    //   78	85	115	java/lang/Throwable
    //   88	96	115	java/lang/Throwable
    //   104	112	115	java/lang/Throwable
    //   230	235	115	java/lang/Throwable
    //   298	302	115	java/lang/Throwable
    //   174	179	181	java/lang/Exception
    //   242	247	249	java/lang/Exception
    //   31	48	315	finally
    //   322	326	328	java/lang/Exception
    //   51	57	375	finally
    //   67	75	375	finally
    //   78	85	375	finally
    //   88	96	375	finally
    //   104	112	375	finally
    //   123	167	375	finally
    //   230	235	375	finally
    //   298	302	375	finally
    //   305	312	375	finally
    //   31	48	379	java/lang/Throwable
    //   305	312	390	java/lang/Throwable
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
    //   0: iconst_0
    //   1: istore_2
    //   2: new 36	java/io/File
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 6
    //   18: aload 5
    //   20: astore 4
    //   22: aload 7
    //   24: invokevirtual 43	java/io/File:exists	()Z
    //   27: ifne +74 -> 101
    //   30: aload 5
    //   32: astore 4
    //   34: aload 7
    //   36: invokevirtual 387	java/io/File:createNewFile	()Z
    //   39: istore_3
    //   40: iload_3
    //   41: ifne +60 -> 101
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 389	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 390	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: iload_2
    //   57: ireturn
    //   58: astore_0
    //   59: ldc 17
    //   61: bipush 6
    //   63: new 114	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 392
    //   73: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc_w 337
    //   83: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 5
    //   103: astore 4
    //   105: new 394	java/io/FileOutputStream
    //   108: dup
    //   109: aload 7
    //   111: invokespecial 395	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   114: astore 5
    //   116: aload 5
    //   118: aload_0
    //   119: invokevirtual 398	java/io/FileOutputStream:write	([B)V
    //   122: aload 5
    //   124: invokevirtual 401	java/io/FileOutputStream:flush	()V
    //   127: iconst_1
    //   128: istore_2
    //   129: aload 5
    //   131: ifnull -75 -> 56
    //   134: aload 5
    //   136: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_0
    //   142: ldc 17
    //   144: bipush 6
    //   146: new 114	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 392
    //   156: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 337
    //   166: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore 5
    //   186: aload 6
    //   188: astore_0
    //   189: aload_0
    //   190: astore 4
    //   192: ldc 17
    //   194: bipush 6
    //   196: new 114	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 404
    //   206: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 337
    //   216: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 5
    //   221: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: ifnull -178 -> 56
    //   237: aload_0
    //   238: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   241: iconst_0
    //   242: ireturn
    //   243: astore_0
    //   244: ldc 17
    //   246: bipush 6
    //   248: new 114	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 392
    //   258: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 337
    //   268: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload 4
    //   289: ifnull +8 -> 297
    //   292: aload 4
    //   294: invokevirtual 402	java/io/FileOutputStream:close	()V
    //   297: aload_0
    //   298: athrow
    //   299: astore 4
    //   301: ldc 17
    //   303: bipush 6
    //   305: new 114	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 392
    //   315: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 337
    //   325: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 4
    //   330: invokevirtual 340	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   333: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 137	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   342: goto -45 -> 297
    //   345: astore_0
    //   346: aload 5
    //   348: astore 4
    //   350: goto -63 -> 287
    //   353: astore 4
    //   355: aload 5
    //   357: astore_0
    //   358: aload 4
    //   360: astore 5
    //   362: goto -173 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramArrayOfByte	byte[]
    //   0	365	1	paramString	String
    //   1	128	2	bool1	boolean
    //   39	2	3	bool2	boolean
    //   20	273	4	localObject1	Object
    //   299	30	4	localThrowable1	java.lang.Throwable
    //   348	1	4	localThrowable2	java.lang.Throwable
    //   353	6	4	localThrowable3	java.lang.Throwable
    //   13	122	5	localFileOutputStream	java.io.FileOutputStream
    //   184	172	5	localThrowable4	java.lang.Throwable
    //   360	1	5	localObject2	Object
    //   16	171	6	localObject3	Object
    //   10	100	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   48	56	58	java/lang/Throwable
    //   134	139	141	java/lang/Throwable
    //   22	30	184	java/lang/Throwable
    //   34	40	184	java/lang/Throwable
    //   105	116	184	java/lang/Throwable
    //   237	241	243	java/lang/Throwable
    //   22	30	286	finally
    //   34	40	286	finally
    //   105	116	286	finally
    //   192	233	286	finally
    //   292	297	299	java/lang/Throwable
    //   116	127	345	finally
    //   116	127	353	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicFileUtils
 * JD-Core Version:    0.7.0.1
 */