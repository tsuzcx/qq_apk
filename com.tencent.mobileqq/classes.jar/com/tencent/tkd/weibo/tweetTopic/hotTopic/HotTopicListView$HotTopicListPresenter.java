package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.framework.mvp.ListContract.IListModel;
import com.tencent.tkd.weibo.framework.mvp.ListContract.IListView;
import com.tencent.tkd.weibo.framework.mvp.ListPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/HotTopicListView$HotTopicListPresenter;", "Lcom/tencent/tkd/weibo/framework/mvp/ListPresenter;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "model", "Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/TweetHotTopicListModel;", "(Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/TweetHotTopicListModel;)V", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class HotTopicListView$HotTopicListPresenter
  extends ListPresenter<TweetTopicItem, ListContract.IListView<TweetTopicItem>>
{
  public HotTopicListView$HotTopicListPresenter(@NotNull TweetHotTopicListModel paramTweetHotTopicListModel)
  {
    super((ListContract.IListModel)paramTweetHotTopicListModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView.HotTopicListPresenter
 * JD-Core Version:    0.7.0.1
 */