package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.transfile.FileMsg;
import java.lang.ref.WeakReference;

class OrderMediaMsgStatusCallback$CallbackWrapper
{
  WeakReference<View> a;
  WeakReference<Callback> b;
  WeakReference<FileMsg> c;
  
  public OrderMediaMsgStatusCallback$CallbackWrapper(OrderMediaMsgStatusCallback paramOrderMediaMsgStatusCallback, View paramView, Callback paramCallback)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
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
  
  public View b()
  {
    return (View)this.a.get();
  }
  
  public Callback c()
  {
    return (Callback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback.CallbackWrapper
 * JD-Core Version:    0.7.0.1
 */