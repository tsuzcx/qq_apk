package com.tencent.mobileqq.dating;

public class DarenAssistantHelper
{
  /* Error */
  public static com.tencent.mobileqq.data.MessageRecord a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, OnlinePushPack.MsgInfo paramMsgInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +283 -> 284
    //   4: new 15	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody
    //   7: dup
    //   8: invokespecial 16	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:<init>	()V
    //   11: astore 7
    //   13: aload 7
    //   15: aload_1
    //   16: invokevirtual 20	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   19: pop
    //   20: sipush -2068
    //   23: invokestatic 25	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   26: checkcast 27	com/tencent/mobileqq/data/MessageForDarenAssistant
    //   29: astore_1
    //   30: aload_1
    //   31: aload 7
    //   33: getfield 31	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   36: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   39: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   42: putfield 47	com/tencent/mobileqq/data/MessageForDarenAssistant:msg	Ljava/lang/String;
    //   45: aload_1
    //   46: aload 7
    //   48: getfield 50	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   57: putfield 53	com/tencent/mobileqq/data/MessageForDarenAssistant:jumpUrl	Ljava/lang/String;
    //   60: aload 7
    //   62: getfield 57	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:uint32_update_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: i2l
    //   69: lstore 5
    //   71: lload 5
    //   73: lstore_3
    //   74: lload 5
    //   76: lconst_0
    //   77: lcmp
    //   78: ifgt +9 -> 87
    //   81: aload_2
    //   82: getfield 68	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   85: i2l
    //   86: lstore_3
    //   87: aload_1
    //   88: lload_3
    //   89: putfield 72	com/tencent/mobileqq/data/MessageForDarenAssistant:time	J
    //   92: aload_1
    //   93: lload_3
    //   94: putfield 75	com/tencent/mobileqq/data/MessageForDarenAssistant:msgseq	J
    //   97: aload_1
    //   98: aload_2
    //   99: getfield 79	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   102: i2l
    //   103: putfield 82	com/tencent/mobileqq/data/MessageForDarenAssistant:shmsgseq	J
    //   106: aload_1
    //   107: aload_2
    //   108: getfield 85	OnlinePushPack/MsgInfo:lMsgUid	J
    //   111: putfield 88	com/tencent/mobileqq/data/MessageForDarenAssistant:msgUid	J
    //   114: aload_1
    //   115: aload_0
    //   116: invokevirtual 93	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   119: putfield 96	com/tencent/mobileqq/data/MessageForDarenAssistant:selfuin	Ljava/lang/String;
    //   122: aload_1
    //   123: sipush 1001
    //   126: putfield 99	com/tencent/mobileqq/data/MessageForDarenAssistant:istroop	I
    //   129: aload_1
    //   130: iconst_0
    //   131: putfield 103	com/tencent/mobileqq/data/MessageForDarenAssistant:isread	Z
    //   134: aload_1
    //   135: getstatic 108	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   138: putfield 111	com/tencent/mobileqq/data/MessageForDarenAssistant:frienduin	Ljava/lang/String;
    //   141: aload_1
    //   142: getstatic 114	com/tencent/mobileqq/app/AppConstants:MSG_BOX_DAREN_ASSISTANT_UIN	Ljava/lang/String;
    //   145: putfield 117	com/tencent/mobileqq/data/MessageForDarenAssistant:senderuin	Ljava/lang/String;
    //   148: aload_1
    //   149: invokevirtual 120	com/tencent/mobileqq/data/MessageForDarenAssistant:getBytes	()V
    //   152: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +94 -> 249
    //   158: new 128	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   165: astore_0
    //   166: aload_0
    //   167: ldc 131
    //   169: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 137
    //   174: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 7
    //   179: getfield 31	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   182: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   185: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   188: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 139
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 7
    //   198: getfield 50	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   204: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   207: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc 141
    //   212: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 7
    //   217: getfield 57	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:uint32_update_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   220: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   223: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc 146
    //   228: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: getfield 149	OnlinePushPack/MsgInfo:lFromUin	J
    //   235: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 154
    //   241: iconst_2
    //   242: aload_0
    //   243: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_1
    //   250: areturn
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_0
    //   254: ldc 154
    //   256: iconst_1
    //   257: new 128	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   264: ldc 163
    //   266: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_1
    //   270: invokevirtual 164	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   273: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: areturn
    //   284: ldc 154
    //   286: iconst_1
    //   287: ldc 166
    //   289: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aconst_null
    //   293: areturn
    //   294: astore_2
    //   295: aload_1
    //   296: astore_0
    //   297: aload_2
    //   298: astore_1
    //   299: goto -45 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	302	1	paramArrayOfByte	byte[]
    //   0	302	2	paramMsgInfo	OnlinePushPack.MsgInfo
    //   73	21	3	l1	long
    //   69	6	5	l2	long
    //   11	205	7	localMsgBody	com.tencent.mobileqq.darenassistant.pb.DarenAssistantMsg.MsgBody
    // Exception table:
    //   from	to	target	type
    //   4	71	251	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   81	87	251	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   87	152	251	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   152	249	294	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  public static com.tencent.mobileqq.data.MessageRecord a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +313 -> 314
    //   4: new 15	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody
    //   7: dup
    //   8: invokespecial 16	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:<init>	()V
    //   11: astore 7
    //   13: aload 7
    //   15: aload_1
    //   16: invokevirtual 20	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   19: pop
    //   20: sipush -2068
    //   23: invokestatic 25	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   26: checkcast 27	com/tencent/mobileqq/data/MessageForDarenAssistant
    //   29: astore_1
    //   30: aload_1
    //   31: aload 7
    //   33: getfield 31	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   36: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   39: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   42: putfield 47	com/tencent/mobileqq/data/MessageForDarenAssistant:msg	Ljava/lang/String;
    //   45: aload_1
    //   46: aload 7
    //   48: getfield 50	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   57: putfield 53	com/tencent/mobileqq/data/MessageForDarenAssistant:jumpUrl	Ljava/lang/String;
    //   60: aload 7
    //   62: getfield 57	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:uint32_update_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: i2l
    //   69: lstore 5
    //   71: lload 5
    //   73: lstore_3
    //   74: lload 5
    //   76: lconst_0
    //   77: lcmp
    //   78: ifgt +21 -> 99
    //   81: aload_2
    //   82: getfield 173	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   85: invokevirtual 178	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   88: checkcast 175	msf/msgcomm/msg_comm$MsgHead
    //   91: getfield 181	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   94: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   97: i2l
    //   98: lstore_3
    //   99: aload_1
    //   100: lload_3
    //   101: putfield 72	com/tencent/mobileqq/data/MessageForDarenAssistant:time	J
    //   104: aload_1
    //   105: lload_3
    //   106: putfield 75	com/tencent/mobileqq/data/MessageForDarenAssistant:msgseq	J
    //   109: aload_1
    //   110: aload_2
    //   111: getfield 173	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   114: getfield 184	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   117: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   120: i2l
    //   121: putfield 82	com/tencent/mobileqq/data/MessageForDarenAssistant:shmsgseq	J
    //   124: aload_1
    //   125: aload_2
    //   126: getfield 173	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   129: getfield 188	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   132: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   135: putfield 88	com/tencent/mobileqq/data/MessageForDarenAssistant:msgUid	J
    //   138: aload_1
    //   139: aload_0
    //   140: invokevirtual 93	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   143: putfield 96	com/tencent/mobileqq/data/MessageForDarenAssistant:selfuin	Ljava/lang/String;
    //   146: aload_1
    //   147: sipush 1001
    //   150: putfield 99	com/tencent/mobileqq/data/MessageForDarenAssistant:istroop	I
    //   153: aload_1
    //   154: iconst_0
    //   155: putfield 103	com/tencent/mobileqq/data/MessageForDarenAssistant:isread	Z
    //   158: aload_1
    //   159: getstatic 108	com/tencent/mobileqq/app/AppConstants:LBS_HELLO_UIN	Ljava/lang/String;
    //   162: putfield 111	com/tencent/mobileqq/data/MessageForDarenAssistant:frienduin	Ljava/lang/String;
    //   165: aload_1
    //   166: getstatic 114	com/tencent/mobileqq/app/AppConstants:MSG_BOX_DAREN_ASSISTANT_UIN	Ljava/lang/String;
    //   169: putfield 117	com/tencent/mobileqq/data/MessageForDarenAssistant:senderuin	Ljava/lang/String;
    //   172: aload_1
    //   173: invokevirtual 120	com/tencent/mobileqq/data/MessageForDarenAssistant:getBytes	()V
    //   176: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +100 -> 279
    //   182: new 128	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   189: astore_0
    //   190: aload_0
    //   191: ldc 195
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 137
    //   198: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 7
    //   203: getfield 31	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   206: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   209: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   212: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 139
    //   217: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 7
    //   222: getfield 50	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:bytes_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   225: invokevirtual 37	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   228: invokevirtual 43	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   231: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc 141
    //   236: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 7
    //   241: getfield 57	com/tencent/mobileqq/darenassistant/pb/DarenAssistantMsg$MsgBody:uint32_update_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   244: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   247: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc 146
    //   252: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_2
    //   256: getfield 173	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   259: getfield 198	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   262: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   265: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 154
    //   271: iconst_2
    //   272: aload_0
    //   273: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_1
    //   280: areturn
    //   281: astore_1
    //   282: aconst_null
    //   283: astore_0
    //   284: ldc 154
    //   286: iconst_1
    //   287: new 128	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   294: ldc 200
    //   296: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 164	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   303: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: areturn
    //   314: ldc 154
    //   316: iconst_1
    //   317: ldc 202
    //   319: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aconst_null
    //   323: areturn
    //   324: astore_2
    //   325: aload_1
    //   326: astore_0
    //   327: aload_2
    //   328: astore_1
    //   329: goto -45 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	332	1	paramArrayOfByte	byte[]
    //   0	332	2	paramMsg	msf.msgcomm.msg_comm.Msg
    //   73	33	3	l1	long
    //   69	6	5	l2	long
    //   11	229	7	localMsgBody	com.tencent.mobileqq.darenassistant.pb.DarenAssistantMsg.MsgBody
    // Exception table:
    //   from	to	target	type
    //   4	71	281	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   81	99	281	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	176	281	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   176	279	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DarenAssistantHelper
 * JD-Core Version:    0.7.0.1
 */