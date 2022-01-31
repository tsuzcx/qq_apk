import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mzi
  implements Runnable
{
  public mzi(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.m, 0);
    localCompressInfo.f = 0;
    CompressOperator.a(localCompressInfo);
    String str;
    if (!StringUtil.a(localCompressInfo.e))
    {
      str = "mqqpa://resourceid/" + this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.o;
      PublicAccountH5AbilityPlugin.b.put(str, localCompressInfo.e);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONArray.put(0, str);
        this.jdField_a_of_type_OrgJsonJSONObject.put("value", this.jdField_a_of_type_OrgJsonJSONArray);
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 0);
        this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "Success");
        this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "camera");
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.callJs(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.n, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.m = "";
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.n = "";
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.o = "";
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", -1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("msg", "compress fail");
        this.jdField_a_of_type_OrgJsonJSONObject.put("sourceType", "camera");
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.callJs(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.n, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzi
 * JD-Core Version:    0.7.0.1
 */