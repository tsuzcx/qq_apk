package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.transfile.FileMsg;

class OrderMediaMsgStatusCallback$1
  implements Runnable
{
  OrderMediaMsgStatusCallback$1(OrderMediaMsgStatusCallback paramOrderMediaMsgStatusCallback, FileTransferManager.Callback paramCallback, View paramView, FileMsg paramFileMsg) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioFileTransferManager$Callback.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.status, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */