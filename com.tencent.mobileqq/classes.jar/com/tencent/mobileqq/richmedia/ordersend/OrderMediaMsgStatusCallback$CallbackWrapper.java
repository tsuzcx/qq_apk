package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.transfile.FileMsg;
import java.lang.ref.WeakReference;

class OrderMediaMsgStatusCallback$CallbackWrapper
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<Callback> b;
  WeakReference<FileMsg> c;
  
  public OrderMediaMsgStatusCallback$CallbackWrapper(OrderMediaMsgStatusCallback paramOrderMediaMsgStatusCallback, View paramView, Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public Callback a()
  {
    return (Callback)this.b.get();
  }
  
  public FileMsg a()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference == null) {
      return null;
    }
    return (FileMsg)localWeakReference.get();
  }
  
  public void a(FileMsg paramFileMsg)
  {
    this.c = new WeakReference(paramFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */