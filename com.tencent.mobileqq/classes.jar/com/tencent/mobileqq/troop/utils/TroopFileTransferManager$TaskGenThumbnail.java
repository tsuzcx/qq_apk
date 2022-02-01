package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskGenThumbnail
  extends TroopFileTransferManager.Task
{
  public int b;
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   4: getfield 28	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   7: invokestatic 33	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokestatic 38	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   18: astore 5
    //   20: aload 5
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   27: getfield 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   30: bipush 12
    //   32: if_icmpne +7 -> 39
    //   35: aload 5
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: aload_0
    //   44: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   47: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   50: aload_0
    //   51: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   54: invokevirtual 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   57: astore 8
    //   59: new 57	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   66: astore 6
    //   68: aload 6
    //   70: aload 8
    //   72: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 6
    //   78: ldc 66
    //   80: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 9
    //   91: aload 5
    //   93: monitorexit
    //   94: iconst_1
    //   95: istore_2
    //   96: iconst_1
    //   97: istore 4
    //   99: iconst_1
    //   100: istore_3
    //   101: iload_1
    //   102: iconst_2
    //   103: if_icmpne +510 -> 613
    //   106: aload_0
    //   107: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   110: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   113: astore 6
    //   115: aconst_null
    //   116: astore 7
    //   118: aconst_null
    //   119: astore 5
    //   121: aconst_null
    //   122: aload 6
    //   124: invokestatic 79	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   127: astore 10
    //   129: aload 10
    //   131: ifnull +357 -> 488
    //   134: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +82 -> 219
    //   140: new 57	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   147: astore 6
    //   149: aload 6
    //   151: ldc 87
    //   153: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 6
    //   159: aload_0
    //   160: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   163: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   166: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 6
    //   172: ldc 89
    //   174: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 6
    //   180: aload 10
    //   182: invokevirtual 95	android/graphics/Bitmap:getWidth	()I
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 6
    //   191: ldc 100
    //   193: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: aload 10
    //   201: invokevirtual 103	android/graphics/Bitmap:getHeight	()I
    //   204: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 105
    //   210: iconst_2
    //   211: aload 6
    //   213: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: new 111	java/io/File
    //   222: dup
    //   223: aload 9
    //   225: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: astore 6
    //   230: aload 6
    //   232: invokevirtual 117	java/io/File:exists	()Z
    //   235: ifeq +9 -> 244
    //   238: aload 6
    //   240: invokevirtual 120	java/io/File:delete	()Z
    //   243: pop
    //   244: aload 6
    //   246: invokevirtual 123	java/io/File:createNewFile	()Z
    //   249: pop
    //   250: goto +10 -> 260
    //   253: astore 11
    //   255: aload 11
    //   257: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   260: new 128	java/io/BufferedOutputStream
    //   263: dup
    //   264: new 130	java/io/FileOutputStream
    //   267: dup
    //   268: aload 6
    //   270: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: invokespecial 136	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   276: astore 6
    //   278: aload 10
    //   280: getstatic 142	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   283: bipush 100
    //   285: aload 6
    //   287: invokevirtual 146	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   290: pop
    //   291: aload 10
    //   293: invokevirtual 149	android/graphics/Bitmap:recycle	()V
    //   296: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +60 -> 359
    //   302: new 57	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   309: astore 5
    //   311: aload 5
    //   313: ldc 151
    //   315: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 5
    //   321: aload_0
    //   322: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   325: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   328: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 5
    //   334: ldc 153
    //   336: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 5
    //   342: aload 9
    //   344: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: ldc 105
    //   350: iconst_2
    //   351: aload 5
    //   353: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 6
    //   361: invokevirtual 156	java/io/BufferedOutputStream:flush	()V
    //   364: aload 6
    //   366: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   369: iload 4
    //   371: istore_2
    //   372: goto +412 -> 784
    //   375: astore 5
    //   377: goto +120 -> 497
    //   380: astore 5
    //   382: aload 5
    //   384: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   387: iload 4
    //   389: istore_2
    //   390: goto +394 -> 784
    //   393: astore 5
    //   395: iload_2
    //   396: istore_3
    //   397: goto +160 -> 557
    //   400: astore 5
    //   402: goto +63 -> 465
    //   405: astore 7
    //   407: goto +26 -> 433
    //   410: astore 7
    //   412: aload 5
    //   414: astore 6
    //   416: aload 7
    //   418: astore 5
    //   420: goto +45 -> 465
    //   423: astore 5
    //   425: aload 7
    //   427: astore 6
    //   429: aload 5
    //   431: astore 7
    //   433: aload 6
    //   435: astore 5
    //   437: aload 7
    //   439: invokevirtual 161	java/io/FileNotFoundException:printStackTrace	()V
    //   442: aload 6
    //   444: ifnull +44 -> 488
    //   447: aload 6
    //   449: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   452: goto +36 -> 488
    //   455: astore 5
    //   457: aload 5
    //   459: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   462: goto +26 -> 488
    //   465: aload 6
    //   467: ifnull +18 -> 485
    //   470: aload 6
    //   472: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   475: goto +10 -> 485
    //   478: astore 6
    //   480: aload 6
    //   482: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   485: aload 5
    //   487: athrow
    //   488: iconst_0
    //   489: istore_2
    //   490: goto +294 -> 784
    //   493: astore 5
    //   495: iconst_0
    //   496: istore_3
    //   497: iload_3
    //   498: istore_2
    //   499: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   502: ifeq +282 -> 784
    //   505: new 57	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   512: astore 6
    //   514: aload 6
    //   516: ldc 87
    //   518: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload 6
    //   524: aload_0
    //   525: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   528: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   531: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: ldc 105
    //   537: iconst_2
    //   538: aload 6
    //   540: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: aload 5
    //   545: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   548: iload_3
    //   549: istore_2
    //   550: goto +234 -> 784
    //   553: astore 5
    //   555: iconst_0
    //   556: istore_3
    //   557: iload_3
    //   558: istore_2
    //   559: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   562: ifeq +222 -> 784
    //   565: new 57	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   572: astore 6
    //   574: aload 6
    //   576: ldc 87
    //   578: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 6
    //   584: aload_0
    //   585: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   588: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   591: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: ldc 105
    //   597: iconst_2
    //   598: aload 6
    //   600: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: aload 5
    //   605: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   608: iload_3
    //   609: istore_2
    //   610: goto +174 -> 784
    //   613: aload_0
    //   614: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   617: istore_1
    //   618: iload_1
    //   619: sipush 383
    //   622: if_icmpeq +40 -> 662
    //   625: iload_1
    //   626: sipush 640
    //   629: if_icmpne +6 -> 635
    //   632: goto +30 -> 662
    //   635: aload_0
    //   636: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   639: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   642: astore 5
    //   644: aload_0
    //   645: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   648: istore_1
    //   649: aload 5
    //   651: aload 9
    //   653: iload_1
    //   654: iload_1
    //   655: invokestatic 169	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   658: istore_2
    //   659: goto +125 -> 784
    //   662: aload_0
    //   663: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   666: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   669: astore 5
    //   671: aload_0
    //   672: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   675: sipush 383
    //   678: if_icmpne +43 -> 721
    //   681: aload_0
    //   682: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   685: aload_0
    //   686: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   689: getfield 49	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   692: sipush 640
    //   695: invokevirtual 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   698: astore 6
    //   700: aload 6
    //   702: astore 5
    //   704: aload 6
    //   706: invokestatic 172	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   709: ifne +12 -> 721
    //   712: aload_0
    //   713: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   716: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   719: astore 5
    //   721: aload_0
    //   722: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   725: sipush 640
    //   728: if_icmpne +8 -> 736
    //   731: iconst_2
    //   732: istore_1
    //   733: goto +5 -> 738
    //   736: iconst_1
    //   737: istore_1
    //   738: aload 5
    //   740: invokestatic 172	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   743: ifeq -255 -> 488
    //   746: ldc 174
    //   748: invokestatic 180	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   751: checkcast 174	com/tencent/mobileqq/pic/api/ICompressOperator
    //   754: aload 5
    //   756: aload 9
    //   758: iconst_1
    //   759: ldc 182
    //   761: iload_1
    //   762: invokeinterface 186 6 0
    //   767: pop
    //   768: iload 4
    //   770: istore_2
    //   771: goto +13 -> 784
    //   774: astore 5
    //   776: aload 5
    //   778: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   781: goto -293 -> 488
    //   784: aload_0
    //   785: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   788: astore 5
    //   790: aload 5
    //   792: monitorenter
    //   793: iload_2
    //   794: ifeq +37 -> 831
    //   797: new 111	java/io/File
    //   800: dup
    //   801: aload 9
    //   803: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   806: astore 6
    //   808: aload 6
    //   810: new 111	java/io/File
    //   813: dup
    //   814: aload 8
    //   816: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   819: invokevirtual 190	java/io/File:renameTo	(Ljava/io/File;)Z
    //   822: pop
    //   823: aload 6
    //   825: invokevirtual 193	java/io/File:deleteOnExit	()V
    //   828: goto +79 -> 907
    //   831: new 111	java/io/File
    //   834: dup
    //   835: aload 9
    //   837: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   840: invokevirtual 120	java/io/File:delete	()Z
    //   843: pop
    //   844: aload_0
    //   845: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   848: getfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   851: ifnull +56 -> 907
    //   854: aload_0
    //   855: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   858: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   861: invokestatic 202	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   864: ifne +23 -> 887
    //   867: new 111	java/io/File
    //   870: dup
    //   871: aload_0
    //   872: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   875: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   878: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   881: invokevirtual 117	java/io/File:exists	()Z
    //   884: ifne +23 -> 907
    //   887: aload_0
    //   888: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   891: aload_0
    //   892: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   895: aload_0
    //   896: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   899: iconst_0
    //   900: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IZ)V
    //   903: aload 5
    //   905: monitorexit
    //   906: return
    //   907: aload_0
    //   908: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   911: sipush 128
    //   914: if_icmpne +14 -> 928
    //   917: aload_0
    //   918: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   921: iconst_0
    //   922: putfield 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   925: goto +42 -> 967
    //   928: aload_0
    //   929: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   932: sipush 640
    //   935: if_icmpne +14 -> 949
    //   938: aload_0
    //   939: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   942: iconst_0
    //   943: putfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   946: goto +21 -> 967
    //   949: aload_0
    //   950: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   953: sipush 383
    //   956: if_icmpne +11 -> 967
    //   959: aload_0
    //   960: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   963: iconst_0
    //   964: putfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
    //   967: aload_0
    //   968: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   971: aload_0
    //   972: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   975: aload_0
    //   976: getfield 51	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:b	I
    //   979: invokevirtual 218	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   982: pop
    //   983: aload_0
    //   984: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   987: lconst_0
    //   988: putfield 221	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   991: aload_0
    //   992: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   995: getfield 224	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	Ljava/util/Map;
    //   998: aload_0
    //   999: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1002: getfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   1005: invokeinterface 234 2 0
    //   1010: ifeq +14 -> 1024
    //   1013: aload_0
    //   1014: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1017: aload_0
    //   1018: getfield 22	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1021: invokevirtual 237	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1024: aload 5
    //   1026: monitorexit
    //   1027: return
    //   1028: astore 6
    //   1030: aload 5
    //   1032: monitorexit
    //   1033: aload 6
    //   1035: athrow
    //   1036: astore 6
    //   1038: aload 5
    //   1040: monitorexit
    //   1041: goto +6 -> 1047
    //   1044: aload 6
    //   1046: athrow
    //   1047: goto -3 -> 1044
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1050	0	this	TaskGenThumbnail
    //   13	749	1	i	int
    //   95	699	2	bool1	boolean
    //   100	509	3	bool2	boolean
    //   97	672	4	bool3	boolean
    //   18	334	5	localObject1	java.lang.Object
    //   375	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   380	3	5	localException1	java.lang.Exception
    //   393	1	5	localException2	java.lang.Exception
    //   400	13	5	localObject2	java.lang.Object
    //   418	1	5	localObject3	java.lang.Object
    //   423	7	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   435	1	5	localObject4	java.lang.Object
    //   455	31	5	localException3	java.lang.Exception
    //   493	51	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   553	51	5	localException4	java.lang.Exception
    //   642	113	5	localObject5	java.lang.Object
    //   774	3	5	localException5	java.lang.Exception
    //   788	251	5	localTroopFileTransferManager	TroopFileTransferManager
    //   66	405	6	localObject6	java.lang.Object
    //   478	3	6	localException6	java.lang.Exception
    //   512	312	6	localObject7	java.lang.Object
    //   1028	6	6	localObject8	java.lang.Object
    //   1036	9	6	localObject9	java.lang.Object
    //   116	1	7	localObject10	java.lang.Object
    //   405	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   410	16	7	localObject11	java.lang.Object
    //   431	7	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   57	758	8	str1	java.lang.String
    //   89	747	9	str2	java.lang.String
    //   127	165	10	localBitmap	android.graphics.Bitmap
    //   253	3	11	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   244	250	253	java/io/IOException
    //   364	369	375	java/lang/OutOfMemoryError
    //   382	387	375	java/lang/OutOfMemoryError
    //   364	369	380	java/lang/Exception
    //   382	387	393	java/lang/Exception
    //   278	359	400	finally
    //   359	364	400	finally
    //   278	359	405	java/io/FileNotFoundException
    //   359	364	405	java/io/FileNotFoundException
    //   260	278	410	finally
    //   437	442	410	finally
    //   260	278	423	java/io/FileNotFoundException
    //   447	452	455	java/lang/Exception
    //   470	475	478	java/lang/Exception
    //   106	115	493	java/lang/OutOfMemoryError
    //   121	129	493	java/lang/OutOfMemoryError
    //   134	219	493	java/lang/OutOfMemoryError
    //   219	244	493	java/lang/OutOfMemoryError
    //   244	250	493	java/lang/OutOfMemoryError
    //   255	260	493	java/lang/OutOfMemoryError
    //   447	452	493	java/lang/OutOfMemoryError
    //   457	462	493	java/lang/OutOfMemoryError
    //   470	475	493	java/lang/OutOfMemoryError
    //   480	485	493	java/lang/OutOfMemoryError
    //   485	488	493	java/lang/OutOfMemoryError
    //   106	115	553	java/lang/Exception
    //   121	129	553	java/lang/Exception
    //   134	219	553	java/lang/Exception
    //   219	244	553	java/lang/Exception
    //   244	250	553	java/lang/Exception
    //   255	260	553	java/lang/Exception
    //   457	462	553	java/lang/Exception
    //   480	485	553	java/lang/Exception
    //   485	488	553	java/lang/Exception
    //   738	768	774	java/lang/Exception
    //   797	828	1028	finally
    //   831	887	1028	finally
    //   887	906	1028	finally
    //   907	925	1028	finally
    //   928	946	1028	finally
    //   949	967	1028	finally
    //   967	1024	1028	finally
    //   1024	1027	1028	finally
    //   1030	1033	1028	finally
    //   23	38	1036	finally
    //   39	94	1036	finally
    //   1038	1041	1036	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskGenThumbnail
 * JD-Core Version:    0.7.0.1
 */