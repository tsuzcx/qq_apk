package mqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import mqq.observer.TicketObserver;

class MainService$4
  implements IPushHandler
{
  MainService$4(MainService paramMainService) {}
  
  public void onOverloadPushNotify(String paramString)
  {
    QLog.d("mqq", 1, "overload push notify, msg: " + paramString);
    if (MainService.access$000(this.this$0) != null)
    {
      AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localAppRuntime != null) {
        localAppRuntime.runOnUiThread(new MainService.4.1(this, paramString));
      }
    }
    else
    {
      return;
    }
    QLog.d("mqq", 1, "overload push notify fail, app is null");
  }
  
  public void onProxyIpChanged(String paramString)
  {
    QLog.d("mqq", 1, "proxy ip changed, uin: " + MsfSdkUtils.getShortUin(paramString));
    if (MainService.access$000(this.this$0) != null)
    {
      AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localAppRuntime != null) {
        ((ProxyIpManager)localAppRuntime.getManager(3)).reloadCache(paramString, false);
      }
    }
  }
  
  public void onRecvCmdPush(FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, null, paramFromServiceMsg);
  }
  
  public void onRegisterCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onResetCmdPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void onTicketChanged(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QLog.d("mqq", 1, "ticket changed by uin: " + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
    }
    if (MainService.access$000(this.this$0) != null)
    {
      AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
      if (localAppRuntime != null)
      {
        ((TicketManager)localAppRuntime.getManager(2)).reloadCache(MainService.access$000(this.this$0));
        if (paramFromServiceMsg != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("uin", paramFromServiceMsg.getUin());
          localAppRuntime.notifyObservers(TicketObserver.class, 0, true, localBundle);
        }
      }
    }
  }
  
  public void onUnRegisterPushResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService.4
 * JD-Core Version:    0.7.0.1
 */