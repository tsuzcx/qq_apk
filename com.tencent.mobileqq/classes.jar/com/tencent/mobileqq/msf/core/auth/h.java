package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class h
  implements Runnable
{
  h(d paramd, String paramString) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", this.a, "login.chgTok_WEBVIEW_KEY");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localToServiceMsg.setAppId(this.b.e.a.getMsfAppid());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.getAttributes().put("refresh_token_src", "AccountTokenChecker");
    this.b.e.a.changeTokenAfterLogin(localToServiceMsg, true);
    QLog.d("MSF.C.TokenChecker", 1, "refresh webKey indeed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.h
 * JD-Core Version:    0.7.0.1
 */