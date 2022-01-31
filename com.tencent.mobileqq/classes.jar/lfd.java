import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;

public class lfd
  implements Runnable
{
  public lfd(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo, boolean paramBoolean) {}
  
  public void run()
  {
    String str1 = "3";
    if ((ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) == 4) || (ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) == 6))
    {
      str1 = "0";
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mIsTopic) {
        break label119;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str2 = "1";; str2 = "2")
    {
      PublicAccountReportUtils.a(null, "", "0X80088BC", "0X80088BC", 0, 0, str2, str1, "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity), null), false);
      return;
      if (ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) == 8)
      {
        str1 = "1";
        break;
      }
      if (ReadInJoyVideoSubChannelActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity) != 4) {
        break;
      }
      str1 = "2";
      break;
    }
    label119:
    if (this.jdField_a_of_type_Boolean) {}
    for (str2 = "1";; str2 = "2")
    {
      PublicAccountReportUtils.a(null, "", "0X8007BFE", "0X8007BFE", 0, 0, str2, str1, "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity), null), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */