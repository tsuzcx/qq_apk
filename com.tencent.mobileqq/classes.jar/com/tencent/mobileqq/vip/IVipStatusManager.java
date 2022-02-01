package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vip/IVipStatusManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "getPrivilegeFlags", "", "uin", "", "isBigClub", "", "isSVip", "isSuperQQ", "isVip", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVipStatusManager
  extends IVasManager
{
  public abstract int getPrivilegeFlags(@Nullable String paramString);
  
  public abstract boolean isBigClub();
  
  public abstract boolean isSVip();
  
  public abstract boolean isSuperQQ();
  
  public abstract boolean isVip();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.IVipStatusManager
 * JD-Core Version:    0.7.0.1
 */