package com.tencent.tbs.one.impl.common;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public int a;
  public String b;
  public String c;
  public String d;
  public e.a[] e;
  public Pair<String, String>[] f;
  
  private e(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("VERSIONCODE");
    this.b = paramJSONObject.optString("RESOURCE");
    Object localObject = paramJSONObject.optString("ENTRY");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length == 1)
      {
        this.c = localObject[0];
      }
      else if (localObject.length >= 2)
      {
        this.c = localObject[0];
        this.d = localObject[1];
      }
    }
    localObject = paramJSONObject.optJSONArray("FILES");
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      int j = ((JSONArray)localObject).length();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        e.a locala = a(((JSONArray)localObject).optJSONObject(i));
        if (locala != null) {
          localArrayList.add(locala);
        }
        i += 1;
      }
      this.e = ((e.a[])localArrayList.toArray(new e.a[0]));
    }
    a(paramJSONObject.optJSONArray("RECEIVERS"));
  }
  
  private static e.a a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = paramJSONObject.optString("PATH");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    e.a locala = new e.a();
    locala.a = ((String)localObject);
    locala.b = paramJSONObject.optString("MD5");
    try
    {
      localObject = paramJSONObject.getJSONArray("UNSEALED");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        int j = ((JSONArray)localObject).length();
        String[] arrayOfString = new String[j];
        int i = 0;
        while (i < j)
        {
          arrayOfString[i] = ((JSONArray)localObject).optString(i);
          i += 1;
        }
        locala.c = arrayOfString;
      }
    }
    catch (JSONException localJSONException)
    {
      label111:
      break label111;
    }
    locala.e = paramJSONObject.optString("URL");
    localObject = paramJSONObject.optString("PARENT");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramJSONObject = new e.b();
      localObject = ((String)localObject).split(":");
      if (localObject.length == 1)
      {
        paramJSONObject.b = localObject[0];
      }
      else
      {
        paramJSONObject.a = localObject[0];
        paramJSONObject.b = localObject[1];
      }
      locala.d = paramJSONObject;
    }
    return locala;
  }
  
  /* Error */
  public static e a(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 145	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: new 2	com/tencent/tbs/one/impl/common/e
    //   14: dup
    //   15: new 24	org/json/JSONObject
    //   18: dup
    //   19: aload_2
    //   20: ldc 150
    //   22: invokestatic 155	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   25: invokespecial 158	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 160	com/tencent/tbs/one/impl/common/e:<init>	(Lorg/json/JSONObject;)V
    //   31: astore_3
    //   32: aload_2
    //   33: invokestatic 163	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   36: aload_3
    //   37: areturn
    //   38: astore_3
    //   39: goto +20 -> 59
    //   42: astore_3
    //   43: goto +82 -> 125
    //   46: astore_3
    //   47: goto +144 -> 191
    //   50: astore_0
    //   51: aconst_null
    //   52: astore_1
    //   53: goto +205 -> 258
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: new 165	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 167
    //   67: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: astore 4
    //   72: aload_2
    //   73: astore_1
    //   74: aload 4
    //   76: aload_0
    //   77: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: ldc 180
    //   90: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: astore_1
    //   96: aload 4
    //   98: aload_3
    //   99: invokevirtual 183	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: astore_1
    //   108: new 185	com/tencent/tbs/one/TBSOneException
    //   111: dup
    //   112: sipush 403
    //   115: aload 4
    //   117: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_3
    //   121: invokespecial 191	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: aload_2
    //   126: astore_1
    //   127: new 165	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 193
    //   133: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: astore 4
    //   138: aload_2
    //   139: astore_1
    //   140: aload 4
    //   142: aload_0
    //   143: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   146: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_2
    //   151: astore_1
    //   152: aload 4
    //   154: ldc 180
    //   156: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: astore_1
    //   162: aload 4
    //   164: aload_3
    //   165: invokevirtual 194	java/io/IOException:getMessage	()Ljava/lang/String;
    //   168: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_2
    //   173: astore_1
    //   174: new 185	com/tencent/tbs/one/TBSOneException
    //   177: dup
    //   178: sipush 402
    //   181: aload 4
    //   183: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload_3
    //   187: invokespecial 191	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: athrow
    //   191: aload_2
    //   192: astore_1
    //   193: new 165	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 196
    //   199: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: astore 4
    //   204: aload_2
    //   205: astore_1
    //   206: aload 4
    //   208: aload_0
    //   209: invokevirtual 174	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   212: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: ldc 180
    //   222: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: astore_1
    //   228: aload 4
    //   230: aload_3
    //   231: invokevirtual 197	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_2
    //   239: astore_1
    //   240: new 185	com/tencent/tbs/one/TBSOneException
    //   243: dup
    //   244: sipush 401
    //   247: aload 4
    //   249: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload_3
    //   253: invokespecial 191	com/tencent/tbs/one/TBSOneException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: athrow
    //   257: astore_0
    //   258: aload_1
    //   259: invokestatic 163	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   262: aload_0
    //   263: athrow
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_2
    //   267: goto -142 -> 125
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_2
    //   273: goto -82 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramFile	java.io.File
    //   10	249	1	localFileInputStream1	java.io.FileInputStream
    //   8	265	2	localFileInputStream2	java.io.FileInputStream
    //   31	6	3	locale	e
    //   38	1	3	localJSONException1	JSONException
    //   42	1	3	localIOException1	IOException
    //   46	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   56	197	3	localJSONException2	JSONException
    //   264	1	3	localIOException2	IOException
    //   270	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   70	178	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	32	38	org/json/JSONException
    //   11	32	42	java/io/IOException
    //   11	32	46	java/io/FileNotFoundException
    //   0	9	50	finally
    //   0	9	56	org/json/JSONException
    //   11	32	257	finally
    //   61	72	257	finally
    //   74	84	257	finally
    //   86	94	257	finally
    //   96	106	257	finally
    //   108	125	257	finally
    //   127	138	257	finally
    //   140	150	257	finally
    //   152	160	257	finally
    //   162	172	257	finally
    //   174	191	257	finally
    //   193	204	257	finally
    //   206	216	257	finally
    //   218	226	257	finally
    //   228	238	257	finally
    //   240	257	257	finally
    //   0	9	264	java/io/IOException
    //   0	9	270	java/io/FileNotFoundException
  }
  
  public static e a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new JSONObject(c.a(paramInputStream, "utf-8"));
      return new e(paramInputStream);
    }
    catch (JSONException paramInputStream)
    {
      localStringBuilder = new StringBuilder("Failed to parse MANIFSET contents, error: ");
      localStringBuilder.append(paramInputStream.getMessage());
      throw new TBSOneException(401, localStringBuilder.toString());
    }
    catch (IOException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to read MANIFEST contents, error: ");
      localStringBuilder.append(paramInputStream.getMessage());
      throw new TBSOneException(401, localStringBuilder.toString(), paramInputStream);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() <= 0) {
        return;
      }
      int k = paramJSONArray.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < k)
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        String str = ((JSONObject)localObject).optString("CLASS");
        localObject = ((JSONObject)localObject).optJSONArray("EVENTS");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          int m = ((JSONArray)localObject).length();
          int j = 0;
          while (j < m)
          {
            localArrayList.add(new Pair(((JSONArray)localObject).optString(j), str));
            j += 1;
          }
        }
        i += 1;
      }
      this.f = ((Pair[])localArrayList.toArray(new Pair[0]));
    }
  }
  
  public final e.a a(String paramString)
  {
    e.a[] arrayOfa = this.e;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      e.a locala = arrayOfa[i];
      if (locala.a.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.e
 * JD-Core Version:    0.7.0.1
 */