package mqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Constants.Action;
import mqq.bean.OnLoginByGatewayParam;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public abstract class WtloginObserver
  implements Constants.Action, BusinessObserver
{
  public void onAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckSMSAndGetStExt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onException(String paramString, int paramInt) {}
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onGetOpenKeyWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg) {}
  
  public void onGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg) {}
  
  public void onLoginByGateway(int paramInt, OnLoginByGatewayParam paramOnLoginByGatewayParam) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2100: 
      onGetStWithPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getString("userPasswd"), paramBundle.getByteArray("pictureData"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2101: 
      onGetStWithoutPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getLong("dwDstAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2102: 
      onCheckPictureAndGetSt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), paramBundle.getByteArray("pictureData"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2103: 
      onRefreshPictureData(paramBundle.getString("userAccount"), paramBundle.getByteArray("pictureData"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2104: 
      onVerifyCode(paramBundle.getString("userAccount"), paramBundle.getByteArray("appName"), paramBundle.getLong("time"), paramBundle.getStringArrayList("data"), paramBundle.getByteArray("errMsg"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2105: 
      onCloseCode(paramBundle.getString("userAccount"), paramBundle.getByteArray("appName"), paramBundle.getLong("time"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getByteArray("errMsg"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2106: 
      onGetA1WithA1(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubSrcAppid"), paramBundle.getByteArray("dstAppName"), paramBundle.getLong("dwDstSsoVer"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getByteArray("dstAppVer"), paramBundle.getByteArray("dstAppSign"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), (WFastLoginInfo)paramBundle.getParcelable("fastLoginInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2108: 
      onCheckDevLockStatus((WUserSigInfo)paramBundle.getParcelable("sigInfo"), (DevlockInfo)paramBundle.getParcelable("devLockInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2109: 
      onAskDevLockSms((WUserSigInfo)paramBundle.getParcelable("sigInfo"), (DevlockInfo)paramBundle.getParcelable("devLockInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2110: 
      onCheckDevLockSms((WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2111: 
      onCloseDevLock((WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2112: 
      onRefreshSMSData(paramBundle.getString("userAccount"), paramBundle.getLong("smsAppid"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("remainMsgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2113: 
      onCheckSMSAndGetSt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2114: 
      onCheckSMSAndGetStExt(paramBundle.getString("userAccount"), paramBundle.getByteArray("userInput"), (WUserSigInfo)paramBundle.getParcelable("sigInfo"), (byte[][])null, paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2117: 
      onReceiveRegGetSMSVerifyLoginAccount(paramBundle);
      return;
    case 2118: 
      onCheckSMSVerifyLoginAccount(paramBundle.getLong("appid"), paramBundle.getLong("subAppid"), paramBundle.getString("countryCode"), paramBundle.getString("mobile"), paramBundle.getString("msg"), paramBundle.getInt("msgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2119: 
      onRefreshSMSVerifyLoginAccount(paramBundle.getString("mobile"), paramBundle.getString("msg"), paramBundle.getInt("msgCnt"), paramBundle.getInt("timeLimit"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2120: 
      onVerifySMSVerifyLoginAccount(paramBundle.getString("mobile"), paramBundle.getString("msgCode"), paramBundle.getInt("ret"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), (ErrMsg)paramBundle.getParcelable("errMsg"));
      return;
    case 2121: 
      onReceiveGetStViaSMSVerifyLogin(paramBundle);
      return;
    case 2122: 
      onGetSubaccountStViaSMSVerifyLogin(paramBundle.getString("submainaccount"), paramBundle.getString("userAccount"), paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2208: 
      onGetOpenKeyWithoutPasswd(paramBundle.getString("userAccount"), paramBundle.getLong("dwSrcAppid"), paramBundle.getLong("dwDstAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getByteArray("openid"), paramBundle.getByteArray("accessToken"), paramBundle.getInt("ret"), (ErrMsg)paramBundle.getParcelable("lastError"));
      return;
    case 2215: 
      onLoginByGateway(paramBundle.getInt("ret"), new OnLoginByGatewayParam(paramBundle.getInt("key_sso_seq"), (DevlockInfo)paramBundle.getParcelable("resp_devlockinfo"), (ToServiceMsg)paramBundle.getParcelable("key_to_service_msg"), (WUserSigInfo)paramBundle.getParcelable("userSigInfo"), paramBundle.getString("uin"), (ErrMsg)paramBundle.getParcelable("errMsg")));
      return;
    }
    onException(paramBundle.getString("error"), paramBundle.getInt("cmd"));
  }
  
  protected void onReceiveGetStViaSMSVerifyLogin(Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("lhsig");
    int i = paramBundle.getInt("ret");
    String str2 = paramBundle.getString("userAccount");
    String str1 = str2;
    if (i != 0)
    {
      str1 = str2;
      if (arrayOfByte != null)
      {
        str2 = paramBundle.getString("uin");
        str1 = str2;
        if (QLog.isColorLevel())
        {
          QLog.d("wtlogin_Lianghao", 2, "SMSVerifyLogin|phone=" + paramBundle.getString("userAccount") + "|" + str2);
          str1 = str2;
        }
      }
    }
    onGetStViaSMSVerifyLogin(str1, paramBundle.getLong("dwAppid"), paramBundle.getInt("dwMainSigMap"), paramBundle.getLong("dwSubDstAppid"), i, arrayOfByte, (ErrMsg)paramBundle.getParcelable("lastError"));
  }
  
  protected void onReceiveRegGetSMSVerifyLoginAccount(Bundle paramBundle)
  {
    if (paramBundle.getBoolean("reg_LiangHao"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("wtLogin_LiangHao", 2, "OnRegGetSMSVerifyLoginAccountWithLhSig");
      }
      onRegGetSMSVerifyLoginAccountWithLhSig(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"), paramBundle.getByteArray("lhsig"));
    }
    for (;;)
    {
      onRegGetSMSVerifyLoginAccount(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"));
      return;
      onRegGetSMSVerifyLoginAccount(paramBundle.getInt("ret"), paramBundle.getLong("userAccount"), paramBundle.getByteArray("supersig"), paramBundle.getByteArray("contactssig"), paramBundle.getByteArray("msg"));
    }
  }
  
  public void onRefreshPictureData(String paramString, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void onRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg) {}
  
  public void onRegGetSMSVerifyLoginAccount(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void onRegGetSMSVerifyLoginAccountWithLhSig(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4) {}
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg) {}
  
  public void onVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, WUserSigInfo paramWUserSigInfo, ErrMsg paramErrMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.observer.WtloginObserver
 * JD-Core Version:    0.7.0.1
 */