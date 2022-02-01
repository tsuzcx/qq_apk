package com.tencent.tkd.topicsdk.publisharticle.base;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticleContract$IPublishArticleModel;", "", "publishArticle", "", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface BasePublishArticleContract$IPublishArticleModel
{
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function2<? super Integer, ? super String, Unit> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticleContract.IPublishArticleModel
 * JD-Core Version:    0.7.0.1
 */