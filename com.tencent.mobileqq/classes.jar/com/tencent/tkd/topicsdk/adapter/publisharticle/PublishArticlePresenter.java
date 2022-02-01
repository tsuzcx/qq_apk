package com.tencent.tkd.topicsdk.adapter.publisharticle;

import androidx.annotation.VisibleForTesting;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.publisharticle.publishChecker.BasePublisherChecker;
import com.tencent.tkd.topicsdk.publisharticle.publishChecker.PublishCheckerFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePresenter;", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticlePresenter;", "model", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleModel;", "(Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleModel;)V", "view", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleView;", "attachView", "", "detachView", "getPublishValidCode", "", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "publishArticle", "articleInfo", "Companion", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePresenter
  implements QQPublishArticleContract.IPublishArticlePresenter
{
  public static final PublishArticlePresenter.Companion a;
  private QQPublishArticleContract.IPublishArticleModel jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleModel;
  private QQPublishArticleContract.IPublishArticleView jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePresenter$Companion = new PublishArticlePresenter.Companion(null);
  }
  
  public PublishArticlePresenter(@NotNull QQPublishArticleContract.IPublishArticleModel paramIPublishArticleModel)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleModel = paramIPublishArticleModel;
  }
  
  @VisibleForTesting
  public final int a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    return PublishCheckerFactory.a.a(paramPublishArticleInfo, paramGlobalPublisherConfig).a(paramGlobalPublisherConfig.getCountLimit()).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView = ((QQPublishArticleContract.IPublishArticleView)null);
  }
  
  public void a(@NotNull QQPublishArticleContract.IPublishArticleView paramIPublishArticleView)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishArticleView, "view");
    StorageManager.a.a("sp_has_show_min_limit", false);
    StorageManager.a.a("sp_has_show_max_limit", false);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView = paramIPublishArticleView;
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    QQPublishArticleContract.IPublishArticleView localIPublishArticleView = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView;
    if ((localIPublishArticleView != null) && (localIPublishArticleView.d() == true))
    {
      int i = a(paramGlobalPublisherConfig, paramPublishArticleInfo);
      if (i == 0) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleModel.a(paramGlobalPublisherConfig, paramPublishArticleInfo, (Function2)PublishArticlePresenter.publishArticle.1.INSTANCE);
      }
      paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView;
      if (paramGlobalPublisherConfig != null) {
        paramGlobalPublisherConfig.a(i, paramPublishArticleInfo);
      }
      return;
    }
    paramGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticleQQPublishArticleContract$IPublishArticleView;
    if (paramGlobalPublisherConfig != null) {
      paramGlobalPublisherConfig.a(-1, paramPublishArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePresenter
 * JD-Core Version:    0.7.0.1
 */