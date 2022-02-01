package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;", "", "topicSketch", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "getTopicSketch", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "clearTopicSketch", "", "createTopic", "topicInfo", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "tip", "", "topicId", "editTopic", "saveTopicSketch", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface ManageTopicContract$IManageTopicModel
{
  @Nullable
  public abstract TopicInfo a();
  
  public abstract void a();
  
  public abstract void a(@NotNull TopicInfo paramTopicInfo);
  
  public abstract void a(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4);
  
  public abstract void b(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicContract.IManageTopicModel
 * JD-Core Version:    0.7.0.1
 */