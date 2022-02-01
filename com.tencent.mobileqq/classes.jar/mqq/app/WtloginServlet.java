package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class WtloginServlet
  extends MSFServlet
  implements Constants.Action
{
  private void handleSMSAction(int paramInt, Intent paramIntent, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2112: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshSMSData(paramString, paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2113: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckSMSAndGetSt(paramString, paramIntent.getStringExtra("userAccount"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2114: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckSMSAndGetStExt(paramString, paramIntent.getStringExtra("userAccount"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2117: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RegGetSMSVerifyLoginAccount(paramString, paramIntent.getByteArrayExtra("msgchk"), paramIntent.getByteArrayExtra("nick"), paramIntent.getStringExtra("lhuin"), paramIntent.getStringExtra("unBindlhUin"), paramIntent.getStringExtra("appVersion"), 30000L));
      return;
    case 2118: 
      paramString = MsfMsgUtil.get_wt_CheckSMSVerifyLoginAccount(paramString, paramIntent.getStringExtra("userAccount"), paramIntent.getStringExtra("countryCode"), paramIntent.getIntExtra("appid", 0), 30000L);
      byte[] arrayOfByte = paramIntent.getByteArrayExtra("verifyToken");
      if (arrayOfByte != null) {
        paramString.addAttribute("verifyToken", arrayOfByte);
      }
      sendToMSF(paramIntent, paramString);
      return;
    case 2215: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_QuickLoginByGateway(paramString, paramIntent, 30000L));
      return;
    case 2119: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshSMSVerifyLoginCode(paramString, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2120: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_VerifySMSVerifyLoginCode(paramString, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getStringExtra("code"), 30000L));
      return;
    case 2121: 
      paramString = MsfMsgUtil.get_wt_GetStViaSMSVerifyLogin(paramString, paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getIntExtra("appid", 0), 30000L);
      paramString.addAttribute("from_where", paramIntent.getStringExtra("from_where"));
      sendToMSF(paramIntent, paramString);
      return;
    }
    sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetSubaccountStViaSMSVerifyLogin(paramString, paramIntent.getStringExtra("mainaccount"), paramIntent.getStringExtra("countryCode"), paramIntent.getStringExtra("userAccount"), paramIntent.getIntExtra("appid", 0), 30000L));
  }
  
  private void onRecvAskDevLockSms(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putParcelable("devLockInfo", (Parcelable)paramFromServiceMsg.attributes.get("devLockInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2109, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckDevLockSms(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2110, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckDevLockStatus(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putParcelable("devLockInfo", (Parcelable)paramFromServiceMsg.attributes.get("devLockInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2108, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckPictureAndGetSt(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      paramBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      paramBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2102, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckSMSAndGetSt(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2113, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckSMSAndGetStExt(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putByteArray("userInput", (byte[])paramFromServiceMsg.attributes.get("userInput"));
      paramBundle.putParcelable("st", null);
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2114, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCheckSMSVerifyLoginAccount(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    int i;
    if (paramFromServiceMsg.attributes != null)
    {
      paramBundle.putString("countryCode", (String)paramFromServiceMsg.attributes.get("countryCode"));
      paramBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
      paramBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
      paramBundle.putString("msg", (String)paramFromServiceMsg.attributes.get("msg"));
      Object localObject = paramFromServiceMsg.getAttribute("ret");
      i = paramFromServiceMsg.getBusinessFailCode();
      if (!(localObject instanceof Integer)) {
        break label135;
      }
      i = ((Integer)localObject).intValue();
    }
    label135:
    for (;;)
    {
      paramBundle.putInt("ret", i);
      notifyObserver(paramIntent, 2118, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
      return;
    }
  }
  
  private void onRecvCloseCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putByteArray("appName", (byte[])paramFromServiceMsg.attributes.get("appName"));
      paramBundle.putLong("time", ((Long)paramFromServiceMsg.attributes.get("time")).longValue());
      paramBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putByteArray("errMsg", (byte[])paramFromServiceMsg.attributes.get("errMsg"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2105, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvCloseDevLock(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2111, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvException(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramBundle.putString("error", (String)paramFromServiceMsg.attributes.get("error"));
    paramBundle.putInt("cmd", ((Integer)paramFromServiceMsg.attributes.get("cmd")).intValue());
    notifyObserver(paramIntent, 2107, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvGetA1WithA1(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      paramBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      paramBundle.putLong("dwSubSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubSrcAppid")).longValue());
      paramBundle.putByteArray("dstAppName", (byte[])paramFromServiceMsg.attributes.get("dstAppName"));
      paramBundle.putLong("dwDstSsoVer", ((Long)paramFromServiceMsg.attributes.get("dwDstSsoVer")).longValue());
      paramBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      paramBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      paramBundle.putByteArray("dstAppVer", (byte[])paramFromServiceMsg.attributes.get("dstAppVer"));
      paramBundle.putByteArray("dstAppSign", (byte[])paramFromServiceMsg.attributes.get("dstAppSign"));
      paramBundle.putParcelable("userSigInfo", (WUserSigInfo)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putParcelable("fastLoginInfo", (WFastLoginInfo)paramFromServiceMsg.attributes.get("fastLoginInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2106, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvGetOpenKeyWithoutPasswd(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      paramBundle.putLong("dwDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwDstAppid")).longValue());
      paramBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      paramBundle.putByteArray("appid", (byte[])paramFromServiceMsg.attributes.get("appid"));
      paramBundle.putByteArray("openid", (byte[])paramFromServiceMsg.attributes.get("openid"));
      paramBundle.putByteArray("accessToken", (byte[])paramFromServiceMsg.attributes.get("accessToken"));
      paramBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2208, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvGetStViaSMSVerifyLogin(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    int j = 0;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    if (paramFromServiceMsg.attributes != null)
    {
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramBundle.putString("uin", paramFromServiceMsg.getUin());
      paramBundle.putString("alias", paramIntent.getStringExtra("userAccount"));
      paramBundle.putString("error", paramFromServiceMsg.getBusinessFailMsg());
      paramBundle.putByteArray("st_temp", (byte[])paramFromServiceMsg.getAttribute("st_temp"));
      paramBundle.putByteArray("st_temp_key", (byte[])paramFromServiceMsg.getAttribute("st_temp_key"));
      localObject3 = paramFromServiceMsg.getAttribute("resp_login_url");
      localObject2 = "";
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof String)) {
          localObject1 = (String)localObject3;
        }
      }
      localObject2 = paramFromServiceMsg.getAttribute("resp_logini_ret");
      if (!(localObject2 instanceof Integer)) {
        break label640;
      }
    }
    label640:
    for (int i = ((Integer)localObject2).intValue();; i = 0)
    {
      localObject2 = paramFromServiceMsg.getAttribute("resp_login_lhsig");
      if ((localObject2 instanceof byte[])) {}
      for (localObject2 = (byte[])localObject2;; localObject2 = null)
      {
        paramBundle.putString("errorurl", (String)localObject1);
        paramBundle.putInt("loginret", i);
        paramBundle.putInt("code", paramFromServiceMsg.getResultCode());
        paramBundle.putByteArray("lhsig", (byte[])localObject2);
        if (paramFromServiceMsg.isSuccess())
        {
          if (!"com.tencent.mobileqq:openSdk".equals(getAppRuntime().getApplication().getQQProcessName()))
          {
            MsfSdkUtils.addSimpleAccount(paramFromServiceMsg.getUin());
            MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), true);
            if (!paramFromServiceMsg.getUin().equals(paramIntent.getStringExtra("userAccount"))) {
              MsfSdkUtils.delSimpleAccount(paramIntent.getStringExtra("userAccount"));
            }
          }
          localObject1 = paramIntent.getStringExtra("userAccount");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
            localObject2 = MsfSdkUtils.getLoginedAccountList();
            if (localObject2 != null)
            {
              i = j;
              if (i < ((List)localObject2).size())
              {
                localObject3 = (SimpleAccount)((List)localObject2).get(i);
                if (localObject3 == null) {}
                for (;;)
                {
                  i += 1;
                  break;
                  localObject3 = ((SimpleAccount)localObject3).getUin();
                  String str = getAppRuntime().getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3);
                  if ((!TextUtils.isEmpty(str)) && (str.equals(localObject1)) && (!((String)localObject3).equals(paramFromServiceMsg.getUin()))) {
                    getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3, (String)localObject3);
                  }
                }
              }
            }
          }
        }
        getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
        paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
        i = paramFromServiceMsg.getResultCode();
        localObject1 = paramFromServiceMsg.attributes.get("ret");
        if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
          i = ((Integer)localObject1).intValue();
        }
        for (;;)
        {
          paramBundle.putInt("ret", i);
          notifyObserver(paramIntent, 2121, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
          return;
        }
      }
    }
  }
  
  private void onRecvGetStWithPasswd(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putLong("dwAppid", ((Long)paramFromServiceMsg.attributes.get("dwAppid")).longValue());
      paramBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      paramBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      paramBundle.putString("userPasswd", (String)paramFromServiceMsg.attributes.get("userPasswd"));
      paramBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      paramBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2100, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvGetStWithoutPasswd(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putLong("dwSrcAppid", ((Long)paramFromServiceMsg.attributes.get("dwSrcAppid")).longValue());
      paramBundle.putLong("dwDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwDstAppid")).longValue());
      paramBundle.putInt("dwMainSigMap", ((Integer)paramFromServiceMsg.attributes.get("dwMainSigMap")).intValue());
      paramBundle.putLong("dwSubDstAppid", ((Long)paramFromServiceMsg.attributes.get("dwSubDstAppid")).longValue());
      paramBundle.putParcelable("userSigInfo", (Parcelable)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2101, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvGetSubaccountStViaSMSVerifyLogin(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    Object localObject2;
    long l3;
    if (paramFromServiceMsg.attributes != null)
    {
      getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      if (paramFromServiceMsg.isSuccess())
      {
        MsfSdkUtils.addSimpleAccount(paramFromServiceMsg.getUin());
        MsfSdkUtils.updateSimpleAccount(paramFromServiceMsg.getUin(), true);
        if (!paramFromServiceMsg.getUin().equals(paramIntent.getStringExtra("userAccount"))) {
          MsfSdkUtils.delSimpleAccount(paramIntent.getStringExtra("userAccount"));
        }
        localObject1 = paramIntent.getStringExtra("userAccount");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramFromServiceMsg.getUin(), (String)localObject1);
          localObject2 = MsfSdkUtils.getLoginedAccountList();
          if (localObject2 != null)
          {
            i = 0;
            if (i < ((List)localObject2).size())
            {
              Object localObject3 = (SimpleAccount)((List)localObject2).get(i);
              if (localObject3 == null) {}
              for (;;)
              {
                i += 1;
                break;
                localObject3 = ((SimpleAccount)localObject3).getUin();
                String str = getAppRuntime().getApplication().getProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3);
                if ((!TextUtils.isEmpty(str)) && (str.equals(localObject1)) && (!((String)localObject3).equals(paramFromServiceMsg.getUin()))) {
                  getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + (String)localObject3, (String)localObject3);
                }
              }
            }
          }
        }
      }
      localObject1 = (String)paramFromServiceMsg.getAttribute("mainaccount");
      paramBundle.putString("submainaccount", (String)localObject1);
      localObject2 = getAppRuntime().getApplication().getFirstSimpleAccount();
      l3 = System.currentTimeMillis();
      l1 = l3;
      if (localObject2 != null) {
        l2 = l3;
      }
    }
    try
    {
      long l4 = getAppRuntime().getApplication().string2Long(getAppRuntime().getApplication().getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
      l1 = l3;
      if (l3 <= l4)
      {
        l3 = l4 + 1L;
        l1 = l3;
        l2 = l3;
        if (QLog.isColorLevel())
        {
          l2 = l3;
          QLog.d("mqq", 2, "CNR account savetime => system time is error..");
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
    if (localObject1 != null) {
      getAppRuntime().getApplication().setProperty((String)localObject1 + Constants.Key._logintime, String.valueOf(l1 + 1L));
    }
    getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    paramBundle.putString("userAccount", paramFromServiceMsg.getUin());
    int i = paramFromServiceMsg.getResultCode();
    Object localObject1 = paramFromServiceMsg.attributes.get("ret");
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      i = ((Integer)localObject1).intValue();
      paramBundle.putInt("ret", i);
      notifyObserver(paramIntent, 2122, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
      return;
    }
  }
  
  private void onRecvRefreshPictureData(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putByteArray("pictureData", (byte[])paramFromServiceMsg.attributes.get("pictureData"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2103, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvRefreshSMSData(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putLong("smsAppid", ((Long)paramFromServiceMsg.attributes.get("smsAppid")).longValue());
      paramBundle.putParcelable("sigInfo", (Parcelable)paramFromServiceMsg.attributes.get("sigInfo"));
      paramBundle.putInt("remainMsgCnt", ((Integer)paramFromServiceMsg.attributes.get("remainMsgCnt")).intValue());
      paramBundle.putInt("timeLimit", ((Integer)paramFromServiceMsg.attributes.get("timeLimit")).intValue());
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2112, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvRefreshSMSVerifyLoginCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    int i;
    if (paramFromServiceMsg.attributes != null)
    {
      paramBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
      paramBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
      paramBundle.putString("msg", (String)paramFromServiceMsg.attributes.get("msg"));
      localObject = paramFromServiceMsg.getAttribute("ret");
      i = paramFromServiceMsg.getBusinessFailCode();
      if (!(localObject instanceof Integer)) {
        break label117;
      }
    }
    label117:
    for (Object localObject = (Integer)localObject;; localObject = Integer.valueOf(i))
    {
      paramBundle.putInt("ret", ((Integer)localObject).intValue());
      notifyObserver(paramIntent, 2119, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
      return;
    }
  }
  
  private void onRecvRegGetSMSVerifyLoginAccount(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    Long localLong;
    int i;
    if (paramFromServiceMsg.attributes != null)
    {
      localObject = paramFromServiceMsg.getAttribute("userAccount");
      localLong = Long.valueOf(0L);
      if (localObject != null) {
        localLong = (Long)localObject;
      }
      paramBundle.putLong("userAccount", localLong.longValue());
      paramBundle.putByteArray("supersig", (byte[])paramFromServiceMsg.attributes.get("supersig"));
      paramBundle.putByteArray("contactssig", (byte[])paramFromServiceMsg.attributes.get("contactssig"));
      paramBundle.putByteArray("msg", (byte[])paramFromServiceMsg.attributes.get("msg"));
      localObject = (byte[])paramFromServiceMsg.getAttribute("resp_register_lh_sig", null);
      if ((localObject != null) && (localObject.length > 0))
      {
        paramBundle.putByteArray("lhsig", (byte[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|lhsig= " + new String((byte[])localObject));
        }
      }
      localObject = paramFromServiceMsg.getAttribute("ret");
      i = paramFromServiceMsg.getBusinessFailCode();
      if (!(localObject instanceof Integer)) {
        break label309;
      }
    }
    label309:
    for (Object localObject = (Integer)localObject;; localObject = Integer.valueOf(i))
    {
      paramBundle.putInt("ret", ((Integer)localObject).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "wtloginServlet|RegGetAccount|ret=" + localObject + ",uin=" + localLong);
      }
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("lhuin"))) {
        paramBundle.putBoolean("reg_LiangHao", true);
      }
      notifyObserver(paramIntent, 2117, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
      return;
    }
  }
  
  private void onRecvVerifyCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramBundle.putString("userAccount", (String)paramFromServiceMsg.attributes.get("userAccount"));
      paramBundle.putByteArray("appName", (byte[])paramFromServiceMsg.attributes.get("appName"));
      paramBundle.putLong("time", ((Long)paramFromServiceMsg.attributes.get("time")).longValue());
      paramBundle.putStringArrayList("data", (ArrayList)paramFromServiceMsg.attributes.get("data"));
      paramBundle.putByteArray("errMsg", (byte[])paramFromServiceMsg.attributes.get("errMsg"));
      paramBundle.putInt("ret", ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue());
      paramBundle.putParcelable("lastError", (ErrMsg)paramFromServiceMsg.attributes.get("lastError"));
    }
    notifyObserver(paramIntent, 2104, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  private void onRecvVerifySMSVerifyLoginCode(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    int i;
    if (paramFromServiceMsg.attributes != null)
    {
      paramBundle.putString("msgCode", (String)paramFromServiceMsg.attributes.get("msgCode"));
      paramBundle.putString("mobile", (String)paramFromServiceMsg.attributes.get("mobile"));
      paramBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
      paramBundle.putParcelable("userSigInfo", (WUserSigInfo)paramFromServiceMsg.attributes.get("userSigInfo"));
      localObject = paramFromServiceMsg.getAttribute("ret");
      i = paramFromServiceMsg.getBusinessFailCode();
      if (!(localObject instanceof Integer)) {
        break label137;
      }
    }
    label137:
    for (Object localObject = (Integer)localObject;; localObject = Integer.valueOf(i))
    {
      paramBundle.putInt("ret", ((Integer)localObject).intValue());
      notifyObserver(paramIntent, 2120, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
      return;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 3002) {}
    Bundle localBundle;
    for (int i = 2107;; i = paramIntent.getIntExtra("action", 0))
    {
      localBundle = new Bundle();
      switch (i)
      {
      default: 
        return;
      }
    }
    onRecvGetStWithPasswd(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvGetStWithoutPasswd(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvGetOpenKeyWithoutPasswd(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckPictureAndGetSt(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvRefreshPictureData(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvVerifyCode(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCloseCode(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvGetA1WithA1(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckDevLockStatus(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvAskDevLockSms(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckDevLockSms(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCloseDevLock(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvRefreshSMSData(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckSMSAndGetSt(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckSMSAndGetStExt(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvException(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvRegGetSMSVerifyLoginAccount(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvCheckSMSVerifyLoginAccount(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvQuickLoginByGateway(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvRefreshSMSVerifyLoginCode(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvVerifySMSVerifyLoginCode(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvGetStViaSMSVerifyLogin(paramIntent, paramFromServiceMsg, localBundle);
    return;
    onRecvGetSubaccountStViaSMSVerifyLogin(paramIntent, paramFromServiceMsg, localBundle);
  }
  
  protected void onRecvQuickLoginByGateway(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.attributes != null)
    {
      Object localObject1 = (WUserSigInfo)paramFromServiceMsg.attributes.get("userSigInfo");
      paramBundle.putParcelable("userSigInfo", (WUserSigInfo)paramFromServiceMsg.attributes.get("userSigInfo"));
      paramBundle.putParcelable("resp_devlockinfo", (DevlockInfo)paramFromServiceMsg.attributes.get("resp_devlockinfo"));
      if (localObject1 != null) {
        paramBundle.putInt("key_sso_seq", (int)((WUserSigInfo)localObject1)._seqence);
      }
      paramBundle.putParcelable("key_to_service_msg", (ToServiceMsg)paramFromServiceMsg.attributes.get("key_to_service_msg"));
      paramBundle.putParcelable("errMsg", (ErrMsg)paramFromServiceMsg.attributes.get("errMsg"));
      Object localObject2 = paramFromServiceMsg.getAttribute("ret");
      paramBundle.putString("uin", (String)paramFromServiceMsg.attributes.get("uin"));
      localObject1 = Integer.valueOf(paramFromServiceMsg.getBusinessFailCode());
      if ((localObject2 instanceof Integer)) {
        localObject1 = (Integer)localObject2;
      }
      paramBundle.putInt("ret", ((Integer)localObject1).intValue());
    }
    notifyObserver(paramIntent, 2215, paramFromServiceMsg.isSuccess(), paramBundle, WtloginObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void service(Intent paramIntent)
  {
    super.service(paramIntent);
    int i = paramIntent.getIntExtra("action", 0);
    String str = MsfServiceSdk.get().getMsfServiceName();
    switch (i)
    {
    default: 
      handleSMSAction(i, paramIntent, str);
      return;
    case 2100: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetStWithPasswd(str, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("appid", 0L), paramIntent.getStringExtra("passwd"), 30000L));
      return;
    case 2101: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetStWithoutPasswd(str, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), 30000L));
      return;
    case 2208: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetOpenKeyWithoutPasswd(str, paramIntent.getStringExtra("uin"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), 30000L));
      return;
    case 2102: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckPictureAndGetSt(str, paramIntent.getStringExtra("uin"), paramIntent.getByteArrayExtra("userInput"), 30000L));
      return;
    case 2103: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_RefreshPictureData(str, paramIntent.getStringExtra("uin"), 30000L));
      return;
    case 2104: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_VerifyCode(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getBooleanExtra("close", false), paramIntent.getByteArrayExtra("code"), paramIntent.getIntArrayExtra("tlv"), paramIntent.getIntExtra("version", 0), 30000L));
      return;
    case 2105: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CloseCode(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getByteArrayExtra("code"), paramIntent.getIntExtra("version", 0), paramIntent.getStringArrayListExtra("data"), 30000L));
      return;
    case 2213: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CancelCode(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("appid", 0L), paramIntent.getByteArrayExtra("code"), 30000L));
      return;
    case 2106: 
      WFastLoginInfo localWFastLoginInfo = (WFastLoginInfo)((NewIntent)paramIntent).intentMap.get("fastLoginInfo");
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_GetA1WithA1(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("dwSrcAppid", 0L), paramIntent.getLongExtra("dwSubSrcAppid", 0L), paramIntent.getByteArrayExtra("dstAppName"), paramIntent.getLongExtra("dwDstSsoVer", 0L), paramIntent.getLongExtra("dwDstAppid", 0L), paramIntent.getLongExtra("dwSubDstAppid", 0L), paramIntent.getByteArrayExtra("dstAppVer"), paramIntent.getByteArrayExtra("dstAppSign"), localWFastLoginInfo, 30000L));
      return;
    case 2108: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckDevLockStatus(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), 30000L));
      return;
    case 2109: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_AskDevLockSms(str, paramIntent.getStringExtra("userAccount"), 30000L));
      return;
    case 2110: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CheckDevLockSms(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), paramIntent.getStringExtra("smsCode"), paramIntent.getByteArrayExtra("sppKey"), 30000L));
      return;
    case 2111: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_CloseDevLock(str, paramIntent.getStringExtra("userAccount"), paramIntent.getLongExtra("subAppid", 0L), 30000L));
      return;
    case 2125: 
      sendToMSF(paramIntent, MsfMsgUtil.get_wt_setRegDevLockFlag(str, paramIntent.getIntExtra("flag", 0), 30000L));
      return;
    }
    sendToMSF(paramIntent, MsfMsgUtil.get_wt_SetDevlockMobileType(str, paramIntent.getIntExtra("mobile_type", 0), 30000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.WtloginServlet
 * JD-Core Version:    0.7.0.1
 */