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
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 101	java/io/BufferedReader
    //   7: dup
    //   8: new 103	java/io/InputStreamReader
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   16: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   19: astore_0
    //   20: new 111	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 113
    //   26: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +12 -> 48
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: goto -15 -> 30
    //   48: aload_1
    //   49: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 130	java/io/BufferedReader:close	()V
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   64: aload_1
    //   65: areturn
    //   66: astore_2
    //   67: aload_0
    //   68: astore_1
    //   69: aload_2
    //   70: astore_0
    //   71: goto +39 -> 110
    //   74: astore_2
    //   75: goto +10 -> 85
    //   78: astore_0
    //   79: goto +31 -> 110
    //   82: astore_2
    //   83: aload_3
    //   84: astore_0
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: invokevirtual 134	java/lang/Exception:printStackTrace	()V
    //   91: aload_0
    //   92: ifnull +15 -> 107
    //   95: aload_0
    //   96: invokevirtual 130	java/io/BufferedReader:close	()V
    //   99: ldc 113
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   107: ldc 113
    //   109: areturn
    //   110: aload_1
    //   111: ifnull +15 -> 126
    //   114: aload_1
    //   115: invokevirtual 130	java/io/BufferedReader:close	()V
    //   118: goto +8 -> 126
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   126: goto +5 -> 131
    //   129: aload_0
    //   130: athrow
    //   131: goto -2 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	InputStream
    //   3	112	1	localObject1	Object
    //   121	2	1	localIOException	java.io.IOException
    //   34	7	2	str	String
    //   66	4	2	localObject2	Object
    //   74	1	2	localException1	java.lang.Exception
    //   82	6	2	localException2	java.lang.Exception
    //   1	83	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	57	59	java/io/IOException
    //   20	30	66	finally
    //   30	35	66	finally
    //   39	45	66	finally
    //   48	53	66	finally
    //   20	30	74	java/lang/Exception
    //   30	35	74	java/lang/Exception
    //   39	45	74	java/lang/Exception
    //   48	53	74	java/lang/Exception
    //   4	20	78	finally
    //   87	91	78	finally
    //   4	20	82	java/lang/Exception
    //   95	99	102	java/io/IOException
    //   114	118	121	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.QShadowRepository
 * JD-Core Version:    0.7.0.1
 */