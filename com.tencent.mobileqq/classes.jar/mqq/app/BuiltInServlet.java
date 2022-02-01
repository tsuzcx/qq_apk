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
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("action", 0);
    }
    Bundle localBundle = new Bundle();
    Object localObject10;
    int j;
    Object localObject1;
    label310:
    Object localObject6;
    label333:
    label1260:
    Object localObject2;
    long l1;
    long l2;
    Object localObject9;
    Object localObject7;
    switch (i)
    {
    default: 
    case 2205: 
    case 2206: 
    case 2207: 
    case 1001: 
      do
      {
        return;
        Object localObject8 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject10 = paramFromServiceMsg.getBusinessFailMsg();
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        if (!paramFromServiceMsg.getAttributes().containsKey("resp_verify_image")) {
          break label5691;
        }
        localObject1 = (byte[])paramFromServiceMsg.getAttribute("resp_verify_image");
        if (!paramFromServiceMsg.getAttributes().containsKey("resp_verify_msg")) {
          break label5685;
        }
        localObject6 = (String)paramFromServiceMsg.getAttribute("resp_verify_msg");
        localBundle.putString("uin", (String)localObject8);
        localBundle.putInt("resultCode", i);
        localBundle.putString("errorMsg", (String)localObject10);
        localBundle.putInt("ret", j);
        localBundle.putString("notice", (String)localObject6);
        localBundle.putByteArray("image", (byte[])localObject1);
        notifyObserver(paramIntent, 2205, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localObject6 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject8 = paramFromServiceMsg.getBusinessFailMsg();
        localObject10 = (String)paramFromServiceMsg.getAttribute("userAccount");
        Object localObject11 = (byte[])paramFromServiceMsg.getAttribute("userInput");
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
        localObject1 = null;
        if (paramFromServiceMsg.getAttributes().containsKey("image_buf")) {
          localObject1 = (byte[])paramFromServiceMsg.getAttribute("image_buf");
        }
        localBundle.putString("uin", (String)localObject6);
        localBundle.putInt("resultCode", i);
        localBundle.putString("errorMsg", (String)localObject8);
        localBundle.putString("userAccount", (String)localObject10);
        localBundle.putByteArray("userInput", (byte[])localObject11);
        localBundle.putInt("ret", j);
        localBundle.putParcelable("lastError", localErrMsg);
        localBundle.putByteArray("image", (byte[])localObject1);
        notifyObserver(paramIntent, 2206, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localObject1 = paramFromServiceMsg.getUin();
        i = paramFromServiceMsg.getBusinessFailCode();
        localObject6 = paramFromServiceMsg.getBusinessFailMsg();
        localObject8 = (String)paramFromServiceMsg.getAttribute("userAccount");
        localObject10 = (byte[])paramFromServiceMsg.getAttribute("pictureData");
        j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
        localObject11 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
        localBundle.putString("uin", (String)localObject1);
        localBundle.putInt("resultCode", i);
        localBundle.putString("errorMsg", (String)localObject6);
        localBundle.putString("userAccount", (String)localObject8);
        localBundle.putByteArray("pictureData", (byte[])localObject10);
        localBundle.putInt("ret", j);
        localBundle.putParcelable("lastError", (Parcelable)localObject11);
        notifyObserver(paramIntent, 2207, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("BuiltInServlet", 2, "login in back from msf build servlets start");
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        localBundle.putString("uin", paramFromServiceMsg.getUin());
        localBundle.putString("alias", paramIntent.getStringExtra("account"));
        localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
        localObject8 = paramFromServiceMsg.getAttribute("resp_login_url");
        localObject6 = "";
        localObject1 = localObject6;
        if (localObject8 != null)
        {
          localObject1 = localObject6;
          if ((localObject8 instanceof String)) {
            localObject1 = (String)localObject8;
          }
        }
        localObject6 = paramFromServiceMsg.getAttribute("resp_logini_ret");
        j = 0;
        i = j;
        if (localObject6 != null)
        {
          i = j;
          if ((localObject6 instanceof Integer)) {
            i = ((Integer)localObject6).intValue();
          }
        }
        localObject10 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
        localObject8 = null;
        localObject6 = localObject8;
        if (localObject10 != null)
        {
          localObject6 = localObject8;
          if ((localObject10 instanceof byte[])) {
            localObject6 = (byte[])localObject10;
          }
        }
        try
        {
          localObject8 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
          if (localObject8 != null) {
            localBundle.putInt("errorver", ((ErrMsg)localObject8).getVersion());
          }
        }
        catch (Exception localException13)
        {
          for (;;)
          {
            QLog.e("mqq", 1, "getAttribute error:" + localException13.getMessage());
            continue;
            MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
            try
            {
              localObject1 = (WUserSigInfo)paramFromServiceMsg.getAttribute("userSigInfo");
              if ((localObject1 != null) && (((WUserSigInfo)localObject1).loginResultTLVMap != null) && (((WUserSigInfo)localObject1).loginResultTLVMap.get(Integer.valueOf(1347)) != null))
              {
                localObject1 = ((tlv_t)((WUserSigInfo)localObject1).loginResultTLVMap.get(Integer.valueOf(1347))).get_data();
                if (localObject1 != null) {
                  break label1260;
                }
              }
              QLog.d("ACTION_LOGIN", 1, "ignore tlv543Bytes");
            }
            catch (Exception localException1)
            {
              QLog.e("ACTION_LOGIN", 1, "getAttribute userSignInfo error:" + localException1.getMessage());
            }
            continue;
            localBundle.putByteArray("tlverror", localException1);
          }
        }
        localBundle.putString("errorurl", (String)localObject1);
        localBundle.putInt("loginret", i);
        localBundle.putInt("code", paramFromServiceMsg.getResultCode());
        localBundle.putByteArray("lhsig", (byte[])localObject6);
        if (!paramFromServiceMsg.isSuccess()) {
          break;
        }
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject1 = paramIntent.getStringExtra("account");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        notifyObserver(paramIntent, 1001, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      } while (!QLog.isColorLevel());
      QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
      return;
    case 1035: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "sub account login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      localBundle.putString("uin", paramFromServiceMsg.getUin());
      localBundle.putString("alias", paramIntent.getStringExtra("subaccount"));
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject2 = paramIntent.getStringExtra("subaccount");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject2);
        }
      }
      for (;;)
      {
        localObject2 = (String)paramFromServiceMsg.getAttribute("mainaccount");
        localBundle.putString("submainaccount", (String)localObject2);
        localObject6 = getAppRuntime().getApplication().getFirstSimpleAccount();
        long l3 = System.currentTimeMillis();
        l1 = l3;
        if (localObject6 != null) {
          l2 = l3;
        }
        try
        {
          long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject6).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = 1L + l4;
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
        catch (Exception localException12)
        {
          for (;;)
          {
            localException12.printStackTrace();
            l1 = l2;
          }
        }
        if (paramFromServiceMsg.getUin() != null) {
          getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
        }
        if (localObject2 != null) {
          getAppRuntime().getApplication().setProperty((String)localObject2 + Constants.Key._logintime, String.valueOf(l1 + 1L));
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
        }
        notifyObserver(paramIntent, 1035, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
        return;
        MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      }
    case 1100: 
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
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        localBundle.putInt("code", paramFromServiceMsg.getResultCode());
        localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1100, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        if (paramFromServiceMsg.getResultCode() != 1013) {
          break;
        }
        report(paramFromServiceMsg.getUin(), false, "ssoLoginAppTimeout", 0L, 0L, null, true);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1101: 
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
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1101, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1102: 
      localBundle.putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localObject2 = paramFromServiceMsg.getAttribute("dwSrcAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          localBundle.putLong("dwSrcAppid", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwMainSigMap");
        if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
          localBundle.putInt("dwMainSigMap", ((Integer)localObject2).intValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwSubSrcAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          localBundle.putLong("dwSubSrcAppid", ((Long)localObject2).longValue());
        }
        localBundle.putByteArray("dstAppName", (byte[])paramFromServiceMsg.getAttribute("dstAppName"));
        localObject2 = paramFromServiceMsg.getAttribute("dwDstSsoVer");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          localBundle.putLong("dwDstSsoVer", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwDstAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          localBundle.putLong("dwDstAppid", ((Long)localObject2).longValue());
        }
        localObject2 = paramFromServiceMsg.getAttribute("dwSubDstAppid");
        if ((localObject2 != null) && ((localObject2 instanceof Long))) {
          localBundle.putLong("dwSubDstAppid", ((Long)localObject2).longValue());
        }
        localBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        localBundle.putParcelable("fastLoginInfo", (Parcelable)paramFromServiceMsg.getAttribute("fastLoginInfo"));
        localBundle.putByteArray("dstAppVer", (byte[])paramFromServiceMsg.getAttribute("dstAppVer"));
        localBundle.putByteArray("dstAppSign", (byte[])paramFromServiceMsg.getAttribute("dstAppSign"));
        localBundle.putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      }
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject2 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
        localBundle.putInt("ret", ((Integer)localObject2).intValue());
      }
      for (;;)
      {
        notifyObserver(paramIntent, 1102, paramFromServiceMsg.isSuccess(), localBundle, SSOAccountObserver.class);
        return;
        localBundle.putInt("ret", -1);
      }
    case 1037: 
      localObject10 = (String)paramFromServiceMsg.getAttribute("MSF.getKey");
      localObject9 = paramFromServiceMsg.getUin();
      localObject7 = null;
      localObject2 = localObject7;
      if (localObject10 != null)
      {
        localObject2 = ((String)localObject10).split(";");
        if (localObject2 == null) {
          break label5679;
        }
      }
      break;
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        if (localObject2.length <= 0) {
          break label5679;
        }
        i = 0;
        if (i >= localObject2.length) {
          break label5679;
        }
        localObject10 = localObject2[i];
        if ((localObject10 == null) || (((String)localObject10).length() == 0) || (!((String)localObject10).startsWith("UIN=" + (String)localObject9 + ","))) {
          break label5697;
        }
        j = ((String)localObject10).indexOf("A2=");
        if (j < 0) {
          break label5697;
        }
        localObject10 = ((String)localObject10).substring(j);
        if ((localObject10 == null) || (((String)localObject10).length() == 0)) {
          break label5697;
        }
        localObject10 = ((String)localObject10).split(",");
        if ((localObject10 == null) || (localObject10.length <= 0) || (localObject10[0] == null) || (localObject10[0].length() <= "A2=".length() + 1)) {
          break label5697;
        }
        localObject2 = localObject10[0].substring("A2=".length());
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        localObject3 = localObject7;
        continue;
      }
      localBundle.putString("uin", (String)localObject9);
      localBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("code", paramFromServiceMsg.getResultCode());
      localBundle.putString("subaccountA2", (String)localObject2);
      localBundle.putString("mainaccount", (String)paramFromServiceMsg.getAttribute("mainaccount"));
      notifyObserver(paramIntent, 1037, paramFromServiceMsg.isSuccess(), localBundle, SubAccountObserver.class);
      return;
      notifyObserver(paramIntent, 1040, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
      return;
      if ((!"push.register".equals(paramFromServiceMsg.getServiceCmd())) && (!"push.unRegister".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      getAppRuntime().getOnlineStatus();
      l1 = 0L;
      boolean bool2;
      label3147:
      boolean bool3;
      label3159:
      boolean bool1;
      if (paramFromServiceMsg.isSuccess()) {
        if ("push.register".equals(paramFromServiceMsg.getServiceCmd())) {
          if ((paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
          {
            localObject7 = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
            if ((localObject7 != null) && (((SvcRespRegister)localObject7).cReplyCode == 0)) {
              if (((SvcRespRegister)localObject7).bUpdateFlag == 1)
              {
                bool2 = true;
                if (((SvcRespRegister)localObject7).bLargeSeqUpdate != 1) {
                  break label3527;
                }
                bool3 = true;
                i = ((SvcRespRegister)localObject7).iStatus;
                l1 = ((SvcRespRegister)localObject7).timeStamp;
                localObject3 = AppRuntime.Status.build(i);
                l2 = ((SvcRespRegister)localObject7).uExtOnlineStatus;
                if (localObject3 != null) {
                  break label5670;
                }
                QLog.d("mqq", 1, String.format("invalid iStatus: %s", new Object[] { Integer.valueOf(i) }));
                if (!paramFromServiceMsg.attributes.containsKey("attr_online_status")) {
                  break label3533;
                }
                i = ((Integer)paramFromServiceMsg.getAttribute("attr_online_status")).intValue();
                paramFromServiceMsg = AppRuntime.Status.build(i);
                QLog.d("mqq", 1, String.format("update iStatus: %s", new Object[] { Integer.valueOf(i) }));
                label3270:
                if (paramFromServiceMsg != null) {
                  break label5664;
                }
                paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
                QLog.e("mqq", 1, "register.push onlineStatus == null");
                bool1 = true;
              }
            }
          }
        }
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
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("mqq", 2, String.format("register.push, isSuc = %s, onlineStatus = %s, isUserSet = %s, isChanged = %s, timeStamp = %s, isLargeChanged = %s, iStatus = %s, extStatus = %s", new Object[] { Boolean.valueOf(bool1), paramFromServiceMsg, Boolean.valueOf(bool4), Boolean.valueOf(bool3), Long.valueOf(l1), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(l2) }));
          return;
          bool2 = false;
          break label3147;
          label3527:
          bool3 = false;
          break label3159;
          label3533:
          QLog.d("mqq", 1, String.format("don't containsKey attr_online_status", new Object[0]));
          paramFromServiceMsg = (FromServiceMsg)localObject3;
          break label3270;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          if (localObject7 != null)
          {
            i = ((SvcRespRegister)localObject7).cReplyCode;
            label3578:
            if (localObject7 != null) {
              break label3642;
            }
          }
          label3642:
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
            break label3578;
          }
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
          QLog.d("mqq", 1, "register.push return empty packet! status: " + paramFromServiceMsg);
          l2 = -1L;
          bool3 = false;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = true;
          continue;
          paramFromServiceMsg = AppRuntime.Status.offline;
          l2 = -1L;
          bool3 = false;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = true;
          continue;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          QLog.d("mqq", 1, "register.push fail!");
          l2 = -1L;
          bool3 = false;
          l1 = 0L;
          i = 0;
          bool2 = false;
          bool1 = false;
        }
        localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount callback");
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            localException3.printStackTrace();
          }
        }
        localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
            localBundle.putInt("code", j);
            localBundle.putByteArray("mobile", arrayOfByte1);
            if (paramIntent.hasExtra("inviteCode")) {
              localBundle.putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
            }
            notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
            return;
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            continue;
          }
          if (paramFromServiceMsg.getBusinessFailCode() == 3001)
          {
            Object localObject4 = paramFromServiceMsg.getBusinessFailMsg();
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              try
              {
                j = Integer.valueOf((String)localObject4).intValue();
                localObject4 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
                localBundle.putInt("code", j);
                localBundle.putByteArray("mobile", (byte[])localObject4);
                if (paramIntent.hasExtra("inviteCode")) {
                  localBundle.putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
                }
              }
              catch (Exception localException5)
              {
                localException5.printStackTrace();
              }
            }
          }
        }
        localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        int k;
        int m;
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          localBundle.putInt("code", j);
          localBundle.putInt("next_chk_time", k);
          localBundle.putInt("total_time_over", m);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
        }
        catch (Exception localException6)
        {
          for (;;)
          {
            localException6.printStackTrace();
          }
        }
        localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          String str1 = (String)paramFromServiceMsg.getAttribute("bind_qq_uin");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("bind_qq_uin", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_nick");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("bind_qq_nick", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_faceUrl");
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("bind_qq_face_url", str1);
          }
        }
        catch (Exception localException7)
        {
          for (;;)
          {
            localException7.printStackTrace();
          }
        }
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localBundle.putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          String str2 = (String)paramFromServiceMsg.getAttribute("res_register_errmsg", "");
          localObject7 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject9 = (String)paramFromServiceMsg.getAttribute("resp_register_nick", "");
          localObject10 = (String)paramFromServiceMsg.getAttribute("resp_register_picture_url", "");
          localBundle.putInt("code", j);
          localBundle.putInt("next_chk_time", k);
          localBundle.putInt("total_time_over", m);
          localBundle.putString("errmsg", str2);
          localBundle.putString("uin", (String)localObject7);
          localBundle.putString("nick", (String)localObject9);
          localBundle.putString("faceUrl", (String)localObject10);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
        }
        catch (Exception localException8)
        {
          for (;;)
          {
            localException8.printStackTrace();
          }
        }
        localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_contactssig", new byte[0]);
            localObject7 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
            localObject9 = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
            localObject10 = (byte[])paramFromServiceMsg.getAttribute("resp_register_supersig", null);
            if ((localObject9 != null) && (localObject9.length > 0))
            {
              localBundle.putByteArray("lhsig", (byte[])localObject9);
              if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "builtInServlet|LiangHao_lhsig= " + new String((byte[])localObject9));
              }
            }
            localBundle.putByteArray("resp_register_supersig", (byte[])localObject10);
            localBundle.putInt("code", j);
            localBundle.putByteArray("promptInfo", arrayOfByte2);
            localBundle.putString("uin", (String)localObject7);
            if (QLog.isColorLevel()) {
              QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive code= " + j + ",uin=" + (String)localObject7);
            }
          }
          catch (Exception localException9)
          {
            localException9.printStackTrace();
            continue;
          }
          if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
            localBundle.putBoolean("reg_Lianghao", true);
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive failed = " + paramFromServiceMsg.getBusinessFailCode());
          }
        }
        localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          localBundle.putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
        }
        catch (Exception localException10)
        {
          for (;;)
          {
            localException10.printStackTrace();
          }
        }
        localBundle.putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          String str3 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject7 = (String)paramFromServiceMsg.getAttribute("to_register_cr_mobile", "");
          localBundle.putInt("code", j);
          localBundle.putString("uin", str3);
          localBundle.putString("phone", (String)localObject7);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
          return;
        }
        catch (Exception localException11)
        {
          for (;;)
          {
            localException11.printStackTrace();
          }
        }
        notifyObserver(paramIntent, 1007, paramFromServiceMsg.isSuccess(), null, AccountObserver.class);
        return;
        localBundle.putSerializable("map", paramFromServiceMsg.attributes);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localBundle.putString("key", (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localObject5 = paramIntent.getStringExtra("uin");
        localObject7 = paramIntent.getStringExtra("cmd");
        l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
        paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramIntent.order(ByteOrder.BIG_ENDIAN);
        i = paramIntent.getInt();
        localObject9 = new byte[i - 4];
        paramIntent.get((byte[])localObject9, 0, i - 4);
        if (paramFromServiceMsg.isSuccess())
        {
          WtloginMsfListener.onAsyncReceive((String)localObject5, (String)localObject7, l1, (byte[])localObject9);
          return;
        }
        WtloginMsfListener.onAsyncReceiveFail((String)localObject5, (String)localObject7, l1, paramFromServiceMsg.getBusinessFailCode());
        return;
        if (paramFromServiceMsg.isSuccess())
        {
          localObject5 = new UniPacket(true);
          ((UniPacket)localObject5).setEncodeName("utf-8");
          ((UniPacket)localObject5).decode(paramFromServiceMsg.getWupBuffer());
          localBundle.putSerializable("jce", (GetResourceRespV2)((UniPacket)localObject5).getByClass("GetResourceRespV2", new GetResourceRespV2()));
        }
        localBundle.putInt("iPluginType", paramIntent.getIntExtra("iPluginType", 64));
        notifyObserver(paramIntent, 1018, paramFromServiceMsg.isSuccess(), localBundle, ServerConfigObserver.class);
        return;
        paramIntent = paramFromServiceMsg.getUin();
        paramFromServiceMsg = (HashMap)paramFromServiceMsg.getAttributes().get("keyMap");
        if ((TextUtils.isEmpty(paramIntent)) || (getAppRuntime() == null) || (!paramIntent.equals(getAppRuntime().getAccount()))) {
          break;
        }
        ((TicketManager)getAppRuntime().getManager(2)).setAlterTicket(paramFromServiceMsg);
        return;
        localObject5 = paramFromServiceMsg.getUin();
        localObject7 = (byte[])paramFromServiceMsg.getAttributes().get("da2");
        localBundle.putString("account", (String)localObject5);
        localBundle.putString("da2", new String((byte[])localObject7));
        notifyObserver(paramIntent, 1046, paramFromServiceMsg.isSuccess(), localBundle, AccountObserver.class);
        return;
        localBundle.putString("msf_con_erro", (String)paramFromServiceMsg.getAttribute("msf_con_erro", ""));
        notifyObserver(paramIntent, 2201, paramFromServiceMsg.isSuccess(), localBundle, CheckConErroObserver.class);
        return;
        label5664:
        bool1 = true;
        continue;
        label5670:
        bool1 = true;
        paramFromServiceMsg = (FromServiceMsg)localObject5;
      }
      label5679:
      Object localObject5 = null;
      continue;
      label5685:
      localObject7 = null;
      break label333;
      label5691:
      localObject5 = null;
      break label310;
      label5697:
      i += 1;
    }
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
    Object localObject3;
    int j;
    int i;
    boolean bool;
    switch (paramIntent.getIntExtra("action", 0))
    {
    default: 
    case 1001: 
    case 2201: 
    case 1035: 
    case 2123: 
    case 1100: 
    case 2205: 
    case 2206: 
    case 2207: 
    case 1101: 
    case 1102: 
    case 1037: 
    case 1040: 
    case 1002: 
    case 1025: 
    case 1026: 
    case 1041: 
    case 1003: 
    case 1020: 
    case 1004: 
    case 1022: 
    case 1005: 
    case 1008: 
    case 1009: 
    case 1007: 
    case 1030: 
    case 2203: 
    case 1032: 
    case 1012: 
    case 1018: 
    case 1042: 
    case 1043: 
    case 1044: 
    case 2124: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getByteArrayExtra("password");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, (byte[])localObject2);; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, (byte[])localObject2))
                {
                  localObject2 = paramIntent.getByteArrayExtra("resp_register_supersig");
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  ((ToServiceMsg)localObject1).addAttribute("resp_register_supersig", localObject2);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = getAppRuntime().getService().msfSub.getCheckMsfConErroMsg();
                ((ToServiceMsg)localObject1).setTimeout(10000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("subaccount");
                localObject3 = paramIntent.getStringExtra("subpassword");
                localObject2 = paramIntent.getStringExtra("mainaccount");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
                  ((ToServiceMsg)localObject1).addAttribute("mainaccount", localObject2);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("uin");
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRefreshTicketsMsg((String)localObject1));
                return;
                localObject2 = paramIntent.getStringExtra("process");
                localObject1 = paramIntent.getStringExtra("ssoAccount");
                localObject3 = paramIntent.getStringExtra("ssoPassword");
                if (isQQUin((String)localObject1)) {}
                for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3));; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, MD5.toMD5Byte((String)localObject3)))
                {
                  ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                  ((ToServiceMsg)localObject1).setTimeout(40000L);
                  ((ToServiceMsg)localObject1).addAttribute("from_where", "ssoAccountAction");
                  ((ToServiceMsg)localObject1).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                  ((ToServiceMsg)localObject1).addAttribute("process", localObject2);
                  addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject1);
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                }
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getStringExtra("password");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdMsg((String)localObject1, MD5.toMD5Byte((String)localObject2));
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                ((ToServiceMsg)localObject1).setIsSupportRetry(true);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject2 = paramIntent.getStringExtra("verifyCode");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdImageMsg((String)localObject1, (String)localObject2);
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("account");
                localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdRefreshImageMsg((String)localObject1);
                ((ToServiceMsg)localObject1).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                return;
                localObject1 = paramIntent.getStringExtra("process");
                localObject3 = paramIntent.getStringExtra("ssoAccount");
                localObject2 = paramIntent.getStringExtra("from_where");
                localObject3 = getAppRuntime().getService().msfSub.getLoginWithoutPasswdMsg((String)localObject3);
                ((ToServiceMsg)localObject3).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
                ((ToServiceMsg)localObject3).addAttribute("process", localObject1);
                if ((localObject2 != null) && (((String)localObject2).length() > 0))
                {
                  ((ToServiceMsg)localObject3).addAttribute("from_where", localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("builtInservert", 2, "ACTION_GET_TICKET_NO_PASSWD from_where is no null");
                  }
                }
                addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject3);
                ((ToServiceMsg)localObject3).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject3);
                return;
                localObject4 = paramIntent.getStringExtra("ssoAccount");
                localObject1 = paramIntent.getByteArrayExtra("dstAppName");
                l1 = paramIntent.getLongExtra("dwDstSsoVer", 0L);
                long l2 = paramIntent.getLongExtra("dwDstAppid", 0L);
                long l3 = paramIntent.getLongExtra("dwSubDstAppid", 0L);
                localObject2 = paramIntent.getByteArrayExtra("dstAppVer");
                localObject3 = paramIntent.getByteArrayExtra("dstAppSign");
                localObject4 = getAppRuntime().getService().msfSub.getA1WithA1((String)localObject4);
                ((ToServiceMsg)localObject4).addAttribute("dstAppName", localObject1);
                ((ToServiceMsg)localObject4).addAttribute("dwDstSsoVer", Long.valueOf(l1));
                ((ToServiceMsg)localObject4).addAttribute("dwDstAppid", Long.valueOf(l2));
                ((ToServiceMsg)localObject4).addAttribute("dwSubDstAppid", Long.valueOf(l3));
                ((ToServiceMsg)localObject4).addAttribute("dstAppVer", localObject2);
                ((ToServiceMsg)localObject4).addAttribute("dstAppSign", localObject3);
                ((ToServiceMsg)localObject4).addAttribute("fastLoginInfo", new WFastLoginInfo());
                localObject1 = paramIntent.getStringExtra("process");
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((ToServiceMsg)localObject4).addAttribute("process", localObject1);
                }
                addOpenSdkExtra(paramIntent, (ToServiceMsg)localObject4);
                ((ToServiceMsg)localObject4).setTimeout(40000L);
                sendToMSF(paramIntent, (ToServiceMsg)localObject4);
                return;
                localObject2 = paramIntent.getStringExtra("subaccountuin");
                localObject1 = paramIntent.getStringExtra("mainaccount");
                localObject2 = getAppRuntime().getService().msfSub.getKeyMsg((String)localObject2);
                ((ToServiceMsg)localObject2).setTimeout(10000L);
                ((ToServiceMsg)localObject2).addAttribute("from_where", "subaccount");
                ((ToServiceMsg)localObject2).addAttribute("mainaccount", localObject1);
                sendToMSF(paramIntent, (ToServiceMsg)localObject2);
                return;
                localObject1 = new CommandCallbackerInfo();
                ((CommandCallbackerInfo)localObject1).uin = getAppRuntime().getAccount();
                localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                localObject3 = new ArrayList();
                j = localObject2.length;
                i = 0;
                while (i < j)
                {
                  ((ArrayList)localObject3).add(localObject2[i]);
                  i += 1;
                }
                ((CommandCallbackerInfo)localObject1).cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                return;
                if (!this.isRegist)
                {
                  localObject1 = new CommandCallbackerInfo();
                  ((CommandCallbackerInfo)localObject1).uin = getAppRuntime().getAccount();
                  localObject2 = paramIntent.getStringArrayExtra("pushCommands");
                  localObject3 = new ArrayList();
                  j = localObject2.length;
                  i = 0;
                  while (i < j)
                  {
                    ((ArrayList)localObject3).add(localObject2[i]);
                    i += 1;
                  }
                  ((CommandCallbackerInfo)localObject1).cmds = ((ArrayList)localObject3);
                  sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCmdCallMsg((CommandCallbackerInfo)localObject1));
                  this.isRegist = true;
                }
                localObject2 = new PushRegisterInfo();
                if (paramIntent.getBooleanExtra("kick", false))
                {
                  b = 1;
                  ((PushRegisterInfo)localObject2).bKikPC = b;
                  ((PushRegisterInfo)localObject2).bKikWeak = 0;
                  localObject3 = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
                  bool = paramIntent.getBooleanExtra("isUserSet", false);
                  ((PushRegisterInfo)localObject2).iStatus = ((AppRuntime.Status)localObject3).getValue();
                  l1 = paramIntent.getLongExtra("extOnlineStatus", -1L);
                  ((PushRegisterInfo)localObject2).extStatus = l1;
                  if ((localObject3 == AppRuntime.Status.online) && (l1 == 1000L))
                  {
                    ((PushRegisterInfo)localObject2).batteryCapacity = paramIntent.getIntExtra("batteryCapacity", 0);
                    ((PushRegisterInfo)localObject2).powerConnect = paramIntent.getIntExtra("powerConnect", -1);
                  }
                  localObject1 = new ArrayList();
                  ((ArrayList)localObject1).add(Long.valueOf(1L));
                  ((ArrayList)localObject1).add(Long.valueOf(2L));
                  ((ArrayList)localObject1).add(Long.valueOf(4L));
                  ((PushRegisterInfo)localObject2).pushIds = ((ArrayList)localObject1);
                  ((PushRegisterInfo)localObject2).timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                  ((PushRegisterInfo)localObject2).iLargeSeq = paramIntent.getLongExtra("K_SEQ", 0L);
                  ((PushRegisterInfo)localObject2).uin = getAppRuntime().getAccount();
                  if (localObject3 != AppRuntime.Status.offline) {
                    break label1970;
                  }
                  localObject1 = getAppRuntime().getService().msfSub.getUnRegisterPushMsg((PushRegisterInfo)localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.contacts.", 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + localObject3 + ", " + ((PushRegisterInfo)localObject2).timeStamp + ", " + ((PushRegisterInfo)localObject2).iLargeSeq + ", isUserSet: " + bool);
                  }
                  if (!bool) {
                    break label1990;
                  }
                  ((ToServiceMsg)localObject1).getAttributes().put("regPushReason", RegPushReason.setOnlineStatus);
                }
                for (;;)
                {
                  sendToMSF(paramIntent, (ToServiceMsg)localObject1);
                  return;
                  b = 0;
                  break;
                  localObject1 = getAppRuntime().getService().msfSub.getRegisterPushMsg((PushRegisterInfo)localObject2);
                  break label1864;
                  ((ToServiceMsg)localObject1).getAttributes().put("regPushReason", RegPushReason.appRegister);
                }
                j = paramIntent.getIntExtra("appid", 0);
                localObject1 = paramIntent.getStringExtra("processName");
                localObject2 = paramIntent.getStringExtra("broadcastName");
                localObject4 = paramIntent.getStringArrayExtra("commands");
                localObject3 = new ArrayList();
                int k = localObject4.length;
                i = 0;
                while (i < k)
                {
                  ((ArrayList)localObject3).add(localObject4[i]);
                  i += 1;
                }
                localObject4 = new NotifyRegisterInfo();
                ((NotifyRegisterInfo)localObject4).uin = getAppRuntime().getAccount();
                ((NotifyRegisterInfo)localObject4).notifyIds = new ArrayList();
                ((NotifyRegisterInfo)localObject4).notifyProperties = new HashMap();
                localObject5 = new CommandCallbackerInfo();
                ((CommandCallbackerInfo)localObject5).uin = getAppRuntime().getAccount();
                ((CommandCallbackerInfo)localObject5).cmds = ((ArrayList)localObject3);
                sendToMSF(paramIntent, MsfServiceSdk.get().getRegisterProxyMsg(j, getAppRuntime().getAccount(), (String)localObject1, (String)localObject2, (NotifyRegisterInfo)localObject4, (CommandCallbackerInfo)localObject5));
                return;
                i = paramIntent.getIntExtra("appid", 0);
                sendToMSF(paramIntent, MsfServiceSdk.get().getUnRegisterProxyMsg(i, getAppRuntime().getAccount(), paramIntent.getStringExtra("processName")));
                return;
                localObject1 = paramIntent.getStringExtra("countryCode");
                localObject2 = paramIntent.getStringExtra("phoneNumber");
                localObject1 = (String)localObject1 + "-" + (String)localObject2;
                sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegQueryAccountMsg((String)localObject1));
              } while (!QLog.isColorLevel());
              QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount");
              return;
              localObject1 = paramIntent.getStringExtra("countryCode");
              localObject2 = paramIntent.getStringExtra("phoneNumber");
              Object localObject5 = paramIntent.getStringExtra("inviteCode");
              long l1 = paramIntent.getLongExtra("appid", 0L);
              Object localObject4 = paramIntent.getStringExtra("verifySig");
              String str1 = (String)localObject1 + "-" + (String)localObject2;
              String str2 = paramIntent.getStringExtra("appVersion");
              byte b = paramIntent.getByteExtra("language", (byte)2);
              localObject1 = paramIntent.getStringExtra("wifi_mac");
              localObject3 = paramIntent.getStringExtra("os_language");
              i = paramIntent.getIntExtra("qq_language", 0);
              localObject2 = paramIntent.getStringExtra("gps_location");
              localObject4 = getAppRuntime().getService().msfSub.getRegisterCommitMobileMsg((String)localObject4, (byte)0, b, (byte)0, "", str2, str1, Long.valueOf(l1));
              if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                ((ToServiceMsg)localObject4).getAttributes().put("To_register_Invitation_code", localObject5);
              }
              localObject5 = ((ToServiceMsg)localObject4).getAttributes();
              if (localObject1 == null)
              {
                localObject1 = "";
                ((HashMap)localObject5).put("wifi_mac", localObject1);
                localObject5 = ((ToServiceMsg)localObject4).getAttributes();
                if (localObject3 != null) {
                  break label2594;
                }
                localObject1 = "";
                ((HashMap)localObject5).put("os_language", localObject1);
                ((ToServiceMsg)localObject4).getAttributes().put("qq_language", Integer.valueOf(i));
                localObject3 = ((ToServiceMsg)localObject4).getAttributes();
                if (localObject2 != null) {
                  break label2601;
                }
              }
              for (localObject1 = "";; localObject1 = localObject2)
              {
                ((HashMap)localObject3).put("gps_location", localObject1);
                sendToMSF(paramIntent, (ToServiceMsg)localObject4);
                return;
                break;
                localObject1 = localObject3;
                break label2529;
              }
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterSendReSendSmsMsg());
              return;
              localObject1 = paramIntent.getStringExtra("code");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitSmsCodeMsg((String)localObject1));
              return;
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterQueryUpSmsStatMsg());
              return;
              localObject1 = paramIntent.getStringExtra("password");
              localObject2 = paramIntent.getStringExtra("nick");
              localObject3 = paramIntent.getStringExtra("code");
              bool = true;
              if (paramIntent.hasExtra("bindMobile")) {
                bool = paramIntent.getBooleanExtra("bindMobile", true);
              }
              localObject4 = paramIntent.getStringExtra("lhuin");
              localObject5 = paramIntent.getStringExtra("unBindlhUin");
              str1 = paramIntent.getStringExtra("appVersion");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitPassMsg((String)localObject3, (String)localObject1, (String)localObject2, bool, (String)localObject4, (String)localObject5, str1));
              return;
              localObject1 = paramIntent.getStringExtra("account");
              i = paramIntent.getIntExtra("appid", 0);
              localObject2 = paramIntent.getStringExtra("appVersion");
              localObject2 = getAppRuntime().getService().msfSub.checkQuickRegisterAccount((String)localObject1, i, (byte)2, (String)localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + (String)localObject1);
              }
              sendToMSF(paramIntent, (ToServiceMsg)localObject2);
              return;
              localObject1 = paramIntent.getStringExtra("account");
              localObject3 = paramIntent.getStringExtra("password");
              localObject2 = paramIntent.getStringExtra("nick");
              i = paramIntent.getIntExtra("appid", 0);
              localObject4 = paramIntent.getStringExtra("appVersion");
              localObject3 = getAppRuntime().getService().msfSub.getQuickRegisterAccount((String)localObject1, (String)localObject3, (String)localObject2, i, (byte)2, (String)localObject4);
              if (QLog.isColorLevel()) {
                QLog.d("Login_Optimize_", 2, "builtInServlet: curAccount=" + (String)localObject1 + ",nick=" + (String)localObject2);
              }
              sendToMSF(paramIntent, (ToServiceMsg)localObject3);
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              localObject2 = paramIntent.getStringExtra("alias");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getDelLoginedAccount(getAppRuntime().getAccount(), (String)localObject1, (String)localObject2));
              return;
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getKeyMsg(getAppRuntime().getAccount()));
              return;
              localObject1 = paramIntent.getStringExtra("uin");
              localObject2 = paramIntent.getStringExtra("cmd");
              localObject3 = paramIntent.getByteArrayExtra("busBuf");
              i = paramIntent.getIntExtra("timeout", 30000);
              l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getSendWtPkgMsg((String)localObject1, l1, (String)localObject2, (byte[])localObject3, i));
              return;
              localObject1 = (HashMap)paramIntent.getSerializableExtra("mapSt");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getChangeTokenAfterLoginMsg(getAppRuntime().getAccount(), 9, (HashMap)localObject1));
              return;
              b = paramIntent.getByteExtra("type", (byte)0);
              localObject1 = paramIntent.getStringExtra("content");
              sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getReportMsg(b, (String)localObject1));
              return;
              localObject1 = getAppRuntime().getService().msfSub.getPluginConfigMsg(getAppRuntime().getAccount());
              ((ToServiceMsg)localObject1).putWupBuffer(paramIntent.getByteArrayExtra("buffer"));
              ((ToServiceMsg)localObject1).setTimeout(10000L);
              sendToMSF(paramIntent, (ToServiceMsg)localObject1);
              return;
              i = paramIntent.getIntExtra("value", 1);
              localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "Msf.NetException");
              ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand._msf_NetException);
              ((ToServiceMsg)localObject1).addAttribute("NetExceptionType", Integer.valueOf(i));
              ((ToServiceMsg)localObject1).setNeedCallback(false);
            } while (localObject1 == null);
            if (QLog.isColorLevel()) {
              QLog.d("MSFServlet", 2, "ACTION_NET_EXCEPTION_EVENT send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
            }
            sendToMSF(paramIntent, (ToServiceMsg)localObject1);
            return;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSFServlet", 4, "WIRELESS_PSWREQ:");
            }
            i = paramIntent.getIntExtra("cmd", 1);
            localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "KsidTrans.Trans");
            ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_PSWREQ);
            ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
            ((ToServiceMsg)localObject1).setNeedCallback(false);
          } while (localObject1 == null);
          if (QLog.isColorLevel()) {
            QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_PSWREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
          }
          sendToMSF(paramIntent, (ToServiceMsg)localObject1);
          return;
          i = paramIntent.getIntExtra("cmd", 1);
          localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), getAppRuntime().getAccount(), "PwdProtect.DataUpload");
          ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.SEND_WIRELESS_MEIBAOREQ);
          ((ToServiceMsg)localObject1).addAttribute("cmd", Integer.valueOf(i));
          ((ToServiceMsg)localObject1).setNeedCallback(false);
        } while (localObject1 == null);
        if (QLog.isColorLevel()) {
          QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
        }
        sendToMSF(paramIntent, (ToServiceMsg)localObject1);
        return;
        localObject1 = paramIntent.getStringExtra("uin");
        localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "");
        ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.getAlterTickets);
        ((ToServiceMsg)localObject1).setNeedCallback(true);
      } while (localObject1 == null);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2200: 
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_UNGUARD_APP send now");
      }
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), null, "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.gm_GuardEvent);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      ((ToServiceMsg)localObject1).addAttribute("k_event", Integer.valueOf(paramIntent.getIntExtra("k_event", 0)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg0", Long.valueOf(paramIntent.getLongExtra("k_arg0", 0L)));
      ((ToServiceMsg)localObject1).addAttribute("k_arg1", Long.valueOf(paramIntent.getLongExtra("k_arg1", 0L)));
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2126: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.startPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2127: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.stopPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2128: 
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      bool = paramIntent.getBooleanExtra("opened", false);
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.openPCActive);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).getAttributes().put("opened", Boolean.valueOf(bool));
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
    case 2202: 
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_msgsignal);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 1046: 
      localObject1 = paramIntent.getStringExtra("account");
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "login.chgTok_DA2");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_refreshDA2);
      ((ToServiceMsg)localObject1).setNeedCallback(true);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2204: 
      localObject1 = paramIntent.getStringExtra("longitude");
      localObject2 = paramIntent.getStringExtra("latitude");
      localObject3 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand.msf_save_geoginfo);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_lontitude", localObject1);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_latitude", localObject2);
      ((ToServiceMsg)localObject3).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject3);
      return;
    case 2210: 
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      i = paramIntent.getIntExtra("opType", 0);
      j = paramIntent.getIntExtra("manualLogLevel", 2);
      ((ToServiceMsg)localObject1).getAttributes().put("opType", Integer.valueOf(i));
      ((ToServiceMsg)localObject1).getAttributes().put("manualLogLevel", Integer.valueOf(j));
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_manual_set_log_level);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    case 2212: 
      label1864:
      label2529:
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      label1970:
      label1990:
      i = paramIntent.getIntExtra("localeId", 0);
      label2594:
      label2601:
      ((ToServiceMsg)localObject1).getAttributes().put("localeId", Integer.valueOf(i));
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_update_locale_id);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    }
    Object localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "cmd_update_manager_config");
    ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msfUpdateManagerConfig);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    ((ToServiceMsg)localObject1).setNeedCallback(false);
    Object localObject2 = paramIntent.getStringExtra("manager_config");
    ((ToServiceMsg)localObject1).getAttributes().put("manager_config", localObject2);
    sendToMSF(paramIntent, (ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.BuiltInServlet
 * JD-Core Version:    0.7.0.1
 */