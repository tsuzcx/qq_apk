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
    Object localObject = new ToServiceMsg("", this.a, "login.chgTok_A2D2");
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
    ((ToServiceMsg)localObject).getAttributes().put("to_login_token_cmdhead", Integer.valueOf(9));
    ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).setAppId(this.b.e.a.getMsfAppid());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    HashMap localHashMap = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 34869344L;
    localRequestCustomSig.reserved = new byte[0];
    localHashMap.put("RequestCustomSig", localRequestCustomSig);
    ((ToServiceMsg)localObject).getAttributes().put("to_login_token_map", localHashMap);
    this.b.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkToken renew A/D for ");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(this.a));
    QLog.d("MSF.C.TokenChecker", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.g
 * JD-Core Version:    0.7.0.1
 */