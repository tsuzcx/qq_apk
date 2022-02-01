package cooperation.ilive.lite;

import cooperation.ilive.manager.IliveAuthManager;
import java.util.HashMap;

final class IliveLiteMonitorUtil$1
  implements Runnable
{
  public void run()
  {
    IliveLiteMonitorUtil.a("live_first_auth_status");
    HashMap localHashMap = new HashMap();
    String str;
    if (IliveAuthManager.getInstance().getLocalIliveAuth(true) != null) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("has_auth", str);
    IliveLiteMonitorUtil.b(false);
    IliveLiteMonitorUtil.a("live_first_auth_status", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteMonitorUtil.1
 * JD-Core Version:    0.7.0.1
 */