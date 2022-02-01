package com.tencent.widget.calloutpopupwindow;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class CalloutPopupWindow$InnerHandler
  extends Handler
{
  public CalloutPopupWindow$InnerHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = ((WeakReference)paramMessage.obj).get();
      if ((paramMessage != null) && ((paramMessage instanceof CalloutPopupWindow))) {
        ((CalloutPopupWindow)paramMessage).dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.InnerHandler
 * JD-Core Version:    0.7.0.1
 */