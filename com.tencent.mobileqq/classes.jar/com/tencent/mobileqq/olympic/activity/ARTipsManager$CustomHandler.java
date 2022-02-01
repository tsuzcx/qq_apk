package com.tencent.mobileqq.olympic.activity;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ARTipsManager$CustomHandler
  extends Handler
{
  private WeakReference<ARTipsManager> a;
  
  public ARTipsManager$CustomHandler(ARTipsManager paramARTipsManager)
  {
    this.a = new WeakReference(paramARTipsManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ARTipsManager localARTipsManager = (ARTipsManager)this.a.get();
    if (localARTipsManager == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      ARTipsManager.a(localARTipsManager, (ARTipsManager.TipsInfo)paramMessage.obj);
      return;
    }
    ARTipsManager.a(localARTipsManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.CustomHandler
 * JD-Core Version:    0.7.0.1
 */