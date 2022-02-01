package com.tencent.mobileqq.emosm.web.module;

import amme;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.MessengerService;

class CmShowModule$18
  implements Runnable
{
  CmShowModule$18(CmShowModule paramCmShowModule, Bundle paramBundle1, QQAppInterface paramQQAppInterface, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    String str = this.val$reqParam.getString("apollo_face3DData");
    ((amme)this.val$qqApp.getManager(QQManagerFactory.APOLLO_MANAGER)).a(str, new CmShowModule.18.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.module.CmShowModule.18
 * JD-Core Version:    0.7.0.1
 */