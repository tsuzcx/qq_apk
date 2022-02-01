package com.tencent.mobileqq.troop.robot.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class RobotUtilApiImpl
  implements IRobotUtilApi
{
  private static final String TAG = "RobotUtilApiImpl";
  
  private boolean isTroopOwnerOrAdmin(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramAppRuntime = ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
      if (paramAppRuntime != null) {
        return paramAppRuntime.isAdmin();
      }
      QLog.e("RobotUtilApiImpl", 2, "ROBOT RED isTroopOwnerOrAdminOrMember troopInfo IS null");
    }
    return false;
  }
  
  public ArrayList<String> SplitUinListFromString(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split("_");
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          if (!TextUtils.isEmpty(localObject[i]))
          {
            localArrayList.add(localObject[i]);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("RobotRed SplitUinListFromString I empty ");
            localStringBuilder.append(i);
            QLog.e("RobotUtilApiImpl", 2, localStringBuilder.toString());
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RobotRed SplitUinListFromString size  ");
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append(" listString ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("RobotUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public String convertUinListToString(ArrayList<String> paramArrayList)
  {
    String str = "";
    Object localObject = str;
    if (paramArrayList != null)
    {
      localObject = str;
      if (paramArrayList.size() > 0)
      {
        int i = 0;
        for (;;)
        {
          localObject = str;
          if (i >= paramArrayList.size()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append((String)paramArrayList.get(i));
          ((StringBuilder)localObject).append("_");
          str = ((StringBuilder)localObject).toString();
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("RobotRed convertUinListToString  ");
      paramArrayList.append((String)localObject);
      QLog.i("RobotUtilApiImpl", 2, paramArrayList.toString());
    }
    return localObject;
  }
  
  public boolean getBeAllMemberShowRed(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("sp_robot_red_limit_role_for_member", false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("RobotRed getIfTheRightRoleInTroopShowRobotRedDot bNeedShowed: ");
      paramAppRuntime.append(bool);
      QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
    }
    return bool;
  }
  
  public ArrayList<String> getHistoryRobotListFromSp(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return new ArrayList();
    }
    Object localObject = SplitUinListFromString(paramAppRuntime.getString("sp_history_robot_red_list", ""));
    paramAppRuntime = (AppRuntime)localObject;
    if (localObject == null) {
      paramAppRuntime = new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RobotRed getHistoryRobotListFromSp size  ");
      ((StringBuilder)localObject).append(paramAppRuntime.size());
      QLog.d("RobotUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  public boolean getIfRobotRedInfoNeedUpdate(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotSP(paramAppRuntime);
    boolean bool2 = true;
    if (paramAppRuntime == null) {
      return true;
    }
    long l1 = paramAppRuntime.getLong("sp_robot_red_expire_time", 3600L);
    long l2 = paramAppRuntime.getLong("sp_robot_red_update_time", 0L);
    long l3 = NetConnInfoCenter.getServerTime();
    long l4 = l3 - l2;
    boolean bool1 = bool2;
    if (l4 < l1)
    {
      bool1 = bool2;
      if (l4 > 0L) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("RobotRed getIfRobotRedInfoNeedUpdate: ");
      paramAppRuntime.append(l1);
      paramAppRuntime.append(" update :");
      paramAppRuntime.append(l2);
      paramAppRuntime.append(" now：");
      paramAppRuntime.append(l3);
      paramAppRuntime.append(" needUpdate：");
      paramAppRuntime.append(bool1);
      QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
    }
    return bool1;
  }
  
  public boolean getIfTheRightRoleInTroopShowRobotRedDot(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString != "0"))
    {
      if (getBeAllMemberShowRed(paramAppRuntime)) {
        return true;
      }
      boolean bool = isTroopOwnerOrAdmin(paramAppRuntime, paramString);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("RobotRed getIfTheRightRoleInTroopShowRobotRedDot isTroopOwnerOrAdminOrMember: ");
        paramAppRuntime.append(bool);
        QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
      }
      return bool;
    }
    QLog.e("RobotUtilApiImpl", 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
    return false;
  }
  
  public boolean getNeedShowRobotRedDotAio(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString != "0"))
    {
      if (!((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getIfTheRightRoleInTroopShowRobotRedDot(paramAppRuntime, paramString)) {
        return false;
      }
      paramAppRuntime = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotSP(paramAppRuntime);
      if (paramAppRuntime == null) {
        return false;
      }
      boolean bool = paramAppRuntime.getBoolean("sp_robot_red_int_troop_aio", false);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("RobotRed needShowRobotRedDotAio bNeedShowed: ");
        paramAppRuntime.append(bool);
        QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
      }
      return bool;
    }
    QLog.e("RobotUtilApiImpl", 2, "getNeedShowRobotRedDotAio WITH wrong troopUin");
    return false;
  }
  
  public ArrayList<String> getNewRobotListFromSp(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return new ArrayList();
    }
    Object localObject = SplitUinListFromString(paramAppRuntime.getString("sp_new_robot_red_list", ""));
    paramAppRuntime = (AppRuntime)localObject;
    if (localObject == null) {
      paramAppRuntime = new ArrayList();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RobotRed getNewRobotListFromSp size  ");
      ((StringBuilder)localObject).append(paramAppRuntime.size());
      QLog.d("RobotUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  public String getRobotAioBar(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("robot_aio_bar");
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getRobotAioBar,aio_bar:");
      paramString.append(paramContext);
      QLog.d("Q.qqstory", 2, paramString.toString());
    }
    return paramContext;
  }
  
  public boolean getRobotItemRedShowed(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = paramAppRuntime.getBoolean("sp_robot_red_item_int_chat_setting", false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("RobotRed getRobotItemRedShowed bNeedShowed: ");
      paramAppRuntime.append(bool);
      QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
    }
    return bool;
  }
  
  public String getRobotProfileUrl(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("0")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gc=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("&");
      paramString1 = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramString1 = "";
    }
    Object localObject = "robot_uin=";
    if (paramString2 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("robot_uin=");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append("https://web.qun.qq.com/qunrobot/data.html?");
    paramString2.append(paramString1);
    paramString2.append((String)localObject);
    paramString2.append("&_wwv=128&_wv=3");
    return paramString2.toString();
  }
  
  public SharedPreferences getRobotSP(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("RobotUtilApiImpl", 2, "RobotRed  get sp by app is null");
      return null;
    }
    String str = paramAppRuntime.getCurrentUin();
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      paramAppRuntime = paramAppRuntime.getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_robot_in_troop");
      localStringBuilder.append(str);
      return paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    QLog.e("RobotUtilApiImpl", 2, "RobotRed get sp by uin is null");
    return null;
  }
  
  public String getRobotVoiceTail(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("robot_voice_tail");
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getRobotVoiceTail,aio_bar:");
      paramString.append(paramContext);
      QLog.d("Q.qqstory", 2, paramString.toString());
    }
    return paramContext;
  }
  
  public boolean isRobotSwitchOn(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return ((ITroopRobotService)paramAppRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotSwichOn();
  }
  
  public void openRobotProfileCard(Context paramContext, String paramString1, String paramString2)
  {
    ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).openRobotProfileCard(paramContext, paramString1, paramString2);
  }
  
  public boolean setHistoryRobotListToSp(AppRuntime paramAppRuntime, ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramArrayList != null)
    {
      String str = convertUinListToString(paramArrayList);
      paramAppRuntime = getRobotSP(paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.edit().putString("sp_history_robot_red_list", str).apply();
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("RobotRed setHistoryRobotListToSp size  ");
        paramAppRuntime.append(paramArrayList.size());
        QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void setNeedShowRobotRedDotAio(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotRed setHasShowRobotRedDotAio bShowed: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RobotUtilApiImpl", 2, localStringBuilder.toString());
    }
    paramAppRuntime = getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.edit().putBoolean("sp_robot_red_int_troop_aio", paramBoolean).apply();
  }
  
  public boolean setNewRobotListToSp(AppRuntime paramAppRuntime, ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramArrayList != null)
    {
      String str = convertUinListToString(paramArrayList);
      paramAppRuntime = getRobotSP(paramAppRuntime);
      if (paramAppRuntime != null)
      {
        paramAppRuntime.edit().putString("sp_new_robot_red_list", str).apply();
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("RobotRed setNewRobotListToSp size  ");
        paramAppRuntime.append(paramArrayList.size());
        QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void setRobotItemRedShowed(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotRed setRobotItemRedShowed bShowed: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RobotUtilApiImpl", 2, localStringBuilder.toString());
    }
    paramAppRuntime = getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.edit().putBoolean("sp_robot_red_item_int_chat_setting", paramBoolean).apply();
  }
  
  public void setRobotRedForAllMembers(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RobotRed setRobotRedForAllMembers bShowed: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RobotUtilApiImpl", 2, localStringBuilder.toString());
    }
    paramAppRuntime = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime.edit().putBoolean("sp_robot_red_limit_role_for_member", paramBoolean).apply();
  }
  
  public void setRobotRedInfoUpdate(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotSP(paramAppRuntime);
    if (paramAppRuntime == null) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    paramAppRuntime.edit().putLong("sp_robot_red_expire_time", paramLong).apply();
    paramAppRuntime.edit().putLong("sp_robot_red_update_time", l).apply();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("RobotRed setRobotRedInfoUpdate expireTime  ");
      paramAppRuntime.append(paramLong);
      paramAppRuntime.append(" update time: ");
      paramAppRuntime.append(l);
      QLog.d("RobotUtilApiImpl", 2, paramAppRuntime.toString());
    }
  }
  
  public void updateRobotAioBar(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("robot_aio_bar");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public void updateRobotVoiceTail(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("robot_voice_tail");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public void updateTroopRobotConfig(boolean paramBoolean, String paramString)
  {
    ((ITroopRobotService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopRobotService.class, "all")).updateConfig(paramBoolean, paramString);
  }
  
  public void updateTroopRobotPanelVersion(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_robot_panel_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.RobotUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */