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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadByQQHttpEngine, pathString:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", remoteConfig:");
    ((StringBuilder)localObject).append(paramSDKLocalConfig);
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    d.b(new File(paramString));
    localObject = new File(paramString, "TvkPlugin.zip");
    ((File)localObject).getParentFile().mkdirs();
    try
    {
      int n = ((Integer)Class.forName("com.tencent.mobileqq.transfile.HttpInterfaceForTVK").getDeclaredMethod("downLoadFileSync", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramSDKLocalConfig.URL, ((File)localObject).getAbsolutePath() })).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadByQQHttpEngine, downResult =  ");
      localStringBuilder.append(n);
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder.toString());
      if (n == 0)
      {
        n = a((File)localObject, paramSDKLocalConfig, paramString);
        paramSDKLocalConfig = new StringBuilder();
        paramSDKLocalConfig.append("downloadByQQHttpEngine, uzipResult =  ");
        paramSDKLocalConfig.append(n);
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", paramSDKLocalConfig.toString());
        this.d = n;
        return this.d;
      }
      this.d = 101;
      n = this.d;
      return n;
    }
    catch (Throwable paramSDKLocalConfig)
    {
      paramString = new StringBuilder();
      paramString.append("downloadByQQHttpEngine Throwable, ");
      paramString.append(paramSDKLocalConfig.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", paramString.toString());
      return 101;
    }
    catch (NoSuchMethodException paramSDKLocalConfig)
    {
      paramString = new StringBuilder();
      paramString.append("downloadByQQHttpEngine NoSuchMethodException, ");
      paramString.append(paramSDKLocalConfig.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", paramString.toString());
      return 101;
    }
    catch (ClassNotFoundException paramSDKLocalConfig)
    {
      paramString = new StringBuilder();
      paramString.append("downloadByQQHttpEngine ClassNotFoundException, ");
      paramString.append(paramSDKLocalConfig.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", paramString.toString());
    }
    return 101;
  }
  
  /* Error */
  private int a(File paramFile, SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +871 -> 872
    //   4: aload_1
    //   5: invokevirtual 173	java/io/File:exists	()Z
    //   8: ifeq +864 -> 872
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   17: invokevirtual 179	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Ljava/lang/String;)Z
    //   20: ifne +42 -> 62
    //   23: new 64	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   30: astore_1
    //   31: aload_1
    //   32: ldc 181
    //   34: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_1
    //   39: aload_2
    //   40: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   43: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: iconst_5
    //   48: ldc 78
    //   50: ldc 80
    //   52: aload_1
    //   53: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: bipush 103
    //   61: ireturn
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: aload_3
    //   68: invokevirtual 184	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   71: ifne +16 -> 87
    //   74: iconst_5
    //   75: ldc 78
    //   77: ldc 80
    //   79: ldc 186
    //   81: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   84: bipush 103
    //   86: ireturn
    //   87: aload_0
    //   88: iconst_1
    //   89: putfield 51	com/tencent/qqlive/mediaplayer/sdkupdate/b:k	Z
    //   92: iconst_3
    //   93: ldc 78
    //   95: ldc 80
    //   97: ldc 188
    //   99: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   102: new 91	java/io/File
    //   105: dup
    //   106: aload_0
    //   107: invokevirtual 190	com/tencent/qqlive/mediaplayer/sdkupdate/b:h	()Ljava/lang/String;
    //   110: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   113: iconst_5
    //   114: invokestatic 193	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;I)V
    //   117: goto +43 -> 160
    //   120: new 64	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   127: astore 4
    //   129: aload 4
    //   131: ldc 195
    //   133: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: aload_0
    //   140: invokevirtual 196	java/lang/Object:toString	()Ljava/lang/String;
    //   143: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: iconst_5
    //   148: ldc 78
    //   150: ldc 80
    //   152: aload 4
    //   154: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_0
    //   161: aload_3
    //   162: invokespecial 199	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   165: astore 4
    //   167: aload 4
    //   169: ifnonnull +16 -> 185
    //   172: iconst_5
    //   173: ldc 78
    //   175: ldc 80
    //   177: ldc 201
    //   179: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   182: bipush 103
    //   184: ireturn
    //   185: aload_2
    //   186: aload 4
    //   188: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   191: putfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   194: aconst_null
    //   195: astore 9
    //   197: aconst_null
    //   198: astore 10
    //   200: aconst_null
    //   201: astore 11
    //   203: aconst_null
    //   204: astore 12
    //   206: aconst_null
    //   207: astore 14
    //   209: aconst_null
    //   210: astore 13
    //   212: aconst_null
    //   213: astore 7
    //   215: new 91	java/io/File
    //   218: dup
    //   219: aload_3
    //   220: ldc 209
    //   222: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: astore 15
    //   227: new 211	java/io/ByteArrayOutputStream
    //   230: dup
    //   231: sipush 4096
    //   234: invokespecial 214	java/io/ByteArrayOutputStream:<init>	(I)V
    //   237: astore 4
    //   239: new 216	java/io/ObjectOutputStream
    //   242: dup
    //   243: aload 4
    //   245: invokespecial 219	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   248: astore 8
    //   250: aload 14
    //   252: astore_3
    //   253: aload 8
    //   255: astore 5
    //   257: aload 4
    //   259: astore 6
    //   261: aload 8
    //   263: aload_2
    //   264: invokevirtual 223	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   267: aload 14
    //   269: astore_3
    //   270: aload 8
    //   272: astore 5
    //   274: aload 4
    //   276: astore 6
    //   278: aload 8
    //   280: invokevirtual 226	java/io/ObjectOutputStream:flush	()V
    //   283: aload 14
    //   285: astore_3
    //   286: aload 8
    //   288: astore 5
    //   290: aload 4
    //   292: astore 6
    //   294: aload 8
    //   296: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   299: new 231	java/io/FileOutputStream
    //   302: dup
    //   303: aload 15
    //   305: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   308: astore_3
    //   309: aload 4
    //   311: aload_3
    //   312: invokevirtual 236	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   315: aload 4
    //   317: invokevirtual 237	java/io/ByteArrayOutputStream:flush	()V
    //   320: aload 4
    //   322: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   325: aload_3
    //   326: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   329: new 64	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   336: astore_3
    //   337: aload_3
    //   338: ldc 241
    //   340: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_3
    //   345: aload_2
    //   346: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: iconst_3
    //   351: ldc 78
    //   353: ldc 80
    //   355: aload_3
    //   356: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_1
    //   363: invokevirtual 244	java/io/File:delete	()Z
    //   366: pop
    //   367: iconst_0
    //   368: ireturn
    //   369: astore_1
    //   370: goto +110 -> 480
    //   373: astore 8
    //   375: aload_3
    //   376: astore 7
    //   378: goto +117 -> 495
    //   381: astore 8
    //   383: aload_3
    //   384: astore 7
    //   386: goto +271 -> 657
    //   389: astore_1
    //   390: aconst_null
    //   391: astore 5
    //   393: goto +425 -> 818
    //   396: astore 8
    //   398: aconst_null
    //   399: astore_2
    //   400: aload_3
    //   401: astore 7
    //   403: goto +97 -> 500
    //   406: astore 8
    //   408: aconst_null
    //   409: astore_2
    //   410: aload_3
    //   411: astore 7
    //   413: goto +249 -> 662
    //   416: astore_3
    //   417: aload 10
    //   419: astore 7
    //   421: aload 8
    //   423: astore_2
    //   424: aload_3
    //   425: astore 8
    //   427: goto +73 -> 500
    //   430: astore_3
    //   431: aload 12
    //   433: astore 7
    //   435: aload 8
    //   437: astore_2
    //   438: aload_3
    //   439: astore 8
    //   441: goto +221 -> 662
    //   444: astore_1
    //   445: aconst_null
    //   446: astore 5
    //   448: aload 13
    //   450: astore_3
    //   451: goto +367 -> 818
    //   454: astore 8
    //   456: aconst_null
    //   457: astore_2
    //   458: aload 10
    //   460: astore 7
    //   462: goto +38 -> 500
    //   465: astore 8
    //   467: aconst_null
    //   468: astore_2
    //   469: aload 12
    //   471: astore 7
    //   473: goto +189 -> 662
    //   476: astore_1
    //   477: aload 7
    //   479: astore_3
    //   480: aconst_null
    //   481: astore 4
    //   483: aconst_null
    //   484: astore 5
    //   486: goto +332 -> 818
    //   489: astore 8
    //   491: aload 9
    //   493: astore 7
    //   495: aconst_null
    //   496: astore 4
    //   498: aconst_null
    //   499: astore_2
    //   500: aload 7
    //   502: astore_3
    //   503: aload_2
    //   504: astore 5
    //   506: aload 4
    //   508: astore 6
    //   510: new 64	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   517: astore 9
    //   519: aload 7
    //   521: astore_3
    //   522: aload_2
    //   523: astore 5
    //   525: aload 4
    //   527: astore 6
    //   529: aload 9
    //   531: ldc 246
    //   533: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 7
    //   539: astore_3
    //   540: aload_2
    //   541: astore 5
    //   543: aload 4
    //   545: astore 6
    //   547: aload 9
    //   549: aload 8
    //   551: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   554: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 7
    //   560: astore_3
    //   561: aload_2
    //   562: astore 5
    //   564: aload 4
    //   566: astore 6
    //   568: iconst_5
    //   569: ldc 78
    //   571: ldc 80
    //   573: aload 9
    //   575: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 7
    //   583: astore_3
    //   584: aload_2
    //   585: astore 5
    //   587: aload 4
    //   589: astore 6
    //   591: aload_1
    //   592: invokevirtual 244	java/io/File:delete	()Z
    //   595: pop
    //   596: aload 7
    //   598: ifnull +16 -> 614
    //   601: aload 7
    //   603: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   606: goto +8 -> 614
    //   609: astore_1
    //   610: aload_1
    //   611: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   614: aload_2
    //   615: ifnull +15 -> 630
    //   618: aload_2
    //   619: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   622: goto +8 -> 630
    //   625: astore_1
    //   626: aload_1
    //   627: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   630: aload 4
    //   632: ifnull +16 -> 648
    //   635: aload 4
    //   637: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   640: bipush 100
    //   642: ireturn
    //   643: astore_1
    //   644: aload_1
    //   645: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   648: bipush 100
    //   650: ireturn
    //   651: astore 8
    //   653: aload 11
    //   655: astore 7
    //   657: aconst_null
    //   658: astore 4
    //   660: aconst_null
    //   661: astore_2
    //   662: aload 7
    //   664: astore_3
    //   665: aload_2
    //   666: astore 5
    //   668: aload 4
    //   670: astore 6
    //   672: new 64	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   679: astore 9
    //   681: aload 7
    //   683: astore_3
    //   684: aload_2
    //   685: astore 5
    //   687: aload 4
    //   689: astore 6
    //   691: aload 9
    //   693: ldc 252
    //   695: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 7
    //   701: astore_3
    //   702: aload_2
    //   703: astore 5
    //   705: aload 4
    //   707: astore 6
    //   709: aload 9
    //   711: aload 8
    //   713: invokevirtual 253	java/io/IOException:toString	()Ljava/lang/String;
    //   716: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 7
    //   722: astore_3
    //   723: aload_2
    //   724: astore 5
    //   726: aload 4
    //   728: astore 6
    //   730: iconst_5
    //   731: ldc 78
    //   733: ldc 80
    //   735: aload 9
    //   737: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   740: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload 7
    //   745: astore_3
    //   746: aload_2
    //   747: astore 5
    //   749: aload 4
    //   751: astore 6
    //   753: aload_1
    //   754: invokevirtual 244	java/io/File:delete	()Z
    //   757: pop
    //   758: aload 7
    //   760: ifnull +16 -> 776
    //   763: aload 7
    //   765: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   768: goto +8 -> 776
    //   771: astore_1
    //   772: aload_1
    //   773: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   776: aload_2
    //   777: ifnull +15 -> 792
    //   780: aload_2
    //   781: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   784: goto +8 -> 792
    //   787: astore_1
    //   788: aload_1
    //   789: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   792: aload 4
    //   794: ifnull +16 -> 810
    //   797: aload 4
    //   799: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   802: bipush 104
    //   804: ireturn
    //   805: astore_1
    //   806: aload_1
    //   807: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   810: bipush 104
    //   812: ireturn
    //   813: astore_1
    //   814: aload 6
    //   816: astore 4
    //   818: aload_3
    //   819: ifnull +15 -> 834
    //   822: aload_3
    //   823: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   826: goto +8 -> 834
    //   829: astore_2
    //   830: aload_2
    //   831: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   834: aload 5
    //   836: ifnull +16 -> 852
    //   839: aload 5
    //   841: invokevirtual 229	java/io/ObjectOutputStream:close	()V
    //   844: goto +8 -> 852
    //   847: astore_2
    //   848: aload_2
    //   849: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   852: aload 4
    //   854: ifnull +16 -> 870
    //   857: aload 4
    //   859: invokevirtual 238	java/io/ByteArrayOutputStream:close	()V
    //   862: goto +8 -> 870
    //   865: astore_2
    //   866: aload_2
    //   867: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   870: aload_1
    //   871: athrow
    //   872: new 64	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   879: astore_2
    //   880: aload_2
    //   881: ldc 255
    //   883: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload_2
    //   888: aload_1
    //   889: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: iconst_5
    //   894: ldc 78
    //   896: ldc 80
    //   898: aload_2
    //   899: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   905: bipush 103
    //   907: ireturn
    //   908: astore 4
    //   910: goto -790 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	b
    //   0	913	1	paramFile	File
    //   0	913	2	paramSDKLocalConfig	SDKLocalConfig
    //   0	913	3	paramString	String
    //   127	731	4	localObject1	Object
    //   908	1	4	localThrowable	Throwable
    //   255	585	5	localObject2	Object
    //   259	556	6	localObject3	Object
    //   213	551	7	localObject4	Object
    //   248	47	8	localObjectOutputStream	java.io.ObjectOutputStream
    //   373	1	8	localException1	Exception
    //   381	1	8	localIOException1	java.io.IOException
    //   396	1	8	localException2	Exception
    //   406	16	8	localIOException2	java.io.IOException
    //   425	15	8	str	String
    //   454	1	8	localException3	Exception
    //   465	1	8	localIOException3	java.io.IOException
    //   489	61	8	localException4	Exception
    //   651	61	8	localIOException4	java.io.IOException
    //   195	541	9	localStringBuilder	StringBuilder
    //   198	261	10	localObject5	Object
    //   201	453	11	localObject6	Object
    //   204	266	12	localObject7	Object
    //   210	239	13	localObject8	Object
    //   207	77	14	localObject9	Object
    //   225	79	15	localFile	File
    // Exception table:
    //   from	to	target	type
    //   325	329	369	finally
    //   325	329	373	java/lang/Exception
    //   325	329	381	java/io/IOException
    //   309	325	389	finally
    //   309	325	396	java/lang/Exception
    //   309	325	406	java/io/IOException
    //   261	267	416	java/lang/Exception
    //   278	283	416	java/lang/Exception
    //   294	299	416	java/lang/Exception
    //   261	267	430	java/io/IOException
    //   278	283	430	java/io/IOException
    //   294	299	430	java/io/IOException
    //   239	250	444	finally
    //   299	309	444	finally
    //   239	250	454	java/lang/Exception
    //   299	309	454	java/lang/Exception
    //   239	250	465	java/io/IOException
    //   299	309	465	java/io/IOException
    //   215	239	476	finally
    //   329	362	476	finally
    //   215	239	489	java/lang/Exception
    //   329	362	489	java/lang/Exception
    //   601	606	609	java/io/IOException
    //   618	622	625	java/io/IOException
    //   635	640	643	java/io/IOException
    //   215	239	651	java/io/IOException
    //   329	362	651	java/io/IOException
    //   763	768	771	java/io/IOException
    //   780	784	787	java/io/IOException
    //   797	802	805	java/io/IOException
    //   261	267	813	finally
    //   278	283	813	finally
    //   294	299	813	finally
    //   510	519	813	finally
    //   529	537	813	finally
    //   547	558	813	finally
    //   568	581	813	finally
    //   591	596	813	finally
    //   672	681	813	finally
    //   691	699	813	finally
    //   709	720	813	finally
    //   730	743	813	finally
    //   753	758	813	finally
    //   822	826	829	java/io/IOException
    //   839	844	847	java/io/IOException
    //   857	862	865	java/io/IOException
    //   92	117	908	java/lang/Throwable
  }
  
  private File a(String paramString)
  {
    if (paramString.contains("TencentVideoKitUpdate")) {
      paramString = this.f;
    } else {
      paramString = this.e;
    }
    paramString = b(paramString, "TVK_MediaPlayer");
    if (!TextUtils.isEmpty(paramString)) {
      return new File(paramString);
    }
    return null;
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 13
    //   7: aconst_null
    //   8: astore 14
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 8
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 15
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore 6
    //   28: new 278	java/net/URL
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 279	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 283	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 285	java/net/HttpURLConnection
    //   42: astore 5
    //   44: iload_2
    //   45: ifne +71 -> 116
    //   48: aload_3
    //   49: astore 10
    //   51: aload 6
    //   53: astore 7
    //   55: aload_3
    //   56: astore 11
    //   58: aload 13
    //   60: astore 8
    //   62: aload_3
    //   63: astore 12
    //   65: aload 14
    //   67: astore 9
    //   69: aload 15
    //   71: astore_1
    //   72: aload 5
    //   74: astore 4
    //   76: aload 5
    //   78: iconst_1
    //   79: invokevirtual 289	java/net/HttpURLConnection:setDoInput	(Z)V
    //   82: aload_3
    //   83: astore 10
    //   85: aload 6
    //   87: astore 7
    //   89: aload_3
    //   90: astore 11
    //   92: aload 13
    //   94: astore 8
    //   96: aload_3
    //   97: astore 12
    //   99: aload 14
    //   101: astore 9
    //   103: aload 15
    //   105: astore_1
    //   106: aload 5
    //   108: astore 4
    //   110: aload 5
    //   112: iconst_1
    //   113: invokevirtual 292	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   116: aload_3
    //   117: astore 10
    //   119: aload 6
    //   121: astore 7
    //   123: aload_3
    //   124: astore 11
    //   126: aload 13
    //   128: astore 8
    //   130: aload_3
    //   131: astore 12
    //   133: aload 14
    //   135: astore 9
    //   137: aload 15
    //   139: astore_1
    //   140: aload 5
    //   142: astore 4
    //   144: aload 5
    //   146: iconst_0
    //   147: invokevirtual 295	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   150: aload_3
    //   151: astore 10
    //   153: aload 6
    //   155: astore 7
    //   157: aload_3
    //   158: astore 11
    //   160: aload 13
    //   162: astore 8
    //   164: aload_3
    //   165: astore 12
    //   167: aload 14
    //   169: astore 9
    //   171: aload 15
    //   173: astore_1
    //   174: aload 5
    //   176: astore 4
    //   178: aload 5
    //   180: ldc_w 297
    //   183: invokevirtual 300	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   186: aload_3
    //   187: astore 10
    //   189: aload 6
    //   191: astore 7
    //   193: aload_3
    //   194: astore 11
    //   196: aload 13
    //   198: astore 8
    //   200: aload_3
    //   201: astore 12
    //   203: aload 14
    //   205: astore 9
    //   207: aload 15
    //   209: astore_1
    //   210: aload 5
    //   212: astore 4
    //   214: aload 5
    //   216: invokevirtual 304	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   219: astore 6
    //   221: aload_3
    //   222: astore 10
    //   224: aload 6
    //   226: astore 7
    //   228: aload_3
    //   229: astore 11
    //   231: aload 6
    //   233: astore 8
    //   235: aload_3
    //   236: astore 12
    //   238: aload 6
    //   240: astore 9
    //   242: aload 6
    //   244: astore_1
    //   245: aload 5
    //   247: astore 4
    //   249: new 306	java/io/BufferedReader
    //   252: dup
    //   253: new 308	java/io/InputStreamReader
    //   256: dup
    //   257: aload 6
    //   259: invokespecial 311	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   262: invokespecial 314	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   265: astore 13
    //   267: aload_3
    //   268: astore 10
    //   270: aload 6
    //   272: astore 7
    //   274: aload_3
    //   275: astore 11
    //   277: aload 6
    //   279: astore 8
    //   281: aload_3
    //   282: astore 12
    //   284: aload 6
    //   286: astore 9
    //   288: aload 6
    //   290: astore_1
    //   291: aload 5
    //   293: astore 4
    //   295: aload 13
    //   297: invokevirtual 317	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   300: astore 14
    //   302: aload 14
    //   304: ifnull +185 -> 489
    //   307: aload_3
    //   308: astore 10
    //   310: aload 6
    //   312: astore 7
    //   314: aload_3
    //   315: astore 11
    //   317: aload 6
    //   319: astore 8
    //   321: aload_3
    //   322: astore 12
    //   324: aload 6
    //   326: astore 9
    //   328: aload 6
    //   330: astore_1
    //   331: aload 5
    //   333: astore 4
    //   335: new 64	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   342: astore 15
    //   344: aload_3
    //   345: astore 10
    //   347: aload 6
    //   349: astore 7
    //   351: aload_3
    //   352: astore 11
    //   354: aload 6
    //   356: astore 8
    //   358: aload_3
    //   359: astore 12
    //   361: aload 6
    //   363: astore 9
    //   365: aload 6
    //   367: astore_1
    //   368: aload 5
    //   370: astore 4
    //   372: aload 15
    //   374: aload_3
    //   375: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_3
    //   380: astore 10
    //   382: aload 6
    //   384: astore 7
    //   386: aload_3
    //   387: astore 11
    //   389: aload 6
    //   391: astore 8
    //   393: aload_3
    //   394: astore 12
    //   396: aload 6
    //   398: astore 9
    //   400: aload 6
    //   402: astore_1
    //   403: aload 5
    //   405: astore 4
    //   407: aload 15
    //   409: aload 14
    //   411: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_3
    //   416: astore 10
    //   418: aload 6
    //   420: astore 7
    //   422: aload_3
    //   423: astore 11
    //   425: aload 6
    //   427: astore 8
    //   429: aload_3
    //   430: astore 12
    //   432: aload 6
    //   434: astore 9
    //   436: aload 6
    //   438: astore_1
    //   439: aload 5
    //   441: astore 4
    //   443: aload 15
    //   445: ldc_w 319
    //   448: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_3
    //   453: astore 10
    //   455: aload 6
    //   457: astore 7
    //   459: aload_3
    //   460: astore 11
    //   462: aload 6
    //   464: astore 8
    //   466: aload_3
    //   467: astore 12
    //   469: aload 6
    //   471: astore 9
    //   473: aload 6
    //   475: astore_1
    //   476: aload 5
    //   478: astore 4
    //   480: aload 15
    //   482: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: astore_3
    //   486: goto -219 -> 267
    //   489: aload 6
    //   491: ifnull +16 -> 507
    //   494: aload 6
    //   496: invokevirtual 322	java/io/InputStream:close	()V
    //   499: goto +8 -> 507
    //   502: astore_1
    //   503: aload_1
    //   504: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   507: aload_3
    //   508: astore_1
    //   509: aload 5
    //   511: ifnull +357 -> 868
    //   514: aload 5
    //   516: invokevirtual 325	java/net/HttpURLConnection:disconnect	()V
    //   519: aload_3
    //   520: areturn
    //   521: astore 6
    //   523: aload 10
    //   525: astore_3
    //   526: goto +38 -> 564
    //   529: astore 6
    //   531: aload 11
    //   533: astore_3
    //   534: goto +133 -> 667
    //   537: astore 6
    //   539: aload 12
    //   541: astore_3
    //   542: goto +228 -> 770
    //   545: astore_3
    //   546: aconst_null
    //   547: astore 5
    //   549: aload 4
    //   551: astore_1
    //   552: aload 5
    //   554: astore 4
    //   556: goto +315 -> 871
    //   559: astore 6
    //   561: aconst_null
    //   562: astore 5
    //   564: aload 7
    //   566: astore_1
    //   567: aload 5
    //   569: astore 4
    //   571: new 64	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   578: astore 8
    //   580: aload 7
    //   582: astore_1
    //   583: aload 5
    //   585: astore 4
    //   587: aload 8
    //   589: ldc_w 327
    //   592: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 7
    //   598: astore_1
    //   599: aload 5
    //   601: astore 4
    //   603: aload 8
    //   605: aload 6
    //   607: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   610: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 7
    //   616: astore_1
    //   617: aload 5
    //   619: astore 4
    //   621: iconst_5
    //   622: ldc 78
    //   624: ldc 80
    //   626: aload 8
    //   628: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload 7
    //   636: ifnull +16 -> 652
    //   639: aload 7
    //   641: invokevirtual 322	java/io/InputStream:close	()V
    //   644: goto +8 -> 652
    //   647: astore_1
    //   648: aload_1
    //   649: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   652: aload_3
    //   653: astore_1
    //   654: aload 5
    //   656: ifnull +212 -> 868
    //   659: goto -145 -> 514
    //   662: astore 6
    //   664: aconst_null
    //   665: astore 5
    //   667: aload 8
    //   669: astore_1
    //   670: aload 5
    //   672: astore 4
    //   674: new 64	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   681: astore 7
    //   683: aload 8
    //   685: astore_1
    //   686: aload 5
    //   688: astore 4
    //   690: aload 7
    //   692: ldc_w 329
    //   695: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 8
    //   701: astore_1
    //   702: aload 5
    //   704: astore 4
    //   706: aload 7
    //   708: aload 6
    //   710: invokevirtual 253	java/io/IOException:toString	()Ljava/lang/String;
    //   713: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: aload 8
    //   719: astore_1
    //   720: aload 5
    //   722: astore 4
    //   724: iconst_5
    //   725: ldc 78
    //   727: ldc 80
    //   729: aload 7
    //   731: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload 8
    //   739: ifnull +16 -> 755
    //   742: aload 8
    //   744: invokevirtual 322	java/io/InputStream:close	()V
    //   747: goto +8 -> 755
    //   750: astore_1
    //   751: aload_1
    //   752: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   755: aload_3
    //   756: astore_1
    //   757: aload 5
    //   759: ifnull +109 -> 868
    //   762: goto -248 -> 514
    //   765: astore 6
    //   767: aconst_null
    //   768: astore 5
    //   770: aload 9
    //   772: astore_1
    //   773: aload 5
    //   775: astore 4
    //   777: new 64	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   784: astore 7
    //   786: aload 9
    //   788: astore_1
    //   789: aload 5
    //   791: astore 4
    //   793: aload 7
    //   795: ldc_w 331
    //   798: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 9
    //   804: astore_1
    //   805: aload 5
    //   807: astore 4
    //   809: aload 7
    //   811: aload 6
    //   813: invokevirtual 332	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   816: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 9
    //   822: astore_1
    //   823: aload 5
    //   825: astore 4
    //   827: iconst_5
    //   828: ldc 78
    //   830: ldc 80
    //   832: aload 7
    //   834: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload 9
    //   842: ifnull +16 -> 858
    //   845: aload 9
    //   847: invokevirtual 322	java/io/InputStream:close	()V
    //   850: goto +8 -> 858
    //   853: astore_1
    //   854: aload_1
    //   855: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   858: aload_3
    //   859: astore_1
    //   860: aload 5
    //   862: ifnull +6 -> 868
    //   865: goto -351 -> 514
    //   868: aload_1
    //   869: areturn
    //   870: astore_3
    //   871: aload_1
    //   872: ifnull +15 -> 887
    //   875: aload_1
    //   876: invokevirtual 322	java/io/InputStream:close	()V
    //   879: goto +8 -> 887
    //   882: astore_1
    //   883: aload_1
    //   884: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   887: aload 4
    //   889: ifnull +8 -> 897
    //   892: aload 4
    //   894: invokevirtual 325	java/net/HttpURLConnection:disconnect	()V
    //   897: goto +5 -> 902
    //   900: aload_3
    //   901: athrow
    //   902: goto -2 -> 900
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	this	b
    //   0	905	1	paramString	String
    //   0	905	2	paramBoolean	boolean
    //   3	539	3	localObject1	Object
    //   545	314	3	localObject2	Object
    //   870	31	3	localObject3	Object
    //   23	870	4	localObject4	Object
    //   42	819	5	localHttpURLConnection	java.net.HttpURLConnection
    //   26	469	6	localInputStream	java.io.InputStream
    //   521	1	6	localException1	Exception
    //   529	1	6	localIOException1	java.io.IOException
    //   537	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   559	47	6	localException2	Exception
    //   662	47	6	localIOException2	java.io.IOException
    //   765	47	6	localMalformedURLException2	java.net.MalformedURLException
    //   11	822	7	localObject5	Object
    //   14	729	8	localObject6	Object
    //   17	829	9	localObject7	Object
    //   49	475	10	localObject8	Object
    //   56	476	11	localObject9	Object
    //   63	477	12	localObject10	Object
    //   5	291	13	localBufferedReader	java.io.BufferedReader
    //   8	402	14	str	String
    //   20	461	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   494	499	502	java/io/IOException
    //   76	82	521	java/lang/Exception
    //   110	116	521	java/lang/Exception
    //   144	150	521	java/lang/Exception
    //   178	186	521	java/lang/Exception
    //   214	221	521	java/lang/Exception
    //   249	267	521	java/lang/Exception
    //   295	302	521	java/lang/Exception
    //   335	344	521	java/lang/Exception
    //   372	379	521	java/lang/Exception
    //   407	415	521	java/lang/Exception
    //   443	452	521	java/lang/Exception
    //   480	486	521	java/lang/Exception
    //   76	82	529	java/io/IOException
    //   110	116	529	java/io/IOException
    //   144	150	529	java/io/IOException
    //   178	186	529	java/io/IOException
    //   214	221	529	java/io/IOException
    //   249	267	529	java/io/IOException
    //   295	302	529	java/io/IOException
    //   335	344	529	java/io/IOException
    //   372	379	529	java/io/IOException
    //   407	415	529	java/io/IOException
    //   443	452	529	java/io/IOException
    //   480	486	529	java/io/IOException
    //   76	82	537	java/net/MalformedURLException
    //   110	116	537	java/net/MalformedURLException
    //   144	150	537	java/net/MalformedURLException
    //   178	186	537	java/net/MalformedURLException
    //   214	221	537	java/net/MalformedURLException
    //   249	267	537	java/net/MalformedURLException
    //   295	302	537	java/net/MalformedURLException
    //   335	344	537	java/net/MalformedURLException
    //   372	379	537	java/net/MalformedURLException
    //   407	415	537	java/net/MalformedURLException
    //   443	452	537	java/net/MalformedURLException
    //   480	486	537	java/net/MalformedURLException
    //   28	44	545	finally
    //   28	44	559	java/lang/Exception
    //   639	644	647	java/io/IOException
    //   28	44	662	java/io/IOException
    //   742	747	750	java/io/IOException
    //   28	44	765	java/net/MalformedURLException
    //   845	850	853	java/io/IOException
    //   76	82	870	finally
    //   110	116	870	finally
    //   144	150	870	finally
    //   178	186	870	finally
    //   214	221	870	finally
    //   249	267	870	finally
    //   295	302	870	finally
    //   335	344	870	finally
    //   372	379	870	finally
    //   407	415	870	finally
    //   443	452	870	finally
    //   480	486	870	finally
    //   571	580	870	finally
    //   587	596	870	finally
    //   603	614	870	finally
    //   621	634	870	finally
    //   674	683	870	finally
    //   690	699	870	finally
    //   706	717	870	finally
    //   724	737	870	finally
    //   777	786	870	finally
    //   793	802	870	finally
    //   809	820	870	finally
    //   827	840	870	finally
    //   875	879	882	java/io/IOException
  }
  
  /* Error */
  private int b(SDKLocalConfig paramSDKLocalConfig, String paramString)
  {
    // Byte code:
    //   0: ldc_w 338
    //   3: astore 17
    //   5: ldc_w 340
    //   8: astore 16
    //   10: iconst_3
    //   11: istore 9
    //   13: iconst_3
    //   14: istore 10
    //   16: iload 10
    //   18: iconst_1
    //   19: isub
    //   20: istore 8
    //   22: iload 10
    //   24: ifle +4133 -> 4157
    //   27: aload_0
    //   28: getfield 55	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	Landroid/content/Context;
    //   31: invokestatic 343	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Landroid/content/Context;)Z
    //   34: ifne +23 -> 57
    //   37: iload 8
    //   39: iconst_2
    //   40: if_icmpge +17 -> 57
    //   43: iconst_5
    //   44: ldc 78
    //   46: ldc 80
    //   48: ldc_w 345
    //   51: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   54: bipush 101
    //   56: ireturn
    //   57: new 64	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   64: astore 18
    //   66: aload 18
    //   68: ldc_w 347
    //   71: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 18
    //   77: iconst_2
    //   78: iload 8
    //   80: isub
    //   81: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 18
    //   87: ldc_w 349
    //   90: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 18
    //   96: aload_2
    //   97: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 18
    //   103: ldc 73
    //   105: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 18
    //   111: aload_1
    //   112: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload 9
    //   118: ldc 78
    //   120: ldc 80
    //   122: aload 18
    //   124: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   130: new 91	java/io/File
    //   133: dup
    //   134: aload_2
    //   135: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   141: new 91	java/io/File
    //   144: dup
    //   145: aload_2
    //   146: ldc 99
    //   148: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: astore 22
    //   153: aload 22
    //   155: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   158: invokevirtual 110	java/io/File:mkdirs	()Z
    //   161: pop
    //   162: new 278	java/net/URL
    //   165: dup
    //   166: aload_1
    //   167: getfield 132	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:URL	Ljava/lang/String;
    //   170: invokespecial 279	java/net/URL:<init>	(Ljava/lang/String;)V
    //   173: invokevirtual 283	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   176: checkcast 285	java/net/HttpURLConnection
    //   179: astore 23
    //   181: aload 23
    //   183: ifnonnull +22 -> 205
    //   186: iconst_5
    //   187: ldc 78
    //   189: ldc 80
    //   191: ldc_w 351
    //   194: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   197: iload 8
    //   199: ifne +3961 -> 4160
    //   202: bipush 101
    //   204: ireturn
    //   205: new 231	java/io/FileOutputStream
    //   208: dup
    //   209: aload 22
    //   211: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   214: astore 18
    //   216: aload 23
    //   218: invokevirtual 354	java/net/HttpURLConnection:getResponseCode	()I
    //   221: istore 10
    //   223: iload 10
    //   225: sipush 300
    //   228: if_icmple +157 -> 385
    //   231: iload 8
    //   233: ifne +90 -> 323
    //   236: new 64	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   243: astore 19
    //   245: aload 19
    //   247: ldc_w 356
    //   250: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 19
    //   256: iload 10
    //   258: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: iconst_5
    //   263: ldc 78
    //   265: ldc 80
    //   267: aload 19
    //   269: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 18
    //   277: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   280: bipush 102
    //   282: ireturn
    //   283: astore_1
    //   284: new 64	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   291: astore_2
    //   292: aload_2
    //   293: aload 17
    //   295: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_2
    //   300: aload_1
    //   301: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   304: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: iconst_5
    //   309: ldc 78
    //   311: ldc 80
    //   313: aload_2
    //   314: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   320: bipush 102
    //   322: ireturn
    //   323: new 64	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   330: astore 19
    //   332: aload 19
    //   334: ldc_w 358
    //   337: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 19
    //   343: iload 10
    //   345: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: iload 9
    //   351: ldc 78
    //   353: ldc 80
    //   355: aload 19
    //   357: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 18
    //   365: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   368: goto +3792 -> 4160
    //   371: astore 18
    //   373: new 64	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   380: astore 19
    //   382: goto +110 -> 492
    //   385: aload 23
    //   387: ldc_w 360
    //   390: invokevirtual 364	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   393: invokestatic 368	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   396: i2l
    //   397: lstore 14
    //   399: lconst_0
    //   400: lstore 12
    //   402: lload 14
    //   404: lconst_0
    //   405: lcmp
    //   406: ifne +121 -> 527
    //   409: iconst_5
    //   410: ldc 78
    //   412: ldc 80
    //   414: ldc_w 370
    //   417: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   420: iload 8
    //   422: ifne +51 -> 473
    //   425: aload 18
    //   427: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   430: bipush 103
    //   432: ireturn
    //   433: astore_1
    //   434: new 64	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   441: astore_2
    //   442: aload_2
    //   443: aload 17
    //   445: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_2
    //   450: aload_1
    //   451: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   454: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: iconst_5
    //   459: ldc 78
    //   461: ldc 80
    //   463: aload_2
    //   464: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   470: bipush 103
    //   472: ireturn
    //   473: aload 18
    //   475: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   478: goto +3682 -> 4160
    //   481: astore 18
    //   483: new 64	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   490: astore 19
    //   492: aload 19
    //   494: aload 17
    //   496: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 19
    //   502: aload 18
    //   504: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: iconst_5
    //   512: ldc 78
    //   514: ldc 80
    //   516: aload 19
    //   518: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   524: goto +3636 -> 4160
    //   527: aload 23
    //   529: invokevirtual 304	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   532: astore 20
    //   534: aload 20
    //   536: ifnonnull +344 -> 880
    //   539: iload 8
    //   541: ifne +222 -> 763
    //   544: iconst_5
    //   545: ldc 78
    //   547: ldc 80
    //   549: ldc_w 372
    //   552: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 20
    //   557: ifnull +48 -> 605
    //   560: aload 20
    //   562: invokevirtual 322	java/io/InputStream:close	()V
    //   565: goto +40 -> 605
    //   568: astore_1
    //   569: new 64	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   576: astore_2
    //   577: aload_2
    //   578: aload 16
    //   580: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_2
    //   585: aload_1
    //   586: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   589: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: iconst_5
    //   594: ldc 78
    //   596: ldc 80
    //   598: aload_2
    //   599: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   605: aload 18
    //   607: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   610: bipush 103
    //   612: ireturn
    //   613: astore_1
    //   614: new 64	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   621: astore_2
    //   622: aload_2
    //   623: aload 17
    //   625: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: aload_1
    //   631: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   634: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: iconst_5
    //   639: ldc 78
    //   641: ldc 80
    //   643: aload_2
    //   644: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   650: bipush 103
    //   652: ireturn
    //   653: astore_1
    //   654: aload 20
    //   656: astore_2
    //   657: aload 18
    //   659: astore 19
    //   661: aload 16
    //   663: astore 18
    //   665: aload 19
    //   667: astore 16
    //   669: goto +3380 -> 4049
    //   672: astore 23
    //   674: aload 20
    //   676: astore 19
    //   678: iload 8
    //   680: istore 11
    //   682: aload 18
    //   684: astore 20
    //   686: iconst_3
    //   687: istore 10
    //   689: aload 19
    //   691: astore 18
    //   693: aload 20
    //   695: astore 19
    //   697: goto +1401 -> 2098
    //   700: astore 19
    //   702: aload 20
    //   704: astore 21
    //   706: iload 8
    //   708: istore 11
    //   710: aload 16
    //   712: astore 20
    //   714: aload 19
    //   716: astore 16
    //   718: goto +1087 -> 1805
    //   721: astore 19
    //   723: aload 20
    //   725: astore 21
    //   727: iload 8
    //   729: istore 11
    //   731: aload 16
    //   733: astore 20
    //   735: aload 19
    //   737: astore 16
    //   739: goto +1110 -> 1849
    //   742: astore 19
    //   744: aload 20
    //   746: astore 21
    //   748: iload 8
    //   750: istore 11
    //   752: aload 16
    //   754: astore 20
    //   756: aload 19
    //   758: astore 16
    //   760: goto +1133 -> 1893
    //   763: aload 20
    //   765: ifnull +54 -> 819
    //   768: aload 20
    //   770: invokevirtual 322	java/io/InputStream:close	()V
    //   773: goto +46 -> 819
    //   776: astore 19
    //   778: new 64	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   785: astore 20
    //   787: aload 20
    //   789: aload 16
    //   791: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 20
    //   797: aload 19
    //   799: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   802: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: iconst_5
    //   807: ldc 78
    //   809: ldc 80
    //   811: aload 20
    //   813: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   819: aload 18
    //   821: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   824: iconst_3
    //   825: istore 9
    //   827: aload 16
    //   829: astore 18
    //   831: goto +3195 -> 4026
    //   834: astore 18
    //   836: new 64	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   843: astore 19
    //   845: aload 19
    //   847: aload 17
    //   849: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 19
    //   855: aload 18
    //   857: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   860: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: iconst_5
    //   865: ldc 78
    //   867: ldc 80
    //   869: aload 19
    //   871: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   877: goto -53 -> 824
    //   880: sipush 8192
    //   883: newarray byte
    //   885: astore 21
    //   887: aload 17
    //   889: astore 19
    //   891: aload 20
    //   893: aload 21
    //   895: iconst_0
    //   896: sipush 8192
    //   899: invokevirtual 376	java/io/InputStream:read	([BII)I
    //   902: istore 9
    //   904: iload 9
    //   906: iconst_m1
    //   907: if_icmple +192 -> 1099
    //   910: aload 18
    //   912: aload 21
    //   914: iconst_0
    //   915: iload 9
    //   917: invokevirtual 380	java/io/FileOutputStream:write	([BII)V
    //   920: lload 12
    //   922: iload 9
    //   924: i2l
    //   925: ladd
    //   926: lstore 12
    //   928: lload 12
    //   930: l2d
    //   931: dstore_3
    //   932: lload 14
    //   934: l2d
    //   935: dstore 5
    //   937: dload_3
    //   938: invokestatic 386	java/lang/Double:isNaN	(D)Z
    //   941: pop
    //   942: dload 5
    //   944: invokestatic 386	java/lang/Double:isNaN	(D)Z
    //   947: pop
    //   948: dload_3
    //   949: dload 5
    //   951: ddiv
    //   952: d2f
    //   953: fstore 7
    //   955: aload_0
    //   956: fload 7
    //   958: invokevirtual 389	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(F)V
    //   961: goto -70 -> 891
    //   964: astore_1
    //   965: goto +24 -> 989
    //   968: astore 23
    //   970: goto +43 -> 1013
    //   973: astore 17
    //   975: goto +51 -> 1026
    //   978: astore 17
    //   980: goto +71 -> 1051
    //   983: astore 17
    //   985: goto +91 -> 1076
    //   988: astore_1
    //   989: aload 18
    //   991: astore 21
    //   993: aload 20
    //   995: astore_2
    //   996: aload 19
    //   998: astore 17
    //   1000: aload 16
    //   1002: astore 18
    //   1004: aload 21
    //   1006: astore 16
    //   1008: goto +3041 -> 4049
    //   1011: astore 23
    //   1013: aload 20
    //   1015: astore 19
    //   1017: iload 8
    //   1019: istore 11
    //   1021: goto -339 -> 682
    //   1024: astore 17
    //   1026: aload 20
    //   1028: astore 21
    //   1030: aload 16
    //   1032: astore 20
    //   1034: aload 17
    //   1036: astore 16
    //   1038: aload 19
    //   1040: astore 17
    //   1042: iload 8
    //   1044: istore 11
    //   1046: goto -328 -> 718
    //   1049: astore 17
    //   1051: aload 20
    //   1053: astore 21
    //   1055: aload 16
    //   1057: astore 20
    //   1059: aload 17
    //   1061: astore 16
    //   1063: aload 19
    //   1065: astore 17
    //   1067: iload 8
    //   1069: istore 11
    //   1071: goto -332 -> 739
    //   1074: astore 17
    //   1076: aload 20
    //   1078: astore 21
    //   1080: aload 16
    //   1082: astore 20
    //   1084: aload 17
    //   1086: astore 16
    //   1088: aload 19
    //   1090: astore 17
    //   1092: iload 8
    //   1094: istore 11
    //   1096: goto -336 -> 760
    //   1099: aload 20
    //   1101: astore 21
    //   1103: iload 8
    //   1105: istore 10
    //   1107: aload 18
    //   1109: invokevirtual 390	java/io/FileOutputStream:flush	()V
    //   1112: aload 18
    //   1114: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   1117: aload 23
    //   1119: invokevirtual 325	java/net/HttpURLConnection:disconnect	()V
    //   1122: new 64	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1129: astore 18
    //   1131: aload 18
    //   1133: ldc_w 392
    //   1136: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: aload 18
    //   1142: lload 14
    //   1144: invokevirtual 395	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: aload 18
    //   1150: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: astore 18
    //   1155: iconst_3
    //   1156: istore 9
    //   1158: iconst_3
    //   1159: ldc 78
    //   1161: ldc 80
    //   1163: aload 18
    //   1165: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1168: aload_0
    //   1169: aload_0
    //   1170: aload 22
    //   1172: aload_1
    //   1173: aload_2
    //   1174: invokespecial 155	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/io/File;Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;Ljava/lang/String;)I
    //   1177: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1180: aload_0
    //   1181: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1184: ifeq +263 -> 1447
    //   1187: iload 10
    //   1189: ifne +97 -> 1286
    //   1192: new 64	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1199: astore 18
    //   1201: aload 18
    //   1203: ldc_w 397
    //   1206: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload 18
    //   1212: aload_0
    //   1213: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1216: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: pop
    //   1220: iconst_5
    //   1221: ldc 78
    //   1223: ldc 80
    //   1225: aload 18
    //   1227: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1230: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1233: aload 21
    //   1235: ifnull +48 -> 1283
    //   1238: aload 21
    //   1240: invokevirtual 322	java/io/InputStream:close	()V
    //   1243: goto +40 -> 1283
    //   1246: astore_1
    //   1247: new 64	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1254: astore_2
    //   1255: aload_2
    //   1256: aload 16
    //   1258: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload_2
    //   1263: aload_1
    //   1264: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   1267: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: iconst_5
    //   1272: ldc 78
    //   1274: ldc 80
    //   1276: aload_2
    //   1277: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1283: bipush 101
    //   1285: ireturn
    //   1286: aload 16
    //   1288: astore 18
    //   1290: aload_0
    //   1291: getfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   1294: istore 8
    //   1296: bipush 103
    //   1298: iload 8
    //   1300: if_icmpne +56 -> 1356
    //   1303: aload 21
    //   1305: ifnull +48 -> 1353
    //   1308: aload 21
    //   1310: invokevirtual 322	java/io/InputStream:close	()V
    //   1313: goto +40 -> 1353
    //   1316: astore_1
    //   1317: new 64	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1324: astore_2
    //   1325: aload_2
    //   1326: aload 18
    //   1328: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload_2
    //   1333: aload_1
    //   1334: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   1337: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: iconst_5
    //   1342: ldc 78
    //   1344: ldc 80
    //   1346: aload_2
    //   1347: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1353: bipush 103
    //   1355: ireturn
    //   1356: aload 21
    //   1358: ifnull +54 -> 1412
    //   1361: aload 21
    //   1363: invokevirtual 322	java/io/InputStream:close	()V
    //   1366: goto +46 -> 1412
    //   1369: astore 16
    //   1371: new 64	java/lang/StringBuilder
    //   1374: dup
    //   1375: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1378: astore 17
    //   1380: aload 17
    //   1382: aload 18
    //   1384: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: pop
    //   1388: aload 17
    //   1390: aload 16
    //   1392: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   1395: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: pop
    //   1399: iconst_5
    //   1400: ldc 78
    //   1402: ldc 80
    //   1404: aload 17
    //   1406: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1409: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1412: aload 19
    //   1414: astore 17
    //   1416: iload 10
    //   1418: istore 8
    //   1420: goto +2606 -> 4026
    //   1423: astore_1
    //   1424: goto +95 -> 1519
    //   1427: astore 18
    //   1429: goto +102 -> 1531
    //   1432: astore 17
    //   1434: goto +113 -> 1547
    //   1437: astore 17
    //   1439: goto +120 -> 1559
    //   1442: astore 17
    //   1444: goto +127 -> 1571
    //   1447: aload 21
    //   1449: ifnull +47 -> 1496
    //   1452: aload 21
    //   1454: invokevirtual 322	java/io/InputStream:close	()V
    //   1457: iconst_0
    //   1458: ireturn
    //   1459: astore_1
    //   1460: new 64	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1467: astore_2
    //   1468: aload_2
    //   1469: aload 16
    //   1471: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: aload_2
    //   1476: aload_1
    //   1477: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   1480: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: iconst_5
    //   1485: ldc 78
    //   1487: ldc 80
    //   1489: aload_2
    //   1490: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1496: iconst_0
    //   1497: ireturn
    //   1498: astore 18
    //   1500: goto +31 -> 1531
    //   1503: astore 17
    //   1505: goto +42 -> 1547
    //   1508: astore 17
    //   1510: goto +49 -> 1559
    //   1513: astore 17
    //   1515: goto +56 -> 1571
    //   1518: astore_1
    //   1519: aload 21
    //   1521: astore_2
    //   1522: aload 19
    //   1524: astore 17
    //   1526: goto +538 -> 2064
    //   1529: astore 18
    //   1531: iconst_3
    //   1532: istore 9
    //   1534: aload 18
    //   1536: astore 23
    //   1538: aload 21
    //   1540: astore 18
    //   1542: goto +545 -> 2087
    //   1545: astore 17
    //   1547: iconst_3
    //   1548: istore 9
    //   1550: aload 21
    //   1552: astore 18
    //   1554: goto +965 -> 2519
    //   1557: astore 17
    //   1559: iconst_3
    //   1560: istore 9
    //   1562: aload 21
    //   1564: astore 18
    //   1566: goto +1450 -> 3016
    //   1569: astore 17
    //   1571: iconst_3
    //   1572: istore 9
    //   1574: aload 21
    //   1576: astore 18
    //   1578: goto +1935 -> 3513
    //   1581: astore_1
    //   1582: goto +24 -> 1606
    //   1585: astore 23
    //   1587: goto +43 -> 1630
    //   1590: astore 17
    //   1592: goto +51 -> 1643
    //   1595: astore 17
    //   1597: goto +79 -> 1676
    //   1600: astore 17
    //   1602: goto +107 -> 1709
    //   1605: astore_1
    //   1606: aload 18
    //   1608: astore 21
    //   1610: aload 20
    //   1612: astore_2
    //   1613: aload 19
    //   1615: astore 17
    //   1617: aload 16
    //   1619: astore 18
    //   1621: aload 21
    //   1623: astore 16
    //   1625: goto +2424 -> 4049
    //   1628: astore 23
    //   1630: aload 20
    //   1632: astore 19
    //   1634: iload 8
    //   1636: istore 11
    //   1638: goto +131 -> 1769
    //   1641: astore 17
    //   1643: aload 16
    //   1645: astore 21
    //   1647: aload 20
    //   1649: astore 22
    //   1651: aload 17
    //   1653: astore 16
    //   1655: aload 19
    //   1657: astore 17
    //   1659: aload 21
    //   1661: astore 20
    //   1663: iload 8
    //   1665: istore 11
    //   1667: aload 22
    //   1669: astore 21
    //   1671: goto +134 -> 1805
    //   1674: astore 17
    //   1676: aload 16
    //   1678: astore 21
    //   1680: aload 20
    //   1682: astore 22
    //   1684: aload 17
    //   1686: astore 16
    //   1688: aload 19
    //   1690: astore 17
    //   1692: aload 21
    //   1694: astore 20
    //   1696: iload 8
    //   1698: istore 11
    //   1700: aload 22
    //   1702: astore 21
    //   1704: goto +145 -> 1849
    //   1707: astore 17
    //   1709: aload 16
    //   1711: astore 21
    //   1713: aload 20
    //   1715: astore 22
    //   1717: aload 17
    //   1719: astore 16
    //   1721: aload 19
    //   1723: astore 17
    //   1725: aload 21
    //   1727: astore 20
    //   1729: iload 8
    //   1731: istore 11
    //   1733: aload 22
    //   1735: astore 21
    //   1737: goto +156 -> 1893
    //   1740: astore_1
    //   1741: aload 18
    //   1743: astore 19
    //   1745: aload 20
    //   1747: astore_2
    //   1748: aload 16
    //   1750: astore 18
    //   1752: aload 19
    //   1754: astore 16
    //   1756: goto +2293 -> 4049
    //   1759: astore 23
    //   1761: aload 20
    //   1763: astore 19
    //   1765: iload 8
    //   1767: istore 11
    //   1769: iconst_3
    //   1770: istore 10
    //   1772: aload 18
    //   1774: astore 20
    //   1776: aload 19
    //   1778: astore 18
    //   1780: aload 20
    //   1782: astore 19
    //   1784: goto +314 -> 2098
    //   1787: astore 19
    //   1789: aload 20
    //   1791: astore 21
    //   1793: iload 8
    //   1795: istore 11
    //   1797: aload 16
    //   1799: astore 20
    //   1801: aload 19
    //   1803: astore 16
    //   1805: aload 18
    //   1807: astore 23
    //   1809: iconst_3
    //   1810: istore 10
    //   1812: aload 16
    //   1814: astore 24
    //   1816: aload 17
    //   1818: astore 19
    //   1820: aload 20
    //   1822: astore 16
    //   1824: aload 21
    //   1826: astore 18
    //   1828: goto +706 -> 2534
    //   1831: astore 19
    //   1833: aload 20
    //   1835: astore 21
    //   1837: iload 8
    //   1839: istore 11
    //   1841: aload 16
    //   1843: astore 20
    //   1845: aload 19
    //   1847: astore 16
    //   1849: aload 18
    //   1851: astore 23
    //   1853: iconst_3
    //   1854: istore 10
    //   1856: aload 16
    //   1858: astore 24
    //   1860: aload 17
    //   1862: astore 19
    //   1864: aload 20
    //   1866: astore 16
    //   1868: aload 21
    //   1870: astore 18
    //   1872: goto +1159 -> 3031
    //   1875: astore 19
    //   1877: aload 20
    //   1879: astore 21
    //   1881: iload 8
    //   1883: istore 11
    //   1885: aload 16
    //   1887: astore 20
    //   1889: aload 19
    //   1891: astore 16
    //   1893: aload 18
    //   1895: astore 23
    //   1897: iconst_3
    //   1898: istore 10
    //   1900: aload 16
    //   1902: astore 24
    //   1904: aload 17
    //   1906: astore 19
    //   1908: aload 20
    //   1910: astore 16
    //   1912: aload 21
    //   1914: astore 18
    //   1916: goto +1612 -> 3528
    //   1919: astore 23
    //   1921: iconst_3
    //   1922: istore 9
    //   1924: goto +47 -> 1971
    //   1927: astore 24
    //   1929: iconst_3
    //   1930: istore 9
    //   1932: goto +59 -> 1991
    //   1935: astore 24
    //   1937: iconst_3
    //   1938: istore 9
    //   1940: goto +75 -> 2015
    //   1943: astore 24
    //   1945: iconst_3
    //   1946: istore 9
    //   1948: goto +91 -> 2039
    //   1951: astore_1
    //   1952: aload 18
    //   1954: astore 19
    //   1956: aconst_null
    //   1957: astore_2
    //   1958: aload 16
    //   1960: astore 18
    //   1962: aload 19
    //   1964: astore 16
    //   1966: goto +2083 -> 4049
    //   1969: astore 23
    //   1971: aload 18
    //   1973: astore 19
    //   1975: aconst_null
    //   1976: astore 18
    //   1978: iload 9
    //   1980: istore 10
    //   1982: iload 8
    //   1984: istore 11
    //   1986: goto +112 -> 2098
    //   1989: astore 24
    //   1991: aload 18
    //   1993: astore 23
    //   1995: aconst_null
    //   1996: astore 18
    //   1998: aload 17
    //   2000: astore 19
    //   2002: iload 9
    //   2004: istore 10
    //   2006: iload 8
    //   2008: istore 11
    //   2010: goto +524 -> 2534
    //   2013: astore 24
    //   2015: aload 18
    //   2017: astore 23
    //   2019: aconst_null
    //   2020: astore 18
    //   2022: aload 17
    //   2024: astore 19
    //   2026: iload 9
    //   2028: istore 10
    //   2030: iload 8
    //   2032: istore 11
    //   2034: goto +997 -> 3031
    //   2037: astore 24
    //   2039: aload 18
    //   2041: astore 23
    //   2043: aconst_null
    //   2044: astore 18
    //   2046: aload 17
    //   2048: astore 19
    //   2050: iload 9
    //   2052: istore 10
    //   2054: iload 8
    //   2056: istore 11
    //   2058: goto +1470 -> 3528
    //   2061: astore_1
    //   2062: aconst_null
    //   2063: astore_2
    //   2064: aconst_null
    //   2065: astore 19
    //   2067: aload 16
    //   2069: astore 18
    //   2071: aload 19
    //   2073: astore 16
    //   2075: goto +1974 -> 4049
    //   2078: astore 23
    //   2080: aconst_null
    //   2081: astore 18
    //   2083: iload 8
    //   2085: istore 10
    //   2087: aconst_null
    //   2088: astore 19
    //   2090: iload 10
    //   2092: istore 11
    //   2094: iload 9
    //   2096: istore 10
    //   2098: aload_0
    //   2099: bipush 101
    //   2101: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2104: iload 11
    //   2106: ifne +144 -> 2250
    //   2109: new 64	java/lang/StringBuilder
    //   2112: dup
    //   2113: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2116: astore_1
    //   2117: aload_1
    //   2118: ldc_w 399
    //   2121: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2124: pop
    //   2125: aload_1
    //   2126: aload 23
    //   2128: invokevirtual 160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2131: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: pop
    //   2135: iconst_5
    //   2136: ldc 78
    //   2138: ldc 80
    //   2140: aload_1
    //   2141: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2144: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2147: aload 18
    //   2149: ifnull +48 -> 2197
    //   2152: aload 18
    //   2154: invokevirtual 322	java/io/InputStream:close	()V
    //   2157: goto +40 -> 2197
    //   2160: astore_1
    //   2161: new 64	java/lang/StringBuilder
    //   2164: dup
    //   2165: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2168: astore_2
    //   2169: aload_2
    //   2170: aload 16
    //   2172: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2175: pop
    //   2176: aload_2
    //   2177: aload_1
    //   2178: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2181: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2184: pop
    //   2185: iconst_5
    //   2186: ldc 78
    //   2188: ldc 80
    //   2190: aload_2
    //   2191: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2194: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2197: aload 19
    //   2199: ifnull +48 -> 2247
    //   2202: aload 19
    //   2204: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2207: goto +40 -> 2247
    //   2210: astore_1
    //   2211: new 64	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2218: astore_2
    //   2219: aload_2
    //   2220: aload 17
    //   2222: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: pop
    //   2226: aload_2
    //   2227: aload_1
    //   2228: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2231: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2234: pop
    //   2235: iconst_5
    //   2236: ldc 78
    //   2238: ldc 80
    //   2240: aload_2
    //   2241: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2244: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2247: bipush 101
    //   2249: ireturn
    //   2250: aload 17
    //   2252: astore 24
    //   2254: aload 24
    //   2256: astore 17
    //   2258: aload 16
    //   2260: astore 20
    //   2262: aload 18
    //   2264: astore 21
    //   2266: aload 19
    //   2268: astore 22
    //   2270: new 64	java/lang/StringBuilder
    //   2273: dup
    //   2274: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2277: astore 25
    //   2279: aload 24
    //   2281: astore 17
    //   2283: aload 16
    //   2285: astore 20
    //   2287: aload 18
    //   2289: astore 21
    //   2291: aload 19
    //   2293: astore 22
    //   2295: aload 25
    //   2297: ldc_w 401
    //   2300: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: pop
    //   2304: aload 24
    //   2306: astore 17
    //   2308: aload 16
    //   2310: astore 20
    //   2312: aload 18
    //   2314: astore 21
    //   2316: aload 19
    //   2318: astore 22
    //   2320: aload 25
    //   2322: aload 23
    //   2324: invokevirtual 160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2327: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: pop
    //   2331: aload 24
    //   2333: astore 17
    //   2335: aload 16
    //   2337: astore 20
    //   2339: aload 18
    //   2341: astore 21
    //   2343: aload 19
    //   2345: astore 22
    //   2347: iconst_5
    //   2348: ldc 78
    //   2350: ldc 80
    //   2352: aload 25
    //   2354: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2357: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2360: aload 18
    //   2362: ifnull +54 -> 2416
    //   2365: aload 18
    //   2367: invokevirtual 322	java/io/InputStream:close	()V
    //   2370: goto +46 -> 2416
    //   2373: astore 17
    //   2375: new 64	java/lang/StringBuilder
    //   2378: dup
    //   2379: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2382: astore 18
    //   2384: aload 18
    //   2386: aload 16
    //   2388: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2391: pop
    //   2392: aload 18
    //   2394: aload 17
    //   2396: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2399: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2402: pop
    //   2403: iconst_5
    //   2404: ldc 78
    //   2406: ldc 80
    //   2408: aload 18
    //   2410: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2413: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2416: aload 24
    //   2418: astore 17
    //   2420: aload 16
    //   2422: astore 18
    //   2424: iload 10
    //   2426: istore 9
    //   2428: iload 11
    //   2430: istore 8
    //   2432: aload 19
    //   2434: ifnull +1592 -> 4026
    //   2437: aload 19
    //   2439: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2442: aload 24
    //   2444: astore 17
    //   2446: aload 16
    //   2448: astore 18
    //   2450: iload 10
    //   2452: istore 9
    //   2454: iload 11
    //   2456: istore 8
    //   2458: goto +1568 -> 4026
    //   2461: astore 20
    //   2463: new 64	java/lang/StringBuilder
    //   2466: dup
    //   2467: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2470: astore 18
    //   2472: aload 24
    //   2474: astore 17
    //   2476: iload 10
    //   2478: istore 9
    //   2480: iload 11
    //   2482: istore 8
    //   2484: goto +1506 -> 3990
    //   2487: astore_1
    //   2488: aload 16
    //   2490: astore 20
    //   2492: aload 18
    //   2494: astore_2
    //   2495: aload 19
    //   2497: astore 16
    //   2499: goto +1546 -> 4045
    //   2502: astore 20
    //   2504: aconst_null
    //   2505: astore 18
    //   2507: iload 8
    //   2509: istore 10
    //   2511: aload 17
    //   2513: astore 19
    //   2515: aload 20
    //   2517: astore 17
    //   2519: aconst_null
    //   2520: astore 23
    //   2522: iload 10
    //   2524: istore 11
    //   2526: iload 9
    //   2528: istore 10
    //   2530: aload 17
    //   2532: astore 24
    //   2534: aload 19
    //   2536: astore 17
    //   2538: aload 16
    //   2540: astore 20
    //   2542: aload 18
    //   2544: astore 21
    //   2546: aload 23
    //   2548: astore 22
    //   2550: aload_0
    //   2551: bipush 101
    //   2553: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   2556: iload 11
    //   2558: ifne +208 -> 2766
    //   2561: aload 19
    //   2563: astore 17
    //   2565: aload 16
    //   2567: astore 20
    //   2569: aload 18
    //   2571: astore 21
    //   2573: aload 23
    //   2575: astore 22
    //   2577: new 64	java/lang/StringBuilder
    //   2580: dup
    //   2581: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2584: astore_1
    //   2585: aload 19
    //   2587: astore 17
    //   2589: aload 16
    //   2591: astore 20
    //   2593: aload 18
    //   2595: astore 21
    //   2597: aload 23
    //   2599: astore 22
    //   2601: aload_1
    //   2602: ldc_w 403
    //   2605: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: pop
    //   2609: aload 19
    //   2611: astore 17
    //   2613: aload 16
    //   2615: astore 20
    //   2617: aload 18
    //   2619: astore 21
    //   2621: aload 23
    //   2623: astore 22
    //   2625: aload_1
    //   2626: aload 24
    //   2628: invokevirtual 404	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   2631: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2634: pop
    //   2635: aload 19
    //   2637: astore 17
    //   2639: aload 16
    //   2641: astore 20
    //   2643: aload 18
    //   2645: astore 21
    //   2647: aload 23
    //   2649: astore 22
    //   2651: iconst_5
    //   2652: ldc 78
    //   2654: ldc 80
    //   2656: aload_1
    //   2657: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2660: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2663: aload 18
    //   2665: ifnull +48 -> 2713
    //   2668: aload 18
    //   2670: invokevirtual 322	java/io/InputStream:close	()V
    //   2673: goto +40 -> 2713
    //   2676: astore_1
    //   2677: new 64	java/lang/StringBuilder
    //   2680: dup
    //   2681: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2684: astore_2
    //   2685: aload_2
    //   2686: aload 16
    //   2688: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: pop
    //   2692: aload_2
    //   2693: aload_1
    //   2694: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2697: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2700: pop
    //   2701: iconst_5
    //   2702: ldc 78
    //   2704: ldc 80
    //   2706: aload_2
    //   2707: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2710: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2713: aload 23
    //   2715: ifnull +48 -> 2763
    //   2718: aload 23
    //   2720: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2723: goto +40 -> 2763
    //   2726: astore_1
    //   2727: new 64	java/lang/StringBuilder
    //   2730: dup
    //   2731: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2734: astore_2
    //   2735: aload_2
    //   2736: aload 19
    //   2738: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2741: pop
    //   2742: aload_2
    //   2743: aload_1
    //   2744: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2747: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: pop
    //   2751: iconst_5
    //   2752: ldc 78
    //   2754: ldc 80
    //   2756: aload_2
    //   2757: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2760: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2763: bipush 101
    //   2765: ireturn
    //   2766: aload 19
    //   2768: astore 17
    //   2770: aload 16
    //   2772: astore 20
    //   2774: aload 18
    //   2776: astore 21
    //   2778: aload 23
    //   2780: astore 22
    //   2782: new 64	java/lang/StringBuilder
    //   2785: dup
    //   2786: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2789: astore 25
    //   2791: aload 19
    //   2793: astore 17
    //   2795: aload 16
    //   2797: astore 20
    //   2799: aload 18
    //   2801: astore 21
    //   2803: aload 23
    //   2805: astore 22
    //   2807: aload 25
    //   2809: ldc_w 406
    //   2812: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: pop
    //   2816: aload 19
    //   2818: astore 17
    //   2820: aload 16
    //   2822: astore 20
    //   2824: aload 18
    //   2826: astore 21
    //   2828: aload 23
    //   2830: astore 22
    //   2832: aload 25
    //   2834: aload 24
    //   2836: invokevirtual 404	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   2839: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: pop
    //   2843: aload 19
    //   2845: astore 17
    //   2847: aload 16
    //   2849: astore 20
    //   2851: aload 18
    //   2853: astore 21
    //   2855: aload 23
    //   2857: astore 22
    //   2859: iconst_5
    //   2860: ldc 78
    //   2862: ldc 80
    //   2864: aload 25
    //   2866: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2869: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2872: aload 18
    //   2874: ifnull +54 -> 2928
    //   2877: aload 18
    //   2879: invokevirtual 322	java/io/InputStream:close	()V
    //   2882: goto +46 -> 2928
    //   2885: astore 17
    //   2887: new 64	java/lang/StringBuilder
    //   2890: dup
    //   2891: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2894: astore 18
    //   2896: aload 18
    //   2898: aload 16
    //   2900: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: pop
    //   2904: aload 18
    //   2906: aload 17
    //   2908: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   2911: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: pop
    //   2915: iconst_5
    //   2916: ldc 78
    //   2918: ldc 80
    //   2920: aload 18
    //   2922: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2925: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2928: aload 19
    //   2930: astore 17
    //   2932: aload 16
    //   2934: astore 18
    //   2936: iload 10
    //   2938: istore 9
    //   2940: iload 11
    //   2942: istore 8
    //   2944: aload 23
    //   2946: ifnull +1080 -> 4026
    //   2949: aload 23
    //   2951: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   2954: aload 19
    //   2956: astore 17
    //   2958: aload 16
    //   2960: astore 18
    //   2962: iload 10
    //   2964: istore 9
    //   2966: iload 11
    //   2968: istore 8
    //   2970: goto +1056 -> 4026
    //   2973: astore 20
    //   2975: new 64	java/lang/StringBuilder
    //   2978: dup
    //   2979: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2982: astore 18
    //   2984: aload 19
    //   2986: astore 17
    //   2988: iload 10
    //   2990: istore 9
    //   2992: iload 11
    //   2994: istore 8
    //   2996: goto +994 -> 3990
    //   2999: astore 20
    //   3001: aconst_null
    //   3002: astore 18
    //   3004: iload 8
    //   3006: istore 10
    //   3008: aload 17
    //   3010: astore 19
    //   3012: aload 20
    //   3014: astore 17
    //   3016: aconst_null
    //   3017: astore 23
    //   3019: iload 10
    //   3021: istore 11
    //   3023: iload 9
    //   3025: istore 10
    //   3027: aload 17
    //   3029: astore 24
    //   3031: aload 19
    //   3033: astore 17
    //   3035: aload 16
    //   3037: astore 20
    //   3039: aload 18
    //   3041: astore 21
    //   3043: aload 23
    //   3045: astore 22
    //   3047: aload_0
    //   3048: bipush 100
    //   3050: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   3053: iload 11
    //   3055: ifne +208 -> 3263
    //   3058: aload 19
    //   3060: astore 17
    //   3062: aload 16
    //   3064: astore 20
    //   3066: aload 18
    //   3068: astore 21
    //   3070: aload 23
    //   3072: astore 22
    //   3074: new 64	java/lang/StringBuilder
    //   3077: dup
    //   3078: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3081: astore_1
    //   3082: aload 19
    //   3084: astore 17
    //   3086: aload 16
    //   3088: astore 20
    //   3090: aload 18
    //   3092: astore 21
    //   3094: aload 23
    //   3096: astore 22
    //   3098: aload_1
    //   3099: ldc_w 408
    //   3102: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3105: pop
    //   3106: aload 19
    //   3108: astore 17
    //   3110: aload 16
    //   3112: astore 20
    //   3114: aload 18
    //   3116: astore 21
    //   3118: aload 23
    //   3120: astore 22
    //   3122: aload_1
    //   3123: aload 24
    //   3125: invokevirtual 409	java/lang/NoSuchMethodError:toString	()Ljava/lang/String;
    //   3128: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3131: pop
    //   3132: aload 19
    //   3134: astore 17
    //   3136: aload 16
    //   3138: astore 20
    //   3140: aload 18
    //   3142: astore 21
    //   3144: aload 23
    //   3146: astore 22
    //   3148: iconst_5
    //   3149: ldc 78
    //   3151: ldc 80
    //   3153: aload_1
    //   3154: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3157: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3160: aload 18
    //   3162: ifnull +48 -> 3210
    //   3165: aload 18
    //   3167: invokevirtual 322	java/io/InputStream:close	()V
    //   3170: goto +40 -> 3210
    //   3173: astore_1
    //   3174: new 64	java/lang/StringBuilder
    //   3177: dup
    //   3178: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3181: astore_2
    //   3182: aload_2
    //   3183: aload 16
    //   3185: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3188: pop
    //   3189: aload_2
    //   3190: aload_1
    //   3191: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3194: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3197: pop
    //   3198: iconst_5
    //   3199: ldc 78
    //   3201: ldc 80
    //   3203: aload_2
    //   3204: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3207: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3210: aload 23
    //   3212: ifnull +48 -> 3260
    //   3215: aload 23
    //   3217: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3220: goto +40 -> 3260
    //   3223: astore_1
    //   3224: new 64	java/lang/StringBuilder
    //   3227: dup
    //   3228: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3231: astore_2
    //   3232: aload_2
    //   3233: aload 19
    //   3235: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3238: pop
    //   3239: aload_2
    //   3240: aload_1
    //   3241: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3244: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3247: pop
    //   3248: iconst_5
    //   3249: ldc 78
    //   3251: ldc 80
    //   3253: aload_2
    //   3254: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3257: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3260: bipush 100
    //   3262: ireturn
    //   3263: aload 19
    //   3265: astore 17
    //   3267: aload 16
    //   3269: astore 20
    //   3271: aload 18
    //   3273: astore 21
    //   3275: aload 23
    //   3277: astore 22
    //   3279: new 64	java/lang/StringBuilder
    //   3282: dup
    //   3283: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3286: astore 25
    //   3288: aload 19
    //   3290: astore 17
    //   3292: aload 16
    //   3294: astore 20
    //   3296: aload 18
    //   3298: astore 21
    //   3300: aload 23
    //   3302: astore 22
    //   3304: aload 25
    //   3306: ldc_w 411
    //   3309: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3312: pop
    //   3313: aload 19
    //   3315: astore 17
    //   3317: aload 16
    //   3319: astore 20
    //   3321: aload 18
    //   3323: astore 21
    //   3325: aload 23
    //   3327: astore 22
    //   3329: aload 25
    //   3331: aload 24
    //   3333: invokevirtual 409	java/lang/NoSuchMethodError:toString	()Ljava/lang/String;
    //   3336: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: pop
    //   3340: aload 19
    //   3342: astore 17
    //   3344: aload 16
    //   3346: astore 20
    //   3348: aload 18
    //   3350: astore 21
    //   3352: aload 23
    //   3354: astore 22
    //   3356: iconst_5
    //   3357: ldc 78
    //   3359: ldc 80
    //   3361: aload 25
    //   3363: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3366: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3369: aload 18
    //   3371: ifnull +54 -> 3425
    //   3374: aload 18
    //   3376: invokevirtual 322	java/io/InputStream:close	()V
    //   3379: goto +46 -> 3425
    //   3382: astore 17
    //   3384: new 64	java/lang/StringBuilder
    //   3387: dup
    //   3388: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3391: astore 18
    //   3393: aload 18
    //   3395: aload 16
    //   3397: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3400: pop
    //   3401: aload 18
    //   3403: aload 17
    //   3405: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3408: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: pop
    //   3412: iconst_5
    //   3413: ldc 78
    //   3415: ldc 80
    //   3417: aload 18
    //   3419: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3422: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3425: aload 19
    //   3427: astore 17
    //   3429: aload 16
    //   3431: astore 18
    //   3433: iload 10
    //   3435: istore 9
    //   3437: iload 11
    //   3439: istore 8
    //   3441: aload 23
    //   3443: ifnull +583 -> 4026
    //   3446: aload 23
    //   3448: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3451: aload 19
    //   3453: astore 17
    //   3455: aload 16
    //   3457: astore 18
    //   3459: iload 10
    //   3461: istore 9
    //   3463: iload 11
    //   3465: istore 8
    //   3467: goto +559 -> 4026
    //   3470: astore 20
    //   3472: new 64	java/lang/StringBuilder
    //   3475: dup
    //   3476: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3479: astore 18
    //   3481: aload 19
    //   3483: astore 17
    //   3485: iload 10
    //   3487: istore 9
    //   3489: iload 11
    //   3491: istore 8
    //   3493: goto +497 -> 3990
    //   3496: astore 20
    //   3498: aconst_null
    //   3499: astore 18
    //   3501: iload 8
    //   3503: istore 10
    //   3505: aload 17
    //   3507: astore 19
    //   3509: aload 20
    //   3511: astore 17
    //   3513: aconst_null
    //   3514: astore 23
    //   3516: iload 10
    //   3518: istore 11
    //   3520: iload 9
    //   3522: istore 10
    //   3524: aload 17
    //   3526: astore 24
    //   3528: aload 19
    //   3530: astore 17
    //   3532: aload 16
    //   3534: astore 20
    //   3536: aload 18
    //   3538: astore 21
    //   3540: aload 23
    //   3542: astore 22
    //   3544: aload_0
    //   3545: bipush 101
    //   3547: putfield 37	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	I
    //   3550: iload 11
    //   3552: ifne +208 -> 3760
    //   3555: aload 19
    //   3557: astore 17
    //   3559: aload 16
    //   3561: astore 20
    //   3563: aload 18
    //   3565: astore 21
    //   3567: aload 23
    //   3569: astore 22
    //   3571: new 64	java/lang/StringBuilder
    //   3574: dup
    //   3575: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3578: astore_1
    //   3579: aload 19
    //   3581: astore 17
    //   3583: aload 16
    //   3585: astore 20
    //   3587: aload 18
    //   3589: astore 21
    //   3591: aload 23
    //   3593: astore 22
    //   3595: aload_1
    //   3596: ldc_w 413
    //   3599: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: pop
    //   3603: aload 19
    //   3605: astore 17
    //   3607: aload 16
    //   3609: astore 20
    //   3611: aload 18
    //   3613: astore 21
    //   3615: aload 23
    //   3617: astore 22
    //   3619: aload_1
    //   3620: aload 24
    //   3622: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3625: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: pop
    //   3629: aload 19
    //   3631: astore 17
    //   3633: aload 16
    //   3635: astore 20
    //   3637: aload 18
    //   3639: astore 21
    //   3641: aload 23
    //   3643: astore 22
    //   3645: iconst_5
    //   3646: ldc 78
    //   3648: ldc 80
    //   3650: aload_1
    //   3651: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3654: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3657: aload 18
    //   3659: ifnull +48 -> 3707
    //   3662: aload 18
    //   3664: invokevirtual 322	java/io/InputStream:close	()V
    //   3667: goto +40 -> 3707
    //   3670: astore_1
    //   3671: new 64	java/lang/StringBuilder
    //   3674: dup
    //   3675: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3678: astore_2
    //   3679: aload_2
    //   3680: aload 16
    //   3682: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: pop
    //   3686: aload_2
    //   3687: aload_1
    //   3688: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3691: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3694: pop
    //   3695: iconst_5
    //   3696: ldc 78
    //   3698: ldc 80
    //   3700: aload_2
    //   3701: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3704: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3707: aload 23
    //   3709: ifnull +48 -> 3757
    //   3712: aload 23
    //   3714: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3717: goto +40 -> 3757
    //   3720: astore_1
    //   3721: new 64	java/lang/StringBuilder
    //   3724: dup
    //   3725: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3728: astore_2
    //   3729: aload_2
    //   3730: aload 19
    //   3732: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: pop
    //   3736: aload_2
    //   3737: aload_1
    //   3738: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3741: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: pop
    //   3745: iconst_5
    //   3746: ldc 78
    //   3748: ldc 80
    //   3750: aload_2
    //   3751: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3754: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3757: bipush 101
    //   3759: ireturn
    //   3760: aload 19
    //   3762: astore 17
    //   3764: aload 16
    //   3766: astore 20
    //   3768: aload 18
    //   3770: astore 21
    //   3772: aload 23
    //   3774: astore 22
    //   3776: new 64	java/lang/StringBuilder
    //   3779: dup
    //   3780: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3783: astore 25
    //   3785: aload 19
    //   3787: astore 17
    //   3789: aload 16
    //   3791: astore 20
    //   3793: aload 18
    //   3795: astore 21
    //   3797: aload 23
    //   3799: astore 22
    //   3801: aload 25
    //   3803: ldc_w 415
    //   3806: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3809: pop
    //   3810: aload 19
    //   3812: astore 17
    //   3814: aload 16
    //   3816: astore 20
    //   3818: aload 18
    //   3820: astore 21
    //   3822: aload 23
    //   3824: astore 22
    //   3826: aload 25
    //   3828: aload 24
    //   3830: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3833: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3836: pop
    //   3837: aload 19
    //   3839: astore 17
    //   3841: aload 16
    //   3843: astore 20
    //   3845: aload 18
    //   3847: astore 21
    //   3849: aload 23
    //   3851: astore 22
    //   3853: iconst_5
    //   3854: ldc 78
    //   3856: ldc 80
    //   3858: aload 25
    //   3860: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3863: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3866: aload 18
    //   3868: ifnull +54 -> 3922
    //   3871: aload 18
    //   3873: invokevirtual 322	java/io/InputStream:close	()V
    //   3876: goto +46 -> 3922
    //   3879: astore 17
    //   3881: new 64	java/lang/StringBuilder
    //   3884: dup
    //   3885: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3888: astore 18
    //   3890: aload 18
    //   3892: aload 16
    //   3894: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3897: pop
    //   3898: aload 18
    //   3900: aload 17
    //   3902: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   3905: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3908: pop
    //   3909: iconst_5
    //   3910: ldc 78
    //   3912: ldc 80
    //   3914: aload 18
    //   3916: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3919: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3922: aload 19
    //   3924: astore 17
    //   3926: aload 16
    //   3928: astore 18
    //   3930: iload 10
    //   3932: istore 9
    //   3934: iload 11
    //   3936: istore 8
    //   3938: aload 23
    //   3940: ifnull +86 -> 4026
    //   3943: aload 23
    //   3945: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   3948: aload 19
    //   3950: astore 17
    //   3952: aload 16
    //   3954: astore 18
    //   3956: iload 10
    //   3958: istore 9
    //   3960: iload 11
    //   3962: istore 8
    //   3964: goto +62 -> 4026
    //   3967: astore 20
    //   3969: new 64	java/lang/StringBuilder
    //   3972: dup
    //   3973: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3976: astore 18
    //   3978: iload 11
    //   3980: istore 8
    //   3982: iload 10
    //   3984: istore 9
    //   3986: aload 19
    //   3988: astore 17
    //   3990: aload 18
    //   3992: aload 17
    //   3994: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3997: pop
    //   3998: aload 18
    //   4000: aload 20
    //   4002: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   4005: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4008: pop
    //   4009: iconst_5
    //   4010: ldc 78
    //   4012: ldc 80
    //   4014: aload 18
    //   4016: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4019: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4022: aload 16
    //   4024: astore 18
    //   4026: iload 8
    //   4028: istore 10
    //   4030: aload 18
    //   4032: astore 16
    //   4034: goto -4018 -> 16
    //   4037: astore_1
    //   4038: aload 22
    //   4040: astore 16
    //   4042: aload 21
    //   4044: astore_2
    //   4045: aload 20
    //   4047: astore 18
    //   4049: aload_2
    //   4050: ifnull +51 -> 4101
    //   4053: aload_2
    //   4054: invokevirtual 322	java/io/InputStream:close	()V
    //   4057: goto +44 -> 4101
    //   4060: astore_2
    //   4061: new 64	java/lang/StringBuilder
    //   4064: dup
    //   4065: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   4068: astore 19
    //   4070: aload 19
    //   4072: aload 18
    //   4074: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: pop
    //   4078: aload 19
    //   4080: aload_2
    //   4081: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   4084: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4087: pop
    //   4088: iconst_5
    //   4089: ldc 78
    //   4091: ldc 80
    //   4093: aload 19
    //   4095: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4098: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4101: aload 16
    //   4103: ifnull +52 -> 4155
    //   4106: aload 16
    //   4108: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   4111: goto +44 -> 4155
    //   4114: astore_2
    //   4115: new 64	java/lang/StringBuilder
    //   4118: dup
    //   4119: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   4122: astore 16
    //   4124: aload 16
    //   4126: aload 17
    //   4128: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload 16
    //   4134: aload_2
    //   4135: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   4138: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4141: pop
    //   4142: iconst_5
    //   4143: ldc 78
    //   4145: ldc 80
    //   4147: aload 16
    //   4149: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4152: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4155: aload_1
    //   4156: athrow
    //   4157: bipush 100
    //   4159: ireturn
    //   4160: aload 16
    //   4162: astore 18
    //   4164: goto -138 -> 4026
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4167	0	this	b
    //   0	4167	1	paramSDKLocalConfig	SDKLocalConfig
    //   0	4167	2	paramString	String
    //   931	18	3	d1	double
    //   935	15	5	d2	double
    //   953	4	7	f1	float
    //   20	4007	8	n	int
    //   11	3974	9	i1	int
    //   14	4015	10	i2	int
    //   680	3299	11	i3	int
    //   400	529	12	l1	long
    //   397	746	14	l2	long
    //   8	1279	16	localObject1	Object
    //   1369	249	16	localException1	Exception
    //   1623	2538	16	localObject2	Object
    //   3	885	17	str	String
    //   973	1	17	localOutOfMemoryError1	OutOfMemoryError
    //   978	1	17	localNoSuchMethodError1	java.lang.NoSuchMethodError
    //   983	1	17	localException2	Exception
    //   998	1	17	localObject3	Object
    //   1024	11	17	localOutOfMemoryError2	OutOfMemoryError
    //   1040	1	17	localObject4	Object
    //   1049	11	17	localNoSuchMethodError2	java.lang.NoSuchMethodError
    //   1065	1	17	localObject5	Object
    //   1074	11	17	localException3	Exception
    //   1090	325	17	localObject6	Object
    //   1432	1	17	localOutOfMemoryError3	OutOfMemoryError
    //   1437	1	17	localNoSuchMethodError3	java.lang.NoSuchMethodError
    //   1442	1	17	localException4	Exception
    //   1503	1	17	localOutOfMemoryError4	OutOfMemoryError
    //   1508	1	17	localNoSuchMethodError4	java.lang.NoSuchMethodError
    //   1513	1	17	localException5	Exception
    //   1524	1	17	localObject7	Object
    //   1545	1	17	localOutOfMemoryError5	OutOfMemoryError
    //   1557	1	17	localNoSuchMethodError5	java.lang.NoSuchMethodError
    //   1569	1	17	localException6	Exception
    //   1590	1	17	localOutOfMemoryError6	OutOfMemoryError
    //   1595	1	17	localNoSuchMethodError6	java.lang.NoSuchMethodError
    //   1600	1	17	localException7	Exception
    //   1615	1	17	localObject8	Object
    //   1641	11	17	localOutOfMemoryError7	OutOfMemoryError
    //   1657	1	17	localObject9	Object
    //   1674	11	17	localNoSuchMethodError7	java.lang.NoSuchMethodError
    //   1690	1	17	localObject10	Object
    //   1707	11	17	localException8	Exception
    //   1723	611	17	localObject11	Object
    //   2373	22	17	localException9	Exception
    //   2418	428	17	localObject12	Object
    //   2885	22	17	localException10	Exception
    //   2930	413	17	localObject13	Object
    //   3382	22	17	localException11	Exception
    //   3427	413	17	localObject14	Object
    //   3879	22	17	localException12	Exception
    //   3924	203	17	localObject15	Object
    //   64	300	18	localObject16	Object
    //   371	103	18	localException13	Exception
    //   481	177	18	localException14	Exception
    //   663	167	18	localObject17	Object
    //   834	156	18	localException15	Exception
    //   1002	381	18	localObject18	Object
    //   1427	1	18	localThrowable1	Throwable
    //   1498	1	18	localThrowable2	Throwable
    //   1529	6	18	localThrowable3	Throwable
    //   1540	2623	18	localObject19	Object
    //   243	453	19	localObject20	Object
    //   700	15	19	localOutOfMemoryError8	OutOfMemoryError
    //   721	15	19	localNoSuchMethodError8	java.lang.NoSuchMethodError
    //   742	15	19	localException16	Exception
    //   776	22	19	localException17	Exception
    //   843	940	19	localObject21	Object
    //   1787	15	19	localOutOfMemoryError9	OutOfMemoryError
    //   1818	1	19	localObject22	Object
    //   1831	15	19	localNoSuchMethodError9	java.lang.NoSuchMethodError
    //   1862	1	19	localObject23	Object
    //   1875	15	19	localException18	Exception
    //   1906	2188	19	localObject24	Object
    //   532	1806	20	localObject25	Object
    //   2461	1	20	localException19	Exception
    //   2490	1	20	localObject26	Object
    //   2502	14	20	localOutOfMemoryError10	OutOfMemoryError
    //   2540	310	20	localObject27	Object
    //   2973	1	20	localException20	Exception
    //   2999	14	20	localNoSuchMethodError10	java.lang.NoSuchMethodError
    //   3037	310	20	localObject28	Object
    //   3470	1	20	localException21	Exception
    //   3496	14	20	localException22	Exception
    //   3534	310	20	localObject29	Object
    //   3967	79	20	localException23	Exception
    //   704	3339	21	localObject30	Object
    //   151	3888	22	localObject31	Object
    //   179	349	23	localHttpURLConnection	java.net.HttpURLConnection
    //   672	1	23	localThrowable4	Throwable
    //   968	1	23	localThrowable5	Throwable
    //   1011	107	23	localThrowable6	Throwable
    //   1536	1	23	localThrowable7	Throwable
    //   1585	1	23	localThrowable8	Throwable
    //   1628	1	23	localThrowable9	Throwable
    //   1759	1	23	localThrowable10	Throwable
    //   1807	89	23	localObject32	Object
    //   1919	1	23	localThrowable11	Throwable
    //   1969	1	23	localThrowable12	Throwable
    //   1993	49	23	localObject33	Object
    //   2078	245	23	localThrowable13	Throwable
    //   2520	1424	23	localObject34	Object
    //   1814	89	24	localObject35	Object
    //   1927	1	24	localOutOfMemoryError11	OutOfMemoryError
    //   1935	1	24	localNoSuchMethodError11	java.lang.NoSuchMethodError
    //   1943	1	24	localException24	Exception
    //   1989	1	24	localOutOfMemoryError12	OutOfMemoryError
    //   2013	1	24	localNoSuchMethodError12	java.lang.NoSuchMethodError
    //   2037	1	24	localException25	Exception
    //   2252	1577	24	localObject36	Object
    //   2277	1582	25	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   275	280	283	java/lang/Exception
    //   363	368	371	java/lang/Exception
    //   425	430	433	java/lang/Exception
    //   473	478	481	java/lang/Exception
    //   560	565	568	java/lang/Exception
    //   605	610	613	java/lang/Exception
    //   544	555	653	finally
    //   544	555	672	java/lang/Throwable
    //   544	555	700	java/lang/OutOfMemoryError
    //   544	555	721	java/lang/NoSuchMethodError
    //   544	555	742	java/lang/Exception
    //   768	773	776	java/lang/Exception
    //   819	824	834	java/lang/Exception
    //   955	961	964	finally
    //   955	961	968	java/lang/Throwable
    //   955	961	973	java/lang/OutOfMemoryError
    //   955	961	978	java/lang/NoSuchMethodError
    //   955	961	983	java/lang/Exception
    //   910	920	988	finally
    //   910	920	1011	java/lang/Throwable
    //   910	920	1024	java/lang/OutOfMemoryError
    //   910	920	1049	java/lang/NoSuchMethodError
    //   910	920	1074	java/lang/Exception
    //   1238	1243	1246	java/lang/Exception
    //   1308	1313	1316	java/lang/Exception
    //   1361	1366	1369	java/lang/Exception
    //   1290	1296	1423	finally
    //   1290	1296	1427	java/lang/Throwable
    //   1290	1296	1432	java/lang/OutOfMemoryError
    //   1290	1296	1437	java/lang/NoSuchMethodError
    //   1290	1296	1442	java/lang/Exception
    //   1452	1457	1459	java/lang/Exception
    //   1158	1187	1498	java/lang/Throwable
    //   1192	1233	1498	java/lang/Throwable
    //   1158	1187	1503	java/lang/OutOfMemoryError
    //   1192	1233	1503	java/lang/OutOfMemoryError
    //   1158	1187	1508	java/lang/NoSuchMethodError
    //   1192	1233	1508	java/lang/NoSuchMethodError
    //   1158	1187	1513	java/lang/Exception
    //   1192	1233	1513	java/lang/Exception
    //   1117	1155	1518	finally
    //   1158	1187	1518	finally
    //   1192	1233	1518	finally
    //   1117	1155	1529	java/lang/Throwable
    //   1117	1155	1545	java/lang/OutOfMemoryError
    //   1117	1155	1557	java/lang/NoSuchMethodError
    //   1117	1155	1569	java/lang/Exception
    //   1107	1117	1581	finally
    //   1107	1117	1585	java/lang/Throwable
    //   1107	1117	1590	java/lang/OutOfMemoryError
    //   1107	1117	1595	java/lang/NoSuchMethodError
    //   1107	1117	1600	java/lang/Exception
    //   891	904	1605	finally
    //   891	904	1628	java/lang/Throwable
    //   891	904	1641	java/lang/OutOfMemoryError
    //   891	904	1674	java/lang/NoSuchMethodError
    //   891	904	1707	java/lang/Exception
    //   880	887	1740	finally
    //   880	887	1759	java/lang/Throwable
    //   880	887	1787	java/lang/OutOfMemoryError
    //   880	887	1831	java/lang/NoSuchMethodError
    //   880	887	1875	java/lang/Exception
    //   527	534	1919	java/lang/Throwable
    //   527	534	1927	java/lang/OutOfMemoryError
    //   527	534	1935	java/lang/NoSuchMethodError
    //   527	534	1943	java/lang/Exception
    //   216	223	1951	finally
    //   236	275	1951	finally
    //   323	363	1951	finally
    //   385	399	1951	finally
    //   409	420	1951	finally
    //   527	534	1951	finally
    //   216	223	1969	java/lang/Throwable
    //   236	275	1969	java/lang/Throwable
    //   323	363	1969	java/lang/Throwable
    //   385	399	1969	java/lang/Throwable
    //   409	420	1969	java/lang/Throwable
    //   216	223	1989	java/lang/OutOfMemoryError
    //   236	275	1989	java/lang/OutOfMemoryError
    //   323	363	1989	java/lang/OutOfMemoryError
    //   385	399	1989	java/lang/OutOfMemoryError
    //   409	420	1989	java/lang/OutOfMemoryError
    //   216	223	2013	java/lang/NoSuchMethodError
    //   236	275	2013	java/lang/NoSuchMethodError
    //   323	363	2013	java/lang/NoSuchMethodError
    //   385	399	2013	java/lang/NoSuchMethodError
    //   409	420	2013	java/lang/NoSuchMethodError
    //   216	223	2037	java/lang/Exception
    //   236	275	2037	java/lang/Exception
    //   323	363	2037	java/lang/Exception
    //   385	399	2037	java/lang/Exception
    //   409	420	2037	java/lang/Exception
    //   130	181	2061	finally
    //   186	197	2061	finally
    //   205	216	2061	finally
    //   130	181	2078	java/lang/Throwable
    //   186	197	2078	java/lang/Throwable
    //   205	216	2078	java/lang/Throwable
    //   2152	2157	2160	java/lang/Exception
    //   2202	2207	2210	java/lang/Exception
    //   2365	2370	2373	java/lang/Exception
    //   2437	2442	2461	java/lang/Exception
    //   2098	2104	2487	finally
    //   2109	2147	2487	finally
    //   130	181	2502	java/lang/OutOfMemoryError
    //   186	197	2502	java/lang/OutOfMemoryError
    //   205	216	2502	java/lang/OutOfMemoryError
    //   2668	2673	2676	java/lang/Exception
    //   2718	2723	2726	java/lang/Exception
    //   2877	2882	2885	java/lang/Exception
    //   2949	2954	2973	java/lang/Exception
    //   130	181	2999	java/lang/NoSuchMethodError
    //   186	197	2999	java/lang/NoSuchMethodError
    //   205	216	2999	java/lang/NoSuchMethodError
    //   3165	3170	3173	java/lang/Exception
    //   3215	3220	3223	java/lang/Exception
    //   3374	3379	3382	java/lang/Exception
    //   3446	3451	3470	java/lang/Exception
    //   130	181	3496	java/lang/Exception
    //   186	197	3496	java/lang/Exception
    //   205	216	3496	java/lang/Exception
    //   3662	3667	3670	java/lang/Exception
    //   3712	3717	3720	java/lang/Exception
    //   3871	3876	3879	java/lang/Exception
    //   3943	3948	3967	java/lang/Exception
    //   2270	2279	4037	finally
    //   2295	2304	4037	finally
    //   2320	2331	4037	finally
    //   2347	2360	4037	finally
    //   2550	2556	4037	finally
    //   2577	2585	4037	finally
    //   2601	2609	4037	finally
    //   2625	2635	4037	finally
    //   2651	2663	4037	finally
    //   2782	2791	4037	finally
    //   2807	2816	4037	finally
    //   2832	2843	4037	finally
    //   2859	2872	4037	finally
    //   3047	3053	4037	finally
    //   3074	3082	4037	finally
    //   3098	3106	4037	finally
    //   3122	3132	4037	finally
    //   3148	3160	4037	finally
    //   3279	3288	4037	finally
    //   3304	3313	4037	finally
    //   3329	3340	4037	finally
    //   3356	3369	4037	finally
    //   3544	3550	4037	finally
    //   3571	3579	4037	finally
    //   3595	3603	4037	finally
    //   3619	3629	4037	finally
    //   3645	3657	4037	finally
    //   3776	3785	4037	finally
    //   3801	3810	4037	finally
    //   3826	3837	4037	finally
    //   3853	3866	4037	finally
    //   4053	4057	4060	java/lang/Exception
    //   4106	4111	4114	java/lang/Exception
  }
  
  private String b(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("getFilePathByPrefix, dirFile: ");
    localStringBuilder1.append(paramFile);
    localStringBuilder1.append(" - prefix : ");
    localStringBuilder1.append(paramString);
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder1.toString());
    if (paramFile == null) {
      return null;
    }
    paramFile = paramFile.listFiles();
    if ((paramFile != null) && (paramFile.length > 0))
    {
      int i1 = paramFile.length;
      int n = 0;
      while (n < i1)
      {
        localStringBuilder1 = paramFile[n];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getFilePathByPrefix,  file.name : ");
        localStringBuilder2.append(localStringBuilder1.getName());
        localStringBuilder2.append(" , file.path :");
        localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder2.toString());
        if ((localStringBuilder1.getName().length() >= paramString.length()) && (localStringBuilder1.getName().substring(0, paramString.length()).equalsIgnoreCase(paramString)) && (localStringBuilder1.getName().endsWith(".jar"))) {
          return localStringBuilder1.getAbsolutePath();
        }
        n += 1;
      }
      return null;
    }
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix , childFiles is null or length 0 ");
    return null;
  }
  
  private String b(String paramString)
  {
    System.setProperty("http.keepAlive", "false");
    System.setProperty("http.maxConnections", "100");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fetchResultWithURL, request url: ");
    ((StringBuilder)localObject).append(paramString);
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    int n = 3;
    for (;;)
    {
      if (n <= 0) {
        break label173;
      }
      try
      {
        localObject = a(paramString, false);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          a(paramString, true);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchResultWithURL, result : ");
        localStringBuilder.append((String)localObject);
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder.toString());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = TextUtils.isEmpty(((String)localObject).trim());
          if (!bool) {
            return localObject;
          }
        }
        n -= 1;
      }
      catch (Exception paramString)
      {
        break label165;
      }
      catch (OutOfMemoryError paramString)
      {
        label157:
        break label157;
      }
    }
    this.d = 102;
    return null;
    label165:
    this.d = 102;
    return null;
    label173:
    this.d = 102;
    return null;
  }
  
  private SDKLocalConfig c(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.startsWith("QZOutputJson=")) {
        str1 = paramString.replace("QZOutputJson=", "");
      }
      Object localObject = new JSONObject(str1);
      if (((JSONObject)localObject).optString("error_msg").equals("no record"))
      {
        this.d = 102;
        return null;
      }
      paramString = ((JSONObject)localObject).optString("c_so_url");
      str1 = ((JSONObject)localObject).optString("c_so_name");
      String str2 = ((JSONObject)localObject).optString("c_so_update_ver");
      String str3 = ((JSONObject)localObject).optString("c_so_md5");
      localObject = ((JSONObject)localObject).optString("ret");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localObject = new SDKLocalConfig();
        ((SDKLocalConfig)localObject).filename = str1;
        ((SDKLocalConfig)localObject).version = str2;
        ((SDKLocalConfig)localObject).MD5 = str3;
        ((SDKLocalConfig)localObject).URL = paramString;
        return localObject;
      }
      this.d = 102;
      return null;
    }
    catch (Exception paramString)
    {
      label190:
      break label190;
    }
    this.d = 102;
    return null;
  }
  
  private boolean c(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.isPluginMode()) {
      return true;
    }
    Object localObject = TVK_SDKMgr.SDK_Ver.split("\\.");
    String[] arrayOfString = paramSDKLocalConfig.version.split("\\.");
    if ((localObject != null) && (arrayOfString != null) && (localObject.length > 1) && (arrayOfString.length > 1) && (localObject[0].equalsIgnoreCase(arrayOfString[0])) && (localObject[1].equalsIgnoreCase(arrayOfString[1]))) {
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("version not match, sdk:");
    ((StringBuilder)localObject).append(TVK_SDKMgr.SDK_Ver);
    ((StringBuilder)localObject).append(", configver: ");
    ((StringBuilder)localObject).append(paramSDKLocalConfig.version);
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean d(SDKLocalConfig paramSDKLocalConfig)
  {
    if (!TVK_SDKMgr.isPluginMode()) {
      return true;
    }
    Object localObject = TVK_SDKMgr.SDK_Ver.split("\\.");
    String[] arrayOfString = paramSDKLocalConfig.version.split("\\.");
    if ((localObject != null) && (arrayOfString != null) && (localObject.length > 3) && (arrayOfString.length > 3))
    {
      int n = Integer.valueOf(localObject[3]).intValue();
      if (Integer.valueOf(arrayOfString[3]).intValue() >= n) {
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("build version not match, sdk:");
      ((StringBuilder)localObject).append(TVK_SDKMgr.SDK_Ver);
      ((StringBuilder)localObject).append(", configver: ");
      ((StringBuilder)localObject).append(paramSDKLocalConfig.version);
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("build version is invalid, sdk:");
    ((StringBuilder)localObject).append(TVK_SDKMgr.SDK_Ver);
    ((StringBuilder)localObject).append(", configver: ");
    ((StringBuilder)localObject).append(paramSDKLocalConfig.version);
    d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean d(String paramString)
  {
    try
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("/tencent/TencentVideoSdk/com.tencent.videokit");
      localObject = new File(((StringBuilder)localObject).toString(), "TVKConfig.ser");
      if (!((File)localObject).exists()) {
        return false;
      }
      this.j = new File(paramString, "TVKConfig.ser");
      this.j.getParentFile().mkdirs();
      if (!d.a((File)localObject, this.j))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKConfig fail");
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("/tencent/TencentVideoSdk/com.tencent.videokit");
      localObject = new File(((StringBuilder)localObject).toString(), "TvkPlugin.zip");
      if (!((File)localObject).exists()) {
        return false;
      }
      this.i = new File(paramString, "TvkPlugin.zip");
      this.i.getParentFile().mkdirs();
      if (!d.a((File)localObject, this.i))
      {
        d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, copy SDKZip fail");
        return false;
      }
      if (!a(this.i.getAbsolutePath(), this.i.getParentFile().getAbsolutePath()))
      {
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "copyRemoteFiles, file unzip error");
        return false;
      }
      return true;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("copyRemoteFiles, exception: ");
      ((StringBuilder)localObject).append(paramString.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public SDKLocalConfig a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://commdata6.v.qq.com/commdatav2?cmd=51&so_name=TvkPlugin&so_ver=");
    if (paramBoolean) {
      localObject = this.l.version;
    } else {
      localObject = "V0.0.0.0";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&app_id=");
    localStringBuilder.append("000");
    localStringBuilder.append("&sdk_version=");
    localStringBuilder.append(c.a);
    Object localObject = b(localStringBuilder.toString());
    if (localObject == null)
    {
      this.d = 102;
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "getUpdateInfoWithIsUpdate failed, fetchResultWithURL return null");
      return null;
    }
    localObject = c((String)localObject);
    if ((localObject != null) && (!c((SDKLocalConfig)localObject)) && (!d((SDKLocalConfig)localObject)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUpdateInfoWithIsUpdate failed, version not match! remoteConfig: ");
      localStringBuilder.append(localObject);
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder.toString());
      this.d = 102;
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUpdateInfoWithIsUpdate success, isUpdate: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", remoteConfig: ");
    localStringBuilder.append(localObject);
    d.a(2, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder.toString());
    return localObject;
  }
  
  public void a(float paramFloat)
  {
    TVK_SDKMgr.InstallListener localInstallListener = this.m;
    if (localInstallListener != null) {
      localInstallListener.onInstallProgress(paramFloat);
    }
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.m = paramInstallListener;
  }
  
  public void a(SDKLocalConfig paramSDKLocalConfig, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadWithIsUpdate ===>start, isUpdate:");
    ((StringBuilder)localObject).append(paramBoolean);
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
    if (paramBoolean) {
      localObject = this.f;
    } else {
      localObject = this.e;
    }
    localObject = ((File)localObject).getAbsolutePath();
    int n;
    if (a(paramSDKLocalConfig, (String)localObject) == 0)
    {
      n = 0;
    }
    else
    {
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "downloadByQQEngine failed");
      n = b(paramSDKLocalConfig, (String)localObject);
    }
    this.d = n;
    if ((n == 0) && (!paramBoolean)) {
      this.l = paramSDKLocalConfig;
    }
    paramSDKLocalConfig = new StringBuilder();
    paramSDKLocalConfig.append("downloadWithIsUpdate <===end ret:");
    paramSDKLocalConfig.append(n);
    d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", paramSDKLocalConfig.toString());
  }
  
  public boolean a()
  {
    StringBuilder localStringBuilder = null;
    try
    {
      Object localObject;
      if ((this.c.getFilesDir().exists()) && (this.c.getFilesDir().canRead()) && (this.c.getFilesDir().canWrite()))
      {
        localObject = this.c.getFilesDir().getAbsolutePath();
      }
      else
      {
        localObject = localStringBuilder;
        if (this.c.getCacheDir().exists())
        {
          localObject = localStringBuilder;
          if (this.c.getCacheDir().canRead())
          {
            localObject = localStringBuilder;
            if (this.c.getCacheDir().canWrite())
            {
              d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit mContext.getFilesDir() Unavailable....try cacheDir");
              localObject = this.c.getCacheDir().getAbsolutePath();
            }
          }
        }
      }
      if (localObject != null)
      {
        this.e = new File((String)localObject, "TencentVideoKit");
        this.f = new File((String)localObject, "TencentVideoKitUpdate");
        this.g = new File(this.e.getAbsolutePath(), "TVKConfig.ser");
        this.h = new File(this.f.getAbsolutePath(), "TVKConfig.ser");
        b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("helperInit finish, mSDKDir:");
        ((StringBuilder)localObject).append(this.e.getAbsolutePath());
        d.a(1, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject).toString());
        return true;
      }
      this.d = 104;
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", "helperInit failed, dir error; getFilesDir unavailable and getCacheDir unavailable");
    }
    catch (Exception localException)
    {
      this.d = 104;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("helperInit failed, ");
      localStringBuilder.append(localException.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder.toString());
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
    //   1: ifnull +660 -> 661
    //   4: aload_1
    //   5: invokevirtual 173	java/io/File:exists	()Z
    //   8: ifeq +653 -> 661
    //   11: aload_2
    //   12: ifnull +649 -> 661
    //   15: aload_2
    //   16: invokevirtual 173	java/io/File:exists	()Z
    //   19: ifne +6 -> 25
    //   22: goto +639 -> 661
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 4
    //   31: new 646	java/io/ObjectInputStream
    //   34: dup
    //   35: new 648	java/io/FileInputStream
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 649	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 650	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore 5
    //   48: aload_0
    //   49: aload 5
    //   51: invokevirtual 654	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   54: checkcast 128	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   57: putfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   60: aload 5
    //   62: invokevirtual 655	java/io/ObjectInputStream:close	()V
    //   65: new 64	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: ldc_w 657
    //   79: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: getstatic 521	com/tencent/qqlive/mediaplayer/api/TVK_SDKMgr:SDK_Ver	Ljava/lang/String;
    //   88: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 4
    //   94: ldc_w 659
    //   97: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   107: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: ldc_w 661
    //   116: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 4
    //   122: aload_2
    //   123: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   126: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 4
    //   132: ldc_w 663
    //   135: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: aload_0
    //   142: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   145: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: ldc_w 665
    //   154: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 4
    //   160: invokestatic 667	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	()Ljava/lang/String;
    //   163: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: iconst_3
    //   168: ldc 78
    //   170: ldc 80
    //   172: aload 4
    //   174: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +323 -> 509
    //   189: aload_2
    //   190: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   193: ifnull +316 -> 509
    //   196: aload_0
    //   197: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   200: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   203: ifnull +306 -> 509
    //   206: aload_0
    //   207: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   210: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   213: ifnull +296 -> 509
    //   216: aload_0
    //   217: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   220: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   223: ifnonnull +6 -> 229
    //   226: goto +283 -> 509
    //   229: aload_0
    //   230: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   233: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   236: astore 5
    //   238: aload_1
    //   239: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   242: astore_2
    //   243: aload 5
    //   245: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +80 -> 328
    //   251: aload_2
    //   252: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifeq +6 -> 261
    //   258: goto +70 -> 328
    //   261: aload_0
    //   262: aload_2
    //   263: invokespecial 199	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   266: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   269: astore_2
    //   270: aload_2
    //   271: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifne +20 -> 294
    //   277: aload 5
    //   279: aload_2
    //   280: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   283: ifne +6 -> 289
    //   286: goto +8 -> 294
    //   289: iconst_1
    //   290: istore_3
    //   291: goto +98 -> 389
    //   294: new 64	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   301: astore 4
    //   303: aload 4
    //   305: ldc_w 669
    //   308: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 4
    //   314: aload 5
    //   316: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc_w 671
    //   323: astore 5
    //   325: goto +34 -> 359
    //   328: new 64	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   335: astore 4
    //   337: aload 4
    //   339: ldc_w 673
    //   342: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 4
    //   348: aload 5
    //   350: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc_w 675
    //   357: astore 5
    //   359: aload 4
    //   361: aload 5
    //   363: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 4
    //   369: aload_2
    //   370: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: iconst_5
    //   375: ldc 78
    //   377: ldc 80
    //   379: aload 4
    //   381: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   387: iconst_0
    //   388: istore_3
    //   389: iload_3
    //   390: ifne +9 -> 399
    //   393: aload_1
    //   394: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   397: iconst_0
    //   398: ireturn
    //   399: aload_0
    //   400: aload_0
    //   401: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   404: invokespecial 590	com/tencent/qqlive/mediaplayer/sdkupdate/b:c	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   407: ifne +46 -> 453
    //   410: aload_1
    //   411: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   414: new 64	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   421: astore_2
    //   422: aload_2
    //   423: ldc_w 677
    //   426: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_2
    //   431: aload_1
    //   432: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   435: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: iconst_5
    //   440: ldc 78
    //   442: ldc 80
    //   444: aload_2
    //   445: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   451: iconst_0
    //   452: ireturn
    //   453: aload_0
    //   454: aload_0
    //   455: getfield 570	com/tencent/qqlive/mediaplayer/sdkupdate/b:l	Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;
    //   458: invokespecial 592	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig;)Z
    //   461: ifne +46 -> 507
    //   464: aload_1
    //   465: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   468: new 64	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   475: astore_2
    //   476: aload_2
    //   477: ldc_w 679
    //   480: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_2
    //   485: aload_1
    //   486: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   489: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: iconst_5
    //   494: ldc 78
    //   496: ldc 80
    //   498: aload_2
    //   499: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   505: iconst_0
    //   506: ireturn
    //   507: iconst_1
    //   508: ireturn
    //   509: new 64	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   516: astore_2
    //   517: aload_2
    //   518: ldc_w 681
    //   521: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_2
    //   526: aload_1
    //   527: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: iconst_5
    //   532: ldc 78
    //   534: ldc 80
    //   536: aload_2
    //   537: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_1
    //   544: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   547: iconst_0
    //   548: ireturn
    //   549: astore_1
    //   550: aload 5
    //   552: astore 4
    //   554: goto +95 -> 649
    //   557: astore 4
    //   559: aload 5
    //   561: astore_2
    //   562: aload 4
    //   564: astore 5
    //   566: goto +12 -> 578
    //   569: astore_1
    //   570: goto +79 -> 649
    //   573: astore 5
    //   575: aload 6
    //   577: astore_2
    //   578: aload_2
    //   579: astore 4
    //   581: new 64	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   588: astore 6
    //   590: aload_2
    //   591: astore 4
    //   593: aload 6
    //   595: ldc_w 683
    //   598: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload_2
    //   603: astore 4
    //   605: aload 6
    //   607: aload 5
    //   609: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   612: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload_2
    //   617: astore 4
    //   619: iconst_5
    //   620: ldc 78
    //   622: ldc 80
    //   624: aload 6
    //   626: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload_2
    //   633: astore 4
    //   635: aload_1
    //   636: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   639: aload_2
    //   640: ifnull +7 -> 647
    //   643: aload_2
    //   644: invokevirtual 655	java/io/ObjectInputStream:close	()V
    //   647: iconst_0
    //   648: ireturn
    //   649: aload 4
    //   651: ifnull +8 -> 659
    //   654: aload 4
    //   656: invokevirtual 655	java/io/ObjectInputStream:close	()V
    //   659: aload_1
    //   660: athrow
    //   661: new 64	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   668: astore 4
    //   670: aload 4
    //   672: ldc_w 685
    //   675: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 4
    //   681: aload_1
    //   682: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 4
    //   688: ldc_w 661
    //   691: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 4
    //   697: aload_2
    //   698: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: iconst_5
    //   703: ldc 78
    //   705: ldc 80
    //   707: aload 4
    //   709: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   715: iconst_0
    //   716: ireturn
    //   717: astore 4
    //   719: goto -654 -> 65
    //   722: astore_1
    //   723: iconst_0
    //   724: ireturn
    //   725: astore_2
    //   726: goto -67 -> 659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	this	b
    //   0	729	1	paramFile1	File
    //   0	729	2	paramFile2	File
    //   290	100	3	n	int
    //   29	524	4	localObject1	Object
    //   557	6	4	localException1	Exception
    //   579	129	4	localObject2	Object
    //   717	1	4	localException2	Exception
    //   46	519	5	localObject3	Object
    //   573	35	5	localException3	Exception
    //   26	599	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   48	60	549	finally
    //   48	60	557	java/lang/Exception
    //   31	48	569	finally
    //   581	590	569	finally
    //   593	602	569	finally
    //   605	616	569	finally
    //   619	632	569	finally
    //   635	639	569	finally
    //   31	48	573	java/lang/Exception
    //   60	65	717	java/lang/Exception
    //   643	647	722	java/lang/Exception
    //   654	659	725	java/lang/Exception
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
      paramString2 = new StringBuilder();
      paramString2.append("unzipFile,  exception: ");
      paramString2.append(paramString1.toString());
      d.a(5, "SDKUpdateHelper.java", "MediaPlayerMgr", paramString2.toString());
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
      return;
    }
    if (e())
    {
      this.k = true;
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "fileInit checkLocalFiles true");
    }
  }
  
  /* Error */
  public boolean b(SDKLocalConfig paramSDKLocalConfig)
  {
    // Byte code:
    //   0: invokestatic 544	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 546
    //   6: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 64	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: invokestatic 549	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   26: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_3
    //   34: getstatic 552	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc_w 554
    //   45: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 91	java/io/File
    //   52: dup
    //   53: aload_3
    //   54: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: ldc 209
    //   59: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: invokevirtual 173	java/io/File:exists	()Z
    //   67: ifne +42 -> 109
    //   70: new 64	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   77: astore_1
    //   78: aload_1
    //   79: ldc_w 699
    //   82: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: aload_3
    //   88: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   91: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: iconst_5
    //   96: ldc 78
    //   98: ldc 80
    //   100: aload_1
    //   101: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   107: iconst_0
    //   108: ireturn
    //   109: new 64	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   116: astore 4
    //   118: aload 4
    //   120: invokestatic 549	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   123: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   126: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 4
    //   132: getstatic 552	java/io/File:separator	Ljava/lang/String;
    //   135: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: ldc_w 554
    //   144: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 91	java/io/File
    //   151: dup
    //   152: aload 4
    //   154: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: ldc 99
    //   159: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 173	java/io/File:exists	()Z
    //   169: ifne +43 -> 212
    //   172: new 64	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   179: astore_1
    //   180: aload_1
    //   181: ldc_w 701
    //   184: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: aload 4
    //   191: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   194: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: iconst_5
    //   199: ldc 78
    //   201: ldc 80
    //   203: aload_1
    //   204: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   210: iconst_0
    //   211: ireturn
    //   212: new 646	java/io/ObjectInputStream
    //   215: dup
    //   216: new 648	java/io/FileInputStream
    //   219: dup
    //   220: aload_3
    //   221: invokespecial 649	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   224: invokespecial 650	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   227: astore 6
    //   229: aload 6
    //   231: invokevirtual 654	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   234: checkcast 128	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig
    //   237: astore 5
    //   239: aload 6
    //   241: invokevirtual 655	java/io/ObjectInputStream:close	()V
    //   244: aload 5
    //   246: ifnull +334 -> 580
    //   249: aload 5
    //   251: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   254: ifnull +326 -> 580
    //   257: aload 5
    //   259: getfield 509	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:filename	Ljava/lang/String;
    //   262: ifnull +318 -> 580
    //   265: aload 5
    //   267: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   270: ifnull +310 -> 580
    //   273: aload 5
    //   275: getfield 207	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:JARMD5	Ljava/lang/String;
    //   278: ifnonnull +6 -> 284
    //   281: goto +299 -> 580
    //   284: aload 4
    //   286: invokestatic 204	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(Ljava/io/File;)Ljava/lang/String;
    //   289: astore 6
    //   291: aload 6
    //   293: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: istore_2
    //   297: iload_2
    //   298: ifne +217 -> 515
    //   301: aload 6
    //   303: aload 5
    //   305: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   308: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   311: ifne +6 -> 317
    //   314: goto +201 -> 515
    //   317: new 64	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   324: astore_3
    //   325: aload_3
    //   326: ldc_w 703
    //   329: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: aload 5
    //   336: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   339: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_3
    //   344: ldc_w 705
    //   347: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_3
    //   352: aload 5
    //   354: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   357: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: iconst_3
    //   362: ldc 78
    //   364: ldc 80
    //   366: aload_3
    //   367: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload 5
    //   375: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   378: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   381: ifne +257 -> 638
    //   384: aload 5
    //   386: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   389: aload_1
    //   390: getfield 512	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:version	Ljava/lang/String;
    //   393: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   396: ifeq +242 -> 638
    //   399: aload 5
    //   401: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   404: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifne +231 -> 638
    //   410: aload 5
    //   412: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   415: aload_1
    //   416: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   419: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   422: ifeq +216 -> 638
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 41	com/tencent/qqlive/mediaplayer/sdkupdate/b:f	Ljava/io/File;
    //   430: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: invokespecial 707	com/tencent/qqlive/mediaplayer/sdkupdate/b:d	(Ljava/lang/String;)Z
    //   436: ifne +77 -> 513
    //   439: iconst_5
    //   440: ldc_w 276
    //   443: ldc 80
    //   445: ldc_w 709
    //   448: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload_0
    //   452: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   455: ifnull +26 -> 481
    //   458: aload_0
    //   459: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   462: invokevirtual 173	java/io/File:exists	()Z
    //   465: ifeq +16 -> 481
    //   468: aload_0
    //   469: getfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   472: invokevirtual 244	java/io/File:delete	()Z
    //   475: pop
    //   476: aload_0
    //   477: aconst_null
    //   478: putfield 49	com/tencent/qqlive/mediaplayer/sdkupdate/b:j	Ljava/io/File;
    //   481: aload_0
    //   482: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   485: ifnull +26 -> 511
    //   488: aload_0
    //   489: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   492: invokevirtual 173	java/io/File:exists	()Z
    //   495: ifeq +16 -> 511
    //   498: aload_0
    //   499: getfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   502: invokevirtual 244	java/io/File:delete	()Z
    //   505: pop
    //   506: aload_0
    //   507: aconst_null
    //   508: putfield 47	com/tencent/qqlive/mediaplayer/sdkupdate/b:i	Ljava/io/File;
    //   511: iconst_0
    //   512: ireturn
    //   513: iconst_1
    //   514: ireturn
    //   515: new 64	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   522: astore_1
    //   523: aload_1
    //   524: ldc_w 711
    //   527: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_1
    //   532: aload 5
    //   534: getfield 176	com/tencent/qqlive/mediaplayer/sdkupdate/SDKLocalConfig:MD5	Ljava/lang/String;
    //   537: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_1
    //   542: ldc_w 671
    //   545: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload_1
    //   550: aload 6
    //   552: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: iconst_5
    //   557: ldc_w 276
    //   560: ldc 80
    //   562: aload_1
    //   563: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   569: aload_3
    //   570: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   573: aload 4
    //   575: invokestatic 97	com/tencent/qqlive/mediaplayer/sdkupdate/d:b	(Ljava/io/File;)V
    //   578: iconst_0
    //   579: ireturn
    //   580: iconst_5
    //   581: ldc 78
    //   583: ldc 80
    //   585: ldc_w 713
    //   588: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   591: iconst_0
    //   592: ireturn
    //   593: aload 6
    //   595: invokevirtual 655	java/io/ObjectInputStream:close	()V
    //   598: iconst_0
    //   599: ireturn
    //   600: astore_1
    //   601: new 64	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   608: astore_3
    //   609: aload_3
    //   610: ldc_w 715
    //   613: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload_3
    //   618: aload_1
    //   619: invokevirtual 247	java/lang/Exception:toString	()Ljava/lang/String;
    //   622: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: iconst_5
    //   627: ldc 78
    //   629: ldc 80
    //   631: aload_3
    //   632: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 89	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   638: iconst_0
    //   639: ireturn
    //   640: astore_1
    //   641: goto -48 -> 593
    //   644: astore_1
    //   645: goto -164 -> 481
    //   648: astore_1
    //   649: iconst_0
    //   650: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	b
    //   0	651	1	paramSDKLocalConfig	SDKLocalConfig
    //   296	2	2	bool	boolean
    //   21	611	3	localObject1	Object
    //   116	458	4	localObject2	Object
    //   237	296	5	localSDKLocalConfig	SDKLocalConfig
    //   227	367	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	600	java/lang/Exception
    //   14	107	600	java/lang/Exception
    //   109	210	600	java/lang/Exception
    //   212	229	600	java/lang/Exception
    //   239	244	600	java/lang/Exception
    //   249	281	600	java/lang/Exception
    //   284	297	600	java/lang/Exception
    //   301	314	600	java/lang/Exception
    //   317	451	600	java/lang/Exception
    //   451	481	600	java/lang/Exception
    //   481	511	600	java/lang/Exception
    //   515	578	600	java/lang/Exception
    //   580	591	600	java/lang/Exception
    //   593	598	600	java/lang/Exception
    //   229	239	640	java/lang/Exception
    //   451	481	644	java/lang/Throwable
    //   481	511	648	java/lang/Throwable
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
    TVK_SDKMgr.InstallListener localInstallListener = this.m;
    if (localInstallListener == null) {
      return;
    }
    int n = this.d;
    if (n == 0)
    {
      localInstallListener.onInstalledSuccessed();
      return;
    }
    localInstallListener.onInstalledFailed(n);
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
    boolean bool = this.k;
    StringBuilder localStringBuilder1 = null;
    if (bool)
    {
      Object localObject1 = this.e;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFilePathByPrefix, dirFile: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(" - prefix : ");
      ((StringBuilder)localObject2).append("armeabi");
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", ((StringBuilder)localObject2).toString());
      if (localObject1 == null)
      {
        localObject1 = localStringBuilder1;
      }
      else
      {
        localObject2 = ((File)localObject1).listFiles();
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          int i1 = localObject2.length;
          int n = 0;
          for (;;)
          {
            localObject1 = localStringBuilder1;
            if (n >= i1) {
              break;
            }
            localObject1 = localObject2[n];
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("getFilePathByPrefix,  file.name : ");
            localStringBuilder2.append(((File)localObject1).getName());
            localStringBuilder2.append(" , file.path :");
            localStringBuilder2.append(((File)localObject1).getAbsolutePath());
            d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder2.toString());
            if ((((File)localObject1).getName().length() >= 7) && (((File)localObject1).getName().substring(0, 7).equalsIgnoreCase("armeabi")))
            {
              localObject1 = ((File)localObject1).getAbsolutePath();
              break;
            }
            n += 1;
          }
        }
        d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", "getFilePathByPrefix , childFiles is null or length 0 ");
        localObject1 = localStringBuilder1;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getLibs, isFileExisted=true, libPath: ");
      localStringBuilder1.append((String)localObject1);
      d.a(3, "SDKUpdateHelper.java", "MediaPlayerMgr", localStringBuilder1.toString());
      return localObject1;
    }
    d.a(4, "SDKUpdateHelper.java", "MediaPlayerMgr", "getLibs, isFileExisted=false, return null ");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.b
 * JD-Core Version:    0.7.0.1
 */