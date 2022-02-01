package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;

public class OrderMediaMsgItem
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  OrderMediaMsgManager.IMsgSendingListener jdField_a_of_type_ComTencentMobileqqRichmediaOrdersendOrderMediaMsgManager$IMsgSendingListener;
  Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public boolean a()
  {
    return (this.a != null) && (this.b == 1);
  }
  
  public boolean b()
  {
    return (this.a != null) && (this.b >= 2);
  }
  
  public boolean c()
  {
    return (this.a != null) && (this.c == 3);
  }
  
  public boolean d()
  {
    return (this.a != null) && (this.c >= 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgItem
 * JD-Core Version:    0.7.0.1
 */