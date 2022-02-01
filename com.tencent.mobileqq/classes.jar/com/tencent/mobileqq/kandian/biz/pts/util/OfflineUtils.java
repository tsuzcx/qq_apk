package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.res.AssetManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OfflineUtils
{
  private static QQHashMap<String, TemplateFactory> jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap = new QQHashMap(2019, 10, 10000);
  public static String a = "version_id";
  private static Map<String, OfflineUtils.ConfigData> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  public static String b = "support_min_version_id";
  public static String c = "is_merged";
  
  private static int a(List<Integer> paramList1, List<Integer> paramList2)
  {
    int j = Math.min(paramList1.size(), paramList2.size());
    int i = 0;
    while (i < j)
    {
      if (((Integer)paramList1.get(i)).intValue() > ((Integer)paramList2.get(i)).intValue()) {
        return 1;
      }
      if (((Integer)paramList1.get(i)).intValue() < ((Integer)paramList2.get(i)).intValue()) {
        return -1;
      }
      i += 1;
    }
    return 0;
  }
  
  public static TemplateFactory a(String paramString)
  {
    try
    {
      paramString = (TemplateFactory)jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static OfflineUtils.ConfigData a(String paramString)
  {
    // Byte code:
    //   0: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   3: aload_0
    //   4: invokeinterface 72 2 0
    //   9: checkcast 74	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +5 -> 19
    //   17: aload_1
    //   18: areturn
    //   19: new 74	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData
    //   22: dup
    //   23: invokespecial 75	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData:<init>	()V
    //   26: astore_1
    //   27: aload_0
    //   28: invokestatic 80	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnonnull +29 -> 62
    //   36: ldc 82
    //   38: iconst_2
    //   39: ldc 84
    //   41: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_1
    //   45: iconst_0
    //   46: putfield 93	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData:a	Z
    //   49: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   52: aload_0
    //   53: aload_1
    //   54: invokeinterface 97 3 0
    //   59: pop
    //   60: aload_1
    //   61: areturn
    //   62: new 99	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   69: astore_3
    //   70: aload_3
    //   71: aload_2
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: aload_0
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore_2
    //   87: new 99	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_2
    //   97: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_3
    //   102: ldc 110
    //   104: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc 112
    //   111: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_3
    //   116: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_2
    //   120: new 114	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore_3
    //   129: aload_3
    //   130: invokevirtual 121	java/io/File:exists	()Z
    //   133: ifne +52 -> 185
    //   136: new 99	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   143: astore_3
    //   144: aload_3
    //   145: ldc 123
    //   147: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: aload_2
    //   153: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 82
    //   159: iconst_2
    //   160: aload_3
    //   161: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_1
    //   168: iconst_1
    //   169: putfield 93	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData:a	Z
    //   172: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   175: aload_0
    //   176: aload_1
    //   177: invokeinterface 97 3 0
    //   182: pop
    //   183: aload_1
    //   184: areturn
    //   185: aload_1
    //   186: iconst_0
    //   187: putfield 93	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils$ConfigData:a	Z
    //   190: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   193: aload_0
    //   194: aload_1
    //   195: invokeinterface 97 3 0
    //   200: pop
    //   201: aload_1
    //   202: areturn
    //   203: astore_2
    //   204: goto +26 -> 230
    //   207: astore_2
    //   208: ldc 82
    //   210: iconst_1
    //   211: ldc 125
    //   213: aload_2
    //   214: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   220: aload_0
    //   221: aload_1
    //   222: invokeinterface 97 3 0
    //   227: pop
    //   228: aload_1
    //   229: areturn
    //   230: getstatic 34	com/tencent/mobileqq/kandian/biz/pts/util/OfflineUtils:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   233: aload_0
    //   234: aload_1
    //   235: invokeinterface 97 3 0
    //   240: pop
    //   241: aload_2
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString	String
    //   12	223	1	localConfigData	OfflineUtils.ConfigData
    //   31	122	2	str	String
    //   203	1	2	localObject1	Object
    //   207	35	2	localException	java.lang.Exception
    //   69	92	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   129	172	203	finally
    //   185	190	203	finally
    //   208	217	203	finally
    //   129	172	207	java/lang/Exception
    //   185	190	207	java/lang/Exception
  }
  
  public static String a()
  {
    String str = RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a(str));
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 141	java/io/BufferedReader
    //   3: dup
    //   4: new 143	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 99	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +12 -> 42
    //   33: aload_1
    //   34: aload_3
    //   35: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: goto -15 -> 24
    //   42: aload_0
    //   43: invokevirtual 157	java/io/InputStream:close	()V
    //   46: goto +32 -> 78
    //   49: astore_1
    //   50: goto +33 -> 83
    //   53: ldc 82
    //   55: iconst_2
    //   56: ldc 159
    //   58: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: invokevirtual 157	java/io/InputStream:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: ldc 82
    //   69: iconst_2
    //   70: ldc 161
    //   72: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: goto -33 -> 42
    //   78: aload_1
    //   79: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: areturn
    //   83: aload_0
    //   84: invokevirtual 157	java/io/InputStream:close	()V
    //   87: goto +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: goto -2 -> 90
    //   95: astore_2
    //   96: goto -29 -> 67
    //   99: astore_1
    //   100: goto -47 -> 53
    //   103: astore_0
    //   104: goto -26 -> 78
    //   107: astore_0
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: goto -24 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	java.io.InputStream
    //   23	11	1	localStringBuilder	StringBuilder
    //   49	42	1	localObject	Object
    //   99	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   95	1	2	localIOException	java.io.IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	49	finally
    //   33	39	49	finally
    //   53	61	49	finally
    //   67	75	49	finally
    //   24	29	95	java/io/IOException
    //   33	39	95	java/io/IOException
    //   24	29	99	java/lang/OutOfMemoryError
    //   33	39	99	java/lang/OutOfMemoryError
    //   42	46	103	java/io/IOException
    //   61	65	107	java/io/IOException
    //   83	87	110	java/io/IOException
  }
  
  public static List<String> a(AssetManager paramAssetManager, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    localStringBuilder.append("manifest");
    return a(paramAssetManager.open(localStringBuilder.toString()));
  }
  
  /* Error */
  public static List<String> a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 141	java/io/BufferedReader
    //   3: dup
    //   4: new 143	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 146	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 149	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 176	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 177	java/util/ArrayList:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: aload_3
    //   35: invokeinterface 181 2 0
    //   40: pop
    //   41: goto -17 -> 24
    //   44: aload_0
    //   45: invokevirtual 157	java/io/InputStream:close	()V
    //   48: aload_1
    //   49: areturn
    //   50: astore_1
    //   51: goto +28 -> 79
    //   54: ldc 82
    //   56: iconst_2
    //   57: ldc 159
    //   59: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: invokevirtual 157	java/io/InputStream:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: ldc 82
    //   70: iconst_2
    //   71: ldc 161
    //   73: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: goto -32 -> 44
    //   79: aload_0
    //   80: invokevirtual 157	java/io/InputStream:close	()V
    //   83: goto +5 -> 88
    //   86: aload_1
    //   87: athrow
    //   88: goto -2 -> 86
    //   91: astore_2
    //   92: goto -24 -> 68
    //   95: astore_1
    //   96: goto -42 -> 54
    //   99: astore_0
    //   100: aload_1
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: goto -23 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramInputStream	java.io.InputStream
    //   23	26	1	localArrayList	ArrayList
    //   50	37	1	localObject	Object
    //   95	6	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   91	1	2	localIOException	java.io.IOException
    //   28	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   24	29	50	finally
    //   33	41	50	finally
    //   54	62	50	finally
    //   68	76	50	finally
    //   24	29	91	java/io/IOException
    //   33	41	91	java/io/IOException
    //   24	29	95	java/lang/OutOfMemoryError
    //   33	41	95	java/lang/OutOfMemoryError
    //   44	48	99	java/io/IOException
    //   62	66	102	java/io/IOException
    //   79	83	105	java/io/IOException
  }
  
  private static List<Integer> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\\.");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      localArrayList.add(Integer.valueOf(Integer.parseInt(paramString[i])));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    ProteusSettingUtil.a();
    HtmlOffline.a();
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, TemplateFactory paramTemplateFactory)
  {
    try
    {
      jdField_a_of_type_ComTencentCommonsdkCacheQQHashMap.put(paramString, paramTemplateFactory);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    ThreadManager.executeOnFileThread(new OfflineUtils.1(paramBoolean));
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString3 = a("8.7.0");
      paramString3.add(Integer.valueOf(Integer.parseInt("5295")));
      paramString1 = a(paramString1);
      paramString2 = a(paramString2);
      bool1 = bool2;
      if (paramString1.size() == paramString3.size() - 1)
      {
        if (paramString2.size() != paramString3.size() - 1) {
          return false;
        }
        if (a(paramString1, paramString2) > 0) {
          return false;
        }
        bool1 = bool2;
        if (a(paramString3, paramString1) >= 0)
        {
          bool1 = bool2;
          if (a(paramString3, paramString2) <= 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static void b() {}
  
  public static void c()
  {
    String str = RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a(str));
    localStringBuilder.append(str);
    FileUtils.deleteDirectory(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils
 * JD-Core Version:    0.7.0.1
 */