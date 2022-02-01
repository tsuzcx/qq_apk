package com.tencent.mobileqq.text;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.InputStream;
import java.io.OutputStream;

public class AppleEmojiManager
{
  public static final String EMOJI_FILE = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_EMOJIS + "emojis");
  public static final String INDEX_FILE = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_EMOJIS + "emojiindex");
  public static final String TAG = "AppleEmojiManager";
  
  public static final int bytesToInt(byte[] paramArrayOfByte)
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
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 7
    //   62: aconst_null
    //   63: astore 10
    //   65: aconst_null
    //   66: astore 8
    //   68: new 95	com/tencent/commonsdk/zip/QZipInputStream
    //   71: dup
    //   72: new 97	java/io/BufferedInputStream
    //   75: dup
    //   76: new 99	java/io/FileInputStream
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 106	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore 6
    //   92: new 108	java/io/BufferedOutputStream
    //   95: dup
    //   96: new 110	java/io/FileOutputStream
    //   99: dup
    //   100: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   103: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   106: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   109: astore 5
    //   111: aload 10
    //   113: astore 7
    //   115: new 116	java/util/HashMap
    //   118: dup
    //   119: aload_0
    //   120: invokevirtual 119	java/io/File:length	()J
    //   123: l2i
    //   124: sipush 1024
    //   127: idiv
    //   128: invokespecial 122	java/util/HashMap:<init>	(I)V
    //   131: astore 12
    //   133: aload 10
    //   135: astore 7
    //   137: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   140: sipush 512
    //   143: invokevirtual 132	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   146: astore_0
    //   147: iconst_0
    //   148: istore_1
    //   149: aload_0
    //   150: astore 7
    //   152: aload 6
    //   154: invokevirtual 136	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   157: astore 10
    //   159: aload 10
    //   161: ifnull +159 -> 320
    //   164: aload_0
    //   165: astore 7
    //   167: aload 10
    //   169: invokevirtual 141	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   172: astore 9
    //   174: aload 9
    //   176: ifnull -27 -> 149
    //   179: aload 9
    //   181: astore 8
    //   183: aload_0
    //   184: astore 7
    //   186: aload 9
    //   188: ldc 143
    //   190: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +25 -> 218
    //   196: aload_0
    //   197: astore 7
    //   199: aload 9
    //   201: aload 9
    //   203: bipush 47
    //   205: invokevirtual 153	java/lang/String:lastIndexOf	(I)I
    //   208: iconst_1
    //   209: iadd
    //   210: invokevirtual 157	java/lang/String:substring	(I)Ljava/lang/String;
    //   213: invokevirtual 160	java/lang/String:trim	()Ljava/lang/String;
    //   216: astore 8
    //   218: aload_0
    //   219: astore 7
    //   221: aload 8
    //   223: ldc 162
    //   225: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifne -79 -> 149
    //   231: aload_0
    //   232: astore 7
    //   234: aload 12
    //   236: aload 8
    //   238: iload_1
    //   239: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: invokeinterface 178 3 0
    //   247: pop
    //   248: aload_0
    //   249: astore 7
    //   251: aload 10
    //   253: invokevirtual 181	java/util/zip/ZipEntry:getSize	()J
    //   256: l2i
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_1
    //   260: if_icmplt -111 -> 149
    //   263: aload_0
    //   264: astore 7
    //   266: aload 5
    //   268: iload_2
    //   269: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   272: iload_1
    //   273: iconst_4
    //   274: iadd
    //   275: istore_1
    //   276: aload_0
    //   277: astore 7
    //   279: aload 6
    //   281: aload_0
    //   282: invokevirtual 187	com/tencent/commonsdk/zip/QZipInputStream:read	([B)I
    //   285: istore_2
    //   286: iload_2
    //   287: iconst_m1
    //   288: if_icmpeq +21 -> 309
    //   291: aload_0
    //   292: astore 7
    //   294: aload 5
    //   296: aload_0
    //   297: iconst_0
    //   298: iload_2
    //   299: invokevirtual 191	java/io/BufferedOutputStream:write	([BII)V
    //   302: iload_1
    //   303: iload_2
    //   304: iadd
    //   305: istore_1
    //   306: goto -30 -> 276
    //   309: aload_0
    //   310: astore 7
    //   312: aload 5
    //   314: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   317: goto -168 -> 149
    //   320: aload_0
    //   321: astore 7
    //   323: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   326: aload_0
    //   327: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   330: aconst_null
    //   331: astore 8
    //   333: aconst_null
    //   334: astore 11
    //   336: aconst_null
    //   337: astore 7
    //   339: aload 5
    //   341: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   344: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +11 -> 358
    //   350: ldc 10
    //   352: iconst_2
    //   353: ldc 203
    //   355: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: new 108	java/io/BufferedOutputStream
    //   361: dup
    //   362: new 110	java/io/FileOutputStream
    //   365: dup
    //   366: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:INDEX_FILE	Ljava/lang/String;
    //   369: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   372: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   375: astore_0
    //   376: aload 11
    //   378: astore 10
    //   380: aload_0
    //   381: astore 9
    //   383: aload 6
    //   385: astore 8
    //   387: aload 12
    //   389: invokeinterface 207 1 0
    //   394: invokeinterface 213 1 0
    //   399: astore 5
    //   401: aload 11
    //   403: astore 10
    //   405: aload_0
    //   406: astore 9
    //   408: aload 6
    //   410: astore 8
    //   412: aload 5
    //   414: invokeinterface 218 1 0
    //   419: ifeq +582 -> 1001
    //   422: aload 11
    //   424: astore 10
    //   426: aload_0
    //   427: astore 9
    //   429: aload 6
    //   431: astore 8
    //   433: aload 5
    //   435: invokeinterface 222 1 0
    //   440: checkcast 145	java/lang/String
    //   443: astore 13
    //   445: aload 11
    //   447: astore 10
    //   449: aload_0
    //   450: astore 9
    //   452: aload 6
    //   454: astore 8
    //   456: aload 13
    //   458: ldc 224
    //   460: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   463: ifne +238 -> 701
    //   466: aload 11
    //   468: astore 10
    //   470: aload_0
    //   471: astore 9
    //   473: aload 6
    //   475: astore 8
    //   477: aload 13
    //   479: iconst_2
    //   480: aload 13
    //   482: invokevirtual 226	java/lang/String:length	()I
    //   485: iconst_4
    //   486: isub
    //   487: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   490: astore 14
    //   492: aload 11
    //   494: astore 10
    //   496: aload_0
    //   497: astore 9
    //   499: aload 6
    //   501: astore 8
    //   503: aload 12
    //   505: aload 13
    //   507: invokeinterface 233 2 0
    //   512: checkcast 168	java/lang/Integer
    //   515: invokevirtual 236	java/lang/Integer:intValue	()I
    //   518: istore_1
    //   519: aload 11
    //   521: astore 10
    //   523: aload_0
    //   524: astore 9
    //   526: aload 6
    //   528: astore 8
    //   530: aload 14
    //   532: bipush 16
    //   534: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   537: istore_2
    //   538: aload 11
    //   540: astore 10
    //   542: aload_0
    //   543: astore 9
    //   545: aload 6
    //   547: astore 8
    //   549: aload_0
    //   550: iconst_1
    //   551: invokevirtual 242	java/io/BufferedOutputStream:write	(I)V
    //   554: aload 11
    //   556: astore 10
    //   558: aload_0
    //   559: astore 9
    //   561: aload 6
    //   563: astore 8
    //   565: aload_0
    //   566: iload_2
    //   567: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   570: aload 11
    //   572: astore 10
    //   574: aload_0
    //   575: astore 9
    //   577: aload 6
    //   579: astore 8
    //   581: aload_0
    //   582: iload_1
    //   583: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   586: goto -185 -> 401
    //   589: astore 14
    //   591: aload 11
    //   593: astore 10
    //   595: aload_0
    //   596: astore 9
    //   598: aload 6
    //   600: astore 8
    //   602: ldc 10
    //   604: iconst_1
    //   605: iconst_3
    //   606: anewarray 4	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: ldc 244
    //   613: aastore
    //   614: dup
    //   615: iconst_1
    //   616: aload 13
    //   618: aastore
    //   619: dup
    //   620: iconst_2
    //   621: aload 14
    //   623: aastore
    //   624: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   627: goto -226 -> 401
    //   630: astore 8
    //   632: aconst_null
    //   633: astore 5
    //   635: aload_0
    //   636: astore 7
    //   638: aload 6
    //   640: astore_0
    //   641: aload 8
    //   643: astore 6
    //   645: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +13 -> 661
    //   651: ldc 10
    //   653: iconst_2
    //   654: ldc 250
    //   656: aload 6
    //   658: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   661: aload_0
    //   662: ifnull +7 -> 669
    //   665: aload_0
    //   666: invokevirtual 254	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   669: aload 7
    //   671: ifnull +8 -> 679
    //   674: aload 7
    //   676: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   679: aload 5
    //   681: ifnull -660 -> 21
    //   684: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   687: aload 5
    //   689: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   692: iconst_0
    //   693: ireturn
    //   694: astore_0
    //   695: aload_0
    //   696: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   699: iconst_0
    //   700: ireturn
    //   701: aload 11
    //   703: astore 10
    //   705: aload_0
    //   706: astore 9
    //   708: aload 6
    //   710: astore 8
    //   712: aload 13
    //   714: iconst_0
    //   715: aload 13
    //   717: invokevirtual 226	java/lang/String:length	()I
    //   720: iconst_4
    //   721: isub
    //   722: invokevirtual 229	java/lang/String:substring	(II)Ljava/lang/String;
    //   725: ldc 224
    //   727: invokevirtual 261	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   730: astore 14
    //   732: aload 11
    //   734: astore 10
    //   736: aload_0
    //   737: astore 9
    //   739: aload 6
    //   741: astore 8
    //   743: aload 12
    //   745: aload 13
    //   747: invokeinterface 233 2 0
    //   752: checkcast 168	java/lang/Integer
    //   755: invokevirtual 236	java/lang/Integer:intValue	()I
    //   758: istore_2
    //   759: aload 14
    //   761: ifnull -360 -> 401
    //   764: aload 11
    //   766: astore 10
    //   768: aload_0
    //   769: astore 9
    //   771: aload 6
    //   773: astore 8
    //   775: aload 14
    //   777: arraylength
    //   778: newarray int
    //   780: astore 15
    //   782: iconst_0
    //   783: istore_1
    //   784: aload 11
    //   786: astore 10
    //   788: aload_0
    //   789: astore 9
    //   791: aload 6
    //   793: astore 8
    //   795: iload_1
    //   796: aload 14
    //   798: arraylength
    //   799: if_icmpge +38 -> 837
    //   802: aload 11
    //   804: astore 10
    //   806: aload_0
    //   807: astore 9
    //   809: aload 6
    //   811: astore 8
    //   813: aload 15
    //   815: iload_1
    //   816: aload 14
    //   818: iload_1
    //   819: aaload
    //   820: iconst_2
    //   821: invokevirtual 157	java/lang/String:substring	(I)Ljava/lang/String;
    //   824: bipush 16
    //   826: invokestatic 240	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   829: iastore
    //   830: iload_1
    //   831: iconst_1
    //   832: iadd
    //   833: istore_1
    //   834: goto -50 -> 784
    //   837: aload 11
    //   839: astore 10
    //   841: aload_0
    //   842: astore 9
    //   844: aload 6
    //   846: astore 8
    //   848: aload_0
    //   849: aload 14
    //   851: arraylength
    //   852: invokevirtual 242	java/io/BufferedOutputStream:write	(I)V
    //   855: iconst_0
    //   856: istore_1
    //   857: aload 11
    //   859: astore 10
    //   861: aload_0
    //   862: astore 9
    //   864: aload 6
    //   866: astore 8
    //   868: iload_1
    //   869: aload 15
    //   871: arraylength
    //   872: if_icmpge +29 -> 901
    //   875: aload 11
    //   877: astore 10
    //   879: aload_0
    //   880: astore 9
    //   882: aload 6
    //   884: astore 8
    //   886: aload_0
    //   887: aload 15
    //   889: iload_1
    //   890: iaload
    //   891: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   894: iload_1
    //   895: iconst_1
    //   896: iadd
    //   897: istore_1
    //   898: goto -41 -> 857
    //   901: aload 11
    //   903: astore 10
    //   905: aload_0
    //   906: astore 9
    //   908: aload 6
    //   910: astore 8
    //   912: aload_0
    //   913: iload_2
    //   914: invokestatic 185	com/tencent/mobileqq/text/AppleEmojiManager:writeIntToBytes	(Ljava/io/OutputStream;I)V
    //   917: goto -516 -> 401
    //   920: astore 5
    //   922: aload 7
    //   924: astore 10
    //   926: aload_0
    //   927: astore 9
    //   929: aload 6
    //   931: astore 8
    //   933: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +25 -> 961
    //   939: aload 7
    //   941: astore 10
    //   943: aload_0
    //   944: astore 9
    //   946: aload 6
    //   948: astore 8
    //   950: ldc 10
    //   952: iconst_2
    //   953: ldc_w 263
    //   956: aload 5
    //   958: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   961: aload 6
    //   963: ifnull +8 -> 971
    //   966: aload 6
    //   968: invokevirtual 254	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   971: aload_0
    //   972: ifnull +7 -> 979
    //   975: aload_0
    //   976: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   979: aload 7
    //   981: ifnull -960 -> 21
    //   984: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   987: aload 7
    //   989: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   992: iconst_0
    //   993: ireturn
    //   994: astore_0
    //   995: aload_0
    //   996: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   999: iconst_0
    //   1000: ireturn
    //   1001: aload 11
    //   1003: astore 10
    //   1005: aload_0
    //   1006: astore 9
    //   1008: aload 6
    //   1010: astore 8
    //   1012: aload_0
    //   1013: invokevirtual 194	java/io/BufferedOutputStream:flush	()V
    //   1016: aload 11
    //   1018: astore 10
    //   1020: aload_0
    //   1021: astore 9
    //   1023: aload 6
    //   1025: astore 8
    //   1027: invokestatic 269	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1030: astore 12
    //   1032: aload 11
    //   1034: astore 10
    //   1036: aload_0
    //   1037: astore 9
    //   1039: aload 6
    //   1041: astore 8
    //   1043: getstatic 275	android/os/Build$VERSION:SDK_INT	I
    //   1046: bipush 24
    //   1048: if_icmplt +342 -> 1390
    //   1051: aload 11
    //   1053: astore 10
    //   1055: aload_0
    //   1056: astore 9
    //   1058: aload 6
    //   1060: astore 8
    //   1062: aload 12
    //   1064: invokestatic 281	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   1067: astore 5
    //   1069: aload 11
    //   1071: astore 10
    //   1073: aload_0
    //   1074: astore 9
    //   1076: aload 6
    //   1078: astore 8
    //   1080: aload 12
    //   1082: aload 5
    //   1084: iconst_4
    //   1085: invokevirtual 287	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1088: invokeinterface 293 1 0
    //   1093: ldc_w 295
    //   1096: iconst_1
    //   1097: invokeinterface 301 3 0
    //   1102: invokeinterface 304 1 0
    //   1107: pop
    //   1108: aload 11
    //   1110: astore 10
    //   1112: aload_0
    //   1113: astore 9
    //   1115: aload 6
    //   1117: astore 8
    //   1119: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1122: ifeq +23 -> 1145
    //   1125: aload 11
    //   1127: astore 10
    //   1129: aload_0
    //   1130: astore 9
    //   1132: aload 6
    //   1134: astore 8
    //   1136: ldc 10
    //   1138: iconst_2
    //   1139: ldc_w 306
    //   1142: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1145: aload 11
    //   1147: astore 10
    //   1149: aload_0
    //   1150: astore 9
    //   1152: aload 6
    //   1154: astore 8
    //   1156: new 66	java/io/File
    //   1159: dup
    //   1160: getstatic 40	com/tencent/mobileqq/text/AppleEmojiManager:INDEX_FILE	Ljava/lang/String;
    //   1163: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   1166: astore 5
    //   1168: aload 11
    //   1170: astore 10
    //   1172: aload_0
    //   1173: astore 9
    //   1175: aload 6
    //   1177: astore 8
    //   1179: new 66	java/io/File
    //   1182: dup
    //   1183: getstatic 44	com/tencent/mobileqq/text/AppleEmojiManager:EMOJI_FILE	Ljava/lang/String;
    //   1186: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;)V
    //   1189: astore 12
    //   1191: aload 11
    //   1193: astore 10
    //   1195: aload_0
    //   1196: astore 9
    //   1198: aload 6
    //   1200: astore 8
    //   1202: aload 5
    //   1204: invokevirtual 70	java/io/File:exists	()Z
    //   1207: ifeq +40 -> 1247
    //   1210: aload 11
    //   1212: astore 10
    //   1214: aload_0
    //   1215: astore 9
    //   1217: aload 6
    //   1219: astore 8
    //   1221: aload 12
    //   1223: invokevirtual 70	java/io/File:exists	()Z
    //   1226: ifeq +21 -> 1247
    //   1229: aload 11
    //   1231: astore 10
    //   1233: aload_0
    //   1234: astore 9
    //   1236: aload 6
    //   1238: astore 8
    //   1240: aload 5
    //   1242: aload 12
    //   1244: invokestatic 312	com/tencent/mobileqq/text/EmotcationConstants:setEmojiMap	(Ljava/io/File;Ljava/io/File;)V
    //   1247: aload 11
    //   1249: astore 10
    //   1251: aload_0
    //   1252: astore 9
    //   1254: aload 6
    //   1256: astore 8
    //   1258: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1261: ifeq +62 -> 1323
    //   1264: aload 11
    //   1266: astore 10
    //   1268: aload_0
    //   1269: astore 9
    //   1271: aload 6
    //   1273: astore 8
    //   1275: ldc 10
    //   1277: iconst_2
    //   1278: new 14	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 314
    //   1288: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: getstatic 318	com/tencent/mobileqq/text/EmotcationConstants:EMOJI_MAP	Landroid/util/SparseIntArray;
    //   1294: invokevirtual 323	android/util/SparseIntArray:size	()I
    //   1297: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: ldc_w 328
    //   1303: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: getstatic 332	com/tencent/mobileqq/text/EmotcationConstants:DOUBLE_EMOJI_MAP	Ljava/util/Map;
    //   1309: invokeinterface 333 1 0
    //   1314: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: aload 6
    //   1325: ifnull +8 -> 1333
    //   1328: aload 6
    //   1330: invokevirtual 254	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1333: aload_0
    //   1334: ifnull +7 -> 1341
    //   1337: aload_0
    //   1338: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1341: iconst_0
    //   1342: ifeq +10 -> 1352
    //   1345: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1348: aconst_null
    //   1349: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1352: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1355: ifeq +33 -> 1388
    //   1358: ldc 10
    //   1360: iconst_2
    //   1361: new 14	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   1368: ldc_w 335
    //   1371: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: invokestatic 93	android/os/SystemClock:uptimeMillis	()J
    //   1377: lload_3
    //   1378: lsub
    //   1379: invokevirtual 338	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1382: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: iconst_1
    //   1389: ireturn
    //   1390: aload 11
    //   1392: astore 10
    //   1394: aload_0
    //   1395: astore 9
    //   1397: aload 6
    //   1399: astore 8
    //   1401: new 14	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   1408: aload 12
    //   1410: invokevirtual 341	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1413: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: ldc_w 343
    //   1419: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: astore 5
    //   1427: goto -358 -> 1069
    //   1430: astore_0
    //   1431: aload_0
    //   1432: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   1435: goto -83 -> 1352
    //   1438: astore_0
    //   1439: aconst_null
    //   1440: astore 7
    //   1442: aconst_null
    //   1443: astore 6
    //   1445: aconst_null
    //   1446: astore 5
    //   1448: aload 6
    //   1450: ifnull +8 -> 1458
    //   1453: aload 6
    //   1455: invokevirtual 254	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1458: aload 7
    //   1460: ifnull +8 -> 1468
    //   1463: aload 7
    //   1465: invokevirtual 201	java/io/BufferedOutputStream:close	()V
    //   1468: aload 5
    //   1470: ifnull +11 -> 1481
    //   1473: invokestatic 128	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1476: aload 5
    //   1478: invokevirtual 198	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1481: aload_0
    //   1482: athrow
    //   1483: astore 5
    //   1485: aload 5
    //   1487: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   1490: goto -9 -> 1481
    //   1493: astore_0
    //   1494: aconst_null
    //   1495: astore 7
    //   1497: aconst_null
    //   1498: astore 5
    //   1500: goto -52 -> 1448
    //   1503: astore_0
    //   1504: aconst_null
    //   1505: astore 8
    //   1507: aload 5
    //   1509: astore 7
    //   1511: aload 8
    //   1513: astore 5
    //   1515: goto -67 -> 1448
    //   1518: astore 9
    //   1520: aload_0
    //   1521: astore 7
    //   1523: aload 5
    //   1525: astore 8
    //   1527: aload 9
    //   1529: astore_0
    //   1530: aload 7
    //   1532: astore 5
    //   1534: aload 8
    //   1536: astore 7
    //   1538: goto -90 -> 1448
    //   1541: astore_0
    //   1542: aload 5
    //   1544: astore 7
    //   1546: aload 8
    //   1548: astore 5
    //   1550: goto -102 -> 1448
    //   1553: astore_0
    //   1554: aload 10
    //   1556: astore 5
    //   1558: aload 9
    //   1560: astore 7
    //   1562: aload 8
    //   1564: astore 6
    //   1566: goto -118 -> 1448
    //   1569: astore 8
    //   1571: aload_0
    //   1572: astore 6
    //   1574: aload 8
    //   1576: astore_0
    //   1577: goto -129 -> 1448
    //   1580: astore 5
    //   1582: aconst_null
    //   1583: astore_0
    //   1584: aconst_null
    //   1585: astore 6
    //   1587: aconst_null
    //   1588: astore 7
    //   1590: goto -668 -> 922
    //   1593: astore 5
    //   1595: aconst_null
    //   1596: astore_0
    //   1597: aconst_null
    //   1598: astore 7
    //   1600: goto -678 -> 922
    //   1603: astore 8
    //   1605: aconst_null
    //   1606: astore 7
    //   1608: aload 5
    //   1610: astore_0
    //   1611: aload 8
    //   1613: astore 5
    //   1615: goto -693 -> 922
    //   1618: astore 7
    //   1620: aload 5
    //   1622: astore 8
    //   1624: aload 7
    //   1626: astore 5
    //   1628: aload_0
    //   1629: astore 7
    //   1631: aload 8
    //   1633: astore_0
    //   1634: goto -712 -> 922
    //   1637: astore 8
    //   1639: aload 5
    //   1641: astore_0
    //   1642: aload 8
    //   1644: astore 5
    //   1646: goto -724 -> 922
    //   1649: astore 6
    //   1651: aload 8
    //   1653: astore 5
    //   1655: aload 9
    //   1657: astore_0
    //   1658: goto -1013 -> 645
    //   1661: astore 5
    //   1663: aload 6
    //   1665: astore_0
    //   1666: aload 5
    //   1668: astore 6
    //   1670: aload 8
    //   1672: astore 5
    //   1674: goto -1029 -> 645
    //   1677: astore 9
    //   1679: aload 5
    //   1681: astore_0
    //   1682: aload 6
    //   1684: astore 8
    //   1686: aload 9
    //   1688: astore 6
    //   1690: aload 7
    //   1692: astore 5
    //   1694: aload_0
    //   1695: astore 7
    //   1697: aload 8
    //   1699: astore_0
    //   1700: goto -1055 -> 645
    //   1703: astore 9
    //   1705: aconst_null
    //   1706: astore 8
    //   1708: aload 5
    //   1710: astore 7
    //   1712: aload 6
    //   1714: astore_0
    //   1715: aload 9
    //   1717: astore 6
    //   1719: aload 8
    //   1721: astore 5
    //   1723: goto -1078 -> 645
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1726	0	paramFile	java.io.File
    //   148	750	1	i	int
    //   257	657	2	j	int
    //   55	1323	3	l	long
    //   36	652	5	localObject1	Object
    //   920	37	5	localIOException1	java.io.IOException
    //   1067	410	5	localObject2	Object
    //   1483	3	5	localIOException2	java.io.IOException
    //   1498	59	5	localObject3	Object
    //   1580	1	5	localIOException3	java.io.IOException
    //   1593	16	5	localIOException4	java.io.IOException
    //   1613	41	5	localObject4	Object
    //   1661	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   1672	50	5	localObject5	Object
    //   90	1496	6	localObject6	Object
    //   1649	15	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1668	50	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   60	1547	7	localObject7	Object
    //   1618	7	7	localIOException5	java.io.IOException
    //   1629	82	7	localObject8	Object
    //   66	535	8	localObject9	Object
    //   630	12	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   710	853	8	localObject10	Object
    //   1569	6	8	localObject11	Object
    //   1603	9	8	localIOException6	java.io.IOException
    //   1622	10	8	localObject12	Object
    //   1637	34	8	localIOException7	java.io.IOException
    //   1684	36	8	localObject13	Object
    //   57	1339	9	localObject14	Object
    //   1518	138	9	localObject15	Object
    //   1677	10	9	localFileNotFoundException5	java.io.FileNotFoundException
    //   1703	13	9	localFileNotFoundException6	java.io.FileNotFoundException
    //   63	1492	10	localObject16	Object
    //   334	1057	11	localObject17	Object
    //   131	1278	12	localObject18	Object
    //   443	303	13	str1	String
    //   490	41	14	str2	String
    //   589	33	14	localException	java.lang.Exception
    //   730	120	14	arrayOfString	String[]
    //   780	108	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   456	466	589	java/lang/Exception
    //   477	492	589	java/lang/Exception
    //   503	519	589	java/lang/Exception
    //   530	538	589	java/lang/Exception
    //   549	554	589	java/lang/Exception
    //   565	570	589	java/lang/Exception
    //   581	586	589	java/lang/Exception
    //   712	732	589	java/lang/Exception
    //   743	759	589	java/lang/Exception
    //   775	782	589	java/lang/Exception
    //   795	802	589	java/lang/Exception
    //   813	830	589	java/lang/Exception
    //   848	855	589	java/lang/Exception
    //   868	875	589	java/lang/Exception
    //   886	894	589	java/lang/Exception
    //   912	917	589	java/lang/Exception
    //   387	401	630	java/io/FileNotFoundException
    //   412	422	630	java/io/FileNotFoundException
    //   433	445	630	java/io/FileNotFoundException
    //   456	466	630	java/io/FileNotFoundException
    //   477	492	630	java/io/FileNotFoundException
    //   503	519	630	java/io/FileNotFoundException
    //   530	538	630	java/io/FileNotFoundException
    //   549	554	630	java/io/FileNotFoundException
    //   565	570	630	java/io/FileNotFoundException
    //   581	586	630	java/io/FileNotFoundException
    //   602	627	630	java/io/FileNotFoundException
    //   712	732	630	java/io/FileNotFoundException
    //   743	759	630	java/io/FileNotFoundException
    //   775	782	630	java/io/FileNotFoundException
    //   795	802	630	java/io/FileNotFoundException
    //   813	830	630	java/io/FileNotFoundException
    //   848	855	630	java/io/FileNotFoundException
    //   868	875	630	java/io/FileNotFoundException
    //   886	894	630	java/io/FileNotFoundException
    //   912	917	630	java/io/FileNotFoundException
    //   1012	1016	630	java/io/FileNotFoundException
    //   1027	1032	630	java/io/FileNotFoundException
    //   1043	1051	630	java/io/FileNotFoundException
    //   1062	1069	630	java/io/FileNotFoundException
    //   1080	1108	630	java/io/FileNotFoundException
    //   1119	1125	630	java/io/FileNotFoundException
    //   1136	1145	630	java/io/FileNotFoundException
    //   1156	1168	630	java/io/FileNotFoundException
    //   1179	1191	630	java/io/FileNotFoundException
    //   1202	1210	630	java/io/FileNotFoundException
    //   1221	1229	630	java/io/FileNotFoundException
    //   1240	1247	630	java/io/FileNotFoundException
    //   1258	1264	630	java/io/FileNotFoundException
    //   1275	1323	630	java/io/FileNotFoundException
    //   1401	1427	630	java/io/FileNotFoundException
    //   665	669	694	java/io/IOException
    //   674	679	694	java/io/IOException
    //   684	692	694	java/io/IOException
    //   387	401	920	java/io/IOException
    //   412	422	920	java/io/IOException
    //   433	445	920	java/io/IOException
    //   456	466	920	java/io/IOException
    //   477	492	920	java/io/IOException
    //   503	519	920	java/io/IOException
    //   530	538	920	java/io/IOException
    //   549	554	920	java/io/IOException
    //   565	570	920	java/io/IOException
    //   581	586	920	java/io/IOException
    //   602	627	920	java/io/IOException
    //   712	732	920	java/io/IOException
    //   743	759	920	java/io/IOException
    //   775	782	920	java/io/IOException
    //   795	802	920	java/io/IOException
    //   813	830	920	java/io/IOException
    //   848	855	920	java/io/IOException
    //   868	875	920	java/io/IOException
    //   886	894	920	java/io/IOException
    //   912	917	920	java/io/IOException
    //   1012	1016	920	java/io/IOException
    //   1027	1032	920	java/io/IOException
    //   1043	1051	920	java/io/IOException
    //   1062	1069	920	java/io/IOException
    //   1080	1108	920	java/io/IOException
    //   1119	1125	920	java/io/IOException
    //   1136	1145	920	java/io/IOException
    //   1156	1168	920	java/io/IOException
    //   1179	1191	920	java/io/IOException
    //   1202	1210	920	java/io/IOException
    //   1221	1229	920	java/io/IOException
    //   1240	1247	920	java/io/IOException
    //   1258	1264	920	java/io/IOException
    //   1275	1323	920	java/io/IOException
    //   1401	1427	920	java/io/IOException
    //   966	971	994	java/io/IOException
    //   975	979	994	java/io/IOException
    //   984	992	994	java/io/IOException
    //   1328	1333	1430	java/io/IOException
    //   1337	1341	1430	java/io/IOException
    //   1345	1352	1430	java/io/IOException
    //   68	92	1438	finally
    //   1453	1458	1483	java/io/IOException
    //   1463	1468	1483	java/io/IOException
    //   1473	1481	1483	java/io/IOException
    //   92	111	1493	finally
    //   115	133	1503	finally
    //   137	147	1503	finally
    //   152	159	1518	finally
    //   167	174	1518	finally
    //   186	196	1518	finally
    //   199	218	1518	finally
    //   221	231	1518	finally
    //   234	248	1518	finally
    //   251	258	1518	finally
    //   266	272	1518	finally
    //   279	286	1518	finally
    //   294	302	1518	finally
    //   312	317	1518	finally
    //   323	330	1518	finally
    //   339	358	1541	finally
    //   358	376	1541	finally
    //   387	401	1553	finally
    //   412	422	1553	finally
    //   433	445	1553	finally
    //   456	466	1553	finally
    //   477	492	1553	finally
    //   503	519	1553	finally
    //   530	538	1553	finally
    //   549	554	1553	finally
    //   565	570	1553	finally
    //   581	586	1553	finally
    //   602	627	1553	finally
    //   712	732	1553	finally
    //   743	759	1553	finally
    //   775	782	1553	finally
    //   795	802	1553	finally
    //   813	830	1553	finally
    //   848	855	1553	finally
    //   868	875	1553	finally
    //   886	894	1553	finally
    //   912	917	1553	finally
    //   933	939	1553	finally
    //   950	961	1553	finally
    //   1012	1016	1553	finally
    //   1027	1032	1553	finally
    //   1043	1051	1553	finally
    //   1062	1069	1553	finally
    //   1080	1108	1553	finally
    //   1119	1125	1553	finally
    //   1136	1145	1553	finally
    //   1156	1168	1553	finally
    //   1179	1191	1553	finally
    //   1202	1210	1553	finally
    //   1221	1229	1553	finally
    //   1240	1247	1553	finally
    //   1258	1264	1553	finally
    //   1275	1323	1553	finally
    //   1401	1427	1553	finally
    //   645	661	1569	finally
    //   68	92	1580	java/io/IOException
    //   92	111	1593	java/io/IOException
    //   115	133	1603	java/io/IOException
    //   137	147	1603	java/io/IOException
    //   152	159	1618	java/io/IOException
    //   167	174	1618	java/io/IOException
    //   186	196	1618	java/io/IOException
    //   199	218	1618	java/io/IOException
    //   221	231	1618	java/io/IOException
    //   234	248	1618	java/io/IOException
    //   251	258	1618	java/io/IOException
    //   266	272	1618	java/io/IOException
    //   279	286	1618	java/io/IOException
    //   294	302	1618	java/io/IOException
    //   312	317	1618	java/io/IOException
    //   323	330	1618	java/io/IOException
    //   339	358	1637	java/io/IOException
    //   358	376	1637	java/io/IOException
    //   68	92	1649	java/io/FileNotFoundException
    //   92	111	1661	java/io/FileNotFoundException
    //   115	133	1677	java/io/FileNotFoundException
    //   137	147	1677	java/io/FileNotFoundException
    //   152	159	1677	java/io/FileNotFoundException
    //   167	174	1677	java/io/FileNotFoundException
    //   186	196	1677	java/io/FileNotFoundException
    //   199	218	1677	java/io/FileNotFoundException
    //   221	231	1677	java/io/FileNotFoundException
    //   234	248	1677	java/io/FileNotFoundException
    //   251	258	1677	java/io/FileNotFoundException
    //   266	272	1677	java/io/FileNotFoundException
    //   279	286	1677	java/io/FileNotFoundException
    //   294	302	1677	java/io/FileNotFoundException
    //   312	317	1677	java/io/FileNotFoundException
    //   323	330	1677	java/io/FileNotFoundException
    //   339	358	1703	java/io/FileNotFoundException
    //   358	376	1703	java/io/FileNotFoundException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.AppleEmojiManager
 * JD-Core Version:    0.7.0.1
 */