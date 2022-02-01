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
  
  private String getTroopMemberName(TroopMemberInfo paramTroopMemberInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
    if ((paramTroopMemberInfo != null) && (paramBoolean) && (!TextUtils.isEmpty(paramTroopMemberInfo.troopColorNick))) {
      localObject = paramTroopMemberInfo.troopColorNick;
    } else if ((paramTroopMemberInfo != null) && (!paramBoolean) && (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick))) {
      localObject = paramTroopMemberInfo.troopnick;
    } else if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
      localObject = ((Friends)localObject).remark;
    } else if ((localObject != null) && (((Friends)localObject).isFriend())) {
      localObject = ((Friends)localObject).name;
    } else if (paramTroopMemberInfo != null)
    {
      if (paramString2.equals(this.app.getCurrentAccountUin())) {
        localObject = ((IFriendNameService)this.app.getRuntimeService(IFriendNameService.class, "")).getFriendName(this.app.getCurrentAccountUin());
      } else if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
        localObject = paramTroopMemberInfo.autoremark;
      } else {
        localObject = paramTroopMemberInfo.friendnick;
      }
    }
    else {
      localObject = null;
    }
    return getTroopMemberNameSpecial(paramTroopMemberInfo, paramString1, paramString2, (String)localObject);
  }
  
  private String getTroopMemberNameSpecial(TroopMemberInfo paramTroopMemberInfo, String paramString1, String paramString2, String paramString3)
  {
    Friends localFriends = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
    if ((TextUtils.isEmpty(paramString3)) && (TroopCommonConfig.b(this.app, paramString2)) && (localFriends != null) && (localFriends.isFriend()) && (paramTroopMemberInfo != null))
    {
      if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
        paramTroopMemberInfo = paramTroopMemberInfo.autoremark;
      } else {
        paramTroopMemberInfo = paramTroopMemberInfo.friendnick;
      }
    }
    else {
      paramTroopMemberInfo = paramString3;
    }
    paramString3 = paramTroopMemberInfo;
    if (TextUtils.isEmpty(paramTroopMemberInfo)) {
      paramString3 = paramString2;
    }
    paramTroopMemberInfo = paramString3;
    if (paramString3 != null)
    {
      paramTroopMemberInfo = paramString3;
      if (paramString3.equals(paramString2))
      {
        paramString1 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
        paramTroopMemberInfo = paramString3;
        if (paramString1 != null)
        {
          paramTroopMemberInfo = paramString3;
          if (paramString1.isQidianPrivateTroop()) {
            paramTroopMemberInfo = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
          }
        }
      }
    }
    return paramTroopMemberInfo;
  }
  
  public String getTroopMemberColorNick(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.app;
    String str = "";
    if (localAppRuntime == null) {
      return "";
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
      paramString1 = str;
      if (paramString2 != null)
      {
        paramString1 = str;
        if (!TextUtils.isEmpty(paramString2.troopColorNick)) {
          paramString1 = paramString2.troopColorNick;
        }
      }
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNick uin is null");
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
    Object localObject1 = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramTroopMemberInfo.memberuin, true);
    if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject1 = ((Friends)localObject1).remark;
    } else if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
      localObject1 = paramTroopMemberInfo.troopnick;
    } else if ((localObject1 != null) && (((Friends)localObject1).isFriend())) {
      localObject1 = ((Friends)localObject1).name;
    } else if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
      localObject1 = paramTroopMemberInfo.autoremark;
    } else {
      localObject1 = paramTroopMemberInfo.friendnick;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramTroopMemberInfo.memberuin;
    }
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).equals(paramTroopMemberInfo.memberuin))
      {
        paramTroopMemberInfo = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramTroopMemberInfo.troopuin);
        localObject1 = localObject2;
        if (paramTroopMemberInfo != null)
        {
          localObject1 = localObject2;
          if (paramTroopMemberInfo.isQidianPrivateTroop()) {
            localObject1 = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
          }
        }
      }
    }
    return localObject1;
  }
  
  public String getTroopMemberName(String paramString1, String paramString2)
  {
    return getTroopMemberName(paramString1, paramString2, false, false);
  }
  
  public String getTroopMemberName(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = (ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "");
      if (!paramBoolean2) {
        localObject = ((ITroopMemberInfoService)localObject).getTroopMember(paramString1, paramString2);
      } else {
        localObject = ((ITroopMemberInfoService)localObject).getTroopMemberInLruCache(paramString1, paramString2);
      }
      return getTroopMemberName((TroopMemberInfo)localObject, paramString1, paramString2, paramBoolean1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberName uin is null");
    }
    return "";
  }
  
  public void getTroopMemberNameAsync(String paramString1, String paramString2, ITroopMemberNameService.OnGetTroopMemberNameCallback paramOnGetTroopMemberNameCallback)
  {
    ThreadManager.post(new TroopMemberNameServiceImpl.1(this, paramString1, paramString2, paramOnGetTroopMemberNameCallback), 5, null, false);
  }
  
  public String getTroopMemberNameInUI(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = null;
      Friends localFriends = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2);
      Object localObject = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInLruCache(paramString1, paramString2);
      if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick))) {
        str = ((TroopMemberInfo)localObject).troopnick;
      } else if ((localFriends != null) && (localFriends.isFriend()) && (!TextUtils.isEmpty(localFriends.remark))) {
        str = localFriends.remark;
      } else if ((localFriends != null) && (localFriends.isFriend())) {
        str = localFriends.name;
      } else if (localObject != null) {
        if (paramString2.equals(this.app.getCurrentAccountUin())) {
          str = ((IFriendNameService)this.app.getRuntimeService(IFriendNameService.class, "")).getFriendName(paramString2);
        } else if (!TextUtils.isEmpty(((TroopMemberInfo)localObject).autoremark)) {
          str = ((TroopMemberInfo)localObject).autoremark;
        } else {
          str = ((TroopMemberInfo)localObject).friendnick;
        }
      }
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.equals(paramString2))
        {
          paramString1 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfoInUI(paramString1);
          localObject = str;
          if (paramString1 != null)
          {
            localObject = str;
            if (paramString1.isQidianPrivateTroop()) {
              localObject = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            }
          }
        }
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberName uin is null");
    }
    return "";
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject1 = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
      Object localObject2 = ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString2, true);
      if ((localObject1 != null) && (paramBoolean) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopColorNick))) {
        localObject1 = ((TroopMemberInfo)localObject1).troopColorNick;
      } else if ((localObject1 != null) && (!paramBoolean) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick))) {
        localObject1 = ((TroopMemberInfo)localObject1).troopnick;
      } else if ((localObject2 != null) && (((Friends)localObject2).isFriend())) {
        localObject1 = ((Friends)localObject2).name;
      } else if ((localObject1 != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick))) {
        localObject1 = ((TroopMemberInfo)localObject1).friendnick;
      } else {
        localObject1 = "";
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).equals(paramString2))
        {
          paramString1 = ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString1);
          localObject2 = localObject1;
          if (paramString1 != null)
          {
            localObject2 = localObject1;
            if (paramString1.isQidianPrivateTroop()) {
              localObject2 = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            }
          }
        }
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNameWithoutRemark uin is null");
    }
    return "";
  }
  
  public String getTroopMemberNick(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.app;
    String str = "";
    if (localAppRuntime == null) {
      return "";
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = ((ITroopMemberInfoService)this.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(paramString1, paramString2);
      paramString1 = str;
      if (paramString2 != null)
      {
        paramString1 = str;
        if (!TextUtils.isEmpty(paramString2.troopnick)) {
          paramString1 = paramString2.troopnick;
        }
      }
      return paramString1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberNameServiceImpl", 2, "getTroopMemberNick uin is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberNameServiceImpl
 * JD-Core Version:    0.7.0.1
 */