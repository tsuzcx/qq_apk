package com.tencent.mobileqq.data;

public class MessageForSplitLineTips
  extends ChatMessage
{
  public static final String TAG = MessageForSplitLineTips.class.getName();
  public static final int TYPE_TROOP_HISTORY_MESSAGE_TIPS = 1;
  public static int VERSION = 1;
  public String msgContent;
  public int subType;
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 39	java/io/ObjectInputStream
    //   11: dup
    //   12: new 41	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 37	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   20: invokespecial 44	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 47	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: invokevirtual 51	java/io/ObjectInputStream:readInt	()I
    //   33: pop
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 51	java/io/ObjectInputStream:readInt	()I
    //   41: putfield 53	com/tencent/mobileqq/data/MessageForSplitLineTips:subType	I
    //   44: aload_2
    //   45: astore_1
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 56	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   51: putfield 58	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: aload_0
    //   58: invokevirtual 61	com/tencent/mobileqq/data/MessageForSplitLineTips:getSummaryMsg	()Ljava/lang/String;
    //   61: putfield 64	com/tencent/mobileqq/data/MessageForSplitLineTips:msg	Ljava/lang/String;
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 67	java/io/ObjectInputStream:close	()V
    //   72: new 39	java/io/ObjectInputStream
    //   75: dup
    //   76: new 41	java/io/ByteArrayInputStream
    //   79: dup
    //   80: aload_0
    //   81: getfield 37	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   84: invokespecial 44	java/io/ByteArrayInputStream:<init>	([B)V
    //   87: invokespecial 47	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: pop
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   103: goto -31 -> 72
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +32 -> 146
    //   117: aload_2
    //   118: astore_1
    //   119: getstatic 22	com/tencent/mobileqq/data/MessageForSplitLineTips:TAG	Ljava/lang/String;
    //   122: iconst_2
    //   123: new 79	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   130: ldc 82
    //   132: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload_3
    //   143: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_2
    //   147: ifnull -75 -> 72
    //   150: aload_2
    //   151: invokevirtual 67	java/io/ObjectInputStream:close	()V
    //   154: goto -82 -> 72
    //   157: astore_1
    //   158: aload_1
    //   159: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   162: goto -90 -> 72
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 67	java/io/ObjectInputStream:close	()V
    //   176: aload_2
    //   177: athrow
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   183: goto -7 -> 176
    //   186: astore_2
    //   187: goto -19 -> 168
    //   190: astore_3
    //   191: goto -82 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	MessageForSplitLineTips
    //   28	28	1	localObjectInputStream1	java.io.ObjectInputStream
    //   92	2	1	localIOException	java.io.IOException
    //   98	2	1	localException1	java.lang.Exception
    //   110	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   157	2	1	localException2	java.lang.Exception
    //   167	6	1	localObject1	java.lang.Object
    //   178	2	1	localException3	java.lang.Exception
    //   26	125	2	localObjectInputStream3	java.io.ObjectInputStream
    //   165	12	2	localObject2	java.lang.Object
    //   186	1	2	localObject3	java.lang.Object
    //   106	37	3	localException4	java.lang.Exception
    //   190	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   72	91	92	java/io/IOException
    //   68	72	98	java/lang/Exception
    //   8	27	106	java/lang/Exception
    //   150	154	157	java/lang/Exception
    //   8	27	165	finally
    //   172	176	178	java/lang/Exception
    //   29	34	186	finally
    //   36	44	186	finally
    //   46	54	186	finally
    //   56	64	186	finally
    //   111	117	186	finally
    //   119	146	186	finally
    //   29	34	190	java/lang/Exception
    //   36	44	190	java/lang/Exception
    //   46	54	190	java/lang/Exception
    //   56	64	190	java/lang/Exception
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
    //   0: new 107	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 108	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 110	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 113	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: getstatic 24	com/tencent/mobileqq/data/MessageForSplitLineTips:VERSION	I
    //   25: invokevirtual 117	java/io/ObjectOutputStream:writeInt	(I)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 53	com/tencent/mobileqq/data/MessageForSplitLineTips:subType	I
    //   35: invokevirtual 117	java/io/ObjectOutputStream:writeInt	(I)V
    //   38: aload_2
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 58	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   44: ifnonnull +49 -> 93
    //   47: ldc 119
    //   49: astore_3
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 123	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: invokevirtual 124	java/io/ObjectOutputStream:close	()V
    //   63: aload_2
    //   64: astore_1
    //   65: aload_0
    //   66: aload 4
    //   68: invokevirtual 127	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: putfield 37	com/tencent/mobileqq/data/MessageForSplitLineTips:msgData	[B
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 124	java/io/ObjectOutputStream:close	()V
    //   82: aload 4
    //   84: ifnull +8 -> 92
    //   87: aload 4
    //   89: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   92: return
    //   93: aload_2
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 58	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   99: astore_3
    //   100: goto -50 -> 50
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   108: goto -26 -> 82
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   116: return
    //   117: astore_3
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: astore_1
    //   122: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +32 -> 157
    //   128: aload_2
    //   129: astore_1
    //   130: getstatic 22	com/tencent/mobileqq/data/MessageForSplitLineTips:TAG	Ljava/lang/String;
    //   133: iconst_2
    //   134: new 79	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   141: ldc 130
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: aload_3
    //   154: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 124	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: ifnull -75 -> 92
    //   170: aload 4
    //   172: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   175: return
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   181: return
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   187: goto -22 -> 165
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +7 -> 201
    //   197: aload_1
    //   198: invokevirtual 124	java/io/ObjectOutputStream:close	()V
    //   201: aload 4
    //   203: ifnull +8 -> 211
    //   206: aload 4
    //   208: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   211: aload_2
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   218: goto -17 -> 201
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 71	java/lang/Exception:printStackTrace	()V
    //   226: goto -15 -> 211
    //   229: astore_2
    //   230: goto -37 -> 193
    //   233: astore_3
    //   234: goto -114 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	MessageForSplitLineTips
    //   20	75	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   103	2	1	localException1	java.lang.Exception
    //   111	2	1	localException2	java.lang.Exception
    //   121	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   176	2	1	localException3	java.lang.Exception
    //   182	2	1	localException4	java.lang.Exception
    //   192	6	1	localObject1	java.lang.Object
    //   213	2	1	localException5	java.lang.Exception
    //   221	2	1	localException6	java.lang.Exception
    //   18	144	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   190	22	2	localObject2	java.lang.Object
    //   229	1	2	localObject3	java.lang.Object
    //   49	51	3	str	String
    //   117	37	3	localException7	java.lang.Exception
    //   233	1	3	localException8	java.lang.Exception
    //   7	200	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   78	82	103	java/lang/Exception
    //   87	92	111	java/lang/Exception
    //   9	19	117	java/lang/Exception
    //   170	175	176	java/lang/Exception
    //   161	165	182	java/lang/Exception
    //   9	19	190	finally
    //   197	201	213	java/lang/Exception
    //   206	211	221	java/lang/Exception
    //   21	28	229	finally
    //   30	38	229	finally
    //   40	47	229	finally
    //   52	57	229	finally
    //   59	63	229	finally
    //   65	74	229	finally
    //   95	100	229	finally
    //   122	128	229	finally
    //   130	157	229	finally
    //   21	28	233	java/lang/Exception
    //   30	38	233	java/lang/Exception
    //   40	47	233	java/lang/Exception
    //   52	57	233	java/lang/Exception
    //   59	63	233	java/lang/Exception
    //   65	74	233	java/lang/Exception
    //   95	100	233	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForSplitLineTips
 * JD-Core Version:    0.7.0.1
 */