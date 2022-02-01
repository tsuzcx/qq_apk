package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticleModel;", "Lcom/tencent/tkd/topicsdk/adapter/publisharticle/QQPublishArticleContract$IPublishArticleModel;", "()V", "publishArticle", "", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticleModel
  implements QQPublishArticleContract.IPublishArticleModel
{
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    TopicSDK.a.a().a().a().a(paramGlobalPublisherConfig, paramPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticleModel
 * JD-Core Version:    0.7.0.1
 */