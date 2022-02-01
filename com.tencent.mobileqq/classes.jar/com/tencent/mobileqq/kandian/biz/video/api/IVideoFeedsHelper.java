package com.tencent.mobileqq.kandian.biz.video.api;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "calculateCommentViewGroupHeight", "", "activity", "Landroid/app/Activity;", "calculateVideoAreaHeight", "", "", "videoWidth", "videoHeight", "(Landroid/app/Activity;II)[Ljava/lang/Object;", "changeVisibilityWithAlphaAnimation", "", "view", "Landroid/view/View;", "visibility", "duration", "changeVisibilityWithObjectAnimator", "commonCountToString", "", "count", "commonSetCountToTextView", "textView", "Landroid/widget/TextView;", "defaultValue", "commonSetCountToTextViewAsync", "computeXYaxis", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "bottomOffset", "fileSizeToString", "byteSize", "", "getLogoMarginSize", "", "isFullScreen", "", "getMainFeedsKingCardAutoPlayConfig", "getScreenSize", "getTodayShowCountForSoftAd", "app", "Lmqq/app/AppRuntime;", "getVideoFeedsPlayActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "hideBottomUIMenu", "hideBottomUIMenuImmersived", "hideNavigationBar", "isFullScreenDisplay", "isIntentAvailable", "intent", "isPlayFeedsActivity", "isSystemAutoRotateOpen", "isVideoFeedsPlayActivity", "openVideoFeedsPlayActivity", "bundle", "Landroid/os/Bundle;", "isLazyLoad", "fromType", "openVideoFeedsPlayActivityForDebug", "vid", "url", "isH265", "performViewSlideDownAnimator", "targetHeight", "delay", "performViewSlideUpAnim", "Landroid/animation/Animator;", "resolveUrlJumpInfo", "jumpInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UrlJumpInfo;", "setFollowTextVisibility", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "needShow", "setRichTitle", "titleTextView", "setTimeTextForTextView", "timeMS", "updateTodayShowCountForSoftAd", "newValue", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsHelper
  extends QRouteApi
{
  public abstract int calculateCommentViewGroupHeight(@Nullable Activity paramActivity);
  
  @Nullable
  public abstract Object[] calculateVideoAreaHeight(@Nullable Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract void changeVisibilityWithAlphaAnimation(@Nullable View paramView, int paramInt1, int paramInt2);
  
  public abstract void changeVisibilityWithObjectAnimator(@Nullable View paramView, int paramInt);
  
  @Nullable
  public abstract String commonCountToString(int paramInt);
  
  public abstract void commonSetCountToTextView(@Nullable TextView paramTextView, int paramInt, @Nullable String paramString);
  
  public abstract void commonSetCountToTextViewAsync(@Nullable TextView paramTextView, int paramInt, @Nullable String paramString);
  
  public abstract int computeXYaxis(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, int paramInt);
  
  @Nullable
  public abstract String fileSizeToString(long paramLong);
  
  @Nullable
  public abstract int[] getLogoMarginSize(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, boolean paramBoolean, int paramInt);
  
  public abstract int getMainFeedsKingCardAutoPlayConfig();
  
  @Nullable
  public abstract int[] getScreenSize(@Nullable Activity paramActivity);
  
  public abstract int getTodayShowCountForSoftAd(@Nullable AppRuntime paramAppRuntime);
  
  @NotNull
  public abstract Intent getVideoFeedsPlayActivityIntent(@NotNull Context paramContext);
  
  public abstract void hideBottomUIMenu(@Nullable Activity paramActivity);
  
  public abstract void hideBottomUIMenuImmersived(@Nullable Activity paramActivity);
  
  public abstract void hideNavigationBar(@Nullable Activity paramActivity);
  
  public abstract boolean isFullScreenDisplay(@Nullable Activity paramActivity);
  
  public abstract boolean isIntentAvailable(@Nullable Context paramContext, @Nullable Intent paramIntent);
  
  public abstract boolean isPlayFeedsActivity(@Nullable Activity paramActivity);
  
  public abstract boolean isSystemAutoRotateOpen(@Nullable Context paramContext);
  
  public abstract boolean isVideoFeedsPlayActivity(@Nullable Activity paramActivity);
  
  public abstract void openVideoFeedsPlayActivity(@Nullable Context paramContext, @Nullable Bundle paramBundle, boolean paramBoolean, int paramInt);
  
  public abstract void openVideoFeedsPlayActivityForDebug(@Nullable Activity paramActivity, @Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean);
  
  public abstract void performViewSlideDownAnimator(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void performViewSlideDownAnimator(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @Nullable
  public abstract Animator performViewSlideUpAnim(@Nullable View paramView, int paramInt);
  
  public abstract void resolveUrlJumpInfo(@Nullable Context paramContext, @Nullable UrlJumpInfo paramUrlJumpInfo);
  
  public abstract void setFollowTextVisibility(@NotNull VideoItemHolder paramVideoItemHolder, boolean paramBoolean);
  
  public abstract void setRichTitle(@Nullable VideoInfo paramVideoInfo, @Nullable TextView paramTextView);
  
  public abstract void setTimeTextForTextView(@Nullable TextView paramTextView, long paramLong);
  
  public abstract void updateTodayShowCountForSoftAd(@Nullable AppRuntime paramAppRuntime, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper
 * JD-Core Version:    0.7.0.1
 */