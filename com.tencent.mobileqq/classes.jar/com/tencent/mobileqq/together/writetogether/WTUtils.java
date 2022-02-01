package com.tencent.mobileqq.together.writetogether;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class WTUtils
{
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo == null) && (QLog.isColorLevel())) {
      QLog.d("WriteTogetherUtils", 2, "[shouldShowWriteTogetherMenuItem] sessionInfo is null. ");
    }
    return (paramSessionInfo != null) && (paramSessionInfo.a == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.WTUtils
 * JD-Core Version:    0.7.0.1
 */