package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SearchTopicListModel$onEmptyTopicLoaded$2
  implements Runnable
{
  SearchTopicListModel$onEmptyTopicLoaded$2(Function7 paramFunction7) {}
  
  public final void run()
  {
    Function7 localFunction7 = this.a;
    Boolean localBoolean = Boolean.valueOf(true);
    Integer localInteger = Integer.valueOf(0);
    localFunction7.invoke(localBoolean, localBoolean, localInteger, new ArrayList(), null, localInteger, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.onEmptyTopicLoaded.2
 * JD-Core Version:    0.7.0.1
 */