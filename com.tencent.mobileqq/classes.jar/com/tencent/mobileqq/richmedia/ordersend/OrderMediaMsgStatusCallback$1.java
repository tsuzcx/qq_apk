package com.tencent.mobileqq.richmedia.ordersend;

import afsn;
import android.view.View;
import bboj;
import com.tencent.mobileqq.transfile.FileMsg;

public class OrderMediaMsgStatusCallback$1
  implements Runnable
{
  public OrderMediaMsgStatusCallback$1(bboj parambboj, afsn paramafsn, View paramView, FileMsg paramFileMsg) {}
  
  public void run()
  {
    this.jdField_a_of_type_Afsn.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.status, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */