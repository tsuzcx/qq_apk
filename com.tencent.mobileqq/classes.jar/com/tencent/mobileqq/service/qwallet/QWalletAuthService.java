package com.tencent.mobileqq.service.qwallet;

import QQWalletPay.ReqCheckChangePwdAuth;
import QQWalletPay.RespCheckChangePwdAuth;
import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import Wallet.PfaFriendRqt;
import Wallet.PfaFriendRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletAuthService
  extends BaseProtocolCoder
{
  private static final String[] a = { "QQWalletPayAuthServer", "AdvRuleSvrCmd", "WalletGestureSvc", "VacThirdCodeSvc", "QWalletPfa" };
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (RespCheckChangePwdAuth)paramToServiceMsg.getByClass("resp", new RespCheckChangePwdAuth());
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeModifyPassAuthWUP error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
      return null;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeModifyPassAuthWUP error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
    }
    return null;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.OpenPayServer.QQWalletPayAuthObj");
    paramUniPacket.setFuncName("checkChangePwdAuth");
    paramUniPacket.put("req", (ReqCheckChangePwdAuth)paramToServiceMsg.extraData.getSerializable("ReqCheckChangePwdAuth"));
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (GetPasswordRsp)paramToServiceMsg.getByClass("rsp", new GetPasswordRsp());
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetPasswordWUP error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
      return null;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetPasswordWUP error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.GesturePasswordServer.GesturePasswordObj");
    paramUniPacket.setFuncName("GetPassword");
    paramUniPacket.put("req", (GetPasswordReq)paramToServiceMsg.extraData.getSerializable("GetPasswordReq"));
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (AuthCodeRsp)paramToServiceMsg.getByClass("rsp", new AuthCodeRsp());
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetAuthCode error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
      return null;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetAuthCode error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
    paramUniPacket.setFuncName("fetchCodes");
    paramUniPacket.put("req", (AuthCodeReq)paramToServiceMsg.extraData.getSerializable("AuthCodeReq"));
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (PfaFriendRsp)paramToServiceMsg.getByClass("rsp", new PfaFriendRsp());
      return paramToServiceMsg;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetRecentList error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
      return null;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      if (QLog.isDevelopLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeGetRecentList error:");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("Q.qwallet.auth.AuthService", 4, paramFromServiceMsg.toString());
      }
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("Wallet.WalletFriendQueryServer.WalletFriendObj");
    paramUniPacket.setFuncName("QueryRecommendFriend");
    paramUniPacket.put("rqt", (PfaFriendRqt)paramToServiceMsg.extraData.getSerializable("PfaFriendRqt"));
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if (str.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if (str.compareTo("QWalletPfa.RecFriend") == 0) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if (str.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (str.compareTo("WalletGestureSvc.GetPassword") == 0) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (str.compareTo("VacThirdCodeSvc.fetchCodes") == 0) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (str.compareTo("QWalletPfa.RecFriend") == 0) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qwallet.QWalletAuthService
 * JD-Core Version:    0.7.0.1
 */