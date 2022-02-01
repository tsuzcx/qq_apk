package com.tencent.mobileqq.vip;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vip/VipStatusManagerImpl;", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "()V", "managerName", "", "getManagerName", "()Ljava/lang/String;", "getAppRuntime", "Lmqq/app/AppRuntime;", "getPrivilegeFlags", "", "uin", "isBigClub", "", "isSVip", "isSuperQQ", "isVip", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VipStatusManagerImpl
  implements IVipStatusManager
{
  public static final VipStatusManagerImpl.Companion a = new VipStatusManagerImpl.Companion(null);
  @NotNull
  private final String b = "VipStatusManagerImpl";
  
  @Nullable
  public final AppRuntime a()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public int getPrivilegeFlags(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = a();
    int k = 0;
    if (localAppRuntime != null)
    {
      if (paramString == null) {
        paramString = localAppRuntime.getAccount();
      }
      paramString = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).findFriendEntityByUin(localAppRuntime, paramString);
      int i = 2;
      if (paramString != null)
      {
        boolean bool = paramString.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
        if (!paramString.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
          i = 0;
        }
        int j;
        if (paramString.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
          j = 4;
        } else {
          j = 0;
        }
        if (paramString.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
          k = 8;
        }
        return i | bool | false | j | k;
      }
      QLog.e("VipStatusManagerImpl", 2, "getPrivilegeFlags Friends is null");
    }
    return 0;
  }
  
  public boolean isBigClub()
  {
    return (getPrivilegeFlags(null) & 0x8) != 0;
  }
  
  public boolean isSVip()
  {
    return (getPrivilegeFlags(null) & 0x4) != 0;
  }
  
  public boolean isSuperQQ()
  {
    return (getPrivilegeFlags(null) & 0x1) != 0;
  }
  
  public boolean isVip()
  {
    return (getPrivilegeFlags(null) & 0x2) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.VipStatusManagerImpl
 * JD-Core Version:    0.7.0.1
 */