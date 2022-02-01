package com.tencent.mobileqq.msf.core.auth;

import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.MsfCore;
import java.util.HashMap;
import oicq.wlogin_sdk.listener.ReportListener;

public class l$b
  implements ReportListener
{
  public void onReport(String paramString, HashMap paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if ((MsfCore.sCore != null) && (MsfCore.sCore.getAccountCenter() != null)) {
      str = MsfCore.sCore.getAccountCenter().i();
    } else {
      str = "";
    }
    paramHashMap.put("account_uin", str);
    UserAction.onUserAction(paramString, true, 0L, 0L, paramHashMap, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.l.b
 * JD-Core Version:    0.7.0.1
 */