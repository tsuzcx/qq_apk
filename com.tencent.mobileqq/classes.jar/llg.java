import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.MessageForStructing;
import org.json.JSONException;
import org.json.JSONObject;

public final class llg
  implements Runnable
{
  public llg(MessageForStructing paramMessageForStructing, RecentBaseData paramRecentBaseData, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = new JSONObject();
    boolean bool = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
        if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
        {
          str1 = "";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.b != 1) {
            continue;
          }
          str1 = "1";
          localJSONObject.put("reddot_style", str1);
          localJSONObject.put("algorithm_id", WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
        }
        localJSONObject.put("EnterType", this.jdField_a_of_type_JavaLangString);
      }
      catch (JSONException localJSONException)
      {
        String str1;
        String str2;
        localJSONException.printStackTrace();
        continue;
      }
      str2 = "0";
      str1 = "0";
      if (bool)
      {
        str2 = WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
        str1 = WeishiReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing);
      }
      WeishiReportUtil.a(str2, str1, "0X8009291", localJSONObject.toString());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.b == 2) {
        str1 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llg
 * JD-Core Version:    0.7.0.1
 */