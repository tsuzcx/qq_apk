package com.tencent.tkd.topicsdk;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/TopicConfig;", "", "()V", "listeners", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/tkd/topicsdk/TopicConfig$TopicListener;", "value", "", "Lcom/tencent/tkd/topicsdk/TopicItem;", "topicList", "getTopicList", "()Ljava/util/List;", "setTopicList", "(Ljava/util/List;)V", "addListener", "", "listener", "notifyListeners", "oldList", "newList", "removeListener", "TopicListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicConfig
{
  public static final TopicConfig a;
  @NotNull
  private static List<TopicItem> jdField_a_of_type_JavaUtilList = CollectionsKt.emptyList();
  private static final ConcurrentLinkedQueue<WeakReference<TopicConfig.TopicListener>> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkTopicConfig = new TopicConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicConfig
 * JD-Core Version:    0.7.0.1
 */