package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.transfile.FileMsg;

class OrderMediaMsgStatusCallback$1
  implements Runnable
{
  OrderMediaMsgStatusCallback$1(OrderMediaMsgStatusCallback paramOrderMediaMsgStatusCallback, Callback paramCallback, View paramView, FileMsg paramFileMsg) {}
  
  public void run()
  {
    Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioCallback;
    View localView = this.jdField_a_of_type_AndroidViewView;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    localCallback.handleMessage(localView, localFileMsg, localFileMsg.status, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */