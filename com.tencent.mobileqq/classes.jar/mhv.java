import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import org.json.JSONException;
import org.json.JSONObject;

public class mhv
  implements Runnable
{
  public mhv(VideoFeedsPlayManager paramVideoFeedsPlayManager, JSONObject paramJSONObject, mhy parammhy, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_OrgJsonJSONObject)
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("watch_duration", this.jdField_a_of_type_Mhy.a);
          this.jdField_a_of_type_OrgJsonJSONObject.put("current_duration", this.jdField_a_of_type_Mhy.b);
          this.jdField_a_of_type_OrgJsonJSONObject.put("is_loop", this.jdField_a_of_type_Int);
          String str1;
          if (VideoFeedsPlayManager.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager))
          {
            str4 = this.jdField_a_of_type_JavaLangString;
            i = this.jdField_b_of_type_Int;
            j = this.jdField_c_of_type_Int;
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              break;
            }
            str1 = this.jdField_b_of_type_JavaLangString;
            PublicAccountReportUtils.b(null, str4, "0X8009297", "0X8009297", 0, 0, String.valueOf(i), String.valueOf(j), str1, VideoReporter.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mhy.b, this.jdField_a_of_type_OrgJsonJSONObject), false);
            PublicAccountReportUtils.a("0X8009297", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_c_of_type_Int), "", VideoReporter.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mhy.b, this.jdField_a_of_type_OrgJsonJSONObject));
            return;
          }
          String str4 = this.jdField_a_of_type_JavaLangString;
          int i = this.jdField_b_of_type_Int;
          int j = this.jdField_c_of_type_Int;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            str1 = this.jdField_b_of_type_JavaLangString;
            PublicAccountReportUtils.b(null, str4, "0X8007409", "0X8007409", 0, 0, String.valueOf(i), String.valueOf(j), str1, VideoReporter.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mhy.b, this.jdField_a_of_type_OrgJsonJSONObject), false);
            PublicAccountReportUtils.a("0X8007409", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_c_of_type_Int), "", VideoReporter.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Mhy.b, this.jdField_a_of_type_OrgJsonJSONObject));
          }
        }
        String str2 = "0";
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        continue;
        String str3 = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhv
 * JD-Core Version:    0.7.0.1
 */