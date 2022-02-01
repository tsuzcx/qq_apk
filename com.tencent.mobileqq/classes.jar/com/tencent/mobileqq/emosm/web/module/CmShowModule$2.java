package com.tencent.mobileqq.emosm.web.module;

import amme;
import amtm;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$2
  implements Runnable
{
  CmShowModule$2(CmShowModule paramCmShowModule, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    amtm localamtm = ((amme)this.val$qqApp.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
    localamtm.a(localamtm.b(), new CmShowModule.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.2
 * JD-Core Version:    0.7.0.1
 */