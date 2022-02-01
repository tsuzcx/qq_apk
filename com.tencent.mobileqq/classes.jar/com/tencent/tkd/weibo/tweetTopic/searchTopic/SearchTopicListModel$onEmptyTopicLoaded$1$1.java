package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SearchTopicListModel$onEmptyTopicLoaded$1$1
  implements Runnable
{
  SearchTopicListModel$onEmptyTopicLoaded$1$1(SearchTopicListModel.onEmptyTopicLoaded.1 param1) {}
  
  public final void run()
  {
    Function7 localFunction7 = this.this$0.$callback;
    Boolean localBoolean = Boolean.valueOf(true);
    localFunction7.invoke(localBoolean, localBoolean, Integer.valueOf(this.this$0.$result.size()), this.this$0.$result, null, Integer.valueOf(0), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.onEmptyTopicLoaded.1.1
 * JD-Core Version:    0.7.0.1
 */