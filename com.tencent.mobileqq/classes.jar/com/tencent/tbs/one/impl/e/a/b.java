package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.tbs.one.impl.a.a<com.tencent.tbs.one.impl.e.e<d>>
  implements a.a
{
  int b;
  private Context c;
  private String d;
  private String e;
  private String[] f;
  private int g;
  private File h;
  private com.tencent.tbs.one.impl.d.a i;
  private Bundle j;
  
  public b(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, File paramFile, Bundle paramBundle)
  {
    this.c = paramContext;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramArrayOfString;
    this.g = paramInt;
    this.h = paramFile;
    this.j = paramBundle;
  }
  
  private static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString }), 4).getInt("in_use_deps_version", -1);
  }
  
  private JSONObject c()
  {
    try
    {
      JSONObject localJSONObject = com.tencent.tbs.one.impl.a.e.a(BuildConfig.COMPONENT_SDK_VERSIONS);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to get component sdk versions", new Object[] { this.d, localThrowable });
    }
    return new JSONObject();
  }
  
  private JSONObject d()
  {
    int k = 0;
    File[] arrayOfFile = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.c.getDir("tbs", 0), this.d)).listFiles();
    JSONObject localJSONObject = new JSONObject();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      while (k < m)
      {
        File localFile = arrayOfFile[k];
        com.tencent.tbs.one.impl.a.e.a(localJSONObject, localFile.getName(), Integer.valueOf(com.tencent.tbs.one.impl.e.f.c(localFile)));
        k += 1;
      }
    }
    return localJSONObject;
  }
  
  private JSONArray e()
  {
    JSONArray localJSONArray = new JSONArray();
    Context localContext = this.c;
    String str1 = this.d;
    String[] arrayOfString = this.f;
    if (arrayOfString != null)
    {
      int m = arrayOfString.length;
      int k = 0;
      while (k < m)
      {
        String str2 = arrayOfString[k];
        if (!str2.equals(localContext.getPackageName())) {}
        try
        {
          int n = a(localContext.createPackageContext(str2, 2), str1);
          if (n != -1) {
            localJSONArray.put(n);
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          label88:
          break label88;
        }
        k += 1;
      }
    }
    else
    {
      return localJSONArray;
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/tbs/one/impl/e/a/b:c	Landroid/content/Context;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 32	com/tencent/tbs/one/impl/e/a/b:d	Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 34	com/tencent/tbs/one/impl/e/a/b:e	Ljava/lang/String;
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 40	com/tencent/tbs/one/impl/e/a/b:h	Ljava/io/File;
    //   22: astore_2
    //   23: aload 4
    //   25: aload 5
    //   27: invokestatic 161	com/tencent/tbs/one/impl/common/a:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tbs/one/optional/TBSOneRuntimeExtension;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +50 -> 82
    //   35: aload_3
    //   36: aload 5
    //   38: ldc 163
    //   40: iconst_m1
    //   41: aconst_null
    //   42: aload_2
    //   43: new 165	com/tencent/tbs/one/impl/e/a/b$1
    //   46: dup
    //   47: aload_0
    //   48: aload 5
    //   50: aload_2
    //   51: invokespecial 168	com/tencent/tbs/one/impl/e/a/b$1:<init>	(Lcom/tencent/tbs/one/impl/e/a/b;Ljava/lang/String;Ljava/io/File;)V
    //   54: invokevirtual 174	com/tencent/tbs/one/optional/TBSOneRuntimeExtension:shouldOverrideInstallationJob	(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/io/File;Lcom/tencent/tbs/one/TBSOneCallback;)I
    //   57: istore_1
    //   58: iload_1
    //   59: ifeq +23 -> 82
    //   62: ldc 176
    //   64: iconst_1
    //   65: anewarray 49	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload 5
    //   72: aastore
    //   73: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload_0
    //   77: iload_1
    //   78: putfield 180	com/tencent/tbs/one/impl/e/a/b:b	I
    //   81: return
    //   82: ldc 182
    //   84: sipush 1001
    //   87: aconst_null
    //   88: invokestatic 187	com/tencent/tbs/one/impl/common/h:a	(Ljava/lang/String;ILjava/util/Map;)V
    //   91: new 92	org/json/JSONObject
    //   94: dup
    //   95: invokespecial 93	org/json/JSONObject:<init>	()V
    //   98: astore 7
    //   100: aload 7
    //   102: ldc 189
    //   104: iconst_1
    //   105: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   111: aload 7
    //   113: ldc 191
    //   115: aload 4
    //   117: aload 5
    //   119: invokestatic 150	com/tencent/tbs/one/impl/e/a/b:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   122: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   128: aload 7
    //   130: ldc 193
    //   132: aload_0
    //   133: invokespecial 195	com/tencent/tbs/one/impl/e/a/b:e	()Lorg/json/JSONArray;
    //   136: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   139: aload 7
    //   141: ldc 197
    //   143: aload_0
    //   144: invokespecial 199	com/tencent/tbs/one/impl/e/a/b:c	()Lorg/json/JSONObject;
    //   147: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   150: aload 7
    //   152: ldc 201
    //   154: aload_0
    //   155: invokespecial 203	com/tencent/tbs/one/impl/e/a/b:d	()Lorg/json/JSONObject;
    //   158: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   161: aload_0
    //   162: getfield 38	com/tencent/tbs/one/impl/e/a/b:g	I
    //   165: iconst_m1
    //   166: if_icmpeq +17 -> 183
    //   169: aload 7
    //   171: ldc 205
    //   173: aload_0
    //   174: getfield 38	com/tencent/tbs/one/impl/e/a/b:g	I
    //   177: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   183: aload 7
    //   185: ldc 207
    //   187: iconst_1
    //   188: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   194: aload 7
    //   196: ldc 209
    //   198: iconst_0
    //   199: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   205: aload 4
    //   207: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   210: astore 8
    //   212: aload 7
    //   214: ldc 211
    //   216: aload 8
    //   218: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   221: aload 4
    //   223: invokevirtual 215	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   226: astore 9
    //   228: aload 9
    //   230: aload 8
    //   232: iconst_0
    //   233: invokevirtual 221	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   236: astore_2
    //   237: aload 7
    //   239: ldc 223
    //   241: aload_2
    //   242: getfield 228	android/content/pm/PackageInfo:versionCode	I
    //   245: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   251: invokestatic 232	com/tencent/tbs/one/impl/a/d:b	()Ljava/lang/String;
    //   254: astore_3
    //   255: aload_3
    //   256: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: ifeq +261 -> 520
    //   262: aload_2
    //   263: ifnull +14 -> 277
    //   266: aload 7
    //   268: ldc 240
    //   270: aload_2
    //   271: getfield 243	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   274: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   277: aload 9
    //   279: aload 8
    //   281: sipush 128
    //   284: invokevirtual 247	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   287: astore_2
    //   288: aload_2
    //   289: ifnull +57 -> 346
    //   292: aload 7
    //   294: ldc 249
    //   296: aload_2
    //   297: getfield 254	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   300: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   306: aload_2
    //   307: getfield 257	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   310: ifnull +36 -> 346
    //   313: aload_2
    //   314: getfield 257	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   317: ldc_w 259
    //   320: invokevirtual 265	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   323: astore_2
    //   324: aload_2
    //   325: ifnull +21 -> 346
    //   328: aload 7
    //   330: ldc_w 267
    //   333: aload_2
    //   334: invokestatic 270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   340: invokestatic 278	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   343: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   346: aload 7
    //   348: ldc_w 280
    //   351: getstatic 285	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   354: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   357: aload 7
    //   359: ldc_w 287
    //   362: invokestatic 289	com/tencent/tbs/one/impl/a/d:c	()Ljava/lang/String;
    //   365: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   368: aload 7
    //   370: ldc_w 291
    //   373: aload 4
    //   375: invokestatic 294	com/tencent/tbs/one/impl/a/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   378: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   381: aload 7
    //   383: ldc_w 296
    //   386: invokestatic 298	com/tencent/tbs/one/impl/a/d:a	()Ljava/lang/String;
    //   389: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   392: aload 7
    //   394: ldc_w 300
    //   397: aload 4
    //   399: invokestatic 302	com/tencent/tbs/one/impl/a/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   402: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   405: aload 7
    //   407: ldc_w 304
    //   410: invokestatic 306	com/tencent/tbs/one/impl/a/d:d	()Ljava/lang/String;
    //   413: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   416: ldc_w 308
    //   419: iconst_3
    //   420: anewarray 49	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload 5
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: aload 6
    //   432: aastore
    //   433: dup
    //   434: iconst_2
    //   435: aload 7
    //   437: aastore
    //   438: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: aload_0
    //   442: new 310	com/tencent/tbs/one/impl/d/a
    //   445: dup
    //   446: aload 4
    //   448: aload 6
    //   450: ldc_w 312
    //   453: aconst_null
    //   454: aload 7
    //   456: invokevirtual 315	org/json/JSONObject:toString	()Ljava/lang/String;
    //   459: getstatic 320	com/tencent/tbs/one/impl/common/b:b	Ljava/nio/charset/Charset;
    //   462: invokevirtual 324	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   465: invokespecial 327	com/tencent/tbs/one/impl/d/a:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[B)V
    //   468: putfield 329	com/tencent/tbs/one/impl/e/a/b:i	Lcom/tencent/tbs/one/impl/d/a;
    //   471: aload_0
    //   472: getfield 329	com/tencent/tbs/one/impl/e/a/b:i	Lcom/tencent/tbs/one/impl/d/a;
    //   475: aload_0
    //   476: putfield 332	com/tencent/tbs/one/impl/d/a:f	Lcom/tencent/tbs/one/impl/d/a$a;
    //   479: aload_0
    //   480: getfield 329	com/tencent/tbs/one/impl/e/a/b:i	Lcom/tencent/tbs/one/impl/d/a;
    //   483: new 334	com/tencent/tbs/one/impl/e/a/b$2
    //   486: dup
    //   487: aload_0
    //   488: invokespecial 337	com/tencent/tbs/one/impl/e/a/b$2:<init>	(Lcom/tencent/tbs/one/impl/e/a/b;)V
    //   491: invokevirtual 340	com/tencent/tbs/one/impl/d/a:a	(Lcom/tencent/tbs/one/impl/a/l;)V
    //   494: return
    //   495: astore_3
    //   496: aconst_null
    //   497: astore_2
    //   498: ldc_w 342
    //   501: iconst_2
    //   502: anewarray 49	java/lang/Object
    //   505: dup
    //   506: iconst_0
    //   507: aload 8
    //   509: aastore
    //   510: dup
    //   511: iconst_1
    //   512: aload_3
    //   513: aastore
    //   514: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   517: goto -266 -> 251
    //   520: aload 7
    //   522: ldc 240
    //   524: aload_3
    //   525: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   528: goto -251 -> 277
    //   531: astore_2
    //   532: ldc_w 344
    //   535: iconst_2
    //   536: anewarray 49	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: aload 8
    //   543: aastore
    //   544: dup
    //   545: iconst_1
    //   546: aload_2
    //   547: aastore
    //   548: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aconst_null
    //   552: astore_2
    //   553: goto -265 -> 288
    //   556: astore_3
    //   557: ldc_w 346
    //   560: iconst_2
    //   561: anewarray 49	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_2
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload_3
    //   571: aastore
    //   572: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   575: goto -229 -> 346
    //   578: astore_3
    //   579: goto -81 -> 498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	b
    //   57	21	1	k	int
    //   22	476	2	localObject1	Object
    //   531	16	2	localException1	java.lang.Exception
    //   552	15	2	localObject2	Object
    //   30	226	3	localObject3	Object
    //   495	30	3	localNameNotFoundException1	PackageManager.NameNotFoundException
    //   556	15	3	localException2	java.lang.Exception
    //   578	1	3	localNameNotFoundException2	PackageManager.NameNotFoundException
    //   4	443	4	localContext	Context
    //   10	416	5	str1	String
    //   16	433	6	str2	String
    //   98	423	7	localJSONObject	JSONObject
    //   210	332	8	str3	String
    //   226	52	9	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   228	237	495	android/content/pm/PackageManager$NameNotFoundException
    //   277	288	531	java/lang/Exception
    //   328	346	556	java/lang/Exception
    //   237	251	578	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    com.tencent.tbs.one.impl.e.f.a(this.h, System.currentTimeMillis());
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.c;
    String str = this.d;
    Object localObject = this.e;
    File localFile = this.h;
    com.tencent.tbs.one.impl.a.f.a("[%s] Receiving DEPS response: [%d] %s", new Object[] { str, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      a(210, "Invalid DEPS response stream, url: " + (String)localObject + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = com.tencent.tbs.one.impl.common.a.b(localContext, str);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str, null, paramInputStream, localFile, new b.3(this, str, localFile));
      if (paramInt != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] Intercepted DEPS response stream by runtime extension", new Object[] { str });
        this.b = paramInt;
        return;
      }
    }
    try
    {
      paramInputStream = c.a(paramInputStream, "utf-8");
      paramInputStream = paramMap.optString("DEPS");
    }
    catch (IOException paramMap)
    {
      try
      {
        paramMap = new JSONObject(paramInputStream);
        com.tencent.tbs.one.impl.a.f.a("[%s] Receiving DEPS data %s", new Object[] { str, paramMap });
        paramInt = paramMap.optInt("CODE", -1);
        if (paramInt == 0) {
          break label328;
        }
        paramMap = paramMap.optString("MSG");
        a(213, "Failed to request DEPS, url: " + (String)localObject + ", response code: " + paramInt + ", message: " + paramMap, null);
        return;
      }
      catch (JSONException paramMap)
      {
        a(212, "Failed to parse DEPS response " + paramInputStream + ", url: " + (String)localObject, paramMap);
        return;
      }
      paramMap = paramMap;
      a(211, "Failed to read DEPS response, url:" + (String)localObject, paramMap);
      return;
    }
    try
    {
      label328:
      localObject = d.a(paramInputStream);
      c.a(paramInputStream, "utf-8", localFile);
      paramInputStream = com.tencent.tbs.one.impl.e.e.a(e.a.d, localObject);
      paramInputStream.c = paramMap;
      a(paramInputStream);
      return;
    }
    catch (TBSOneException paramMap)
    {
      a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      return;
    }
    catch (IOException paramMap)
    {
      a(305, "Failed to save online DEPS to " + localFile.getAbsolutePath(), paramMap);
    }
  }
  
  public final void b()
  {
    super.b();
    if (this.i != null) {
      this.i.b();
    }
    if (this.b != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(this.c, this.d);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.b
 * JD-Core Version:    0.7.0.1
 */