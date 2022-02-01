package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.ManageTopicConfig;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicView;", "", "bindTopicData", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "hidePublishLoadingProgress", "hideUploadLoadingProgress", "onCoverUploaded", "url", "", "localPath", "onTopicCreated", "isSuccess", "", "onTopicEdited", "showPublishLoadingProgress", "showTips", "tipsId", "", "tips", "showUploadLoadingProgress", "updateSubmitUIByConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;", "updateUIByConfig", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface ManageTopicContract$IManageTopicView
{
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull ManageTopicConfig paramManageTopicConfig);
  
  public abstract void a(@NotNull TopicInfo paramTopicInfo);
  
  public abstract void a(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void b(@NotNull ManageTopicConfig paramManageTopicConfig);
  
  public abstract void b(@NotNull TopicInfo paramTopicInfo, boolean paramBoolean);
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicContract.IManageTopicView
 * JD-Core Version:    0.7.0.1
 */