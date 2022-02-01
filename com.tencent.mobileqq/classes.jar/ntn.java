import mqq.observer.BusinessObserver;

class ntn
  implements BusinessObserver
{
  ntn(ntj paramntj) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 28
    //   8: iconst_2
    //   9: new 30	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   16: ldc 33
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   25: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_0
    //   32: istore 7
    //   34: iconst_0
    //   35: istore 6
    //   37: iconst_0
    //   38: istore_1
    //   39: lconst_0
    //   40: lstore 11
    //   42: iconst_m1
    //   43: istore 4
    //   45: iconst_0
    //   46: istore 9
    //   48: iconst_0
    //   49: istore 8
    //   51: iconst_0
    //   52: istore 10
    //   54: iload 4
    //   56: istore 5
    //   58: lload 11
    //   60: lstore 13
    //   62: iload_2
    //   63: ifeq +245 -> 308
    //   66: aload_3
    //   67: ldc 50
    //   69: invokevirtual 56	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   72: astore 15
    //   74: iload 10
    //   76: istore_2
    //   77: iload 4
    //   79: istore 5
    //   81: lload 11
    //   83: lstore 13
    //   85: aload 15
    //   87: ifnull +69 -> 156
    //   90: new 58	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage
    //   93: dup
    //   94: invokespecial 59	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:<init>	()V
    //   97: astore_3
    //   98: aload_3
    //   99: aload 15
    //   101: invokevirtual 63	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   104: pop
    //   105: aload_3
    //   106: getfield 67	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:remain_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: istore_1
    //   113: aload_3
    //   114: getfield 77	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:image_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   117: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   120: lstore 13
    //   122: aload_3
    //   123: getfield 85	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:last_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 73	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: istore 5
    //   131: aload_3
    //   132: getfield 89	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:msg_tab	Lcom/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult;
    //   135: invokevirtual 94	com/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   138: checkcast 91	com/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult
    //   141: astore 15
    //   143: aload_3
    //   144: getfield 97	com/tencent/biz/qqstory/network/pb/qqstory_710_message$RspClearMessage:msg_dynamic	Lcom/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult;
    //   147: invokevirtual 94	com/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 91	com/tencent/biz/qqstory/network/pb/qqstory_710_message$ClearMessageResult
    //   153: astore_3
    //   154: iconst_1
    //   155: istore_2
    //   156: aload_0
    //   157: getfield 12	ntn:a	Lntj;
    //   160: getfield 103	ntj:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   163: getstatic 109	com/tencent/mobileqq/app/QQManagerFactory:MGR_RED_TOUCH_EX	I
    //   166: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   169: checkcast 117	ntq
    //   172: astore_3
    //   173: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +47 -> 223
    //   179: ldc 119
    //   181: iconst_2
    //   182: new 30	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   189: ldc 121
    //   191: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_2
    //   195: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   198: ldc 123
    //   200: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload_1
    //   204: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: ldc 128
    //   209: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 5
    //   214: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 131	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload_2
    //   224: ifeq +98 -> 322
    //   227: iload_1
    //   228: ifle +89 -> 317
    //   231: iconst_1
    //   232: istore_2
    //   233: aload_3
    //   234: iload_2
    //   235: iload_1
    //   236: lload 13
    //   238: iload 5
    //   240: bipush 52
    //   242: invokevirtual 134	ntq:a	(ZIJII)Z
    //   245: pop
    //   246: aload_0
    //   247: getfield 12	ntn:a	Lntj;
    //   250: bipush 105
    //   252: iconst_1
    //   253: aconst_null
    //   254: invokevirtual 138	ntj:notifyUI	(IZLjava/lang/Object;)V
    //   257: return
    //   258: astore_3
    //   259: iload 7
    //   261: istore_1
    //   262: iload 9
    //   264: istore_2
    //   265: iload_2
    //   266: istore 8
    //   268: iload 4
    //   270: istore 5
    //   272: lload 11
    //   274: lstore 13
    //   276: iload_1
    //   277: istore 6
    //   279: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +26 -> 308
    //   285: ldc 28
    //   287: iconst_2
    //   288: ldc 140
    //   290: aload_3
    //   291: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: iload_1
    //   295: istore 6
    //   297: lload 11
    //   299: lstore 13
    //   301: iload 4
    //   303: istore 5
    //   305: iload_2
    //   306: istore 8
    //   308: iload 6
    //   310: istore_1
    //   311: iload 8
    //   313: istore_2
    //   314: goto -158 -> 156
    //   317: iconst_0
    //   318: istore_2
    //   319: goto -86 -> 233
    //   322: aload_0
    //   323: getfield 12	ntn:a	Lntj;
    //   326: aload_3
    //   327: bipush 52
    //   329: invokevirtual 146	ntj:a	(Lntq;I)V
    //   332: goto -86 -> 246
    //   335: astore_3
    //   336: iload 9
    //   338: istore_2
    //   339: goto -74 -> 265
    //   342: astore_3
    //   343: lload 13
    //   345: lstore 11
    //   347: iload 9
    //   349: istore_2
    //   350: goto -85 -> 265
    //   353: astore_3
    //   354: iconst_1
    //   355: istore_2
    //   356: iload 5
    //   358: istore 4
    //   360: lload 13
    //   362: lstore 11
    //   364: goto -99 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	ntn
    //   0	367	1	paramInt	int
    //   0	367	2	paramBoolean	boolean
    //   0	367	3	paramBundle	android.os.Bundle
    //   43	316	4	i	int
    //   56	301	5	j	int
    //   35	274	6	k	int
    //   32	228	7	m	int
    //   49	263	8	bool1	boolean
    //   46	302	9	bool2	boolean
    //   52	23	10	bool3	boolean
    //   40	323	11	l1	long
    //   60	301	13	l2	long
    //   72	70	15	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	74	258	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   90	113	258	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	122	335	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	131	342	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   131	154	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */