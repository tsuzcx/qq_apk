package com.tencent.ttpic.videoshelf.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.ttpic.baseutils.encrypt.MD5Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequestUtils
{
  private static String DEFAULT_FONTNAME = "default";
  private static final String TAG = "HttpRequestUtils";
  
  private String getToken(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("agreeStr", "9eZCXk4t9HCSFmO61h9WvIgww9zZMscE");
    ((HashMap)localObject).put("content", paramString1);
    ((HashMap)localObject).put("font_name", paramString2);
    ((HashMap)localObject).entrySet().iterator();
    paramString1 = new ArrayList(((HashMap)localObject).entrySet());
    Collections.sort(paramString1, new HttpRequestUtils.1(this));
    paramString2 = paramString1.iterator();
    paramString1 = "";
    int i = 0;
    while (paramString2.hasNext())
    {
      localObject = (Map.Entry)paramString2.next();
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)((Map.Entry)localObject).getValue());
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("&");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)((Map.Entry)localObject).getValue());
        paramString1 = localStringBuilder.toString();
      }
      i += 1;
    }
    return MD5Util.GetMD5Code(paramString1);
  }
  
  private static boolean isValidFontName(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String parseFontname(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("temp.ttf");
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    writeBytesToFile(paramContext, Base64.decode(paramString, 0));
    return localObject;
  }
  
  /* Error */
  public static void writeBytesToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: new 79	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: aload_0
    //   21: invokevirtual 122	android/content/Context:getFilesDir	()Ljava/io/File;
    //   24: invokevirtual 127	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   36: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: ldc 132
    //   44: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_0
    //   54: aload_1
    //   55: ifnonnull +4 -> 59
    //   58: return
    //   59: new 148	java/io/FileOutputStream
    //   62: dup
    //   63: new 124	java/io/File
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 151	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_0
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 158	java/io/FileOutputStream:write	([B)V
    //   80: aload_0
    //   81: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   84: return
    //   85: astore_2
    //   86: aload_0
    //   87: astore_1
    //   88: aload_2
    //   89: astore_0
    //   90: goto +9 -> 99
    //   93: goto +16 -> 109
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   107: aload_0
    //   108: athrow
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 161	java/io/FileOutputStream:close	()V
    //   117: return
    //   118: astore_0
    //   119: aload_3
    //   120: astore_0
    //   121: goto -12 -> 109
    //   124: astore_1
    //   125: goto -32 -> 93
    //   128: astore_0
    //   129: return
    //   130: astore_1
    //   131: goto -24 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   0	134	1	paramArrayOfByte	byte[]
    //   8	1	2	localObject1	Object
    //   85	13	2	localObject2	Object
    //   6	114	3	localObject3	Object
    //   16	33	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   75	80	85	finally
    //   59	75	96	finally
    //   59	75	118	java/io/IOException
    //   75	80	124	java/io/IOException
    //   80	84	128	java/lang/Exception
    //   113	117	128	java/lang/Exception
    //   103	107	130	java/lang/Exception
  }
  
  public JSONObject getJsonData(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        String str = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          str = DEFAULT_FONTNAME;
        }
        localJSONObject.put("font_name", str);
        localJSONObject.put("content", paramString1);
        localJSONObject.put("token", getToken(paramString1, str));
      }
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return localJSONObject;
  }
  
  public String uploadText(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str2 = "";
    Object localObject = str2;
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString3)) {
        return "";
      }
      String str3 = str2;
      String str1 = str2;
      try
      {
        paramString3 = new HttpPost(paramString3);
        str3 = str2;
        str1 = str2;
        if (isValidFontName(paramString2))
        {
          str3 = str2;
          str1 = str2;
          paramString1 = getJsonData(paramString1, paramString2);
        }
        else
        {
          str3 = str2;
          str1 = str2;
          paramString1 = getJsonData(paramString1, DEFAULT_FONTNAME);
        }
        str3 = str2;
        str1 = str2;
        paramString3.setEntity(new StringEntity(paramString1.toString(), "UTF-8"));
        str3 = str2;
        str1 = str2;
        paramString1 = new DefaultHttpClient();
        str3 = str2;
        str1 = str2;
        paramString1.getParams().setParameter("http.connection.timeout", Integer.valueOf(3000));
        str3 = str2;
        str1 = str2;
        paramString1.getParams().setParameter("http.socket.timeout", Integer.valueOf(3000));
        str3 = str2;
        str1 = str2;
        paramString1 = new JSONObject(EntityUtils.toString(paramString1.execute(paramString3).getEntity()));
        str3 = str2;
        str1 = str2;
        localObject = str2;
        if (paramString1.has("retcode"))
        {
          str3 = str2;
          str1 = str2;
          paramString2 = paramString1.get("retcode").toString();
          str3 = str2;
          str1 = str2;
          paramString3 = TAG;
          str3 = str2;
          str1 = str2;
          localObject = new StringBuilder();
          str3 = str2;
          str1 = str2;
          ((StringBuilder)localObject).append("ret: ");
          str3 = str2;
          str1 = str2;
          ((StringBuilder)localObject).append(paramString2);
          str3 = str2;
          str1 = str2;
          Log.d(paramString3, ((StringBuilder)localObject).toString());
          str3 = str2;
          str1 = str2;
          localObject = str2;
          if (Integer.parseInt(paramString2) == 0)
          {
            str3 = str2;
            str1 = str2;
            paramString1 = paramString1.getJSONObject("retdata").get("font_data").toString();
            str3 = paramString1;
            str1 = paramString1;
            paramContext = parseFontname(paramContext, paramString1);
            return paramContext;
          }
        }
      }
      catch (IOException paramContext)
      {
        Log.w(TAG, "upload error = ", paramContext);
        return str3;
      }
      catch (JSONException paramContext)
      {
        Log.w(TAG, "upload error = ", paramContext);
        localObject = str1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.HttpRequestUtils
 * JD-Core Version:    0.7.0.1
 */