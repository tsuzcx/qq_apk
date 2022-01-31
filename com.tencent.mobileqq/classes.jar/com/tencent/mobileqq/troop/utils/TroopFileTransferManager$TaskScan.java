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
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 43	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	()V
    //   18: aload_0
    //   19: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   22: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   25: ifnonnull +35 -> 60
    //   28: aload_0
    //   29: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: lconst_0
    //   33: putfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   36: aload_0
    //   37: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   40: ldc 55
    //   42: invokestatic 61	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: putfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   48: aload_0
    //   49: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   52: ldc 63
    //   54: invokestatic 61	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   57: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   60: new 68	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   68: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   71: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 79	java/io/File:exists	()Z
    //   79: ifeq +30 -> 109
    //   82: aload_3
    //   83: invokevirtual 82	java/io/File:isFile	()Z
    //   86: ifeq +23 -> 109
    //   89: aload_3
    //   90: invokevirtual 86	java/io/File:length	()J
    //   93: lconst_0
    //   94: lcmp
    //   95: ifle +14 -> 109
    //   98: aload_0
    //   99: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   102: aload_3
    //   103: invokevirtual 86	java/io/File:length	()J
    //   106: putfield 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   109: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +58 -> 170
    //   115: ldc 96
    //   117: iconst_2
    //   118: new 98	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   125: ldc 102
    //   127: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   134: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   137: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 108
    //   142: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 79	java/io/File:exists	()Z
    //   149: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   152: ldc 113
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_3
    //   158: invokevirtual 86	java/io/File:length	()J
    //   161: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   174: aload_0
    //   175: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   178: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   181: aload_0
    //   182: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   185: getfield 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   188: ldc2_w 128
    //   191: lcmp
    //   192: ifle +62 -> 254
    //   195: aload_0
    //   196: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   199: aload_0
    //   200: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: iconst_3
    //   204: sipush 205
    //   207: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   210: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   213: getstatic 140	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:e	I
    //   216: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   219: return
    //   220: astore_3
    //   221: ldc 96
    //   223: iconst_1
    //   224: ldc 145
    //   226: aload_3
    //   227: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_0
    //   231: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   234: aload_0
    //   235: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   238: iconst_3
    //   239: bipush 102
    //   241: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   244: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   247: getstatic 151	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:r	I
    //   250: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   253: return
    //   254: new 153	java/io/FileInputStream
    //   257: dup
    //   258: aload_3
    //   259: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   262: astore_3
    //   263: aload_3
    //   264: aload_0
    //   265: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   268: getfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   271: invokevirtual 160	java/io/FileInputStream:skip	(J)J
    //   274: pop2
    //   275: ldc 161
    //   277: newarray byte
    //   279: astore 4
    //   281: aload_3
    //   282: aload 4
    //   284: invokevirtual 165	java/io/FileInputStream:read	([B)I
    //   287: istore_1
    //   288: iload_1
    //   289: ifge +189 -> 478
    //   292: aload_3
    //   293: invokevirtual 168	java/io/FileInputStream:close	()V
    //   296: aload_0
    //   297: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   300: aload_0
    //   301: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   304: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   307: invokevirtual 172	java/security/MessageDigest:digest	()[B
    //   310: putfield 176	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   313: aload_0
    //   314: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   317: aload_0
    //   318: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   321: getfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   324: invokevirtual 172	java/security/MessageDigest:digest	()[B
    //   327: putfield 179	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   330: aload_0
    //   331: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   334: aconst_null
    //   335: putfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   338: aload_0
    //   339: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   342: aconst_null
    //   343: putfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   346: aload_0
    //   347: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   350: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   353: invokestatic 184	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   356: ifne +263 -> 619
    //   359: new 186	android/graphics/BitmapFactory$Options
    //   362: dup
    //   363: invokespecial 187	android/graphics/BitmapFactory$Options:<init>	()V
    //   366: astore_3
    //   367: aload_3
    //   368: iconst_1
    //   369: putfield 190	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   372: aload_0
    //   373: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   376: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   379: aload_3
    //   380: invokestatic 195	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   383: pop
    //   384: aload_0
    //   385: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   388: aload_3
    //   389: getfield 198	android/graphics/BitmapFactory$Options:outWidth	I
    //   392: putfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   395: aload_0
    //   396: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   399: aload_3
    //   400: getfield 204	android/graphics/BitmapFactory$Options:outHeight	I
    //   403: putfield 207	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   406: aload_0
    //   407: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   410: aload_0
    //   411: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   414: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   417: ifne -403 -> 14
    //   420: aload_0
    //   421: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   424: aload_0
    //   425: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   428: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   431: aload_0
    //   432: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   435: aload_0
    //   436: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   439: invokevirtual 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   442: return
    //   443: astore_3
    //   444: ldc 96
    //   446: iconst_1
    //   447: ldc 211
    //   449: aload_3
    //   450: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   453: aload_0
    //   454: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   457: aload_0
    //   458: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   461: iconst_3
    //   462: sipush 201
    //   465: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   468: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   471: getstatic 214	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   474: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   477: return
    //   478: aload_0
    //   479: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   482: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   485: aload 4
    //   487: iconst_0
    //   488: iload_1
    //   489: invokevirtual 218	java/security/MessageDigest:update	([BII)V
    //   492: aload_0
    //   493: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   496: getfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   499: aload 4
    //   501: iconst_0
    //   502: iload_1
    //   503: invokevirtual 218	java/security/MessageDigest:update	([BII)V
    //   506: aload_0
    //   507: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   510: astore 5
    //   512: aload 5
    //   514: aload 5
    //   516: getfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   519: iload_1
    //   520: i2l
    //   521: ladd
    //   522: putfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   525: aload_0
    //   526: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   529: aload_0
    //   530: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   533: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   536: istore_2
    //   537: iload_2
    //   538: ifeq -257 -> 281
    //   541: aload_3
    //   542: invokevirtual 168	java/io/FileInputStream:close	()V
    //   545: return
    //   546: astore_3
    //   547: aload_3
    //   548: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   551: return
    //   552: astore_3
    //   553: aload_3
    //   554: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   557: goto -261 -> 296
    //   560: astore 4
    //   562: aload 4
    //   564: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   567: aload_0
    //   568: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   571: aload_0
    //   572: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   575: iconst_3
    //   576: sipush 203
    //   579: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   582: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   585: getstatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   588: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   591: aload_3
    //   592: invokevirtual 168	java/io/FileInputStream:close	()V
    //   595: return
    //   596: astore_3
    //   597: aload_3
    //   598: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   601: return
    //   602: astore 4
    //   604: aload_3
    //   605: invokevirtual 168	java/io/FileInputStream:close	()V
    //   608: aload 4
    //   610: athrow
    //   611: astore_3
    //   612: aload_3
    //   613: invokevirtual 221	java/io/IOException:printStackTrace	()V
    //   616: goto -8 -> 608
    //   619: aload_0
    //   620: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   623: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   626: invokestatic 184	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   629: iconst_2
    //   630: if_icmpne -224 -> 406
    //   633: aload_0
    //   634: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   637: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   640: invokestatic 229	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)[I
    //   643: astore_3
    //   644: aload_0
    //   645: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   648: aload_3
    //   649: iconst_0
    //   650: iaload
    //   651: putfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   654: aload_0
    //   655: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   658: aload_3
    //   659: iconst_1
    //   660: iaload
    //   661: putfield 207	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   664: aload_0
    //   665: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   668: aload_3
    //   669: iconst_2
    //   670: iaload
    //   671: putfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   674: goto -268 -> 406
    //   677: astore_3
    //   678: goto -272 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	this	TaskScan
    //   287	233	1	i	int
    //   536	2	2	bool	boolean
    //   74	84	3	localFile	java.io.File
    //   220	39	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   262	138	3	localObject1	java.lang.Object
    //   443	99	3	localFileNotFoundException	java.io.FileNotFoundException
    //   546	2	3	localIOException1	java.io.IOException
    //   552	40	3	localIOException2	java.io.IOException
    //   596	9	3	localIOException3	java.io.IOException
    //   611	2	3	localIOException4	java.io.IOException
    //   643	26	3	arrayOfInt	int[]
    //   677	1	3	localException	java.lang.Exception
    //   279	221	4	arrayOfByte	byte[]
    //   560	3	4	localIOException5	java.io.IOException
    //   602	7	4	localObject2	java.lang.Object
    //   510	5	5	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   36	60	220	java/security/NoSuchAlgorithmException
    //   254	263	443	java/io/FileNotFoundException
    //   541	545	546	java/io/IOException
    //   292	296	552	java/io/IOException
    //   263	281	560	java/io/IOException
    //   281	288	560	java/io/IOException
    //   478	537	560	java/io/IOException
    //   591	595	596	java/io/IOException
    //   263	281	602	finally
    //   281	288	602	finally
    //   478	537	602	finally
    //   562	591	602	finally
    //   604	608	611	java/io/IOException
    //   359	406	677	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */