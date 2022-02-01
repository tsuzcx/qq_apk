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
    //   15: invokestatic 44	bfdx:a	()V
    //   18: aload_0
    //   19: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   22: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   25: ifnonnull +35 -> 60
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
    //   60: new 69	java/io/File
    //   63: dup
    //   64: aload_0
    //   65: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   68: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   71: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual 80	java/io/File:exists	()Z
    //   79: ifeq +30 -> 109
    //   82: aload_3
    //   83: invokevirtual 83	java/io/File:isFile	()Z
    //   86: ifeq +23 -> 109
    //   89: aload_3
    //   90: invokevirtual 87	java/io/File:length	()J
    //   93: lconst_0
    //   94: lcmp
    //   95: ifle +14 -> 109
    //   98: aload_0
    //   99: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   102: aload_3
    //   103: invokevirtual 87	java/io/File:length	()J
    //   106: putfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   109: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +58 -> 170
    //   115: ldc 97
    //   117: iconst_2
    //   118: new 99	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   125: ldc 103
    //   127: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   134: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   137: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 109
    //   142: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 80	java/io/File:exists	()Z
    //   149: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   152: ldc 114
    //   154: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_3
    //   158: invokevirtual 87	java/io/File:length	()J
    //   161: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   174: aload_0
    //   175: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   178: invokevirtual 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   181: aload_0
    //   182: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   185: getfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   188: ldc2_w 129
    //   191: lcmp
    //   192: ifle +62 -> 254
    //   195: aload_0
    //   196: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   199: aload_0
    //   200: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   203: iconst_3
    //   204: sipush 205
    //   207: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   210: getstatic 138	bfdy:b	I
    //   213: getstatic 141	bfdy:e	I
    //   216: invokestatic 144	bfdx:a	(II)V
    //   219: return
    //   220: astore_3
    //   221: ldc 97
    //   223: iconst_1
    //   224: ldc 146
    //   226: aload_3
    //   227: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_0
    //   231: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   234: aload_0
    //   235: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   238: iconst_3
    //   239: bipush 102
    //   241: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   244: getstatic 138	bfdy:b	I
    //   247: getstatic 152	bfdy:s	I
    //   250: invokestatic 144	bfdx:a	(II)V
    //   253: return
    //   254: new 154	java/io/FileInputStream
    //   257: dup
    //   258: aload_3
    //   259: invokespecial 157	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   262: astore_3
    //   263: aload_3
    //   264: aload_0
    //   265: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   268: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   271: invokevirtual 161	java/io/FileInputStream:skip	(J)J
    //   274: pop2
    //   275: ldc 162
    //   277: newarray byte
    //   279: astore 4
    //   281: aload_3
    //   282: aload 4
    //   284: invokevirtual 166	java/io/FileInputStream:read	([B)I
    //   287: istore_1
    //   288: iload_1
    //   289: ifge +341 -> 630
    //   292: aload_3
    //   293: invokevirtual 169	java/io/FileInputStream:close	()V
    //   296: aload_0
    //   297: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   300: aload_0
    //   301: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   304: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   307: invokevirtual 173	java/security/MessageDigest:digest	()[B
    //   310: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   313: aload_0
    //   314: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   317: aload_0
    //   318: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   321: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   324: invokevirtual 173	java/security/MessageDigest:digest	()[B
    //   327: putfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   330: aload_0
    //   331: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   334: aload_0
    //   335: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   338: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   341: invokestatic 185	aszt:d	(Ljava/lang/String;)[B
    //   344: invokestatic 191	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   347: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   350: aload_0
    //   351: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   354: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   357: invokestatic 197	aszt:c	(Ljava/lang/String;)[B
    //   360: invokestatic 191	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   363: pop
    //   364: aload_0
    //   365: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   368: aconst_null
    //   369: putfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   372: aload_0
    //   373: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   376: aconst_null
    //   377: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   380: aload_0
    //   381: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   384: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   387: invokestatic 200	aszt:a	(Ljava/lang/String;)I
    //   390: ifne +381 -> 771
    //   393: new 202	android/graphics/BitmapFactory$Options
    //   396: dup
    //   397: invokespecial 203	android/graphics/BitmapFactory$Options:<init>	()V
    //   400: astore_3
    //   401: aload_3
    //   402: iconst_1
    //   403: putfield 206	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   406: aload_0
    //   407: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   410: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   413: aload_3
    //   414: invokestatic 211	bfvo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   417: pop
    //   418: aload_0
    //   419: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   422: aload_3
    //   423: getfield 214	android/graphics/BitmapFactory$Options:outWidth	I
    //   426: putfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   429: aload_0
    //   430: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   433: aload_3
    //   434: getfield 220	android/graphics/BitmapFactory$Options:outHeight	I
    //   437: putfield 223	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   440: aload_0
    //   441: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   444: aload_0
    //   445: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   448: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   451: ifne -437 -> 14
    //   454: aload_0
    //   455: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   458: getfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   461: invokestatic 191	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   464: astore_3
    //   465: aload_0
    //   466: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   469: getfield 180	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   472: invokestatic 191	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   475: astore 4
    //   477: ldc 97
    //   479: iconst_1
    //   480: new 99	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   487: ldc 225
    //   489: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_3
    //   493: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc 227
    //   498: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 4
    //   503: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc 229
    //   508: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   515: getfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   518: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: ldc 231
    //   523: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload_0
    //   527: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   530: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   533: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc 236
    //   538: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_0
    //   542: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   545: getfield 223	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   548: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc 238
    //   553: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   560: getfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   563: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 244	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: aload_0
    //   573: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   576: aload_0
    //   577: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   580: invokevirtual 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   583: aload_0
    //   584: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   587: aload_0
    //   588: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   591: invokevirtual 246	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   594: return
    //   595: astore_3
    //   596: ldc 97
    //   598: iconst_1
    //   599: ldc 248
    //   601: aload_3
    //   602: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   605: aload_0
    //   606: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   609: aload_0
    //   610: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   613: iconst_3
    //   614: sipush 201
    //   617: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   620: getstatic 138	bfdy:b	I
    //   623: getstatic 251	bfdy:g	I
    //   626: invokestatic 144	bfdx:a	(II)V
    //   629: return
    //   630: aload_0
    //   631: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   634: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   637: aload 4
    //   639: iconst_0
    //   640: iload_1
    //   641: invokevirtual 255	java/security/MessageDigest:update	([BII)V
    //   644: aload_0
    //   645: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   648: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   651: aload 4
    //   653: iconst_0
    //   654: iload_1
    //   655: invokevirtual 255	java/security/MessageDigest:update	([BII)V
    //   658: aload_0
    //   659: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   662: astore 5
    //   664: aload 5
    //   666: aload 5
    //   668: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   671: iload_1
    //   672: i2l
    //   673: ladd
    //   674: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   677: aload_0
    //   678: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   681: aload_0
    //   682: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   685: invokevirtual 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   688: istore_2
    //   689: iload_2
    //   690: ifeq -409 -> 281
    //   693: aload_3
    //   694: invokevirtual 169	java/io/FileInputStream:close	()V
    //   697: return
    //   698: astore_3
    //   699: aload_3
    //   700: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   703: return
    //   704: astore_3
    //   705: aload_3
    //   706: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   709: goto -413 -> 296
    //   712: astore 4
    //   714: aload 4
    //   716: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   719: aload_0
    //   720: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   723: aload_0
    //   724: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   727: iconst_3
    //   728: sipush 203
    //   731: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   734: getstatic 138	bfdy:b	I
    //   737: getstatic 261	bfdy:j	I
    //   740: invokestatic 144	bfdx:a	(II)V
    //   743: aload_3
    //   744: invokevirtual 169	java/io/FileInputStream:close	()V
    //   747: return
    //   748: astore_3
    //   749: aload_3
    //   750: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   753: return
    //   754: astore 4
    //   756: aload_3
    //   757: invokevirtual 169	java/io/FileInputStream:close	()V
    //   760: aload 4
    //   762: athrow
    //   763: astore_3
    //   764: aload_3
    //   765: invokevirtual 258	java/io/IOException:printStackTrace	()V
    //   768: goto -8 -> 760
    //   771: aload_0
    //   772: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   775: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   778: invokestatic 200	aszt:a	(Ljava/lang/String;)I
    //   781: iconst_2
    //   782: if_icmpne -342 -> 440
    //   785: aload_0
    //   786: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   789: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   792: invokestatic 267	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoFileRtAndTime	(Ljava/lang/String;)[I
    //   795: astore_3
    //   796: aload_0
    //   797: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   800: aload_3
    //   801: iconst_0
    //   802: iaload
    //   803: putfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   806: aload_0
    //   807: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   810: aload_3
    //   811: iconst_1
    //   812: iaload
    //   813: putfield 223	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   816: aload_0
    //   817: getfield 36	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   820: aload_3
    //   821: iconst_2
    //   822: iaload
    //   823: putfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   826: goto -386 -> 440
    //   829: astore_3
    //   830: goto -390 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	TaskScan
    //   287	385	1	i	int
    //   688	2	2	bool	boolean
    //   74	84	3	localFile	java.io.File
    //   220	39	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   262	231	3	localObject1	java.lang.Object
    //   595	99	3	localFileNotFoundException	java.io.FileNotFoundException
    //   698	2	3	localIOException1	java.io.IOException
    //   704	40	3	localIOException2	java.io.IOException
    //   748	9	3	localIOException3	java.io.IOException
    //   763	2	3	localIOException4	java.io.IOException
    //   795	26	3	arrayOfInt	int[]
    //   829	1	3	localException	java.lang.Exception
    //   279	373	4	localObject2	java.lang.Object
    //   712	3	4	localIOException5	java.io.IOException
    //   754	7	4	localObject3	java.lang.Object
    //   662	5	5	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   36	60	220	java/security/NoSuchAlgorithmException
    //   254	263	595	java/io/FileNotFoundException
    //   693	697	698	java/io/IOException
    //   292	296	704	java/io/IOException
    //   263	281	712	java/io/IOException
    //   281	288	712	java/io/IOException
    //   630	689	712	java/io/IOException
    //   743	747	748	java/io/IOException
    //   263	281	754	finally
    //   281	288	754	finally
    //   630	689	754	finally
    //   714	743	754	finally
    //   756	760	763	java/io/IOException
    //   393	440	829	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */