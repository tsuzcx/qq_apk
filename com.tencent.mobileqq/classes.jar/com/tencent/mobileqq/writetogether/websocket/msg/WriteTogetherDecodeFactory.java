package com.tencent.mobileqq.writetogether.websocket.msg;

public class WriteTogetherDecodeFactory
{
  private static final String TAG = "WriteTogether.WriteTogetherDecodeFactory";
  
  /* Error */
  @android.support.annotation.Nullable
  public BaseWriteTogetherMsg decode(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 24	com/tencent/mobileqq/writetogether/websocket/msg/BaseWriteTogetherMsg:optTypeFromJson	(Ljava/lang/String;)Lcom/tencent/mobileqq/writetogether/websocket/msg/Type;
    //   4: astore_3
    //   5: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +28 -> 36
    //   11: ldc 8
    //   13: iconst_2
    //   14: new 32	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   21: ldc 35
    //   23: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_3
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: getstatic 56	com/tencent/mobileqq/writetogether/websocket/msg/WriteTogetherDecodeFactory$1:$SwitchMap$com$tencent$mobileqq$writetogether$websocket$msg$Type	[I
    //   39: aload_3
    //   40: invokevirtual 62	com/tencent/mobileqq/writetogether/websocket/msg/Type:ordinal	()I
    //   43: iaload
    //   44: tableswitch	default:+210 -> 254, 1:+91->135, 2:+118->162, 3:+129->173, 4:+140->184, 5:+151->195, 6:+162->206, 7:+173->217, 8:+184->228, 9:+195->239
    //   97: iconst_5
    //   98: iconst_1
    //   99: new 32	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   106: ldc 64
    //   108: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aconst_null
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +9 -> 133
    //   127: aload_3
    //   128: aload_1
    //   129: aload_2
    //   130: invokevirtual 68	com/tencent/mobileqq/writetogether/websocket/msg/BaseWriteTogetherMsg:fromJson	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: areturn
    //   135: new 70	com/tencent/mobileqq/writetogether/websocket/msg/ClientReadyRespMsg
    //   138: dup
    //   139: invokespecial 71	com/tencent/mobileqq/writetogether/websocket/msg/ClientReadyRespMsg:<init>	()V
    //   142: astore_3
    //   143: goto -20 -> 123
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_3
    //   149: ldc 8
    //   151: iconst_1
    //   152: aload_1
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 75	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   160: aload_3
    //   161: areturn
    //   162: new 77	com/tencent/mobileqq/writetogether/websocket/msg/UserNewInfoMsg
    //   165: dup
    //   166: invokespecial 78	com/tencent/mobileqq/writetogether/websocket/msg/UserNewInfoMsg:<init>	()V
    //   169: astore_3
    //   170: goto -47 -> 123
    //   173: new 80	com/tencent/mobileqq/writetogether/websocket/msg/LastReversionMsg
    //   176: dup
    //   177: invokespecial 81	com/tencent/mobileqq/writetogether/websocket/msg/LastReversionMsg:<init>	()V
    //   180: astore_3
    //   181: goto -58 -> 123
    //   184: new 83	com/tencent/mobileqq/writetogether/websocket/msg/UserChangesRespMsg
    //   187: dup
    //   188: invokespecial 84	com/tencent/mobileqq/writetogether/websocket/msg/UserChangesRespMsg:<init>	()V
    //   191: astore_3
    //   192: goto -69 -> 123
    //   195: new 86	com/tencent/mobileqq/writetogether/websocket/msg/AcceptCommitMsg
    //   198: dup
    //   199: invokespecial 87	com/tencent/mobileqq/writetogether/websocket/msg/AcceptCommitMsg:<init>	()V
    //   202: astore_3
    //   203: goto -80 -> 123
    //   206: new 89	com/tencent/mobileqq/writetogether/websocket/msg/NewChangesMsg
    //   209: dup
    //   210: invokespecial 90	com/tencent/mobileqq/writetogether/websocket/msg/NewChangesMsg:<init>	()V
    //   213: astore_3
    //   214: goto -91 -> 123
    //   217: new 92	com/tencent/mobileqq/writetogether/websocket/msg/UserLeaveMsg
    //   220: dup
    //   221: invokespecial 93	com/tencent/mobileqq/writetogether/websocket/msg/UserLeaveMsg:<init>	()V
    //   224: astore_3
    //   225: goto -102 -> 123
    //   228: new 95	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageRspMsg
    //   231: dup
    //   232: invokespecial 96	com/tencent/mobileqq/writetogether/websocket/msg/CursorMessageRspMsg:<init>	()V
    //   235: astore_3
    //   236: goto -113 -> 123
    //   239: new 98	com/tencent/mobileqq/writetogether/websocket/msg/CommitErrorMsg
    //   242: dup
    //   243: invokespecial 99	com/tencent/mobileqq/writetogether/websocket/msg/CommitErrorMsg:<init>	()V
    //   246: astore_3
    //   247: goto -124 -> 123
    //   250: astore_1
    //   251: goto -102 -> 149
    //   254: goto -158 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	WriteTogetherDecodeFactory
    //   0	257	1	paramString1	String
    //   0	257	2	paramString2	String
    //   4	243	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	36	146	java/lang/RuntimeException
    //   36	96	146	java/lang/RuntimeException
    //   96	121	146	java/lang/RuntimeException
    //   135	143	146	java/lang/RuntimeException
    //   162	170	146	java/lang/RuntimeException
    //   173	181	146	java/lang/RuntimeException
    //   184	192	146	java/lang/RuntimeException
    //   195	203	146	java/lang/RuntimeException
    //   206	214	146	java/lang/RuntimeException
    //   217	225	146	java/lang/RuntimeException
    //   228	236	146	java/lang/RuntimeException
    //   239	247	146	java/lang/RuntimeException
    //   127	133	250	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.msg.WriteTogetherDecodeFactory
 * JD-Core Version:    0.7.0.1
 */