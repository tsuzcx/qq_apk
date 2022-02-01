package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import org.json.JSONArray;
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
    Object localObject = this.c;
    int k = 0;
    localObject = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(((Context)localObject).getDir("tbs", 0), this.d)).listFiles();
    JSONObject localJSONObject = new JSONObject();
    if (localObject != null)
    {
      int m = localObject.length;
      while (k < m)
      {
        File localFile = localObject[k];
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
  protected final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/tbs/one/impl/e/a/b:c	Landroid/content/Context;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 32	com/tencent/tbs/one/impl/e/a/b:d	Ljava/lang/String;
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 34	com/tencent/tbs/one/impl/e/a/b:e	Ljava/lang/String;
    //   16: astore 7
    //   18: aload_0
    //   19: getfield 40	com/tencent/tbs/one/impl/e/a/b:h	Ljava/io/File;
    //   22: astore_3
    //   23: aload 5
    //   25: aload 6
    //   27: invokestatic 161	com/tencent/tbs/one/impl/common/a:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tbs/one/optional/TBSOneRuntimeExtension;
    //   30: astore 4
    //   32: iconst_1
    //   33: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   36: astore_2
    //   37: aload 4
    //   39: ifnull +51 -> 90
    //   42: aload 4
    //   44: aload 6
    //   46: ldc 163
    //   48: iconst_m1
    //   49: aconst_null
    //   50: aload_3
    //   51: new 165	com/tencent/tbs/one/impl/e/a/b$1
    //   54: dup
    //   55: aload_0
    //   56: aload 6
    //   58: aload_3
    //   59: invokespecial 168	com/tencent/tbs/one/impl/e/a/b$1:<init>	(Lcom/tencent/tbs/one/impl/e/a/b;Ljava/lang/String;Ljava/io/File;)V
    //   62: invokevirtual 174	com/tencent/tbs/one/optional/TBSOneRuntimeExtension:shouldOverrideInstallationJob	(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/io/File;Lcom/tencent/tbs/one/TBSOneCallback;)I
    //   65: istore_1
    //   66: iload_1
    //   67: ifeq +23 -> 90
    //   70: ldc 176
    //   72: iconst_1
    //   73: anewarray 49	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload 6
    //   80: aastore
    //   81: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_0
    //   85: iload_1
    //   86: putfield 180	com/tencent/tbs/one/impl/e/a/b:b	I
    //   89: return
    //   90: aconst_null
    //   91: astore 4
    //   93: ldc 182
    //   95: sipush 1001
    //   98: aconst_null
    //   99: invokestatic 187	com/tencent/tbs/one/impl/common/h:a	(Ljava/lang/String;ILjava/util/Map;)V
    //   102: new 92	org/json/JSONObject
    //   105: dup
    //   106: invokespecial 93	org/json/JSONObject:<init>	()V
    //   109: astore 8
    //   111: aload 8
    //   113: ldc 189
    //   115: aload_2
    //   116: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   119: aload 8
    //   121: ldc 191
    //   123: aload 5
    //   125: aload 6
    //   127: invokestatic 150	com/tencent/tbs/one/impl/e/a/b:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   130: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   136: aload 8
    //   138: ldc 193
    //   140: aload_0
    //   141: invokespecial 195	com/tencent/tbs/one/impl/e/a/b:e	()Lorg/json/JSONArray;
    //   144: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   147: aload 8
    //   149: ldc 197
    //   151: aload_0
    //   152: invokespecial 199	com/tencent/tbs/one/impl/e/a/b:c	()Lorg/json/JSONObject;
    //   155: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   158: aload 8
    //   160: ldc 201
    //   162: aload_0
    //   163: invokespecial 203	com/tencent/tbs/one/impl/e/a/b:d	()Lorg/json/JSONObject;
    //   166: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   169: aload_0
    //   170: getfield 38	com/tencent/tbs/one/impl/e/a/b:g	I
    //   173: istore_1
    //   174: iload_1
    //   175: iconst_m1
    //   176: if_icmpeq +14 -> 190
    //   179: aload 8
    //   181: ldc 205
    //   183: iload_1
    //   184: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   190: aload 8
    //   192: ldc 207
    //   194: aload_2
    //   195: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   198: aload 8
    //   200: ldc 209
    //   202: iconst_0
    //   203: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   209: aload 5
    //   211: invokevirtual 140	android/content/Context:getPackageName	()Ljava/lang/String;
    //   214: astore 9
    //   216: aload 8
    //   218: ldc 211
    //   220: aload 9
    //   222: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   225: aload 5
    //   227: invokevirtual 215	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   230: astore 10
    //   232: aload 10
    //   234: aload 9
    //   236: iconst_0
    //   237: invokevirtual 221	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   240: astore_2
    //   241: aload 8
    //   243: ldc 223
    //   245: aload_2
    //   246: getfield 228	android/content/pm/PackageInfo:versionCode	I
    //   249: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   255: goto +28 -> 283
    //   258: astore_3
    //   259: goto +6 -> 265
    //   262: astore_3
    //   263: aconst_null
    //   264: astore_2
    //   265: ldc 230
    //   267: iconst_2
    //   268: anewarray 49	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: aload 9
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: aload_3
    //   279: aastore
    //   280: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: invokestatic 234	com/tencent/tbs/one/impl/a/d:b	()Ljava/lang/String;
    //   286: astore_3
    //   287: aload_3
    //   288: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifeq +21 -> 312
    //   294: aload_2
    //   295: ifnull +25 -> 320
    //   298: aload 8
    //   300: ldc 242
    //   302: aload_2
    //   303: getfield 245	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   306: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   309: goto +11 -> 320
    //   312: aload 8
    //   314: ldc 242
    //   316: aload_3
    //   317: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   320: aload 10
    //   322: aload 9
    //   324: sipush 128
    //   327: invokevirtual 249	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   330: astore_2
    //   331: goto +25 -> 356
    //   334: astore_2
    //   335: ldc 251
    //   337: iconst_2
    //   338: anewarray 49	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload 9
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload_2
    //   349: aastore
    //   350: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload 4
    //   355: astore_2
    //   356: aload_2
    //   357: ifnull +79 -> 436
    //   360: aload 8
    //   362: ldc 253
    //   364: aload_2
    //   365: getfield 258	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   368: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   374: aload_2
    //   375: getfield 261	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   378: ifnull +58 -> 436
    //   381: aload_2
    //   382: getfield 261	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   385: ldc_w 263
    //   388: invokevirtual 269	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   391: astore_2
    //   392: aload_2
    //   393: ifnull +43 -> 436
    //   396: aload 8
    //   398: ldc_w 271
    //   401: aload_2
    //   402: invokestatic 274	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   405: invokestatic 278	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   408: invokestatic 282	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   411: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   414: goto +22 -> 436
    //   417: astore_3
    //   418: ldc_w 284
    //   421: iconst_2
    //   422: anewarray 49	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: aload_2
    //   428: aastore
    //   429: dup
    //   430: iconst_1
    //   431: aload_3
    //   432: aastore
    //   433: invokestatic 90	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: aload 8
    //   438: ldc_w 286
    //   441: getstatic 291	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   444: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   447: aload 8
    //   449: ldc_w 293
    //   452: invokestatic 295	com/tencent/tbs/one/impl/a/d:c	()Ljava/lang/String;
    //   455: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   458: aload 8
    //   460: ldc_w 297
    //   463: aload 5
    //   465: invokestatic 300	com/tencent/tbs/one/impl/a/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   468: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   471: aload 8
    //   473: ldc_w 302
    //   476: invokestatic 304	com/tencent/tbs/one/impl/a/d:a	()Ljava/lang/String;
    //   479: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   482: aload 8
    //   484: ldc_w 306
    //   487: aload 5
    //   489: invokestatic 308	com/tencent/tbs/one/impl/a/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   492: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   495: aload 8
    //   497: ldc_w 310
    //   500: invokestatic 312	com/tencent/tbs/one/impl/a/d:d	()Ljava/lang/String;
    //   503: invokestatic 131	com/tencent/tbs/one/impl/a/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Object;)V
    //   506: ldc_w 314
    //   509: iconst_3
    //   510: anewarray 49	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: aload 6
    //   517: aastore
    //   518: dup
    //   519: iconst_1
    //   520: aload 7
    //   522: aastore
    //   523: dup
    //   524: iconst_2
    //   525: aload 8
    //   527: aastore
    //   528: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: new 316	com/tencent/tbs/one/impl/d/a
    //   535: dup
    //   536: aload 5
    //   538: aload 7
    //   540: ldc_w 318
    //   543: aconst_null
    //   544: aload 8
    //   546: invokevirtual 321	org/json/JSONObject:toString	()Ljava/lang/String;
    //   549: getstatic 326	com/tencent/tbs/one/impl/common/b:b	Ljava/nio/charset/Charset;
    //   552: invokevirtual 330	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   555: invokespecial 333	com/tencent/tbs/one/impl/d/a:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[B)V
    //   558: putfield 335	com/tencent/tbs/one/impl/e/a/b:i	Lcom/tencent/tbs/one/impl/d/a;
    //   561: aload_0
    //   562: getfield 335	com/tencent/tbs/one/impl/e/a/b:i	Lcom/tencent/tbs/one/impl/d/a;
    //   565: astore_2
    //   566: aload_2
    //   567: aload_0
    //   568: putfield 338	com/tencent/tbs/one/impl/d/a:f	Lcom/tencent/tbs/one/impl/d/a$a;
    //   571: aload_2
    //   572: new 340	com/tencent/tbs/one/impl/e/a/b$2
    //   575: dup
    //   576: aload_0
    //   577: invokespecial 343	com/tencent/tbs/one/impl/e/a/b$2:<init>	(Lcom/tencent/tbs/one/impl/e/a/b;)V
    //   580: invokevirtual 346	com/tencent/tbs/one/impl/d/a:a	(Lcom/tencent/tbs/one/impl/a/l;)V
    //   583: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	584	0	this	b
    //   65	119	1	k	int
    //   36	295	2	localObject1	Object
    //   334	15	2	localException1	java.lang.Exception
    //   355	217	2	localObject2	Object
    //   22	37	3	localFile	File
    //   258	1	3	localNameNotFoundException1	PackageManager.NameNotFoundException
    //   262	17	3	localNameNotFoundException2	PackageManager.NameNotFoundException
    //   286	31	3	str1	String
    //   417	15	3	localException2	java.lang.Exception
    //   30	324	4	localTBSOneRuntimeExtension	TBSOneRuntimeExtension
    //   4	533	5	localContext	Context
    //   10	506	6	str2	String
    //   16	523	7	str3	String
    //   109	436	8	localJSONObject	JSONObject
    //   214	130	9	str4	String
    //   230	91	10	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   241	255	258	android/content/pm/PackageManager$NameNotFoundException
    //   232	241	262	android/content/pm/PackageManager$NameNotFoundException
    //   320	331	334	java/lang/Exception
    //   396	414	417	java/lang/Exception
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    com.tencent.tbs.one.impl.e.f.a(this.h, System.currentTimeMillis());
    super.a(paramInt, paramString, paramThrowable);
  }
  
  /* Error */
  public final void a(int paramInt, java.util.Map<String, java.util.List<String>> paramMap, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/tbs/one/impl/e/a/b:c	Landroid/content/Context;
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 32	com/tencent/tbs/one/impl/e/a/b:d	Ljava/lang/String;
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 34	com/tencent/tbs/one/impl/e/a/b:e	Ljava/lang/String;
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 40	com/tencent/tbs/one/impl/e/a/b:h	Ljava/io/File;
    //   22: astore 5
    //   24: ldc_w 367
    //   27: iconst_3
    //   28: anewarray 49	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload 6
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: iload_1
    //   39: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: aload_2
    //   46: aastore
    //   47: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: iload_1
    //   51: sipush 200
    //   54: if_icmpne +364 -> 418
    //   57: aload_3
    //   58: ifnonnull +6 -> 64
    //   61: goto +357 -> 418
    //   64: aload 7
    //   66: aload 6
    //   68: invokestatic 161	com/tencent/tbs/one/impl/common/a:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tbs/one/optional/TBSOneRuntimeExtension;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +51 -> 124
    //   76: aload_2
    //   77: aload 6
    //   79: aconst_null
    //   80: aload_3
    //   81: aload 5
    //   83: new 369	com/tencent/tbs/one/impl/e/a/b$3
    //   86: dup
    //   87: aload_0
    //   88: aload 6
    //   90: aload 5
    //   92: invokespecial 370	com/tencent/tbs/one/impl/e/a/b$3:<init>	(Lcom/tencent/tbs/one/impl/e/a/b;Ljava/lang/String;Ljava/io/File;)V
    //   95: invokevirtual 374	com/tencent/tbs/one/optional/TBSOneRuntimeExtension:shouldInterceptDEPSResponse	(Ljava/lang/String;Ljava/util/Map;Ljava/io/InputStream;Ljava/io/File;Lcom/tencent/tbs/one/TBSOneCallback;)I
    //   98: istore_1
    //   99: iload_1
    //   100: ifeq +24 -> 124
    //   103: ldc_w 376
    //   106: iconst_1
    //   107: anewarray 49	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload 6
    //   114: aastore
    //   115: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: iload_1
    //   120: putfield 180	com/tencent/tbs/one/impl/e/a/b:b	I
    //   123: return
    //   124: aload_3
    //   125: ldc_w 378
    //   128: invokestatic 383	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: new 92	org/json/JSONObject
    //   135: dup
    //   136: aload_3
    //   137: invokespecial 386	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   140: astore_2
    //   141: ldc_w 388
    //   144: iconst_2
    //   145: anewarray 49	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 6
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_2
    //   156: aastore
    //   157: invokestatic 178	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aload_2
    //   161: ldc_w 390
    //   164: iconst_m1
    //   165: invokevirtual 393	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   168: istore_1
    //   169: iload_1
    //   170: ifeq +70 -> 240
    //   173: aload_2
    //   174: ldc_w 395
    //   177: invokevirtual 399	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: astore_2
    //   181: new 401	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 403
    //   188: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: astore_3
    //   192: aload_3
    //   193: aload 4
    //   195: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_3
    //   200: ldc_w 410
    //   203: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_3
    //   208: iload_1
    //   209: invokevirtual 413	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_3
    //   214: ldc_w 415
    //   217: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_3
    //   222: aload_2
    //   223: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_0
    //   228: sipush 213
    //   231: aload_3
    //   232: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: aconst_null
    //   236: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: return
    //   240: aload_2
    //   241: ldc 163
    //   243: invokevirtual 399	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_3
    //   247: aload_3
    //   248: invokestatic 422	com/tencent/tbs/one/impl/common/d:a	(Ljava/lang/String;)Lcom/tencent/tbs/one/impl/common/d;
    //   251: astore 4
    //   253: aload_3
    //   254: ldc_w 378
    //   257: aload 5
    //   259: invokestatic 425	com/tencent/tbs/one/impl/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
    //   262: getstatic 430	com/tencent/tbs/one/impl/e/e$a:d	Lcom/tencent/tbs/one/impl/e/e$a;
    //   265: aload 4
    //   267: invokestatic 435	com/tencent/tbs/one/impl/e/e:a	(Lcom/tencent/tbs/one/impl/e/e$a;Ljava/lang/Object;)Lcom/tencent/tbs/one/impl/e/e;
    //   270: astore_3
    //   271: aload_3
    //   272: aload_2
    //   273: putfield 438	com/tencent/tbs/one/impl/e/e:c	Ljava/lang/Object;
    //   276: aload_0
    //   277: aload_3
    //   278: invokevirtual 441	com/tencent/tbs/one/impl/e/a/b:a	(Ljava/lang/Object;)V
    //   281: return
    //   282: astore_2
    //   283: new 401	java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w 443
    //   290: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: astore_3
    //   294: aload_3
    //   295: aload 5
    //   297: invokevirtual 446	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   300: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_0
    //   305: sipush 305
    //   308: aload_3
    //   309: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: aload_2
    //   313: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   316: return
    //   317: astore_2
    //   318: aload_0
    //   319: aload_2
    //   320: invokevirtual 450	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   323: aload_2
    //   324: invokevirtual 453	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   327: aload_2
    //   328: invokevirtual 457	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   331: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: return
    //   335: astore_2
    //   336: new 401	java/lang/StringBuilder
    //   339: dup
    //   340: ldc_w 459
    //   343: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: astore 5
    //   348: aload 5
    //   350: aload_3
    //   351: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 5
    //   357: ldc_w 461
    //   360: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 5
    //   366: aload 4
    //   368: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload_0
    //   373: sipush 212
    //   376: aload 5
    //   378: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: aload_2
    //   382: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   385: return
    //   386: astore_2
    //   387: new 401	java/lang/StringBuilder
    //   390: dup
    //   391: ldc_w 463
    //   394: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: astore_3
    //   398: aload_3
    //   399: aload 4
    //   401: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_0
    //   406: sipush 211
    //   409: aload_3
    //   410: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: aload_2
    //   414: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: return
    //   418: new 401	java/lang/StringBuilder
    //   421: dup
    //   422: ldc_w 465
    //   425: invokespecial 404	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: astore_2
    //   429: aload_2
    //   430: aload 4
    //   432: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: ldc_w 467
    //   440: invokevirtual 408	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_2
    //   445: iload_1
    //   446: invokevirtual 413	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload_0
    //   451: sipush 210
    //   454: aload_2
    //   455: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: aconst_null
    //   459: invokevirtual 417	com/tencent/tbs/one/impl/e/a/b:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	b
    //   0	463	1	paramInt	int
    //   0	463	2	paramMap	java.util.Map<String, java.util.List<String>>
    //   0	463	3	paramInputStream	java.io.InputStream
    //   16	415	4	localObject1	Object
    //   22	355	5	localObject2	Object
    //   10	141	6	str	String
    //   4	61	7	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   247	262	282	java/io/IOException
    //   247	262	317	com/tencent/tbs/one/TBSOneException
    //   132	141	335	org/json/JSONException
    //   124	132	386	java/io/IOException
  }
  
  public final void b()
  {
    super.b();
    Object localObject = this.i;
    if (localObject != null) {
      ((com.tencent.tbs.one.impl.d.a)localObject).b();
    }
    if (this.b != 0)
    {
      localObject = com.tencent.tbs.one.impl.common.a.b(this.c, this.d);
      if (localObject != null) {
        ((TBSOneRuntimeExtension)localObject).cancel(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.b
 * JD-Core Version:    0.7.0.1
 */