package com.tencent.mobileqq.text;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.InputStream;
import java.io.OutputStream;

public class AppleEmojiManager
{
  public static final String EMOJI_FILE;
  public static final String INDEX_FILE;
  public static final String TAG = "AppleEmojiManager";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH_EMOJIS);
    localStringBuilder.append("emojiindex");
    INDEX_FILE = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH_EMOJIS);
    localStringBuilder.append("emojis");
    EMOJI_FILE = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static final int bytesToInt(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      int k = paramArrayOfByte[i];
      if (k < 0) {
        k += 256;
      }
      j |= k << i * 8;
      i += 1;
    }
    return j;
  }
  
  public static final int readIntFromStream(InputStream paramInputStream)
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
  
  /* Error */
  public static boolean unzip(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	java/io/File:exists	()Z
    //   4: ifne +19 -> 23
    //   7: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 10
    //   15: iconst_2
    //   16: ldc 77
    //   18: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: new 66	java/io/File
    //   26: dup
    //   27: getstatic 22	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH_EMOJIS	Ljava/lang/String;
    //   30: invokestatic 38	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 70	java/io/File:exists	()Z
    //   43: ifne +9 -> 52
    //   46: aload 5
    //   48: invokevirtual 87	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: invokestatic 93	android/os/SystemClock:uptimeMillis	()J
    //   55: lstore_3
    //   56: new 95	com/tencent/commonsdk/zip/QZipInputStream
    //   59: dup
    //   60: new 97	java/io/BufferedInputStream
    //   63: dup
    //   64: new 99	java/io/FileInputStream
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: invokespecial 106	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore 5
    //   80: new 108	java/io/BufferedOutputStream
    //   83: dup
    //   84: new 110	java/io/FileOutputStream
    //   87: dup
    //   88: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   91: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore 6
    //   99: new 116	java/util/HashMap
    //   102: dup
    //   103: aload_0
    //   104: invokevirtual 119	java/io/File:length	()J
    //   107: l2i
    //   108: sipush 1024
    //   111: idiv
    //   112: invokespecial 122	java/util/HashMap:<init>	(I)V
    //   115: astore 9
    //   117: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   120: sipush 512
    //   123: invokevirtual 132	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   126: astore_0
    //   127: iconst_0
    //   128: istore_1
    //   129: aload 5
    //   131: invokevirtual 136	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   134: astore 10
    //   136: aload 10
    //   138: ifnull +138 -> 276
    //   141: aload 10
    //   143: invokevirtual 141	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   146: astore 8
    //   148: aload 8
    //   150: ifnonnull +6 -> 156
    //   153: goto -24 -> 129
    //   156: aload 8
    //   158: astore 7
    //   160: aload 8
    //   162: ldc 143
    //   164: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   167: ifeq +22 -> 189
    //   170: aload 8
    //   172: aload 8
    //   174: bipush 47
    //   176: invokevirtual 153	java/lang/String:lastIndexOf	(I)I
    //   179: iconst_1
    //   180: iadd
    //   181: invokevirtual 157	java/lang/String:substring	(I)Ljava/lang/String;
    //   184: invokevirtual 160	java/lang/String:trim	()Ljava/lang/String;
    //   187: astore 7
    //   189: aload 7
    //   191: ldc 162
    //   193: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +6 -> 202
    //   199: goto -70 -> 129
    //   202: aload 9
    //   204: aload 7
    //   206: iload_1
    //   207: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: invokeinterface 178 3 0
    //   215: pop
    //   216: aload 10
    //   218: invokevirtual 181	java/util/zip/ZipEntry:getSize	()J
    //   221: l2i
    //   222: istore_2
    //   223: iload_2
    //   224: iconst_1
    //   225: if_icmpge +6 -> 231
    //   228: goto -99 -> 129
    //   231: aload 6
    //   233: iload_2
    //   234: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   237: iload_1
    //   238: iconst_4
    //   239: iadd
    //   240: istore_1
    //   241: aload 5
    //   243: aload_0
    //   244: invokevirtual 187	com/tencent/commonsdk/zip/QZipInputStream:read	([B)I
    //   247: istore_2
    //   248: iload_2
    //   249: iconst_m1
    //   250: if_icmpeq +18 -> 268
    //   253: aload 6
    //   255: aload_0
    //   256: iconst_0
    //   257: iload_2
    //   258: invokevirtual 191	java/io/BufferedOutputStream:write	([BII)V
    //   261: iload_1
    //   262: iload_2
    //   263: iadd
    //   264: istore_1
    //   265: goto -24 -> 241
    //   268: aload 6
    //   270: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   273: goto -144 -> 129
    //   276: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   279: aload_0
    //   280: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   283: aload 6
    //   285: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   288: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +11 -> 302
    //   294: ldc 10
    //   296: iconst_2
    //   297: ldc 203
    //   299: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: new 108	java/io/BufferedOutputStream
    //   305: dup
    //   306: new 110	java/io/FileOutputStream
    //   309: dup
    //   310: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:INDEX_FILE	Ljava/lang/String;
    //   313: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   316: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   319: astore_0
    //   320: aload 9
    //   322: invokeinterface 207 1 0
    //   327: invokeinterface 213 1 0
    //   332: astore 6
    //   334: aload 6
    //   336: invokeinterface 218 1 0
    //   341: ifeq +232 -> 573
    //   344: aload 6
    //   346: invokeinterface 222 1 0
    //   351: checkcast 145	java/lang/String
    //   354: astore 7
    //   356: aload 7
    //   358: ldc 224
    //   360: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifne +60 -> 423
    //   366: aload 7
    //   368: iconst_2
    //   369: aload 7
    //   371: invokevirtual 226	java/lang/String:length	()I
    //   374: iconst_4
    //   375: isub
    //   376: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   379: astore 8
    //   381: aload 9
    //   383: aload 7
    //   385: invokeinterface 233 2 0
    //   390: checkcast 168	java/lang/Integer
    //   393: invokevirtual 236	java/lang/Integer:intValue	()I
    //   396: istore_1
    //   397: aload 8
    //   399: bipush 16
    //   401: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   404: istore_2
    //   405: aload_0
    //   406: iconst_1
    //   407: invokevirtual 242	java/io/BufferedOutputStream:write	(I)V
    //   410: aload_0
    //   411: iload_2
    //   412: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   415: aload_0
    //   416: iload_1
    //   417: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   420: goto +825 -> 1245
    //   423: aload 7
    //   425: iconst_0
    //   426: aload 7
    //   428: invokevirtual 226	java/lang/String:length	()I
    //   431: iconst_4
    //   432: isub
    //   433: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   436: ldc 224
    //   438: invokevirtual 246	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   441: astore 8
    //   443: aload 9
    //   445: aload 7
    //   447: invokeinterface 233 2 0
    //   452: checkcast 168	java/lang/Integer
    //   455: invokevirtual 236	java/lang/Integer:intValue	()I
    //   458: istore_2
    //   459: aload 8
    //   461: ifnull +784 -> 1245
    //   464: aload 8
    //   466: arraylength
    //   467: newarray int
    //   469: astore 10
    //   471: iconst_0
    //   472: istore_1
    //   473: iload_1
    //   474: aload 8
    //   476: arraylength
    //   477: if_icmpge +27 -> 504
    //   480: aload 10
    //   482: iload_1
    //   483: aload 8
    //   485: iload_1
    //   486: aaload
    //   487: iconst_2
    //   488: invokevirtual 157	java/lang/String:substring	(I)Ljava/lang/String;
    //   491: bipush 16
    //   493: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   496: iastore
    //   497: iload_1
    //   498: iconst_1
    //   499: iadd
    //   500: istore_1
    //   501: goto -28 -> 473
    //   504: aload_0
    //   505: aload 8
    //   507: arraylength
    //   508: invokevirtual 242	java/io/BufferedOutputStream:write	(I)V
    //   511: iconst_0
    //   512: istore_1
    //   513: iload_1
    //   514: aload 10
    //   516: arraylength
    //   517: if_icmpge +18 -> 535
    //   520: aload_0
    //   521: aload 10
    //   523: iload_1
    //   524: iaload
    //   525: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   528: iload_1
    //   529: iconst_1
    //   530: iadd
    //   531: istore_1
    //   532: goto -19 -> 513
    //   535: aload_0
    //   536: iload_2
    //   537: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   540: goto +705 -> 1245
    //   543: astore 8
    //   545: ldc 10
    //   547: iconst_1
    //   548: iconst_3
    //   549: anewarray 4	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: ldc 248
    //   556: aastore
    //   557: dup
    //   558: iconst_1
    //   559: aload 7
    //   561: aastore
    //   562: dup
    //   563: iconst_2
    //   564: aload 8
    //   566: aastore
    //   567: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   570: goto +675 -> 1245
    //   573: aload_0
    //   574: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   577: invokestatic 258	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   580: astore 7
    //   582: getstatic 264	android/os/Build$VERSION:SDK_INT	I
    //   585: bipush 24
    //   587: if_icmplt +13 -> 600
    //   590: aload 7
    //   592: invokestatic 270	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   595: astore 6
    //   597: goto +39 -> 636
    //   600: new 14	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   607: astore 6
    //   609: aload 6
    //   611: aload 7
    //   613: invokevirtual 275	android/content/Context:getPackageName	()Ljava/lang/String;
    //   616: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 6
    //   622: ldc_w 277
    //   625: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 6
    //   631: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: astore 6
    //   636: aload 7
    //   638: aload 6
    //   640: iconst_4
    //   641: invokevirtual 281	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   644: invokeinterface 287 1 0
    //   649: ldc_w 289
    //   652: iconst_1
    //   653: invokeinterface 295 3 0
    //   658: invokeinterface 298 1 0
    //   663: pop
    //   664: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq +12 -> 679
    //   670: ldc 10
    //   672: iconst_2
    //   673: ldc_w 300
    //   676: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: new 66	java/io/File
    //   682: dup
    //   683: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:INDEX_FILE	Ljava/lang/String;
    //   686: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   689: astore 6
    //   691: new 66	java/io/File
    //   694: dup
    //   695: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   698: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   701: astore 7
    //   703: aload 6
    //   705: invokevirtual 70	java/io/File:exists	()Z
    //   708: ifeq +18 -> 726
    //   711: aload 7
    //   713: invokevirtual 70	java/io/File:exists	()Z
    //   716: ifeq +10 -> 726
    //   719: aload 6
    //   721: aload 7
    //   723: invokestatic 306	com/tencent/mobileqq/text/EmotcationConstants:setEmojiMap	(Ljava/io/File;Ljava/io/File;)V
    //   726: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq +67 -> 796
    //   732: new 14	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   739: astore 6
    //   741: aload 6
    //   743: ldc_w 308
    //   746: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload 6
    //   752: getstatic 312	com/tencent/mobileqq/text/EmotcationConstants:EMOJI_MAP	Landroid/util/SparseIntArray;
    //   755: invokevirtual 317	android/util/SparseIntArray:size	()I
    //   758: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 6
    //   764: ldc_w 322
    //   767: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload 6
    //   773: getstatic 326	com/tencent/mobileqq/text/EmotcationConstants:DOUBLE_EMOJI_MAP	Ljava/util/Map;
    //   776: invokeinterface 327 1 0
    //   781: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: ldc 10
    //   787: iconst_2
    //   788: aload 6
    //   790: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: aload 5
    //   798: invokevirtual 328	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   801: aload_0
    //   802: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   805: goto +8 -> 813
    //   808: astore_0
    //   809: aload_0
    //   810: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   813: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +39 -> 855
    //   819: new 14	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   826: astore_0
    //   827: aload_0
    //   828: ldc_w 333
    //   831: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload_0
    //   836: invokestatic 93	android/os/SystemClock:uptimeMillis	()J
    //   839: lload_3
    //   840: lsub
    //   841: invokevirtual 336	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: ldc 10
    //   847: iconst_2
    //   848: aload_0
    //   849: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   855: iconst_1
    //   856: ireturn
    //   857: astore 6
    //   859: aload_0
    //   860: astore 8
    //   862: goto +64 -> 926
    //   865: astore 8
    //   867: aload_0
    //   868: astore 6
    //   870: goto +79 -> 949
    //   873: astore 8
    //   875: aload_0
    //   876: astore 6
    //   878: goto +78 -> 956
    //   881: astore 7
    //   883: aload_0
    //   884: astore 9
    //   886: aload 6
    //   888: astore 8
    //   890: aload 7
    //   892: astore_0
    //   893: aload 9
    //   895: astore 6
    //   897: aload 5
    //   899: astore 7
    //   901: aload 8
    //   903: astore 5
    //   905: goto +288 -> 1193
    //   908: astore 8
    //   910: goto +96 -> 1006
    //   913: astore 8
    //   915: goto +183 -> 1098
    //   918: astore_0
    //   919: aload 6
    //   921: astore 8
    //   923: aload_0
    //   924: astore 6
    //   926: aconst_null
    //   927: astore 7
    //   929: aload 6
    //   931: astore_0
    //   932: aload 7
    //   934: astore 6
    //   936: aload 5
    //   938: astore 7
    //   940: aload 8
    //   942: astore 5
    //   944: goto +249 -> 1193
    //   947: astore 8
    //   949: aconst_null
    //   950: astore_0
    //   951: goto +55 -> 1006
    //   954: astore 8
    //   956: aconst_null
    //   957: astore_0
    //   958: goto +140 -> 1098
    //   961: astore_0
    //   962: goto +17 -> 979
    //   965: astore 8
    //   967: goto +34 -> 1001
    //   970: astore 8
    //   972: goto +121 -> 1093
    //   975: astore_0
    //   976: aconst_null
    //   977: astore 5
    //   979: aconst_null
    //   980: astore 6
    //   982: aconst_null
    //   983: astore 8
    //   985: aload 5
    //   987: astore 7
    //   989: aload 8
    //   991: astore 5
    //   993: goto +200 -> 1193
    //   996: astore 8
    //   998: aconst_null
    //   999: astore 5
    //   1001: aconst_null
    //   1002: astore_0
    //   1003: aconst_null
    //   1004: astore 6
    //   1006: aload_0
    //   1007: astore 9
    //   1009: aload 5
    //   1011: astore 10
    //   1013: aload 6
    //   1015: astore 7
    //   1017: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq +25 -> 1045
    //   1023: aload_0
    //   1024: astore 9
    //   1026: aload 5
    //   1028: astore 10
    //   1030: aload 6
    //   1032: astore 7
    //   1034: ldc 10
    //   1036: iconst_2
    //   1037: ldc_w 338
    //   1040: aload 8
    //   1042: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1045: aload 5
    //   1047: ifnull +11 -> 1058
    //   1050: aload 5
    //   1052: invokevirtual 328	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1055: goto +3 -> 1058
    //   1058: aload 6
    //   1060: ifnull +8 -> 1068
    //   1063: aload 6
    //   1065: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1068: aload_0
    //   1069: ifnull +17 -> 1086
    //   1072: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1075: aload_0
    //   1076: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1079: goto +7 -> 1086
    //   1082: aload_0
    //   1083: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   1086: iconst_0
    //   1087: ireturn
    //   1088: astore 8
    //   1090: aconst_null
    //   1091: astore 5
    //   1093: aconst_null
    //   1094: astore_0
    //   1095: aconst_null
    //   1096: astore 6
    //   1098: aload_0
    //   1099: astore 9
    //   1101: aload 5
    //   1103: astore 10
    //   1105: aload 6
    //   1107: astore 7
    //   1109: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1112: ifeq +25 -> 1137
    //   1115: aload_0
    //   1116: astore 9
    //   1118: aload 5
    //   1120: astore 10
    //   1122: aload 6
    //   1124: astore 7
    //   1126: ldc 10
    //   1128: iconst_2
    //   1129: ldc_w 343
    //   1132: aload 8
    //   1134: invokestatic 341	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1137: aload 5
    //   1139: ifnull +11 -> 1150
    //   1142: aload 5
    //   1144: invokevirtual 328	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1147: goto +3 -> 1150
    //   1150: aload 6
    //   1152: ifnull +8 -> 1160
    //   1155: aload 6
    //   1157: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1160: aload_0
    //   1161: ifnull +17 -> 1178
    //   1164: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1167: aload_0
    //   1168: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1171: goto +7 -> 1178
    //   1174: aload_0
    //   1175: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   1178: iconst_0
    //   1179: ireturn
    //   1180: astore_0
    //   1181: aload 9
    //   1183: astore 6
    //   1185: aload 7
    //   1187: astore 5
    //   1189: aload 10
    //   1191: astore 7
    //   1193: aload 7
    //   1195: ifnull +11 -> 1206
    //   1198: aload 7
    //   1200: invokevirtual 328	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1203: goto +3 -> 1206
    //   1206: aload 5
    //   1208: ifnull +8 -> 1216
    //   1211: aload 5
    //   1213: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1216: aload 6
    //   1218: ifnull +19 -> 1237
    //   1221: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1224: aload 6
    //   1226: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1229: goto +8 -> 1237
    //   1232: aload 5
    //   1234: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   1237: goto +5 -> 1242
    //   1240: aload_0
    //   1241: athrow
    //   1242: goto -2 -> 1240
    //   1245: goto -911 -> 334
    //   1248: astore_0
    //   1249: goto -167 -> 1082
    //   1252: astore_0
    //   1253: goto -79 -> 1174
    //   1256: astore 5
    //   1258: goto -26 -> 1232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	paramFile	java.io.File
    //   128	404	1	i	int
    //   222	315	2	j	int
    //   55	785	3	l	long
    //   36	1197	5	localObject1	Object
    //   1256	1	5	localIOException1	java.io.IOException
    //   97	692	6	localObject2	Object
    //   857	1	6	localObject3	Object
    //   868	357	6	localObject4	Object
    //   158	564	7	localObject5	Object
    //   881	10	7	localObject6	Object
    //   899	300	7	localObject7	Object
    //   146	360	8	localObject8	Object
    //   543	22	8	localException	java.lang.Exception
    //   860	1	8	localFile	java.io.File
    //   865	1	8	localIOException2	java.io.IOException
    //   873	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   888	14	8	localObject9	Object
    //   908	1	8	localIOException3	java.io.IOException
    //   913	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   921	20	8	localObject10	Object
    //   947	1	8	localIOException4	java.io.IOException
    //   954	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   965	1	8	localIOException5	java.io.IOException
    //   970	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   983	7	8	localObject11	Object
    //   996	45	8	localIOException6	java.io.IOException
    //   1088	45	8	localFileNotFoundException5	java.io.FileNotFoundException
    //   115	1067	9	localObject12	Object
    //   134	1056	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   356	420	543	java/lang/Exception
    //   423	459	543	java/lang/Exception
    //   464	471	543	java/lang/Exception
    //   473	497	543	java/lang/Exception
    //   504	511	543	java/lang/Exception
    //   513	528	543	java/lang/Exception
    //   535	540	543	java/lang/Exception
    //   796	805	808	java/io/IOException
    //   320	334	857	finally
    //   334	356	857	finally
    //   356	420	857	finally
    //   423	459	857	finally
    //   464	471	857	finally
    //   473	497	857	finally
    //   504	511	857	finally
    //   513	528	857	finally
    //   535	540	857	finally
    //   545	570	857	finally
    //   573	597	857	finally
    //   600	636	857	finally
    //   636	679	857	finally
    //   679	726	857	finally
    //   726	796	857	finally
    //   320	334	865	java/io/IOException
    //   334	356	865	java/io/IOException
    //   356	420	865	java/io/IOException
    //   423	459	865	java/io/IOException
    //   464	471	865	java/io/IOException
    //   473	497	865	java/io/IOException
    //   504	511	865	java/io/IOException
    //   513	528	865	java/io/IOException
    //   535	540	865	java/io/IOException
    //   545	570	865	java/io/IOException
    //   573	597	865	java/io/IOException
    //   600	636	865	java/io/IOException
    //   636	679	865	java/io/IOException
    //   679	726	865	java/io/IOException
    //   726	796	865	java/io/IOException
    //   320	334	873	java/io/FileNotFoundException
    //   334	356	873	java/io/FileNotFoundException
    //   356	420	873	java/io/FileNotFoundException
    //   423	459	873	java/io/FileNotFoundException
    //   464	471	873	java/io/FileNotFoundException
    //   473	497	873	java/io/FileNotFoundException
    //   504	511	873	java/io/FileNotFoundException
    //   513	528	873	java/io/FileNotFoundException
    //   535	540	873	java/io/FileNotFoundException
    //   545	570	873	java/io/FileNotFoundException
    //   573	597	873	java/io/FileNotFoundException
    //   600	636	873	java/io/FileNotFoundException
    //   636	679	873	java/io/FileNotFoundException
    //   679	726	873	java/io/FileNotFoundException
    //   726	796	873	java/io/FileNotFoundException
    //   129	136	881	finally
    //   141	148	881	finally
    //   160	189	881	finally
    //   189	199	881	finally
    //   202	223	881	finally
    //   231	237	881	finally
    //   241	248	881	finally
    //   253	261	881	finally
    //   268	273	881	finally
    //   276	283	881	finally
    //   129	136	908	java/io/IOException
    //   141	148	908	java/io/IOException
    //   160	189	908	java/io/IOException
    //   189	199	908	java/io/IOException
    //   202	223	908	java/io/IOException
    //   231	237	908	java/io/IOException
    //   241	248	908	java/io/IOException
    //   253	261	908	java/io/IOException
    //   268	273	908	java/io/IOException
    //   276	283	908	java/io/IOException
    //   129	136	913	java/io/FileNotFoundException
    //   141	148	913	java/io/FileNotFoundException
    //   160	189	913	java/io/FileNotFoundException
    //   189	199	913	java/io/FileNotFoundException
    //   202	223	913	java/io/FileNotFoundException
    //   231	237	913	java/io/FileNotFoundException
    //   241	248	913	java/io/FileNotFoundException
    //   253	261	913	java/io/FileNotFoundException
    //   268	273	913	java/io/FileNotFoundException
    //   276	283	913	java/io/FileNotFoundException
    //   99	127	918	finally
    //   283	302	918	finally
    //   302	320	918	finally
    //   99	127	947	java/io/IOException
    //   283	302	947	java/io/IOException
    //   302	320	947	java/io/IOException
    //   99	127	954	java/io/FileNotFoundException
    //   283	302	954	java/io/FileNotFoundException
    //   302	320	954	java/io/FileNotFoundException
    //   80	99	961	finally
    //   80	99	965	java/io/IOException
    //   80	99	970	java/io/FileNotFoundException
    //   56	80	975	finally
    //   56	80	996	java/io/IOException
    //   56	80	1088	java/io/FileNotFoundException
    //   1017	1023	1180	finally
    //   1034	1045	1180	finally
    //   1109	1115	1180	finally
    //   1126	1137	1180	finally
    //   1050	1055	1248	java/io/IOException
    //   1063	1068	1248	java/io/IOException
    //   1072	1079	1248	java/io/IOException
    //   1142	1147	1252	java/io/IOException
    //   1155	1160	1252	java/io/IOException
    //   1164	1171	1252	java/io/IOException
    //   1198	1203	1256	java/io/IOException
    //   1211	1216	1256	java/io/IOException
    //   1221	1229	1256	java/io/IOException
  }
  
  public static final void writeIntToBytes(OutputStream paramOutputStream, int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      paramOutputStream.write(paramInt >> i * 8 & 0xFF);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.AppleEmojiManager
 * JD-Core Version:    0.7.0.1
 */