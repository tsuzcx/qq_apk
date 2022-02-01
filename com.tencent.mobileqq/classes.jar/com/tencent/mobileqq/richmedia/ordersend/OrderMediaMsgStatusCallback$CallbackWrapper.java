package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.transfile.FileMsg;
import java.lang.ref.WeakReference;

class OrderMediaMsgStatusCallback$CallbackWrapper
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<FileTransferManager.Callback> b;
  WeakReference<FileMsg> c;
  
  public OrderMediaMsgStatusCallback$CallbackWrapper(OrderMediaMsgStatusCallback paramOrderMediaMsgStatusCallback, View paramView, FileTransferManager.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public FileTransferManager.Callback a()
  {
    return (FileTransferManager.Callback)this.b.get();
  }
  
  public FileMsg a()
  {
    if (this.c == null) {
      return null;
    }
    return (FileMsg)this.c.get();
  }
  
  public void a(FileMsg paramFileMsg)
  {
    this.c = new WeakReference(paramFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */