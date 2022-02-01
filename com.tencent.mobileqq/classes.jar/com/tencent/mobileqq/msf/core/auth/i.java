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
    l1 += d.a(this.b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("changeWebkeyByAccount for ");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(this.a));
    ((StringBuilder)localObject).append(" now: ");
    ((StringBuilder)localObject).append(l3);
    ((StringBuilder)localObject).append(" lastCheckWebviewKeyTime: ");
    ((StringBuilder)localObject).append(l4);
    ((StringBuilder)localObject).append(" interval: ");
    l2 = l3 - l4;
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" needChangeToken: ");
    boolean bool;
    if (l2 > l1) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.d("MSF.C.TokenChecker", 1, ((StringBuilder)localObject).toString());
    if ((l2 > l1) || (this.b.e.a.getWtLoginCenter().b(this.a)))
    {
      localObject = new ToServiceMsg("", this.a, "login.chgTok_WEBVIEW_KEY");
      ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setAppId(this.b.e.a.getMsfAppid());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
      this.b.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeWebkeyByAccount for ");
      ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(this.a));
      ((StringBuilder)localObject).append(" renew webKey");
      QLog.d("MSF.C.TokenChecker", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.i
 * JD-Core Version:    0.7.0.1
 */