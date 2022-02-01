package com.tencent.mobileqq.onlinestatus.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BatteryBroadcastReceiver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.onlinestatus.IOnLineStatusPresenter;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter;
import com.tencent.mobileqq.onlinestatus.StatusInfoCallback;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusSPUtil;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class OnlineStatusServiceImpl
  implements IOnlineStatusService
{
  public static final String PREFERENCE_NAME = "acc_info";
  public static final String TAG = "OnlineStatusServiceImpl";
  private int batteryCapacity = 0;
  WeakReference<OnlineStatusAIOPopUpWindow> curDialog = new WeakReference(null);
  private AccountObserver mAccountObserver = new OnlineStatusServiceImpl.1(this);
  private AppRuntime mApp;
  private BatteryBroadcastReceiver mBatteryBroadcastReceiver;
  private AppRuntime.Status onlineStatus = AppRuntime.Status.offline;
  private int powerConnect = -1;
  private long uExtOnlineStatus = -1L;
  
  public void checkBatteryStatus()
  {
    int i = getBatteryCapacity();
    int j = getPowerConnect();
    if ((i == 0) || (j == -1))
    {
      i = OnLineStatusHelper.a();
      j = OnLineStatusHelper.b();
      setBatteryCapacity(i);
      setPowerConnect(j);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusServiceImpl", 2, String.format("checkBatteryStatus, curBattery: %s, powerConnect:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
  }
  
  public boolean dismissAIOStatusPopupDialog()
  {
    OnlineStatusAIOPopUpWindow localOnlineStatusAIOPopUpWindow = (OnlineStatusAIOPopUpWindow)this.curDialog.get();
    if ((localOnlineStatusAIOPopUpWindow != null) && (localOnlineStatusAIOPopUpWindow.isShowing()))
    {
      localOnlineStatusAIOPopUpWindow.dismiss();
      return true;
    }
    return false;
  }
  
  public int getBatteryCapacity()
  {
    return this.batteryCapacity;
  }
  
  public long getExtOnlineStatus()
  {
    return this.uExtOnlineStatus;
  }
  
  public AppRuntime.Status getOnlineStatus()
  {
    return this.onlineStatus;
  }
  
  public int getPowerConnect()
  {
    return this.powerConnect;
  }
  
  public boolean isAIODialogNotShowing()
  {
    Object localObject = this.curDialog;
    if (localObject != null)
    {
      localObject = (PopupWindow)((WeakReference)localObject).get();
      if ((localObject != null) && (((PopupWindow)localObject).isShowing())) {
        return false;
      }
    }
    return true;
  }
  
  public IAccountPanel newAccountPanel(QBaseActivity paramQBaseActivity)
  {
    return new AccountPanel(paramQBaseActivity, 0);
  }
  
  public IAccountPanel newAccountPanel(QBaseActivity paramQBaseActivity, int paramInt)
  {
    return new AccountPanel(paramQBaseActivity, paramInt);
  }
  
  public IOnLineStatusPresenter newPresenter(QBaseActivity paramQBaseActivity, StatusInfoCallback paramStatusInfoCallback)
  {
    return new OnLineStatusPresenter(paramQBaseActivity, paramStatusInfoCallback);
  }
  
  public void onAIODialogResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    OnlineStatusAIOPopUpWindow localOnlineStatusAIOPopUpWindow = (OnlineStatusAIOPopUpWindow)this.curDialog.get();
    if ((localOnlineStatusAIOPopUpWindow != null) && (localOnlineStatusAIOPopUpWindow.isShowing())) {
      localOnlineStatusAIOPopUpWindow.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void registerBatteryBroadcastReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusServiceImpl", 2, "registerBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.mBatteryBroadcastReceiver == null)
      {
        Object localObject = (IOnlineStatusService)this.mApp.getRuntimeService(IOnlineStatusService.class, "");
        if ((((IOnlineStatusService)localObject).getOnlineStatus() == AppRuntime.Status.online) && (((IOnlineStatusService)localObject).getExtOnlineStatus() == 1000L))
        {
          localObject = new IntentFilter();
          ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
          ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
          this.mBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this.mApp);
          MobileQQ.getContext().registerReceiver(this.mBatteryBroadcastReceiver, (IntentFilter)localObject);
          if (QLog.isColorLevel())
          {
            QLog.d("OnlineStatusServiceImpl", 2, "registerBatteryBroadcastReceiver success");
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusServiceImpl", 1, localThrowable, new Object[] { "registerBatteryBroadcastReceiver fail" });
    }
  }
  
  public void registerObserver()
  {
    this.mApp.registObserver(this.mAccountObserver);
  }
  
  public void requestSetPushToken(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    ((OnlineStatusHandler)((AppInterface)paramAppRuntime).getBusinessHandler(OnlineStatusHandler.class.getName())).a(paramString1, paramString2);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    AppRuntime.Status localStatus = getOnlineStatus();
    this.mApp.sendOnlineStatus(paramStatus, localStatus, paramBoolean1, paramLong, paramBoolean2);
    setOnlineStatus(paramStatus);
  }
  
  public void sendOnlineStatusWithExt(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    AppRuntime.Status localStatus = getOnlineStatus();
    this.mApp.sendOnlineStatusWithExt(paramStatus, localStatus, paramBoolean1, paramLong1, paramBoolean2, paramLong2, getBatteryCapacity(), getPowerConnect());
    setOnlineStatus(paramStatus);
    setExtOnlineStatus(paramLong2);
  }
  
  public void setBatteryCapacity(int paramInt)
  {
    this.batteryCapacity = paramInt;
    if (paramInt != 0)
    {
      OnlineStatusSPUtil.a(this.mApp.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusServiceImpl", 2, new Object[] { "setBatteryCapacity, capacity:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void setExtOnlineStatus(long paramLong)
  {
    this.uExtOnlineStatus = paramLong;
    if (paramLong != -1L)
    {
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acc_info");
      localStringBuilder.append(this.mApp.getAccount());
      localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("getOnlineStatusExt", paramLong).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusServiceImpl", 2, String.format("setExtOnlineStatus, status: %s", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void setOnlineStatus(AppRuntime.Status paramStatus)
  {
    this.onlineStatus = paramStatus;
    if ((paramStatus != null) && (paramStatus != AppRuntime.Status.offline) && (paramStatus != AppRuntime.Status.receiveofflinemsg))
    {
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acc_info");
      localStringBuilder.append(this.mApp.getAccount());
      localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("getProfileStatusNew", paramStatus.getValue()).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusServiceImpl", 2, String.format("setOnlineStatus, status: %s", new Object[] { paramStatus }));
    }
  }
  
  public void setPowerConnect(int paramInt)
  {
    this.powerConnect = paramInt;
    if (paramInt != -1)
    {
      OnlineStatusSPUtil.b(this.mApp.getApplicationContext(), paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusServiceImpl", 2, new Object[] { "setPowerConnect, powerConnect: %s", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public void showAIOStatusPopupDialog(BaseSessionInfo paramBaseSessionInfo, Activity paramActivity)
  {
    if (isAIODialogNotShowing())
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager.isActive()) {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
      paramBaseSessionInfo = OnlineStatusAIOPopUpWindow.a((AppInterface)this.mApp, paramActivity, paramBaseSessionInfo, -1, -1);
      paramBaseSessionInfo.setAnimationStyle(2131755424);
      paramBaseSessionInfo.showAtLocation(paramActivity.getWindow().getDecorView(), 80, 0, 0);
      paramBaseSessionInfo.i();
      this.curDialog = new WeakReference(paramBaseSessionInfo);
    }
  }
  
  public void unRegisterBatteryBroadcastReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusServiceImpl", 2, "unRegisterBatteryBroadcastReceiver start");
    }
    try
    {
      if (this.mBatteryBroadcastReceiver != null)
      {
        MobileQQ.getContext().unregisterReceiver(this.mBatteryBroadcastReceiver);
        this.mBatteryBroadcastReceiver = null;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusServiceImpl", 2, "unRegisterBatteryBroadcastReceiver success");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("OnlineStatusServiceImpl", 1, localThrowable, new Object[] { "unRegisterBatteryBroadcastReceiver fail" });
    }
  }
  
  public void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong)
  {
    updateOnlineStatus(paramStatus, paramLong, false);
  }
  
  public void updateOnlineStatus(AppRuntime.Status paramStatus, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.mApp;
    if (!(localObject instanceof AppInterface)) {
      return;
    }
    if ((((AppRuntime)localObject).getAccount() != null) && (this.mApp.isLogin()))
    {
      long l = MobileQQ.sMobileQQ.getSharedPreferences(this.mApp.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
      localObject = (AppInterface)this.mApp;
      ((OnlineStatusHandler)((AppInterface)localObject).getBusinessHandler(OnlineStatusHandler.class.getName())).a((AppRuntime)localObject, paramStatus, paramLong, l, paramBoolean);
    }
    else
    {
      QLog.d("OnlineStatusServiceImpl", 1, String.format("updateOnlineStatus not login!", new Object[0]));
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusServiceImpl", 1, new Object[] { String.format("updateOnlineStatus, status: %s", new Object[] { paramStatus.name() }), " ext:", Long.valueOf(paramLong) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusServiceImpl
 * JD-Core Version:    0.7.0.1
 */