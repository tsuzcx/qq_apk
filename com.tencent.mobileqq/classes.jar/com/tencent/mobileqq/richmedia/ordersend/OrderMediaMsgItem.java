package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;

public class OrderMediaMsgItem
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  MediaMessageObserver jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  IOrderMediaMsgService.IMsgSendingListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendIOrderMediaMsgService$IMsgSendingListener;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_b_of_type_Int == 1);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.jdField_b_of_type_Int >= 2);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.c == 3);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (this.c >= 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(90);
    localStringBuilder.append(" MsgItem{index=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", addStatus=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", sendStatus=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isInvalid=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgItem
 * JD-Core Version:    0.7.0.1
 */