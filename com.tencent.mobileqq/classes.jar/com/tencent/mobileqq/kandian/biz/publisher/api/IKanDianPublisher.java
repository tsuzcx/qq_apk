package com.tencent.mobileqq.kandian.biz.publisher.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcEntryExtraInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "buildKDCommunityInfo", "", "config", "Lorg/json/JSONObject;", "kdCommunityId", "", "kdCommunityName", "buildOriginTopicInfo", "topicId", "", "coverUrl", "title", "brief", "allowSubmit", "", "buildPublisherScene", "from", "callback", "buildSelectVideoInfo", "duration", "", "fileSize", "coverPath", "width", "height", "filePath", "buildUgcEntryExtraInfo", "ugcEntryExtraInfo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcEntryExtraInfo;", "getRemoteConfig", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "init", "context", "Landroid/content/Context;", "openPublishArticlePage", "extra", "openPublishArticlePageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openSelectVideoPage", "openSelectVideoPageForResult", "registerPublishObserver", "observer", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "unRegisterPublishObserver", "IPublisherObserver", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianPublisher
  extends QRouteApi
{
  public abstract void buildKDCommunityInfo(@NotNull JSONObject paramJSONObject, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void buildOriginTopicInfo(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean);
  
  public abstract void buildPublisherScene(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString);
  
  public abstract void buildSelectVideoInfo(@NotNull JSONObject paramJSONObject, long paramLong1, long paramLong2, @NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2);
  
  public abstract void buildUgcEntryExtraInfo(@NotNull JSONObject paramJSONObject, @NotNull UgcEntryExtraInfo paramUgcEntryExtraInfo);
  
  @NotNull
  public abstract IPublisherRemoteConfig getRemoteConfig();
  
  public abstract void init(@NotNull Context paramContext);
  
  public abstract void openPublishArticlePage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject);
  
  public abstract void openPublishArticlePageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject);
  
  public abstract void openSelectVideoPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt);
  
  public abstract void openSelectVideoPageForResult(@NotNull Activity paramActivity, int paramInt1, @Nullable JSONObject paramJSONObject, int paramInt2);
  
  @Deprecated(message="发表逻辑使用手Q，因此此方法当前无用")
  public abstract void registerPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver);
  
  @Deprecated(message="发表逻辑使用手Q，因此此方法当前无用")
  public abstract void unRegisterPublishObserver(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher
 * JD-Core Version:    0.7.0.1
 */