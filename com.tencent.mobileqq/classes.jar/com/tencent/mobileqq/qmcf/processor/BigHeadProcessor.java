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
  
  /* Error */
  protected String modelDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +8 -> 14
    //   9: aload_0
    //   10: getfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   13: areturn
    //   14: getstatic 39	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeLock	Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   24: ifeq +32 -> 56
    //   27: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   30: aload_0
    //   31: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   34: invokevirtual 49	com/tencent/mobileqq/qmcf/QMCF:snpeBigHeadDestroy	(J)Ljava/lang/String;
    //   37: pop
    //   38: aload_1
    //   39: monitorexit
    //   40: aload_0
    //   41: lconst_0
    //   42: putfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   45: aload_0
    //   46: ldc 51
    //   48: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   55: areturn
    //   56: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   59: aload_0
    //   60: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   63: invokevirtual 55	com/tencent/mobileqq/qmcf/QMCF:BigHeadDestroy	(J)V
    //   66: goto -28 -> 38
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: ldc 57
    //   78: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   81: goto -30 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	BigHeadProcessor
    //   74	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   69	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	38	69	finally
    //   38	40	69	finally
    //   56	66	69	finally
    //   70	72	69	finally
    //   14	20	74	java/lang/UnsatisfiedLinkError
    //   40	51	74	java/lang/UnsatisfiedLinkError
    //   72	74	74	java/lang/UnsatisfiedLinkError
  }
  
  /* Error */
  protected String modelInit(com.tencent.mobileqq.qmcf.QmcfModelItem paramQmcfModelItem)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: getstatic 39	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeLock	Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_3
    //   7: monitorenter
    //   8: getstatic 64	com/tencent/mobileqq/qmcf/QmcfManager:hasSNPESo	Z
    //   11: ifeq +220 -> 231
    //   14: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   17: invokevirtual 68	com/tencent/mobileqq/qmcf/QMCF:snpeAvaliableType	()I
    //   20: istore_2
    //   21: iload_2
    //   22: ifle +128 -> 150
    //   25: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   28: iconst_1
    //   29: invokevirtual 76	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   42: aload_0
    //   43: getfield 28	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:runInSNPE	Z
    //   46: iand
    //   47: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   50: aload_0
    //   51: getfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   54: ifeq +111 -> 165
    //   57: aload_0
    //   58: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   61: aload_0
    //   62: invokevirtual 79	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputHeight	()I
    //   65: aload_0
    //   66: invokevirtual 82	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputWidth	()I
    //   69: aload_1
    //   70: getfield 87	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDlcPath	Ljava/lang/String;
    //   73: ldc 22
    //   75: aload_1
    //   76: getfield 91	com/tencent/mobileqq/qmcf/QmcfModelItem:modelEncrypt	I
    //   79: getstatic 95	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   82: getfield 98	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   85: invokevirtual 102	com/tencent/mobileqq/qmcf/QMCF:snpeBigHeadInit	(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)J
    //   88: putfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   91: ldc 104
    //   93: new 106	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   100: ldc 109
    //   102: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   109: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: ldc 118
    //   114: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_2
    //   118: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 130	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   127: pop
    //   128: aload_3
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   134: lconst_0
    //   135: lcmp
    //   136: ifeq +86 -> 222
    //   139: aload_0
    //   140: ldc 51
    //   142: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   145: aload_0
    //   146: getfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   149: areturn
    //   150: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   153: iconst_3
    //   154: invokevirtual 76	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield 30	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:couldRunSnpe	Z
    //   162: goto +69 -> 231
    //   165: aload_0
    //   166: getstatic 43	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   169: invokestatic 72	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   172: invokevirtual 133	com/tencent/mobileqq/qmcf/QmcfManager:getRunType	()I
    //   175: aload_0
    //   176: invokevirtual 79	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputHeight	()I
    //   179: aload_0
    //   180: invokevirtual 82	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:getInputWidth	()I
    //   183: aload_1
    //   184: getfield 136	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDeployString	Ljava/lang/String;
    //   187: aload_1
    //   188: getfield 139	com/tencent/mobileqq/qmcf/QmcfModelItem:modelParamPath	Ljava/lang/String;
    //   191: getstatic 95	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   194: getfield 98	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   197: iconst_0
    //   198: invokevirtual 143	com/tencent/mobileqq/qmcf/QMCF:BigHeadInit	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)J
    //   201: putfield 26	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:mNativeObj	J
    //   204: goto -76 -> 128
    //   207: astore_1
    //   208: aload_3
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload_0
    //   214: ldc 57
    //   216: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   219: goto -74 -> 145
    //   222: aload_0
    //   223: ldc 145
    //   225: putfield 24	com/tencent/mobileqq/qmcf/processor/BigHeadProcessor:ProcessorResult	Ljava/lang/String;
    //   228: goto -83 -> 145
    //   231: goto -194 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	BigHeadProcessor
    //   0	234	1	paramQmcfModelItem	com.tencent.mobileqq.qmcf.QmcfModelItem
    //   1	117	2	i	int
    // Exception table:
    //   from	to	target	type
    //   8	21	207	finally
    //   25	37	207	finally
    //   37	128	207	finally
    //   128	130	207	finally
    //   150	162	207	finally
    //   165	204	207	finally
    //   208	210	207	finally
    //   2	8	212	java/lang/UnsatisfiedLinkError
    //   130	145	212	java/lang/UnsatisfiedLinkError
    //   210	212	212	java/lang/UnsatisfiedLinkError
    //   222	228	212	java/lang/UnsatisfiedLinkError
  }
  
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        long l1;
        this.ProcessorResult = "UnsatisfiedLinkError";
        continue;
      }
      synchronized (mNativeLock)
      {
        if (this.couldRunSnpe)
        {
          this.ProcessorResult = qmcfLinker.snpeBigHeadProcess(this.mNativeObj, paramInt1, paramInt2);
          long l2 = System.currentTimeMillis();
          if (SLog.isEnable()) {
            SLog.d(this.TAG, "BigHead processGLShareSafe cost=" + (l2 - l1));
          }
          return this.ProcessorResult;
        }
        if (this.mNativeObj == 0L) {
          continue;
        }
        this.ProcessorResult = qmcfLinker.BigHeadProcess(this.mNativeObj, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.BigHeadProcessor
 * JD-Core Version:    0.7.0.1
 */