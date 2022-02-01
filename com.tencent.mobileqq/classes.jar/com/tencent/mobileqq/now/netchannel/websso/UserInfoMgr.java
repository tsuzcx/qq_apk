package com.tencent.mobileqq.now.netchannel.websso;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class UserInfoMgr
{
  public static UserInfoMgr a;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  
  public static long a()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface == null) {
      return 0L;
    }
    return localAppInterface.getLongAccountUin();
  }
  
  public static AppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static UserInfoMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoUserInfoMgr == null) {
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoUserInfoMgr = new UserInfoMgr();
    }
    return jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoUserInfoMgr;
  }
  
  public static String a()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface == null) {
      return "";
    }
    return localAppInterface.getCurrentAccountUin();
  }
  
  public static TicketManager a()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(localAppInterface.getCurrentAccountUin())) {
      return null;
    }
    return (TicketManager)localAppInterface.getManager(2);
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoUserInfoMgr = null;
  }
  
  public static String b()
  {
    Object localObject = a();
    if (localObject == null) {
      return "";
    }
    localObject = ((TicketManager)localObject).getSkey(a());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return localObject;
  }
  
  public static String c()
  {
    Object localObject = a();
    if (localObject == null) {
      return "";
    }
    localObject = ((TicketManager)localObject).getA2(a());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return localObject;
  }
  
  void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public String d()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr
 * JD-Core Version:    0.7.0.1
 */