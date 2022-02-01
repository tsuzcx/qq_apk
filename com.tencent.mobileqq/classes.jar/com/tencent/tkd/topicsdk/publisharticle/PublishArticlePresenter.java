package com.tencent.tkd.topicsdk.publisharticle;

import androidx.annotation.VisibleForTesting;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.publisharticle.publishChecker.BasePublisherChecker;
import com.tencent.tkd.topicsdk.publisharticle.publishChecker.PublishCheckerFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticlePresenter;", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticlePresenter;", "model", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleModel;", "(Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleModel;)V", "view", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleView;", "attachView", "", "bindAccount", "accountId", "", "cancelBindAccount", "checkAccountBindStatus", "detachView", "getPublishValidCode", "", "countLimit", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "loadRecentTopicList", "publishArticle", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePresenter
  implements PublishArticleContract.IPublishArticlePresenter
{
  public static final PublishArticlePresenter.Companion a;
  private PublishArticleContract.IPublishArticleModel jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel;
  private PublishArticleContract.IPublishArticleView jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePresenter$Companion = new PublishArticlePresenter.Companion(null);
  }
  
  public PublishArticlePresenter(@NotNull PublishArticleContract.IPublishArticleModel paramIPublishArticleModel)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel = paramIPublishArticleModel;
  }
  
  @VisibleForTesting
  public final int a(int paramInt, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    return PublishCheckerFactory.a.a(paramPublishArticleInfo.getPublishScene(), paramPublishArticleInfo).a(paramInt).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleView = ((PublishArticleContract.IPublishArticleView)null);
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    int i = a(paramGlobalPublisherConfig.getCountLimit(), paramPublishArticleInfo);
    PublishArticleContract.IPublishArticleView localIPublishArticleView = this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleView;
    if (localIPublishArticleView != null)
    {
      if (i != 0) {
        break label103;
      }
      if (!localIPublishArticleView.p_()) {
        break label55;
      }
      localIPublishArticleView.aH_();
    }
    for (;;)
    {
      return;
      label55:
      if (localIPublishArticleView.o_())
      {
        localIPublishArticleView.aG_();
      }
      else
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel.a(paramGlobalPublisherConfig, paramPublishArticleInfo, (Function2)PublishArticlePresenter.publishArticle.1.1.INSTANCE);
        localIPublishArticleView.a(0);
        continue;
        label103:
        localIPublishArticleView.a(i);
      }
    }
  }
  
  public void a(@Nullable PublishArticleContract.IPublishArticleView paramIPublishArticleView)
  {
    StorageManager.a.a("sp_has_show_min_limit", false);
    StorageManager.a.a("sp_has_show_max_limit", false);
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleView = paramIPublishArticleView;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel.a(paramString, (Function1)new PublishArticlePresenter.bindAccount.1(this));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel.a((Function5)new PublishArticlePresenter.checkAccountBindStatus.1(this));
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel.b(paramString, (Function1)PublishArticlePresenter.cancelBindAccount.1.INSTANCE);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticleContract$IPublishArticleModel.a((Function3)new PublishArticlePresenter.loadRecentTopicList.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter
 * JD-Core Version:    0.7.0.1
 */