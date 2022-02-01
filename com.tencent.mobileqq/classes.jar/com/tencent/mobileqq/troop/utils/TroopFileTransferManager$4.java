package com.tencent.mobileqq.troop.utils;

import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;

class TroopFileTransferManager$4
  extends TroopFileReqUploadFileObserver
{
  TroopFileTransferManager$4(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt, tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload 4
    //   2: ldc 17
    //   4: invokevirtual 23	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   7: lstore 6
    //   9: ldc 25
    //   11: monitorenter
    //   12: invokestatic 28	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Ljava/util/Map;
    //   15: lload 6
    //   17: invokestatic 34	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: invokeinterface 40 2 0
    //   25: checkcast 25	com/tencent/mobileqq/troop/utils/TroopFileTransferManager
    //   28: astore 8
    //   30: aload 8
    //   32: ifnonnull +45 -> 77
    //   35: invokestatic 46	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   38: ifeq +35 -> 73
    //   41: new 48	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc 51
    //   52: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: lload 6
    //   59: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 60
    //   65: iconst_4
    //   66: aload_3
    //   67: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: ldc 25
    //   75: monitorexit
    //   76: return
    //   77: ldc 25
    //   79: monitorexit
    //   80: aload 4
    //   82: ldc 70
    //   84: invokevirtual 74	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 9
    //   89: aload 9
    //   91: ifnonnull +4 -> 95
    //   94: return
    //   95: aload 9
    //   97: invokestatic 80	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   100: astore 4
    //   102: aload 8
    //   104: monitorenter
    //   105: aload 8
    //   107: getfield 83	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   110: aload 4
    //   112: invokeinterface 40 2 0
    //   117: checkcast 85	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   120: astore 4
    //   122: aload 4
    //   124: ifnonnull +54 -> 178
    //   127: invokestatic 46	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   130: ifeq +35 -> 165
    //   133: new 48	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   140: astore_3
    //   141: aload_3
    //   142: ldc 87
    //   144: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_3
    //   149: aload 9
    //   151: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 60
    //   157: iconst_4
    //   158: aload_3
    //   159: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: getstatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   168: getstatic 96	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:r	I
    //   171: invokestatic 101	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   174: aload 8
    //   176: monitorexit
    //   177: return
    //   178: aload 8
    //   180: monitorexit
    //   181: iload_1
    //   182: ifne +148 -> 330
    //   185: aload_0
    //   186: getfield 105	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:mApp	Ljava/lang/ref/WeakReference;
    //   189: invokevirtual 110	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   192: checkcast 112	mqq/app/AppRuntime
    //   195: astore_3
    //   196: new 48	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   203: astore 8
    //   205: aload 8
    //   207: lload 6
    //   209: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 8
    //   215: ldc 114
    //   217: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_3
    //   222: ldc 116
    //   224: ldc 118
    //   226: ldc 114
    //   228: ldc 120
    //   230: ldc 122
    //   232: iconst_0
    //   233: iconst_0
    //   234: aload 8
    //   236: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: ldc 114
    //   241: ldc 114
    //   243: ldc 114
    //   245: invokestatic 127	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   248: new 129	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   251: dup
    //   252: aload 4
    //   254: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   261: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   264: iconst_3
    //   265: sipush 207
    //   268: invokespecial 140	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JII)V
    //   271: astore_3
    //   272: aload_0
    //   273: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   276: aload 4
    //   278: iconst_3
    //   279: aload_3
    //   280: invokevirtual 143	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;ILcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;)V
    //   283: invokestatic 46	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   286: ifeq +34 -> 320
    //   289: new 48	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   296: astore_3
    //   297: aload_3
    //   298: ldc 145
    //   300: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_3
    //   305: iload_2
    //   306: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: ldc 60
    //   312: iconst_2
    //   313: aload_3
    //   314: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 151	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: getstatic 93	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:b	I
    //   323: getstatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:A	I
    //   326: invokestatic 101	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   329: return
    //   330: aload_3
    //   331: getfield 160	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   334: invokevirtual 165	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   337: istore 5
    //   339: invokestatic 46	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   342: ifeq +26 -> 368
    //   345: ldc 60
    //   347: iconst_4
    //   348: ldc 167
    //   350: iconst_1
    //   351: anewarray 169	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: iload 5
    //   358: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: iload 5
    //   370: ifge +305 -> 675
    //   373: iload 5
    //   375: sipush -25126
    //   378: if_icmpeq +251 -> 629
    //   381: iload 5
    //   383: sipush -312
    //   386: if_icmpeq +236 -> 622
    //   389: iload 5
    //   391: sipush -136
    //   394: if_icmpeq +228 -> 622
    //   397: iload 5
    //   399: sipush -134
    //   402: if_icmpeq +213 -> 615
    //   405: iload 5
    //   407: bipush 149
    //   409: if_icmpeq +199 -> 608
    //   412: iload 5
    //   414: bipush 154
    //   416: if_icmpeq +192 -> 608
    //   419: iload 5
    //   421: bipush 220
    //   423: if_icmpeq +157 -> 580
    //   426: iload 5
    //   428: sipush -20001
    //   431: if_icmpeq +115 -> 546
    //   434: iload 5
    //   436: sipush -20000
    //   439: if_icmpeq +107 -> 546
    //   442: iload 5
    //   444: sipush -403
    //   447: if_icmpeq +99 -> 546
    //   450: iload 5
    //   452: sipush -402
    //   455: if_icmpeq +46 -> 501
    //   458: iload 5
    //   460: sipush -139
    //   463: if_icmpeq +31 -> 494
    //   466: iload 5
    //   468: sipush -138
    //   471: if_icmpeq +23 -> 494
    //   474: iload 5
    //   476: bipush 254
    //   478: if_icmpeq +130 -> 608
    //   481: iload 5
    //   483: iconst_m1
    //   484: if_icmpeq +131 -> 615
    //   487: sipush 207
    //   490: istore_2
    //   491: goto +142 -> 633
    //   494: sipush -138
    //   497: istore_2
    //   498: goto +135 -> 633
    //   501: aload_3
    //   502: getfield 186	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:str_client_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   505: invokevirtual 190	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   508: astore_3
    //   509: new 129	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   512: dup
    //   513: aload 4
    //   515: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   522: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   525: iconst_3
    //   526: sipush 704
    //   529: aload_3
    //   530: invokespecial 193	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JIILjava/lang/String;)V
    //   533: astore_3
    //   534: aload_0
    //   535: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   538: aload 4
    //   540: iconst_3
    //   541: aload_3
    //   542: invokevirtual 143	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;ILcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;)V
    //   545: return
    //   546: aload 4
    //   548: getfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   551: bipush 104
    //   553: if_icmpeq +20 -> 573
    //   556: aload 4
    //   558: bipush 104
    //   560: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   563: aload_0
    //   564: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   567: aload 4
    //   569: invokevirtual 199	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   572: return
    //   573: sipush 204
    //   576: istore_2
    //   577: goto +56 -> 633
    //   580: new 201	android/os/Handler
    //   583: dup
    //   584: invokestatic 207	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   587: invokespecial 210	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   590: new 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4$1
    //   593: dup
    //   594: aload_0
    //   595: aload 4
    //   597: invokespecial 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4$1:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$4;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   600: ldc2_w 216
    //   603: invokevirtual 221	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   606: pop
    //   607: return
    //   608: sipush 208
    //   611: istore_2
    //   612: goto +21 -> 633
    //   615: sipush 202
    //   618: istore_2
    //   619: goto +14 -> 633
    //   622: sipush -136
    //   625: istore_2
    //   626: goto +7 -> 633
    //   629: sipush 209
    //   632: istore_2
    //   633: new 129	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   636: dup
    //   637: aload 4
    //   639: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   642: aload_0
    //   643: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   646: getfield 137	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   649: iconst_3
    //   650: iload_2
    //   651: invokespecial 140	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JII)V
    //   654: astore_3
    //   655: aload_0
    //   656: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   659: aload 4
    //   661: iconst_3
    //   662: aload_3
    //   663: invokevirtual 143	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;ILcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;)V
    //   666: getstatic 224	com/tencent/mobileqq/troop/utils/TroopTechReportUtils$TroopFileReportResultCode:c	I
    //   669: iload 5
    //   671: invokestatic 101	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(II)V
    //   674: return
    //   675: aload 4
    //   677: aload_3
    //   678: getfield 227	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:str_file_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   681: invokevirtual 190	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   684: putfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   687: aload 4
    //   689: aload_3
    //   690: getfield 233	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:str_upload_ip	Lcom/tencent/mobileqq/pb/PBStringField;
    //   693: invokevirtual 190	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   696: putfield 236	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   699: aload 4
    //   701: aload_3
    //   702: getfield 240	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:bytes_check_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   705: invokevirtual 245	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   708: invokevirtual 251	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   711: putfield 255	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   714: aload 4
    //   716: aload_3
    //   717: getfield 259	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$UploadFileRspBody:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   720: invokevirtual 262	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   723: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   726: aload_0
    //   727: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   730: aload 4
    //   732: invokevirtual 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   735: ifne +28 -> 763
    //   738: aload_0
    //   739: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   742: getfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool	[Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool;
    //   745: iconst_2
    //   746: aaload
    //   747: new 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload
    //   750: dup
    //   751: aload_0
    //   752: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$4:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   755: aload 4
    //   757: invokespecial 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   760: invokevirtual 278	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Task;)V
    //   763: return
    //   764: astore_3
    //   765: aload 8
    //   767: monitorexit
    //   768: aload_3
    //   769: athrow
    //   770: astore_3
    //   771: ldc 25
    //   773: monitorexit
    //   774: aload_3
    //   775: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	776	0	this	4
    //   0	776	1	paramBoolean	boolean
    //   0	776	2	paramInt	int
    //   0	776	3	paramUploadFileRspBody	tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody
    //   0	776	4	paramBundle	android.os.Bundle
    //   337	333	5	i	int
    //   7	201	6	l	long
    //   28	738	8	localObject	java.lang.Object
    //   87	63	9	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   105	122	764	finally
    //   127	165	764	finally
    //   165	177	764	finally
    //   178	181	764	finally
    //   765	768	764	finally
    //   12	30	770	finally
    //   35	73	770	finally
    //   73	76	770	finally
    //   77	80	770	finally
    //   771	774	770	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.4
 * JD-Core Version:    0.7.0.1
 */