package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.tkd.weibo.R.id;
import com.tencent.tkd.weibo.R.string;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.framework.mvp.BaseListAdapter;
import com.tencent.tkd.weibo.framework.mvp.BaseListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initSearchResultView$1", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListView;", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "adapter", "Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "getAdapter", "()Lcom/tencent/tkd/weibo/framework/mvp/BaseListAdapter;", "setCenterEmpty", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicView$initSearchResultView$1
  extends BaseListView<TweetTopicItem>
{
  @NotNull
  public BaseListAdapter<TweetTopicItem> a()
  {
    return (BaseListAdapter)TweetTopicView.a(this.jdField_a_of_type_ComTencentTkdWeiboTweetTopicTweetTopicView);
  }
  
  public void setCenterEmpty()
  {
    super.setCenterEmpty();
    TextView localTextView = (TextView)a(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tv_empty");
    localTextView.setText((CharSequence)this.jdField_a_of_type_AndroidContentContext.getResources().getString(R.string.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initSearchResultView.1
 * JD-Core Version:    0.7.0.1
 */