package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class SelectVideoUIDelegate$InnerHandler
  extends Handler
{
  private WeakReference<SelectVideoUIDelegate> a;
  
  public SelectVideoUIDelegate$InnerHandler(SelectVideoUIDelegate paramSelectVideoUIDelegate)
  {
    this.a = new WeakReference(paramSelectVideoUIDelegate);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    SelectVideoUIDelegate localSelectVideoUIDelegate = (SelectVideoUIDelegate)this.a.get();
    if (localSelectVideoUIDelegate == null) {
      return;
    }
    if (paramMessage.what == 101) {
      SelectVideoUIDelegate.a(localSelectVideoUIDelegate);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoUIDelegate.InnerHandler
 * JD-Core Version:    0.7.0.1
 */