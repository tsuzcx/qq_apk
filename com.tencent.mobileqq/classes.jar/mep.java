import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import org.json.JSONObject;

public class mep
  implements View.OnClickListener
{
  public mep(VideoFeedsTopicViewGroup paramVideoFeedsTopicViewGroup, VideoInfo.ChannelInfo paramChannelInfo) {}
  
  public void onClick(View paramView)
  {
    if ((VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup))) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo != null))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c)) {
        break label127;
      }
      ReadInJoyUtils.a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c);
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("topic_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int);
        label79:
        PublicAccountReportUtils.a(null, "", "0X80092F9", "0X80092F9", 0, 0, "3", "", "", VideoReporter.a("", "", VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).jdField_a_of_type_JavaLangString, VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).g, paramView), false);
        return;
        label127:
        ReadInJoyActivityHelper.b(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.b, 8, null);
      }
      catch (Exception localException)
      {
        break label79;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mep
 * JD-Core Version:    0.7.0.1
 */