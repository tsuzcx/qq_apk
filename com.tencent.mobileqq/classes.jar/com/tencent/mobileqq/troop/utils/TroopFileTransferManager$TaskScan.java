package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskScan
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskScan(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 0);
    paramTroopFileTransferManager.a(paramItem, 0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 44	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	()V
    //   18: aload_0
    //   19: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   22: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   25: ifnonnull +72 -> 97
    //   28: aload_0
    //   29: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: lconst_0
    //   33: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   36: aload_0
    //   37: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   40: ldc 56
    //   42: invokestatic 62	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: putfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   48: aload_0
    //   49: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   52: ldc 64
    //   54: invokestatic 62	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   57: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   60: goto +37 -> 97
    //   63: astore_3
    //   64: ldc 69
    //   66: iconst_1
    //   67: ldc 71
    //   69: aload_3
    //   70: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   77: aload_0
    //   78: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   81: iconst_3
    //   82: bipush 102
    //   84: invokevirtual 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   87: getstatic 85	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   90: getstatic 88	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:s	I
    //   93: invokestatic 91	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   96: return
    //   97: new 93	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   105: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   108: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 104	java/io/File:exists	()Z
    //   116: ifeq +30 -> 146
    //   119: aload_3
    //   120: invokevirtual 107	java/io/File:isFile	()Z
    //   123: ifeq +23 -> 146
    //   126: aload_3
    //   127: invokevirtual 111	java/io/File:length	()J
    //   130: lconst_0
    //   131: lcmp
    //   132: ifle +14 -> 146
    //   135: aload_0
    //   136: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   139: aload_3
    //   140: invokevirtual 111	java/io/File:length	()J
    //   143: putfield 114	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   146: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +80 -> 229
    //   152: new 119	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: ldc 123
    //   165: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: aload_0
    //   172: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   175: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   178: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: ldc 129
    //   186: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: aload_3
    //   193: invokevirtual 104	java/io/File:exists	()Z
    //   196: invokevirtual 132	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 4
    //   202: ldc 134
    //   204: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: aload_3
    //   211: invokevirtual 111	java/io/File:length	()J
    //   214: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 69
    //   220: iconst_2
    //   221: aload 4
    //   223: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   233: aload_0
    //   234: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: invokevirtual 148	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   240: aload_0
    //   241: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   244: getfield 114	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   247: ldc2_w 149
    //   250: lcmp
    //   251: ifle +28 -> 279
    //   254: aload_0
    //   255: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   258: aload_0
    //   259: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   262: iconst_3
    //   263: sipush 205
    //   266: invokevirtual 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   269: getstatic 85	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   272: getstatic 152	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:e	I
    //   275: invokestatic 91	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   278: return
    //   279: new 154	java/io/FileInputStream
    //   282: dup
    //   283: aload_3
    //   284: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   287: astore_3
    //   288: aload_3
    //   289: aload_0
    //   290: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   296: invokevirtual 161	java/io/FileInputStream:skip	(J)J
    //   299: pop2
    //   300: ldc 162
    //   302: newarray byte
    //   304: astore 4
    //   306: aload_3
    //   307: aload 4
    //   309: invokevirtual 166	java/io/FileInputStream:read	([B)I
    //   312: istore_1
    //   313: iload_1
    //   314: ifge +416 -> 730
    //   317: aload_3
    //   318: invokevirtual 169	java/io/FileInputStream:close	()V
    //   321: goto +8 -> 329
    //   324: astore_3
    //   325: aload_3
    //   326: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   329: aload_0
    //   330: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   333: aload_0
    //   334: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   337: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   340: invokevirtual 176	java/security/MessageDigest:digest	()[B
    //   343: putfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   346: aload_0
    //   347: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   350: aload_0
    //   351: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   354: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   357: invokevirtual 176	java/security/MessageDigest:digest	()[B
    //   360: putfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   363: aload_0
    //   364: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   367: aload_0
    //   368: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   371: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   374: invokestatic 189	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)[B
    //   377: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   380: putfield 198	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   387: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   390: invokestatic 200	com/tencent/mobileqq/filemanager/util/FileManagerUtil:b	(Ljava/lang/String;)[B
    //   393: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   396: pop
    //   397: aload_0
    //   398: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   401: aconst_null
    //   402: putfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   405: aload_0
    //   406: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   409: aconst_null
    //   410: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   413: aload_0
    //   414: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   417: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   420: invokestatic 203	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   423: ifne +56 -> 479
    //   426: new 205	android/graphics/BitmapFactory$Options
    //   429: dup
    //   430: invokespecial 206	android/graphics/BitmapFactory$Options:<init>	()V
    //   433: astore_3
    //   434: aload_3
    //   435: iconst_1
    //   436: putfield 209	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   439: aload_0
    //   440: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   443: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   446: aload_3
    //   447: invokestatic 214	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   450: pop
    //   451: aload_0
    //   452: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   455: aload_3
    //   456: getfield 217	android/graphics/BitmapFactory$Options:outWidth	I
    //   459: putfield 220	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   462: aload_0
    //   463: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   466: aload_3
    //   467: getfield 223	android/graphics/BitmapFactory$Options:outHeight	I
    //   470: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   473: goto +61 -> 534
    //   476: goto +58 -> 534
    //   479: aload_0
    //   480: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   483: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   486: invokestatic 203	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   489: iconst_2
    //   490: if_icmpne +44 -> 534
    //   493: aload_0
    //   494: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   497: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   500: invokestatic 232	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoFileRtAndTime	(Ljava/lang/String;)[I
    //   503: astore_3
    //   504: aload_0
    //   505: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   508: aload_3
    //   509: iconst_0
    //   510: iaload
    //   511: putfield 220	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   514: aload_0
    //   515: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   518: aload_3
    //   519: iconst_1
    //   520: iaload
    //   521: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   524: aload_0
    //   525: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   528: aload_3
    //   529: iconst_2
    //   530: iaload
    //   531: putfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   534: aload_0
    //   535: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   538: aload_0
    //   539: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   542: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   545: ifeq +4 -> 549
    //   548: return
    //   549: aload_0
    //   550: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   553: getfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   556: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   559: astore_3
    //   560: aload_0
    //   561: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   564: getfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   567: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   570: astore 4
    //   572: new 119	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   579: astore 5
    //   581: aload 5
    //   583: ldc 237
    //   585: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 5
    //   591: aload_3
    //   592: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 5
    //   598: ldc 239
    //   600: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 5
    //   606: aload 4
    //   608: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 5
    //   614: ldc 241
    //   616: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 5
    //   622: aload_0
    //   623: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   626: getfield 198	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   629: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 5
    //   635: ldc 243
    //   637: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 5
    //   643: aload_0
    //   644: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   647: getfield 220	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   650: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 5
    //   656: ldc 248
    //   658: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 5
    //   664: aload_0
    //   665: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   668: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   671: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 5
    //   677: ldc 250
    //   679: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 5
    //   685: aload_0
    //   686: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   689: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   692: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 69
    //   698: iconst_1
    //   699: aload 5
    //   701: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_0
    //   708: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   711: aload_0
    //   712: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   715: invokevirtual 148	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   718: aload_0
    //   719: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   722: aload_0
    //   723: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   726: invokevirtual 255	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   729: return
    //   730: aload_0
    //   731: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   734: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   737: aload 4
    //   739: iconst_0
    //   740: iload_1
    //   741: invokevirtual 259	java/security/MessageDigest:update	([BII)V
    //   744: aload_0
    //   745: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   748: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   751: aload 4
    //   753: iconst_0
    //   754: iload_1
    //   755: invokevirtual 259	java/security/MessageDigest:update	([BII)V
    //   758: aload_0
    //   759: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   762: astore 5
    //   764: aload 5
    //   766: aload 5
    //   768: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   771: iload_1
    //   772: i2l
    //   773: ladd
    //   774: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   777: aload_0
    //   778: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   781: aload_0
    //   782: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   785: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   788: istore_2
    //   789: iload_2
    //   790: ifeq -484 -> 306
    //   793: aload_3
    //   794: invokevirtual 169	java/io/FileInputStream:close	()V
    //   797: return
    //   798: astore_3
    //   799: aload_3
    //   800: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   803: return
    //   804: astore 4
    //   806: goto +45 -> 851
    //   809: astore 4
    //   811: aload 4
    //   813: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   816: aload_0
    //   817: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   820: aload_0
    //   821: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   824: iconst_3
    //   825: sipush 203
    //   828: invokevirtual 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   831: getstatic 85	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   834: getstatic 262	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   837: invokestatic 91	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   840: aload_3
    //   841: invokevirtual 169	java/io/FileInputStream:close	()V
    //   844: return
    //   845: astore_3
    //   846: aload_3
    //   847: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   850: return
    //   851: aload_3
    //   852: invokevirtual 169	java/io/FileInputStream:close	()V
    //   855: goto +8 -> 863
    //   858: astore_3
    //   859: aload_3
    //   860: invokevirtual 172	java/io/IOException:printStackTrace	()V
    //   863: aload 4
    //   865: athrow
    //   866: astore_3
    //   867: ldc 69
    //   869: iconst_1
    //   870: ldc_w 264
    //   873: aload_3
    //   874: invokestatic 77	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: aload_0
    //   878: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   881: aload_0
    //   882: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   885: iconst_3
    //   886: sipush 201
    //   889: invokevirtual 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   892: getstatic 85	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   895: getstatic 267	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   898: invokestatic 91	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   901: return
    //   902: astore_3
    //   903: goto -427 -> 476
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	906	0	this	TaskScan
    //   312	460	1	i	int
    //   788	2	2	bool	boolean
    //   63	7	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   111	207	3	localObject1	java.lang.Object
    //   324	2	3	localIOException1	java.io.IOException
    //   433	361	3	localObject2	java.lang.Object
    //   798	43	3	localIOException2	java.io.IOException
    //   845	7	3	localIOException3	java.io.IOException
    //   858	2	3	localIOException4	java.io.IOException
    //   866	8	3	localFileNotFoundException	java.io.FileNotFoundException
    //   902	1	3	localException	java.lang.Exception
    //   159	593	4	localObject3	java.lang.Object
    //   804	1	4	localObject4	java.lang.Object
    //   809	55	4	localIOException5	java.io.IOException
    //   579	188	5	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   36	60	63	java/security/NoSuchAlgorithmException
    //   317	321	324	java/io/IOException
    //   793	797	798	java/io/IOException
    //   288	306	804	finally
    //   306	313	804	finally
    //   730	789	804	finally
    //   811	840	804	finally
    //   288	306	809	java/io/IOException
    //   306	313	809	java/io/IOException
    //   730	789	809	java/io/IOException
    //   840	844	845	java/io/IOException
    //   851	855	858	java/io/IOException
    //   279	288	866	java/io/FileNotFoundException
    //   426	473	902	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */