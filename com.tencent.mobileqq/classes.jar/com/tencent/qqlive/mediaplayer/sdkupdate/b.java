package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class b
{
  private static final int[] a = { 5000, 5000, 10000 };
  private static final int[] b = { 15000, 15000, 20000 };
  private Context c;
  private int d = 0;
  private File e = null;
  private File f = null;
  private File g = null;
  private File h = null;
  private File i = null;
  private File j = null;
  private boolean k = false;
  private SDKLocalConfig l;
  private TVK_SDKMgr.InstallListener m = null;
  
  public b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private int a(SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine, pathString:" + paramString + ", remoteConfig:" + paramSDKLocalConfig);
    d.b(new File(paramString));
    File localFile = new File(paramString, "TvkPlugin.zip");
    localFile.getParentFile().mkdirs();
    try
    {
      int n = ((Integer)Class.forName("com.tencent.mobileqq.transfile.HttpInterfaceForTVK").getDeclaredMethod("downLoadFileSync", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramSDKLocalConfig.URL, localFile.getAbsolutePath() })).intValue();
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine, downResult =  " + n);
      if (n == 0)
      {
        n = a(localFile, paramSDKLocalConfig, paramString);
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine, uzipResult =  " + n);
        this.d = n;
        return this.d;
      }
      this.d = 101;
      n = this.d;
      return n;
    }
    catch (ClassNotFoundException paramSDKLocalConfig)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine ClassNotFoundException, " + paramSDKLocalConfig.toString());
      return 101;
    }
    catch (NoSuchMethodException paramSDKLocalConfig)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine NoSuchMethodException, " + paramSDKLocalConfig.toString());
      return 101;
    }
    catch (Throwable paramSDKLocalConfig)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQHttpEngine Throwable, " + paramSDKLocalConfig.toString());
    }
    return 101;
  }
  
  /* Error */
  private int a(File paramFile, SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: bipush 103
    //   2: istore 4
    //   4: aconst_null
    //   5: astore 9
    //   7: aconst_null
    //   8: astore 12
    //   10: aconst_null
    //   11: astore 13
    //   13: aconst_null
    //   14: astore 11
    //   16: aload_1
    //   17: ifnull +700 -> 717
    //   20: aload_1
    //   21: invokevirtual 173	java/io/File:exists	()Z
    //   24: ifeq +693 -> 717
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   33: invokevirtual 179	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Ljava/lang/String;)Z
    //   36: ifne +36 -> 72
    //   39: iconst_5
    //   40: ldc 64
    //   42: ldc 66
    //   44: new 68	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   51: ldc 181
    //   53: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   60: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   69: iload 4
    //   71: ireturn
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: aload_3
    //   78: invokevirtual 184	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   81: ifne +16 -> 97
    //   84: iconst_5
    //   85: ldc 64
    //   87: ldc 66
    //   89: ldc 186
    //   91: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   94: bipush 103
    //   96: ireturn
    //   97: aload_0
    //   98: iconst_1
    //   99: putfield 51	com/tencent/qqlive/mediaplayer/sdkupdate/b:k	Z
    //   102: iconst_3
    //   103: ldc 64
    //   105: ldc 66
    //   107: ldc 188
    //   109: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 91	java/io/File
    //   115: dup
    //   116: aload_0
    //   117: invokevirtual 190	com/tencent/qqlive/mediaplayer/sdkupdate/b:h	()Ljava/lang/String;
    //   120: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: iconst_5
    //   124: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;I)V
    //   127: aload_0
    //   128: aload_3
    //   129: invokespecial 196	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   132: astore 5
    //   134: aload 5
    //   136: ifnonnull +51 -> 187
    //   139: iconst_5
    //   140: ldc 64
    //   142: ldc 66
    //   144: ldc 198
    //   146: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   149: bipush 103
    //   151: ireturn
    //   152: astore 5
    //   154: iconst_5
    //   155: ldc 64
    //   157: ldc 66
    //   159: new 68	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   166: ldc 200
    //   168: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: invokevirtual 201	java/lang/Object:toString	()Ljava/lang/String;
    //   175: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   184: goto -57 -> 127
    //   187: aload_2
    //   188: aload 5
    //   190: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   193: putfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   196: new 91	java/io/File
    //   199: dup
    //   200: aload_3
    //   201: ldc 209
    //   203: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: astore_3
    //   207: new 211	java/io/ByteArrayOutputStream
    //   210: dup
    //   211: sipush 4096
    //   214: invokespecial 214	java/io/ByteArrayOutputStream:<init>	(I)V
    //   217: astore 5
    //   219: new 216	java/io/ObjectOutputStream
    //   222: dup
    //   223: aload 5
    //   225: invokespecial 219	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   228: astore 10
    //   230: aload 13
    //   232: astore 8
    //   234: aload 10
    //   236: astore 7
    //   238: aload 5
    //   240: astore 6
    //   242: aload 10
    //   244: aload_2
    //   245: invokevirtual 223	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   248: aload 13
    //   250: astore 8
    //   252: aload 10
    //   254: astore 7
    //   256: aload 5
    //   258: astore 6
    //   260: aload 10
    //   262: invokevirtual 226	java/io/ObjectOutputStream:flush	()V
    //   265: aload 13
    //   267: astore 8
    //   269: aload 10
    //   271: astore 7
    //   273: aload 5
    //   275: astore 6
    //   277: aload 10
    //   279: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   282: new 231	java/io/FileOutputStream
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   290: astore_3
    //   291: aload 5
    //   293: aload_3
    //   294: invokevirtual 236	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   297: aload 5
    //   299: invokevirtual 237	java/io/ByteArrayOutputStream:flush	()V
    //   302: aload 5
    //   304: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   307: aload_3
    //   308: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   311: iconst_3
    //   312: ldc 64
    //   314: ldc 66
    //   316: new 68	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   323: ldc 241
    //   325: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_2
    //   329: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   338: iconst_0
    //   339: ifeq +11 -> 350
    //   342: new 243	java/lang/NullPointerException
    //   345: dup
    //   346: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   349: athrow
    //   350: iconst_0
    //   351: ifeq +11 -> 362
    //   354: new 243	java/lang/NullPointerException
    //   357: dup
    //   358: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   361: athrow
    //   362: iconst_0
    //   363: ifeq +11 -> 374
    //   366: new 243	java/lang/NullPointerException
    //   369: dup
    //   370: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   373: athrow
    //   374: aload_1
    //   375: invokevirtual 247	java/io/File:delete	()Z
    //   378: pop
    //   379: iconst_0
    //   380: ireturn
    //   381: astore_2
    //   382: aload_2
    //   383: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   386: goto -36 -> 350
    //   389: astore_2
    //   390: aload_2
    //   391: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   394: goto -32 -> 362
    //   397: astore_2
    //   398: aload_2
    //   399: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   402: goto -28 -> 374
    //   405: astore_3
    //   406: aconst_null
    //   407: astore_2
    //   408: aconst_null
    //   409: astore 5
    //   411: aload 11
    //   413: astore 9
    //   415: aload 9
    //   417: astore 8
    //   419: aload_2
    //   420: astore 7
    //   422: aload 5
    //   424: astore 6
    //   426: iconst_5
    //   427: ldc 64
    //   429: ldc 66
    //   431: new 68	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   438: ldc 252
    //   440: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_3
    //   444: invokevirtual 253	java/io/IOException:toString	()Ljava/lang/String;
    //   447: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload 9
    //   458: astore 8
    //   460: aload_2
    //   461: astore 7
    //   463: aload 5
    //   465: astore 6
    //   467: aload_1
    //   468: invokevirtual 247	java/io/File:delete	()Z
    //   471: pop
    //   472: bipush 104
    //   474: istore 4
    //   476: aload 9
    //   478: ifnull +8 -> 486
    //   481: aload 9
    //   483: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   486: aload_2
    //   487: ifnull +7 -> 494
    //   490: aload_2
    //   491: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   494: aload 5
    //   496: ifnull -427 -> 69
    //   499: aload 5
    //   501: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   504: bipush 104
    //   506: ireturn
    //   507: astore_1
    //   508: aload_1
    //   509: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   512: bipush 104
    //   514: ireturn
    //   515: astore_1
    //   516: aload_1
    //   517: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   520: goto -34 -> 486
    //   523: astore_1
    //   524: aload_1
    //   525: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   528: goto -34 -> 494
    //   531: astore_3
    //   532: aconst_null
    //   533: astore_2
    //   534: aconst_null
    //   535: astore 5
    //   537: aload 9
    //   539: astore 8
    //   541: aload_2
    //   542: astore 7
    //   544: aload 5
    //   546: astore 6
    //   548: iconst_5
    //   549: ldc 64
    //   551: ldc 66
    //   553: new 68	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   560: ldc 255
    //   562: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload_3
    //   566: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   569: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload 9
    //   580: astore 8
    //   582: aload_2
    //   583: astore 7
    //   585: aload 5
    //   587: astore 6
    //   589: aload_1
    //   590: invokevirtual 247	java/io/File:delete	()Z
    //   593: pop
    //   594: bipush 100
    //   596: istore 4
    //   598: aload 9
    //   600: ifnull +8 -> 608
    //   603: aload 9
    //   605: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   608: aload_2
    //   609: ifnull +7 -> 616
    //   612: aload_2
    //   613: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   616: aload 5
    //   618: ifnull -549 -> 69
    //   621: aload 5
    //   623: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   626: bipush 100
    //   628: ireturn
    //   629: astore_1
    //   630: aload_1
    //   631: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   634: bipush 100
    //   636: ireturn
    //   637: astore_1
    //   638: aload_1
    //   639: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   642: goto -34 -> 608
    //   645: astore_1
    //   646: aload_1
    //   647: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   650: goto -34 -> 616
    //   653: astore_1
    //   654: aconst_null
    //   655: astore_2
    //   656: aconst_null
    //   657: astore 5
    //   659: aload 12
    //   661: astore 8
    //   663: aload 8
    //   665: ifnull +8 -> 673
    //   668: aload 8
    //   670: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   673: aload_2
    //   674: ifnull +7 -> 681
    //   677: aload_2
    //   678: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   681: aload 5
    //   683: ifnull +8 -> 691
    //   686: aload 5
    //   688: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   691: aload_1
    //   692: athrow
    //   693: astore_3
    //   694: aload_3
    //   695: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   698: goto -25 -> 673
    //   701: astore_2
    //   702: aload_2
    //   703: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   706: goto -25 -> 681
    //   709: astore_2
    //   710: aload_2
    //   711: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   714: goto -23 -> 691
    //   717: iconst_5
    //   718: ldc 64
    //   720: ldc 66
    //   722: new 68	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 258
    //   732: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_1
    //   736: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   745: bipush 103
    //   747: ireturn
    //   748: astore_1
    //   749: aconst_null
    //   750: astore_2
    //   751: aload 12
    //   753: astore 8
    //   755: goto -92 -> 663
    //   758: astore_1
    //   759: aload 7
    //   761: astore_2
    //   762: aload 6
    //   764: astore 5
    //   766: goto -103 -> 663
    //   769: astore_1
    //   770: aconst_null
    //   771: astore_2
    //   772: aload_3
    //   773: astore 8
    //   775: goto -112 -> 663
    //   778: astore_1
    //   779: aconst_null
    //   780: astore 5
    //   782: aconst_null
    //   783: astore_2
    //   784: aload_3
    //   785: astore 8
    //   787: goto -124 -> 663
    //   790: astore_3
    //   791: aconst_null
    //   792: astore_2
    //   793: goto -256 -> 537
    //   796: astore_3
    //   797: aload 10
    //   799: astore_2
    //   800: goto -263 -> 537
    //   803: astore 6
    //   805: aconst_null
    //   806: astore_2
    //   807: aload_3
    //   808: astore 9
    //   810: aload 6
    //   812: astore_3
    //   813: goto -276 -> 537
    //   816: astore 6
    //   818: aconst_null
    //   819: astore 5
    //   821: aload_3
    //   822: astore 9
    //   824: aconst_null
    //   825: astore_2
    //   826: aload 6
    //   828: astore_3
    //   829: goto -292 -> 537
    //   832: astore_3
    //   833: aconst_null
    //   834: astore_2
    //   835: aload 11
    //   837: astore 9
    //   839: goto -424 -> 415
    //   842: astore_3
    //   843: aload 11
    //   845: astore 9
    //   847: aload 10
    //   849: astore_2
    //   850: goto -435 -> 415
    //   853: astore 6
    //   855: aconst_null
    //   856: astore_2
    //   857: aload_3
    //   858: astore 9
    //   860: aload 6
    //   862: astore_3
    //   863: goto -448 -> 415
    //   866: astore 6
    //   868: aconst_null
    //   869: astore 5
    //   871: aload_3
    //   872: astore 9
    //   874: aconst_null
    //   875: astore_2
    //   876: aload 6
    //   878: astore_3
    //   879: goto -464 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	b
    //   0	882	1	paramFile	File
    //   0	882	2	paramSDKLocalConfig	SDKLocalConfig
    //   0	882	3	paramString	String
    //   2	595	4	n	int
    //   132	3	5	localFile	File
    //   152	37	5	localThrowable	Throwable
    //   217	653	5	localObject1	Object
    //   240	523	6	localObject2	Object
    //   803	8	6	localException1	Exception
    //   816	11	6	localException2	Exception
    //   853	8	6	localIOException1	java.io.IOException
    //   866	11	6	localIOException2	java.io.IOException
    //   236	524	7	localObject3	Object
    //   232	554	8	localObject4	Object
    //   5	868	9	localObject5	Object
    //   228	620	10	localObjectOutputStream	java.io.ObjectOutputStream
    //   14	830	11	localObject6	Object
    //   8	744	12	localObject7	Object
    //   11	255	13	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   102	127	152	java/lang/Throwable
    //   342	350	381	java/io/IOException
    //   354	362	389	java/io/IOException
    //   366	374	397	java/io/IOException
    //   196	219	405	java/io/IOException
    //   311	338	405	java/io/IOException
    //   499	504	507	java/io/IOException
    //   481	486	515	java/io/IOException
    //   490	494	523	java/io/IOException
    //   196	219	531	java/lang/Exception
    //   311	338	531	java/lang/Exception
    //   621	626	629	java/io/IOException
    //   603	608	637	java/io/IOException
    //   612	616	645	java/io/IOException
    //   196	219	653	finally
    //   311	338	653	finally
    //   668	673	693	java/io/IOException
    //   677	681	701	java/io/IOException
    //   686	691	709	java/io/IOException
    //   219	230	748	finally
    //   282	291	748	finally
    //   242	248	758	finally
    //   260	265	758	finally
    //   277	282	758	finally
    //   426	456	758	finally
    //   467	472	758	finally
    //   548	578	758	finally
    //   589	594	758	finally
    //   291	307	769	finally
    //   307	311	778	finally
    //   219	230	790	java/lang/Exception
    //   282	291	790	java/lang/Exception
    //   242	248	796	java/lang/Exception
    //   260	265	796	java/lang/Exception
    //   277	282	796	java/lang/Exception
    //   291	307	803	java/lang/Exception
    //   307	311	816	java/lang/Exception
    //   219	230	832	java/io/IOException
    //   282	291	832	java/io/IOException
    //   242	248	842	java/io/IOException
    //   260	265	842	java/io/IOException
    //   277	282	842	java/io/IOException
    //   291	307	853	java/io/IOException
    //   307	311	866	java/io/IOException
  }
  
  private File a(String paramString)
  {
    if (paramString.contains("TencentVideoKitUpdate")) {}
    for (paramString = this.f;; paramString = this.e)
    {
      paramString = b(paramString, "TVK_MediaPlayer");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      return new File(paramString);
    }
    return null;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 10
    //   17: aconst_null
    //   18: astore 4
    //   20: new 279	java/net/URL
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 280	java/net/URL:<init>	(Ljava/lang/String;)V
    //   28: invokevirtual 284	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   31: checkcast 286	java/net/HttpURLConnection
    //   34: astore_1
    //   35: iload_2
    //   36: ifne +37 -> 73
    //   39: aload 8
    //   41: astore 5
    //   43: aload 9
    //   45: astore 6
    //   47: aload 10
    //   49: astore 7
    //   51: aload_1
    //   52: iconst_1
    //   53: invokevirtual 290	java/net/HttpURLConnection:setDoInput	(Z)V
    //   56: aload 8
    //   58: astore 5
    //   60: aload 9
    //   62: astore 6
    //   64: aload 10
    //   66: astore 7
    //   68: aload_1
    //   69: iconst_1
    //   70: invokevirtual 293	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   73: aload 8
    //   75: astore 5
    //   77: aload 9
    //   79: astore 6
    //   81: aload 10
    //   83: astore 7
    //   85: aload_1
    //   86: iconst_0
    //   87: invokevirtual 296	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   90: aload 8
    //   92: astore 5
    //   94: aload 9
    //   96: astore 6
    //   98: aload 10
    //   100: astore 7
    //   102: aload_1
    //   103: ldc_w 298
    //   106: invokevirtual 301	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   109: aload 8
    //   111: astore 5
    //   113: aload 9
    //   115: astore 6
    //   117: aload 10
    //   119: astore 7
    //   121: aload_1
    //   122: invokevirtual 305	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   125: astore_3
    //   126: aload_3
    //   127: astore 5
    //   129: aload_3
    //   130: astore 6
    //   132: aload_3
    //   133: astore 7
    //   135: new 307	java/io/BufferedReader
    //   138: dup
    //   139: new 309	java/io/InputStreamReader
    //   142: dup
    //   143: aload_3
    //   144: invokespecial 312	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   147: invokespecial 315	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   150: astore 8
    //   152: ldc_w 317
    //   155: astore 4
    //   157: aload_3
    //   158: astore 5
    //   160: aload 8
    //   162: invokevirtual 320	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull +41 -> 210
    //   172: aload_3
    //   173: astore 5
    //   175: new 68	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   182: aload 4
    //   184: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 6
    //   189: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 322
    //   195: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 6
    //   203: aload 6
    //   205: astore 4
    //   207: goto -50 -> 157
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 325	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: ifnull +426 -> 645
    //   222: aload_1
    //   223: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   226: aload 4
    //   228: astore_3
    //   229: aload_3
    //   230: areturn
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   236: goto -18 -> 218
    //   239: astore 5
    //   241: ldc_w 317
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_3
    //   247: iconst_5
    //   248: ldc 64
    //   250: ldc 66
    //   252: new 68	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 330
    //   262: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 5
    //   267: invokevirtual 331	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   270: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload_3
    //   280: ifnull +7 -> 287
    //   283: aload_3
    //   284: invokevirtual 325	java/io/InputStream:close	()V
    //   287: aload_1
    //   288: astore_3
    //   289: aload 4
    //   291: ifnull -62 -> 229
    //   294: aload 4
    //   296: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_1
    //   300: areturn
    //   301: astore_3
    //   302: aload_3
    //   303: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   306: goto -19 -> 287
    //   309: astore 8
    //   311: ldc_w 317
    //   314: astore_1
    //   315: aconst_null
    //   316: astore 4
    //   318: aload 4
    //   320: astore 6
    //   322: aload_3
    //   323: astore 5
    //   325: iconst_5
    //   326: ldc 64
    //   328: ldc 66
    //   330: new 68	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 333
    //   340: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 8
    //   345: invokevirtual 253	java/io/IOException:toString	()Ljava/lang/String;
    //   348: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_3
    //   358: ifnull +7 -> 365
    //   361: aload_3
    //   362: invokevirtual 325	java/io/InputStream:close	()V
    //   365: aload_1
    //   366: astore_3
    //   367: aload 4
    //   369: ifnull -140 -> 229
    //   372: aload 4
    //   374: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   377: aload_1
    //   378: areturn
    //   379: astore_3
    //   380: aload_3
    //   381: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   384: goto -19 -> 365
    //   387: astore 7
    //   389: ldc_w 317
    //   392: astore_1
    //   393: aconst_null
    //   394: astore 4
    //   396: aload 5
    //   398: astore_3
    //   399: aload 4
    //   401: astore 6
    //   403: aload_3
    //   404: astore 5
    //   406: iconst_5
    //   407: ldc 64
    //   409: ldc 66
    //   411: new 68	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 335
    //   421: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 7
    //   426: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   429: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_3
    //   439: ifnull +7 -> 446
    //   442: aload_3
    //   443: invokevirtual 325	java/io/InputStream:close	()V
    //   446: aload_1
    //   447: astore_3
    //   448: aload 4
    //   450: ifnull -221 -> 229
    //   453: aload 4
    //   455: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   458: aload_1
    //   459: areturn
    //   460: astore_3
    //   461: aload_3
    //   462: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   465: goto -19 -> 446
    //   468: astore_1
    //   469: aconst_null
    //   470: astore_3
    //   471: aload 6
    //   473: astore 4
    //   475: aload 4
    //   477: ifnull +8 -> 485
    //   480: aload 4
    //   482: invokevirtual 325	java/io/InputStream:close	()V
    //   485: aload_3
    //   486: ifnull +7 -> 493
    //   489: aload_3
    //   490: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   493: aload_1
    //   494: athrow
    //   495: astore 4
    //   497: aload 4
    //   499: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   502: goto -17 -> 485
    //   505: astore 4
    //   507: aload_1
    //   508: astore_3
    //   509: aload 4
    //   511: astore_1
    //   512: aload 5
    //   514: astore 4
    //   516: goto -41 -> 475
    //   519: astore_1
    //   520: aload_3
    //   521: astore 5
    //   523: aload 4
    //   525: astore_3
    //   526: aload 5
    //   528: astore 4
    //   530: goto -55 -> 475
    //   533: astore_1
    //   534: aload 6
    //   536: astore_3
    //   537: aload 5
    //   539: astore 4
    //   541: goto -66 -> 475
    //   544: astore 7
    //   546: aload_1
    //   547: astore 4
    //   549: ldc_w 317
    //   552: astore_1
    //   553: aload 6
    //   555: astore_3
    //   556: goto -157 -> 399
    //   559: astore 7
    //   561: aload_1
    //   562: astore 5
    //   564: aload 4
    //   566: astore_1
    //   567: aload 5
    //   569: astore 4
    //   571: goto -172 -> 399
    //   574: astore 8
    //   576: aload_1
    //   577: astore 4
    //   579: ldc_w 317
    //   582: astore_1
    //   583: aload 7
    //   585: astore_3
    //   586: goto -268 -> 318
    //   589: astore 8
    //   591: aload_1
    //   592: astore 5
    //   594: aload 4
    //   596: astore_1
    //   597: aload 5
    //   599: astore 4
    //   601: goto -283 -> 318
    //   604: astore 5
    //   606: aconst_null
    //   607: astore_3
    //   608: aload_1
    //   609: astore 4
    //   611: ldc_w 317
    //   614: astore_1
    //   615: goto -368 -> 247
    //   618: astore 5
    //   620: aload_1
    //   621: astore 4
    //   623: ldc_w 317
    //   626: astore_1
    //   627: goto -380 -> 247
    //   630: astore 5
    //   632: aload_1
    //   633: astore 6
    //   635: aload 4
    //   637: astore_1
    //   638: aload 6
    //   640: astore 4
    //   642: goto -395 -> 247
    //   645: aload 4
    //   647: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	b
    //   0	648	1	paramString	String
    //   0	648	2	paramBoolean	boolean
    //   1	229	3	localObject1	Object
    //   231	2	3	localIOException1	java.io.IOException
    //   246	43	3	str1	String
    //   301	61	3	localIOException2	java.io.IOException
    //   366	1	3	str2	String
    //   379	2	3	localIOException3	java.io.IOException
    //   398	50	3	localObject2	Object
    //   460	2	3	localIOException4	java.io.IOException
    //   470	138	3	localObject3	Object
    //   18	463	4	localObject4	Object
    //   495	3	4	localIOException5	java.io.IOException
    //   505	5	4	localObject5	Object
    //   514	132	4	localObject6	Object
    //   3	171	5	localObject7	Object
    //   239	27	5	localMalformedURLException1	java.net.MalformedURLException
    //   323	275	5	localObject8	Object
    //   604	1	5	localMalformedURLException2	java.net.MalformedURLException
    //   618	1	5	localMalformedURLException3	java.net.MalformedURLException
    //   630	1	5	localMalformedURLException4	java.net.MalformedURLException
    //   6	633	6	localObject9	Object
    //   49	85	7	localObject10	Object
    //   387	38	7	localException1	Exception
    //   544	1	7	localException2	Exception
    //   559	25	7	localException3	Exception
    //   9	152	8	localBufferedReader	java.io.BufferedReader
    //   309	35	8	localIOException6	java.io.IOException
    //   574	1	8	localIOException7	java.io.IOException
    //   589	1	8	localIOException8	java.io.IOException
    //   12	102	9	localObject11	Object
    //   15	103	10	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   214	218	231	java/io/IOException
    //   20	35	239	java/net/MalformedURLException
    //   283	287	301	java/io/IOException
    //   20	35	309	java/io/IOException
    //   361	365	379	java/io/IOException
    //   20	35	387	java/lang/Exception
    //   442	446	460	java/io/IOException
    //   20	35	468	finally
    //   480	485	495	java/io/IOException
    //   51	56	505	finally
    //   68	73	505	finally
    //   85	90	505	finally
    //   102	109	505	finally
    //   121	126	505	finally
    //   135	152	505	finally
    //   160	167	505	finally
    //   175	203	505	finally
    //   247	279	519	finally
    //   325	357	533	finally
    //   406	438	533	finally
    //   51	56	544	java/lang/Exception
    //   68	73	544	java/lang/Exception
    //   85	90	544	java/lang/Exception
    //   102	109	544	java/lang/Exception
    //   121	126	544	java/lang/Exception
    //   135	152	544	java/lang/Exception
    //   160	167	559	java/lang/Exception
    //   175	203	559	java/lang/Exception
    //   51	56	574	java/io/IOException
    //   68	73	574	java/io/IOException
    //   85	90	574	java/io/IOException
    //   102	109	574	java/io/IOException
    //   121	126	574	java/io/IOException
    //   135	152	574	java/io/IOException
    //   160	167	589	java/io/IOException
    //   175	203	589	java/io/IOException
    //   51	56	604	java/net/MalformedURLException
    //   68	73	604	java/net/MalformedURLException
    //   85	90	604	java/net/MalformedURLException
    //   102	109	604	java/net/MalformedURLException
    //   121	126	604	java/net/MalformedURLException
    //   135	152	618	java/net/MalformedURLException
    //   160	167	630	java/net/MalformedURLException
    //   175	203	630	java/net/MalformedURLException
  }
  
  /* Error */
  private int b(SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: iload_3
    //   3: iconst_1
    //   4: isub
    //   5: istore 4
    //   7: iload_3
    //   8: ifle +3443 -> 3451
    //   11: aload_0
    //   12: getfield 55	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	Landroid/content/Context;
    //   15: invokestatic 342	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Landroid/content/Context;)Z
    //   18: ifne +25 -> 43
    //   21: iload 4
    //   23: iconst_2
    //   24: if_icmpge +19 -> 43
    //   27: iconst_5
    //   28: ldc 64
    //   30: ldc 66
    //   32: ldc_w 344
    //   35: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   38: bipush 101
    //   40: istore_3
    //   41: iload_3
    //   42: ireturn
    //   43: iconst_3
    //   44: ldc 64
    //   46: ldc 66
    //   48: new 68	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 346
    //   58: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iconst_2
    //   62: iload 4
    //   64: isub
    //   65: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc_w 348
    //   71: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 77
    //   80: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   93: aconst_null
    //   94: astore 23
    //   96: aconst_null
    //   97: astore 21
    //   99: aconst_null
    //   100: astore 10
    //   102: aconst_null
    //   103: astore 18
    //   105: aconst_null
    //   106: astore 17
    //   108: aconst_null
    //   109: astore 16
    //   111: aconst_null
    //   112: astore 9
    //   114: aconst_null
    //   115: astore 20
    //   117: aconst_null
    //   118: astore 22
    //   120: aconst_null
    //   121: astore 19
    //   123: aload 20
    //   125: astore 13
    //   127: aload 23
    //   129: astore 14
    //   131: aload 21
    //   133: astore 15
    //   135: aload 22
    //   137: astore 11
    //   139: aload 10
    //   141: astore 12
    //   143: new 91	java/io/File
    //   146: dup
    //   147: aload_2
    //   148: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   154: aload 20
    //   156: astore 13
    //   158: aload 23
    //   160: astore 14
    //   162: aload 21
    //   164: astore 15
    //   166: aload 22
    //   168: astore 11
    //   170: aload 10
    //   172: astore 12
    //   174: new 91	java/io/File
    //   177: dup
    //   178: aload_2
    //   179: ldc 99
    //   181: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: astore 24
    //   186: aload 20
    //   188: astore 13
    //   190: aload 23
    //   192: astore 14
    //   194: aload 21
    //   196: astore 15
    //   198: aload 22
    //   200: astore 11
    //   202: aload 10
    //   204: astore 12
    //   206: aload 24
    //   208: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   211: invokevirtual 110	java/io/File:mkdirs	()Z
    //   214: pop
    //   215: aload 20
    //   217: astore 13
    //   219: aload 23
    //   221: astore 14
    //   223: aload 21
    //   225: astore 15
    //   227: aload 22
    //   229: astore 11
    //   231: aload 10
    //   233: astore 12
    //   235: new 279	java/net/URL
    //   238: dup
    //   239: aload_1
    //   240: getfield 132	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:URL	Ljava/lang/String;
    //   243: invokespecial 280	java/net/URL:<init>	(Ljava/lang/String;)V
    //   246: invokevirtual 284	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   249: checkcast 286	java/net/HttpURLConnection
    //   252: astore 25
    //   254: aload 25
    //   256: ifnonnull +237 -> 493
    //   259: aload 20
    //   261: astore 13
    //   263: aload 23
    //   265: astore 14
    //   267: aload 21
    //   269: astore 15
    //   271: aload 22
    //   273: astore 11
    //   275: aload 10
    //   277: astore 12
    //   279: iconst_5
    //   280: ldc 64
    //   282: ldc 66
    //   284: ldc_w 350
    //   287: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   290: iload 4
    //   292: ifne +100 -> 392
    //   295: bipush 101
    //   297: istore_3
    //   298: iconst_0
    //   299: ifeq +11 -> 310
    //   302: new 243	java/lang/NullPointerException
    //   305: dup
    //   306: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   309: athrow
    //   310: iconst_0
    //   311: ifeq -270 -> 41
    //   314: new 243	java/lang/NullPointerException
    //   317: dup
    //   318: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   321: athrow
    //   322: astore_1
    //   323: iconst_5
    //   324: ldc 64
    //   326: ldc 66
    //   328: new 68	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 352
    //   338: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_1
    //   342: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   345: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: bipush 101
    //   356: ireturn
    //   357: astore_1
    //   358: iconst_5
    //   359: ldc 64
    //   361: ldc 66
    //   363: new 68	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 354
    //   373: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_1
    //   377: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   380: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   389: goto -79 -> 310
    //   392: iconst_0
    //   393: ifeq +11 -> 404
    //   396: new 243	java/lang/NullPointerException
    //   399: dup
    //   400: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   403: athrow
    //   404: iconst_0
    //   405: ifeq +3153 -> 3558
    //   408: new 243	java/lang/NullPointerException
    //   411: dup
    //   412: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   415: athrow
    //   416: astore 9
    //   418: iconst_5
    //   419: ldc 64
    //   421: ldc 66
    //   423: new 68	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   430: ldc_w 354
    //   433: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 9
    //   438: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   441: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   450: goto -46 -> 404
    //   453: astore 9
    //   455: iconst_5
    //   456: ldc 64
    //   458: ldc 66
    //   460: new 68	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 352
    //   470: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 9
    //   475: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   478: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   487: iload 4
    //   489: istore_3
    //   490: goto -488 -> 2
    //   493: aload 20
    //   495: astore 13
    //   497: aload 23
    //   499: astore 14
    //   501: aload 21
    //   503: astore 15
    //   505: aload 22
    //   507: astore 11
    //   509: aload 10
    //   511: astore 12
    //   513: new 231	java/io/FileOutputStream
    //   516: dup
    //   517: aload 24
    //   519: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   522: astore 10
    //   524: aload 18
    //   526: astore 14
    //   528: aload 17
    //   530: astore 12
    //   532: aload 16
    //   534: astore 11
    //   536: aload 9
    //   538: astore 13
    //   540: aload 25
    //   542: invokevirtual 357	java/net/HttpURLConnection:getResponseCode	()I
    //   545: istore_3
    //   546: iload_3
    //   547: sipush 300
    //   550: if_icmple +299 -> 849
    //   553: iload 4
    //   555: ifne +145 -> 700
    //   558: aload 18
    //   560: astore 14
    //   562: aload 17
    //   564: astore 12
    //   566: aload 16
    //   568: astore 11
    //   570: aload 9
    //   572: astore 13
    //   574: iconst_5
    //   575: ldc 64
    //   577: ldc 66
    //   579: new 68	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 359
    //   589: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload_3
    //   593: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   602: bipush 102
    //   604: istore_3
    //   605: iconst_0
    //   606: ifeq +11 -> 617
    //   609: new 243	java/lang/NullPointerException
    //   612: dup
    //   613: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   616: athrow
    //   617: aload 10
    //   619: ifnull -578 -> 41
    //   622: aload 10
    //   624: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   627: bipush 102
    //   629: ireturn
    //   630: astore_1
    //   631: iconst_5
    //   632: ldc 64
    //   634: ldc 66
    //   636: new 68	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 352
    //   646: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_1
    //   650: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   653: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   662: bipush 102
    //   664: ireturn
    //   665: astore_1
    //   666: iconst_5
    //   667: ldc 64
    //   669: ldc 66
    //   671: new 68	java/lang/StringBuilder
    //   674: dup
    //   675: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   678: ldc_w 354
    //   681: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_1
    //   685: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   688: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   697: goto -80 -> 617
    //   700: aload 18
    //   702: astore 14
    //   704: aload 17
    //   706: astore 12
    //   708: aload 16
    //   710: astore 11
    //   712: aload 9
    //   714: astore 13
    //   716: iconst_3
    //   717: ldc 64
    //   719: ldc 66
    //   721: new 68	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 361
    //   731: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: iload_3
    //   735: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   744: iconst_0
    //   745: ifeq +11 -> 756
    //   748: new 243	java/lang/NullPointerException
    //   751: dup
    //   752: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   755: athrow
    //   756: aload 10
    //   758: ifnull +2800 -> 3558
    //   761: aload 10
    //   763: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   766: iload 4
    //   768: istore_3
    //   769: goto -767 -> 2
    //   772: astore 9
    //   774: iconst_5
    //   775: ldc 64
    //   777: ldc 66
    //   779: new 68	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 354
    //   789: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload 9
    //   794: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   797: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   806: goto -50 -> 756
    //   809: astore 9
    //   811: iconst_5
    //   812: ldc 64
    //   814: ldc 66
    //   816: new 68	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   823: ldc_w 352
    //   826: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload 9
    //   831: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   834: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   843: iload 4
    //   845: istore_3
    //   846: goto -844 -> 2
    //   849: aload 18
    //   851: astore 14
    //   853: aload 17
    //   855: astore 12
    //   857: aload 16
    //   859: astore 11
    //   861: aload 9
    //   863: astore 13
    //   865: aload 25
    //   867: ldc_w 363
    //   870: invokevirtual 367	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   873: invokestatic 371	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   876: i2l
    //   877: lstore 7
    //   879: lload 7
    //   881: lconst_0
    //   882: lcmp
    //   883: ifne +238 -> 1121
    //   886: aload 18
    //   888: astore 14
    //   890: aload 17
    //   892: astore 12
    //   894: aload 16
    //   896: astore 11
    //   898: aload 9
    //   900: astore 13
    //   902: iconst_5
    //   903: ldc 64
    //   905: ldc 66
    //   907: ldc_w 373
    //   910: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   913: iload 4
    //   915: ifne +101 -> 1016
    //   918: bipush 103
    //   920: istore_3
    //   921: iconst_0
    //   922: ifeq +11 -> 933
    //   925: new 243	java/lang/NullPointerException
    //   928: dup
    //   929: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   932: athrow
    //   933: aload 10
    //   935: ifnull -894 -> 41
    //   938: aload 10
    //   940: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   943: bipush 103
    //   945: ireturn
    //   946: astore_1
    //   947: iconst_5
    //   948: ldc 64
    //   950: ldc 66
    //   952: new 68	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   959: ldc_w 352
    //   962: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: aload_1
    //   966: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   969: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   978: bipush 103
    //   980: ireturn
    //   981: astore_1
    //   982: iconst_5
    //   983: ldc 64
    //   985: ldc 66
    //   987: new 68	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   994: ldc_w 354
    //   997: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: aload_1
    //   1001: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1004: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1013: goto -80 -> 933
    //   1016: iconst_0
    //   1017: ifeq +11 -> 1028
    //   1020: new 243	java/lang/NullPointerException
    //   1023: dup
    //   1024: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   1027: athrow
    //   1028: aload 10
    //   1030: ifnull +2528 -> 3558
    //   1033: aload 10
    //   1035: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1038: iload 4
    //   1040: istore_3
    //   1041: goto -1039 -> 2
    //   1044: astore 9
    //   1046: iconst_5
    //   1047: ldc 64
    //   1049: ldc 66
    //   1051: new 68	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 354
    //   1061: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload 9
    //   1066: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1069: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1078: goto -50 -> 1028
    //   1081: astore 9
    //   1083: iconst_5
    //   1084: ldc 64
    //   1086: ldc 66
    //   1088: new 68	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 352
    //   1098: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload 9
    //   1103: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1106: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1115: iload 4
    //   1117: istore_3
    //   1118: goto -1116 -> 2
    //   1121: lconst_0
    //   1122: lstore 5
    //   1124: aload 18
    //   1126: astore 14
    //   1128: aload 17
    //   1130: astore 12
    //   1132: aload 16
    //   1134: astore 11
    //   1136: aload 9
    //   1138: astore 13
    //   1140: aload 25
    //   1142: invokevirtual 305	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1145: astore 9
    //   1147: aload 9
    //   1149: ifnonnull +234 -> 1383
    //   1152: iload 4
    //   1154: ifne +126 -> 1280
    //   1157: aload 9
    //   1159: astore 14
    //   1161: aload 9
    //   1163: astore 12
    //   1165: aload 9
    //   1167: astore 11
    //   1169: aload 9
    //   1171: astore 13
    //   1173: iconst_5
    //   1174: ldc 64
    //   1176: ldc 66
    //   1178: ldc_w 375
    //   1181: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1184: bipush 103
    //   1186: istore_3
    //   1187: aload 9
    //   1189: ifnull +8 -> 1197
    //   1192: aload 9
    //   1194: invokevirtual 325	java/io/InputStream:close	()V
    //   1197: aload 10
    //   1199: ifnull -1158 -> 41
    //   1202: aload 10
    //   1204: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1207: bipush 103
    //   1209: ireturn
    //   1210: astore_1
    //   1211: iconst_5
    //   1212: ldc 64
    //   1214: ldc 66
    //   1216: new 68	java/lang/StringBuilder
    //   1219: dup
    //   1220: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1223: ldc_w 352
    //   1226: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_1
    //   1230: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1233: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1239: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1242: bipush 103
    //   1244: ireturn
    //   1245: astore_1
    //   1246: iconst_5
    //   1247: ldc 64
    //   1249: ldc 66
    //   1251: new 68	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1258: ldc_w 354
    //   1261: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload_1
    //   1265: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1268: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1277: goto -80 -> 1197
    //   1280: aload 9
    //   1282: ifnull +8 -> 1290
    //   1285: aload 9
    //   1287: invokevirtual 325	java/io/InputStream:close	()V
    //   1290: aload 10
    //   1292: ifnull +2266 -> 3558
    //   1295: aload 10
    //   1297: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1300: iload 4
    //   1302: istore_3
    //   1303: goto -1301 -> 2
    //   1306: astore 9
    //   1308: iconst_5
    //   1309: ldc 64
    //   1311: ldc 66
    //   1313: new 68	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1320: ldc_w 354
    //   1323: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: aload 9
    //   1328: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1331: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1340: goto -50 -> 1290
    //   1343: astore 9
    //   1345: iconst_5
    //   1346: ldc 64
    //   1348: ldc 66
    //   1350: new 68	java/lang/StringBuilder
    //   1353: dup
    //   1354: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1357: ldc_w 352
    //   1360: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload 9
    //   1365: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1368: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1374: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1377: iload 4
    //   1379: istore_3
    //   1380: goto -1378 -> 2
    //   1383: aload 9
    //   1385: astore 14
    //   1387: aload 9
    //   1389: astore 12
    //   1391: aload 9
    //   1393: astore 11
    //   1395: aload 9
    //   1397: astore 13
    //   1399: sipush 8192
    //   1402: newarray byte
    //   1404: astore 15
    //   1406: aload 9
    //   1408: astore 14
    //   1410: aload 9
    //   1412: astore 12
    //   1414: aload 9
    //   1416: astore 11
    //   1418: aload 9
    //   1420: astore 13
    //   1422: aload 9
    //   1424: aload 15
    //   1426: iconst_0
    //   1427: sipush 8192
    //   1430: invokevirtual 379	java/io/InputStream:read	([BII)I
    //   1433: istore_3
    //   1434: iload_3
    //   1435: iconst_m1
    //   1436: if_icmple +188 -> 1624
    //   1439: aload 9
    //   1441: astore 14
    //   1443: aload 9
    //   1445: astore 12
    //   1447: aload 9
    //   1449: astore 11
    //   1451: aload 9
    //   1453: astore 13
    //   1455: aload 10
    //   1457: aload 15
    //   1459: iconst_0
    //   1460: iload_3
    //   1461: invokevirtual 383	java/io/FileOutputStream:write	([BII)V
    //   1464: lload 5
    //   1466: iload_3
    //   1467: i2l
    //   1468: ladd
    //   1469: lstore 5
    //   1471: aload 9
    //   1473: astore 14
    //   1475: aload 9
    //   1477: astore 12
    //   1479: aload 9
    //   1481: astore 11
    //   1483: aload 9
    //   1485: astore 13
    //   1487: aload_0
    //   1488: lload 5
    //   1490: l2d
    //   1491: lload 7
    //   1493: l2d
    //   1494: ddiv
    //   1495: d2f
    //   1496: invokevirtual 386	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(F)V
    //   1499: goto -93 -> 1406
    //   1502: astore 12
    //   1504: aload 10
    //   1506: astore 11
    //   1508: aload 9
    //   1510: astore 10
    //   1512: aload 11
    //   1514: astore 9
    //   1516: aload 12
    //   1518: astore 11
    //   1520: aload_0
    //   1521: bipush 101
    //   1523: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1526: iload 4
    //   1528: ifne +782 -> 2310
    //   1531: iconst_5
    //   1532: ldc 64
    //   1534: ldc 66
    //   1536: new 68	java/lang/StringBuilder
    //   1539: dup
    //   1540: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1543: ldc_w 388
    //   1546: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: aload 11
    //   1551: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1554: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1560: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: bipush 101
    //   1565: istore_3
    //   1566: aload 10
    //   1568: ifnull +8 -> 1576
    //   1571: aload 10
    //   1573: invokevirtual 325	java/io/InputStream:close	()V
    //   1576: aload 9
    //   1578: ifnull -1537 -> 41
    //   1581: aload 9
    //   1583: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1586: bipush 101
    //   1588: ireturn
    //   1589: astore_1
    //   1590: iconst_5
    //   1591: ldc 64
    //   1593: ldc 66
    //   1595: new 68	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 352
    //   1605: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: aload_1
    //   1609: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1612: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1621: bipush 101
    //   1623: ireturn
    //   1624: aload 9
    //   1626: astore 14
    //   1628: aload 9
    //   1630: astore 12
    //   1632: aload 9
    //   1634: astore 11
    //   1636: aload 9
    //   1638: astore 13
    //   1640: aload 10
    //   1642: invokevirtual 389	java/io/FileOutputStream:flush	()V
    //   1645: aload 9
    //   1647: astore 14
    //   1649: aload 9
    //   1651: astore 12
    //   1653: aload 9
    //   1655: astore 11
    //   1657: aload 9
    //   1659: astore 13
    //   1661: aload 10
    //   1663: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1666: aconst_null
    //   1667: astore 10
    //   1669: aconst_null
    //   1670: astore 16
    //   1672: aload 9
    //   1674: astore 13
    //   1676: aload 9
    //   1678: astore 14
    //   1680: aload 9
    //   1682: astore 15
    //   1684: aload 10
    //   1686: astore 11
    //   1688: aload 9
    //   1690: astore 12
    //   1692: aload 25
    //   1694: invokevirtual 328	java/net/HttpURLConnection:disconnect	()V
    //   1697: aload 9
    //   1699: astore 13
    //   1701: aload 9
    //   1703: astore 14
    //   1705: aload 9
    //   1707: astore 15
    //   1709: aload 10
    //   1711: astore 11
    //   1713: aload 9
    //   1715: astore 12
    //   1717: iconst_3
    //   1718: ldc 64
    //   1720: ldc 66
    //   1722: new 68	java/lang/StringBuilder
    //   1725: dup
    //   1726: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1729: ldc_w 391
    //   1732: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: lload 7
    //   1737: invokevirtual 394	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1740: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1743: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1746: aload 9
    //   1748: astore 13
    //   1750: aload 9
    //   1752: astore 14
    //   1754: aload 9
    //   1756: astore 15
    //   1758: aload 10
    //   1760: astore 11
    //   1762: aload 9
    //   1764: astore 12
    //   1766: aload_0
    //   1767: aload_0
    //   1768: aload 24
    //   1770: aload_1
    //   1771: aload_2
    //   1772: invokespecial 155	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;Ljava/lang/String;)I
    //   1775: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1778: aload 9
    //   1780: astore 13
    //   1782: aload 9
    //   1784: astore 14
    //   1786: aload 9
    //   1788: astore 15
    //   1790: aload 10
    //   1792: astore 11
    //   1794: aload 9
    //   1796: astore 12
    //   1798: aload_0
    //   1799: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1802: ifeq +379 -> 2181
    //   1805: iload 4
    //   1807: ifne +149 -> 1956
    //   1810: aload 9
    //   1812: astore 13
    //   1814: aload 9
    //   1816: astore 14
    //   1818: aload 9
    //   1820: astore 15
    //   1822: aload 10
    //   1824: astore 11
    //   1826: aload 9
    //   1828: astore 12
    //   1830: iconst_5
    //   1831: ldc 64
    //   1833: ldc 66
    //   1835: new 68	java/lang/StringBuilder
    //   1838: dup
    //   1839: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1842: ldc_w 396
    //   1845: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: aload_0
    //   1849: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1852: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1855: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1858: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1861: bipush 101
    //   1863: istore_3
    //   1864: aload 9
    //   1866: ifnull +8 -> 1874
    //   1869: aload 9
    //   1871: invokevirtual 325	java/io/InputStream:close	()V
    //   1874: iconst_0
    //   1875: ifeq -1834 -> 41
    //   1878: new 243	java/lang/NullPointerException
    //   1881: dup
    //   1882: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   1885: athrow
    //   1886: astore_1
    //   1887: iconst_5
    //   1888: ldc 64
    //   1890: ldc 66
    //   1892: new 68	java/lang/StringBuilder
    //   1895: dup
    //   1896: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1899: ldc_w 352
    //   1902: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: aload_1
    //   1906: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1909: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1912: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1915: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1918: bipush 101
    //   1920: ireturn
    //   1921: astore_1
    //   1922: iconst_5
    //   1923: ldc 64
    //   1925: ldc 66
    //   1927: new 68	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1934: ldc_w 354
    //   1937: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1940: aload_1
    //   1941: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   1944: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1950: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1953: goto -79 -> 1874
    //   1956: aload 9
    //   1958: astore 13
    //   1960: aload 9
    //   1962: astore 14
    //   1964: aload 9
    //   1966: astore 15
    //   1968: aload 10
    //   1970: astore 11
    //   1972: aload 9
    //   1974: astore 12
    //   1976: aload_0
    //   1977: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1980: istore_3
    //   1981: bipush 103
    //   1983: iload_3
    //   1984: if_icmpne +98 -> 2082
    //   1987: bipush 103
    //   1989: istore_3
    //   1990: aload 9
    //   1992: ifnull +8 -> 2000
    //   1995: aload 9
    //   1997: invokevirtual 325	java/io/InputStream:close	()V
    //   2000: iconst_0
    //   2001: ifeq -1960 -> 41
    //   2004: new 243	java/lang/NullPointerException
    //   2007: dup
    //   2008: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   2011: athrow
    //   2012: astore_1
    //   2013: iconst_5
    //   2014: ldc 64
    //   2016: ldc 66
    //   2018: new 68	java/lang/StringBuilder
    //   2021: dup
    //   2022: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2025: ldc_w 352
    //   2028: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: aload_1
    //   2032: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2035: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2041: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2044: bipush 103
    //   2046: ireturn
    //   2047: astore_1
    //   2048: iconst_5
    //   2049: ldc 64
    //   2051: ldc 66
    //   2053: new 68	java/lang/StringBuilder
    //   2056: dup
    //   2057: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2060: ldc_w 354
    //   2063: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: aload_1
    //   2067: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2070: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2076: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2079: goto -79 -> 2000
    //   2082: aload 9
    //   2084: ifnull +8 -> 2092
    //   2087: aload 9
    //   2089: invokevirtual 325	java/io/InputStream:close	()V
    //   2092: iconst_0
    //   2093: ifeq +1465 -> 3558
    //   2096: new 243	java/lang/NullPointerException
    //   2099: dup
    //   2100: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   2103: athrow
    //   2104: astore 9
    //   2106: iconst_5
    //   2107: ldc 64
    //   2109: ldc 66
    //   2111: new 68	java/lang/StringBuilder
    //   2114: dup
    //   2115: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2118: ldc_w 354
    //   2121: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: aload 9
    //   2126: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2129: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2132: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2135: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2138: goto -46 -> 2092
    //   2141: astore 9
    //   2143: iconst_5
    //   2144: ldc 64
    //   2146: ldc 66
    //   2148: new 68	java/lang/StringBuilder
    //   2151: dup
    //   2152: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2155: ldc_w 352
    //   2158: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: aload 9
    //   2163: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2166: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2169: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2172: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2175: iload 4
    //   2177: istore_3
    //   2178: goto -2176 -> 2
    //   2181: aload 9
    //   2183: ifnull +8 -> 2191
    //   2186: aload 9
    //   2188: invokevirtual 325	java/io/InputStream:close	()V
    //   2191: iconst_0
    //   2192: ifeq +11 -> 2203
    //   2195: new 243	java/lang/NullPointerException
    //   2198: dup
    //   2199: invokespecial 244	java/lang/NullPointerException:<init>	()V
    //   2202: athrow
    //   2203: iconst_0
    //   2204: ireturn
    //   2205: astore_1
    //   2206: iconst_5
    //   2207: ldc 64
    //   2209: ldc 66
    //   2211: new 68	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2218: ldc_w 354
    //   2221: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: aload_1
    //   2225: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2228: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2237: goto -46 -> 2191
    //   2240: astore_1
    //   2241: iconst_5
    //   2242: ldc 64
    //   2244: ldc 66
    //   2246: new 68	java/lang/StringBuilder
    //   2249: dup
    //   2250: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2253: ldc_w 352
    //   2256: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: aload_1
    //   2260: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2263: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2272: goto -69 -> 2203
    //   2275: astore_1
    //   2276: iconst_5
    //   2277: ldc 64
    //   2279: ldc 66
    //   2281: new 68	java/lang/StringBuilder
    //   2284: dup
    //   2285: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2288: ldc_w 354
    //   2291: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: aload_1
    //   2295: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2298: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2304: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2307: goto -731 -> 1576
    //   2310: iconst_5
    //   2311: ldc 64
    //   2313: ldc 66
    //   2315: new 68	java/lang/StringBuilder
    //   2318: dup
    //   2319: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2322: ldc_w 398
    //   2325: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2328: aload 11
    //   2330: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2333: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2336: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2339: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2342: aload 10
    //   2344: ifnull +8 -> 2352
    //   2347: aload 10
    //   2349: invokevirtual 325	java/io/InputStream:close	()V
    //   2352: aload 9
    //   2354: ifnull +1204 -> 3558
    //   2357: aload 9
    //   2359: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2362: iload 4
    //   2364: istore_3
    //   2365: goto -2363 -> 2
    //   2368: astore 10
    //   2370: iconst_5
    //   2371: ldc 64
    //   2373: ldc 66
    //   2375: new 68	java/lang/StringBuilder
    //   2378: dup
    //   2379: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2382: ldc_w 354
    //   2385: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2388: aload 10
    //   2390: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2393: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2399: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2402: goto -50 -> 2352
    //   2405: astore 9
    //   2407: iconst_5
    //   2408: ldc 64
    //   2410: ldc 66
    //   2412: new 68	java/lang/StringBuilder
    //   2415: dup
    //   2416: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2419: ldc_w 352
    //   2422: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: aload 9
    //   2427: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2430: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2433: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2436: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2439: iload 4
    //   2441: istore_3
    //   2442: goto -2440 -> 2
    //   2445: aconst_null
    //   2446: astore 9
    //   2448: astore 10
    //   2450: aload 9
    //   2452: astore 11
    //   2454: aload 13
    //   2456: astore 12
    //   2458: aload_0
    //   2459: bipush 100
    //   2461: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2464: iload 4
    //   2466: ifne +139 -> 2605
    //   2469: aload 9
    //   2471: astore 11
    //   2473: aload 13
    //   2475: astore 12
    //   2477: iconst_5
    //   2478: ldc 64
    //   2480: ldc 66
    //   2482: new 68	java/lang/StringBuilder
    //   2485: dup
    //   2486: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2489: ldc_w 400
    //   2492: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2495: aload 10
    //   2497: invokevirtual 401	java/lang/NoSuchMethodError:toString	()Ljava/lang/String;
    //   2500: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2506: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2509: bipush 100
    //   2511: istore_3
    //   2512: aload 13
    //   2514: ifnull +8 -> 2522
    //   2517: aload 13
    //   2519: invokevirtual 325	java/io/InputStream:close	()V
    //   2522: aload 9
    //   2524: ifnull -2483 -> 41
    //   2527: aload 9
    //   2529: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2532: bipush 100
    //   2534: ireturn
    //   2535: astore_1
    //   2536: iconst_5
    //   2537: ldc 64
    //   2539: ldc 66
    //   2541: new 68	java/lang/StringBuilder
    //   2544: dup
    //   2545: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2548: ldc_w 352
    //   2551: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2554: aload_1
    //   2555: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2558: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2561: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2564: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2567: bipush 100
    //   2569: ireturn
    //   2570: astore_1
    //   2571: iconst_5
    //   2572: ldc 64
    //   2574: ldc 66
    //   2576: new 68	java/lang/StringBuilder
    //   2579: dup
    //   2580: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2583: ldc_w 354
    //   2586: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2589: aload_1
    //   2590: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2593: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2596: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2599: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2602: goto -80 -> 2522
    //   2605: aload 9
    //   2607: astore 11
    //   2609: aload 13
    //   2611: astore 12
    //   2613: iconst_5
    //   2614: ldc 64
    //   2616: ldc 66
    //   2618: new 68	java/lang/StringBuilder
    //   2621: dup
    //   2622: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2625: ldc_w 403
    //   2628: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2631: aload 10
    //   2633: invokevirtual 401	java/lang/NoSuchMethodError:toString	()Ljava/lang/String;
    //   2636: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2639: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2642: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2645: aload 13
    //   2647: ifnull +8 -> 2655
    //   2650: aload 13
    //   2652: invokevirtual 325	java/io/InputStream:close	()V
    //   2655: aload 9
    //   2657: ifnull +901 -> 3558
    //   2660: aload 9
    //   2662: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2665: iload 4
    //   2667: istore_3
    //   2668: goto -2666 -> 2
    //   2671: astore 10
    //   2673: iconst_5
    //   2674: ldc 64
    //   2676: ldc 66
    //   2678: new 68	java/lang/StringBuilder
    //   2681: dup
    //   2682: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2685: ldc_w 354
    //   2688: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: aload 10
    //   2693: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2696: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2699: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2702: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2705: goto -50 -> 2655
    //   2708: astore 9
    //   2710: iconst_5
    //   2711: ldc 64
    //   2713: ldc 66
    //   2715: new 68	java/lang/StringBuilder
    //   2718: dup
    //   2719: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2722: ldc_w 352
    //   2725: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: aload 9
    //   2730: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2733: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2736: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2739: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2742: iload 4
    //   2744: istore_3
    //   2745: goto -2743 -> 2
    //   2748: aconst_null
    //   2749: astore 9
    //   2751: astore 10
    //   2753: aload 9
    //   2755: astore 11
    //   2757: aload 14
    //   2759: astore 12
    //   2761: aload_0
    //   2762: bipush 101
    //   2764: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2767: iload 4
    //   2769: ifne +139 -> 2908
    //   2772: aload 9
    //   2774: astore 11
    //   2776: aload 14
    //   2778: astore 12
    //   2780: iconst_5
    //   2781: ldc 64
    //   2783: ldc 66
    //   2785: new 68	java/lang/StringBuilder
    //   2788: dup
    //   2789: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2792: ldc_w 405
    //   2795: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2798: aload 10
    //   2800: invokevirtual 406	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   2803: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2806: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2809: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2812: bipush 101
    //   2814: istore_3
    //   2815: aload 14
    //   2817: ifnull +8 -> 2825
    //   2820: aload 14
    //   2822: invokevirtual 325	java/io/InputStream:close	()V
    //   2825: aload 9
    //   2827: ifnull -2786 -> 41
    //   2830: aload 9
    //   2832: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2835: bipush 101
    //   2837: ireturn
    //   2838: astore_1
    //   2839: iconst_5
    //   2840: ldc 64
    //   2842: ldc 66
    //   2844: new 68	java/lang/StringBuilder
    //   2847: dup
    //   2848: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2851: ldc_w 352
    //   2854: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2857: aload_1
    //   2858: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2861: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2864: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2867: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2870: bipush 101
    //   2872: ireturn
    //   2873: astore_1
    //   2874: iconst_5
    //   2875: ldc 64
    //   2877: ldc 66
    //   2879: new 68	java/lang/StringBuilder
    //   2882: dup
    //   2883: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2886: ldc_w 354
    //   2889: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: aload_1
    //   2893: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2896: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2899: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2902: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2905: goto -80 -> 2825
    //   2908: aload 9
    //   2910: astore 11
    //   2912: aload 14
    //   2914: astore 12
    //   2916: iconst_5
    //   2917: ldc 64
    //   2919: ldc 66
    //   2921: new 68	java/lang/StringBuilder
    //   2924: dup
    //   2925: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2928: ldc_w 408
    //   2931: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2934: aload 10
    //   2936: invokevirtual 406	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   2939: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2945: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2948: aload 14
    //   2950: ifnull +8 -> 2958
    //   2953: aload 14
    //   2955: invokevirtual 325	java/io/InputStream:close	()V
    //   2958: aload 9
    //   2960: ifnull +598 -> 3558
    //   2963: aload 9
    //   2965: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2968: iload 4
    //   2970: istore_3
    //   2971: goto -2969 -> 2
    //   2974: astore 10
    //   2976: iconst_5
    //   2977: ldc 64
    //   2979: ldc 66
    //   2981: new 68	java/lang/StringBuilder
    //   2984: dup
    //   2985: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   2988: ldc_w 354
    //   2991: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2994: aload 10
    //   2996: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   2999: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3002: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3005: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3008: goto -50 -> 2958
    //   3011: astore 9
    //   3013: iconst_5
    //   3014: ldc 64
    //   3016: ldc 66
    //   3018: new 68	java/lang/StringBuilder
    //   3021: dup
    //   3022: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3025: ldc_w 352
    //   3028: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3031: aload 9
    //   3033: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3036: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3039: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3042: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3045: iload 4
    //   3047: istore_3
    //   3048: goto -3046 -> 2
    //   3051: aconst_null
    //   3052: astore 9
    //   3054: astore 10
    //   3056: aload 9
    //   3058: astore 11
    //   3060: aload 15
    //   3062: astore 12
    //   3064: aload_0
    //   3065: bipush 101
    //   3067: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   3070: iload 4
    //   3072: ifne +139 -> 3211
    //   3075: aload 9
    //   3077: astore 11
    //   3079: aload 15
    //   3081: astore 12
    //   3083: iconst_5
    //   3084: ldc 64
    //   3086: ldc 66
    //   3088: new 68	java/lang/StringBuilder
    //   3091: dup
    //   3092: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3095: ldc_w 410
    //   3098: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3101: aload 10
    //   3103: invokevirtual 166	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3106: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3109: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3112: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3115: bipush 101
    //   3117: istore_3
    //   3118: aload 15
    //   3120: ifnull +8 -> 3128
    //   3123: aload 15
    //   3125: invokevirtual 325	java/io/InputStream:close	()V
    //   3128: aload 9
    //   3130: ifnull -3089 -> 41
    //   3133: aload 9
    //   3135: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3138: bipush 101
    //   3140: ireturn
    //   3141: astore_1
    //   3142: iconst_5
    //   3143: ldc 64
    //   3145: ldc 66
    //   3147: new 68	java/lang/StringBuilder
    //   3150: dup
    //   3151: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3154: ldc_w 352
    //   3157: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: aload_1
    //   3161: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3164: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3167: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3170: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3173: bipush 101
    //   3175: ireturn
    //   3176: astore_1
    //   3177: iconst_5
    //   3178: ldc 64
    //   3180: ldc 66
    //   3182: new 68	java/lang/StringBuilder
    //   3185: dup
    //   3186: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3189: ldc_w 354
    //   3192: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3195: aload_1
    //   3196: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3199: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3202: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3205: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3208: goto -80 -> 3128
    //   3211: aload 9
    //   3213: astore 11
    //   3215: aload 15
    //   3217: astore 12
    //   3219: iconst_5
    //   3220: ldc 64
    //   3222: ldc 66
    //   3224: new 68	java/lang/StringBuilder
    //   3227: dup
    //   3228: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3231: ldc_w 412
    //   3234: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: aload 10
    //   3239: invokevirtual 166	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3245: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3248: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3251: aload 15
    //   3253: ifnull +8 -> 3261
    //   3256: aload 15
    //   3258: invokevirtual 325	java/io/InputStream:close	()V
    //   3261: aload 9
    //   3263: ifnull +295 -> 3558
    //   3266: aload 9
    //   3268: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3271: iload 4
    //   3273: istore_3
    //   3274: goto -3272 -> 2
    //   3277: astore 10
    //   3279: iconst_5
    //   3280: ldc 64
    //   3282: ldc 66
    //   3284: new 68	java/lang/StringBuilder
    //   3287: dup
    //   3288: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3291: ldc_w 354
    //   3294: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3297: aload 10
    //   3299: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3302: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3305: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3308: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3311: goto -50 -> 3261
    //   3314: astore 9
    //   3316: iconst_5
    //   3317: ldc 64
    //   3319: ldc 66
    //   3321: new 68	java/lang/StringBuilder
    //   3324: dup
    //   3325: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3328: ldc_w 352
    //   3331: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: aload 9
    //   3336: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3339: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3342: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3345: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3348: iload 4
    //   3350: istore_3
    //   3351: goto -3349 -> 2
    //   3354: astore_1
    //   3355: aload 11
    //   3357: astore 9
    //   3359: aload 12
    //   3361: ifnull +8 -> 3369
    //   3364: aload 12
    //   3366: invokevirtual 325	java/io/InputStream:close	()V
    //   3369: aload 9
    //   3371: ifnull +8 -> 3379
    //   3374: aload 9
    //   3376: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3379: aload_1
    //   3380: athrow
    //   3381: astore_2
    //   3382: iconst_5
    //   3383: ldc 64
    //   3385: ldc 66
    //   3387: new 68	java/lang/StringBuilder
    //   3390: dup
    //   3391: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3394: ldc_w 354
    //   3397: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: aload_2
    //   3401: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3404: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3407: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3410: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3413: goto -44 -> 3369
    //   3416: astore_2
    //   3417: iconst_5
    //   3418: ldc 64
    //   3420: ldc 66
    //   3422: new 68	java/lang/StringBuilder
    //   3425: dup
    //   3426: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3429: ldc_w 352
    //   3432: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: aload_2
    //   3436: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   3439: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3448: goto -69 -> 3379
    //   3451: bipush 100
    //   3453: ireturn
    //   3454: astore_1
    //   3455: aload 10
    //   3457: astore 9
    //   3459: aload 14
    //   3461: astore 12
    //   3463: goto -104 -> 3359
    //   3466: astore_1
    //   3467: aload 10
    //   3469: astore 12
    //   3471: goto -112 -> 3359
    //   3474: astore 11
    //   3476: aload 10
    //   3478: astore 9
    //   3480: aload 11
    //   3482: astore 10
    //   3484: aload 12
    //   3486: astore 15
    //   3488: goto -432 -> 3056
    //   3491: astore 12
    //   3493: aload 10
    //   3495: astore 9
    //   3497: aload 12
    //   3499: astore 10
    //   3501: aload 11
    //   3503: astore 14
    //   3505: goto -752 -> 2753
    //   3508: astore 11
    //   3510: aload 10
    //   3512: astore 9
    //   3514: aload 11
    //   3516: astore 10
    //   3518: goto -1068 -> 2450
    //   3521: astore 11
    //   3523: aconst_null
    //   3524: astore 10
    //   3526: aload 19
    //   3528: astore 9
    //   3530: goto -2010 -> 1520
    //   3533: astore 11
    //   3535: aload 10
    //   3537: astore 9
    //   3539: aconst_null
    //   3540: astore 10
    //   3542: goto -2022 -> 1520
    //   3545: astore 11
    //   3547: aload 9
    //   3549: astore 10
    //   3551: aload 16
    //   3553: astore 9
    //   3555: goto -2035 -> 1520
    //   3558: iload 4
    //   3560: istore_3
    //   3561: goto -3559 -> 2
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3564	0	this	b
    //   0	3564	1	paramSDKLocalConfig	SDKLocalConfig
    //   0	3564	2	paramString	String
    //   1	3560	3	n	int
    //   5	3554	4	i1	int
    //   1122	367	5	l1	long
    //   877	859	7	l2	long
    //   112	1	9	localObject1	Object
    //   416	21	9	localException1	Exception
    //   453	260	9	localException2	Exception
    //   772	21	9	localException3	Exception
    //   809	90	9	localException4	Exception
    //   1044	21	9	localException5	Exception
    //   1081	56	9	localException6	Exception
    //   1145	141	9	localInputStream	java.io.InputStream
    //   1306	21	9	localException7	Exception
    //   1343	166	9	localException8	Exception
    //   1514	574	9	localObject2	Object
    //   2104	21	9	localException9	Exception
    //   2141	217	9	localException10	Exception
    //   2405	21	9	localException11	Exception
    //   2446	215	9	localObject3	Object
    //   2708	21	9	localException12	Exception
    //   2749	215	9	localObject4	Object
    //   3011	21	9	localException13	Exception
    //   3052	215	9	localObject5	Object
    //   3314	21	9	localException14	Exception
    //   3357	197	9	localObject6	Object
    //   100	2248	10	localObject7	Object
    //   2368	21	10	localException15	Exception
    //   2448	184	10	localNoSuchMethodError1	java.lang.NoSuchMethodError
    //   2671	21	10	localException16	Exception
    //   2751	184	10	localOutOfMemoryError1	OutOfMemoryError
    //   2974	21	10	localException17	Exception
    //   3054	184	10	localThrowable1	Throwable
    //   3277	200	10	localException18	Exception
    //   3482	68	10	localObject8	Object
    //   137	3219	11	localObject9	Object
    //   3474	28	11	localThrowable2	Throwable
    //   3508	7	11	localNoSuchMethodError2	java.lang.NoSuchMethodError
    //   3521	1	11	localException19	Exception
    //   3533	1	11	localException20	Exception
    //   3545	1	11	localException21	Exception
    //   141	1337	12	localObject10	Object
    //   1502	15	12	localException22	Exception
    //   1630	1855	12	localObject11	Object
    //   3491	7	12	localOutOfMemoryError2	OutOfMemoryError
    //   125	2526	13	localObject12	Object
    //   129	3375	14	localObject13	Object
    //   133	3354	15	localObject14	Object
    //   109	3443	16	localObject15	Object
    //   106	1023	17	localObject16	Object
    //   103	1022	18	localObject17	Object
    //   121	3406	19	localObject18	Object
    //   115	379	20	localObject19	Object
    //   97	405	21	localObject20	Object
    //   118	388	22	localObject21	Object
    //   94	404	23	localObject22	Object
    //   184	1585	24	localFile	File
    //   252	1441	25	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   314	322	322	java/lang/Exception
    //   302	310	357	java/lang/Exception
    //   396	404	416	java/lang/Exception
    //   408	416	453	java/lang/Exception
    //   622	627	630	java/lang/Exception
    //   609	617	665	java/lang/Exception
    //   748	756	772	java/lang/Exception
    //   761	766	809	java/lang/Exception
    //   938	943	946	java/lang/Exception
    //   925	933	981	java/lang/Exception
    //   1020	1028	1044	java/lang/Exception
    //   1033	1038	1081	java/lang/Exception
    //   1202	1207	1210	java/lang/Exception
    //   1192	1197	1245	java/lang/Exception
    //   1285	1290	1306	java/lang/Exception
    //   1295	1300	1343	java/lang/Exception
    //   1173	1184	1502	java/lang/Exception
    //   1399	1406	1502	java/lang/Exception
    //   1422	1434	1502	java/lang/Exception
    //   1455	1464	1502	java/lang/Exception
    //   1487	1499	1502	java/lang/Exception
    //   1640	1645	1502	java/lang/Exception
    //   1661	1666	1502	java/lang/Exception
    //   1581	1586	1589	java/lang/Exception
    //   1878	1886	1886	java/lang/Exception
    //   1869	1874	1921	java/lang/Exception
    //   2004	2012	2012	java/lang/Exception
    //   1995	2000	2047	java/lang/Exception
    //   2087	2092	2104	java/lang/Exception
    //   2096	2104	2141	java/lang/Exception
    //   2186	2191	2205	java/lang/Exception
    //   2195	2203	2240	java/lang/Exception
    //   1571	1576	2275	java/lang/Exception
    //   2347	2352	2368	java/lang/Exception
    //   2357	2362	2405	java/lang/Exception
    //   143	154	2445	java/lang/NoSuchMethodError
    //   174	186	2445	java/lang/NoSuchMethodError
    //   206	215	2445	java/lang/NoSuchMethodError
    //   235	254	2445	java/lang/NoSuchMethodError
    //   279	290	2445	java/lang/NoSuchMethodError
    //   513	524	2445	java/lang/NoSuchMethodError
    //   1692	1697	2445	java/lang/NoSuchMethodError
    //   1717	1746	2445	java/lang/NoSuchMethodError
    //   1766	1778	2445	java/lang/NoSuchMethodError
    //   1798	1805	2445	java/lang/NoSuchMethodError
    //   1830	1861	2445	java/lang/NoSuchMethodError
    //   1976	1981	2445	java/lang/NoSuchMethodError
    //   2527	2532	2535	java/lang/Exception
    //   2517	2522	2570	java/lang/Exception
    //   2650	2655	2671	java/lang/Exception
    //   2660	2665	2708	java/lang/Exception
    //   143	154	2748	java/lang/OutOfMemoryError
    //   174	186	2748	java/lang/OutOfMemoryError
    //   206	215	2748	java/lang/OutOfMemoryError
    //   235	254	2748	java/lang/OutOfMemoryError
    //   279	290	2748	java/lang/OutOfMemoryError
    //   513	524	2748	java/lang/OutOfMemoryError
    //   1692	1697	2748	java/lang/OutOfMemoryError
    //   1717	1746	2748	java/lang/OutOfMemoryError
    //   1766	1778	2748	java/lang/OutOfMemoryError
    //   1798	1805	2748	java/lang/OutOfMemoryError
    //   1830	1861	2748	java/lang/OutOfMemoryError
    //   1976	1981	2748	java/lang/OutOfMemoryError
    //   2830	2835	2838	java/lang/Exception
    //   2820	2825	2873	java/lang/Exception
    //   2953	2958	2974	java/lang/Exception
    //   2963	2968	3011	java/lang/Exception
    //   143	154	3051	java/lang/Throwable
    //   174	186	3051	java/lang/Throwable
    //   206	215	3051	java/lang/Throwable
    //   235	254	3051	java/lang/Throwable
    //   279	290	3051	java/lang/Throwable
    //   513	524	3051	java/lang/Throwable
    //   1692	1697	3051	java/lang/Throwable
    //   1717	1746	3051	java/lang/Throwable
    //   1766	1778	3051	java/lang/Throwable
    //   1798	1805	3051	java/lang/Throwable
    //   1830	1861	3051	java/lang/Throwable
    //   1976	1981	3051	java/lang/Throwable
    //   3133	3138	3141	java/lang/Exception
    //   3123	3128	3176	java/lang/Exception
    //   3256	3261	3277	java/lang/Exception
    //   3266	3271	3314	java/lang/Exception
    //   143	154	3354	finally
    //   174	186	3354	finally
    //   206	215	3354	finally
    //   235	254	3354	finally
    //   279	290	3354	finally
    //   513	524	3354	finally
    //   1692	1697	3354	finally
    //   1717	1746	3354	finally
    //   1766	1778	3354	finally
    //   1798	1805	3354	finally
    //   1830	1861	3354	finally
    //   1976	1981	3354	finally
    //   2458	2464	3354	finally
    //   2477	2509	3354	finally
    //   2613	2645	3354	finally
    //   2761	2767	3354	finally
    //   2780	2812	3354	finally
    //   2916	2948	3354	finally
    //   3064	3070	3354	finally
    //   3083	3115	3354	finally
    //   3219	3251	3354	finally
    //   3364	3369	3381	java/lang/Exception
    //   3374	3379	3416	java/lang/Exception
    //   540	546	3454	finally
    //   574	602	3454	finally
    //   716	744	3454	finally
    //   865	879	3454	finally
    //   902	913	3454	finally
    //   1140	1147	3454	finally
    //   1173	1184	3454	finally
    //   1399	1406	3454	finally
    //   1422	1434	3454	finally
    //   1455	1464	3454	finally
    //   1487	1499	3454	finally
    //   1640	1645	3454	finally
    //   1661	1666	3454	finally
    //   1520	1526	3466	finally
    //   1531	1563	3466	finally
    //   2310	2342	3466	finally
    //   540	546	3474	java/lang/Throwable
    //   574	602	3474	java/lang/Throwable
    //   716	744	3474	java/lang/Throwable
    //   865	879	3474	java/lang/Throwable
    //   902	913	3474	java/lang/Throwable
    //   1140	1147	3474	java/lang/Throwable
    //   1173	1184	3474	java/lang/Throwable
    //   1399	1406	3474	java/lang/Throwable
    //   1422	1434	3474	java/lang/Throwable
    //   1455	1464	3474	java/lang/Throwable
    //   1487	1499	3474	java/lang/Throwable
    //   1640	1645	3474	java/lang/Throwable
    //   1661	1666	3474	java/lang/Throwable
    //   540	546	3491	java/lang/OutOfMemoryError
    //   574	602	3491	java/lang/OutOfMemoryError
    //   716	744	3491	java/lang/OutOfMemoryError
    //   865	879	3491	java/lang/OutOfMemoryError
    //   902	913	3491	java/lang/OutOfMemoryError
    //   1140	1147	3491	java/lang/OutOfMemoryError
    //   1173	1184	3491	java/lang/OutOfMemoryError
    //   1399	1406	3491	java/lang/OutOfMemoryError
    //   1422	1434	3491	java/lang/OutOfMemoryError
    //   1455	1464	3491	java/lang/OutOfMemoryError
    //   1487	1499	3491	java/lang/OutOfMemoryError
    //   1640	1645	3491	java/lang/OutOfMemoryError
    //   1661	1666	3491	java/lang/OutOfMemoryError
    //   540	546	3508	java/lang/NoSuchMethodError
    //   574	602	3508	java/lang/NoSuchMethodError
    //   716	744	3508	java/lang/NoSuchMethodError
    //   865	879	3508	java/lang/NoSuchMethodError
    //   902	913	3508	java/lang/NoSuchMethodError
    //   1140	1147	3508	java/lang/NoSuchMethodError
    //   1173	1184	3508	java/lang/NoSuchMethodError
    //   1399	1406	3508	java/lang/NoSuchMethodError
    //   1422	1434	3508	java/lang/NoSuchMethodError
    //   1455	1464	3508	java/lang/NoSuchMethodError
    //   1487	1499	3508	java/lang/NoSuchMethodError
    //   1640	1645	3508	java/lang/NoSuchMethodError
    //   1661	1666	3508	java/lang/NoSuchMethodError
    //   143	154	3521	java/lang/Exception
    //   174	186	3521	java/lang/Exception
    //   206	215	3521	java/lang/Exception
    //   235	254	3521	java/lang/Exception
    //   279	290	3521	java/lang/Exception
    //   513	524	3521	java/lang/Exception
    //   540	546	3533	java/lang/Exception
    //   574	602	3533	java/lang/Exception
    //   716	744	3533	java/lang/Exception
    //   865	879	3533	java/lang/Exception
    //   902	913	3533	java/lang/Exception
    //   1140	1147	3533	java/lang/Exception
    //   1692	1697	3545	java/lang/Exception
    //   1717	1746	3545	java/lang/Exception
    //   1766	1778	3545	java/lang/Exception
    //   1798	1805	3545	java/lang/Exception
    //   1830	1861	3545	java/lang/Exception
    //   1976	1981	3545	java/lang/Exception
  }
  
  private String b(File paramFile, String paramString)
  {
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix, dirFile: " + paramFile + " - prefix : " + paramString);
    if (paramFile == null) {}
    for (;;)
    {
      return null;
      paramFile = paramFile.listFiles();
      if ((paramFile == null) || (paramFile.length <= 0))
      {
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix , childFiles is null or length 0 ");
        return null;
      }
      int i1 = paramFile.length;
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramFile[n];
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix,  file.name : " + localObject.getName() + " , file.path :" + localObject.getAbsolutePath());
        if ((localObject.getName().length() >= paramString.length()) && (localObject.getName().substring(0, paramString.length()).equalsIgnoreCase(paramString)) && (localObject.getName().endsWith(".jar"))) {
          return localObject.getAbsolutePath();
        }
        n += 1;
      }
    }
  }
  
  private String b(String paramString)
  {
    int n = 3;
    System.setProperty("http.keepAlive", "false");
    System.setProperty("http.maxConnections", "100");
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fetchResultWithURL, request url: " + paramString);
    while (n > 0) {
      try
      {
        String str = a(paramString, false);
        if (TextUtils.isEmpty(str)) {
          a(paramString, true);
        }
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fetchResultWithURL, result : " + str);
        if (!TextUtils.isEmpty(str))
        {
          boolean bool = TextUtils.isEmpty(str.trim());
          if (!bool) {
            return str;
          }
        }
        n -= 1;
      }
      catch (Exception paramString)
      {
        this.d = 102;
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        this.d = 102;
        return null;
      }
    }
    this.d = 102;
    return null;
  }
  
  private SDKLocalConfig c(String paramString)
  {
    String str1 = paramString;
    String str2;
    String str3;
    try
    {
      if (paramString.startsWith("QZOutputJson=")) {
        str1 = paramString.replace("QZOutputJson=", "");
      }
      localObject = new JSONObject(str1);
      if (((JSONObject)localObject).optString("error_msg").equals("no record"))
      {
        this.d = 102;
        return null;
      }
      paramString = ((JSONObject)localObject).optString("c_so_url");
      str1 = ((JSONObject)localObject).optString("c_so_name");
      str2 = ((JSONObject)localObject).optString("c_so_update_ver");
      str3 = ((JSONObject)localObject).optString("c_so_md5");
      localObject = ((JSONObject)localObject).optString("ret");
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        this.d = 102;
        return null;
      }
    }
    catch (Exception paramString)
    {
      this.d = 102;
      return null;
    }
    Object localObject = new SDKLocalConfig();
    ((SDKLocalConfig)localObject).filename = str1;
    ((SDKLocalConfig)localObject).version = str2;
    ((SDKLocalConfig)localObject).MD5 = str3;
    ((SDKLocalConfig)localObject).URL = paramString;
    return localObject;
  }
  
  private boolean c(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.isPluginMode()) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return true;
      arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
    } while ((arrayOfString1 != null) && (arrayOfString2 != null) && (arrayOfString1.length > 1) && (arrayOfString2.length > 1) && (arrayOfString1[0].equalsIgnoreCase(arrayOfString2[0])) && (arrayOfString1[1].equalsIgnoreCase(arrayOfString2[1])));
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.isPluginMode()) {}
    String[] arrayOfString2;
    int n;
    do
    {
      return true;
      String[] arrayOfString1 = TVK_SDKMgr.SDK_Ver.split("\\.");
      arrayOfString2 = paramSDKLocalConfig.version.split("\\.");
      if ((arrayOfString1 == null) || (arrayOfString2 == null) || (arrayOfString1.length <= 3) || (arrayOfString2.length <= 3)) {
        break;
      }
      n = Integer.valueOf(arrayOfString1[3]).intValue();
    } while (Integer.valueOf(arrayOfString2[3]).intValue() >= n);
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version not match, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "build version is invalid, sdk:" + TVK_SDKMgr.SDK_Ver + ", configver: " + paramSDKLocalConfig.version);
    return false;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return false;
      }
      localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TVKConfig.ser");
      bool1 = bool2;
      if (!localFile.exists()) {
        return bool1;
      }
      this.j = new File(paramString, "TVKConfig.ser");
      this.j.getParentFile().mkdirs();
      if (!d.a(localFile, this.j))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKConfig fail");
        return false;
      }
    }
    catch (Exception paramString)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, exception: " + paramString.toString());
      return false;
    }
    File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/tencent/TencentVideoSdk/com.tencent.videokit", "TvkPlugin.zip");
    boolean bool1 = bool2;
    if (localFile.exists())
    {
      this.i = new File(paramString, "TvkPlugin.zip");
      this.i.getParentFile().mkdirs();
      if (!d.a(localFile, this.i))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKZip fail");
        return false;
      }
      if (!a(this.i.getAbsolutePath(), this.i.getParentFile().getAbsolutePath()))
      {
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, file unzip error");
        return false;
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public SDKLocalConfig a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("https://commdata.v.qq.com/commdatav2?cmd=51&so_name=TvkPlugin&so_ver=");
    if (paramBoolean) {}
    for (Object localObject = this.l.version;; localObject = "V0.0.0.0")
    {
      localObject = b((String)localObject + "&app_id=" + "000" + "&sdk_version=" + c.a);
      if (localObject != null) {
        break;
      }
      this.d = 102;
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "getUpdateInfoWithIsUpdate failed, fetchResultWithURL return null");
      return null;
    }
    localObject = c((String)localObject);
    if ((localObject != null) && (!c((SDKLocalConfig)localObject)) && (!d((SDKLocalConfig)localObject)))
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "getUpdateInfoWithIsUpdate failed, version not match! remoteConfig: " + localObject);
      this.d = 102;
      return null;
    }
    d.a(2, "SDKUpdateHelper.java", "MediaPlayerMgr", "getUpdateInfoWithIsUpdate success, isUpdate: " + paramBoolean + ", remoteConfig: " + localObject);
    return localObject;
  }
  
  public void a(float paramFloat)
  {
    if (this.m != null) {
      this.m.onInstallProgress(paramFloat);
    }
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.m = paramInstallListener;
  }
  
  public void a(SDKLocalConfig paramSDKLocalConfig, boolean paramBoolean)
  {
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadWithIsUpdate ===>start, isUpdate:" + paramBoolean);
    String str;
    if (paramBoolean)
    {
      str = this.f.getAbsolutePath();
      if (a(paramSDKLocalConfig, str) != 0) {
        break label112;
      }
    }
    for (int n = 0;; n = b(paramSDKLocalConfig, str))
    {
      this.d = n;
      if ((n == 0) && (!paramBoolean)) {
        this.l = paramSDKLocalConfig;
      }
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadWithIsUpdate <===end ret:" + n);
      return;
      str = this.e.getAbsolutePath();
      break;
      label112:
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQEngine failed");
    }
  }
  
  public boolean a()
  {
    Object localObject2 = null;
    try
    {
      Object localObject1;
      if ((this.c.getFilesDir().exists()) && (this.c.getFilesDir().canRead()) && (this.c.getFilesDir().canWrite())) {
        localObject1 = this.c.getFilesDir().getAbsolutePath();
      }
      while (localObject1 != null)
      {
        this.e = new File((String)localObject1, "TencentVideoKit");
        this.f = new File((String)localObject1, "TencentVideoKitUpdate");
        this.g = new File(this.e.getAbsolutePath(), "TVKConfig.ser");
        this.h = new File(this.f.getAbsolutePath(), "TVKConfig.ser");
        b();
        d.a(1, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit finish, mSDKDir:" + this.e.getAbsolutePath());
        return true;
        localObject1 = localObject2;
        if (this.c.getCacheDir().exists())
        {
          localObject1 = localObject2;
          if (this.c.getCacheDir().canRead())
          {
            localObject1 = localObject2;
            if (this.c.getCacheDir().canWrite())
            {
              d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit mContext.getFilesDir() Unavailable....try cacheDir");
              localObject1 = this.c.getCacheDir().getAbsolutePath();
            }
          }
        }
      }
      this.d = 104;
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, dir error; getFilesDir unavailable and getCacheDir unavailable");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.d = 104;
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, " + localException.toString());
      }
    }
    return false;
  }
  
  public boolean a(SDKLocalConfig paramSDKLocalConfig)
  {
    return (paramSDKLocalConfig != null) && (!TextUtils.isEmpty(paramSDKLocalConfig.version)) && (this.l != null) && (paramSDKLocalConfig.version.equals(this.l.version));
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +21 -> 22
    //   4: aload_1
    //   5: invokevirtual 173	java/io/File:exists	()Z
    //   8: ifeq +14 -> 22
    //   11: aload_2
    //   12: ifnull +10 -> 22
    //   15: aload_2
    //   16: invokevirtual 173	java/io/File:exists	()Z
    //   19: ifne +43 -> 62
    //   22: iconst_5
    //   23: ldc 64
    //   25: ldc 66
    //   27: new 68	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 643
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc_w 645
    //   47: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   60: iconst_0
    //   61: ireturn
    //   62: new 647	java/io/ObjectInputStream
    //   65: dup
    //   66: new 649	java/io/FileInputStream
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 650	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 651	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 4
    //   79: aload_0
    //   80: aload 4
    //   82: invokevirtual 655	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   85: checkcast 128	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   88: putfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 656	java/io/ObjectInputStream:close	()V
    //   101: iconst_3
    //   102: ldc 64
    //   104: ldc 66
    //   106: new 68	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 658
    //   116: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 518	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:SDK_Ver	Ljava/lang/String;
    //   122: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 660
    //   128: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_1
    //   132: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 645
    //   141: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   148: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 662
    //   154: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   161: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc_w 664
    //   167: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokestatic 666	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	()Ljava/lang/String;
    //   173: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   186: ifnull +43 -> 229
    //   189: aload_0
    //   190: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   193: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   196: ifnull +33 -> 229
    //   199: aload_0
    //   200: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   203: getfield 506	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   206: ifnull +23 -> 229
    //   209: aload_0
    //   210: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   213: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   216: ifnull +13 -> 229
    //   219: aload_0
    //   220: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   223: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   226: ifnonnull +100 -> 326
    //   229: iconst_5
    //   230: ldc 64
    //   232: ldc 66
    //   234: new 68	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 668
    //   244: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_2
    //   267: iconst_5
    //   268: ldc 64
    //   270: ldc 66
    //   272: new 68	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 670
    //   282: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 4
    //   287: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   290: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   303: aload_2
    //   304: ifnull +7 -> 311
    //   307: aload_2
    //   308: invokevirtual 656	java/io/ObjectInputStream:close	()V
    //   311: iconst_0
    //   312: ireturn
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +7 -> 324
    //   320: aload_2
    //   321: invokevirtual 656	java/io/ObjectInputStream:close	()V
    //   324: aload_1
    //   325: athrow
    //   326: aload_0
    //   327: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   330: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   333: astore_2
    //   334: aload_1
    //   335: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   338: astore 4
    //   340: aload_2
    //   341: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   344: ifne +11 -> 355
    //   347: aload 4
    //   349: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +54 -> 406
    //   355: iconst_5
    //   356: ldc 64
    //   358: ldc 66
    //   360: new 68	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 672
    //   370: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_2
    //   374: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 674
    //   380: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload 4
    //   385: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   394: iconst_0
    //   395: istore_3
    //   396: iload_3
    //   397: ifne +86 -> 483
    //   400: aload_1
    //   401: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   404: iconst_0
    //   405: ireturn
    //   406: aload_0
    //   407: aload 4
    //   409: invokespecial 196	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   412: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   415: astore 4
    //   417: aload 4
    //   419: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   422: ifne +12 -> 434
    //   425: aload_2
    //   426: aload 4
    //   428: invokevirtual 440	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   431: ifne +47 -> 478
    //   434: iconst_5
    //   435: ldc 64
    //   437: ldc 66
    //   439: new 68	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 676
    //   449: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_2
    //   453: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 678
    //   459: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload 4
    //   464: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   473: iconst_0
    //   474: istore_3
    //   475: goto -79 -> 396
    //   478: iconst_1
    //   479: istore_3
    //   480: goto -84 -> 396
    //   483: aload_0
    //   484: aload_0
    //   485: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   488: invokespecial 587	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   491: ifne +40 -> 531
    //   494: aload_1
    //   495: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   498: iconst_5
    //   499: ldc 64
    //   501: ldc 66
    //   503: new 68	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 680
    //   513: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_1
    //   517: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   520: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   529: iconst_0
    //   530: ireturn
    //   531: aload_0
    //   532: aload_0
    //   533: getfield 567	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   536: invokespecial 589	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   539: ifne +40 -> 579
    //   542: aload_1
    //   543: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   546: iconst_5
    //   547: ldc 64
    //   549: ldc 66
    //   551: new 68	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 682
    //   561: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   568: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   577: iconst_0
    //   578: ireturn
    //   579: iconst_1
    //   580: ireturn
    //   581: astore 4
    //   583: goto -482 -> 101
    //   586: astore_1
    //   587: goto -276 -> 311
    //   590: astore_2
    //   591: goto -267 -> 324
    //   594: astore_1
    //   595: aload 4
    //   597: astore_2
    //   598: goto -282 -> 316
    //   601: astore_1
    //   602: goto -286 -> 316
    //   605: astore 5
    //   607: aload 4
    //   609: astore_2
    //   610: aload 5
    //   612: astore 4
    //   614: goto -347 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	b
    //   0	617	1	paramFile1	File
    //   0	617	2	paramFile2	File
    //   395	85	3	n	int
    //   77	20	4	localObjectInputStream	java.io.ObjectInputStream
    //   263	23	4	localException1	Exception
    //   338	125	4	str	String
    //   581	27	4	localException2	Exception
    //   612	1	4	localObject	Object
    //   605	6	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   62	79	263	java/lang/Exception
    //   62	79	313	finally
    //   96	101	581	java/lang/Exception
    //   307	311	586	java/lang/Exception
    //   320	324	590	java/lang/Exception
    //   79	91	594	finally
    //   267	303	601	finally
    //   79	91	605	java/lang/Exception
  }
  
  public boolean a(File paramFile, String paramString)
  {
    return paramString.equalsIgnoreCase(d.a(paramFile));
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      d.a(paramString1, paramString2);
      return true;
    }
    catch (Throwable paramString1)
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "unzipFile,  exception: " + paramString1.toString());
    }
    return false;
  }
  
  public void b()
  {
    this.k = false;
    if (d())
    {
      this.k = true;
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fileInit checkUpdateLocalFiles true");
    }
    while (!e()) {
      return;
    }
    this.k = true;
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fileInit checkLocalFiles true");
  }
  
  /* Error */
  public boolean b(SDKLocalConfig paramSDKLocalConfig)
  {
    // Byte code:
    //   0: invokestatic 541	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 543
    //   6: invokevirtual 492	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 91	java/io/File
    //   17: dup
    //   18: new 68	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   25: invokestatic 546	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   28: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   31: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 549	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 551
    //   43: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: ldc 209
    //   51: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 173	java/io/File:exists	()Z
    //   59: ifne +36 -> 95
    //   62: iconst_5
    //   63: ldc 64
    //   65: ldc 66
    //   67: new 68	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 696
    //   77: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   84: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   93: iconst_0
    //   94: ireturn
    //   95: new 91	java/io/File
    //   98: dup
    //   99: new 68	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   106: invokestatic 546	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   109: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: getstatic 549	java/io/File:separator	Ljava/lang/String;
    //   118: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 551
    //   124: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: ldc 99
    //   132: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: astore_3
    //   136: aload_3
    //   137: invokevirtual 173	java/io/File:exists	()Z
    //   140: ifne +36 -> 176
    //   143: iconst_5
    //   144: ldc 64
    //   146: ldc 66
    //   148: new 68	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 698
    //   158: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   165: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   174: iconst_0
    //   175: ireturn
    //   176: new 647	java/io/ObjectInputStream
    //   179: dup
    //   180: new 649	java/io/FileInputStream
    //   183: dup
    //   184: aload_2
    //   185: invokespecial 650	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   188: invokespecial 651	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   191: astore 4
    //   193: aload 4
    //   195: invokevirtual 655	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   198: checkcast 128	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   201: astore 5
    //   203: aload 4
    //   205: invokevirtual 656	java/io/ObjectInputStream:close	()V
    //   208: aload 5
    //   210: ifnull +35 -> 245
    //   213: aload 5
    //   215: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   218: ifnull +27 -> 245
    //   221: aload 5
    //   223: getfield 506	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   226: ifnull +19 -> 245
    //   229: aload 5
    //   231: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   234: ifnull +11 -> 245
    //   237: aload 5
    //   239: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   242: ifnonnull +24 -> 266
    //   245: iconst_5
    //   246: ldc 64
    //   248: ldc 66
    //   250: ldc_w 700
    //   253: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_1
    //   259: aload 4
    //   261: invokevirtual 656	java/io/ObjectInputStream:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: aload_3
    //   267: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   270: astore 4
    //   272: aload 4
    //   274: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne +16 -> 293
    //   280: aload 4
    //   282: aload 5
    //   284: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   287: invokevirtual 440	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   290: ifne +57 -> 347
    //   293: iconst_5
    //   294: ldc_w 317
    //   297: ldc 66
    //   299: new 68	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 702
    //   309: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 5
    //   314: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   317: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc_w 678
    //   323: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 4
    //   328: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_2
    //   338: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   341: aload_3
    //   342: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   345: iconst_0
    //   346: ireturn
    //   347: iconst_3
    //   348: ldc 64
    //   350: ldc 66
    //   352: new 68	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 704
    //   362: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 5
    //   367: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   370: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 706
    //   376: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 5
    //   381: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   384: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload 5
    //   395: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   398: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   401: ifne +166 -> 567
    //   404: aload 5
    //   406: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   409: aload_1
    //   410: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   413: invokevirtual 440	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   416: ifeq +151 -> 567
    //   419: aload 5
    //   421: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   424: invokestatic 274	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +140 -> 567
    //   430: aload 5
    //   432: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   435: aload_1
    //   436: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   439: invokevirtual 440	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   442: ifeq +125 -> 567
    //   445: aload_0
    //   446: aload_0
    //   447: getfield 41	com/tencent/qqlive/mediaplayer/sdkupdate/b:f	Ljava/io/File;
    //   450: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   453: invokespecial 708	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Ljava/lang/String;)Z
    //   456: ifne +77 -> 533
    //   459: iconst_5
    //   460: ldc_w 317
    //   463: ldc 66
    //   465: ldc_w 710
    //   468: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   475: ifnull +26 -> 501
    //   478: aload_0
    //   479: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   482: invokevirtual 173	java/io/File:exists	()Z
    //   485: ifeq +16 -> 501
    //   488: aload_0
    //   489: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   492: invokevirtual 247	java/io/File:delete	()Z
    //   495: pop
    //   496: aload_0
    //   497: aconst_null
    //   498: putfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   501: aload_0
    //   502: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   505: ifnull +26 -> 531
    //   508: aload_0
    //   509: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   512: invokevirtual 173	java/io/File:exists	()Z
    //   515: ifeq +16 -> 531
    //   518: aload_0
    //   519: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   522: invokevirtual 247	java/io/File:delete	()Z
    //   525: pop
    //   526: aload_0
    //   527: aconst_null
    //   528: putfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   531: iconst_0
    //   532: ireturn
    //   533: iconst_1
    //   534: ireturn
    //   535: astore_1
    //   536: iconst_5
    //   537: ldc 64
    //   539: ldc 66
    //   541: new 68	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 712
    //   551: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload_1
    //   555: invokevirtual 256	java/lang/Exception:toString	()Ljava/lang/String;
    //   558: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   567: iconst_0
    //   568: ireturn
    //   569: astore_1
    //   570: goto -39 -> 531
    //   573: astore_1
    //   574: goto -73 -> 501
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	b
    //   0	577	1	paramSDKLocalConfig	SDKLocalConfig
    //   54	284	2	localFile1	File
    //   135	207	3	localFile2	File
    //   191	136	4	localObject	Object
    //   201	230	5	localSDKLocalConfig	SDKLocalConfig
    // Exception table:
    //   from	to	target	type
    //   193	203	258	java/lang/Exception
    //   0	12	535	java/lang/Exception
    //   14	93	535	java/lang/Exception
    //   95	174	535	java/lang/Exception
    //   176	193	535	java/lang/Exception
    //   203	208	535	java/lang/Exception
    //   213	245	535	java/lang/Exception
    //   245	256	535	java/lang/Exception
    //   259	264	535	java/lang/Exception
    //   266	293	535	java/lang/Exception
    //   293	345	535	java/lang/Exception
    //   347	471	535	java/lang/Exception
    //   471	501	535	java/lang/Exception
    //   501	531	535	java/lang/Exception
    //   501	531	569	java/lang/Throwable
    //   471	501	573	java/lang/Throwable
  }
  
  public boolean c()
  {
    return this.k;
  }
  
  public boolean d()
  {
    if (!a(this.f, this.h))
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "checkUpdateLocalFiles checkFileAndConfig failed");
      return false;
    }
    d.b(this.e);
    if (!this.f.renameTo(this.e))
    {
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "checkUpdateLocalFiles renameTo failed");
      return false;
    }
    return true;
  }
  
  public boolean e()
  {
    return a(this.e, this.g);
  }
  
  public void f()
  {
    if (this.m == null) {
      return;
    }
    if (this.d == 0)
    {
      this.m.onInstalledSuccessed();
      return;
    }
    this.m.onInstalledFailed(this.d);
  }
  
  public String g()
  {
    if (this.k) {
      return b(this.e, "TVK_MediaPlayer");
    }
    return null;
  }
  
  public String h()
  {
    Object localObject2 = null;
    if (this.k)
    {
      Object localObject1 = this.e;
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix, dirFile: " + localObject1 + " - prefix : " + "armeabi");
      if (localObject1 == null) {}
      File[] arrayOfFile;
      for (localObject1 = localObject2;; localObject1 = localObject2)
      {
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getLibs, isFileExisted=true, libPath: " + (String)localObject1);
        return localObject1;
        arrayOfFile = ((File)localObject1).listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
          break;
        }
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix , childFiles is null or length 0 ");
      }
      int i1 = arrayOfFile.length;
      int n = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= i1) {
          break;
        }
        localObject1 = arrayOfFile[n];
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix,  file.name : " + ((File)localObject1).getName() + " , file.path :" + ((File)localObject1).getAbsolutePath());
        if ((((File)localObject1).getName().length() >= "armeabi".length()) && (((File)localObject1).getName().substring(0, "armeabi".length()).equalsIgnoreCase("armeabi")))
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          break;
        }
        n += 1;
      }
    }
    d.a(4, "SDKUpdateHelper.java", "MediaPlayerMgr", "getLibs, isFileExisted=false, return null ");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.b
 * JD-Core Version:    0.7.0.1
 */