package com.tencent.mobileqq.kandian.biz.common.widget;

import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ReadInJoyXListView$UICallBack
  implements Handler.Callback
{
  private WeakReference<ReadInJoyXListView> a;
  
  public ReadInJoyXListView$UICallBack(ReadInJoyXListView paramReadInJoyXListView)
  {
    this.a = new WeakReference(paramReadInJoyXListView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = this.a;
    if ((paramMessage != null) && (paramMessage.get() != null)) {
      ((ReadInJoyXListView)this.a.get()).i();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView.UICallBack
 * JD-Core Version:    0.7.0.1
 */