package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class n
  extends WtloginListener
{
  MsfCore a;
  
  public n(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.b(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnAskDevLockSms found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckDevLockSms found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckDevLockStatus found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.b(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckPictureAndGetSt found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.c(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetSt found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSAndGetStExt found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount ret =" + paramInt3 + " mobile=" + paramString1 + " msg=" + paramString2 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnCheckSMSVerifyLoginAccount errMsg =" + paramErrMsg.getMessage());
      }
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramLong1, paramLong2, "", paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckSMSVerifyLoginAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckWebsigAndGetSt2 found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    paramArrayOfByte1 = m.b(paramWUserSigInfo);
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte1.b(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCheckWebsigAndGetSt1 found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramArrayOfByte1, paramLong, paramWUserSigInfo, paramArrayOfByte2, paramInt);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCloseCode found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.b(paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnCloseDevLock found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramErrMsg.getMessage(), paramInt, paramWUserSigInfo);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnException found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin ret =" + paramInt2 + " userAccount=" + paramString);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnGetStViaSMSVerifyLogin errMsg =" + paramErrMsg.getMessage());
      }
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramLong1, paramInt1, paramLong2, "", paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStViaSMSVerifyLogin found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString1, paramLong1, paramInt1, paramLong2, paramString2, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithPasswd found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    paramArrayOfLong = m.b(paramWUserSigInfo);
    if (paramArrayOfLong != null)
    {
      paramArrayOfLong.a(paramString1, paramLong1, paramInt1, paramLong2, paramString2, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithPasswd found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithoutPasswd1 found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnGetStWithoutPasswd2 found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnQuickRegisterCheckAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.e(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnQuickRegisterCheckAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnQuickRegisterGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.f(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnQuickRegisterGetAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramWUserSigInfo, paramArrayOfByte, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshPictureData found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramLong, paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshSMSData found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRefreshSMSVerifyLoginCode(String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode ret =" + paramInt3 + " mobile=" + paramString1 + " msg=" + paramString2 + " msgCnt=" + paramInt1 + " timeLimit=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnRefreshSMSVerifyLoginCode errMsg =" + paramErrMsg.getMessage());
      }
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRefreshSMSVerifyLoginAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegCheckDownloadMsg(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.c(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckDownloadMsg found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegCheckUploadMsg(WUserSigInfo paramWUserSigInfo, String paramString)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramString);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckUploadMsg found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckValidUrl found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegCheckWebSig(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramString1, paramString2);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegCheckWebSig found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegError(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegError found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegGetAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("WtloginCenterCallback", 4, "OnRegGetSMSVerifyLoginAccount ret =" + paramInt + " uin=" + paramLong);
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegGetSMSVerifyLoginAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegQueryAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WTLoginCenter.OnRegQueryAccount ret = " + paramInt);
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.b(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegQueryAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegQueryClientSendedMsgStatus found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramWUserSigInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegRequestServerResendMsg found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnRegSubmitMsgChk(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.d(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnRegSubmitMsgChk found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramArrayOfByte1, paramLong, paramList, paramWUserSigInfo, paramArrayOfByte2, paramInt);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnVerifyCode found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void OnVerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode ret =" + paramInt + " mobile=" + paramString1 + " msgCode=" + paramString2);
      if (paramErrMsg != null) {
        QLog.d("WtloginCenterCallback", 4, "OnVerifySMSVerifyLoginCode errMsg =" + paramErrMsg.getMessage());
      }
    }
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString1, paramString2, paramInt, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "OnVerifySMSVerifyLoginAccount found unknown userSigInfo " + paramWUserSigInfo);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    o localo = m.b(paramWUserSigInfo);
    if (localo != null)
    {
      localo.a(paramString, paramLong1, paramInt1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, paramInt2, paramErrMsg);
      return;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "onGetA1WithA1 found unknown userSigInfo " + paramWUserSigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.n
 * JD-Core Version:    0.7.0.1
 */