package com.tencent.tkd.topicsdk.interfaces;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "", "bindAccount", "", "accountId", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cancelBindAccount", "checkAccountBindStatus", "Lkotlin/Function5;", "needBind", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "bindAccountInfo", "protocolUrl", "needRealNameConfirm", "realNameConfirmUrl", "Lcom/tencent/tkd/topicsdk/publisharticle/CheckAccountBindStatusCallback;", "createTopic", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "Lkotlin/Function4;", "", "errorCode", "errorMsg", "tip", "", "topicId", "deleteTopic", "Lkotlin/Function3;", "editTopic", "getCommunityList", "cookie", "isEnd", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "communityList", "getFansList", "", "pageSize", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "personList", "getFollowList", "getRecentTopicList", "pageCount", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicList", "getSearchTopicList", "pageNum", "wording", "getTopicList", "topTopicId", "getTweetHotTopicList", "publishArticle", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "id", "serverPublisherData", "Lcom/tencent/tkd/topicsdk/interfaces/PublishCallback;", "requestCurrentLocation", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IDataTransfer
{
  public abstract void a(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4);
  
  public abstract void a(int paramInt1, int paramInt2, @NotNull Function4<? super Integer, ? super String, ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction4);
  
  public abstract void a(int paramInt, @NotNull Function3<? super Integer, ? super String, ? super List<TweetTopicItem>, Unit> paramFunction3);
  
  public abstract void a(@Nullable LocationInfo paramLocationInfo);
  
  public abstract void a(@NotNull PublishArticleInfo paramPublishArticleInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super String, Unit> paramFunction4);
  
  public abstract void a(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4);
  
  public abstract void a(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1);
  
  public abstract void a(@Nullable String paramString, @NotNull Function5<? super Integer, ? super String, ? super String, ? super Boolean, ? super List<CommunityInfo>, Unit> paramFunction5);
  
  public abstract void a(@NotNull Function5<? super Boolean, ? super BindAccountInfo, ? super String, ? super Boolean, ? super String, Unit> paramFunction5);
  
  public abstract void a(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5);
  
  public abstract void a(@Nullable byte[] paramArrayOfByte, long paramLong, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TopicInfo>, Unit> paramFunction5);
  
  public abstract void b(@NotNull TopicInfo paramTopicInfo, @NotNull Function4<? super Integer, ? super String, ? super String, ? super Long, Unit> paramFunction4);
  
  public abstract void b(@NotNull String paramString, @NotNull Function1<? super Boolean, Unit> paramFunction1);
  
  public abstract void b(@Nullable byte[] paramArrayOfByte, int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IDataTransfer
 * JD-Core Version:    0.7.0.1
 */