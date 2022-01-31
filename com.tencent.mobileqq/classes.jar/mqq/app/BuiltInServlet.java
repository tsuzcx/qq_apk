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
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import protocol.KQQConfig.GetResourceRespV2;

public class BuiltInServlet
  extends MSFServlet
  implements Constants.Action
{
  private boolean isRegist;
  
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
    Object localObject7 = new Bundle();
    Object localObject8;
    Object localObject9;
    int j;
    Object localObject1;
    label310:
    Object localObject5;
    label333:
    Object localObject10;
    label906:
    long l3;
    long l1;
    long l2;
    Object localObject6;
    switch (i)
    {
    default: 
      return;
    case 2205: 
      localObject8 = paramFromServiceMsg.getUin();
      i = paramFromServiceMsg.getBusinessFailCode();
      localObject9 = paramFromServiceMsg.getBusinessFailMsg();
      j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
      if (paramFromServiceMsg.getAttributes().containsKey("resp_verify_image"))
      {
        localObject1 = (byte[])paramFromServiceMsg.getAttribute("resp_verify_image");
        if (paramFromServiceMsg.getAttributes().containsKey("resp_verify_msg"))
        {
          localObject5 = (String)paramFromServiceMsg.getAttribute("resp_verify_msg");
          ((Bundle)localObject7).putString("uin", (String)localObject8);
          ((Bundle)localObject7).putInt("resultCode", i);
          ((Bundle)localObject7).putString("errorMsg", (String)localObject9);
          ((Bundle)localObject7).putInt("ret", j);
          ((Bundle)localObject7).putString("notice", (String)localObject5);
          ((Bundle)localObject7).putByteArray("image", (byte[])localObject1);
          notifyObserver(paramIntent, 2205, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
      }
      break;
    case 2206: 
      localObject5 = paramFromServiceMsg.getUin();
      i = paramFromServiceMsg.getBusinessFailCode();
      localObject8 = paramFromServiceMsg.getBusinessFailMsg();
      localObject9 = (String)paramFromServiceMsg.getAttribute("userAccount");
      localObject10 = (byte[])paramFromServiceMsg.getAttribute("userInput");
      j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
      ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
      localObject1 = null;
      if (paramFromServiceMsg.getAttributes().containsKey("image_buf")) {
        localObject1 = (byte[])paramFromServiceMsg.getAttribute("image_buf");
      }
      ((Bundle)localObject7).putString("uin", (String)localObject5);
      ((Bundle)localObject7).putInt("resultCode", i);
      ((Bundle)localObject7).putString("errorMsg", (String)localObject8);
      ((Bundle)localObject7).putString("userAccount", (String)localObject9);
      ((Bundle)localObject7).putByteArray("userInput", (byte[])localObject10);
      ((Bundle)localObject7).putInt("ret", j);
      ((Bundle)localObject7).putParcelable("lastError", localErrMsg);
      ((Bundle)localObject7).putByteArray("image", (byte[])localObject1);
      notifyObserver(paramIntent, 2206, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
      return;
    case 2207: 
      localObject1 = paramFromServiceMsg.getUin();
      i = paramFromServiceMsg.getBusinessFailCode();
      localObject5 = paramFromServiceMsg.getBusinessFailMsg();
      localObject8 = (String)paramFromServiceMsg.getAttribute("userAccount");
      localObject9 = (byte[])paramFromServiceMsg.getAttribute("pictureData");
      j = ((Integer)paramFromServiceMsg.getAttribute("ret")).intValue();
      localObject10 = (ErrMsg)paramFromServiceMsg.getAttribute("lastError");
      ((Bundle)localObject7).putString("uin", (String)localObject1);
      ((Bundle)localObject7).putInt("resultCode", i);
      ((Bundle)localObject7).putString("errorMsg", (String)localObject5);
      ((Bundle)localObject7).putString("userAccount", (String)localObject8);
      ((Bundle)localObject7).putByteArray("pictureData", (byte[])localObject9);
      ((Bundle)localObject7).putInt("ret", j);
      ((Bundle)localObject7).putParcelable("lastError", (Parcelable)localObject10);
      notifyObserver(paramIntent, 2207, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
      return;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      ((Bundle)localObject7).putString("uin", paramFromServiceMsg.getUin());
      ((Bundle)localObject7).putString("alias", paramIntent.getStringExtra("account"));
      ((Bundle)localObject7).putString("error", paramFromServiceMsg.getBusinessFailMsg());
      localObject8 = paramFromServiceMsg.getAttribute("resp_login_url");
      localObject5 = "";
      localObject1 = localObject5;
      if (localObject8 != null)
      {
        localObject1 = localObject5;
        if ((localObject8 instanceof String)) {
          localObject1 = (String)localObject8;
        }
      }
      localObject5 = paramFromServiceMsg.getAttribute("resp_logini_ret");
      j = 0;
      i = j;
      if (localObject5 != null)
      {
        i = j;
        if ((localObject5 instanceof Integer)) {
          i = ((Integer)localObject5).intValue();
        }
      }
      localObject5 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
      if ((localObject5 != null) && ((localObject5 instanceof byte[])))
      {
        localObject5 = (byte[])localObject5;
        ((Bundle)localObject7).putString("errorurl", (String)localObject1);
        ((Bundle)localObject7).putInt("loginret", i);
        ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
        ((Bundle)localObject7).putByteArray("lhsig", (byte[])localObject5);
        if (paramFromServiceMsg.isSuccess())
        {
          MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
          localObject1 = paramIntent.getStringExtra("account");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
          }
        }
        for (;;)
        {
          getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          notifyObserver(paramIntent, 1001, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("BuiltInServlet", 2, "login in back from msf build servlets end");
          return;
          MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
        }
      }
      break;
    case 1035: 
      if (QLog.isColorLevel()) {
        QLog.d("BuiltInServlet", 2, "sub account login in back from msf build servlets start");
      }
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      ((Bundle)localObject7).putString("uin", paramFromServiceMsg.getUin());
      ((Bundle)localObject7).putString("alias", paramIntent.getStringExtra("subaccount"));
      ((Bundle)localObject7).putString("error", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addLoginSimpleAccount(paramFromServiceMsg.getUin(), true);
        localObject1 = paramIntent.getStringExtra("subaccount");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
        }
      }
      for (;;)
      {
        localObject1 = (String)paramFromServiceMsg.getAttribute("mainaccount");
        ((Bundle)localObject7).putString("submainaccount", (String)localObject1);
        localObject5 = getAppRuntime().getApplication().getFirstSimpleAccount();
        l3 = System.currentTimeMillis();
        l1 = l3;
        if (localObject5 != null) {
          l2 = l3;
        }
        try
        {
          long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject5).getUin() + Constants.Key._logintime));
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
        catch (Exception localException11)
        {
          for (;;)
          {
            localException11.printStackTrace();
            l1 = l2;
          }
        }
        if (paramFromServiceMsg.getUin() != null) {
          getAppRuntime().getApplication().setProperty(paramFromServiceMsg.getUin() + Constants.Key._logintime, String.valueOf(l1));
        }
        if (localObject1 != null) {
          getAppRuntime().getApplication().setProperty((String)localObject1 + Constants.Key._logintime, String.valueOf(l1 + 1L));
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "builtInservice onreceiver ACTION_SUBACCOUNT_LOGIN");
        }
        notifyObserver(paramIntent, 1035, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, SubAccountObserver.class);
        return;
        MsfSdkUtils.updateSimpleAccountNotCreate(paramFromServiceMsg.getUin(), false);
      }
    case 1100: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_account...");
      }
      ((Bundle)localObject7).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      ((Bundle)localObject7).putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
      if (paramFromServiceMsg.isSuccess())
      {
        ((Bundle)localObject7).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        ((Bundle)localObject7).putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        ((Bundle)localObject7).putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        ((Bundle)localObject7).putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        ((Bundle)localObject7).putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
        ((Bundle)localObject7).putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1100, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, SSOAccountObserver.class);
        if (paramFromServiceMsg.getResultCode() != 1013) {
          break;
        }
        report(paramFromServiceMsg.getUin(), false, "ssoLoginAppTimeout", 0L, 0L, null, true);
        return;
        ((Bundle)localObject7).putInt("ret", -1);
      }
    case 1101: 
      if (QLog.isColorLevel()) {
        QLog.d("onReceive", 2, "builtInServlet action_sso_login_no_passwd...");
      }
      ((Bundle)localObject7).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        ((Bundle)localObject7).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
        ((Bundle)localObject7).putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        ((Bundle)localObject7).putParcelable("lastError", (Parcelable)paramFromServiceMsg.getAttribute("lastError"));
        ((Bundle)localObject7).putInt("targetTicket", paramIntent.getIntExtra("targetTicket", 4096));
        ((Bundle)localObject7).putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
        ((Bundle)localObject7).putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      }
      ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject7).putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        ((Bundle)localObject7).putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        ((Bundle)localObject7).putString("error", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, 1101, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, SSOAccountObserver.class);
        return;
        ((Bundle)localObject7).putInt("ret", -1);
      }
    case 1102: 
      ((Bundle)localObject7).putString("ssoAccount", (String)paramFromServiceMsg.getAttribute("userAccount"));
      if (paramFromServiceMsg.isSuccess())
      {
        localObject1 = paramFromServiceMsg.getAttribute("dwSrcAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          ((Bundle)localObject7).putLong("dwSrcAppid", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwMainSigMap");
        if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
          ((Bundle)localObject7).putInt("dwMainSigMap", ((Integer)localObject1).intValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwSubSrcAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          ((Bundle)localObject7).putLong("dwSubSrcAppid", ((Long)localObject1).longValue());
        }
        ((Bundle)localObject7).putByteArray("dstAppName", (byte[])paramFromServiceMsg.getAttribute("dstAppName"));
        localObject1 = paramFromServiceMsg.getAttribute("dwDstSsoVer");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          ((Bundle)localObject7).putLong("dwDstSsoVer", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwDstAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          ((Bundle)localObject7).putLong("dwDstAppid", ((Long)localObject1).longValue());
        }
        localObject1 = paramFromServiceMsg.getAttribute("dwSubDstAppid");
        if ((localObject1 != null) && ((localObject1 instanceof Long))) {
          ((Bundle)localObject7).putLong("dwSubDstAppid", ((Long)localObject1).longValue());
        }
        ((Bundle)localObject7).putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.getAttribute("userSigInfo"));
        ((Bundle)localObject7).putParcelable("fastLoginInfo", (Parcelable)paramFromServiceMsg.getAttribute("fastLoginInfo"));
        ((Bundle)localObject7).putByteArray("dstAppVer", (byte[])paramFromServiceMsg.getAttribute("dstAppVer"));
        ((Bundle)localObject7).putByteArray("dstAppSign", (byte[])paramFromServiceMsg.getAttribute("dstAppSign"));
        ((Bundle)localObject7).putByteArray("wtTicket", (byte[])paramFromServiceMsg.getAttribute("wtTicket"));
      }
      ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject7).putParcelable("errMsg", (Parcelable)paramFromServiceMsg.getAttribute("errMsg"));
      localObject1 = paramFromServiceMsg.getAttribute("ret");
      if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
        ((Bundle)localObject7).putInt("ret", ((Integer)localObject1).intValue());
      }
      for (;;)
      {
        notifyObserver(paramIntent, 1102, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, SSOAccountObserver.class);
        return;
        ((Bundle)localObject7).putInt("ret", -1);
      }
    case 1037: 
      localObject9 = (String)paramFromServiceMsg.getAttribute("MSF.getKey");
      localObject8 = paramFromServiceMsg.getUin();
      localObject6 = null;
      localObject1 = localObject6;
      if (localObject9 != null)
      {
        localObject1 = ((String)localObject9).split(";");
        if (localObject1 == null) {
          break label5550;
        }
      }
      break;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (localObject1.length <= 0) {
          break label5550;
        }
        i = 0;
        if (i >= localObject1.length) {
          break label5550;
        }
        localObject9 = localObject1[i];
        if ((localObject9 == null) || (((String)localObject9).length() == 0) || (!((String)localObject9).startsWith("UIN=" + (String)localObject8 + ","))) {
          break label5574;
        }
        j = ((String)localObject9).indexOf("A2=");
        if (j < 0) {
          break label5574;
        }
        localObject9 = ((String)localObject9).substring(j);
        if ((localObject9 == null) || (((String)localObject9).length() == 0)) {
          break label5574;
        }
        localObject9 = ((String)localObject9).split(",");
        if ((localObject9 == null) || (localObject9.length <= 0) || (localObject9[0] == null) || (localObject9[0].length() <= "A2=".length() + 1)) {
          break label5574;
        }
        localObject1 = localObject9[0].substring("A2=".length());
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject2 = localObject6;
        continue;
      }
      ((Bundle)localObject7).putString("uin", (String)localObject8);
      ((Bundle)localObject7).putString("error", paramFromServiceMsg.getBusinessFailMsg());
      ((Bundle)localObject7).putInt("code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject7).putString("subaccountA2", (String)localObject1);
      ((Bundle)localObject7).putString("mainaccount", (String)paramFromServiceMsg.getAttribute("mainaccount"));
      notifyObserver(paramIntent, 1037, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, SubAccountObserver.class);
      return;
      notifyObserver(paramIntent, 1040, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
      return;
      if ((!"push.register".equals(paramFromServiceMsg.getServiceCmd())) && (!"push.unRegister".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      getAppRuntime().getOnlineStatus();
      l1 = 0L;
      boolean bool2;
      label2935:
      boolean bool3;
      label2947:
      label3058:
      boolean bool1;
      if (paramFromServiceMsg.isSuccess()) {
        if ("push.register".equals(paramFromServiceMsg.getServiceCmd())) {
          if ((paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
          {
            localObject6 = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
            if ((localObject6 != null) && (((SvcRespRegister)localObject6).cReplyCode == 0)) {
              if (((SvcRespRegister)localObject6).bUpdateFlag == 1)
              {
                bool2 = true;
                if (((SvcRespRegister)localObject6).bLargeSeqUpdate != 1) {
                  break label3434;
                }
                bool3 = true;
                i = ((SvcRespRegister)localObject6).iStatus;
                l1 = ((SvcRespRegister)localObject6).timeStamp;
                localObject2 = AppRuntime.Status.build(i);
                l2 = ((SvcRespRegister)localObject6).uExtOnlineStatus;
                if (localObject2 != null) {
                  break label5541;
                }
                QLog.d("mqq", 1, String.format("invalid iStatus: %s", new Object[] { Integer.valueOf(i) }));
                if (!paramFromServiceMsg.attributes.containsKey("attr_online_status")) {
                  break label3440;
                }
                i = ((Integer)paramFromServiceMsg.getAttribute("attr_online_status")).intValue();
                paramFromServiceMsg = AppRuntime.Status.build(i);
                QLog.d("mqq", 1, String.format("update iStatus: %s", new Object[] { Integer.valueOf(i) }));
                if (paramFromServiceMsg != null) {
                  break label5535;
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
        l3 = l2;
        boolean bool4 = bool3;
        bool3 = bool2;
        l2 = l1;
        bool2 = bool4;
        l1 = l3;
        for (;;)
        {
          bool4 = paramIntent.getBooleanExtra("isUserSet", false);
          localObject2 = getAppRuntime().getOnlineStatus();
          l3 = getAppRuntime().getExtOnlineStatus();
          getAppRuntime().setOnlineStatus(paramFromServiceMsg);
          if (l1 != -1L) {
            getAppRuntime().setExtOnlineStatus(l1);
          }
          ((Bundle)localObject7).putSerializable("onlineStatus", paramFromServiceMsg);
          ((Bundle)localObject7).putLong("extOnlineStatus", l1);
          ((Bundle)localObject7).putBoolean("isChanged", bool3);
          ((Bundle)localObject7).putLong("timeStamp", l2);
          ((Bundle)localObject7).putBoolean("isLargeChanged", bool2);
          ((Bundle)localObject7).putBoolean("isUserSet", bool4);
          notifyObserver(paramIntent, 1002, bool1, (Bundle)localObject7, AccountObserver.class);
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, String.format("register.push, isSuc = %s, onlineStatus = %s, isUserSet = %s, isChanged = %s, timeStamp = %s, isLargeChanged = %s, iStatus = %s, extStatus = %s", new Object[] { Boolean.valueOf(bool1), paramFromServiceMsg, Boolean.valueOf(bool4), Boolean.valueOf(bool3), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(i), Long.valueOf(l1) }));
          }
          if ((paramFromServiceMsg != AppRuntime.Status.online) || (l1 != 1000L) || ((localObject2 == paramFromServiceMsg) && (l3 == l1))) {
            break;
          }
          l2 = getAppRuntime().getApplication().getSharedPreferences(getAppRuntime().getAccount(), 0).getInt("GetFrdListReq_seq", 0);
          getAppRuntime().sendOnlineStatusWithExt(paramFromServiceMsg, false, l2, false, l1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("mqq", 2, new Object[] { "register reset battery status largeSeq:", Long.valueOf(l2) });
          return;
          bool2 = false;
          break label2935;
          label3434:
          bool3 = false;
          break label2947;
          label3440:
          QLog.d("mqq", 1, String.format("don't containsKey attr_online_status", new Object[0]));
          paramFromServiceMsg = (FromServiceMsg)localObject2;
          break label3058;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          if (localObject6 == null) {}
          for (bool1 = true;; bool1 = false)
          {
            QLog.d("mqq", 1, String.format("register.push resp is null [%s], cReplyCode: [%s]", new Object[] { Boolean.valueOf(bool1), Byte.valueOf(((SvcRespRegister)localObject6).cReplyCode) }));
            i = 0;
            bool3 = false;
            bool1 = false;
            bool2 = false;
            l2 = -1L;
            break;
          }
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
          QLog.d("mqq", 1, "register.push return empty packet! status: " + paramFromServiceMsg);
          bool2 = false;
          bool3 = false;
          i = 0;
          bool1 = true;
          l2 = 0L;
          l1 = -1L;
          continue;
          paramFromServiceMsg = AppRuntime.Status.offline;
          bool2 = false;
          bool3 = false;
          i = 0;
          bool1 = true;
          l2 = 0L;
          l1 = -1L;
          continue;
          paramFromServiceMsg = (AppRuntime.Status)paramIntent.getSerializableExtra("old");
          QLog.d("mqq", 1, "register.push fail!");
          bool2 = false;
          bool3 = false;
          i = 0;
          bool1 = false;
          l2 = 0L;
          l1 = -1L;
        }
        ((Bundle)localObject7).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject7).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          if (QLog.isColorLevel()) {
            QLog.d("queryMobile", 2, "BuiltInServlet.startQueryAccount callback");
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte1 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
            ((Bundle)localObject7).putInt("code", j);
            ((Bundle)localObject7).putByteArray("mobile", arrayOfByte1);
            if (paramIntent.hasExtra("inviteCode")) {
              ((Bundle)localObject7).putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
            }
            notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
            return;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            continue;
          }
          if (paramFromServiceMsg.getBusinessFailCode() == 3001)
          {
            Object localObject3 = paramFromServiceMsg.getBusinessFailMsg();
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              try
              {
                j = Integer.valueOf((String)localObject3).intValue();
                localObject3 = (byte[])paramFromServiceMsg.getAttribute("to_register_cr_mobile", new byte[0]);
                ((Bundle)localObject7).putInt("code", j);
                ((Bundle)localObject7).putByteArray("mobile", (byte[])localObject3);
                if (paramIntent.hasExtra("inviteCode")) {
                  ((Bundle)localObject7).putString("inviteCode", paramIntent.getStringExtra("inviteCode"));
                }
              }
              catch (Exception localException4)
              {
                localException4.printStackTrace();
              }
            }
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        int k;
        int m;
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          ((Bundle)localObject7).putInt("code", j);
          ((Bundle)localObject7).putInt("next_chk_time", k);
          ((Bundle)localObject7).putInt("total_time_over", m);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
        catch (Exception localException5)
        {
          for (;;)
          {
            localException5.printStackTrace();
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject7).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          String str1 = (String)paramFromServiceMsg.getAttribute("bind_qq_uin");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject7).putString("bind_qq_uin", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_nick");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject7).putString("bind_qq_nick", str1);
          }
          str1 = (String)paramFromServiceMsg.getAttribute("resp_verify_account_faceUrl");
          if (!TextUtils.isEmpty(str1)) {
            ((Bundle)localObject7).putString("bind_qq_face_url", str1);
          }
        }
        catch (Exception localException6)
        {
          for (;;)
          {
            localException6.printStackTrace();
          }
        }
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
        return;
        ((Bundle)localObject7).putByteArray("promptInfo", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          k = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shNextResendTime", Integer.valueOf(-1))).intValue();
          m = ((Integer)paramFromServiceMsg.getAttribute("resp_register_shTotalTimeOver", Integer.valueOf(-1))).intValue();
          String str2 = (String)paramFromServiceMsg.getAttribute("res_register_errmsg", "");
          localObject6 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject8 = (String)paramFromServiceMsg.getAttribute("resp_register_nick", "");
          localObject9 = (String)paramFromServiceMsg.getAttribute("resp_register_picture_url", "");
          ((Bundle)localObject7).putInt("code", j);
          ((Bundle)localObject7).putInt("next_chk_time", k);
          ((Bundle)localObject7).putInt("total_time_over", m);
          ((Bundle)localObject7).putString("errmsg", str2);
          ((Bundle)localObject7).putString("uin", (String)localObject6);
          ((Bundle)localObject7).putString("nick", (String)localObject8);
          ((Bundle)localObject7).putString("faceUrl", (String)localObject9);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
        catch (Exception localException7)
        {
          for (;;)
          {
            localException7.printStackTrace();
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        for (;;)
        {
          try
          {
            j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
            byte[] arrayOfByte2 = (byte[])paramFromServiceMsg.getAttribute("resp_register_contactssig", new byte[0]);
            localObject6 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
            localObject8 = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
            if ((localObject8 != null) && (localObject8.length > 0))
            {
              ((Bundle)localObject7).putByteArray("lhsig", (byte[])localObject8);
              if (QLog.isColorLevel()) {
                QLog.d("wtLogin_LiangHao", 2, "builtInServlet|LiangHao_lhsig= " + new String((byte[])localObject8));
              }
            }
            ((Bundle)localObject7).putInt("code", j);
            ((Bundle)localObject7).putByteArray("promptInfo", arrayOfByte2);
            ((Bundle)localObject7).putString("uin", (String)localObject6);
            if (QLog.isColorLevel()) {
              QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive code= " + j + ",uin=" + (String)localObject6);
            }
          }
          catch (Exception localException8)
          {
            localException8.printStackTrace();
            continue;
          }
          if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
            ((Bundle)localObject7).putBoolean("reg_Lianghao", true);
          }
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("wtLogin_LiangHao", 2, "builtInServlet|onReceive failed = " + paramFromServiceMsg.getBusinessFailCode());
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          ((Bundle)localObject7).putInt("code", ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue());
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
        catch (Exception localException9)
        {
          for (;;)
          {
            localException9.printStackTrace();
          }
        }
        ((Bundle)localObject7).putByteArray("promptInfo_error", (byte[])paramFromServiceMsg.getAttribute("resp_register_promptinfo", new byte[0]));
        if (paramFromServiceMsg.isSuccess()) {}
        try
        {
          j = ((Integer)paramFromServiceMsg.getAttribute("resp_register_resultcode", Integer.valueOf(-1))).intValue();
          String str3 = (String)paramFromServiceMsg.getAttribute("resp_register_uin", "");
          localObject6 = (String)paramFromServiceMsg.getAttribute("to_register_cr_mobile", "");
          ((Bundle)localObject7).putInt("code", j);
          ((Bundle)localObject7).putString("uin", str3);
          ((Bundle)localObject7).putString("phone", (String)localObject6);
          notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
          return;
        }
        catch (Exception localException10)
        {
          for (;;)
          {
            localException10.printStackTrace();
          }
        }
        notifyObserver(paramIntent, 1007, paramFromServiceMsg.isSuccess(), null, AccountObserver.class);
        return;
        ((Bundle)localObject7).putSerializable("map", paramFromServiceMsg.attributes);
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
        return;
        ((Bundle)localObject7).putString("key", (String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
        notifyObserver(paramIntent, i, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
        return;
        localObject4 = paramIntent.getStringExtra("uin");
        localObject6 = paramIntent.getStringExtra("cmd");
        l1 = paramIntent.getLongExtra("wtsdkseq", -1L);
        paramIntent = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramIntent.order(ByteOrder.BIG_ENDIAN);
        i = paramIntent.getInt();
        localObject7 = new byte[i - 4];
        paramIntent.get((byte[])localObject7, 0, i - 4);
        if (paramFromServiceMsg.isSuccess())
        {
          WtloginMsfListener.onAsyncReceive((String)localObject4, (String)localObject6, l1, (byte[])localObject7);
          return;
        }
        WtloginMsfListener.onAsyncReceiveFail((String)localObject4, (String)localObject6, l1, paramFromServiceMsg.getBusinessFailCode());
        return;
        if (paramFromServiceMsg.isSuccess())
        {
          localObject4 = new UniPacket(true);
          ((UniPacket)localObject4).setEncodeName("utf-8");
          ((UniPacket)localObject4).decode(paramFromServiceMsg.getWupBuffer());
          ((Bundle)localObject7).putSerializable("jce", (GetResourceRespV2)((UniPacket)localObject4).getByClass("GetResourceRespV2", new GetResourceRespV2()));
        }
        ((Bundle)localObject7).putInt("iPluginType", paramIntent.getIntExtra("iPluginType", 64));
        notifyObserver(paramIntent, 1018, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, ServerConfigObserver.class);
        return;
        paramIntent = paramFromServiceMsg.getUin();
        paramFromServiceMsg = (HashMap)paramFromServiceMsg.getAttributes().get("keyMap");
        if ((TextUtils.isEmpty(paramIntent)) || (getAppRuntime() == null) || (!paramIntent.equals(getAppRuntime().getAccount()))) {
          break;
        }
        ((TicketManager)getAppRuntime().getManager(2)).setAlterTicket(paramFromServiceMsg);
        return;
        localObject4 = paramFromServiceMsg.getUin();
        localObject6 = (byte[])paramFromServiceMsg.getAttributes().get("da2");
        ((Bundle)localObject7).putString("account", (String)localObject4);
        ((Bundle)localObject7).putString("da2", new String((byte[])localObject6));
        notifyObserver(paramIntent, 1046, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, AccountObserver.class);
        return;
        ((Bundle)localObject7).putString("msf_con_erro", (String)paramFromServiceMsg.getAttribute("msf_con_erro", ""));
        notifyObserver(paramIntent, 2201, paramFromServiceMsg.isSuccess(), (Bundle)localObject7, CheckConErroObserver.class);
        return;
        label5535:
        bool1 = true;
        continue;
        label5541:
        bool1 = true;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
      }
      label5550:
      Object localObject4 = null;
      continue;
      localObject6 = null;
      break label906;
      localObject6 = null;
      break label333;
      localObject4 = null;
      break label310;
      label5574:
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
    byte b = 1;
    int i = 0;
    int j = 0;
    super.service(paramIntent);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    long l1;
    label1718:
    Object localObject5;
    label1824:
    label1844:
    String str1;
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
      do
      {
        return;
        localObject1 = paramIntent.getStringExtra("account");
        localObject2 = paramIntent.getByteArrayExtra("password");
        if (isQQUin((String)localObject1)) {}
        for (localObject1 = getAppRuntime().getService().msfSub.getLoginMsg((String)localObject1, (byte[])localObject2);; localObject1 = getAppRuntime().getService().msfSub.getChangeUinAndLoginMsg((String)localObject1, (byte[])localObject2))
        {
          ((ToServiceMsg)localObject1).setTimeout(40000L);
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
          ((ToServiceMsg)localObject1).setTimeout(40000L);
          ((ToServiceMsg)localObject1).addAttribute("from_where", "ssoAccountAction");
          ((ToServiceMsg)localObject1).addAttribute("targetTicket", Integer.valueOf(paramIntent.getIntExtra("targetTicket", 4096)));
          ((ToServiceMsg)localObject1).addAttribute("process", localObject2);
          sendToMSF(paramIntent, (ToServiceMsg)localObject1);
          return;
        }
        localObject1 = paramIntent.getStringExtra("account");
        localObject2 = paramIntent.getStringExtra("password");
        localObject1 = getAppRuntime().getService().msfSub.getVerifyPasswdMsg((String)localObject1, MD5.toMD5Byte((String)localObject2));
        ((ToServiceMsg)localObject1).setTimeout(40000L);
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
        int k = localObject2.length;
        i = j;
        while (i < k)
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
          ((PushRegisterInfo)localObject2).bKikPC = b;
          ((PushRegisterInfo)localObject2).bKikWeak = 0;
          localObject3 = (AppRuntime.Status)paramIntent.getSerializableExtra("onlineStatus");
          bool = paramIntent.getBooleanExtra("isUserSet", false);
          ((PushRegisterInfo)localObject2).iStatus = ((AppRuntime.Status)localObject3).getValue();
          ((PushRegisterInfo)localObject2).extStatus = paramIntent.getLongExtra("extOnlineStatus", -1L);
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).add(Long.valueOf(1L));
          ((ArrayList)localObject1).add(Long.valueOf(2L));
          ((ArrayList)localObject1).add(Long.valueOf(4L));
          ((PushRegisterInfo)localObject2).pushIds = ((ArrayList)localObject1);
          ((PushRegisterInfo)localObject2).timeStamp = getAppRuntime().getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
          ((PushRegisterInfo)localObject2).iLargeSeq = paramIntent.getLongExtra("K_SEQ", 0L);
          ((PushRegisterInfo)localObject2).uin = getAppRuntime().getAccount();
          if (localObject3 != AppRuntime.Status.offline) {
            break label1824;
          }
          localObject1 = getAppRuntime().getService().msfSub.getUnRegisterPushMsg((PushRegisterInfo)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "BuiltInServlet.ACTION_REGIST_MESSAGE_PUSH " + localObject3 + ", " + ((PushRegisterInfo)localObject2).timeStamp + ", " + ((PushRegisterInfo)localObject2).iLargeSeq + ", isUserSet: " + bool);
          }
          if (!bool) {
            break label1844;
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
          break label1718;
          ((ToServiceMsg)localObject1).getAttributes().put("regPushReason", RegPushReason.appRegister);
        }
        j = paramIntent.getIntExtra("appid", 0);
        localObject1 = paramIntent.getStringExtra("processName");
        localObject2 = paramIntent.getStringExtra("broadcastName");
        localObject4 = paramIntent.getStringArrayExtra("commands");
        localObject3 = new ArrayList();
        k = localObject4.length;
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
    case 1003: 
      localObject1 = paramIntent.getStringExtra("countryCode");
      localObject2 = paramIntent.getStringExtra("phoneNumber");
      localObject5 = paramIntent.getStringExtra("inviteCode");
      l1 = paramIntent.getLongExtra("appid", 0L);
      localObject4 = paramIntent.getStringExtra("verifySig");
      str1 = (String)localObject1 + "-" + (String)localObject2;
      String str2 = paramIntent.getStringExtra("appVersion");
      b = paramIntent.getByteExtra("language", (byte)2);
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
          break label2446;
        }
        localObject1 = "";
        ((HashMap)localObject5).put("os_language", localObject1);
        ((ToServiceMsg)localObject4).getAttributes().put("qq_language", Integer.valueOf(i));
        localObject3 = ((ToServiceMsg)localObject4).getAttributes();
        if (localObject2 != null) {
          break label2453;
        }
      }
      for (localObject1 = "";; localObject1 = localObject2)
      {
        ((HashMap)localObject3).put("gps_location", localObject1);
        sendToMSF(paramIntent, (ToServiceMsg)localObject4);
        return;
        break;
        localObject1 = localObject3;
        break label2381;
      }
    case 1020: 
      sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterSendReSendSmsMsg());
      return;
    case 1004: 
      localObject1 = paramIntent.getStringExtra("code");
      sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterCommitSmsCodeMsg((String)localObject1));
      return;
    case 1022: 
      sendToMSF(paramIntent, getAppRuntime().getService().msfSub.getRegisterQueryUpSmsStatMsg());
      return;
    case 1005: 
      label2381:
      localObject1 = paramIntent.getStringExtra("password");
      label2446:
      label2453:
      localObject2 = paramIntent.getStringExtra("nick");
      localObject3 = paramIntent.getStringExtra("code");
      if (!paramIntent.hasExtra("bindMobile")) {
        break;
      }
    }
    for (boolean bool = paramIntent.getBooleanExtra("bindMobile", true);; bool = true)
    {
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
      if (localObject1 == null) {
        break;
      }
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
      if (localObject1 == null) {
        break;
      }
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
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "ACTION_SEND_WIRELESS_MEIBAOREQ send msgnow " + ((ToServiceMsg)localObject1).getServiceCmd());
      }
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
      localObject1 = paramIntent.getStringExtra("uin");
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.getAlterTickets);
      ((ToServiceMsg)localObject1).setNeedCallback(true);
      if (localObject1 == null) {
        break;
      }
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
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
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.startPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
      localObject2 = paramIntent.getStringExtra("uin");
      localObject1 = paramIntent.getStringExtra("src");
      localObject2 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject2, "");
      ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.stopPCActivePolling);
      ((ToServiceMsg)localObject2).getAttributes().put("src", localObject1);
      ((ToServiceMsg)localObject2).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject2);
      return;
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
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_msgsignal);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
      localObject1 = paramIntent.getStringExtra("account");
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), (String)localObject1, "login.chgTok_DA2");
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_refreshDA2);
      ((ToServiceMsg)localObject1).setNeedCallback(true);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
      localObject1 = paramIntent.getStringExtra("longitude");
      localObject2 = paramIntent.getStringExtra("latitude");
      localObject3 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      ((ToServiceMsg)localObject3).setMsfCommand(MsfCommand.msf_save_geoginfo);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_lontitude", localObject1);
      ((ToServiceMsg)localObject3).getAttributes().put("geoginfo_latitude", localObject2);
      ((ToServiceMsg)localObject3).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject3);
      return;
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      i = paramIntent.getIntExtra("opType", 0);
      j = paramIntent.getIntExtra("manualLogLevel", 2);
      ((ToServiceMsg)localObject1).getAttributes().put("opType", Integer.valueOf(i));
      ((ToServiceMsg)localObject1).getAttributes().put("manualLogLevel", Integer.valueOf(j));
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_manual_set_log_level);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
      localObject1 = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), "0", "");
      i = paramIntent.getIntExtra("localeId", 0);
      ((ToServiceMsg)localObject1).getAttributes().put("localeId", Integer.valueOf(i));
      ((ToServiceMsg)localObject1).setMsfCommand(MsfCommand.msf_update_locale_id);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      sendToMSF(paramIntent, (ToServiceMsg)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.BuiltInServlet
 * JD-Core Version:    0.7.0.1
 */