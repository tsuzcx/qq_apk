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
  public static final PublishArticlePresenter.Companion a = new PublishArticlePresenter.Companion(null);
  private QQPublishArticleContract.IPublishArticleView b;
  private QQPublishArticleContract.IPublishArticleModel c;
  
  public PublishArticlePresenter(@NotNull QQPublishArticleContract.IPublishArticleModel paramIPublishArticleModel)
  {
    this.c = paramIPublishArticleModel;
  }
  
  public void a()
  {
    this.b = ((QQPublishArticleContract.IPublishArticleView)null);
  }
  
  public void a(@NotNull QQPublishArticleContract.IPublishArticleView paramIPublishArticleView)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishArticleView, "view");
    StorageManager.b.a("sp_has_show_min_limit", false);
    StorageManager.b.a("sp_has_show_max_limit", false);
    this.b = paramIPublishArticleView;
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    QQPublishArticleContract.IPublishArticleView localIPublishArticleView = this.b;
    if ((localIPublishArticleView != null) && (localIPublishArticleView.dO_() == true))
    {
      int i = b(paramGlobalPublisherConfig, paramPublishArticleInfo);
      if (i == 0) {
        this.c.a(paramGlobalPublisherConfig, paramPublishArticleInfo, (Function2)PublishArticlePresenter.publishArticle.1.INSTANCE);
      }
      paramGlobalPublisherConfig = this.b;
      if (paramGlobalPublisherConfig != null) {
        paramGlobalPublisherConfig.a(i, paramPublishArticleInfo);
      }
      return;
    }
    paramGlobalPublisherConfig = this.b;
    if (paramGlobalPublisherConfig != null) {
      paramGlobalPublisherConfig.a(-1, paramPublishArticleInfo);
    }
  }
  
  @VisibleForTesting
  public final int b(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    return BasePublisherChecker.a(PublishCheckerFactory.a.a(paramPublishArticleInfo, paramGlobalPublisherConfig), paramGlobalPublisherConfig.getContentUpperLimit(), 0, 2, null).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePresenter
 * JD-Core Version:    0.7.0.1
 */