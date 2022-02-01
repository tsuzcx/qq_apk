package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import com.tencent.tkd.topicsdk.publisharticle.BindAccountInfo;
import com.tencent.tkd.weibo.bean.AtPersonItem;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/DataTransferManager;", "", "()V", "mIDataTransfer", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/publisharticle/CheckAccountBindStatusCallback;", "createTopic", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lkotlin/Function4;", "", "errorCode", "errorMsg", "tip", "", "topicId", "editTopic", "getCommunityList", "cookie", "isEnd", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityList", "getFansList", "", "pageSize", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "personList", "getFollowList", "getTopicList", "topicList", "getTweetHotTopicList", "pageNum", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "getTweetRecentTopicList", "pageCount", "Lkotlin/Function3;", "getTweetSearchTopicList", "wording", "init", "dataTransfer", "publishArticle", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "id", "serverPublisherData", "Lcom/tencent/tkd/topicsdk/interfaces/PublishCallback;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DataTransferManager
{
  public static final DataTransferManager a;
  private static IDataTransfer a;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkDataTransferManager = new DataTransferManager();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramInt1, paramInt2, paramFunction4);
  }
  
  public final void a(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramInt1, paramInt2, paramString, paramFunction4);
  }
  
  public final void a(int paramInt, @NotNull Function3<? super Integer, ? super String, ? super List<TweetTopicItem>, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramInt, paramFunction3);
  }
  
  public final void a(@NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super String, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramPublishArticleInfo, paramFunction4);
  }
  
  public final void a(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramTopicInfo, paramFunction4);
  }
  
  public final void a(@NotNull IDataTransfer paramIDataTransfer)
  {
    Intrinsics.checkParameterIsNotNull(paramIDataTransfer, "dataTransfer");
    jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer = paramIDataTransfer;
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramString, paramFunction1);
  }
  
  public final void a(@Nullable String paramString, @NotNull Function5<? super Integer, ? super String, ? super String, ? super Boolean, ? super List<CommunityInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramString, paramFunction5);
  }
  
  public final void a(@NotNull Function5<? super Boolean, ? super BindAccountInfo, ? super String, ? super Boolean, ? super String, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramFunction5);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.b(paramArrayOfByte, paramInt, paramFunction5);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TopicInfo>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramArrayOfByte, 0L, paramFunction5);
  }
  
  public final void b(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.b(paramTopicInfo, paramFunction4);
  }
  
  public final void b(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "accountId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.b(paramString, paramFunction1);
  }
  
  public final void b(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramArrayOfByte, paramInt, paramFunction5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.DataTransferManager
 * JD-Core Version:    0.7.0.1
 */