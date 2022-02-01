package com.tencent.tkd.topicsdk.managetopic;

import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.interfaces.ISimpleUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/managetopic/ManageTopicPresenter$uploadCover$1", "Lcom/tencent/tkd/topicsdk/interfaces/ISimpleUploadListener;", "onFailed", "", "errMsg", "", "onSuccess", "url", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicPresenter$uploadCover$1
  implements ISimpleUploadListener
{
  ManageTopicPresenter$uploadCover$1(String paramString) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    ManageTopicContract.IManageTopicView localIManageTopicView = ManageTopicPresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter);
    if (localIManageTopicView != null) {
      localIManageTopicView.i();
    }
    localIManageTopicView = ManageTopicPresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter);
    if (localIManageTopicView != null) {
      localIManageTopicView.a(paramString, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    paramString = ManageTopicPresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter);
    if (paramString != null) {
      paramString.i();
    }
    paramString = ManageTopicPresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkManagetopicManageTopicPresenter);
    if (paramString != null) {
      paramString.a(R.string.ar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.managetopic.ManageTopicPresenter.uploadCover.1
 * JD-Core Version:    0.7.0.1
 */