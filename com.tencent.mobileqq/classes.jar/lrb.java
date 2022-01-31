import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import cooperation.readinjoy.ReadInJoyHelper;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;

public class lrb
  implements Runnable
{
  public lrb(FollowCoverInfoModule paramFollowCoverInfoModule, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(FollowCoverInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) {
          break label66;
        }
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info");
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).putInt("follow_tab_topic_update_info_exists", FollowCoverInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFollowCoverInfoModule));
      ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      return;
      label66:
      ((SharedPreferences.Editor)localObject).putString("follow_tab_topic_update_info", Base64.encodeToString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a().toByteArray(), 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrb
 * JD-Core Version:    0.7.0.1
 */