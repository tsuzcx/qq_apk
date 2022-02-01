package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopCreateInfoServiceImpl
  implements ITroopCreateInfoService
{
  private static final String TAG = "TroopCreateServiceImpl";
  protected TroopCreateInfo createInfo;
  private AppRuntime mAppRuntime;
  
  public void clearTroopCreateInfo()
  {
    TroopCreateInfo localTroopCreateInfo = this.createInfo;
    if (localTroopCreateInfo != null) {
      localTroopCreateInfo.reset();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopCreate", 2, "clearTroopCreateInfo");
    }
  }
  
  public void deleteInInviteList(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      Object localObject1 = this.createInfo;
      if ((localObject1 != null) && (paramString1.equals(((TroopCreateInfo)localObject1).troopUin)) && (this.createInfo.inviteMembers != null))
      {
        Object localObject2 = null;
        Iterator localIterator = this.createInfo.inviteMembers.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (TroopCreateInfo.InviteMemberInfo)localIterator.next();
        } while (!paramString2.equals(((TroopCreateInfo.InviteMemberInfo)localObject1).a));
        if (localObject1 != null)
        {
          this.createInfo.inviteMembers.remove(localObject1);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("deleteInInviteList troopUin:");
            ((StringBuilder)localObject1).append(paramString1);
            ((StringBuilder)localObject1).append("  memberUin:");
            ((StringBuilder)localObject1).append(paramString2);
            QLog.d("TroopCreateServiceImpl", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  public TroopCreateInfo getTroopCreateInfo()
  {
    if (this.createInfo == null) {
      this.createInfo = new TroopCreateInfo();
    }
    return this.createInfo;
  }
  
  public boolean isInInviteList(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      TroopCreateInfo localTroopCreateInfo = this.createInfo;
      if ((localTroopCreateInfo != null) && (paramString1.equals(localTroopCreateInfo.troopUin)) && (this.createInfo.inviteMembers != null))
      {
        paramString1 = this.createInfo.inviteMembers.iterator();
        while (paramString1.hasNext()) {
          if (paramString2.equals(((TroopCreateInfo.InviteMemberInfo)paramString1.next()).a)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    this.createInfo = new TroopCreateInfo();
  }
  
  public void onDestroy()
  {
    clearTroopCreateInfo();
  }
  
  public final void refreshCreateInfo(String paramString, int paramInt)
  {
    this.createInfo.reset();
    this.createInfo.parseFromJsonString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopCreateInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */