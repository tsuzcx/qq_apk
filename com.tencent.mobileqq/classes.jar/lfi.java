import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lfi
  implements Runnable
{
  public lfi(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void run()
  {
    if (ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) == 6) {}
    for (;;)
    {
      Object localObject;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsFollowed) {
          break label202;
        }
        String str1 = "1";
        localJSONObject.put("is_followed", str1);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsTopic) {
          break label208;
        }
        str1 = "0X80088BB";
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsTopic)
        {
          localObject = "0X80088BB";
          PublicAccountReportUtils.a(null, "", str1, (String)localObject, 0, 0, "2", "", "", VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelID, localJSONObject), false);
          return;
        }
        localObject = "0X8007BE6";
        continue;
        if (ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) != 8) {
          break label201;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsFollowed)
          {
            String str2 = "1";
            ((JSONObject)localObject).put("is_followed", str2);
            ((JSONObject)localObject).put("channel_id", 409409);
            PublicAccountReportUtils.a(null, "", "0X80088BB", "0X80088BB", 0, 0, "3", "", "", VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelID, (JSONObject)localObject), false);
            return;
          }
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
          return;
        }
        str3 = "0";
      }
      label201:
      return;
      label202:
      String str3 = "0";
      continue;
      label208:
      str3 = "0X8007BE6";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfi
 * JD-Core Version:    0.7.0.1
 */