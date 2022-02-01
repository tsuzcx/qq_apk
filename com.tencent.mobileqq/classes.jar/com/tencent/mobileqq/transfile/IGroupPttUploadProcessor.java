package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface IGroupPttUploadProcessor
{
  public abstract void copyStatisInfo(StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, StatictisInfo paramStatictisInfo);
  
  public abstract im_msg_body.RichText getNewestPTTRichText(MessageForPtt paramMessageForPtt);
  
  public abstract TransferRequest getRequest();
  
  public abstract StepInfo getStepMsg();
  
  public abstract void logRichMediaEvent(String paramString1, String paramString2);
  
  public abstract void onError();
  
  public abstract void onSuccess();
  
  public abstract void setShouldMsgReportSucc(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.IGroupPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */