package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TopicPublishInfo;
import com.tencent.tkd.topicsdk.bean.globalconfig.ManageTopicConfig;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.ISimpleUploadListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicPresenter;", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicPresenter;", "model", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;", "(Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;)V", "topicConfig", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/ManageTopicConfig;", "view", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicView;", "attachView", "", "changeSubmitState", "allowSubmit", "", "clearTopicSketch", "createTopic", "topicPublishInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;", "detachView", "editTopic", "topicIdForEdit", "", "getBaseReportMap", "", "", "scene", "hasEditIntro", "hasSelectCover", "initFromSketch", "saveTopicSketch", "updateTopicConfig", "uploadCover", "uploader", "Lcom/tencent/tkd/topicsdk/framework/Uploader;", "localPath", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicPresenter
  implements ManageTopicContract.IManageTopicPresenter
{
  public static final ManageTopicPresenter.Companion a;
  private ManageTopicConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalconfigManageTopicConfig;
  private ManageTopicContract.IManageTopicModel jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel;
  private ManageTopicContract.IManageTopicView jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter$Companion = new ManageTopicPresenter.Companion(null);
  }
  
  public ManageTopicPresenter(@NotNull ManageTopicContract.IManageTopicModel paramIManageTopicModel)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel = paramIManageTopicModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView = ((ManageTopicContract.IManageTopicView)null);
  }
  
  public void a(long paramLong, @NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("editTopic ,topicId: ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", topicPublishInfo: ");
    ((StringBuilder)localObject).append(paramTopicPublishInfo);
    TLog.a("ManageTopicPresenter", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView == null) {
      TLog.d("ManageTopicPresenter", "editTopic view is null!");
    }
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    paramTopicPublishInfo.setTopicId(paramLong);
    paramTopicPublishInfo.setSource(5);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localObject != null) {
      ((ManageTopicContract.IManageTopicView)localObject).j();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.b(paramTopicPublishInfo, (Function4)new ManageTopicPresenter.editTopic.1(this, paramTopicPublishInfo));
  }
  
  public void a(@NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a(paramTopicPublishInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveColumnSketch topicInfo = ");
    localStringBuilder.append(paramTopicPublishInfo);
    TLog.a("ManageTopicPresenter", localStringBuilder.toString());
  }
  
  public void a(@NotNull ManageTopicConfig paramManageTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramManageTopicConfig, "topicConfig");
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalconfigManageTopicConfig = paramManageTopicConfig;
    ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localIManageTopicView != null) {
      localIManageTopicView.a(paramManageTopicConfig);
    }
  }
  
  public void a(@NotNull Uploader paramUploader, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramUploader, "uploader");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Uploading Cover path = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('.');
    TLog.a("ManageTopicPresenter", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localObject != null) {
      ((ManageTopicContract.IManageTopicView)localObject).h();
    }
    paramUploader.a((ISimpleUploadListener)new ManageTopicPresenter.uploadCover.1(this, paramString));
    paramUploader.a();
  }
  
  public void a(@Nullable ManageTopicContract.IManageTopicView paramIManageTopicView)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView = paramIManageTopicView;
  }
  
  public void a(boolean paramBoolean)
  {
    ManageTopicConfig localManageTopicConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalconfigManageTopicConfig;
    if ((localManageTopicConfig != null) && (localManageTopicConfig != null))
    {
      localManageTopicConfig.setCurrentAllowSubmit(paramBoolean);
      ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
      if (localIManageTopicView != null) {
        localIManageTopicView.b(localManageTopicConfig);
      }
    }
  }
  
  public void b()
  {
    TopicInfo localTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a();
    Object localObject;
    if (localTopicInfo != null)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
      if (localObject != null) {
        ((ManageTopicContract.IManageTopicView)localObject).a(localTopicInfo);
      }
    }
    if (localTopicInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initFromSketch topicInfo = ");
      ((StringBuilder)localObject).append(localTopicInfo);
      TLog.a("ManageTopicPresenter", ((StringBuilder)localObject).toString());
      return;
    }
    TLog.a("ManageTopicPresenter", "initFromSketch topicInfo is null");
  }
  
  public void b(@NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createTopic topicPublishInfo: ");
    ((StringBuilder)localObject).append(paramTopicPublishInfo);
    TLog.a("ManageTopicPresenter", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView == null) {
      TLog.d("ManageTopicPresenter", "createTopic view is null!");
    }
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    paramTopicPublishInfo.setSource(5);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localObject != null) {
      ((ManageTopicContract.IManageTopicView)localObject).j();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a(paramTopicPublishInfo, (Function4)new ManageTopicPresenter.createTopic.1(this, paramTopicPublishInfo));
  }
  
  public void c()
  {
    TLog.a("ManageTopicPresenter", "clearTopicSketch.");
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicPresenter
 * JD-Core Version:    0.7.0.1
 */