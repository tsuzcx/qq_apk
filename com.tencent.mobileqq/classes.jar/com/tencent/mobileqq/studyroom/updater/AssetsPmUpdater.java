package com.tencent.mobileqq.studyroom.updater;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class AssetsPmUpdater
  implements IShadowPluginManagerUpdater
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  private Future<File> jdField_a_of_type_JavaUtilConcurrentFuture;
  private boolean jdField_a_of_type_Boolean = false;
  private final String b;
  private final String c;
  
  public AssetsPmUpdater(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramString;
    this.jdField_a_of_type_JavaLangString = String.format("%sPluginManager.apk", new Object[] { paramString });
    this.b = String.format("shadow/%sPluginManager.apk", new Object[] { paramString });
    paramContext = new File(paramContext.getFilesDir(), String.format("%s/assets", new Object[] { paramString }));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      QLog.e("studyroom.AssetsPmUpdater", 1, "create local dir fail");
    }
    this.jdField_a_of_type_JavaIoFile = new File(paramContext, this.jdField_a_of_type_JavaLangString);
  }
  
  /* Error */
  private boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: iconst_1
    //   7: istore 5
    //   9: aload_1
    //   10: invokevirtual 83	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_2
    //   14: invokevirtual 89	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_1
    //   18: new 91	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 94	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 6
    //   28: new 42	java/io/File
    //   31: dup
    //   32: aload_3
    //   33: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 57	java/io/File:exists	()Z
    //   41: ifeq +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 100	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_2
    //   50: invokevirtual 103	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 105	java/io/FileOutputStream
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_3
    //   63: new 110	java/io/BufferedOutputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 113	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 7
    //   73: sipush 1024
    //   76: newarray byte
    //   78: astore_2
    //   79: aload 6
    //   81: aload_2
    //   82: invokevirtual 117	java/io/BufferedInputStream:read	([B)I
    //   85: istore 4
    //   87: iload 4
    //   89: iconst_m1
    //   90: if_icmpeq +82 -> 172
    //   93: aload 7
    //   95: aload_2
    //   96: iconst_0
    //   97: iload 4
    //   99: invokevirtual 121	java/io/BufferedOutputStream:write	([BII)V
    //   102: goto -23 -> 79
    //   105: astore 9
    //   107: aload_3
    //   108: astore 8
    //   110: aload 6
    //   112: astore_2
    //   113: aload_1
    //   114: astore_3
    //   115: aload 8
    //   117: astore_1
    //   118: aload 9
    //   120: astore 6
    //   122: ldc 62
    //   124: iconst_1
    //   125: ldc 123
    //   127: aload 6
    //   129: invokestatic 126	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload 7
    //   134: ifnull +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 134	java/io/InputStream:close	()V
    //   166: iconst_0
    //   167: istore 5
    //   169: iload 5
    //   171: ireturn
    //   172: aload 7
    //   174: invokevirtual 137	java/io/BufferedOutputStream:flush	()V
    //   177: aload 7
    //   179: ifnull +8 -> 187
    //   182: aload 7
    //   184: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   195: aload 6
    //   197: ifnull +8 -> 205
    //   200: aload 6
    //   202: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   205: aload_1
    //   206: ifnull -37 -> 169
    //   209: aload_1
    //   210: invokevirtual 134	java/io/InputStream:close	()V
    //   213: iconst_1
    //   214: ireturn
    //   215: astore_1
    //   216: ldc 62
    //   218: iconst_1
    //   219: new 139	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   226: ldc 142
    //   228: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   235: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_2
    //   247: ldc 62
    //   249: iconst_1
    //   250: new 139	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   257: ldc 142
    //   259: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_2
    //   263: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   266: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: goto -88 -> 187
    //   278: astore_2
    //   279: ldc 62
    //   281: iconst_1
    //   282: new 139	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   289: ldc 142
    //   291: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_2
    //   295: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   298: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto -112 -> 195
    //   310: astore_2
    //   311: ldc 62
    //   313: iconst_1
    //   314: new 139	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   321: ldc 142
    //   323: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   330: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: goto -134 -> 205
    //   342: astore 6
    //   344: ldc 62
    //   346: iconst_1
    //   347: new 139	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   354: ldc 142
    //   356: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 6
    //   361: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   364: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: goto -231 -> 142
    //   376: astore_1
    //   377: ldc 62
    //   379: iconst_1
    //   380: new 139	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   387: ldc 142
    //   389: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_1
    //   393: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   396: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -255 -> 150
    //   408: astore_1
    //   409: ldc 62
    //   411: iconst_1
    //   412: new 139	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   419: ldc 142
    //   421: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_1
    //   425: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   428: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: goto -279 -> 158
    //   440: astore_1
    //   441: ldc 62
    //   443: iconst_1
    //   444: new 139	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   451: ldc 142
    //   453: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload_1
    //   457: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   460: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -303 -> 166
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_3
    //   475: aconst_null
    //   476: astore 6
    //   478: aconst_null
    //   479: astore_1
    //   480: aload 8
    //   482: astore 7
    //   484: aload 7
    //   486: ifnull +8 -> 494
    //   489: aload 7
    //   491: invokevirtual 129	java/io/BufferedOutputStream:close	()V
    //   494: aload_3
    //   495: ifnull +7 -> 502
    //   498: aload_3
    //   499: invokevirtual 130	java/io/FileOutputStream:close	()V
    //   502: aload 6
    //   504: ifnull +8 -> 512
    //   507: aload 6
    //   509: invokevirtual 131	java/io/BufferedInputStream:close	()V
    //   512: aload_1
    //   513: ifnull +7 -> 520
    //   516: aload_1
    //   517: invokevirtual 134	java/io/InputStream:close	()V
    //   520: aload_2
    //   521: athrow
    //   522: astore 7
    //   524: ldc 62
    //   526: iconst_1
    //   527: new 139	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   534: ldc 142
    //   536: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 7
    //   541: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   544: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: goto -59 -> 494
    //   556: astore_3
    //   557: ldc 62
    //   559: iconst_1
    //   560: new 139	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   567: ldc 142
    //   569: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_3
    //   573: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   576: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: goto -83 -> 502
    //   588: astore_3
    //   589: ldc 62
    //   591: iconst_1
    //   592: new 139	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   599: ldc 142
    //   601: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload_3
    //   605: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   608: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: goto -105 -> 512
    //   620: astore_1
    //   621: ldc 62
    //   623: iconst_1
    //   624: new 139	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   631: ldc 142
    //   633: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_1
    //   637: invokevirtual 150	java/io/IOException:toString	()Ljava/lang/String;
    //   640: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: goto -129 -> 520
    //   652: astore_2
    //   653: aconst_null
    //   654: astore_3
    //   655: aconst_null
    //   656: astore 6
    //   658: aload 8
    //   660: astore 7
    //   662: goto -178 -> 484
    //   665: astore_2
    //   666: aconst_null
    //   667: astore_3
    //   668: aload 8
    //   670: astore 7
    //   672: goto -188 -> 484
    //   675: astore_2
    //   676: aload 8
    //   678: astore 7
    //   680: goto -196 -> 484
    //   683: astore_2
    //   684: goto -200 -> 484
    //   687: astore 9
    //   689: aload_3
    //   690: astore 8
    //   692: aload_2
    //   693: astore 6
    //   695: aload 9
    //   697: astore_2
    //   698: aload_1
    //   699: astore_3
    //   700: aload 8
    //   702: astore_1
    //   703: goto -219 -> 484
    //   706: astore 6
    //   708: aconst_null
    //   709: astore_1
    //   710: aconst_null
    //   711: astore_2
    //   712: aconst_null
    //   713: astore_3
    //   714: aload 9
    //   716: astore 7
    //   718: goto -596 -> 122
    //   721: astore 6
    //   723: aconst_null
    //   724: astore 8
    //   726: aconst_null
    //   727: astore_2
    //   728: aload_1
    //   729: astore_3
    //   730: aload 9
    //   732: astore 7
    //   734: aload 8
    //   736: astore_1
    //   737: goto -615 -> 122
    //   740: astore 7
    //   742: aconst_null
    //   743: astore 8
    //   745: aload 6
    //   747: astore_2
    //   748: aload_1
    //   749: astore_3
    //   750: aload 7
    //   752: astore 6
    //   754: aload 9
    //   756: astore 7
    //   758: aload 8
    //   760: astore_1
    //   761: goto -639 -> 122
    //   764: astore 7
    //   766: aload 6
    //   768: astore_2
    //   769: aload_1
    //   770: astore 8
    //   772: aload 7
    //   774: astore 6
    //   776: aload 9
    //   778: astore 7
    //   780: aload_3
    //   781: astore_1
    //   782: aload 8
    //   784: astore_3
    //   785: goto -663 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	AssetsPmUpdater
    //   0	788	1	paramContext	Context
    //   0	788	2	paramString1	String
    //   0	788	3	paramString2	String
    //   85	13	4	i	int
    //   7	163	5	bool	boolean
    //   26	175	6	localObject1	Object
    //   342	18	6	localIOException1	IOException
    //   476	218	6	str	String
    //   706	1	6	localIOException2	IOException
    //   721	25	6	localIOException3	IOException
    //   752	23	6	localObject2	Object
    //   71	419	7	localObject3	Object
    //   522	18	7	localIOException4	IOException
    //   660	73	7	localObject4	Object
    //   740	11	7	localIOException5	IOException
    //   756	1	7	localObject5	Object
    //   764	9	7	localIOException6	IOException
    //   778	1	7	localObject6	Object
    //   1	782	8	localObject7	Object
    //   4	1	9	localObject8	Object
    //   105	14	9	localIOException7	IOException
    //   687	90	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   73	79	105	java/io/IOException
    //   79	87	105	java/io/IOException
    //   93	102	105	java/io/IOException
    //   172	177	105	java/io/IOException
    //   209	213	215	java/io/IOException
    //   182	187	246	java/io/IOException
    //   191	195	278	java/io/IOException
    //   200	205	310	java/io/IOException
    //   137	142	342	java/io/IOException
    //   146	150	376	java/io/IOException
    //   154	158	408	java/io/IOException
    //   162	166	440	java/io/IOException
    //   9	18	472	finally
    //   489	494	522	java/io/IOException
    //   498	502	556	java/io/IOException
    //   507	512	588	java/io/IOException
    //   516	520	620	java/io/IOException
    //   18	28	652	finally
    //   28	49	665	finally
    //   49	63	665	finally
    //   63	73	675	finally
    //   73	79	683	finally
    //   79	87	683	finally
    //   93	102	683	finally
    //   172	177	683	finally
    //   122	132	687	finally
    //   9	18	706	java/io/IOException
    //   18	28	721	java/io/IOException
    //   28	49	740	java/io/IOException
    //   49	63	740	java/io/IOException
    //   63	73	764	java/io/IOException
  }
  
  private static boolean b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.list(paramString1);
      if (paramContext != null)
      {
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramContext[i].equals(paramString2);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (IOException paramContext)
    {
      QLog.e("studyroom.AssetsPmUpdater", 1, "isAssertFileExists", paramContext);
    }
  }
  
  public boolean a()
  {
    return b(this.jdField_a_of_type_AndroidContentContext, "shadow/", this.jdField_a_of_type_JavaLangString);
  }
  
  public File getLatest()
  {
    if (a())
    {
      if ((!this.jdField_a_of_type_JavaIoFile.exists()) || (!this.jdField_a_of_type_Boolean))
      {
        long l = System.currentTimeMillis();
        if (!a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_JavaIoFile.getAbsolutePath())) {
          break label94;
        }
        QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
      }
      while (this.jdField_a_of_type_JavaIoFile.exists())
      {
        return this.jdField_a_of_type_JavaIoFile;
        label94:
        QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
      }
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    throw new UnsupportedOperationException(HardCodeUtil.a(2131701543));
  }
  
  public Future<File> update()
  {
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.AssetsPmUpdater", 2, "update");
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isDone()) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isCancelled()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.AssetsPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.jdField_a_of_type_JavaUtilConcurrentFuture;
    }
    this.jdField_a_of_type_JavaUtilConcurrentFuture = ThreadManagerExecutor.getExecutorService(192).submit(new AssetsPmUpdater.1(this));
    return this.jdField_a_of_type_JavaUtilConcurrentFuture;
  }
  
  public boolean wasUpdating()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isDone()) && (!this.jdField_a_of_type_JavaUtilConcurrentFuture.isCancelled());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.AssetsPmUpdater
 * JD-Core Version:    0.7.0.1
 */