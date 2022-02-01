package com.tencent.mobileqq.haoliyou;

import android.net.Uri;
import avpx;
import java.io.InputStream;

public class UriParserPathHelper$3
  implements Runnable
{
  public UriParserPathHelper$3(avpx paramavpx, String paramString, InputStream paramInputStream, long paramLong, Uri paramUri) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: new 34	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield 19	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 13
    //   25: aload 13
    //   27: invokevirtual 41	java/io/File:exists	()Z
    //   30: ifne +54 -> 84
    //   33: aload 13
    //   35: invokevirtual 44	java/io/File:createNewFile	()Z
    //   38: ifne +46 -> 84
    //   41: aload_0
    //   42: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   45: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   48: iconst_1
    //   49: invokevirtual 55	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   52: pop
    //   53: iconst_0
    //   54: ifeq +10 -> 64
    //   57: invokestatic 61	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   60: aconst_null
    //   61: invokevirtual 65	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   64: aload_0
    //   65: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   68: iconst_0
    //   69: putfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   72: aload_0
    //   73: getfield 21	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: invokestatic 74	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   79: aconst_null
    //   80: invokestatic 77	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   83: return
    //   84: new 79	java/io/FileOutputStream
    //   87: dup
    //   88: aload_0
    //   89: getfield 19	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   95: astore 11
    //   97: aload 12
    //   99: astore 10
    //   101: aload 11
    //   103: astore 9
    //   105: invokestatic 61	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   108: sipush 8192
    //   111: invokevirtual 84	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   114: astore 12
    //   116: lconst_0
    //   117: lstore 6
    //   119: lconst_0
    //   120: lstore_2
    //   121: aload 12
    //   123: astore 10
    //   125: aload 12
    //   127: astore 8
    //   129: aload 11
    //   131: astore 9
    //   133: aload_0
    //   134: getfield 21	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   137: aload 12
    //   139: invokevirtual 90	java/io/InputStream:read	([B)I
    //   142: istore_1
    //   143: iload_1
    //   144: iconst_m1
    //   145: if_icmpeq +145 -> 290
    //   148: aload 12
    //   150: astore 10
    //   152: aload 12
    //   154: astore 8
    //   156: aload 11
    //   158: astore 9
    //   160: aload_0
    //   161: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   164: getfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   167: ifeq +123 -> 290
    //   170: lload_2
    //   171: iload_1
    //   172: i2l
    //   173: ladd
    //   174: lstore 4
    //   176: aload 12
    //   178: astore 10
    //   180: aload 12
    //   182: astore 8
    //   184: aload 11
    //   186: astore 9
    //   188: aload 11
    //   190: aload 12
    //   192: iconst_0
    //   193: iload_1
    //   194: invokevirtual 94	java/io/FileOutputStream:write	([BII)V
    //   197: lload 4
    //   199: lstore_2
    //   200: aload 12
    //   202: astore 10
    //   204: aload 12
    //   206: astore 8
    //   208: aload 11
    //   210: astore 9
    //   212: lload 4
    //   214: lload 6
    //   216: lsub
    //   217: l2d
    //   218: aload_0
    //   219: getfield 23	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_Long	J
    //   222: l2d
    //   223: ddiv
    //   224: ldc2_w 95
    //   227: dcmpl
    //   228: ifle -107 -> 121
    //   231: aload 12
    //   233: astore 10
    //   235: aload 12
    //   237: astore 8
    //   239: aload 11
    //   241: astore 9
    //   243: aload_0
    //   244: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   247: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   250: aload_0
    //   251: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   254: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   257: iconst_3
    //   258: lload 4
    //   260: l2d
    //   261: aload_0
    //   262: getfield 23	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_Long	J
    //   265: l2d
    //   266: ddiv
    //   267: ldc2_w 97
    //   270: dmul
    //   271: d2i
    //   272: iconst_0
    //   273: invokevirtual 102	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   276: invokevirtual 106	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   279: pop
    //   280: lload 4
    //   282: lstore 6
    //   284: lload 4
    //   286: lstore_2
    //   287: goto -166 -> 121
    //   290: lload_2
    //   291: lconst_0
    //   292: lcmp
    //   293: ifne +81 -> 374
    //   296: aload 12
    //   298: astore 10
    //   300: aload 12
    //   302: astore 8
    //   304: aload 11
    //   306: astore 9
    //   308: aload_0
    //   309: getfield 25	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   312: invokevirtual 112	android/net/Uri:toString	()Ljava/lang/String;
    //   315: ldc 114
    //   317: invokevirtual 120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +283 -> 603
    //   323: aload 12
    //   325: astore 10
    //   327: aload 12
    //   329: astore 8
    //   331: aload 11
    //   333: astore 9
    //   335: aload_0
    //   336: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   339: getfield 123	avpx:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   342: ldc 124
    //   344: invokevirtual 130	android/content/Context:getString	(I)Ljava/lang/String;
    //   347: putstatic 131	avpx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: aload 12
    //   352: astore 10
    //   354: aload 12
    //   356: astore 8
    //   358: aload 11
    //   360: astore 9
    //   362: aload_0
    //   363: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   366: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   369: iconst_1
    //   370: invokevirtual 55	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   373: pop
    //   374: aload 12
    //   376: astore 10
    //   378: aload 12
    //   380: astore 8
    //   382: aload 11
    //   384: astore 9
    //   386: aload_0
    //   387: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   390: getfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   393: ifeq +314 -> 707
    //   396: aload 12
    //   398: astore 10
    //   400: aload 12
    //   402: astore 8
    //   404: aload 11
    //   406: astore 9
    //   408: aload_0
    //   409: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   412: invokestatic 134	avpx:a	(Lavpx;)Lavqd;
    //   415: ifnull +59 -> 474
    //   418: aload 12
    //   420: astore 10
    //   422: aload 12
    //   424: astore 8
    //   426: aload 11
    //   428: astore 9
    //   430: aload_0
    //   431: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   434: invokestatic 134	avpx:a	(Lavpx;)Lavqd;
    //   437: aload 13
    //   439: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   442: aload 13
    //   444: invokevirtual 140	java/io/File:getName	()Ljava/lang/String;
    //   447: lload_2
    //   448: invokeinterface 145 5 0
    //   453: aload 12
    //   455: astore 10
    //   457: aload 12
    //   459: astore 8
    //   461: aload 11
    //   463: astore 9
    //   465: aload_0
    //   466: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   469: aconst_null
    //   470: invokestatic 148	avpx:a	(Lavpx;Lavqd;)Lavqd;
    //   473: pop
    //   474: aload 12
    //   476: astore 10
    //   478: aload 12
    //   480: astore 8
    //   482: aload 11
    //   484: astore 9
    //   486: invokestatic 151	avpx:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   489: aload_0
    //   490: getfield 25	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   493: invokevirtual 112	android/net/Uri:toString	()Ljava/lang/String;
    //   496: aload 13
    //   498: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   501: invokevirtual 157	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 12
    //   507: astore 10
    //   509: aload 12
    //   511: astore 8
    //   513: aload 11
    //   515: astore 9
    //   517: aload_0
    //   518: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   521: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   524: aload_0
    //   525: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   528: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   531: iconst_3
    //   532: bipush 100
    //   534: iconst_0
    //   535: invokevirtual 102	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   538: invokevirtual 106	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   541: pop
    //   542: aload 12
    //   544: astore 10
    //   546: aload 12
    //   548: astore 8
    //   550: aload 11
    //   552: astore 9
    //   554: aload_0
    //   555: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   558: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   561: iconst_2
    //   562: ldc2_w 158
    //   565: invokevirtual 163	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   568: pop
    //   569: aload 12
    //   571: ifnull +11 -> 582
    //   574: invokestatic 61	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   577: aload 12
    //   579: invokevirtual 65	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   582: aload_0
    //   583: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   586: iconst_0
    //   587: putfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   590: aload_0
    //   591: getfield 21	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   594: invokestatic 74	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   597: aload 11
    //   599: invokestatic 77	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   602: return
    //   603: aload 12
    //   605: astore 10
    //   607: aload 12
    //   609: astore 8
    //   611: aload 11
    //   613: astore 9
    //   615: aload_0
    //   616: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   619: getfield 123	avpx:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   622: ldc 164
    //   624: invokevirtual 130	android/content/Context:getString	(I)Ljava/lang/String;
    //   627: putstatic 131	avpx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   630: goto -280 -> 350
    //   633: astore 12
    //   635: aload 10
    //   637: astore 8
    //   639: aload 11
    //   641: astore 9
    //   643: ldc 166
    //   645: iconst_1
    //   646: ldc 168
    //   648: aload 12
    //   650: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   653: aload 10
    //   655: astore 8
    //   657: aload 11
    //   659: astore 9
    //   661: aload_0
    //   662: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   665: invokestatic 49	avpx:a	(Lavpx;)Lmqq/os/MqqHandler;
    //   668: iconst_1
    //   669: invokevirtual 55	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   672: pop
    //   673: aload 10
    //   675: ifnull +11 -> 686
    //   678: invokestatic 61	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   681: aload 10
    //   683: invokevirtual 65	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   686: aload_0
    //   687: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   690: iconst_0
    //   691: putfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   694: aload_0
    //   695: getfield 21	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   698: invokestatic 74	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   701: aload 11
    //   703: invokestatic 77	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   706: return
    //   707: aload 12
    //   709: astore 10
    //   711: aload 12
    //   713: astore 8
    //   715: aload 11
    //   717: astore 9
    //   719: aload 11
    //   721: invokestatic 77	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   724: aload 12
    //   726: astore 10
    //   728: aload 12
    //   730: astore 8
    //   732: aload 11
    //   734: astore 9
    //   736: aload 13
    //   738: invokevirtual 177	java/io/File:delete	()Z
    //   741: pop
    //   742: goto -173 -> 569
    //   745: astore 11
    //   747: aload 9
    //   749: astore 10
    //   751: aload 8
    //   753: astore 9
    //   755: aload 11
    //   757: astore 8
    //   759: aload 9
    //   761: ifnull +11 -> 772
    //   764: invokestatic 61	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   767: aload 9
    //   769: invokevirtual 65	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   772: aload_0
    //   773: getfield 17	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:this$0	Lavpx;
    //   776: iconst_0
    //   777: putfield 68	avpx:jdField_a_of_type_Boolean	Z
    //   780: aload_0
    //   781: getfield 21	com/tencent/mobileqq/haoliyou/UriParserPathHelper$3:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   784: invokestatic 74	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   787: aload 10
    //   789: invokestatic 77	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   792: aload 8
    //   794: athrow
    //   795: astore 8
    //   797: aconst_null
    //   798: astore 10
    //   800: goto -41 -> 759
    //   803: astore 12
    //   805: aconst_null
    //   806: astore 11
    //   808: goto -173 -> 635
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	3
    //   142	52	1	i	int
    //   120	328	2	l1	long
    //   174	111	4	l2	long
    //   117	166	6	l3	long
    //   4	789	8	localObject1	Object
    //   795	1	8	localObject2	Object
    //   7	761	9	localObject3	Object
    //   1	798	10	localObject4	Object
    //   95	638	11	localFileOutputStream	java.io.FileOutputStream
    //   745	11	11	localObject5	Object
    //   806	1	11	localObject6	Object
    //   10	598	12	arrayOfByte	byte[]
    //   633	96	12	localException1	java.lang.Exception
    //   803	1	12	localException2	java.lang.Exception
    //   23	714	13	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   105	116	633	java/lang/Exception
    //   133	143	633	java/lang/Exception
    //   160	170	633	java/lang/Exception
    //   188	197	633	java/lang/Exception
    //   212	231	633	java/lang/Exception
    //   243	280	633	java/lang/Exception
    //   308	323	633	java/lang/Exception
    //   335	350	633	java/lang/Exception
    //   362	374	633	java/lang/Exception
    //   386	396	633	java/lang/Exception
    //   408	418	633	java/lang/Exception
    //   430	453	633	java/lang/Exception
    //   465	474	633	java/lang/Exception
    //   486	505	633	java/lang/Exception
    //   517	542	633	java/lang/Exception
    //   554	569	633	java/lang/Exception
    //   615	630	633	java/lang/Exception
    //   719	724	633	java/lang/Exception
    //   736	742	633	java/lang/Exception
    //   105	116	745	finally
    //   133	143	745	finally
    //   160	170	745	finally
    //   188	197	745	finally
    //   212	231	745	finally
    //   243	280	745	finally
    //   308	323	745	finally
    //   335	350	745	finally
    //   362	374	745	finally
    //   386	396	745	finally
    //   408	418	745	finally
    //   430	453	745	finally
    //   465	474	745	finally
    //   486	505	745	finally
    //   517	542	745	finally
    //   554	569	745	finally
    //   615	630	745	finally
    //   643	653	745	finally
    //   661	673	745	finally
    //   719	724	745	finally
    //   736	742	745	finally
    //   12	53	795	finally
    //   84	97	795	finally
    //   12	53	803	java/lang/Exception
    //   84	97	803	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.UriParserPathHelper.3
 * JD-Core Version:    0.7.0.1
 */