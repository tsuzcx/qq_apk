package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.IAppAuthorizationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IBindAppRoleCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppAuthorizationInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetAppRoleListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetClientInfoListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildClientIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISwitchPresenceArchiveCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;

public abstract interface IGProAppService
{
  public abstract void appAuthorization(String paramString, IAppAuthorizationCallback paramIAppAuthorizationCallback);
  
  public abstract void bindAppRole(String paramString1, String paramString2, int paramInt, IBindAppRoleCallback paramIBindAppRoleCallback);
  
  public abstract void getAppAuthorizationInfo(String paramString, int paramInt, IGetAppAuthorizationInfoCallback paramIGetAppAuthorizationInfoCallback);
  
  public abstract void getAppRoleList(String paramString, IGetAppRoleListCallback paramIGetAppRoleListCallback);
  
  public abstract void getClientInfoList(int paramInt, IGetClientInfoListCallback paramIGetClientInfoListCallback);
  
  public abstract IGProClientIdentityInfo getGuildMemberClientIdentity(String paramString1, String paramString2, String paramString3);
  
  public abstract void setGuildClientId(String paramString1, String paramString2, ISetGuildClientIdCallback paramISetGuildClientIdCallback);
  
  public abstract void setMemberClientIdentityForMsg(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo, long paramLong);
  
  public abstract void setShowArchive(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback);
  
  public abstract void setShowPresence(String paramString, boolean paramBoolean, ISwitchPresenceArchiveCallback paramISwitchPresenceArchiveCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProAppService
 * JD-Core Version:    0.7.0.1
 */