package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  public int a;
  private String b;
  private Map<String, d.a> c;
  
  private d(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.optString("VERSIONNAME");
    this.a = paramJSONObject.optInt("VERSIONCODE");
    paramJSONObject = paramJSONObject.optJSONArray("COMPONENTS");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      this.c = new HashMap(j);
      int i = 0;
      while (i < j)
      {
        d.a locala = a(paramJSONObject.optJSONObject(i));
        if (locala != null) {
          this.c.put(locala.a, locala);
        }
        i += 1;
      }
    }
  }
  
  private static d.a a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    String str = paramJSONObject.optString("NAME");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    d.a locala = new d.a();
    locala.a = str;
    locala.b = paramJSONObject.optString("VERSIONNAME");
    locala.c = paramJSONObject.optInt("VERSIONCODE");
    locala.d = paramJSONObject.optString("URL");
    locala.e = paramJSONObject.optString("MD5");
    paramJSONObject = paramJSONObject.optJSONArray("DEPENDENCIES");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int j = paramJSONObject.length();
      locala.f = new String[j];
      int i = 0;
      while (i < j)
      {
        locala.f[i] = paramJSONObject.optString(i);
        i += 1;
      }
    }
    return locala;
  }
  
  /* Error */
  public static d a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 109	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 112	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 115	com/tencent/tbs/one/impl/common/d:a	(Ljava/io/InputStream;)Lcom/tencent/tbs/one/impl/common/d;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 120	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   22: aload_1
    //   23: areturn
    //   24: astore_2
    //   25: aload_0
    //   26: astore_1
    //   27: aload_2
    //   28: astore_0
    //   29: goto +55 -> 84
    //   32: astore_2
    //   33: goto +10 -> 43
    //   36: astore_0
    //   37: goto +47 -> 84
    //   40: astore_2
    //   41: aload_3
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: new 122	java/lang/StringBuilder
    //   48: dup
    //   49: ldc 124
    //   51: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_0
    //   56: astore_1
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 131	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   62: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_0
    //   67: astore_1
    //   68: new 137	com/tencent/tbs/one/TBSOneException
    //   71: dup
    //   72: sipush 306
    //   75: aload_3
    //   76: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: aload_2
    //   80: invokespecial 143	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: athrow
    //   84: aload_1
    //   85: invokestatic 120	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile	java.io.File
    //   3	82	1	localObject1	Object
    //   24	4	2	localObject2	Object
    //   32	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   40	40	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	75	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	18	24	finally
    //   13	18	32	java/io/FileNotFoundException
    //   4	13	36	finally
    //   45	55	36	finally
    //   57	66	36	finally
    //   68	84	36	finally
    //   4	13	40	java/io/FileNotFoundException
  }
  
  private static d a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = c.a(paramInputStream, "utf-8");
      return a(paramInputStream);
    }
    catch (IOException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to read DEPS contents, error: ");
      localStringBuilder.append(paramInputStream.getMessage());
      throw new TBSOneException(307, localStringBuilder.toString(), paramInputStream);
    }
  }
  
  public static d a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return new d(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to parse DEPS ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", error: ");
      localStringBuilder.append(localJSONException.getMessage());
      throw new TBSOneException(308, localStringBuilder.toString(), localJSONException);
    }
  }
  
  public final d.a b(String paramString)
  {
    Map localMap = this.c;
    if (localMap == null) {
      return null;
    }
    return (d.a)localMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.d
 * JD-Core Version:    0.7.0.1
 */