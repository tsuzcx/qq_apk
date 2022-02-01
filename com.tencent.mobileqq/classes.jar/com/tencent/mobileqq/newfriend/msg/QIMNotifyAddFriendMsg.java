package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import mqq.app.AppRuntime;

public class QIMNotifyAddFriendMsg
  extends NewFriendMessage
{
  public QIMNotifyAddFriend a;
  
  public QIMNotifyAddFriendMsg(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    this.a = paramQIMNotifyAddFriend;
    this.d = paramQIMNotifyAddFriend.pushTime;
  }
  
  public String a()
  {
    return String.valueOf(this.a.uin);
  }
  
  public String b(AppRuntime paramAppRuntime)
  {
    return "getMessage";
  }
  
  public boolean b()
  {
    return this.a.hasRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg
 * JD-Core Version:    0.7.0.1
 */