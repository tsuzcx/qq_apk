package com.tencent.mobileqq.data;

public class MessageForLimitChatConfirm
  extends ChatMessage
{
  public static final String TAG = MessageForLimitChatConfirm.class.getName();
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
    //   1: getfield 61	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 63	java/io/ObjectInputStream
    //   11: dup
    //   12: new 65	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 61	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   20: invokespecial 68	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 71	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 75	java/io/ObjectInputStream:readBoolean	()Z
    //   34: putfield 34	com/tencent/mobileqq/data/MessageForLimitChatConfirm:bEnterMsg	Z
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_2
    //   41: invokevirtual 79	java/io/ObjectInputStream:readInt	()I
    //   44: putfield 36	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leaveChatType	I
    //   47: aload_2
    //   48: astore_1
    //   49: aload_0
    //   50: aload_2
    //   51: invokevirtual 79	java/io/ObjectInputStream:readInt	()I
    //   54: putfield 40	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leftChatTime	I
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: aload_2
    //   61: invokevirtual 83	java/io/ObjectInputStream:readLong	()J
    //   64: putfield 38	com/tencent/mobileqq/data/MessageForLimitChatConfirm:timeStamp	J
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: aload_2
    //   71: invokevirtual 79	java/io/ObjectInputStream:readInt	()I
    //   74: putfield 42	com/tencent/mobileqq/data/MessageForLimitChatConfirm:matchExpiredTime	I
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: aload_2
    //   81: invokevirtual 79	java/io/ObjectInputStream:readInt	()I
    //   84: putfield 44	com/tencent/mobileqq/data/MessageForLimitChatConfirm:c2cExpiredTime	I
    //   87: aload_2
    //   88: astore_1
    //   89: aload_0
    //   90: aload_2
    //   91: invokevirtual 86	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   94: putfield 48	com/tencent/mobileqq/data/MessageForLimitChatConfirm:SenderNickName	Ljava/lang/String;
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: aload_2
    //   101: invokevirtual 86	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   104: putfield 50	com/tencent/mobileqq/data/MessageForLimitChatConfirm:tipsWording	Ljava/lang/String;
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: aload_2
    //   111: invokevirtual 83	java/io/ObjectInputStream:readLong	()J
    //   114: putfield 52	com/tencent/mobileqq/data/MessageForLimitChatConfirm:readyTs	J
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 89	java/io/ObjectInputStream:close	()V
    //   125: new 63	java/io/ObjectInputStream
    //   128: dup
    //   129: new 65	java/io/ByteArrayInputStream
    //   132: dup
    //   133: aload_0
    //   134: getfield 61	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   137: invokespecial 68	java/io/ByteArrayInputStream:<init>	([B)V
    //   140: invokespecial 71	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: pop
    //   144: return
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   150: return
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   156: goto -31 -> 125
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +32 -> 199
    //   170: aload_2
    //   171: astore_1
    //   172: getstatic 28	com/tencent/mobileqq/data/MessageForLimitChatConfirm:TAG	Ljava/lang/String;
    //   175: iconst_2
    //   176: new 100	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   183: ldc 103
    //   185: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_3
    //   196: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_2
    //   200: ifnull -75 -> 125
    //   203: aload_2
    //   204: invokevirtual 89	java/io/ObjectInputStream:close	()V
    //   207: goto -82 -> 125
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   215: goto -90 -> 125
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 89	java/io/ObjectInputStream:close	()V
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   236: goto -7 -> 229
    //   239: astore_2
    //   240: goto -19 -> 221
    //   243: astore_3
    //   244: goto -82 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	MessageForLimitChatConfirm
    //   28	81	1	localObjectInputStream1	java.io.ObjectInputStream
    //   145	2	1	localIOException	java.io.IOException
    //   151	2	1	localException1	java.lang.Exception
    //   163	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   210	2	1	localException2	java.lang.Exception
    //   220	6	1	localObject1	java.lang.Object
    //   231	2	1	localException3	java.lang.Exception
    //   26	178	2	localObjectInputStream3	java.io.ObjectInputStream
    //   218	12	2	localObject2	java.lang.Object
    //   239	1	2	localObject3	java.lang.Object
    //   159	37	3	localException4	java.lang.Exception
    //   243	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   125	144	145	java/io/IOException
    //   121	125	151	java/lang/Exception
    //   8	27	159	java/lang/Exception
    //   203	207	210	java/lang/Exception
    //   8	27	218	finally
    //   225	229	231	java/lang/Exception
    //   29	37	239	finally
    //   39	47	239	finally
    //   49	57	239	finally
    //   59	67	239	finally
    //   69	77	239	finally
    //   79	87	239	finally
    //   89	97	239	finally
    //   99	107	239	finally
    //   109	117	239	finally
    //   164	170	239	finally
    //   172	199	239	finally
    //   29	37	243	java/lang/Exception
    //   39	47	243	java/lang/Exception
    //   49	57	243	java/lang/Exception
    //   59	67	243	java/lang/Exception
    //   69	77	243	java/lang/Exception
    //   79	87	243	java/lang/Exception
    //   89	97	243	java/lang/Exception
    //   99	107	243	java/lang/Exception
    //   109	117	243	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 128	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 129	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 131	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 134	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 34	com/tencent/mobileqq/data/MessageForLimitChatConfirm:bEnterMsg	Z
    //   26: invokevirtual 138	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 36	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leaveChatType	I
    //   36: invokevirtual 142	java/io/ObjectOutputStream:writeInt	(I)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 40	com/tencent/mobileqq/data/MessageForLimitChatConfirm:leftChatTime	I
    //   46: invokevirtual 142	java/io/ObjectOutputStream:writeInt	(I)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 38	com/tencent/mobileqq/data/MessageForLimitChatConfirm:timeStamp	J
    //   56: invokevirtual 146	java/io/ObjectOutputStream:writeLong	(J)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 42	com/tencent/mobileqq/data/MessageForLimitChatConfirm:matchExpiredTime	I
    //   66: invokevirtual 142	java/io/ObjectOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 44	com/tencent/mobileqq/data/MessageForLimitChatConfirm:c2cExpiredTime	I
    //   76: invokevirtual 142	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 48	com/tencent/mobileqq/data/MessageForLimitChatConfirm:SenderNickName	Ljava/lang/String;
    //   86: invokevirtual 150	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 50	com/tencent/mobileqq/data/MessageForLimitChatConfirm:tipsWording	Ljava/lang/String;
    //   96: invokevirtual 150	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 52	com/tencent/mobileqq/data/MessageForLimitChatConfirm:readyTs	J
    //   106: invokevirtual 146	java/io/ObjectOutputStream:writeLong	(J)V
    //   109: aload_2
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 151	java/io/ObjectOutputStream:close	()V
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: aload 4
    //   120: invokevirtual 154	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   123: putfield 61	com/tencent/mobileqq/data/MessageForLimitChatConfirm:msgData	[B
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 151	java/io/ObjectOutputStream:close	()V
    //   134: aload 4
    //   136: ifnull +8 -> 144
    //   139: aload 4
    //   141: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   144: return
    //   145: astore_1
    //   146: aload_1
    //   147: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   150: goto -16 -> 134
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   158: return
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +32 -> 199
    //   170: aload_2
    //   171: astore_1
    //   172: getstatic 28	com/tencent/mobileqq/data/MessageForLimitChatConfirm:TAG	Ljava/lang/String;
    //   175: iconst_2
    //   176: new 100	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   183: ldc 157
    //   185: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_3
    //   196: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 151	java/io/ObjectOutputStream:close	()V
    //   207: aload 4
    //   209: ifnull -65 -> 144
    //   212: aload 4
    //   214: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   217: return
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   223: return
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   229: goto -22 -> 207
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 151	java/io/ObjectOutputStream:close	()V
    //   243: aload 4
    //   245: ifnull +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 155	java/io/ByteArrayOutputStream:close	()V
    //   253: aload_2
    //   254: athrow
    //   255: astore_1
    //   256: aload_1
    //   257: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   260: goto -17 -> 243
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   268: goto -15 -> 253
    //   271: astore_2
    //   272: goto -37 -> 235
    //   275: astore_3
    //   276: goto -114 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	MessageForLimitChatConfirm
    //   20	97	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   145	2	1	localException1	java.lang.Exception
    //   153	2	1	localException2	java.lang.Exception
    //   163	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   218	2	1	localException3	java.lang.Exception
    //   224	2	1	localException4	java.lang.Exception
    //   234	6	1	localObject1	java.lang.Object
    //   255	2	1	localException5	java.lang.Exception
    //   263	2	1	localException6	java.lang.Exception
    //   18	186	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   232	22	2	localObject2	java.lang.Object
    //   271	1	2	localObject3	java.lang.Object
    //   159	37	3	localException7	java.lang.Exception
    //   275	1	3	localException8	java.lang.Exception
    //   7	242	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   130	134	145	java/lang/Exception
    //   139	144	153	java/lang/Exception
    //   9	19	159	java/lang/Exception
    //   212	217	218	java/lang/Exception
    //   203	207	224	java/lang/Exception
    //   9	19	232	finally
    //   239	243	255	java/lang/Exception
    //   248	253	263	java/lang/Exception
    //   21	29	271	finally
    //   31	39	271	finally
    //   41	49	271	finally
    //   51	59	271	finally
    //   61	69	271	finally
    //   71	79	271	finally
    //   81	89	271	finally
    //   91	99	271	finally
    //   101	109	271	finally
    //   111	115	271	finally
    //   117	126	271	finally
    //   164	170	271	finally
    //   172	199	271	finally
    //   21	29	275	java/lang/Exception
    //   31	39	275	java/lang/Exception
    //   41	49	275	java/lang/Exception
    //   51	59	275	java/lang/Exception
    //   61	69	275	java/lang/Exception
    //   71	79	275	java/lang/Exception
    //   81	89	275	java/lang/Exception
    //   91	99	275	java/lang/Exception
    //   101	109	275	java/lang/Exception
    //   111	115	275	java/lang/Exception
    //   117	126	275	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLimitChatConfirm
 * JD-Core Version:    0.7.0.1
 */