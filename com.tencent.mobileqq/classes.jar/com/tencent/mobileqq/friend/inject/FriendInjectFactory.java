package com.tencent.mobileqq.friend.inject;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.relation.friend.inject.PhoneContactService;
import com.tencent.mobileqq.relation.friend.inject.PubAccountService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FriendInjectFactory
{
  private static IContactFacadeInjectService jdField_a_of_type_ComTencentMobileqqFriendInjectIContactFacadeInjectService;
  private static IPhoneContactInjectService jdField_a_of_type_ComTencentMobileqqFriendInjectIPhoneContactInjectService;
  private static IPubAccountInjectService jdField_a_of_type_ComTencentMobileqqFriendInjectIPubAccountInjectService;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_PhoneContactService.yml", version=1)
  private static ArrayList<Class<? extends IPhoneContactInjectService>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_ContactFacadeService.yml", version=1)
  private static ArrayList<Class<? extends IContactFacadeInjectService>> b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_PubAccountService.yml", version=1)
  private static ArrayList<Class<? extends IPubAccountInjectService>> c;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(PhoneContactService.class);
    b = new ArrayList();
    c = new ArrayList();
    c.add(PubAccountService.class);
  }
  
  public static IContactFacadeInjectService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFriendInjectIContactFacadeInjectService == null) {
      try
      {
        IContactFacadeInjectService localIContactFacadeInjectService = jdField_a_of_type_ComTencentMobileqqFriendInjectIContactFacadeInjectService;
        if (localIContactFacadeInjectService == null) {
          try
          {
            jdField_a_of_type_ComTencentMobileqqFriendInjectIContactFacadeInjectService = (IContactFacadeInjectService)((Class)b.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getContactFacadeService", localException);
          }
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFriendInjectIContactFacadeInjectService;
  }
  
  public static IPhoneContactInjectService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFriendInjectIPhoneContactInjectService == null) {
      try
      {
        IPhoneContactInjectService localIPhoneContactInjectService = jdField_a_of_type_ComTencentMobileqqFriendInjectIPhoneContactInjectService;
        if (localIPhoneContactInjectService == null) {
          try
          {
            jdField_a_of_type_ComTencentMobileqqFriendInjectIPhoneContactInjectService = (IPhoneContactInjectService)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getPhoneContactService", localException);
          }
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFriendInjectIPhoneContactInjectService;
  }
  
  public static IPubAccountInjectService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqFriendInjectIPubAccountInjectService == null) {
      try
      {
        IPubAccountInjectService localIPubAccountInjectService = jdField_a_of_type_ComTencentMobileqqFriendInjectIPubAccountInjectService;
        if (localIPubAccountInjectService == null) {
          try
          {
            jdField_a_of_type_ComTencentMobileqqFriendInjectIPubAccountInjectService = (IPubAccountInjectService)((Class)c.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getPubAccountService", localException);
          }
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqFriendInjectIPubAccountInjectService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.inject.FriendInjectFactory
 * JD-Core Version:    0.7.0.1
 */