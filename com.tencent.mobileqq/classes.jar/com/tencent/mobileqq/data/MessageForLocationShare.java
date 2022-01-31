package com.tencent.mobileqq.data;

import ault;

public class MessageForLocationShare
  extends ChatMessage
{
  private static final String TAG = "MessageForLocationShare";
  @ault(a=1)
  public boolean isSharingLocation = true;
  
  public MessageForLocationShare()
  {
    this.msgtype = -2076;
  }
  
  public byte[] convertToMsgData()
  {
    prewrite();
    return this.msgData;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 38	java/io/ObjectInputStream
    //   11: dup
    //   12: new 40	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 33	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   20: invokespecial 43	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: invokespecial 46	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 50	java/io/ObjectInputStream:readBoolean	()Z
    //   34: putfield 19	com/tencent/mobileqq/data/MessageForLocationShare:isSharingLocation	Z
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_2
    //   41: invokevirtual 54	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   44: putfield 57	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   47: aload_2
    //   48: astore_1
    //   49: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +47 -> 99
    //   55: aload_2
    //   56: astore_1
    //   57: ldc 8
    //   59: iconst_2
    //   60: iconst_5
    //   61: anewarray 64	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc 66
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 68
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: aload_0
    //   77: getfield 57	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   80: aastore
    //   81: dup
    //   82: iconst_3
    //   83: ldc 70
    //   85: aastore
    //   86: dup
    //   87: iconst_4
    //   88: aload_0
    //   89: getfield 19	com/tencent/mobileqq/data/MessageForLocationShare:isSharingLocation	Z
    //   92: invokestatic 76	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: aastore
    //   96: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   99: aload_2
    //   100: ifnull -93 -> 7
    //   103: aload_2
    //   104: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   107: return
    //   108: astore_1
    //   109: ldc 8
    //   111: iconst_1
    //   112: ldc 85
    //   114: aload_1
    //   115: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   118: return
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: astore_1
    //   124: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +14 -> 141
    //   130: aload_2
    //   131: astore_1
    //   132: ldc 8
    //   134: iconst_2
    //   135: ldc 91
    //   137: aload_3
    //   138: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: ifnull -135 -> 7
    //   145: aload_2
    //   146: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   149: return
    //   150: astore_1
    //   151: ldc 8
    //   153: iconst_1
    //   154: ldc 85
    //   156: aload_1
    //   157: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: return
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   172: aload_2
    //   173: athrow
    //   174: astore_1
    //   175: ldc 8
    //   177: iconst_1
    //   178: ldc 85
    //   180: aload_1
    //   181: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -12 -> 172
    //   187: astore_2
    //   188: goto -24 -> 164
    //   191: astore_3
    //   192: goto -70 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	MessageForLocationShare
    //   28	29	1	localObjectInputStream1	java.io.ObjectInputStream
    //   108	7	1	localException1	java.lang.Exception
    //   123	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   150	7	1	localException2	java.lang.Exception
    //   163	6	1	localObject1	java.lang.Object
    //   174	7	1	localException3	java.lang.Exception
    //   26	120	2	localObjectInputStream3	java.io.ObjectInputStream
    //   161	12	2	localObject2	java.lang.Object
    //   187	1	2	localObject3	java.lang.Object
    //   119	19	3	localException4	java.lang.Exception
    //   191	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   103	107	108	java/lang/Exception
    //   8	27	119	java/lang/Exception
    //   145	149	150	java/lang/Exception
    //   8	27	161	finally
    //   168	172	174	java/lang/Exception
    //   29	37	187	finally
    //   39	47	187	finally
    //   49	55	187	finally
    //   57	99	187	finally
    //   124	130	187	finally
    //   132	141	187	finally
    //   29	37	191	java/lang/Exception
    //   39	47	191	java/lang/Exception
    //   49	55	191	java/lang/Exception
    //   57	99	191	java/lang/Exception
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 100	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 101	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 103	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 106	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 19	com/tencent/mobileqq/data/MessageForLocationShare:isSharingLocation	Z
    //   26: invokevirtual 110	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 57	com/tencent/mobileqq/data/MessageForLocationShare:msg	Ljava/lang/String;
    //   36: invokevirtual 114	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   45: aload_2
    //   46: astore_1
    //   47: aload_0
    //   48: aload 4
    //   50: invokevirtual 118	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   53: putfield 33	com/tencent/mobileqq/data/MessageForLocationShare:msgData	[B
    //   56: aload_2
    //   57: ifnull +7 -> 64
    //   60: aload_2
    //   61: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   64: aload 4
    //   66: ifnull +8 -> 74
    //   69: aload 4
    //   71: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   74: return
    //   75: astore_1
    //   76: ldc 8
    //   78: iconst_1
    //   79: ldc 121
    //   81: aload_1
    //   82: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: goto -21 -> 64
    //   88: astore_1
    //   89: ldc 8
    //   91: iconst_1
    //   92: ldc 121
    //   94: aload_1
    //   95: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: return
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +14 -> 121
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 8
    //   114: iconst_2
    //   115: ldc 123
    //   117: aload_3
    //   118: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_2
    //   122: ifnull +7 -> 129
    //   125: aload_2
    //   126: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   129: aload 4
    //   131: ifnull -57 -> 74
    //   134: aload 4
    //   136: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   139: return
    //   140: astore_1
    //   141: ldc 8
    //   143: iconst_1
    //   144: ldc 121
    //   146: aload_1
    //   147: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: return
    //   151: astore_1
    //   152: ldc 8
    //   154: iconst_1
    //   155: ldc 121
    //   157: aload_1
    //   158: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: goto -32 -> 129
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   185: aload_2
    //   186: athrow
    //   187: astore_1
    //   188: ldc 8
    //   190: iconst_1
    //   191: ldc 121
    //   193: aload_1
    //   194: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: goto -22 -> 175
    //   200: astore_1
    //   201: ldc 8
    //   203: iconst_1
    //   204: ldc 121
    //   206: aload_1
    //   207: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -25 -> 185
    //   213: astore_2
    //   214: goto -47 -> 167
    //   217: astore_3
    //   218: goto -116 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	MessageForLocationShare
    //   20	27	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   75	7	1	localException1	java.lang.Exception
    //   88	7	1	localException2	java.lang.Exception
    //   103	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   140	7	1	localException3	java.lang.Exception
    //   151	7	1	localException4	java.lang.Exception
    //   166	6	1	localObject1	java.lang.Object
    //   187	7	1	localException5	java.lang.Exception
    //   200	7	1	localException6	java.lang.Exception
    //   18	108	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   164	22	2	localObject2	java.lang.Object
    //   213	1	2	localObject3	java.lang.Object
    //   99	19	3	localException7	java.lang.Exception
    //   217	1	3	localException8	java.lang.Exception
    //   7	174	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   60	64	75	java/lang/Exception
    //   69	74	88	java/lang/Exception
    //   9	19	99	java/lang/Exception
    //   134	139	140	java/lang/Exception
    //   125	129	151	java/lang/Exception
    //   9	19	164	finally
    //   171	175	187	java/lang/Exception
    //   180	185	200	java/lang/Exception
    //   21	29	213	finally
    //   31	39	213	finally
    //   41	45	213	finally
    //   47	56	213	finally
    //   104	110	213	finally
    //   112	121	213	finally
    //   21	29	217	java/lang/Exception
    //   31	39	217	java/lang/Exception
    //   41	45	217	java/lang/Exception
    //   47	56	217	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForLocationShare{");
    localStringBuilder.append("isSharingLocation=").append(this.isSharingLocation);
    localStringBuilder.append(", msg='").append(this.msg).append('\'');
    localStringBuilder.append(", mr='").append(super.toString()).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLocationShare
 * JD-Core Version:    0.7.0.1
 */