package cooperation.qlink;

import abqn;
import biox;
import bioy;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import org.json.JSONException;
import org.json.JSONObject;

public class QlinkLeakHelper$2$1
  implements Runnable
{
  public QlinkLeakHelper$2$1(bioy parambioy) {}
  
  public void run()
  {
    Object localObject1 = abqn.a("mobile_qlink_leak");
    Object localObject2;
    if (((Boolean)localObject1[0]).booleanValue())
    {
      localObject2 = (String)localObject1[1];
      biox.a((String)localObject2);
    }
    try
    {
      if (!"0".equals("6b98d0b0"))
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
 * Qualified Name:     cooperation.qlink.QlinkLeakHelper.2.1
 * JD-Core Version:    0.7.0.1
 */