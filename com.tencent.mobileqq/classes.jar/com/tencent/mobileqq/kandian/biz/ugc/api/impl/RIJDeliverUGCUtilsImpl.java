package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJDeliverUGCUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJDeliverUGCUtils;", "()V", "generateReadInJoyIntent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "data", "getReadInJoyDeliverBiuActivityClazz", "Ljava/lang/Class;", "getReadInJoyDeliverUgcActivityClazz", "getReadInJoyDeliverVideoActivityClazz", "isUgcContent", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isUgcVideo", "type", "", "openSelectVideoPage", "", "context", "Landroid/content/Context;", "config", "Lorg/json/JSONObject;", "from", "replaceUrlInLog", "", "str", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDeliverUGCUtilsImpl
  implements IRIJDeliverUGCUtils
{
  @NotNull
  public Intent generateReadInJoyIntent(@NotNull Activity paramActivity, @Nullable Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return this.$$delegate_0.generateReadInJoyIntent(paramActivity, paramIntent);
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverBiuActivityClazz()
  {
    return this.$$delegate_0.getReadInJoyDeliverBiuActivityClazz();
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverUgcActivityClazz()
  {
    return this.$$delegate_0.getReadInJoyDeliverUgcActivityClazz();
  }
  
  @NotNull
  public Class<? extends Activity> getReadInJoyDeliverVideoActivityClazz()
  {
    return this.$$delegate_0.getReadInJoyDeliverVideoActivityClazz();
  }
  
  public boolean isUgcContent(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return this.$$delegate_0.isUgcContent(paramAbsBaseArticleInfo);
  }
  
  public boolean isUgcVideo(int paramInt)
  {
    return this.$$delegate_0.isUgcVideo(paramInt);
  }
  
  public void openSelectVideoPage(@Nullable Context paramContext, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    this.$$delegate_0.openSelectVideoPage(paramContext, paramJSONObject, paramInt);
  }
  
  @Nullable
  public String replaceUrlInLog(@Nullable String paramString)
  {
    return this.$$delegate_0.replaceUrlInLog(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJDeliverUGCUtilsImpl
 * JD-Core Version:    0.7.0.1
 */