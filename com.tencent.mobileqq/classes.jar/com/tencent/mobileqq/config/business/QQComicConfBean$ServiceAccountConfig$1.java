package com.tencent.mobileqq.config.business;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

class QQComicConfBean$ServiceAccountConfig$1
  implements MiniAppLaunchListener
{
  QQComicConfBean$ServiceAccountConfig$1(QQComicConfBean.ServiceAccountConfig paramServiceAccountConfig, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean.ServiceAccountConfig.1
 * JD-Core Version:    0.7.0.1
 */