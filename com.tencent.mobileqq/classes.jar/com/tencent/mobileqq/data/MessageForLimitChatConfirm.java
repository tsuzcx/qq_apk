package com.tencent.mobileqq.data;

public class MessageForLimitChatConfirm
  extends ChatMessage
{
  public static final String TAG = "com.tencent.mobileqq.data.MessageForLimitChatConfirm";
  public String SenderNickName = "";
  public boolean bEnterMsg = true;
  public int c2cExpiredTime = 0;
  public int leaveChatType = -1;
  public int leftChatTime = -1;
  public int matchExpiredTime = 0;
  public long readyTs = 0L;
  public long timeStamp = 0L;
  public String tipsWording = "";
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 57	java/io/ObjectInputStream
    //   11: dup
    //   12: new 59	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 55	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   20: invokespecial 62	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 65	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 69	java/io/ObjectInputStream:readBoolean	()Z
    //   34: putfield 28	com/tencent/mobileqq/data/MessageForLimitChatConfirm:bEnterMsg	Z
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_2
    //   41: invokevirtual 73	java/io/ObjectInputStream:readInt	()I
    //   44: putfield 30	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leaveChatType	I
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: aload_2
    //   51: invokevirtual 73	java/io/ObjectInputStream:readInt	()I
    //   54: putfield 34	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leftChatTime	I
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 77	java/io/ObjectInputStream:readLong	()J
    //   64: putfield 32	com/tencent/mobileqq/data/MessageForLimitChatConfirm:timeStamp	J
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: aload_2
    //   71: invokevirtual 73	java/io/ObjectInputStream:readInt	()I
    //   74: putfield 36	com/tencent/mobileqq/data/MessageForLimitChatConfirm:matchExpiredTime	I
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 73	java/io/ObjectInputStream:readInt	()I
    //   84: putfield 38	com/tencent/mobileqq/data/MessageForLimitChatConfirm:c2cExpiredTime	I
    //   87: aload_2
    //   88: astore_1
    //   89: aload_0
    //   90: aload_2
    //   91: invokevirtual 81	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   94: putfield 42	com/tencent/mobileqq/data/MessageForLimitChatConfirm:SenderNickName	Ljava/lang/String;
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: aload_2
    //   101: invokevirtual 81	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   104: putfield 44	com/tencent/mobileqq/data/MessageForLimitChatConfirm:tipsWording	Ljava/lang/String;
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: aload_2
    //   111: invokevirtual 77	java/io/ObjectInputStream:readLong	()J
    //   114: putfield 46	com/tencent/mobileqq/data/MessageForLimitChatConfirm:readyTs	J
    //   117: aload_2
    //   118: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   121: goto +91 -> 212
    //   124: astore_3
    //   125: goto +12 -> 137
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: goto +112 -> 243
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: astore_1
    //   139: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +54 -> 196
    //   145: aload_2
    //   146: astore_1
    //   147: getstatic 91	com/tencent/mobileqq/data/MessageForLimitChatConfirm:TAG	Ljava/lang/String;
    //   150: astore 4
    //   152: aload_2
    //   153: astore_1
    //   154: new 93	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   161: astore 5
    //   163: aload_2
    //   164: astore_1
    //   165: aload 5
    //   167: ldc 96
    //   169: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: astore_1
    //   175: aload 5
    //   177: aload_3
    //   178: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: astore_1
    //   184: aload 4
    //   186: iconst_2
    //   187: aload 5
    //   189: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload_3
    //   193: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_2
    //   197: ifnull +15 -> 212
    //   200: aload_2
    //   201: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   204: goto +8 -> 212
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   212: new 57	java/io/ObjectInputStream
    //   215: dup
    //   216: new 59	java/io/ByteArrayInputStream
    //   219: dup
    //   220: aload_0
    //   221: getfield 55	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   224: invokespecial 62	java/io/ByteArrayInputStream:<init>	([B)V
    //   227: invokespecial 65	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   230: pop
    //   231: return
    //   232: astore_1
    //   233: aload_1
    //   234: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: astore_3
    //   239: aload_1
    //   240: astore_2
    //   241: aload_3
    //   242: astore_1
    //   243: aload_2
    //   244: ifnull +15 -> 259
    //   247: aload_2
    //   248: invokevirtual 84	java/io/ObjectInputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   259: aload_1
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	MessageForLimitChatConfirm
    //   28	81	1	localObject1	java.lang.Object
    //   128	1	1	localObject2	java.lang.Object
    //   138	46	1	localObject3	java.lang.Object
    //   207	2	1	localException1	java.lang.Exception
    //   232	8	1	localIOException	java.io.IOException
    //   242	18	1	localObject4	java.lang.Object
    //   26	222	2	localObject5	java.lang.Object
    //   254	2	2	localException2	java.lang.Exception
    //   124	1	3	localException3	java.lang.Exception
    //   134	59	3	localException4	java.lang.Exception
    //   238	4	3	localObject6	java.lang.Object
    //   150	35	4	str	String
    //   161	27	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	37	124	java/lang/Exception
    //   39	47	124	java/lang/Exception
    //   49	57	124	java/lang/Exception
    //   59	67	124	java/lang/Exception
    //   69	77	124	java/lang/Exception
    //   79	87	124	java/lang/Exception
    //   89	97	124	java/lang/Exception
    //   99	107	124	java/lang/Exception
    //   109	117	124	java/lang/Exception
    //   8	27	128	finally
    //   8	27	134	java/lang/Exception
    //   117	121	207	java/lang/Exception
    //   200	204	207	java/lang/Exception
    //   212	231	232	java/io/IOException
    //   29	37	238	finally
    //   39	47	238	finally
    //   49	57	238	finally
    //   59	67	238	finally
    //   69	77	238	finally
    //   79	87	238	finally
    //   89	97	238	finally
    //   99	107	238	finally
    //   109	117	238	finally
    //   139	145	238	finally
    //   147	152	238	finally
    //   154	163	238	finally
    //   165	173	238	finally
    //   175	182	238	finally
    //   184	196	238	finally
    //   247	251	254	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 125	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 126	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 128	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 131	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 28	com/tencent/mobileqq/data/MessageForLimitChatConfirm:bEnterMsg	Z
    //   26: invokevirtual 135	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 30	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leaveChatType	I
    //   36: invokevirtual 139	java/io/ObjectOutputStream:writeInt	(I)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 34	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leftChatTime	I
    //   46: invokevirtual 139	java/io/ObjectOutputStream:writeInt	(I)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 32	com/tencent/mobileqq/data/MessageForLimitChatConfirm:timeStamp	J
    //   56: invokevirtual 143	java/io/ObjectOutputStream:writeLong	(J)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 36	com/tencent/mobileqq/data/MessageForLimitChatConfirm:matchExpiredTime	I
    //   66: invokevirtual 139	java/io/ObjectOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 38	com/tencent/mobileqq/data/MessageForLimitChatConfirm:c2cExpiredTime	I
    //   76: invokevirtual 139	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 42	com/tencent/mobileqq/data/MessageForLimitChatConfirm:SenderNickName	Ljava/lang/String;
    //   86: invokevirtual 147	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 44	com/tencent/mobileqq/data/MessageForLimitChatConfirm:tipsWording	Ljava/lang/String;
    //   96: invokevirtual 147	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 46	com/tencent/mobileqq/data/MessageForLimitChatConfirm:readyTs	J
    //   106: invokevirtual 143	java/io/ObjectOutputStream:writeLong	(J)V
    //   109: aload_2
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 148	java/io/ObjectOutputStream:close	()V
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: aload 4
    //   120: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   123: putfield 55	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   126: aload_2
    //   127: invokevirtual 148	java/io/ObjectOutputStream:close	()V
    //   130: goto +8 -> 138
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   138: aload 4
    //   140: invokevirtual 152	java/io/ByteArrayOutputStream:close	()V
    //   143: return
    //   144: astore_3
    //   145: goto +12 -> 157
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_2
    //   151: goto +98 -> 249
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +54 -> 216
    //   165: aload_2
    //   166: astore_1
    //   167: getstatic 91	com/tencent/mobileqq/data/MessageForLimitChatConfirm:TAG	Ljava/lang/String;
    //   170: astore 5
    //   172: aload_2
    //   173: astore_1
    //   174: new 93	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   181: astore 6
    //   183: aload_2
    //   184: astore_1
    //   185: aload 6
    //   187: ldc 154
    //   189: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: astore_1
    //   195: aload 6
    //   197: aload_3
    //   198: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: astore_1
    //   204: aload 5
    //   206: iconst_2
    //   207: aload 6
    //   209: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: aload_3
    //   213: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: ifnull +15 -> 232
    //   220: aload_2
    //   221: invokevirtual 148	java/io/ObjectOutputStream:close	()V
    //   224: goto +8 -> 232
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   232: aload 4
    //   234: invokevirtual 152	java/io/ByteArrayOutputStream:close	()V
    //   237: return
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   243: return
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: astore_1
    //   249: aload_2
    //   250: ifnull +15 -> 265
    //   253: aload_2
    //   254: invokevirtual 148	java/io/ObjectOutputStream:close	()V
    //   257: goto +8 -> 265
    //   260: astore_2
    //   261: aload_2
    //   262: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   265: aload 4
    //   267: invokevirtual 152	java/io/ByteArrayOutputStream:close	()V
    //   270: goto +8 -> 278
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	MessageForLimitChatConfirm
    //   20	97	1	localObject1	java.lang.Object
    //   133	2	1	localException1	java.lang.Exception
    //   148	1	1	localObject2	java.lang.Object
    //   158	46	1	localObject3	java.lang.Object
    //   227	2	1	localException2	java.lang.Exception
    //   238	8	1	localException3	java.lang.Exception
    //   248	31	1	localObject4	java.lang.Object
    //   18	236	2	localObject5	java.lang.Object
    //   260	2	2	localException4	java.lang.Exception
    //   273	2	2	localException5	java.lang.Exception
    //   144	1	3	localException6	java.lang.Exception
    //   154	59	3	localException7	java.lang.Exception
    //   244	4	3	localObject6	java.lang.Object
    //   7	259	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   170	35	5	str	String
    //   181	27	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   126	130	133	java/lang/Exception
    //   21	29	144	java/lang/Exception
    //   31	39	144	java/lang/Exception
    //   41	49	144	java/lang/Exception
    //   51	59	144	java/lang/Exception
    //   61	69	144	java/lang/Exception
    //   71	79	144	java/lang/Exception
    //   81	89	144	java/lang/Exception
    //   91	99	144	java/lang/Exception
    //   101	109	144	java/lang/Exception
    //   111	115	144	java/lang/Exception
    //   117	126	144	java/lang/Exception
    //   9	19	148	finally
    //   9	19	154	java/lang/Exception
    //   220	224	227	java/lang/Exception
    //   138	143	238	java/lang/Exception
    //   232	237	238	java/lang/Exception
    //   21	29	244	finally
    //   31	39	244	finally
    //   41	49	244	finally
    //   51	59	244	finally
    //   61	69	244	finally
    //   71	79	244	finally
    //   81	89	244	finally
    //   91	99	244	finally
    //   101	109	244	finally
    //   111	115	244	finally
    //   117	126	244	finally
    //   159	165	244	finally
    //   167	172	244	finally
    //   174	183	244	finally
    //   185	193	244	finally
    //   195	202	244	finally
    //   204	216	244	finally
    //   253	257	260	java/lang/Exception
    //   265	270	273	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLimitChatConfirm
 * JD-Core Version:    0.7.0.1
 */