package com.tencent.mobileqq.data;

public class MessageForSplitLineTips
  extends ChatMessage
{
  public static final String TAG = "com.tencent.mobileqq.data.MessageForSplitLineTips";
  public static final int TYPE_TROOP_HISTORY_MESSAGE_TIPS = 1;
  public static int VERSION = 1;
  public String msgContent;
  public int subType = 0;
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 33	java/io/ObjectInputStream
    //   11: dup
    //   12: new 35	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 31	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   20: invokespecial 38	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 41	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: invokevirtual 45	java/io/ObjectInputStream:readInt	()I
    //   33: pop
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 45	java/io/ObjectInputStream:readInt	()I
    //   41: putfield 22	com/tencent/mobileqq/data/MessageForSplitLineTips:subType	I
    //   44: aload_2
    //   45: astore_1
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 49	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   51: putfield 51	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: aload_0
    //   58: invokevirtual 54	com/tencent/mobileqq/data/MessageForSplitLineTips:getSummaryMsg	()Ljava/lang/String;
    //   61: putfield 57	com/tencent/mobileqq/data/MessageForSplitLineTips:msg	Ljava/lang/String;
    //   64: aload_2
    //   65: invokevirtual 60	java/io/ObjectInputStream:close	()V
    //   68: goto +91 -> 159
    //   71: astore_3
    //   72: goto +12 -> 84
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_2
    //   78: goto +112 -> 190
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +54 -> 143
    //   92: aload_2
    //   93: astore_1
    //   94: getstatic 68	com/tencent/mobileqq/data/MessageForSplitLineTips:TAG	Ljava/lang/String;
    //   97: astore 4
    //   99: aload_2
    //   100: astore_1
    //   101: new 70	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   108: astore 5
    //   110: aload_2
    //   111: astore_1
    //   112: aload 5
    //   114: ldc 73
    //   116: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: astore_1
    //   122: aload 5
    //   124: aload_3
    //   125: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_2
    //   130: astore_1
    //   131: aload 4
    //   133: iconst_2
    //   134: aload 5
    //   136: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_3
    //   140: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_2
    //   144: ifnull +15 -> 159
    //   147: aload_2
    //   148: invokevirtual 60	java/io/ObjectInputStream:close	()V
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   159: new 33	java/io/ObjectInputStream
    //   162: dup
    //   163: new 35	java/io/ByteArrayInputStream
    //   166: dup
    //   167: aload_0
    //   168: getfield 31	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   171: invokespecial 38	java/io/ByteArrayInputStream:<init>	([B)V
    //   174: invokespecial 41	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: pop
    //   178: return
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   184: return
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: aload_2
    //   191: ifnull +15 -> 206
    //   194: aload_2
    //   195: invokevirtual 60	java/io/ObjectInputStream:close	()V
    //   198: goto +8 -> 206
    //   201: astore_2
    //   202: aload_2
    //   203: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   206: aload_1
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	MessageForSplitLineTips
    //   28	28	1	localObject1	java.lang.Object
    //   75	1	1	localObject2	java.lang.Object
    //   85	46	1	localObject3	java.lang.Object
    //   154	2	1	localException1	java.lang.Exception
    //   179	8	1	localIOException	java.io.IOException
    //   189	18	1	localObject4	java.lang.Object
    //   26	169	2	localObject5	java.lang.Object
    //   201	2	2	localException2	java.lang.Exception
    //   71	1	3	localException3	java.lang.Exception
    //   81	59	3	localException4	java.lang.Exception
    //   185	4	3	localObject6	java.lang.Object
    //   97	35	4	str	String
    //   108	27	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	34	71	java/lang/Exception
    //   36	44	71	java/lang/Exception
    //   46	54	71	java/lang/Exception
    //   56	64	71	java/lang/Exception
    //   8	27	75	finally
    //   8	27	81	java/lang/Exception
    //   64	68	154	java/lang/Exception
    //   147	151	154	java/lang/Exception
    //   159	178	179	java/io/IOException
    //   29	34	185	finally
    //   36	44	185	finally
    //   46	54	185	finally
    //   56	64	185	finally
    //   86	92	185	finally
    //   94	99	185	finally
    //   101	110	185	finally
    //   112	120	185	finally
    //   122	129	185	finally
    //   131	143	185	finally
    //   194	198	201	java/lang/Exception
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
  protected void prewrite()
  {
    // Byte code:
    //   0: new 102	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 103	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 105	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 108	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: getstatic 110	com/tencent/mobileqq/data/MessageForSplitLineTips:VERSION	I
    //   25: invokevirtual 114	java/io/ObjectOutputStream:writeInt	(I)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 22	com/tencent/mobileqq/data/MessageForSplitLineTips:subType	I
    //   35: invokevirtual 114	java/io/ObjectOutputStream:writeInt	(I)V
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 51	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   44: ifnonnull +9 -> 53
    //   47: ldc 116
    //   49: astore_3
    //   50: goto +10 -> 60
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: getfield 51	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual 120	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_2
    //   70: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   73: aload_2
    //   74: astore_1
    //   75: aload_0
    //   76: aload 4
    //   78: invokevirtual 124	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: putfield 31	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   84: aload_2
    //   85: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   88: goto +8 -> 96
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   96: aload 4
    //   98: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   101: return
    //   102: astore_3
    //   103: goto +12 -> 115
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_2
    //   109: goto +98 -> 207
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +54 -> 174
    //   123: aload_2
    //   124: astore_1
    //   125: getstatic 68	com/tencent/mobileqq/data/MessageForSplitLineTips:TAG	Ljava/lang/String;
    //   128: astore 5
    //   130: aload_2
    //   131: astore_1
    //   132: new 70	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   139: astore 6
    //   141: aload_2
    //   142: astore_1
    //   143: aload 6
    //   145: ldc 127
    //   147: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: astore_1
    //   153: aload 6
    //   155: aload_3
    //   156: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: astore_1
    //   162: aload 5
    //   164: iconst_2
    //   165: aload 6
    //   167: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_3
    //   171: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_2
    //   175: ifnull +15 -> 190
    //   178: aload_2
    //   179: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   182: goto +8 -> 190
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   190: aload 4
    //   192: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   195: return
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   201: return
    //   202: astore_3
    //   203: aload_1
    //   204: astore_2
    //   205: aload_3
    //   206: astore_1
    //   207: aload_2
    //   208: ifnull +15 -> 223
    //   211: aload_2
    //   212: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   215: goto +8 -> 223
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   223: aload 4
    //   225: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   228: goto +8 -> 236
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   236: aload_1
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	MessageForSplitLineTips
    //   20	55	1	localObject1	java.lang.Object
    //   91	2	1	localException1	java.lang.Exception
    //   106	1	1	localObject2	java.lang.Object
    //   116	46	1	localObject3	java.lang.Object
    //   185	2	1	localException2	java.lang.Exception
    //   196	8	1	localException3	java.lang.Exception
    //   206	31	1	localObject4	java.lang.Object
    //   18	194	2	localObject5	java.lang.Object
    //   218	2	2	localException4	java.lang.Exception
    //   231	2	2	localException5	java.lang.Exception
    //   49	15	3	str1	String
    //   102	1	3	localException6	java.lang.Exception
    //   112	59	3	localException7	java.lang.Exception
    //   202	4	3	localObject6	java.lang.Object
    //   7	217	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   128	35	5	str2	String
    //   139	27	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	88	91	java/lang/Exception
    //   21	28	102	java/lang/Exception
    //   30	38	102	java/lang/Exception
    //   40	47	102	java/lang/Exception
    //   55	60	102	java/lang/Exception
    //   62	67	102	java/lang/Exception
    //   69	73	102	java/lang/Exception
    //   75	84	102	java/lang/Exception
    //   9	19	106	finally
    //   9	19	112	java/lang/Exception
    //   178	182	185	java/lang/Exception
    //   96	101	196	java/lang/Exception
    //   190	195	196	java/lang/Exception
    //   21	28	202	finally
    //   30	38	202	finally
    //   40	47	202	finally
    //   55	60	202	finally
    //   62	67	202	finally
    //   69	73	202	finally
    //   75	84	202	finally
    //   117	123	202	finally
    //   125	130	202	finally
    //   132	141	202	finally
    //   143	151	202	finally
    //   153	160	202	finally
    //   162	174	202	finally
    //   211	215	218	java/lang/Exception
    //   223	228	231	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForSplitLineTips
 * JD-Core Version:    0.7.0.1
 */