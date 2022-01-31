package com.tencent.mobileqq.highway.openup;

public class SessionInfo
{
  private static final String HW_SESSION_EXT_NAME = ".highways";
  private static final String HW_SESSION_INFO_DIRNAME = "highway_session_info_dir";
  private static final String HW_SESSION_INFO_FILENAME = "highway_session_info";
  private static volatile SessionInfo sessionInfo;
  private byte[] bytes_httpconn_sig_session;
  private byte[] bytes_session_key;
  
  private SessionInfo(String paramString)
  {
    loadFromDisk(paramString);
  }
  
  /* Error */
  public static void clearOldSession()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 37
    //   11: iconst_2
    //   12: ldc 39
    //   14: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull +7 -> 29
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: new 51	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   37: ldc 14
    //   39: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 63	java/io/File:exists	()Z
    //   47: ifeq -22 -> 25
    //   50: aload_0
    //   51: invokevirtual 66	java/io/File:delete	()Z
    //   54: pop
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	31	0	localObject1	Object
    //   58	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	58	finally
    //   17	21	58	finally
    //   29	55	58	finally
  }
  
  public static SessionInfo getInstance(String paramString)
  {
    if (sessionInfo == null) {}
    try
    {
      if (sessionInfo == null) {
        sessionInfo = new SessionInfo(paramString);
      }
      return sessionInfo;
    }
    finally {}
  }
  
  /* Error */
  private void loadFromDisk(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull -6 -> 4
    //   13: new 51	java/io/File
    //   16: dup
    //   17: new 51	java/io/File
    //   20: dup
    //   21: aload_3
    //   22: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: ldc 11
    //   27: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: new 78	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   37: aload_1
    //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 8
    //   43: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 63	java/io/File:exists	()Z
    //   57: ifeq +134 -> 191
    //   60: new 89	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   63: dup
    //   64: invokespecial 90	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore 4
    //   75: aconst_null
    //   76: astore 7
    //   78: aconst_null
    //   79: astore 5
    //   81: aconst_null
    //   82: astore_3
    //   83: aconst_null
    //   84: astore 8
    //   86: aconst_null
    //   87: astore 6
    //   89: new 92	java/io/FileInputStream
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_1
    //   98: new 97	java/io/ByteArrayOutputStream
    //   101: dup
    //   102: invokespecial 98	java/io/ByteArrayOutputStream:<init>	()V
    //   105: astore_3
    //   106: sipush 128
    //   109: newarray byte
    //   111: astore 4
    //   113: aload_1
    //   114: aload 4
    //   116: iconst_0
    //   117: aload 4
    //   119: arraylength
    //   120: invokevirtual 102	java/io/FileInputStream:read	([BII)I
    //   123: istore_2
    //   124: iload_2
    //   125: iconst_m1
    //   126: if_icmpeq +98 -> 224
    //   129: aload_3
    //   130: aload 4
    //   132: iconst_0
    //   133: iload_2
    //   134: invokevirtual 106	java/io/ByteArrayOutputStream:write	([BII)V
    //   137: goto -24 -> 113
    //   140: astore 6
    //   142: aload_3
    //   143: astore 5
    //   145: aload 5
    //   147: astore_3
    //   148: aload_1
    //   149: astore 4
    //   151: ldc 37
    //   153: iconst_2
    //   154: ldc 108
    //   156: aload 6
    //   158: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 115	java/io/FileInputStream:close	()V
    //   169: aload 5
    //   171: ifnull -167 -> 4
    //   174: aload 5
    //   176: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   179: return
    //   180: astore_1
    //   181: ldc 37
    //   183: iconst_2
    //   184: ldc 108
    //   186: aload_1
    //   187: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: return
    //   191: new 51	java/io/File
    //   194: dup
    //   195: aload_3
    //   196: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   199: ldc 14
    //   201: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 63	java/io/File:exists	()Z
    //   209: ifeq +6 -> 215
    //   212: goto -152 -> 60
    //   215: ldc 37
    //   217: iconst_2
    //   218: ldc 118
    //   220: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: return
    //   224: aload_3
    //   225: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   228: aload 10
    //   230: aload_3
    //   231: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   234: invokevirtual 131	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   237: pop
    //   238: aload 10
    //   240: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   246: ifeq +18 -> 264
    //   249: aload_0
    //   250: aload 10
    //   252: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: putfield 148	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_httpconn_sig_session	[B
    //   264: aload 10
    //   266: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   269: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   272: ifeq +18 -> 290
    //   275: aload_0
    //   276: aload 10
    //   278: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   281: invokevirtual 143	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   284: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   287: putfield 152	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_session_key	[B
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 115	java/io/FileInputStream:close	()V
    //   298: aload_3
    //   299: ifnull +221 -> 520
    //   302: aload_3
    //   303: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   306: return
    //   307: astore_1
    //   308: ldc 37
    //   310: iconst_2
    //   311: ldc 108
    //   313: aload_1
    //   314: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: goto -19 -> 298
    //   320: astore_1
    //   321: ldc 37
    //   323: iconst_2
    //   324: ldc 108
    //   326: aload_1
    //   327: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: return
    //   331: astore_1
    //   332: ldc 37
    //   334: iconst_2
    //   335: ldc 108
    //   337: aload_1
    //   338: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   341: goto -172 -> 169
    //   344: astore 6
    //   346: aload 9
    //   348: astore_1
    //   349: aload 5
    //   351: astore_3
    //   352: aload_1
    //   353: astore 4
    //   355: ldc 37
    //   357: iconst_2
    //   358: ldc 108
    //   360: aload 6
    //   362: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   365: aload_1
    //   366: ifnull +7 -> 373
    //   369: aload_1
    //   370: invokevirtual 115	java/io/FileInputStream:close	()V
    //   373: aload 5
    //   375: ifnull -371 -> 4
    //   378: aload 5
    //   380: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: ldc 37
    //   387: iconst_2
    //   388: ldc 108
    //   390: aload_1
    //   391: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   394: return
    //   395: astore_1
    //   396: ldc 37
    //   398: iconst_2
    //   399: ldc 108
    //   401: aload_1
    //   402: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: goto -32 -> 373
    //   408: astore_1
    //   409: aload 4
    //   411: ifnull +8 -> 419
    //   414: aload 4
    //   416: invokevirtual 115	java/io/FileInputStream:close	()V
    //   419: aload_3
    //   420: ifnull +7 -> 427
    //   423: aload_3
    //   424: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore 4
    //   431: ldc 37
    //   433: iconst_2
    //   434: ldc 108
    //   436: aload 4
    //   438: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: goto -22 -> 419
    //   444: astore_3
    //   445: ldc 37
    //   447: iconst_2
    //   448: ldc 108
    //   450: aload_3
    //   451: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: goto -27 -> 427
    //   457: astore 5
    //   459: aload 8
    //   461: astore_3
    //   462: aload_1
    //   463: astore 4
    //   465: aload 5
    //   467: astore_1
    //   468: goto -59 -> 409
    //   471: astore 5
    //   473: aload_1
    //   474: astore 4
    //   476: aload 5
    //   478: astore_1
    //   479: goto -70 -> 409
    //   482: astore 6
    //   484: goto -135 -> 349
    //   487: astore 6
    //   489: aload_3
    //   490: astore 5
    //   492: goto -143 -> 349
    //   495: astore_1
    //   496: aload 6
    //   498: astore 5
    //   500: aload_1
    //   501: astore 6
    //   503: aload 7
    //   505: astore_1
    //   506: goto -361 -> 145
    //   509: astore_3
    //   510: aload 6
    //   512: astore 5
    //   514: aload_3
    //   515: astore 6
    //   517: goto -372 -> 145
    //   520: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	SessionInfo
    //   0	521	1	paramString	String
    //   123	11	2	i	int
    //   8	416	3	localObject1	Object
    //   444	7	3	localIOException1	java.io.IOException
    //   461	29	3	localObject2	Object
    //   509	6	3	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   73	342	4	localObject3	Object
    //   429	8	4	localIOException2	java.io.IOException
    //   463	12	4	str	String
    //   79	300	5	localObject4	Object
    //   457	9	5	localObject5	Object
    //   471	6	5	localObject6	Object
    //   490	23	5	localObject7	Object
    //   87	1	6	localObject8	Object
    //   140	17	6	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   344	17	6	localIOException3	java.io.IOException
    //   482	1	6	localIOException4	java.io.IOException
    //   487	10	6	localIOException5	java.io.IOException
    //   501	15	6	localObject9	Object
    //   76	428	7	localObject10	Object
    //   84	376	8	localObject11	Object
    //   70	277	9	localObject12	Object
    //   67	210	10	localHwSessionInfoPB	com.tencent.mobileqq.highway.protocol.HwSessionInfoPersistentPB.HwSessionInfoPB
    // Exception table:
    //   from	to	target	type
    //   106	113	140	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	124	140	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   129	137	140	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   224	264	140	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   264	290	140	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	179	180	java/io/IOException
    //   294	298	307	java/io/IOException
    //   302	306	320	java/io/IOException
    //   165	169	331	java/io/IOException
    //   89	98	344	java/io/IOException
    //   378	383	384	java/io/IOException
    //   369	373	395	java/io/IOException
    //   89	98	408	finally
    //   151	161	408	finally
    //   355	365	408	finally
    //   414	419	429	java/io/IOException
    //   423	427	444	java/io/IOException
    //   98	106	457	finally
    //   106	113	471	finally
    //   113	124	471	finally
    //   129	137	471	finally
    //   224	264	471	finally
    //   264	290	471	finally
    //   98	106	482	java/io/IOException
    //   106	113	487	java/io/IOException
    //   113	124	487	java/io/IOException
    //   129	137	487	java/io/IOException
    //   224	264	487	java/io/IOException
    //   264	290	487	java/io/IOException
    //   89	98	495	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   98	106	509	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public static void updateSessionInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 37
    //   11: iconst_2
    //   12: ldc 155
    //   14: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: arraylength
    //   23: ifeq +18 -> 41
    //   26: aload_1
    //   27: ifnull +14 -> 41
    //   30: aload_1
    //   31: arraylength
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq +7 -> 41
    //   37: aload_2
    //   38: ifnonnull +7 -> 45
    //   41: ldc 2
    //   43: monitorexit
    //   44: return
    //   45: invokestatic 157	com/tencent/mobileqq/highway/openup/SessionInfo:clearOldSession	()V
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: invokestatic 161	com/tencent/mobileqq/highway/openup/SessionInfo:write2Disk	([B[BLjava/lang/String;)Z
    //   54: ifeq -13 -> 41
    //   57: aconst_null
    //   58: putstatic 70	com/tencent/mobileqq/highway/openup/SessionInfo:sessionInfo	Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   61: goto -20 -> 41
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramArrayOfByte1	byte[]
    //   0	70	1	paramArrayOfByte2	byte[]
    //   0	70	2	paramString	String
    //   32	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   3	17	64	finally
    //   21	26	64	finally
    //   30	33	64	finally
    //   45	61	64	finally
  }
  
  /* Error */
  private static boolean write2Disk(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 49	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5: astore 5
    //   7: aload 5
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 51	java/io/File
    //   17: dup
    //   18: aload 5
    //   20: invokevirtual 57	android/content/Context:getFilesDir	()Ljava/io/File;
    //   23: ldc 11
    //   25: invokespecial 60	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore 5
    //   30: aload 5
    //   32: invokevirtual 63	java/io/File:exists	()Z
    //   35: ifne +9 -> 44
    //   38: aload 5
    //   40: invokevirtual 166	java/io/File:mkdir	()Z
    //   43: pop
    //   44: new 51	java/io/File
    //   47: dup
    //   48: aload 5
    //   50: invokevirtual 169	java/io/File:getPath	()Ljava/lang/String;
    //   53: new 78	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   60: aload_2
    //   61: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 8
    //   66: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload 5
    //   79: invokevirtual 63	java/io/File:exists	()Z
    //   82: ifeq +9 -> 91
    //   85: aload 5
    //   87: invokevirtual 66	java/io/File:delete	()Z
    //   90: pop
    //   91: aconst_null
    //   92: astore 7
    //   94: aconst_null
    //   95: astore_2
    //   96: aconst_null
    //   97: astore 6
    //   99: new 174	java/io/FileOutputStream
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   108: astore 5
    //   110: new 89	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   113: dup
    //   114: invokespecial 90	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   117: astore_2
    //   118: aload_2
    //   119: getfield 134	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: aload_0
    //   123: invokestatic 179	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 183	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   129: aload_2
    //   130: getfield 150	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: aload_1
    //   134: invokestatic 179	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   137: invokevirtual 183	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   140: aload 5
    //   142: aload_2
    //   143: invokevirtual 184	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:toByteArray	()[B
    //   146: invokevirtual 187	java/io/FileOutputStream:write	([B)V
    //   149: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +11 -> 163
    //   155: ldc 37
    //   157: iconst_2
    //   158: ldc 189
    //   160: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload 5
    //   165: ifnull +8 -> 173
    //   168: aload 5
    //   170: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   173: iload_3
    //   174: ireturn
    //   175: astore_0
    //   176: ldc 37
    //   178: iconst_2
    //   179: ldc 192
    //   181: aload_0
    //   182: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: iconst_0
    //   186: istore_3
    //   187: goto -14 -> 173
    //   190: astore_1
    //   191: aload 6
    //   193: astore_0
    //   194: aload_0
    //   195: astore_2
    //   196: ldc 37
    //   198: iconst_2
    //   199: ldc 192
    //   201: aload_1
    //   202: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: istore_3
    //   211: aload_0
    //   212: ifnull -39 -> 173
    //   215: aload_0
    //   216: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   219: iload 4
    //   221: istore_3
    //   222: goto -49 -> 173
    //   225: astore_0
    //   226: ldc 37
    //   228: iconst_2
    //   229: ldc 192
    //   231: aload_0
    //   232: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: iconst_0
    //   236: istore_3
    //   237: goto -64 -> 173
    //   240: astore_1
    //   241: aload 7
    //   243: astore_0
    //   244: aload_0
    //   245: astore_2
    //   246: ldc 37
    //   248: iconst_2
    //   249: ldc 192
    //   251: aload_1
    //   252: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: iconst_0
    //   256: istore 4
    //   258: iload 4
    //   260: istore_3
    //   261: aload_0
    //   262: ifnull -89 -> 173
    //   265: aload_0
    //   266: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   269: iload 4
    //   271: istore_3
    //   272: goto -99 -> 173
    //   275: astore_0
    //   276: ldc 37
    //   278: iconst_2
    //   279: ldc 192
    //   281: aload_0
    //   282: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: iconst_0
    //   286: istore_3
    //   287: goto -114 -> 173
    //   290: astore_0
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_1
    //   302: ldc 37
    //   304: iconst_2
    //   305: ldc 192
    //   307: aload_1
    //   308: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -12 -> 299
    //   314: astore_0
    //   315: aload 5
    //   317: astore_2
    //   318: goto -27 -> 291
    //   321: astore_1
    //   322: aload 5
    //   324: astore_0
    //   325: goto -81 -> 244
    //   328: astore_1
    //   329: aload 5
    //   331: astore_0
    //   332: goto -138 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramArrayOfByte1	byte[]
    //   0	335	1	paramArrayOfByte2	byte[]
    //   0	335	2	paramString	String
    //   1	286	3	bool1	boolean
    //   206	64	4	bool2	boolean
    //   5	325	5	localObject1	Object
    //   97	95	6	localObject2	Object
    //   92	150	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   168	173	175	java/io/IOException
    //   99	110	190	java/io/FileNotFoundException
    //   215	219	225	java/io/IOException
    //   99	110	240	java/io/IOException
    //   265	269	275	java/io/IOException
    //   99	110	290	finally
    //   196	205	290	finally
    //   246	255	290	finally
    //   295	299	301	java/io/IOException
    //   110	163	314	finally
    //   110	163	321	java/io/IOException
    //   110	163	328	java/io/FileNotFoundException
  }
  
  public byte[] getHttpconn_sig_session()
  {
    return this.bytes_httpconn_sig_session;
  }
  
  public byte[] getSessionKey()
  {
    return this.bytes_session_key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.openup.SessionInfo
 * JD-Core Version:    0.7.0.1
 */