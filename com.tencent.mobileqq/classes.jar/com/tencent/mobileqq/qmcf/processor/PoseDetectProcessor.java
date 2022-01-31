package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

public class PoseDetectProcessor
  extends BaseQmcfProcessor
{
  String ProcessorResult = "";
  protected String TAG = "PoseDetectProcessor";
  boolean couldRunSnpe = false;
  float[] keypoints = new float[109];
  private long mNativeObj = 0L;
  final int numOfpoints = 18;
  
  public PoseDetectProcessor(int paramInt1, int paramInt2)
  {
    setInputSize(paramInt1, paramInt2);
  }
  
  public float[] getKeyPoints()
  {
    synchronized (mNativeLock)
    {
      if (this.couldRunSnpe)
      {
        qmcfLinker.snpeSkeletonPose(this.keypoints);
        return this.keypoints;
      }
      qmcfLinker.getSkeletonPose(this.mNativeObj, this.keypoints);
    }
  }
  
  /* Error */
  protected String modelDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   4: lconst_0
    //   5: lcmp
    //   6: ifne +8 -> 14
    //   9: aload_0
    //   10: getfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   13: areturn
    //   14: getstatic 46	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeLock	Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 36	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:couldRunSnpe	Z
    //   24: ifeq +13 -> 37
    //   27: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   30: aload_0
    //   31: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   34: invokevirtual 68	com/tencent/mobileqq/qmcf/QMCF:PoseDestroy	(J)V
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_0
    //   40: lconst_0
    //   41: putfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   44: aload_0
    //   45: ldc 70
    //   47: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   54: areturn
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: ldc 72
    //   64: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   67: goto -17 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	PoseDetectProcessor
    //   60	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   55	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	37	55	finally
    //   37	39	55	finally
    //   56	58	55	finally
    //   14	20	60	java/lang/UnsatisfiedLinkError
    //   39	50	60	java/lang/UnsatisfiedLinkError
    //   58	60	60	java/lang/UnsatisfiedLinkError
  }
  
  protected String modelInit(QmcfModelItem paramQmcfModelItem)
  {
    int i = 0;
    if (paramQmcfModelItem == null)
    {
      this.ProcessorResult = "init model is null";
      return this.ProcessorResult;
    }
    label269:
    for (;;)
    {
      try
      {
        synchronized (mNativeLock)
        {
          if (!QmcfManager.hasSNPESo) {
            break label269;
          }
          i = qmcfLinker.snpeAvaliableType();
          if (i > 0)
          {
            QmcfManager.getInstance().setCurrFrameType(1);
            this.couldRunSnpe = true;
            if (!this.couldRunSnpe) {
              break label164;
            }
            this.ProcessorResult = qmcfLinker.snpePoseInit(getInputHeight(), getInputWidth(), qmcfManager.CommonPrefixPath, paramQmcfModelItem.modelDlcPath, 18, paramQmcfModelItem.modelEncrypt);
            SLog.i("poseInfo", "doInit result:" + this.ProcessorResult + " ,availableType:" + i);
          }
        }
      }
      catch (UnsatisfiedLinkError paramQmcfModelItem)
      {
        this.ProcessorResult = "UnsatisfiedLinkError";
      }
      QmcfManager.getInstance().setCurrFrameType(3);
      this.couldRunSnpe = false;
      break label269;
      label164:
      String str = replaceModelSize(paramQmcfModelItem.modelDeployString, getInputHeight(), getInputWidth());
      if (this.mNativeObj != 0L) {
        modelDestroy();
      }
      this.mNativeObj = qmcfLinker.PoseInit(QmcfManager.getInstance().getRunType(), getInputHeight(), getInputWidth(), getInputHeight(), getInputWidth(), 18, str, paramQmcfModelItem.modelParamPath, qmcfManager.CommonPrefixPath);
      if (this.mNativeObj != 0L) {
        this.ProcessorResult = "success";
      } else {
        this.ProcessorResult = "InitError";
      }
    }
  }
  
  /* Error */
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: getstatic 46	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeLock	Ljava/lang/Object;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 36	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:couldRunSnpe	Z
    //   12: ifeq +56 -> 68
    //   15: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   18: lstore_3
    //   19: aload_0
    //   20: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   23: iload_1
    //   24: iload_2
    //   25: invokevirtual 175	com/tencent/mobileqq/qmcf/QMCF:snpePoseProcess	(II)Ljava/lang/String;
    //   28: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   31: ldc 120
    //   33: new 122	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   40: ldc 177
    //   42: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokestatic 172	java/lang/System:currentTimeMillis	()J
    //   48: lload_3
    //   49: lsub
    //   50: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 186	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: aload 5
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   67: areturn
    //   68: aload_0
    //   69: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   72: lconst_0
    //   73: lcmp
    //   74: ifeq -14 -> 60
    //   77: aload_0
    //   78: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   81: aload_0
    //   82: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   85: iload_1
    //   86: iload_2
    //   87: invokevirtual 190	com/tencent/mobileqq/qmcf/QMCF:PoseProcess	(JII)Ljava/lang/String;
    //   90: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   93: goto -33 -> 60
    //   96: astore 6
    //   98: aload 5
    //   100: monitorexit
    //   101: aload 6
    //   103: athrow
    //   104: astore 5
    //   106: aload_0
    //   107: ldc 72
    //   109: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   112: goto -49 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	PoseDetectProcessor
    //   0	115	1	paramInt1	int
    //   0	115	2	paramInt2	int
    //   18	31	3	l	long
    //   104	1	5	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   96	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	60	96	finally
    //   60	63	96	finally
    //   68	93	96	finally
    //   98	101	96	finally
    //   0	8	104	java/lang/UnsatisfiedLinkError
    //   101	104	104	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor
 * JD-Core Version:    0.7.0.1
 */