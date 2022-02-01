package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SearchTopicListModel$loadDataFromNetwork$1$1
  implements Runnable
{
  SearchTopicListModel$loadDataFromNetwork$1$1(SearchTopicListModel.loadDataFromNetwork.1 param1, int paramInt, boolean paramBoolean, List paramList, byte[] paramArrayOfByte, String paramString) {}
  
  public final void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      Function7 localFunction7 = this.this$0.$callback;
      boolean bool = this.jdField_a_of_type_Boolean;
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {}
      for (localObject = (Collection)localObject;; localObject = (Collection)CollectionsKt.emptyList())
      {
        localFunction7.invoke(Boolean.valueOf(true), Boolean.valueOf(bool), Integer.valueOf(0), new ArrayList((Collection)localObject), this.jdField_a_of_type_ArrayOfByte, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), Boolean.valueOf(true), Integer.valueOf(0), new ArrayList(), null, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */