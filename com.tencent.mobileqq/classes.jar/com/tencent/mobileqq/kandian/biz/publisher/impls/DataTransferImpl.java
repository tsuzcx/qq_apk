package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl;
import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel;
import com.tencent.mobileqq.kandian.biz.publisher.column.IColumnModel.IColumnListCallback;
import com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIDataTransferImpl;
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
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf77.oidb_cmd0xf77.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/DataTransferImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "uiDataTransferImpl", "Lcom/tencent/mobileqq/kandian/biz/publisher/impls/component/UIDataTransferImpl;", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/interfaces/CheckAccountBindStatusCallback;", "createTopic", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lkotlin/Function4;", "", "errorCode", "errorMsg", "tip", "", "topicId", "deleteTopic", "Lkotlin/Function3;", "editTopic", "getCommunityList", "cookie", "isEnd", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityList", "getFansList", "", "pageSize", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "personList", "getFollowList", "getInvitedManuscriptItemList", "pageNum", "Lcom/tencent/tkd/topicsdk/bean/InvitedManuscriptItem;", "itemList", "getInvitedManuscriptItemStatus", "itemId", "isSigned", "protocol", "getRecentTopicList", "pageCount", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "topicList", "getSearchTopicList", "wording", "getTopicList", "topTopicId", "getTweetHotTopicList", "onRelease", "publishArticle", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "id", "serverPublisherData", "Lcom/tencent/tkd/topicsdk/interfaces/PublishCallback;", "requestCurrentLocation", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "requestManuscriptSignProtocol", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DataTransferImpl
  implements IDataTransfer
{
  public static final DataTransferImpl.Companion a = new DataTransferImpl.Companion(null);
  private final UIDataTransferImpl b = new UIDataTransferImpl();
  
  private final QQAppInterface b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null) {
      return (QQAppInterface)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    paramFunction4 = (IDataTransfer.TopicCallback)new DataTransferImpl.getSearchTopicList.uiCallback.1(paramFunction4);
    this.b.a(paramString, paramInt1, paramFunction4);
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
    boolean bool;
    if ((int)paramPublishArticleInfo.getTopicId() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localCompanion.a(bool, localList, (PublishVideoHelper.IPublishVideoCallback)paramFunction4);
  }
  
  public void a(@Nullable String paramString, @NotNull Function5<? super Integer, ? super String, ? super String, ? super Boolean, ? super List<CommunityInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    paramString = new oidb_cmd0xf77.ReqBody();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new DataTransferImpl.getCommunityList.1(paramFunction5), paramString.toByteArray(), "OidbSvc.0xf77", 3959, 1, null);
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, long paramLong, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TopicInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    ((IColumnModel)new ColumnModeImpl(b())).a(paramArrayOfByte, paramLong, (IColumnModel.IColumnListCallback)new DataTransferImpl.getTopicList.1(paramFunction5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.DataTransferImpl
 * JD-Core Version:    0.7.0.1
 */