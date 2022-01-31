import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper;

public class lzh
  implements Runnable
{
  public lzh(TopicShareHelper paramTopicShareHelper, String paramString) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X80088B4", "0X80088B4", 0, 0, "", this.jdField_a_of_type_JavaLangString, "", VideoReporter.a(TopicShareHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoTopicShareHelper).mChannelID, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzh
 * JD-Core Version:    0.7.0.1
 */