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
  private long b;
  private long c;
  private String d;
  
  public static UserInfoMgr a()
  {
    if (a == null) {
      a = new UserInfoMgr();
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public static AppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static TicketManager d()
  {
    AppInterface localAppInterface = c();
    if (localAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(localAppInterface.getCurrentAccountUin())) {
      return null;
    }
    return (TicketManager)localAppInterface.getManager(2);
  }
  
  public static long e()
  {
    AppInterface localAppInterface = c();
    if (localAppInterface == null) {
      return 0L;
    }
    return localAppInterface.getLongAccountUin();
  }
  
  public static String f()
  {
    AppInterface localAppInterface = c();
    if (localAppInterface == null) {
      return "";
    }
    return localAppInterface.getCurrentAccountUin();
  }
  
  public static String g()
  {
    Object localObject = d();
    if (localObject == null) {
      return "";
    }
    localObject = ((TicketManager)localObject).getSkey(f());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return localObject;
  }
  
  public static String h()
  {
    Object localObject = d();
    if (localObject == null) {
      return "";
    }
    localObject = ((TicketManager)localObject).getA2(f());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return localObject;
  }
  
  void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  void a(String paramString)
  {
    this.d = paramString;
  }
  
  void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public long i()
  {
    return this.b;
  }
  
  public long j()
  {
    return this.c;
  }
  
  public String k()
  {
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr
 * JD-Core Version:    0.7.0.1
 */