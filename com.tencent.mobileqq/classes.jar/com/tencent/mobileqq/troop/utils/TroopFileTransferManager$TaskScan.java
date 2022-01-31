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
    //   8: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
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
    //   178: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
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
    //   247: getstatic 151	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:s	I
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
    //   289: ifge +292 -> 581
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
    //   356: ifne +366 -> 722
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
    //   414: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   417: ifne -403 -> 14
    //   420: aload_0
    //   421: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   424: getfield 176	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   427: invokestatic 212	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   430: astore_3
    //   431: aload_0
    //   432: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   435: getfield 179	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   438: invokestatic 212	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   441: astore 4
    //   443: ldc 96
    //   445: iconst_1
    //   446: new 98	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   453: ldc 214
    //   455: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_3
    //   459: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc 216
    //   464: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 4
    //   469: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc 218
    //   474: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   481: getfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   484: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: ldc 223
    //   489: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   496: getfield 207	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   499: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: ldc 225
    //   504: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload_0
    //   508: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   511: getfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   514: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload_0
    //   524: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   527: aload_0
    //   528: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   531: invokevirtual 127	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   534: aload_0
    //   535: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   538: aload_0
    //   539: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   542: invokevirtual 233	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   545: return
    //   546: astore_3
    //   547: ldc 96
    //   549: iconst_1
    //   550: ldc 235
    //   552: aload_3
    //   553: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   556: aload_0
    //   557: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   560: aload_0
    //   561: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   564: iconst_3
    //   565: sipush 201
    //   568: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   571: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   574: getstatic 238	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   577: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   580: return
    //   581: aload_0
    //   582: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   585: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   588: aload 4
    //   590: iconst_0
    //   591: iload_1
    //   592: invokevirtual 242	java/security/MessageDigest:update	([BII)V
    //   595: aload_0
    //   596: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   599: getfield 66	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   602: aload 4
    //   604: iconst_0
    //   605: iload_1
    //   606: invokevirtual 242	java/security/MessageDigest:update	([BII)V
    //   609: aload_0
    //   610: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   613: astore 5
    //   615: aload 5
    //   617: aload 5
    //   619: getfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   622: iload_1
    //   623: i2l
    //   624: ladd
    //   625: putfield 53	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   628: aload_0
    //   629: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   632: aload_0
    //   633: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   636: invokevirtual 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   639: istore_2
    //   640: iload_2
    //   641: ifeq -360 -> 281
    //   644: aload_3
    //   645: invokevirtual 168	java/io/FileInputStream:close	()V
    //   648: return
    //   649: astore_3
    //   650: aload_3
    //   651: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   654: return
    //   655: astore_3
    //   656: aload_3
    //   657: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   660: goto -364 -> 296
    //   663: astore 4
    //   665: aload 4
    //   667: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   670: aload_0
    //   671: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   674: aload_0
    //   675: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   678: iconst_3
    //   679: sipush 203
    //   682: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   685: getstatic 137	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   688: getstatic 248	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   691: invokestatic 143	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   694: aload_3
    //   695: invokevirtual 168	java/io/FileInputStream:close	()V
    //   698: return
    //   699: astore_3
    //   700: aload_3
    //   701: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   704: return
    //   705: astore 4
    //   707: aload_3
    //   708: invokevirtual 168	java/io/FileInputStream:close	()V
    //   711: aload 4
    //   713: athrow
    //   714: astore_3
    //   715: aload_3
    //   716: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   719: goto -8 -> 711
    //   722: aload_0
    //   723: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   726: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   729: invokestatic 184	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   732: iconst_2
    //   733: if_icmpne -327 -> 406
    //   736: aload_0
    //   737: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   740: getfield 72	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   743: invokestatic 253	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)[I
    //   746: astore_3
    //   747: aload_0
    //   748: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   751: aload_3
    //   752: iconst_0
    //   753: iaload
    //   754: putfield 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   757: aload_0
    //   758: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   761: aload_3
    //   762: iconst_1
    //   763: iaload
    //   764: putfield 207	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   767: aload_0
    //   768: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   771: aload_3
    //   772: iconst_2
    //   773: iaload
    //   774: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   777: goto -371 -> 406
    //   780: astore_3
    //   781: goto -375 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	TaskScan
    //   287	336	1	i	int
    //   639	2	2	bool	boolean
    //   74	84	3	localFile	java.io.File
    //   220	39	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   262	197	3	localObject1	java.lang.Object
    //   546	99	3	localFileNotFoundException	java.io.FileNotFoundException
    //   649	2	3	localIOException1	java.io.IOException
    //   655	40	3	localIOException2	java.io.IOException
    //   699	9	3	localIOException3	java.io.IOException
    //   714	2	3	localIOException4	java.io.IOException
    //   746	26	3	arrayOfInt	int[]
    //   780	1	3	localException	java.lang.Exception
    //   279	324	4	localObject2	java.lang.Object
    //   663	3	4	localIOException5	java.io.IOException
    //   705	7	4	localObject3	java.lang.Object
    //   613	5	5	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   36	60	220	java/security/NoSuchAlgorithmException
    //   254	263	546	java/io/FileNotFoundException
    //   644	648	649	java/io/IOException
    //   292	296	655	java/io/IOException
    //   263	281	663	java/io/IOException
    //   281	288	663	java/io/IOException
    //   581	640	663	java/io/IOException
    //   694	698	699	java/io/IOException
    //   263	281	705	finally
    //   281	288	705	finally
    //   581	640	705	finally
    //   665	694	705	finally
    //   707	711	714	java/io/IOException
    //   359	406	780	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */