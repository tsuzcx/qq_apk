package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownloadThumbnail
  extends TroopFileTransferManager.Task
{
  public String a;
  public int b = 0;
  
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
    //   24: astore 13
    //   26: aload 13
    //   28: invokevirtual 65	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 13
    //   36: invokevirtual 68	java/io/File:mkdir	()Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: aload_0
    //   45: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   48: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   51: aload_0
    //   52: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   55: invokevirtual 83	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   58: astore 15
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   67: astore 13
    //   69: aload 13
    //   71: aload 15
    //   73: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 13
    //   79: ldc 93
    //   81: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 13
    //   87: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 16
    //   92: aload_0
    //   93: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   96: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   99: invokestatic 105	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokestatic 110	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   105: istore 7
    //   107: iload 7
    //   109: iconst_2
    //   110: if_icmpne +343 -> 453
    //   113: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +59 -> 175
    //   119: new 85	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   126: astore 13
    //   128: aload 13
    //   130: ldc 115
    //   132: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 13
    //   138: aload_0
    //   139: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 13
    //   148: ldc 117
    //   150: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 13
    //   156: aload_0
    //   157: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   160: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: ldc 46
    //   166: iconst_2
    //   167: aload 13
    //   169: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_0
    //   176: getfield 23	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokestatic 129	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   182: invokevirtual 133	java/lang/Integer:intValue	()I
    //   185: istore_1
    //   186: goto +52 -> 238
    //   189: astore 13
    //   191: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +42 -> 236
    //   197: new 85	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   204: astore 14
    //   206: aload 14
    //   208: ldc 135
    //   210: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 14
    //   216: aload 13
    //   218: invokevirtual 136	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   221: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 46
    //   227: iconst_2
    //   228: aload 14
    //   230: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: iconst_0
    //   237: istore_1
    //   238: iload_1
    //   239: istore_2
    //   240: iload_1
    //   241: ifgt +7 -> 248
    //   244: sipush 443
    //   247: istore_2
    //   248: aload_0
    //   249: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   252: ifgt +10 -> 262
    //   255: aload_0
    //   256: sipush 383
    //   259: putfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   262: new 85	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   269: astore 13
    //   271: aload 13
    //   273: ldc 140
    //   275: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 13
    //   281: aload_0
    //   282: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   285: getfield 143	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   288: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 13
    //   294: ldc 145
    //   296: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 13
    //   302: iload_2
    //   303: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 13
    //   309: ldc 147
    //   311: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 13
    //   317: aload_0
    //   318: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   321: getfield 150	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   324: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 13
    //   330: ldc 152
    //   332: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 13
    //   338: aload_0
    //   339: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   342: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 13
    //   348: ldc 154
    //   350: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 13
    //   356: aload_0
    //   357: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   360: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 13
    //   366: ldc 156
    //   368: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 13
    //   374: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore 14
    //   379: aload 14
    //   381: astore 13
    //   383: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +182 -> 568
    //   389: new 85	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   396: astore 13
    //   398: aload 13
    //   400: ldc 158
    //   402: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 13
    //   408: aload_0
    //   409: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   412: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   415: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 13
    //   421: ldc 160
    //   423: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 13
    //   429: aload 14
    //   431: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc 162
    //   437: iconst_2
    //   438: aload 13
    //   440: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload 14
    //   448: astore 13
    //   450: goto +118 -> 568
    //   453: new 85	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   460: astore 13
    //   462: aload 13
    //   464: ldc 140
    //   466: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 13
    //   472: aload_0
    //   473: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   476: getfield 143	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   479: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 13
    //   485: ldc 164
    //   487: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 13
    //   493: aload_0
    //   494: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   497: getfield 150	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   500: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 13
    //   506: ldc 166
    //   508: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 13
    //   514: aload_0
    //   515: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   518: getfield 169	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   521: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 13
    //   527: ldc 171
    //   529: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 13
    //   535: aload_0
    //   536: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   539: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 13
    //   545: ldc 154
    //   547: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 13
    //   553: aload_0
    //   554: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   557: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload 13
    //   563: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: astore 13
    //   568: new 173	java/net/URL
    //   571: dup
    //   572: aload 13
    //   574: invokespecial 174	java/net/URL:<init>	(Ljava/lang/String;)V
    //   577: astore 14
    //   579: iconst_0
    //   580: istore_1
    //   581: iconst_0
    //   582: istore_2
    //   583: iload_1
    //   584: sipush 1000
    //   587: imul
    //   588: i2l
    //   589: lstore 9
    //   591: lload 9
    //   593: invokestatic 180	java/lang/Thread:sleep	(J)V
    //   596: new 54	java/io/File
    //   599: dup
    //   600: aload 16
    //   602: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   605: astore 17
    //   607: aload 17
    //   609: invokevirtual 183	java/io/File:delete	()Z
    //   612: pop
    //   613: iload_1
    //   614: iconst_1
    //   615: iadd
    //   616: istore_1
    //   617: iload_1
    //   618: iconst_3
    //   619: if_icmple +75 -> 694
    //   622: aload_0
    //   623: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   626: istore_1
    //   627: iload_1
    //   628: sipush 128
    //   631: if_icmpne +12 -> 643
    //   634: aload_0
    //   635: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   638: iconst_0
    //   639: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   642: return
    //   643: iload_1
    //   644: sipush 640
    //   647: if_icmpne +12 -> 659
    //   650: aload_0
    //   651: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   654: iconst_0
    //   655: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   658: return
    //   659: iload_1
    //   660: sipush 383
    //   663: if_icmpne +30 -> 693
    //   666: aload_0
    //   667: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   670: iconst_0
    //   671: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   674: aload_0
    //   675: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   678: iconst_1
    //   679: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   682: aload_0
    //   683: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   686: aload_0
    //   687: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   690: invokevirtual 199	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   693: return
    //   694: aload 17
    //   696: invokevirtual 202	java/io/File:createNewFile	()Z
    //   699: pop
    //   700: aload 14
    //   702: invokevirtual 206	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   705: checkcast 208	java/net/HttpURLConnection
    //   708: astore 13
    //   710: iload_2
    //   711: istore 5
    //   713: iload_1
    //   714: istore 4
    //   716: aload 13
    //   718: sipush 30000
    //   721: invokevirtual 212	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   724: iload_2
    //   725: istore 5
    //   727: iload_1
    //   728: istore 4
    //   730: aload 13
    //   732: ldc 214
    //   734: invokevirtual 217	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   737: iload_2
    //   738: istore 5
    //   740: iload_1
    //   741: istore 4
    //   743: aload 13
    //   745: ldc 219
    //   747: ldc 221
    //   749: invokevirtual 225	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   752: iload_2
    //   753: istore 5
    //   755: iload_1
    //   756: istore 4
    //   758: aload 13
    //   760: ldc 227
    //   762: ldc 229
    //   764: invokevirtual 225	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   767: iload_2
    //   768: istore 5
    //   770: iload_1
    //   771: istore 4
    //   773: new 85	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   780: astore 18
    //   782: iload_2
    //   783: istore 5
    //   785: iload_1
    //   786: istore 4
    //   788: aload 18
    //   790: ldc 231
    //   792: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: iload_2
    //   797: istore 5
    //   799: iload_1
    //   800: istore 4
    //   802: aload 18
    //   804: aload_0
    //   805: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   808: getfield 234	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   811: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: iload_2
    //   816: istore 5
    //   818: iload_1
    //   819: istore 4
    //   821: aload 13
    //   823: ldc 236
    //   825: aload 18
    //   827: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokevirtual 225	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: iload_2
    //   834: istore 5
    //   836: iload_1
    //   837: istore 4
    //   839: aload 13
    //   841: invokevirtual 239	java/net/HttpURLConnection:getResponseCode	()I
    //   844: istore 8
    //   846: iload_2
    //   847: istore_3
    //   848: iload 7
    //   850: iconst_2
    //   851: if_icmpne +1490 -> 2341
    //   854: iload_2
    //   855: istore 5
    //   857: iload_1
    //   858: istore 4
    //   860: aload 13
    //   862: ldc 241
    //   864: invokevirtual 244	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   867: astore 18
    //   869: iload_2
    //   870: istore 5
    //   872: iload_1
    //   873: istore 4
    //   875: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   878: ifeq +151 -> 1029
    //   881: iload_2
    //   882: istore 5
    //   884: iload_1
    //   885: istore 4
    //   887: new 85	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   894: astore 19
    //   896: iload_2
    //   897: istore 5
    //   899: iload_1
    //   900: istore 4
    //   902: aload 19
    //   904: ldc 158
    //   906: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: iload_2
    //   911: istore 5
    //   913: iload_1
    //   914: istore 4
    //   916: aload 19
    //   918: aload_0
    //   919: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   922: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   925: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: iload_2
    //   930: istore 5
    //   932: iload_1
    //   933: istore 4
    //   935: aload 19
    //   937: ldc 246
    //   939: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: iload_2
    //   944: istore 5
    //   946: iload_1
    //   947: istore 4
    //   949: aload 19
    //   951: iload 8
    //   953: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: iload_2
    //   958: istore 5
    //   960: iload_1
    //   961: istore 4
    //   963: aload 19
    //   965: ldc 248
    //   967: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: iload_2
    //   972: istore 5
    //   974: iload_1
    //   975: istore 4
    //   977: aload 19
    //   979: aload 18
    //   981: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: iload_2
    //   986: istore 5
    //   988: iload_1
    //   989: istore 4
    //   991: aload 19
    //   993: ldc 250
    //   995: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: iload_2
    //   1000: istore 5
    //   1002: iload_1
    //   1003: istore 4
    //   1005: aload 19
    //   1007: iload_1
    //   1008: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: iload_2
    //   1013: istore 5
    //   1015: iload_1
    //   1016: istore 4
    //   1018: ldc 162
    //   1020: iconst_2
    //   1021: aload 19
    //   1023: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1029: iload_2
    //   1030: istore 5
    //   1032: iload_1
    //   1033: istore 4
    //   1035: iload_2
    //   1036: istore_3
    //   1037: aload 18
    //   1039: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1042: ifne +1299 -> 2341
    //   1045: iload_2
    //   1046: istore 5
    //   1048: iload_1
    //   1049: istore 4
    //   1051: iload_2
    //   1052: istore_3
    //   1053: aload 18
    //   1055: ldc_w 258
    //   1058: invokevirtual 263	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1061: ifeq +1280 -> 2341
    //   1064: iload_2
    //   1065: istore 5
    //   1067: iload_1
    //   1068: istore 4
    //   1070: aload 18
    //   1072: invokevirtual 266	java/lang/String:trim	()Ljava/lang/String;
    //   1075: ldc_w 268
    //   1078: invokevirtual 272	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1081: astore 18
    //   1083: iload_2
    //   1084: istore_3
    //   1085: aload 18
    //   1087: ifnull +1254 -> 2341
    //   1090: iload_2
    //   1091: istore 5
    //   1093: iload_1
    //   1094: istore 4
    //   1096: iload_2
    //   1097: istore_3
    //   1098: aload 18
    //   1100: arraylength
    //   1101: ifle +1240 -> 2341
    //   1104: iconst_0
    //   1105: istore 6
    //   1107: iload_2
    //   1108: istore 5
    //   1110: iload_1
    //   1111: istore 4
    //   1113: iload_2
    //   1114: istore_3
    //   1115: iload 6
    //   1117: aload 18
    //   1119: arraylength
    //   1120: if_icmpge +1221 -> 2341
    //   1123: iload_2
    //   1124: istore 5
    //   1126: iload_1
    //   1127: istore 4
    //   1129: aload 18
    //   1131: iload 6
    //   1133: aaload
    //   1134: ldc_w 274
    //   1137: invokevirtual 272	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1140: astore 19
    //   1142: aload 19
    //   1144: ifnull +52 -> 1196
    //   1147: iload_2
    //   1148: istore 5
    //   1150: iload_1
    //   1151: istore 4
    //   1153: aload 19
    //   1155: arraylength
    //   1156: iconst_2
    //   1157: if_icmpne +39 -> 1196
    //   1160: iload_2
    //   1161: istore 5
    //   1163: iload_1
    //   1164: istore 4
    //   1166: ldc_w 258
    //   1169: aload 19
    //   1171: iconst_0
    //   1172: aaload
    //   1173: invokevirtual 278	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1176: ifeq +20 -> 1196
    //   1179: iload_2
    //   1180: istore 5
    //   1182: iload_1
    //   1183: istore 4
    //   1185: aload 19
    //   1187: iconst_1
    //   1188: aaload
    //   1189: invokestatic 281	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1192: istore_3
    //   1193: goto +1148 -> 2341
    //   1196: iload 6
    //   1198: iconst_1
    //   1199: iadd
    //   1200: istore 6
    //   1202: goto -95 -> 1107
    //   1205: astore 18
    //   1207: iload_2
    //   1208: istore 5
    //   1210: iload_1
    //   1211: istore 4
    //   1213: iload_2
    //   1214: istore_3
    //   1215: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1218: ifeq +1123 -> 2341
    //   1221: iload_2
    //   1222: istore 5
    //   1224: iload_1
    //   1225: istore 4
    //   1227: ldc 162
    //   1229: iconst_2
    //   1230: ldc_w 283
    //   1233: aload 18
    //   1235: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1238: iload_2
    //   1239: istore_3
    //   1240: goto +1101 -> 2341
    //   1243: iload_3
    //   1244: istore 5
    //   1246: iload_1
    //   1247: istore 4
    //   1249: aload_0
    //   1250: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1253: sipush 383
    //   1256: if_icmpne +1104 -> 2360
    //   1259: iload_3
    //   1260: istore 5
    //   1262: iload_1
    //   1263: istore 4
    //   1265: aload_0
    //   1266: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1269: iconst_1
    //   1270: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1273: iload_3
    //   1274: istore 5
    //   1276: iload_1
    //   1277: istore 4
    //   1279: aload_0
    //   1280: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1283: iconst_0
    //   1284: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1287: iload_3
    //   1288: istore 5
    //   1290: iload_1
    //   1291: istore 4
    //   1293: aload_0
    //   1294: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1297: getfield 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Ljava/util/Map;
    //   1300: aload_0
    //   1301: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1304: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1307: invokeinterface 298 2 0
    //   1312: ifeq +1048 -> 2360
    //   1315: iload_3
    //   1316: istore 5
    //   1318: iload_1
    //   1319: istore 4
    //   1321: aload_0
    //   1322: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1325: aload_0
    //   1326: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1329: invokevirtual 199	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1332: goto +1028 -> 2360
    //   1335: iload_3
    //   1336: istore 5
    //   1338: iload_1
    //   1339: istore 4
    //   1341: aload 13
    //   1343: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1346: astore 19
    //   1348: iload_3
    //   1349: istore 5
    //   1351: iload_1
    //   1352: istore 4
    //   1354: new 304	java/io/FileOutputStream
    //   1357: dup
    //   1358: aload 17
    //   1360: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1363: astore 18
    //   1365: iload_1
    //   1366: istore 4
    //   1368: sipush 8192
    //   1371: newarray byte
    //   1373: astore 20
    //   1375: iload_1
    //   1376: istore 4
    //   1378: aload 19
    //   1380: aload 20
    //   1382: invokevirtual 313	java/io/InputStream:read	([B)I
    //   1385: istore_2
    //   1386: iload_2
    //   1387: iconst_m1
    //   1388: if_icmpeq +138 -> 1526
    //   1391: iload_1
    //   1392: istore 4
    //   1394: aload 18
    //   1396: aload 20
    //   1398: iconst_0
    //   1399: iload_2
    //   1400: invokevirtual 317	java/io/FileOutputStream:write	([BII)V
    //   1403: iload_1
    //   1404: istore 4
    //   1406: aload_0
    //   1407: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1410: iconst_1
    //   1411: iload_2
    //   1412: i2l
    //   1413: invokestatic 320	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
    //   1416: iconst_0
    //   1417: istore_1
    //   1418: goto -43 -> 1375
    //   1421: iload_1
    //   1422: istore 4
    //   1424: aload_0
    //   1425: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1428: sipush 128
    //   1431: if_icmpne +17 -> 1448
    //   1434: iload_1
    //   1435: istore 4
    //   1437: aload_0
    //   1438: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1441: iconst_0
    //   1442: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1445: goto +54 -> 1499
    //   1448: iload_1
    //   1449: istore 4
    //   1451: aload_0
    //   1452: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1455: sipush 640
    //   1458: if_icmpne +17 -> 1475
    //   1461: iload_1
    //   1462: istore 4
    //   1464: aload_0
    //   1465: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1468: iconst_0
    //   1469: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1472: goto +27 -> 1499
    //   1475: iload_1
    //   1476: istore 4
    //   1478: aload_0
    //   1479: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1482: sipush 383
    //   1485: if_icmpne +14 -> 1499
    //   1488: iload_1
    //   1489: istore 4
    //   1491: aload_0
    //   1492: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1495: iconst_0
    //   1496: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1499: aload 19
    //   1501: invokevirtual 323	java/io/InputStream:close	()V
    //   1504: aload 18
    //   1506: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   1509: aload 13
    //   1511: ifnull +8 -> 1519
    //   1514: aload 13
    //   1516: invokevirtual 327	java/net/HttpURLConnection:disconnect	()V
    //   1519: aload 17
    //   1521: invokevirtual 183	java/io/File:delete	()Z
    //   1524: pop
    //   1525: return
    //   1526: iconst_1
    //   1527: istore 11
    //   1529: aload 19
    //   1531: invokevirtual 323	java/io/InputStream:close	()V
    //   1534: aload 18
    //   1536: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   1539: iload_3
    //   1540: istore 5
    //   1542: iload_1
    //   1543: istore 4
    //   1545: new 54	java/io/File
    //   1548: dup
    //   1549: aload 16
    //   1551: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   1554: astore 18
    //   1556: iload_3
    //   1557: istore 5
    //   1559: iload_1
    //   1560: istore 4
    //   1562: aload 18
    //   1564: new 54	java/io/File
    //   1567: dup
    //   1568: aload 15
    //   1570: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   1573: invokevirtual 331	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1576: pop
    //   1577: iload_3
    //   1578: istore 5
    //   1580: iload_1
    //   1581: istore 4
    //   1583: aload 18
    //   1585: invokevirtual 334	java/io/File:deleteOnExit	()V
    //   1588: iload_3
    //   1589: istore 5
    //   1591: iload_1
    //   1592: istore 4
    //   1594: aload_0
    //   1595: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1598: astore 18
    //   1600: iload_3
    //   1601: istore 5
    //   1603: iload_1
    //   1604: istore 4
    //   1606: aload 18
    //   1608: monitorenter
    //   1609: aload_0
    //   1610: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1613: sipush 128
    //   1616: if_icmpne +29 -> 1645
    //   1619: aload_0
    //   1620: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1623: iconst_0
    //   1624: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1627: aload_0
    //   1628: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1631: aload_0
    //   1632: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1635: sipush 128
    //   1638: invokevirtual 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1641: pop
    //   1642: goto +744 -> 2386
    //   1645: aload_0
    //   1646: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1649: sipush 640
    //   1652: if_icmpne +29 -> 1681
    //   1655: aload_0
    //   1656: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1659: iconst_0
    //   1660: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1663: aload_0
    //   1664: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1667: aload_0
    //   1668: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1671: sipush 640
    //   1674: invokevirtual 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1677: pop
    //   1678: goto +708 -> 2386
    //   1681: aload_0
    //   1682: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1685: sipush 383
    //   1688: if_icmpne +698 -> 2386
    //   1691: aload_0
    //   1692: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1695: iconst_0
    //   1696: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   1699: aload_0
    //   1700: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1703: aload_0
    //   1704: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1707: sipush 383
    //   1710: invokevirtual 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   1713: istore 12
    //   1715: aload_0
    //   1716: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1719: astore 19
    //   1721: iload 12
    //   1723: ifne +654 -> 2377
    //   1726: goto +3 -> 1729
    //   1729: aload 19
    //   1731: iload 11
    //   1733: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
    //   1736: iload 7
    //   1738: iconst_2
    //   1739: if_icmpne +647 -> 2386
    //   1742: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1745: ifeq +638 -> 2383
    //   1748: new 85	java/lang/StringBuilder
    //   1751: dup
    //   1752: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1755: astore 19
    //   1757: aload 19
    //   1759: ldc 158
    //   1761: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload 19
    //   1767: aload_0
    //   1768: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1771: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1774: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: pop
    //   1778: aload 19
    //   1780: ldc_w 339
    //   1783: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1786: pop
    //   1787: aload 19
    //   1789: iload 12
    //   1791: invokevirtual 342	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1794: pop
    //   1795: ldc 162
    //   1797: iconst_2
    //   1798: aload 19
    //   1800: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1806: goto +3 -> 1809
    //   1809: aload_0
    //   1810: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1813: getfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   1816: ifne +18 -> 1834
    //   1819: iload_3
    //   1820: ifeq +14 -> 1834
    //   1823: aload_0
    //   1824: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1827: iload_3
    //   1828: putfield 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   1831: goto +3 -> 1834
    //   1834: aload_0
    //   1835: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1838: lconst_0
    //   1839: putfield 347	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   1842: aload_0
    //   1843: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1846: getfield 289	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Ljava/util/Map;
    //   1849: aload_0
    //   1850: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1853: getfield 293	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1856: invokeinterface 298 2 0
    //   1861: ifeq +14 -> 1875
    //   1864: aload_0
    //   1865: getfield 14	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1868: aload_0
    //   1869: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1872: invokevirtual 199	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1875: aload 18
    //   1877: monitorexit
    //   1878: aload 13
    //   1880: ifnull +8 -> 1888
    //   1883: aload 13
    //   1885: invokevirtual 327	java/net/HttpURLConnection:disconnect	()V
    //   1888: aload 17
    //   1890: invokevirtual 183	java/io/File:delete	()Z
    //   1893: pop
    //   1894: return
    //   1895: astore 19
    //   1897: aload 18
    //   1899: monitorexit
    //   1900: iload_3
    //   1901: istore 5
    //   1903: iload_1
    //   1904: istore 4
    //   1906: aload 19
    //   1908: athrow
    //   1909: astore 20
    //   1911: aload 19
    //   1913: invokevirtual 323	java/io/InputStream:close	()V
    //   1916: aload 18
    //   1918: invokevirtual 324	java/io/FileOutputStream:close	()V
    //   1921: iload_3
    //   1922: istore 5
    //   1924: aload 20
    //   1926: athrow
    //   1927: iload_3
    //   1928: istore 5
    //   1930: iload_1
    //   1931: istore 4
    //   1933: aload_0
    //   1934: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1937: sipush 128
    //   1940: if_icmpne +20 -> 1960
    //   1943: iload_3
    //   1944: istore 5
    //   1946: iload_1
    //   1947: istore 4
    //   1949: aload_0
    //   1950: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1953: iconst_0
    //   1954: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   1957: goto +66 -> 2023
    //   1960: iload_3
    //   1961: istore 5
    //   1963: iload_1
    //   1964: istore 4
    //   1966: aload_0
    //   1967: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   1970: sipush 640
    //   1973: if_icmpne +20 -> 1993
    //   1976: iload_3
    //   1977: istore 5
    //   1979: iload_1
    //   1980: istore 4
    //   1982: aload_0
    //   1983: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1986: iconst_0
    //   1987: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   1990: goto +33 -> 2023
    //   1993: iload_3
    //   1994: istore 5
    //   1996: iload_1
    //   1997: istore 4
    //   1999: aload_0
    //   2000: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   2003: sipush 383
    //   2006: if_icmpne +17 -> 2023
    //   2009: iload_3
    //   2010: istore 5
    //   2012: iload_1
    //   2013: istore 4
    //   2015: aload_0
    //   2016: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2019: iconst_0
    //   2020: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   2023: aload 13
    //   2025: ifnull +8 -> 2033
    //   2028: aload 13
    //   2030: invokevirtual 327	java/net/HttpURLConnection:disconnect	()V
    //   2033: aload 17
    //   2035: invokevirtual 183	java/io/File:delete	()Z
    //   2038: pop
    //   2039: return
    //   2040: astore 14
    //   2042: goto +17 -> 2059
    //   2045: iload 5
    //   2047: istore_1
    //   2048: iload 4
    //   2050: istore_3
    //   2051: goto +34 -> 2085
    //   2054: astore 14
    //   2056: aconst_null
    //   2057: astore 13
    //   2059: aload 13
    //   2061: ifnull +8 -> 2069
    //   2064: aload 13
    //   2066: invokevirtual 327	java/net/HttpURLConnection:disconnect	()V
    //   2069: aload 17
    //   2071: invokevirtual 183	java/io/File:delete	()Z
    //   2074: pop
    //   2075: aload 14
    //   2077: athrow
    //   2078: aconst_null
    //   2079: astore 13
    //   2081: iload_1
    //   2082: istore_3
    //   2083: iload_2
    //   2084: istore_1
    //   2085: iload_1
    //   2086: istore_2
    //   2087: iload_3
    //   2088: istore 4
    //   2090: aload 13
    //   2092: ifnull +13 -> 2105
    //   2095: iload_1
    //   2096: istore_2
    //   2097: aload 13
    //   2099: invokevirtual 327	java/net/HttpURLConnection:disconnect	()V
    //   2102: iload_3
    //   2103: istore 4
    //   2105: aload 17
    //   2107: invokevirtual 183	java/io/File:delete	()Z
    //   2110: pop
    //   2111: iload 4
    //   2113: istore_1
    //   2114: goto -1531 -> 583
    //   2117: aload_0
    //   2118: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   2121: istore_1
    //   2122: iload_1
    //   2123: sipush 128
    //   2126: if_icmpne +12 -> 2138
    //   2129: aload_0
    //   2130: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2133: iconst_0
    //   2134: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   2137: return
    //   2138: iload_1
    //   2139: sipush 640
    //   2142: if_icmpne +12 -> 2154
    //   2145: aload_0
    //   2146: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2149: iconst_0
    //   2150: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   2153: return
    //   2154: iload_1
    //   2155: sipush 383
    //   2158: if_icmpne +11 -> 2169
    //   2161: aload_0
    //   2162: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2165: iconst_0
    //   2166: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   2169: return
    //   2170: aload_0
    //   2171: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   2174: istore_1
    //   2175: iload_1
    //   2176: sipush 128
    //   2179: if_icmpne +12 -> 2191
    //   2182: aload_0
    //   2183: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2186: iconst_0
    //   2187: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   2190: return
    //   2191: iload_1
    //   2192: sipush 640
    //   2195: if_icmpne +12 -> 2207
    //   2198: aload_0
    //   2199: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2202: iconst_0
    //   2203: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   2206: return
    //   2207: iload_1
    //   2208: sipush 383
    //   2211: if_icmpne +11 -> 2222
    //   2214: aload_0
    //   2215: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2218: iconst_0
    //   2219: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   2222: return
    //   2223: aload_0
    //   2224: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	I
    //   2227: istore_1
    //   2228: iload_1
    //   2229: sipush 128
    //   2232: if_icmpne +12 -> 2244
    //   2235: aload_0
    //   2236: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2239: iconst_0
    //   2240: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   2243: return
    //   2244: iload_1
    //   2245: sipush 640
    //   2248: if_icmpne +12 -> 2260
    //   2251: aload_0
    //   2252: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2255: iconst_0
    //   2256: putfield 190	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   2259: return
    //   2260: iload_1
    //   2261: sipush 383
    //   2264: if_icmpne +11 -> 2275
    //   2267: aload_0
    //   2268: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   2271: iconst_0
    //   2272: putfield 193	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   2275: return
    //   2276: astore 13
    //   2278: goto -55 -> 2223
    //   2281: astore 13
    //   2283: goto -113 -> 2170
    //   2286: astore 13
    //   2288: goto -171 -> 2117
    //   2291: astore 13
    //   2293: goto -215 -> 2078
    //   2296: astore 18
    //   2298: goto -253 -> 2045
    //   2301: astore 18
    //   2303: goto -376 -> 1927
    //   2306: astore 20
    //   2308: goto -887 -> 1421
    //   2311: astore 14
    //   2313: goto -809 -> 1504
    //   2316: astore 14
    //   2318: goto -809 -> 1509
    //   2321: astore 19
    //   2323: goto -789 -> 1534
    //   2326: astore 18
    //   2328: goto -789 -> 1539
    //   2331: astore 19
    //   2333: goto -417 -> 1916
    //   2336: astore 18
    //   2338: goto -417 -> 1921
    //   2341: iload 8
    //   2343: sipush 200
    //   2346: if_icmpeq -1011 -> 1335
    //   2349: iload 8
    //   2351: sipush 206
    //   2354: if_icmpne -1111 -> 1243
    //   2357: goto -1022 -> 1335
    //   2360: iload_3
    //   2361: istore_2
    //   2362: iload_1
    //   2363: istore 4
    //   2365: aload 13
    //   2367: ifnull -262 -> 2105
    //   2370: iload_3
    //   2371: istore_2
    //   2372: iload_1
    //   2373: istore_3
    //   2374: goto -277 -> 2097
    //   2377: iconst_0
    //   2378: istore 11
    //   2380: goto -651 -> 1729
    //   2383: goto -574 -> 1809
    //   2386: goto -552 -> 1834
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2389	0	this	TaskHttpDownloadThumbnail
    //   185	2188	1	i	int
    //   239	2133	2	j	int
    //   847	1527	3	k	int
    //   714	1650	4	m	int
    //   711	1335	5	n	int
    //   1105	96	6	i1	int
    //   105	1635	7	i2	int
    //   844	1511	8	i3	int
    //   589	3	9	l	long
    //   1527	852	11	bool1	boolean
    //   1713	77	12	bool2	boolean
    //   24	144	13	localObject1	java.lang.Object
    //   189	28	13	localNumberFormatException	java.lang.NumberFormatException
    //   269	1829	13	localObject2	java.lang.Object
    //   2276	1	13	localMalformedURLException	java.net.MalformedURLException
    //   2281	1	13	localInterruptedException	java.lang.InterruptedException
    //   2286	1	13	localIOException1	java.io.IOException
    //   2291	75	13	localIOException2	java.io.IOException
    //   204	497	14	localObject3	java.lang.Object
    //   2040	1	14	localObject4	java.lang.Object
    //   2054	22	14	localObject5	java.lang.Object
    //   2311	1	14	localIOException3	java.io.IOException
    //   2316	1	14	localIOException4	java.io.IOException
    //   58	1511	15	str1	String
    //   90	1460	16	str2	String
    //   605	1501	17	localFile	java.io.File
    //   780	350	18	localObject6	java.lang.Object
    //   1205	29	18	localException	java.lang.Exception
    //   1363	554	18	localObject7	java.lang.Object
    //   2296	1	18	localIOException5	java.io.IOException
    //   2301	1	18	localFileNotFoundException	java.io.FileNotFoundException
    //   2326	1	18	localIOException6	java.io.IOException
    //   2336	1	18	localIOException7	java.io.IOException
    //   894	905	19	localObject8	java.lang.Object
    //   1895	17	19	localObject9	java.lang.Object
    //   2321	1	19	localIOException8	java.io.IOException
    //   2331	1	19	localIOException9	java.io.IOException
    //   1373	24	20	arrayOfByte	byte[]
    //   1909	16	20	localObject10	java.lang.Object
    //   2306	1	20	localIOException10	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   175	186	189	java/lang/NumberFormatException
    //   1037	1045	1205	java/lang/Exception
    //   1053	1064	1205	java/lang/Exception
    //   1070	1083	1205	java/lang/Exception
    //   1098	1104	1205	java/lang/Exception
    //   1115	1123	1205	java/lang/Exception
    //   1129	1142	1205	java/lang/Exception
    //   1153	1160	1205	java/lang/Exception
    //   1166	1179	1205	java/lang/Exception
    //   1185	1193	1205	java/lang/Exception
    //   1609	1642	1895	finally
    //   1645	1678	1895	finally
    //   1681	1721	1895	finally
    //   1729	1736	1895	finally
    //   1742	1806	1895	finally
    //   1809	1819	1895	finally
    //   1823	1831	1895	finally
    //   1834	1875	1895	finally
    //   1875	1878	1895	finally
    //   1897	1900	1895	finally
    //   1368	1375	1909	finally
    //   1378	1386	1909	finally
    //   1394	1403	1909	finally
    //   1406	1416	1909	finally
    //   1424	1434	1909	finally
    //   1437	1445	1909	finally
    //   1451	1461	1909	finally
    //   1464	1472	1909	finally
    //   1478	1488	1909	finally
    //   1491	1499	1909	finally
    //   716	724	2040	finally
    //   730	737	2040	finally
    //   743	752	2040	finally
    //   758	767	2040	finally
    //   773	782	2040	finally
    //   788	796	2040	finally
    //   802	815	2040	finally
    //   821	833	2040	finally
    //   839	846	2040	finally
    //   860	869	2040	finally
    //   875	881	2040	finally
    //   887	896	2040	finally
    //   902	910	2040	finally
    //   916	929	2040	finally
    //   935	943	2040	finally
    //   949	957	2040	finally
    //   963	971	2040	finally
    //   977	985	2040	finally
    //   991	999	2040	finally
    //   1005	1012	2040	finally
    //   1018	1029	2040	finally
    //   1037	1045	2040	finally
    //   1053	1064	2040	finally
    //   1070	1083	2040	finally
    //   1098	1104	2040	finally
    //   1115	1123	2040	finally
    //   1129	1142	2040	finally
    //   1153	1160	2040	finally
    //   1166	1179	2040	finally
    //   1185	1193	2040	finally
    //   1215	1221	2040	finally
    //   1227	1238	2040	finally
    //   1249	1259	2040	finally
    //   1265	1273	2040	finally
    //   1279	1287	2040	finally
    //   1293	1315	2040	finally
    //   1321	1332	2040	finally
    //   1341	1348	2040	finally
    //   1354	1365	2040	finally
    //   1499	1504	2040	finally
    //   1504	1509	2040	finally
    //   1529	1534	2040	finally
    //   1534	1539	2040	finally
    //   1545	1556	2040	finally
    //   1562	1577	2040	finally
    //   1583	1588	2040	finally
    //   1594	1600	2040	finally
    //   1606	1609	2040	finally
    //   1906	1909	2040	finally
    //   1911	1916	2040	finally
    //   1916	1921	2040	finally
    //   1924	1927	2040	finally
    //   1933	1943	2040	finally
    //   1949	1957	2040	finally
    //   1966	1976	2040	finally
    //   1982	1990	2040	finally
    //   1999	2009	2040	finally
    //   2015	2023	2040	finally
    //   700	710	2054	finally
    //   568	579	2276	java/net/MalformedURLException
    //   591	596	2281	java/lang/InterruptedException
    //   694	700	2286	java/io/IOException
    //   700	710	2291	java/io/IOException
    //   716	724	2296	java/io/IOException
    //   730	737	2296	java/io/IOException
    //   743	752	2296	java/io/IOException
    //   758	767	2296	java/io/IOException
    //   773	782	2296	java/io/IOException
    //   788	796	2296	java/io/IOException
    //   802	815	2296	java/io/IOException
    //   821	833	2296	java/io/IOException
    //   839	846	2296	java/io/IOException
    //   860	869	2296	java/io/IOException
    //   875	881	2296	java/io/IOException
    //   887	896	2296	java/io/IOException
    //   902	910	2296	java/io/IOException
    //   916	929	2296	java/io/IOException
    //   935	943	2296	java/io/IOException
    //   949	957	2296	java/io/IOException
    //   963	971	2296	java/io/IOException
    //   977	985	2296	java/io/IOException
    //   991	999	2296	java/io/IOException
    //   1005	1012	2296	java/io/IOException
    //   1018	1029	2296	java/io/IOException
    //   1037	1045	2296	java/io/IOException
    //   1053	1064	2296	java/io/IOException
    //   1070	1083	2296	java/io/IOException
    //   1098	1104	2296	java/io/IOException
    //   1115	1123	2296	java/io/IOException
    //   1129	1142	2296	java/io/IOException
    //   1153	1160	2296	java/io/IOException
    //   1166	1179	2296	java/io/IOException
    //   1185	1193	2296	java/io/IOException
    //   1215	1221	2296	java/io/IOException
    //   1227	1238	2296	java/io/IOException
    //   1249	1259	2296	java/io/IOException
    //   1265	1273	2296	java/io/IOException
    //   1279	1287	2296	java/io/IOException
    //   1293	1315	2296	java/io/IOException
    //   1321	1332	2296	java/io/IOException
    //   1341	1348	2296	java/io/IOException
    //   1354	1365	2296	java/io/IOException
    //   1545	1556	2296	java/io/IOException
    //   1562	1577	2296	java/io/IOException
    //   1583	1588	2296	java/io/IOException
    //   1594	1600	2296	java/io/IOException
    //   1606	1609	2296	java/io/IOException
    //   1906	1909	2296	java/io/IOException
    //   1924	1927	2296	java/io/IOException
    //   1933	1943	2296	java/io/IOException
    //   1949	1957	2296	java/io/IOException
    //   1966	1976	2296	java/io/IOException
    //   1982	1990	2296	java/io/IOException
    //   1999	2009	2296	java/io/IOException
    //   2015	2023	2296	java/io/IOException
    //   1354	1365	2301	java/io/FileNotFoundException
    //   1394	1403	2306	java/io/IOException
    //   1406	1416	2306	java/io/IOException
    //   1499	1504	2311	java/io/IOException
    //   1504	1509	2316	java/io/IOException
    //   1529	1534	2321	java/io/IOException
    //   1534	1539	2326	java/io/IOException
    //   1911	1916	2331	java/io/IOException
    //   1916	1921	2336	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail
 * JD-Core Version:    0.7.0.1
 */