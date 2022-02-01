package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.mvp.BaseListAdapter;
import com.tencent.tkd.topicsdk.mvp.BaseListView;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import com.tencent.tkd.weibo.component.R.string;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initSearchResultView$1", "Lcom/tencent/tkd/topicsdk/mvp/BaseListView;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "adapter", "Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/mvp/BaseListAdapter;", "getEmptyText", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicView$initSearchResultView$1
  extends BaseListView<TweetTopicItem>
{
  TweetTopicView$initSearchResultView$1(Context paramContext1, Context paramContext2, ListPresenter paramListPresenter)
  {
    super(paramListPresenter, localListPresenter);
  }
  
  @NotNull
  public BaseListAdapter<TweetTopicItem> getAdapter()
  {
    return (BaseListAdapter)TweetTopicView.f(this.a);
  }
  
  @NotNull
  public String getEmptyText()
  {
    String str = this.b.getResources().getString(R.string.g);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…_search_topic_empty_tips)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initSearchResultView.1
 * JD-Core Version:    0.7.0.1
 */