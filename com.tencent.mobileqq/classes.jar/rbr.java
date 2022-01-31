import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class rbr
  implements Runnable
{
  public rbr(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper) {}
  
  public void run()
  {
    Object localObject7;
    long l1;
    long l2;
    try
    {
      ??? = "https://cgi.connect.qq.com/mqqapi/privilege_group_config?platform=1&platform_version=7.6.0&data_version=" + this.a.b;
      Object localObject4 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject4 == null)
      {
        QLog.e("DoraemonOpenAPI.permissionHelper", 1, "app is null");
        return;
      }
      localObject7 = (TicketManager)((AppRuntime)localObject4).getManager(2);
      localObject4 = ((AppRuntime)localObject4).getAccount();
      localObject7 = ((TicketManager)localObject7).getSkey((String)localObject4);
      Bundle localBundle = new Bundle();
      localBundle.putString("Cookie", "uin=" + (String)localObject4 + ";skey=" + (String)localObject7);
      ??? = new JSONObject(HttpUtil.a(BaseApplicationImpl.getApplication(), (String)???, "GET", null, localBundle));
      int i = ((JSONObject)???).getInt("retcode");
      QLog.i("DoraemonOpenAPI.permissionHelper", 1, "checkup code=" + i);
      if (i != 0) {
        return;
      }
      ??? = ((JSONObject)???).getJSONObject("result");
      l1 = ((JSONObject)???).getLong("version");
      l2 = ((JSONObject)???).getLong("next_req_duration") * 1000L;
      if (this.a.b == l1)
      {
        QLog.i("DoraemonOpenAPI.permissionHelper", 1, "no update, next=" + l2 + ", ver=" + l1);
        synchronized (this.a.jdField_a_of_type_JavaLangObject)
        {
          this.a.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
          return;
        }
      }
      localJSONObject = localThrowable.getJSONObject("list");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoraemonOpenAPI.permissionHelper", 1, "checkup error", localThrowable);
      return;
    }
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      JSONObject localJSONObject;
      this.a.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + Math.max(300000L, l2));
      this.a.b = l1;
      localObject7 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.permissionHelper", 2, "checkup, next=" + l2 + ", ver=" + l1 + ", list=" + (String)localObject7);
      }
      synchronized (this.a)
      {
        this.a.jdField_a_of_type_OrgJsonJSONObject = localJSONObject;
        this.a.jdField_a_of_type_JavaUtilMap.clear();
        BaseApplicationImpl.getApplication().getSharedPreferences("DoraemonApiGroup.json", 4).edit().putString("content", (String)localObject7).putLong("version", l1).apply();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbr
 * JD-Core Version:    0.7.0.1
 */