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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import org.json.JSONObject;

public class mic
  implements View.OnClickListener
{
  public mic(VideoFeedsTopicViewGroup paramVideoFeedsTopicViewGroup, VideoInfo.ChannelInfo paramChannelInfo) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject;
    if (VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c)) {
        ReadInJoyUtils.a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c);
      }
    }
    else {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("topic_id", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int);
        localJSONObject.put("jump_to", VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo));
        if (VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).q == null) {
          continue;
        }
        paramView = VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).q;
        localJSONObject.put("video_report_info", paramView);
      }
      catch (Exception paramView)
      {
        continue;
      }
      if (!VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup)) {
        continue;
      }
      PublicAccountReportUtils.a(null, "", "0X8009331", "0X8009331", 0, 0, "3", "", "", VideoReporter.a("", "", VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).jdField_a_of_type_JavaLangString, VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).g, localJSONObject), false);
      return;
      ReadInJoyActivityHelper.b(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.b, 8, null);
      break;
      paramView = "";
    }
    PublicAccountReportUtils.a(null, "", "0X80092F9", "0X80092F9", 0, 0, "3", "", "", VideoReporter.a("", "", VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).jdField_a_of_type_JavaLangString, VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).g, localJSONObject), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mic
 * JD-Core Version:    0.7.0.1
 */