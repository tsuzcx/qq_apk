package com.tencent.mobileqq.data;

import com.tencent.mobileqq.dating.MsgBoxUtil;
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
    this.context = MsgBoxUtil.a(this.rawContext, 14);
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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 86	java/io/ObjectInputStream
    //   8: dup
    //   9: new 88	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 92	com/tencent/mobileqq/data/MessageForInteractAndFollow:msgData	[B
    //   17: invokespecial 95	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 98	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: invokespecial 100	com/tencent/mobileqq/data/MessageForInteractAndFollow:readExternal	(Ljava/io/ObjectInput;)V
    //   29: aload_2
    //   30: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   33: return
    //   34: astore_1
    //   35: ldc 8
    //   37: iconst_2
    //   38: iconst_3
    //   39: anewarray 105	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 107
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_1
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: aload_1
    //   54: aastore
    //   55: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   58: return
    //   59: astore_1
    //   60: goto +88 -> 148
    //   63: astore_1
    //   64: aload_1
    //   65: astore_3
    //   66: goto +15 -> 81
    //   69: astore_3
    //   70: aload_1
    //   71: astore_2
    //   72: aload_3
    //   73: astore_1
    //   74: goto +74 -> 148
    //   77: astore_3
    //   78: aload 4
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +28 -> 114
    //   89: aload_2
    //   90: astore_1
    //   91: ldc 8
    //   93: iconst_2
    //   94: iconst_3
    //   95: anewarray 105	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: ldc 119
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_3
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload_3
    //   110: aastore
    //   111: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   114: aload_2
    //   115: ifnull +32 -> 147
    //   118: aload_2
    //   119: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   122: return
    //   123: astore_1
    //   124: ldc 8
    //   126: iconst_2
    //   127: iconst_3
    //   128: anewarray 105	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: ldc 107
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload_1
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: aload_1
    //   143: aastore
    //   144: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   147: return
    //   148: aload_2
    //   149: ifnull +34 -> 183
    //   152: aload_2
    //   153: invokevirtual 103	java/io/ObjectInputStream:close	()V
    //   156: goto +27 -> 183
    //   159: astore_2
    //   160: ldc 8
    //   162: iconst_2
    //   163: iconst_3
    //   164: anewarray 105	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: ldc 107
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_2
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload_2
    //   179: aastore
    //   180: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	MessageForInteractAndFollow
    //   4	1	1	localObject1	java.lang.Object
    //   34	20	1	localException1	java.lang.Exception
    //   59	1	1	localObject2	java.lang.Object
    //   63	8	1	localException2	java.lang.Exception
    //   73	18	1	localObject3	java.lang.Object
    //   123	61	1	localException3	java.lang.Exception
    //   23	130	2	localObject4	java.lang.Object
    //   159	20	2	localException4	java.lang.Exception
    //   65	1	3	localException5	java.lang.Exception
    //   69	4	3	localObject5	java.lang.Object
    //   77	33	3	localException6	java.lang.Exception
    //   1	78	4	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   29	33	34	java/lang/Exception
    //   24	29	59	finally
    //   24	29	63	java/lang/Exception
    //   5	24	69	finally
    //   83	89	69	finally
    //   91	114	69	finally
    //   5	24	77	java/lang/Exception
    //   118	122	123	java/lang/Exception
    //   152	156	159	java/lang/Exception
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
    //   44: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   47: goto +33 -> 80
    //   50: astore_1
    //   51: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +26 -> 80
    //   57: ldc 8
    //   59: iconst_2
    //   60: iconst_3
    //   61: anewarray 105	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: ldc 144
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload_1
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: aload_1
    //   76: aastore
    //   77: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   80: aload 4
    //   82: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   85: return
    //   86: astore_1
    //   87: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +150 -> 240
    //   93: ldc 8
    //   95: iconst_2
    //   96: iconst_3
    //   97: anewarray 105	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc 144
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_1
    //   108: aastore
    //   109: dup
    //   110: iconst_2
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   116: return
    //   117: astore_3
    //   118: goto +12 -> 130
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: goto +122 -> 246
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +28 -> 163
    //   138: aload_2
    //   139: astore_1
    //   140: ldc 8
    //   142: iconst_2
    //   143: iconst_3
    //   144: anewarray 105	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: ldc 144
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: aload_3
    //   155: aastore
    //   156: dup
    //   157: iconst_2
    //   158: aload_3
    //   159: aastore
    //   160: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   163: aload_2
    //   164: ifnull +40 -> 204
    //   167: aload_2
    //   168: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   171: goto +33 -> 204
    //   174: astore_1
    //   175: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +26 -> 204
    //   181: ldc 8
    //   183: iconst_2
    //   184: iconst_3
    //   185: anewarray 105	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc 144
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload_1
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: aload_1
    //   200: aastore
    //   201: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   204: aload 4
    //   206: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   209: return
    //   210: astore_1
    //   211: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +26 -> 240
    //   217: ldc 8
    //   219: iconst_2
    //   220: iconst_3
    //   221: anewarray 105	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: ldc 144
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload_1
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_1
    //   236: aastore
    //   237: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   240: return
    //   241: astore_3
    //   242: aload_1
    //   243: astore_2
    //   244: aload_3
    //   245: astore_1
    //   246: aload_2
    //   247: ifnull +40 -> 287
    //   250: aload_2
    //   251: invokevirtual 138	java/io/ObjectOutputStream:close	()V
    //   254: goto +33 -> 287
    //   257: astore_2
    //   258: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +26 -> 287
    //   264: ldc 8
    //   266: iconst_2
    //   267: iconst_3
    //   268: anewarray 105	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: ldc 144
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: aload_2
    //   279: aastore
    //   280: dup
    //   281: iconst_2
    //   282: aload_2
    //   283: aastore
    //   284: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   287: aload 4
    //   289: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   292: goto +33 -> 325
    //   295: astore_2
    //   296: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +26 -> 325
    //   302: ldc 8
    //   304: iconst_2
    //   305: iconst_3
    //   306: anewarray 105	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: ldc 144
    //   313: aastore
    //   314: dup
    //   315: iconst_1
    //   316: aload_2
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: aload_2
    //   321: aastore
    //   322: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   325: aload_1
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	MessageForInteractAndFollow
    //   20	14	1	localObject1	java.lang.Object
    //   50	26	1	localException1	java.lang.Exception
    //   86	26	1	localException2	java.lang.Exception
    //   121	1	1	localObject2	java.lang.Object
    //   131	9	1	localObject3	java.lang.Object
    //   174	26	1	localException3	java.lang.Exception
    //   210	33	1	localException4	java.lang.Exception
    //   245	81	1	localObject4	java.lang.Object
    //   18	233	2	localObject5	java.lang.Object
    //   257	26	2	localException5	java.lang.Exception
    //   295	26	2	localException6	java.lang.Exception
    //   117	1	3	localException7	java.lang.Exception
    //   127	32	3	localException8	java.lang.Exception
    //   241	4	3	localObject6	java.lang.Object
    //   7	281	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   80	85	86	java/lang/Exception
    //   21	26	117	java/lang/Exception
    //   28	32	117	java/lang/Exception
    //   34	43	117	java/lang/Exception
    //   9	19	121	finally
    //   9	19	127	java/lang/Exception
    //   167	171	174	java/lang/Exception
    //   204	209	210	java/lang/Exception
    //   21	26	241	finally
    //   28	32	241	finally
    //   34	43	241	finally
    //   132	138	241	finally
    //   140	163	241	finally
    //   250	254	257	java/lang/Exception
    //   287	292	295	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForInteractAndFollow
 * JD-Core Version:    0.7.0.1
 */