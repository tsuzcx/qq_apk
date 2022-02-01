package com.tencent.mobileqq.troop.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService.OnGetTroopMemberNameCallback;
import com.tencent.mobileqq.troop.api.config.TroopCommonConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class TroopMemberNameServiceImpl
  implements ITroopMemberNameService
{
  public static final String TAG = "TroopMemberNameServiceImpl";
  protected AppRuntime app;
  
  public String getTroopMemberColorNick(String paramString1, String paramString2)
  {
    if (this.app == null) {
      return "";
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramString1 = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.troopColorNick))) {
      return paramString1.troopColorNick;
    }
    return "";
  }
  
  public String getTroopMemberName(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberNameServiceImpl", 2, "getTroopMemberName tmi == null");
      }
      return "";
    }
    Object localObject = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramTroopMemberInfo.memberuin, true);
    if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark)))
    {
      localObject = ((Friends)localObject).remark;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label203;
      }
      localObject = paramTroopMemberInfo.memberuin;
    }
    label203:
    for (;;)
    {
      if ((localObject != null) && (((String)localObject).equals(paramTroopMemberInfo.memberuin)))
      {
        paramTroopMemberInfo = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramTroopMemberInfo.troopuin);
        if ((paramTroopMemberInfo != null) && (paramTroopMemberInfo.isQidianPrivateTroop()))
        {
          return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
          if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick))
          {
            localObject = paramTroopMemberInfo.troopnick;
            break;
          }
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            localObject = ((Friends)localObject).name;
            break;
          }
          if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark))
          {
            localObject = paramTroopMemberInfo.autoremark;
            break;
          }
          localObject = paramTroopMemberInfo.friendnick;
          break;
        }
      }
      return localObject;
    }
  }
  
  public String getTroopMemberName(String paramString1, String paramString2)
  {
    return getTroopMemberName(paramString1, paramString2, false, false);
  }
  
  public String getTroopMemberName(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberName uin is null");
      }
      return "";
    }
    Friends localFriends = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "");
    Object localObject1 = (ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "");
    TroopMemberInfo localTroopMemberInfo;
    if (!paramBoolean2)
    {
      localTroopMemberInfo = ((ITroopMemberInfoService)localObject1).getTroopMember(paramString1, paramString2);
      if ((localTroopMemberInfo == null) || (!paramBoolean1) || (TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
        break label271;
      }
      localObject1 = localTroopMemberInfo.troopColorNick;
    }
    for (;;)
    {
      label129:
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (TroopCommonConfig.b(this.app, paramString2))
        {
          localObject2 = localObject1;
          if (localFriends != null)
          {
            localObject2 = localObject1;
            if (localFriends.isFriend())
            {
              localObject2 = localObject1;
              if (localTroopMemberInfo != null) {
                if (TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
                  break label439;
                }
              }
            }
          }
        }
      }
      label271:
      label439:
      for (localObject2 = localTroopMemberInfo.autoremark;; localObject2 = localTroopMemberInfo.friendnick)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramString2;
        }
        if ((localObject1 == null) || (!((String)localObject1).equals(paramString2))) {
          break label449;
        }
        paramString1 = localITroopInfoService.findTroopInfo(paramString1);
        if ((paramString1 == null) || (!paramString1.isQidianPrivateTroop())) {
          break label449;
        }
        return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
        localTroopMemberInfo = ((ITroopMemberInfoService)localObject1).getTroopMemberInLruCache(paramString1, paramString2);
        break;
        if ((localTroopMemberInfo != null) && (!paramBoolean1) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
        {
          localObject1 = localTroopMemberInfo.troopnick;
          break label129;
        }
        if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark)))
        {
          localObject1 = localFriends.remark;
          break label129;
        }
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localObject1 = localFriends.name;
          break label129;
        }
        if (localTroopMemberInfo == null) {
          break label452;
        }
        if (paramString2.equals(this.app.getCurrentAccountUin()))
        {
          localObject1 = ((IFriendNameService)this.app.getRuntimeService(IFriendNameService.class, "")).getFriendName(this.app.getCurrentAccountUin());
          break label129;
        }
        if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark))
        {
          localObject1 = localTroopMemberInfo.autoremark;
          break label129;
        }
        localObject1 = localTroopMemberInfo.friendnick;
        break label129;
      }
      label449:
      return localObject1;
      label452:
      localObject1 = null;
    }
  }
  
  public void getTroopMemberNameAsync(String paramString1, String paramString2, ITroopMemberNameService.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback)
  {
    ThreadManager.post(new TroopMemberNameServiceImpl.1(this, paramString1, paramString2, paramOnGetTroopMemberNameCallback), 5, null, false);
  }
  
  public String getTroopMemberNameInUI(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberName uin is null");
      }
      return "";
    }
    String str = null;
    Friends localFriends = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2);
    TroopMemberInfo localTroopMemberInfo = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInLruCache(paramString1, paramString2);
    if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))) {
      str = localTroopMemberInfo.troopnick;
    }
    while ((str != null) && (str.equals(paramString2)))
    {
      paramString1 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString1);
      if ((paramString1 == null) || (!paramString1.isQidianPrivateTroop())) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
        str = localFriends.remark;
      } else if ((localFriends != null) && (localFriends.isFriend())) {
        str = localFriends.name;
      } else if (localTroopMemberInfo != null) {
        if (paramString2.equals(this.app.getCurrentAccountUin())) {
          str = ((IFriendNameService)this.app.getRuntimeService(IFriendNameService.class, "")).getFriendName(paramString2);
        } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
          str = localTroopMemberInfo.autoremark;
        } else {
          str = localTroopMemberInfo.friendnick;
        }
      }
    }
    return str;
  }
  
  public String getTroopMemberNameRemarkFirst(String paramString1, String paramString2)
  {
    Friends localFriends = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
    if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
      return localFriends.remark;
    }
    return getTroopMemberName(paramString1, paramString2);
  }
  
  public String getTroopMemberNameWithoutRemark(String paramString1, String paramString2)
  {
    return getTroopMemberNameWithoutRemark(paramString1, paramString2, false);
  }
  
  protected String getTroopMemberNameWithoutRemark(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNameWithoutRemark uin is null");
      }
      return "";
    }
    String str = "";
    TroopMemberInfo localTroopMemberInfo = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    Object localObject = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
    if ((localTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopColorNick))) {
      localObject = localTroopMemberInfo.troopColorNick;
    }
    while ((localObject != null) && (((String)localObject).equals(paramString2)))
    {
      paramString1 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
      if ((paramString1 == null) || (!paramString1.isQidianPrivateTroop())) {
        break;
      }
      return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
      if ((localTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
      {
        localObject = localTroopMemberInfo.troopnick;
      }
      else if ((localObject != null) && (((Friends)localObject).isFriend()))
      {
        localObject = ((Friends)localObject).name;
      }
      else
      {
        localObject = str;
        if (localTroopMemberInfo != null)
        {
          localObject = str;
          if (!TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
            localObject = localTroopMemberInfo.friendnick;
          }
        }
      }
    }
    return localObject;
  }
  
  public String getTroopMemberNick(String paramString1, String paramString2)
  {
    if (this.app == null) {
      return "";
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNick uin is null");
      }
      return "";
    }
    paramString1 = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.troopnick))) {
      return paramString1.troopnick;
    }
    return "";
  }
  
  public String getTroopMemberNickByTroopCode(String paramString1, String paramString2)
  {
    paramString2 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).getTroopUinByTroopCode(paramString2);
    if (paramString2 == null) {
      return paramString1;
    }
    return getTroopMemberName(paramString2, paramString1);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberNameServiceImpl
 * JD-Core Version:    0.7.0.1
 */