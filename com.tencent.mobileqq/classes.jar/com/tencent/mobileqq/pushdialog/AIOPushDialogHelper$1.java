package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class AIOPushDialogHelper$1
  implements PushDialogDbUtil.OnPushDialogDbAction
{
  AIOPushDialogHelper$1(AIOPushDialogHelper paramAIOPushDialogHelper) {}
  
  public void a(List<PushDialogTemplate> paramList)
  {
    ThreadManager.getUIHandler().post(new AIOPushDialogHelper.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper.1
 * JD-Core Version:    0.7.0.1
 */