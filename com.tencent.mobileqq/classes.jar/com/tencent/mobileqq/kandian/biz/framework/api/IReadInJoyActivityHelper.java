package com.tencent.mobileqq.kandian.biz.framework.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyActivityHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAppPackage", "", "appPackageName", "", "getFastWebIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "data", "Ljava/util/HashMap;", "getJumpReadInJoyNewFeedsIntent", "from", "", "getJumpReadInJoyTabFloatingWindowIntent", "rowKey", "articleURL", "getJumpReadInJoyTabIntent", "channelId", "getOpenArticleSchemeIntent", "getReadInJoyAdIMAXBrowserFragmentClazz", "Ljava/lang/Class;", "getReadInJoyAdPopSheetBrowserFragmentClazz", "getReadInJoyChannelActivityClazz", "getReadInJoyDraftboxFragmentClazz", "getReadInJoyNewFeedsActivityClazz", "getReadInJoySettingActivityClazz", "getReadInJoyUploadAvatarFragmentClazz", "isReadInJoyArticleDetailActivity", "isReadInJoyChannelActivity", "isReadInJoyNewFeedsActivity", "launchApp", "", "appSchema", "channelID", "defaultURL", "cancelJump", "launchChannelActivity", "channelName", "channelType", "reportFrom", "param", "", "", "clearTop", "isFromImmersive", "launchFeedsActivity", "launchFrom", "tabIndex", "extraData", "Landroid/os/Bundle;", "articleList", "", "", "currentArticleID", "launchGroupSubscribeChannelActivity", "args", "comeFrom", "launchInterestActivity", "launchKanDianDailyActivity", "bundle", "launchReadInJoyPrivacyListFragment", "activity", "Landroid/app/Activity;", "feedsId", "launchReadInJoySelectMemberAQFragmentForResult", "intent", "launchReadInJoySelfActivity", "redTouch", "launchReadInJoyTab", "launchReadInJoyUninterestComplainFragmentForResult", "launchSelfFromIndependentTab", "shouldMessages", "launchSubscriptionActivity", "jumpAction", "launchVideoChannelActivityForTwoItemVideo", "mainArticle", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "clickedArticle", "showAdapterAnim", "launchVideoSubChannelActivity", "openDailyDynamicChildFeeds", "openFlutterPage", "openFullVideoPlay", "openMXFlutterPage", "startApp", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyActivityHelper
  extends QRouteApi
{
  public abstract boolean checkAppPackage(@Nullable String paramString);
  
  @NotNull
  public abstract Intent getFastWebIntent(@NotNull Context paramContext, @NotNull HashMap<String, String> paramHashMap);
  
  @NotNull
  public abstract Intent getJumpReadInJoyNewFeedsIntent(@NotNull Context paramContext, int paramInt);
  
  @NotNull
  public abstract Intent getJumpReadInJoyTabFloatingWindowIntent(@NotNull Context paramContext, int paramInt, @NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt);
  
  @NotNull
  public abstract Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt1, int paramInt2);
  
  @Nullable
  public abstract Intent getOpenArticleSchemeIntent(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  @NotNull
  public abstract Class<?> getReadInJoyAdIMAXBrowserFragmentClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoyAdPopSheetBrowserFragmentClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoyChannelActivityClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoyDraftboxFragmentClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoyNewFeedsActivityClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoySettingActivityClazz();
  
  @NotNull
  public abstract Class<?> getReadInJoyUploadAvatarFragmentClazz();
  
  public abstract boolean isReadInJoyArticleDetailActivity(@NotNull Context paramContext);
  
  public abstract boolean isReadInJoyChannelActivity(@NotNull Context paramContext);
  
  public abstract boolean isReadInJoyNewFeedsActivity(@NotNull Context paramContext);
  
  public abstract void launchApp(@NotNull Context paramContext, @Nullable String paramString1, int paramInt, @Nullable String paramString2, boolean paramBoolean);
  
  public abstract void launchChannelActivity(@NotNull Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3);
  
  public abstract void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap);
  
  public abstract void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2, @Nullable Bundle paramBundle);
  
  public abstract void launchFeedsActivity(@NotNull Context paramContext, @Nullable List<Long> paramList, long paramLong, int paramInt);
  
  public abstract void launchGroupSubscribeChannelActivity(@Nullable Context paramContext, @Nullable String paramString, int paramInt);
  
  public abstract void launchInterestActivity(@NotNull Context paramContext);
  
  public abstract void launchKanDianDailyActivity(@NotNull Context paramContext, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean);
  
  public abstract void launchReadInJoyPrivacyListFragment(@NotNull Activity paramActivity, long paramLong);
  
  public abstract void launchReadInJoySelectMemberAQFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent);
  
  public abstract void launchReadInJoySelfActivity(@NotNull Context paramContext, boolean paramBoolean);
  
  public abstract void launchReadInJoyTab(@NotNull Context paramContext, int paramInt);
  
  public abstract void launchReadInJoyUninterestComplainFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent);
  
  public abstract void launchSelfFromIndependentTab(@NotNull Context paramContext, boolean paramBoolean);
  
  @Nullable
  public abstract Intent launchSubscriptionActivity(@NotNull Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void launchVideoChannelActivityForTwoItemVideo(@NotNull Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean);
  
  public abstract void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3);
  
  public abstract void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap);
  
  public abstract void openDailyDynamicChildFeeds(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  public abstract void openFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  public abstract void openFullVideoPlay(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  public abstract void openMXFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
  
  public abstract void startApp(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper
 * JD-Core Version:    0.7.0.1
 */