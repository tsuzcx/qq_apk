package com.tencent.tbs.one.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.e.a.b;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.h;
import com.tencent.tbs.one.impl.e.i;
import java.io.File;

public final class a
{
  private static final Object a = new Object();
  private static boolean b;
  
  public static com.tencent.tbs.one.impl.a.a<e<d>> a(i parami, int paramInt, File paramFile, Bundle paramBundle)
  {
    return new b(parami.a, parami.b, parami.g(), parami.f(), paramInt, paramFile, paramBundle);
  }
  
  public static com.tencent.tbs.one.impl.a.a<e<File>> a(i parami, d.a parama, File paramFile, Bundle paramBundle)
  {
    Context localContext = parami.a;
    String str1 = parami.b;
    String str2 = parami.g();
    parami.f();
    return new com.tencent.tbs.one.impl.e.a.a(localContext, str1, str2, parama, paramFile, paramBundle);
  }
  
  /* Error */
  public static h a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 56	java/io/File
    //   3: dup
    //   4: new 56	java/io/File
    //   7: dup
    //   8: new 56	java/io/File
    //   11: dup
    //   12: new 56	java/io/File
    //   15: dup
    //   16: new 56	java/io/File
    //   19: dup
    //   20: invokestatic 62	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   23: ldc 64
    //   25: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: ldc 69
    //   30: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 74	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: ldc 76
    //   46: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 80	java/io/File:exists	()Z
    //   56: invokestatic 86	com/tencent/tbs/one/impl/common/statistic/StatisticReport:shiftRepService	(Z)V
    //   59: new 29	com/tencent/tbs/one/impl/e/i
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial 89	com/tencent/tbs/one/impl/e/i:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload 4
    //   71: invokevirtual 80	java/io/File:exists	()Z
    //   74: ifeq +95 -> 169
    //   77: aload_3
    //   78: ldc 91
    //   80: ldc 93
    //   82: invokevirtual 96	com/tencent/tbs/one/impl/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   85: aconst_null
    //   86: astore_2
    //   87: new 98	java/io/FileInputStream
    //   90: dup
    //   91: aload 4
    //   93: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore_0
    //   97: new 103	java/util/Properties
    //   100: dup
    //   101: invokespecial 104	java/util/Properties:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: aload_0
    //   107: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   110: aload_2
    //   111: invokevirtual 112	java/util/Properties:entrySet	()Ljava/util/Set;
    //   114: invokeinterface 118 1 0
    //   119: astore_2
    //   120: aload_2
    //   121: invokeinterface 123 1 0
    //   126: ifeq +102 -> 228
    //   129: aload_2
    //   130: invokeinterface 127 1 0
    //   135: checkcast 129	java/util/Map$Entry
    //   138: astore 4
    //   140: aload_3
    //   141: aload 4
    //   143: invokeinterface 132 1 0
    //   148: invokevirtual 135	java/lang/Object:toString	()Ljava/lang/String;
    //   151: aload 4
    //   153: invokeinterface 138 1 0
    //   158: invokevirtual 96	com/tencent/tbs/one/impl/e/i:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   161: goto -41 -> 120
    //   164: astore_2
    //   165: aload_0
    //   166: invokestatic 143	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   169: ldc 145
    //   171: aload_1
    //   172: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   175: ifeq +51 -> 226
    //   178: aload_3
    //   179: getfield 155	com/tencent/tbs/one/impl/e/i:q	Landroid/content/SharedPreferences;
    //   182: astore_2
    //   183: aload_2
    //   184: ldc 157
    //   186: invokeinterface 163 2 0
    //   191: ifne +35 -> 226
    //   194: getstatic 169	com/tencent/tbs/sdk/BuildConfig:COMPONENT_SDK_VERSIONS	Ljava/util/Map;
    //   197: invokeinterface 174 1 0
    //   202: astore_0
    //   203: aload_2
    //   204: invokeinterface 178 1 0
    //   209: astore_2
    //   210: aload_2
    //   211: ldc 157
    //   213: aload_0
    //   214: invokeinterface 184 3 0
    //   219: pop
    //   220: aload_2
    //   221: invokeinterface 187 1 0
    //   226: aload_3
    //   227: areturn
    //   228: aload_0
    //   229: invokestatic 143	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   232: goto -63 -> 169
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_0
    //   239: astore_1
    //   240: aload_2
    //   241: invokestatic 143	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   244: aload_1
    //   245: athrow
    //   246: astore_0
    //   247: ldc 189
    //   249: iconst_2
    //   250: anewarray 4	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload_1
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_0
    //   260: aastore
    //   261: invokestatic 195	com/tencent/tbs/one/impl/a/f:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_3
    //   265: areturn
    //   266: astore_1
    //   267: aload_0
    //   268: astore_2
    //   269: goto -29 -> 240
    //   272: astore_0
    //   273: aload_2
    //   274: astore_0
    //   275: goto -110 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   0	278	1	paramString	String
    //   86	44	2	localObject1	Object
    //   164	1	2	localIOException	java.io.IOException
    //   182	92	2	localObject2	Object
    //   68	197	3	locali	i
    //   49	103	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   97	120	164	java/io/IOException
    //   120	161	164	java/io/IOException
    //   87	97	235	finally
    //   194	226	246	java/lang/Throwable
    //   97	120	266	finally
    //   120	161	266	finally
    //   87	97	272	java/io/IOException
  }
  
  public static void a(Context paramContext)
  {
    synchronized (a)
    {
      if (!b)
      {
        TBSLog.initialize(paramContext.getApplicationContext(), "onelog", 604800000L, 3145728L);
        f.a(new a.1());
        StatisticReport.initialize(paramContext.getApplicationContext());
        com.tencent.tbs.one.impl.common.h.a = new a.2();
        Runtime.getRuntime().addShutdownHook(new com.tencent.tbs.one.impl.e.a(paramContext.getDir("tbs", 0)));
        b = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a
 * JD-Core Version:    0.7.0.1
 */