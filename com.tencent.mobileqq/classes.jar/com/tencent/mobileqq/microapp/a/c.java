package com.tencent.mobileqq.microapp.a;

import Wallet.ApkgConfig;
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
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.g.a;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.apkg.k.a;
import com.tencent.mobileqq.microapp.widget.media.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  public String a;
  public com.tencent.mobileqq.microapp.widget.g b;
  public String c;
  public String d;
  public String e;
  public MiniAppConfig f;
  public String g;
  public String h;
  private String i;
  private Map j;
  private int k;
  private float l;
  private byte m;
  
  public static Bitmap a(Drawable paramDrawable)
  {
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
      localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 87	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 93	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 98	java/io/InputStream:available	()I
    //   15: newarray byte
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 102	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: new 104	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: ldc 106
    //   35: invokespecial 109	java/lang/String:<init>	([BLjava/lang/String;)V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 112	java/io/InputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_2
    //   50: goto +12 -> 62
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_0
    //   56: goto +23 -> 79
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 112	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 112	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: athrow
    //   89: astore_0
    //   90: aload_2
    //   91: areturn
    //   92: astore_0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: goto -9 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	android.content.Context
    //   0	99	1	paramString	String
    //   17	31	2	localObject	Object
    //   49	1	2	localException1	Exception
    //   59	32	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   11	18	49	java/lang/Exception
    //   20	26	49	java/lang/Exception
    //   28	39	49	java/lang/Exception
    //   0	9	53	finally
    //   0	9	59	java/lang/Exception
    //   11	18	78	finally
    //   20	26	78	finally
    //   28	39	78	finally
    //   64	68	78	finally
    //   43	47	89	java/io/IOException
    //   72	76	92	java/io/IOException
    //   83	87	95	java/io/IOException
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
    String str = paramString;
    if (paramString != null)
    {
      int i1 = paramString.indexOf("?");
      int n = i1;
      if (i1 == -1) {
        n = paramString.length();
      }
      str = paramString.substring(0, n);
    }
    return str;
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    JSONArray localJSONArray = new JSONArray();
    int i2 = 0;
    int n = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (n >= paramJSONArray1.length()) {
        break;
      }
      localJSONArray.put(paramJSONArray1.get(n));
      n += 1;
    }
    while (i1 < paramJSONArray2.length())
    {
      localJSONArray.put(paramJSONArray2.get(i1));
      i1 += 1;
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
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = localJSONObject;
      StringBuilder localStringBuilder = new StringBuilder();
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString);
      paramJSONObject = localJSONObject;
      localStringBuilder.append(":ok");
      paramJSONObject = localJSONObject;
      localJSONObject.put("errMsg", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (Exception paramString) {}
    return paramJSONObject;
  }
  
  public static JSONObject a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramJSONObject;
      if (paramJSONObject == null) {
        paramString1 = new JSONObject();
      }
      return paramString1;
    }
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      paramJSONObject = localJSONObject;
      StringBuilder localStringBuilder = new StringBuilder();
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString1);
      paramJSONObject = localJSONObject;
      localStringBuilder.append(":fail");
      paramJSONObject = localJSONObject;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = "";
      }
      else
      {
        paramJSONObject = localJSONObject;
        paramString1 = new StringBuilder();
        paramJSONObject = localJSONObject;
        paramString1.append(" ");
        paramJSONObject = localJSONObject;
        paramString1.append(paramString2);
        paramJSONObject = localJSONObject;
        paramString1 = paramString1.toString();
      }
      paramJSONObject = localJSONObject;
      localStringBuilder.append(paramString1);
      paramJSONObject = localJSONObject;
      localJSONObject.put("errMsg", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (Exception paramString1) {}
    return paramJSONObject;
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
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    paramWebView.evaluateJavascript(paramString, null);
  }
  
  private static void a(File paramFile, byte[] paramArrayOfByte)
  {
    if ((!paramFile.getParentFile().exists()) && (!paramFile.getParentFile().mkdirs()))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Create folder fail:");
      paramArrayOfByte.append(paramFile.getParentFile().getAbsolutePath());
      throw new RuntimeException(paramArrayOfByte.toString());
    }
    paramFile = new FileOutputStream(paramFile);
    try
    {
      paramFile.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static void a(String paramString, com.tencent.mobileqq.microapp.widget.media.c paramc)
  {
    new b(paramc).execute(new String[] { paramString });
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int i1 = arrayOfFile.length;
    int n = 0;
    while (n < i1)
    {
      a(arrayOfFile[n].getAbsolutePath(), paramBoolean);
      n += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  public static void a(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        localObject2 = (Map)localObject2;
        a((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  public static boolean a(c paramc)
  {
    if (paramc != null)
    {
      paramc = paramc.f;
      if (paramc != null) {
        return paramc.isInnerUser();
      }
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramString1, paramString2, "");
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        boolean bool = new File(paramString2, paramString3).exists();
        if (bool) {
          return true;
        }
        bool = c(paramString1, paramString2, paramString3);
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 229	java/io/File:exists	()Z
    //   13: ifeq +291 -> 304
    //   16: aload_0
    //   17: invokevirtual 335	java/io/File:isDirectory	()Z
    //   20: ifne +242 -> 262
    //   23: aload_0
    //   24: invokevirtual 338	java/io/File:canRead	()Z
    //   27: ifeq +193 -> 220
    //   30: new 340	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 343	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc_w 345
    //   47: invokespecial 348	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_0
    //   52: invokevirtual 351	java/io/File:length	()J
    //   55: l2i
    //   56: istore_1
    //   57: iload_1
    //   58: sipush 12288
    //   61: if_icmple +53 -> 114
    //   64: sipush 4096
    //   67: newarray char
    //   69: astore_0
    //   70: new 162	java/lang/StringBuilder
    //   73: dup
    //   74: sipush 12288
    //   77: invokespecial 354	java/lang/StringBuilder:<init>	(I)V
    //   80: astore 5
    //   82: aload_2
    //   83: aload_0
    //   84: invokevirtual 357	java/io/InputStreamReader:read	([C)I
    //   87: istore_1
    //   88: iconst_m1
    //   89: iload_1
    //   90: if_icmpeq +15 -> 105
    //   93: aload 5
    //   95: aload_0
    //   96: iconst_0
    //   97: iload_1
    //   98: invokevirtual 360	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: goto -20 -> 82
    //   105: aload 5
    //   107: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_0
    //   111: goto +22 -> 133
    //   114: iload_1
    //   115: newarray char
    //   117: astore_0
    //   118: new 104	java/lang/String
    //   121: dup
    //   122: aload_0
    //   123: iconst_0
    //   124: aload_2
    //   125: aload_0
    //   126: invokevirtual 357	java/io/InputStreamReader:read	([C)I
    //   129: invokespecial 363	java/lang/String:<init>	([CII)V
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 112	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_2
    //   140: invokevirtual 364	java/io/InputStreamReader:close	()V
    //   143: aload_3
    //   144: areturn
    //   145: astore_0
    //   146: goto +24 -> 170
    //   149: aload_2
    //   150: astore_0
    //   151: goto +44 -> 195
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_2
    //   157: goto +13 -> 170
    //   160: aconst_null
    //   161: astore_0
    //   162: goto +33 -> 195
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore_2
    //   170: aload_3
    //   171: ifnull +10 -> 181
    //   174: aload_3
    //   175: invokevirtual 112	java/io/InputStream:close	()V
    //   178: goto +3 -> 181
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 364	java/io/InputStreamReader:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: aconst_null
    //   192: astore_3
    //   193: aload_3
    //   194: astore_0
    //   195: aload_3
    //   196: ifnull +10 -> 206
    //   199: aload_3
    //   200: invokevirtual 112	java/io/InputStream:close	()V
    //   203: goto +3 -> 206
    //   206: aload_0
    //   207: ifnull +11 -> 218
    //   210: aload 4
    //   212: astore_3
    //   213: aload_0
    //   214: astore_2
    //   215: goto -76 -> 139
    //   218: aconst_null
    //   219: areturn
    //   220: new 162	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload_2
    //   229: ldc_w 366
    //   232: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: ldc_w 371
    //   246: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: new 81	java/io/IOException
    //   253: dup
    //   254: aload_2
    //   255: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokespecial 372	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: new 162	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 366
    //   274: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload_0
    //   280: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: ldc_w 374
    //   288: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 81	java/io/IOException
    //   295: dup
    //   296: aload_2
    //   297: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 372	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: new 162	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   311: astore_2
    //   312: aload_2
    //   313: ldc_w 366
    //   316: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: aload_0
    //   322: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: ldc_w 376
    //   330: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: new 378	java/io/FileNotFoundException
    //   337: dup
    //   338: aload_2
    //   339: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 379	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   345: astore_0
    //   346: goto +5 -> 351
    //   349: aload_0
    //   350: athrow
    //   351: goto -2 -> 349
    //   354: astore_0
    //   355: goto -164 -> 191
    //   358: astore_0
    //   359: goto -199 -> 160
    //   362: astore_0
    //   363: goto -214 -> 149
    //   366: astore_3
    //   367: aload_0
    //   368: astore_3
    //   369: goto -230 -> 139
    //   372: astore_0
    //   373: aload_3
    //   374: areturn
    //   375: astore_3
    //   376: goto -195 -> 181
    //   379: astore_2
    //   380: goto -191 -> 189
    //   383: astore_2
    //   384: goto -178 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramFile	File
    //   56	59	1	n	int
    //   50	289	2	localObject1	Object
    //   379	1	2	localException1	Exception
    //   383	1	2	localException2	Exception
    //   38	175	3	localObject2	Object
    //   366	1	3	localException3	Exception
    //   368	6	3	localFile	File
    //   375	1	3	localException4	Exception
    //   1	210	4	localObject3	Object
    //   80	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	57	145	finally
    //   64	82	145	finally
    //   82	88	145	finally
    //   93	102	145	finally
    //   105	111	145	finally
    //   114	133	145	finally
    //   39	51	154	finally
    //   30	39	165	finally
    //   30	39	354	java/lang/Exception
    //   39	51	358	java/lang/Exception
    //   51	57	362	java/lang/Exception
    //   64	82	362	java/lang/Exception
    //   82	88	362	java/lang/Exception
    //   93	102	362	java/lang/Exception
    //   105	111	362	java/lang/Exception
    //   114	133	362	java/lang/Exception
    //   133	137	366	java/lang/Exception
    //   139	143	372	java/lang/Exception
    //   174	178	375	java/lang/Exception
    //   185	189	379	java/lang/Exception
    //   199	203	383	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str2 = "";
    str1 = str2;
    try
    {
      List localList = URLEncodedUtils.parse(new URI(paramString1), "UTF-8");
      str1 = str2;
      int i1 = localList.size();
      int n = 0;
      for (paramString1 = str2;; paramString1 = str2)
      {
        str1 = paramString1;
        if (n >= i1) {
          break;
        }
        str1 = paramString1;
        NameValuePair localNameValuePair = (NameValuePair)localList.get(n);
        str2 = paramString1;
        str1 = paramString1;
        if (localNameValuePair.getName().equals(paramString2))
        {
          str1 = paramString1;
          str2 = localNameValuePair.getValue();
        }
        n += 1;
      }
      return str1;
    }
    catch (URISyntaxException paramString1)
    {
      paramString1.printStackTrace();
    }
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
  
  /* Error */
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +407 -> 411
    //   7: aload_1
    //   8: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_2
    //   17: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +47 -> 67
    //   23: new 162	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   30: astore 7
    //   32: aload 7
    //   34: new 211	java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 7
    //   51: ldc_w 417
    //   54: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 7
    //   60: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: goto +15 -> 79
    //   67: new 211	java/io/File
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: astore_2
    //   79: aconst_null
    //   80: astore 7
    //   82: new 419	java/io/RandomAccessFile
    //   85: dup
    //   86: aload_0
    //   87: ldc_w 421
    //   90: invokespecial 422	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 426	java/io/RandomAccessFile:readByte	()B
    //   98: bipush 190
    //   100: if_icmpne +268 -> 368
    //   103: aload_0
    //   104: ldc2_w 427
    //   107: invokevirtual 432	java/io/RandomAccessFile:seek	(J)V
    //   110: aload_0
    //   111: invokevirtual 435	java/io/RandomAccessFile:readInt	()I
    //   114: istore 4
    //   116: new 437	java/util/ArrayList
    //   119: dup
    //   120: iload 4
    //   122: invokespecial 438	java/util/ArrayList:<init>	(I)V
    //   125: astore 9
    //   127: iconst_0
    //   128: istore_3
    //   129: iload_3
    //   130: iload 4
    //   132: if_icmpge +147 -> 279
    //   135: aload_0
    //   136: invokevirtual 435	java/io/RandomAccessFile:readInt	()I
    //   139: istore 5
    //   141: iload 5
    //   143: newarray byte
    //   145: astore 7
    //   147: aload_0
    //   148: aload 7
    //   150: iconst_0
    //   151: iload 5
    //   153: invokevirtual 441	java/io/RandomAccessFile:read	([BII)I
    //   156: pop
    //   157: new 211	java/io/File
    //   160: dup
    //   161: new 104	java/lang/String
    //   164: dup
    //   165: aload 7
    //   167: iconst_0
    //   168: iload 5
    //   170: invokespecial 444	java/lang/String:<init>	([BII)V
    //   173: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: invokevirtual 237	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: astore 8
    //   181: aload 8
    //   183: astore 7
    //   185: aload_2
    //   186: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +60 -> 249
    //   192: aload 8
    //   194: aload_2
    //   195: invokevirtual 448	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   198: istore 6
    //   200: iload 6
    //   202: ifne +9 -> 211
    //   205: aload_0
    //   206: invokevirtual 449	java/io/RandomAccessFile:close	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: new 162	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   218: astore 7
    //   220: aload 7
    //   222: aload_2
    //   223: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 7
    //   229: ldc_w 417
    //   232: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 8
    //   238: aload_2
    //   239: aload 7
    //   241: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokevirtual 452	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   247: astore 7
    //   249: aload 9
    //   251: new 454	com/tencent/mobileqq/microapp/a/c$a
    //   254: dup
    //   255: aload 7
    //   257: aload_0
    //   258: invokevirtual 435	java/io/RandomAccessFile:readInt	()I
    //   261: aload_0
    //   262: invokevirtual 435	java/io/RandomAccessFile:readInt	()I
    //   265: invokespecial 457	com/tencent/mobileqq/microapp/a/c$a:<init>	(Ljava/lang/String;II)V
    //   268: invokevirtual 460	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   271: pop
    //   272: iload_3
    //   273: iconst_1
    //   274: iadd
    //   275: istore_3
    //   276: goto -147 -> 129
    //   279: aload 9
    //   281: invokevirtual 461	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   284: astore_2
    //   285: aload_2
    //   286: invokeinterface 291 1 0
    //   291: ifeq +71 -> 362
    //   294: aload_2
    //   295: invokeinterface 295 1 0
    //   300: checkcast 454	com/tencent/mobileqq/microapp/a/c$a
    //   303: astore 7
    //   305: new 211	java/io/File
    //   308: dup
    //   309: aload_1
    //   310: aload 7
    //   312: getfield 463	com/tencent/mobileqq/microapp/a/c$a:a	Ljava/lang/String;
    //   315: invokespecial 330	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: astore 8
    //   320: aload_0
    //   321: aload 7
    //   323: getfield 464	com/tencent/mobileqq/microapp/a/c$a:b	I
    //   326: i2l
    //   327: invokevirtual 432	java/io/RandomAccessFile:seek	(J)V
    //   330: aload 7
    //   332: getfield 465	com/tencent/mobileqq/microapp/a/c$a:c	I
    //   335: newarray byte
    //   337: astore 9
    //   339: aload_0
    //   340: aload 9
    //   342: iconst_0
    //   343: aload 7
    //   345: getfield 465	com/tencent/mobileqq/microapp/a/c$a:c	I
    //   348: invokevirtual 441	java/io/RandomAccessFile:read	([BII)I
    //   351: pop
    //   352: aload 8
    //   354: aload 9
    //   356: invokestatic 467	com/tencent/mobileqq/microapp/a/c:a	(Ljava/io/File;[B)V
    //   359: goto -74 -> 285
    //   362: aload_0
    //   363: invokevirtual 449	java/io/RandomAccessFile:close	()V
    //   366: iconst_1
    //   367: ireturn
    //   368: new 239	java/lang/RuntimeException
    //   371: dup
    //   372: ldc_w 469
    //   375: invokespecial 240	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   378: athrow
    //   379: astore_2
    //   380: aload_0
    //   381: astore_1
    //   382: aload_2
    //   383: astore_0
    //   384: goto +9 -> 393
    //   387: goto +16 -> 403
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull +7 -> 401
    //   397: aload_1
    //   398: invokevirtual 449	java/io/RandomAccessFile:close	()V
    //   401: aload_0
    //   402: athrow
    //   403: aload_0
    //   404: ifnull +7 -> 411
    //   407: aload_0
    //   408: invokevirtual 449	java/io/RandomAccessFile:close	()V
    //   411: iconst_0
    //   412: ireturn
    //   413: astore_0
    //   414: aload 7
    //   416: astore_0
    //   417: goto -14 -> 403
    //   420: astore_1
    //   421: goto -34 -> 387
    //   424: astore_0
    //   425: iconst_0
    //   426: ireturn
    //   427: astore_0
    //   428: goto -62 -> 366
    //   431: astore_1
    //   432: goto -31 -> 401
    //   435: astore_0
    //   436: iconst_0
    //   437: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	paramString1	String
    //   0	438	1	paramString2	String
    //   0	438	2	paramString3	String
    //   128	148	3	n	int
    //   114	19	4	i1	int
    //   139	30	5	i2	int
    //   198	3	6	bool	boolean
    //   30	385	7	localObject1	Object
    //   179	174	8	localObject2	Object
    //   125	230	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   94	127	379	finally
    //   135	181	379	finally
    //   185	200	379	finally
    //   211	249	379	finally
    //   249	272	379	finally
    //   279	285	379	finally
    //   285	359	379	finally
    //   368	379	379	finally
    //   82	94	390	finally
    //   82	94	413	java/lang/Exception
    //   94	127	420	java/lang/Exception
    //   135	181	420	java/lang/Exception
    //   185	200	420	java/lang/Exception
    //   211	249	420	java/lang/Exception
    //   249	272	420	java/lang/Exception
    //   279	285	420	java/lang/Exception
    //   285	359	420	java/lang/Exception
    //   368	379	420	java/lang/Exception
    //   205	209	424	java/lang/Exception
    //   362	366	427	java/lang/Exception
    //   397	401	431	java/lang/Exception
    //   407	411	435	java/lang/Exception
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {
      return false;
    }
    String str = new File(paramString2, paramString3).getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("Tmp");
    localObject = ((StringBuilder)localObject).toString();
    a((String)localObject, false);
    if (!b(paramString1, paramString2, paramString3)) {
      return false;
    }
    paramString1 = new File((String)localObject);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(str);
    a(str, false);
    if (!a(paramString1, paramString2)) {
      return false;
    }
    return paramString2.exists();
  }
  
  public static String l(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///");
    ((StringBuilder)localObject).append(paramString);
    localObject = Uri.parse(((StringBuilder)localObject).toString()).getPath();
    paramString = (String)localObject;
    if (localObject != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).startsWith("/")) {
        paramString = ((String)localObject).substring(1);
      }
    }
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  public static Map m(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///");
    ((StringBuilder)localObject).append(paramString);
    paramString = Uri.parse(((StringBuilder)localObject).toString());
    localObject = paramString.getQueryParameterNames().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localHashMap.put(str, paramString.getQueryParameter(str));
    }
    return localHashMap;
  }
  
  public static String n(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int n = paramString.indexOf("?");
    String str = paramString;
    if (n != -1) {
      str = paramString.substring(0, n);
    }
    return str;
  }
  
  public static int[] o(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int n = 0;
    if (bool) {
      return new int[0];
    }
    paramString = paramString.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
    int[] arrayOfInt = new int[paramString.length];
    for (;;)
    {
      if (n < paramString.length) {}
      try
      {
        arrayOfInt[n] = Integer.parseInt(paramString[n]);
        label67:
        n += 1;
        continue;
        return arrayOfInt;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label67;
      }
    }
  }
  
  public static int p(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Object localObject = paramString;
    if (paramString.length() == 7)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("#FF");
      ((StringBuilder)localObject).append(paramString.substring(1));
      localObject = ((StringBuilder)localObject).toString();
    }
    return Color.parseColor((String)localObject);
  }
  
  /* Error */
  public static Bitmap q(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 540	com/tencent/mobileqq/utils/StringUtil:a	(Ljava/lang/String;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: iload_1
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 340	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 541	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: new 543	java/io/BufferedInputStream
    //   28: dup
    //   29: aload_0
    //   30: sipush 8192
    //   33: invokespecial 546	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokestatic 552	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   41: astore 5
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 553	java/io/FileInputStream:close	()V
    //   50: aload 5
    //   52: astore_3
    //   53: aload_2
    //   54: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   57: aload 5
    //   59: areturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   65: aload_3
    //   66: areturn
    //   67: astore 4
    //   69: aload_2
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload 4
    //   75: astore_0
    //   76: goto +26 -> 102
    //   79: astore 4
    //   81: aload_0
    //   82: astore_2
    //   83: aload 4
    //   85: astore_0
    //   86: goto +16 -> 102
    //   89: aconst_null
    //   90: astore_2
    //   91: goto +43 -> 134
    //   94: aconst_null
    //   95: astore_2
    //   96: goto +62 -> 158
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +10 -> 113
    //   106: aload_2
    //   107: invokevirtual 553	java/io/FileInputStream:close	()V
    //   110: goto +3 -> 113
    //   113: aload_3
    //   114: ifnull +14 -> 128
    //   117: aload_3
    //   118: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   121: goto +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +10 -> 145
    //   138: aload 4
    //   140: astore_3
    //   141: aload_0
    //   142: invokevirtual 553	java/io/FileInputStream:close	()V
    //   145: aload_2
    //   146: ifnull +34 -> 180
    //   149: aload 4
    //   151: astore_3
    //   152: aload_2
    //   153: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: aload_0
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: astore_3
    //   165: aload_0
    //   166: invokevirtual 553	java/io/FileInputStream:close	()V
    //   169: aload_2
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: astore_3
    //   176: aload_2
    //   177: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_0
    //   183: goto +27 -> 210
    //   186: astore_0
    //   187: goto -57 -> 130
    //   190: astore_2
    //   191: goto -97 -> 94
    //   194: astore_2
    //   195: goto -106 -> 89
    //   198: astore_3
    //   199: goto -41 -> 158
    //   202: astore_3
    //   203: goto -69 -> 134
    //   206: astore_2
    //   207: goto -83 -> 124
    //   210: aconst_null
    //   211: astore_2
    //   212: aload_2
    //   213: astore_0
    //   214: goto -56 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramString	String
    //   4	7	1	bool	boolean
    //   36	141	2	localObject1	Object
    //   190	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   194	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   206	1	2	localIOException	IOException
    //   211	2	2	localObject2	Object
    //   6	170	3	localObject3	Object
    //   198	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   202	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   8	1	4	localObject4	Object
    //   67	7	4	localObject5	Object
    //   79	95	4	localObject6	Object
    //   41	17	5	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	50	60	java/io/IOException
    //   53	57	60	java/io/IOException
    //   141	145	60	java/io/IOException
    //   152	156	60	java/io/IOException
    //   165	169	60	java/io/IOException
    //   176	180	60	java/io/IOException
    //   37	43	67	finally
    //   25	37	79	finally
    //   16	25	99	finally
    //   16	25	182	java/lang/OutOfMemoryError
    //   16	25	186	java/io/FileNotFoundException
    //   25	37	190	java/lang/OutOfMemoryError
    //   25	37	194	java/io/FileNotFoundException
    //   37	43	198	java/lang/OutOfMemoryError
    //   37	43	202	java/io/FileNotFoundException
    //   106	110	206	java/io/IOException
    //   117	121	206	java/io/IOException
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream r(String paramString)
  {
    // Byte code:
    //   0: new 211	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 229	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 340	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: new 543	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_0
    //   32: sipush 8192
    //   35: invokespecial 546	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: astore 4
    //   40: new 557	java/io/ByteArrayOutputStream
    //   43: dup
    //   44: invokespecial 558	java/io/ByteArrayOutputStream:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_2
    //   52: aload 6
    //   54: astore_3
    //   55: aload_0
    //   56: astore 5
    //   58: sipush 1024
    //   61: newarray byte
    //   63: astore 7
    //   65: aload 4
    //   67: astore_2
    //   68: aload 6
    //   70: astore_3
    //   71: aload_0
    //   72: astore 5
    //   74: aload 4
    //   76: aload 7
    //   78: invokevirtual 559	java/io/BufferedInputStream:read	([B)I
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_m1
    //   84: if_icmpeq +24 -> 108
    //   87: aload 4
    //   89: astore_2
    //   90: aload 6
    //   92: astore_3
    //   93: aload_0
    //   94: astore 5
    //   96: aload 6
    //   98: aload 7
    //   100: iconst_0
    //   101: iload_1
    //   102: invokevirtual 561	java/io/ByteArrayOutputStream:write	([BII)V
    //   105: goto -40 -> 65
    //   108: aload 4
    //   110: astore_2
    //   111: aload 6
    //   113: astore_3
    //   114: aload_0
    //   115: astore 5
    //   117: new 563	java/io/ByteArrayInputStream
    //   120: dup
    //   121: aload 6
    //   123: invokevirtual 567	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   126: invokespecial 569	java/io/ByteArrayInputStream:<init>	([B)V
    //   129: astore 7
    //   131: aload 6
    //   133: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   136: aload 4
    //   138: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   141: aload_0
    //   142: invokevirtual 553	java/io/FileInputStream:close	()V
    //   145: aload 7
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   153: aload 7
    //   155: areturn
    //   156: astore_2
    //   157: aload 4
    //   159: astore 7
    //   161: aload 6
    //   163: astore 4
    //   165: aload_2
    //   166: astore 6
    //   168: goto +102 -> 270
    //   171: astore_2
    //   172: aload 4
    //   174: astore 7
    //   176: aload 6
    //   178: astore 4
    //   180: aload_2
    //   181: astore 6
    //   183: goto +141 -> 324
    //   186: astore_3
    //   187: aconst_null
    //   188: astore 5
    //   190: aload 4
    //   192: astore_2
    //   193: aload 5
    //   195: astore 4
    //   197: goto +191 -> 388
    //   200: astore 6
    //   202: aconst_null
    //   203: astore_2
    //   204: aload 4
    //   206: astore 7
    //   208: aload_2
    //   209: astore 4
    //   211: goto +59 -> 270
    //   214: astore 6
    //   216: aconst_null
    //   217: astore_2
    //   218: aload 4
    //   220: astore 7
    //   222: aload_2
    //   223: astore 4
    //   225: goto +99 -> 324
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 4
    //   232: aload 4
    //   234: astore_2
    //   235: goto +153 -> 388
    //   238: astore 6
    //   240: goto +24 -> 264
    //   243: astore 6
    //   245: goto +73 -> 318
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_2
    //   251: aload_2
    //   252: astore 4
    //   254: aload 4
    //   256: astore_0
    //   257: goto +131 -> 388
    //   260: astore 6
    //   262: aconst_null
    //   263: astore_0
    //   264: aconst_null
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 4
    //   270: aload 7
    //   272: astore_2
    //   273: aload 4
    //   275: astore_3
    //   276: aload_0
    //   277: astore 5
    //   279: aload 6
    //   281: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   294: aload 7
    //   296: ifnull +8 -> 304
    //   299: aload 7
    //   301: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   304: aload_0
    //   305: ifnull +70 -> 375
    //   308: aload_0
    //   309: invokevirtual 553	java/io/FileInputStream:close	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore 6
    //   316: aconst_null
    //   317: astore_0
    //   318: aconst_null
    //   319: astore 7
    //   321: aconst_null
    //   322: astore 4
    //   324: aload 7
    //   326: astore_2
    //   327: aload 4
    //   329: astore_3
    //   330: aload_0
    //   331: astore 5
    //   333: aload 6
    //   335: invokevirtual 571	java/io/FileNotFoundException:printStackTrace	()V
    //   338: aload 4
    //   340: ifnull +11 -> 351
    //   343: aload 4
    //   345: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   348: goto +3 -> 351
    //   351: aload 7
    //   353: ifnull +8 -> 361
    //   356: aload 7
    //   358: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   361: aload_0
    //   362: ifnull +13 -> 375
    //   365: aload_0
    //   366: invokevirtual 553	java/io/FileInputStream:close	()V
    //   369: aconst_null
    //   370: areturn
    //   371: aload_0
    //   372: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore 6
    //   379: aload 5
    //   381: astore_0
    //   382: aload_3
    //   383: astore 4
    //   385: aload 6
    //   387: astore_3
    //   388: aload 4
    //   390: ifnull +11 -> 401
    //   393: aload 4
    //   395: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   398: goto +3 -> 401
    //   401: aload_2
    //   402: ifnull +7 -> 409
    //   405: aload_2
    //   406: invokevirtual 554	java/io/BufferedInputStream:close	()V
    //   409: aload_0
    //   410: ifnull +14 -> 424
    //   413: aload_0
    //   414: invokevirtual 553	java/io/FileInputStream:close	()V
    //   417: goto +7 -> 424
    //   420: aload_0
    //   421: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   424: goto +5 -> 429
    //   427: aload_3
    //   428: athrow
    //   429: goto -2 -> 427
    //   432: astore_0
    //   433: goto -62 -> 371
    //   436: astore_0
    //   437: goto -17 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramString	String
    //   81	21	1	n	int
    //   51	60	2	localObject1	Object
    //   156	10	2	localIOException1	IOException
    //   171	10	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   192	214	2	localObject2	Object
    //   54	60	3	localObject3	Object
    //   186	1	3	localObject4	Object
    //   228	1	3	localObject5	Object
    //   248	1	3	localObject6	Object
    //   275	153	3	localObject7	Object
    //   38	356	4	localObject8	Object
    //   56	324	5	str	String
    //   47	135	6	localObject9	Object
    //   200	1	6	localIOException2	IOException
    //   214	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   238	1	6	localIOException3	IOException
    //   243	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   260	20	6	localIOException4	IOException
    //   314	20	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   377	9	6	localObject10	Object
    //   63	294	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   131	145	148	java/io/IOException
    //   58	65	156	java/io/IOException
    //   74	82	156	java/io/IOException
    //   96	105	156	java/io/IOException
    //   117	131	156	java/io/IOException
    //   58	65	171	java/io/FileNotFoundException
    //   74	82	171	java/io/FileNotFoundException
    //   96	105	171	java/io/FileNotFoundException
    //   117	131	171	java/io/FileNotFoundException
    //   40	49	186	finally
    //   40	49	200	java/io/IOException
    //   40	49	214	java/io/FileNotFoundException
    //   27	40	228	finally
    //   27	40	238	java/io/IOException
    //   27	40	243	java/io/FileNotFoundException
    //   18	27	248	finally
    //   18	27	260	java/io/IOException
    //   18	27	314	java/io/FileNotFoundException
    //   58	65	377	finally
    //   74	82	377	finally
    //   96	105	377	finally
    //   117	131	377	finally
    //   279	284	377	finally
    //   333	338	377	finally
    //   289	294	432	java/io/IOException
    //   299	304	432	java/io/IOException
    //   308	312	432	java/io/IOException
    //   343	348	432	java/io/IOException
    //   356	361	432	java/io/IOException
    //   365	369	432	java/io/IOException
    //   393	398	436	java/io/IOException
    //   405	409	436	java/io/IOException
    //   413	417	436	java/io/IOException
  }
  
  /* Error */
  public static java.io.ByteArrayInputStream s(String paramString)
  {
    // Byte code:
    //   0: new 211	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aconst_null
    //   10: astore 4
    //   12: new 340	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: sipush 4096
    //   24: newarray byte
    //   26: astore 6
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_0
    //   31: aload 6
    //   33: invokevirtual 573	java/io/FileInputStream:read	([B)I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +103 -> 142
    //   42: aload_3
    //   43: iconst_0
    //   44: aload_3
    //   45: arraylength
    //   46: invokestatic 577	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   49: getstatic 51	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   52: iconst_1
    //   53: invokevirtual 581	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   56: astore 6
    //   58: aload 6
    //   60: iconst_1
    //   61: invokevirtual 585	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   64: new 557	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 558	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore 5
    //   73: aload_0
    //   74: astore_3
    //   75: aload 5
    //   77: astore 4
    //   79: aload 6
    //   81: getstatic 591	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   84: bipush 100
    //   86: aload 5
    //   88: invokevirtual 595	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   91: pop
    //   92: aload_0
    //   93: astore_3
    //   94: aload 5
    //   96: astore 4
    //   98: new 563	java/io/ByteArrayInputStream
    //   101: dup
    //   102: aload 5
    //   104: invokevirtual 567	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: invokespecial 569	java/io/ByteArrayInputStream:<init>	([B)V
    //   110: astore 6
    //   112: aload 5
    //   114: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   117: aload_0
    //   118: invokevirtual 553	java/io/FileInputStream:close	()V
    //   121: aload 6
    //   123: areturn
    //   124: astore_0
    //   125: aload_0
    //   126: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   129: aload 6
    //   131: areturn
    //   132: astore 6
    //   134: goto +110 -> 244
    //   137: astore 6
    //   139: goto +205 -> 344
    //   142: aload_3
    //   143: ifnonnull +8 -> 151
    //   146: iconst_0
    //   147: istore_1
    //   148: goto +6 -> 154
    //   151: aload_3
    //   152: arraylength
    //   153: istore_1
    //   154: iload_1
    //   155: iload_2
    //   156: iadd
    //   157: newarray byte
    //   159: astore 5
    //   161: aload_3
    //   162: ifnull +27 -> 189
    //   165: aload_3
    //   166: iconst_0
    //   167: aload 5
    //   169: iconst_0
    //   170: aload_3
    //   171: arraylength
    //   172: invokestatic 601	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   175: aload 6
    //   177: iconst_0
    //   178: aload 5
    //   180: aload_3
    //   181: arraylength
    //   182: iload_2
    //   183: invokestatic 601	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   186: goto +13 -> 199
    //   189: aload 6
    //   191: iconst_0
    //   192: aload 5
    //   194: iconst_0
    //   195: iload_2
    //   196: invokestatic 601	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   199: aload 5
    //   201: astore_3
    //   202: goto -172 -> 30
    //   205: astore_3
    //   206: goto +185 -> 391
    //   209: astore 6
    //   211: aconst_null
    //   212: astore 5
    //   214: goto +30 -> 244
    //   217: aconst_null
    //   218: astore 5
    //   220: goto +60 -> 280
    //   223: astore 6
    //   225: aconst_null
    //   226: astore 5
    //   228: goto +116 -> 344
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_0
    //   234: goto +157 -> 391
    //   237: astore 6
    //   239: aconst_null
    //   240: astore_0
    //   241: aload_0
    //   242: astore 5
    //   244: aload_0
    //   245: astore_3
    //   246: aload 5
    //   248: astore 4
    //   250: aload 6
    //   252: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   265: aload_0
    //   266: ifnull +116 -> 382
    //   269: aload_0
    //   270: invokevirtual 553	java/io/FileInputStream:close	()V
    //   273: aconst_null
    //   274: areturn
    //   275: aconst_null
    //   276: astore_0
    //   277: aload_0
    //   278: astore 5
    //   280: aload_0
    //   281: astore_3
    //   282: aload 5
    //   284: astore 4
    //   286: invokestatic 604	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +19 -> 308
    //   292: aload_0
    //   293: astore_3
    //   294: aload 5
    //   296: astore 4
    //   298: ldc_w 606
    //   301: iconst_2
    //   302: ldc_w 608
    //   305: invokestatic 612	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload 5
    //   310: ifnull +11 -> 321
    //   313: aload 5
    //   315: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   318: goto +3 -> 321
    //   321: aload_0
    //   322: ifnull +13 -> 335
    //   325: aload_0
    //   326: invokevirtual 553	java/io/FileInputStream:close	()V
    //   329: aconst_null
    //   330: areturn
    //   331: aload_0
    //   332: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   335: aconst_null
    //   336: areturn
    //   337: astore 6
    //   339: aconst_null
    //   340: astore_0
    //   341: aload_0
    //   342: astore 5
    //   344: aload_0
    //   345: astore_3
    //   346: aload 5
    //   348: astore 4
    //   350: aload 6
    //   352: invokevirtual 571	java/io/FileNotFoundException:printStackTrace	()V
    //   355: aload 5
    //   357: ifnull +11 -> 368
    //   360: aload 5
    //   362: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   365: goto +3 -> 368
    //   368: aload_0
    //   369: ifnull +13 -> 382
    //   372: aload_0
    //   373: invokevirtual 553	java/io/FileInputStream:close	()V
    //   376: aconst_null
    //   377: areturn
    //   378: aload_0
    //   379: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   382: aconst_null
    //   383: areturn
    //   384: astore 5
    //   386: aload_3
    //   387: astore_0
    //   388: aload 5
    //   390: astore_3
    //   391: aload 4
    //   393: ifnull +11 -> 404
    //   396: aload 4
    //   398: invokevirtual 570	java/io/ByteArrayOutputStream:close	()V
    //   401: goto +3 -> 404
    //   404: aload_0
    //   405: ifnull +14 -> 419
    //   408: aload_0
    //   409: invokevirtual 553	java/io/FileInputStream:close	()V
    //   412: goto +7 -> 419
    //   415: aload_0
    //   416: invokevirtual 215	java/io/IOException:printStackTrace	()V
    //   419: goto +5 -> 424
    //   422: aload_3
    //   423: athrow
    //   424: goto -2 -> 422
    //   427: astore_0
    //   428: goto -153 -> 275
    //   431: astore_3
    //   432: goto -215 -> 217
    //   435: astore_3
    //   436: goto -156 -> 280
    //   439: astore_0
    //   440: goto -109 -> 331
    //   443: astore_0
    //   444: goto -66 -> 378
    //   447: astore_0
    //   448: goto -33 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	paramString	String
    //   147	10	1	n	int
    //   36	160	2	i1	int
    //   29	173	3	localObject1	Object
    //   205	1	3	localObject2	Object
    //   231	1	3	localObject3	Object
    //   245	178	3	localObject4	Object
    //   431	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   435	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   10	387	4	localObject5	Object
    //   71	290	5	localObject6	Object
    //   384	5	5	localObject7	Object
    //   26	104	6	localObject8	Object
    //   132	1	6	localIOException1	IOException
    //   137	53	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   209	1	6	localIOException2	IOException
    //   223	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   237	14	6	localIOException3	IOException
    //   337	14	6	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   112	121	124	java/io/IOException
    //   79	92	132	java/io/IOException
    //   98	112	132	java/io/IOException
    //   79	92	137	java/io/FileNotFoundException
    //   98	112	137	java/io/FileNotFoundException
    //   21	28	205	finally
    //   30	37	205	finally
    //   42	73	205	finally
    //   151	154	205	finally
    //   154	161	205	finally
    //   165	186	205	finally
    //   189	199	205	finally
    //   21	28	209	java/io/IOException
    //   30	37	209	java/io/IOException
    //   42	73	209	java/io/IOException
    //   151	154	209	java/io/IOException
    //   154	161	209	java/io/IOException
    //   165	186	209	java/io/IOException
    //   189	199	209	java/io/IOException
    //   21	28	223	java/io/FileNotFoundException
    //   30	37	223	java/io/FileNotFoundException
    //   42	73	223	java/io/FileNotFoundException
    //   151	154	223	java/io/FileNotFoundException
    //   154	161	223	java/io/FileNotFoundException
    //   165	186	223	java/io/FileNotFoundException
    //   189	199	223	java/io/FileNotFoundException
    //   12	21	231	finally
    //   12	21	237	java/io/IOException
    //   12	21	337	java/io/FileNotFoundException
    //   79	92	384	finally
    //   98	112	384	finally
    //   250	255	384	finally
    //   286	292	384	finally
    //   298	308	384	finally
    //   350	355	384	finally
    //   12	21	427	java/lang/OutOfMemoryError
    //   21	28	431	java/lang/OutOfMemoryError
    //   30	37	431	java/lang/OutOfMemoryError
    //   42	73	431	java/lang/OutOfMemoryError
    //   151	154	431	java/lang/OutOfMemoryError
    //   154	161	431	java/lang/OutOfMemoryError
    //   165	186	431	java/lang/OutOfMemoryError
    //   189	199	431	java/lang/OutOfMemoryError
    //   79	92	435	java/lang/OutOfMemoryError
    //   98	112	435	java/lang/OutOfMemoryError
    //   313	318	439	java/io/IOException
    //   325	329	439	java/io/IOException
    //   260	265	443	java/io/IOException
    //   269	273	443	java/io/IOException
    //   360	365	443	java/io/IOException
    //   372	376	443	java/io/IOException
    //   396	401	447	java/io/IOException
    //   408	412	447	java/io/IOException
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append("/");
    localStringBuilder.append("app-service.js");
    return localStringBuilder.toString();
  }
  
  public void a(MiniAppConfig paramMiniAppConfig)
  {
    int n = this.f.config.mini_version;
    this.f = paramMiniAppConfig;
    this.f.config.mini_version = n;
  }
  
  public void a(String paramString, g.a parama)
  {
    com.tencent.mobileqq.microapp.apkg.g.a().a(this, paramString, parama);
  }
  
  public String b()
  {
    return com.tencent.mobileqq.microapp.apkg.g.a().e();
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str2 = a(paramString);
    String str1 = (String)this.j.get(str2);
    paramString = str1;
    if (TextUtils.isEmpty(str1))
    {
      paramString = str1;
      try
      {
        String str3 = b(new File(this.i, str2));
        paramString = str1;
        str1 = str3.substring(str3.indexOf("<script>") + 8, str3.indexOf("</script>"));
        paramString = str1;
        this.j.put(str2, str1);
        return str1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return paramString;
  }
  
  public f c()
  {
    Object localObject = new File(this.i, "page-frame.html");
    f localf = new f();
    if (!((File)localObject).exists())
    {
      localf.a = b();
      return localf;
    }
    localObject = a((File)localObject);
    String str = ((String)localObject).substring(((String)localObject).indexOf("<script>") + 8, ((String)localObject).indexOf("</script>"));
    localf.a = ((String)localObject).replace(str, "");
    localf.b = str;
    return localf;
  }
  
  public boolean c(String paramString)
  {
    paramString = d(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = new File(com.tencent.mobileqq.microapp.apkg.g.a(this.f.config), paramString).getAbsolutePath();
    boolean bool = new File(paramString).exists();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUrlResReady | subFolderPath :");
      localStringBuilder.append(paramString);
      localStringBuilder.append("isExist:");
      localStringBuilder.append(bool);
      QLog.d("ApkgInfo", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public String d()
  {
    File localFile = new File(new File(this.i), "app-wxss.js");
    if (localFile.exists()) {
      return a(localFile);
    }
    return "";
  }
  
  public String d(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public String e()
  {
    return com.tencent.mobileqq.microapp.apkg.g.a().b();
  }
  
  public String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(this.i);
      paramString.append("/");
      paramString.append("app-service.js");
      return paramString.toString();
    }
    return new File(new File(this.i, paramString), "app-service.js").getAbsolutePath();
  }
  
  public String f()
  {
    return com.tencent.mobileqq.microapp.apkg.g.a().c();
  }
  
  public String f(String paramString)
  {
    return a(new File(e(paramString)));
  }
  
  public String g()
  {
    return com.tencent.mobileqq.microapp.apkg.g.a().d();
  }
  
  public String g(String paramString)
  {
    paramString = this.b.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(this.i, paramString), "page-frame.js");
    if (paramString.exists()) {
      return a(paramString);
    }
    return "";
  }
  
  public boolean h()
  {
    return this.b.e;
  }
  
  public boolean h(String paramString)
  {
    paramString = n(paramString);
    Object localObject = this.b.h;
    if (localObject != null)
    {
      localObject = ((k)localObject).f.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((k.a)((Iterator)localObject).next()).a.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public byte i()
  {
    return this.m;
  }
  
  public boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = n(paramString);
    return (h(paramString)) || (paramString.equals(this.b.f));
  }
  
  public float j()
  {
    return this.l;
  }
  
  public String j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(this.i, paramString).getAbsolutePath();
  }
  
  public int k()
  {
    return this.k;
  }
  
  public boolean k(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(j(n(paramString))).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.c
 * JD-Core Version:    0.7.0.1
 */