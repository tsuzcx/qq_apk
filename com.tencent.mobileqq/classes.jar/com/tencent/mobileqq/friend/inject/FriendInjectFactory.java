package com.tencent.mobileqq.friend.inject;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.relation.friend.inject.PhoneContactService;
import com.tencent.mobileqq.relation.friend.inject.PubAccountService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FriendInjectFactory
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_PhoneContactService.yml", version=1)
  private static ArrayList<Class<? extends IPhoneContactInjectService>> a = new ArrayList();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_ContactFacadeService.yml", version=1)
  private static ArrayList<Class<? extends IContactFacadeInjectService>> b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_PubAccountService.yml", version=1)
  private static ArrayList<Class<? extends IPubAccountInjectService>> c;
  private static IContactFacadeInjectService d;
  private static IPhoneContactInjectService e;
  private static IPubAccountInjectService f;
  
  static
  {
    a.add(PhoneContactService.class);
    b = new ArrayList();
    c = new ArrayList();
    c.add(PubAccountService.class);
  }
  
  public static IContactFacadeInjectService a()
  {
    if (d == null) {
      try
      {
        IContactFacadeInjectService localIContactFacadeInjectService = d;
        if (localIContactFacadeInjectService == null) {
          try
          {
            int i = b.size();
            if (i == 0) {
              return null;
            }
            d = (IContactFacadeInjectService)((Class)b.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getContactFacadeService", localException);
          }
        }
      }
      finally {}
    }
    return d;
  }
  
  public static IPhoneContactInjectService b()
  {
    if (e == null) {
      try
      {
        IPhoneContactInjectService localIPhoneContactInjectService = e;
        if (localIPhoneContactInjectService == null) {
          try
          {
            int i = a.size();
            if (i == 0) {
              return null;
            }
            e = (IPhoneContactInjectService)((Class)a.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getPhoneContactService", localException);
          }
        }
      }
      finally {}
    }
    return e;
  }
  
  public static IPubAccountInjectService c()
  {
    if (f == null) {
      try
      {
        IPubAccountInjectService localIPubAccountInjectService = f;
        if (localIPubAccountInjectService == null) {
          try
          {
            int i = c.size();
            if (i == 0) {
              return null;
            }
            f = (IPubAccountInjectService)((Class)c.get(0)).newInstance();
          }
          catch (Exception localException)
          {
            QLog.d("FriendInjectFactory", 1, "getPubAccountService", localException);
          }
        }
      }
      finally {}
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.inject.FriendInjectFactory
 * JD-Core Version:    0.7.0.1
 */