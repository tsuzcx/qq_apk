package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QShadowRepository
{
  private static final String QSHADOW_SP = "QShadow_SP";
  
  public static void deleteInstalledPlugin(Context paramContext, String paramString)
  {
    getSP(paramContext).edit().remove(paramString).apply();
  }
  
  public static Map<String, String> getAllInstallPlugin(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    paramContext = getSP(paramContext).getAll().entrySet().iterator();
    while (paramContext.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContext.next();
      String str = (String)localEntry.getValue();
      localHashMap.put(localEntry.getKey(), str);
    }
    return localHashMap;
  }
  
  public static String getInstalledPlugin(Context paramContext, String paramString1, String paramString2)
  {
    return getSP(paramContext).getString(paramString1, paramString2);
  }
  
  private static SharedPreferences getSP(Context paramContext)
  {
    return paramContext.getSharedPreferences("QShadow_SP", 0);
  }
  
  /* Error */
  public static String getStringFromStream(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 101	java/io/BufferedReader
    //   3: dup
    //   4: new 103	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: new 111	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 113
    //   24: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_1
    //   29: astore_0
    //   30: aload_1
    //   31: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +34 -> 70
    //   39: aload_1
    //   40: astore_0
    //   41: aload_2
    //   42: aload_3
    //   43: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: goto -19 -> 28
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 130	java/io/BufferedReader:close	()V
    //   65: ldc 113
    //   67: astore_2
    //   68: aload_2
    //   69: areturn
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_2
    //   77: aload_2
    //   78: astore_0
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: ifnull -14 -> 68
    //   85: aload_1
    //   86: invokevirtual 130	java/io/BufferedReader:close	()V
    //   89: aload_0
    //   90: areturn
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   103: goto -38 -> 65
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 130	java/io/BufferedReader:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   124: goto -7 -> 117
    //   127: astore_1
    //   128: goto -19 -> 109
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -83 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramInputStream	InputStream
    //   15	71	1	localBufferedReader	java.io.BufferedReader
    //   91	2	1	localIOException	java.io.IOException
    //   106	12	1	localObject1	Object
    //   127	1	1	localObject2	Object
    //   133	1	1	localObject3	Object
    //   27	15	2	localStringBuilder	java.lang.StringBuilder
    //   50	4	2	localException1	java.lang.Exception
    //   67	14	2	localObject4	Object
    //   131	1	2	localException2	java.lang.Exception
    //   34	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   18	28	50	java/lang/Exception
    //   30	35	50	java/lang/Exception
    //   41	47	50	java/lang/Exception
    //   72	77	50	java/lang/Exception
    //   85	89	91	java/io/IOException
    //   61	65	98	java/io/IOException
    //   0	16	106	finally
    //   113	117	119	java/io/IOException
    //   18	28	127	finally
    //   30	35	127	finally
    //   41	47	127	finally
    //   53	57	127	finally
    //   72	77	127	finally
    //   0	16	131	java/lang/Exception
  }
  
  public static String getUuidFromFile(File paramFile)
  {
    if (!paramFile.exists()) {
      return "";
    }
    try
    {
      paramFile = getUuidFromStream(new FileInputStream(paramFile));
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      paramFile.printStackTrace();
    }
    return "";
  }
  
  public static String getUuidFromStream(InputStream paramInputStream)
  {
    paramInputStream = getStringFromStream(paramInputStream);
    try
    {
      paramInputStream = new JSONObject(paramInputStream).getString("UUID");
      return paramInputStream;
    }
    catch (JSONException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return "";
  }
  
  public static void saveInstalledPlugin(Context paramContext, String paramString1, String paramString2)
  {
    getSP(paramContext).edit().putString(paramString1, paramString2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.QShadowRepository
 * JD-Core Version:    0.7.0.1
 */