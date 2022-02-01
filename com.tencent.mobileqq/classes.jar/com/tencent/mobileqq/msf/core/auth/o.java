package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class o
  extends WtloginListener
{
  MsfCore a;
  
  public o(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public void OnAskDevLockSms(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.b(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
      return;
    }
    paramDevlockInfo = new StringBuilder();
    paramDevlockInfo.append("OnAskDevLockSms found unknown userSigInfo ");
    paramDevlockInfo.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramDevlockInfo.toString());
  }
  
  public void OnCheckDevLockSms(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramErrMsg = new StringBuilder();
    paramErrMsg.append("OnCheckDevLockSms found unknown userSigInfo ");
    paramErrMsg.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramErrMsg.toString());
  }
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramDevlockInfo, paramInt, paramErrMsg);
      return;
    }
    paramDevlockInfo = new StringBuilder();
    paramDevlockInfo.append("OnCheckDevLockStatus found unknown userSigInfo ");
    paramDevlockInfo.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramDevlockInfo.toString());
  }
  
  public void OnCheckPictureAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.b(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCheckPictureAndGetSt found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.c(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCheckSMSAndGetSt found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCheckSMSAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramArrayOfByte, paramWUserSigInfo, paramArrayOfByte1, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCheckSMSAndGetStExt found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCheckSMSVerifyLoginAccount(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCheckSMSVerifyLoginAccount ret =");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" mobile=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" msg=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" msgCnt=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" timeLimit=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      if (paramErrMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnCheckSMSVerifyLoginAccount errMsg =");
        ((StringBuilder)localObject).append(paramErrMsg.getMessage());
        QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramLong1, paramLong2, "", paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnCheckSMSVerifyLoginAccount found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCheckWebsigAndGetSt2 found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCheckWebsigAndGetSt(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    paramArrayOfByte1 = n.b(paramWUserSigInfo);
    if (paramArrayOfByte1 != null)
    {
      paramArrayOfByte1.b(paramString, paramArrayOfByte, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCheckWebsigAndGetSt1 found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramArrayOfByte1, paramLong, paramWUserSigInfo, paramArrayOfByte2, paramInt);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnCloseCode found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnCloseDevLock(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.b(paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramErrMsg = new StringBuilder();
    paramErrMsg.append("OnCloseDevLock found unknown userSigInfo ");
    paramErrMsg.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramErrMsg.toString());
  }
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramErrMsg.getMessage(), paramInt, paramWUserSigInfo);
      return;
    }
    paramErrMsg = new StringBuilder();
    paramErrMsg.append("OnException found unknown userSigInfo ");
    paramErrMsg.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramErrMsg.toString());
  }
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnGetStViaSMSVerifyLogin ret =");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" userAccount=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      if (paramErrMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnGetStViaSMSVerifyLogin errMsg =");
        ((StringBuilder)localObject).append(paramErrMsg.getMessage());
        QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramString, paramLong1, paramInt1, paramLong2, "", paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnGetStViaSMSVerifyLogin found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString1, paramLong1, paramInt1, paramLong2, paramString2, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnGetStWithPasswd found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void OnGetStWithPasswd(String paramString1, long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOfLong, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    paramArrayOfLong = n.b(paramWUserSigInfo);
    if (paramArrayOfLong != null)
    {
      paramArrayOfLong.a(paramString1, paramLong1, paramInt1, paramLong2, paramString2, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnGetStWithPasswd found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramWUserSigInfo, paramInt2, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnGetStWithoutPasswd1 found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnGetStWithoutPasswd(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramArrayOfLong, paramWUserSigInfo, paramArrayOfByte, paramInt2, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnGetStWithoutPasswd2 found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnGuaranteeCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnGuaranteeCheckValidUrl found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnQuickRegisterCheckAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.e(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnQuickRegisterCheckAccount found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnQuickRegisterGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.f(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnQuickRegisterGetAccount found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRefreshPictureData(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramWUserSigInfo, paramArrayOfByte, paramInt, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnRefreshPictureData found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnRefreshSMSData(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramLong, paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnRefreshSMSData found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnRefreshSMSVerifyLoginCode(String paramString1, String paramString2, int paramInt1, int paramInt2, WUserSigInfo paramWUserSigInfo, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRefreshSMSVerifyLoginCode ret =");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" mobile=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" msg=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" msgCnt=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" timeLimit=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      if (paramErrMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnRefreshSMSVerifyLoginCode errMsg =");
        ((StringBuilder)localObject).append(paramErrMsg.getMessage());
        QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramErrMsg);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnRefreshSMSVerifyLoginAccount found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void OnRegCheckDownloadMsg(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.c(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegCheckDownloadMsg found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRegCheckIframe(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, Object paramObject)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramArrayOfByte, paramObject);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegCheckIframe found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRegCheckUploadMsg(WUserSigInfo paramWUserSigInfo, String paramString)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnRegCheckUploadMsg found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnRegCheckValidUrl(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.b(paramWUserSigInfo, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegCheckValidUrl found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRegCheckWebSig(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramString1, paramString2);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnRegCheckWebSig found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void OnRegError(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegError found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRegGetAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    p localp = n.b(paramWUserSigInfo);
    byte[] arrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 48);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnRegGetAccount|lhsig= ");
      localStringBuilder.append(new String(arrayOfByte));
      QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
    }
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte);
      return;
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("OnRegGetAccount found unknown userSigInfo ");
    paramArrayOfByte1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte1.toString());
  }
  
  public void OnRegGetSMSVerifyLoginAccount(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OnRegGetSMSVerifyLoginAccount ret =");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" uin=");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 48);
    if ((localObject1 != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("OnRegGetSMSVerifyLoginAccount|lhsig= ");
      ((StringBuilder)localObject2).append(new String((byte[])localObject1));
      QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = n.b(paramWUserSigInfo);
    if (localObject2 != null)
    {
      ((p)localObject2).a(paramInt, paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, (byte[])localObject1);
      return;
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("OnRegGetSMSVerifyLoginAccount found unknown userSigInfo ");
    paramArrayOfByte1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte1.toString());
  }
  
  public void OnRegQueryAccount(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WTLoginCenter.OnRegQueryAccount ret = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("queryMobile", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).b(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegQueryAccount found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnRegQueryClientSentMsgStatus(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramWUserSigInfo, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnRegQueryClientSendedMsgStatus found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnRegRequestServerResendMsg(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramWUserSigInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnRegRequestServerResendMsg found unknown userSigInfo ");
    ((StringBuilder)localObject).append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, ((StringBuilder)localObject).toString());
  }
  
  public void OnRegSubmitMsgChk(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.d(paramWUserSigInfo, paramInt, paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("OnRegSubmitMsgChk found unknown userSigInfo ");
    paramArrayOfByte.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramArrayOfByte.toString());
  }
  
  public void OnVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramArrayOfByte1, paramLong, paramList, paramWUserSigInfo, paramArrayOfByte2, paramInt);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("OnVerifyCode found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void OnVerifySMSVerifyLoginCode(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnVerifySMSVerifyLoginCode ret =");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" mobile=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" msgCode=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      if (paramErrMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OnVerifySMSVerifyLoginCode errMsg =");
        ((StringBuilder)localObject).append(paramErrMsg.getMessage());
        QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramString1, paramString2, paramWUserSigInfo, paramInt, paramErrMsg);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("OnVerifySMSVerifyLoginAccount found unknown userSigInfo ");
    paramString1.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString1.toString());
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    p localp = n.b(paramWUserSigInfo);
    if (localp != null)
    {
      localp.a(paramString, paramLong1, paramInt1, paramLong2, paramArrayOfByte1, paramLong3, paramLong4, paramLong5, paramArrayOfByte2, paramArrayOfByte3, paramWUserSigInfo, paramWFastLoginInfo, paramInt2, paramErrMsg);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("onGetA1WithA1 found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
  
  public void onLoginByGateway(int paramInt, WUserSigInfo paramWUserSigInfo, String paramString, ErrMsg paramErrMsg, HashMap paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoginByGateway ret =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      if (paramErrMsg != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onLoginByGateway errMsg =");
        ((StringBuilder)localObject).append(paramErrMsg.getMessage());
        QLog.d("WtloginCenterCallback", 4, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = n.b(paramWUserSigInfo);
    if (localObject != null)
    {
      ((p)localObject).a(paramInt, paramWUserSigInfo, paramString, paramErrMsg, paramHashMap);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("onLoginByGateway found unknown userSigInfo ");
    paramString.append(paramWUserSigInfo);
    QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.o
 * JD-Core Version:    0.7.0.1
 */