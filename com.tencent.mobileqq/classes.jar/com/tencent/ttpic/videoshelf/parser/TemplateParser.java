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
    //   15: ifne +349 -> 364
    //   18: aload_2
    //   19: ldc 129
    //   21: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   24: ifne +340 -> 364
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
    //   128: ifeq +302 -> 430
    //   131: aload 9
    //   133: invokevirtual 141	java/io/File:isFile	()Z
    //   136: ifeq +294 -> 430
    //   139: aload 8
    //   141: invokevirtual 52	java/io/File:exists	()Z
    //   144: ifeq +225 -> 369
    //   147: aload 8
    //   149: invokevirtual 141	java/io/File:isFile	()Z
    //   152: ifeq +217 -> 369
    //   155: new 143	java/io/FileInputStream
    //   158: dup
    //   159: aload 8
    //   161: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   164: astore_0
    //   165: aload_0
    //   166: astore 7
    //   168: iload_3
    //   169: ifne +254 -> 423
    //   172: aload_2
    //   173: ldc 129
    //   175: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   178: ifeq +235 -> 413
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
    //   244: astore_1
    //   245: aload 7
    //   247: astore 11
    //   249: aload_2
    //   250: astore 10
    //   252: aload_0
    //   253: astore 9
    //   255: aload 6
    //   257: astore 8
    //   259: aload_0
    //   260: invokevirtual 170	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   263: astore 12
    //   265: aload 12
    //   267: ifnull +265 -> 532
    //   270: aload 7
    //   272: astore 11
    //   274: aload_2
    //   275: astore 10
    //   277: aload_0
    //   278: astore 9
    //   280: aload 6
    //   282: astore 8
    //   284: aload_1
    //   285: aload 12
    //   287: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: goto -46 -> 245
    //   294: astore_1
    //   295: aload 7
    //   297: astore 11
    //   299: aload_2
    //   300: astore 10
    //   302: aload_0
    //   303: astore 9
    //   305: aload 6
    //   307: astore 8
    //   309: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   312: aload_1
    //   313: invokevirtual 173	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: aload_1
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 182	java/io/BufferedReader:close	()V
    //   332: aload_2
    //   333: ifnull +7 -> 340
    //   336: aload_2
    //   337: invokevirtual 183	java/io/InputStreamReader:close	()V
    //   340: aload 6
    //   342: ifnull +8 -> 350
    //   345: aload 6
    //   347: invokevirtual 186	java/io/InputStream:close	()V
    //   350: aload 7
    //   352: ifnull +8 -> 360
    //   355: aload 7
    //   357: invokevirtual 187	java/io/FileInputStream:close	()V
    //   360: aconst_null
    //   361: astore_0
    //   362: aload_0
    //   363: areturn
    //   364: iconst_0
    //   365: istore_3
    //   366: goto -337 -> 29
    //   369: aload 9
    //   371: invokevirtual 52	java/io/File:exists	()Z
    //   374: ifeq +606 -> 980
    //   377: aload 9
    //   379: invokevirtual 141	java/io/File:isFile	()Z
    //   382: ifeq +598 -> 980
    //   385: new 143	java/io/FileInputStream
    //   388: dup
    //   389: aload 9
    //   391: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   394: astore_0
    //   395: iload_3
    //   396: ifne +12 -> 408
    //   399: iload 5
    //   401: istore_3
    //   402: aload_0
    //   403: astore 7
    //   405: goto -237 -> 168
    //   408: iconst_0
    //   409: istore_3
    //   410: goto -8 -> 402
    //   413: aload 7
    //   415: iconst_0
    //   416: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   419: astore_0
    //   420: goto -232 -> 188
    //   423: aload 7
    //   425: astore 6
    //   427: goto -231 -> 196
    //   430: aload_0
    //   431: invokevirtual 193	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   434: aload_1
    //   435: invokevirtual 199	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   438: astore_2
    //   439: iload_3
    //   440: ifne +24 -> 464
    //   443: aload_2
    //   444: iconst_1
    //   445: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   448: astore_1
    //   449: aload_2
    //   450: invokestatic 158	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   453: aload_1
    //   454: astore_0
    //   455: aconst_null
    //   456: astore 7
    //   458: aload_0
    //   459: astore 6
    //   461: goto -265 -> 196
    //   464: aload_2
    //   465: astore_0
    //   466: goto -11 -> 455
    //   469: astore_1
    //   470: aconst_null
    //   471: astore_1
    //   472: aload_0
    //   473: invokevirtual 193	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   476: aload 6
    //   478: invokevirtual 199	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   481: astore_2
    //   482: iload_3
    //   483: ifne +29 -> 512
    //   486: iload 4
    //   488: istore_3
    //   489: iload_3
    //   490: ifne +27 -> 517
    //   493: aload_2
    //   494: iconst_1
    //   495: invokestatic 152	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   498: astore_0
    //   499: aload_2
    //   500: invokestatic 158	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   503: aconst_null
    //   504: astore 7
    //   506: aload_0
    //   507: astore 6
    //   509: goto -313 -> 196
    //   512: iconst_0
    //   513: istore_3
    //   514: goto -25 -> 489
    //   517: aload_2
    //   518: astore_0
    //   519: goto -16 -> 503
    //   522: astore_0
    //   523: aconst_null
    //   524: astore 7
    //   526: aload_1
    //   527: astore 6
    //   529: goto -333 -> 196
    //   532: aload 7
    //   534: astore 11
    //   536: aload_2
    //   537: astore 10
    //   539: aload_0
    //   540: astore 9
    //   542: aload 6
    //   544: astore 8
    //   546: aload_1
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
    //   581: ifnull -219 -> 362
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
    //   645: ifnull -285 -> 360
    //   648: aload 7
    //   650: invokevirtual 187	java/io/FileInputStream:close	()V
    //   653: goto -293 -> 360
    //   656: astore_0
    //   657: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   660: aload_0
    //   661: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   664: aload_0
    //   665: iconst_0
    //   666: anewarray 4	java/lang/Object
    //   669: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   672: goto -312 -> 360
    //   675: astore_0
    //   676: getstatic 22	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   679: aload_0
    //   680: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   683: aload_0
    //   684: iconst_0
    //   685: anewarray 4	java/lang/Object
    //   688: invokestatic 179	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   691: goto -331 -> 360
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
    //   798: astore_2
    //   799: aload_1
    //   800: astore 6
    //   802: aconst_null
    //   803: astore 8
    //   805: aload_2
    //   806: astore_1
    //   807: aload 8
    //   809: astore_2
    //   810: goto -108 -> 702
    //   813: astore 8
    //   815: aconst_null
    //   816: astore_1
    //   817: aconst_null
    //   818: astore_2
    //   819: aload_0
    //   820: astore 6
    //   822: aload 8
    //   824: astore_0
    //   825: goto -123 -> 702
    //   828: astore_0
    //   829: aconst_null
    //   830: astore_1
    //   831: aconst_null
    //   832: astore_2
    //   833: goto -131 -> 702
    //   836: astore_0
    //   837: aconst_null
    //   838: astore 8
    //   840: aload_2
    //   841: astore_1
    //   842: aload 8
    //   844: astore_2
    //   845: goto -143 -> 702
    //   848: astore_0
    //   849: aload 11
    //   851: astore 7
    //   853: aload 10
    //   855: astore_1
    //   856: aload 9
    //   858: astore_2
    //   859: aload 8
    //   861: astore 6
    //   863: goto -161 -> 702
    //   866: astore_1
    //   867: aconst_null
    //   868: astore 7
    //   870: aconst_null
    //   871: astore_2
    //   872: aconst_null
    //   873: astore_0
    //   874: aconst_null
    //   875: astore 6
    //   877: goto -582 -> 295
    //   880: astore_1
    //   881: aconst_null
    //   882: astore_2
    //   883: aconst_null
    //   884: astore_0
    //   885: aconst_null
    //   886: astore 6
    //   888: goto -593 -> 295
    //   891: astore_1
    //   892: aconst_null
    //   893: astore_2
    //   894: aload_0
    //   895: astore 6
    //   897: aconst_null
    //   898: astore_0
    //   899: goto -604 -> 295
    //   902: astore 8
    //   904: aconst_null
    //   905: astore 7
    //   907: aconst_null
    //   908: astore_0
    //   909: aload_1
    //   910: astore 6
    //   912: aconst_null
    //   913: astore_2
    //   914: aload 8
    //   916: astore_1
    //   917: goto -622 -> 295
    //   920: astore 8
    //   922: aconst_null
    //   923: astore 7
    //   925: aconst_null
    //   926: astore_2
    //   927: aload_1
    //   928: astore 6
    //   930: aconst_null
    //   931: astore_0
    //   932: aload 8
    //   934: astore_1
    //   935: goto -640 -> 295
    //   938: astore_1
    //   939: aconst_null
    //   940: astore_2
    //   941: aconst_null
    //   942: astore 8
    //   944: aload_0
    //   945: astore 6
    //   947: aconst_null
    //   948: astore 7
    //   950: aload 8
    //   952: astore_0
    //   953: goto -658 -> 295
    //   956: astore_1
    //   957: aconst_null
    //   958: astore_2
    //   959: aconst_null
    //   960: astore_0
    //   961: goto -666 -> 295
    //   964: astore_1
    //   965: aconst_null
    //   966: astore_0
    //   967: goto -672 -> 295
    //   970: astore_1
    //   971: aload_0
    //   972: astore_1
    //   973: goto -450 -> 523
    //   976: astore_2
    //   977: goto -505 -> 472
    //   980: aconst_null
    //   981: astore 7
    //   983: goto -815 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	986	0	paramContext	Context
    //   0	986	1	paramString1	String
    //   0	986	2	paramString2	String
    //   28	486	3	i	int
    //   4	483	4	j	int
    //   7	393	5	k	int
    //   33	913	6	localObject1	Object
    //   1	981	7	localObject2	Object
    //   94	451	8	localObject3	Object
    //   770	10	8	localObject4	Object
    //   803	5	8	localObject5	Object
    //   813	10	8	localObject6	Object
    //   838	22	8	localObject7	Object
    //   902	13	8	localException1	java.lang.Exception
    //   920	13	8	localException2	java.lang.Exception
    //   942	9	8	localObject8	Object
    //   105	752	9	localObject9	Object
    //   228	626	10	str1	String
    //   225	625	11	localObject10	Object
    //   263	23	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   237	245	294	java/lang/Exception
    //   259	265	294	java/lang/Exception
    //   284	291	294	java/lang/Exception
    //   546	551	294	java/lang/Exception
    //   430	439	469	java/io/IOException
    //   443	449	469	java/io/IOException
    //   472	482	522	java/io/IOException
    //   493	499	522	java/io/IOException
    //   555	559	591	java/io/IOException
    //   563	567	591	java/io/IOException
    //   572	577	591	java/io/IOException
    //   584	589	591	java/io/IOException
    //   613	621	656	java/io/IOException
    //   625	633	656	java/io/IOException
    //   638	643	656	java/io/IOException
    //   648	653	656	java/io/IOException
    //   328	332	675	java/io/IOException
    //   336	340	675	java/io/IOException
    //   345	350	675	java/io/IOException
    //   355	360	675	java/io/IOException
    //   86	123	694	finally
    //   123	139	694	finally
    //   139	165	694	finally
    //   369	395	694	finally
    //   430	439	694	finally
    //   443	449	694	finally
    //   706	710	740	java/io/IOException
    //   714	718	740	java/io/IOException
    //   723	728	740	java/io/IOException
    //   733	738	740	java/io/IOException
    //   172	188	759	finally
    //   413	420	759	finally
    //   188	193	770	finally
    //   449	453	785	finally
    //   472	482	796	finally
    //   493	499	796	finally
    //   499	503	813	finally
    //   201	211	828	finally
    //   211	223	836	finally
    //   237	245	848	finally
    //   259	265	848	finally
    //   284	291	848	finally
    //   309	324	848	finally
    //   546	551	848	finally
    //   86	123	866	java/lang/Exception
    //   123	139	866	java/lang/Exception
    //   139	165	866	java/lang/Exception
    //   369	395	866	java/lang/Exception
    //   430	439	866	java/lang/Exception
    //   443	449	866	java/lang/Exception
    //   172	188	880	java/lang/Exception
    //   413	420	880	java/lang/Exception
    //   188	193	891	java/lang/Exception
    //   449	453	902	java/lang/Exception
    //   472	482	920	java/lang/Exception
    //   493	499	920	java/lang/Exception
    //   499	503	938	java/lang/Exception
    //   201	211	956	java/lang/Exception
    //   211	223	964	java/lang/Exception
    //   499	503	970	java/io/IOException
    //   449	453	976	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.parser.TemplateParser
 * JD-Core Version:    0.7.0.1
 */