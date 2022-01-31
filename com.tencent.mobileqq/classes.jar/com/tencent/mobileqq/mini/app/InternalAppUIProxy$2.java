package com.tencent.mobileqq.mini.app;

import ajyc;
import android.os.Handler;
import android.os.Message;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class InternalAppUIProxy$2
  implements Runnable
{
  InternalAppUIProxy$2(InternalAppUIProxy paramInternalAppUIProxy, Message paramMessage) {}
  
  public void run()
  {
    String str = (String)this.val$msg.obj;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (str != null) {}
    for (;;)
    {
      bcpw.a(localBaseApplication, 1, str, 1).a();
      InternalAppUIProxy.access$100(this.this$0).postDelayed(new InternalAppUIProxy.2.1(this), 1000L);
      return;
      str = ajyc.a(2131705803);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.InternalAppUIProxy.2
 * JD-Core Version:    0.7.0.1
 */