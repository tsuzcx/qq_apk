package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMFollwerAdd;
import mqq.app.AppRuntime;

public class QIMFollowMessage
  extends NewFriendMessage
{
  public QIMFollwerAdd a;
  
  public QIMFollowMessage(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.a = paramQIMFollwerAdd;
    this.d = paramQIMFollwerAdd.upTime;
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
    return this.a.isRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.QIMFollowMessage
 * JD-Core Version:    0.7.0.1
 */