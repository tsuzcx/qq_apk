package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.sveffects.SLog;

public class BigHeadProcessor
  extends BaseQmcfProcessor
{
  String ProcessorResult = "";
  protected String TAG = "BigHeadProcessor";
  boolean couldRunSnpe = false;
  private long mNativeObj = 0L;
  private boolean runInSNPE = false;
  
  protected String modelDestroy()
  {
    if (this.mNativeObj == 0L) {
      return this.ProcessorResult;
    }
    try
    {
      synchronized (mNativeLock)
      {
        if (this.couldRunSnpe) {
          qmcfLinker.snpeBigHeadDestroy(this.mNativeObj);
        } else {
          qmcfLinker.BigHeadDestroy(this.mNativeObj);
        }
        this.mNativeObj = 0L;
        this.ProcessorResult = "success";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label72:
      break label72;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
  }
  
  /* Error */
  protected String modelInit(com.tencent.mobileqq.qmcf.QmcfModelItem paramQmcfModelItem)
  {
    // Byte code:
    //   0: getstatic 39	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeLock	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: getstatic 64	com/tencent/mobileqq/qmcf/QmcfManager:hasSNPESo	Z
    //   9: ifeq +236 -> 245
    //   12: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   15: invokevirtual 68	com/tencent/mobileqq/qmcf/QMCF:snpeAvaliableType	()I
    //   18: istore_2
    //   19: iload_2
    //   20: ifle +18 -> 38
    //   23: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   26: iconst_1
    //   27: invokevirtual 76	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   35: goto +18 -> 53
    //   38: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   41: iconst_3
    //   42: invokevirtual 76	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   50: goto +3 -> 53
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   58: aload_0
    //   59: getfield 28	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:runInSNPE	Z
    //   62: iand
    //   63: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   66: aload_0
    //   67: getfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   70: ifeq +87 -> 157
    //   73: aload_0
    //   74: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   77: aload_0
    //   78: invokevirtual 79	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputHeight	()I
    //   81: aload_0
    //   82: invokevirtual 82	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputWidth	()I
    //   85: aload_1
    //   86: getfield 87	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDlcPath	Ljava/lang/String;
    //   89: ldc 22
    //   91: aload_1
    //   92: getfield 91	com/tencent/mobileqq/qmcf/QmcfModelItem:modelEncrypt	I
    //   95: getstatic 95	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   98: getfield 98	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   101: invokevirtual 102	com/tencent/mobileqq/qmcf/QMCF:snpeBigHeadInit	(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)J
    //   104: putfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   107: new 104	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   114: astore_1
    //   115: aload_1
    //   116: ldc 107
    //   118: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: aload_0
    //   124: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   127: invokevirtual 114	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_1
    //   132: ldc 116
    //   134: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: iload_2
    //   140: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 121
    //   146: aload_1
    //   147: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 130	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   153: pop
    //   154: goto +42 -> 196
    //   157: aload_0
    //   158: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   161: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   164: invokevirtual 133	com/tencent/mobileqq/qmcf/QmcfManager:getRunType	()I
    //   167: aload_0
    //   168: invokevirtual 79	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputHeight	()I
    //   171: aload_0
    //   172: invokevirtual 82	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputWidth	()I
    //   175: aload_1
    //   176: getfield 136	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDeployString	Ljava/lang/String;
    //   179: aload_1
    //   180: getfield 139	com/tencent/mobileqq/qmcf/QmcfModelItem:modelParamPath	Ljava/lang/String;
    //   183: getstatic 95	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   186: getfield 98	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   189: iconst_0
    //   190: invokevirtual 143	com/tencent/mobileqq/qmcf/QMCF:BigHeadInit	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)J
    //   193: putfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   196: aload_3
    //   197: monitorexit
    //   198: aload_0
    //   199: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   202: lconst_0
    //   203: lcmp
    //   204: ifeq +12 -> 216
    //   207: aload_0
    //   208: ldc 55
    //   210: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   213: goto +23 -> 236
    //   216: aload_0
    //   217: ldc 145
    //   219: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   222: goto +14 -> 236
    //   225: astore_1
    //   226: aload_3
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    //   230: aload_0
    //   231: ldc 57
    //   233: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   236: aload_0
    //   237: getfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   240: areturn
    //   241: astore_1
    //   242: goto -12 -> 230
    //   245: iconst_0
    //   246: istore_2
    //   247: goto -194 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	BigHeadProcessor
    //   0	250	1	paramQmcfModelItem	com.tencent.mobileqq.qmcf.QmcfModelItem
    //   18	229	2	i	int
    // Exception table:
    //   from	to	target	type
    //   6	19	225	finally
    //   23	35	225	finally
    //   38	50	225	finally
    //   53	154	225	finally
    //   157	196	225	finally
    //   196	198	225	finally
    //   226	228	225	finally
    //   0	6	241	java/lang/UnsatisfiedLinkError
    //   198	213	241	java/lang/UnsatisfiedLinkError
    //   216	222	241	java/lang/UnsatisfiedLinkError
    //   228	230	241	java/lang/UnsatisfiedLinkError
  }
  
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      synchronized (mNativeLock)
      {
        if (this.couldRunSnpe) {
          this.ProcessorResult = qmcfLinker.snpeBigHeadProcess(this.mNativeObj, paramInt1, paramInt2);
        } else if (this.mNativeObj != 0L) {
          this.ProcessorResult = qmcfLinker.BigHeadProcess(this.mNativeObj, paramInt1, paramInt2);
        }
        long l2 = System.currentTimeMillis();
        if (!SLog.isEnable()) {
          break label137;
        }
        ??? = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BigHead processGLShareSafe cost=");
        localStringBuilder.append(l2 - l1);
        SLog.d((String)???, localStringBuilder.toString());
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label131:
      label137:
      break label131;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.BigHeadProcessor
 * JD-Core Version:    0.7.0.1
 */