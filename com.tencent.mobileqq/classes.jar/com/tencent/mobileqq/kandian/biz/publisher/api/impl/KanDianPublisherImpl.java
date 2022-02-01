package com.tencent.mobileqq.kandian.biz.publisher.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher.IPublisherObserver;
import com.tencent.mobileqq.kandian.biz.publisher.api.IPublisherRemoteConfig;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/impl/KanDianPublisherImpl;", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher;", "()V", "buildKDCommunityInfo", "", "config", "Lorg/json/JSONObject;", "kdCommunityId", "", "kdCommunityName", "buildOriginTopicInfo", "topicId", "", "coverUrl", "title", "brief", "allowSubmit", "", "buildPublisherScene", "from", "callback", "buildSelectVideoInfo", "duration", "", "fileSize", "coverPath", "width", "height", "filePath", "buildUgcEntryExtraInfo", "ugcEntryExtraInfo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo;", "getRemoteConfig", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "init", "context", "Landroid/content/Context;", "openPublishArticlePage", "extra", "openPublishArticlePageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openSelectVideoPage", "openSelectVideoPageForResult", "registerPublishObserver", "observer", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "unRegisterPublishObserver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianPublisherImpl
  implements IKanDianPublisher
{
  public void buildKDCommunityInfo(@NotNull JSONObject paramJSONObject, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramString1, "kdCommunityId");
    Intrinsics.checkParameterIsNotNull(paramString2, "kdCommunityName");
    this.$$delegate_0.buildKDCommunityInfo(paramJSONObject, paramString1, paramString2);
  }
  
  public void buildOriginTopicInfo(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    this.$$delegate_0.buildOriginTopicInfo(paramJSONObject, paramInt, paramString1, paramString2, paramString3, paramBoolean);
  }
  
  public void buildPublisherScene(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    this.$$delegate_0.buildPublisherScene(paramJSONObject, paramInt, paramString);
  }
  
  public void buildSelectVideoInfo(@NotNull JSONObject paramJSONObject, long paramLong1, long paramLong2, @NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramString1, "coverPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    this.$$delegate_0.buildSelectVideoInfo(paramJSONObject, paramLong1, paramLong2, paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void buildUgcEntryExtraInfo(@NotNull JSONObject paramJSONObject, @NotNull UgcEntryExtraInfo paramUgcEntryExtraInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    Intrinsics.checkParameterIsNotNull(paramUgcEntryExtraInfo, "ugcEntryExtraInfo");
    this.$$delegate_0.buildUgcEntryExtraInfo(paramJSONObject, paramUgcEntryExtraInfo);
  }
  
  @NotNull
  public IPublisherRemoteConfig getRemoteConfig()
  {
    return this.$$delegate_0.getRemoteConfig();
  }
  
  public void init(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.init(paramContext);
  }
  
  public void openPublishArticlePage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.openPublishArticlePage(paramContext, paramJSONObject);
  }
  
  public void openPublishArticlePageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    this.$$delegate_0.openPublishArticlePageForResult(paramActivity, paramInt, paramJSONObject);
  }
  
  public void openSelectVideoPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.openSelectVideoPage(paramContext, paramJSONObject, paramInt);
  }
  
  public void openSelectVideoPageForResult(@NotNull Activity paramActivity, int paramInt1, @Nullable JSONObject paramJSONObject, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    this.$$delegate_0.openSelectVideoPageForResult(paramActivity, paramInt1, paramJSONObject, paramInt2);
  }
  
  @Deprecated(message="发表逻辑使用手Q，因此此方法当前无用")
  public void registerPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    this.$$delegate_0.registerPublishObserver(paramIPublisherObserver);
  }
  
  @Deprecated(message="发表逻辑使用手Q，因此此方法当前无用")
  public void unRegisterPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    this.$$delegate_0.unRegisterPublishObserver(paramIPublisherObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisherImpl
 * JD-Core Version:    0.7.0.1
 */