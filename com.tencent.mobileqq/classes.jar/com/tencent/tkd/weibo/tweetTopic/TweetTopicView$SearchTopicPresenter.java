package com.tencent.tkd.weibo.tweetTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.framework.mvp.ListContract.IListModel;
import com.tencent.tkd.weibo.framework.mvp.ListContract.IListView;
import com.tencent.tkd.weibo.framework.mvp.ListPresenter;
import com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/TweetTopicView$SearchTopicPresenter;", "Lcom/tencent/tkd/weibo/framework/mvp/ListPresenter;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "model", "Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "(Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;)V", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicView$SearchTopicPresenter
  extends ListPresenter<TweetTopicItem, ListContract.IListView<TweetTopicItem>>
{
  public TweetTopicView$SearchTopicPresenter(@NotNull SearchTopicListModel paramSearchTopicListModel)
  {
    super((ListContract.IListModel)paramSearchTopicListModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.SearchTopicPresenter
 * JD-Core Version:    0.7.0.1
 */