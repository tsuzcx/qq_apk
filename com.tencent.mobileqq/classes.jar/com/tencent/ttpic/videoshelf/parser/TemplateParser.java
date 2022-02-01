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
  private static final String TAG = "TemplateParser";
  
  public static VideoShelfTemplate parse(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile2 = new File(paramString, "params.json");
      Object localObject = "params.dat";
      File localFile1 = new File(paramString, "params.dat");
      if (localFile2.exists()) {
        localObject = localFile2.getName();
      } else if (localFile1.exists()) {
        localObject = localFile1.getName();
      }
      paramContext = readFileString(paramContext, paramString, (String)localObject);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try
        {
          paramContext = (VideoShelfTemplate)((Gson)localObject).fromJson(paramContext, VideoShelfTemplate.class);
        }
        catch (JsonSyntaxException paramContext)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Video template parse error!");
          ((StringBuilder)localObject).append(paramContext);
          ReportUtil.report(((StringBuilder)localObject).toString());
          paramContext.printStackTrace();
          paramContext = null;
        }
        if (paramContext != null)
        {
          paramContext.setFromAssets(paramString.startsWith("assets://"));
          paramContext.setMaterialPath(paramString);
        }
        return paramContext;
      }
      throw new IllegalArgumentException("video template json is not valid");
    }
    throw new IllegalArgumentException("video template path is not valid");
  }
  
  /* Error */
  private static String readFileString(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 119
    //   3: invokevirtual 122	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifne +17 -> 23
    //   9: aload_2
    //   10: ldc 124
    //   12: invokevirtual 122	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +8 -> 23
    //   18: iconst_1
    //   19: istore_3
    //   20: goto +5 -> 25
    //   23: iconst_0
    //   24: istore_3
    //   25: aload_1
    //   26: invokestatic 130	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 4
    //   31: new 68	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: aload 4
    //   42: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: ldc 132
    //   49: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_1
    //   54: aload_2
    //   55: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: new 68	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   71: astore 5
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: ldc 132
    //   85: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 5
    //   91: aload_2
    //   92: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 5
    //   98: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore 7
    //   103: aconst_null
    //   104: astore 5
    //   106: aconst_null
    //   107: astore 6
    //   109: new 32	java/io/File
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore 4
    //   119: new 32	java/io/File
    //   122: dup
    //   123: aload 7
    //   125: invokespecial 133	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 8
    //   130: aload 4
    //   132: invokevirtual 39	java/io/File:exists	()Z
    //   135: ifeq +11 -> 146
    //   138: aload 4
    //   140: invokevirtual 136	java/io/File:isFile	()Z
    //   143: ifne +19 -> 162
    //   146: aload 8
    //   148: invokevirtual 39	java/io/File:exists	()Z
    //   151: ifeq +172 -> 323
    //   154: aload 8
    //   156: invokevirtual 136	java/io/File:isFile	()Z
    //   159: ifeq +164 -> 323
    //   162: aload 4
    //   164: invokevirtual 39	java/io/File:exists	()Z
    //   167: ifeq +24 -> 191
    //   170: aload 4
    //   172: invokevirtual 136	java/io/File:isFile	()Z
    //   175: ifeq +16 -> 191
    //   178: new 138	java/io/FileInputStream
    //   181: dup
    //   182: aload 4
    //   184: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   187: astore_0
    //   188: goto +38 -> 226
    //   191: aload 8
    //   193: invokevirtual 39	java/io/File:exists	()Z
    //   196: ifeq +28 -> 224
    //   199: aload 8
    //   201: invokevirtual 136	java/io/File:isFile	()Z
    //   204: ifeq +20 -> 224
    //   207: new 138	java/io/FileInputStream
    //   210: dup
    //   211: aload 8
    //   213: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   216: astore_0
    //   217: iload_3
    //   218: iconst_1
    //   219: ixor
    //   220: istore_3
    //   221: goto +5 -> 226
    //   224: aconst_null
    //   225: astore_0
    //   226: iload_3
    //   227: ifne +87 -> 314
    //   230: aload_2
    //   231: ldc 124
    //   233: invokevirtual 122	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   236: ifeq +12 -> 248
    //   239: aload_0
    //   240: iconst_1
    //   241: invokestatic 147	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   244: astore_1
    //   245: goto +9 -> 254
    //   248: aload_0
    //   249: iconst_0
    //   250: invokestatic 147	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   253: astore_1
    //   254: aload_0
    //   255: invokestatic 153	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   258: goto +215 -> 473
    //   261: astore_2
    //   262: goto +359 -> 621
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_2
    //   269: aload_2
    //   270: astore 4
    //   272: goto +422 -> 694
    //   275: astore_2
    //   276: aconst_null
    //   277: astore 4
    //   279: aload 4
    //   281: astore_1
    //   282: aload 6
    //   284: astore 5
    //   286: goto +489 -> 775
    //   289: astore_2
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 4
    //   295: astore_1
    //   296: aload_1
    //   297: astore 5
    //   299: aload_2
    //   300: astore 6
    //   302: aload_1
    //   303: astore_2
    //   304: aload 5
    //   306: astore_1
    //   307: aload 6
    //   309: astore 5
    //   311: goto +383 -> 694
    //   314: aload_0
    //   315: astore_2
    //   316: aload_0
    //   317: astore_1
    //   318: aload_2
    //   319: astore_0
    //   320: goto +153 -> 473
    //   323: aload_0
    //   324: invokevirtual 159	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   327: aload_1
    //   328: invokevirtual 165	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   331: astore 6
    //   333: aload 6
    //   335: astore_1
    //   336: iload_3
    //   337: ifne +20 -> 357
    //   340: aload 6
    //   342: iconst_1
    //   343: invokestatic 147	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   346: astore_1
    //   347: aload_1
    //   348: astore_2
    //   349: aload_1
    //   350: astore 4
    //   352: aload 6
    //   354: invokestatic 153	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   357: aload_1
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_2
    //   361: aload_0
    //   362: astore_1
    //   363: aload_2
    //   364: astore_0
    //   365: goto +108 -> 473
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: astore_2
    //   372: aload_1
    //   373: astore 4
    //   375: aload_0
    //   376: invokevirtual 159	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   379: aload 7
    //   381: invokevirtual 165	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   384: astore 6
    //   386: aload 6
    //   388: astore_0
    //   389: iload_3
    //   390: iconst_1
    //   391: ixor
    //   392: ifne -33 -> 359
    //   395: aload_1
    //   396: astore_2
    //   397: aload_1
    //   398: astore 4
    //   400: aload 6
    //   402: iconst_1
    //   403: invokestatic 147	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;Z)Ljava/io/InputStream;
    //   406: astore_0
    //   407: aload 6
    //   409: invokestatic 153	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   412: goto -53 -> 359
    //   415: astore_2
    //   416: aload_0
    //   417: astore_1
    //   418: aload_2
    //   419: astore_0
    //   420: goto +18 -> 438
    //   423: astore 5
    //   425: aload_0
    //   426: astore_1
    //   427: goto +31 -> 458
    //   430: aload_0
    //   431: astore_1
    //   432: goto +36 -> 468
    //   435: astore_0
    //   436: aload_2
    //   437: astore_1
    //   438: aconst_null
    //   439: astore 6
    //   441: aload 6
    //   443: astore 4
    //   445: aload_0
    //   446: astore_2
    //   447: aload 6
    //   449: astore_0
    //   450: goto +325 -> 775
    //   453: astore 5
    //   455: aload 4
    //   457: astore_1
    //   458: aconst_null
    //   459: astore_0
    //   460: aconst_null
    //   461: astore 4
    //   463: aconst_null
    //   464: astore_2
    //   465: goto +229 -> 694
    //   468: aload_1
    //   469: astore_0
    //   470: goto -111 -> 359
    //   473: aload_1
    //   474: ifnull +158 -> 632
    //   477: new 167	java/io/InputStreamReader
    //   480: dup
    //   481: aload_1
    //   482: invokespecial 169	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   485: astore 4
    //   487: new 171	java/io/BufferedReader
    //   490: dup
    //   491: aload 4
    //   493: sipush 1024
    //   496: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   499: astore_2
    //   500: new 68	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   507: astore 5
    //   509: aload_2
    //   510: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   513: astore 6
    //   515: aload 6
    //   517: ifnull +14 -> 531
    //   520: aload 5
    //   522: aload 6
    //   524: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: goto -19 -> 509
    //   531: aload 5
    //   533: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore 5
    //   538: aload_2
    //   539: invokevirtual 180	java/io/BufferedReader:close	()V
    //   542: aload 4
    //   544: invokevirtual 181	java/io/InputStreamReader:close	()V
    //   547: aload_1
    //   548: ifnull +7 -> 555
    //   551: aload_1
    //   552: invokevirtual 184	java/io/InputStream:close	()V
    //   555: aload_0
    //   556: ifnull +26 -> 582
    //   559: aload_0
    //   560: invokevirtual 185	java/io/FileInputStream:close	()V
    //   563: aload 5
    //   565: areturn
    //   566: astore_0
    //   567: getstatic 187	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   570: aload_0
    //   571: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   574: aload_0
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 196	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   582: aload 5
    //   584: areturn
    //   585: astore 6
    //   587: aload_2
    //   588: astore 5
    //   590: aload 6
    //   592: astore_2
    //   593: goto -307 -> 286
    //   596: astore 6
    //   598: aload_1
    //   599: astore 5
    //   601: aload_2
    //   602: astore_1
    //   603: aload 6
    //   605: astore_2
    //   606: goto -307 -> 299
    //   609: astore_2
    //   610: goto +165 -> 775
    //   613: astore 5
    //   615: aconst_null
    //   616: astore_2
    //   617: goto +77 -> 694
    //   620: astore_2
    //   621: aconst_null
    //   622: astore 4
    //   624: goto +151 -> 775
    //   627: astore 5
    //   629: goto -169 -> 460
    //   632: aload_1
    //   633: ifnull +10 -> 643
    //   636: aload_1
    //   637: invokevirtual 184	java/io/InputStream:close	()V
    //   640: goto +3 -> 643
    //   643: aload_0
    //   644: ifnull +121 -> 765
    //   647: aload_0
    //   648: invokevirtual 185	java/io/FileInputStream:close	()V
    //   651: aconst_null
    //   652: areturn
    //   653: getstatic 187	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   656: aload_0
    //   657: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   660: aload_0
    //   661: iconst_0
    //   662: anewarray 4	java/lang/Object
    //   665: invokestatic 196	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   668: aconst_null
    //   669: areturn
    //   670: astore_2
    //   671: aconst_null
    //   672: astore_0
    //   673: aload_0
    //   674: astore 4
    //   676: aload 4
    //   678: astore_1
    //   679: goto +96 -> 775
    //   682: astore 5
    //   684: aconst_null
    //   685: astore_0
    //   686: aload_0
    //   687: astore 4
    //   689: aload 4
    //   691: astore_2
    //   692: aload_2
    //   693: astore_1
    //   694: getstatic 187	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   697: aload 5
    //   699: invokevirtual 197	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   702: aload 5
    //   704: iconst_0
    //   705: anewarray 4	java/lang/Object
    //   708: invokestatic 196	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   711: aload_2
    //   712: ifnull +10 -> 722
    //   715: aload_2
    //   716: invokevirtual 180	java/io/BufferedReader:close	()V
    //   719: goto +3 -> 722
    //   722: aload 4
    //   724: ifnull +8 -> 732
    //   727: aload 4
    //   729: invokevirtual 181	java/io/InputStreamReader:close	()V
    //   732: aload_1
    //   733: ifnull +7 -> 740
    //   736: aload_1
    //   737: invokevirtual 184	java/io/InputStream:close	()V
    //   740: aload_0
    //   741: ifnull +24 -> 765
    //   744: aload_0
    //   745: invokevirtual 185	java/io/FileInputStream:close	()V
    //   748: aconst_null
    //   749: areturn
    //   750: getstatic 187	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   753: aload_0
    //   754: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   757: aload_0
    //   758: iconst_0
    //   759: anewarray 4	java/lang/Object
    //   762: invokestatic 196	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   765: aconst_null
    //   766: areturn
    //   767: astore 6
    //   769: aload_2
    //   770: astore 5
    //   772: aload 6
    //   774: astore_2
    //   775: aload 5
    //   777: ifnull +11 -> 788
    //   780: aload 5
    //   782: invokevirtual 180	java/io/BufferedReader:close	()V
    //   785: goto +3 -> 788
    //   788: aload 4
    //   790: ifnull +8 -> 798
    //   793: aload 4
    //   795: invokevirtual 181	java/io/InputStreamReader:close	()V
    //   798: aload_1
    //   799: ifnull +7 -> 806
    //   802: aload_1
    //   803: invokevirtual 184	java/io/InputStream:close	()V
    //   806: aload_0
    //   807: ifnull +25 -> 832
    //   810: aload_0
    //   811: invokevirtual 185	java/io/FileInputStream:close	()V
    //   814: goto +18 -> 832
    //   817: getstatic 187	com/tencent/ttpic/videoshelf/parser/TemplateParser:TAG	Ljava/lang/String;
    //   820: aload_0
    //   821: invokevirtual 190	java/io/IOException:getMessage	()Ljava/lang/String;
    //   824: aload_0
    //   825: iconst_0
    //   826: anewarray 4	java/lang/Object
    //   829: invokestatic 196	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   832: goto +5 -> 837
    //   835: aload_2
    //   836: athrow
    //   837: goto -2 -> 835
    //   840: astore_1
    //   841: goto -473 -> 368
    //   844: astore_2
    //   845: goto -475 -> 370
    //   848: astore_0
    //   849: goto -381 -> 468
    //   852: astore_1
    //   853: goto -423 -> 430
    //   856: astore_0
    //   857: goto -204 -> 653
    //   860: astore_0
    //   861: goto -111 -> 750
    //   864: astore_0
    //   865: goto -48 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	868	0	paramContext	Context
    //   0	868	1	paramString1	String
    //   0	868	2	paramString2	String
    //   19	373	3	i	int
    //   29	765	4	localObject1	Object
    //   71	34	5	localStringBuilder	StringBuilder
    //   265	1	5	localException1	java.lang.Exception
    //   284	26	5	localObject2	Object
    //   423	1	5	localException2	java.lang.Exception
    //   453	1	5	localException3	java.lang.Exception
    //   507	93	5	localObject3	Object
    //   613	1	5	localException4	java.lang.Exception
    //   627	1	5	localException5	java.lang.Exception
    //   682	21	5	localException6	java.lang.Exception
    //   770	11	5	str1	String
    //   107	416	6	localObject4	Object
    //   585	6	6	localObject5	Object
    //   596	8	6	localException7	java.lang.Exception
    //   767	6	6	localObject6	Object
    //   101	279	7	str2	String
    //   128	84	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   254	258	261	finally
    //   254	258	265	java/lang/Exception
    //   230	245	275	finally
    //   248	254	275	finally
    //   230	245	289	java/lang/Exception
    //   248	254	289	java/lang/Exception
    //   407	412	415	finally
    //   407	412	423	java/lang/Exception
    //   352	357	435	finally
    //   375	386	435	finally
    //   400	407	435	finally
    //   352	357	453	java/lang/Exception
    //   375	386	453	java/lang/Exception
    //   400	407	453	java/lang/Exception
    //   538	547	566	java/io/IOException
    //   551	555	566	java/io/IOException
    //   559	563	566	java/io/IOException
    //   500	509	585	finally
    //   509	515	585	finally
    //   520	528	585	finally
    //   531	538	585	finally
    //   500	509	596	java/lang/Exception
    //   509	515	596	java/lang/Exception
    //   520	528	596	java/lang/Exception
    //   531	538	596	java/lang/Exception
    //   487	500	609	finally
    //   487	500	613	java/lang/Exception
    //   477	487	620	finally
    //   477	487	627	java/lang/Exception
    //   109	146	670	finally
    //   146	162	670	finally
    //   162	188	670	finally
    //   191	217	670	finally
    //   323	333	670	finally
    //   340	347	670	finally
    //   109	146	682	java/lang/Exception
    //   146	162	682	java/lang/Exception
    //   162	188	682	java/lang/Exception
    //   191	217	682	java/lang/Exception
    //   323	333	682	java/lang/Exception
    //   340	347	682	java/lang/Exception
    //   694	711	767	finally
    //   323	333	840	java/io/IOException
    //   340	347	840	java/io/IOException
    //   352	357	844	java/io/IOException
    //   375	386	848	java/io/IOException
    //   400	407	848	java/io/IOException
    //   407	412	852	java/io/IOException
    //   636	640	856	java/io/IOException
    //   647	651	856	java/io/IOException
    //   715	719	860	java/io/IOException
    //   727	732	860	java/io/IOException
    //   736	740	860	java/io/IOException
    //   744	748	860	java/io/IOException
    //   780	785	864	java/io/IOException
    //   793	798	864	java/io/IOException
    //   802	806	864	java/io/IOException
    //   810	814	864	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.parser.TemplateParser
 * JD-Core Version:    0.7.0.1
 */