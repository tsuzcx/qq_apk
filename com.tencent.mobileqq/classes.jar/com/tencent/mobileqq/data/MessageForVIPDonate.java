package com.tencent.mobileqq.data;

import amrf;
import android.text.TextUtils;
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
      this.donateMsg = ((VIPDonateMsg)amrf.a(this.msgData));
      if (QLog.isColorLevel()) {
        QLog.d("MessageForVIPDonate", 2, "doParse :VIPDonateMsg = " + this.donateMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String getSummaryMsg()
  {
    if ((this.donateMsg != null) && (!TextUtils.isEmpty(this.donateMsg.brief))) {
      return this.donateMsg.brief;
    }
    return "[QQ会员赠送]";
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    if (this.donateMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForVIPDonate", 2, "prewrite :VIPDonateMsg = " + this.donateMsg);
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        this.msgData = amrf.a(this.donateMsg);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    QLog.d("MessageForVIPDonate", 2, "prewrite :VIPDonateMsg = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForVIPDonate
 * JD-Core Version:    0.7.0.1
 */