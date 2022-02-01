package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopSysMsgDependApiService
  extends IRuntimeService
{
  public abstract void addSystemMsgSeq(String paramString, long paramLong);
  
  public abstract void clearGroupSuspiciousMsg();
  
  public abstract void clearGroupSystemMsg();
  
  public abstract void clearGroupSystemMsgHistory();
  
  public abstract void followPublicAccountReq(AppRuntime paramAppRuntime, long paramLong, ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver paramITransitTroopProtocolOnFollowObserver, Bundle paramBundle);
  
  public abstract TextView getAnimationTextInstance(Context paramContext);
  
  public abstract void getFriendInfo(String paramString);
  
  public abstract String getSubscriptName(AppRuntime paramAppRuntime, Context paramContext);
  
  public abstract long getSystemMsgSeq(String paramString);
  
  public abstract String getTroopNickName(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle);
  
  public abstract boolean isBrowserAppInterface(AppRuntime paramAppRuntime);
  
  public abstract boolean isQQAppInterface(AppRuntime paramAppRuntime);
  
  public abstract void openNearTroopActivity(Context paramContext, AppRuntime paramAppRuntime);
  
  public abstract void openProfileCardForTroopSysMsg(Context paramContext, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void openTroopMemberCard(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void openTroopProfile(Context paramContext, Bundle paramBundle);
  
  public abstract void refreshConversationList();
  
  public abstract void requestForPubAccountInfo(AppRuntime paramAppRuntime, long paramLong, ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver paramITransitTroopProtocolOnGetInfoObserver);
  
  public abstract void showOnePicture(Activity paramActivity, String paramString);
  
  public abstract Intent startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService
 * JD-Core Version:    0.7.0.1
 */