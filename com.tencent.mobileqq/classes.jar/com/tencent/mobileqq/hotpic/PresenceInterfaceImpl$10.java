package com.tencent.mobileqq.hotpic;

import android.app.Dialog;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class PresenceInterfaceImpl$10
  implements Runnable
{
  PresenceInterfaceImpl$10(PresenceInterfaceImpl paramPresenceInterfaceImpl, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.this$0.a, 232, null, this.a, new PresenceInterfaceImpl.10.1(this), null);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "show dialog fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.10
 * JD-Core Version:    0.7.0.1
 */