package com.tencent.mobileqq.data;

import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForYanZhi
  extends ChatMessage
{
  public static final String TAG = "Q.msg_box.MessageForYanZhi";
  public int likeCount;
  public int pushTime;
  public long pushUin;
  public int type;
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.type = paramObjectInput.readInt();
    this.pushUin = paramObjectInput.readLong();
    this.likeCount = paramObjectInput.readInt();
    this.pushTime = paramObjectInput.readInt();
    this.time = paramObjectInput.readLong();
    this.msg = paramObjectInput.readUTF();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.type);
    paramObjectOutput.writeLong(this.pushUin);
    paramObjectOutput.writeInt(this.likeCount);
    paramObjectOutput.writeInt(this.pushTime);
    paramObjectOutput.writeLong(this.time);
    paramObjectOutput.writeUTF(this.msg);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 70	java/io/ObjectInputStream
    //   8: dup
    //   9: new 72	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 76	com/tencent/mobileqq/data/MessageForYanZhi:msgData	[B
    //   17: invokespecial 79	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 82	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 84	com/tencent/mobileqq/data/MessageForYanZhi:readExternal	(Ljava/io/ObjectInput;)V
    //   29: aload_2
    //   30: invokevirtual 87	java/io/ObjectInputStream:close	()V
    //   33: return
    //   34: astore_1
    //   35: goto +55 -> 90
    //   38: astore_1
    //   39: aload_1
    //   40: astore_3
    //   41: goto +15 -> 56
    //   44: astore_3
    //   45: aload_1
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: goto +41 -> 90
    //   52: astore_3
    //   53: aload 4
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +14 -> 75
    //   64: aload_2
    //   65: astore_1
    //   66: ldc 8
    //   68: iconst_2
    //   69: ldc 95
    //   71: aload_3
    //   72: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: aload_2
    //   76: ifnull +13 -> 89
    //   79: aload_2
    //   80: invokevirtual 87	java/io/ObjectInputStream:close	()V
    //   83: return
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   89: return
    //   90: aload_2
    //   91: ifnull +15 -> 106
    //   94: aload_2
    //   95: invokevirtual 87	java/io/ObjectInputStream:close	()V
    //   98: goto +8 -> 106
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	MessageForYanZhi
    //   4	1	1	localObject1	java.lang.Object
    //   34	1	1	localObject2	java.lang.Object
    //   38	8	1	localException1	java.lang.Exception
    //   48	18	1	localObject3	java.lang.Object
    //   84	23	1	localException2	java.lang.Exception
    //   23	72	2	localObject4	java.lang.Object
    //   101	2	2	localException3	java.lang.Exception
    //   40	1	3	localException4	java.lang.Exception
    //   44	4	3	localObject5	java.lang.Object
    //   52	20	3	localException5	java.lang.Exception
    //   1	53	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   24	29	34	finally
    //   24	29	38	java/lang/Exception
    //   5	24	44	finally
    //   58	64	44	finally
    //   66	75	44	finally
    //   5	24	52	java/lang/Exception
    //   29	33	84	java/lang/Exception
    //   79	83	84	java/lang/Exception
    //   94	98	101	java/lang/Exception
  }
  
  public void getBytes()
  {
    prewrite();
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 112	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 113	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 115	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 118	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 120	com/tencent/mobileqq/data/MessageForYanZhi:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 76	com/tencent/mobileqq/data/MessageForYanZhi:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   47: goto +19 -> 66
    //   50: astore_1
    //   51: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +12 -> 66
    //   57: ldc 8
    //   59: iconst_2
    //   60: ldc 127
    //   62: aload_1
    //   63: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload 4
    //   68: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   71: return
    //   72: astore_1
    //   73: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +88 -> 164
    //   79: ldc 8
    //   81: iconst_2
    //   82: ldc 127
    //   84: aload_1
    //   85: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   104: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +14 -> 121
    //   110: aload_2
    //   111: astore_1
    //   112: ldc 8
    //   114: iconst_2
    //   115: ldc 127
    //   117: aload_3
    //   118: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_2
    //   122: ifnull +26 -> 148
    //   125: aload_2
    //   126: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   129: goto +19 -> 148
    //   132: astore_1
    //   133: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +12 -> 148
    //   139: ldc 8
    //   141: iconst_2
    //   142: ldc 127
    //   144: aload_1
    //   145: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload 4
    //   150: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
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
    //   175: invokevirtual 121	java/io/ObjectOutputStream:close	()V
    //   178: goto +19 -> 197
    //   181: astore_2
    //   182: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +12 -> 197
    //   188: ldc 8
    //   190: iconst_2
    //   191: ldc 127
    //   193: aload_2
    //   194: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   202: goto +19 -> 221
    //   205: astore_2
    //   206: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +12 -> 221
    //   212: ldc 8
    //   214: iconst_2
    //   215: ldc 127
    //   217: aload_2
    //   218: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   221: goto +5 -> 226
    //   224: aload_1
    //   225: athrow
    //   226: goto -2 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	MessageForYanZhi
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForYanZhi
 * JD-Core Version:    0.7.0.1
 */