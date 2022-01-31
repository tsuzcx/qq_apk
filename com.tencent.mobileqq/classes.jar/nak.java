import mqq.observer.BusinessObserver;

class nak
  implements BusinessObserver
{
  nak(nag paramnag) {}
  
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
    //   63: ifeq +244 -> 307
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
    //   157: getfield 12	nak:a	Lnag;
    //   160: getfield 103	nag:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   163: bipush 70
    //   165: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   168: checkcast 111	nan
    //   171: astore_3
    //   172: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +47 -> 222
    //   178: ldc 113
    //   180: iconst_2
    //   181: new 30	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   188: ldc 115
    //   190: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: iload_2
    //   194: invokevirtual 40	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: ldc 117
    //   199: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload_1
    //   203: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc 122
    //   208: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 5
    //   213: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: iload_2
    //   223: ifeq +98 -> 321
    //   226: iload_1
    //   227: ifle +89 -> 316
    //   230: iconst_1
    //   231: istore_2
    //   232: aload_3
    //   233: iload_2
    //   234: iload_1
    //   235: lload 13
    //   237: iload 5
    //   239: bipush 52
    //   241: invokevirtual 128	nan:a	(ZIJII)Z
    //   244: pop
    //   245: aload_0
    //   246: getfield 12	nak:a	Lnag;
    //   249: bipush 105
    //   251: iconst_1
    //   252: aconst_null
    //   253: invokevirtual 132	nag:notifyUI	(IZLjava/lang/Object;)V
    //   256: return
    //   257: astore_3
    //   258: iload 7
    //   260: istore_1
    //   261: iload 9
    //   263: istore_2
    //   264: iload_2
    //   265: istore 8
    //   267: iload 4
    //   269: istore 5
    //   271: lload 11
    //   273: lstore 13
    //   275: iload_1
    //   276: istore 6
    //   278: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +26 -> 307
    //   284: ldc 28
    //   286: iconst_2
    //   287: ldc 134
    //   289: aload_3
    //   290: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: iload_1
    //   294: istore 6
    //   296: lload 11
    //   298: lstore 13
    //   300: iload 4
    //   302: istore 5
    //   304: iload_2
    //   305: istore 8
    //   307: iload 6
    //   309: istore_1
    //   310: iload 8
    //   312: istore_2
    //   313: goto -157 -> 156
    //   316: iconst_0
    //   317: istore_2
    //   318: goto -86 -> 232
    //   321: aload_0
    //   322: getfield 12	nak:a	Lnag;
    //   325: aload_3
    //   326: bipush 52
    //   328: invokevirtual 140	nag:a	(Lnan;I)V
    //   331: goto -86 -> 245
    //   334: astore_3
    //   335: iload 9
    //   337: istore_2
    //   338: goto -74 -> 264
    //   341: astore_3
    //   342: lload 13
    //   344: lstore 11
    //   346: iload 9
    //   348: istore_2
    //   349: goto -85 -> 264
    //   352: astore_3
    //   353: iconst_1
    //   354: istore_2
    //   355: iload 5
    //   357: istore 4
    //   359: lload 13
    //   361: lstore 11
    //   363: goto -99 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	nak
    //   0	366	1	paramInt	int
    //   0	366	2	paramBoolean	boolean
    //   0	366	3	paramBundle	android.os.Bundle
    //   43	315	4	i	int
    //   56	300	5	j	int
    //   35	273	6	k	int
    //   32	227	7	m	int
    //   49	262	8	bool1	boolean
    //   46	301	9	bool2	boolean
    //   52	23	10	bool3	boolean
    //   40	322	11	l1	long
    //   60	300	13	l2	long
    //   72	70	15	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	74	257	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   90	113	257	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	122	334	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	131	341	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   131	154	352	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nak
 * JD-Core Version:    0.7.0.1
 */