package com.tencent.mobileqq.kandian.repo.follow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

class FollowCoverInfoModule$2
  implements Runnable
{
  FollowCoverInfoModule$2(FollowCoverInfoModule paramFollowCoverInfoModule, TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo) {}
  
  public void run()
  {
    Object localObject = RIJSPUtils.a(FollowCoverInfoModule.a(this.this$0), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = this.a;
        if (localTopicRecommendFeedsInfo == null) {
          ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info");
        } else {
          ((SharedPreferences.Editor)localObject).putString("follow_tab_topic_update_info", Base64.encodeToString(localTopicRecommendFeedsInfo.a().toByteArray(), 0));
        }
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_topic_update_info_exists", FollowCoverInfoModule.b(this.this$0));
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowCoverInfoModule.2
 * JD-Core Version:    0.7.0.1
 */