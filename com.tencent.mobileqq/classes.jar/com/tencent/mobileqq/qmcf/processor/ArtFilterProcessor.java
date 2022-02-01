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
  
  protected String modelDestroy()
  {
    if (this.mNativeObj == 0L) {
      return this.ProcessorResult;
    }
    try
    {
      synchronized (mNativeLock)
      {
        qmcfLinker.ArtDestroy(this.mNativeObj);
        this.mNativeObj = 0L;
        this.ProcessorResult = "success";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label51:
      break label51;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
  }
  
  protected String modelInit(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null) {
      this.ProcessorResult = "init model is null";
    }
    try
    {
      synchronized (mNativeLock)
      {
        String str = replaceModelSize(paramQmcfModelItem.modelDeployString, getInputWidth(), getInputHeight());
        this.mNativeObj = qmcfLinker.ArtInit(QmcfManager.getInstance().getRunType(), getInputWidth(), getInputHeight(), str, paramQmcfModelItem.modelParamPath, qmcfManager.CommonPrefixPath);
        if (this.mNativeObj != 0L) {
          this.ProcessorResult = "success";
        } else {
          this.ProcessorResult = "InitError";
        }
      }
    }
    catch (UnsatisfiedLinkError paramQmcfModelItem)
    {
      label105:
      break label105;
    }
    this.ProcessorResult = "UnsatisfiedLinkError";
    return this.ProcessorResult;
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
    synchronized (mNativeLock)
    {
      String str = replaceModelSize(paramQmcfModelItem.modelDeployString, getInputWidth(), getInputHeight());
      this.ProcessorResult = qmcfLinker.ArtSwitchModel(this.mNativeObj, str, paramQmcfModelItem.modelParamPath, qmcfManager.CommonPrefixPath);
      boolean bool = "success".equals(this.ProcessorResult);
      if ((!bool) && (SLog.isEnable()))
      {
        paramQmcfModelItem = this.TAG;
        ??? = new StringBuilder();
        ((StringBuilder)???).append("modelSwitch error:");
        ((StringBuilder)???).append(this.ProcessorResult);
        SLog.d(paramQmcfModelItem, ((StringBuilder)???).toString());
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor
 * JD-Core Version:    0.7.0.1
 */