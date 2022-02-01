package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopReportor
{
  private static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > paramInt)) {
      return paramVarArgs[paramInt];
    }
    return "";
  }
  
  public static String a(TroopInfo paramTroopInfo, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime != null) && (paramTroopInfo != null))
    {
      paramAppRuntime = paramAppRuntime.getAccount();
      if (!TextUtils.isEmpty(paramAppRuntime))
      {
        if (paramTroopInfo.isTroopOwner(paramAppRuntime)) {
          return "0";
        }
        if (paramTroopInfo.isTroopAdmin(paramAppRuntime)) {
          return "1";
        }
        return "2";
      }
    }
    return "";
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
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      paramString = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
      if (paramString != null)
      {
        if (paramString.isTroopOwner(paramAppRuntime.getCurrentAccountUin())) {
          return "0";
        }
        if (paramString.isAdmin()) {
          return "1";
        }
      }
      return "2";
    }
    return "";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      return a(((ITroopMemberInfoService)paramAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2));
    }
    return "";
  }
  
  public static void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("department");
      String str1 = ((JSONObject)localObject).getString("opType");
      String str2 = ((JSONObject)localObject).getString("opName");
      int i = ((JSONObject)localObject).getInt("opIn");
      int j = ((JSONObject)localObject).getInt("opResult");
      localObject = a(((JSONObject)localObject).getJSONObject("remains"));
      if ((localObject != null) && (localObject.length >= 4))
      {
        a(paramString, str1, str2, i, j, new String[] { localObject[0], localObject[1], localObject[2], localObject[3] });
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if (paramInt3 == 10001) {
      str = "1";
    } else if (paramInt3 == 10002) {
      str = "2";
    } else if (paramInt3 == 10003) {
      str = "3";
    } else if (paramInt3 == 10004) {
      str = "4";
    } else if ((paramInt3 != 10018) && (paramInt3 != 10017))
    {
      if ((paramInt3 != 10020) && (paramInt3 != 10019))
      {
        if ((paramInt3 != 10022) && (paramInt3 != 10021)) {
          str = null;
        } else {
          str = "8";
        }
      }
      else {
        str = "7";
      }
    }
    else {
      str = "6";
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopReportor", 2, "reportRecSrc");
    }
    if (paramInt1 == 0)
    {
      if (paramInt2 == 1)
      {
        a("Grp_set_new", "recommend", "exp_new", 3, 0, new String[] { paramString, str });
        return;
      }
      if (paramInt2 == 0) {
        a("Grp_set_new", "recommend", "clkjoin_new", 3, 0, new String[] { paramString, str });
      }
    }
    else if (paramInt1 == 1)
    {
      if (paramInt2 == 1)
      {
        a("Grp_join_new", "person_data", "exp_new", 3, 0, new String[] { paramString, str });
        return;
      }
      if (paramInt2 == 0) {
        a("Grp_join_new", "recommend", "clkjoin_new", 3, 0, new String[] { paramString, str });
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    try
    {
      if (SLog.a()) {
        SLog.c("TroopReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", new Object[] { paramString2, paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs) });
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopReportor", 2, localException, new Object[0]);
      }
    }
    ReportController.b(null, "dc00899", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00899", "Grp_tech_report", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("opType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", opName=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", r1=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", r2=");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(",r3=");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(", r4");
      localStringBuilder.append(paramString6);
      QLog.d("ReportTech", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3)
  {
    TroopInfo localTroopInfo = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString1);
    a("Grp_edu", paramString2, paramString3, 0, 0, new String[] { paramString1, a(((ITroopMemberInfoService)paramAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramAppRuntime.getCurrentAccountUin())), a(localTroopInfo, paramAppRuntime), String.valueOf(localTroopInfo.dwGroupClassExt) });
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    if ((paramAppRuntime != null) && (paramVarArgs != null))
    {
      if (paramVarArgs.length < 4) {
        return;
      }
      if (((ITroopMemberInfoService)paramAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInLruCache(paramString1, paramAppRuntime.getAccount()) == null)
      {
        ThreadManagerV2.excute(new TroopReportor.1(paramString2, paramString3, paramInt1, paramInt2, paramVarArgs, paramAppRuntime, paramString1), 32, null, true);
        return;
      }
      a("Grp_edu", paramString2, paramString3, paramInt1, paramInt2, new String[] { paramVarArgs[0], a(paramAppRuntime, paramString1, paramAppRuntime.getCurrentAccountUin()), paramVarArgs[2], paramVarArgs[3] });
    }
  }
  
  public static String[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    try
    {
      if (paramJSONObject.has("r1")) {
        arrayOfString[0] = paramJSONObject.getString("r1");
      }
      if (paramJSONObject.has("r2")) {
        arrayOfString[1] = paramJSONObject.getString("r2");
      }
      if (paramJSONObject.has("r3")) {
        arrayOfString[2] = paramJSONObject.getString("r3");
      }
      if (paramJSONObject.has("r4"))
      {
        arrayOfString[3] = paramJSONObject.getString("r4");
        return arrayOfString;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TroopReportor
 * JD-Core Version:    0.7.0.1
 */