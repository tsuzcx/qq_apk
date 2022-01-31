package com.tencent.mobileqq.worldcup;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Vibrator;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ARWorldCupGameUtil
{
  static final int[] a = { 75, 92, 65, 90, 80 };
  
  /* Error */
  public static Bitmap a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnonnull +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: new 25	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   18: aload_2
    //   19: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_3
    //   27: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 4
    //   32: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 39	com/tencent/open/base/MD5:a	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 5
    //   43: new 25	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   50: aload 5
    //   52: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 41
    //   57: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 8
    //   65: ldc 43
    //   67: iconst_0
    //   68: new 25	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   75: ldc 45
    //   77: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: new 53	java/io/File
    //   98: dup
    //   99: new 25	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   106: aload_0
    //   107: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 8
    //   112: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: invokevirtual 60	java/io/File:exists	()Z
    //   124: ifeq +103 -> 227
    //   127: new 25	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 8
    //   140: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 66	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   149: astore_3
    //   150: aload_3
    //   151: astore_1
    //   152: aload_3
    //   153: astore_2
    //   154: ldc 43
    //   156: iconst_0
    //   157: new 25	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   164: ldc 68
    //   166: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 8
    //   175: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_3
    //   185: areturn
    //   186: astore_2
    //   187: aload_1
    //   188: astore_0
    //   189: aload_0
    //   190: astore_1
    //   191: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   194: ifeq -185 -> 9
    //   197: ldc 43
    //   199: iconst_0
    //   200: new 25	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   207: ldc 73
    //   209: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 76	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   216: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 79	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: areturn
    //   227: ldc 43
    //   229: iconst_0
    //   230: new 25	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   237: ldc 81
    //   239: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 8
    //   248: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: new 25	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   264: aload_0
    //   265: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 83
    //   270: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 66	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   279: astore 6
    //   281: aload 6
    //   283: ifnonnull +36 -> 319
    //   286: ldc 43
    //   288: iconst_0
    //   289: new 25	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   296: ldc 85
    //   298: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_0
    //   302: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 8
    //   307: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 6
    //   318: areturn
    //   319: aload 6
    //   321: aload 6
    //   323: invokevirtual 91	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   326: iconst_1
    //   327: invokevirtual 95	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   330: astore 5
    //   332: aload 6
    //   334: invokevirtual 98	android/graphics/Bitmap:recycle	()V
    //   337: new 100	android/graphics/Canvas
    //   340: dup
    //   341: invokespecial 101	android/graphics/Canvas:<init>	()V
    //   344: astore 9
    //   346: aload 9
    //   348: aload 5
    //   350: invokevirtual 105	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   353: aload 9
    //   355: aload_1
    //   356: aload_2
    //   357: aload_3
    //   358: aload 4
    //   360: invokestatic 108	com/tencent/mobileqq/worldcup/ARWorldCupGameUtil:a	(Landroid/graphics/Canvas;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 5
    //   365: ifnull +248 -> 613
    //   368: aload 5
    //   370: astore_1
    //   371: aload 5
    //   373: astore_2
    //   374: new 53	java/io/File
    //   377: dup
    //   378: new 25	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   385: aload_0
    //   386: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 8
    //   391: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: astore_3
    //   401: aload 5
    //   403: astore_1
    //   404: aload 5
    //   406: astore_2
    //   407: aload_3
    //   408: invokevirtual 60	java/io/File:exists	()Z
    //   411: ifeq +14 -> 425
    //   414: aload 5
    //   416: astore_1
    //   417: aload 5
    //   419: astore_2
    //   420: aload_3
    //   421: invokevirtual 111	java/io/File:delete	()Z
    //   424: pop
    //   425: aload 5
    //   427: astore_1
    //   428: aload 5
    //   430: astore_2
    //   431: aload_3
    //   432: invokevirtual 114	java/io/File:createNewFile	()Z
    //   435: pop
    //   436: aload 5
    //   438: astore_1
    //   439: aload 5
    //   441: astore_2
    //   442: new 116	java/io/FileOutputStream
    //   445: dup
    //   446: aload_3
    //   447: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   450: astore_3
    //   451: aload 5
    //   453: astore_1
    //   454: aload 5
    //   456: astore_2
    //   457: aload 5
    //   459: getstatic 125	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   462: bipush 100
    //   464: aload_3
    //   465: invokevirtual 129	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   468: pop
    //   469: aload 5
    //   471: astore_1
    //   472: aload 5
    //   474: astore_2
    //   475: aload_3
    //   476: invokevirtual 132	java/io/FileOutputStream:flush	()V
    //   479: aload 5
    //   481: astore_1
    //   482: aload 5
    //   484: astore_2
    //   485: aload_3
    //   486: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   489: aload 5
    //   491: astore_1
    //   492: aload 5
    //   494: astore_2
    //   495: ldc 43
    //   497: iconst_0
    //   498: new 25	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   505: ldc 137
    //   507: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 8
    //   516: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: aload 5
    //   527: areturn
    //   528: astore_3
    //   529: aload_2
    //   530: astore_0
    //   531: aload_0
    //   532: astore_1
    //   533: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   536: ifeq -527 -> 9
    //   539: ldc 43
    //   541: iconst_0
    //   542: ldc 139
    //   544: aload_3
    //   545: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   548: aload_0
    //   549: areturn
    //   550: astore 4
    //   552: aload 5
    //   554: astore_1
    //   555: aload 5
    //   557: astore_2
    //   558: aload 4
    //   560: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   563: goto -127 -> 436
    //   566: astore_3
    //   567: aload 5
    //   569: astore_1
    //   570: aload 5
    //   572: astore_2
    //   573: aload_3
    //   574: invokevirtual 146	java/io/FileNotFoundException:printStackTrace	()V
    //   577: aload 7
    //   579: astore_3
    //   580: goto -129 -> 451
    //   583: astore 4
    //   585: aload 5
    //   587: astore_1
    //   588: aload 5
    //   590: astore_2
    //   591: aload 4
    //   593: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   596: goto -117 -> 479
    //   599: astore_3
    //   600: aload 5
    //   602: astore_1
    //   603: aload 5
    //   605: astore_2
    //   606: aload_3
    //   607: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   610: goto -121 -> 489
    //   613: aload 5
    //   615: astore_1
    //   616: aload 5
    //   618: astore_2
    //   619: ldc 43
    //   621: iconst_0
    //   622: ldc 148
    //   624: invokestatic 51	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload 5
    //   629: areturn
    //   630: astore_3
    //   631: aconst_null
    //   632: astore_0
    //   633: goto -102 -> 531
    //   636: astore_3
    //   637: aload 6
    //   639: astore_0
    //   640: goto -109 -> 531
    //   643: astore_2
    //   644: aconst_null
    //   645: astore_0
    //   646: goto -457 -> 189
    //   649: astore_2
    //   650: aload 6
    //   652: astore_0
    //   653: goto -464 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	656	0	paramString1	String
    //   0	656	1	paramString2	String
    //   0	656	2	paramString3	String
    //   0	656	3	paramString4	String
    //   0	656	4	paramString5	String
    //   41	587	5	localObject1	Object
    //   279	372	6	localBitmap	Bitmap
    //   1	577	7	localObject2	Object
    //   63	452	8	str	String
    //   344	10	9	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   154	184	186	java/lang/OutOfMemoryError
    //   374	401	186	java/lang/OutOfMemoryError
    //   407	414	186	java/lang/OutOfMemoryError
    //   420	425	186	java/lang/OutOfMemoryError
    //   431	436	186	java/lang/OutOfMemoryError
    //   442	451	186	java/lang/OutOfMemoryError
    //   457	469	186	java/lang/OutOfMemoryError
    //   475	479	186	java/lang/OutOfMemoryError
    //   485	489	186	java/lang/OutOfMemoryError
    //   495	525	186	java/lang/OutOfMemoryError
    //   558	563	186	java/lang/OutOfMemoryError
    //   573	577	186	java/lang/OutOfMemoryError
    //   591	596	186	java/lang/OutOfMemoryError
    //   606	610	186	java/lang/OutOfMemoryError
    //   619	627	186	java/lang/OutOfMemoryError
    //   154	184	528	java/lang/Exception
    //   374	401	528	java/lang/Exception
    //   407	414	528	java/lang/Exception
    //   420	425	528	java/lang/Exception
    //   431	436	528	java/lang/Exception
    //   442	451	528	java/lang/Exception
    //   457	469	528	java/lang/Exception
    //   475	479	528	java/lang/Exception
    //   485	489	528	java/lang/Exception
    //   495	525	528	java/lang/Exception
    //   558	563	528	java/lang/Exception
    //   573	577	528	java/lang/Exception
    //   591	596	528	java/lang/Exception
    //   606	610	528	java/lang/Exception
    //   619	627	528	java/lang/Exception
    //   431	436	550	java/io/IOException
    //   442	451	566	java/io/FileNotFoundException
    //   475	479	583	java/io/IOException
    //   485	489	599	java/io/IOException
    //   11	150	630	java/lang/Exception
    //   227	281	630	java/lang/Exception
    //   286	316	636	java/lang/Exception
    //   319	363	636	java/lang/Exception
    //   11	150	643	java/lang/OutOfMemoryError
    //   227	281	643	java/lang/OutOfMemoryError
    //   286	316	649	java/lang/OutOfMemoryError
    //   319	363	649	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static ARWorldCupVideoInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 53	java/io/File
    //   9: dup
    //   10: new 25	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 151
    //   23: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 60	java/io/File:exists	()Z
    //   37: ifeq +409 -> 446
    //   40: new 153	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 158	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   53: astore_1
    //   54: aload_1
    //   55: getstatic 164	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   58: lconst_0
    //   59: aload_1
    //   60: invokevirtual 170	java/nio/channels/FileChannel:size	()J
    //   63: invokevirtual 174	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   66: astore_2
    //   67: invokestatic 180	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   70: aload_2
    //   71: invokevirtual 184	java/nio/charset/Charset:decode	(Ljava/nio/ByteBuffer;)Ljava/nio/CharBuffer;
    //   74: invokevirtual 187	java/nio/CharBuffer:toString	()Ljava/lang/String;
    //   77: invokestatic 191	com/tencent/mobileqq/worldcup/ARWorldCupVideoInfo:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/worldcup/ARWorldCupVideoInfo;
    //   80: astore_2
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 192	java/io/FileInputStream:close	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   97: aload_2
    //   98: astore_0
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   105: ifeq +12 -> 117
    //   108: ldc 43
    //   110: iconst_0
    //   111: ldc 195
    //   113: aload_0
    //   114: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   117: aload_2
    //   118: astore_0
    //   119: goto -20 -> 99
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_2
    //   125: aconst_null
    //   126: astore_0
    //   127: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   130: ifeq +12 -> 142
    //   133: ldc 43
    //   135: iconst_0
    //   136: ldc 197
    //   138: aload_1
    //   139: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 192	java/io/FileInputStream:close	()V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   158: aconst_null
    //   159: astore_0
    //   160: goto -61 -> 99
    //   163: astore_0
    //   164: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   167: ifeq +12 -> 179
    //   170: ldc 43
    //   172: iconst_0
    //   173: ldc 195
    //   175: aload_0
    //   176: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -82 -> 99
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_1
    //   187: aconst_null
    //   188: astore 4
    //   190: aload_1
    //   191: astore_2
    //   192: aload 4
    //   194: astore_0
    //   195: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   198: ifeq +17 -> 215
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: astore_0
    //   206: ldc 43
    //   208: iconst_0
    //   209: ldc 199
    //   211: aload_3
    //   212: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 192	java/io/FileInputStream:close	()V
    //   225: aload_1
    //   226: ifnull +7 -> 233
    //   229: aload_1
    //   230: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   233: aconst_null
    //   234: astore_0
    //   235: goto -136 -> 99
    //   238: astore_0
    //   239: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   242: ifeq +12 -> 254
    //   245: ldc 43
    //   247: iconst_0
    //   248: ldc 195
    //   250: aload_0
    //   251: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   254: aconst_null
    //   255: astore_0
    //   256: goto -157 -> 99
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 4
    //   265: aload_1
    //   266: astore_2
    //   267: aload 4
    //   269: astore_0
    //   270: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   273: ifeq +17 -> 290
    //   276: aload_1
    //   277: astore_2
    //   278: aload 4
    //   280: astore_0
    //   281: ldc 43
    //   283: iconst_0
    //   284: ldc 201
    //   286: aload_3
    //   287: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   290: aload 4
    //   292: ifnull +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 192	java/io/FileInputStream:close	()V
    //   300: aload_1
    //   301: ifnull +7 -> 308
    //   304: aload_1
    //   305: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   308: aconst_null
    //   309: astore_0
    //   310: goto -211 -> 99
    //   313: astore_0
    //   314: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   317: ifeq +12 -> 329
    //   320: ldc 43
    //   322: iconst_0
    //   323: ldc 195
    //   325: aload_0
    //   326: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   329: aconst_null
    //   330: astore_0
    //   331: goto -232 -> 99
    //   334: astore_1
    //   335: aconst_null
    //   336: astore_2
    //   337: aconst_null
    //   338: astore_0
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 192	java/io/FileInputStream:close	()V
    //   347: aload_2
    //   348: ifnull +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 193	java/nio/channels/FileChannel:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore_0
    //   358: invokestatic 71	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   361: ifeq -6 -> 355
    //   364: ldc 43
    //   366: iconst_0
    //   367: ldc 195
    //   369: aload_0
    //   370: invokestatic 142	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   373: goto -18 -> 355
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_2
    //   379: goto -40 -> 339
    //   382: astore_3
    //   383: aload_1
    //   384: astore_2
    //   385: aload_3
    //   386: astore_1
    //   387: goto -48 -> 339
    //   390: astore_1
    //   391: goto -52 -> 339
    //   394: astore_1
    //   395: goto -56 -> 339
    //   398: astore_3
    //   399: aconst_null
    //   400: astore_1
    //   401: aload_0
    //   402: astore 4
    //   404: goto -139 -> 265
    //   407: astore_3
    //   408: aload_0
    //   409: astore 4
    //   411: goto -146 -> 265
    //   414: astore_3
    //   415: aconst_null
    //   416: astore_1
    //   417: aload_0
    //   418: astore 4
    //   420: goto -230 -> 190
    //   423: astore_3
    //   424: aload_0
    //   425: astore 4
    //   427: goto -237 -> 190
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_2
    //   433: goto -306 -> 127
    //   436: astore_2
    //   437: aload_1
    //   438: astore_3
    //   439: aload_2
    //   440: astore_1
    //   441: aload_3
    //   442: astore_2
    //   443: goto -316 -> 127
    //   446: aconst_null
    //   447: astore_0
    //   448: goto -349 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	paramString	String
    //   53	41	1	localFileChannel	java.nio.channels.FileChannel
    //   122	17	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   186	119	1	localObject1	Object
    //   334	22	1	localObject2	Object
    //   376	8	1	localObject3	Object
    //   386	1	1	localObject4	Object
    //   390	1	1	localObject5	Object
    //   394	1	1	localObject6	Object
    //   400	17	1	localObject7	Object
    //   430	8	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   440	1	1	localObject8	Object
    //   66	367	2	localObject9	Object
    //   436	4	2	localFileNotFoundException3	java.io.FileNotFoundException
    //   442	1	2	localObject10	Object
    //   184	28	3	localIOException1	java.io.IOException
    //   259	28	3	localException1	java.lang.Exception
    //   382	4	3	localObject11	Object
    //   398	1	3	localException2	java.lang.Exception
    //   407	1	3	localException3	java.lang.Exception
    //   414	1	3	localIOException2	java.io.IOException
    //   423	1	3	localIOException3	java.io.IOException
    //   438	4	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   188	238	4	str	String
    // Exception table:
    //   from	to	target	type
    //   85	89	101	java/lang/Exception
    //   93	97	101	java/lang/Exception
    //   40	49	122	java/io/FileNotFoundException
    //   146	150	163	java/lang/Exception
    //   154	158	163	java/lang/Exception
    //   40	49	184	java/io/IOException
    //   220	225	238	java/lang/Exception
    //   229	233	238	java/lang/Exception
    //   40	49	259	java/lang/Exception
    //   295	300	313	java/lang/Exception
    //   304	308	313	java/lang/Exception
    //   40	49	334	finally
    //   343	347	357	java/lang/Exception
    //   351	355	357	java/lang/Exception
    //   49	54	376	finally
    //   54	81	382	finally
    //   127	142	390	finally
    //   195	201	394	finally
    //   206	215	394	finally
    //   270	276	394	finally
    //   281	290	394	finally
    //   49	54	398	java/lang/Exception
    //   54	81	407	java/lang/Exception
    //   49	54	414	java/io/IOException
    //   54	81	423	java/io/IOException
    //   49	54	430	java/io/FileNotFoundException
    //   54	81	436	java/io/FileNotFoundException
  }
  
  private static void a(Canvas paramCanvas, Paint paramPaint, String paramString)
  {
    paramPaint.setTextSize(53.0F);
    float f2 = paramPaint.measureText(paramString);
    float f1 = f2;
    String str = paramString;
    if (f2 > 372.0F)
    {
      do
      {
        str = paramString.substring(0, paramString.length() - 2);
        f1 = paramPaint.measureText(str + "...");
        paramString = str;
      } while (f1 >= 372.0F);
      str = str + "...";
    }
    paramCanvas.drawText(str, 659 - (int)(f1 / 2.0F), 586.0F, paramPaint);
  }
  
  private static void a(Canvas paramCanvas, String paramString, Paint paramPaint)
  {
    Bitmap localBitmap = ARCardUtils.a(paramString);
    int i = localBitmap.getHeight();
    paramString = localBitmap;
    if (i != 250)
    {
      int j = localBitmap.getWidth();
      float f = 250.0F / i;
      paramString = new Matrix();
      paramString.postScale(f, f);
      paramString = Bitmap.createBitmap(localBitmap, 0, 0, j, i, paramString, true);
    }
    paramCanvas.drawBitmap(paramString, 515.0F, 230.0F, paramPaint);
  }
  
  private static void a(Canvas paramCanvas, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      paramString2 = new Paint(1);
      paramString2.setStyle(Paint.Style.FILL);
      paramString2.setTextSize(32.0F);
      paramString2.setFlags(1);
      paramString2.setColor(Color.parseColor("#FFFFFF"));
      if (paramString4 != null) {
        a(paramCanvas, paramString4, paramString2);
      }
    } while (paramString1 == null);
    a(paramCanvas, paramString2, paramString1);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    paramAppInterface = (Vibrator)paramAppInterface.getApp().getSystemService("vibrator");
    if (paramAppInterface != null) {
      paramAppInterface.vibrate(500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupGameUtil
 * JD-Core Version:    0.7.0.1
 */