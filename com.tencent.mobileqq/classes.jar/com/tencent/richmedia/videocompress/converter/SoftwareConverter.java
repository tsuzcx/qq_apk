package com.tencent.richmedia.videocompress.converter;

import android.text.TextUtils;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SoftwareConverter
{
  public static final String TAG = "SoftwareConverter";
  public static AtomicBoolean continueCompress = new AtomicBoolean(true);
  private static String ffmpegBinFullPath;
  private static String ffmpegSoFullPath;
  private static int sCpuCores;
  
  public static int compressVideo(String paramString, SoftwareConverter.ProcessCallBack paramProcessCallBack)
  {
    VideoConverterConfig localVideoConverterConfig = paramProcessCallBack.getEncodeConfig();
    if (!localVideoConverterConfig.isNeedCompress)
    {
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("SoftwareConverter", 2, new Object[] { "compressVideo error, isNeedCompress is false" });
      }
      return -1;
    }
    File localFile = new File(localVideoConverterConfig.output);
    if (localFile.exists()) {
      localFile.delete();
    }
    int i = executeFFmpegCmd(generateCommand(paramString, localVideoConverterConfig.output, localVideoConverterConfig), paramProcessCallBack);
    if (i != 0) {
      try
      {
        paramString = new File(localVideoConverterConfig.output);
        if (paramString.exists())
        {
          paramString.delete();
          if (ConvertLog.isColorLevel())
          {
            ConvertLog.d("SoftwareConverter", 2, new Object[] { "compressVideo, delete video, ret=", Integer.valueOf(i) });
            return i;
          }
        }
      }
      catch (Exception paramString)
      {
        ConvertLog.e("SoftwareConverter", 1, "compressVideo, delete video exception", paramString);
      }
    }
    return i;
  }
  
  /* Error */
  public static int executeFFmpegCmd(List<String> paramList, SoftwareConverter.ProcessCallBack paramProcessCallBack)
  {
    // Byte code:
    //   0: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 103	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 104	java/util/ArrayList:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: getstatic 106	com/tencent/richmedia/videocompress/converter/SoftwareConverter:ffmpegBinFullPath	Ljava/lang/String;
    //   19: invokeinterface 112 2 0
    //   24: pop
    //   25: aload 7
    //   27: aload_0
    //   28: invokeinterface 116 2 0
    //   33: pop
    //   34: aload 7
    //   36: getstatic 118	com/tencent/richmedia/videocompress/converter/SoftwareConverter:ffmpegSoFullPath	Ljava/lang/String;
    //   39: invokeinterface 112 2 0
    //   44: pop
    //   45: invokestatic 49	com/tencent/richmedia/videocompress/utils/ConvertLog:isColorLevel	()Z
    //   48: ifeq +35 -> 83
    //   51: ldc 8
    //   53: iconst_2
    //   54: iconst_4
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: ldc 120
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: getstatic 106	com/tencent/richmedia/videocompress/converter/SoftwareConverter:ffmpegBinFullPath	Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: ldc 122
    //   73: aastore
    //   74: dup
    //   75: iconst_3
    //   76: getstatic 118	com/tencent/richmedia/videocompress/converter/SoftwareConverter:ffmpegSoFullPath	Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   83: aconst_null
    //   84: astore 6
    //   86: aconst_null
    //   87: astore 10
    //   89: aconst_null
    //   90: astore 8
    //   92: new 124	java/lang/ProcessBuilder
    //   95: dup
    //   96: aload 7
    //   98: invokespecial 127	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   101: iconst_1
    //   102: invokevirtual 131	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   105: invokevirtual 135	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   108: astore 9
    //   110: aload_1
    //   111: ifnull +11 -> 122
    //   114: aload_1
    //   115: aload 9
    //   117: invokeinterface 139 2 0
    //   122: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   125: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   128: ifne +27 -> 155
    //   131: aload_1
    //   132: ifnull +9 -> 141
    //   135: aload_1
    //   136: invokeinterface 145 1 0
    //   141: aload 9
    //   143: invokevirtual 150	java/lang/Process:destroy	()V
    //   146: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   149: iconst_1
    //   150: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   153: iconst_m1
    //   154: ireturn
    //   155: aload 9
    //   157: invokevirtual 157	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   160: astore_0
    //   161: new 159	java/io/InputStreamReader
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 162	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   169: astore 6
    //   171: new 164	java/io/BufferedReader
    //   174: dup
    //   175: aload 6
    //   177: invokespecial 167	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   180: astore 7
    //   182: aload 9
    //   184: invokevirtual 171	java/lang/Process:waitFor	()I
    //   187: pop
    //   188: aload 9
    //   190: invokevirtual 174	java/lang/Process:exitValue	()I
    //   193: istore_2
    //   194: new 176	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   201: astore 8
    //   203: aload 8
    //   205: ldc 179
    //   207: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 8
    //   213: iload_2
    //   214: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 8
    //   220: iconst_2
    //   221: iconst_1
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 8
    //   229: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   236: aload 7
    //   238: invokevirtual 193	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   241: astore 8
    //   243: aload 8
    //   245: ifnull +49 -> 294
    //   248: new 176	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   255: astore 10
    //   257: aload 10
    //   259: ldc 195
    //   261: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 10
    //   267: aload 8
    //   269: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: ldc 8
    //   275: iconst_2
    //   276: iconst_1
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload 10
    //   284: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   291: goto -55 -> 236
    //   294: aload 9
    //   296: invokevirtual 150	java/lang/Process:destroy	()V
    //   299: aload_1
    //   300: ifnull +9 -> 309
    //   303: aload_1
    //   304: invokeinterface 198 1 0
    //   309: ldc 8
    //   311: iconst_1
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: ldc 200
    //   320: aastore
    //   321: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   324: aload_0
    //   325: ifnull +7 -> 332
    //   328: aload_0
    //   329: invokevirtual 205	java/io/InputStream:close	()V
    //   332: aload 6
    //   334: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   337: aload 7
    //   339: invokevirtual 207	java/io/BufferedReader:close	()V
    //   342: goto +345 -> 687
    //   345: astore_1
    //   346: goto +413 -> 759
    //   349: astore_1
    //   350: goto +51 -> 401
    //   353: astore_1
    //   354: goto +68 -> 422
    //   357: astore_1
    //   358: goto +85 -> 443
    //   361: astore_1
    //   362: aconst_null
    //   363: astore 7
    //   365: goto +394 -> 759
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 7
    //   372: goto +29 -> 401
    //   375: astore_1
    //   376: aconst_null
    //   377: astore 7
    //   379: goto +43 -> 422
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 7
    //   386: goto +57 -> 443
    //   389: astore_1
    //   390: goto +69 -> 459
    //   393: astore_1
    //   394: aconst_null
    //   395: astore 6
    //   397: aload 6
    //   399: astore 7
    //   401: aload_1
    //   402: astore 10
    //   404: aload_0
    //   405: astore 8
    //   407: aload 6
    //   409: astore 9
    //   411: goto +66 -> 477
    //   414: astore_1
    //   415: aconst_null
    //   416: astore 6
    //   418: aload 6
    //   420: astore 7
    //   422: aload_1
    //   423: astore 10
    //   425: aload_0
    //   426: astore 8
    //   428: aload 6
    //   430: astore 9
    //   432: goto +124 -> 556
    //   435: astore_1
    //   436: aconst_null
    //   437: astore 6
    //   439: aload 6
    //   441: astore 7
    //   443: aload_1
    //   444: astore 10
    //   446: aload_0
    //   447: astore 8
    //   449: aload 6
    //   451: astore 9
    //   453: goto +176 -> 629
    //   456: astore_1
    //   457: aconst_null
    //   458: astore_0
    //   459: aconst_null
    //   460: astore 6
    //   462: aconst_null
    //   463: astore 7
    //   465: goto +294 -> 759
    //   468: astore 10
    //   470: aconst_null
    //   471: astore 9
    //   473: aload 9
    //   475: astore 7
    //   477: sipush -1003
    //   480: istore_3
    //   481: aload 8
    //   483: astore 6
    //   485: aload 9
    //   487: astore_0
    //   488: aload 7
    //   490: astore_1
    //   491: ldc 8
    //   493: iconst_1
    //   494: ldc 209
    //   496: aload 10
    //   498: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: aload 8
    //   503: ifnull +13 -> 516
    //   506: iload_3
    //   507: istore_2
    //   508: aload 8
    //   510: invokevirtual 205	java/io/InputStream:close	()V
    //   513: goto +3 -> 516
    //   516: aload 9
    //   518: ifnull +292 -> 810
    //   521: iload_3
    //   522: istore_2
    //   523: aload 9
    //   525: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   528: goto +282 -> 810
    //   531: iload_3
    //   532: istore_2
    //   533: aload 7
    //   535: invokevirtual 207	java/io/BufferedReader:close	()V
    //   538: iload_3
    //   539: istore_2
    //   540: goto +147 -> 687
    //   543: astore 10
    //   545: aconst_null
    //   546: astore 9
    //   548: aload 9
    //   550: astore 7
    //   552: aload 6
    //   554: astore 8
    //   556: sipush -1002
    //   559: istore_3
    //   560: aload 8
    //   562: astore 6
    //   564: aload 9
    //   566: astore_0
    //   567: aload 7
    //   569: astore_1
    //   570: ldc 8
    //   572: iconst_1
    //   573: ldc 211
    //   575: aload 10
    //   577: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   580: aload 8
    //   582: ifnull +10 -> 592
    //   585: iload_3
    //   586: istore_2
    //   587: aload 8
    //   589: invokevirtual 205	java/io/InputStream:close	()V
    //   592: aload 9
    //   594: ifnull +10 -> 604
    //   597: iload_3
    //   598: istore_2
    //   599: aload 9
    //   601: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   604: iload_3
    //   605: istore_2
    //   606: aload 7
    //   608: ifnull +79 -> 687
    //   611: goto -80 -> 531
    //   614: astore_0
    //   615: aconst_null
    //   616: astore 9
    //   618: aload 9
    //   620: astore 7
    //   622: aload 10
    //   624: astore 8
    //   626: aload_0
    //   627: astore 10
    //   629: sipush -1001
    //   632: istore_3
    //   633: aload 8
    //   635: astore 6
    //   637: aload 9
    //   639: astore_0
    //   640: aload 7
    //   642: astore_1
    //   643: ldc 8
    //   645: iconst_1
    //   646: ldc 213
    //   648: aload 10
    //   650: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: aload 8
    //   655: ifnull +10 -> 665
    //   658: iload_3
    //   659: istore_2
    //   660: aload 8
    //   662: invokevirtual 205	java/io/InputStream:close	()V
    //   665: aload 9
    //   667: ifnull +10 -> 677
    //   670: iload_3
    //   671: istore_2
    //   672: aload 9
    //   674: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   677: iload_3
    //   678: istore_2
    //   679: aload 7
    //   681: ifnull +6 -> 687
    //   684: goto -153 -> 531
    //   687: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   690: iconst_1
    //   691: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   694: invokestatic 49	com/tencent/richmedia/videocompress/utils/ConvertLog:isColorLevel	()Z
    //   697: ifeq +42 -> 739
    //   700: ldc 8
    //   702: iconst_2
    //   703: iconst_4
    //   704: anewarray 4	java/lang/Object
    //   707: dup
    //   708: iconst_0
    //   709: ldc 215
    //   711: aastore
    //   712: dup
    //   713: iconst_1
    //   714: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   717: lload 4
    //   719: lsub
    //   720: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   723: aastore
    //   724: dup
    //   725: iconst_2
    //   726: ldc 222
    //   728: aastore
    //   729: dup
    //   730: iconst_3
    //   731: iload_2
    //   732: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   735: aastore
    //   736: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   739: iload_2
    //   740: ireturn
    //   741: astore 9
    //   743: aload 6
    //   745: astore 8
    //   747: aload_1
    //   748: astore 7
    //   750: aload_0
    //   751: astore 6
    //   753: aload 8
    //   755: astore_0
    //   756: aload 9
    //   758: astore_1
    //   759: aload_0
    //   760: ifnull +7 -> 767
    //   763: aload_0
    //   764: invokevirtual 205	java/io/InputStream:close	()V
    //   767: aload 6
    //   769: ifnull +8 -> 777
    //   772: aload 6
    //   774: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   777: aload 7
    //   779: ifnull +8 -> 787
    //   782: aload 7
    //   784: invokevirtual 207	java/io/BufferedReader:close	()V
    //   787: goto +5 -> 792
    //   790: aload_1
    //   791: athrow
    //   792: goto -2 -> 790
    //   795: astore_0
    //   796: goto -454 -> 342
    //   799: astore_0
    //   800: goto +7 -> 807
    //   803: astore_0
    //   804: goto -17 -> 787
    //   807: goto -120 -> 687
    //   810: iload_3
    //   811: istore_2
    //   812: aload 7
    //   814: ifnull -127 -> 687
    //   817: goto -286 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	820	0	paramList	List<String>
    //   0	820	1	paramProcessCallBack	SoftwareConverter.ProcessCallBack
    //   193	619	2	i	int
    //   480	331	3	j	int
    //   3	715	4	l	long
    //   84	689	6	localObject1	Object
    //   12	801	7	localObject2	Object
    //   90	664	8	localObject3	Object
    //   108	565	9	localObject4	Object
    //   741	16	9	localObject5	Object
    //   87	358	10	localObject6	Object
    //   468	29	10	localException	Exception
    //   543	80	10	localInterruptedException	java.lang.InterruptedException
    //   627	22	10	localList	List<String>
    // Exception table:
    //   from	to	target	type
    //   182	236	345	finally
    //   236	243	345	finally
    //   248	291	345	finally
    //   294	299	345	finally
    //   303	309	345	finally
    //   309	324	345	finally
    //   182	236	349	java/lang/Exception
    //   236	243	349	java/lang/Exception
    //   248	291	349	java/lang/Exception
    //   294	299	349	java/lang/Exception
    //   303	309	349	java/lang/Exception
    //   309	324	349	java/lang/Exception
    //   182	236	353	java/lang/InterruptedException
    //   236	243	353	java/lang/InterruptedException
    //   248	291	353	java/lang/InterruptedException
    //   294	299	353	java/lang/InterruptedException
    //   303	309	353	java/lang/InterruptedException
    //   309	324	353	java/lang/InterruptedException
    //   182	236	357	java/io/IOException
    //   236	243	357	java/io/IOException
    //   248	291	357	java/io/IOException
    //   294	299	357	java/io/IOException
    //   303	309	357	java/io/IOException
    //   309	324	357	java/io/IOException
    //   171	182	361	finally
    //   171	182	368	java/lang/Exception
    //   171	182	375	java/lang/InterruptedException
    //   171	182	382	java/io/IOException
    //   161	171	389	finally
    //   161	171	393	java/lang/Exception
    //   161	171	414	java/lang/InterruptedException
    //   161	171	435	java/io/IOException
    //   92	110	456	finally
    //   114	122	456	finally
    //   122	131	456	finally
    //   135	141	456	finally
    //   141	153	456	finally
    //   155	161	456	finally
    //   92	110	468	java/lang/Exception
    //   114	122	468	java/lang/Exception
    //   122	131	468	java/lang/Exception
    //   135	141	468	java/lang/Exception
    //   141	153	468	java/lang/Exception
    //   155	161	468	java/lang/Exception
    //   92	110	543	java/lang/InterruptedException
    //   114	122	543	java/lang/InterruptedException
    //   122	131	543	java/lang/InterruptedException
    //   135	141	543	java/lang/InterruptedException
    //   141	153	543	java/lang/InterruptedException
    //   155	161	543	java/lang/InterruptedException
    //   92	110	614	java/io/IOException
    //   114	122	614	java/io/IOException
    //   122	131	614	java/io/IOException
    //   135	141	614	java/io/IOException
    //   141	153	614	java/io/IOException
    //   155	161	614	java/io/IOException
    //   491	501	741	finally
    //   570	580	741	finally
    //   643	653	741	finally
    //   328	332	795	java/io/IOException
    //   332	342	795	java/io/IOException
    //   508	513	799	java/io/IOException
    //   523	528	799	java/io/IOException
    //   533	538	799	java/io/IOException
    //   587	592	799	java/io/IOException
    //   599	604	799	java/io/IOException
    //   660	665	799	java/io/IOException
    //   672	677	799	java/io/IOException
    //   763	767	803	java/io/IOException
    //   772	777	803	java/io/IOException
    //   782	787	803	java/io/IOException
  }
  
  private static List<String> generateCommand(String paramString1, String paramString2, VideoConverterConfig paramVideoConverterConfig)
  {
    if (getCpuCores() >= 2) {
      str = "2";
    } else {
      str = "1";
    }
    Object localObject1 = new StringBuilder(String.valueOf(paramVideoConverterConfig.destWidth));
    ((StringBuilder)localObject1).append("x");
    ((StringBuilder)localObject1).append(paramVideoConverterConfig.destHeight);
    localObject1 = ((StringBuilder)localObject1).toString();
    if (ConvertLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generateCommand threads=");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("  resolution=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ConvertLog.d("SoftwareConverter", 2, new Object[] { ((StringBuilder)localObject2).toString() });
    }
    Object localObject2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rotate=");
    localStringBuilder.append(paramVideoConverterConfig.rotate);
    ((List)localObject2).addAll(Arrays.asList(new String[] { "-d", "-y", "-threads", str, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", localStringBuilder.toString(), "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k" }));
    paramString1 = new StringBuilder();
    paramString1.append(paramVideoConverterConfig.videoBitRate);
    paramString1.append("k");
    String str = paramString1.toString();
    if ((paramVideoConverterConfig.videoBitRate > 0) && (paramVideoConverterConfig.videoFrameRate > 0))
    {
      paramString1 = new String[8];
      paramString1[0] = "-minrate";
      paramString1[1] = str;
      paramString1[2] = "-maxrate";
      paramString1[3] = str;
      paramString1[4] = "-b";
      paramString1[5] = str;
      paramString1[6] = "-r";
      paramString1[7] = String.valueOf(paramVideoConverterConfig.videoFrameRate);
    }
    else
    {
      paramString1 = new String[8];
      paramString1[0] = "-minrate";
      paramString1[1] = "300k";
      paramString1[2] = "-maxrate";
      paramString1[3] = "600k";
      paramString1[4] = "-qmin";
      paramString1[5] = "1";
      paramString1[6] = "-qmax";
      paramString1[7] = String.valueOf(paramVideoConverterConfig.destQmax);
    }
    ((List)localObject2).addAll(Arrays.asList(paramString1));
    ((List)localObject2).addAll(Arrays.asList(new String[] { "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", localObject1, "-movflags", "faststart", paramString2 }));
    return localObject2;
  }
  
  public static int getCpuCores()
  {
    if (sCpuCores == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new SoftwareConverter.1CpuFilter());
      if (arrayOfFile == null) {
        return 1;
      }
      sCpuCores = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      label41:
      break label41;
    }
    sCpuCores = 1;
    return sCpuCores;
  }
  
  public static void setFFmpegBinAndSoPath(String paramString1, String paramString2)
  {
    ffmpegBinFullPath = paramString1;
    ffmpegSoFullPath = paramString2;
  }
  
  public static boolean supportCodec()
  {
    int i;
    if ((!TextUtils.isEmpty(ffmpegBinFullPath)) && (new File(ffmpegBinFullPath).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((!TextUtils.isEmpty(ffmpegSoFullPath)) && (new File(ffmpegSoFullPath).exists())) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.SoftwareConverter
 * JD-Core Version:    0.7.0.1
 */