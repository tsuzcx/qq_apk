package mqq.app;

import PushNotifyPack.RequestPushForceOffline;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class MainService$MyErrorHandler
  implements IErrorHandler
{
  private static final String SEC_TAG = "sec_sig_tag";
  
  private MainService$MyErrorHandler(MainService paramMainService) {}
  
  private void onInterceptKicked(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppRuntime.InterceptKickListener localInterceptKickListener = MainService.access$400(this.this$0);
    if (localInterceptKickListener != null)
    {
      localInterceptKickListener.onInterceptKicked(new AppRuntime.KickParams(paramToServiceMsg, paramFromServiceMsg, paramBoolean2, paramBoolean1));
      return;
    }
    onKickedInternal(paramToServiceMsg, paramFromServiceMsg, paramBoolean2, paramBoolean1);
  }
  
  private void popupNotification(String paramString1, String paramString2, String paramString3, String paramString4, Constants.LogoutReason paramLogoutReason, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
    if ((localAppRuntime != null) && (QLog.isColorLevel())) {
      QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification isSameDevice = " + paramBoolean + "; runnbackGroud = " + localAppRuntime.isBackground_Stop + ";action = " + paramString1 + "; mApplicaiton.getProcessName() = " + MainService.access$000(this.this$0).getQQProcessName());
    }
    localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.3(this, paramString2, localAppRuntime, paramLogoutReason, paramString1, paramString3, paramString4, paramBoolean));
  }
  
  private void popupNotificationEx(String paramString1, String paramString2, String paramString3, String paramString4, Constants.LogoutReason paramLogoutReason, byte[] paramArrayOfByte)
  {
    AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
    if (QLog.isColorLevel()) {
      QLog.d("sec_sig_tag", 2, "popupNotificationEx");
    }
    localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.2(this, paramString2, localAppRuntime, paramLogoutReason, paramString1, paramString3, paramString4, paramArrayOfByte));
  }
  
  public void onGrayError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onGrayError start");
    }
    if ((MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "onGrayError:" + paramFromServiceMsg);
      }
      MainService.access$500(this.this$0, paramToServiceMsg, paramFromServiceMsg);
    }
    MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
    MainService.access$000(this.this$0).setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramToServiceMsg = (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd(), "false");
    new Handler(Looper.getMainLooper()).postDelayed(new MainService.MyErrorHandler.4(this, paramFromServiceMsg, paramToServiceMsg, paramBoolean), 500L);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onGrayError end");
    }
  }
  
  public void onInvalidSign(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = MainService.access$000(this.this$0).waitAppRuntime(null);
    if (localAppRuntime != null) {
      localAppRuntime.runOnUiThread(new MainService.MyErrorHandler.1(this));
    }
  }
  
  public void onKicked(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onKicked start");
    }
    onInterceptKicked(paramToServiceMsg, paramFromServiceMsg, paramBoolean, false);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onKicked end");
    }
  }
  
  public void onKickedAndClearToken(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked ... onKickedAndClearToken start");
    }
    onInterceptKicked(paramToServiceMsg, paramFromServiceMsg, paramBoolean, true);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked ... onKickedAndClearToken end");
    }
  }
  
  void onKickedInternal(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired start");
      }
      MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
      MainService.access$000(this.this$0).setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramToServiceMsg = (RequestMSFForceOffline)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "RequestMSFForceOffline", new RequestMSFForceOffline());
      if (paramToServiceMsg.bSigKick == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick == 1");
        }
        popupNotificationEx("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), paramToServiceMsg.strTitle, paramToServiceMsg.strInfo, Constants.LogoutReason.secKicked, paramToServiceMsg.vecSigKickData);
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired end");
        }
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick != 1");
      }
      popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), paramToServiceMsg.strTitle, paramToServiceMsg.strInfo, Constants.LogoutReason.kicked, paramBoolean2);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start");
      }
      MainService.access$000(this.this$0).setAutoLogin(false);
      paramToServiceMsg = (RequestPushForceOffline)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "req_PushForceOffline", new RequestPushForceOffline());
      if (paramToServiceMsg != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start req != null");
        }
        paramFromServiceMsg = paramFromServiceMsg.getUin();
        String str1 = paramToServiceMsg.strTitle;
        String str2 = paramToServiceMsg.strTips;
        Constants.LogoutReason localLogoutReason = Constants.LogoutReason.forceLogout;
        paramBoolean1 = bool;
        if (paramToServiceMsg.bSameDevice == 1) {
          paramBoolean1 = true;
        }
        popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg, str1, str2, localLogoutReason, paramBoolean1);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired end");
        return;
        popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramFromServiceMsg.getUin(), null, null, Constants.LogoutReason.forceLogout, false);
      }
    }
  }
  
  public void onRecvServerTip(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    String str = paramFromServiceMsg.getBusinessFailMsg();
    String[] arrayOfString = str.split("\\n");
    int i = str.indexOf("\n");
    paramToServiceMsg = str;
    if (i != -1) {
      paramToServiceMsg = str.substring(i + 1);
    }
    popupNotification("mqq.intent.action.ACCOUNT_TIPS", paramFromServiceMsg.getUin(), arrayOfString[0], paramToServiceMsg, Constants.LogoutReason.tips, paramBoolean);
  }
  
  public void onServerSuspended(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onServerSuspended start");
    }
    if (paramToServiceMsg == null) {
      popupNotification("mqq.intent.action.SUSPEND", paramFromServiceMsg.getUin(), null, paramFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.suspend, paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked.....onServerSuspended end");
    }
  }
  
  public void onUserTokenExpired(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked...onUserTokenExpired start");
    }
    MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), false);
    MainService.access$000(this.this$0).setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    popupNotification("mqq.intent.action.ACCOUNT_EXPIRED", paramFromServiceMsg.getUin(), null, paramFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.expired, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "kicked....onUserTokenExpired end ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler
 * JD-Core Version:    0.7.0.1
 */