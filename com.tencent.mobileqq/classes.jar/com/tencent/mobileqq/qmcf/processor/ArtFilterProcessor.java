package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

public class ArtFilterProcessor
  extends BaseQmcfProcessor
{
  String ProcessorResult = "";
  protected String TAG = "ArtFilterProcessor";
  private long mNativeObj = 0L;
  
  public ArtFilterProcessor(int paramInt1, int paramInt2)
  {
    setInputSize(paramInt1, paramInt2);
  }
  
  /* Error */
  protected String modelDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:mNativeObj	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +8 -> 14
    //   9: aload_0
    //   10: getfield 22	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:ProcessorResult	Ljava/lang/String;
    //   13: areturn
    //   14: getstatic 36	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:mNativeLock	Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: getstatic 40	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   23: aload_0
    //   24: getfield 24	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:mNativeObj	J
    //   27: invokevirtual 46	com/tencent/mobileqq/qmcf/QMCF:ArtDestroy	(J)V
    //   30: aload_1
    //   31: monitorexit
    //   32: aload_0
    //   33: lconst_0
    //   34: putfield 24	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:mNativeObj	J
    //   37: aload_0
    //   38: ldc 48
    //   40: putfield 22	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:ProcessorResult	Ljava/lang/String;
    //   43: aload_0
    //   44: getfield 22	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:ProcessorResult	Ljava/lang/String;
    //   47: areturn
    //   48: astore_2
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: ldc 50
    //   57: putfield 22	com/tencent/mobileqq/qmcf/processor/ArtFilterProcessor:ProcessorResult	Ljava/lang/String;
    //   60: goto -17 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	ArtFilterProcessor
    //   53	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   48	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	32	48	finally
    //   49	51	48	finally
    //   14	20	53	java/lang/UnsatisfiedLinkError
    //   32	43	53	java/lang/UnsatisfiedLinkError
    //   51	53	53	java/lang/UnsatisfiedLinkError
  }
  
  protected String modelInit(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null)
    {
      this.ProcessorResult = "init model is null";
      return this.ProcessorResult;
    }
    for (;;)
    {
      try
      {
        synchronized (mNativeLock)
        {
          String str = replaceModelSize(paramQmcfModelItem.modelDeployString, getInputWidth(), getInputHeight());
          this.mNativeObj = qmcfLinker.ArtInit(QmcfManager.getInstance().getRunType(), getInputWidth(), getInputHeight(), str, paramQmcfModelItem.modelParamPath, qmcfManager.CommonPrefixPath);
          if (this.mNativeObj != 0L) {
            this.ProcessorResult = "success";
          }
        }
      }
      catch (UnsatisfiedLinkError paramQmcfModelItem)
      {
        this.ProcessorResult = "UnsatisfiedLinkError";
      }
      this.ProcessorResult = "InitError";
    }
  }
  
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    synchronized (mNativeLock)
    {
      this.ProcessorResult = qmcfLinker.ArtProcess(this.mNativeObj, paramInt1, paramInt2);
      return this.ProcessorResult;
    }
  }
  
  protected boolean modelSwitch(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null) {
      this.ProcessorResult = "switch model is null";
    }
    for (;;)
    {
      boolean bool = "success".equals(this.ProcessorResult);
      if ((!bool) && (SLog.isEnable())) {
        SLog.d(this.TAG, "modelSwitch error:" + this.ProcessorResult);
      }
      return bool;
      synchronized (mNativeLock)
      {
        String str = replaceModelSize(paramQmcfModelItem.modelDeployString, getInputWidth(), getInputHeight());
        this.ProcessorResult = qmcfLinker.ArtSwitchModel(this.mNativeObj, str, paramQmcfModelItem.modelParamPath, qmcfManager.CommonPrefixPath);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor
 * JD-Core Version:    0.7.0.1
 */