package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class MessageForSafeGrayTips
  extends ChatMessage
{
  private String TAG = "Q.msg.SafeGrayTips";
  public SafeMsg.SafeMoreInfo safeInfo;
  
  public void doParse()
  {
    this.safeInfo = new SafeMsg.SafeMoreInfo();
    String str = this.TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doParse versionCode:");
    ((StringBuilder)localObject).append(this.versionCode);
    QLog.d(str, 2, ((StringBuilder)localObject).toString());
    if (this.versionCode < 3)
    {
      super.postRead();
      QLog.d(this.TAG, 2, "doParse oldversion");
      return;
    }
    try
    {
      this.safeInfo.mergeFrom(this.msgData);
      QLog.d(this.TAG, 2, "doParse msg:");
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dopase exception:");
      localStringBuilder.append(localInvalidProtocolBufferMicroException.getMessage());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prewrite versionCode:");
    localStringBuilder.append(this.versionCode);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (this.versionCode < 3)
    {
      super.prewrite();
      return;
    }
    localObject = this.safeInfo;
    if (localObject == null) {
      return;
    }
    this.msgData = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForSafeGrayTips
 * JD-Core Version:    0.7.0.1
 */