package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import mqq.app.AppRuntime;

public class QIMNotifyAddFriendMsg
  extends NewFriendMessage
{
  public QIMNotifyAddFriend a;
  
  public QIMNotifyAddFriendMsg(QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    this.jdField_a_of_type_Long = paramQIMNotifyAddFriend.pushTime;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend.uin);
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    return "getMessage";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend.hasRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg
 * JD-Core Version:    0.7.0.1
 */