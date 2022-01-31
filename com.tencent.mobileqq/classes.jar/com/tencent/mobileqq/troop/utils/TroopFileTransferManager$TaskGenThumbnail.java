package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskGenThumbnail
  extends TroopFileTransferManager.Task
{
  public int b;
  
  public TroopFileTransferManager$TaskGenThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 1);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: iconst_1
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   12: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   15: invokestatic 41	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 46	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   26: astore 6
    //   28: aload 6
    //   30: monitorenter
    //   31: aload_0
    //   32: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   35: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   38: bipush 12
    //   40: if_icmpne +7 -> 47
    //   43: aload 6
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   51: aload_0
    //   52: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   55: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   58: aload_0
    //   59: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   62: invokevirtual 59	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   65: astore 9
    //   67: new 61	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   74: aload 9
    //   76: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 69
    //   81: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 10
    //   89: aload 6
    //   91: monitorexit
    //   92: iload_1
    //   93: iconst_2
    //   94: if_icmpne +575 -> 669
    //   97: aconst_null
    //   98: aload_0
    //   99: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   102: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   105: invokestatic 81	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   108: astore 8
    //   110: aload 8
    //   112: ifnull +855 -> 967
    //   115: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +60 -> 178
    //   121: ldc 89
    //   123: iconst_2
    //   124: new 61	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   131: ldc 91
    //   133: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   140: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   143: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 93
    //   148: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 8
    //   153: invokevirtual 99	android/graphics/Bitmap:getWidth	()I
    //   156: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc 104
    //   161: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 8
    //   166: invokevirtual 107	android/graphics/Bitmap:getHeight	()I
    //   169: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: new 113	java/io/File
    //   181: dup
    //   182: aload 10
    //   184: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: astore 6
    //   189: aload 6
    //   191: invokevirtual 119	java/io/File:exists	()Z
    //   194: ifeq +9 -> 203
    //   197: aload 6
    //   199: invokevirtual 122	java/io/File:delete	()Z
    //   202: pop
    //   203: aload 6
    //   205: invokevirtual 125	java/io/File:createNewFile	()Z
    //   208: pop
    //   209: new 127	java/io/BufferedOutputStream
    //   212: dup
    //   213: new 129	java/io/FileOutputStream
    //   216: dup
    //   217: aload 6
    //   219: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   222: invokespecial 135	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   225: astore 7
    //   227: aload 7
    //   229: astore 6
    //   231: aload 8
    //   233: getstatic 141	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   236: bipush 100
    //   238: aload 7
    //   240: invokevirtual 145	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   243: pop
    //   244: aload 7
    //   246: astore 6
    //   248: aload 8
    //   250: invokevirtual 148	android/graphics/Bitmap:recycle	()V
    //   253: aload 7
    //   255: astore 6
    //   257: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +48 -> 308
    //   263: aload 7
    //   265: astore 6
    //   267: ldc 89
    //   269: iconst_2
    //   270: new 61	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   277: ldc 150
    //   279: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   286: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   289: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc 152
    //   294: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 10
    //   299: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload 7
    //   310: astore 6
    //   312: aload 7
    //   314: invokevirtual 155	java/io/BufferedOutputStream:flush	()V
    //   317: iload_3
    //   318: istore_2
    //   319: aload 7
    //   321: ifnull +10 -> 331
    //   324: aload 7
    //   326: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   329: iload_3
    //   330: istore_2
    //   331: aload_0
    //   332: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   335: astore 6
    //   337: aload 6
    //   339: monitorenter
    //   340: iload_2
    //   341: ifeq +485 -> 826
    //   344: new 113	java/io/File
    //   347: dup
    //   348: aload 10
    //   350: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   353: astore 7
    //   355: aload 7
    //   357: new 113	java/io/File
    //   360: dup
    //   361: aload 9
    //   363: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   366: invokevirtual 162	java/io/File:renameTo	(Ljava/io/File;)Z
    //   369: pop
    //   370: aload 7
    //   372: invokevirtual 165	java/io/File:deleteOnExit	()V
    //   375: aload_0
    //   376: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   379: sipush 128
    //   382: if_icmpne +520 -> 902
    //   385: aload_0
    //   386: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   389: iconst_0
    //   390: putfield 169	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   393: aload_0
    //   394: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   397: aload_0
    //   398: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   401: aload_0
    //   402: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   405: invokevirtual 172	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   408: pop
    //   409: aload_0
    //   410: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   413: lconst_0
    //   414: putfield 175	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   417: aload_0
    //   418: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   421: getfield 178	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Ljava/util/Map;
    //   424: aload_0
    //   425: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   428: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   431: invokeinterface 188 2 0
    //   436: ifeq +14 -> 450
    //   439: aload_0
    //   440: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   443: aload_0
    //   444: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   447: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   450: aload 6
    //   452: monitorexit
    //   453: return
    //   454: astore 7
    //   456: aload 6
    //   458: monitorexit
    //   459: aload 7
    //   461: athrow
    //   462: astore 7
    //   464: aload 6
    //   466: monitorexit
    //   467: aload 7
    //   469: athrow
    //   470: astore 7
    //   472: aload 7
    //   474: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   477: goto -268 -> 209
    //   480: astore 6
    //   482: iconst_0
    //   483: istore_3
    //   484: iload_3
    //   485: istore_2
    //   486: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -158 -> 331
    //   492: ldc 89
    //   494: iconst_2
    //   495: new 61	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   502: ldc 91
    //   504: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   511: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   514: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: aload 6
    //   522: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   525: iload_3
    //   526: istore_2
    //   527: goto -196 -> 331
    //   530: astore 6
    //   532: aload 6
    //   534: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   537: iload_3
    //   538: istore_2
    //   539: goto -208 -> 331
    //   542: astore 6
    //   544: iload 4
    //   546: istore_3
    //   547: goto -63 -> 484
    //   550: astore 8
    //   552: aconst_null
    //   553: astore 7
    //   555: aload 7
    //   557: astore 6
    //   559: aload 8
    //   561: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   564: aload 7
    //   566: ifnull +401 -> 967
    //   569: aload 7
    //   571: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   574: iconst_0
    //   575: istore_2
    //   576: goto -245 -> 331
    //   579: astore 6
    //   581: aload 6
    //   583: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   586: iconst_0
    //   587: istore_2
    //   588: goto -257 -> 331
    //   591: astore 7
    //   593: aconst_null
    //   594: astore 6
    //   596: aload 6
    //   598: ifnull +8 -> 606
    //   601: aload 6
    //   603: invokevirtual 158	java/io/BufferedOutputStream:close	()V
    //   606: aload 7
    //   608: athrow
    //   609: astore 6
    //   611: iconst_0
    //   612: istore_3
    //   613: iload_3
    //   614: istore_2
    //   615: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq -287 -> 331
    //   621: ldc 89
    //   623: iconst_2
    //   624: new 61	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   631: ldc 91
    //   633: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   640: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   643: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: aload 6
    //   651: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: iload_3
    //   655: istore_2
    //   656: goto -325 -> 331
    //   659: astore 6
    //   661: aload 6
    //   663: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   666: goto -60 -> 606
    //   669: aload_0
    //   670: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   673: sipush 383
    //   676: if_icmpeq +13 -> 689
    //   679: aload_0
    //   680: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   683: sipush 640
    //   686: if_icmpne +116 -> 802
    //   689: aload_0
    //   690: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   693: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   696: astore 6
    //   698: aload_0
    //   699: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   702: sipush 383
    //   705: if_icmpne +43 -> 748
    //   708: aload_0
    //   709: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   712: aload_0
    //   713: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   716: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	J
    //   719: sipush 640
    //   722: invokevirtual 59	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   725: astore 7
    //   727: aload 7
    //   729: astore 6
    //   731: aload 7
    //   733: invokestatic 203	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   736: ifne +12 -> 748
    //   739: aload_0
    //   740: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   743: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   746: astore 6
    //   748: aload_0
    //   749: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   752: sipush 640
    //   755: if_icmpne +207 -> 962
    //   758: iconst_2
    //   759: istore_1
    //   760: aload 6
    //   762: invokestatic 203	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   765: ifeq +32 -> 797
    //   768: aload 6
    //   770: aload 10
    //   772: iconst_1
    //   773: ldc 205
    //   775: iload_1
    //   776: invokestatic 210	com/tencent/mobileqq/pic/compress/Utils:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)Z
    //   779: pop
    //   780: iload_3
    //   781: istore_2
    //   782: goto -451 -> 331
    //   785: astore 6
    //   787: aload 6
    //   789: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   792: iconst_0
    //   793: istore_2
    //   794: goto -463 -> 331
    //   797: iconst_0
    //   798: istore_2
    //   799: goto -468 -> 331
    //   802: aload_0
    //   803: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   806: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   809: aload 10
    //   811: aload_0
    //   812: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   815: aload_0
    //   816: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   819: invokestatic 215	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   822: istore_2
    //   823: goto -492 -> 331
    //   826: new 113	java/io/File
    //   829: dup
    //   830: aload 10
    //   832: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   835: invokevirtual 122	java/io/File:delete	()Z
    //   838: pop
    //   839: aload_0
    //   840: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   843: getfield 218	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   846: ifnull -471 -> 375
    //   849: aload_0
    //   850: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   853: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   856: invokestatic 224	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +23 -> 882
    //   862: new 113	java/io/File
    //   865: dup
    //   866: aload_0
    //   867: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   870: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   873: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   876: invokevirtual 119	java/io/File:exists	()Z
    //   879: ifne -504 -> 375
    //   882: aload_0
    //   883: getfield 11	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   886: aload_0
    //   887: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   890: aload_0
    //   891: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   894: iconst_0
    //   895: invokevirtual 227	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IZ)V
    //   898: aload 6
    //   900: monitorexit
    //   901: return
    //   902: aload_0
    //   903: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   906: sipush 640
    //   909: if_icmpne +14 -> 923
    //   912: aload_0
    //   913: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   916: iconst_0
    //   917: putfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   920: goto -527 -> 393
    //   923: aload_0
    //   924: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:jdField_b_of_type_Int	I
    //   927: sipush 383
    //   930: if_icmpne -537 -> 393
    //   933: aload_0
    //   934: getfield 30	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   937: iconst_0
    //   938: putfield 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   941: goto -548 -> 393
    //   944: astore 6
    //   946: iload 5
    //   948: istore_3
    //   949: goto -336 -> 613
    //   952: astore 7
    //   954: goto -358 -> 596
    //   957: astore 8
    //   959: goto -404 -> 555
    //   962: iconst_1
    //   963: istore_1
    //   964: goto -204 -> 760
    //   967: iconst_0
    //   968: istore_2
    //   969: goto -638 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	972	0	this	TaskGenThumbnail
    //   21	943	1	i	int
    //   318	651	2	bool1	boolean
    //   7	942	3	bool2	boolean
    //   1	544	4	bool3	boolean
    //   4	943	5	bool4	boolean
    //   26	439	6	localObject1	java.lang.Object
    //   480	41	6	localException1	java.lang.Exception
    //   530	3	6	localException2	java.lang.Exception
    //   542	1	6	localException3	java.lang.Exception
    //   557	1	6	localObject2	java.lang.Object
    //   579	3	6	localException4	java.lang.Exception
    //   594	8	6	localObject3	java.lang.Object
    //   609	41	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   659	3	6	localException5	java.lang.Exception
    //   696	73	6	localObject4	java.lang.Object
    //   785	114	6	localException6	java.lang.Exception
    //   944	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   225	146	7	localObject5	java.lang.Object
    //   454	6	7	localObject6	java.lang.Object
    //   462	6	7	localObject7	java.lang.Object
    //   470	3	7	localIOException	java.io.IOException
    //   553	17	7	localObject8	java.lang.Object
    //   591	16	7	localObject9	java.lang.Object
    //   725	7	7	str1	java.lang.String
    //   952	1	7	localObject10	java.lang.Object
    //   108	141	8	localBitmap	android.graphics.Bitmap
    //   550	10	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   957	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   65	297	9	str2	java.lang.String
    //   87	744	10	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   344	375	454	finally
    //   375	393	454	finally
    //   393	450	454	finally
    //   450	453	454	finally
    //   456	459	454	finally
    //   826	882	454	finally
    //   882	901	454	finally
    //   902	920	454	finally
    //   923	941	454	finally
    //   31	46	462	finally
    //   47	92	462	finally
    //   464	467	462	finally
    //   203	209	470	java/io/IOException
    //   97	110	480	java/lang/Exception
    //   115	178	480	java/lang/Exception
    //   178	203	480	java/lang/Exception
    //   203	209	480	java/lang/Exception
    //   472	477	480	java/lang/Exception
    //   581	586	480	java/lang/Exception
    //   606	609	480	java/lang/Exception
    //   661	666	480	java/lang/Exception
    //   324	329	530	java/lang/Exception
    //   532	537	542	java/lang/Exception
    //   209	227	550	java/io/FileNotFoundException
    //   569	574	579	java/lang/Exception
    //   209	227	591	finally
    //   97	110	609	java/lang/OutOfMemoryError
    //   115	178	609	java/lang/OutOfMemoryError
    //   178	203	609	java/lang/OutOfMemoryError
    //   203	209	609	java/lang/OutOfMemoryError
    //   472	477	609	java/lang/OutOfMemoryError
    //   569	574	609	java/lang/OutOfMemoryError
    //   581	586	609	java/lang/OutOfMemoryError
    //   601	606	609	java/lang/OutOfMemoryError
    //   606	609	609	java/lang/OutOfMemoryError
    //   661	666	609	java/lang/OutOfMemoryError
    //   601	606	659	java/lang/Exception
    //   760	780	785	java/lang/Exception
    //   324	329	944	java/lang/OutOfMemoryError
    //   532	537	944	java/lang/OutOfMemoryError
    //   231	244	952	finally
    //   248	253	952	finally
    //   257	263	952	finally
    //   267	308	952	finally
    //   312	317	952	finally
    //   559	564	952	finally
    //   231	244	957	java/io/FileNotFoundException
    //   248	253	957	java/io/FileNotFoundException
    //   257	263	957	java/io/FileNotFoundException
    //   267	308	957	java/io/FileNotFoundException
    //   312	317	957	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskGenThumbnail
 * JD-Core Version:    0.7.0.1
 */