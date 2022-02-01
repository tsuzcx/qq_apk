package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownloadThumbnail
  extends TroopFileTransferManager.Task
{
  public String a;
  public int b;
  
  public TroopFileTransferManager$TaskHttpDownloadThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    super(paramTroopFileTransferManager, paramItem, 4);
    this.jdField_a_of_type_JavaLangString = "80";
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 44	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 46
    //   8: iconst_4
    //   9: ldc 48
    //   11: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 54	java/io/File
    //   17: dup
    //   18: getstatic 59	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   21: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 12
    //   26: aload 12
    //   28: invokevirtual 65	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 12
    //   36: invokevirtual 68	java/io/File:mkdir	()Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: aload_0
    //   45: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   48: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   51: aload_0
    //   52: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   55: invokevirtual 83	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   58: astore 16
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   67: aload 16
    //   69: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 93
    //   74: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 17
    //   82: aload_0
    //   83: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   86: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   89: invokestatic 106	com/tencent/mobileqq/filemanager/util/FileUtil:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokestatic 111	auea:a	(Ljava/lang/String;)I
    //   95: istore 6
    //   97: iload 6
    //   99: iconst_2
    //   100: if_icmpne +334 -> 434
    //   103: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +43 -> 149
    //   109: ldc 46
    //   111: iconst_2
    //   112: new 85	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   119: ldc 116
    //   121: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 21	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   128: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 118
    //   133: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   140: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 124	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_0
    //   150: getfield 21	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: invokestatic 130	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   156: invokevirtual 134	java/lang/Integer:intValue	()I
    //   159: istore_1
    //   160: iload_1
    //   161: istore_2
    //   162: iload_1
    //   163: ifgt +7 -> 170
    //   166: sipush 443
    //   169: istore_2
    //   170: aload_0
    //   171: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   174: ifgt +10 -> 184
    //   177: aload_0
    //   178: sipush 383
    //   181: putfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   184: new 85	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   191: ldc 136
    //   193: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   200: getfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   203: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 141
    //   208: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload_2
    //   212: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc 143
    //   217: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   224: getfield 146	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   227: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 148
    //   232: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   239: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 150
    //   244: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_0
    //   248: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   251: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: ldc 152
    //   256: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: astore 13
    //   264: aload 13
    //   266: astore 12
    //   268: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +48 -> 319
    //   274: ldc 154
    //   276: iconst_2
    //   277: new 85	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   284: ldc 156
    //   286: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   296: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 158
    //   301: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 13
    //   306: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 13
    //   317: astore 12
    //   319: new 160	java/net/URL
    //   322: dup
    //   323: aload 12
    //   325: invokespecial 161	java/net/URL:<init>	(Ljava/lang/String;)V
    //   328: astore 18
    //   330: iconst_0
    //   331: istore_3
    //   332: iconst_0
    //   333: istore_1
    //   334: iload_1
    //   335: sipush 1000
    //   338: imul
    //   339: i2l
    //   340: lstore 8
    //   342: lload 8
    //   344: invokestatic 167	java/lang/Thread:sleep	(J)V
    //   347: new 54	java/io/File
    //   350: dup
    //   351: aload 17
    //   353: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   356: astore 15
    //   358: aload 15
    //   360: invokevirtual 170	java/io/File:delete	()Z
    //   363: pop
    //   364: iload_1
    //   365: iconst_1
    //   366: iadd
    //   367: istore_1
    //   368: iload_1
    //   369: iconst_3
    //   370: if_icmple +323 -> 693
    //   373: aload_0
    //   374: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   377: sipush 128
    //   380: if_icmpne +256 -> 636
    //   383: aload_0
    //   384: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   387: iconst_0
    //   388: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   391: return
    //   392: astore 12
    //   394: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +32 -> 429
    //   400: ldc 46
    //   402: iconst_2
    //   403: new 85	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   410: ldc 176
    //   412: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 12
    //   417: invokevirtual 177	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   420: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 179	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iconst_0
    //   430: istore_1
    //   431: goto -271 -> 160
    //   434: new 85	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   441: ldc 136
    //   443: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   450: getfield 139	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   453: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc 181
    //   458: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_0
    //   462: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   465: getfield 146	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   468: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc 183
    //   473: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   480: getfield 186	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   483: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc 188
    //   488: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_0
    //   492: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   495: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   498: ldc 150
    //   500: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   507: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: astore 12
    //   515: goto -196 -> 319
    //   518: astore 12
    //   520: aload_0
    //   521: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   524: sipush 128
    //   527: if_icmpne +12 -> 539
    //   530: aload_0
    //   531: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   534: iconst_0
    //   535: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   538: return
    //   539: aload_0
    //   540: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   543: sipush 640
    //   546: if_icmpne +12 -> 558
    //   549: aload_0
    //   550: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   553: iconst_0
    //   554: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   557: return
    //   558: aload_0
    //   559: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   562: sipush 383
    //   565: if_icmpne -174 -> 391
    //   568: aload_0
    //   569: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   572: iconst_0
    //   573: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   576: return
    //   577: astore 12
    //   579: aload_0
    //   580: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   583: sipush 128
    //   586: if_icmpne +12 -> 598
    //   589: aload_0
    //   590: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   593: iconst_0
    //   594: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   597: return
    //   598: aload_0
    //   599: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   602: sipush 640
    //   605: if_icmpne +12 -> 617
    //   608: aload_0
    //   609: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   612: iconst_0
    //   613: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   616: return
    //   617: aload_0
    //   618: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   621: sipush 383
    //   624: if_icmpne -233 -> 391
    //   627: aload_0
    //   628: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   631: iconst_0
    //   632: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   635: return
    //   636: aload_0
    //   637: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   640: sipush 640
    //   643: if_icmpne +12 -> 655
    //   646: aload_0
    //   647: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   650: iconst_0
    //   651: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   654: return
    //   655: aload_0
    //   656: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   659: sipush 383
    //   662: if_icmpne -271 -> 391
    //   665: aload_0
    //   666: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   669: iconst_0
    //   670: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   673: aload_0
    //   674: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   677: iconst_1
    //   678: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   681: aload_0
    //   682: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   685: aload_0
    //   686: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   689: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   692: return
    //   693: aload 15
    //   695: invokevirtual 203	java/io/File:createNewFile	()Z
    //   698: pop
    //   699: aconst_null
    //   700: astore 14
    //   702: aload 18
    //   704: invokevirtual 207	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   707: checkcast 209	java/net/HttpURLConnection
    //   710: astore 12
    //   712: iload_3
    //   713: istore 4
    //   715: aload 12
    //   717: sipush 30000
    //   720: invokevirtual 213	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   723: iload_3
    //   724: istore 4
    //   726: aload 12
    //   728: ldc 215
    //   730: invokevirtual 218	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   733: iload_3
    //   734: istore 4
    //   736: aload 12
    //   738: ldc 220
    //   740: ldc 222
    //   742: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: iload_3
    //   746: istore 4
    //   748: aload 12
    //   750: ldc 228
    //   752: ldc 230
    //   754: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: iload_3
    //   758: istore 4
    //   760: aload 12
    //   762: ldc 232
    //   764: new 85	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   771: ldc 234
    //   773: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_0
    //   777: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   780: getfield 237	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   783: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: invokevirtual 226	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: iload_3
    //   793: istore 4
    //   795: aload 12
    //   797: invokevirtual 240	java/net/HttpURLConnection:getResponseCode	()I
    //   800: istore 7
    //   802: iload_3
    //   803: istore_2
    //   804: iload 6
    //   806: iconst_2
    //   807: if_icmpne +224 -> 1031
    //   810: iload_3
    //   811: istore 4
    //   813: aload 12
    //   815: ldc 242
    //   817: invokevirtual 245	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   820: astore 13
    //   822: iload_3
    //   823: istore 4
    //   825: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq +66 -> 894
    //   831: iload_3
    //   832: istore 4
    //   834: ldc 154
    //   836: iconst_2
    //   837: new 85	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   844: ldc 156
    //   846: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_0
    //   850: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   853: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   856: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: ldc 247
    //   861: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: iload 7
    //   866: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: ldc 249
    //   871: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload 13
    //   876: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc 251
    //   881: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: iload_1
    //   885: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: iload_3
    //   895: istore_2
    //   896: iload_3
    //   897: istore 4
    //   899: aload 13
    //   901: invokestatic 257	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   904: ifne +127 -> 1031
    //   907: iload_3
    //   908: istore_2
    //   909: iload_3
    //   910: istore 4
    //   912: aload 13
    //   914: ldc_w 259
    //   917: invokevirtual 264	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   920: ifeq +111 -> 1031
    //   923: iload_3
    //   924: istore 4
    //   926: aload 13
    //   928: invokevirtual 267	java/lang/String:trim	()Ljava/lang/String;
    //   931: ldc_w 269
    //   934: invokevirtual 273	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   937: astore 13
    //   939: iload_3
    //   940: istore_2
    //   941: aload 13
    //   943: ifnull +88 -> 1031
    //   946: iload_3
    //   947: istore_2
    //   948: iload_3
    //   949: istore 4
    //   951: aload 13
    //   953: arraylength
    //   954: ifle +77 -> 1031
    //   957: iconst_0
    //   958: istore 5
    //   960: iload_3
    //   961: istore_2
    //   962: iload_3
    //   963: istore 4
    //   965: iload 5
    //   967: aload 13
    //   969: arraylength
    //   970: if_icmpge +61 -> 1031
    //   973: iload_3
    //   974: istore 4
    //   976: aload 13
    //   978: iload 5
    //   980: aaload
    //   981: ldc_w 275
    //   984: invokevirtual 273	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   987: astore 14
    //   989: aload 14
    //   991: ifnull +183 -> 1174
    //   994: iload_3
    //   995: istore 4
    //   997: aload 14
    //   999: arraylength
    //   1000: iconst_2
    //   1001: if_icmpne +173 -> 1174
    //   1004: iload_3
    //   1005: istore 4
    //   1007: ldc_w 259
    //   1010: aload 14
    //   1012: iconst_0
    //   1013: aaload
    //   1014: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1017: ifeq +157 -> 1174
    //   1020: iload_3
    //   1021: istore 4
    //   1023: aload 14
    //   1025: iconst_1
    //   1026: aaload
    //   1027: invokestatic 282	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1030: istore_2
    //   1031: iload 7
    //   1033: sipush 200
    //   1036: if_icmpeq +11 -> 1047
    //   1039: iload 7
    //   1041: sipush 206
    //   1044: if_icmpne +774 -> 1818
    //   1047: iload_2
    //   1048: istore 4
    //   1050: aload 12
    //   1052: invokevirtual 286	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1055: astore 19
    //   1057: iload_2
    //   1058: istore 4
    //   1060: new 288	java/io/FileOutputStream
    //   1063: dup
    //   1064: aload 15
    //   1066: invokespecial 291	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1069: astore 14
    //   1071: sipush 8192
    //   1074: newarray byte
    //   1076: astore 13
    //   1078: aload 19
    //   1080: aload 13
    //   1082: invokevirtual 297	java/io/InputStream:read	([B)I
    //   1085: istore_3
    //   1086: iload_3
    //   1087: iconst_m1
    //   1088: if_icmpeq +390 -> 1478
    //   1091: aload 14
    //   1093: aload 13
    //   1095: iconst_0
    //   1096: iload_3
    //   1097: invokevirtual 301	java/io/FileOutputStream:write	([BII)V
    //   1100: aload_0
    //   1101: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1104: iconst_1
    //   1105: iload_3
    //   1106: i2l
    //   1107: invokestatic 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1110: iconst_0
    //   1111: istore_1
    //   1112: goto -34 -> 1078
    //   1115: astore 12
    //   1117: aload_0
    //   1118: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1121: sipush 128
    //   1124: if_icmpne +12 -> 1136
    //   1127: aload_0
    //   1128: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1131: iconst_0
    //   1132: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1135: return
    //   1136: aload_0
    //   1137: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1140: sipush 640
    //   1143: if_icmpne +12 -> 1155
    //   1146: aload_0
    //   1147: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1150: iconst_0
    //   1151: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1154: return
    //   1155: aload_0
    //   1156: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1159: sipush 383
    //   1162: if_icmpne -771 -> 391
    //   1165: aload_0
    //   1166: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1169: iconst_0
    //   1170: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1173: return
    //   1174: iload 5
    //   1176: iconst_1
    //   1177: iadd
    //   1178: istore 5
    //   1180: goto -220 -> 960
    //   1183: astore 13
    //   1185: iload_3
    //   1186: istore_2
    //   1187: iload_3
    //   1188: istore 4
    //   1190: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1193: ifeq -162 -> 1031
    //   1196: iload_3
    //   1197: istore 4
    //   1199: ldc 154
    //   1201: iconst_2
    //   1202: ldc_w 306
    //   1205: aload 13
    //   1207: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1210: iload_3
    //   1211: istore_2
    //   1212: goto -181 -> 1031
    //   1215: astore 13
    //   1217: iload_1
    //   1218: istore_2
    //   1219: iload 4
    //   1221: istore_1
    //   1222: aload 12
    //   1224: ifnull +8 -> 1232
    //   1227: aload 12
    //   1229: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1232: aload 15
    //   1234: invokevirtual 170	java/io/File:delete	()Z
    //   1237: pop
    //   1238: iload_1
    //   1239: istore_3
    //   1240: iload_2
    //   1241: istore_1
    //   1242: goto -908 -> 334
    //   1245: astore 13
    //   1247: iload_2
    //   1248: istore 4
    //   1250: aload_0
    //   1251: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1254: sipush 128
    //   1257: if_icmpne +31 -> 1288
    //   1260: iload_2
    //   1261: istore 4
    //   1263: aload_0
    //   1264: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1267: iconst_0
    //   1268: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1271: aload 12
    //   1273: ifnull +8 -> 1281
    //   1276: aload 12
    //   1278: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1281: aload 15
    //   1283: invokevirtual 170	java/io/File:delete	()Z
    //   1286: pop
    //   1287: return
    //   1288: iload_2
    //   1289: istore 4
    //   1291: aload_0
    //   1292: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1295: sipush 640
    //   1298: if_icmpne +38 -> 1336
    //   1301: iload_2
    //   1302: istore 4
    //   1304: aload_0
    //   1305: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1308: iconst_0
    //   1309: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1312: goto -41 -> 1271
    //   1315: astore 13
    //   1317: aload 12
    //   1319: ifnull +8 -> 1327
    //   1322: aload 12
    //   1324: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1327: aload 15
    //   1329: invokevirtual 170	java/io/File:delete	()Z
    //   1332: pop
    //   1333: aload 13
    //   1335: athrow
    //   1336: iload_2
    //   1337: istore 4
    //   1339: aload_0
    //   1340: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1343: sipush 383
    //   1346: if_icmpne -75 -> 1271
    //   1349: iload_2
    //   1350: istore 4
    //   1352: aload_0
    //   1353: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1356: iconst_0
    //   1357: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1360: goto -89 -> 1271
    //   1363: astore 13
    //   1365: aload_0
    //   1366: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1369: sipush 128
    //   1372: if_icmpne +38 -> 1410
    //   1375: aload_0
    //   1376: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1379: iconst_0
    //   1380: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1383: aload 19
    //   1385: invokevirtual 315	java/io/InputStream:close	()V
    //   1388: aload 14
    //   1390: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   1393: aload 12
    //   1395: ifnull +8 -> 1403
    //   1398: aload 12
    //   1400: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1403: aload 15
    //   1405: invokevirtual 170	java/io/File:delete	()Z
    //   1408: pop
    //   1409: return
    //   1410: aload_0
    //   1411: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1414: sipush 640
    //   1417: if_icmpne +40 -> 1457
    //   1420: aload_0
    //   1421: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1424: iconst_0
    //   1425: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1428: goto -45 -> 1383
    //   1431: astore 13
    //   1433: aload 19
    //   1435: invokevirtual 315	java/io/InputStream:close	()V
    //   1438: aload 14
    //   1440: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   1443: iload_1
    //   1444: istore_3
    //   1445: aload 13
    //   1447: athrow
    //   1448: astore 13
    //   1450: iload_2
    //   1451: istore_1
    //   1452: iload_3
    //   1453: istore_2
    //   1454: goto -232 -> 1222
    //   1457: aload_0
    //   1458: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1461: sipush 383
    //   1464: if_icmpne -81 -> 1383
    //   1467: aload_0
    //   1468: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1471: iconst_0
    //   1472: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1475: goto -92 -> 1383
    //   1478: aload 19
    //   1480: invokevirtual 315	java/io/InputStream:close	()V
    //   1483: aload 14
    //   1485: invokevirtual 316	java/io/FileOutputStream:close	()V
    //   1488: iload_1
    //   1489: istore_3
    //   1490: new 54	java/io/File
    //   1493: dup
    //   1494: aload 17
    //   1496: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   1499: astore 13
    //   1501: iload_1
    //   1502: istore_3
    //   1503: aload 13
    //   1505: new 54	java/io/File
    //   1508: dup
    //   1509: aload 16
    //   1511: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   1514: invokevirtual 320	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1517: pop
    //   1518: iload_1
    //   1519: istore_3
    //   1520: aload 13
    //   1522: invokevirtual 323	java/io/File:deleteOnExit	()V
    //   1525: iload_1
    //   1526: istore_3
    //   1527: aload_0
    //   1528: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1531: astore 13
    //   1533: iload_1
    //   1534: istore_3
    //   1535: aload 13
    //   1537: monitorenter
    //   1538: aload_0
    //   1539: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1542: sipush 128
    //   1545: if_icmpne +87 -> 1632
    //   1548: aload_0
    //   1549: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1552: iconst_0
    //   1553: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1556: aload_0
    //   1557: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1560: aload_0
    //   1561: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1564: sipush 128
    //   1567: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1570: pop
    //   1571: aload_0
    //   1572: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1575: lconst_0
    //   1576: putfield 329	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   1579: aload_0
    //   1580: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1583: getfield 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Ljava/util/Map;
    //   1586: aload_0
    //   1587: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1590: getfield 336	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1593: invokeinterface 341 2 0
    //   1598: ifeq +14 -> 1612
    //   1601: aload_0
    //   1602: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1605: aload_0
    //   1606: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1609: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1612: aload 13
    //   1614: monitorexit
    //   1615: aload 12
    //   1617: ifnull +8 -> 1625
    //   1620: aload 12
    //   1622: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1625: aload 15
    //   1627: invokevirtual 170	java/io/File:delete	()Z
    //   1630: pop
    //   1631: return
    //   1632: aload_0
    //   1633: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1636: sipush 640
    //   1639: if_icmpne +39 -> 1678
    //   1642: aload_0
    //   1643: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1646: iconst_0
    //   1647: putfield 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1650: aload_0
    //   1651: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1654: aload_0
    //   1655: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1658: sipush 640
    //   1661: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1664: pop
    //   1665: goto -94 -> 1571
    //   1668: astore 14
    //   1670: aload 13
    //   1672: monitorexit
    //   1673: iload_1
    //   1674: istore_3
    //   1675: aload 14
    //   1677: athrow
    //   1678: aload_0
    //   1679: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1682: sipush 383
    //   1685: if_icmpne -114 -> 1571
    //   1688: aload_0
    //   1689: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1692: iconst_0
    //   1693: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1696: aload_0
    //   1697: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1700: aload_0
    //   1701: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1704: sipush 383
    //   1707: invokevirtual 326	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1710: istore 11
    //   1712: aload_0
    //   1713: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1716: astore 14
    //   1718: iload 11
    //   1720: ifne +92 -> 1812
    //   1723: iconst_1
    //   1724: istore 10
    //   1726: aload 14
    //   1728: iload 10
    //   1730: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1733: iload 6
    //   1735: iconst_2
    //   1736: if_icmpne -165 -> 1571
    //   1739: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1742: ifeq +45 -> 1787
    //   1745: ldc 154
    //   1747: iconst_2
    //   1748: new 85	java/lang/StringBuilder
    //   1751: dup
    //   1752: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1755: ldc 156
    //   1757: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: aload_0
    //   1761: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1764: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1767: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: ldc_w 343
    //   1773: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: iload 11
    //   1778: invokevirtual 346	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1787: aload_0
    //   1788: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1791: getfield 348	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   1794: ifne -223 -> 1571
    //   1797: iload_2
    //   1798: ifeq -227 -> 1571
    //   1801: aload_0
    //   1802: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1805: iload_2
    //   1806: putfield 348	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   1809: goto -238 -> 1571
    //   1812: iconst_0
    //   1813: istore 10
    //   1815: goto -89 -> 1726
    //   1818: iload_2
    //   1819: istore 4
    //   1821: aload_0
    //   1822: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1825: sipush 383
    //   1828: if_icmpne +64 -> 1892
    //   1831: iload_2
    //   1832: istore 4
    //   1834: aload_0
    //   1835: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1838: iconst_1
    //   1839: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1842: iload_2
    //   1843: istore 4
    //   1845: aload_0
    //   1846: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1849: iconst_0
    //   1850: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1853: iload_2
    //   1854: istore 4
    //   1856: aload_0
    //   1857: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1860: getfield 332	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Ljava/util/Map;
    //   1863: aload_0
    //   1864: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1867: getfield 336	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1870: invokeinterface 341 2 0
    //   1875: ifeq +17 -> 1892
    //   1878: iload_2
    //   1879: istore 4
    //   1881: aload_0
    //   1882: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1885: aload_0
    //   1886: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1889: invokevirtual 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1892: aload 12
    //   1894: ifnull +8 -> 1902
    //   1897: aload 12
    //   1899: invokevirtual 312	java/net/HttpURLConnection:disconnect	()V
    //   1902: aload 15
    //   1904: invokevirtual 170	java/io/File:delete	()Z
    //   1907: pop
    //   1908: iload_1
    //   1909: istore_3
    //   1910: iload_2
    //   1911: istore_1
    //   1912: iload_3
    //   1913: istore_2
    //   1914: goto -676 -> 1238
    //   1917: astore 13
    //   1919: goto -531 -> 1388
    //   1922: astore 13
    //   1924: goto -531 -> 1393
    //   1927: astore 13
    //   1929: goto -446 -> 1483
    //   1932: astore 13
    //   1934: goto -446 -> 1488
    //   1937: astore 19
    //   1939: goto -501 -> 1438
    //   1942: astore 14
    //   1944: goto -501 -> 1443
    //   1947: astore 13
    //   1949: aload 14
    //   1951: astore 12
    //   1953: goto -636 -> 1317
    //   1956: astore 12
    //   1958: iload_1
    //   1959: istore_2
    //   1960: aconst_null
    //   1961: astore 12
    //   1963: iload_3
    //   1964: istore_1
    //   1965: goto -743 -> 1222
    //   1968: astore 13
    //   1970: goto -537 -> 1433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1973	0	this	TaskHttpDownloadThumbnail
    //   159	1806	1	i	int
    //   161	1799	2	j	int
    //   331	1633	3	k	int
    //   713	1167	4	m	int
    //   958	221	5	n	int
    //   95	1642	6	i1	int
    //   800	245	7	i2	int
    //   340	3	8	l	long
    //   1724	90	10	bool1	boolean
    //   1710	67	11	bool2	boolean
    //   24	300	12	localObject1	java.lang.Object
    //   392	24	12	localNumberFormatException	java.lang.NumberFormatException
    //   513	1	12	str1	String
    //   518	1	12	localMalformedURLException	java.net.MalformedURLException
    //   577	1	12	localInterruptedException	java.lang.InterruptedException
    //   710	341	12	localHttpURLConnection	java.net.HttpURLConnection
    //   1115	783	12	localIOException1	java.io.IOException
    //   1951	1	12	localObject2	java.lang.Object
    //   1956	1	12	localIOException2	java.io.IOException
    //   1961	1	12	localObject3	java.lang.Object
    //   262	832	13	localObject4	java.lang.Object
    //   1183	23	13	localException	java.lang.Exception
    //   1215	1	13	localIOException3	java.io.IOException
    //   1245	1	13	localFileNotFoundException	java.io.FileNotFoundException
    //   1315	19	13	localObject5	java.lang.Object
    //   1363	1	13	localIOException4	java.io.IOException
    //   1431	15	13	localObject6	java.lang.Object
    //   1448	1	13	localIOException5	java.io.IOException
    //   1499	172	13	localObject7	java.lang.Object
    //   1917	1	13	localIOException6	java.io.IOException
    //   1922	1	13	localIOException7	java.io.IOException
    //   1927	1	13	localIOException8	java.io.IOException
    //   1932	1	13	localIOException9	java.io.IOException
    //   1947	1	13	localObject8	java.lang.Object
    //   1968	1	13	localObject9	java.lang.Object
    //   700	784	14	localObject10	java.lang.Object
    //   1668	8	14	localObject11	java.lang.Object
    //   1716	11	14	localItem	TroopFileTransferManager.Item
    //   1942	8	14	localIOException10	java.io.IOException
    //   356	1547	15	localFile	java.io.File
    //   58	1452	16	str2	String
    //   80	1415	17	str3	String
    //   328	375	18	localURL	java.net.URL
    //   1055	424	19	localInputStream	java.io.InputStream
    //   1937	1	19	localIOException11	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   149	160	392	java/lang/NumberFormatException
    //   319	330	518	java/net/MalformedURLException
    //   342	347	577	java/lang/InterruptedException
    //   693	699	1115	java/io/IOException
    //   899	907	1183	java/lang/Exception
    //   912	923	1183	java/lang/Exception
    //   926	939	1183	java/lang/Exception
    //   951	957	1183	java/lang/Exception
    //   965	973	1183	java/lang/Exception
    //   976	989	1183	java/lang/Exception
    //   997	1004	1183	java/lang/Exception
    //   1007	1020	1183	java/lang/Exception
    //   1023	1031	1183	java/lang/Exception
    //   715	723	1215	java/io/IOException
    //   726	733	1215	java/io/IOException
    //   736	745	1215	java/io/IOException
    //   748	757	1215	java/io/IOException
    //   760	792	1215	java/io/IOException
    //   795	802	1215	java/io/IOException
    //   813	822	1215	java/io/IOException
    //   825	831	1215	java/io/IOException
    //   834	894	1215	java/io/IOException
    //   899	907	1215	java/io/IOException
    //   912	923	1215	java/io/IOException
    //   926	939	1215	java/io/IOException
    //   951	957	1215	java/io/IOException
    //   965	973	1215	java/io/IOException
    //   976	989	1215	java/io/IOException
    //   997	1004	1215	java/io/IOException
    //   1007	1020	1215	java/io/IOException
    //   1023	1031	1215	java/io/IOException
    //   1050	1057	1215	java/io/IOException
    //   1060	1071	1215	java/io/IOException
    //   1190	1196	1215	java/io/IOException
    //   1199	1210	1215	java/io/IOException
    //   1250	1260	1215	java/io/IOException
    //   1263	1271	1215	java/io/IOException
    //   1291	1301	1215	java/io/IOException
    //   1304	1312	1215	java/io/IOException
    //   1339	1349	1215	java/io/IOException
    //   1352	1360	1215	java/io/IOException
    //   1821	1831	1215	java/io/IOException
    //   1834	1842	1215	java/io/IOException
    //   1845	1853	1215	java/io/IOException
    //   1856	1878	1215	java/io/IOException
    //   1881	1892	1215	java/io/IOException
    //   1060	1071	1245	java/io/FileNotFoundException
    //   715	723	1315	finally
    //   726	733	1315	finally
    //   736	745	1315	finally
    //   748	757	1315	finally
    //   760	792	1315	finally
    //   795	802	1315	finally
    //   813	822	1315	finally
    //   825	831	1315	finally
    //   834	894	1315	finally
    //   899	907	1315	finally
    //   912	923	1315	finally
    //   926	939	1315	finally
    //   951	957	1315	finally
    //   965	973	1315	finally
    //   976	989	1315	finally
    //   997	1004	1315	finally
    //   1007	1020	1315	finally
    //   1023	1031	1315	finally
    //   1050	1057	1315	finally
    //   1060	1071	1315	finally
    //   1190	1196	1315	finally
    //   1199	1210	1315	finally
    //   1250	1260	1315	finally
    //   1263	1271	1315	finally
    //   1291	1301	1315	finally
    //   1304	1312	1315	finally
    //   1339	1349	1315	finally
    //   1352	1360	1315	finally
    //   1383	1388	1315	finally
    //   1388	1393	1315	finally
    //   1433	1438	1315	finally
    //   1438	1443	1315	finally
    //   1445	1448	1315	finally
    //   1478	1483	1315	finally
    //   1483	1488	1315	finally
    //   1490	1501	1315	finally
    //   1503	1518	1315	finally
    //   1520	1525	1315	finally
    //   1527	1533	1315	finally
    //   1535	1538	1315	finally
    //   1675	1678	1315	finally
    //   1821	1831	1315	finally
    //   1834	1842	1315	finally
    //   1845	1853	1315	finally
    //   1856	1878	1315	finally
    //   1881	1892	1315	finally
    //   1091	1110	1363	java/io/IOException
    //   1078	1086	1431	finally
    //   1091	1110	1431	finally
    //   1365	1383	1431	finally
    //   1410	1428	1431	finally
    //   1457	1475	1431	finally
    //   1445	1448	1448	java/io/IOException
    //   1490	1501	1448	java/io/IOException
    //   1503	1518	1448	java/io/IOException
    //   1520	1525	1448	java/io/IOException
    //   1527	1533	1448	java/io/IOException
    //   1535	1538	1448	java/io/IOException
    //   1675	1678	1448	java/io/IOException
    //   1538	1571	1668	finally
    //   1571	1612	1668	finally
    //   1612	1615	1668	finally
    //   1632	1665	1668	finally
    //   1670	1673	1668	finally
    //   1678	1718	1668	finally
    //   1726	1733	1668	finally
    //   1739	1787	1668	finally
    //   1787	1797	1668	finally
    //   1801	1809	1668	finally
    //   1383	1388	1917	java/io/IOException
    //   1388	1393	1922	java/io/IOException
    //   1478	1483	1927	java/io/IOException
    //   1483	1488	1932	java/io/IOException
    //   1433	1438	1937	java/io/IOException
    //   1438	1443	1942	java/io/IOException
    //   702	712	1947	finally
    //   702	712	1956	java/io/IOException
    //   1071	1078	1968	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail
 * JD-Core Version:    0.7.0.1
 */