package com.tencent.mobileqq.security;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class SecControllerInjectImpl$1
  implements DialogInterface.OnClickListener
{
  SecControllerInjectImpl$1(SecControllerInjectImpl paramSecControllerInjectImpl, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new SecControllerInjectImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.security.SecControllerInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */