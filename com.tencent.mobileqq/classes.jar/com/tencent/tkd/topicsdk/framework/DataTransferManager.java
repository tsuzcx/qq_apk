package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/DataTransferManager;", "", "()V", "mIDataTransfer", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/interfaces/CheckAccountBindStatusCallback;", "createTopic", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lkotlin/Function4;", "", "errorCode", "errorMsg", "tip", "", "topicId", "editTopic", "getCommunityList", "cookie", "isEnd", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityList", "getFansList", "", "pageSize", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "personList", "getFollowList", "getTopicList", "topicList", "getTweetHotTopicList", "pageNum", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "getTweetRecentTopicList", "pageCount", "Lkotlin/Function3;", "getTweetSearchTopicList", "wording", "init", "dataTransfer", "publishArticle", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "id", "serverPublisherData", "Lcom/tencent/tkd/topicsdk/interfaces/PublishCallback;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DataTransferManager
{
  public static final DataTransferManager a = new DataTransferManager();
  private static IDataTransfer b;
  
  public final void a(@NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super String, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = b;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramPublishArticleInfo, paramFunction4);
  }
  
  public final void a(@NotNull IDataTransfer paramIDataTransfer)
  {
    Intrinsics.checkParameterIsNotNull(paramIDataTransfer, "dataTransfer");
    b = paramIDataTransfer;
  }
  
  public final void a(@Nullable String paramString, @NotNull Function5<? super Integer, ? super String, ? super String, ? super Boolean, ? super List<CommunityInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = b;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramString, paramFunction5);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TopicInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = b;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramArrayOfByte, 0L, paramFunction5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.DataTransferManager
 * JD-Core Version:    0.7.0.1
 */