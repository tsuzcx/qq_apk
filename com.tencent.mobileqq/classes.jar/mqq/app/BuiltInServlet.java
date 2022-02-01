package mqq.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import mqq.observer.CheckConErroObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.ServerConfigObserver;
import mqq.observer.SubAccountObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.ErrMsg;
import protocol.KQQConfig.GetResourceRespV2;

public class BuiltInServlet
  extends MSFServlet
  implements Constants.Action
{
  private boolean isRegist;
  
  private void addOpenSdkExtra(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    if (!"com.tencent.mobileqq:openSdk".equals(paramIntent.getStringExtra("process"))) {}
    for (;;)
    {
      return;
      paramIntent = paramIntent.getBundleExtra("extra");
      if (paramIntent != null)
      {
        Iterator localIterator = paramIntent.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramToServiceMsg.addAttribute(str, paramIntent.get(str));
          QLog.d("BuiltInServlet", 1, "BuiltInServlet --> key=" + str + ", value=" + paramIntent.get(str));
        }
      }
    }
  }
  
  private void bundlePutErrorUrl(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if ((paramFromServiceMsg == null) || (paramBundle == null)) {
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.getAttribute("resp_login_url");
    if ((paramFromServiceMsg instanceof String)) {}
    for (paramFromServiceMsg = (String)paramFromServiceMsg;; paramFromServiceMsg = "")
    {
      paramBundle.putString("errorUrl", paramFromServiceMsg);
      return;
    }
  }
  
  private void bundlePutTlv543(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if ((paramFromServiceMsg == null) || (paramBundle == null)) {}
    do
    {
      do
      {
        do
        {
          WUserSigInfo localWUserSigInfo1;
          do
          {
            return;
            WUserSigInfo localWUserSigInfo2 = (WUserSigInfo)paramFromServiceMsg.getAttribute("userSigInfo");
            localWUserSigInfo1 = localWUserSigInfo2;
            if (localWUserSigInfo2 != null) {
              break;
            }
            localWUserSigInfo1 = (WUserSigInfo)paramFromServiceMsg.getAttribute("sigInfo");
          } while (localWUserSigInfo1 == null);
          paramFromServiceMsg = localWUserSigInfo1.loginResultTLVMap;
        } while (paramFromServiceMsg == null);
        paramFromServiceMsg = (tlv_t)paramFromServiceMsg.get(Integer.valueOf(1347));
      } while (paramFromServiceMsg == null);
      paramFromServiceMsg = paramFromServiceMsg.get_data();
    } while (paramFromServiceMsg == null);
    paramBundle.putByteArray("tlverror", paramFromServiceMsg);
  }
  
  private boolean dispatchOnReceiveForRegister(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1041: 
      onReceiveForActionRegistNewAccountQueryMobile(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1003: 
      onReceiveForActionRegistNewAccountCommitMobile(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1020: 
      onReceiveForActionRegistNewAccountRefetchSM(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1004: 
      onReceiveForActionRegistNewAccountCommitSMS(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1022: 
      onReceiveForActionQuerySMSState(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1005: 
      onReceiveForActionRegistNewAccountSendPassword(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    case 1008: 
      onReceiveForActionCheckQuickRegistAccount(paramIntent, paramFromServiceMsg, paramInt);
      return true;
    }
    onReceiveForActionGetQuickRegistAccount(paramIntent, paramFromServiceMsg, paramInt);
    return true;
  }
  
  private void dispatchService(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1007: 
      serviceForActionDeleteAccount(paramIntent);
      return;
    case 1030: 
      serviceForActionGetKey(paramIntent);
      return;
    case 2203: 
      serviceForActionSendWTPKG(paramIntent);
      return;
    case 1032: 
      serviceForActionChangeToken(paramIntent);
      return;
    case 1012: 
      serviceForActionReport(paramIntent);
      return;
    case 1018: 
      serviceForActionGetPluginConfig(paramIntent);
      return;
    case 1042: 
      serviceForActionNetExceptionEvent(paramIntent);
      return;
    case 1043: 
      serviceForActionSendWirelessPSWReq(paramIntent);
      return;
    case 1044: 
      serviceForActionSendWirelessMeiBaoReq(paramIntent);
      return;
    case 2124: 
      serviceForActionGetAlterTickets(paramIntent);
      return;
    case 2200: 
      serviceForActionAppGuard(paramIntent);
      return;
    case 2126: 
      serviceForActionStartPCActivePolling(paramIntent);
      return;
    case 2127: 
      serviceForActionStopPCActivePolling(paramIntent);
      return;
    case 2128: 
      serviceForActionOpenPCActive(paramIntent);
      return;
    case 2202: 
      serviceForActionSendMSGSignal(paramIntent);
      return;
    case 1046: 
      serviceForActionRefreshDA2(paramIntent);
      return;
    case 2204: 
      serviceForActionSaveGEOGInfo(paramIntent);
      return;
    case 2210: 
      serviceForActionManualSetLogLevel(paramIntent);
      return;
    case 2212: 
      serviceForActionActionMSFUpdateLocaleID(paramIntent);
      return;
    }
    serviceForActionUpdateMSFConfig(paramIntent);
  }
  
  private boolean dispatchServiceForLogin(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1001: 
      serviceForActionLogin(paramIntent);
      return true;
    case 2201: 
      serviceForActionTransFileCheckMSFConerro(paramIntent);
      return true;
    case 1035: 
      serviceForActionSubAccountLogin(paramIntent);
      return true;
    case 2123: 
      serviceForActionNotifyRefreshWebviewTicket(paramIntent);
      return true;
    case 1100: 
      serviceForActionSSOLoginAccount(paramIntent);
      return true;
    case 2205: 
      serviceForActionVeriftyPasswd(paramIntent);
      return true;
    case 2206: 
      serviceForActionVerifyPasswdSubmitImageCode(paramIntent);
      return true;
    case 2207: 
      serviceForActionVerifyPassWDRefreshImageCode(paramIntent);
      return true;
    case 1101: 
      serviceForActionGetTicketNoPasswd(paramIntent);
      return true;
    case 1102: 
      serviceForActionSSOGetA1WithA1(paramIntent);
      return true;
    case 1037: 
      serviceForActionSubAccountGetKey(paramIntent);
      return true;
    case 1040: 
      serviceForActionRegistCommandPush(paramIntent);
      return true;
    case 1002: 
      serviceForActionRegistMessagePush(paramIntent);
      return true;
    case 1025: 
      serviceForActionRegistMessagePushProxy(paramIntent);
      return true;
    case 1026: 
      serviceForActionUnregistMessagePushProxy(paramIntent);
      return true;
    case 1041: 
      serviceForActionRegistNewAccountQueryMobile(paramIntent);
      return true;
    case 1003: 
      serviceForActionRegistNewAccountCommitMobile(paramIntent);
      return true;
    case 1020: 
      serviceForActionRegistNewAccountRefetchSMS(paramIntent);
      return true;
    case 1004: 
      serviceForActionRegistNewAccountCommitSMS(paramIntent);
      return true;
    case 1022: 
      serviceForActionQuerySMSState(paramIntent);
      return true;
    case 1005: 
      serviceForActionRegistNewAccountSendPassword(paramIntent);
      return true;
    case 1008: 
      serviceForActionCheckQuickRegistAccont(paramIntent);
      return true;
    }
    serviceForActionGetQuickRegistAccount(paramIntent);
    return true;
  }
  
  static boolean isQQUin(String paramString)
  {
    boolean bool2 = false;
    try
    {
      long l = Long.parseLong(paramString);
      boolean bool1 = bool2;
      if (l > 9999L)
      {
        bool1 = bool2;
        if (l < 4000000000L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void onReceiveForActionChangeToken(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("map", paramFromServiceMsg.attributes);
    notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionCheckQuickRegistAccount(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onReceiveForActionGetAlterTickets(FromServiceMsg paramFromServiceMsg)
  {
    new Bundle();
    String str = paramFromServiceMsg.getUin();
    paramFromServiceMsg = (HashMap)paramFromServiceMsg.getAttributes().get("keyMap");
    if ((!TextUtils.isEmpty(str)) && (getAppRuntime() != null) && (str.equals(getAppRuntime().getAccount()))) {
      ((TicketManager)getAppRuntime().getManager(2)).setAlterTicket(paramFromServiceMsg);
    }
  }
  
  private void onReceiveForActionGetKey(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("key", (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
    notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionGetPluginConfig(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramFromServiceMsg.getWupBuffer());
      localBundle.putSerializable("jce", (GetResourceRespV2)localUniPacket.getByClass("GetResourceRespV2", new GetResourceRespV2()));
    }
    localBundle.putInt("iPluginType", paramIntent.getIntExtra("iPluginType", 64));
    notifyObserver(paramIntent, 1018, paramFromServiceMsg.isSuccess(), localBundle, ServerConfigObserver.class);
  }
  
  private void onReceiveForActionGetQuickRegistAccount(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      int i = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
      String str1 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
      String str2 = (String)paramFromServiceMsg.getAttribute("to_register_cr_mobile", "");
      localBundle.putInt("code", i);
      localBundle.putString("uin", str1);
      localBundle.putString("phone", str2);
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onReceiveForActionGetTicketNoPasswd(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (QLog.isColorLevel()) {
      QLog.d("onReceive", 2, "builtInServlet action_sso_login_no_passwd...");
    }
    localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
      localBundle.putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
      localBundle.putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
      localBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
      localBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
    }
    localBundle.putInt("code", paramFromServiceMsg.getResultCode());
    localBundle.putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
    Object localObject = paramFromServiceMsg.getAttribute("ret");
    if ((localObject instanceof Integer)) {
      localBundle.putInt("ret", ((Integer)localObject).intValue());
    }
    for (;;)
    {
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1101, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
      return;
      localBundle.putInt("ret", -1);
    }
  }
  
  private void onReceiveForActionLogin(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (QLog.isColorLevel()) {
      QLog.d("BuiltInServlet", 2, "login in back from msf build servlets start");
    }
    getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    localBundle.putString("uin", paramFromServiceMsg.getUin());
    localBundle.putString("alias", paramIntent.getStringExtra("account"));
    localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
    Object localObject1 = paramFromServiceMsg.getAttribute("resp_login_url");
    String str = "";
    if ((localObject1 instanceof String)) {
      str = (String)localObject1;
    }
    localObject1 = paramFromServiceMsg.getAttribute("resp_logini_ret");
    if ((localObject1 instanceof Integer)) {}
    for (int i = ((Integer)localObject1).intValue();; i = 0)
    {
      Object localObject2 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
      localObject1 = null;
      if ((localObject2 instanceof byte[])) {
        localObject1 = (byte[])localObject2;
      }
      try
      {
        localObject2 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
        if (localObject2 != null)
        {
          localBundle.putInt("errorver", ((ErrMsg)localObject2).getVersion());
          localBundle.putString("title", ((ErrMsg)localObject2).getTitle());
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("mqq", 1, "getAttribute error:" + localException2.getMessage());
          continue;
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), str);
          continue;
          MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
          try
          {
            bundlePutTlv543(paramFromServiceMsg, localBundle);
          }
          catch (Exception localException1)
          {
            QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + localException1.getMessage());
          }
        }
      }
      localBundle.putString("errorurl", str);
      localBundle.putInt("loginret", i);
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putByteArray("lhsig", (byte[])localObject1);
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        str = paramIntent.getStringExtra("account");
        if (!TextUtils.isEmpty(str))
        {
          if (paramIntent.getByteArrayExtra("to_login_uin_encrypt") != null) {
            getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), paramFromServiceMsg.getUin());
          }
        }
        else
        {
          getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          notifyObserver(paramIntent, 1001, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          if (QLog.isColorLevel()) {
            QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
          }
          return;
        }
      }
    }
  }
  
  private void onReceiveForActionQuerySMSState(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      int i = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
      int j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
      int k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
      String str1 = (String)paramFromServiceMsg.getAttribute("res_register_errmsg", "");
      String str2 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
      String str3 = (String)paramFromServiceMsg.getAttribute("resp_register_nick", "");
      String str4 = (String)paramFromServiceMsg.getAttribute("resp_register_picture_url", "");
      localBundle.putInt("code", i);
      localBundle.putInt("next_chk_time", j);
      localBundle.putInt("total_time_over", k);
      localBundle.putString("errmsg", str1);
      localBundle.putString("uin", str2);
      localBundle.putString("nick", str3);
      localBundle.putString("faceUrl", str4);
      str1 = (String)paramFromServiceMsg.getAttribute("resp_phone_protect_uins_url");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("phone_protect_uins_url", str1);
      }
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onReceiveForActionRefreshDA2(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    String str = paramFromServiceMsg.getUin();
    byte[] arrayOfByte = (byte[])paramFromServiceMsg.getAttributes().get("da2");
    localBundle.putString("account", str);
    localBundle.putString("da2", new String(arrayOfByte));
    notifyObserver(paramIntent, 1046, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionRegistCommandPush(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    notifyObserver(paramIntent, 1040, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionRegistMessagePush(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    long l1;
    SvcRespRegister localSvcRespRegister;
    boolean bool2;
    boolean bool3;
    label141:
    int i;
    AppRuntime.Status localStatus;
    long l2;
    label252:
    boolean bool1;
    if (("push.register".equals(paramFromServiceMsg.getServiceCmd())) || ("push.unRegister".equals(paramFromServiceMsg.getServiceCmd())))
    {
      getAppRuntime().getOnlineStatus();
      l1 = 0L;
      if (!paramFromServiceMsg.isSuccess()) {
        break label717;
      }
      if (!"push.register".equals(paramFromServiceMsg.getServiceCmd())) {
        break label691;
      }
      if ((paramFromServiceMsg.getWupBuffer() == null) || (paramFromServiceMsg.getWupBuffer().length <= 0)) {
        break label631;
      }
      localSvcRespRegister = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
      if ((localSvcRespRegister == null) || (localSvcRespRegister.cReplyCode != 0)) {
        break label539;
      }
      if (localSvcRespRegister.bUpdateFlag != 1) {
        break label504;
      }
      bool2 = true;
      if (localSvcRespRegister.bLargeSeqUpdate != 1) {
        break label510;
      }
      bool3 = true;
      i = localSvcRespRegister.iStatus;
      l1 = localSvcRespRegister.timeStamp;
      localStatus = AppRuntime.Status.build(i);
      l2 = localSvcRespRegister.uExtOnlineStatus;
      if (localStatus != null) {
        break label766;
      }
      QLog.d("mqq", 1, String.format("invalid iStatus: %s", new Object[] { Integer.valueOf(i) }));
      if (!paramFromServiceMsg.attributes.containsKey("attr_online_status")) {
        break label516;
      }
      i = ((Integer)paramFromServiceMsg.getAttribute("attr_online_status")).intValue();
      paramFromServiceMsg = AppRuntime.Status.build(i);
      QLog.d("mqq", 1, String.format("update iStatus: %s", new Object[] { Integer.valueOf(i) }));
      if (paramFromServiceMsg != null) {
        break label760;
      }
      paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
      QLog.e("mqq", 1, "register.push onlineStatus == null");
      bool1 = true;
    }
    for (;;)
    {
      boolean bool4 = bool3;
      bool3 = bool2;
      bool2 = bool4;
      for (;;)
      {
        bool4 = paramIntent.getBooleanExtra("isUserSet", false);
        getAppRuntime().getOnlineStatus();
        getAppRuntime().getExtOnlineStatus();
        getAppRuntime().setOnlineStatus(paramFromServiceMsg);
        if (l2 != -1L) {
          getAppRuntime().setExtOnlineStatus(l2);
        }
        localBundle.putSerializable("onlineStatus", paramFromServiceMsg);
        localBundle.putLong("extOnlineStatus", l2);
        localBundle.putBoolean("isChanged", bool3);
        localBundle.putLong("timeStamp", l1);
        localBundle.putBoolean("isLargeChanged", bool2);
        localBundle.putBoolean("isUserSet", bool4);
        notifyObserver(paramIntent, 1002, bool1, localBundle, AccountObserver.class);
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, String.format("register.push, isSuc = %s, onlineStatus = %s, isUserSet = %s, isChanged = %s, timeStamp = %s, isLargeChanged = %s, iStatus = %s, extStatus = %s", new Object[] { Boolean.valueOf(bool1), paramFromServiceMsg, Boolean.valueOf(bool4), Boolean.valueOf(bool3), Long.valueOf(l1), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(l2) }));
        }
        return;
        label504:
        bool2 = false;
        break;
        label510:
        bool3 = false;
        break label141;
        label516:
        QLog.d("mqq", 1, String.format("don't containsKey attr_online_status", new Object[0]));
        paramFromServiceMsg = localStatus;
        break label252;
        label539:
        paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
        if (localSvcRespRegister != null)
        {
          i = localSvcRespRegister.cReplyCode;
          label561:
          if (localSvcRespRegister != null) {
            break label625;
          }
        }
        label625:
        for (bool1 = true;; bool1 = false)
        {
          QLog.d("mqq", 1, String.format("register.push resp is null [%s], cReplyCode: [%s]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i) }));
          i = 0;
          bool3 = false;
          bool1 = false;
          bool2 = false;
          l2 = -1L;
          break;
          i = -1;
          break label561;
        }
        label631:
        paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
        QLog.d("mqq", 1, "register.push return empty packet! status: " + paramFromServiceMsg);
        l2 = -1L;
        bool3 = false;
        l1 = 0L;
        i = 0;
        bool2 = false;
        bool1 = true;
        continue;
        label691:
        paramFromServiceMsg = AppRuntime.Status.offline;
        l2 = -1L;
        bool3 = false;
        l1 = 0L;
        i = 0;
        bool2 = false;
        bool1 = true;
        continue;
        label717:
        paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
        QLog.d("mqq", 1, "register.push fail!");
        l2 = -1L;
        bool3 = false;
        l1 = 0L;
        i = 0;
        bool2 = false;
        bool1 = false;
      }
      label760:
      bool1 = true;
      continue;
      label766:
      bool1 = true;
      paramFromServiceMsg = localStatus;
    }
  }
  
  private void onReceiveForActionRegistNewAccountCommitMobile(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      int i;
      try
      {
        i = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        byte[] arrayOfByte = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
        localBundle.putInt("code", i);
        localBundle.putByteArray("mobile", arrayOfByte);
        if (paramIntent.hasExtra("inviteCode")) {
          localBundle.putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
        }
        notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        continue;
      }
      if (paramFromServiceMsg.getBusinessFailCode() == 3001)
      {
        Object localObject = paramFromServiceMsg.getBusinessFailMsg();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            i = Integer.valueOf((String)localObject).intValue();
            localObject = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
            localBundle.putInt("code", i);
            localBundle.putByteArray("mobile", (byte[])localObject);
            if (paramIntent.hasExtra("inviteCode")) {
              localBundle.putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
  
  private void onReceiveForActionRegistNewAccountCommitSMS(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
      String str = (String)paramFromServiceMsg.getAttribute("bind_qq_uin");
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("bind_qq_uin", str);
      }
      str = (String)paramFromServiceMsg.getAttribute("resp_verify_account_nick");
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("bind_qq_nick", str);
      }
      str = (String)paramFromServiceMsg.getAttribute("resp_verify_account_faceUrl");
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("bind_qq_face_url", str);
      }
      str = (String)paramFromServiceMsg.getAttribute("resp_phone_protect_uins_url");
      if (!TextUtils.isEmpty(str)) {
        localBundle.putString("phone_protect_uins_url", str);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionRegistNewAccountQueryMobile(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount callback");
      }
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onReceiveForActionRegistNewAccountRefetchSM(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    try
    {
      int i = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
      int j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
      int k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
      localBundle.putInt("code", i);
      localBundle.putInt("next_chk_time", j);
      localBundle.putInt("total_time_over", k);
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void onReceiveForActionRegistNewAccountSendPassword(Intent paramIntent, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        int i = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
        byte[] arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("resp_register_contactssig", new byte[0]);
        String str = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
        byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
        byte[] arrayOfByte3 = (byte[])paramFromServiceMsg.getAttribute("resp_register_supersig", null);
        if ((arrayOfByte2 != null) && (arrayOfByte2.length > 0))
        {
          localBundle.putByteArray("lhsig", arrayOfByte2);
          if (QLog.isColorLevel()) {
            QLog.d("wtLogin_LiangHao", 2, "builtInServlet|LiangHao_lhsig= " + new String(arrayOfByte2));
          }
        }
        localBundle.putByteArray("resp_register_supersig", arrayOfByte3);
        localBundle.putInt("code", i);
        localBundle.putByteArray("promptInfo", arrayOfByte1);
        localBundle.putString("uin", str);
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive code= " + i + ",uin=" + str);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
        localBundle.putBoolean("reg_Lianghao", true);
      }
      notifyObserver(paramIntent, paramInt, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive failed = " + paramFromServiceMsg.getBusinessFailCode());
      }
    }
  }
  
  private void onReceiveForActionSSOGetA1WithA1(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = paramFromServiceMsg.getAttribute("dwSrcAppid");
      if ((localObject instanceof Long)) {
        localBundle.putLong("dwSrcAppid", ((Long)localObject).longValue());
      }
      localObject = paramFromServiceMsg.getAttribute("dwMainSigMap");
      if ((localObject instanceof Integer)) {
        localBundle.putInt("dwMainSigMap", ((Integer)localObject).intValue());
      }
      localObject = paramFromServiceMsg.getAttribute("dwSubSrcAppid");
      if ((localObject instanceof Long)) {
        localBundle.putLong("dwSubSrcAppid", ((Long)localObject).longValue());
      }
      localBundle.putByteArray("dstAppName", (byte[])paramFromServiceMsg.getAttribute("dstAppName"));
      localObject = paramFromServiceMsg.getAttribute("dwDstSsoVer");
      if ((localObject instanceof Long)) {
        localBundle.putLong("dwDstSsoVer", ((Long)localObject).longValue());
      }
      localObject = paramFromServiceMsg.getAttribute("dwDstAppid");
      if ((localObject instanceof Long)) {
        localBundle.putLong("dwDstAppid", ((Long)localObject).longValue());
      }
      localObject = paramFromServiceMsg.getAttribute("dwSubDstAppid");
      if ((localObject instanceof Long)) {
        localBundle.putLong("dwSubDstAppid", ((Long)localObject).longValue());
      }
      localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
      localBundle.putParcelable("fastLoginInfo", (Parcelable)paramFromServiceMsg.getAttribute("fastLoginInfo"));
      localBundle.putByteArray("dstAppVer", (byte[])paramFromServiceMsg.getAttribute("dstAppVer"));
      localBundle.putByteArray("dstAppSign", (byte[])paramFromServiceMsg.getAttribute("dstAppSign"));
      localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
    }
    localBundle.putInt("code", paramFromServiceMsg.getResultCode());
    localBundle.putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
    Object localObject = paramFromServiceMsg.getAttribute("ret");
    if ((localObject instanceof Integer)) {
      localBundle.putInt("ret", ((Integer)localObject).intValue());
    }
    for (;;)
    {
      notifyObserver(paramIntent, 1102, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
      return;
      localBundle.putInt("ret", -1);
    }
  }
  
  private void onReceiveForActionSSOLoginAccount(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (QLog.isColorLevel()) {
      QLog.d("onReceive", 2, "builtInServlet action_sso_login_account...");
    }
    localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
    localBundle.putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
    if (paramFromServiceMsg.isSuccess())
    {
      localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      localBundle.putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
      localBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
      localBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
    }
    Object localObject = paramFromServiceMsg.getAttribute("ret");
    if ((localObject instanceof Integer))
    {
      localBundle.putInt("ret", ((Integer)localObject).intValue());
      if (((Integer)localObject).intValue() == 40)
      {
        bundlePutTlv543(paramFromServiceMsg, localBundle);
        bundlePutErrorUrl(paramFromServiceMsg, localBundle);
      }
    }
    for (;;)
    {
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      notifyObserver(paramIntent, 1100, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
      if (paramFromServiceMsg.getResultCode() == 1013) {
        report(paramFromServiceMsg.getUin(), false, "ssoLoginAppTimeout", 0L, 0L, null, true);
      }
      return;
      localBundle.putInt("ret", -1);
    }
  }
  
  private void onReceiveForActionSendWTPKG(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str1 = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("wtsdkseq", -1L);
    paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
    paramIntent.order(ByteOrder.BIG_ENDIAN);
    int i = paramIntent.getInt();
    byte[] arrayOfByte = new byte[i - 4];
    paramIntent.get(arrayOfByte, 0, i - 4);
    if (paramFromServiceMsg.isSuccess())
    {
      WtloginMsfListener.onAsyncReceive(str1, str2, l, arrayOfByte);
      return;
    }
    WtloginMsfListener.onAsyncReceiveFail(str1, str2, l, paramFromServiceMsg.getBusinessFailCode());
  }
  
  private void onReceiveForActionSubAccountGetKey(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    Object localObject4 = (String)paramFromServiceMsg.getAttribute("MSF.getKey");
    String str = paramFromServiceMsg.getUin();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = ((String)localObject4).split(";");
      if (localObject1 == null) {
        break label318;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (localObject1.length <= 0) {
          break label318;
        }
        i = 0;
        if (i >= localObject1.length) {
          break label318;
        }
        localObject4 = localObject1[i];
        if ((localObject4 == null) || (((String)localObject4).length() == 0) || (!((String)localObject4).startsWith("UIN=" + str + ","))) {
          break label324;
        }
        int j = ((String)localObject4).indexOf("A2=");
        if (j < 0) {
          break label324;
        }
        localObject4 = ((String)localObject4).substring(j);
        if ((localObject4 == null) || (((String)localObject4).length() == 0)) {
          break label324;
        }
        localObject4 = ((String)localObject4).split(",");
        if ((localObject4 == null) || (localObject4.length <= 0) || (localObject4[0] == null) || (localObject4[0].length() <= "A2=".length() + 1)) {
          break label324;
        }
        localObject1 = localObject4[0].substring("A2=".length());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      localBundle.putString("uin", str);
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putString("subaccountA2", (String)localObject1);
      localBundle.putString("mainaccount", (String)paramFromServiceMsg.getAttribute("mainaccount"));
      notifyObserver(paramIntent, 1037, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
      return;
      label318:
      Object localObject2 = null;
      continue;
      label324:
      i += 1;
    }
  }
  
  private void onReceiveForActionSubAccountLogin(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (QLog.isColorLevel()) {
      QLog.d("BuiltInServlet", 2, "sub account login in back from msf build servlets start");
    }
    getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    localBundle.putString("uin", paramFromServiceMsg.getUin());
    localBundle.putString("alias", paramIntent.getStringExtra("subaccount"));
    localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
    localBundle.putInt("code", paramFromServiceMsg.getResultCode());
    Object localObject;
    if (paramFromServiceMsg.isSuccess())
    {
      MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
      localObject = paramIntent.getStringExtra("subaccount");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject);
      }
    }
    for (;;)
    {
      localObject = (String)paramFromServiceMsg.getAttribute("mainaccount");
      localBundle.putString("submainaccount", (String)localObject);
      SimpleAccount localSimpleAccount = getAppRuntime().getApplication().getFirstSimpleAccount();
      long l3 = System.currentTimeMillis();
      l1 = l3;
      if (localSimpleAccount != null) {
        l2 = l3;
      }
      try
      {
        long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(localSimpleAccount.getUin() + Constants.Key._logintime));
        l1 = l3;
        if (l3 <= l4)
        {
          l3 = l4 + 1L;
          l1 = l3;
          l2 = l3;
          if (QLog.isColorLevel())
          {
            l2 = l3;
            QLog.d("mqq", 2, "CNR account savetime => system time is error");
            l1 = l3;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          l1 = l2;
        }
      }
      if (paramFromServiceMsg.getUin() != null) {
        getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
      }
      if (localObject != null) {
        getAppRuntime().getApplication().setProperty((String)localObject + Constants.Key._logintime, String.valueOf(l1 + 1L));
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
      }
      notifyObserver(paramIntent, 1035, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
      return;
      MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      localBundle.putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
      localObject = paramFromServiceMsg.getAttribute("ret");
      if ((localObject instanceof Integer))
      {
        localBundle.putInt("ret", ((Integer)localObject).intValue());
        if (((Integer)localObject).intValue() == 40)
        {
          bundlePutTlv543(paramFromServiceMsg, localBundle);
          bundlePutErrorUrl(paramFromServiceMsg, localBundle);
        }
      }
    }
  }
  
  private void onReceiveForActionTransFileCheckMSFConerro(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("msf_con_erro", (String)paramFromServiceMsg.getAttribute("msf_con_erro", ""));
    notifyObserver(paramIntent, 2201, paramFromServiceMsg.isSuccess(), localBundle, CheckConErroObserver.class);
  }
  
  private void onReceiveForActionVeriftyPasswdRefreshImageCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    String str1 = paramFromServiceMsg.getUin();
    int i = paramFromServiceMsg.getBusinessFailCode();
    String str2 = paramFromServiceMsg.getBusinessFailMsg();
    String str3 = (String)paramFromServiceMsg.getAttribute("userAccount");
    byte[] arrayOfByte = (byte[])paramFromServiceMsg.getAttribute("pictureData");
    int j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
    ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
    localBundle.putString("uin", str1);
    localBundle.putInt("resultCode", i);
    localBundle.putString("errorMsg", str2);
    localBundle.putString("userAccount", str3);
    localBundle.putByteArray("pictureData", arrayOfByte);
    localBundle.putInt("ret", j);
    localBundle.putParcelable("lastError", localErrMsg);
    notifyObserver(paramIntent, 2207, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void onReceiveForActionVerifyPasswd(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    String str2 = paramFromServiceMsg.getUin();
    int i = paramFromServiceMsg.getBusinessFailCode();
    String str3 = paramFromServiceMsg.getBusinessFailMsg();
    int j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
    if (paramFromServiceMsg.getAttributes().containsKey("resp_verify_image")) {}
    for (byte[] arrayOfByte = (byte[])paramFromServiceMsg.getAttribute("resp_verify_image");; arrayOfByte = null)
    {
      if (paramFromServiceMsg.getAttributes().containsKey("resp_verify_msg")) {}
      for (String str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_msg");; str1 = null)
      {
        localBundle.putString("uin", str2);
        localBundle.putInt("resultCode", i);
        localBundle.putString("errorMsg", str3);
        localBundle.putInt("ret", j);
        localBundle.putString("notice", str1);
        localBundle.putByteArray("image", arrayOfByte);
        notifyObserver(paramIntent, 2205, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
      }
    }
  }
  
  private void onReceiveForActionVerifyPasswdSubmitImageCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    String str1 = paramFromServiceMsg.getUin();
    int i = paramFromServiceMsg.getBusinessFailCode();
    String str2 = paramFromServiceMsg.getBusinessFailMsg();
    String str3 = (String)paramFromServiceMsg.getAttribute("userAccount");
    byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("userInput");
    int j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
    ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
    byte[] arrayOfByte1 = null;
    if (paramFromServiceMsg.getAttributes().containsKey("image_buf")) {
      arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("image_buf");
    }
    localBundle.putString("uin", str1);
    localBundle.putInt("resultCode", i);
    localBundle.putString("errorMsg", str2);
    localBundle.putString("userAccount", str3);
    localBundle.putByteArray("userInput", arrayOfByte2);
    localBundle.putInt("ret", j);
    localBundle.putParcelable("lastError", localErrMsg);
    localBundle.putByteArray("image", arrayOfByte1);
    notifyObserver(paramIntent, 2206, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
  }
  
  private void serviceForActionActionMSFUpdateLocaleID(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
    int i = paramIntent.getIntExtra("localeId", 0);
    localToServiceMsg.getAttributes().put("localeId", Integer.valueOf(i));
    localToServiceMsg.setMsfCommand(MsfCommand.msf_update_locale_id);
    localToServiceMsg.setNeedCallback(false);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionAppGuard(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSFServlet", 2, "ACTION_UNGUARD_APP send now");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), null, "");
    localToServiceMsg.setMsfCommand(MsfCommand.gm_GuardEvent);
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.addAttribute("k_event", Integer.valueOf(paramIntent.getIntExtra("k_event", 0)));
    localToServiceMsg.addAttribute("k_arg0", Long.valueOf(paramIntent.getLongExtra("k_arg0", 0L)));
    localToServiceMsg.addAttribute("k_arg1", Long.valueOf(paramIntent.getLongExtra("k_arg1", 0L)));
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionChangeToken(Intent paramIntent)
  {
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("mapSt");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, localHashMap));
  }
  
  private void serviceForActionCheckQuickRegistAccont(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("account");
    int i = paramIntent.getIntExtra("appid", 0);
    Object localObject = paramIntent.getStringExtra("appVersion");
    localObject = getAppRuntime().getService().msfSub.checkQuickRegisterAccount(str, i, (byte)2, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + str);
    }
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionDeleteAccount(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("alias");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getDelLoginedAccount(getAppRuntime().getAccount(), str1, str2));
  }
  
  private void serviceForActionGetAlterTickets(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject, "");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.getAlterTickets);
    ((ToServiceMsg)localObject).setNeedCallback(true);
    if (localObject != null) {
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
    }
  }
  
  private void serviceForActionGetKey(Intent paramIntent)
  {
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getKeyMsg(getAppRuntime().getAccount()));
  }
  
  private void serviceForActionGetPluginConfig(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = getAppRuntime().getService().msfSub.getPluginConfigMsg(getAppRuntime().getAccount());
    localToServiceMsg.putWupBuffer(paramIntent.getByteArrayExtra("buffer"));
    localToServiceMsg.setTimeout(10000L);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionGetQuickRegistAccount(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("account");
    Object localObject = paramIntent.getStringExtra("password");
    String str2 = paramIntent.getStringExtra("nick");
    int i = paramIntent.getIntExtra("appid", 0);
    String str3 = paramIntent.getStringExtra("appVersion");
    localObject = getAppRuntime().getService().msfSub.getQuickRegisterAccount(str1, (String)localObject, str2, i, (byte)2, str3);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + str1 + ",nick=" + str2);
    }
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionGetTicketNoPasswd(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("process");
    Object localObject = paramIntent.getStringExtra("ssoAccount");
    String str2 = paramIntent.getStringExtra("from_where");
    localObject = getAppRuntime().getService().msfSub.getLoginWithoutPasswdMsg((String)localObject);
    ((ToServiceMsg)localObject).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
    ((ToServiceMsg)localObject).addAttribute("process", str1);
    if ((str2 != null) && (str2.length() > 0))
    {
      ((ToServiceMsg)localObject).addAttribute("from_where", str2);
      if (QLog.isColorLevel()) {
        QLog.d("builtInservert", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
      }
    }
    addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject);
    ((ToServiceMsg)localObject).setTimeout(40000L);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionLogin(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("account");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("password");
    if (isQQUin((String)localObject)) {}
    for (localObject = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject, arrayOfByte);; localObject = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject, arrayOfByte))
    {
      arrayOfByte = paramIntent.getByteArrayExtra("resp_register_supersig");
      ((ToServiceMsg)localObject).setIsSupportRetry(true);
      ((ToServiceMsg)localObject).setTimeout(40000L);
      ((ToServiceMsg)localObject).addAttribute("resp_register_supersig", arrayOfByte);
      arrayOfByte = paramIntent.getByteArrayExtra("to_login_uin_encrypt");
      if (arrayOfByte != null) {
        ((ToServiceMsg)localObject).addAttribute("to_login_uin_encrypt", arrayOfByte);
      }
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
      return;
    }
  }
  
  private void serviceForActionManualSetLogLevel(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
    int i = paramIntent.getIntExtra("opType", 0);
    int j = paramIntent.getIntExtra("manualLogLevel", 2);
    localToServiceMsg.getAttributes().put("opType", Integer.valueOf(i));
    localToServiceMsg.getAttributes().put("manualLogLevel", Integer.valueOf(j));
    localToServiceMsg.setMsfCommand(MsfCommand.msf_manual_set_log_level);
    localToServiceMsg.setNeedCallback(false);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionNetExceptionEvent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("value", 1);
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "Msf.NetException");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_NetException);
    localToServiceMsg.addAttribute("NetExceptionType", Integer.valueOf(i));
    localToServiceMsg.setNeedCallback(false);
    if (localToServiceMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_NET_EXCEPTION_EVENT send msgnow " + localToServiceMsg.getServiceCmd());
      }
      sendToMSF(paramIntent, localToServiceMsg);
    }
  }
  
  private void serviceForActionNotifyRefreshWebviewTicket(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRefreshTicketsMsg(str));
  }
  
  private void serviceForActionOpenPCActive(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("src");
    boolean bool = paramIntent.getBooleanExtra("opened", false);
    localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject, "");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.openPCActive);
    ((ToServiceMsg)localObject).getAttributes().put("src", str);
    ((ToServiceMsg)localObject).getAttributes().put("opened", Boolean.valueOf(bool));
    ((ToServiceMsg)localObject).setNeedCallback(false);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionQuerySMSState(Intent paramIntent)
  {
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterQueryUpSmsStatMsg());
  }
  
  private void serviceForActionRefreshDA2(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("account");
    localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject, "login.chgTok_DA2");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.msf_refreshDA2);
    ((ToServiceMsg)localObject).setNeedCallback(true);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionRegistCommandPush(Intent paramIntent)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = new CommandCallbackerInfo();
    localCommandCallbackerInfo.uin = getAppRuntime().getAccount();
    String[] arrayOfString = paramIntent.getStringArrayExtra("pushCommands");
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    localCommandCallbackerInfo.cmds = localArrayList;
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg(localCommandCallbackerInfo));
  }
  
  private void serviceForActionRegistMessagePush(Intent paramIntent)
  {
    if (!this.isRegist)
    {
      serviceForActionRegistCommandPush(paramIntent);
      this.isRegist = true;
    }
    PushRegisterInfo localPushRegisterInfo = new PushRegisterInfo();
    byte b;
    Object localObject;
    if (paramIntent.getBooleanExtra("kick", false))
    {
      b = 1;
      localPushRegisterInfo.bKikPC = b;
      localPushRegisterInfo.bKikWeak = 0;
      AppRuntime.Status localStatus = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
      boolean bool = paramIntent.getBooleanExtra("isUserSet", false);
      localPushRegisterInfo.iStatus = localStatus.getValue();
      long l = paramIntent.getLongExtra("extOnlineStatus", -1L);
      localPushRegisterInfo.extStatus = l;
      if ((localStatus == AppRuntime.Status.online) && (l == 1000L))
      {
        localPushRegisterInfo.batteryCapacity = paramIntent.getIntExtra("batteryCapacity", 0);
        localPushRegisterInfo.powerConnect = paramIntent.getIntExtra("powerConnect", -1);
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(1L));
      ((ArrayList)localObject).add(Long.valueOf(2L));
      ((ArrayList)localObject).add(Long.valueOf(4L));
      localPushRegisterInfo.pushIds = ((ArrayList)localObject);
      localPushRegisterInfo.timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      localPushRegisterInfo.iLargeSeq = paramIntent.getLongExtra("K_SEQ", 0L);
      localPushRegisterInfo.uin = getAppRuntime().getAccount();
      if (localStatus != AppRuntime.Status.offline) {
        break label433;
      }
      localObject = getAppRuntime().getService().msfSub.getUnRegisterPushMsg(localPushRegisterInfo);
      label269:
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + localStatus + ", " + localPushRegisterInfo.timeStamp + ", " + localPushRegisterInfo.iLargeSeq + ", isUserSet: " + bool);
      }
      if (!bool) {
        break label453;
      }
      ((ToServiceMsg)localObject).getAttributes().put("regPushReason", RegPushReason.setOnlineStatus);
    }
    for (;;)
    {
      int i = paramIntent.getIntExtra("vendor_push_type", 1);
      ((ToServiceMsg)localObject).getAttributes().put("vendor_push_type", Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d("Mqq", 2, "mqq-BuiltInServlet.vendor_push_type:" + i);
      }
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
      return;
      b = 0;
      break;
      label433:
      localObject = getAppRuntime().getService().msfSub.getRegisterPushMsg(localPushRegisterInfo);
      break label269;
      label453:
      ((ToServiceMsg)localObject).getAttributes().put("regPushReason", RegPushReason.appRegister);
    }
  }
  
  private void serviceForActionRegistMessagePushProxy(Intent paramIntent)
  {
    int i = 0;
    int j = paramIntent.getIntExtra("appid", 0);
    String str1 = paramIntent.getStringExtra("processName");
    String str2 = paramIntent.getStringExtra("broadcastName");
    Object localObject = paramIntent.getStringArrayExtra("commands");
    ArrayList localArrayList = new ArrayList();
    int k = localObject.length;
    while (i < k)
    {
      localArrayList.add(localObject[i]);
      i += 1;
    }
    localObject = new NotifyRegisterInfo();
    ((NotifyRegisterInfo)localObject).uin = getAppRuntime().getAccount();
    ((NotifyRegisterInfo)localObject).notifyIds = new ArrayList();
    ((NotifyRegisterInfo)localObject).notifyProperties = new HashMap();
    CommandCallbackerInfo localCommandCallbackerInfo = new CommandCallbackerInfo();
    localCommandCallbackerInfo.uin = getAppRuntime().getAccount();
    localCommandCallbackerInfo.cmds = localArrayList;
    sendToMSF(paramIntent, MsfServiceSdk.get().getRegisterProxyMsg(j, getAppRuntime().getAccount(), str1, str2, (NotifyRegisterInfo)localObject, localCommandCallbackerInfo));
  }
  
  private void serviceForActionRegistNewAccountCommitMobile(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("countryCode");
    String str1 = paramIntent.getStringExtra("phoneNumber");
    Object localObject4 = paramIntent.getStringExtra("inviteCode");
    long l = paramIntent.getLongExtra("appid", 0L);
    Object localObject3 = paramIntent.getStringExtra("verifySig");
    String str2 = (String)localObject1 + "-" + str1;
    String str3 = paramIntent.getStringExtra("appVersion");
    byte b = paramIntent.getByteExtra("language", (byte)2);
    localObject1 = paramIntent.getStringExtra("wifi_mac");
    Object localObject2 = paramIntent.getStringExtra("os_language");
    int i = paramIntent.getIntExtra("qq_language", 0);
    str1 = paramIntent.getStringExtra("gps_location");
    localObject3 = getAppRuntime().getService().msfSub.getRegisterCommitMobileMsg((String)localObject3, (byte)0, b, (byte)0, "", str3, str2, Long.valueOf(l));
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((ToServiceMsg)localObject3).getAttributes().put("To_register_Invitation_code", localObject4);
    }
    localObject4 = ((ToServiceMsg)localObject3).getAttributes();
    if (localObject1 == null)
    {
      localObject1 = "";
      ((HashMap)localObject4).put("wifi_mac", localObject1);
      localObject4 = ((ToServiceMsg)localObject3).getAttributes();
      if (localObject2 != null) {
        break label289;
      }
      localObject1 = "";
      label224:
      ((HashMap)localObject4).put("os_language", localObject1);
      ((ToServiceMsg)localObject3).getAttributes().put("qq_language", Integer.valueOf(i));
      localObject2 = ((ToServiceMsg)localObject3).getAttributes();
      if (str1 != null) {
        break label296;
      }
    }
    label289:
    label296:
    for (localObject1 = "";; localObject1 = str1)
    {
      ((HashMap)localObject2).put("gps_location", localObject1);
      sendToMSF(paramIntent, (ToServiceMsg)localObject3);
      return;
      break;
      localObject1 = localObject2;
      break label224;
    }
  }
  
  private void serviceForActionRegistNewAccountCommitSMS(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("code");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitSmsCodeMsg(str));
  }
  
  private void serviceForActionRegistNewAccountQueryMobile(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("countryCode");
    String str2 = paramIntent.getStringExtra("phoneNumber");
    str1 = str1 + "-" + str2;
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegQueryAccountMsg(str1));
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount");
    }
  }
  
  private void serviceForActionRegistNewAccountRefetchSMS(Intent paramIntent)
  {
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterSendReSendSmsMsg());
  }
  
  private void serviceForActionRegistNewAccountSendPassword(Intent paramIntent)
  {
    boolean bool = true;
    String str1 = paramIntent.getStringExtra("password");
    String str2 = paramIntent.getStringExtra("nick");
    String str3 = paramIntent.getStringExtra("code");
    if (paramIntent.hasExtra("bindMobile")) {
      bool = paramIntent.getBooleanExtra("bindMobile", true);
    }
    String str4 = paramIntent.getStringExtra("lhuin");
    String str5 = paramIntent.getStringExtra("unBindlhUin");
    String str6 = paramIntent.getStringExtra("appVersion");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitPassMsg(str3, str1, str2, bool, str4, str5, str6));
  }
  
  private void serviceForActionReport(Intent paramIntent)
  {
    byte b = paramIntent.getByteExtra("type", (byte)0);
    String str = paramIntent.getStringExtra("content");
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getReportMsg(b, str));
  }
  
  private void serviceForActionSSOGetA1WithA1(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("ssoAccount");
    Object localObject1 = paramIntent.getByteArrayExtra("dstAppName");
    long l1 = paramIntent.getLongExtra("dwDstSsoVer", 0L);
    long l2 = paramIntent.getLongExtra("dwDstAppid", 0L);
    long l3 = paramIntent.getLongExtra("dwSubDstAppid", 0L);
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("dstAppVer");
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("dstAppSign");
    localObject2 = getAppRuntime().getService().msfSub.getA1WithA1((String)localObject2);
    ((ToServiceMsg)localObject2).addAttribute("dstAppName", localObject1);
    ((ToServiceMsg)localObject2).addAttribute("dwDstSsoVer", Long.valueOf(l1));
    ((ToServiceMsg)localObject2).addAttribute("dwDstAppid", Long.valueOf(l2));
    ((ToServiceMsg)localObject2).addAttribute("dwSubDstAppid", Long.valueOf(l3));
    ((ToServiceMsg)localObject2).addAttribute("dstAppVer", arrayOfByte1);
    ((ToServiceMsg)localObject2).addAttribute("dstAppSign", arrayOfByte2);
    ((ToServiceMsg)localObject2).addAttribute("fastLoginInfo", new WFastLoginInfo());
    localObject1 = paramIntent.getStringExtra("process");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ToServiceMsg)localObject2).addAttribute("process", localObject1);
    }
    addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject2);
    ((ToServiceMsg)localObject2).setTimeout(40000L);
    sendToMSF(paramIntent, (ToServiceMsg)localObject2);
  }
  
  private void serviceForActionSSOLoginAccount(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("process");
    Object localObject = paramIntent.getStringExtra("ssoAccount");
    String str2 = paramIntent.getStringExtra("ssoPassword");
    if (isQQUin((String)localObject)) {}
    for (localObject = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject, MD5.toMD5Byte(str2));; localObject = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject, MD5.toMD5Byte(str2)))
    {
      ((ToServiceMsg)localObject).setIsSupportRetry(true);
      ((ToServiceMsg)localObject).setTimeout(40000L);
      ((ToServiceMsg)localObject).addAttribute("from_where", "ssoAccountAction");
      ((ToServiceMsg)localObject).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
      ((ToServiceMsg)localObject).addAttribute("process", str1);
      addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject);
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
      return;
    }
  }
  
  private void serviceForActionSaveGEOGInfo(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("longitude");
    String str2 = paramIntent.getStringExtra("latitude");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
    localToServiceMsg.setMsfCommand(MsfCommand.msf_save_geoginfo);
    localToServiceMsg.getAttributes().put("geoginfo_lontitude", str1);
    localToServiceMsg.getAttributes().put("geoginfo_latitude", str2);
    localToServiceMsg.setNeedCallback(false);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionSendMSGSignal(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
    localToServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
    localToServiceMsg.setNeedCallback(false);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionSendWTPKG(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("busBuf");
    int i = paramIntent.getIntExtra("timeout", 30000);
    long l = paramIntent.getLongExtra("wtsdkseq", -1L);
    sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getSendWtPkgMsg(str1, l, str2, arrayOfByte, i));
  }
  
  private void serviceForActionSendWirelessMeiBaoReq(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("cmd", 1);
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "PwdProtect.DataUpload");
    localToServiceMsg.setMsfCommand(MsfCommand.SEND_WIRELESS_MEIBAOREQ);
    localToServiceMsg.addAttribute("cmd", Integer.valueOf(i));
    localToServiceMsg.setNeedCallback(false);
    if (localToServiceMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + localToServiceMsg.getServiceCmd());
      }
      sendToMSF(paramIntent, localToServiceMsg);
    }
  }
  
  private void serviceForActionSendWirelessPSWReq(Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MSFServlet", 4, "WIRELESS_PSWREQ:");
    }
    int i = paramIntent.getIntExtra("cmd", 1);
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "KsidTrans.Trans");
    localToServiceMsg.setMsfCommand(MsfCommand.SEND_WIRELESS_PSWREQ);
    localToServiceMsg.addAttribute("cmd", Integer.valueOf(i));
    localToServiceMsg.setNeedCallback(false);
    if (localToServiceMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_PSWREQ send msgnow " + localToServiceMsg.getServiceCmd());
      }
      sendToMSF(paramIntent, localToServiceMsg);
    }
  }
  
  private void serviceForActionStartPCActivePolling(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("src");
    localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject, "");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.startPCActivePolling);
    ((ToServiceMsg)localObject).getAttributes().put("src", str);
    ((ToServiceMsg)localObject).setNeedCallback(false);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionStopPCActivePolling(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    String str = paramIntent.getStringExtra("src");
    localObject = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject, "");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.stopPCActivePolling);
    ((ToServiceMsg)localObject).getAttributes().put("src", str);
    ((ToServiceMsg)localObject).setNeedCallback(false);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionSubAccountGetKey(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("subaccountuin");
    String str = paramIntent.getStringExtra("mainaccount");
    localObject = getAppRuntime().getService().msfSub.getKeyMsg((String)localObject);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    ((ToServiceMsg)localObject).addAttribute("from_where", "subaccount");
    ((ToServiceMsg)localObject).addAttribute("mainaccount", str);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionSubAccountLogin(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("subaccount");
    String str2 = paramIntent.getStringExtra("subpassword");
    String str1 = paramIntent.getStringExtra("mainaccount");
    if (isQQUin((String)localObject)) {}
    for (localObject = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject, MD5.toMD5Byte(str2));; localObject = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject, MD5.toMD5Byte(str2)))
    {
      ((ToServiceMsg)localObject).setIsSupportRetry(true);
      ((ToServiceMsg)localObject).addAttribute("from_where", "subaccount");
      ((ToServiceMsg)localObject).addAttribute("mainaccount", str1);
      ((ToServiceMsg)localObject).setTimeout(40000L);
      sendToMSF(paramIntent, (ToServiceMsg)localObject);
      return;
    }
  }
  
  private void serviceForActionTransFileCheckMSFConerro(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = getAppRuntime().getService().msfSub.getCheckMsfConErroMsg();
    localToServiceMsg.setTimeout(10000L);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionUnregistMessagePushProxy(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("appid", 0);
    sendToMSF(paramIntent, MsfServiceSdk.get().getUnRegisterProxyMsg(i, getAppRuntime().getAccount(), paramIntent.getStringExtra("processName")));
  }
  
  private void serviceForActionUpdateMSFConfig(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "cmd_update_manager_config");
    localToServiceMsg.setMsfCommand(MsfCommand.msfUpdateManagerConfig);
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.setNeedCallback(false);
    String str = paramIntent.getStringExtra("manager_config");
    localToServiceMsg.getAttributes().put("manager_config", str);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void serviceForActionVeriftyPasswd(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("account");
    String str = paramIntent.getStringExtra("password");
    localObject = getAppRuntime().getService().msfSub.getVerifyPasswdMsg((String)localObject, MD5.toMD5Byte(str));
    ((ToServiceMsg)localObject).setTimeout(40000L);
    ((ToServiceMsg)localObject).setIsSupportRetry(true);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionVerifyPassWDRefreshImageCode(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("account");
    localObject = getAppRuntime().getService().msfSub.getVerifyPasswdRefreshImageMsg((String)localObject);
    ((ToServiceMsg)localObject).setTimeout(40000L);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  private void serviceForActionVerifyPasswdSubmitImageCode(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("account");
    String str = paramIntent.getStringExtra("verifyCode");
    localObject = getAppRuntime().getService().msfSub.getVerifyPasswdImageMsg((String)localObject, str);
    ((ToServiceMsg)localObject).setTimeout(40000L);
    sendToMSF(paramIntent, (ToServiceMsg)localObject);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("action", 0);
    }
    if (dispatchOnReceiveForRegister(i, paramIntent, paramFromServiceMsg)) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 1001: 
      onReceiveForActionLogin(paramIntent, paramFromServiceMsg);
      return;
    case 2205: 
      onReceiveForActionVerifyPasswd(paramIntent, paramFromServiceMsg);
      return;
    case 2206: 
      onReceiveForActionVerifyPasswdSubmitImageCode(paramIntent, paramFromServiceMsg);
      return;
    case 2207: 
      onReceiveForActionVeriftyPasswdRefreshImageCode(paramIntent, paramFromServiceMsg);
      return;
    case 1035: 
      onReceiveForActionSubAccountLogin(paramIntent, paramFromServiceMsg);
      return;
    case 1100: 
      onReceiveForActionSSOLoginAccount(paramIntent, paramFromServiceMsg);
      return;
    case 1101: 
      onReceiveForActionGetTicketNoPasswd(paramIntent, paramFromServiceMsg);
      return;
    case 1102: 
      onReceiveForActionSSOGetA1WithA1(paramIntent, paramFromServiceMsg);
      return;
    case 1037: 
      onReceiveForActionSubAccountGetKey(paramIntent, paramFromServiceMsg);
      return;
    case 1040: 
      onReceiveForActionRegistCommandPush(paramIntent, paramFromServiceMsg);
      return;
    case 1002: 
      onReceiveForActionRegistMessagePush(paramIntent, paramFromServiceMsg);
      return;
    case 1007: 
      notifyObserver(paramIntent, 1007, paramFromServiceMsg.isSuccess(), null, AccountObserver.class);
      return;
    case 1032: 
      onReceiveForActionChangeToken(paramIntent, paramFromServiceMsg, i);
      return;
    case 1030: 
      onReceiveForActionGetKey(paramIntent, paramFromServiceMsg, i);
      return;
    case 2203: 
      onReceiveForActionSendWTPKG(paramIntent, paramFromServiceMsg);
      return;
    case 1018: 
      onReceiveForActionGetPluginConfig(paramIntent, paramFromServiceMsg);
      return;
    case 2124: 
      onReceiveForActionGetAlterTickets(paramFromServiceMsg);
      return;
    case 1046: 
      onReceiveForActionRefreshDA2(paramIntent, paramFromServiceMsg);
      return;
    }
    onReceiveForActionTransFileCheckMSFConerro(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void report(String paramString1, boolean paramBoolean1, String paramString2, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, boolean paramBoolean2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "10000";
    }
    if (((localObject == null) || (((String)localObject).length() >= 1)) || (paramHashMap == null))
    {
      paramString1 = new HashMap();
      paramHashMap = new RdmReq();
      paramHashMap.eventName = paramString2;
      paramHashMap.elapse = paramLong1;
      paramHashMap.size = paramLong2;
      paramHashMap.isSucceed = paramBoolean1;
      paramHashMap.isRealTime = paramBoolean2;
      paramHashMap.isMerge = false;
      paramHashMap.isRealTime = true;
      paramHashMap.params = paramString1;
    }
    try
    {
      paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
      MsfServiceSdk.get().sendMsg(paramString1);
      return;
    }
    catch (Exception paramString1) {}
    localObject = paramHashMap.keySet().iterator();
    for (;;)
    {
      paramString1 = paramHashMap;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramString1 = (String)((Iterator)localObject).next();
      if ((String)paramHashMap.get(paramString1) == null) {
        paramHashMap.put(paramString1, "");
      }
    }
  }
  
  public void service(Intent paramIntent)
  {
    super.service(paramIntent);
    int i = paramIntent.getIntExtra("action", 0);
    if (dispatchServiceForLogin(i, paramIntent)) {
      return;
    }
    dispatchService(i, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.BuiltInServlet
 * JD-Core Version:    0.7.0.1
 */