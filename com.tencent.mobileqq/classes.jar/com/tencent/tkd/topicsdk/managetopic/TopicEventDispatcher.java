package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/TopicEventDispatcher;", "", "()V", "CODE_CREATE_CANCEL", "", "CODE_CREATE_FAIL", "CODE_CREATE_SUCCESS", "CODE_EDIT_CANCEL", "CODE_EDIT_SUCCESS", "createTopicListenerList", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "", "Lcom/tencent/tkd/topicsdk/managetopic/CreateTopicListener;", "editTopicListenerList", "Lcom/tencent/tkd/topicsdk/managetopic/EditTopicListener;", "addCreateTopicListener", "listener", "addEditTopicListener", "notifyTopicCreateCancel", "notifyTopicCreateFail", "notifyTopicCreateSuccess", "notifyTopicEditCancel", "notifyTopicEditSuccess", "removeCreateTopicListener", "removeEditTopicListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicEventDispatcher
{
  public static final TopicEventDispatcher a;
  private static final List<Function2<Integer, TopicInfo, Unit>> a;
  private static final List<Function2<Integer, TopicInfo, Unit>> b = (List)new ArrayList();
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkManagetopicTopicEventDispatcher = new TopicEventDispatcher();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  }
  
  public final void a()
  {
    Iterator localIterator = ((Iterable)jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(2), null);
    }
  }
  
  public final void a(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Iterator localIterator = ((Iterable)jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(0), paramTopicInfo);
    }
  }
  
  public final void a(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    jdField_a_of_type_JavaUtilList.add(paramFunction2);
  }
  
  public final void b()
  {
    Iterator localIterator = ((Iterable)jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(1), null);
    }
  }
  
  public final void b(@Nullable TopicInfo paramTopicInfo)
  {
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(1), paramTopicInfo);
    }
  }
  
  public final void b(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    jdField_a_of_type_JavaUtilList.remove(paramFunction2);
  }
  
  public final void c(@Nullable TopicInfo paramTopicInfo)
  {
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(0), paramTopicInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.TopicEventDispatcher
 * JD-Core Version:    0.7.0.1
 */