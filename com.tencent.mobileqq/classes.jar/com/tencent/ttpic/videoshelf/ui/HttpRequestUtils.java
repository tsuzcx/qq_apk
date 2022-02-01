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
  private static final String TAG = HttpRequestUtils.class.getSimpleName();
  
  private String getToken(String paramString1, String paramString2)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("agreeStr", "9eZCXk4t9HCSFmO61h9WvIgww9zZMscE");
    ((HashMap)localObject).put("content", paramString1);
    ((HashMap)localObject).put("font_name", paramString2);
    ((HashMap)localObject).entrySet().iterator();
    paramString1 = "";
    paramString2 = new ArrayList(((HashMap)localObject).entrySet());
    Collections.sort(paramString2, new HttpRequestUtils.1(this));
    paramString2 = paramString2.iterator();
    int i = 0;
    if (paramString2.hasNext())
    {
      localObject = (Map.Entry)paramString2.next();
      if (i == 0) {}
      for (paramString1 = paramString1 + (String)((Map.Entry)localObject).getKey() + "=" + (String)((Map.Entry)localObject).getValue();; paramString1 = paramString1 + "&" + (String)((Map.Entry)localObject).getKey() + "=" + (String)((Map.Entry)localObject).getValue())
      {
        i += 1;
        break;
      }
    }
    return MD5Util.GetMD5Code(paramString1);
  }
  
  private static boolean isValidFontName(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String parseFontname(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    String str;
    do
    {
      return "";
      str = paramContext.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
    } while (TextUtils.isEmpty(paramString));
    writeBytesToFile(paramContext, Base64.decode(paramString, 0));
    return str;
  }
  
  /* Error */
  public static void writeBytesToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_2
    //   7: new 87	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   14: aload_0
    //   15: invokevirtual 129	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 137	java/io/File:separator	Ljava/lang/String;
    //   27: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 139
    //   32: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_0
    //   39: aload_1
    //   40: ifnonnull +17 -> 57
    //   43: iconst_0
    //   44: ifeq -40 -> 4
    //   47: new 155	java/lang/NullPointerException
    //   50: dup
    //   51: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   54: athrow
    //   55: astore_0
    //   56: return
    //   57: new 158	java/io/FileOutputStream
    //   60: dup
    //   61: new 131	java/io/File
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: invokespecial 164	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: astore_0
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 168	java/io/FileOutputStream:write	([B)V
    //   78: aload_0
    //   79: ifnull -75 -> 4
    //   82: aload_0
    //   83: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_0
    //   88: return
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull -89 -> 4
    //   96: aload_0
    //   97: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   100: return
    //   101: astore_0
    //   102: return
    //   103: astore_1
    //   104: aload_2
    //   105: astore_0
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   114: aload_1
    //   115: athrow
    //   116: astore_0
    //   117: goto -3 -> 114
    //   120: astore_1
    //   121: goto -15 -> 106
    //   124: astore_1
    //   125: goto -33 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramArrayOfByte	byte[]
    //   6	99	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	55	55	java/lang/Exception
    //   82	86	87	java/lang/Exception
    //   57	73	89	java/io/IOException
    //   96	100	101	java/lang/Exception
    //   57	73	103	finally
    //   110	114	116	java/lang/Exception
    //   73	78	120	finally
    //   73	78	124	java/io/IOException
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
    str = "";
    if ((paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return "";
    }
    for (;;)
    {
      try
      {
        paramString3 = new HttpPost(paramString3);
        if (isValidFontName(paramString2))
        {
          paramString1 = getJsonData(paramString1, paramString2);
          paramString3.setEntity(new StringEntity(paramString1.toString(), "UTF-8"));
          paramString1 = new DefaultHttpClient();
          paramString1.getParams().setParameter("http.connection.timeout", Integer.valueOf(3000));
          paramString1.getParams().setParameter("http.socket.timeout", Integer.valueOf(3000));
          paramString1 = new JSONObject(EntityUtils.toString(paramString1.execute(paramString3).getEntity()));
          if (!paramString1.has("retcode")) {
            break;
          }
          paramString2 = paramString1.get("retcode").toString();
          Log.d(TAG, "ret: " + paramString2);
          if (Integer.parseInt(paramString2) != 0) {
            break;
          }
          paramString1 = paramString1.getJSONObject("retdata").get("font_data").toString();
        }
      }
      catch (JSONException paramContext)
      {
        Log.w(TAG, "upload error = ", paramContext);
        return str;
      }
      catch (IOException paramContext)
      {
        Log.w(TAG, "upload error = ", paramContext);
        return str;
      }
      try
      {
        paramContext = parseFontname(paramContext, paramString1);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        str = paramString1;
        continue;
      }
      catch (JSONException paramContext)
      {
        str = paramString1;
        continue;
      }
      paramString1 = getJsonData(paramString1, DEFAULT_FONTNAME);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.ui.HttpRequestUtils
 * JD-Core Version:    0.7.0.1
 */