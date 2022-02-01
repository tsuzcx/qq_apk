package com.tencent.mobileqq.highway.openup;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class SessionInfo
{
  private static final String HW_SESSION_EXT_NAME = ".highways";
  private static final String HW_SESSION_INFO_DIRNAME = "highway_session_info_dir";
  private static final String HW_SESSION_INFO_FILENAME = "highway_session_info";
  private static volatile SessionInfo sessionInfo;
  private byte[] bytes_httpconn_sig_session = null;
  private byte[] bytes_session_key = null;
  private String mUin;
  
  private SessionInfo(String paramString)
  {
    this.mUin = paramString;
    loadFromDisk(paramString);
  }
  
  public static void clearOldSession()
  {
    try
    {
      BdhLogUtil.LogEvent("C", "SessionInfo.clearOldSession");
      Object localObject1 = BaseApplication.getContext();
      if (localObject1 == null) {
        return;
      }
      localObject1 = new File(((Context)localObject1).getFilesDir(), "highway_session_info");
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      return;
    }
    finally {}
  }
  
  public static SessionInfo getInstance(String paramString)
  {
    try
    {
      if ((sessionInfo == null) || (sessionInfo.mUin == null) || (!sessionInfo.mUin.equals(paramString))) {
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
    //   5: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +4 -> 14
    //   13: return
    //   14: new 88	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: ldc 91
    //   27: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: ldc 38
    //   40: aload 4
    //   42: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 46	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: new 54	java/io/File
    //   51: dup
    //   52: aload_3
    //   53: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   56: ldc 11
    //   58: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore 4
    //   63: new 88	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   70: astore 5
    //   72: aload 5
    //   74: aload_1
    //   75: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: ldc 8
    //   83: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 54	java/io/File
    //   90: dup
    //   91: aload 4
    //   93: aload 5
    //   95: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 67	java/io/File:exists	()Z
    //   106: ifeq +6 -> 112
    //   109: goto +24 -> 133
    //   112: new 54	java/io/File
    //   115: dup
    //   116: aload_3
    //   117: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   120: ldc 14
    //   122: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 67	java/io/File:exists	()Z
    //   130: ifeq +411 -> 541
    //   133: new 101	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   136: dup
    //   137: invokespecial 102	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   140: astore 4
    //   142: aconst_null
    //   143: astore 7
    //   145: aconst_null
    //   146: astore 5
    //   148: new 104	java/io/FileInputStream
    //   151: dup
    //   152: aload_1
    //   153: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   156: astore_3
    //   157: new 109	java/io/ByteArrayOutputStream
    //   160: dup
    //   161: invokespecial 110	java/io/ByteArrayOutputStream:<init>	()V
    //   164: astore_1
    //   165: sipush 128
    //   168: newarray byte
    //   170: astore 5
    //   172: aload_3
    //   173: aload 5
    //   175: iconst_0
    //   176: aload 5
    //   178: arraylength
    //   179: invokevirtual 114	java/io/FileInputStream:read	([BII)I
    //   182: istore_2
    //   183: iload_2
    //   184: iconst_m1
    //   185: if_icmpeq +14 -> 199
    //   188: aload_1
    //   189: aload 5
    //   191: iconst_0
    //   192: iload_2
    //   193: invokevirtual 118	java/io/ByteArrayOutputStream:write	([BII)V
    //   196: goto -24 -> 172
    //   199: aload_1
    //   200: invokevirtual 121	java/io/ByteArrayOutputStream:flush	()V
    //   203: aload 4
    //   205: aload_1
    //   206: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   209: invokevirtual 129	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   212: pop
    //   213: aload 4
    //   215: getfield 132	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   221: ifeq +18 -> 239
    //   224: aload_0
    //   225: aload 4
    //   227: getfield 132	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   233: invokevirtual 144	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   236: putfield 27	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_httpconn_sig_session	[B
    //   239: aload 4
    //   241: getfield 146	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   244: invokevirtual 137	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   247: ifeq +18 -> 265
    //   250: aload_0
    //   251: aload 4
    //   253: getfield 146	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   259: invokevirtual 144	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   262: putfield 29	com/tencent/mobileqq/highway/openup/SessionInfo:bytes_session_key	[B
    //   265: aload_3
    //   266: invokevirtual 149	java/io/FileInputStream:close	()V
    //   269: goto +12 -> 281
    //   272: astore_3
    //   273: ldc 38
    //   275: ldc 151
    //   277: aload_3
    //   278: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_1
    //   282: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   285: return
    //   286: astore 5
    //   288: aload_3
    //   289: astore 4
    //   291: aload 5
    //   293: astore_3
    //   294: goto +201 -> 495
    //   297: astore 5
    //   299: aload_1
    //   300: astore 4
    //   302: aload 5
    //   304: astore_1
    //   305: goto +31 -> 336
    //   308: astore 5
    //   310: aload_1
    //   311: astore 4
    //   313: aload 5
    //   315: astore_1
    //   316: goto +33 -> 349
    //   319: astore 5
    //   321: aconst_null
    //   322: astore_1
    //   323: aload_3
    //   324: astore 4
    //   326: aload 5
    //   328: astore_3
    //   329: goto +166 -> 495
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 4
    //   336: aload_3
    //   337: astore 5
    //   339: aload_1
    //   340: astore 6
    //   342: goto +30 -> 372
    //   345: astore_1
    //   346: aconst_null
    //   347: astore 4
    //   349: aload_3
    //   350: astore 5
    //   352: aload_1
    //   353: astore 6
    //   355: goto +74 -> 429
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_1
    //   362: astore 4
    //   364: goto +131 -> 495
    //   367: astore 6
    //   369: aconst_null
    //   370: astore 4
    //   372: aload 5
    //   374: astore_3
    //   375: aload 4
    //   377: astore_1
    //   378: ldc 38
    //   380: ldc 151
    //   382: aload 6
    //   384: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   387: aload 5
    //   389: ifnull +20 -> 409
    //   392: aload 5
    //   394: invokevirtual 149	java/io/FileInputStream:close	()V
    //   397: goto +12 -> 409
    //   400: astore_1
    //   401: ldc 38
    //   403: ldc 151
    //   405: aload_1
    //   406: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   409: aload 4
    //   411: ifnull +75 -> 486
    //   414: aload 4
    //   416: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   419: return
    //   420: astore 6
    //   422: aconst_null
    //   423: astore 4
    //   425: aload 7
    //   427: astore 5
    //   429: aload 5
    //   431: astore_3
    //   432: aload 4
    //   434: astore_1
    //   435: ldc 38
    //   437: ldc 151
    //   439: aload 6
    //   441: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   444: aload 5
    //   446: ifnull +20 -> 466
    //   449: aload 5
    //   451: invokevirtual 149	java/io/FileInputStream:close	()V
    //   454: goto +12 -> 466
    //   457: astore_1
    //   458: ldc 38
    //   460: ldc 151
    //   462: aload_1
    //   463: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   466: aload 4
    //   468: ifnull +18 -> 486
    //   471: aload 4
    //   473: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   476: return
    //   477: astore_1
    //   478: ldc 38
    //   480: ldc 151
    //   482: aload_1
    //   483: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   486: return
    //   487: astore 5
    //   489: aload_3
    //   490: astore 4
    //   492: aload 5
    //   494: astore_3
    //   495: aload 4
    //   497: ifnull +22 -> 519
    //   500: aload 4
    //   502: invokevirtual 149	java/io/FileInputStream:close	()V
    //   505: goto +14 -> 519
    //   508: astore 4
    //   510: ldc 38
    //   512: ldc 151
    //   514: aload 4
    //   516: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload_1
    //   520: ifnull +19 -> 539
    //   523: aload_1
    //   524: invokevirtual 156	java/io/ByteArrayOutputStream:close	()V
    //   527: goto +12 -> 539
    //   530: astore_1
    //   531: ldc 38
    //   533: ldc 151
    //   535: aload_1
    //   536: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   539: aload_3
    //   540: athrow
    //   541: ldc 38
    //   543: ldc 158
    //   545: invokestatic 46	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	SessionInfo
    //   0	549	1	paramString	String
    //   182	11	2	i	int
    //   8	258	3	localObject1	Object
    //   272	17	3	localIOException1	java.io.IOException
    //   293	57	3	localObject2	Object
    //   358	1	3	localObject3	Object
    //   374	166	3	localObject4	Object
    //   21	480	4	localObject5	Object
    //   508	7	4	localIOException2	java.io.IOException
    //   70	120	5	localObject6	Object
    //   286	6	5	localObject7	Object
    //   297	6	5	localIOException3	java.io.IOException
    //   308	6	5	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   319	8	5	localObject8	Object
    //   337	113	5	localObject9	Object
    //   487	6	5	localObject10	Object
    //   340	14	6	str	String
    //   367	16	6	localIOException4	java.io.IOException
    //   420	20	6	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   143	283	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   265	269	272	java/io/IOException
    //   165	172	286	finally
    //   172	183	286	finally
    //   188	196	286	finally
    //   199	239	286	finally
    //   239	265	286	finally
    //   165	172	297	java/io/IOException
    //   172	183	297	java/io/IOException
    //   188	196	297	java/io/IOException
    //   199	239	297	java/io/IOException
    //   239	265	297	java/io/IOException
    //   165	172	308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   172	183	308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   188	196	308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   199	239	308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   239	265	308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   157	165	319	finally
    //   157	165	332	java/io/IOException
    //   157	165	345	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   148	157	358	finally
    //   148	157	367	java/io/IOException
    //   392	397	400	java/io/IOException
    //   148	157	420	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   449	454	457	java/io/IOException
    //   281	285	477	java/io/IOException
    //   414	419	477	java/io/IOException
    //   471	476	477	java/io/IOException
    //   378	387	487	finally
    //   435	444	487	finally
    //   500	505	508	java/io/IOException
    //   523	527	530	java/io/IOException
  }
  
  public static void updateSessionInfo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSessionInfo:");
      localStringBuilder.append(BdhUtils.bytes2HexStr(paramArrayOfByte1));
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      BdhLogUtil.LogEvent("C", localStringBuilder.toString());
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0) && (paramString != null))
      {
        clearOldSession();
        if (write2Disk(paramArrayOfByte1, paramArrayOfByte2, paramString)) {
          sessionInfo = null;
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private static boolean write2Disk(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    // Byte code:
    //   0: invokestatic 52	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: new 54	java/io/File
    //   13: dup
    //   14: aload_3
    //   15: invokevirtual 60	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: ldc 11
    //   20: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 67	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_3
    //   32: invokevirtual 181	java/io/File:mkdir	()Z
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 184	java/io/File:getPath	()Ljava/lang/String;
    //   40: astore_3
    //   41: new 88	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   48: astore 4
    //   50: aload 4
    //   52: aload_2
    //   53: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc 8
    //   61: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: new 54	java/io/File
    //   68: dup
    //   69: aload_3
    //   70: aload 4
    //   72: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore_3
    //   79: aload_3
    //   80: invokevirtual 67	java/io/File:exists	()Z
    //   83: ifeq +8 -> 91
    //   86: aload_3
    //   87: invokevirtual 70	java/io/File:delete	()Z
    //   90: pop
    //   91: aconst_null
    //   92: astore 4
    //   94: aconst_null
    //   95: astore 5
    //   97: aconst_null
    //   98: astore_2
    //   99: new 188	java/io/FileOutputStream
    //   102: dup
    //   103: aload_3
    //   104: invokespecial 189	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   107: astore_3
    //   108: new 101	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB
    //   111: dup
    //   112: invokespecial 102	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:<init>	()V
    //   115: astore_2
    //   116: aload_2
    //   117: getfield 132	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_httpconn_sig_session	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: aload_0
    //   121: invokestatic 193	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   124: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   127: aload_2
    //   128: getfield 146	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:bytes_session_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   131: aload_1
    //   132: invokestatic 193	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   135: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   138: aload_3
    //   139: aload_2
    //   140: invokevirtual 198	com/tencent/mobileqq/highway/protocol/HwSessionInfoPersistentPB$HwSessionInfoPB:toByteArray	()[B
    //   143: invokevirtual 201	java/io/FileOutputStream:write	([B)V
    //   146: ldc 38
    //   148: ldc 203
    //   150: invokestatic 46	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_3
    //   154: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_0
    //   160: goto +80 -> 240
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: goto +19 -> 185
    //   169: astore_1
    //   170: aload_3
    //   171: astore_0
    //   172: goto +37 -> 209
    //   175: astore_0
    //   176: aload_2
    //   177: astore_3
    //   178: goto +62 -> 240
    //   181: astore_1
    //   182: aload 4
    //   184: astore_0
    //   185: aload_0
    //   186: astore_2
    //   187: ldc 38
    //   189: ldc 206
    //   191: aload_1
    //   192: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: aload_0
    //   196: ifnull +42 -> 238
    //   199: aload_0
    //   200: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   203: iconst_0
    //   204: ireturn
    //   205: astore_1
    //   206: aload 5
    //   208: astore_0
    //   209: aload_0
    //   210: astore_2
    //   211: ldc 38
    //   213: ldc 206
    //   215: aload_1
    //   216: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_0
    //   220: ifnull +18 -> 238
    //   223: aload_0
    //   224: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_0
    //   230: ldc 38
    //   232: ldc 206
    //   234: aload_0
    //   235: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   238: iconst_0
    //   239: ireturn
    //   240: aload_3
    //   241: ifnull +19 -> 260
    //   244: aload_3
    //   245: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   248: goto +12 -> 260
    //   251: astore_1
    //   252: ldc 38
    //   254: ldc 206
    //   256: aload_1
    //   257: invokestatic 155	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_0
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramArrayOfByte1	byte[]
    //   0	262	1	paramArrayOfByte2	byte[]
    //   0	262	2	paramString	String
    //   3	242	3	localObject1	Object
    //   48	135	4	localStringBuilder	StringBuilder
    //   95	112	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   108	153	159	finally
    //   108	153	163	java/io/IOException
    //   108	153	169	java/io/FileNotFoundException
    //   99	108	175	finally
    //   187	195	175	finally
    //   211	219	175	finally
    //   99	108	181	java/io/IOException
    //   99	108	205	java/io/FileNotFoundException
    //   153	157	229	java/io/IOException
    //   199	203	229	java/io/IOException
    //   223	227	229	java/io/IOException
    //   244	248	251	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.openup.SessionInfo
 * JD-Core Version:    0.7.0.1
 */