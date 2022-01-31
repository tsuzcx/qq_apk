package cooperation.qqdataline;

import bgol;
import bgom;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import org.json.JSONException;
import org.json.JSONObject;
import zzt;

public class DatalineLeakHelper$2$1
  implements Runnable
{
  public DatalineLeakHelper$2$1(bgom parambgom) {}
  
  public void run()
  {
    Object localObject1 = zzt.a("mobile_dataline_leak");
    Object localObject2;
    if (((Boolean)localObject1[0]).booleanValue())
    {
      localObject2 = (String)localObject1[1];
      bgol.a((String)localObject2);
    }
    try
    {
      if (!"0".equals("a15c4095"))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqdataline.DatalineLeakHelper.2.1
 * JD-Core Version:    0.7.0.1
 */