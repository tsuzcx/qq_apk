package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.topicsdk.bean.ManageTopicConfig;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TopicPublishInfo;
import com.tencent.tkd.topicsdk.common.report.ReportKeys;
import com.tencent.tkd.topicsdk.common.report.ReportValues;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.Uploader;
import com.tencent.tkd.topicsdk.interfaces.ISimpleUploadListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicPresenter;", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicPresenter;", "model", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;", "(Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicModel;)V", "topicConfig", "Lcom/tencent/tkd/topicsdk/bean/ManageTopicConfig;", "view", "Lcom/tencent/tkd/topicsdk/managetopic/ManageTopicContract$IManageTopicView;", "attachView", "", "changeSubmitState", "allowSubmit", "", "clearTopicSketch", "createTopic", "topicPublishInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicPublishInfo;", "detachView", "editTopic", "topicIdForEdit", "", "getBaseReportMap", "", "", "scene", "hasEditIntro", "hasSelectCover", "initFromSketch", "saveTopicSketch", "updateTopicConfig", "uploadCover", "uploader", "Lcom/tencent/tkd/topicsdk/framework/Uploader;", "localPath", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicPresenter
  implements ManageTopicContract.IManageTopicPresenter
{
  public static final ManageTopicPresenter.Companion a;
  private ManageTopicConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanManageTopicConfig;
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
  
  @NotNull
  public Map<String, String> a(@NotNull String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    Map localMap = (Map)new HashMap();
    localMap.put(ReportKeys.a.a(), paramString);
    paramString = ReportKeys.a.f();
    ReportValues localReportValues = ReportValues.a;
    ManageTopicConfig localManageTopicConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanManageTopicConfig;
    if (localManageTopicConfig != null) {}
    for (boolean bool1 = localManageTopicConfig.getVideoPermissionFlag();; bool1 = true)
    {
      localMap.put(paramString, localReportValues.a(bool1));
      paramString = ReportKeys.a.g();
      localReportValues = ReportValues.a;
      localManageTopicConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanManageTopicConfig;
      bool1 = bool2;
      if (localManageTopicConfig != null) {
        bool1 = localManageTopicConfig.getTopicPermissionFlag();
      }
      localMap.put(paramString, localReportValues.a(bool1));
      localMap.put(ReportKeys.a.j(), ReportValues.a.a(paramBoolean1));
      localMap.put(ReportKeys.a.k(), ReportValues.a.a(paramBoolean2));
      return localMap;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView = ((ManageTopicContract.IManageTopicView)null);
  }
  
  public void a(long paramLong, @NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    TLog.a("ManageTopicPresenter", "editTopic ,topicId: " + paramLong + ", topicPublishInfo: " + paramTopicPublishInfo);
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView == null) {
      TLog.d("ManageTopicPresenter", "editTopic view is null!");
    }
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    paramTopicPublishInfo.setTopicId(paramLong);
    paramTopicPublishInfo.setSource(5);
    ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localIManageTopicView != null) {
      localIManageTopicView.j();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.b(paramTopicPublishInfo, (Function4)new ManageTopicPresenter.editTopic.1(this, paramTopicPublishInfo));
  }
  
  public void a(@NotNull ManageTopicConfig paramManageTopicConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramManageTopicConfig, "topicConfig");
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanManageTopicConfig = paramManageTopicConfig;
    ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localIManageTopicView != null) {
      localIManageTopicView.a(paramManageTopicConfig);
    }
  }
  
  public void a(@NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a(paramTopicPublishInfo);
    TLog.a("ManageTopicPresenter", "saveColumnSketch topicInfo = " + paramTopicPublishInfo);
  }
  
  public void a(@NotNull Uploader paramUploader, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramUploader, "uploader");
    Intrinsics.checkParameterIsNotNull(paramString, "localPath");
    TLog.a("ManageTopicPresenter", "Uploading Cover path = " + paramString + '.');
    ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localIManageTopicView != null) {
      localIManageTopicView.h();
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
    ManageTopicConfig localManageTopicConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanManageTopicConfig;
    if (localManageTopicConfig != null)
    {
      if (localManageTopicConfig == null) {
        return;
      }
      localManageTopicConfig.setCurrentAllowSubmit(paramBoolean);
      ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
      if (localIManageTopicView != null) {
        localIManageTopicView.b(localManageTopicConfig);
      }
    }
    return;
  }
  
  public void b()
  {
    TopicInfo localTopicInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a();
    if (localTopicInfo != null)
    {
      ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
      if (localIManageTopicView != null) {
        localIManageTopicView.a(localTopicInfo);
      }
    }
    if (localTopicInfo != null)
    {
      TLog.a("ManageTopicPresenter", "initFromSketch topicInfo = " + localTopicInfo);
      return;
    }
    TLog.a("ManageTopicPresenter", "initFromSketch topicInfo is null");
  }
  
  public void b(@NotNull TopicPublishInfo paramTopicPublishInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicPublishInfo, "topicPublishInfo");
    TLog.a("ManageTopicPresenter", "createTopic topicPublishInfo: " + paramTopicPublishInfo);
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView == null) {
      TLog.d("ManageTopicPresenter", "createTopic view is null!");
    }
    paramTopicPublishInfo = new TopicInfo(paramTopicPublishInfo);
    paramTopicPublishInfo.setSource(5);
    ManageTopicContract.IManageTopicView localIManageTopicView = this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicView;
    if (localIManageTopicView != null) {
      localIManageTopicView.j();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a(paramTopicPublishInfo, (Function4)new ManageTopicPresenter.createTopic.1(this, paramTopicPublishInfo));
  }
  
  public void c()
  {
    TLog.a("ManageTopicPresenter", "clearTopicSketch.");
    this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicContract$IManageTopicModel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicPresenter
 * JD-Core Version:    0.7.0.1
 */