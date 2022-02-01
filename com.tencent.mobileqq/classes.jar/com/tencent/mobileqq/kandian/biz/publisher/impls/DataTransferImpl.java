package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl;
import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel;
import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel.IColumnCallback;
import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel.IColumnListCallback;
import com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper;
import com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.Companion;
import com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.IPublishVideoCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import com.tencent.tkd.topicsdk.publisharticle.BindAccountInfo;
import com.tencent.tkd.weibo.bean.AtPersonItem;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/publisharticle/CheckAccountBindStatusCallback;", "createTopic", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lkotlin/Function4;", "", "errorCode", "errorMsg", "tip", "", "topicId", "deleteTopic", "Lkotlin/Function3;", "editTopic", "getCommunityList", "cookie", "isEnd", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityList", "getFansList", "", "pageSize", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "personList", "getFollowList", "getRecentTopicList", "pageCount", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicList", "getSearchTopicList", "pageNum", "wording", "getTopicList", "topTopicId", "getTweetHotTopicList", "publishArticle", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "id", "serverPublisherData", "Lcom/tencent/tkd/topicsdk/interfaces/PublishCallback;", "requestCurrentLocation", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl
  implements IDataTransfer
{
  public static final DataTransferImpl.Companion a = new DataTransferImpl.Companion(null);
  
  private final QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    return (QQAppInterface)localObject;
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
  }
  
  public void a(int paramInt, @NotNull Function3<? super Integer, ? super String, ? super List<TweetTopicItem>, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "callback");
  }
  
  public void a(@Nullable LocationInfo paramLocationInfo)
  {
    paramLocationInfo = new DataTransferImpl.requestCurrentLocation.mOnLocationListener.1(paramLocationInfo, 0, true, true, 0L, false, false, "AbsPublish");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation((SosoInterfaceOnLocationListener)paramLocationInfo);
  }
  
  public void a(@NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super String, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    List localList = CollectionsKt.listOf(paramPublishArticleInfo);
    paramFunction4 = new DataTransferImpl.publishArticle.publishCallback.1(paramFunction4);
    PublishVideoHelper.Companion localCompanion = PublishVideoHelper.a;
    if ((int)paramPublishArticleInfo.getTopicId() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localCompanion.a(bool, localList, (PublishVideoHelper.IPublishVideoCallback)paramFunction4);
      return;
    }
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    ((IColumnModel)new ColumnModeImpl(a())).a(paramTopicInfo, (IColumnModel.IColumnCallback)new DataTransferImpl.createTopic.1(paramFunction4));
  }
  
  public void a(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
  }
  
  public void a(@Nullable String paramString, @NotNull Function5<? super Integer, ? super String, ? super String, ? super Boolean, ? super List<CommunityInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
  }
  
  public void a(@NotNull Function5<? super Boolean, ? super BindAccountInfo, ? super String, ? super Boolean, ? super String, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, long paramLong, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TopicInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    ((IColumnModel)new ColumnModeImpl(a())).a(paramArrayOfByte, paramLong, (IColumnModel.IColumnListCallback)new DataTransferImpl.getTopicList.1(paramFunction5));
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    ((IColumnModel)new ColumnModeImpl(a())).b(paramTopicInfo, (IColumnModel.IColumnCallback)new DataTransferImpl.editTopic.1(paramFunction4));
  }
  
  public void b(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
  }
  
  public void b(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl
 * JD-Core Version:    0.7.0.1
 */