package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForQQStoryComment
  extends ChatMessage
{
  public static final int CTR_VERSION = 1;
  public static final String TAG = "MessageForQQStoryComment";
  public long author;
  public String comment;
  public String coverUrl;
  public long createTime;
  public int ctrVersion;
  public int displayType = 0;
  public String summary;
  public String title;
  public String vid;
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.vid = paramObjectInput.readUTF();
    this.comment = paramObjectInput.readUTF();
    this.title = paramObjectInput.readUTF();
    this.coverUrl = paramObjectInput.readUTF();
    this.summary = paramObjectInput.readUTF();
    this.createTime = paramObjectInput.readLong();
    this.author = paramObjectInput.readLong();
    this.ctrVersion = paramObjectInput.readInt();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.vid);
    paramObjectOutput.writeUTF(this.comment);
    paramObjectOutput.writeUTF(this.title);
    paramObjectOutput.writeUTF(this.coverUrl);
    paramObjectOutput.writeUTF(this.summary);
    paramObjectOutput.writeLong(this.createTime);
    paramObjectOutput.writeLong(this.author);
    paramObjectOutput.writeInt(this.ctrVersion);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 81	java/io/ObjectInputStream
    //   8: dup
    //   9: new 83	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 87	com/tencent/mobileqq/data/MessageForQQStoryComment:msgData	[B
    //   17: invokespecial 90	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 93	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 95	com/tencent/mobileqq/data/MessageForQQStoryComment:readExternal	(Ljava/io/ObjectInput;)V
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 40	com/tencent/mobileqq/data/MessageForQQStoryComment:comment	Ljava/lang/String;
    //   34: putfield 98	com/tencent/mobileqq/data/MessageForQQStoryComment:msg	Ljava/lang/String;
    //   37: aload_2
    //   38: invokevirtual 101	java/io/ObjectInputStream:close	()V
    //   41: return
    //   42: astore_1
    //   43: goto +55 -> 98
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: goto +15 -> 64
    //   52: astore_3
    //   53: aload_1
    //   54: astore_2
    //   55: aload_3
    //   56: astore_1
    //   57: goto +41 -> 98
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +14 -> 83
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 109
    //   76: iconst_2
    //   77: ldc 111
    //   79: aload_3
    //   80: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_2
    //   84: ifnull +13 -> 97
    //   87: aload_2
    //   88: invokevirtual 101	java/io/ObjectInputStream:close	()V
    //   91: return
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   97: return
    //   98: aload_2
    //   99: ifnull +15 -> 114
    //   102: aload_2
    //   103: invokevirtual 101	java/io/ObjectInputStream:close	()V
    //   106: goto +8 -> 114
    //   109: astore_2
    //   110: aload_2
    //   111: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MessageForQQStoryComment
    //   4	1	1	localObject1	java.lang.Object
    //   42	1	1	localObject2	java.lang.Object
    //   46	8	1	localException1	java.lang.Exception
    //   56	18	1	localObject3	java.lang.Object
    //   92	23	1	localException2	java.lang.Exception
    //   23	80	2	localObject4	java.lang.Object
    //   109	2	2	localException3	java.lang.Exception
    //   48	1	3	localException4	java.lang.Exception
    //   52	4	3	localObject5	java.lang.Object
    //   60	20	3	localException5	java.lang.Exception
    //   1	61	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	37	42	finally
    //   24	37	46	java/lang/Exception
    //   5	24	52	finally
    //   66	72	52	finally
    //   74	83	52	finally
    //   5	24	60	java/lang/Exception
    //   37	41	92	java/lang/Exception
    //   87	91	92	java/lang/Exception
    //   102	106	109	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return this.msg;
  }
  
  protected void postRead()
  {
    super.parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 126	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 127	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 129	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 132	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 134	com/tencent/mobileqq/data/MessageForQQStoryComment:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 139	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 87	com/tencent/mobileqq/data/MessageForQQStoryComment:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   47: goto +19 -> 66
    //   50: astore_1
    //   51: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +12 -> 66
    //   57: ldc 109
    //   59: iconst_2
    //   60: ldc 141
    //   62: aload_1
    //   63: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload 4
    //   68: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +88 -> 164
    //   79: ldc 109
    //   81: iconst_2
    //   82: ldc 141
    //   84: aload_1
    //   85: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: return
    //   89: astore_3
    //   90: goto +12 -> 102
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_2
    //   96: goto +74 -> 170
    //   99: astore_3
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +14 -> 121
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 109
    //   114: iconst_2
    //   115: ldc 141
    //   117: aload_3
    //   118: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_2
    //   122: ifnull +26 -> 148
    //   125: aload_2
    //   126: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   129: goto +19 -> 148
    //   132: astore_1
    //   133: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 109
    //   141: iconst_2
    //   142: ldc 141
    //   144: aload_1
    //   145: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload 4
    //   150: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +6 -> 164
    //   161: goto -82 -> 79
    //   164: return
    //   165: astore_3
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: astore_1
    //   170: aload_2
    //   171: ifnull +26 -> 197
    //   174: aload_2
    //   175: invokevirtual 135	java/io/ObjectOutputStream:close	()V
    //   178: goto +19 -> 197
    //   181: astore_2
    //   182: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 109
    //   190: iconst_2
    //   191: ldc 141
    //   193: aload_2
    //   194: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   202: goto +19 -> 221
    //   205: astore_2
    //   206: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +12 -> 221
    //   212: ldc 109
    //   214: iconst_2
    //   215: ldc 141
    //   217: aload_2
    //   218: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	MessageForQQStoryComment
    //   20	14	1	localObject1	java.lang.Object
    //   50	13	1	localException1	java.lang.Exception
    //   72	13	1	localException2	java.lang.Exception
    //   93	1	1	localObject2	java.lang.Object
    //   103	9	1	localObject3	java.lang.Object
    //   132	13	1	localException3	java.lang.Exception
    //   154	13	1	localException4	java.lang.Exception
    //   169	56	1	localObject4	java.lang.Object
    //   18	157	2	localObject5	java.lang.Object
    //   181	13	2	localException5	java.lang.Exception
    //   205	13	2	localException6	java.lang.Exception
    //   89	1	3	localException7	java.lang.Exception
    //   99	19	3	localException8	java.lang.Exception
    //   165	4	3	localObject6	java.lang.Object
    //   7	191	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   66	71	72	java/lang/Exception
    //   21	26	89	java/lang/Exception
    //   28	32	89	java/lang/Exception
    //   34	43	89	java/lang/Exception
    //   9	19	93	finally
    //   9	19	99	java/lang/Exception
    //   125	129	132	java/lang/Exception
    //   148	153	154	java/lang/Exception
    //   21	26	165	finally
    //   28	32	165	finally
    //   34	43	165	finally
    //   104	110	165	finally
    //   112	121	165	finally
    //   174	178	181	java/lang/Exception
    //   197	202	205	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQStoryComment
 * JD-Core Version:    0.7.0.1
 */