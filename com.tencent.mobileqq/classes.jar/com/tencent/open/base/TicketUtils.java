package com.tencent.open.base;

import com.tencent.open.adapter.CommonDataAdapter;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class TicketUtils
{
  protected TicketUtils.TicketCallback a;
  protected WtloginManager b;
  protected long c;
  protected SSOAccountObserver d = new TicketUtils.1(this);
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(TicketUtils.TicketCallback paramTicketCallback)
  {
    this.a = paramTicketCallback;
  }
  
  public void a(AppRuntime paramAppRuntime, long paramLong, String paramString)
  {
    this.b = ((WtloginManager)paramAppRuntime.getManager(1));
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((WtloginManager)localObject).getPkgSigFromApkName(CommonDataAdapter.a().b(), paramString);
      this.c = paramLong;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(CommonDataAdapter.a().c());
      localStringBuilder.append("");
      paramAppRuntime.ssoGetA1WithA1(localStringBuilder.toString(), paramString.getBytes(), 16L, paramLong, 1L, "5.0".getBytes(), (byte[])localObject, this.d);
    }
  }
  
  /* Error */
  public byte[] a(android.content.Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokevirtual 94	java/lang/Object:getClass	()Ljava/lang/Class;
    //   5: ldc 96
    //   7: iconst_3
    //   8: anewarray 98	java/lang/Class
    //   11: dup
    //   12: iconst_0
    //   13: ldc 100
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: getstatic 106	java/lang/Long:TYPE	Ljava/lang/Class;
    //   21: aastore
    //   22: dup
    //   23: iconst_2
    //   24: getstatic 106	java/lang/Long:TYPE	Ljava/lang/Class;
    //   27: aastore
    //   28: invokevirtual 110	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   31: astore 6
    //   33: aload 6
    //   35: aload_0
    //   36: iconst_3
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: lload_2
    //   47: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: lload 4
    //   55: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aastore
    //   59: invokevirtual 120	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   62: astore 6
    //   64: aload 6
    //   66: instanceof 122
    //   69: ifeq +28 -> 97
    //   72: aload 6
    //   74: checkcast 122	[B
    //   77: checkcast 122	[B
    //   80: astore 6
    //   82: aload 6
    //   84: areturn
    //   85: astore 6
    //   87: goto +5 -> 92
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   97: aload_1
    //   98: ifnonnull +7 -> 105
    //   101: iconst_0
    //   102: newarray byte
    //   104: areturn
    //   105: aload_1
    //   106: invokevirtual 129	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   109: astore 9
    //   111: new 54	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   118: astore_1
    //   119: aload_1
    //   120: ldc 131
    //   122: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: ldc 133
    //   129: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: ldc 135
    //   136: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_1
    //   141: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 141	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   147: astore 10
    //   149: aconst_null
    //   150: astore 8
    //   152: aconst_null
    //   153: astore 7
    //   155: aload 7
    //   157: astore 6
    //   159: aload 8
    //   161: astore_1
    //   162: new 54	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   169: astore 11
    //   171: aload 7
    //   173: astore 6
    //   175: aload 8
    //   177: astore_1
    //   178: aload 11
    //   180: lload_2
    //   181: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 7
    //   187: astore 6
    //   189: aload 8
    //   191: astore_1
    //   192: aload 11
    //   194: ldc 64
    //   196: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 7
    //   202: astore 6
    //   204: aload 8
    //   206: astore_1
    //   207: aload 11
    //   209: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: astore 11
    //   214: aload 7
    //   216: astore 6
    //   218: aload 8
    //   220: astore_1
    //   221: new 54	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   228: astore 12
    //   230: aload 7
    //   232: astore 6
    //   234: aload 8
    //   236: astore_1
    //   237: aload 12
    //   239: lload 4
    //   241: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 7
    //   247: astore 6
    //   249: aload 8
    //   251: astore_1
    //   252: aload 12
    //   254: ldc 64
    //   256: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 7
    //   262: astore 6
    //   264: aload 8
    //   266: astore_1
    //   267: aload 12
    //   269: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: astore 12
    //   274: aload 7
    //   276: astore 6
    //   278: aload 8
    //   280: astore_1
    //   281: aload 9
    //   283: aload 10
    //   285: iconst_5
    //   286: anewarray 73	java/lang/String
    //   289: dup
    //   290: iconst_0
    //   291: ldc 143
    //   293: aastore
    //   294: dup
    //   295: iconst_1
    //   296: ldc 145
    //   298: aastore
    //   299: dup
    //   300: iconst_2
    //   301: ldc 147
    //   303: aastore
    //   304: dup
    //   305: iconst_3
    //   306: ldc 149
    //   308: aastore
    //   309: dup
    //   310: iconst_4
    //   311: ldc 151
    //   313: aastore
    //   314: ldc 153
    //   316: iconst_2
    //   317: anewarray 73	java/lang/String
    //   320: dup
    //   321: iconst_0
    //   322: aload 11
    //   324: aastore
    //   325: dup
    //   326: iconst_1
    //   327: aload 12
    //   329: aastore
    //   330: aconst_null
    //   331: invokevirtual 159	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   334: astore 7
    //   336: aload 7
    //   338: ifnull +143 -> 481
    //   341: aload 7
    //   343: astore 6
    //   345: aload 7
    //   347: astore_1
    //   348: aload 7
    //   350: invokeinterface 165 1 0
    //   355: ifeq +126 -> 481
    //   358: aload 7
    //   360: astore 6
    //   362: aload 7
    //   364: astore_1
    //   365: aload 7
    //   367: aload 7
    //   369: ldc 143
    //   371: invokeinterface 169 2 0
    //   376: invokeinterface 173 2 0
    //   381: pop
    //   382: aload 7
    //   384: astore 6
    //   386: aload 7
    //   388: astore_1
    //   389: aload 7
    //   391: aload 7
    //   393: ldc 149
    //   395: invokeinterface 169 2 0
    //   400: invokeinterface 177 2 0
    //   405: astore 8
    //   407: aload 7
    //   409: astore 6
    //   411: aload 7
    //   413: astore_1
    //   414: aload 7
    //   416: aload 7
    //   418: ldc 151
    //   420: invokeinterface 169 2 0
    //   425: invokeinterface 177 2 0
    //   430: astore 9
    //   432: aload 7
    //   434: astore 6
    //   436: aload 7
    //   438: astore_1
    //   439: aload 8
    //   441: invokestatic 183	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   444: aload 9
    //   446: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifeq +32 -> 481
    //   452: aload 7
    //   454: astore 6
    //   456: aload 7
    //   458: astore_1
    //   459: aload 8
    //   461: invokestatic 191	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   464: astore 8
    //   466: aload 7
    //   468: ifnull +10 -> 478
    //   471: aload 7
    //   473: invokeinterface 194 1 0
    //   478: aload 8
    //   480: areturn
    //   481: aload 7
    //   483: ifnull +40 -> 523
    //   486: aload 7
    //   488: astore_1
    //   489: goto +28 -> 517
    //   492: astore_1
    //   493: goto +36 -> 529
    //   496: astore 7
    //   498: aload_1
    //   499: astore 6
    //   501: ldc 196
    //   503: aload 7
    //   505: invokevirtual 199	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   508: aload 7
    //   510: invokestatic 204	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   513: aload_1
    //   514: ifnull +9 -> 523
    //   517: aload_1
    //   518: invokeinterface 194 1 0
    //   523: ldc 206
    //   525: invokestatic 191	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   528: areturn
    //   529: aload 6
    //   531: ifnull +10 -> 541
    //   534: aload 6
    //   536: invokeinterface 194 1 0
    //   541: aload_1
    //   542: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	TicketUtils
    //   0	543	1	paramContext	android.content.Context
    //   0	543	2	paramLong1	long
    //   0	543	4	paramLong2	long
    //   31	52	6	localObject1	Object
    //   85	1	6	localException1	java.lang.Exception
    //   90	3	6	localException2	java.lang.Exception
    //   157	378	6	localObject2	Object
    //   153	334	7	localCursor	android.database.Cursor
    //   496	13	7	localException3	java.lang.Exception
    //   150	329	8	localObject3	Object
    //   109	336	9	localObject4	Object
    //   147	137	10	localUri	android.net.Uri
    //   169	154	11	localObject5	Object
    //   228	100	12	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   33	82	85	java/lang/Exception
    //   0	33	90	java/lang/Exception
    //   162	171	492	finally
    //   178	185	492	finally
    //   192	200	492	finally
    //   207	214	492	finally
    //   221	230	492	finally
    //   237	245	492	finally
    //   252	260	492	finally
    //   267	274	492	finally
    //   281	336	492	finally
    //   348	358	492	finally
    //   365	382	492	finally
    //   389	407	492	finally
    //   414	432	492	finally
    //   439	452	492	finally
    //   459	466	492	finally
    //   501	513	492	finally
    //   162	171	496	java/lang/Exception
    //   178	185	496	java/lang/Exception
    //   192	200	496	java/lang/Exception
    //   207	214	496	java/lang/Exception
    //   221	230	496	java/lang/Exception
    //   237	245	496	java/lang/Exception
    //   252	260	496	java/lang/Exception
    //   267	274	496	java/lang/Exception
    //   281	336	496	java/lang/Exception
    //   348	358	496	java/lang/Exception
    //   365	382	496	java/lang/Exception
    //   389	407	496	java/lang/Exception
    //   414	432	496	java/lang/Exception
    //   439	452	496	java/lang/Exception
    //   459	466	496	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.TicketUtils
 * JD-Core Version:    0.7.0.1
 */