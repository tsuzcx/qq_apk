package com.tencent.mobileqq.friend.phonecontact;

import com.tencent.mobileqq.friend.api.inject.IPhoneContactService;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhoneContactInjectFactory
{
  private static IPhoneContactService jdField_a_of_type_ComTencentMobileqqFriendApiInjectIPhoneContactService;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_FriendPhoneContactService", version=1)
  private static ArrayList<Class<? extends IPhoneContactService>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static IPhoneContactService a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      a();
      jdField_a_of_type_Boolean = true;
    }
    return jdField_a_of_type_ComTencentMobileqqFriendApiInjectIPhoneContactService;
  }
  
  private static void a()
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqFriendApiInjectIPhoneContactService = (IPhoneContactService)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("PhoneContactInjectFactory", 1, "initPhoneContactService", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.phonecontact.PhoneContactInjectFactory
 * JD-Core Version:    0.7.0.1
 */