package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.DataTransferManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleModel;", "Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleModel;", "()V", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/publisharticle/CheckAccountBindStatusCallback;", "loadRecentTopicList", "Lkotlin/Function3;", "", "errorCode", "errorMsg", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicList", "Lcom/tencent/tkd/topicsdk/publisharticle/GetRecentTopicListCallback;", "publishArticle", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Lkotlin/Function2;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticleModel
  implements PublishArticleContract.IPublishArticleModel
{
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "callback");
    TopicSDK.a.a().a().a().a(paramGlobalPublisherConfig, paramPublishArticleInfo);
  }
  
  public void a(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    DataTransferManager.a.a(paramString, paramFunction1);
  }
  
  public void a(@NotNull Function3<? super Integer, ? super String, ? super List<TweetTopicItem>, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "callback");
    DataTransferManager.a(DataTransferManager.a, 0, paramFunction3, 1, null);
  }
  
  public void a(@NotNull Function5<? super Boolean, ? super BindAccountInfo, ? super String, ? super Boolean, ? super String, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    DataTransferManager.a.a(paramFunction5);
  }
  
  public void b(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    DataTransferManager.a.b(paramString, paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticleModel
 * JD-Core Version:    0.7.0.1
 */