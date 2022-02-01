package com.tencent.mobileqq.data;

import anni;
import biaj;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForScribble
  extends ChatMessage
{
  public static final String TAG = "MessageForScribbleMSg";
  public static final int TRANS_STAUS_DEFAULT = 0;
  public static final int TRANS_STAUS_DOWNLOADING = 3;
  public static final int TRANS_STAUS_DOWNLOAD_FAILED = 2;
  public static final int TRANS_STAUS_DOWNLOAD_SUC = 1;
  public static final int TRANS_STAUS_UP_FAILED = 2;
  public static final int TRANS_STAUS_UP_SENDING = 3;
  public static final int TRANS_STAUS_UP_SUC = 1;
  public String combineFileMd5 = "";
  public String combineFileUrl = "";
  public int fileDownloadStatus = 0;
  public int fileUploadStatus = 0;
  public int gifId;
  public String localFildPath = "";
  public MessageForScribble.FileExistInfo mExistInfo = new MessageForScribble.FileExistInfo(this);
  public biaj mProgressPie;
  public int mRealProgress;
  public int mUiProgress;
  public Runnable mUpdateProgressRunnable;
  public int offSet;
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.combineFileUrl = paramObjectInput.readUTF();
    this.combineFileMd5 = paramObjectInput.readUTF();
    this.gifId = paramObjectInput.readInt();
    this.offSet = paramObjectInput.readInt();
    this.fileUploadStatus = paramObjectInput.readInt();
    this.fileDownloadStatus = paramObjectInput.readInt();
    this.localFildPath = paramObjectInput.readUTF();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.combineFileUrl);
    paramObjectOutput.writeUTF(this.combineFileMd5);
    paramObjectOutput.writeInt(this.gifId);
    paramObjectOutput.writeInt(this.offSet);
    paramObjectOutput.writeInt(this.fileUploadStatus);
    paramObjectOutput.writeInt(this.fileDownloadStatus);
    paramObjectOutput.writeUTF(this.localFildPath);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   4: ifnull +257 -> 261
    //   7: new 96	java/io/ObjectInputStream
    //   10: dup
    //   11: new 98	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   19: invokespecial 101	java/io/ByteArrayInputStream:<init>	([B)V
    //   22: invokespecial 104	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: astore_3
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 106	com/tencent/mobileqq/data/MessageForScribble:readExternal	(Ljava/io/ObjectInput;)V
    //   35: aload_2
    //   36: astore_1
    //   37: aload_2
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   43: aload_0
    //   44: getfield 51	com/tencent/mobileqq/data/MessageForScribble:localFildPath	Ljava/lang/String;
    //   47: invokestatic 112	bgmg:a	(Ljava/lang/String;)Z
    //   50: putfield 116	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mLocalPathExist	Z
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: astore_3
    //   57: aload_0
    //   58: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   61: aload_0
    //   62: invokestatic 122	bbet:b	(Lcom/tencent/mobileqq/data/MessageForScribble;)Ljava/lang/String;
    //   65: invokestatic 112	bgmg:a	(Ljava/lang/String;)Z
    //   68: putfield 125	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mDataFileExist	Z
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: astore_3
    //   75: aload_0
    //   76: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   79: aload_0
    //   80: invokestatic 127	bbet:a	(Lcom/tencent/mobileqq/data/MessageForScribble;)Ljava/lang/String;
    //   83: invokestatic 112	bgmg:a	(Ljava/lang/String;)Z
    //   86: putfield 130	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mCombineFileExist	Z
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   97: iconst_1
    //   98: putfield 133	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mInit	Z
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: astore_3
    //   105: aload_0
    //   106: aload_0
    //   107: invokevirtual 136	com/tencent/mobileqq/data/MessageForScribble:getSummaryMsg	()Ljava/lang/String;
    //   110: putfield 139	com/tencent/mobileqq/data/MessageForScribble:msg	Ljava/lang/String;
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 142	java/io/ObjectInputStream:close	()V
    //   121: ldc 8
    //   123: iconst_2
    //   124: new 144	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   131: ldc 147
    //   133: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   140: getfield 116	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mLocalPathExist	Z
    //   143: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: ldc 156
    //   148: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   155: getfield 125	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mDataFileExist	Z
    //   158: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: ldc 156
    //   163: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_0
    //   167: getfield 58	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   170: getfield 130	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mCombineFileExist	Z
    //   173: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: return
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   188: goto -67 -> 121
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_1
    //   196: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +14 -> 213
    //   202: aload_3
    //   203: astore_1
    //   204: ldc 8
    //   206: iconst_2
    //   207: ldc 174
    //   209: aload_2
    //   210: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_3
    //   214: ifnull -93 -> 121
    //   217: aload_3
    //   218: invokevirtual 142	java/io/ObjectInputStream:close	()V
    //   221: goto -100 -> 121
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   229: goto -108 -> 121
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 142	java/io/ObjectInputStream:close	()V
    //   243: aload_2
    //   244: athrow
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   250: goto -7 -> 243
    //   253: astore_2
    //   254: goto -19 -> 235
    //   257: astore_2
    //   258: goto -64 -> 194
    //   261: aconst_null
    //   262: astore_2
    //   263: goto -162 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	MessageForScribble
    //   27	76	1	localObjectInputStream1	java.io.ObjectInputStream
    //   183	2	1	localException1	java.lang.Exception
    //   195	9	1	localObject1	java.lang.Object
    //   224	2	1	localException2	java.lang.Exception
    //   234	6	1	localObject2	java.lang.Object
    //   245	2	1	localException3	java.lang.Exception
    //   25	93	2	localObjectInputStream2	java.io.ObjectInputStream
    //   191	19	2	localException4	java.lang.Exception
    //   232	12	2	localObject3	java.lang.Object
    //   253	1	2	localObject4	java.lang.Object
    //   257	1	2	localException5	java.lang.Exception
    //   262	1	2	localObject5	java.lang.Object
    //   29	189	3	localObjectInputStream3	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   117	121	183	java/lang/Exception
    //   0	26	191	java/lang/Exception
    //   217	221	224	java/lang/Exception
    //   0	26	232	finally
    //   239	243	245	java/lang/Exception
    //   30	35	253	finally
    //   39	53	253	finally
    //   57	71	253	finally
    //   75	89	253	finally
    //   93	101	253	finally
    //   105	113	253	finally
    //   196	202	253	finally
    //   204	213	253	finally
    //   30	35	257	java/lang/Exception
    //   39	53	257	java/lang/Exception
    //   57	71	257	java/lang/Exception
    //   75	89	257	java/lang/Exception
    //   93	101	257	java/lang/Exception
    //   105	113	257	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return anni.a(2131705354);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 191	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 192	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 194	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 197	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 199	com/tencent/mobileqq/data/MessageForScribble:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 200	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 204	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 200	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -15 -> 51
    //   69: ldc 8
    //   71: iconst_2
    //   72: ldc 207
    //   74: aload_1
    //   75: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -27 -> 51
    //   81: astore_1
    //   82: ldc 8
    //   84: iconst_2
    //   85: ldc 207
    //   87: aload_1
    //   88: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: return
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_1
    //   97: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +14 -> 114
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 8
    //   107: iconst_2
    //   108: ldc 207
    //   110: aload_3
    //   111: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 200	java/io/ObjectOutputStream:close	()V
    //   122: aload 4
    //   124: ifnull -63 -> 61
    //   127: aload 4
    //   129: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   132: return
    //   133: astore_1
    //   134: ldc 8
    //   136: iconst_2
    //   137: ldc 207
    //   139: aload_1
    //   140: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   143: return
    //   144: astore_1
    //   145: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -26 -> 122
    //   151: ldc 8
    //   153: iconst_2
    //   154: ldc 207
    //   156: aload_1
    //   157: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: goto -38 -> 122
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 200	java/io/ObjectOutputStream:close	()V
    //   174: aload 4
    //   176: ifnull +8 -> 184
    //   179: aload 4
    //   181: invokevirtual 205	java/io/ByteArrayOutputStream:close	()V
    //   184: aload_2
    //   185: athrow
    //   186: astore_1
    //   187: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -16 -> 174
    //   193: ldc 8
    //   195: iconst_2
    //   196: ldc 207
    //   198: aload_1
    //   199: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   202: goto -28 -> 174
    //   205: astore_1
    //   206: ldc 8
    //   208: iconst_2
    //   209: ldc 207
    //   211: aload_1
    //   212: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -31 -> 184
    //   218: astore_2
    //   219: goto -53 -> 166
    //   222: astore_3
    //   223: goto -128 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	MessageForScribble
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	13	1	localException1	java.lang.Exception
    //   81	7	1	localException2	java.lang.Exception
    //   96	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   133	7	1	localException3	java.lang.Exception
    //   144	13	1	localException4	java.lang.Exception
    //   165	6	1	localObject1	java.lang.Object
    //   186	13	1	localException5	java.lang.Exception
    //   205	7	1	localException6	java.lang.Exception
    //   18	101	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   163	22	2	localObject2	java.lang.Object
    //   218	1	2	localObject3	java.lang.Object
    //   92	19	3	localException7	java.lang.Exception
    //   222	1	3	localException8	java.lang.Exception
    //   7	173	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	81	java/lang/Exception
    //   9	19	92	java/lang/Exception
    //   127	132	133	java/lang/Exception
    //   118	122	144	java/lang/Exception
    //   9	19	163	finally
    //   170	174	186	java/lang/Exception
    //   179	184	205	java/lang/Exception
    //   21	26	218	finally
    //   28	32	218	finally
    //   34	43	218	finally
    //   97	103	218	finally
    //   105	114	218	finally
    //   21	26	222	java/lang/Exception
    //   28	32	222	java/lang/Exception
    //   34	43	222	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForScribble
 * JD-Core Version:    0.7.0.1
 */