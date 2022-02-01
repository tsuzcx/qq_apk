package com.tencent.tkd.topicsdk.selectowner;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/selectowner/TopicEventDispatcher;", "", "()V", "CODE_CREATE_CANCEL", "", "CODE_CREATE_FAIL", "CODE_CREATE_SUCCESS", "CODE_EDIT_CANCEL", "CODE_EDIT_SUCCESS", "createTopicListenerList", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errorCode", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "topicInfo", "", "Lcom/tencent/tkd/topicsdk/selectowner/CreateTopicListener;", "editTopicListenerList", "Lcom/tencent/tkd/topicsdk/selectowner/EditTopicListener;", "addCreateTopicListener", "listener", "addEditTopicListener", "notifyTopicCreateCancel", "notifyTopicCreateFail", "notifyTopicCreateSuccess", "notifyTopicEditCancel", "notifyTopicEditSuccess", "removeCreateTopicListener", "removeEditTopicListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicEventDispatcher
{
  public static final TopicEventDispatcher a = new TopicEventDispatcher();
  private static final List<Function2<Integer, TopicInfo, Unit>> b = (List)new ArrayList();
  private static final List<Function2<Integer, TopicInfo, Unit>> c = (List)new ArrayList();
  
  public final void a(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    b.add(paramFunction2);
  }
  
  public final void b(@NotNull Function2<? super Integer, ? super TopicInfo, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    b.remove(paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.TopicEventDispatcher
 * JD-Core Version:    0.7.0.1
 */