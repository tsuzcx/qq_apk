package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForVIPDonate
  extends ChatMessage
{
  public static final String DEFAULT_SUMMARYMSG = "[QQ会员赠送]";
  public VIPDonateMsg donateMsg;
  
  protected void doParse()
  {
    try
    {
      this.donateMsg = ((VIPDonateMsg)MessagePkgUtils.a(this.msgData));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doParse :VIPDonateMsg = ");
        localStringBuilder.append(this.donateMsg);
        QLog.d("MessageForVIPDonate", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getSummaryMsg()
  {
    VIPDonateMsg localVIPDonateMsg = this.donateMsg;
    if ((localVIPDonateMsg != null) && (!TextUtils.isEmpty(localVIPDonateMsg.brief))) {
      return this.donateMsg.brief;
    }
    return "[QQ会员赠送]";
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.donateMsg != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prewrite :VIPDonateMsg = ");
        localStringBuilder.append(this.donateMsg);
        QLog.d("MessageForVIPDonate", 2, localStringBuilder.toString());
      }
      try
      {
        this.msgData = MessagePkgUtils.a(this.donateMsg);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageForVIPDonate", 2, "prewrite :VIPDonateMsg = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVIPDonate
 * JD-Core Version:    0.7.0.1
 */