package com.tencent.ttpic.videoshelf.parser;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import java.io.File;

public class TemplateParser
{
  private static final String CONFIG_FILENAME = "params.json";
  private static final String CONFIG_FILENAME_ENCRYPTED = "params.dat";
  private static final String TAG = TemplateParser.class.getSimpleName();
  
  public static VideoShelfTemplate parse(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("video template path is not valid");
    }
    Object localObject = new File(paramString, "params.json");
    File localFile = new File(paramString, "params.dat");
    if (((File)localObject).exists()) {
      localObject = ((File)localObject).getName();
    }
    for (;;)
    {
      paramContext = readFileString(paramContext, paramString, (String)localObject);
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      throw new IllegalArgumentException("video template json is not valid");
      if (localFile.exists()) {
        localObject = localFile.getName();
      } else {
        localObject = "params.dat";
      }
    }
    localObject = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    try
    {
      paramContext = (VideoShelfTemplate)((Gson)localObject).fromJson(paramContext, VideoShelfTemplate.class);
      if (paramContext != null)
      {
        paramContext.setFromAssets(paramString.startsWith("assets://"));
        paramContext.setMaterialPath(paramString);
      }
      return paramContext;
    }
    catch (JsonSyntaxException paramContext)
    {
      for (;;)
      {
        ReportUtil.report("Video template parse error!" + paramContext);
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  /* Error */
  private static String readFileString(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_2
    //   10: ldc 124
    //   12: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +348 -> 363
    //   18: aload_2
    //   19: ldc 129
    //   21: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   24: ifne +339 -> 363
    //   27: iconst_1
    //   28: istore_3
    //   29: aload_1
    //   30: invokestatic 135	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore 6
    //   35: new 97	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   42: aload 6
    //   44: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 137
    //   49: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_1
    //   60: new 97	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   67: aload 6
    //   69: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 137
    //   74: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_2
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 6
    //   86: new 45	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 8
    //   96: new 45	java/io/File
    //   99: dup
    //   100: aload 6
    //   102: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore 9
    //   107: aload 8
    //   109: invokevirtual 52	java/io/File:exists	()Z
    //   112: ifeq +11 -> 123
    //   115: aload 8
    //   117: invokevirtual 141	java/io/File:isFile	()Z
    //   120: ifne +19 -> 139
    //   123: aload 9
    //   125: invokevirtual 52	java/io/File:exists	()Z
    //   128: ifeq +301 -> 429
    //   131: aload 9
    //   133: invokevirtual 141	java/io/File:isFile	()Z
    //   136: ifeq +293 -> 429
    //   139: aload 8
    //   141: invokevirtual 52	java/io/File:exists	()Z
    //   144: ifeq +224 -> 368
    //   147: aload 8
    //   149: invokevirtual 141	java/io/File:isFile	()Z
    //   152: ifeq +216 -> 368
    //   155: new 143	java/io/FileInputStream
    //   158: dup
    //   159: aload 8
    //   161: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   164: astore_0
    //   165: aload_0
    //   166: astore 7
    //   168: iload_3
    //   169: ifne +253 -> 422
    //   172: aload_2
    //   173: ldc 129
    //   175: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   178: ifeq +234 -> 412
    //   181: aload 7
    //   183: iconst_1
    //   184: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   187: astore_0
    //   188: aload 7
    //   190: invokestatic 158	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   193: aload_0
    //   194: astore 6
    //   196: aload 6
    //   198: ifnull +411 -> 609
    //   201: new 160	java/io/InputStreamReader
    //   204: dup
    //   205: aload 6
    //   207: invokespecial 162	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   210: astore_2
    //   211: new 164	java/io/BufferedReader
    //   214: dup
    //   215: aload_2
    //   216: sipush 1024
    //   219: invokespecial 167	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   222: astore_0
    //   223: aload 7
    //   225: astore 11
    //   227: aload_2
    //   228: astore 10
    //   230: aload_0
    //   231: astore 9
    //   233: aload 6
    //   235: astore 8
    //   237: new 97	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   244: astore 12
    //   246: aload 7
    //   248: astore 11
    //   250: aload_2
    //   251: astore 10
    //   253: aload_0
    //   254: astore 9
    //   256: aload 6
    //   258: astore 8
    //   260: aload_0
    //   261: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +265 -> 531
    //   269: aload 7
    //   271: astore 11
    //   273: aload_2
    //   274: astore 10
    //   276: aload_0
    //   277: astore 9
    //   279: aload 6
    //   281: astore 8
    //   283: aload 12
    //   285: aload_1
    //   286: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: goto -44 -> 246
    //   293: astore_1
    //   294: aload 7
    //   296: astore 11
    //   298: aload_2
    //   299: astore 10
    //   301: aload_0
    //   302: astore 9
    //   304: aload 6
    //   306: astore 8
    //   308: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   311: aload_1
    //   312: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   315: aload_1
    //   316: iconst_0
    //   317: anewarray 4	java/lang/Object
    //   320: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   323: aload_0
    //   324: ifnull +7 -> 331
    //   327: aload_0
    //   328: invokevirtual 182	java/io/BufferedReader:close	()V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 183	java/io/InputStreamReader:close	()V
    //   339: aload 6
    //   341: ifnull +8 -> 349
    //   344: aload 6
    //   346: invokevirtual 186	java/io/InputStream:close	()V
    //   349: aload 7
    //   351: ifnull +8 -> 359
    //   354: aload 7
    //   356: invokevirtual 187	java/io/FileInputStream:close	()V
    //   359: aconst_null
    //   360: astore_0
    //   361: aload_0
    //   362: areturn
    //   363: iconst_0
    //   364: istore_3
    //   365: goto -336 -> 29
    //   368: aload 9
    //   370: invokevirtual 52	java/io/File:exists	()Z
    //   373: ifeq +605 -> 978
    //   376: aload 9
    //   378: invokevirtual 141	java/io/File:isFile	()Z
    //   381: ifeq +597 -> 978
    //   384: new 143	java/io/FileInputStream
    //   387: dup
    //   388: aload 9
    //   390: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   393: astore_0
    //   394: iload_3
    //   395: ifne +12 -> 407
    //   398: iload 5
    //   400: istore_3
    //   401: aload_0
    //   402: astore 7
    //   404: goto -236 -> 168
    //   407: iconst_0
    //   408: istore_3
    //   409: goto -8 -> 401
    //   412: aload 7
    //   414: iconst_0
    //   415: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   418: astore_0
    //   419: goto -231 -> 188
    //   422: aload 7
    //   424: astore 6
    //   426: goto -230 -> 196
    //   429: aload_0
    //   430: invokevirtual 193	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   433: aload_1
    //   434: invokevirtual 199	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   437: astore_2
    //   438: iload_3
    //   439: ifne +24 -> 463
    //   442: aload_2
    //   443: iconst_1
    //   444: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   447: astore_1
    //   448: aload_2
    //   449: invokestatic 158	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   452: aload_1
    //   453: astore_0
    //   454: aconst_null
    //   455: astore 7
    //   457: aload_0
    //   458: astore 6
    //   460: goto -264 -> 196
    //   463: aload_2
    //   464: astore_0
    //   465: goto -11 -> 454
    //   468: astore_1
    //   469: aconst_null
    //   470: astore_1
    //   471: aload_0
    //   472: invokevirtual 193	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   475: aload 6
    //   477: invokevirtual 199	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   480: astore_2
    //   481: iload_3
    //   482: ifne +29 -> 511
    //   485: iload 4
    //   487: istore_3
    //   488: iload_3
    //   489: ifne +27 -> 516
    //   492: aload_2
    //   493: iconst_1
    //   494: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   497: astore_0
    //   498: aload_2
    //   499: invokestatic 158	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   502: aconst_null
    //   503: astore 7
    //   505: aload_0
    //   506: astore 6
    //   508: goto -312 -> 196
    //   511: iconst_0
    //   512: istore_3
    //   513: goto -25 -> 488
    //   516: aload_2
    //   517: astore_0
    //   518: goto -16 -> 502
    //   521: astore_0
    //   522: aconst_null
    //   523: astore 7
    //   525: aload_1
    //   526: astore 6
    //   528: goto -332 -> 196
    //   531: aload 7
    //   533: astore 11
    //   535: aload_2
    //   536: astore 10
    //   538: aload_0
    //   539: astore 9
    //   541: aload 6
    //   543: astore 8
    //   545: aload 12
    //   547: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: astore_1
    //   551: aload_0
    //   552: ifnull +7 -> 559
    //   555: aload_0
    //   556: invokevirtual 182	java/io/BufferedReader:close	()V
    //   559: aload_2
    //   560: ifnull +7 -> 567
    //   563: aload_2
    //   564: invokevirtual 183	java/io/InputStreamReader:close	()V
    //   567: aload 6
    //   569: ifnull +8 -> 577
    //   572: aload 6
    //   574: invokevirtual 186	java/io/InputStream:close	()V
    //   577: aload_1
    //   578: astore_0
    //   579: aload 7
    //   581: ifnull -220 -> 361
    //   584: aload 7
    //   586: invokevirtual 187	java/io/FileInputStream:close	()V
    //   589: aload_1
    //   590: areturn
    //   591: astore_0
    //   592: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   595: aload_0
    //   596: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   599: aload_0
    //   600: iconst_0
    //   601: anewarray 4	java/lang/Object
    //   604: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   607: aload_1
    //   608: areturn
    //   609: iconst_0
    //   610: ifeq +11 -> 621
    //   613: new 202	java/lang/NullPointerException
    //   616: dup
    //   617: invokespecial 203	java/lang/NullPointerException:<init>	()V
    //   620: athrow
    //   621: iconst_0
    //   622: ifeq +11 -> 633
    //   625: new 202	java/lang/NullPointerException
    //   628: dup
    //   629: invokespecial 203	java/lang/NullPointerException:<init>	()V
    //   632: athrow
    //   633: aload 6
    //   635: ifnull +8 -> 643
    //   638: aload 6
    //   640: invokevirtual 186	java/io/InputStream:close	()V
    //   643: aload 7
    //   645: ifnull -286 -> 359
    //   648: aload 7
    //   650: invokevirtual 187	java/io/FileInputStream:close	()V
    //   653: goto -294 -> 359
    //   656: astore_0
    //   657: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   660: aload_0
    //   661: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   664: aload_0
    //   665: iconst_0
    //   666: anewarray 4	java/lang/Object
    //   669: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   672: goto -313 -> 359
    //   675: astore_0
    //   676: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   679: aload_0
    //   680: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   683: aload_0
    //   684: iconst_0
    //   685: anewarray 4	java/lang/Object
    //   688: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   691: goto -332 -> 359
    //   694: astore_0
    //   695: aconst_null
    //   696: astore_1
    //   697: aconst_null
    //   698: astore_2
    //   699: aconst_null
    //   700: astore 6
    //   702: aload_2
    //   703: ifnull +7 -> 710
    //   706: aload_2
    //   707: invokevirtual 182	java/io/BufferedReader:close	()V
    //   710: aload_1
    //   711: ifnull +7 -> 718
    //   714: aload_1
    //   715: invokevirtual 183	java/io/InputStreamReader:close	()V
    //   718: aload 6
    //   720: ifnull +8 -> 728
    //   723: aload 6
    //   725: invokevirtual 186	java/io/InputStream:close	()V
    //   728: aload 7
    //   730: ifnull +8 -> 738
    //   733: aload 7
    //   735: invokevirtual 187	java/io/FileInputStream:close	()V
    //   738: aload_0
    //   739: athrow
    //   740: astore_1
    //   741: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   744: aload_1
    //   745: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   748: aload_1
    //   749: iconst_0
    //   750: anewarray 4	java/lang/Object
    //   753: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   756: goto -18 -> 738
    //   759: astore_0
    //   760: aconst_null
    //   761: astore_1
    //   762: aconst_null
    //   763: astore_2
    //   764: aconst_null
    //   765: astore 6
    //   767: goto -65 -> 702
    //   770: astore 8
    //   772: aconst_null
    //   773: astore_1
    //   774: aload_0
    //   775: astore 6
    //   777: aconst_null
    //   778: astore_2
    //   779: aload 8
    //   781: astore_0
    //   782: goto -80 -> 702
    //   785: astore_0
    //   786: aconst_null
    //   787: astore_2
    //   788: aload_1
    //   789: astore 6
    //   791: aconst_null
    //   792: astore_1
    //   793: goto -91 -> 702
    //   796: astore_0
    //   797: aconst_null
    //   798: astore 8
    //   800: aload_1
    //   801: astore 6
    //   803: aconst_null
    //   804: astore_2
    //   805: aload 8
    //   807: astore_1
    //   808: goto -106 -> 702
    //   811: astore 8
    //   813: aconst_null
    //   814: astore_1
    //   815: aconst_null
    //   816: astore_2
    //   817: aload_0
    //   818: astore 6
    //   820: aload 8
    //   822: astore_0
    //   823: goto -121 -> 702
    //   826: astore_0
    //   827: aconst_null
    //   828: astore_1
    //   829: aconst_null
    //   830: astore_2
    //   831: goto -129 -> 702
    //   834: astore_0
    //   835: aconst_null
    //   836: astore 8
    //   838: aload_2
    //   839: astore_1
    //   840: aload 8
    //   842: astore_2
    //   843: goto -141 -> 702
    //   846: astore_0
    //   847: aload 11
    //   849: astore 7
    //   851: aload 10
    //   853: astore_1
    //   854: aload 9
    //   856: astore_2
    //   857: aload 8
    //   859: astore 6
    //   861: goto -159 -> 702
    //   864: astore_1
    //   865: aconst_null
    //   866: astore 7
    //   868: aconst_null
    //   869: astore_2
    //   870: aconst_null
    //   871: astore_0
    //   872: aconst_null
    //   873: astore 6
    //   875: goto -581 -> 294
    //   878: astore_1
    //   879: aconst_null
    //   880: astore_2
    //   881: aconst_null
    //   882: astore_0
    //   883: aconst_null
    //   884: astore 6
    //   886: goto -592 -> 294
    //   889: astore_1
    //   890: aconst_null
    //   891: astore_2
    //   892: aload_0
    //   893: astore 6
    //   895: aconst_null
    //   896: astore_0
    //   897: goto -603 -> 294
    //   900: astore 8
    //   902: aconst_null
    //   903: astore 7
    //   905: aconst_null
    //   906: astore_0
    //   907: aload_1
    //   908: astore 6
    //   910: aconst_null
    //   911: astore_2
    //   912: aload 8
    //   914: astore_1
    //   915: goto -621 -> 294
    //   918: astore 8
    //   920: aconst_null
    //   921: astore 7
    //   923: aconst_null
    //   924: astore_2
    //   925: aload_1
    //   926: astore 6
    //   928: aconst_null
    //   929: astore_0
    //   930: aload 8
    //   932: astore_1
    //   933: goto -639 -> 294
    //   936: astore_1
    //   937: aconst_null
    //   938: astore_2
    //   939: aconst_null
    //   940: astore 8
    //   942: aload_0
    //   943: astore 6
    //   945: aconst_null
    //   946: astore 7
    //   948: aload 8
    //   950: astore_0
    //   951: goto -657 -> 294
    //   954: astore_1
    //   955: aconst_null
    //   956: astore_2
    //   957: aconst_null
    //   958: astore_0
    //   959: goto -665 -> 294
    //   962: astore_1
    //   963: aconst_null
    //   964: astore_0
    //   965: goto -671 -> 294
    //   968: astore_1
    //   969: aload_0
    //   970: astore_1
    //   971: goto -449 -> 522
    //   974: astore_2
    //   975: goto -504 -> 471
    //   978: aconst_null
    //   979: astore 7
    //   981: goto -813 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramContext	Context
    //   0	984	1	paramString1	String
    //   0	984	2	paramString2	String
    //   28	485	3	i	int
    //   4	482	4	j	int
    //   7	392	5	k	int
    //   33	911	6	localObject1	Object
    //   1	979	7	localObject2	Object
    //   94	450	8	localObject3	Object
    //   770	10	8	localObject4	Object
    //   798	8	8	localObject5	Object
    //   811	10	8	localObject6	Object
    //   836	22	8	localObject7	Object
    //   900	13	8	localException1	java.lang.Exception
    //   918	13	8	localException2	java.lang.Exception
    //   940	9	8	localObject8	Object
    //   105	750	9	localObject9	Object
    //   228	624	10	str	String
    //   225	623	11	localObject10	Object
    //   244	302	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   237	246	293	java/lang/Exception
    //   260	265	293	java/lang/Exception
    //   283	290	293	java/lang/Exception
    //   545	551	293	java/lang/Exception
    //   429	438	468	java/io/IOException
    //   442	448	468	java/io/IOException
    //   471	481	521	java/io/IOException
    //   492	498	521	java/io/IOException
    //   555	559	591	java/io/IOException
    //   563	567	591	java/io/IOException
    //   572	577	591	java/io/IOException
    //   584	589	591	java/io/IOException
    //   613	621	656	java/io/IOException
    //   625	633	656	java/io/IOException
    //   638	643	656	java/io/IOException
    //   648	653	656	java/io/IOException
    //   327	331	675	java/io/IOException
    //   335	339	675	java/io/IOException
    //   344	349	675	java/io/IOException
    //   354	359	675	java/io/IOException
    //   86	123	694	finally
    //   123	139	694	finally
    //   139	165	694	finally
    //   368	394	694	finally
    //   429	438	694	finally
    //   442	448	694	finally
    //   706	710	740	java/io/IOException
    //   714	718	740	java/io/IOException
    //   723	728	740	java/io/IOException
    //   733	738	740	java/io/IOException
    //   172	188	759	finally
    //   412	419	759	finally
    //   188	193	770	finally
    //   448	452	785	finally
    //   471	481	796	finally
    //   492	498	796	finally
    //   498	502	811	finally
    //   201	211	826	finally
    //   211	223	834	finally
    //   237	246	846	finally
    //   260	265	846	finally
    //   283	290	846	finally
    //   308	323	846	finally
    //   545	551	846	finally
    //   86	123	864	java/lang/Exception
    //   123	139	864	java/lang/Exception
    //   139	165	864	java/lang/Exception
    //   368	394	864	java/lang/Exception
    //   429	438	864	java/lang/Exception
    //   442	448	864	java/lang/Exception
    //   172	188	878	java/lang/Exception
    //   412	419	878	java/lang/Exception
    //   188	193	889	java/lang/Exception
    //   448	452	900	java/lang/Exception
    //   471	481	918	java/lang/Exception
    //   492	498	918	java/lang/Exception
    //   498	502	936	java/lang/Exception
    //   201	211	954	java/lang/Exception
    //   211	223	962	java/lang/Exception
    //   498	502	968	java/io/IOException
    //   448	452	974	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.parser.TemplateParser
 * JD-Core Version:    0.7.0.1
 */