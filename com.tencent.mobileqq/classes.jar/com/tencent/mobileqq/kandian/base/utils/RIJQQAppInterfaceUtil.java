package com.tencent.mobileqq.kandian.base.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HexUtil;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;

public class RIJQQAppInterfaceUtil
{
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = e();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static QQAppInterface b()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static long c()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return 0L;
    }
    return ((AppRuntime)localObject).getLongAccountUin();
  }
  
  public static String d()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return "0";
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = str;
    if (str == null) {
      localObject = "0";
    }
    return localObject;
  }
  
  public static AppRuntime e()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  public static String f()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      return null;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return null;
    }
    localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
    if (localObject == null) {
      return null;
    }
    localObject = ((WtloginManager)localObject).getGUID();
    if (localObject != null)
    {
      if (localObject.length <= 0) {
        return null;
      }
      return HexUtil.bytes2HexStr((byte[])localObject);
    }
    return null;
  }
  
  public static boolean g()
  {
    return e() instanceof QQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil
 * JD-Core Version:    0.7.0.1
 */