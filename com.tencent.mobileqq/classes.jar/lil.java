import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class lil
  implements Runnable
{
  public lil(ChannelCoverView paramChannelCoverView, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("is_followed", "1");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mIsTopic)
        {
          String str1 = "0X80088BB";
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mIsTopic)
          {
            str3 = "0X80088BB";
            PublicAccountReportUtils.a(null, "", str1, str3, 0, 0, "1", "", "", VideoReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId, localJSONObject), false);
            return;
          }
          String str3 = "0X8007BE6";
          continue;
        }
        String str2 = "0X8007BE6";
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lil
 * JD-Core Version:    0.7.0.1
 */