package cooperation.ilive.plugin;

import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import cooperation.ilive.util.ElapseStat;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

final class LiveAuth$2
  implements Runnable
{
  LiveAuth$2(String paramString1, String paramString2, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = LiveAuth.access$200(new URL(LiveAuth.access$100(this.val$accountId, this.val$authKey, "1037", "16594", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getIMEIForReport(), "10000", "1037")), null);
      if (new JSONObject(new String((byte[])localObject)).getInt("retcode") != 0)
      {
        localObject = "fail";
      }
      else
      {
        IlivePluginManager.getInstance().savePluginToken(new String((byte[])localObject));
        IlivePluginManager.getInstance().savePluginTokenValidTime(System.currentTimeMillis());
        IlivePluginManager.sIsFastStart = true;
        localObject = "success";
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("status", localObject);
      VasStatisticCollector.a("login_auth", localHashMap, System.currentTimeMillis() - this.val$authTime);
      ElapseStat.b("liveToken");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.plugin.LiveAuth.2
 * JD-Core Version:    0.7.0.1
 */