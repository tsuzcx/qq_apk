package com.tencent.mobileqq.data;

import aryo;
import com.tencent.mobileqq.text.QQText;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForInteractAndFollow
  extends ChatMessage
{
  public static final String TAG = "Q.msg_box.MessageForInteractAndFollow";
  public static final int TYPE_FOLLOW = 2;
  public static final int TYPE_INTERACT = 1;
  public static final int TYPE_MOMENT = 3;
  public QQText context;
  public int msgBoxUnreadCount;
  public String rawContext;
  public long timeStamp;
  public int type;
  public int unReadCount;
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.unReadCount = paramObjectInput.readInt();
    this.msgBoxUnreadCount = paramObjectInput.readInt();
    this.type = paramObjectInput.readInt();
    this.rawContext = paramObjectInput.readUTF();
    this.timeStamp = paramObjectInput.readLong();
    this.time = this.timeStamp;
    this.context = aryo.a(this.rawContext, 14);
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.unReadCount);
    paramObjectOutput.writeInt(this.msgBoxUnreadCount);
    paramObjectOutput.writeInt(this.type);
    paramObjectOutput.writeUTF(this.rawContext);
    paramObjectOutput.writeLong(this.timeStamp);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 86	java/io/ObjectInputStream
    //   3: dup
    //   4: new 88	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 92	com/tencent/mobileqq/data/MessageForInteractAndFollow:msgData	[B
    //   12: invokespecial 95	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 98	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 100	com/tencent/mobileqq/data/MessageForInteractAndFollow:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   34: return
    //   35: astore_1
    //   36: ldc 8
    //   38: iconst_2
    //   39: iconst_3
    //   40: anewarray 105	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: ldc 107
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_1
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: aload_1
    //   55: aastore
    //   56: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   59: return
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +28 -> 96
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 8
    //   75: iconst_2
    //   76: iconst_3
    //   77: anewarray 105	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: ldc 119
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_3
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: aload_3
    //   92: aastore
    //   93: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   96: aload_2
    //   97: ifnull -63 -> 34
    //   100: aload_2
    //   101: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   104: return
    //   105: astore_1
    //   106: ldc 8
    //   108: iconst_2
    //   109: iconst_3
    //   110: anewarray 105	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: ldc 107
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_1
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: aload_1
    //   125: aastore
    //   126: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   129: return
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   141: aload_2
    //   142: athrow
    //   143: astore_1
    //   144: ldc 8
    //   146: iconst_2
    //   147: iconst_3
    //   148: anewarray 105	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: ldc 107
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_1
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: aload_1
    //   163: aastore
    //   164: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   167: goto -26 -> 141
    //   170: astore_2
    //   171: goto -38 -> 133
    //   174: astore_3
    //   175: goto -112 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	MessageForInteractAndFollow
    //   20	1	1	localObjectInputStream1	java.io.ObjectInputStream
    //   35	20	1	localException1	java.lang.Exception
    //   64	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   105	20	1	localException2	java.lang.Exception
    //   132	6	1	localObject1	java.lang.Object
    //   143	20	1	localException3	java.lang.Exception
    //   18	83	2	localObjectInputStream3	java.io.ObjectInputStream
    //   130	12	2	localObject2	java.lang.Object
    //   170	1	2	localObject3	java.lang.Object
    //   60	32	3	localException4	java.lang.Exception
    //   174	1	3	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	34	35	java/lang/Exception
    //   0	19	60	java/lang/Exception
    //   100	104	105	java/lang/Exception
    //   0	19	130	finally
    //   137	141	143	java/lang/Exception
    //   21	26	170	finally
    //   65	71	170	finally
    //   73	96	170	finally
    //   21	26	174	java/lang/Exception
  }
  
  public void getBytes()
  {
    prewrite();
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 129	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 132	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 135	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 137	com/tencent/mobileqq/data/MessageForInteractAndFollow:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 142	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 92	com/tencent/mobileqq/data/MessageForInteractAndFollow:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   56: return
    //   57: astore_1
    //   58: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq -10 -> 51
    //   64: ldc 8
    //   66: iconst_2
    //   67: iconst_3
    //   68: anewarray 105	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: ldc 145
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_1
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: aload_1
    //   83: aastore
    //   84: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   87: goto -36 -> 51
    //   90: astore_1
    //   91: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq -38 -> 56
    //   97: ldc 8
    //   99: iconst_2
    //   100: iconst_3
    //   101: anewarray 105	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: ldc 145
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: aload_1
    //   116: aastore
    //   117: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   120: return
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +28 -> 157
    //   132: aload_2
    //   133: astore_1
    //   134: ldc 8
    //   136: iconst_2
    //   137: iconst_3
    //   138: anewarray 105	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc 145
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_3
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: aload_3
    //   153: aastore
    //   154: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   170: return
    //   171: astore_1
    //   172: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -119 -> 56
    //   178: ldc 8
    //   180: iconst_2
    //   181: iconst_3
    //   182: anewarray 105	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: ldc 145
    //   189: aastore
    //   190: dup
    //   191: iconst_1
    //   192: aload_1
    //   193: aastore
    //   194: dup
    //   195: iconst_2
    //   196: aload_1
    //   197: aastore
    //   198: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   201: return
    //   202: astore_1
    //   203: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq -41 -> 165
    //   209: ldc 8
    //   211: iconst_2
    //   212: iconst_3
    //   213: anewarray 105	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc 145
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_1
    //   224: aastore
    //   225: dup
    //   226: iconst_2
    //   227: aload_1
    //   228: aastore
    //   229: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   232: goto -67 -> 165
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   246: aload 4
    //   248: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   251: aload_2
    //   252: athrow
    //   253: astore_1
    //   254: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -11 -> 246
    //   260: ldc 8
    //   262: iconst_2
    //   263: iconst_3
    //   264: anewarray 105	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: ldc 145
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload_1
    //   275: aastore
    //   276: dup
    //   277: iconst_2
    //   278: aload_1
    //   279: aastore
    //   280: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   283: goto -37 -> 246
    //   286: astore_1
    //   287: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq -39 -> 251
    //   293: ldc 8
    //   295: iconst_2
    //   296: iconst_3
    //   297: anewarray 105	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: ldc 145
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: aload_1
    //   308: aastore
    //   309: dup
    //   310: iconst_2
    //   311: aload_1
    //   312: aastore
    //   313: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   316: goto -65 -> 251
    //   319: astore_2
    //   320: goto -82 -> 238
    //   323: astore_3
    //   324: goto -200 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	MessageForInteractAndFollow
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   57	26	1	localException1	java.lang.Exception
    //   90	26	1	localException2	java.lang.Exception
    //   125	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   171	26	1	localException3	java.lang.Exception
    //   202	26	1	localException4	java.lang.Exception
    //   237	6	1	localObject1	java.lang.Object
    //   253	26	1	localException5	java.lang.Exception
    //   286	26	1	localException6	java.lang.Exception
    //   18	144	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   235	17	2	localObject2	java.lang.Object
    //   319	1	2	localObject3	java.lang.Object
    //   121	32	3	localException7	java.lang.Exception
    //   323	1	3	localException8	java.lang.Exception
    //   7	240	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	57	java/lang/Exception
    //   51	56	90	java/lang/Exception
    //   9	19	121	java/lang/Exception
    //   165	170	171	java/lang/Exception
    //   161	165	202	java/lang/Exception
    //   9	19	235	finally
    //   242	246	253	java/lang/Exception
    //   246	251	286	java/lang/Exception
    //   21	26	319	finally
    //   28	32	319	finally
    //   34	43	319	finally
    //   126	132	319	finally
    //   134	157	319	finally
    //   21	26	323	java/lang/Exception
    //   28	32	323	java/lang/Exception
    //   34	43	323	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForInteractAndFollow
 * JD-Core Version:    0.7.0.1
 */