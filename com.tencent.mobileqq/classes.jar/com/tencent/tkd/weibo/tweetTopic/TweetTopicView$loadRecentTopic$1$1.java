package com.tencent.tkd.weibo.tweetTopic;

import com.tencent.tkd.topicsdk.widget.RecentTopicLayout;
import com.tencent.tkd.weibo.UiComponentSdk;
import com.tencent.tkd.weibo.UiComponentSdk.Companion;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TweetTopicView$loadRecentTopic$1$1
  implements Runnable
{
  TweetTopicView$loadRecentTopic$1$1(TweetTopicView.loadRecentTopic.1 param1, int paramInt, List paramList) {}
  
  public final void run()
  {
    if (this.a == 0)
    {
      List localList = this.b;
      if ((localList != null) && ((((Collection)localList).isEmpty() ^ true)))
      {
        TweetTopicView.a(this.this$0.this$0).setVisibility(0);
        TweetTopicView.a(this.this$0.this$0).a(this.b, UiComponentSdk.a.a().c());
        return;
      }
    }
    TweetTopicView.a(this.this$0.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.loadRecentTopic.1.1
 * JD-Core Version:    0.7.0.1
 */