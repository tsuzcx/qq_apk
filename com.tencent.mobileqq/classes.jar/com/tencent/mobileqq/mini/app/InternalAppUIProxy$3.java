package com.tencent.mobileqq.mini.app;

import amtj;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class InternalAppUIProxy$3
  implements Runnable
{
  InternalAppUIProxy$3(InternalAppUIProxy paramInternalAppUIProxy, Message paramMessage) {}
  
  public void run()
  {
    String str = (String)this.val$msg.obj;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (str != null) {}
    for (;;)
    {
      QQToast.a(localBaseApplication, 1, str, 1).a();
      InternalAppUIProxy.access$100(this.this$0).postDelayed(new InternalAppUIProxy.3.1(this), 1000L);
      return;
      str = amtj.a(2131704933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.InternalAppUIProxy.3
 * JD-Core Version:    0.7.0.1
 */