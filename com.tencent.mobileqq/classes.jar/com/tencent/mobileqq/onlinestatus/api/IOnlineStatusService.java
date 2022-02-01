package com.tencent.mobileqq.onlinestatus.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.IOnLineStatusPresenter;
import com.tencent.mobileqq.onlinestatus.StatusInfoCallback;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IOnlineStatusService
  extends IRuntimeService
{
  public static final String CMD_RECV_MUSIC_STATUS_PUSH = "ImStatus.ReqPushStatus";
  public static final String CMD_SET_ONLINE_STATUS = "StatSvc.SetStatusFromClient";
  public static final String CMD_SET_PUSH_TOKEN = "PushService.SetToken";
  public static final String PARAMS_VENDOR_PUSH_TYPE = "vendor_push_type";
  
  public abstract void checkBatteryStatus();
  
  public abstract boolean dismissAIOStatusPopupDialog();
  
  public abstract int getBatteryCapacity();
  
  public abstract long getExtOnlineStatus();
  
  public abstract AppRuntime.Status getOnlineStatus();
  
  public abstract int getPowerConnect();
  
  public abstract boolean isAIODialogNotShowing();
  
  public abstract IAccountPanel newAccountPanel(QBaseActivity paramQBaseActivity);
  
  public abstract IAccountPanel newAccountPanel(QBaseActivity paramQBaseActivity, int paramInt);
  
  public abstract IOnLineStatusPresenter newPresenter(QBaseActivity paramQBaseActivity, StatusInfoCallback paramStatusInfoCallback);
  
  public abstract void onAIODialogResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void registerBatteryBroadcastReceiver();
  
  public abstract void registerObserver();
  
  public abstract void requestSetPushToken(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2);
  
  public abstract void sendOnlineStatusWithExt(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2);
  
  public abstract void setBatteryCapacity(int paramInt);
  
  public abstract void setExtOnlineStatus(long paramLong);
  
  public abstract void setOnlineStatus(AppRuntime.Status paramStatus);
  
  public abstract void setPowerConnect(int paramInt);
  
  public abstract void showAIOStatusPopupDialog(BaseSessionInfo paramBaseSessionInfo, Activity paramActivity);
  
  public abstract void unRegisterBatteryBroadcastReceiver();
  
  public abstract void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong);
  
  public abstract void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService
 * JD-Core Version:    0.7.0.1
 */