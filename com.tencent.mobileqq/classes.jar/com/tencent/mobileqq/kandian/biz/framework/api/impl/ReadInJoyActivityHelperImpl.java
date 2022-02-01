package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyActivityHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyActivityHelper;", "()V", "checkAppPackage", "", "appPackageName", "", "getFastWebIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "data", "Ljava/util/HashMap;", "getJumpReadInJoyNewFeedsIntent", "from", "", "getJumpReadInJoyTabFloatingWindowIntent", "rowKey", "articleURL", "getJumpReadInJoyTabIntent", "channelId", "getOpenArticleSchemeIntent", "getReadInJoyAdIMAXBrowserFragmentClazz", "Ljava/lang/Class;", "getReadInJoyAdPopSheetBrowserFragmentClazz", "getReadInJoyChannelActivityClazz", "getReadInJoyDraftboxFragmentClazz", "getReadInJoyNewFeedsActivityClazz", "getReadInJoySettingActivityClazz", "getReadInJoyUploadAvatarFragmentClazz", "isReadInJoyArticleDetailActivity", "isReadInJoyChannelActivity", "isReadInJoyNewFeedsActivity", "launchApp", "", "appSchema", "channelID", "defaultURL", "cancelJump", "launchChannelActivity", "channelName", "channelType", "reportFrom", "param", "", "", "clearTop", "isFromImmersive", "launchFeedsActivity", "launchFrom", "tabIndex", "extraData", "Landroid/os/Bundle;", "articleList", "", "", "currentArticleID", "launchGroupSubscribeChannelActivity", "args", "comeFrom", "launchInterestActivity", "launchKanDianDailyActivity", "bundle", "launchReadInJoyPrivacyListFragment", "activity", "Landroid/app/Activity;", "feedsId", "launchReadInJoySelectMemberAQFragmentForResult", "intent", "launchReadInJoySelfActivity", "redTouch", "launchReadInJoyTab", "launchReadInJoyUninterestComplainFragmentForResult", "launchSelfFromIndependentTab", "shouldMessages", "launchSubscriptionActivity", "jumpAction", "launchVideoChannelActivityForTwoItemVideo", "mainArticle", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "clickedArticle", "showAdapterAnim", "launchVideoSubChannelActivity", "openDailyDynamicChildFeeds", "openFlutterPage", "openFullVideoPlay", "openMXFlutterPage", "startApp", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyActivityHelperImpl
  implements IReadInJoyActivityHelper
{
  public boolean checkAppPackage(@Nullable String paramString)
  {
    return this.$$delegate_0.checkAppPackage(paramString);
  }
  
  @NotNull
  public Intent getFastWebIntent(@NotNull Context paramContext, @NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "data");
    return this.$$delegate_0.getFastWebIntent(paramContext, paramHashMap);
  }
  
  @NotNull
  public Intent getJumpReadInJoyNewFeedsIntent(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.getJumpReadInJoyNewFeedsIntent(paramContext, paramInt);
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabFloatingWindowIntent(@NotNull Context paramContext, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "articleURL");
    return this.$$delegate_0.getJumpReadInJoyTabFloatingWindowIntent(paramContext, paramInt, paramString1, paramString2);
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.getJumpReadInJoyTabIntent(paramContext, paramInt);
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.getJumpReadInJoyTabIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Nullable
  public Intent getOpenArticleSchemeIntent(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    return this.$$delegate_0.getOpenArticleSchemeIntent(paramContext, paramHashMap);
  }
  
  @NotNull
  public Class<?> getReadInJoyAdIMAXBrowserFragmentClazz()
  {
    return this.$$delegate_0.getReadInJoyAdIMAXBrowserFragmentClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoyAdPopSheetBrowserFragmentClazz()
  {
    return this.$$delegate_0.getReadInJoyAdPopSheetBrowserFragmentClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoyChannelActivityClazz()
  {
    return this.$$delegate_0.getReadInJoyChannelActivityClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoyDraftboxFragmentClazz()
  {
    return this.$$delegate_0.getReadInJoyDraftboxFragmentClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoyNewFeedsActivityClazz()
  {
    return this.$$delegate_0.getReadInJoyNewFeedsActivityClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoySettingActivityClazz()
  {
    return this.$$delegate_0.getReadInJoySettingActivityClazz();
  }
  
  @NotNull
  public Class<?> getReadInJoyUploadAvatarFragmentClazz()
  {
    return this.$$delegate_0.getReadInJoyUploadAvatarFragmentClazz();
  }
  
  public boolean isReadInJoyArticleDetailActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.isReadInJoyArticleDetailActivity(paramContext);
  }
  
  public boolean isReadInJoyChannelActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.isReadInJoyChannelActivity(paramContext);
  }
  
  public boolean isReadInJoyNewFeedsActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.isReadInJoyNewFeedsActivity(paramContext);
  }
  
  public void launchApp(@NotNull Context paramContext, @Nullable String paramString1, int paramInt, @Nullable String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchApp(paramContext, paramString1, paramInt, paramString2, paramBoolean);
  }
  
  public void launchChannelActivity(@NotNull Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap)
  {
    this.$$delegate_0.launchChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap);
  }
  
  public void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.$$delegate_0.launchChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchFeedsActivity(paramContext, paramInt1, paramInt2);
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchFeedsActivity(paramContext, paramInt1, paramInt2, paramBundle);
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, @Nullable List<Long> paramList, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchFeedsActivity(paramContext, paramList, paramLong, paramInt);
  }
  
  public void launchGroupSubscribeChannelActivity(@Nullable Context paramContext, @Nullable String paramString, int paramInt)
  {
    this.$$delegate_0.launchGroupSubscribeChannelActivity(paramContext, paramString, paramInt);
  }
  
  public void launchInterestActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchInterestActivity(paramContext);
  }
  
  public void launchKanDianDailyActivity(@NotNull Context paramContext, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchKanDianDailyActivity(paramContext, paramInt, paramBundle, paramBoolean);
  }
  
  public void launchReadInJoyPrivacyListFragment(@NotNull Activity paramActivity, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    this.$$delegate_0.launchReadInJoyPrivacyListFragment(paramActivity, paramLong);
  }
  
  public void launchReadInJoySelectMemberAQFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.$$delegate_0.launchReadInJoySelectMemberAQFragmentForResult(paramActivity, paramIntent);
  }
  
  public void launchReadInJoySelfActivity(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchReadInJoySelfActivity(paramContext, paramBoolean);
  }
  
  public void launchReadInJoyTab(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchReadInJoyTab(paramContext, paramInt);
  }
  
  public void launchReadInJoyUninterestComplainFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.$$delegate_0.launchReadInJoyUninterestComplainFragmentForResult(paramActivity, paramIntent);
  }
  
  public void launchSelfFromIndependentTab(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.$$delegate_0.launchSelfFromIndependentTab(paramContext, paramBoolean);
  }
  
  @Nullable
  public Intent launchSubscriptionActivity(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.launchSubscriptionActivity(paramContext, paramInt1, paramInt2);
  }
  
  public void launchVideoChannelActivityForTwoItemVideo(@NotNull Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo1, "mainArticle");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo2, "clickedArticle");
    this.$$delegate_0.launchVideoChannelActivityForTwoItemVideo(paramContext, paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramBoolean);
  }
  
  public void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "channelName");
    this.$$delegate_0.launchVideoSubChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "channelName");
    this.$$delegate_0.launchVideoSubChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap);
  }
  
  public void openDailyDynamicChildFeeds(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    this.$$delegate_0.openDailyDynamicChildFeeds(paramContext, paramHashMap);
  }
  
  public void openFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    this.$$delegate_0.openFlutterPage(paramContext, paramHashMap);
  }
  
  public void openFullVideoPlay(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    this.$$delegate_0.openFullVideoPlay(paramContext, paramHashMap);
  }
  
  public void openMXFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    this.$$delegate_0.openMXFlutterPage(paramContext, paramHashMap);
  }
  
  public void startApp(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    this.$$delegate_0.startApp(paramContext, paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelperImpl
 * JD-Core Version:    0.7.0.1
 */