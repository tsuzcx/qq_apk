package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicModel;", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;", "()V", "topicSketch", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "getTopicSketch", "()Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "clearTopicSketch", "", "createTopic", "topicInfo", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "tip", "", "topicId", "editTopic", "saveTopicSketch", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicModel
  implements ManageTopicContract.IManageTopicModel
{
  @Nullable
  public TopicInfo a()
  {
    String str = StorageManager.a.a("sp_topic_info_sketch", "");
    if (str != null) {
      if (((CharSequence)str).length() != 0) {
        break label41;
      }
    }
    label41:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label46;
      }
      return null;
      str = "";
      break;
    }
    label46:
    return new TopicInfo(str);
  }
  
  public void a()
  {
    StorageManager.a.a("sp_topic_info_sketch", "");
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    StorageManager.a.a("sp_topic_info_sketch", paramTopicInfo.toString());
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    DataTransferManager.a.a(paramTopicInfo, (Function4)new ManageTopicModel.createTopic.1(paramFunction4));
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    DataTransferManager.a.b(paramTopicInfo, paramFunction4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicModel
 * JD-Core Version:    0.7.0.1
 */