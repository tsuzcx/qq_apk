package com.tencent.mobileqq.hotpic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;

class PresenceInterfaceImpl$3
  implements DialogInterface.OnClickListener
{
  PresenceInterfaceImpl$3(PresenceInterfaceImpl paramPresenceInterfaceImpl, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.e.post(new PresenceInterfaceImpl.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.3
 * JD-Core Version:    0.7.0.1
 */