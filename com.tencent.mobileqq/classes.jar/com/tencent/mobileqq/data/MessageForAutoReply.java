package com.tencent.mobileqq.data;

import atux;
import azxj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MessageForAutoReply
  extends MessageForText
{
  public static final String ROOT_TAG = "[AutoReply] ";
  private static final String TAG = "[AutoReply] MessageForAutoReply";
  @atux
  public boolean needTextLink;
  
  public MessageForAutoReply()
  {
    this.msgtype = -10000;
  }
  
  protected void doParse()
  {
    super.doParse();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      boolean bool = azxj.a((QQAppInterface)localAppRuntime, this.istroop, this.frienduin);
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] MessageForAutoReply", 2, new Object[] { "[message] doParse: invoked. ", " oneWayFriend: ", Boolean.valueOf(bool), " istroop: ", Integer.valueOf(this.istroop), " frienduin: ", this.frienduin, " senderuin: ", this.senderuin });
      }
      if ((this.istroop == 0) && (!bool)) {
        this.needTextLink = true;
      }
    }
    else
    {
      return;
    }
    this.needTextLink = false;
    this.sb = this.msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForAutoReply
 * JD-Core Version:    0.7.0.1
 */