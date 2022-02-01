package com.tencent.mobileqq.relation.friend.inject;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friend.inject.IContactFacadeInjectService;
import com.tencent.mobileqq.util.FetchBuddyAndTroopNameHelper;

public class ContactFacadeService
  implements IContactFacadeInjectService
{
  public void a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = (ContactFacade)paramAppInterface.getManager(QQManagerFactory.CONTACT_FACADE);
    if (paramAppInterface != null) {
      paramAppInterface.a().b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.friend.inject.ContactFacadeService
 * JD-Core Version:    0.7.0.1
 */