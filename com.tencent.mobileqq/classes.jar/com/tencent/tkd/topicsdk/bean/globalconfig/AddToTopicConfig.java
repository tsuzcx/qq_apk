package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/AddToTopicConfig;", "Ljava/io/Serializable;", "()V", "disableSelectTopic", "", "getDisableSelectTopic", "()Z", "setDisableSelectTopic", "(Z)V", "selectedTopicId", "", "getSelectedTopicId", "()J", "setSelectedTopicId", "(J)V", "selectedTopicName", "", "getSelectedTopicName", "()Ljava/lang/String;", "setSelectedTopicName", "(Ljava/lang/String;)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AddToTopicConfig
  implements Serializable
{
  private boolean disableSelectTopic;
  private long selectedTopicId;
  @NotNull
  private String selectedTopicName = "";
  
  public final boolean getDisableSelectTopic()
  {
    return this.disableSelectTopic;
  }
  
  public final long getSelectedTopicId()
  {
    return this.selectedTopicId;
  }
  
  @NotNull
  public final String getSelectedTopicName()
  {
    return this.selectedTopicName;
  }
  
  public final void setDisableSelectTopic(boolean paramBoolean)
  {
    this.disableSelectTopic = paramBoolean;
  }
  
  public final void setSelectedTopicId(long paramLong)
  {
    this.selectedTopicId = paramLong;
  }
  
  public final void setSelectedTopicName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.selectedTopicName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.AddToTopicConfig
 * JD-Core Version:    0.7.0.1
 */