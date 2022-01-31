import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class mud
  implements TroopMemberApiClient.Callback
{
  public mud(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    String str2;
    JSONObject localJSONObject;
    if (paramBundle != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.l();
      }
      str2 = paramBundle.getString("pic_local_id");
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        if (!"-1".equals(str2)) {
          continue;
        }
        localJSONObject.put("retCode", -1);
        localJSONObject.put("msg", "fail");
        if (!this.jdField_a_of_type_Boolean) {
          continue;
        }
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
        paramBundle = str2;
        localJSONObject.put("localId", paramBundle);
      }
      catch (JSONException paramBundle)
      {
        String str1;
        paramBundle.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.c(this.b);
      }
      return;
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
      paramBundle = str2;
      continue;
      str1 = str2;
      if (this.jdField_a_of_type_Boolean) {
        str1 = "mqqpa://resourceid/" + str2;
      }
      paramBundle = paramBundle.getString("pic_local_path");
      PublicAccountH5AbilityPlugin.b.put(str1, paramBundle);
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "下载成功，localld为" + str1);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountH5AbilityPlugin", 2, "下载成功，localld为  " + str1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
      else
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 0, "1", "", "", "");
        paramBundle = str1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mud
 * JD-Core Version:    0.7.0.1
 */