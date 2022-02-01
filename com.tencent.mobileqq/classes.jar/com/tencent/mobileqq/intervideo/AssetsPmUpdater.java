package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.util.concurrent.Future;

public class AssetsPmUpdater
  implements IAssetsPmUpdater, PluginManagerUpdater
{
  private File a;
  private String b = "";
  private String c;
  private Context d;
  private String e;
  private String f;
  private final SharedPreferences g = BaseApplicationImpl.getContext().getSharedPreferences("IVShadowAssetsPmUpdater", 0);
  
  public AssetsPmUpdater(Context paramContext, String paramString1, String paramString2)
  {
    this.f = paramString2;
    this.d = paramContext;
    this.e = paramString1;
    paramContext = new File(paramContext.getFilesDir(), "IVShadowCdnPmUpdater/assets");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if ("Now".equals(paramString1))
    {
      this.b = "NowPluginManager.apk";
      this.c = "shadow/NowPluginManager.apk";
    }
    this.a = new File(paramContext, this.b);
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 94	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_2
    //   5: invokevirtual 100	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: new 102	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 52	java/io/File
    //   21: dup
    //   22: aload_3
    //   23: invokespecial 108	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_3
    //   28: invokevirtual 67	java/io/File:exists	()Z
    //   31: ifeq +8 -> 39
    //   34: aload_3
    //   35: invokevirtual 111	java/io/File:delete	()Z
    //   38: pop
    //   39: aload_3
    //   40: invokevirtual 114	java/io/File:createNewFile	()Z
    //   43: pop
    //   44: new 116	java/io/FileOutputStream
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore 5
    //   54: new 121	java/io/BufferedOutputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 124	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore_3
    //   64: aload_3
    //   65: astore 6
    //   67: aload_1
    //   68: astore 7
    //   70: aload_2
    //   71: astore 8
    //   73: aload 5
    //   75: astore 9
    //   77: sipush 1024
    //   80: newarray byte
    //   82: astore 10
    //   84: aload_3
    //   85: astore 6
    //   87: aload_1
    //   88: astore 7
    //   90: aload_2
    //   91: astore 8
    //   93: aload 5
    //   95: astore 9
    //   97: aload_2
    //   98: aload 10
    //   100: invokevirtual 128	java/io/BufferedInputStream:read	([B)I
    //   103: istore 4
    //   105: iload 4
    //   107: iconst_m1
    //   108: if_icmpeq +28 -> 136
    //   111: aload_3
    //   112: astore 6
    //   114: aload_1
    //   115: astore 7
    //   117: aload_2
    //   118: astore 8
    //   120: aload 5
    //   122: astore 9
    //   124: aload_3
    //   125: aload 10
    //   127: iconst_0
    //   128: iload 4
    //   130: invokevirtual 132	java/io/BufferedOutputStream:write	([BII)V
    //   133: goto -49 -> 84
    //   136: aload_3
    //   137: astore 6
    //   139: aload_1
    //   140: astore 7
    //   142: aload_2
    //   143: astore 8
    //   145: aload 5
    //   147: astore 9
    //   149: aload_3
    //   150: invokevirtual 135	java/io/BufferedOutputStream:flush	()V
    //   153: aload_3
    //   154: astore 6
    //   156: aload_1
    //   157: astore 7
    //   159: aload_2
    //   160: astore 8
    //   162: aload 5
    //   164: astore 9
    //   166: aload_0
    //   167: getfield 44	com/tencent/mobileqq/intervideo/AssetsPmUpdater:g	Landroid/content/SharedPreferences;
    //   170: invokeinterface 141 1 0
    //   175: astore 10
    //   177: aload_3
    //   178: astore 6
    //   180: aload_1
    //   181: astore 7
    //   183: aload_2
    //   184: astore 8
    //   186: aload 5
    //   188: astore 9
    //   190: new 143	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   197: astore 11
    //   199: aload_3
    //   200: astore 6
    //   202: aload_1
    //   203: astore 7
    //   205: aload_2
    //   206: astore 8
    //   208: aload 5
    //   210: astore 9
    //   212: aload 11
    //   214: ldc 146
    //   216: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: astore 6
    //   223: aload_1
    //   224: astore 7
    //   226: aload_2
    //   227: astore 8
    //   229: aload 5
    //   231: astore 9
    //   233: aload 11
    //   235: aload_0
    //   236: getfield 46	com/tencent/mobileqq/intervideo/AssetsPmUpdater:f	Ljava/lang/String;
    //   239: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: astore 6
    //   246: aload_1
    //   247: astore 7
    //   249: aload_2
    //   250: astore 8
    //   252: aload 5
    //   254: astore 9
    //   256: aload 10
    //   258: aload 11
    //   260: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: iconst_1
    //   264: invokeinterface 160 3 0
    //   269: invokeinterface 163 1 0
    //   274: aload_1
    //   275: ifnull +49 -> 324
    //   278: aload_1
    //   279: invokevirtual 168	java/io/InputStream:close	()V
    //   282: goto +42 -> 324
    //   285: astore_1
    //   286: new 143	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   293: astore 6
    //   295: aload 6
    //   297: ldc 170
    //   299: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 6
    //   305: aload_1
    //   306: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   309: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 173
    //   315: iconst_1
    //   316: aload 6
    //   318: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_2
    //   325: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   328: goto +38 -> 366
    //   331: astore_1
    //   332: new 143	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   339: astore_2
    //   340: aload_2
    //   341: ldc 170
    //   343: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_2
    //   348: aload_1
    //   349: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   352: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: ldc 173
    //   358: iconst_1
    //   359: aload_2
    //   360: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload 5
    //   368: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   371: goto +38 -> 409
    //   374: astore_1
    //   375: new 143	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   382: astore_2
    //   383: aload_2
    //   384: ldc 170
    //   386: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_2
    //   391: aload_1
    //   392: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   395: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 173
    //   401: iconst_1
    //   402: aload_2
    //   403: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_3
    //   410: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   413: iconst_1
    //   414: ireturn
    //   415: astore_1
    //   416: new 143	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   423: astore_2
    //   424: aload_2
    //   425: ldc 170
    //   427: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: aload_1
    //   433: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   436: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: ldc 173
    //   442: iconst_1
    //   443: aload_2
    //   444: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iconst_1
    //   451: ireturn
    //   452: astore 10
    //   454: goto +84 -> 538
    //   457: astore_3
    //   458: aconst_null
    //   459: astore 6
    //   461: aload_1
    //   462: astore 7
    //   464: aload 5
    //   466: astore_1
    //   467: goto +360 -> 827
    //   470: astore 10
    //   472: aconst_null
    //   473: astore_3
    //   474: goto +64 -> 538
    //   477: astore_3
    //   478: aconst_null
    //   479: astore 5
    //   481: aload_1
    //   482: astore 7
    //   484: aload 5
    //   486: astore_1
    //   487: goto +30 -> 517
    //   490: astore 5
    //   492: aconst_null
    //   493: astore_3
    //   494: goto +37 -> 531
    //   497: astore_3
    //   498: aload_1
    //   499: astore 7
    //   501: goto +12 -> 513
    //   504: astore 5
    //   506: goto +21 -> 527
    //   509: astore_3
    //   510: aconst_null
    //   511: astore 7
    //   513: aconst_null
    //   514: astore_2
    //   515: aconst_null
    //   516: astore_1
    //   517: aload_1
    //   518: astore 6
    //   520: goto +307 -> 827
    //   523: astore 5
    //   525: aconst_null
    //   526: astore_1
    //   527: aconst_null
    //   528: astore_2
    //   529: aconst_null
    //   530: astore_3
    //   531: aload 5
    //   533: astore 10
    //   535: aload_3
    //   536: astore 5
    //   538: aload_3
    //   539: astore 6
    //   541: aload_1
    //   542: astore 7
    //   544: aload_2
    //   545: astore 8
    //   547: aload 5
    //   549: astore 9
    //   551: new 143	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   558: astore 11
    //   560: aload_3
    //   561: astore 6
    //   563: aload_1
    //   564: astore 7
    //   566: aload_2
    //   567: astore 8
    //   569: aload 5
    //   571: astore 9
    //   573: aload 11
    //   575: ldc 184
    //   577: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_3
    //   582: astore 6
    //   584: aload_1
    //   585: astore 7
    //   587: aload_2
    //   588: astore 8
    //   590: aload 5
    //   592: astore 9
    //   594: aload 11
    //   596: aload 10
    //   598: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   601: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_3
    //   606: astore 6
    //   608: aload_1
    //   609: astore 7
    //   611: aload_2
    //   612: astore 8
    //   614: aload 5
    //   616: astore 9
    //   618: ldc 173
    //   620: iconst_1
    //   621: aload 11
    //   623: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: aload_1
    //   630: ifnull +49 -> 679
    //   633: aload_1
    //   634: invokevirtual 168	java/io/InputStream:close	()V
    //   637: goto +42 -> 679
    //   640: astore_1
    //   641: new 143	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   648: astore 6
    //   650: aload 6
    //   652: ldc 170
    //   654: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload 6
    //   660: aload_1
    //   661: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   664: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: ldc 173
    //   670: iconst_1
    //   671: aload 6
    //   673: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: aload_2
    //   680: ifnull +45 -> 725
    //   683: aload_2
    //   684: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   687: goto +38 -> 725
    //   690: astore_1
    //   691: new 143	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   698: astore_2
    //   699: aload_2
    //   700: ldc 170
    //   702: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_2
    //   707: aload_1
    //   708: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   711: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: ldc 173
    //   717: iconst_1
    //   718: aload_2
    //   719: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   725: aload 5
    //   727: ifnull +46 -> 773
    //   730: aload 5
    //   732: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   735: goto +38 -> 773
    //   738: astore_1
    //   739: new 143	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   746: astore_2
    //   747: aload_2
    //   748: ldc 170
    //   750: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_2
    //   755: aload_1
    //   756: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   759: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: ldc 173
    //   765: iconst_1
    //   766: aload_2
    //   767: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: aload_3
    //   774: ifnull +44 -> 818
    //   777: aload_3
    //   778: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   781: iconst_0
    //   782: ireturn
    //   783: astore_1
    //   784: new 143	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   791: astore_2
    //   792: aload_2
    //   793: ldc 170
    //   795: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload_2
    //   800: aload_1
    //   801: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   804: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: ldc 173
    //   810: iconst_1
    //   811: aload_2
    //   812: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   818: iconst_0
    //   819: ireturn
    //   820: astore_3
    //   821: aload 9
    //   823: astore_1
    //   824: aload 8
    //   826: astore_2
    //   827: aload 7
    //   829: ifnull +52 -> 881
    //   832: aload 7
    //   834: invokevirtual 168	java/io/InputStream:close	()V
    //   837: goto +44 -> 881
    //   840: astore 5
    //   842: new 143	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   849: astore 7
    //   851: aload 7
    //   853: ldc 170
    //   855: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 7
    //   861: aload 5
    //   863: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   866: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: ldc 173
    //   872: iconst_1
    //   873: aload 7
    //   875: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: aload_2
    //   882: ifnull +49 -> 931
    //   885: aload_2
    //   886: invokevirtual 180	java/io/BufferedInputStream:close	()V
    //   889: goto +42 -> 931
    //   892: astore_2
    //   893: new 143	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   900: astore 5
    //   902: aload 5
    //   904: ldc 170
    //   906: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 5
    //   912: aload_2
    //   913: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   916: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: ldc 173
    //   922: iconst_1
    //   923: aload 5
    //   925: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: aload_1
    //   932: ifnull +45 -> 977
    //   935: aload_1
    //   936: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   939: goto +38 -> 977
    //   942: astore_1
    //   943: new 143	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   950: astore_2
    //   951: aload_2
    //   952: ldc 170
    //   954: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_2
    //   959: aload_1
    //   960: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   963: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: pop
    //   967: ldc 173
    //   969: iconst_1
    //   970: aload_2
    //   971: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   977: aload 6
    //   979: ifnull +46 -> 1025
    //   982: aload 6
    //   984: invokevirtual 182	java/io/BufferedOutputStream:close	()V
    //   987: goto +38 -> 1025
    //   990: astore_1
    //   991: new 143	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   998: astore_2
    //   999: aload_2
    //   1000: ldc 170
    //   1002: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload_2
    //   1007: aload_1
    //   1008: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   1011: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: ldc 173
    //   1017: iconst_1
    //   1018: aload_2
    //   1019: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1025: goto +5 -> 1030
    //   1028: aload_3
    //   1029: athrow
    //   1030: goto -2 -> 1028
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1033	0	this	AssetsPmUpdater
    //   0	1033	1	paramContext	Context
    //   0	1033	2	paramString1	String
    //   0	1033	3	paramString2	String
    //   103	26	4	i	int
    //   52	433	5	localFileOutputStream	java.io.FileOutputStream
    //   490	1	5	localIOException1	java.io.IOException
    //   504	1	5	localIOException2	java.io.IOException
    //   523	9	5	localIOException3	java.io.IOException
    //   536	195	5	str1	String
    //   840	22	5	localIOException4	java.io.IOException
    //   900	24	5	localStringBuilder1	StringBuilder
    //   65	918	6	localObject1	Object
    //   68	806	7	localObject2	Object
    //   71	754	8	str2	String
    //   75	747	9	localObject3	Object
    //   82	175	10	localObject4	Object
    //   452	1	10	localIOException5	java.io.IOException
    //   470	1	10	localIOException6	java.io.IOException
    //   533	64	10	localIOException7	java.io.IOException
    //   197	425	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   278	282	285	java/io/IOException
    //   324	328	331	java/io/IOException
    //   366	371	374	java/io/IOException
    //   409	413	415	java/io/IOException
    //   77	84	452	java/io/IOException
    //   97	105	452	java/io/IOException
    //   124	133	452	java/io/IOException
    //   149	153	452	java/io/IOException
    //   166	177	452	java/io/IOException
    //   190	199	452	java/io/IOException
    //   212	220	452	java/io/IOException
    //   233	243	452	java/io/IOException
    //   256	274	452	java/io/IOException
    //   54	64	457	finally
    //   54	64	470	java/io/IOException
    //   18	39	477	finally
    //   39	54	477	finally
    //   18	39	490	java/io/IOException
    //   39	54	490	java/io/IOException
    //   9	18	497	finally
    //   9	18	504	java/io/IOException
    //   0	9	509	finally
    //   0	9	523	java/io/IOException
    //   633	637	640	java/io/IOException
    //   683	687	690	java/io/IOException
    //   730	735	738	java/io/IOException
    //   777	781	783	java/io/IOException
    //   77	84	820	finally
    //   97	105	820	finally
    //   124	133	820	finally
    //   149	153	820	finally
    //   166	177	820	finally
    //   190	199	820	finally
    //   212	220	820	finally
    //   233	243	820	finally
    //   256	274	820	finally
    //   551	560	820	finally
    //   573	581	820	finally
    //   594	605	820	finally
    //   618	629	820	finally
    //   832	837	840	java/io/IOException
    //   885	889	892	java/io/IOException
    //   935	939	942	java/io/IOException
    //   982	987	990	java/io/IOException
  }
  
  public boolean a()
  {
    return "Now".equals(this.e);
  }
  
  public File getLatest()
  {
    if (a())
    {
      long l = System.currentTimeMillis();
      boolean bool = a(this.d, this.c, this.a.getAbsolutePath());
      NowDataReporter localNowDataReporter = PluginManagerInterfaceImpl.a().d().b("copy_pm");
      Object localObject;
      if (bool) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      localNowDataReporter.c((String)localObject).b();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("copy asset pm success, cost=");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.i("shadow::AssetsPmUpdater", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        QLog.i("shadow::AssetsPmUpdater", 1, "copy asset pm fail");
      }
      return this.a;
    }
    return null;
  }
  
  public Future isAvailable(File paramFile)
  {
    return null;
  }
  
  public Future update()
  {
    return null;
  }
  
  public boolean wasUpdating()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.AssetsPmUpdater
 * JD-Core Version:    0.7.0.1
 */