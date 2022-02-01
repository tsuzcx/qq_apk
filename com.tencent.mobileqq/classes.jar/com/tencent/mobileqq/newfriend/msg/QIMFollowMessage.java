package com.tencent.mobileqq.newfriend.msg;

import com.tencent.mobileqq.data.QIMFollwerAdd;
import mqq.app.AppRuntime;

public class QIMFollowMessage
  extends NewFriendMessage
{
  public QIMFollwerAdd a;
  
  public QIMFollowMessage(QIMFollwerAdd paramQIMFollwerAdd)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd = paramQIMFollwerAdd;
    this.jdField_a_of_type_Long = paramQIMFollwerAdd.upTime;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd.uin);
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    return "getMessage";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQIMFollwerAdd.isRead;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.QIMFollowMessage
 * JD-Core Version:    0.7.0.1
 */