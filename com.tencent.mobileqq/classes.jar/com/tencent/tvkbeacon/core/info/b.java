package com.tencent.tvkbeacon.core.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.tvkbeacon.core.c.i;

public class b
{
  public static String a;
  public static String b;
  public static String c;
  private static volatile b d = null;
  private Context e;
  private String f = "";
  private String g = "";
  private byte h = -1;
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private long n;
  private String o = "";
  private String p = "";
  
  public b(Context paramContext)
  {
    this.e = paramContext;
    d.a(paramContext);
    this.f = d.b();
    this.g = d.a();
    this.h = 1;
    this.j = a.c(paramContext);
    this.k = "tvkbeacon";
    this.l = "3.2.1.7-tvk";
    this.m = "unknown";
    this.o = b(paramContext);
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    for (;;)
    {
      this.p = com.tencent.tvkbeacon.core.c.b.a((String)localObject);
      return;
      String str = c(paramContext);
      localObject = str;
      if (i.a(str)) {
        localObject = d(paramContext);
      }
    }
  }
  
  public static b a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        if (d == null) {
          d = new b(paramContext);
        }
        paramContext = d;
      }
      finally {}
    }
  }
  
  private static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
      if (paramContext != null)
      {
        paramContext = paramContext.toString().trim();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      com.tencent.tvkbeacon.core.c.c.d("[core] not set 'APPKEY_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  /* Error */
  private static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 151	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 156	com/tencent/tvkbeacon/core/a/c:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/a/c;
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 158
    //   15: ldc 36
    //   17: invokevirtual 161	com/tencent/tvkbeacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   27: ifeq +21 -> 48
    //   30: ldc 163
    //   32: astore_0
    //   33: aload 4
    //   35: invokevirtual 166	com/tencent/tvkbeacon/core/a/c:a	()Lcom/tencent/tvkbeacon/core/a/c;
    //   38: ldc 158
    //   40: ldc 163
    //   42: invokevirtual 169	com/tencent/tvkbeacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/tvkbeacon/core/a/c;
    //   45: invokevirtual 171	com/tencent/tvkbeacon/core/a/c:b	()V
    //   48: ldc 173
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: aastore
    //   58: invokestatic 175	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   61: aload_0
    //   62: ldc 36
    //   64: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifne +93 -> 160
    //   70: aload_3
    //   71: aload_0
    //   72: invokevirtual 185	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   75: astore_0
    //   76: aload_0
    //   77: astore_3
    //   78: new 187	java/util/Properties
    //   81: dup
    //   82: invokespecial 188	java/util/Properties:<init>	()V
    //   85: astore_2
    //   86: aload_0
    //   87: astore_3
    //   88: aload_2
    //   89: aload_0
    //   90: invokevirtual 192	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   93: aload_0
    //   94: astore_3
    //   95: aload_2
    //   96: ldc 194
    //   98: ldc 36
    //   100: invokevirtual 197	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   103: astore_2
    //   104: aload_0
    //   105: astore_3
    //   106: ldc 199
    //   108: aload_2
    //   109: invokestatic 203	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 206	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 208	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: astore_3
    //   124: aload_2
    //   125: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   128: istore_1
    //   129: aload_2
    //   130: astore 4
    //   132: aload_0
    //   133: astore 5
    //   135: iload_1
    //   136: ifne +31 -> 167
    //   139: aload_2
    //   140: astore_3
    //   141: aload_0
    //   142: ifnull +9 -> 151
    //   145: aload_0
    //   146: invokevirtual 213	java/io/InputStream:close	()V
    //   149: aload_2
    //   150: astore_3
    //   151: aload_3
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 216	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: areturn
    //   160: aconst_null
    //   161: astore 5
    //   163: ldc 36
    //   165: astore 4
    //   167: aload 4
    //   169: astore_3
    //   170: aload 5
    //   172: ifnull -21 -> 151
    //   175: aload 5
    //   177: invokevirtual 213	java/io/InputStream:close	()V
    //   180: aload 4
    //   182: areturn
    //   183: astore_0
    //   184: aload_0
    //   185: invokestatic 216	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   188: aload 4
    //   190: areturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_0
    //   194: ldc 36
    //   196: astore_2
    //   197: aload_0
    //   198: astore_3
    //   199: aload 4
    //   201: invokevirtual 166	com/tencent/tvkbeacon/core/a/c:a	()Lcom/tencent/tvkbeacon/core/a/c;
    //   204: ldc 158
    //   206: ldc 36
    //   208: invokevirtual 169	com/tencent/tvkbeacon/core/a/c:a	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/tvkbeacon/core/a/c;
    //   211: invokevirtual 171	com/tencent/tvkbeacon/core/a/c:b	()V
    //   214: aload_0
    //   215: astore_3
    //   216: ldc 218
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 220	com/tencent/tvkbeacon/core/c/c:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_2
    //   226: astore_3
    //   227: aload_0
    //   228: ifnull -77 -> 151
    //   231: aload_0
    //   232: invokevirtual 213	java/io/InputStream:close	()V
    //   235: aload_2
    //   236: areturn
    //   237: astore_0
    //   238: aload_0
    //   239: invokestatic 216	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   242: aload_2
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 213	java/io/InputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore_2
    //   258: aload_2
    //   259: invokestatic 216	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   262: goto -7 -> 255
    //   265: astore_0
    //   266: goto -19 -> 247
    //   269: astore_2
    //   270: ldc 36
    //   272: astore_2
    //   273: goto -76 -> 197
    //   276: astore_3
    //   277: goto -80 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramContext	Context
    //   128	8	1	bool	boolean
    //   20	223	2	localObject1	Object
    //   257	2	2	localIOException	java.io.IOException
    //   269	1	2	localException1	Exception
    //   272	1	2	str	String
    //   4	248	3	localObject2	Object
    //   276	1	3	localException2	Exception
    //   9	191	4	localObject3	Object
    //   133	43	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   145	149	153	java/io/IOException
    //   175	180	183	java/io/IOException
    //   11	21	191	java/lang/Exception
    //   23	30	191	java/lang/Exception
    //   33	48	191	java/lang/Exception
    //   48	76	191	java/lang/Exception
    //   231	235	237	java/io/IOException
    //   11	21	244	finally
    //   23	30	244	finally
    //   33	48	244	finally
    //   48	76	244	finally
    //   251	255	257	java/io/IOException
    //   78	86	265	finally
    //   88	93	265	finally
    //   95	104	265	finally
    //   106	122	265	finally
    //   124	129	265	finally
    //   199	214	265	finally
    //   216	225	265	finally
    //   78	86	269	java/lang/Exception
    //   88	93	269	java/lang/Exception
    //   95	104	269	java/lang/Exception
    //   106	122	276	java/lang/Exception
    //   124	129	276	java/lang/Exception
  }
  
  private static String d(Context paramContext)
  {
    String str = "";
    try
    {
      Object localObject = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
      paramContext = str;
      if (localObject != null) {
        paramContext = localObject.toString();
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      com.tencent.tvkbeacon.core.c.c.d("[core] not set 'CHANNEL_DENGTA' in manifest", new Object[0]);
    }
    return "";
  }
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/tencent/tvkbeacon/core/info/b:e	Landroid/content/Context;
    //   6: ifnonnull +10 -> 16
    //   9: ldc 36
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 58	com/tencent/tvkbeacon/core/info/b:e	Landroid/content/Context;
    //   21: invokevirtual 108	android/content/Context:getPackageName	()Ljava/lang/String;
    //   24: putfield 44	com/tencent/tvkbeacon/core/info/b:i	Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 44	com/tencent/tvkbeacon/core/info/b:i	Ljava/lang/String;
    //   31: astore_1
    //   32: goto -20 -> 12
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	b
    //   11	21	1	str	String
    //   35	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	35	finally
    //   16	32	35	finally
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 226	com/tencent/tvkbeacon/core/info/b:c	Ljava/lang/String;
    //   5: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 226	com/tencent/tvkbeacon/core/info/b:c	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 56	com/tencent/tvkbeacon/core/info/b:p	Ljava/lang/String;
    //   23: astore_1
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	b
    //   0	32	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	27	finally
    //   19	24	27	finally
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.n = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 231	com/tencent/tvkbeacon/core/info/b:a	Ljava/lang/String;
    //   5: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 231	com/tencent/tvkbeacon/core/info/b:a	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 54	com/tencent/tvkbeacon/core/info/b:o	Ljava/lang/String;
    //   23: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   26: ifne +11 -> 37
    //   29: aload_0
    //   30: getfield 54	com/tencent/tvkbeacon/core/info/b:o	Ljava/lang/String;
    //   33: astore_1
    //   34: goto -19 -> 15
    //   37: aload_0
    //   38: invokevirtual 232	com/tencent/tvkbeacon/core/info/b:a	()Ljava/lang/String;
    //   41: astore_1
    //   42: goto -27 -> 15
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	b
    //   14	28	1	str	String
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	45	finally
    //   19	34	45	finally
    //   37	42	45	finally
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 234	com/tencent/tvkbeacon/core/info/b:b	Ljava/lang/String;
    //   5: invokestatic 92	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   8: ifne +11 -> 19
    //   11: getstatic 234	com/tencent/tvkbeacon/core/info/b:b	Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: aload_0
    //   20: getfield 46	com/tencent/tvkbeacon/core/info/b:j	Ljava/lang/String;
    //   23: astore_1
    //   24: goto -9 -> 15
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	b
    //   0	32	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	15	27	finally
    //   19	24	27	finally
  }
  
  public final String c()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(String paramString)
  {
    this.m = paramString;
  }
  
  public final String d()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
  {
    return this.f;
  }
  
  public final String f()
  {
    return this.g;
  }
  
  public final byte g()
  {
    try
    {
      byte b1 = this.h;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String h()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long i()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context j()
  {
    return this.e;
  }
  
  public final boolean k()
  {
    bool3 = true;
    boolean bool2 = true;
    bool1 = false;
    boolean bool4 = false;
    try
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        break label29;
      }
      bool1 = bool4;
    }
    finally
    {
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.tvkbeacon.core.a.c.a(this.e).c();
          str1 = a.g(this.e) + "_SDKVER_DENGTA";
          str2 = ((SharedPreferences)localObject1).getString(str1, null);
          if (str2 != null)
          {
            bool4 = str2.equals(this.l);
            if (bool4) {
              continue;
            }
          }
        }
        catch (Exception localException1)
        {
          Object localObject1;
          bool1 = false;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putString(str1, this.l).apply();
          bool1 = bool2;
          com.tencent.tvkbeacon.core.c.c.b("[core] isNewSDKVersion: %s", new Object[] { Boolean.valueOf(bool1) });
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            bool1 = bool3;
          }
        }
      }
      localObject2 = finally;
    }
    return bool1;
    for (;;)
    {
      label29:
      String str1;
      String str2;
      com.tencent.tvkbeacon.core.c.c.d("[core] updateLocalSDKVER fail!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localException1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.info.b
 * JD-Core Version:    0.7.0.1
 */