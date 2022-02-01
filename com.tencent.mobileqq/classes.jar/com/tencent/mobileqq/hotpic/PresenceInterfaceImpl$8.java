package com.tencent.mobileqq.hotpic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class PresenceInterfaceImpl$8
  implements DialogInterface.OnClickListener
{
  PresenceInterfaceImpl$8(PresenceInterfaceImpl paramPresenceInterfaceImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PresenceInterfaceImpl.a = false;
    PresenceInterfaceImpl.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), false);
    this.a.c.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "User disallowed downd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.8
 * JD-Core Version:    0.7.0.1
 */