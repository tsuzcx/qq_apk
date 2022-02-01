package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
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
  public int gifId = 0;
  public String localFildPath = "";
  public MessageForScribble.FileExistInfo mExistInfo = new MessageForScribble.FileExistInfo(this);
  public ProgressPieDrawable mProgressPie;
  public int mRealProgress;
  public int mUiProgress;
  public Runnable mUpdateProgressRunnable;
  public int offSet = 0;
  
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
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_1
    //   8: aload 4
    //   10: astore_2
    //   11: aload 5
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   18: ifnull +150 -> 168
    //   21: aload 4
    //   23: astore_2
    //   24: aload 5
    //   26: astore_3
    //   27: new 96	java/io/ObjectInputStream
    //   30: dup
    //   31: new 98	java/io/ByteArrayInputStream
    //   34: dup
    //   35: aload_0
    //   36: getfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   39: invokespecial 101	java/io/ByteArrayInputStream:<init>	([B)V
    //   42: invokespecial 104	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_2
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 106	com/tencent/mobileqq/data/MessageForScribble:readExternal	(Ljava/io/ObjectInput;)V
    //   53: aload_1
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   59: ldc 108
    //   61: invokestatic 114	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   64: checkcast 108	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   67: aload_0
    //   68: getfield 55	com/tencent/mobileqq/data/MessageForScribble:localFildPath	Ljava/lang/String;
    //   71: invokeinterface 118 2 0
    //   76: putfield 122	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mLocalPathExist	Z
    //   79: aload_1
    //   80: astore_2
    //   81: aload_0
    //   82: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   85: ldc 108
    //   87: invokestatic 114	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   90: checkcast 108	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   93: ldc 124
    //   95: invokestatic 114	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   98: checkcast 124	com/tencent/mobileqq/scribble/IScribbleMsgUtils
    //   101: aload_0
    //   102: invokeinterface 128 2 0
    //   107: invokeinterface 118 2 0
    //   112: putfield 131	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mDataFileExist	Z
    //   115: aload_1
    //   116: astore_2
    //   117: aload_0
    //   118: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   121: ldc 108
    //   123: invokestatic 114	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   126: checkcast 108	com/tencent/mobileqq/qqcommon/api/IFileUtilsApi
    //   129: ldc 124
    //   131: invokestatic 114	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   134: checkcast 124	com/tencent/mobileqq/scribble/IScribbleMsgUtils
    //   137: aload_0
    //   138: invokeinterface 134 2 0
    //   143: invokeinterface 118 2 0
    //   148: putfield 137	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mCombineFileExist	Z
    //   151: aload_1
    //   152: astore_2
    //   153: aload_0
    //   154: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   157: iconst_1
    //   158: putfield 140	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mInit	Z
    //   161: goto +7 -> 168
    //   164: astore_3
    //   165: goto +35 -> 200
    //   168: aload_1
    //   169: astore_2
    //   170: aload_1
    //   171: astore_3
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 143	com/tencent/mobileqq/data/MessageForScribble:getSummaryMsg	()Ljava/lang/String;
    //   177: putfield 146	com/tencent/mobileqq/data/MessageForScribble:msg	Ljava/lang/String;
    //   180: aload_1
    //   181: ifnull +54 -> 235
    //   184: aload_1
    //   185: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   188: goto +47 -> 235
    //   191: astore_1
    //   192: goto +120 -> 312
    //   195: astore_2
    //   196: aload_3
    //   197: astore_1
    //   198: aload_2
    //   199: astore_3
    //   200: aload_1
    //   201: astore_2
    //   202: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +14 -> 219
    //   208: aload_1
    //   209: astore_2
    //   210: ldc 8
    //   212: iconst_2
    //   213: ldc 157
    //   215: aload_3
    //   216: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_1
    //   220: ifnull +15 -> 235
    //   223: aload_1
    //   224: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   227: goto +8 -> 235
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   235: new 166	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   242: astore_1
    //   243: aload_1
    //   244: ldc 169
    //   246: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: aload_0
    //   252: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   255: getfield 122	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mLocalPathExist	Z
    //   258: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_1
    //   263: ldc 178
    //   265: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: aload_0
    //   271: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   274: getfield 131	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mDataFileExist	Z
    //   277: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_1
    //   282: ldc 178
    //   284: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_1
    //   289: aload_0
    //   290: getfield 62	com/tencent/mobileqq/data/MessageForScribble:mExistInfo	Lcom/tencent/mobileqq/data/MessageForScribble$FileExistInfo;
    //   293: getfield 137	com/tencent/mobileqq/data/MessageForScribble$FileExistInfo:mCombineFileExist	Z
    //   296: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: ldc 8
    //   302: iconst_2
    //   303: aload_1
    //   304: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: return
    //   311: astore_1
    //   312: aload_2
    //   313: ifnull +15 -> 328
    //   316: aload_2
    //   317: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   320: goto +8 -> 328
    //   323: astore_2
    //   324: aload_2
    //   325: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   328: aload_1
    //   329: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	MessageForScribble
    //   7	178	1	localObjectInputStream	java.io.ObjectInputStream
    //   191	1	1	localObject1	java.lang.Object
    //   197	27	1	localObject2	java.lang.Object
    //   230	2	1	localException1	java.lang.Exception
    //   242	62	1	localStringBuilder	java.lang.StringBuilder
    //   311	18	1	localObject3	java.lang.Object
    //   10	160	2	localObject4	java.lang.Object
    //   195	4	2	localException2	java.lang.Exception
    //   201	116	2	localObject5	java.lang.Object
    //   323	2	2	localException3	java.lang.Exception
    //   13	14	3	localObject6	java.lang.Object
    //   164	1	3	localException4	java.lang.Exception
    //   171	45	3	localObject7	java.lang.Object
    //   1	21	4	localObject8	java.lang.Object
    //   4	21	5	localObject9	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   48	53	164	java/lang/Exception
    //   55	79	164	java/lang/Exception
    //   81	115	164	java/lang/Exception
    //   117	151	164	java/lang/Exception
    //   153	161	164	java/lang/Exception
    //   14	21	191	finally
    //   27	46	191	finally
    //   172	180	191	finally
    //   14	21	195	java/lang/Exception
    //   27	46	195	java/lang/Exception
    //   172	180	195	java/lang/Exception
    //   184	188	230	java/lang/Exception
    //   223	227	230	java/lang/Exception
    //   48	53	311	finally
    //   55	79	311	finally
    //   81	115	311	finally
    //   117	151	311	finally
    //   153	161	311	finally
    //   202	208	311	finally
    //   210	219	311	finally
    //   316	320	323	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return HardCodeUtil.a(2131897739);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 199	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 200	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 202	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 205	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 207	com/tencent/mobileqq/data/MessageForScribble:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 208	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 212	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 94	com/tencent/mobileqq/data/MessageForScribble:msgData	[B
    //   43: aload_2
    //   44: invokevirtual 208	java/io/ObjectOutputStream:close	()V
    //   47: goto +19 -> 66
    //   50: astore_1
    //   51: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +12 -> 66
    //   57: ldc 8
    //   59: iconst_2
    //   60: ldc 214
    //   62: aload_1
    //   63: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload 4
    //   68: invokevirtual 215	java/io/ByteArrayOutputStream:close	()V
    //   71: return
    //   72: astore_3
    //   73: goto +12 -> 85
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_2
    //   79: goto +74 -> 153
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +14 -> 104
    //   93: aload_2
    //   94: astore_1
    //   95: ldc 8
    //   97: iconst_2
    //   98: ldc 214
    //   100: aload_3
    //   101: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_2
    //   105: ifnull +26 -> 131
    //   108: aload_2
    //   109: invokevirtual 208	java/io/ObjectOutputStream:close	()V
    //   112: goto +19 -> 131
    //   115: astore_1
    //   116: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +12 -> 131
    //   122: ldc 8
    //   124: iconst_2
    //   125: ldc 214
    //   127: aload_1
    //   128: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload 4
    //   133: invokevirtual 215	java/io/ByteArrayOutputStream:close	()V
    //   136: return
    //   137: astore_1
    //   138: ldc 8
    //   140: iconst_2
    //   141: ldc 214
    //   143: aload_1
    //   144: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: return
    //   148: astore_3
    //   149: aload_1
    //   150: astore_2
    //   151: aload_3
    //   152: astore_1
    //   153: aload_2
    //   154: ifnull +26 -> 180
    //   157: aload_2
    //   158: invokevirtual 208	java/io/ObjectOutputStream:close	()V
    //   161: goto +19 -> 180
    //   164: astore_2
    //   165: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +12 -> 180
    //   171: ldc 8
    //   173: iconst_2
    //   174: ldc 214
    //   176: aload_2
    //   177: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload 4
    //   182: invokevirtual 215	java/io/ByteArrayOutputStream:close	()V
    //   185: goto +13 -> 198
    //   188: astore_2
    //   189: ldc 8
    //   191: iconst_2
    //   192: ldc 214
    //   194: aload_2
    //   195: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_1
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	MessageForScribble
    //   20	14	1	localObject1	java.lang.Object
    //   50	13	1	localException1	java.lang.Exception
    //   76	1	1	localObject2	java.lang.Object
    //   86	9	1	localObject3	java.lang.Object
    //   115	13	1	localException2	java.lang.Exception
    //   137	13	1	localException3	java.lang.Exception
    //   152	47	1	localObject4	java.lang.Object
    //   18	140	2	localObject5	java.lang.Object
    //   164	13	2	localException4	java.lang.Exception
    //   188	7	2	localException5	java.lang.Exception
    //   72	1	3	localException6	java.lang.Exception
    //   82	19	3	localException7	java.lang.Exception
    //   148	4	3	localObject6	java.lang.Object
    //   7	174	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   21	26	72	java/lang/Exception
    //   28	32	72	java/lang/Exception
    //   34	43	72	java/lang/Exception
    //   9	19	76	finally
    //   9	19	82	java/lang/Exception
    //   108	112	115	java/lang/Exception
    //   66	71	137	java/lang/Exception
    //   131	136	137	java/lang/Exception
    //   21	26	148	finally
    //   28	32	148	finally
    //   34	43	148	finally
    //   87	93	148	finally
    //   95	104	148	finally
    //   157	161	164	java/lang/Exception
    //   180	185	188	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForScribble
 * JD-Core Version:    0.7.0.1
 */