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
    Callback localCallback = this.a;
    View localView = this.b;
    FileMsg localFileMsg = this.c;
    localCallback.handleMessage(localView, localFileMsg, localFileMsg.status, this.c.errorCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.1
 * JD-Core Version:    0.7.0.1
 */