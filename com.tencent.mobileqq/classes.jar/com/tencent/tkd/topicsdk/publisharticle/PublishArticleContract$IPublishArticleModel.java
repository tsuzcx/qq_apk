package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleModel;", "", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/publisharticle/CheckAccountBindStatusCallback;", "loadRecentTopicList", "Lkotlin/Function3;", "", "errorCode", "errorMsg", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicList", "Lcom/tencent/tkd/topicsdk/publisharticle/GetRecentTopicListCallback;", "publishArticle", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Lkotlin/Function2;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface PublishArticleContract$IPublishArticleModel
{
  public static final PublishArticleContract.IPublishArticleModel.Companion a = PublishArticleContract.IPublishArticleModel.Companion.a;
  
  public abstract void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function2<? super Integer, ? super String, Unit> paramFunction2);
  
  public abstract void a(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1);
  
  public abstract void a(@NotNull Function3<? super Integer, ? super String, ? super List<TweetTopicItem>, Unit> paramFunction3);
  
  public abstract void a(@NotNull Function5<? super Boolean, ? super BindAccountInfo, ? super String, ? super Boolean, ? super String, Unit> paramFunction5);
  
  public abstract void b(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticleContract.IPublishArticleModel
 * JD-Core Version:    0.7.0.1
 */