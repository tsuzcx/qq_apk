package com.tencent.tkd.weibo.tweetTopic.recentTopic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RecentTopicLayout$updateTweetItems$2
  implements View.OnClickListener
{
  RecentTopicLayout$updateTweetItems$2(RecentTopicLayout paramRecentTopicLayout, TweetTopicItem paramTweetTopicItem) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicRecentTopicRecentTopicLayout.a();
    if (paramView != null)
    {
      TweetTopicItem localTweetTopicItem = this.jdField_a_of_type_ComTencentTkdWeiboBeanTweetTopicItem;
      Intrinsics.checkExpressionValueIsNotNull(localTweetTopicItem, "topicItem");
      paramView = (Unit)paramView.invoke(localTweetTopicItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.recentTopic.RecentTopicLayout.updateTweetItems.2
 * JD-Core Version:    0.7.0.1
 */