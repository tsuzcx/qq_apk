package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class LsRecordConfig
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LsRecord_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("UserGuide", true).commit();
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "markUserGuideFlag");
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LsRecord_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("UserGuide", false) ^ true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LsRecord_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("UserTips", l);
    if (QLog.isDevelopLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("markUserTipsFlag:");
      paramQQAppInterface.append(l);
      QLog.d("LsRecord", 4, paramQQAppInterface.toString());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    long l = System.currentTimeMillis();
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LsRecord_");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localStringBuilder.toString();
    boolean bool = false;
    if (Math.abs(l - localBaseApplicationImpl.getSharedPreferences(paramQQAppInterface, 0).getLong("UserTips", 0L)) >= 3600000L) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LsRecordConfig
 * JD-Core Version:    0.7.0.1
 */