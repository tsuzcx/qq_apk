package com.tencent.mobileqq.qmcf.processor;

import android.util.Log;
import com.tencent.mobileqq.qmcf.QMCF;

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
      if (this.couldRunSnpe) {
        qmcfLinker.snpeSkeletonPose(this.keypoints);
      } else {
        qmcfLinker.getSkeletonPose(this.mNativeObj, this.keypoints);
      }
      return this.keypoints;
    }
  }
  
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
          qmcfLinker.PoseDestroy(this.mNativeObj);
        }
        this.mNativeObj = 0L;
        this.ProcessorResult = "success";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label58:
      break label58;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
  }
  
  /* Error */
  protected String modelInit(com.tencent.mobileqq.qmcf.QmcfModelItem paramQmcfModelItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +12 -> 13
    //   4: aload_0
    //   5: ldc 76
    //   7: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   10: goto +264 -> 274
    //   13: getstatic 46	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeLock	Ljava/lang/Object;
    //   16: astore_3
    //   17: aload_3
    //   18: monitorenter
    //   19: getstatic 81	com/tencent/mobileqq/qmcf/QmcfManager:hasSNPESo	Z
    //   22: ifeq +261 -> 283
    //   25: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   28: invokevirtual 85	com/tencent/mobileqq/qmcf/QMCF:snpeAvaliableType	()I
    //   31: istore_2
    //   32: iload_2
    //   33: ifle +18 -> 51
    //   36: invokestatic 89	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   39: iconst_1
    //   40: invokevirtual 93	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 36	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:couldRunSnpe	Z
    //   48: goto +18 -> 66
    //   51: invokestatic 89	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   54: iconst_3
    //   55: invokevirtual 93	com/tencent/mobileqq/qmcf/QmcfManager:setCurrFrameType	(I)V
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 36	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:couldRunSnpe	Z
    //   63: goto +3 -> 66
    //   66: aload_0
    //   67: getfield 36	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:couldRunSnpe	Z
    //   70: ifeq +86 -> 156
    //   73: aload_0
    //   74: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   77: aload_0
    //   78: invokevirtual 96	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputHeight	()I
    //   81: aload_0
    //   82: invokevirtual 99	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputWidth	()I
    //   85: getstatic 103	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   88: getfield 106	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   91: aload_1
    //   92: getfield 111	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDlcPath	Ljava/lang/String;
    //   95: bipush 18
    //   97: aload_1
    //   98: getfield 114	com/tencent/mobileqq/qmcf/QmcfModelItem:modelEncrypt	I
    //   101: invokevirtual 118	com/tencent/mobileqq/qmcf/QMCF:snpePoseInit	(IILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   104: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   107: new 120	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   114: astore_1
    //   115: aload_1
    //   116: ldc 123
    //   118: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: aload_0
    //   124: getfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   127: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_1
    //   132: ldc 129
    //   134: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: iload_2
    //   140: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 134
    //   146: aload_1
    //   147: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 143	com/tencent/sveffects/SLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto +105 -> 258
    //   156: aload_0
    //   157: aload_1
    //   158: getfield 146	com/tencent/mobileqq/qmcf/QmcfModelItem:modelDeployString	Ljava/lang/String;
    //   161: aload_0
    //   162: invokevirtual 96	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputHeight	()I
    //   165: aload_0
    //   166: invokevirtual 99	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputWidth	()I
    //   169: invokevirtual 150	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:replaceModelSize	(Ljava/lang/String;II)Ljava/lang/String;
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   178: lconst_0
    //   179: lcmp
    //   180: ifeq +8 -> 188
    //   183: aload_0
    //   184: invokevirtual 152	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:modelDestroy	()Ljava/lang/String;
    //   187: pop
    //   188: aload_0
    //   189: getstatic 50	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfLinker	Lcom/tencent/mobileqq/qmcf/QMCF;
    //   192: invokestatic 89	com/tencent/mobileqq/qmcf/QmcfManager:getInstance	()Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   195: invokevirtual 155	com/tencent/mobileqq/qmcf/QmcfManager:getRunType	()I
    //   198: aload_0
    //   199: invokevirtual 96	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputHeight	()I
    //   202: aload_0
    //   203: invokevirtual 99	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputWidth	()I
    //   206: aload_0
    //   207: invokevirtual 96	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputHeight	()I
    //   210: aload_0
    //   211: invokevirtual 99	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:getInputWidth	()I
    //   214: bipush 18
    //   216: aload 4
    //   218: aload_1
    //   219: getfield 158	com/tencent/mobileqq/qmcf/QmcfModelItem:modelParamPath	Ljava/lang/String;
    //   222: getstatic 103	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:qmcfManager	Lcom/tencent/mobileqq/qmcf/QmcfManager;
    //   225: getfield 106	com/tencent/mobileqq/qmcf/QmcfManager:CommonPrefixPath	Ljava/lang/String;
    //   228: invokevirtual 162	com/tencent/mobileqq/qmcf/QMCF:PoseInit	(IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
    //   231: putfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   234: aload_0
    //   235: getfield 30	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:mNativeObj	J
    //   238: lconst_0
    //   239: lcmp
    //   240: ifeq +12 -> 252
    //   243: aload_0
    //   244: ldc 70
    //   246: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   249: goto +9 -> 258
    //   252: aload_0
    //   253: ldc 164
    //   255: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   258: aload_3
    //   259: monitorexit
    //   260: goto +14 -> 274
    //   263: astore_1
    //   264: aload_3
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: ldc 72
    //   271: putfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   274: aload_0
    //   275: getfield 28	com/tencent/mobileqq/qmcf/processor/PoseDetectProcessor:ProcessorResult	Ljava/lang/String;
    //   278: areturn
    //   279: astore_1
    //   280: goto -12 -> 268
    //   283: iconst_0
    //   284: istore_2
    //   285: goto -219 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	PoseDetectProcessor
    //   0	288	1	paramQmcfModelItem	com.tencent.mobileqq.qmcf.QmcfModelItem
    //   31	254	2	i	int
    //   172	45	4	str	String
    // Exception table:
    //   from	to	target	type
    //   19	32	263	finally
    //   36	48	263	finally
    //   51	63	263	finally
    //   66	153	263	finally
    //   156	188	263	finally
    //   188	249	263	finally
    //   252	258	263	finally
    //   258	260	263	finally
    //   264	266	263	finally
    //   13	19	279	java/lang/UnsatisfiedLinkError
    //   266	268	279	java/lang/UnsatisfiedLinkError
  }
  
  protected String modelProcess(int paramInt1, int paramInt2)
  {
    try
    {
      synchronized (mNativeLock)
      {
        if (this.couldRunSnpe)
        {
          long l = System.currentTimeMillis();
          this.ProcessorResult = qmcfLinker.snpePoseProcess(paramInt1, paramInt2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doProcess cost:");
          localStringBuilder.append(System.currentTimeMillis() - l);
          Log.d("poseInfo", localStringBuilder.toString());
        }
        else if (this.mNativeObj != 0L)
        {
          this.ProcessorResult = qmcfLinker.PoseProcess(this.mNativeObj, paramInt1, paramInt2);
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label112:
      break label112;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor
 * JD-Core Version:    0.7.0.1
 */