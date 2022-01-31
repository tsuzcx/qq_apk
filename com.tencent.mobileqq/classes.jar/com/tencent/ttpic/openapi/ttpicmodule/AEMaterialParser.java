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
    //   15: ifne +329 -> 344
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
    //   117: ifeq +287 -> 404
    //   120: aload 10
    //   122: invokevirtual 109	java/io/File:isFile	()Z
    //   125: ifeq +279 -> 404
    //   128: aload_3
    //   129: invokevirtual 106	java/io/File:exists	()Z
    //   132: ifeq +218 -> 350
    //   135: aload_3
    //   136: invokevirtual 109	java/io/File:isFile	()Z
    //   139: ifeq +211 -> 350
    //   142: new 111	java/io/FileInputStream
    //   145: dup
    //   146: aload_3
    //   147: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   150: astore_1
    //   151: aload_1
    //   152: astore 8
    //   154: iload 5
    //   156: ifne +241 -> 397
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
    //   224: astore_2
    //   225: aload 8
    //   227: astore 12
    //   229: aload_3
    //   230: astore 11
    //   232: aload_1
    //   233: astore 10
    //   235: aload 4
    //   237: astore 9
    //   239: aload_1
    //   240: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   243: astore 13
    //   245: aload 13
    //   247: ifnull +268 -> 515
    //   250: aload 8
    //   252: astore 12
    //   254: aload_3
    //   255: astore 11
    //   257: aload_1
    //   258: astore 10
    //   260: aload 4
    //   262: astore 9
    //   264: aload_2
    //   265: aload 13
    //   267: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: goto -46 -> 225
    //   274: astore_2
    //   275: aload 8
    //   277: astore 12
    //   279: aload_3
    //   280: astore 11
    //   282: aload_1
    //   283: astore 10
    //   285: aload 4
    //   287: astore 9
    //   289: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   292: aload_2
    //   293: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   296: aload_2
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 144	java/io/BufferedReader:close	()V
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 145	java/io/InputStreamReader:close	()V
    //   320: aload 4
    //   322: ifnull +8 -> 330
    //   325: aload 4
    //   327: invokevirtual 148	java/io/InputStream:close	()V
    //   330: aload 8
    //   332: ifnull +8 -> 340
    //   335: aload 8
    //   337: invokevirtual 149	java/io/FileInputStream:close	()V
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_1
    //   343: areturn
    //   344: iconst_0
    //   345: istore 5
    //   347: goto -326 -> 21
    //   350: aload 10
    //   352: invokevirtual 106	java/io/File:exists	()Z
    //   355: ifeq +606 -> 961
    //   358: aload 10
    //   360: invokevirtual 109	java/io/File:isFile	()Z
    //   363: ifeq +598 -> 961
    //   366: new 111	java/io/FileInputStream
    //   369: dup
    //   370: aload 10
    //   372: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   375: astore_1
    //   376: iload 5
    //   378: ifne +13 -> 391
    //   381: iload 7
    //   383: istore 5
    //   385: aload_1
    //   386: astore 8
    //   388: goto -234 -> 154
    //   391: iconst_0
    //   392: istore 5
    //   394: goto -9 -> 385
    //   397: aload 8
    //   399: astore 4
    //   401: goto -225 -> 176
    //   404: aload_1
    //   405: invokevirtual 155	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   408: aload_2
    //   409: invokevirtual 161	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   412: astore_3
    //   413: iload 5
    //   415: ifne +26 -> 441
    //   418: aload_0
    //   419: aload_3
    //   420: aload 4
    //   422: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   425: astore_2
    //   426: aload_3
    //   427: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   430: aload_2
    //   431: astore_1
    //   432: aconst_null
    //   433: astore 8
    //   435: aload_1
    //   436: astore 4
    //   438: goto -262 -> 176
    //   441: aload_3
    //   442: astore_1
    //   443: goto -11 -> 432
    //   446: astore_2
    //   447: aconst_null
    //   448: astore_2
    //   449: aload_1
    //   450: invokevirtual 155	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   453: aload 9
    //   455: invokevirtual 161	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   458: astore_3
    //   459: iload 5
    //   461: ifne +33 -> 494
    //   464: iload 6
    //   466: istore 5
    //   468: iload 5
    //   470: ifne +30 -> 500
    //   473: aload_0
    //   474: aload_3
    //   475: aload 4
    //   477: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   480: astore_1
    //   481: aload_3
    //   482: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   485: aconst_null
    //   486: astore 8
    //   488: aload_1
    //   489: astore 4
    //   491: goto -315 -> 176
    //   494: iconst_0
    //   495: istore 5
    //   497: goto -29 -> 468
    //   500: aload_3
    //   501: astore_1
    //   502: goto -17 -> 485
    //   505: astore_1
    //   506: aconst_null
    //   507: astore 8
    //   509: aload_2
    //   510: astore 4
    //   512: goto -336 -> 176
    //   515: aload 8
    //   517: astore 12
    //   519: aload_3
    //   520: astore 11
    //   522: aload_1
    //   523: astore 10
    //   525: aload 4
    //   527: astore 9
    //   529: aload_2
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
    //   564: ifnull -222 -> 342
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
    //   628: ifnull -288 -> 340
    //   631: aload 8
    //   633: invokevirtual 149	java/io/FileInputStream:close	()V
    //   636: goto -296 -> 340
    //   639: astore_1
    //   640: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   643: aload_1
    //   644: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   647: aload_1
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   655: goto -315 -> 340
    //   658: astore_1
    //   659: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   662: aload_1
    //   663: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   666: aload_1
    //   667: iconst_0
    //   668: anewarray 4	java/lang/Object
    //   671: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   674: goto -334 -> 340
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
    //   781: astore 9
    //   783: aload_2
    //   784: astore 4
    //   786: aconst_null
    //   787: astore_3
    //   788: aload 9
    //   790: astore_2
    //   791: goto -106 -> 685
    //   794: astore 9
    //   796: aconst_null
    //   797: astore_2
    //   798: aconst_null
    //   799: astore_3
    //   800: aload_1
    //   801: astore 4
    //   803: aload 9
    //   805: astore_1
    //   806: goto -121 -> 685
    //   809: astore_1
    //   810: aconst_null
    //   811: astore_2
    //   812: aconst_null
    //   813: astore_3
    //   814: goto -129 -> 685
    //   817: astore_1
    //   818: aconst_null
    //   819: astore 9
    //   821: aload_3
    //   822: astore_2
    //   823: aload 9
    //   825: astore_3
    //   826: goto -141 -> 685
    //   829: astore_1
    //   830: aload 12
    //   832: astore 8
    //   834: aload 11
    //   836: astore_2
    //   837: aload 10
    //   839: astore_3
    //   840: aload 9
    //   842: astore 4
    //   844: goto -159 -> 685
    //   847: astore_2
    //   848: aconst_null
    //   849: astore 8
    //   851: aconst_null
    //   852: astore_3
    //   853: aconst_null
    //   854: astore_1
    //   855: aconst_null
    //   856: astore 4
    //   858: goto -583 -> 275
    //   861: astore_2
    //   862: aconst_null
    //   863: astore_3
    //   864: aconst_null
    //   865: astore_1
    //   866: aconst_null
    //   867: astore 4
    //   869: goto -594 -> 275
    //   872: astore_2
    //   873: aconst_null
    //   874: astore_3
    //   875: aload_1
    //   876: astore 4
    //   878: aconst_null
    //   879: astore_1
    //   880: goto -605 -> 275
    //   883: astore 9
    //   885: aconst_null
    //   886: astore 8
    //   888: aconst_null
    //   889: astore_1
    //   890: aload_2
    //   891: astore 4
    //   893: aconst_null
    //   894: astore_3
    //   895: aload 9
    //   897: astore_2
    //   898: goto -623 -> 275
    //   901: astore 9
    //   903: aconst_null
    //   904: astore 8
    //   906: aconst_null
    //   907: astore_3
    //   908: aload_2
    //   909: astore 4
    //   911: aconst_null
    //   912: astore_1
    //   913: aload 9
    //   915: astore_2
    //   916: goto -641 -> 275
    //   919: astore_2
    //   920: aconst_null
    //   921: astore_3
    //   922: aconst_null
    //   923: astore 9
    //   925: aload_1
    //   926: astore 4
    //   928: aconst_null
    //   929: astore 8
    //   931: aload 9
    //   933: astore_1
    //   934: goto -659 -> 275
    //   937: astore_2
    //   938: aconst_null
    //   939: astore_3
    //   940: aconst_null
    //   941: astore_1
    //   942: goto -667 -> 275
    //   945: astore_2
    //   946: aconst_null
    //   947: astore_1
    //   948: goto -673 -> 275
    //   951: astore_2
    //   952: aload_1
    //   953: astore_2
    //   954: goto -448 -> 506
    //   957: astore_3
    //   958: goto -509 -> 449
    //   961: aconst_null
    //   962: astore 8
    //   964: goto -810 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	this	AEMaterialParser
    //   0	967	1	paramContext	Context
    //   0	967	2	paramString1	String
    //   0	967	3	paramString2	String
    //   0	967	4	paramDecryptListener	DecryptListener
    //   19	477	5	i	int
    //   1	464	6	j	int
    //   4	378	7	k	int
    //   7	956	8	localObject1	Object
    //   25	503	9	localObject2	Object
    //   753	10	9	localObject3	Object
    //   781	8	9	localObject4	Object
    //   794	10	9	localObject5	Object
    //   819	22	9	localObject6	Object
    //   883	13	9	localException1	java.lang.Exception
    //   901	13	9	localException2	java.lang.Exception
    //   923	9	9	localObject7	Object
    //   96	742	10	localObject8	Object
    //   208	627	11	str1	String
    //   205	626	12	localObject9	Object
    //   243	23	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   217	225	274	java/lang/Exception
    //   239	245	274	java/lang/Exception
    //   264	271	274	java/lang/Exception
    //   529	534	274	java/lang/Exception
    //   404	413	446	java/io/IOException
    //   418	426	446	java/io/IOException
    //   449	459	505	java/io/IOException
    //   473	481	505	java/io/IOException
    //   538	542	574	java/io/IOException
    //   546	550	574	java/io/IOException
    //   555	560	574	java/io/IOException
    //   567	572	574	java/io/IOException
    //   596	604	639	java/io/IOException
    //   608	616	639	java/io/IOException
    //   621	626	639	java/io/IOException
    //   631	636	639	java/io/IOException
    //   308	312	658	java/io/IOException
    //   316	320	658	java/io/IOException
    //   325	330	658	java/io/IOException
    //   335	340	658	java/io/IOException
    //   78	112	677	finally
    //   112	128	677	finally
    //   128	151	677	finally
    //   350	376	677	finally
    //   404	413	677	finally
    //   418	426	677	finally
    //   689	693	723	java/io/IOException
    //   697	701	723	java/io/IOException
    //   706	711	723	java/io/IOException
    //   716	721	723	java/io/IOException
    //   159	168	742	finally
    //   168	173	753	finally
    //   426	430	768	finally
    //   449	459	779	finally
    //   473	481	779	finally
    //   481	485	794	finally
    //   181	191	809	finally
    //   191	203	817	finally
    //   217	225	829	finally
    //   239	245	829	finally
    //   264	271	829	finally
    //   289	304	829	finally
    //   529	534	829	finally
    //   78	112	847	java/lang/Exception
    //   112	128	847	java/lang/Exception
    //   128	151	847	java/lang/Exception
    //   350	376	847	java/lang/Exception
    //   404	413	847	java/lang/Exception
    //   418	426	847	java/lang/Exception
    //   159	168	861	java/lang/Exception
    //   168	173	872	java/lang/Exception
    //   426	430	883	java/lang/Exception
    //   449	459	901	java/lang/Exception
    //   473	481	901	java/lang/Exception
    //   481	485	919	java/lang/Exception
    //   181	191	937	java/lang/Exception
    //   191	203	945	java/lang/Exception
    //   481	485	951	java/io/IOException
    //   426	430	957	java/io/IOException
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