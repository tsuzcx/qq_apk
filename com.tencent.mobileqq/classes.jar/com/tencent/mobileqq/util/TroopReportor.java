package com.tencent.mobileqq.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TroopReportor
{
  @NonNull
  private static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo)
  {
    if (paramQQAppInterface == null) {
      return "";
    }
    if (paramDiscussionInfo == null) {
      return "";
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return "";
    }
    if (paramDiscussionInfo.isOwnerOrInheritOwner(paramQQAppInterface)) {
      return "0";
    }
    return "1";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.getCurrentAccountUin())) {
        return "0";
      }
      if (paramString.isAdmin()) {
        return "1";
      }
    }
    return "2";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return a(((TroopManager)paramQQAppInterface.getManager(51)).b(paramString1, paramString2));
  }
  
  public static String a(TroopInfo paramTroopInfo, AppRuntime paramAppRuntime)
  {
    String str2 = "";
    String str1 = str2;
    if (paramAppRuntime != null)
    {
      str1 = str2;
      if (paramTroopInfo != null)
      {
        paramAppRuntime = paramAppRuntime.getAccount();
        str1 = str2;
        if (!TextUtils.isEmpty(paramAppRuntime))
        {
          if (!paramTroopInfo.isTroopOwner(paramAppRuntime)) {
            break label42;
          }
          str1 = "0";
        }
      }
    }
    return str1;
    label42:
    if (paramTroopInfo.isTroopAdmin(paramAppRuntime)) {
      return "1";
    }
    return "2";
  }
  
  public static String a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {
      return "";
    }
    switch (paramTroopMemberInfo.level)
    {
    default: 
      return "";
    case 335: 
      return "student";
    case 334: 
      return "parent";
    case 333: 
      return "teacher";
    }
    return "classteacher";
  }
  
  public static String a(TroopInfoData paramTroopInfoData)
  {
    if (paramTroopInfoData == null) {
      return "";
    }
    if (paramTroopInfoData.bOwner) {
      return "0";
    }
    if (paramTroopInfoData.bAdmin) {
      return "1";
    }
    if (paramTroopInfoData.isMember) {
      return "2";
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = (TroopManager)paramQQAppInterface.getManager(51);
    TroopMemberInfo localTroopMemberInfo = ((TroopManager)localObject).b(paramString1, paramQQAppInterface.getCurrentAccountUin());
    localObject = ((TroopManager)localObject).b(paramString1);
    a("Grp_edu", paramString2, paramString3, 0, 0, new String[] { paramString1, a(localTroopMemberInfo), a((TroopInfo)localObject, paramQQAppInterface), String.valueOf(((TroopInfo)localObject).dwGroupClassExt) });
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.c("TroopReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
      ReportController.b(null, "dc00899", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopReportor", 2, localException, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.util.TroopReportor
 * JD-Core Version:    0.7.0.1
 */