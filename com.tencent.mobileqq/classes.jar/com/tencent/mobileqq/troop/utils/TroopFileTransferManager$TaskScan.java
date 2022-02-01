package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskScan
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskScan(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 0);
    paramTroopFileTransferManager.b(paramItem, 0);
    this.c = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 42	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 46	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	()V
    //   18: aload_0
    //   19: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   22: getfield 52	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   25: ifnonnull +72 -> 97
    //   28: aload_0
    //   29: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   32: lconst_0
    //   33: putfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   36: aload_0
    //   37: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   40: ldc 58
    //   42: invokestatic 64	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: putfield 52	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   48: aload_0
    //   49: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   52: ldc 66
    //   54: invokestatic 64	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   57: putfield 69	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   60: goto +37 -> 97
    //   63: astore_3
    //   64: ldc 71
    //   66: iconst_1
    //   67: ldc 73
    //   69: aload_3
    //   70: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   77: aload_0
    //   78: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   81: iconst_3
    //   82: bipush 102
    //   84: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   87: getstatic 87	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   90: getstatic 90	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:s	I
    //   93: invokestatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   96: return
    //   97: new 95	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   105: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   108: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   111: astore_3
    //   112: aload_3
    //   113: invokevirtual 106	java/io/File:exists	()Z
    //   116: ifeq +30 -> 146
    //   119: aload_3
    //   120: invokevirtual 109	java/io/File:isFile	()Z
    //   123: ifeq +23 -> 146
    //   126: aload_3
    //   127: invokevirtual 113	java/io/File:length	()J
    //   130: lconst_0
    //   131: lcmp
    //   132: ifle +14 -> 146
    //   135: aload_0
    //   136: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   139: aload_3
    //   140: invokevirtual 113	java/io/File:length	()J
    //   143: putfield 116	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   146: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +80 -> 229
    //   152: new 121	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   159: astore 4
    //   161: aload 4
    //   163: ldc 125
    //   165: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: aload_0
    //   172: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   175: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   178: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: ldc 131
    //   186: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: aload_3
    //   193: invokevirtual 106	java/io/File:exists	()Z
    //   196: invokevirtual 134	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 4
    //   202: ldc 136
    //   204: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: aload_3
    //   211: invokevirtual 113	java/io/File:length	()J
    //   214: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 71
    //   220: iconst_2
    //   221: aload 4
    //   223: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   233: aload_0
    //   234: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   237: invokevirtual 150	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   240: aload_0
    //   241: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   244: getfield 116	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   247: ldc2_w 151
    //   250: lcmp
    //   251: ifle +28 -> 279
    //   254: aload_0
    //   255: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   258: aload_0
    //   259: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   262: iconst_3
    //   263: sipush 205
    //   266: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   269: getstatic 87	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   272: getstatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:e	I
    //   275: invokestatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   278: return
    //   279: new 156	java/io/FileInputStream
    //   282: dup
    //   283: aload_3
    //   284: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   287: astore_3
    //   288: aload_3
    //   289: aload_0
    //   290: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   293: getfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   296: invokevirtual 163	java/io/FileInputStream:skip	(J)J
    //   299: pop2
    //   300: ldc 164
    //   302: newarray byte
    //   304: astore 4
    //   306: aload_3
    //   307: aload 4
    //   309: invokevirtual 168	java/io/FileInputStream:read	([B)I
    //   312: istore_1
    //   313: iload_1
    //   314: ifge +416 -> 730
    //   317: aload_3
    //   318: invokevirtual 171	java/io/FileInputStream:close	()V
    //   321: goto +8 -> 329
    //   324: astore_3
    //   325: aload_3
    //   326: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   329: aload_0
    //   330: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   333: aload_0
    //   334: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   337: getfield 52	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   340: invokevirtual 178	java/security/MessageDigest:digest	()[B
    //   343: putfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   346: aload_0
    //   347: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   350: aload_0
    //   351: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   354: getfield 69	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   357: invokevirtual 178	java/security/MessageDigest:digest	()[B
    //   360: putfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   363: aload_0
    //   364: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   367: aload_0
    //   368: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   371: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   374: invokestatic 191	com/tencent/mobileqq/filemanager/util/FileManagerUtil:f	(Ljava/lang/String;)[B
    //   377: invokestatic 197	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   380: putfield 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   383: aload_0
    //   384: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   387: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   390: invokestatic 202	com/tencent/mobileqq/filemanager/util/FileManagerUtil:e	(Ljava/lang/String;)[B
    //   393: invokestatic 197	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   396: pop
    //   397: aload_0
    //   398: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   401: aconst_null
    //   402: putfield 52	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   405: aload_0
    //   406: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   409: aconst_null
    //   410: putfield 69	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   413: aload_0
    //   414: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   417: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   420: invokestatic 205	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)I
    //   423: ifne +56 -> 479
    //   426: new 207	android/graphics/BitmapFactory$Options
    //   429: dup
    //   430: invokespecial 208	android/graphics/BitmapFactory$Options:<init>	()V
    //   433: astore_3
    //   434: aload_3
    //   435: iconst_1
    //   436: putfield 211	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   439: aload_0
    //   440: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   443: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   446: aload_3
    //   447: invokestatic 216	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   450: pop
    //   451: aload_0
    //   452: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   455: aload_3
    //   456: getfield 219	android/graphics/BitmapFactory$Options:outWidth	I
    //   459: putfield 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   462: aload_0
    //   463: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   466: aload_3
    //   467: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
    //   470: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   473: goto +61 -> 534
    //   476: goto +58 -> 534
    //   479: aload_0
    //   480: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   483: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   486: invokestatic 205	com/tencent/mobileqq/filemanager/util/FileManagerUtil:c	(Ljava/lang/String;)I
    //   489: iconst_2
    //   490: if_icmpne +44 -> 534
    //   493: aload_0
    //   494: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   497: getfield 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   500: invokestatic 234	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoFileRtAndTime	(Ljava/lang/String;)[I
    //   503: astore_3
    //   504: aload_0
    //   505: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   508: aload_3
    //   509: iconst_0
    //   510: iaload
    //   511: putfield 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   514: aload_0
    //   515: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   518: aload_3
    //   519: iconst_1
    //   520: iaload
    //   521: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   524: aload_0
    //   525: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   528: aload_3
    //   529: iconst_2
    //   530: iaload
    //   531: putfield 237	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   534: aload_0
    //   535: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   538: aload_0
    //   539: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   542: invokevirtual 42	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   545: ifeq +4 -> 549
    //   548: return
    //   549: aload_0
    //   550: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   553: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   556: invokestatic 197	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   559: astore_3
    //   560: aload_0
    //   561: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   564: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   567: invokestatic 197	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   570: astore 4
    //   572: new 121	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   579: astore 5
    //   581: aload 5
    //   583: ldc 239
    //   585: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 5
    //   591: aload_3
    //   592: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 5
    //   598: ldc 241
    //   600: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload 5
    //   606: aload 4
    //   608: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 5
    //   614: ldc 243
    //   616: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 5
    //   622: aload_0
    //   623: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   626: getfield 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
    //   629: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 5
    //   635: ldc 245
    //   637: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 5
    //   643: aload_0
    //   644: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   647: getfield 222	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   650: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: aload 5
    //   656: ldc 250
    //   658: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 5
    //   664: aload_0
    //   665: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   668: getfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   671: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 5
    //   677: ldc 252
    //   679: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload 5
    //   685: aload_0
    //   686: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   689: getfield 237	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
    //   692: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 71
    //   698: iconst_1
    //   699: aload 5
    //   701: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_0
    //   708: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   711: aload_0
    //   712: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   715: invokevirtual 150	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   718: aload_0
    //   719: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   722: aload_0
    //   723: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   726: invokevirtual 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   729: return
    //   730: aload_0
    //   731: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   734: getfield 52	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   737: aload 4
    //   739: iconst_0
    //   740: iload_1
    //   741: invokevirtual 261	java/security/MessageDigest:update	([BII)V
    //   744: aload_0
    //   745: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   748: getfield 69	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   751: aload 4
    //   753: iconst_0
    //   754: iload_1
    //   755: invokevirtual 261	java/security/MessageDigest:update	([BII)V
    //   758: aload_0
    //   759: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   762: astore 5
    //   764: aload 5
    //   766: aload 5
    //   768: getfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   771: iload_1
    //   772: i2l
    //   773: ladd
    //   774: putfield 56	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   777: aload_0
    //   778: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   781: aload_0
    //   782: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   785: invokevirtual 42	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   788: istore_2
    //   789: iload_2
    //   790: ifeq -484 -> 306
    //   793: aload_3
    //   794: invokevirtual 171	java/io/FileInputStream:close	()V
    //   797: return
    //   798: astore_3
    //   799: aload_3
    //   800: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   803: return
    //   804: astore 4
    //   806: goto +45 -> 851
    //   809: astore 4
    //   811: aload 4
    //   813: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   816: aload_0
    //   817: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   820: aload_0
    //   821: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   824: iconst_3
    //   825: sipush 203
    //   828: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   831: getstatic 87	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   834: getstatic 264	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:j	I
    //   837: invokestatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   840: aload_3
    //   841: invokevirtual 171	java/io/FileInputStream:close	()V
    //   844: return
    //   845: astore_3
    //   846: aload_3
    //   847: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   850: return
    //   851: aload_3
    //   852: invokevirtual 171	java/io/FileInputStream:close	()V
    //   855: goto +8 -> 863
    //   858: astore_3
    //   859: aload_3
    //   860: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   863: aload 4
    //   865: athrow
    //   866: astore_3
    //   867: ldc 71
    //   869: iconst_1
    //   870: ldc_w 266
    //   873: aload_3
    //   874: invokestatic 79	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   877: aload_0
    //   878: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   881: aload_0
    //   882: getfield 38	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   885: iconst_3
    //   886: sipush 201
    //   889: invokevirtual 82	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   892: getstatic 87	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   895: getstatic 268	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:g	I
    //   898: invokestatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan
 * JD-Core Version:    0.7.0.1
 */