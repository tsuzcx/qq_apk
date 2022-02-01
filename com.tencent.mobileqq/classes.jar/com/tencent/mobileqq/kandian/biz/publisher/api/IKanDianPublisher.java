package com.tencent.mobileqq.kandian.biz.publisher.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "buildOriginTopicInfo", "", "config", "Lorg/json/JSONObject;", "topicId", "", "coverUrl", "", "title", "brief", "allowSubmit", "", "buildPublisherScene", "from", "callback", "buildSelectVideoInfo", "duration", "", "fileSize", "coverPath", "width", "height", "filePath", "buildVideoOriginTopicInfo", "topicName", "getRemoteConfig", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IPublisherRemoteConfig;", "init", "context", "Landroid/content/Context;", "openCreateTopicPage", "extra", "openCreateTopicPageForResult", "activity", "Landroid/app/Activity;", "requestCode", "openEditTopicPage", "openEditTopicPageForResult", "openPublishArticlePage", "openPublishArticlePageForResult", "openSelectVideoPage", "openSelectVideoPageForResult", "registerPublishObserver", "observer", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "unRegisterPublishObserver", "IPublisherObserver", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianPublisher
  extends QRouteApi
{
  public abstract void buildOriginTopicInfo(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean);
  
  public abstract void buildPublisherScene(@NotNull JSONObject paramJSONObject, int paramInt, @Nullable String paramString);
  
  public abstract void buildSelectVideoInfo(@NotNull JSONObject paramJSONObject, long paramLong1, long paramLong2, @NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2);
  
  public abstract void buildVideoOriginTopicInfo(@NotNull JSONObject paramJSONObject, long paramLong, @NotNull String paramString);
  
  @NotNull
  public abstract IPublisherRemoteConfig getRemoteConfig();
  
  public abstract void init(@NotNull Context paramContext);
  
  public abstract void openCreateTopicPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject);
  
  public abstract void openCreateTopicPageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject);
  
  public abstract void openEditTopicPage(@NotNull Context paramContext, @Nullable JSONObject paramJSONObject);
  
  public abstract void openEditTopicPageForResult(@NotNull Activity paramActivity, int paramInt, @Nullable JSONObject paramJSONObject);
  
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