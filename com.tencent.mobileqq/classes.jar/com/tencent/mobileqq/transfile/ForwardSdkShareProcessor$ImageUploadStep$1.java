package com.tencent.mobileqq.transfile;

import axqq;

public class ForwardSdkShareProcessor$ImageUploadStep$1
  implements Runnable
{
  public ForwardSdkShareProcessor$ImageUploadStep$1(axqq paramaxqq) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: ldc 31
    //   8: iconst_2
    //   9: new 33	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   16: ldc 36
    //   18: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   25: invokestatic 45	axqq:a	(Laxqq;)I
    //   28: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   41: getfield 60	axqq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: invokevirtual 65	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   47: ifeq +11 -> 58
    //   50: aload_0
    //   51: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   54: invokevirtual 68	axqq:f	()V
    //   57: return
    //   58: aload_0
    //   59: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   62: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   65: getfield 76	axqk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   71: astore 14
    //   73: aload_0
    //   74: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   77: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   80: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   83: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   86: ifne +115 -> 201
    //   89: aload_0
    //   90: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   93: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   96: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   99: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +99 -> 201
    //   105: iconst_1
    //   106: istore_3
    //   107: iload_3
    //   108: ifeq +98 -> 206
    //   111: iconst_2
    //   112: istore_1
    //   113: iload_3
    //   114: ifeq +1732 -> 1846
    //   117: aload_0
    //   118: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   121: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   124: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   127: astore 12
    //   129: new 94	com/tencent/mobileqq/pic/CompressInfo
    //   132: dup
    //   133: aload 12
    //   135: iconst_0
    //   136: invokespecial 97	com/tencent/mobileqq/pic/CompressInfo:<init>	(Ljava/lang/String;I)V
    //   139: astore 11
    //   141: aload 11
    //   143: iconst_0
    //   144: putfield 100	com/tencent/mobileqq/pic/CompressInfo:f	I
    //   147: aload 11
    //   149: invokestatic 105	atqs:b	(Lcom/tencent/mobileqq/pic/CompressInfo;)Z
    //   152: pop
    //   153: aload 11
    //   155: getfield 109	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   158: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne +19 -> 180
    //   164: aload_0
    //   165: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   168: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   171: aload 11
    //   173: getfield 109	com/tencent/mobileqq/pic/CompressInfo:e	Ljava/lang/String;
    //   176: invokestatic 112	axqk:e	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   179: pop
    //   180: aload_0
    //   181: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   184: getfield 60	axqq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   187: invokevirtual 65	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   190: ifeq +21 -> 211
    //   193: aload_0
    //   194: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   197: invokevirtual 68	axqq:f	()V
    //   200: return
    //   201: iconst_0
    //   202: istore_3
    //   203: goto -96 -> 107
    //   206: iconst_4
    //   207: istore_1
    //   208: goto -95 -> 113
    //   211: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   214: lstore 7
    //   216: aconst_null
    //   217: astore 13
    //   219: new 120	java/io/File
    //   222: dup
    //   223: aload_0
    //   224: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   227: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   230: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   233: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   236: astore 11
    //   238: aload 11
    //   240: invokevirtual 126	java/io/File:exists	()Z
    //   243: ifeq +968 -> 1211
    //   246: aload 11
    //   248: invokevirtual 129	java/io/File:length	()J
    //   251: lstore 5
    //   253: aload_0
    //   254: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   257: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   260: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   263: invokestatic 134	bace:c	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 15
    //   268: aload 13
    //   270: astore 11
    //   272: lload 5
    //   274: lconst_0
    //   275: lcmp
    //   276: ifle +60 -> 336
    //   279: aload 13
    //   281: astore 11
    //   283: aload 15
    //   285: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +48 -> 336
    //   291: ldc 136
    //   293: iconst_2
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload 15
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: lload 5
    //   306: invokestatic 142	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   309: aastore
    //   310: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   313: sipush 1007
    //   316: invokestatic 153	bcdx:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   319: aload 14
    //   321: aload_0
    //   322: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   325: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   328: invokestatic 155	axqk:f	(Laxqk;)Ljava/lang/String;
    //   331: invokestatic 160	mpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/util/Pair;
    //   334: astore 11
    //   336: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   339: lload 7
    //   341: lsub
    //   342: lstore 5
    //   344: aload 11
    //   346: ifnonnull +2018 -> 2364
    //   349: new 162	com/tencent/util/Pair
    //   352: dup
    //   353: iconst_m1
    //   354: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: ldc 169
    //   359: invokespecial 172	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   362: astore 11
    //   364: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +58 -> 425
    //   370: ldc 31
    //   372: iconst_2
    //   373: new 33	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   380: ldc 174
    //   382: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 11
    //   387: getfield 178	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   390: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   393: ldc 183
    //   395: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: lload 5
    //   400: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: ldc 188
    //   405: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 11
    //   410: getfield 191	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   413: checkcast 144	java/lang/String
    //   416: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: new 193	android/os/Bundle
    //   428: dup
    //   429: invokespecial 194	android/os/Bundle:<init>	()V
    //   432: astore 13
    //   434: aload 13
    //   436: ldc 196
    //   438: ldc 198
    //   440: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: aload 13
    //   445: ldc 204
    //   447: ldc 206
    //   449: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload 13
    //   454: ldc 208
    //   456: new 33	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   463: ldc 169
    //   465: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 11
    //   470: getfield 178	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   473: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: new 33	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   489: ldc 169
    //   491: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 15
    //   496: aload 11
    //   498: getfield 178	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   501: checkcast 164	java/lang/Integer
    //   504: invokevirtual 212	java/lang/Integer:intValue	()I
    //   507: iconst_m1
    //   508: if_icmpne +709 -> 1217
    //   511: iconst_0
    //   512: istore_3
    //   513: aload 13
    //   515: ldc 214
    //   517: aload 15
    //   519: iload_3
    //   520: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload 13
    //   531: ldc 216
    //   533: new 33	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   540: ldc 169
    //   542: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: lload 5
    //   547: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   550: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: invokestatic 221	bcad:a	()Lbcad;
    //   559: aload 13
    //   561: ldc 169
    //   563: aload 14
    //   565: iconst_0
    //   566: invokevirtual 224	bcad:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   569: iconst_0
    //   570: istore 10
    //   572: aload 11
    //   574: getfield 191	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   577: checkcast 226	java/lang/CharSequence
    //   580: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +649 -> 1232
    //   586: iconst_1
    //   587: istore 9
    //   589: aload_0
    //   590: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   593: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   596: aload 11
    //   598: getfield 191	com/tencent/util/Pair:second	Ljava/lang/Object;
    //   601: checkcast 144	java/lang/String
    //   604: invokestatic 228	axqk:c	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   607: pop
    //   608: aload_0
    //   609: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   612: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   615: invokestatic 231	axqk:b	(Laxqk;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   618: iconst_1
    //   619: invokevirtual 235	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   622: iconst_0
    //   623: istore_3
    //   624: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   627: lload 7
    //   629: lsub
    //   630: lstore 5
    //   632: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +93 -> 728
    //   638: new 33	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   645: ldc 237
    //   647: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: iload 9
    //   652: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   655: ldc 183
    //   657: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: lload 5
    //   662: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: ldc 242
    //   667: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_0
    //   671: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   674: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   677: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   680: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc 244
    //   685: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_0
    //   689: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   692: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   695: invokestatic 246	axqk:e	(Laxqk;)Ljava/lang/String;
    //   698: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: astore 11
    //   706: iload 9
    //   708: ifeq +12 -> 720
    //   711: lload 5
    //   713: ldc2_w 247
    //   716: lcmp
    //   717: ifle +956 -> 1673
    //   720: ldc 31
    //   722: iconst_2
    //   723: aload 11
    //   725: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: iload 9
    //   730: ifne +43 -> 773
    //   733: ldc 31
    //   735: iconst_1
    //   736: new 33	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   743: ldc 252
    //   745: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: iload_3
    //   749: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: ldc 254
    //   754: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_0
    //   758: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   761: invokestatic 45	axqq:a	(Laxqq;)I
    //   764: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   770: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   773: new 193	android/os/Bundle
    //   776: dup
    //   777: invokespecial 194	android/os/Bundle:<init>	()V
    //   780: astore 11
    //   782: aload 11
    //   784: ldc 196
    //   786: ldc 198
    //   788: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   791: aload 11
    //   793: ldc 204
    //   795: ldc_w 256
    //   798: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: new 33	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   808: ldc 169
    //   810: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: astore 13
    //   815: iload 9
    //   817: ifeq +867 -> 1684
    //   820: iconst_0
    //   821: istore 4
    //   823: aload 11
    //   825: ldc 208
    //   827: aload 13
    //   829: iload 4
    //   831: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload 11
    //   842: ldc 214
    //   844: new 33	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   851: ldc 169
    //   853: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: iload_3
    //   857: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   866: aload 11
    //   868: ldc_w 258
    //   871: ldc_w 260
    //   874: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload 11
    //   879: ldc 216
    //   881: new 33	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   888: ldc 169
    //   890: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: lload 5
    //   895: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   898: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   904: iload 9
    //   906: ifne +39 -> 945
    //   909: aload 11
    //   911: ldc_w 262
    //   914: aload_0
    //   915: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   918: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   921: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   924: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload 11
    //   929: ldc_w 264
    //   932: aload_0
    //   933: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   936: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   939: invokestatic 246	axqk:e	(Laxqk;)Ljava/lang/String;
    //   942: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: invokestatic 221	bcad:a	()Lbcad;
    //   948: aload 11
    //   950: ldc 169
    //   952: aload 14
    //   954: iconst_0
    //   955: invokevirtual 224	bcad:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   958: iload 9
    //   960: ifeq +775 -> 1735
    //   963: iconst_1
    //   964: istore_2
    //   965: new 120	java/io/File
    //   968: dup
    //   969: aload 12
    //   971: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   974: invokevirtual 268	java/io/File:toURL	()Ljava/net/URL;
    //   977: invokevirtual 271	java/net/URL:toString	()Ljava/lang/String;
    //   980: astore 11
    //   982: iconst_1
    //   983: aload 11
    //   985: aload_0
    //   986: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   989: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   992: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   995: aload_0
    //   996: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   999: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1002: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   1005: invokestatic 274	bcdx:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1008: aload_0
    //   1009: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1012: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1015: getfield 76	axqk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1018: invokevirtual 277	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1021: aload_0
    //   1022: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1025: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1028: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1031: getfield 284	axvt:c	Ljava/lang/String;
    //   1034: aload_0
    //   1035: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1038: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1041: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1044: getfield 286	axvt:jdField_a_of_type_Int	I
    //   1047: aload_0
    //   1048: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1051: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1054: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1057: getfield 289	axvt:jdField_a_of_type_Long	J
    //   1060: invokevirtual 294	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1063: astore 11
    //   1065: aload 11
    //   1067: ifnull +122 -> 1189
    //   1070: aload 11
    //   1072: instanceof 296
    //   1075: ifeq +114 -> 1189
    //   1078: aload 11
    //   1080: checkcast 296	com/tencent/mobileqq/data/MessageForStructing
    //   1083: getfield 300	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1086: instanceof 302
    //   1089: ifeq +100 -> 1189
    //   1092: aload 11
    //   1094: checkcast 296	com/tencent/mobileqq/data/MessageForStructing
    //   1097: getfield 300	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1100: checkcast 302	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   1103: astore 11
    //   1105: aload 11
    //   1107: aload_0
    //   1108: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1111: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1114: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   1117: invokevirtual 305	com/tencent/mobileqq/structmsg/AbsShareMsg:updateCover	(Ljava/lang/String;)V
    //   1120: aload 11
    //   1122: getfield 309	com/tencent/mobileqq/structmsg/AbsShareMsg:shareData	Lcom/tencent/mobileqq/structmsg/AbsShareMsg$ShareData;
    //   1125: iload_2
    //   1126: putfield 315	com/tencent/mobileqq/structmsg/AbsShareMsg$ShareData:imageUrlStatus	B
    //   1129: aload_0
    //   1130: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1133: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1136: getfield 76	axqk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1139: invokevirtual 277	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1142: aload_0
    //   1143: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1146: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1149: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1152: getfield 284	axvt:c	Ljava/lang/String;
    //   1155: aload_0
    //   1156: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1159: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1162: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1165: getfield 286	axvt:jdField_a_of_type_Int	I
    //   1168: aload_0
    //   1169: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1172: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1175: getfield 280	axqk:jdField_a_of_type_Axvt	Laxvt;
    //   1178: getfield 289	axvt:jdField_a_of_type_Long	J
    //   1181: aload 11
    //   1183: invokevirtual 319	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   1186: invokevirtual 322	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ[B)V
    //   1189: aload_0
    //   1190: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1193: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1196: invokestatic 324	axqk:a	(Laxqk;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1199: iconst_1
    //   1200: invokevirtual 235	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1203: aload_0
    //   1204: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1207: invokevirtual 326	axqq:b	()V
    //   1210: return
    //   1211: lconst_0
    //   1212: lstore 5
    //   1214: goto -961 -> 253
    //   1217: aload 11
    //   1219: getfield 178	com/tencent/util/Pair:first	Ljava/lang/Object;
    //   1222: checkcast 164	java/lang/Integer
    //   1225: invokevirtual 212	java/lang/Integer:intValue	()I
    //   1228: istore_3
    //   1229: goto -716 -> 513
    //   1232: aload_0
    //   1233: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1236: getfield 60	axqq:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1239: invokevirtual 65	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1242: ifeq +11 -> 1253
    //   1245: aload_0
    //   1246: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1249: invokevirtual 68	axqq:f	()V
    //   1252: return
    //   1253: new 328	java/util/HashMap
    //   1256: dup
    //   1257: invokespecial 329	java/util/HashMap:<init>	()V
    //   1260: astore 15
    //   1262: aload 15
    //   1264: ldc_w 331
    //   1267: ldc_w 333
    //   1270: invokeinterface 339 3 0
    //   1275: pop
    //   1276: aload 15
    //   1278: ldc_w 341
    //   1281: ldc_w 343
    //   1284: invokeinterface 339 3 0
    //   1289: pop
    //   1290: aload 15
    //   1292: ldc_w 345
    //   1295: ldc_w 347
    //   1298: invokeinterface 339 3 0
    //   1303: pop
    //   1304: invokestatic 353	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1307: invokevirtual 357	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1310: iconst_2
    //   1311: invokevirtual 363	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1314: checkcast 365	mqq/manager/TicketManager
    //   1317: aload 14
    //   1319: ldc_w 347
    //   1322: invokeinterface 369 3 0
    //   1327: astore 11
    //   1329: aload 11
    //   1331: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1334: ifne +46 -> 1380
    //   1337: aload 15
    //   1339: ldc_w 371
    //   1342: new 33	java/lang/StringBuilder
    //   1345: dup
    //   1346: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1349: ldc_w 373
    //   1352: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: aload 14
    //   1357: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: ldc_w 375
    //   1363: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: aload 11
    //   1368: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1374: invokeinterface 339 3 0
    //   1379: pop
    //   1380: new 328	java/util/HashMap
    //   1383: dup
    //   1384: invokespecial 329	java/util/HashMap:<init>	()V
    //   1387: astore 16
    //   1389: aload 16
    //   1391: ldc_w 377
    //   1394: aload_0
    //   1395: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1398: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1401: invokestatic 84	axqk:b	(Laxqk;)Ljava/lang/String;
    //   1404: invokeinterface 339 3 0
    //   1409: pop
    //   1410: new 193	android/os/Bundle
    //   1413: dup
    //   1414: invokespecial 194	android/os/Bundle:<init>	()V
    //   1417: astore 11
    //   1419: aload 11
    //   1421: ldc 196
    //   1423: ldc 198
    //   1425: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1428: aload 11
    //   1430: ldc 204
    //   1432: ldc_w 379
    //   1435: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1438: aload 11
    //   1440: ldc_w 258
    //   1443: ldc_w 260
    //   1446: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1449: aload 11
    //   1451: ldc_w 264
    //   1454: aload_0
    //   1455: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1458: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1461: invokestatic 246	axqk:e	(Laxqk;)Ljava/lang/String;
    //   1464: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1467: invokestatic 221	bcad:a	()Lbcad;
    //   1470: aload 11
    //   1472: ldc 169
    //   1474: aload 14
    //   1476: iconst_0
    //   1477: invokevirtual 224	bcad:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1480: ldc_w 381
    //   1483: sipush 1007
    //   1486: invokestatic 153	bcdx:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   1489: aload 14
    //   1491: aload_0
    //   1492: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1495: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1498: invokestatic 155	axqk:f	(Laxqk;)Ljava/lang/String;
    //   1501: aconst_null
    //   1502: aload 16
    //   1504: aload 15
    //   1506: invokestatic 384	mpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   1509: astore 13
    //   1511: aload 13
    //   1513: astore 11
    //   1515: aload 13
    //   1517: ifnonnull +28 -> 1545
    //   1520: ldc_w 381
    //   1523: aload 14
    //   1525: aload_0
    //   1526: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1529: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1532: invokestatic 155	axqk:f	(Laxqk;)Ljava/lang/String;
    //   1535: aconst_null
    //   1536: aload 16
    //   1538: aload 15
    //   1540: invokestatic 384	mpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   1543: astore 11
    //   1545: aload 11
    //   1547: ifnull +808 -> 2355
    //   1550: new 386	org/json/JSONObject
    //   1553: dup
    //   1554: aload 11
    //   1556: invokespecial 387	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1559: astore 11
    //   1561: aload 11
    //   1563: ldc_w 389
    //   1566: invokevirtual 393	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1569: istore_3
    //   1570: iload_3
    //   1571: ifne +778 -> 2349
    //   1574: aload 11
    //   1576: ldc_w 395
    //   1579: invokevirtual 399	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1582: ifeq +767 -> 2349
    //   1585: aload 11
    //   1587: ldc_w 395
    //   1590: invokevirtual 403	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1593: astore 11
    //   1595: aload_0
    //   1596: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1599: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1602: aload 11
    //   1604: ldc_w 405
    //   1607: invokevirtual 408	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1610: invokestatic 228	axqk:c	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   1613: pop
    //   1614: aload_0
    //   1615: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1618: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1621: invokestatic 231	axqk:b	(Laxqk;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1624: iconst_1
    //   1625: invokevirtual 235	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1628: iconst_1
    //   1629: istore 9
    //   1631: goto -1007 -> 624
    //   1634: astore 11
    //   1636: iconst_0
    //   1637: istore 4
    //   1639: iload 4
    //   1641: istore_3
    //   1642: iload 10
    //   1644: istore 9
    //   1646: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1649: ifeq -1025 -> 624
    //   1652: ldc 31
    //   1654: iconst_2
    //   1655: aload 11
    //   1657: invokevirtual 411	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   1660: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1663: iload 4
    //   1665: istore_3
    //   1666: iload 10
    //   1668: istore 9
    //   1670: goto -1046 -> 624
    //   1673: ldc 31
    //   1675: iconst_2
    //   1676: aload 11
    //   1678: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1681: goto -953 -> 728
    //   1684: iconst_1
    //   1685: istore 4
    //   1687: goto -864 -> 823
    //   1690: astore 11
    //   1692: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1695: ifeq +33 -> 1728
    //   1698: ldc 31
    //   1700: iconst_2
    //   1701: new 33	java/lang/StringBuilder
    //   1704: dup
    //   1705: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1708: ldc_w 413
    //   1711: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: aload 11
    //   1716: invokevirtual 414	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1719: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1725: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1728: aload 12
    //   1730: astore 11
    //   1732: goto -750 -> 982
    //   1735: iload_3
    //   1736: ldc_w 415
    //   1739: if_icmpne +63 -> 1802
    //   1742: aload_0
    //   1743: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1746: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1749: invokestatic 418	axqk:c	(Laxqk;)I
    //   1752: iconst_2
    //   1753: if_icmpge +49 -> 1802
    //   1756: aload_0
    //   1757: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1760: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1763: invokestatic 420	axqk:d	(Laxqk;)I
    //   1766: pop
    //   1767: aload_0
    //   1768: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1771: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1774: aconst_null
    //   1775: invokestatic 422	axqk:d	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   1778: pop
    //   1779: aload_0
    //   1780: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1783: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1786: iconst_1
    //   1787: invokestatic 425	axqk:a	(Laxqk;Z)Z
    //   1790: pop
    //   1791: aload_0
    //   1792: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1795: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1798: invokestatic 428	axqk:a	(Laxqk;)V
    //   1801: return
    //   1802: aload_0
    //   1803: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1806: invokestatic 430	axqq:b	(Laxqq;)I
    //   1809: iconst_2
    //   1810: if_icmpge +12 -> 1822
    //   1813: aload_0
    //   1814: bipush 8
    //   1816: aconst_null
    //   1817: iconst_1
    //   1818: invokestatic 436	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1821: return
    //   1822: aload_0
    //   1823: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1826: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1829: sipush 9402
    //   1832: ldc_w 438
    //   1835: invokevirtual 441	axqk:b	(ILjava/lang/String;)V
    //   1838: aload_0
    //   1839: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1842: invokevirtual 443	axqq:c	()V
    //   1845: return
    //   1846: iload_1
    //   1847: istore_2
    //   1848: aload_0
    //   1849: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1852: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1855: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   1858: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1861: ifne -853 -> 1008
    //   1864: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   1867: lstore 5
    //   1869: aload_0
    //   1870: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   1873: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   1876: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   1879: aload 14
    //   1881: invokestatic 446	bcdx:a	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;
    //   1884: astore 11
    //   1886: aload 11
    //   1888: iconst_0
    //   1889: aaload
    //   1890: checkcast 164	java/lang/Integer
    //   1893: invokevirtual 212	java/lang/Integer:intValue	()I
    //   1896: istore_3
    //   1897: aload 11
    //   1899: iconst_1
    //   1900: aaload
    //   1901: checkcast 448	java/lang/Boolean
    //   1904: invokevirtual 451	java/lang/Boolean:booleanValue	()Z
    //   1907: istore 9
    //   1909: aload 11
    //   1911: iconst_2
    //   1912: aaload
    //   1913: checkcast 144	java/lang/String
    //   1916: astore 12
    //   1918: invokestatic 118	java/lang/System:currentTimeMillis	()J
    //   1921: lload 5
    //   1923: lsub
    //   1924: lstore 5
    //   1926: invokestatic 454	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1929: ifeq +60 -> 1989
    //   1932: ldc 31
    //   1934: iconst_4
    //   1935: new 33	java/lang/StringBuilder
    //   1938: dup
    //   1939: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1942: ldc_w 456
    //   1945: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: iload_3
    //   1949: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1952: ldc_w 458
    //   1955: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: iload 9
    //   1960: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1963: ldc 188
    //   1965: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: aload 12
    //   1970: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: ldc 183
    //   1975: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: lload 5
    //   1980: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1983: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1986: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1989: new 193	android/os/Bundle
    //   1992: dup
    //   1993: invokespecial 194	android/os/Bundle:<init>	()V
    //   1996: astore 13
    //   1998: aload 13
    //   2000: ldc 196
    //   2002: ldc 198
    //   2004: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2007: aload 13
    //   2009: ldc 204
    //   2011: ldc_w 460
    //   2014: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2017: aload 13
    //   2019: ldc 208
    //   2021: new 33	java/lang/StringBuilder
    //   2024: dup
    //   2025: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   2028: ldc 169
    //   2030: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: iload_3
    //   2034: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2037: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2040: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2043: iload 9
    //   2045: ifeq +204 -> 2249
    //   2048: ldc_w 462
    //   2051: astore 11
    //   2053: aload 13
    //   2055: ldc 214
    //   2057: aload 11
    //   2059: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2062: aload 13
    //   2064: ldc_w 258
    //   2067: ldc_w 462
    //   2070: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2073: aload 13
    //   2075: ldc 216
    //   2077: new 33	java/lang/StringBuilder
    //   2080: dup
    //   2081: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   2084: ldc 169
    //   2086: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: lload 5
    //   2091: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2094: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2097: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2100: aload 13
    //   2102: ldc_w 262
    //   2105: aload_0
    //   2106: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2109: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2112: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   2115: invokevirtual 202	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2118: invokestatic 221	bcad:a	()Lbcad;
    //   2121: aload 13
    //   2123: ldc 169
    //   2125: aload_0
    //   2126: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2129: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2132: getfield 76	axqk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2135: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2138: iconst_0
    //   2139: invokevirtual 224	bcad:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2142: iload 9
    //   2144: ifeq +113 -> 2257
    //   2147: aload_0
    //   2148: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2151: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2154: invokestatic 465	axqk:a	(Laxqk;)Laxqr;
    //   2157: ifnull +100 -> 2257
    //   2160: aload_0
    //   2161: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2164: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2167: invokestatic 465	axqk:a	(Laxqk;)Laxqr;
    //   2170: getfield 470	axqr:a	Z
    //   2173: ifne +84 -> 2257
    //   2176: aload_0
    //   2177: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2180: invokevirtual 68	axqq:f	()V
    //   2183: aload_0
    //   2184: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2187: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2190: getfield 473	axqk:jdField_a_of_type_Axos	Laxos;
    //   2193: getfield 478	axos:a	Laxot;
    //   2196: new 480	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1$1
    //   2199: dup
    //   2200: aload_0
    //   2201: invokespecial 483	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1$1:<init>	(Lcom/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1;)V
    //   2204: invokevirtual 488	axot:post	(Ljava/lang/Runnable;)Z
    //   2207: pop
    //   2208: return
    //   2209: astore 11
    //   2211: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2214: ifeq +30 -> 2244
    //   2217: ldc 31
    //   2219: iconst_2
    //   2220: new 33	java/lang/StringBuilder
    //   2223: dup
    //   2224: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   2227: ldc_w 490
    //   2230: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2233: aload 11
    //   2235: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2238: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2241: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2244: iload_1
    //   2245: istore_2
    //   2246: goto -1238 -> 1008
    //   2249: ldc_w 260
    //   2252: astore 11
    //   2254: goto -201 -> 2053
    //   2257: iload_3
    //   2258: ifne +61 -> 2319
    //   2261: aload 12
    //   2263: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2266: istore 9
    //   2268: iload 9
    //   2270: ifne +49 -> 2319
    //   2273: iconst_0
    //   2274: aload_0
    //   2275: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2278: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2281: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   2284: aload_0
    //   2285: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2288: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2291: invokestatic 92	axqk:a	(Laxqk;)Ljava/lang/String;
    //   2294: aload 12
    //   2296: invokestatic 274	bcdx:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2299: aload_0
    //   2300: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2303: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2306: aload 12
    //   2308: invokestatic 228	axqk:c	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   2311: pop
    //   2312: iconst_3
    //   2313: istore_1
    //   2314: iload_1
    //   2315: istore_2
    //   2316: goto -1308 -> 1008
    //   2319: aload_0
    //   2320: getfield 12	com/tencent/mobileqq/transfile/ForwardSdkShareProcessor$ImageUploadStep$1:a	Laxqq;
    //   2323: getfield 71	axqq:jdField_b_of_type_Axqk	Laxqk;
    //   2326: aconst_null
    //   2327: invokestatic 228	axqk:c	(Laxqk;Ljava/lang/String;)Ljava/lang/String;
    //   2330: pop
    //   2331: goto -17 -> 2314
    //   2334: astore 11
    //   2336: iconst_3
    //   2337: istore_1
    //   2338: goto -127 -> 2211
    //   2341: astore 11
    //   2343: iload_3
    //   2344: istore 4
    //   2346: goto -707 -> 1639
    //   2349: iconst_0
    //   2350: istore 9
    //   2352: goto -721 -> 1631
    //   2355: iconst_0
    //   2356: istore_3
    //   2357: iload 10
    //   2359: istore 9
    //   2361: goto -1737 -> 624
    //   2364: goto -2000 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2367	0	this	1
    //   112	2226	1	b1	byte
    //   964	1352	2	b2	byte
    //   106	2251	3	i	int
    //   821	1524	4	j	int
    //   251	1839	5	l1	long
    //   214	414	7	l2	long
    //   587	1773	9	bool1	boolean
    //   570	1788	10	bool2	boolean
    //   139	1464	11	localObject1	Object
    //   1634	43	11	localJSONException1	org.json.JSONException
    //   1690	25	11	localMalformedURLException	java.net.MalformedURLException
    //   1730	328	11	localObject2	Object
    //   2209	25	11	localException1	java.lang.Exception
    //   2252	1	11	str1	java.lang.String
    //   2334	1	11	localException2	java.lang.Exception
    //   2341	1	11	localJSONException2	org.json.JSONException
    //   127	2180	12	str2	java.lang.String
    //   217	1905	13	localObject3	Object
    //   71	1809	14	str3	java.lang.String
    //   266	1273	15	localObject4	Object
    //   1387	150	16	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   1550	1570	1634	org/json/JSONException
    //   965	982	1690	java/net/MalformedURLException
    //   1864	1989	2209	java/lang/Exception
    //   1989	2043	2209	java/lang/Exception
    //   2053	2142	2209	java/lang/Exception
    //   2147	2208	2209	java/lang/Exception
    //   2261	2268	2209	java/lang/Exception
    //   2319	2331	2209	java/lang/Exception
    //   2273	2312	2334	java/lang/Exception
    //   1574	1628	2341	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep.1
 * JD-Core Version:    0.7.0.1
 */