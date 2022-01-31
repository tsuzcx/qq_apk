package com.tencent.ttpic.openapi.ttpicmodule;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.util.DecryptListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class AEMaterialParser
{
  private static final String CONFIG_ENCRYPTED_SUFFIX = ".dat";
  private static final String CONFIG_SUFFIX = ".json";
  public static final String TAG = AEMaterialParser.class.getSimpleName();
  private static final DecryptListener decryptListener = new AEMaterialParser.1();
  private static final AEMaterialParser ourInstance = new AEMaterialParser();
  
  private InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  public static AEMaterialParser getInstance()
  {
    return ourInstance;
  }
  
  /* Error */
  private String readFileString(Context paramContext, String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_3
    //   10: ldc 73
    //   12: invokevirtual 79	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +328 -> 343
    //   18: iconst_1
    //   19: istore 5
    //   21: aload_2
    //   22: invokestatic 85	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 9
    //   27: new 87	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   34: aload 9
    //   36: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 94
    //   41: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: new 87	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   59: aload 9
    //   61: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 94
    //   66: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_3
    //   70: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 9
    //   78: new 99	java/io/File
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore_3
    //   87: new 99	java/io/File
    //   90: dup
    //   91: aload 9
    //   93: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 10
    //   98: aload_3
    //   99: invokevirtual 106	java/io/File:exists	()Z
    //   102: ifeq +10 -> 112
    //   105: aload_3
    //   106: invokevirtual 109	java/io/File:isFile	()Z
    //   109: ifne +19 -> 128
    //   112: aload 10
    //   114: invokevirtual 106	java/io/File:exists	()Z
    //   117: ifeq +286 -> 403
    //   120: aload 10
    //   122: invokevirtual 109	java/io/File:isFile	()Z
    //   125: ifeq +278 -> 403
    //   128: aload_3
    //   129: invokevirtual 106	java/io/File:exists	()Z
    //   132: ifeq +217 -> 349
    //   135: aload_3
    //   136: invokevirtual 109	java/io/File:isFile	()Z
    //   139: ifeq +210 -> 349
    //   142: new 111	java/io/FileInputStream
    //   145: dup
    //   146: aload_3
    //   147: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   150: astore_1
    //   151: aload_1
    //   152: astore 8
    //   154: iload 5
    //   156: ifne +240 -> 396
    //   159: aload_0
    //   160: aload 8
    //   162: aload 4
    //   164: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   167: astore_1
    //   168: aload 8
    //   170: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +414 -> 592
    //   181: new 122	java/io/InputStreamReader
    //   184: dup
    //   185: aload 4
    //   187: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   190: astore_3
    //   191: new 126	java/io/BufferedReader
    //   194: dup
    //   195: aload_3
    //   196: sipush 1024
    //   199: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   202: astore_1
    //   203: aload 8
    //   205: astore 12
    //   207: aload_3
    //   208: astore 11
    //   210: aload_1
    //   211: astore 10
    //   213: aload 4
    //   215: astore 9
    //   217: new 87	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   224: astore 13
    //   226: aload 8
    //   228: astore 12
    //   230: aload_3
    //   231: astore 11
    //   233: aload_1
    //   234: astore 10
    //   236: aload 4
    //   238: astore 9
    //   240: aload_1
    //   241: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   244: astore_2
    //   245: aload_2
    //   246: ifnull +268 -> 514
    //   249: aload 8
    //   251: astore 12
    //   253: aload_3
    //   254: astore 11
    //   256: aload_1
    //   257: astore 10
    //   259: aload 4
    //   261: astore 9
    //   263: aload 13
    //   265: aload_2
    //   266: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: goto -44 -> 226
    //   273: astore_2
    //   274: aload 8
    //   276: astore 12
    //   278: aload_3
    //   279: astore 11
    //   281: aload_1
    //   282: astore 10
    //   284: aload 4
    //   286: astore 9
    //   288: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   291: aload_2
    //   292: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: aload_2
    //   296: iconst_0
    //   297: anewarray 4	java/lang/Object
    //   300: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 144	java/io/BufferedReader:close	()V
    //   311: aload_3
    //   312: ifnull +7 -> 319
    //   315: aload_3
    //   316: invokevirtual 145	java/io/InputStreamReader:close	()V
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 148	java/io/InputStream:close	()V
    //   329: aload 8
    //   331: ifnull +8 -> 339
    //   334: aload 8
    //   336: invokevirtual 149	java/io/FileInputStream:close	()V
    //   339: aconst_null
    //   340: astore_1
    //   341: aload_1
    //   342: areturn
    //   343: iconst_0
    //   344: istore 5
    //   346: goto -325 -> 21
    //   349: aload 10
    //   351: invokevirtual 106	java/io/File:exists	()Z
    //   354: ifeq +609 -> 963
    //   357: aload 10
    //   359: invokevirtual 109	java/io/File:isFile	()Z
    //   362: ifeq +601 -> 963
    //   365: new 111	java/io/FileInputStream
    //   368: dup
    //   369: aload 10
    //   371: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   374: astore_1
    //   375: iload 5
    //   377: ifne +13 -> 390
    //   380: iload 7
    //   382: istore 5
    //   384: aload_1
    //   385: astore 8
    //   387: goto -233 -> 154
    //   390: iconst_0
    //   391: istore 5
    //   393: goto -9 -> 384
    //   396: aload 8
    //   398: astore 4
    //   400: goto -224 -> 176
    //   403: aload_1
    //   404: invokevirtual 155	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   407: aload_2
    //   408: invokevirtual 161	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   411: astore_3
    //   412: iload 5
    //   414: ifne +26 -> 440
    //   417: aload_0
    //   418: aload_3
    //   419: aload 4
    //   421: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   424: astore_2
    //   425: aload_3
    //   426: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   429: aload_2
    //   430: astore_1
    //   431: aconst_null
    //   432: astore 8
    //   434: aload_1
    //   435: astore 4
    //   437: goto -261 -> 176
    //   440: aload_3
    //   441: astore_1
    //   442: goto -11 -> 431
    //   445: astore_2
    //   446: aconst_null
    //   447: astore_2
    //   448: aload_1
    //   449: invokevirtual 155	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   452: aload 9
    //   454: invokevirtual 161	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   457: astore_3
    //   458: iload 5
    //   460: ifne +33 -> 493
    //   463: iload 6
    //   465: istore 5
    //   467: iload 5
    //   469: ifne +30 -> 499
    //   472: aload_0
    //   473: aload_3
    //   474: aload 4
    //   476: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   479: astore_1
    //   480: aload_3
    //   481: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   484: aconst_null
    //   485: astore 8
    //   487: aload_1
    //   488: astore 4
    //   490: goto -314 -> 176
    //   493: iconst_0
    //   494: istore 5
    //   496: goto -29 -> 467
    //   499: aload_3
    //   500: astore_1
    //   501: goto -17 -> 484
    //   504: astore_1
    //   505: aconst_null
    //   506: astore 8
    //   508: aload_2
    //   509: astore 4
    //   511: goto -335 -> 176
    //   514: aload 8
    //   516: astore 12
    //   518: aload_3
    //   519: astore 11
    //   521: aload_1
    //   522: astore 10
    //   524: aload 4
    //   526: astore 9
    //   528: aload 13
    //   530: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: astore_2
    //   534: aload_1
    //   535: ifnull +7 -> 542
    //   538: aload_1
    //   539: invokevirtual 144	java/io/BufferedReader:close	()V
    //   542: aload_3
    //   543: ifnull +7 -> 550
    //   546: aload_3
    //   547: invokevirtual 145	java/io/InputStreamReader:close	()V
    //   550: aload 4
    //   552: ifnull +8 -> 560
    //   555: aload 4
    //   557: invokevirtual 148	java/io/InputStream:close	()V
    //   560: aload_2
    //   561: astore_1
    //   562: aload 8
    //   564: ifnull -223 -> 341
    //   567: aload 8
    //   569: invokevirtual 149	java/io/FileInputStream:close	()V
    //   572: aload_2
    //   573: areturn
    //   574: astore_1
    //   575: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   578: aload_1
    //   579: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   582: aload_1
    //   583: iconst_0
    //   584: anewarray 4	java/lang/Object
    //   587: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   590: aload_2
    //   591: areturn
    //   592: iconst_0
    //   593: ifeq +11 -> 604
    //   596: new 164	java/lang/NullPointerException
    //   599: dup
    //   600: invokespecial 165	java/lang/NullPointerException:<init>	()V
    //   603: athrow
    //   604: iconst_0
    //   605: ifeq +11 -> 616
    //   608: new 164	java/lang/NullPointerException
    //   611: dup
    //   612: invokespecial 165	java/lang/NullPointerException:<init>	()V
    //   615: athrow
    //   616: aload 4
    //   618: ifnull +8 -> 626
    //   621: aload 4
    //   623: invokevirtual 148	java/io/InputStream:close	()V
    //   626: aload 8
    //   628: ifnull -289 -> 339
    //   631: aload 8
    //   633: invokevirtual 149	java/io/FileInputStream:close	()V
    //   636: goto -297 -> 339
    //   639: astore_1
    //   640: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   643: aload_1
    //   644: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   647: aload_1
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   655: goto -316 -> 339
    //   658: astore_1
    //   659: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   662: aload_1
    //   663: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   666: aload_1
    //   667: iconst_0
    //   668: anewarray 4	java/lang/Object
    //   671: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   674: goto -335 -> 339
    //   677: astore_1
    //   678: aconst_null
    //   679: astore_2
    //   680: aconst_null
    //   681: astore_3
    //   682: aconst_null
    //   683: astore 4
    //   685: aload_3
    //   686: ifnull +7 -> 693
    //   689: aload_3
    //   690: invokevirtual 144	java/io/BufferedReader:close	()V
    //   693: aload_2
    //   694: ifnull +7 -> 701
    //   697: aload_2
    //   698: invokevirtual 145	java/io/InputStreamReader:close	()V
    //   701: aload 4
    //   703: ifnull +8 -> 711
    //   706: aload 4
    //   708: invokevirtual 148	java/io/InputStream:close	()V
    //   711: aload 8
    //   713: ifnull +8 -> 721
    //   716: aload 8
    //   718: invokevirtual 149	java/io/FileInputStream:close	()V
    //   721: aload_1
    //   722: athrow
    //   723: astore_2
    //   724: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   727: aload_2
    //   728: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   731: aload_2
    //   732: iconst_0
    //   733: anewarray 4	java/lang/Object
    //   736: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   739: goto -18 -> 721
    //   742: astore_1
    //   743: aconst_null
    //   744: astore_2
    //   745: aconst_null
    //   746: astore_3
    //   747: aconst_null
    //   748: astore 4
    //   750: goto -65 -> 685
    //   753: astore 9
    //   755: aconst_null
    //   756: astore_2
    //   757: aload_1
    //   758: astore 4
    //   760: aconst_null
    //   761: astore_3
    //   762: aload 9
    //   764: astore_1
    //   765: goto -80 -> 685
    //   768: astore_1
    //   769: aconst_null
    //   770: astore_3
    //   771: aload_2
    //   772: astore 4
    //   774: aconst_null
    //   775: astore_2
    //   776: goto -91 -> 685
    //   779: astore_1
    //   780: aconst_null
    //   781: astore_3
    //   782: aload_2
    //   783: astore 4
    //   785: aconst_null
    //   786: astore 9
    //   788: aload_3
    //   789: astore_2
    //   790: aload 9
    //   792: astore_3
    //   793: goto -108 -> 685
    //   796: astore 9
    //   798: aconst_null
    //   799: astore_2
    //   800: aconst_null
    //   801: astore_3
    //   802: aload_1
    //   803: astore 4
    //   805: aload 9
    //   807: astore_1
    //   808: goto -123 -> 685
    //   811: astore_1
    //   812: aconst_null
    //   813: astore_2
    //   814: aconst_null
    //   815: astore_3
    //   816: goto -131 -> 685
    //   819: astore_1
    //   820: aconst_null
    //   821: astore 9
    //   823: aload_3
    //   824: astore_2
    //   825: aload 9
    //   827: astore_3
    //   828: goto -143 -> 685
    //   831: astore_1
    //   832: aload 12
    //   834: astore 8
    //   836: aload 11
    //   838: astore_2
    //   839: aload 10
    //   841: astore_3
    //   842: aload 9
    //   844: astore 4
    //   846: goto -161 -> 685
    //   849: astore_2
    //   850: aconst_null
    //   851: astore 8
    //   853: aconst_null
    //   854: astore_3
    //   855: aconst_null
    //   856: astore_1
    //   857: aconst_null
    //   858: astore 4
    //   860: goto -586 -> 274
    //   863: astore_2
    //   864: aconst_null
    //   865: astore_3
    //   866: aconst_null
    //   867: astore_1
    //   868: aconst_null
    //   869: astore 4
    //   871: goto -597 -> 274
    //   874: astore_2
    //   875: aconst_null
    //   876: astore_3
    //   877: aload_1
    //   878: astore 4
    //   880: aconst_null
    //   881: astore_1
    //   882: goto -608 -> 274
    //   885: astore 9
    //   887: aconst_null
    //   888: astore 8
    //   890: aconst_null
    //   891: astore_1
    //   892: aload_2
    //   893: astore 4
    //   895: aconst_null
    //   896: astore_3
    //   897: aload 9
    //   899: astore_2
    //   900: goto -626 -> 274
    //   903: astore 9
    //   905: aconst_null
    //   906: astore 8
    //   908: aconst_null
    //   909: astore_3
    //   910: aload_2
    //   911: astore 4
    //   913: aconst_null
    //   914: astore_1
    //   915: aload 9
    //   917: astore_2
    //   918: goto -644 -> 274
    //   921: astore_2
    //   922: aconst_null
    //   923: astore_3
    //   924: aconst_null
    //   925: astore 9
    //   927: aload_1
    //   928: astore 4
    //   930: aconst_null
    //   931: astore 8
    //   933: aload 9
    //   935: astore_1
    //   936: goto -662 -> 274
    //   939: astore_2
    //   940: aconst_null
    //   941: astore_3
    //   942: aconst_null
    //   943: astore_1
    //   944: goto -670 -> 274
    //   947: astore_2
    //   948: aconst_null
    //   949: astore_1
    //   950: goto -676 -> 274
    //   953: astore_2
    //   954: aload_1
    //   955: astore_2
    //   956: goto -451 -> 505
    //   959: astore_3
    //   960: goto -512 -> 448
    //   963: aconst_null
    //   964: astore 8
    //   966: goto -812 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	this	AEMaterialParser
    //   0	969	1	paramContext	Context
    //   0	969	2	paramString1	String
    //   0	969	3	paramString2	String
    //   0	969	4	paramDecryptListener	DecryptListener
    //   19	476	5	i	int
    //   1	463	6	j	int
    //   4	377	7	k	int
    //   7	958	8	localObject1	Object
    //   25	502	9	localObject2	Object
    //   753	10	9	localObject3	Object
    //   786	5	9	localObject4	Object
    //   796	10	9	localObject5	Object
    //   821	22	9	localObject6	Object
    //   885	13	9	localException1	java.lang.Exception
    //   903	13	9	localException2	java.lang.Exception
    //   925	9	9	localObject7	Object
    //   96	744	10	localObject8	Object
    //   208	629	11	str	String
    //   205	628	12	localObject9	Object
    //   224	305	13	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   217	226	273	java/lang/Exception
    //   240	245	273	java/lang/Exception
    //   263	270	273	java/lang/Exception
    //   528	534	273	java/lang/Exception
    //   403	412	445	java/io/IOException
    //   417	425	445	java/io/IOException
    //   448	458	504	java/io/IOException
    //   472	480	504	java/io/IOException
    //   538	542	574	java/io/IOException
    //   546	550	574	java/io/IOException
    //   555	560	574	java/io/IOException
    //   567	572	574	java/io/IOException
    //   596	604	639	java/io/IOException
    //   608	616	639	java/io/IOException
    //   621	626	639	java/io/IOException
    //   631	636	639	java/io/IOException
    //   307	311	658	java/io/IOException
    //   315	319	658	java/io/IOException
    //   324	329	658	java/io/IOException
    //   334	339	658	java/io/IOException
    //   78	112	677	finally
    //   112	128	677	finally
    //   128	151	677	finally
    //   349	375	677	finally
    //   403	412	677	finally
    //   417	425	677	finally
    //   689	693	723	java/io/IOException
    //   697	701	723	java/io/IOException
    //   706	711	723	java/io/IOException
    //   716	721	723	java/io/IOException
    //   159	168	742	finally
    //   168	173	753	finally
    //   425	429	768	finally
    //   448	458	779	finally
    //   472	480	779	finally
    //   480	484	796	finally
    //   181	191	811	finally
    //   191	203	819	finally
    //   217	226	831	finally
    //   240	245	831	finally
    //   263	270	831	finally
    //   288	303	831	finally
    //   528	534	831	finally
    //   78	112	849	java/lang/Exception
    //   112	128	849	java/lang/Exception
    //   128	151	849	java/lang/Exception
    //   349	375	849	java/lang/Exception
    //   403	412	849	java/lang/Exception
    //   417	425	849	java/lang/Exception
    //   159	168	863	java/lang/Exception
    //   168	173	874	java/lang/Exception
    //   425	429	885	java/lang/Exception
    //   448	458	903	java/lang/Exception
    //   472	480	903	java/lang/Exception
    //   480	484	921	java/lang/Exception
    //   181	191	939	java/lang/Exception
    //   191	203	947	java/lang/Exception
    //   480	484	953	java/io/IOException
    //   425	429	959	java/io/IOException
  }
  
  public void parse(Context paramContext, String paramString1, Class paramClass, String paramString2, AEMaterialParser.ParseCallback paramParseCallback)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (paramParseCallback != null) {
        paramParseCallback.onFailed("Template path is not valid");
      }
    }
    do
    {
      return;
      File localFile1 = new File(paramString1, paramString2 + ".json");
      File localFile2 = new File(paramString1, paramString2 + ".dat");
      if (localFile1.exists()) {}
      for (paramString2 = localFile1.getName();; paramString2 = localFile2.getName())
      {
        AsyncTask.execute(new AEMaterialParser.2(this, paramContext, paramString1, paramString2, paramClass, paramParseCallback));
        return;
        if (!localFile2.exists()) {
          break;
        }
      }
    } while (paramParseCallback == null);
    paramParseCallback.onFailed(paramString2 + " config file not exist.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEMaterialParser
 * JD-Core Version:    0.7.0.1
 */