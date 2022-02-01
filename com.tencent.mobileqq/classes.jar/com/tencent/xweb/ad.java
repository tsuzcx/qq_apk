package com.tencent.xweb;

import android.content.Context;
import android.os.Bundle;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.xwalk.c;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class ad
{
  static c a;
  static boolean b = false;
  private static boolean c = false;
  
  public static ad.a a(String paramString, Object paramObject)
  {
    ad.a locala = new ad.a();
    if ((paramObject instanceof Bundle))
    {
      localObject = (Bundle)paramObject;
    }
    else if ((paramObject instanceof HashMap))
    {
      localObject = (HashMap)paramObject;
      break label41;
    }
    Object localObject = null;
    label41:
    int i = paramString.hashCode();
    if (i != 208969188)
    {
      if ((i == 755296886) && (paramString.equals("BASE_CONTEXT_CHANGED")))
      {
        i = 1;
        break label91;
      }
    }
    else if (paramString.equals("SET_INIT_ARG"))
    {
      i = 0;
      break label91;
    }
    i = -1;
    label91:
    if (i != 0) {
      if (i != 1)
      {
        locala.a = -1;
        return locala;
      }
    }
    try
    {
      paramString = l.a(WebView.c.b);
      if (paramString == null) {
        break label160;
      }
      paramString.excute("BASE_CONTEXT_CHANGED", new Object[] { paramObject });
      locala.a = 0;
      return locala;
    }
    catch (Exception paramString)
    {
      label146:
      break label146;
    }
    Log.e("XWebSdk", "excute context changed failed");
    return locala;
    XWalkEnvironment.setXWebInitArgs((HashMap)localObject);
    label160:
    return locala;
  }
  
  public static c a()
  {
    try
    {
      c localc = a;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static Object a(int paramInt, Object[] paramArrayOfObject)
  {
    try
    {
      l.a locala = l.a(WebView.c.b);
      if (locala == null) {
        break label44;
      }
      paramArrayOfObject = locala.excute("STR_CMD_INVOKE_TO_RUNTIME", new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      return paramArrayOfObject;
    }
    catch (Exception paramArrayOfObject)
    {
      label37:
      label44:
      break label37;
    }
    Log.e("XWebSdk", "invokeExtension failed");
    return null;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Context localContext = paramContext;
    if (paramContext == null) {}
    label27:
    while (localException != null)
    {
      try
      {
        localContext = XWalkEnvironment.getApplicationContext();
      }
      catch (Exception localException)
      {
        break label27;
      }
      l.a(WebView.getCurWebType()).clearAllWebViewCache(localContext, paramBoolean);
      return;
      paramContext = new StringBuilder();
      paramContext.append("clearAllWebViewCache failed: ");
      paramContext.append(localContext.getMessage());
      Log.e("XWebSdk", paramContext.toString());
      return;
    }
  }
  
  public static void a(ISharedPreferenceProvider paramISharedPreferenceProvider)
  {
    try
    {
      XWalkEnvironment.setSharedPreferenceProvider(paramISharedPreferenceProvider);
      return;
    }
    finally
    {
      paramISharedPreferenceProvider = finally;
      throw paramISharedPreferenceProvider;
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "hasXWebFeature not xwalk now");
      return false;
    }
    Object localObject = a(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean a(long paramLong)
  {
    if (!WebView.isXWalk())
    {
      Log.e("XWebSdk", "bind_native_trans is  not xwalk now");
      return false;
    }
    try
    {
      l.a locala = l.a(WebView.c.b);
      if (locala == null) {
        return false;
      }
      locala.excute("STR_CMD_NATIVE_TRANS_INIT", new Object[] { Long.valueOf(paramLong) });
      return true;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    Log.e("XWebSdk", "invokeExtension failed");
    return true;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 151	com/tencent/xweb/ad:c	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: invokestatic 95	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   20: ifnonnull +14 -> 34
    //   23: ldc 62
    //   25: ldc 153
    //   27: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: invokestatic 95	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   37: invokevirtual 159	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   40: ifnull +28 -> 68
    //   43: invokestatic 95	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   46: invokevirtual 159	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   49: getfield 164	android/content/pm/ApplicationInfo:targetSdkVersion	I
    //   52: bipush 28
    //   54: if_icmpge +14 -> 68
    //   57: ldc 62
    //   59: ldc 166
    //   61: invokestatic 169	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: ldc 2
    //   66: monitorexit
    //   67: return
    //   68: getstatic 174	android/os/Build$VERSION:SDK_INT	I
    //   71: bipush 28
    //   73: if_icmplt +611 -> 684
    //   76: ldc 62
    //   78: ldc 176
    //   80: invokestatic 169	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aconst_null
    //   84: astore 7
    //   86: invokestatic 179	org/xwalk/core/XWalkEnvironment:getProcessName	()Ljava/lang/String;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 5
    //   95: aload 6
    //   97: ldc 181
    //   99: ldc 183
    //   101: invokevirtual 187	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   104: astore 6
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: ldc 189
    //   114: ldc 183
    //   116: invokevirtual 187	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   119: astore 6
    //   121: aload 6
    //   123: astore 5
    //   125: new 106	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   132: astore 8
    //   134: aload 6
    //   136: astore 5
    //   138: aload 8
    //   140: ldc 191
    //   142: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: astore 5
    //   150: aload 8
    //   152: aload 6
    //   154: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 6
    //   160: astore 5
    //   162: ldc 62
    //   164: aload 8
    //   166: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 169	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 6
    //   174: astore 5
    //   176: goto +51 -> 227
    //   179: astore 6
    //   181: goto +8 -> 189
    //   184: astore 6
    //   186: aconst_null
    //   187: astore 5
    //   189: new 106	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   196: astore 8
    //   198: aload 8
    //   200: ldc 193
    //   202: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 8
    //   208: aload 6
    //   210: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   213: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: ldc 62
    //   219: aload 8
    //   221: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: invokestatic 95	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   230: astore 6
    //   232: new 106	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   239: astore 8
    //   241: aload 8
    //   243: ldc 195
    //   245: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 8
    //   251: aload 5
    //   253: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: new 197	java/io/File
    //   260: dup
    //   261: aload 6
    //   263: aload 8
    //   265: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: iconst_0
    //   269: invokevirtual 201	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   272: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   275: ldc 206
    //   277: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: astore 6
    //   282: aload 6
    //   284: invokevirtual 211	java/io/File:exists	()Z
    //   287: ifne +21 -> 308
    //   290: ldc 62
    //   292: ldc 213
    //   294: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: iconst_0
    //   298: istore_0
    //   299: iconst_0
    //   300: istore_1
    //   301: aload 7
    //   303: astore 6
    //   305: goto +36 -> 341
    //   308: new 215	java/io/RandomAccessFile
    //   311: dup
    //   312: aload 6
    //   314: ldc 217
    //   316: invokespecial 220	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   319: invokevirtual 224	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   322: invokevirtual 230	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   325: astore 6
    //   327: aload 6
    //   329: ifnull +8 -> 337
    //   332: iconst_1
    //   333: istore_0
    //   334: goto +5 -> 339
    //   337: iconst_0
    //   338: istore_0
    //   339: iconst_1
    //   340: istore_1
    //   341: iload_0
    //   342: istore_3
    //   343: iload_1
    //   344: istore_2
    //   345: aload 6
    //   347: ifnull +135 -> 482
    //   350: aload 6
    //   352: invokevirtual 235	java/nio/channels/FileLock:release	()V
    //   355: aload 6
    //   357: invokevirtual 238	java/nio/channels/FileLock:close	()V
    //   360: iload_0
    //   361: istore_3
    //   362: iload_1
    //   363: istore_2
    //   364: goto +118 -> 482
    //   367: astore 6
    //   369: new 106	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   376: astore 7
    //   378: aload 7
    //   380: ldc 240
    //   382: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 7
    //   388: aload 6
    //   390: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 62
    //   399: aload 7
    //   401: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: iload_0
    //   408: istore_3
    //   409: iload_1
    //   410: istore_2
    //   411: goto +71 -> 482
    //   414: astore 6
    //   416: iconst_1
    //   417: istore_0
    //   418: goto +12 -> 430
    //   421: astore 5
    //   423: goto +258 -> 681
    //   426: astore 6
    //   428: iconst_0
    //   429: istore_0
    //   430: new 106	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   437: astore 7
    //   439: aload 7
    //   441: ldc 242
    //   443: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 7
    //   449: aload 6
    //   451: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   454: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 62
    //   460: aload 7
    //   462: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: ldc2_w 243
    //   471: ldc2_w 245
    //   474: lconst_1
    //   475: invokestatic 251	com/tencent/xweb/util/h:a	(JJJ)V
    //   478: iconst_0
    //   479: istore_3
    //   480: iload_0
    //   481: istore_2
    //   482: iload_2
    //   483: ifeq +89 -> 572
    //   486: iload_3
    //   487: ifne +85 -> 572
    //   490: new 106	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   497: astore 6
    //   499: aload 6
    //   501: aload 5
    //   503: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload 6
    //   509: invokestatic 254	org/xwalk/core/XWalkEnvironment:getGrayValue	()I
    //   512: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 6
    //   518: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: astore 6
    //   523: new 106	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   530: astore 5
    //   532: aload 5
    //   534: ldc_w 259
    //   537: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 5
    //   543: aload 6
    //   545: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: ldc 62
    //   551: aload 5
    //   553: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: ldc2_w 243
    //   562: ldc2_w 260
    //   565: lconst_1
    //   566: invokestatic 251	com/tencent/xweb/util/h:a	(JJJ)V
    //   569: goto +23 -> 592
    //   572: aload 5
    //   574: astore 6
    //   576: iload_3
    //   577: ifeq +15 -> 592
    //   580: ldc 62
    //   582: ldc_w 263
    //   585: invokestatic 169	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload 5
    //   590: astore 6
    //   592: ldc_w 265
    //   595: ldc_w 267
    //   598: iconst_1
    //   599: anewarray 269	java/lang/Class
    //   602: dup
    //   603: iconst_0
    //   604: ldc 27
    //   606: aastore
    //   607: iconst_1
    //   608: anewarray 4	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: aload 6
    //   615: aastore
    //   616: invokestatic 274	com/tencent/xweb/util/g:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   619: pop
    //   620: iconst_1
    //   621: putstatic 151	com/tencent/xweb/ad:c	Z
    //   624: goto +60 -> 684
    //   627: astore 5
    //   629: new 106	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   636: astore 6
    //   638: aload 6
    //   640: ldc_w 276
    //   643: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload 6
    //   649: aload 5
    //   651: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   654: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: ldc 62
    //   660: aload 6
    //   662: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 70	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: ldc2_w 243
    //   671: ldc2_w 277
    //   674: lconst_1
    //   675: invokestatic 251	com/tencent/xweb/util/h:a	(JJJ)V
    //   678: goto +6 -> 684
    //   681: aload 5
    //   683: athrow
    //   684: ldc 2
    //   686: monitorexit
    //   687: return
    //   688: astore 5
    //   690: ldc 2
    //   692: monitorexit
    //   693: aload 5
    //   695: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   298	183	0	i	int
    //   300	110	1	j	int
    //   344	139	2	k	int
    //   342	235	3	m	int
    //   6	3	4	bool	boolean
    //   93	159	5	str1	String
    //   421	81	5	str2	String
    //   530	59	5	localStringBuilder1	StringBuilder
    //   627	55	5	localException1	Exception
    //   688	6	5	localObject1	Object
    //   89	84	6	str3	String
    //   179	1	6	localException2	Exception
    //   184	25	6	localException3	Exception
    //   230	126	6	localObject2	Object
    //   367	22	6	localException4	Exception
    //   414	1	6	localException5	Exception
    //   426	24	6	localException6	Exception
    //   497	164	6	localObject3	Object
    //   84	377	7	localStringBuilder2	StringBuilder
    //   132	132	8	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   95	106	179	java/lang/Exception
    //   110	121	179	java/lang/Exception
    //   125	134	179	java/lang/Exception
    //   138	146	179	java/lang/Exception
    //   150	158	179	java/lang/Exception
    //   162	172	179	java/lang/Exception
    //   86	91	184	java/lang/Exception
    //   350	360	367	java/lang/Exception
    //   308	327	414	java/lang/Exception
    //   227	297	421	finally
    //   308	327	421	finally
    //   430	478	421	finally
    //   227	297	426	java/lang/Exception
    //   592	624	627	java/lang/Exception
    //   3	8	688	finally
    //   17	30	688	finally
    //   34	64	688	finally
    //   68	83	688	finally
    //   86	91	688	finally
    //   95	106	688	finally
    //   110	121	688	finally
    //   125	134	688	finally
    //   138	146	688	finally
    //   150	158	688	finally
    //   162	172	688	finally
    //   189	227	688	finally
    //   350	360	688	finally
    //   369	407	688	finally
    //   490	569	688	finally
    //   580	588	688	finally
    //   592	624	688	finally
    //   629	678	688	finally
    //   681	684	688	finally
  }
  
  public static boolean c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.ad
 * JD-Core Version:    0.7.0.1
 */