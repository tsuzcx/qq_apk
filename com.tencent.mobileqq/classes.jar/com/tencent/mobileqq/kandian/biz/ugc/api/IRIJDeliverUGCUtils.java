package com.tencent.mobileqq.kandian.biz.ugc.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "generateReadInJoyIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "data", "getReadInJoyDeliverBiuActivityClazz", "Ljava/lang/Class;", "getReadInJoyDeliverUgcActivityClazz", "getReadInJoyDeliverVideoActivityClazz", "isUgcContent", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUgcVideo", "type", "", "openSelectVideoPage", "", "context", "Landroid/content/Context;", "config", "Lorg/json/JSONObject;", "from", "replaceUrlInLog", "", "str", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJDeliverUGCUtils
  extends QRouteApi
{
  @NotNull
  public abstract Intent generateReadInJoyIntent(@NotNull Activity paramActivity, @Nullable Intent paramIntent);
  
  @NotNull
  public abstract Class<? extends Activity> getReadInJoyDeliverBiuActivityClazz();
  
  @NotNull
  public abstract Class<? extends Activity> getReadInJoyDeliverUgcActivityClazz();
  
  @NotNull
  public abstract Class<? extends Activity> getReadInJoyDeliverVideoActivityClazz();
  
  public abstract boolean isUgcContent(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isUgcVideo(int paramInt);
  
  public abstract void openSelectVideoPage(@Nullable Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt);
  
  @Nullable
  public abstract String replaceUrlInLog(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils
 * JD-Core Version:    0.7.0.1
 */