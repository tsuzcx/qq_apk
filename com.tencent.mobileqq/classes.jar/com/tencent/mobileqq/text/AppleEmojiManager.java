package com.tencent.mobileqq.text;

import com.tencent.mobileqq.app.AppConstants;
import java.io.InputStream;
import java.io.OutputStream;

public class AppleEmojiManager
{
  public static final String a = AppConstants.aL + "emojiindex";
  public static final String b = AppConstants.aL + "emojis";
  
  public static final int a(InputStream paramInputStream)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= paramInputStream.read() << i * 8;
      i += 1;
    }
    return j;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    if (i < 4)
    {
      int k = paramArrayOfByte[i];
      if (k >= 0) {}
      for (;;)
      {
        j |= k << i * 8;
        i += 1;
        break;
        k += 256;
      }
    }
    return j;
  }
  
  public static final void a(OutputStream paramOutputStream, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      paramOutputStream.write(paramInt >> i * 8 & 0xFF);
      i += 1;
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 65	java/io/File:exists	()Z
    //   4: ifne +19 -> 23
    //   7: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 72
    //   15: iconst_2
    //   16: ldc 74
    //   18: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: new 61	java/io/File
    //   26: dup
    //   27: getstatic 19	com/tencent/mobileqq/app/AppConstants:aL	Ljava/lang/String;
    //   30: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 65	java/io/File:exists	()Z
    //   40: ifne +9 -> 49
    //   43: aload 5
    //   45: invokevirtual 84	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: invokestatic 90	android/os/SystemClock:uptimeMillis	()J
    //   52: lstore_3
    //   53: aconst_null
    //   54: astore 9
    //   56: aconst_null
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 10
    //   62: aconst_null
    //   63: astore 8
    //   65: new 92	com/tencent/commonsdk/zip/QZipInputStream
    //   68: dup
    //   69: new 94	java/io/BufferedInputStream
    //   72: dup
    //   73: new 96	java/io/FileInputStream
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 102	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: invokespecial 103	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: astore 6
    //   89: new 105	java/io/BufferedOutputStream
    //   92: dup
    //   93: new 107	java/io/FileOutputStream
    //   96: dup
    //   97: getstatic 35	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   100: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   103: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   106: astore 5
    //   108: aload 10
    //   110: astore 7
    //   112: new 113	java/util/HashMap
    //   115: dup
    //   116: aload_0
    //   117: invokevirtual 116	java/io/File:length	()J
    //   120: l2i
    //   121: sipush 1024
    //   124: idiv
    //   125: invokespecial 118	java/util/HashMap:<init>	(I)V
    //   128: astore 12
    //   130: aload 10
    //   132: astore 7
    //   134: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   137: sipush 512
    //   140: invokevirtual 128	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   143: astore_0
    //   144: iconst_0
    //   145: istore_1
    //   146: aload_0
    //   147: astore 7
    //   149: aload 6
    //   151: invokevirtual 132	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   154: astore 10
    //   156: aload 10
    //   158: ifnull +159 -> 317
    //   161: aload_0
    //   162: astore 7
    //   164: aload 10
    //   166: invokevirtual 137	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   169: astore 9
    //   171: aload 9
    //   173: astore 8
    //   175: aload_0
    //   176: astore 7
    //   178: aload 9
    //   180: ldc 139
    //   182: invokevirtual 145	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +25 -> 210
    //   188: aload_0
    //   189: astore 7
    //   191: aload 9
    //   193: aload 9
    //   195: bipush 47
    //   197: invokevirtual 149	java/lang/String:lastIndexOf	(I)I
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 153	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   208: astore 8
    //   210: aload 8
    //   212: ifnull -66 -> 146
    //   215: aload_0
    //   216: astore 7
    //   218: aload 8
    //   220: ldc 158
    //   222: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifne -79 -> 146
    //   228: aload_0
    //   229: astore 7
    //   231: aload 12
    //   233: aload 8
    //   235: iload_1
    //   236: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: invokeinterface 174 3 0
    //   244: pop
    //   245: aload_0
    //   246: astore 7
    //   248: aload 10
    //   250: invokevirtual 177	java/util/zip/ZipEntry:getSize	()J
    //   253: l2i
    //   254: istore_2
    //   255: iload_2
    //   256: iconst_1
    //   257: if_icmplt -111 -> 146
    //   260: aload_0
    //   261: astore 7
    //   263: aload 5
    //   265: iload_2
    //   266: invokestatic 179	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   269: iload_1
    //   270: iconst_4
    //   271: iadd
    //   272: istore_1
    //   273: aload_0
    //   274: astore 7
    //   276: aload 6
    //   278: aload_0
    //   279: invokevirtual 181	com/tencent/commonsdk/zip/QZipInputStream:read	([B)I
    //   282: istore_2
    //   283: iload_2
    //   284: iconst_m1
    //   285: if_icmpeq +21 -> 306
    //   288: aload_0
    //   289: astore 7
    //   291: aload 5
    //   293: aload_0
    //   294: iconst_0
    //   295: iload_2
    //   296: invokevirtual 184	java/io/BufferedOutputStream:write	([BII)V
    //   299: iload_1
    //   300: iload_2
    //   301: iadd
    //   302: istore_1
    //   303: goto -30 -> 273
    //   306: aload_0
    //   307: astore 7
    //   309: aload 5
    //   311: invokevirtual 187	java/io/BufferedOutputStream:flush	()V
    //   314: goto -168 -> 146
    //   317: aload_0
    //   318: astore 7
    //   320: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   323: aload_0
    //   324: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   327: aconst_null
    //   328: astore 8
    //   330: aconst_null
    //   331: astore 11
    //   333: aconst_null
    //   334: astore 7
    //   336: aload 5
    //   338: invokevirtual 194	java/io/BufferedOutputStream:close	()V
    //   341: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +11 -> 355
    //   347: ldc 72
    //   349: iconst_2
    //   350: ldc 196
    //   352: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: new 105	java/io/BufferedOutputStream
    //   358: dup
    //   359: new 107	java/io/FileOutputStream
    //   362: dup
    //   363: getstatic 31	com/tencent/mobileqq/text/AppleEmojiManager:a	Ljava/lang/String;
    //   366: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   369: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   372: astore_0
    //   373: aload 11
    //   375: astore 10
    //   377: aload_0
    //   378: astore 9
    //   380: aload 6
    //   382: astore 8
    //   384: aload 12
    //   386: invokeinterface 200 1 0
    //   391: invokeinterface 206 1 0
    //   396: astore 5
    //   398: aload 11
    //   400: astore 10
    //   402: aload_0
    //   403: astore 9
    //   405: aload 6
    //   407: astore 8
    //   409: aload 5
    //   411: invokeinterface 211 1 0
    //   416: ifeq +581 -> 997
    //   419: aload 11
    //   421: astore 10
    //   423: aload_0
    //   424: astore 9
    //   426: aload 6
    //   428: astore 8
    //   430: aload 5
    //   432: invokeinterface 215 1 0
    //   437: checkcast 141	java/lang/String
    //   440: astore 13
    //   442: aload 11
    //   444: astore 10
    //   446: aload_0
    //   447: astore 9
    //   449: aload 6
    //   451: astore 8
    //   453: aload 13
    //   455: ldc 217
    //   457: invokevirtual 145	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   460: ifne +237 -> 697
    //   463: aload 11
    //   465: astore 10
    //   467: aload_0
    //   468: astore 9
    //   470: aload 6
    //   472: astore 8
    //   474: aload 13
    //   476: iconst_2
    //   477: aload 13
    //   479: invokevirtual 219	java/lang/String:length	()I
    //   482: iconst_4
    //   483: isub
    //   484: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   487: astore 14
    //   489: aload 11
    //   491: astore 10
    //   493: aload_0
    //   494: astore 9
    //   496: aload 6
    //   498: astore 8
    //   500: aload 12
    //   502: aload 13
    //   504: invokeinterface 226 2 0
    //   509: checkcast 164	java/lang/Integer
    //   512: invokevirtual 229	java/lang/Integer:intValue	()I
    //   515: istore_1
    //   516: aload 11
    //   518: astore 10
    //   520: aload_0
    //   521: astore 9
    //   523: aload 6
    //   525: astore 8
    //   527: aload 14
    //   529: bipush 16
    //   531: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   534: istore_2
    //   535: aload 11
    //   537: astore 10
    //   539: aload_0
    //   540: astore 9
    //   542: aload 6
    //   544: astore 8
    //   546: aload_0
    //   547: iconst_1
    //   548: invokevirtual 234	java/io/BufferedOutputStream:write	(I)V
    //   551: aload 11
    //   553: astore 10
    //   555: aload_0
    //   556: astore 9
    //   558: aload 6
    //   560: astore 8
    //   562: aload_0
    //   563: iload_2
    //   564: invokestatic 179	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   567: aload 11
    //   569: astore 10
    //   571: aload_0
    //   572: astore 9
    //   574: aload 6
    //   576: astore 8
    //   578: aload_0
    //   579: iload_1
    //   580: invokestatic 179	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   583: goto -185 -> 398
    //   586: astore 14
    //   588: aload 11
    //   590: astore 10
    //   592: aload_0
    //   593: astore 9
    //   595: aload 6
    //   597: astore 8
    //   599: ldc 72
    //   601: iconst_1
    //   602: invokestatic 239	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   605: ldc 241
    //   607: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 13
    //   612: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: aload 14
    //   620: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   623: goto -225 -> 398
    //   626: astore 8
    //   628: aconst_null
    //   629: astore 5
    //   631: aload_0
    //   632: astore 7
    //   634: aload 6
    //   636: astore_0
    //   637: aload 8
    //   639: astore 6
    //   641: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +13 -> 657
    //   647: ldc 72
    //   649: iconst_2
    //   650: ldc 247
    //   652: aload 6
    //   654: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   657: aload_0
    //   658: ifnull +7 -> 665
    //   661: aload_0
    //   662: invokevirtual 248	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   665: aload 7
    //   667: ifnull +8 -> 675
    //   670: aload 7
    //   672: invokevirtual 194	java/io/BufferedOutputStream:close	()V
    //   675: aload 5
    //   677: ifnull -656 -> 21
    //   680: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   683: aload 5
    //   685: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   688: iconst_0
    //   689: ireturn
    //   690: astore_0
    //   691: aload_0
    //   692: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   695: iconst_0
    //   696: ireturn
    //   697: aload 11
    //   699: astore 10
    //   701: aload_0
    //   702: astore 9
    //   704: aload 6
    //   706: astore 8
    //   708: aload 13
    //   710: iconst_0
    //   711: aload 13
    //   713: invokevirtual 219	java/lang/String:length	()I
    //   716: iconst_4
    //   717: isub
    //   718: invokevirtual 222	java/lang/String:substring	(II)Ljava/lang/String;
    //   721: ldc 217
    //   723: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   726: astore 14
    //   728: aload 11
    //   730: astore 10
    //   732: aload_0
    //   733: astore 9
    //   735: aload 6
    //   737: astore 8
    //   739: aload 12
    //   741: aload 13
    //   743: invokeinterface 226 2 0
    //   748: checkcast 164	java/lang/Integer
    //   751: invokevirtual 229	java/lang/Integer:intValue	()I
    //   754: istore_2
    //   755: aload 14
    //   757: ifnull -359 -> 398
    //   760: aload 11
    //   762: astore 10
    //   764: aload_0
    //   765: astore 9
    //   767: aload 6
    //   769: astore 8
    //   771: aload 14
    //   773: arraylength
    //   774: newarray int
    //   776: astore 15
    //   778: iconst_0
    //   779: istore_1
    //   780: aload 11
    //   782: astore 10
    //   784: aload_0
    //   785: astore 9
    //   787: aload 6
    //   789: astore 8
    //   791: iload_1
    //   792: aload 14
    //   794: arraylength
    //   795: if_icmpge +38 -> 833
    //   798: aload 11
    //   800: astore 10
    //   802: aload_0
    //   803: astore 9
    //   805: aload 6
    //   807: astore 8
    //   809: aload 15
    //   811: iload_1
    //   812: aload 14
    //   814: iload_1
    //   815: aaload
    //   816: iconst_2
    //   817: invokevirtual 153	java/lang/String:substring	(I)Ljava/lang/String;
    //   820: bipush 16
    //   822: invokestatic 233	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   825: iastore
    //   826: iload_1
    //   827: iconst_1
    //   828: iadd
    //   829: istore_1
    //   830: goto -50 -> 780
    //   833: aload 11
    //   835: astore 10
    //   837: aload_0
    //   838: astore 9
    //   840: aload 6
    //   842: astore 8
    //   844: aload_0
    //   845: aload 14
    //   847: arraylength
    //   848: invokevirtual 234	java/io/BufferedOutputStream:write	(I)V
    //   851: iconst_0
    //   852: istore_1
    //   853: aload 11
    //   855: astore 10
    //   857: aload_0
    //   858: astore 9
    //   860: aload 6
    //   862: astore 8
    //   864: iload_1
    //   865: aload 15
    //   867: arraylength
    //   868: if_icmpge +29 -> 897
    //   871: aload 11
    //   873: astore 10
    //   875: aload_0
    //   876: astore 9
    //   878: aload 6
    //   880: astore 8
    //   882: aload_0
    //   883: aload 15
    //   885: iload_1
    //   886: iaload
    //   887: invokestatic 179	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   890: iload_1
    //   891: iconst_1
    //   892: iadd
    //   893: istore_1
    //   894: goto -41 -> 853
    //   897: aload 11
    //   899: astore 10
    //   901: aload_0
    //   902: astore 9
    //   904: aload 6
    //   906: astore 8
    //   908: aload_0
    //   909: iload_2
    //   910: invokestatic 179	com/tencent/mobileqq/text/AppleEmojiManager:a	(Ljava/io/OutputStream;I)V
    //   913: goto -515 -> 398
    //   916: astore 5
    //   918: aload 7
    //   920: astore 10
    //   922: aload_0
    //   923: astore 9
    //   925: aload 6
    //   927: astore 8
    //   929: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq +25 -> 957
    //   935: aload 7
    //   937: astore 10
    //   939: aload_0
    //   940: astore 9
    //   942: aload 6
    //   944: astore 8
    //   946: ldc 72
    //   948: iconst_2
    //   949: ldc_w 257
    //   952: aload 5
    //   954: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   957: aload 6
    //   959: ifnull +8 -> 967
    //   962: aload 6
    //   964: invokevirtual 248	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   967: aload_0
    //   968: ifnull +7 -> 975
    //   971: aload_0
    //   972: invokevirtual 194	java/io/BufferedOutputStream:close	()V
    //   975: aload 7
    //   977: ifnull -956 -> 21
    //   980: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   983: aload 7
    //   985: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   988: iconst_0
    //   989: ireturn
    //   990: astore_0
    //   991: aload_0
    //   992: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   995: iconst_0
    //   996: ireturn
    //   997: aload 11
    //   999: astore 10
    //   1001: aload_0
    //   1002: astore 9
    //   1004: aload 6
    //   1006: astore 8
    //   1008: aload_0
    //   1009: invokevirtual 187	java/io/BufferedOutputStream:flush	()V
    //   1012: aload 11
    //   1014: astore 10
    //   1016: aload_0
    //   1017: astore 9
    //   1019: aload 6
    //   1021: astore 8
    //   1023: invokestatic 263	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1026: invokestatic 269	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   1029: invokeinterface 275 1 0
    //   1034: ldc_w 277
    //   1037: iconst_1
    //   1038: invokeinterface 283 3 0
    //   1043: invokeinterface 286 1 0
    //   1048: pop
    //   1049: aload 11
    //   1051: astore 10
    //   1053: aload_0
    //   1054: astore 9
    //   1056: aload 6
    //   1058: astore 8
    //   1060: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq +23 -> 1086
    //   1066: aload 11
    //   1068: astore 10
    //   1070: aload_0
    //   1071: astore 9
    //   1073: aload 6
    //   1075: astore 8
    //   1077: ldc 72
    //   1079: iconst_2
    //   1080: ldc_w 288
    //   1083: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1086: aload 11
    //   1088: astore 10
    //   1090: aload_0
    //   1091: astore 9
    //   1093: aload 6
    //   1095: astore 8
    //   1097: new 61	java/io/File
    //   1100: dup
    //   1101: getstatic 31	com/tencent/mobileqq/text/AppleEmojiManager:a	Ljava/lang/String;
    //   1104: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   1107: astore 5
    //   1109: aload 11
    //   1111: astore 10
    //   1113: aload_0
    //   1114: astore 9
    //   1116: aload 6
    //   1118: astore 8
    //   1120: new 61	java/io/File
    //   1123: dup
    //   1124: getstatic 35	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   1127: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   1130: astore 12
    //   1132: aload 11
    //   1134: astore 10
    //   1136: aload_0
    //   1137: astore 9
    //   1139: aload 6
    //   1141: astore 8
    //   1143: aload 5
    //   1145: invokevirtual 65	java/io/File:exists	()Z
    //   1148: ifeq +40 -> 1188
    //   1151: aload 11
    //   1153: astore 10
    //   1155: aload_0
    //   1156: astore 9
    //   1158: aload 6
    //   1160: astore 8
    //   1162: aload 12
    //   1164: invokevirtual 65	java/io/File:exists	()Z
    //   1167: ifeq +21 -> 1188
    //   1170: aload 11
    //   1172: astore 10
    //   1174: aload_0
    //   1175: astore 9
    //   1177: aload 6
    //   1179: astore 8
    //   1181: aload 5
    //   1183: aload 12
    //   1185: invokestatic 293	com/tencent/mobileqq/text/EmotcationConstants:a	(Ljava/io/File;Ljava/io/File;)V
    //   1188: aload 11
    //   1190: astore 10
    //   1192: aload_0
    //   1193: astore 9
    //   1195: aload 6
    //   1197: astore 8
    //   1199: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1202: ifeq +62 -> 1264
    //   1205: aload 11
    //   1207: astore 10
    //   1209: aload_0
    //   1210: astore 9
    //   1212: aload 6
    //   1214: astore 8
    //   1216: ldc 72
    //   1218: iconst_2
    //   1219: new 11	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1226: ldc_w 295
    //   1229: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: getstatic 298	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   1235: invokevirtual 303	android/util/SparseIntArray:size	()I
    //   1238: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1241: ldc_w 308
    //   1244: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: getstatic 311	com/tencent/mobileqq/text/EmotcationConstants:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   1250: invokeinterface 312 1 0
    //   1255: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1258: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: aload 6
    //   1266: ifnull +8 -> 1274
    //   1269: aload 6
    //   1271: invokevirtual 248	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1274: aload_0
    //   1275: ifnull +7 -> 1282
    //   1278: aload_0
    //   1279: invokevirtual 194	java/io/BufferedOutputStream:close	()V
    //   1282: iconst_0
    //   1283: ifeq +10 -> 1293
    //   1286: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1289: aconst_null
    //   1290: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1293: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1296: ifeq +33 -> 1329
    //   1299: ldc 72
    //   1301: iconst_2
    //   1302: new 11	java/lang/StringBuilder
    //   1305: dup
    //   1306: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1309: ldc_w 314
    //   1312: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokestatic 90	android/os/SystemClock:uptimeMillis	()J
    //   1318: lload_3
    //   1319: lsub
    //   1320: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1329: iconst_1
    //   1330: ireturn
    //   1331: astore_0
    //   1332: aload_0
    //   1333: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1336: goto -43 -> 1293
    //   1339: astore_0
    //   1340: aconst_null
    //   1341: astore 7
    //   1343: aconst_null
    //   1344: astore 6
    //   1346: aconst_null
    //   1347: astore 5
    //   1349: aload 6
    //   1351: ifnull +8 -> 1359
    //   1354: aload 6
    //   1356: invokevirtual 248	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1359: aload 7
    //   1361: ifnull +8 -> 1369
    //   1364: aload 7
    //   1366: invokevirtual 194	java/io/BufferedOutputStream:close	()V
    //   1369: aload 5
    //   1371: ifnull +11 -> 1382
    //   1374: invokestatic 124	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1377: aload 5
    //   1379: invokevirtual 191	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1382: aload_0
    //   1383: athrow
    //   1384: astore 5
    //   1386: aload 5
    //   1388: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   1391: goto -9 -> 1382
    //   1394: astore_0
    //   1395: aconst_null
    //   1396: astore 7
    //   1398: aconst_null
    //   1399: astore 5
    //   1401: goto -52 -> 1349
    //   1404: astore_0
    //   1405: aconst_null
    //   1406: astore 8
    //   1408: aload 5
    //   1410: astore 7
    //   1412: aload 8
    //   1414: astore 5
    //   1416: goto -67 -> 1349
    //   1419: astore 9
    //   1421: aload_0
    //   1422: astore 7
    //   1424: aload 5
    //   1426: astore 8
    //   1428: aload 9
    //   1430: astore_0
    //   1431: aload 7
    //   1433: astore 5
    //   1435: aload 8
    //   1437: astore 7
    //   1439: goto -90 -> 1349
    //   1442: astore_0
    //   1443: aload 5
    //   1445: astore 7
    //   1447: aload 8
    //   1449: astore 5
    //   1451: goto -102 -> 1349
    //   1454: astore_0
    //   1455: aload 10
    //   1457: astore 5
    //   1459: aload 9
    //   1461: astore 7
    //   1463: aload 8
    //   1465: astore 6
    //   1467: goto -118 -> 1349
    //   1470: astore 8
    //   1472: aload_0
    //   1473: astore 6
    //   1475: aload 8
    //   1477: astore_0
    //   1478: goto -129 -> 1349
    //   1481: astore 5
    //   1483: aconst_null
    //   1484: astore_0
    //   1485: aconst_null
    //   1486: astore 6
    //   1488: aconst_null
    //   1489: astore 7
    //   1491: goto -573 -> 918
    //   1494: astore 5
    //   1496: aconst_null
    //   1497: astore_0
    //   1498: aconst_null
    //   1499: astore 7
    //   1501: goto -583 -> 918
    //   1504: astore 8
    //   1506: aconst_null
    //   1507: astore 7
    //   1509: aload 5
    //   1511: astore_0
    //   1512: aload 8
    //   1514: astore 5
    //   1516: goto -598 -> 918
    //   1519: astore 7
    //   1521: aload 5
    //   1523: astore 8
    //   1525: aload 7
    //   1527: astore 5
    //   1529: aload_0
    //   1530: astore 7
    //   1532: aload 8
    //   1534: astore_0
    //   1535: goto -617 -> 918
    //   1538: astore 8
    //   1540: aload 5
    //   1542: astore_0
    //   1543: aload 8
    //   1545: astore 5
    //   1547: goto -629 -> 918
    //   1550: astore 6
    //   1552: aload 8
    //   1554: astore 5
    //   1556: aload 9
    //   1558: astore_0
    //   1559: goto -918 -> 641
    //   1562: astore 5
    //   1564: aload 6
    //   1566: astore_0
    //   1567: aload 5
    //   1569: astore 6
    //   1571: aload 8
    //   1573: astore 5
    //   1575: goto -934 -> 641
    //   1578: astore 9
    //   1580: aload 5
    //   1582: astore_0
    //   1583: aload 6
    //   1585: astore 8
    //   1587: aload 9
    //   1589: astore 6
    //   1591: aload 7
    //   1593: astore 5
    //   1595: aload_0
    //   1596: astore 7
    //   1598: aload 8
    //   1600: astore_0
    //   1601: goto -960 -> 641
    //   1604: astore 9
    //   1606: aconst_null
    //   1607: astore 8
    //   1609: aload 5
    //   1611: astore 7
    //   1613: aload 6
    //   1615: astore_0
    //   1616: aload 9
    //   1618: astore 6
    //   1620: aload 8
    //   1622: astore 5
    //   1624: goto -983 -> 641
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1627	0	paramFile	java.io.File
    //   145	749	1	i	int
    //   254	656	2	j	int
    //   52	1267	3	l	long
    //   33	651	5	localObject1	Object
    //   916	37	5	localIOException1	java.io.IOException
    //   1107	271	5	localFile	java.io.File
    //   1384	3	5	localIOException2	java.io.IOException
    //   1399	59	5	localObject2	Object
    //   1481	1	5	localIOException3	java.io.IOException
    //   1494	16	5	localIOException4	java.io.IOException
    //   1514	41	5	localObject3	Object
    //   1562	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   1573	50	5	localObject4	Object
    //   87	1400	6	localObject5	Object
    //   1550	15	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1569	50	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   57	1451	7	localObject6	Object
    //   1519	7	7	localIOException5	java.io.IOException
    //   1530	82	7	localObject7	Object
    //   63	535	8	localObject8	Object
    //   626	12	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   706	758	8	localObject9	Object
    //   1470	6	8	localObject10	Object
    //   1504	9	8	localIOException6	java.io.IOException
    //   1523	10	8	localObject11	Object
    //   1538	34	8	localIOException7	java.io.IOException
    //   1585	36	8	localObject12	Object
    //   54	1157	9	localObject13	Object
    //   1419	138	9	localObject14	Object
    //   1578	10	9	localFileNotFoundException5	java.io.FileNotFoundException
    //   1604	13	9	localFileNotFoundException6	java.io.FileNotFoundException
    //   60	1396	10	localObject15	Object
    //   331	875	11	localObject16	Object
    //   128	1056	12	localObject17	Object
    //   440	302	13	str1	String
    //   487	41	14	str2	String
    //   586	33	14	localException	java.lang.Exception
    //   726	120	14	arrayOfString	String[]
    //   776	108	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   453	463	586	java/lang/Exception
    //   474	489	586	java/lang/Exception
    //   500	516	586	java/lang/Exception
    //   527	535	586	java/lang/Exception
    //   546	551	586	java/lang/Exception
    //   562	567	586	java/lang/Exception
    //   578	583	586	java/lang/Exception
    //   708	728	586	java/lang/Exception
    //   739	755	586	java/lang/Exception
    //   771	778	586	java/lang/Exception
    //   791	798	586	java/lang/Exception
    //   809	826	586	java/lang/Exception
    //   844	851	586	java/lang/Exception
    //   864	871	586	java/lang/Exception
    //   882	890	586	java/lang/Exception
    //   908	913	586	java/lang/Exception
    //   384	398	626	java/io/FileNotFoundException
    //   409	419	626	java/io/FileNotFoundException
    //   430	442	626	java/io/FileNotFoundException
    //   453	463	626	java/io/FileNotFoundException
    //   474	489	626	java/io/FileNotFoundException
    //   500	516	626	java/io/FileNotFoundException
    //   527	535	626	java/io/FileNotFoundException
    //   546	551	626	java/io/FileNotFoundException
    //   562	567	626	java/io/FileNotFoundException
    //   578	583	626	java/io/FileNotFoundException
    //   599	623	626	java/io/FileNotFoundException
    //   708	728	626	java/io/FileNotFoundException
    //   739	755	626	java/io/FileNotFoundException
    //   771	778	626	java/io/FileNotFoundException
    //   791	798	626	java/io/FileNotFoundException
    //   809	826	626	java/io/FileNotFoundException
    //   844	851	626	java/io/FileNotFoundException
    //   864	871	626	java/io/FileNotFoundException
    //   882	890	626	java/io/FileNotFoundException
    //   908	913	626	java/io/FileNotFoundException
    //   1008	1012	626	java/io/FileNotFoundException
    //   1023	1049	626	java/io/FileNotFoundException
    //   1060	1066	626	java/io/FileNotFoundException
    //   1077	1086	626	java/io/FileNotFoundException
    //   1097	1109	626	java/io/FileNotFoundException
    //   1120	1132	626	java/io/FileNotFoundException
    //   1143	1151	626	java/io/FileNotFoundException
    //   1162	1170	626	java/io/FileNotFoundException
    //   1181	1188	626	java/io/FileNotFoundException
    //   1199	1205	626	java/io/FileNotFoundException
    //   1216	1264	626	java/io/FileNotFoundException
    //   661	665	690	java/io/IOException
    //   670	675	690	java/io/IOException
    //   680	688	690	java/io/IOException
    //   384	398	916	java/io/IOException
    //   409	419	916	java/io/IOException
    //   430	442	916	java/io/IOException
    //   453	463	916	java/io/IOException
    //   474	489	916	java/io/IOException
    //   500	516	916	java/io/IOException
    //   527	535	916	java/io/IOException
    //   546	551	916	java/io/IOException
    //   562	567	916	java/io/IOException
    //   578	583	916	java/io/IOException
    //   599	623	916	java/io/IOException
    //   708	728	916	java/io/IOException
    //   739	755	916	java/io/IOException
    //   771	778	916	java/io/IOException
    //   791	798	916	java/io/IOException
    //   809	826	916	java/io/IOException
    //   844	851	916	java/io/IOException
    //   864	871	916	java/io/IOException
    //   882	890	916	java/io/IOException
    //   908	913	916	java/io/IOException
    //   1008	1012	916	java/io/IOException
    //   1023	1049	916	java/io/IOException
    //   1060	1066	916	java/io/IOException
    //   1077	1086	916	java/io/IOException
    //   1097	1109	916	java/io/IOException
    //   1120	1132	916	java/io/IOException
    //   1143	1151	916	java/io/IOException
    //   1162	1170	916	java/io/IOException
    //   1181	1188	916	java/io/IOException
    //   1199	1205	916	java/io/IOException
    //   1216	1264	916	java/io/IOException
    //   962	967	990	java/io/IOException
    //   971	975	990	java/io/IOException
    //   980	988	990	java/io/IOException
    //   1269	1274	1331	java/io/IOException
    //   1278	1282	1331	java/io/IOException
    //   1286	1293	1331	java/io/IOException
    //   65	89	1339	finally
    //   1354	1359	1384	java/io/IOException
    //   1364	1369	1384	java/io/IOException
    //   1374	1382	1384	java/io/IOException
    //   89	108	1394	finally
    //   112	130	1404	finally
    //   134	144	1404	finally
    //   149	156	1419	finally
    //   164	171	1419	finally
    //   178	188	1419	finally
    //   191	210	1419	finally
    //   218	228	1419	finally
    //   231	245	1419	finally
    //   248	255	1419	finally
    //   263	269	1419	finally
    //   276	283	1419	finally
    //   291	299	1419	finally
    //   309	314	1419	finally
    //   320	327	1419	finally
    //   336	355	1442	finally
    //   355	373	1442	finally
    //   384	398	1454	finally
    //   409	419	1454	finally
    //   430	442	1454	finally
    //   453	463	1454	finally
    //   474	489	1454	finally
    //   500	516	1454	finally
    //   527	535	1454	finally
    //   546	551	1454	finally
    //   562	567	1454	finally
    //   578	583	1454	finally
    //   599	623	1454	finally
    //   708	728	1454	finally
    //   739	755	1454	finally
    //   771	778	1454	finally
    //   791	798	1454	finally
    //   809	826	1454	finally
    //   844	851	1454	finally
    //   864	871	1454	finally
    //   882	890	1454	finally
    //   908	913	1454	finally
    //   929	935	1454	finally
    //   946	957	1454	finally
    //   1008	1012	1454	finally
    //   1023	1049	1454	finally
    //   1060	1066	1454	finally
    //   1077	1086	1454	finally
    //   1097	1109	1454	finally
    //   1120	1132	1454	finally
    //   1143	1151	1454	finally
    //   1162	1170	1454	finally
    //   1181	1188	1454	finally
    //   1199	1205	1454	finally
    //   1216	1264	1454	finally
    //   641	657	1470	finally
    //   65	89	1481	java/io/IOException
    //   89	108	1494	java/io/IOException
    //   112	130	1504	java/io/IOException
    //   134	144	1504	java/io/IOException
    //   149	156	1519	java/io/IOException
    //   164	171	1519	java/io/IOException
    //   178	188	1519	java/io/IOException
    //   191	210	1519	java/io/IOException
    //   218	228	1519	java/io/IOException
    //   231	245	1519	java/io/IOException
    //   248	255	1519	java/io/IOException
    //   263	269	1519	java/io/IOException
    //   276	283	1519	java/io/IOException
    //   291	299	1519	java/io/IOException
    //   309	314	1519	java/io/IOException
    //   320	327	1519	java/io/IOException
    //   336	355	1538	java/io/IOException
    //   355	373	1538	java/io/IOException
    //   65	89	1550	java/io/FileNotFoundException
    //   89	108	1562	java/io/FileNotFoundException
    //   112	130	1578	java/io/FileNotFoundException
    //   134	144	1578	java/io/FileNotFoundException
    //   149	156	1578	java/io/FileNotFoundException
    //   164	171	1578	java/io/FileNotFoundException
    //   178	188	1578	java/io/FileNotFoundException
    //   191	210	1578	java/io/FileNotFoundException
    //   218	228	1578	java/io/FileNotFoundException
    //   231	245	1578	java/io/FileNotFoundException
    //   248	255	1578	java/io/FileNotFoundException
    //   263	269	1578	java/io/FileNotFoundException
    //   276	283	1578	java/io/FileNotFoundException
    //   291	299	1578	java/io/FileNotFoundException
    //   309	314	1578	java/io/FileNotFoundException
    //   320	327	1578	java/io/FileNotFoundException
    //   336	355	1604	java/io/FileNotFoundException
    //   355	373	1604	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.text.AppleEmojiManager
 * JD-Core Version:    0.7.0.1
 */