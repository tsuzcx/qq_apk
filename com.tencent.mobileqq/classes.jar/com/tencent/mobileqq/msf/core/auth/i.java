package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class i
  implements Runnable
{
  i(d paramd, String paramString) {}
  
  public void run()
  {
    long l3 = System.currentTimeMillis();
    long l4 = d.a(this.b, this.a);
    long l2 = a.ai();
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 21600000L;
    }
    l1 = d.a(this.b) + l1;
    Object localObject = new StringBuilder().append("changeWebkeyByAccount for ").append(MsfSdkUtils.getShortUin(this.a)).append(" now: ").append(l3).append(" lastCheckWebviewKeyTime: ").append(l4).append(" interval: ").append(l3 - l4).append(" needChangeToken: ");
    if (l3 - l4 > l1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("MSF.C.TokenChecker", 1, bool);
      if ((l3 - l4 > l1) || (this.b.e.a.getWtLoginCenter().b(this.a)))
      {
        localObject = new ToServiceMsg("", this.a, "login.chgTok_WEBVIEW_KEY");
        ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
        ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
        ((ToServiceMsg)localObject).setAppId(this.b.e.a.getMsfAppid());
        ((ToServiceMsg)localObject).setTimeout(30000L);
        ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
        this.b.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
        QLog.d("MSF.C.TokenChecker", 1, "changeWebkeyByAccount for " + MsfSdkUtils.getShortUin(this.a) + " renew webKey");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.i
 * JD-Core Version:    0.7.0.1
 */