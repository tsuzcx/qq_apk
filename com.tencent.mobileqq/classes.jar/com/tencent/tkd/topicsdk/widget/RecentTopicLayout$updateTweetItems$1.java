package com.tencent.tkd.topicsdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RecentTopicLayout$updateTweetItems$1
  implements View.OnClickListener
{
  RecentTopicLayout$updateTweetItems$1(RecentTopicLayout paramRecentTopicLayout, TweetTopicItem paramTweetTopicItem) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a.getOnItemClickListener();
    if (paramView != null) {
      paramView = (Unit)paramView.invoke(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.RecentTopicLayout.updateTweetItems.1
 * JD-Core Version:    0.7.0.1
 */