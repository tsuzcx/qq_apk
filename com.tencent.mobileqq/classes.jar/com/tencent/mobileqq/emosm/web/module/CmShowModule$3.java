package com.tencent.mobileqq.emosm.web.module;

import amme;
import amtm;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$3
  implements Runnable
{
  CmShowModule$3(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = ((amme)this.val$qqApp.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(this.val$reqParam.getString("url"));
    Bundle localBundle = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      localBundle.putInt("result", i);
      this.val$reqbundle.putBundle("response", localBundle);
      this.val$service.a(this.val$reqbundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.3
 * JD-Core Version:    0.7.0.1
 */