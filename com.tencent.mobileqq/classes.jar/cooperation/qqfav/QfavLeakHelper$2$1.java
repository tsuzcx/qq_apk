package cooperation.qqfav;

import abvc;
import bivi;
import bivj;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import org.json.JSONException;
import org.json.JSONObject;

public class QfavLeakHelper$2$1
  implements Runnable
{
  public QfavLeakHelper$2$1(bivj parambivj) {}
  
  public void run()
  {
    Object localObject1 = abvc.a("mobile_Qfav_leak");
    Object localObject2;
    if (((Boolean)localObject1[0]).booleanValue())
    {
      localObject2 = (String)localObject1[1];
      bivi.a((String)localObject2);
    }
    try
    {
      if (!"0".equals(AppSetting.g()))
      {
        localObject1 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fileObj1", localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("p_id", "287");
        ((JSONObject)localObject2).put("plugin", String.valueOf(7));
        ((JSONObject)localObject1).put("fileObj", localJSONObject);
        ((JSONObject)localObject1).put("clientinfo", localObject2);
        ((JSONObject)localObject1).put("newplugin", 107);
        ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, MagnifierSDK.a));
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.QfavLeakHelper.2.1
 * JD-Core Version:    0.7.0.1
 */