package com.tencent.mobileqq.microapp.b;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.microapp.R.anim;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String a;
  public String b;
  
  public static int a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(11);
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 85	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 91	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 96	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 100	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 102	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc 104
    //   35: invokespecial 107	java/lang/String:<init>	([BLjava/lang/String;)V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 110	java/io/InputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 110	java/io/InputStream:close	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_1
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 110	java/io/InputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_0
    //   82: aload_2
    //   83: areturn
    //   84: astore_0
    //   85: goto -19 -> 66
    //   88: astore_0
    //   89: goto -10 -> 79
    //   92: astore_1
    //   93: goto -22 -> 71
    //   96: astore_2
    //   97: goto -45 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	android.content.Context
    //   0	100	1	paramString	String
    //   17	31	2	localObject	Object
    //   49	34	2	localException1	Exception
    //   96	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	9	49	java/lang/Exception
    //   0	9	68	finally
    //   43	47	81	java/io/IOException
    //   62	66	84	java/io/IOException
    //   75	79	88	java/io/IOException
    //   11	18	92	finally
    //   20	26	92	finally
    //   28	39	92	finally
    //   54	58	92	finally
    //   11	18	96	java/lang/Exception
    //   20	26	96	java/lang/Exception
    //   28	39	96	java/lang/Exception
  }
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = b(paramFile);
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      paramFile.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = Uri.parse("file:///" + paramString).getPath();
    paramString = str;
    if (str != null)
    {
      paramString = str;
      if (str.startsWith("/")) {
        paramString = str.substring(1);
      }
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        List localList = URLEncodedUtils.parse(new URI(paramString1), "UTF-8");
        localObject1 = localObject2;
        int j = localList.size();
        int i = 0;
        paramString1 = (String)localObject2;
        localObject1 = paramString1;
        if (i < j)
        {
          localObject1 = paramString1;
          localObject2 = (NameValuePair)localList.get(i);
          localObject1 = paramString1;
          if (((NameValuePair)localObject2).getName().equals(paramString2))
          {
            localObject1 = paramString1;
            paramString1 = ((NameValuePair)localObject2).getValue();
            i += 1;
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (URISyntaxException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static SSLContext a()
  {
    Object localObject = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localObject = localSSLContext;
      localSSLContext.init(null, new TrustManager[] { new a.a() }, null);
      return localSSLContext;
    }
    catch (Exception localException) {}
    return localObject;
  }
  
  public static JSONArray a(List paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Map)) {
        localJSONArray.put(c((Map)localObject));
      } else if ((localObject instanceof List)) {
        localJSONArray.put(a((List)localObject));
      } else {
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    int k = 0;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramJSONArray1.length()) {
        break;
      }
      localJSONArray.put(paramJSONArray1.get(i));
      i += 1;
    }
    while (j < paramJSONArray2.length())
    {
      localJSONArray.put(paramJSONArray2.get(j));
      j += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label64:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label64;
        }
      }
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: aload_1
    //   8: astore_0
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 251	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 252	org/json/JSONObject:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_1
    //   24: ifnonnull +91 -> 115
    //   27: new 251	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 252	org/json/JSONObject:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_1
    //   37: new 124	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 262
    //   51: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: astore_3
    //   55: aload_2
    //   56: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +24 -> 83
    //   62: ldc 121
    //   64: astore_0
    //   65: aload_1
    //   66: ldc 254
    //   68: aload_3
    //   69: aload_0
    //   70: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 259	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: goto +38 -> 118
    //   83: new 124	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 264
    //   93: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_2
    //   97: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_0
    //   104: goto -39 -> 65
    //   107: astore_0
    //   108: goto +10 -> 118
    //   111: astore_0
    //   112: goto +6 -> 118
    //   115: goto -78 -> 37
    //   118: aload_1
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString1	String
    //   0	120	1	paramJSONObject	JSONObject
    //   0	120	2	paramString2	String
    //   34	35	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	107	java/lang/Exception
    //   37	62	111	java/lang/Exception
    //   65	80	111	java/lang/Exception
    //   83	104	111	java/lang/Exception
  }
  
  public static JSONObject a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("JSONUtil", 1, paramJSONObject, new Object[0]);
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      paramActivity.overridePendingTransition(R.anim.b, R.anim.c);
    }
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    try
    {
      paramString = b(new File(paramString));
      paramWebView.evaluateJavascript(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static void a(String paramString, com.tencent.mobileqq.microapp.widget.media.c paramc)
  {
    new com.tencent.mobileqq.microapp.widget.media.b(paramc).execute(new String[] { paramString });
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, b paramb)
  {
    a(paramString1, paramString2, paramString3, paramJSONObject, null, null, null, paramb, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, b paramb)
  {
    a(paramString1, paramString2, paramString3, paramJSONObject1, paramJSONObject2, paramString4, paramString5, paramb, true);
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, b paramb, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 318	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 319	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 323	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 325	java/net/HttpURLConnection
    //   14: astore 11
    //   16: aload 11
    //   18: instanceof 327
    //   21: ifeq +25 -> 46
    //   24: invokestatic 329	com/tencent/mobileqq/microapp/b/a:a	()Ljavax/net/ssl/SSLContext;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +17 -> 46
    //   32: aload_1
    //   33: invokevirtual 333	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   36: astore_1
    //   37: aload 11
    //   39: checkcast 327	javax/net/ssl/HttpsURLConnection
    //   42: aload_1
    //   43: invokevirtual 337	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   46: invokestatic 343	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   49: invokevirtual 344	java/util/UUID:toString	()Ljava/lang/String;
    //   52: astore 12
    //   54: aload 11
    //   56: ldc_w 345
    //   59: invokevirtual 349	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   62: aload 11
    //   64: ldc_w 345
    //   67: invokevirtual 352	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   70: aload 11
    //   72: iconst_1
    //   73: invokevirtual 356	java/net/HttpURLConnection:setDoInput	(Z)V
    //   76: aload 11
    //   78: iconst_1
    //   79: invokevirtual 359	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   82: aload 11
    //   84: iconst_0
    //   85: invokevirtual 362	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   88: aload 11
    //   90: aload_0
    //   91: invokevirtual 365	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   94: aload 11
    //   96: ldc_w 367
    //   99: ldc_w 369
    //   102: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 11
    //   107: ldc_w 375
    //   110: ldc_w 377
    //   113: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 11
    //   118: ldc_w 379
    //   121: new 124	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 381
    //   131: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 383
    //   137: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 12
    //   142: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_3
    //   152: ifnull +52 -> 204
    //   155: aload_3
    //   156: invokevirtual 386	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   159: astore_0
    //   160: aload_0
    //   161: invokeinterface 221 1 0
    //   166: ifeq +38 -> 204
    //   169: aload_0
    //   170: invokeinterface 225 1 0
    //   175: checkcast 102	java/lang/String
    //   178: astore_1
    //   179: aload 11
    //   181: aload_1
    //   182: aload_3
    //   183: aload_1
    //   184: invokevirtual 389	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   187: invokevirtual 373	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: goto -30 -> 160
    //   193: astore_0
    //   194: aload 7
    //   196: iconst_m1
    //   197: aconst_null
    //   198: aconst_null
    //   199: iconst_0
    //   200: invokevirtual 394	com/tencent/mobileqq/microapp/b/b:a	(I[BLjava/util/Map;I)V
    //   203: return
    //   204: new 293	java/io/File
    //   207: dup
    //   208: aload_2
    //   209: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore_1
    //   213: new 396	java/io/DataOutputStream
    //   216: dup
    //   217: aload 11
    //   219: invokevirtual 400	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   222: invokespecial 403	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   225: astore_3
    //   226: iload 8
    //   228: ifeq +257 -> 485
    //   231: new 405	java/lang/StringBuffer
    //   234: dup
    //   235: invokespecial 406	java/lang/StringBuffer:<init>	()V
    //   238: astore 13
    //   240: aload 4
    //   242: ifnull +110 -> 352
    //   245: aload 4
    //   247: invokevirtual 386	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   250: astore_0
    //   251: aload_0
    //   252: invokeinterface 221 1 0
    //   257: ifeq +95 -> 352
    //   260: aload_0
    //   261: invokeinterface 225 1 0
    //   266: checkcast 102	java/lang/String
    //   269: astore 14
    //   271: aload 4
    //   273: aload 14
    //   275: invokevirtual 409	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 15
    //   280: aload 13
    //   282: ldc_w 411
    //   285: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   288: aload 12
    //   290: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: ldc_w 416
    //   296: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   299: pop
    //   300: aload 13
    //   302: ldc_w 418
    //   305: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   308: aload 14
    //   310: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   313: ldc_w 420
    //   316: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   319: ldc_w 416
    //   322: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   325: pop
    //   326: aload 13
    //   328: ldc_w 416
    //   331: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   334: pop
    //   335: aload 13
    //   337: aload 15
    //   339: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   342: ldc_w 416
    //   345: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   348: pop
    //   349: goto -98 -> 251
    //   352: aload 13
    //   354: ldc_w 411
    //   357: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   360: pop
    //   361: aload 13
    //   363: aload 12
    //   365: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   368: pop
    //   369: aload 13
    //   371: ldc_w 416
    //   374: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   377: pop
    //   378: aload 6
    //   380: astore_0
    //   381: aload 6
    //   383: invokestatic 249	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   386: ifeq +8 -> 394
    //   389: aload_1
    //   390: invokevirtual 421	java/io/File:getName	()Ljava/lang/String;
    //   393: astore_0
    //   394: aload 13
    //   396: ldc_w 418
    //   399: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   402: aload 5
    //   404: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   407: ldc_w 423
    //   410: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   413: aload_0
    //   414: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   417: ldc_w 420
    //   420: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   423: ldc_w 416
    //   426: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   429: pop
    //   430: aload 13
    //   432: ldc_w 425
    //   435: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   438: aload_2
    //   439: invokestatic 428	com/tencent/mobileqq/microapp/b/a:l	(Ljava/lang/String;)Ljava/lang/String;
    //   442: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   445: ldc_w 430
    //   448: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   451: ldc_w 369
    //   454: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   457: ldc_w 416
    //   460: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   463: pop
    //   464: aload 13
    //   466: ldc_w 416
    //   469: invokevirtual 414	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   472: pop
    //   473: aload_3
    //   474: aload 13
    //   476: invokevirtual 431	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   479: invokevirtual 435	java/lang/String:getBytes	()[B
    //   482: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   485: new 441	java/io/FileInputStream
    //   488: dup
    //   489: aload_1
    //   490: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   493: astore_1
    //   494: aload_1
    //   495: astore_0
    //   496: sipush 1024
    //   499: newarray byte
    //   501: astore_2
    //   502: aload_1
    //   503: astore_0
    //   504: aload_1
    //   505: aload_2
    //   506: invokevirtual 100	java/io/InputStream:read	([B)I
    //   509: istore 9
    //   511: iload 9
    //   513: iconst_m1
    //   514: if_icmpeq +150 -> 664
    //   517: aload_1
    //   518: astore_0
    //   519: aload_3
    //   520: aload_2
    //   521: iconst_0
    //   522: iload 9
    //   524: invokevirtual 447	java/io/DataOutputStream:write	([BII)V
    //   527: goto -25 -> 502
    //   530: astore_2
    //   531: aload_1
    //   532: astore_0
    //   533: aload_2
    //   534: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   537: aload_1
    //   538: ifnull +7 -> 545
    //   541: aload_1
    //   542: invokevirtual 110	java/io/InputStream:close	()V
    //   545: aload_3
    //   546: ldc_w 416
    //   549: invokevirtual 435	java/lang/String:getBytes	()[B
    //   552: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   555: aload_3
    //   556: new 124	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   563: ldc_w 411
    //   566: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 12
    //   571: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc_w 411
    //   577: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 416
    //   583: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 435	java/lang/String:getBytes	()[B
    //   592: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   595: aload_3
    //   596: invokevirtual 450	java/io/DataOutputStream:flush	()V
    //   599: aload 11
    //   601: invokevirtual 453	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   604: pop
    //   605: aload 11
    //   607: invokevirtual 456	java/net/HttpURLConnection:getResponseCode	()I
    //   610: istore 9
    //   612: iload 9
    //   614: sipush 200
    //   617: if_icmpne +103 -> 720
    //   620: aload 11
    //   622: invokevirtual 460	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   625: astore_0
    //   626: new 462	java/io/ByteArrayOutputStream
    //   629: dup
    //   630: invokespecial 463	java/io/ByteArrayOutputStream:<init>	()V
    //   633: astore_1
    //   634: sipush 1024
    //   637: newarray byte
    //   639: astore_2
    //   640: aload_0
    //   641: aload_2
    //   642: invokevirtual 100	java/io/InputStream:read	([B)I
    //   645: istore 10
    //   647: iload 10
    //   649: iconst_m1
    //   650: if_icmpeq +35 -> 685
    //   653: aload_1
    //   654: aload_2
    //   655: iconst_0
    //   656: iload 10
    //   658: invokevirtual 464	java/io/ByteArrayOutputStream:write	([BII)V
    //   661: goto -21 -> 640
    //   664: aload_1
    //   665: ifnull -120 -> 545
    //   668: aload_1
    //   669: invokevirtual 110	java/io/InputStream:close	()V
    //   672: goto -127 -> 545
    //   675: aload_0
    //   676: ifnull +7 -> 683
    //   679: aload_0
    //   680: invokevirtual 110	java/io/InputStream:close	()V
    //   683: aload_1
    //   684: athrow
    //   685: aload_0
    //   686: invokevirtual 110	java/io/InputStream:close	()V
    //   689: aload_1
    //   690: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   693: aload_0
    //   694: invokevirtual 110	java/io/InputStream:close	()V
    //   697: aload 11
    //   699: invokevirtual 468	java/net/HttpURLConnection:disconnect	()V
    //   702: aload 7
    //   704: iload 9
    //   706: aload_1
    //   707: invokevirtual 471	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   710: aload 11
    //   712: invokevirtual 475	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   715: iconst_0
    //   716: invokevirtual 394	com/tencent/mobileqq/microapp/b/b:a	(I[BLjava/util/Map;I)V
    //   719: return
    //   720: aload 7
    //   722: iload 9
    //   724: aconst_null
    //   725: aconst_null
    //   726: iconst_0
    //   727: invokevirtual 394	com/tencent/mobileqq/microapp/b/b:a	(I[BLjava/util/Map;I)V
    //   730: return
    //   731: astore_1
    //   732: goto -57 -> 675
    //   735: astore_2
    //   736: aconst_null
    //   737: astore_1
    //   738: goto -207 -> 531
    //   741: astore_1
    //   742: aconst_null
    //   743: astore_0
    //   744: goto -69 -> 675
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	paramString1	String
    //   0	747	1	paramString2	String
    //   0	747	2	paramString3	String
    //   0	747	3	paramJSONObject1	JSONObject
    //   0	747	4	paramJSONObject2	JSONObject
    //   0	747	5	paramString4	String
    //   0	747	6	paramString5	String
    //   0	747	7	paramb	b
    //   0	747	8	paramBoolean	boolean
    //   509	214	9	i	int
    //   645	12	10	j	int
    //   14	697	11	localHttpURLConnection	HttpURLConnection
    //   52	518	12	str1	String
    //   238	237	13	localStringBuffer	java.lang.StringBuffer
    //   269	40	14	str2	String
    //   278	60	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   0	28	193	java/lang/Throwable
    //   32	46	193	java/lang/Throwable
    //   46	151	193	java/lang/Throwable
    //   155	160	193	java/lang/Throwable
    //   160	190	193	java/lang/Throwable
    //   204	226	193	java/lang/Throwable
    //   231	240	193	java/lang/Throwable
    //   245	251	193	java/lang/Throwable
    //   251	349	193	java/lang/Throwable
    //   352	378	193	java/lang/Throwable
    //   381	394	193	java/lang/Throwable
    //   394	485	193	java/lang/Throwable
    //   541	545	193	java/lang/Throwable
    //   545	612	193	java/lang/Throwable
    //   620	640	193	java/lang/Throwable
    //   640	647	193	java/lang/Throwable
    //   653	661	193	java/lang/Throwable
    //   668	672	193	java/lang/Throwable
    //   679	683	193	java/lang/Throwable
    //   683	685	193	java/lang/Throwable
    //   685	719	193	java/lang/Throwable
    //   720	730	193	java/lang/Throwable
    //   496	502	530	java/lang/Throwable
    //   504	511	530	java/lang/Throwable
    //   519	527	530	java/lang/Throwable
    //   496	502	731	finally
    //   504	511	731	finally
    //   519	527	731	finally
    //   533	537	731	finally
    //   485	494	735	java/lang/Throwable
    //   485	494	741	finally
  }
  
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, b paramb, c paramc)
  {
    int i;
    try
    {
      paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
      paramString2.setRequestMethod(paramString1);
      if (!(paramString2 instanceof HttpsURLConnection)) {
        break label267;
      }
      paramString1 = a();
      if (paramString1 == null) {
        break label267;
      }
      paramString1 = paramString1.getSocketFactory();
      ((HttpsURLConnection)paramString2).setSSLSocketFactory(paramString1);
    }
    catch (Exception paramString1)
    {
      paramb.a(-1, null, null, 0);
      return;
    }
    paramString2.setConnectTimeout(i);
    if (paramc == null)
    {
      i = 60000;
      label67:
      paramString2.setReadTimeout(i);
      paramString2.setUseCaches(false);
      if (paramArrayOfString == null) {
        break label152;
      }
      i = 0;
      paramString1 = null;
    }
    for (;;)
    {
      if (i < paramArrayOfString.length) {
        if (i % 2 == 0)
        {
          paramString1 = paramArrayOfString[i];
          break label280;
        }
      }
      label152:
      do
      {
        i = paramc.a;
        break;
        i = paramc.a;
        break label67;
        paramString2.setRequestProperty(paramString1, paramArrayOfString[i]);
        break label280;
        paramString1 = paramString2.getOutputStream();
        paramString1.write(paramArrayOfByte);
        paramString1.flush();
        i = paramString2.getResponseCode();
        if (i == 200)
        {
          paramString1 = paramString2.getInputStream();
          paramArrayOfByte = new ByteArrayOutputStream();
          paramArrayOfString = new byte[1024];
          for (;;)
          {
            int j = paramString1.read(paramArrayOfString);
            if (j == -1) {
              break;
            }
            paramArrayOfByte.write(paramArrayOfString, 0, j);
          }
          paramString1.close();
          paramArrayOfByte.close();
          paramString1.close();
          paramString2.disconnect();
          paramb.a(i, paramArrayOfByte.toByteArray(), paramString2.getHeaderFields(), 0);
          return;
        }
        paramb.a(i, null, null, 0);
        return;
      } while (paramc != null);
      label267:
      i = 60000;
      break;
      label280:
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, b paramb, c paramc)
  {
    HttpURLConnection localHttpURLConnection;
    int i;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
      if (!(localHttpURLConnection instanceof HttpsURLConnection)) {
        break label313;
      }
      paramString1 = a();
      if (paramString1 == null) {
        break label313;
      }
      paramString1 = paramString1.getSocketFactory();
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramString1);
    }
    catch (Exception paramString1)
    {
      label66:
      paramb.a(-1, null, null, 0);
      return;
    }
    localHttpURLConnection.setConnectTimeout(i);
    if (paramc == null)
    {
      i = 60000;
      localHttpURLConnection.setReadTimeout(i);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("charset", "utf-8");
      localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(paramString2.getBytes().length));
      if (paramArrayOfString == null) {
        break label188;
      }
      i = 0;
      paramString1 = null;
    }
    for (;;)
    {
      if (i < paramArrayOfString.length) {
        if (i % 2 == 0)
        {
          paramString1 = paramArrayOfString[i];
          break label326;
        }
      }
      label188:
      do
      {
        i = paramc.a;
        break;
        i = paramc.a;
        break label66;
        localHttpURLConnection.setRequestProperty(paramString1, paramArrayOfString[i]);
        break label326;
        paramString1 = localHttpURLConnection.getOutputStream();
        paramString1.write(paramString2.getBytes());
        paramString1.flush();
        paramString1.close();
        i = localHttpURLConnection.getResponseCode();
        if (i == 200)
        {
          paramString1 = localHttpURLConnection.getInputStream();
          paramString2 = new ByteArrayOutputStream();
          paramArrayOfString = new byte[1024];
          for (;;)
          {
            int j = paramString1.read(paramArrayOfString);
            if (j == -1) {
              break;
            }
            paramString2.write(paramArrayOfString, 0, j);
          }
          paramString1.close();
          paramString2.close();
          paramString1.close();
          localHttpURLConnection.disconnect();
          paramb.a(i, paramString2.toByteArray(), localHttpURLConnection.getHeaderFields(), 0);
          return;
        }
        paramb.a(i, null, null, 0);
        return;
      } while (paramc != null);
      label313:
      i = 60000;
      break;
      label326:
      i += 1;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static void a(String paramString, String[] paramArrayOfString, b paramb, c paramc)
  {
    HttpURLConnection localHttpURLConnection;
    int i;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      if (!(localHttpURLConnection instanceof HttpsURLConnection)) {
        break label255;
      }
      paramString = a();
      if (paramString == null) {
        break label255;
      }
      paramString = paramString.getSocketFactory();
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramString);
    }
    catch (Exception paramString)
    {
      label73:
      paramb.a(-1, null, null, 0);
      return;
    }
    localHttpURLConnection.setConnectTimeout(i);
    if (paramc == null)
    {
      i = 60000;
      localHttpURLConnection.setReadTimeout(i);
      if (paramArrayOfString == null) {
        break label152;
      }
      i = 0;
      paramString = null;
    }
    for (;;)
    {
      if (i < paramArrayOfString.length) {
        if (i % 2 == 0)
        {
          paramString = paramArrayOfString[i];
          break label267;
        }
      }
      label152:
      label255:
      do
      {
        i = paramc.a;
        break;
        i = paramc.a;
        break label73;
        localHttpURLConnection.setRequestProperty(paramString, paramArrayOfString[i]);
        break label267;
        i = localHttpURLConnection.getResponseCode();
        if (i == 200)
        {
          paramString = localHttpURLConnection.getInputStream();
          paramArrayOfString = new ByteArrayOutputStream();
          paramc = new byte[1024];
          for (;;)
          {
            int j = paramString.read(paramc);
            if (j == -1) {
              break;
            }
            paramArrayOfString.write(paramc, 0, j);
          }
          paramString.close();
          paramArrayOfString.close();
          paramString.close();
          localHttpURLConnection.disconnect();
          paramb.a(i, paramArrayOfString.toByteArray(), localHttpURLConnection.getHeaderFields(), 0);
          return;
        }
        paramb.a(i, null, null, 0);
        return;
      } while (paramc != null);
      i = 60000;
      break;
      label267:
      i += 1;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D < 0.5D;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static String[] a(Map paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    String[] arrayOfString = new String[paramMap.size() * 2];
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      arrayOfString[i] = str;
      i += 1;
      arrayOfString[i] = ((String)paramMap.get(str));
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[] a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    String[] arrayOfString = new String[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramJSONArray.optString(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static int b()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public static int b(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(12);
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 499	java/io/File:exists	()Z
    //   16: ifeq +85 -> 101
    //   19: aload_0
    //   20: invokevirtual 576	java/io/File:isDirectory	()Z
    //   23: ifeq +37 -> 60
    //   26: new 79	java/io/IOException
    //   29: dup
    //   30: new 124	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 578
    //   40: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 581	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc_w 583
    //   50: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 584	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 587	java/io/File:canRead	()Z
    //   64: ifne +71 -> 135
    //   67: new 79	java/io/IOException
    //   70: dup
    //   71: new 124	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 578
    //   81: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: invokevirtual 581	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: ldc_w 589
    //   91: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 584	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   100: athrow
    //   101: new 591	java/io/FileNotFoundException
    //   104: dup
    //   105: new 124	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 578
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 581	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: ldc_w 593
    //   125: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokespecial 594	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: new 441	java/io/FileInputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: new 596	java/io/InputStreamReader
    //   147: dup
    //   148: aload_3
    //   149: ldc 164
    //   151: invokespecial 599	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   154: astore_2
    //   155: aload_0
    //   156: invokevirtual 602	java/io/File:length	()J
    //   159: l2i
    //   160: istore_1
    //   161: iload_1
    //   162: sipush 12288
    //   165: if_icmple +100 -> 265
    //   168: sipush 4096
    //   171: newarray char
    //   173: astore_0
    //   174: new 124	java/lang/StringBuilder
    //   177: dup
    //   178: sipush 12288
    //   181: invokespecial 604	java/lang/StringBuilder:<init>	(I)V
    //   184: astore 5
    //   186: aload_2
    //   187: aload_0
    //   188: invokevirtual 607	java/io/InputStreamReader:read	([C)I
    //   191: istore_1
    //   192: iconst_m1
    //   193: iload_1
    //   194: if_icmpeq +42 -> 236
    //   197: aload 5
    //   199: aload_0
    //   200: iconst_0
    //   201: iload_1
    //   202: invokevirtual 610	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: goto -20 -> 186
    //   209: astore_0
    //   210: aload_2
    //   211: astore_0
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 110	java/io/InputStream:close	()V
    //   220: aload 4
    //   222: astore_3
    //   223: aload_0
    //   224: ifnull -214 -> 10
    //   227: aload_0
    //   228: invokevirtual 611	java/io/InputStreamReader:close	()V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: areturn
    //   236: aload 5
    //   238: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_0
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 110	java/io/InputStream:close	()V
    //   250: aload_0
    //   251: astore_3
    //   252: aload_2
    //   253: ifnull -243 -> 10
    //   256: aload_2
    //   257: invokevirtual 611	java/io/InputStreamReader:close	()V
    //   260: aload_0
    //   261: areturn
    //   262: astore_2
    //   263: aload_0
    //   264: areturn
    //   265: iload_1
    //   266: newarray char
    //   268: astore_0
    //   269: new 102	java/lang/String
    //   272: dup
    //   273: aload_0
    //   274: iconst_0
    //   275: aload_2
    //   276: aload_0
    //   277: invokevirtual 607	java/io/InputStreamReader:read	([C)I
    //   280: invokespecial 614	java/lang/String:<init>	([CII)V
    //   283: astore_0
    //   284: goto -42 -> 242
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_3
    //   290: aconst_null
    //   291: astore_2
    //   292: aload_3
    //   293: ifnull +7 -> 300
    //   296: aload_3
    //   297: invokevirtual 110	java/io/InputStream:close	()V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 611	java/io/InputStreamReader:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: astore_3
    //   311: goto -61 -> 250
    //   314: astore_2
    //   315: goto -95 -> 220
    //   318: astore_3
    //   319: goto -19 -> 300
    //   322: astore_2
    //   323: goto -15 -> 308
    //   326: astore_0
    //   327: aconst_null
    //   328: astore_2
    //   329: goto -37 -> 292
    //   332: astore_0
    //   333: goto -41 -> 292
    //   336: astore_0
    //   337: aconst_null
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_3
    //   341: goto -129 -> 212
    //   344: astore_0
    //   345: aconst_null
    //   346: astore_0
    //   347: goto -135 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramFile	File
    //   160	106	1	i	int
    //   154	103	2	localInputStreamReader	java.io.InputStreamReader
    //   262	14	2	localException1	Exception
    //   291	14	2	localObject1	Object
    //   314	1	2	localException2	Exception
    //   322	1	2	localException3	Exception
    //   328	1	2	localObject2	Object
    //   9	288	3	localObject3	Object
    //   310	1	3	localException4	Exception
    //   318	1	3	localException5	Exception
    //   340	1	3	localObject4	Object
    //   1	220	4	localObject5	Object
    //   184	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   155	161	209	java/lang/Exception
    //   168	186	209	java/lang/Exception
    //   186	192	209	java/lang/Exception
    //   197	206	209	java/lang/Exception
    //   236	242	209	java/lang/Exception
    //   265	284	209	java/lang/Exception
    //   227	231	233	java/lang/Exception
    //   256	260	262	java/lang/Exception
    //   135	144	287	finally
    //   246	250	310	java/lang/Exception
    //   216	220	314	java/lang/Exception
    //   296	300	318	java/lang/Exception
    //   304	308	322	java/lang/Exception
    //   144	155	326	finally
    //   155	161	332	finally
    //   168	186	332	finally
    //   186	192	332	finally
    //   197	206	332	finally
    //   236	242	332	finally
    //   265	284	332	finally
    //   135	144	336	java/lang/Exception
    //   144	155	344	java/lang/Exception
  }
  
  public static Map b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = Uri.parse("file:///" + paramString);
    Iterator localIterator = paramString.getQueryParameterNames().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramString.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public static JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    return a(paramString, paramJSONObject, null);
  }
  
  public static void b(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(R.anim.a, R.anim.d);
    }
  }
  
  public static void b(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        b((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static int c(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(1);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static JSONObject c(Map paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, a((List)paramMap.get(str)));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONObject;
  }
  
  public static int d(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(2);
  }
  
  public static long d(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static JSONObject d(Map paramMap)
  {
    return c(paramMap);
  }
  
  public static int e(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(5);
  }
  
  public static Date e(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Date f(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int[] g(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        label65:
        i += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label65;
      }
    }
  }
  
  public static int h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    String str = paramString;
    if (paramString.length() == 7) {
      str = "#FF" + paramString.substring(1);
    }
    return Color.parseColor(str);
  }
  
  /* Error */
  public static Bitmap i(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 719	bdje:a	(Ljava/lang/String;)Z
    //   6: ifeq +7 -> 13
    //   9: aload_2
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: new 441	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 720	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: new 722	java/io/BufferedInputStream
    //   25: dup
    //   26: aload_0
    //   27: sipush 8192
    //   30: invokespecial 725	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 731	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 732	java/io/FileInputStream:close	()V
    //   49: aload_2
    //   50: astore_0
    //   51: aload_1
    //   52: ifnull -41 -> 11
    //   55: aload_1
    //   56: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_1
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 732	java/io/FileInputStream:close	()V
    //   81: aload_2
    //   82: astore_0
    //   83: aload_1
    //   84: ifnull -73 -> 11
    //   87: aload_1
    //   88: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 732	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: astore_0
    //   115: aload_1
    //   116: ifnull -105 -> 11
    //   119: aload_1
    //   120: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 732	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -29 -> 137
    //   169: astore_2
    //   170: goto -33 -> 137
    //   173: astore_1
    //   174: aconst_null
    //   175: astore_1
    //   176: goto -71 -> 105
    //   179: astore_3
    //   180: goto -75 -> 105
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -113 -> 73
    //   189: astore_3
    //   190: goto -117 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString	String
    //   33	133	1	localBufferedInputStream	java.io.BufferedInputStream
    //   173	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   175	1	1	localObject1	Object
    //   183	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   185	1	1	localObject2	Object
    //   1	113	2	localObject3	Object
    //   132	22	2	localObject4	Object
    //   163	1	2	localObject5	Object
    //   169	1	2	localObject6	Object
    //   38	2	3	localBitmap	Bitmap
    //   179	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   189	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   45	49	61	java/io/IOException
    //   55	59	61	java/io/IOException
    //   13	22	68	java/lang/OutOfMemoryError
    //   77	81	93	java/io/IOException
    //   87	91	93	java/io/IOException
    //   13	22	100	java/io/FileNotFoundException
    //   109	113	125	java/io/IOException
    //   119	123	125	java/io/IOException
    //   13	22	132	finally
    //   141	145	155	java/io/IOException
    //   149	153	155	java/io/IOException
    //   22	34	163	finally
    //   34	39	169	finally
    //   22	34	173	java/io/FileNotFoundException
    //   34	39	179	java/io/FileNotFoundException
    //   22	34	183	java/lang/OutOfMemoryError
    //   34	39	189	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream j(String paramString)
  {
    // Byte code:
    //   0: new 293	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 499	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 441	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: new 722	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: sipush 8192
    //   35: invokespecial 725	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: astore_3
    //   39: new 462	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 463	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore_0
    //   47: aload_3
    //   48: astore 6
    //   50: aload_0
    //   51: astore 5
    //   53: aload_2
    //   54: astore 4
    //   56: sipush 1024
    //   59: newarray byte
    //   61: astore 7
    //   63: aload_3
    //   64: astore 6
    //   66: aload_0
    //   67: astore 5
    //   69: aload_2
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: invokevirtual 736	java/io/BufferedInputStream:read	([B)I
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_m1
    //   81: if_icmpeq +72 -> 153
    //   84: aload_3
    //   85: astore 6
    //   87: aload_0
    //   88: astore 5
    //   90: aload_2
    //   91: astore 4
    //   93: aload_0
    //   94: aload 7
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 464	java/io/ByteArrayOutputStream:write	([BII)V
    //   101: goto -38 -> 63
    //   104: astore 7
    //   106: aload_3
    //   107: astore 6
    //   109: aload_0
    //   110: astore 5
    //   112: aload_2
    //   113: astore 4
    //   115: aload 7
    //   117: invokevirtual 737	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   136: aload_2
    //   137: ifnull -121 -> 16
    //   140: aload_2
    //   141: invokevirtual 732	java/io/FileInputStream:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: aload_3
    //   154: astore 6
    //   156: aload_0
    //   157: astore 5
    //   159: aload_2
    //   160: astore 4
    //   162: new 739	java/io/ByteArrayInputStream
    //   165: dup
    //   166: aload_0
    //   167: invokevirtual 471	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   170: invokespecial 741	java/io/ByteArrayInputStream:<init>	([B)V
    //   173: astore 7
    //   175: aload_0
    //   176: ifnull +7 -> 183
    //   179: aload_0
    //   180: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 732	java/io/FileInputStream:close	()V
    //   199: aload 7
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   207: goto -8 -> 199
    //   210: astore 7
    //   212: aconst_null
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_3
    //   219: astore 6
    //   221: aload_0
    //   222: astore 5
    //   224: aload_2
    //   225: astore 4
    //   227: aload 7
    //   229: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   240: aload_3
    //   241: ifnull +7 -> 248
    //   244: aload_3
    //   245: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   248: aload_2
    //   249: ifnull -233 -> 16
    //   252: aload_2
    //   253: invokevirtual 732	java/io/FileInputStream:close	()V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   263: aconst_null
    //   264: areturn
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_3
    //   268: aconst_null
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_2
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   283: aload_3
    //   284: ifnull +7 -> 291
    //   287: aload_3
    //   288: invokevirtual 733	java/io/BufferedInputStream:close	()V
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 732	java/io/FileInputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   306: goto -7 -> 299
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_3
    //   312: aconst_null
    //   313: astore 5
    //   315: goto -42 -> 273
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 5
    //   322: goto -49 -> 273
    //   325: astore_0
    //   326: aload 6
    //   328: astore_3
    //   329: aload 4
    //   331: astore_2
    //   332: goto -59 -> 273
    //   335: astore 7
    //   337: aconst_null
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -123 -> 218
    //   344: astore 7
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -130 -> 218
    //   351: astore 7
    //   353: goto -135 -> 218
    //   356: astore 7
    //   358: aconst_null
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -258 -> 106
    //   367: astore 7
    //   369: aconst_null
    //   370: astore_3
    //   371: aconst_null
    //   372: astore_0
    //   373: goto -267 -> 106
    //   376: astore 7
    //   378: aconst_null
    //   379: astore_0
    //   380: goto -274 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramString	String
    //   78	20	1	i	int
    //   26	270	2	localFileInputStream1	java.io.FileInputStream
    //   301	2	2	localIOException1	IOException
    //   331	33	2	localObject1	Object
    //   38	333	3	localObject2	Object
    //   54	276	4	localFileInputStream2	java.io.FileInputStream
    //   51	270	5	str	String
    //   48	279	6	localObject3	Object
    //   61	34	7	arrayOfByte	byte[]
    //   104	12	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   173	27	7	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   210	18	7	localIOException2	IOException
    //   335	1	7	localIOException3	IOException
    //   344	1	7	localIOException4	IOException
    //   351	1	7	localIOException5	IOException
    //   356	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   367	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   376	1	7	localFileNotFoundException4	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   56	63	104	java/io/FileNotFoundException
    //   72	79	104	java/io/FileNotFoundException
    //   93	101	104	java/io/FileNotFoundException
    //   162	175	104	java/io/FileNotFoundException
    //   124	128	146	java/io/IOException
    //   132	136	146	java/io/IOException
    //   140	144	146	java/io/IOException
    //   179	183	202	java/io/IOException
    //   187	191	202	java/io/IOException
    //   195	199	202	java/io/IOException
    //   18	27	210	java/io/IOException
    //   236	240	258	java/io/IOException
    //   244	248	258	java/io/IOException
    //   252	256	258	java/io/IOException
    //   18	27	265	finally
    //   278	283	301	java/io/IOException
    //   287	291	301	java/io/IOException
    //   295	299	301	java/io/IOException
    //   27	39	309	finally
    //   39	47	318	finally
    //   56	63	325	finally
    //   72	79	325	finally
    //   93	101	325	finally
    //   115	120	325	finally
    //   162	175	325	finally
    //   227	232	325	finally
    //   27	39	335	java/io/IOException
    //   39	47	344	java/io/IOException
    //   56	63	351	java/io/IOException
    //   72	79	351	java/io/IOException
    //   93	101	351	java/io/IOException
    //   162	175	351	java/io/IOException
    //   18	27	356	java/io/FileNotFoundException
    //   27	39	367	java/io/FileNotFoundException
    //   39	47	376	java/io/FileNotFoundException
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream k(String paramString)
  {
    // Byte code:
    //   0: new 293	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 294	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 441	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore 5
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_0
    //   28: aload 5
    //   30: invokevirtual 743	java/io/FileInputStream:read	([B)I
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_m1
    //   36: if_icmpne +106 -> 142
    //   39: aload_3
    //   40: iconst_0
    //   41: aload_3
    //   42: arraylength
    //   43: invokestatic 747	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   46: getstatic 49	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: iconst_1
    //   50: invokevirtual 751	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   53: astore 6
    //   55: aload 6
    //   57: iconst_1
    //   58: invokevirtual 754	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   61: new 462	java/io/ByteArrayOutputStream
    //   64: dup
    //   65: invokespecial 463	java/io/ByteArrayOutputStream:<init>	()V
    //   68: astore 5
    //   70: aload 5
    //   72: astore 4
    //   74: aload_0
    //   75: astore_3
    //   76: aload 6
    //   78: getstatic 760	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   81: bipush 100
    //   83: aload 5
    //   85: invokevirtual 764	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   88: pop
    //   89: aload 5
    //   91: astore 4
    //   93: aload_0
    //   94: astore_3
    //   95: new 739	java/io/ByteArrayInputStream
    //   98: dup
    //   99: aload 5
    //   101: invokevirtual 471	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   104: invokespecial 741	java/io/ByteArrayInputStream:<init>	([B)V
    //   107: astore 6
    //   109: aload 5
    //   111: ifnull +8 -> 119
    //   114: aload 5
    //   116: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   119: iconst_0
    //   120: ifeq +11 -> 131
    //   123: new 766	java/lang/NullPointerException
    //   126: dup
    //   127: invokespecial 767	java/lang/NullPointerException:<init>	()V
    //   130: athrow
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 732	java/io/FileInputStream:close	()V
    //   139: aload 6
    //   141: areturn
    //   142: aload_3
    //   143: ifnonnull +40 -> 183
    //   146: iconst_0
    //   147: istore_1
    //   148: iload_1
    //   149: iload_2
    //   150: iadd
    //   151: newarray byte
    //   153: astore 4
    //   155: aload_3
    //   156: ifnull +33 -> 189
    //   159: aload_3
    //   160: iconst_0
    //   161: aload 4
    //   163: iconst_0
    //   164: aload_3
    //   165: arraylength
    //   166: invokestatic 773	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   169: aload 5
    //   171: iconst_0
    //   172: aload 4
    //   174: aload_3
    //   175: arraylength
    //   176: iload_2
    //   177: invokestatic 773	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   180: goto +321 -> 501
    //   183: aload_3
    //   184: arraylength
    //   185: istore_1
    //   186: goto -38 -> 148
    //   189: aload 5
    //   191: iconst_0
    //   192: aload 4
    //   194: iconst_0
    //   195: iload_2
    //   196: invokestatic 773	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   199: goto +302 -> 501
    //   202: astore 6
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 5
    //   209: astore 4
    //   211: aload_0
    //   212: astore_3
    //   213: aload 6
    //   215: invokevirtual 737	java/io/FileNotFoundException:printStackTrace	()V
    //   218: aload 5
    //   220: ifnull +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   228: iconst_0
    //   229: ifeq +11 -> 240
    //   232: new 766	java/lang/NullPointerException
    //   235: dup
    //   236: invokespecial 767	java/lang/NullPointerException:<init>	()V
    //   239: athrow
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 732	java/io/FileInputStream:close	()V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_0
    //   251: aload_0
    //   252: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   255: aload 6
    //   257: areturn
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   263: goto -15 -> 248
    //   266: astore_0
    //   267: aconst_null
    //   268: astore 5
    //   270: aconst_null
    //   271: astore_0
    //   272: aload 5
    //   274: astore 4
    //   276: aload_0
    //   277: astore_3
    //   278: invokestatic 776	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +19 -> 300
    //   284: aload 5
    //   286: astore 4
    //   288: aload_0
    //   289: astore_3
    //   290: ldc_w 778
    //   293: iconst_2
    //   294: ldc_w 780
    //   297: invokestatic 784	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload 5
    //   302: ifnull +8 -> 310
    //   305: aload 5
    //   307: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   310: iconst_0
    //   311: ifeq +11 -> 322
    //   314: new 766	java/lang/NullPointerException
    //   317: dup
    //   318: invokespecial 767	java/lang/NullPointerException:<init>	()V
    //   321: athrow
    //   322: aload_0
    //   323: ifnull +7 -> 330
    //   326: aload_0
    //   327: invokevirtual 732	java/io/FileInputStream:close	()V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_0
    //   333: aload_0
    //   334: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   337: goto -7 -> 330
    //   340: astore 6
    //   342: aconst_null
    //   343: astore 5
    //   345: aconst_null
    //   346: astore_0
    //   347: aload 5
    //   349: astore 4
    //   351: aload_0
    //   352: astore_3
    //   353: aload 6
    //   355: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   358: aload 5
    //   360: ifnull +8 -> 368
    //   363: aload 5
    //   365: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   368: iconst_0
    //   369: ifeq +11 -> 380
    //   372: new 766	java/lang/NullPointerException
    //   375: dup
    //   376: invokespecial 767	java/lang/NullPointerException:<init>	()V
    //   379: athrow
    //   380: aload_0
    //   381: ifnull -133 -> 248
    //   384: aload_0
    //   385: invokevirtual 732	java/io/FileInputStream:close	()V
    //   388: goto -140 -> 248
    //   391: astore_0
    //   392: aload_0
    //   393: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   396: goto -148 -> 248
    //   399: astore 5
    //   401: aconst_null
    //   402: astore 4
    //   404: aconst_null
    //   405: astore_0
    //   406: aload 4
    //   408: ifnull +8 -> 416
    //   411: aload 4
    //   413: invokevirtual 465	java/io/ByteArrayOutputStream:close	()V
    //   416: iconst_0
    //   417: ifeq +11 -> 428
    //   420: new 766	java/lang/NullPointerException
    //   423: dup
    //   424: invokespecial 767	java/lang/NullPointerException:<init>	()V
    //   427: athrow
    //   428: aload_0
    //   429: ifnull +7 -> 436
    //   432: aload_0
    //   433: invokevirtual 732	java/io/FileInputStream:close	()V
    //   436: aload 5
    //   438: athrow
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   444: goto -8 -> 436
    //   447: astore 5
    //   449: aconst_null
    //   450: astore 4
    //   452: goto -46 -> 406
    //   455: astore 5
    //   457: aload_3
    //   458: astore_0
    //   459: goto -53 -> 406
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 5
    //   467: goto -120 -> 347
    //   470: astore 6
    //   472: goto -125 -> 347
    //   475: astore_3
    //   476: aconst_null
    //   477: astore 5
    //   479: goto -207 -> 272
    //   482: astore_3
    //   483: goto -211 -> 272
    //   486: astore 6
    //   488: aconst_null
    //   489: astore 5
    //   491: aconst_null
    //   492: astore_0
    //   493: goto -286 -> 207
    //   496: astore 6
    //   498: goto -291 -> 207
    //   501: aload 4
    //   503: astore_3
    //   504: goto -477 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	paramString	String
    //   147	39	1	i	int
    //   33	163	2	j	int
    //   26	432	3	localObject1	Object
    //   475	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   482	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   503	1	3	localObject2	Object
    //   72	430	4	localObject3	Object
    //   23	341	5	localObject4	Object
    //   399	38	5	localObject5	Object
    //   447	1	5	localObject6	Object
    //   455	1	5	localObject7	Object
    //   465	25	5	localObject8	Object
    //   53	87	6	localObject9	Object
    //   202	54	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   340	14	6	localIOException1	IOException
    //   462	1	6	localIOException2	IOException
    //   470	1	6	localIOException3	IOException
    //   486	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   496	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   18	25	202	java/io/FileNotFoundException
    //   27	34	202	java/io/FileNotFoundException
    //   39	70	202	java/io/FileNotFoundException
    //   148	155	202	java/io/FileNotFoundException
    //   159	180	202	java/io/FileNotFoundException
    //   183	186	202	java/io/FileNotFoundException
    //   189	199	202	java/io/FileNotFoundException
    //   114	119	250	java/io/IOException
    //   123	131	250	java/io/IOException
    //   135	139	250	java/io/IOException
    //   223	228	258	java/io/IOException
    //   232	240	258	java/io/IOException
    //   244	248	258	java/io/IOException
    //   9	18	266	java/lang/OutOfMemoryError
    //   305	310	332	java/io/IOException
    //   314	322	332	java/io/IOException
    //   326	330	332	java/io/IOException
    //   9	18	340	java/io/IOException
    //   363	368	391	java/io/IOException
    //   372	380	391	java/io/IOException
    //   384	388	391	java/io/IOException
    //   9	18	399	finally
    //   411	416	439	java/io/IOException
    //   420	428	439	java/io/IOException
    //   432	436	439	java/io/IOException
    //   18	25	447	finally
    //   27	34	447	finally
    //   39	70	447	finally
    //   148	155	447	finally
    //   159	180	447	finally
    //   183	186	447	finally
    //   189	199	447	finally
    //   76	89	455	finally
    //   95	109	455	finally
    //   213	218	455	finally
    //   278	284	455	finally
    //   290	300	455	finally
    //   353	358	455	finally
    //   18	25	462	java/io/IOException
    //   27	34	462	java/io/IOException
    //   39	70	462	java/io/IOException
    //   148	155	462	java/io/IOException
    //   159	180	462	java/io/IOException
    //   183	186	462	java/io/IOException
    //   189	199	462	java/io/IOException
    //   76	89	470	java/io/IOException
    //   95	109	470	java/io/IOException
    //   18	25	475	java/lang/OutOfMemoryError
    //   27	34	475	java/lang/OutOfMemoryError
    //   39	70	475	java/lang/OutOfMemoryError
    //   148	155	475	java/lang/OutOfMemoryError
    //   159	180	475	java/lang/OutOfMemoryError
    //   183	186	475	java/lang/OutOfMemoryError
    //   189	199	475	java/lang/OutOfMemoryError
    //   76	89	482	java/lang/OutOfMemoryError
    //   95	109	482	java/lang/OutOfMemoryError
    //   9	18	486	java/io/FileNotFoundException
    //   76	89	496	java/io/FileNotFoundException
    //   95	109	496	java/io/FileNotFoundException
  }
  
  private static String l(String paramString)
  {
    if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
      return "image/jpg";
    }
    if (paramString.endsWith(".png")) {
      return "image/png";
    }
    return "application/octet-stream";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.b.a
 * JD-Core Version:    0.7.0.1
 */