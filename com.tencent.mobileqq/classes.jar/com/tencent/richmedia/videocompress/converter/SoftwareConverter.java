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
    int i;
    if (!localVideoConverterConfig.isNeedCompress)
    {
      if (ConvertLog.isColorLevel()) {
        ConvertLog.d("SoftwareConverter", 2, new Object[] { "compressVideo error, isNeedCompress is false" });
      }
      i = -1;
    }
    int j;
    for (;;)
    {
      return i;
      File localFile = new File(localVideoConverterConfig.output);
      if (localFile.exists()) {
        localFile.delete();
      }
      j = executeFFmpegCmd(generateCommand(paramString, localVideoConverterConfig.output, localVideoConverterConfig), paramProcessCallBack);
      i = j;
      if (j != 0) {
        try
        {
          paramString = new File(localVideoConverterConfig.output);
          i = j;
          if (paramString.exists())
          {
            paramString.delete();
            i = j;
            if (ConvertLog.isColorLevel())
            {
              ConvertLog.d("SoftwareConverter", 2, new Object[] { "compressVideo, delete video, ret=", Integer.valueOf(j) });
              return j;
            }
          }
        }
        catch (Exception paramString)
        {
          ConvertLog.e("SoftwareConverter", 1, "compressVideo, delete video exception", paramString);
        }
      }
    }
    return j;
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
    //   12: astore 6
    //   14: aload 6
    //   16: getstatic 106	com/tencent/richmedia/videocompress/converter/SoftwareConverter:ffmpegBinFullPath	Ljava/lang/String;
    //   19: invokeinterface 112 2 0
    //   24: pop
    //   25: aload 6
    //   27: aload_0
    //   28: invokeinterface 116 2 0
    //   33: pop
    //   34: aload 6
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
    //   83: new 124	java/lang/ProcessBuilder
    //   86: dup
    //   87: aload 6
    //   89: invokespecial 127	java/lang/ProcessBuilder:<init>	(Ljava/util/List;)V
    //   92: iconst_1
    //   93: invokevirtual 131	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   96: invokevirtual 135	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   99: astore 11
    //   101: aload_1
    //   102: ifnull +11 -> 113
    //   105: aload_1
    //   106: aload 11
    //   108: invokeinterface 139 2 0
    //   113: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   116: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   119: ifne +65 -> 184
    //   122: aload_1
    //   123: ifnull +9 -> 132
    //   126: aload_1
    //   127: invokeinterface 145 1 0
    //   132: aload 11
    //   134: invokevirtual 150	java/lang/Process:destroy	()V
    //   137: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   140: iconst_1
    //   141: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   144: iconst_m1
    //   145: istore_3
    //   146: iconst_0
    //   147: ifeq +11 -> 158
    //   150: new 155	java/lang/NullPointerException
    //   153: dup
    //   154: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   157: athrow
    //   158: iconst_0
    //   159: ifeq +11 -> 170
    //   162: new 155	java/lang/NullPointerException
    //   165: dup
    //   166: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   169: athrow
    //   170: iconst_0
    //   171: ifeq +11 -> 182
    //   174: new 155	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 156	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: iload_3
    //   183: ireturn
    //   184: aload 11
    //   186: invokevirtual 160	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   189: astore_0
    //   190: new 162	java/io/InputStreamReader
    //   193: dup
    //   194: aload_0
    //   195: invokespecial 165	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   198: astore 6
    //   200: new 167	java/io/BufferedReader
    //   203: dup
    //   204: aload 6
    //   206: invokespecial 170	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   209: astore 10
    //   211: aload 10
    //   213: astore 9
    //   215: aload 6
    //   217: astore 8
    //   219: aload_0
    //   220: astore 7
    //   222: aload 11
    //   224: invokevirtual 174	java/lang/Process:waitFor	()I
    //   227: pop
    //   228: aload 10
    //   230: astore 9
    //   232: aload 6
    //   234: astore 8
    //   236: aload_0
    //   237: astore 7
    //   239: aload 11
    //   241: invokevirtual 177	java/lang/Process:exitValue	()I
    //   244: istore_3
    //   245: aload 10
    //   247: astore 9
    //   249: aload 6
    //   251: astore 8
    //   253: aload_0
    //   254: astore 7
    //   256: ldc 8
    //   258: iconst_2
    //   259: iconst_1
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: new 179	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   272: ldc 182
    //   274: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_3
    //   278: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aastore
    //   285: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   288: aload 10
    //   290: astore 9
    //   292: aload 6
    //   294: astore 8
    //   296: aload_0
    //   297: astore 7
    //   299: aload 10
    //   301: invokevirtual 196	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   304: astore 12
    //   306: aload 12
    //   308: ifnull +169 -> 477
    //   311: aload 10
    //   313: astore 9
    //   315: aload 6
    //   317: astore 8
    //   319: aload_0
    //   320: astore 7
    //   322: ldc 8
    //   324: iconst_2
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: new 179	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   338: ldc 198
    //   340: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 12
    //   345: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: aastore
    //   352: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   355: goto -67 -> 288
    //   358: astore 7
    //   360: aload 10
    //   362: astore_1
    //   363: aload 7
    //   365: astore 10
    //   367: sipush -1001
    //   370: istore_3
    //   371: aload_1
    //   372: astore 9
    //   374: aload 6
    //   376: astore 8
    //   378: aload_0
    //   379: astore 7
    //   381: ldc 8
    //   383: iconst_1
    //   384: ldc 200
    //   386: aload 10
    //   388: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_0
    //   392: ifnull +7 -> 399
    //   395: aload_0
    //   396: invokevirtual 205	java/io/InputStream:close	()V
    //   399: aload 6
    //   401: ifnull +8 -> 409
    //   404: aload 6
    //   406: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   409: iload_3
    //   410: istore_2
    //   411: aload_1
    //   412: ifnull +9 -> 421
    //   415: aload_1
    //   416: invokevirtual 207	java/io/BufferedReader:close	()V
    //   419: iload_3
    //   420: istore_2
    //   421: getstatic 24	com/tencent/richmedia/videocompress/converter/SoftwareConverter:continueCompress	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   424: iconst_1
    //   425: invokevirtual 153	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   428: iload_2
    //   429: istore_3
    //   430: invokestatic 49	com/tencent/richmedia/videocompress/utils/ConvertLog:isColorLevel	()Z
    //   433: ifeq -251 -> 182
    //   436: ldc 8
    //   438: iconst_2
    //   439: iconst_4
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: ldc 209
    //   447: aastore
    //   448: dup
    //   449: iconst_1
    //   450: invokestatic 101	java/lang/System:currentTimeMillis	()J
    //   453: lload 4
    //   455: lsub
    //   456: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   459: aastore
    //   460: dup
    //   461: iconst_2
    //   462: ldc 216
    //   464: aastore
    //   465: dup
    //   466: iconst_3
    //   467: iload_2
    //   468: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   475: iload_2
    //   476: ireturn
    //   477: aload 10
    //   479: astore 9
    //   481: aload 6
    //   483: astore 8
    //   485: aload_0
    //   486: astore 7
    //   488: aload 11
    //   490: invokevirtual 150	java/lang/Process:destroy	()V
    //   493: aload_1
    //   494: ifnull +20 -> 514
    //   497: aload 10
    //   499: astore 9
    //   501: aload 6
    //   503: astore 8
    //   505: aload_0
    //   506: astore 7
    //   508: aload_1
    //   509: invokeinterface 219 1 0
    //   514: aload 10
    //   516: astore 9
    //   518: aload 6
    //   520: astore 8
    //   522: aload_0
    //   523: astore 7
    //   525: ldc 8
    //   527: iconst_1
    //   528: iconst_1
    //   529: anewarray 4	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: ldc 221
    //   536: aastore
    //   537: invokestatic 55	com/tencent/richmedia/videocompress/utils/ConvertLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   540: aload_0
    //   541: ifnull +7 -> 548
    //   544: aload_0
    //   545: invokevirtual 205	java/io/InputStream:close	()V
    //   548: aload 6
    //   550: ifnull +8 -> 558
    //   553: aload 6
    //   555: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   558: iload_3
    //   559: istore_2
    //   560: aload 10
    //   562: ifnull -141 -> 421
    //   565: aload 10
    //   567: invokevirtual 207	java/io/BufferedReader:close	()V
    //   570: iload_3
    //   571: istore_2
    //   572: goto -151 -> 421
    //   575: astore_0
    //   576: iload_3
    //   577: istore_2
    //   578: goto -157 -> 421
    //   581: astore 11
    //   583: aconst_null
    //   584: astore_0
    //   585: aconst_null
    //   586: astore 6
    //   588: aconst_null
    //   589: astore_1
    //   590: sipush -1002
    //   593: istore_3
    //   594: aload_1
    //   595: astore 9
    //   597: aload 6
    //   599: astore 8
    //   601: aload_0
    //   602: astore 7
    //   604: ldc 8
    //   606: iconst_1
    //   607: ldc 223
    //   609: aload 11
    //   611: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload_0
    //   615: ifnull +7 -> 622
    //   618: aload_0
    //   619: invokevirtual 205	java/io/InputStream:close	()V
    //   622: aload 6
    //   624: ifnull +8 -> 632
    //   627: aload 6
    //   629: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   632: iload_3
    //   633: istore_2
    //   634: aload_1
    //   635: ifnull -214 -> 421
    //   638: aload_1
    //   639: invokevirtual 207	java/io/BufferedReader:close	()V
    //   642: iload_3
    //   643: istore_2
    //   644: goto -223 -> 421
    //   647: astore_0
    //   648: iload_3
    //   649: istore_2
    //   650: goto -229 -> 421
    //   653: astore 11
    //   655: aconst_null
    //   656: astore_0
    //   657: aconst_null
    //   658: astore 6
    //   660: aconst_null
    //   661: astore_1
    //   662: sipush -1003
    //   665: istore_3
    //   666: aload_1
    //   667: astore 9
    //   669: aload 6
    //   671: astore 8
    //   673: aload_0
    //   674: astore 7
    //   676: ldc 8
    //   678: iconst_1
    //   679: ldc 225
    //   681: aload 11
    //   683: invokestatic 91	com/tencent/richmedia/videocompress/utils/ConvertLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload_0
    //   687: ifnull +7 -> 694
    //   690: aload_0
    //   691: invokevirtual 205	java/io/InputStream:close	()V
    //   694: aload 6
    //   696: ifnull +8 -> 704
    //   699: aload 6
    //   701: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   704: iload_3
    //   705: istore_2
    //   706: aload_1
    //   707: ifnull -286 -> 421
    //   710: aload_1
    //   711: invokevirtual 207	java/io/BufferedReader:close	()V
    //   714: iload_3
    //   715: istore_2
    //   716: goto -295 -> 421
    //   719: astore_0
    //   720: iload_3
    //   721: istore_2
    //   722: goto -301 -> 421
    //   725: astore_1
    //   726: aconst_null
    //   727: astore_0
    //   728: aconst_null
    //   729: astore 6
    //   731: aconst_null
    //   732: astore 9
    //   734: aload_0
    //   735: ifnull +7 -> 742
    //   738: aload_0
    //   739: invokevirtual 205	java/io/InputStream:close	()V
    //   742: aload 6
    //   744: ifnull +8 -> 752
    //   747: aload 6
    //   749: invokevirtual 206	java/io/InputStreamReader:close	()V
    //   752: aload 9
    //   754: ifnull +8 -> 762
    //   757: aload 9
    //   759: invokevirtual 207	java/io/BufferedReader:close	()V
    //   762: aload_1
    //   763: athrow
    //   764: astore_0
    //   765: goto -3 -> 762
    //   768: astore_1
    //   769: aconst_null
    //   770: astore 6
    //   772: aconst_null
    //   773: astore 9
    //   775: goto -41 -> 734
    //   778: astore_1
    //   779: aconst_null
    //   780: astore 9
    //   782: goto -48 -> 734
    //   785: astore_1
    //   786: aload 8
    //   788: astore 6
    //   790: aload 7
    //   792: astore_0
    //   793: goto -59 -> 734
    //   796: astore 11
    //   798: aconst_null
    //   799: astore 6
    //   801: aconst_null
    //   802: astore_1
    //   803: goto -141 -> 662
    //   806: astore 11
    //   808: aconst_null
    //   809: astore_1
    //   810: goto -148 -> 662
    //   813: astore 11
    //   815: aload 10
    //   817: astore_1
    //   818: goto -156 -> 662
    //   821: astore 11
    //   823: aconst_null
    //   824: astore 6
    //   826: aconst_null
    //   827: astore_1
    //   828: goto -238 -> 590
    //   831: astore 11
    //   833: aconst_null
    //   834: astore_1
    //   835: goto -245 -> 590
    //   838: astore 11
    //   840: aload 10
    //   842: astore_1
    //   843: goto -253 -> 590
    //   846: astore_0
    //   847: iload_3
    //   848: istore_2
    //   849: goto -428 -> 421
    //   852: astore 10
    //   854: aconst_null
    //   855: astore_0
    //   856: aconst_null
    //   857: astore 6
    //   859: aconst_null
    //   860: astore_1
    //   861: goto -494 -> 367
    //   864: astore 10
    //   866: aconst_null
    //   867: astore 6
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -504 -> 367
    //   874: astore 10
    //   876: aconst_null
    //   877: astore_1
    //   878: goto -511 -> 367
    //   881: astore_0
    //   882: iconst_m1
    //   883: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	884	0	paramList	List<String>
    //   0	884	1	paramProcessCallBack	SoftwareConverter.ProcessCallBack
    //   410	439	2	i	int
    //   145	703	3	j	int
    //   3	451	4	l	long
    //   12	856	6	localObject1	Object
    //   220	101	7	localList1	List<String>
    //   358	6	7	localIOException1	java.io.IOException
    //   379	412	7	localList2	List<String>
    //   217	570	8	localObject2	Object
    //   213	568	9	localObject3	Object
    //   209	632	10	localObject4	Object
    //   852	1	10	localIOException2	java.io.IOException
    //   864	1	10	localIOException3	java.io.IOException
    //   874	1	10	localIOException4	java.io.IOException
    //   99	390	11	localProcess	java.lang.Process
    //   581	29	11	localInterruptedException1	java.lang.InterruptedException
    //   653	29	11	localException1	Exception
    //   796	1	11	localException2	Exception
    //   806	1	11	localException3	Exception
    //   813	1	11	localException4	Exception
    //   821	1	11	localInterruptedException2	java.lang.InterruptedException
    //   831	1	11	localInterruptedException3	java.lang.InterruptedException
    //   838	1	11	localInterruptedException4	java.lang.InterruptedException
    //   304	40	12	str	String
    // Exception table:
    //   from	to	target	type
    //   222	228	358	java/io/IOException
    //   239	245	358	java/io/IOException
    //   256	288	358	java/io/IOException
    //   299	306	358	java/io/IOException
    //   322	355	358	java/io/IOException
    //   488	493	358	java/io/IOException
    //   508	514	358	java/io/IOException
    //   525	540	358	java/io/IOException
    //   544	548	575	java/io/IOException
    //   553	558	575	java/io/IOException
    //   565	570	575	java/io/IOException
    //   83	101	581	java/lang/InterruptedException
    //   105	113	581	java/lang/InterruptedException
    //   113	122	581	java/lang/InterruptedException
    //   126	132	581	java/lang/InterruptedException
    //   132	144	581	java/lang/InterruptedException
    //   184	190	581	java/lang/InterruptedException
    //   618	622	647	java/io/IOException
    //   627	632	647	java/io/IOException
    //   638	642	647	java/io/IOException
    //   83	101	653	java/lang/Exception
    //   105	113	653	java/lang/Exception
    //   113	122	653	java/lang/Exception
    //   126	132	653	java/lang/Exception
    //   132	144	653	java/lang/Exception
    //   184	190	653	java/lang/Exception
    //   690	694	719	java/io/IOException
    //   699	704	719	java/io/IOException
    //   710	714	719	java/io/IOException
    //   83	101	725	finally
    //   105	113	725	finally
    //   113	122	725	finally
    //   126	132	725	finally
    //   132	144	725	finally
    //   184	190	725	finally
    //   738	742	764	java/io/IOException
    //   747	752	764	java/io/IOException
    //   757	762	764	java/io/IOException
    //   190	200	768	finally
    //   200	211	778	finally
    //   222	228	785	finally
    //   239	245	785	finally
    //   256	288	785	finally
    //   299	306	785	finally
    //   322	355	785	finally
    //   381	391	785	finally
    //   488	493	785	finally
    //   508	514	785	finally
    //   525	540	785	finally
    //   604	614	785	finally
    //   676	686	785	finally
    //   190	200	796	java/lang/Exception
    //   200	211	806	java/lang/Exception
    //   222	228	813	java/lang/Exception
    //   239	245	813	java/lang/Exception
    //   256	288	813	java/lang/Exception
    //   299	306	813	java/lang/Exception
    //   322	355	813	java/lang/Exception
    //   488	493	813	java/lang/Exception
    //   508	514	813	java/lang/Exception
    //   525	540	813	java/lang/Exception
    //   190	200	821	java/lang/InterruptedException
    //   200	211	831	java/lang/InterruptedException
    //   222	228	838	java/lang/InterruptedException
    //   239	245	838	java/lang/InterruptedException
    //   256	288	838	java/lang/InterruptedException
    //   299	306	838	java/lang/InterruptedException
    //   322	355	838	java/lang/InterruptedException
    //   488	493	838	java/lang/InterruptedException
    //   508	514	838	java/lang/InterruptedException
    //   525	540	838	java/lang/InterruptedException
    //   395	399	846	java/io/IOException
    //   404	409	846	java/io/IOException
    //   415	419	846	java/io/IOException
    //   83	101	852	java/io/IOException
    //   105	113	852	java/io/IOException
    //   113	122	852	java/io/IOException
    //   126	132	852	java/io/IOException
    //   132	144	852	java/io/IOException
    //   184	190	852	java/io/IOException
    //   190	200	864	java/io/IOException
    //   200	211	874	java/io/IOException
    //   150	158	881	java/io/IOException
    //   162	170	881	java/io/IOException
    //   174	182	881	java/io/IOException
  }
  
  private static List<String> generateCommand(String paramString1, String paramString2, VideoConverterConfig paramVideoConverterConfig)
  {
    String str1 = "1";
    if (getCpuCores() >= 2) {
      str1 = "2";
    }
    String str2 = paramVideoConverterConfig.destWidth + "x" + paramVideoConverterConfig.destHeight;
    if (ConvertLog.isColorLevel()) {
      ConvertLog.d("SoftwareConverter", 2, new Object[] { "generateCommand threads=" + str1 + "  resolution=" + str2 });
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(new String[] { "-d", "-y", "-threads", str1, "-copyts", "-copytb", "0", "-i", paramString1, "-metadata:s", "rotate=" + paramVideoConverterConfig.rotate, "-acodec", "aac", "-vcodec", "libx264", "-preset", "ultrafast", "-tune", "fastdecode", "-profile:v", "High", "-level", "1.3", "-bufsize", "800k" }));
    str1 = paramVideoConverterConfig.videoBitRate + "k";
    if ((paramVideoConverterConfig.videoBitRate > 0) && (paramVideoConverterConfig.videoFrameRate > 0))
    {
      paramString1 = new String[8];
      paramString1[0] = "-minrate";
      paramString1[1] = str1;
      paramString1[2] = "-maxrate";
      paramString1[3] = str1;
      paramString1[4] = "-b";
      paramString1[5] = str1;
      paramString1[6] = "-r";
      paramString1[7] = String.valueOf(paramVideoConverterConfig.videoFrameRate);
    }
    for (;;)
    {
      localArrayList.addAll(Arrays.asList(paramString1));
      localArrayList.addAll(Arrays.asList(new String[] { "-qdiff", "3", "-bf", "3", "-coder", "1", "-refs", "1", "-s", str2, "-movflags", "faststart", paramString2 }));
      return localArrayList;
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
      for (;;)
      {
        sCpuCores = 1;
      }
    }
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
    if ((!TextUtils.isEmpty(ffmpegBinFullPath)) && (new File(ffmpegBinFullPath).exists()))
    {
      i = 1;
      if ((TextUtils.isEmpty(ffmpegSoFullPath)) || (!new File(ffmpegSoFullPath).exists())) {
        break label69;
      }
    }
    label69:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label74;
      }
      return true;
      i = 0;
      break;
    }
    label74:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.SoftwareConverter
 * JD-Core Version:    0.7.0.1
 */