import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class seg
  implements View.OnClickListener
{
  public seg(VideoFeedsTopicViewGroup paramVideoFeedsTopicViewGroup, VideoInfo.ChannelInfo paramChannelInfo) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c)) {
        pha.a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.c);
      }
    }
    else
    {
      str = new skc("", "", VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).jdField_a_of_type_JavaLangString, VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).g).t(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int).u(ryx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo)).a(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup).B).a().a();
      if (!VideoFeedsTopicViewGroup.a()) {
        break label192;
      }
      oat.a(null, "", "0X8009331", "0X8009331", 0, 0, "3", "", "", str, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ohp.b(VideoFeedsTopicViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ChannelInfo.b, 8, null);
      break;
      label192:
      oat.a(null, "", "0X80092F9", "0X80092F9", 0, 0, "3", "", "", str, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     seg
 * JD-Core Version:    0.7.0.1
 */