package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.defaultValue;

public class MessageForLocationShare
  extends ChatMessage
{
  private static final String TAG = "MessageForLocationShare";
  @defaultValue(defaultInteger=1)
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
    //   100: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   103: return
    //   104: astore_3
    //   105: goto +12 -> 117
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_2
    //   111: goto +50 -> 161
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +14 -> 136
    //   125: aload_2
    //   126: astore_1
    //   127: ldc 8
    //   129: iconst_2
    //   130: ldc 85
    //   132: aload_3
    //   133: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_2
    //   137: ifnull +18 -> 155
    //   140: aload_2
    //   141: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   144: return
    //   145: astore_1
    //   146: ldc 8
    //   148: iconst_1
    //   149: ldc 90
    //   151: aload_1
    //   152: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: return
    //   156: astore_3
    //   157: aload_1
    //   158: astore_2
    //   159: aload_3
    //   160: astore_1
    //   161: aload_2
    //   162: ifnull +20 -> 182
    //   165: aload_2
    //   166: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   169: goto +13 -> 182
    //   172: astore_2
    //   173: ldc 8
    //   175: iconst_1
    //   176: ldc 90
    //   178: aload_2
    //   179: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	MessageForLocationShare
    //   28	29	1	localObject1	java.lang.Object
    //   108	1	1	localObject2	java.lang.Object
    //   118	9	1	localObject3	java.lang.Object
    //   145	13	1	localException1	java.lang.Exception
    //   160	23	1	localObject4	java.lang.Object
    //   26	140	2	localObject5	java.lang.Object
    //   172	7	2	localException2	java.lang.Exception
    //   104	1	3	localException3	java.lang.Exception
    //   114	19	3	localException4	java.lang.Exception
    //   156	4	3	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   29	37	104	java/lang/Exception
    //   39	47	104	java/lang/Exception
    //   49	55	104	java/lang/Exception
    //   57	99	104	java/lang/Exception
    //   8	27	108	finally
    //   8	27	114	java/lang/Exception
    //   99	103	145	java/lang/Exception
    //   140	144	145	java/lang/Exception
    //   29	37	156	finally
    //   39	47	156	finally
    //   49	55	156	finally
    //   57	99	156	finally
    //   119	125	156	finally
    //   127	136	156	finally
    //   165	169	172	java/lang/Exception
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  protected void prewrite()
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
    //   57: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   60: goto +13 -> 73
    //   63: astore_1
    //   64: ldc 8
    //   66: iconst_1
    //   67: ldc 120
    //   69: aload_1
    //   70: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload 4
    //   75: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   78: return
    //   79: astore_3
    //   80: goto +12 -> 92
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: goto +68 -> 154
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +14 -> 111
    //   100: aload_2
    //   101: astore_1
    //   102: ldc 8
    //   104: iconst_2
    //   105: ldc 123
    //   107: aload_3
    //   108: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload_2
    //   112: ifnull +20 -> 132
    //   115: aload_2
    //   116: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   119: goto +13 -> 132
    //   122: astore_1
    //   123: ldc 8
    //   125: iconst_1
    //   126: ldc 120
    //   128: aload_1
    //   129: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload 4
    //   134: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   137: return
    //   138: astore_1
    //   139: ldc 8
    //   141: iconst_1
    //   142: ldc 120
    //   144: aload_1
    //   145: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: return
    //   149: astore_3
    //   150: aload_1
    //   151: astore_2
    //   152: aload_3
    //   153: astore_1
    //   154: aload_2
    //   155: ifnull +20 -> 175
    //   158: aload_2
    //   159: invokevirtual 115	java/io/ObjectOutputStream:close	()V
    //   162: goto +13 -> 175
    //   165: astore_2
    //   166: ldc 8
    //   168: iconst_1
    //   169: ldc 120
    //   171: aload_2
    //   172: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload 4
    //   177: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   180: goto +13 -> 193
    //   183: astore_2
    //   184: ldc 8
    //   186: iconst_1
    //   187: ldc 120
    //   189: aload_2
    //   190: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	MessageForLocationShare
    //   20	27	1	localObject1	java.lang.Object
    //   63	7	1	localException1	java.lang.Exception
    //   83	1	1	localObject2	java.lang.Object
    //   93	9	1	localObject3	java.lang.Object
    //   122	7	1	localException2	java.lang.Exception
    //   138	13	1	localException3	java.lang.Exception
    //   153	41	1	localObject4	java.lang.Object
    //   18	141	2	localObject5	java.lang.Object
    //   165	7	2	localException4	java.lang.Exception
    //   183	7	2	localException5	java.lang.Exception
    //   79	1	3	localException6	java.lang.Exception
    //   89	19	3	localException7	java.lang.Exception
    //   149	4	3	localObject6	java.lang.Object
    //   7	169	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   56	60	63	java/lang/Exception
    //   21	29	79	java/lang/Exception
    //   31	39	79	java/lang/Exception
    //   41	45	79	java/lang/Exception
    //   47	56	79	java/lang/Exception
    //   9	19	83	finally
    //   9	19	89	java/lang/Exception
    //   115	119	122	java/lang/Exception
    //   73	78	138	java/lang/Exception
    //   132	137	138	java/lang/Exception
    //   21	29	149	finally
    //   31	39	149	finally
    //   41	45	149	finally
    //   47	56	149	finally
    //   94	100	149	finally
    //   102	111	149	finally
    //   158	162	165	java/lang/Exception
    //   175	180	183	java/lang/Exception
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MessageForLocationShare{");
    localStringBuilder.append("isSharingLocation=");
    localStringBuilder.append(this.isSharingLocation);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mr='");
    localStringBuilder.append(super.toString());
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLocationShare
 * JD-Core Version:    0.7.0.1
 */