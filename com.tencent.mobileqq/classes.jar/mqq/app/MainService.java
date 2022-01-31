package mqq.app;

import PushNotifyPack.RequestPushForceOffline;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.widget.Toast;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import mqq.manager.VerifyCodeManager;
import mqq.manager.VerifyDevLockManager;
import mqq.observer.TicketObserver;
import mqq.os.MqqRegulatorCallback;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.IServiceCmdCallback;
import mqq.util.MqqConnRateReport;
import mqq.util.MqqConnRateReport.EventType;

public class MainService
{
  public static final String MSFPROCESSNAMETAG = ":MSF";
  public static final String QQPROCESSNAME = "com.tencent.mobileqq";
  private static final String TAG = MainService.class.getSimpleName();
  public static boolean isDebugVersion = false;
  public static boolean isGrayVersion = false;
  public static final String msfServiceName = "com.tencent.mobileqq.msf.service.MsfService";
  private static IServiceCmdCallback sCmdCallback;
  public static int sNativeTidOfReceiver = -1;
  public static long sPwdPacketTime = 0L;
  public static MqqRegulatorCallback sRegulatorCallback;
  public static final String uinNotMatchTag = "uinNotMatch";
  private static AbstractUnifiedMonitor um;
  private final Runnable MSFReceiver = new Runnable()
  {
    private void handleResp(MsfMessagePair paramAnonymousMsfMessagePair)
    {
      paramAnonymousMsfMessagePair.fromServiceMsg.setAppSeq(paramAnonymousMsfMessagePair.toServiceMsg.getAppSeq());
      MainService.this.msfRespHandleUtil.handleRespMsg(paramAnonymousMsfMessagePair.toServiceMsg, paramAnonymousMsfMessagePair.fromServiceMsg);
    }
    
    public void run()
    {
      com.tencent.qphone.base.util.BaseApplication.gMsfReceiverStarted = 1;
      MainService.sNativeTidOfReceiver = Process.myTid();
      for (;;)
      {
        VerifyDevLockManager localVerifyDevLockManager;
        Object localObject2;
        Object localObject3;
        MsfMessagePair localMsfMessagePair;
        try
        {
          if (MainService.this.recvThreadRegulatoring) {
            MainService.sRegulatorCallback.checkInRegulatorMsg();
          }
          Object localObject1 = null;
          localVerifyDevLockManager = null;
          localObject2 = MainService.this.mApplicaiton.waitAppRuntime(null);
          if (localObject2 != null)
          {
            localObject1 = (VerifyCodeManager)((AppRuntime)localObject2).getManager(6);
            localVerifyDevLockManager = (VerifyDevLockManager)((AppRuntime)localObject2).getManager(7);
          }
          localObject3 = null;
          localMsfMessagePair = MainService.this.msfSub.getServiceRespMsg();
          localObject2 = localObject3;
          if (localMsfMessagePair != null)
          {
            if (localMsfMessagePair.toServiceMsg != null) {
              break label274;
            }
            localObject1 = localMsfMessagePair.fromServiceMsg;
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              if ((((FromServiceMsg)localObject1).getServiceCmd() != null) && (((FromServiceMsg)localObject1).getServiceCmd().equals("SharpSvr.s2c"))) {
                MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eVideoMSFReceiverProcess, ((FromServiceMsg)localObject1).getWupBuffer(), 0);
              }
              localObject2 = localObject1;
              if (!MainService.this.msfRespHandleUtil.handlePushMsg((FromServiceMsg)localObject1))
              {
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.w("mqq", 2, "[MSF Receive] No handler for " + ((FromServiceMsg)localObject1).getServiceCmd());
                  localObject2 = localObject1;
                }
              }
            }
          }
          if ((localObject2 != null) || (localMsfMessagePair != null)) {
            break label356;
          }
          MainService.this.msfSub.queueWait();
          continue;
          continue;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("mqq", 2, "[MSF Receive]" + localException.toString());
          }
          localException.printStackTrace();
        }
        label274:
        if ((localException != null) && (localVerifyDevLockManager != null))
        {
          localObject2 = localObject3;
          if (localException.checkVerifyCodeResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
          {
            localObject2 = localObject3;
            if (localVerifyDevLockManager.checkVerifyDevLockSmsResp(localMsfMessagePair.toServiceMsg, localMsfMessagePair.fromServiceMsg))
            {
              handleResp(localMsfMessagePair);
              localObject2 = localObject3;
            }
          }
        }
        else
        {
          handleResp(localMsfMessagePair);
          localObject2 = localObject3;
          continue;
          label356:
          if (MainService.sPwdPacketTime != 0L)
          {
            long l = System.currentTimeMillis() - MainService.sPwdPacketTime;
            if ((l < 40000L) && (l > 0L) && (MainService.this.msfSub.getQueueSize() > 0))
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "[MSF Receive] UI_BUSY");
              }
              Thread.sleep(120L);
            }
          }
        }
      }
    }
  };
  private IAuthHandler authHandler = new IAuthHandler()
  {
    public void onDelLoginedAccountResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetKeyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetSidResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.attributes.put("sid", paramAnonymousString2);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetUinSignResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, byte[] paramAnonymousArrayOfByte)
    {
      paramAnonymousFromServiceMsg.attributes.put(paramAnonymousFromServiceMsg.getServiceCmd(), paramAnonymousArrayOfByte);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onReceVerifyCode(VerifyCodeInfo paramAnonymousVerifyCodeInfo, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.addAttribute("VerifyCodeInfo", paramAnonymousVerifyCodeInfo);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvChangeTokenResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, RespondCustomSig paramAnonymousRespondCustomSig, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      if (paramAnonymousRespondCustomSig != null)
      {
        paramAnonymousString = paramAnonymousRespondCustomSig.SigList.iterator();
        while (paramAnonymousString.hasNext())
        {
          paramAnonymousRespondCustomSig = (CustomSigContent)paramAnonymousString.next();
          if (paramAnonymousRespondCustomSig.ulSigType == 14L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = HexUtil.bytes2HexStr(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("vkey", paramAnonymousRespondCustomSig);
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 8L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = HexUtil.bytes2HexStr(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("STwxWeb", paramAnonymousRespondCustomSig);
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 13L)
          {
            if (paramAnonymousRespondCustomSig.sResult == 0)
            {
              paramAnonymousRespondCustomSig = paramAnonymousFromServiceMsg.getAttribute(paramAnonymousFromServiceMsg.getServiceCmd());
              if ((paramAnonymousRespondCustomSig != null) && ((paramAnonymousRespondCustomSig instanceof ArrayList)))
              {
                paramAnonymousRespondCustomSig = (ArrayList)paramAnonymousRespondCustomSig;
                paramAnonymousFromServiceMsg.attributes.put("arrD3", paramAnonymousRespondCustomSig);
              }
            }
          }
          else if (paramAnonymousRespondCustomSig.ulSigType == 19L)
          {
            if ((paramAnonymousRespondCustomSig.sResult == 0) && (paramAnonymousRespondCustomSig.SigContent != null))
            {
              paramAnonymousRespondCustomSig = new String(paramAnonymousRespondCustomSig.SigContent);
              paramAnonymousFromServiceMsg.attributes.put("skey", paramAnonymousRespondCustomSig);
            }
            else
            {
              try
              {
                paramAnonymousRespondCustomSig = new String(paramAnonymousRespondCustomSig.SigContent, "utf-8");
                paramAnonymousFromServiceMsg.attributes.put("skeyError", paramAnonymousRespondCustomSig);
              }
              catch (UnsupportedEncodingException paramAnonymousRespondCustomSig)
              {
                paramAnonymousRespondCustomSig.printStackTrace();
              }
            }
          }
          else if ((paramAnonymousRespondCustomSig.ulSigType == 21L) && (paramAnonymousRespondCustomSig.sResult == 0))
          {
            paramAnonymousRespondCustomSig = paramAnonymousRespondCustomSig.SigContent;
            paramAnonymousFromServiceMsg.attributes.put("superkey", paramAnonymousRespondCustomSig);
          }
        }
      }
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvChangeUinLoginResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      paramAnonymousString = (String)paramAnonymousToServiceMsg.getAttribute("from_where");
      paramAnonymousInt1 = 1;
      if (("subaccount".equals(paramAnonymousString)) || ("ssoAccountAction".equals(paramAnonymousString))) {
        paramAnonymousInt1 = 0;
      }
      if ((paramAnonymousFromServiceMsg.isSuccess()) && (paramAnonymousInt1 != 0))
      {
        paramAnonymousString = SimpleAccount.parseSimpleAccount((String)paramAnonymousFromServiceMsg.getAttribute("resp_simpleAccount"));
        MainService.this.mApplicaiton.createNewRuntime(paramAnonymousString, true, true, 4, null);
      }
    }
    
    public void onRecvChangeUinResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvLoginResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      paramAnonymousString = (String)paramAnonymousToServiceMsg.getAttribute("from_where");
      paramAnonymousInt1 = 1;
      if (("subaccount".equals(paramAnonymousString)) || ("ssoAccountAction".equals(paramAnonymousString))) {
        paramAnonymousInt1 = 0;
      }
      if ((paramAnonymousFromServiceMsg.isSuccess()) && (paramAnonymousInt1 != 0))
      {
        paramAnonymousString = SimpleAccount.parseSimpleAccount((String)paramAnonymousFromServiceMsg.getAttribute("resp_simpleAccount"));
        MainService.this.mApplicaiton.createNewRuntime(paramAnonymousString, true, true, 3, null);
      }
    }
    
    public void onRefreSidResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      paramAnonymousFromServiceMsg.attributes.put("sid", paramAnonymousString);
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  public int cbExceedCount;
  public int cbIncreaseCount;
  public long cbIncreaseTime;
  public long cbLastUpdateSPTime;
  private IErrorHandler errorHandler = new IErrorHandler()
  {
    private static final String SEC_TAG = "sec_sig_tag";
    
    private void onKicked(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      boolean bool = false;
      if (paramAnonymousBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked:isTokenExpired start");
        }
        MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
        MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        paramAnonymousToServiceMsg = (RequestMSFForceOffline)Packet.decodePacket(paramAnonymousFromServiceMsg.getWupBuffer(), "RequestMSFForceOffline", new RequestMSFForceOffline());
        if (paramAnonymousToServiceMsg.bSigKick == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked:result.bSigKick == 1");
          }
          popupNotificationEx("mqq.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), paramAnonymousToServiceMsg.strTitle, paramAnonymousToServiceMsg.strInfo, Constants.LogoutReason.secKicked, paramAnonymousToServiceMsg.vecSigKickData);
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
        popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), paramAnonymousToServiceMsg.strTitle, paramAnonymousToServiceMsg.strInfo, Constants.LogoutReason.kicked, paramAnonymousBoolean2);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start");
        }
        MainService.this.mApplicaiton.setAutoLogin(false);
        paramAnonymousToServiceMsg = (RequestPushForceOffline)Packet.decodePacket(paramAnonymousFromServiceMsg.getWupBuffer(), "req_PushForceOffline", new RequestPushForceOffline());
        if (paramAnonymousToServiceMsg != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired start req != null");
          }
          paramAnonymousFromServiceMsg = paramAnonymousFromServiceMsg.getUin();
          String str1 = paramAnonymousToServiceMsg.strTitle;
          String str2 = paramAnonymousToServiceMsg.strTips;
          Constants.LogoutReason localLogoutReason = Constants.LogoutReason.forceLogout;
          paramAnonymousBoolean1 = bool;
          if (paramAnonymousToServiceMsg.bSameDevice == 1) {
            paramAnonymousBoolean1 = true;
          }
          popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg, str1, str2, localLogoutReason, paramAnonymousBoolean1);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("sec_sig_tag", 2, "kicked.....onKicked: not isTokenExpired end");
          return;
          popupNotification("mqq.intent.action.ACCOUNT_KICKED", paramAnonymousFromServiceMsg.getUin(), null, null, Constants.LogoutReason.forceLogout, false);
        }
      }
    }
    
    private void popupNotification(final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4, final Constants.LogoutReason paramAnonymousLogoutReason, final boolean paramAnonymousBoolean)
    {
      final AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if ((localAppRuntime != null) && (QLog.isColorLevel())) {
        QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification isSameDevice = " + paramAnonymousBoolean + "; runnbackGroud = " + localAppRuntime.isBackground_Stop + ";action = " + paramAnonymousString1 + "; mApplicaiton.getProcessName() = " + MainService.this.mApplicaiton.getProcessName());
      }
      localAppRuntime.runOnUiThread(new Runnable()
      {
        public void run()
        {
          boolean bool;
          Intent localIntent;
          if ((paramAnonymousString2 != null) && (paramAnonymousString2.equals(localAppRuntime.getAccount())))
          {
            bool = true;
            if (paramAnonymousLogoutReason != Constants.LogoutReason.expired) {
              break label387;
            }
            if (!localAppRuntime.isLogin()) {
              bool = false;
            }
            if ((paramAnonymousLogoutReason != Constants.LogoutReason.tips) && (localAppRuntime.isLogin()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
              }
              localAppRuntime.logout(paramAnonymousLogoutReason, true);
            }
            if ((bool) && (MainService.this.mApplicaiton != null) && (MainService.this.mApplicaiton.getProcessName().equalsIgnoreCase(MainService.this.mApplicaiton.getPackageName())))
            {
              localIntent = new Intent(paramAnonymousString1);
              localIntent.putExtra("title", paramAnonymousString3);
              localIntent.putExtra("msg", paramAnonymousString4);
              localIntent.putExtra("reason", paramAnonymousLogoutReason);
              localIntent.putExtra("isSameDevice", paramAnonymousBoolean);
              localIntent.addFlags(268435456);
              if ((!localAppRuntime.isClearTaskBySystem) && ((!paramAnonymousBoolean) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equalsIgnoreCase("mqq.intent.action.ACCOUNT_KICKED")) || (!localAppRuntime.isBackground_Stop))) {
                break label392;
              }
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked samedevice and set kickIntent ");
              }
              localAppRuntime.setKickIntent(localIntent);
            }
          }
          for (;;)
          {
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("title", paramAnonymousString3);
            localIntent.putExtra("msg", paramAnonymousString4);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("isSameDevice", paramAnonymousBoolean);
            MainService.this.mApplicaiton.sendBroadcast(localIntent);
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification end isNeedNotify = " + bool);
            }
            return;
            label387:
            bool = true;
            break;
            try
            {
              label392:
              MainService.this.mApplicaiton.startActivity(localIntent);
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kicked start notification......");
              }
            }
            catch (ActivityNotFoundException localActivityNotFoundException)
            {
              localAppRuntime.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(MainService.this.mApplicaiton, "[mqq]" + MainService.3.3.this.val$reason + "\n" + MainService.3.3.this.val$title + "\n" + MainService.3.3.this.val$msg, 0).show();
                }
              });
            }
          }
        }
      });
    }
    
    private void popupNotificationEx(final String paramAnonymousString1, final String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4, final Constants.LogoutReason paramAnonymousLogoutReason, final byte[] paramAnonymousArrayOfByte)
    {
      final AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "popupNotificationEx");
      }
      localAppRuntime.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Intent localIntent;
          if (paramAnonymousString2.equals(localAppRuntime.getAccount()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification start");
            }
            if ((paramAnonymousLogoutReason != Constants.LogoutReason.tips) && (localAppRuntime.isLogin()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
              }
              localAppRuntime.logout(paramAnonymousLogoutReason, true);
            }
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("title", paramAnonymousString3);
            localIntent.putExtra("msg", paramAnonymousString4);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            localIntent.putExtra("data", paramAnonymousArrayOfByte);
            localIntent.addFlags(268435456);
          }
          try
          {
            MainService.this.mApplicaiton.startActivity(localIntent);
            localIntent = new Intent(paramAnonymousString1);
            localIntent.putExtra("reason", paramAnonymousLogoutReason);
            MainService.this.mApplicaiton.sendBroadcast(localIntent);
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            for (;;)
            {
              localAppRuntime.runOnUiThread(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(MainService.this.mApplicaiton, "[mqq]" + MainService.3.2.this.val$reason + "\n" + MainService.3.2.this.val$title + "\n" + MainService.3.2.this.val$msg, 0).show();
                }
              });
            }
          }
        }
      });
    }
    
    public void onGrayError(final ToServiceMsg paramAnonymousToServiceMsg, final FromServiceMsg paramAnonymousFromServiceMsg, final boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError start");
      }
      if ((MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramAnonymousFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramAnonymousFromServiceMsg.getMsfCommand())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "onGrayError:" + paramAnonymousFromServiceMsg);
        }
        MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
      }
      MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramAnonymousToServiceMsg = (String)paramAnonymousFromServiceMsg.getAttribute(paramAnonymousFromServiceMsg.getServiceCmd(), "false");
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
      {
        public void run()
        {
          MainService.3.this.popupNotification("mqq.intent.action.GRAY", paramAnonymousFromServiceMsg.getUin(), paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.gray, paramAnonymousBoolean);
        }
      }, 500L);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onGrayError end");
      }
    }
    
    public void onInvalidSign(boolean paramAnonymousBoolean)
    {
      AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
      if (localAppRuntime != null) {
        localAppRuntime.runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast.makeText(MainService.this.mApplicaiton, "Appid is invalid!", 0).show();
          }
        });
      }
    }
    
    public void onKicked(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked start");
      }
      onKicked(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg, false, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onKicked end");
      }
    }
    
    public void onKickedAndClearToken(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken start");
      }
      onKicked(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg, true, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked ... onKickedAndClearToken end");
      }
    }
    
    public void onRecvServerTip(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      String str = paramAnonymousFromServiceMsg.getBusinessFailMsg();
      String[] arrayOfString = str.split("\\n");
      paramAnonymousToServiceMsg = str;
      int i = str.indexOf("\n");
      if (i != -1) {
        paramAnonymousToServiceMsg = str.substring(i + 1);
      }
      popupNotification("mqq.intent.action.ACCOUNT_TIPS", paramAnonymousFromServiceMsg.getUin(), arrayOfString[0], paramAnonymousToServiceMsg, Constants.LogoutReason.tips, paramAnonymousBoolean);
    }
    
    public void onServerSuspended(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended start");
      }
      if (paramAnonymousToServiceMsg == null) {
        popupNotification("mqq.intent.action.SUSPEND", paramAnonymousFromServiceMsg.getUin(), null, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.suspend, paramAnonymousBoolean);
      }
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked.....onServerSuspended end");
      }
    }
    
    public void onUserTokenExpired(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg, boolean paramAnonymousBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked...onUserTokenExpired start");
      }
      MsfSdkUtils.updateSimpleAccount(paramAnonymousFromServiceMsg.getUin(), false);
      MainService.this.mApplicaiton.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      popupNotification("mqq.intent.action.ACCOUNT_EXPIRED", paramAnonymousFromServiceMsg.getUin(), null, paramAnonymousFromServiceMsg.getBusinessFailMsg(), Constants.LogoutReason.expired, paramAnonymousBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "kicked....onUserTokenExpired end ");
      }
    }
  };
  private MobileQQ mApplicaiton;
  private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
  private IMsfMsgHandler msfMsgHandler = new IMsfMsgHandler()
  {
    public void onRecvResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private Thread msfRecvThread;
  private final MsfRespHandleUtil msfRespHandleUtil;
  public final MsfServiceSdk msfSub;
  INotifyHandler notifyHandler = new INotifyHandler()
  {
    public void onRecvNotify(long paramAnonymousLong, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterNotifyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
    
    public void onUnRegisterNotifyResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
  };
  private IPushHandler pushHandler = new IPushHandler()
  {
    public void onOverloadPushNotify(final String paramAnonymousString)
    {
      QLog.d("mqq", 1, "overload push notify, msg: " + paramAnonymousString);
      if (MainService.this.mApplicaiton != null)
      {
        AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
        if (localAppRuntime != null) {
          localAppRuntime.runOnUiThread(new Runnable()
          {
            public void run()
            {
              try
              {
                Intent localIntent = new Intent("mqq.intent.action.OVERLOAD_PUSH");
                localIntent.putExtra("msg", paramAnonymousString);
                localIntent.addFlags(268435456);
                MainService.this.mApplicaiton.startActivity(localIntent);
                return;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
                QLog.d("mqq", 1, "overload push notify fail, except: " + localException.getMessage());
              }
            }
          });
        }
      }
      else
      {
        return;
      }
      QLog.d("mqq", 1, "overload push notify fail, app is null");
    }
    
    public void onProxyIpChanged(String paramAnonymousString)
    {
      QLog.d("mqq", 1, "proxy ip changed, uin: " + MsfSdkUtils.getShortUin(paramAnonymousString));
      if (MainService.this.mApplicaiton != null)
      {
        AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
        if (localAppRuntime != null) {
          ((ProxyIpManager)localAppRuntime.getManager(3)).reloadCache(paramAnonymousString, false);
        }
      }
    }
    
    public void onRecvCmdPush(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCmdPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onResetCmdPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg) {}
    
    public void onTicketChanged(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      if (paramAnonymousFromServiceMsg != null) {
        QLog.d("mqq", 1, "ticket changed by uin: " + MsfSdkUtils.getShortUin(paramAnonymousFromServiceMsg.getUin()));
      }
      if (MainService.this.mApplicaiton != null)
      {
        AppRuntime localAppRuntime = MainService.this.mApplicaiton.waitAppRuntime(null);
        if (localAppRuntime != null)
        {
          ((TicketManager)localAppRuntime.getManager(2)).reloadCache(MainService.this.mApplicaiton);
          if (paramAnonymousFromServiceMsg != null)
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("uin", paramAnonymousFromServiceMsg.getUin());
            localAppRuntime.notifyObservers(TicketObserver.class, 0, true, localBundle);
          }
        }
      }
    }
    
    public void onUnRegisterPushResp(ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private boolean recvThreadRegulatoring;
  private IRegisterUinHandler registerUinHandler = new IRegisterUinHandler()
  {
    public void onCheckQuickRegisterResp(int paramAnonymousInt, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onGetQuickRegisterResp(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegQueryAccountResp(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitMobileResp(int paramAnonymousInt, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitPassResp(int paramAnonymousInt, String paramAnonymousString, byte[] paramAnonymousArrayOfByte, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterCommitSmsCodeResp(int paramAnonymousInt, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterQuerySmsStatResp(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
    
    public void onRegisterSendResendSmsreqResp(int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt2, int paramAnonymousInt3, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private int reportThreshold = -1;
  private IServerInfoHandler serverInfoHandler = new IServerInfoHandler()
  {
    public void onReportResp(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, ToServiceMsg paramAnonymousToServiceMsg, FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(paramAnonymousToServiceMsg, paramAnonymousFromServiceMsg);
    }
  };
  private IServerMsgPushHandler serverMsgPushHandler = new IServerMsgPushHandler()
  {
    public void onConnClose(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onConnOpened(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onOpenConnAllFailed(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onReceFirstResp(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
    
    public void onRecvServerConfigPush(FromServiceMsg paramAnonymousFromServiceMsg)
    {
      MainService.this.receiveMessageFromMSF(null, paramAnonymousFromServiceMsg);
    }
  };
  private int umNotReported;
  
  MainService(MobileQQ paramMobileQQ, int paramInt, String paramString, boolean paramBoolean)
  {
    this.mApplicaiton = paramMobileQQ;
    this.msfSub = MsfServiceSdk.get();
    this.msfSub.init(paramMobileQQ, paramInt, paramString, "com.tencent.mobileqq.msf.service.MsfService", this.errorHandler, MobileQQ.processName);
    this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[] { this.msfMsgHandler, this.pushHandler, this.notifyHandler, this.authHandler, this.registerUinHandler, this.serverMsgPushHandler, this.serverInfoHandler });
    if (paramBoolean) {
      start();
    }
  }
  
  private void receiveMessageFromMSF(ToServiceMsg paramToServiceMsg, final FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    String str1 = null;
    String str2 = null;
    int i = 0;
    Object localObject3 = this.mApplicaiton.waitAppRuntime(null);
    Object localObject1 = localObject3;
    if (paramToServiceMsg != null) {
      localObject1 = ((AppRuntime)localObject3).getAppRuntime(paramToServiceMsg.extraData.getString("moduleId"));
    }
    final long l;
    if (paramToServiceMsg != null)
    {
      localObject2 = (Class)this.mRequestServlets.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
      l = paramToServiceMsg.extraData.getLong("sendTime");
      l = System.currentTimeMillis() - l;
      if (paramFromServiceMsg.isSuccess())
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localObject1.getClass().getSimpleName() + "@" + localObject1.hashCode() + "  cost=" + l + "ms.");
        }
        if (sCmdCallback != null) {
          sCmdCallback.onCmdResponse(paramFromServiceMsg.getServiceCmd());
        }
        recordKeyTimestamp(paramToServiceMsg, paramFromServiceMsg);
        str1 = (String)paramToServiceMsg.getAttribute("from_where");
        str2 = (String)paramToServiceMsg.getAttribute("mainaccount");
        label241:
        int j = 0;
        if ("0".equals(paramFromServiceMsg.getUin()))
        {
          paramFromServiceMsg.setUin(((AppRuntime)localObject1).getAccount());
          j = 1;
        }
        localObject3 = paramFromServiceMsg.getUin();
        if ((str1 != null) && (str1.length() > 0)) {
          paramFromServiceMsg.addAttribute("from_where", str1);
        }
        if ((str2 != null) && (str2.length() > 0)) {
          paramFromServiceMsg.addAttribute("mainaccount", str2);
        }
        if ((j != 0) || (((String)localObject3).equals(((AppRuntime)localObject1).getAccount())) || ("login.auth".equals(paramFromServiceMsg.getServiceCmd())) || ("wtlogin.login".equals(paramFromServiceMsg.getServiceCmd())) || (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_name2uin.equals(paramFromServiceMsg.getMsfCommand())) || ("login.chguin".equals(paramFromServiceMsg.getServiceCmd())) || ((str1 != null) && (str1.equals("subaccount"))) || ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("uinNotMatch"))))
        {
          if ((this.reportThreshold == -1) && (um != null))
          {
            if (!um.whetherReportDuringThisStartup(7)) {
              break label1077;
            }
            this.reportThreshold = um.getThreshold(7);
            um.setMonitoredThread(7, Thread.currentThread(), null);
          }
          label499:
          if ((um != null) && (um.whetherStackEnabled(7))) {
            um.reportStackIfTimeout(7);
          }
          l = SystemClock.uptimeMillis();
          ((AppRuntime)localObject1).getServletContainer().notifyMSFServlet((Class)localObject2, paramFromServiceMsg);
          if (i != 0) {
            try
            {
              paramToServiceMsg = ((AppRuntime)localObject1).subRuntimeMap.values().iterator();
              while (paramToServiceMsg.hasNext()) {
                ((AppRuntime)paramToServiceMsg.next()).getServletContainer().notifyMSFServlet((Class)localObject2, paramFromServiceMsg);
              }
              l = SystemClock.uptimeMillis() - l;
            }
            catch (Exception paramToServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "", paramToServiceMsg);
              }
            }
          }
          if (this.reportThreshold > 0)
          {
            if (l <= this.reportThreshold) {
              break label1086;
            }
            if (um.whetherReportThisTime(7)) {
              um.addEvent(7, paramFromServiceMsg.getServiceCmd(), (int)l, this.umNotReported, null);
            }
          }
        }
      }
    }
    for (this.umNotReported = 0;; this.umNotReported += 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "[MSF End][notifyMSFServlet]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq() + ",cost=" + l + "ms.");
      }
      if (l >= 2000L)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("cmd", paramFromServiceMsg.getServiceCmd());
        localObject2 = new RdmReq();
        ((RdmReq)localObject2).eventName = "longTimeCallback";
        ((RdmReq)localObject2).elapse = l;
        ((RdmReq)localObject2).size = 0L;
        ((RdmReq)localObject2).isSucceed = true;
        ((RdmReq)localObject2).isRealTime = false;
        ((RdmReq)localObject2).params = paramToServiceMsg;
        paramToServiceMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject2);
        paramToServiceMsg.setNeedCallback(false);
        paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
        this.msfSub.sendMsg(paramToServiceMsg);
      }
      reportMSFCallBackCost(l, false);
      if ((isDebugVersion) && (l >= 5000L) && (localObject1 != null)) {
        ((AppRuntime)localObject1).runOnUiThread(new Runnable()
        {
          public void run()
          {
            Toast.makeText(MainService.this.mApplicaiton, "Caution! running too long. cmd=" + paramFromServiceMsg.getServiceCmd() + " time=" + l + "ms.", 1).show();
          }
        });
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localObject1.getClass().getSimpleName() + "@" + localObject1.hashCode() + "  code=" + paramFromServiceMsg.getResultCode() + ",cost=" + l + "ms.");
      break;
      if ((this.mApplicaiton.getProcessName().endsWith(":video")) || (QLog.isColorLevel())) {
        QLog.d("mqq", 1, "[MSF Push]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq());
      }
      i = 1;
      break label241;
      label1077:
      this.reportThreshold = -2;
      break label499;
      label1086:
      if (um.whetherStackEnabled(7)) {
        um.notifyNotTimeout(7);
      }
    }
  }
  
  private void recordKeyTimestamp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("sendTime", 0L);
    long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf", Long.valueOf(0L))).longValue();
    long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", Long.valueOf(0L))).longValue();
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", Long.valueOf(0L))).longValue();
    long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2app", Long.valueOf(0L))).longValue();
    long l6 = System.currentTimeMillis();
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atAppSite", l1);
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atMsfSite", l2);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2net_atMsfSite", l3);
    paramFromServiceMsg.extraData.putLong("timestamp_net2msf_atMsfSite", l4);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atMsfSite", l5);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atAppSite", l6);
  }
  
  public static void setServiceCmdCallback(IServiceCmdCallback paramIServiceCmdCallback)
  {
    sCmdCallback = paramIServiceCmdCallback;
  }
  
  public static void setUnifiedMonitorInstance(AbstractUnifiedMonitor paramAbstractUnifiedMonitor)
  {
    um = paramAbstractUnifiedMonitor;
  }
  
  public void clearServlets()
  {
    this.mRequestServlets.clear();
  }
  
  public void onRecvVerifyManagerCallback(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    this.msfRespHandleUtil.handleRespMsg(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void reportMSFCallBackCost(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.cbIncreaseTime += paramLong;
      this.cbIncreaseCount += 1;
      if (paramLong >= 2000L) {
        this.cbExceedCount += 1;
      }
    }
    paramLong = SystemClock.elapsedRealtime();
    long l1;
    Object localObject1;
    long l4;
    long l3;
    int k;
    int m;
    long l2;
    int j;
    int i;
    if (this.cbLastUpdateSPTime > 0L)
    {
      if (paramLong - this.cbLastUpdateSPTime > 600000L) {
        paramBoolean = true;
      }
      if ((paramBoolean) && (this.cbIncreaseTime > 0L))
      {
        l1 = System.currentTimeMillis();
        localObject1 = this.mApplicaiton.getSharedPreferences("msf_cb_report", 0);
        l4 = ((SharedPreferences)localObject1).getLong("cbLastReportTime", l1);
        l3 = ((SharedPreferences)localObject1).getLong("cbTotalTime", 0L) + this.cbIncreaseTime;
        k = ((SharedPreferences)localObject1).getInt("cbTotalCount", 0) + this.cbIncreaseCount;
        m = ((SharedPreferences)localObject1).getInt("cbExceedCount", 0) + this.cbExceedCount;
        if (l1 - l4 < 86400000L) {
          break label498;
        }
        paramLong = 0L;
        if (k > 0) {
          paramLong = l3 / k;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "reportMSFCallBackCost-->cbTotalTime:" + l3 + " ,cbTotalCount:" + k + " ,cbAverageTime:" + paramLong);
        }
        Object localObject2 = new RdmReq();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cbAverageTime", String.valueOf(paramLong));
        localHashMap.put("cbTotalCount", String.valueOf(k));
        localHashMap.put("cbExceedCount", String.valueOf(m));
        ((RdmReq)localObject2).eventName = "MSFCallBackAvgCost";
        ((RdmReq)localObject2).elapse = paramLong;
        ((RdmReq)localObject2).size = 0L;
        ((RdmReq)localObject2).isSucceed = true;
        ((RdmReq)localObject2).isRealTime = false;
        ((RdmReq)localObject2).params = localHashMap;
        localObject2 = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject2);
        ((ToServiceMsg)localObject2).extraData.putLong("sendTime", System.currentTimeMillis());
        this.msfSub.sendMsg((ToServiceMsg)localObject2);
        l2 = 0L;
        j = 0;
        i = 0;
        paramLong = l1;
      }
    }
    for (;;)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("cbLastReportTime", paramLong);
      ((SharedPreferences.Editor)localObject1).putLong("cbTotalTime", l2);
      ((SharedPreferences.Editor)localObject1).putInt("cbTotalCount", j);
      ((SharedPreferences.Editor)localObject1).putInt("cbExceedCount", i);
      ((SharedPreferences.Editor)localObject1).commit();
      this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
      this.cbIncreaseTime = 0L;
      this.cbIncreaseCount = 0;
      this.cbExceedCount = 0;
      return;
      this.cbLastUpdateSPTime = paramLong;
      break;
      label498:
      paramLong = l4;
      j = k;
      i = m;
      l2 = l3;
      if (l4 > l1)
      {
        paramLong = l1;
        j = k;
        i = m;
        l2 = l3;
      }
    }
  }
  
  void sendMessageToMSF(ToServiceMsg paramToServiceMsg, MSFServlet paramMSFServlet)
  {
    if (paramToServiceMsg.getServiceName() == null) {
      paramToServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
    }
    this.mRequestServlets.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramMSFServlet.getClass());
    paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
    paramToServiceMsg.extraData.putString("moduleId", paramMSFServlet.getAppRuntime().getModuleId());
    this.msfSub.sendMsg(paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "[MSF Send]" + paramToServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + paramMSFServlet.getAppRuntime().getClass().getSimpleName() + "@" + paramMSFServlet.getAppRuntime().hashCode() + "  from " + paramMSFServlet.getClass().getSimpleName());
    }
    if (sCmdCallback != null) {
      sCmdCallback.onCmdRequest(paramToServiceMsg.getServiceCmd());
    }
  }
  
  public void start()
  {
    if (this.msfRecvThread == null)
    {
      this.msfRecvThread = new Thread(this.MSFReceiver, "MSF-Receiver");
      QLog.d(TAG, 1, "start MSF-Receiver " + this.msfRecvThread.getId());
      if ((this.mApplicaiton == null) || (this.mApplicaiton.getProcessName() == null) || (!this.mApplicaiton.getProcessName().endsWith(":video"))) {
        break label130;
      }
      this.msfRecvThread.setPriority(10);
    }
    for (;;)
    {
      this.msfRecvThread.start();
      if (sRegulatorCallback != null) {
        this.recvThreadRegulatoring = sRegulatorCallback.regulatorThread(this.msfRecvThread);
      }
      return;
      label130:
      this.msfRecvThread.setPriority(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService
 * JD-Core Version:    0.7.0.1
 */