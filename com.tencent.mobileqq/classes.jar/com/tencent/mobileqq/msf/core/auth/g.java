package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class g
  implements Runnable
{
  g(d paramd, String paramString) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", this.a, "login.chgTok_A2D2");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
    localToServiceMsg.getAttributes().put("to_login_token_cmdhead", Integer.valueOf(9));
    localToServiceMsg.getAttributes().put("refresh_token_src", "AccountTokenChecker");
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localToServiceMsg.setAppId(this.b.e.a.getMsfAppid());
    localToServiceMsg.setTimeout(30000L);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 34869344L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    localToServiceMsg.getAttributes().put("to_login_token_map", localHashMap);
    this.b.e.a.changeTokenAfterLogin(localToServiceMsg, true);
    QLog.d("MSF.C.TokenChecker", 1, "checkToken renew A/D for " + MsfSdkUtils.getShortUin(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.g
 * JD-Core Version:    0.7.0.1
 */