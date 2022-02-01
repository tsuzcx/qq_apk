package com.tencent.mobileqq.highway.netprobe;

public class EchoProbe
  extends ProbeItem
{
  public static final String PROBE_NAME = "Echo_Probe";
  public static final int RESULT_EXCEPTION = 1;
  public static final int RESULT_NOT_MATCH = 2;
  private EchoTask mEchoTask;
  
  public EchoProbe()
  {
    this(1);
  }
  
  public EchoProbe(int paramInt)
  {
    this.mEchoTask = new EchoTask(WeakNetLearner.mContext, paramInt);
  }
  
  private void onFinish(int paramInt)
  {
    this.mResult.success = false;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        localProbeResult = this.mResult;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("probe has error:");
        localStringBuilder.append(this.mEchoTask.getErrorMsg());
        localProbeResult.errDesc = localStringBuilder.toString();
        this.mResult.errCode = 1;
        return;
      }
      ProbeItem.ProbeResult localProbeResult = this.mResult;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("echo response error,resposne url:");
      localStringBuilder.append(this.mEchoTask.getResponseUrl());
      localProbeResult.errDesc = localStringBuilder.toString();
      this.mResult.errCode = 2;
      return;
    }
    this.mResult.success = true;
    this.mResult.appendResult("echo response is normal!");
  }
  
  public void doProbe()
  {
    onFinish(this.mEchoTask.doEcho());
  }
  
  public String getProbeName()
  {
    String str;
    if (this.mEchoTask.mType == 1) {
      str = "GET_";
    } else if (this.mEchoTask.mType == 2) {
      str = "POST_";
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("Echo_Probe");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.EchoProbe
 * JD-Core Version:    0.7.0.1
 */