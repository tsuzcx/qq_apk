package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SearchTopicListModel$onTopicListLoadFailed$1
  implements Runnable
{
  SearchTopicListModel$onTopicListLoadFailed$1(Function7 paramFunction7, int paramInt, String paramString) {}
  
  public final void run()
  {
    this.a.invoke(Boolean.valueOf(false), Boolean.valueOf(true), Integer.valueOf(0), new ArrayList(), null, Integer.valueOf(this.b), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.onTopicListLoadFailed.1
 * JD-Core Version:    0.7.0.1
 */