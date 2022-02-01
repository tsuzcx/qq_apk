package com.tencent.mobileqq.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.v2.entity.notColumn;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class MessageForAutoReply
  extends MessageForText
{
  public static final String ROOT_TAG = "[AutoReply] ";
  private static final String TAG = "[AutoReply] MessageForAutoReply";
  @notColumn
  public boolean needClickAction = true;
  @notColumn
  public boolean needShowTail = false;
  
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
      boolean bool = OneWayFriendHelper.a((QQAppInterface)localAppRuntime, this.istroop, this.frienduin);
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] MessageForAutoReply", 2, new Object[] { "[message] doParse: invoked. ", " oneWayFriend: ", Boolean.valueOf(bool), " istroop: ", Integer.valueOf(this.istroop), " frienduin: ", this.frienduin, " senderuin: ", this.senderuin });
      }
      if ((this.istroop == 0) && (!bool))
      {
        this.needShowTail = true;
        return;
      }
      this.needShowTail = false;
      this.sb = this.msg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForAutoReply
 * JD-Core Version:    0.7.0.1
 */