package com.tencent.mobileqq.troop.utils;

import com.tencent.biz.troop.file.protocol.TroopFileReqResendFileObserver;

class TroopFileTransferManager$3
  extends TroopFileReqResendFileObserver
{
  TroopFileTransferManager$3(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  /* Error */
  public void a(boolean paramBoolean, int paramInt, tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody paramResendRspBody, android.os.Bundle paramBundle)
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
    //   87: astore 4
    //   89: aload 4
    //   91: ifnonnull +4 -> 95
    //   94: return
    //   95: aload 4
    //   97: invokestatic 80	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   100: astore 9
    //   102: aload 8
    //   104: monitorenter
    //   105: aload 8
    //   107: getfield 83	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   110: aload 9
    //   112: invokeinterface 40 2 0
    //   117: checkcast 85	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   120: astore 9
    //   122: aload 9
    //   124: ifnonnull +45 -> 169
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
    //   149: aload 4
    //   151: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: ldc 60
    //   157: iconst_4
    //   158: aload_3
    //   159: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 68	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 8
    //   167: monitorexit
    //   168: return
    //   169: aload 8
    //   171: monitorexit
    //   172: iload_1
    //   173: ifne +76 -> 249
    //   176: new 89	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   179: dup
    //   180: aload 9
    //   182: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   189: getfield 97	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   192: iconst_3
    //   193: sipush 207
    //   196: invokespecial 100	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JII)V
    //   199: astore_3
    //   200: aload_0
    //   201: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   204: aload 9
    //   206: iconst_3
    //   207: aload_3
    //   208: invokevirtual 103	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;ILcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;)V
    //   211: invokestatic 46	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   214: ifeq +34 -> 248
    //   217: new 48	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   224: astore_3
    //   225: aload_3
    //   226: ldc 105
    //   228: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_3
    //   233: iload_2
    //   234: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 60
    //   240: iconst_2
    //   241: aload_3
    //   242: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 111	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: return
    //   249: aload_3
    //   250: getfield 117	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$ResendRspBody:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   253: invokevirtual 122	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   256: ifge +186 -> 442
    //   259: iconst_1
    //   260: istore_2
    //   261: aload_3
    //   262: getfield 117	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$ResendRspBody:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   265: invokevirtual 122	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   268: istore 5
    //   270: iload 5
    //   272: sipush -312
    //   275: if_icmpeq +142 -> 417
    //   278: iload 5
    //   280: sipush -136
    //   283: if_icmpeq +134 -> 417
    //   286: iload 5
    //   288: bipush 149
    //   290: if_icmpeq +121 -> 411
    //   293: iload 5
    //   295: sipush -139
    //   298: if_icmpeq +97 -> 395
    //   301: iload 5
    //   303: sipush -138
    //   306: if_icmpeq +89 -> 395
    //   309: iload 5
    //   311: bipush 153
    //   313: if_icmpeq +60 -> 373
    //   316: iload 5
    //   318: bipush 154
    //   320: if_icmpeq +91 -> 411
    //   323: iload 5
    //   325: bipush 254
    //   327: if_icmpeq +40 -> 367
    //   330: iload 5
    //   332: iconst_m1
    //   333: if_icmpeq +78 -> 411
    //   336: iload 5
    //   338: tableswitch	default:+26 -> 364, -303:+29->367, -302:+35->373, -301:+35->373
    //   365: nop
    //   366: lstore_3
    //   367: bipush 102
    //   369: istore_2
    //   370: goto +60 -> 430
    //   373: aload_0
    //   374: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   377: aload 9
    //   379: sipush 206
    //   382: invokestatic 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   385: aload_0
    //   386: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   389: aload 9
    //   391: invokestatic 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   394: return
    //   395: aload_0
    //   396: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   399: aload 9
    //   401: invokestatic 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   404: sipush -138
    //   407: istore_2
    //   408: goto +22 -> 430
    //   411: bipush 101
    //   413: istore_2
    //   414: goto +16 -> 430
    //   417: aload_0
    //   418: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   421: aload 9
    //   423: invokestatic 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   426: sipush -136
    //   429: istore_2
    //   430: aload_0
    //   431: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   434: aload 9
    //   436: iconst_3
    //   437: iload_2
    //   438: invokevirtual 131	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   441: return
    //   442: aload 9
    //   444: aload_3
    //   445: getfield 135	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$ResendRspBody:str_upload_ip	Lcom/tencent/mobileqq/pb/PBStringField;
    //   448: invokevirtual 139	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   451: putfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
    //   454: aload 9
    //   456: aload_3
    //   457: getfield 146	tencent/im/oidb/cmd0x6d6/oidb_0x6d6$ResendRspBody:bytes_check_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   460: invokevirtual 151	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   463: invokevirtual 157	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   466: putfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
    //   469: aload_0
    //   470: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   473: aload 9
    //   475: invokevirtual 165	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   478: ifne +28 -> 506
    //   481: aload_0
    //   482: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   485: getfield 168	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool	[Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool;
    //   488: iconst_2
    //   489: aaload
    //   490: new 170	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload
    //   493: dup
    //   494: aload_0
    //   495: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   498: aload 9
    //   500: invokespecial 172	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   503: invokevirtual 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Task;)V
    //   506: return
    //   507: astore_3
    //   508: aload 8
    //   510: monitorexit
    //   511: aload_3
    //   512: athrow
    //   513: astore_3
    //   514: ldc 25
    //   516: monitorexit
    //   517: aload_3
    //   518: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	3
    //   0	519	1	paramBoolean	boolean
    //   0	519	2	paramInt	int
    //   0	519	3	paramResendRspBody	tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody
    //   0	519	4	paramBundle	android.os.Bundle
    //   268	69	5	i	int
    //   7	51	6	l	long
    //   28	481	8	localTroopFileTransferManager	TroopFileTransferManager
    //   100	399	9	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   105	122	507	finally
    //   127	165	507	finally
    //   165	168	507	finally
    //   169	172	507	finally
    //   508	511	507	finally
    //   12	30	513	finally
    //   35	73	513	finally
    //   73	76	513	finally
    //   77	80	513	finally
    //   514	517	513	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.3
 * JD-Core Version:    0.7.0.1
 */