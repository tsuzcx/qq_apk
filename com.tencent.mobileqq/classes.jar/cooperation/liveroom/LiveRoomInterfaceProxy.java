package cooperation.liveroom;

import android.content.Intent;
import android.os.Bundle;
import atmq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.SubAccountObserver;

public class LiveRoomInterfaceProxy
  extends AppInterface
{
  private LiveRoomInterface mRuntime;
  
  public LiveRoomInterfaceProxy(BaseApplicationImpl paramBaseApplicationImpl, String paramString, LiveRoomInterface paramLiveRoomInterface)
  {
    super(paramBaseApplicationImpl, paramString);
    this.mRuntime = paramLiveRoomInterface;
    this.mRuntime.mAppInterface = this;
  }
  
  public static LiveRoomInterfaceProxy create()
  {
    LiveRoomInterface localLiveRoomInterface = (LiveRoomInterface)waitAppRuntime();
    if (localLiveRoomInterface != null) {
      return new LiveRoomInterfaceProxy(BaseApplicationImpl.getApplication(), "liveroom", localLiveRoomInterface);
    }
    QLog.e("LiveRoomInterfaceProxy", 1, "waitAppRuntime return null");
    return null;
  }
  
  private static AppRuntime waitAppRuntime()
  {
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if (localAppRuntime == null) {
      return null;
    }
    return localAppRuntime.getAppRuntime("LiveRoomPlugin.apk");
  }
  
  public String getAccount()
  {
    return this.mRuntime.getAccount();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public MobileQQ getApplication()
  {
    return this.mRuntime.getApplication();
  }
  
  public String getCurrentAccountUin()
  {
    return this.mRuntime.getAccount();
  }
  
  public Intent getDevLockIntent()
  {
    return this.mRuntime.getDevLockIntent();
  }
  
  public atmq getEntityManagerFactory(String paramString)
  {
    return this.mRuntime.getQQEntityManagerFactory();
  }
  
  public Intent getKickIntent()
  {
    return this.mRuntime.getKickIntent();
  }
  
  public long getLongAccountUin()
  {
    return this.mRuntime.getLongAccountUin();
  }
  
  public Manager getManager(int paramInt)
  {
    return this.mRuntime.getManager(paramInt);
  }
  
  public AppRuntime.Status getOnlineStatus()
  {
    try
    {
      AppRuntime.Status localStatus = this.mRuntime.getOnlineStatus();
      return localStatus;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void getSubAccountKey(String paramString1, String paramString2, SubAccountObserver paramSubAccountObserver)
  {
    this.mRuntime.getSubAccountKey(paramString1, paramString2, paramSubAccountObserver);
  }
  
  public byte[] getUinSign()
  {
    return this.mRuntime.getUinSign();
  }
  
  public boolean isLogin()
  {
    return this.mRuntime.isLogin();
  }
  
  public boolean isRunning()
  {
    return this.mRuntime.isRunning();
  }
  
  public void login(SimpleAccount paramSimpleAccount)
  {
    this.mRuntime.login(paramSimpleAccount);
  }
  
  public void login(String paramString, byte[] paramArrayOfByte, AccountObserver paramAccountObserver)
  {
    this.mRuntime.login(paramString, paramArrayOfByte, paramAccountObserver);
  }
  
  public void loginSubAccount(String paramString1, String paramString2, String paramString3, SubAccountObserver paramSubAccountObserver)
  {
    this.mRuntime.loginSubAccount(paramString1, paramString2, paramString3, paramSubAccountObserver);
  }
  
  public void logout(boolean paramBoolean)
  {
    this.mRuntime.logout(paramBoolean);
  }
  
  public void notifyObservers(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.mRuntime.notifyObservers(paramClass, paramInt, paramBoolean, paramBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mRuntime.onCreate(paramBundle);
  }
  
  public void onGuardEvent(int paramInt, long paramLong1, long paramLong2)
  {
    this.mRuntime.onGuardEvent(paramInt, paramLong1, paramLong2);
  }
  
  public void onProxyIpChanged()
  {
    this.mRuntime.onProxyIpChanged();
  }
  
  public void openMsfPCActive(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mRuntime.openMsfPCActive(paramString1, paramString2, paramBoolean);
  }
  
  public void registObserver(BusinessObserver paramBusinessObserver)
  {
    this.mRuntime.registObserver(paramBusinessObserver);
  }
  
  public void reportNetworkException(int paramInt)
  {
    this.mRuntime.reportNetworkException(paramInt);
  }
  
  public void sendAppDataIncermentMsg(String paramString, String[] paramArrayOfString, long paramLong)
  {
    this.mRuntime.sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    this.mRuntime.sendOnlineStatus(paramStatus, paramBoolean1, paramLong, paramBoolean2);
  }
  
  public void sendWirelessMeibaoReq(int paramInt)
  {
    this.mRuntime.sendWirelessMeibaoReq(paramInt);
  }
  
  public void sendWirelessPswReq(int paramInt)
  {
    this.mRuntime.sendWirelessPswReq(paramInt);
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    this.mRuntime.setAutoLogin(paramBoolean);
  }
  
  public void setCmdCallbacker()
  {
    this.mRuntime.setCmdCallbacker();
  }
  
  public void setDevLockIntent(Intent paramIntent)
  {
    this.mRuntime.setDevLockIntent(paramIntent);
  }
  
  public void setKickIntent(Intent paramIntent)
  {
    this.mRuntime.setKickIntent(paramIntent);
  }
  
  public void ssoGetA1WithA1(String paramString, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SSOAccountObserver paramSSOAccountObserver)
  {
    this.mRuntime.ssoGetA1WithA1(paramString, paramArrayOfByte1, paramLong1, paramLong2, paramLong3, paramArrayOfByte2, paramArrayOfByte3, paramSSOAccountObserver);
  }
  
  public void ssoGetTicketNoPasswd(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    this.mRuntime.ssoGetTicketNoPasswd(paramString, paramInt, paramSSOAccountObserver);
  }
  
  public void ssoLogin(String paramString1, String paramString2, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    this.mRuntime.ssoLogin(paramString1, paramString2, paramInt, paramSSOAccountObserver);
  }
  
  public void start(boolean paramBoolean)
  {
    this.mRuntime.start(paramBoolean);
  }
  
  public void startPCActivePolling(String paramString1, String paramString2)
  {
    this.mRuntime.startPCActivePolling(paramString1, paramString2);
  }
  
  public void startServlet(NewIntent paramNewIntent)
  {
    AppRuntime localAppRuntime = getApplication().waitAppRuntime(null);
    if (localAppRuntime != null) {
      localAppRuntime.startServlet(paramNewIntent);
    }
  }
  
  public void stopPCActivePolling(String paramString)
  {
    this.mRuntime.stopPCActivePolling(paramString);
  }
  
  public void switchAccount(SimpleAccount paramSimpleAccount, String paramString)
  {
    this.mRuntime.switchAccount(paramSimpleAccount, paramString);
  }
  
  public void unRegistObserver(BusinessObserver paramBusinessObserver)
  {
    this.mRuntime.unRegistObserver(paramBusinessObserver);
  }
  
  public void updateSubAccountLogin(String paramString, boolean paramBoolean)
  {
    this.mRuntime.updateSubAccountLogin(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomInterfaceProxy
 * JD-Core Version:    0.7.0.1
 */