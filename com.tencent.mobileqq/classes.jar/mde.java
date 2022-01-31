import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import org.json.JSONObject;

public class mde
  implements Runnable
{
  public mde(VideoFeedsPlayManager paramVideoFeedsPlayManager, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (VideoFeedsPlayManager.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager))
    {
      str2 = this.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_Int;
      j = this.jdField_b_of_type_Int;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
      for (str1 = this.jdField_b_of_type_JavaLangString;; str1 = "0")
      {
        PublicAccountReportUtils.b(null, str2, "0X8009297", "0X8009297", 0, 0, String.valueOf(i), String.valueOf(j), str1, VideoReporter.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_OrgJsonJSONObject), false);
        PublicAccountReportUtils.a("0X8009297", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_b_of_type_Int), "", VideoReporter.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_OrgJsonJSONObject));
        return;
      }
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (String str1 = this.jdField_b_of_type_JavaLangString;; str1 = "0")
    {
      PublicAccountReportUtils.b(null, str2, "0X8007409", "0X8007409", 0, 0, String.valueOf(i), String.valueOf(j), str1, VideoReporter.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_OrgJsonJSONObject), false);
      PublicAccountReportUtils.a("0X8007409", this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), String.valueOf(this.jdField_b_of_type_Int), "", VideoReporter.a(this.c, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_OrgJsonJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mde
 * JD-Core Version:    0.7.0.1
 */