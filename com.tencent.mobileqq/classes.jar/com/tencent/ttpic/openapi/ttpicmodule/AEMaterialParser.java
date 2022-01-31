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
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_3
    //   10: ldc 73
    //   12: invokevirtual 79	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +332 -> 347
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
    //   86: astore 10
    //   88: new 99	java/io/File
    //   91: dup
    //   92: aload 9
    //   94: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_3
    //   98: aload 10
    //   100: invokevirtual 106	java/io/File:exists	()Z
    //   103: ifeq +11 -> 114
    //   106: aload 10
    //   108: invokevirtual 109	java/io/File:isFile	()Z
    //   111: ifne +17 -> 128
    //   114: aload_3
    //   115: invokevirtual 106	java/io/File:exists	()Z
    //   118: ifeq +286 -> 404
    //   121: aload_3
    //   122: invokevirtual 109	java/io/File:isFile	()Z
    //   125: ifeq +279 -> 404
    //   128: aload 10
    //   130: invokevirtual 106	java/io/File:exists	()Z
    //   133: ifeq +220 -> 353
    //   136: aload 10
    //   138: invokevirtual 109	java/io/File:isFile	()Z
    //   141: ifeq +212 -> 353
    //   144: new 111	java/io/FileInputStream
    //   147: dup
    //   148: aload 10
    //   150: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore_1
    //   154: aload_1
    //   155: astore 8
    //   157: iload 5
    //   159: ifne +238 -> 397
    //   162: aload_0
    //   163: aload 8
    //   165: aload 4
    //   167: invokespecial 116	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   170: astore_1
    //   171: aload 8
    //   173: invokestatic 120	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   176: aload_1
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +411 -> 592
    //   184: new 122	java/io/InputStreamReader
    //   187: dup
    //   188: aload 4
    //   190: invokespecial 124	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   193: astore_3
    //   194: new 126	java/io/BufferedReader
    //   197: dup
    //   198: aload_3
    //   199: sipush 1024
    //   202: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   205: astore_1
    //   206: aload 8
    //   208: astore 12
    //   210: aload_3
    //   211: astore 11
    //   213: aload_1
    //   214: astore 10
    //   216: aload 4
    //   218: astore 9
    //   220: new 87	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   227: astore_2
    //   228: aload 8
    //   230: astore 12
    //   232: aload_3
    //   233: astore 11
    //   235: aload_1
    //   236: astore 10
    //   238: aload 4
    //   240: astore 9
    //   242: aload_1
    //   243: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   246: astore 13
    //   248: aload 13
    //   250: ifnull +265 -> 515
    //   253: aload 8
    //   255: astore 12
    //   257: aload_3
    //   258: astore 11
    //   260: aload_1
    //   261: astore 10
    //   263: aload 4
    //   265: astore 9
    //   267: aload_2
    //   268: aload 13
    //   270: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: goto -46 -> 228
    //   277: astore_2
    //   278: aload 8
    //   280: astore 12
    //   282: aload_3
    //   283: astore 11
    //   285: aload_1
    //   286: astore 10
    //   288: aload 4
    //   290: astore 9
    //   292: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   295: aload_2
    //   296: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   299: aload_2
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   307: aload_1
    //   308: ifnull +7 -> 315
    //   311: aload_1
    //   312: invokevirtual 144	java/io/BufferedReader:close	()V
    //   315: aload_3
    //   316: ifnull +7 -> 323
    //   319: aload_3
    //   320: invokevirtual 145	java/io/InputStreamReader:close	()V
    //   323: aload 4
    //   325: ifnull +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 148	java/io/InputStream:close	()V
    //   333: aload 8
    //   335: ifnull +8 -> 343
    //   338: aload 8
    //   340: invokevirtual 149	java/io/FileInputStream:close	()V
    //   343: aconst_null
    //   344: astore_1
    //   345: aload_1
    //   346: areturn
    //   347: iconst_0
    //   348: istore 5
    //   350: goto -329 -> 21
    //   353: aload_3
    //   354: invokevirtual 106	java/io/File:exists	()Z
    //   357: ifeq +604 -> 961
    //   360: aload_3
    //   361: invokevirtual 109	java/io/File:isFile	()Z
    //   364: ifeq +597 -> 961
    //   367: new 111	java/io/FileInputStream
    //   370: dup
    //   371: aload_3
    //   372: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   375: astore_1
    //   376: iload 5
    //   378: ifne +13 -> 391
    //   381: iload 6
    //   383: istore 5
    //   385: aload_1
    //   386: astore 8
    //   388: goto -231 -> 157
    //   391: iconst_0
    //   392: istore 5
    //   394: goto -9 -> 385
    //   397: aload 8
    //   399: astore 4
    //   401: goto -222 -> 179
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
    //   438: goto -259 -> 179
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
    //   464: iload 7
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
    //   491: goto -312 -> 179
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
    //   512: goto -333 -> 179
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
    //   564: ifnull -219 -> 345
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
    //   628: ifnull -285 -> 343
    //   631: aload 8
    //   633: invokevirtual 149	java/io/FileInputStream:close	()V
    //   636: goto -293 -> 343
    //   639: astore_1
    //   640: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   643: aload_1
    //   644: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   647: aload_1
    //   648: iconst_0
    //   649: anewarray 4	java/lang/Object
    //   652: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   655: goto -312 -> 343
    //   658: astore_1
    //   659: getstatic 26	com/tencent/ttpic/openapi/ttpicmodule/AEMaterialParser:TAG	Ljava/lang/String;
    //   662: aload_1
    //   663: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   666: aload_1
    //   667: iconst_0
    //   668: anewarray 4	java/lang/Object
    //   671: invokestatic 141	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   674: goto -331 -> 343
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
    //   858: goto -580 -> 278
    //   861: astore_2
    //   862: aconst_null
    //   863: astore_3
    //   864: aconst_null
    //   865: astore_1
    //   866: aconst_null
    //   867: astore 4
    //   869: goto -591 -> 278
    //   872: astore_2
    //   873: aconst_null
    //   874: astore_3
    //   875: aload_1
    //   876: astore 4
    //   878: aconst_null
    //   879: astore_1
    //   880: goto -602 -> 278
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
    //   898: goto -620 -> 278
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
    //   916: goto -638 -> 278
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
    //   934: goto -656 -> 278
    //   937: astore_2
    //   938: aconst_null
    //   939: astore_3
    //   940: aconst_null
    //   941: astore_1
    //   942: goto -664 -> 278
    //   945: astore_2
    //   946: aconst_null
    //   947: astore_1
    //   948: goto -670 -> 278
    //   951: astore_2
    //   952: aload_1
    //   953: astore_2
    //   954: goto -448 -> 506
    //   957: astore_3
    //   958: goto -509 -> 449
    //   961: aconst_null
    //   962: astore 8
    //   964: goto -807 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	967	0	this	AEMaterialParser
    //   0	967	1	paramContext	Context
    //   0	967	2	paramString1	String
    //   0	967	3	paramString2	String
    //   0	967	4	paramDecryptListener	DecryptListener
    //   19	477	5	i	int
    //   4	378	6	j	int
    //   1	464	7	k	int
    //   7	956	8	localObject1	Object
    //   25	503	9	localObject2	Object
    //   753	10	9	localObject3	Object
    //   781	8	9	localObject4	Object
    //   794	10	9	localObject5	Object
    //   819	22	9	localObject6	Object
    //   883	13	9	localException1	java.lang.Exception
    //   901	13	9	localException2	java.lang.Exception
    //   923	9	9	localObject7	Object
    //   86	752	10	localObject8	Object
    //   211	624	11	str1	String
    //   208	623	12	localObject9	Object
    //   246	23	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   220	228	277	java/lang/Exception
    //   242	248	277	java/lang/Exception
    //   267	274	277	java/lang/Exception
    //   529	534	277	java/lang/Exception
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
    //   311	315	658	java/io/IOException
    //   319	323	658	java/io/IOException
    //   328	333	658	java/io/IOException
    //   338	343	658	java/io/IOException
    //   78	114	677	finally
    //   114	128	677	finally
    //   128	154	677	finally
    //   353	376	677	finally
    //   404	413	677	finally
    //   418	426	677	finally
    //   689	693	723	java/io/IOException
    //   697	701	723	java/io/IOException
    //   706	711	723	java/io/IOException
    //   716	721	723	java/io/IOException
    //   162	171	742	finally
    //   171	176	753	finally
    //   426	430	768	finally
    //   449	459	779	finally
    //   473	481	779	finally
    //   481	485	794	finally
    //   184	194	809	finally
    //   194	206	817	finally
    //   220	228	829	finally
    //   242	248	829	finally
    //   267	274	829	finally
    //   292	307	829	finally
    //   529	534	829	finally
    //   78	114	847	java/lang/Exception
    //   114	128	847	java/lang/Exception
    //   128	154	847	java/lang/Exception
    //   353	376	847	java/lang/Exception
    //   404	413	847	java/lang/Exception
    //   418	426	847	java/lang/Exception
    //   162	171	861	java/lang/Exception
    //   171	176	872	java/lang/Exception
    //   426	430	883	java/lang/Exception
    //   449	459	901	java/lang/Exception
    //   473	481	901	java/lang/Exception
    //   481	485	919	java/lang/Exception
    //   184	194	937	java/lang/Exception
    //   194	206	945	java/lang/Exception
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