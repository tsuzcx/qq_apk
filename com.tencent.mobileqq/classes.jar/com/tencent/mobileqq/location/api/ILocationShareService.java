package com.tencent.mobileqq.location.api;

import android.app.Activity;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.callback.IShareLocationCallback;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ILocationShareService
  extends IRuntimeService
{
  public abstract void addErrorShareStateCallback(IShareLocationCallback paramIShareLocationCallback);
  
  public abstract void addLocationUpdateListener(OnUpdateUserLocationListener paramOnUpdateUserLocationListener);
  
  public abstract boolean isCurrentUserSharing();
  
  public abstract boolean isSessionSharingLocation(int paramInt, String paramString);
  
  public abstract void launchShareUi(Activity paramActivity, int paramInt1, String paramString, int paramInt2);
  
  public abstract void notifyStateError(int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void notifyStateNormalClose(int paramInt, long paramLong);
  
  public abstract void notifyUserSwitchPhone(int paramInt, long paramLong);
  
  public abstract void processC2CPush(byte[] paramArrayOfByte);
  
  public abstract void processTroopPush(TroopLbsSharePushInfo paramTroopLbsSharePushInfo);
  
  public abstract void removeErrorShareStateCallback(IShareLocationCallback paramIShareLocationCallback);
  
  public abstract void removeLocationUpdateListener(OnUpdateUserLocationListener paramOnUpdateUserLocationListener);
  
  public abstract void requestOperateRoom(int paramInt1, int paramInt2, String paramString);
  
  public abstract void requestQueryRoom(int paramInt, String paramString);
  
  public abstract void stopLocationSharing(int paramInt, String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.ILocationShareService
 * JD-Core Version:    0.7.0.1
 */