package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsHelper;", "()V", "calculateCommentViewGroupHeight", "", "activity", "Landroid/app/Activity;", "calculateVideoAreaHeight", "", "", "videoWidth", "videoHeight", "(Landroid/app/Activity;II)[Ljava/lang/Object;", "changeVisibilityWithAlphaAnimation", "", "view", "Landroid/view/View;", "visibility", "duration", "changeVisibilityWithObjectAnimator", "commonCountToString", "", "count", "commonSetCountToTextView", "textView", "Landroid/widget/TextView;", "defaultValue", "commonSetCountToTextViewAsync", "computeXYaxis", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "bottomOffset", "fileSizeToString", "byteSize", "", "getLogoMarginSize", "", "isFullScreen", "", "getMainFeedsKingCardAutoPlayConfig", "getScreenSize", "getTodayShowCountForSoftAd", "app", "Lmqq/app/AppRuntime;", "getVideoFeedsPlayActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "hideBottomUIMenu", "hideBottomUIMenuImmersived", "hideNavigationBar", "isFullScreenDisplay", "isIntentAvailable", "intent", "isPlayFeedsActivity", "isSystemAutoRotateOpen", "isVideoFeedsPlayActivity", "modifyVideoUrlForKingCard", "originUrl", "openVideoFeedsPlayActivity", "bundle", "Landroid/os/Bundle;", "isLazyLoad", "fromType", "openVideoFeedsPlayActivityForDebug", "vid", "url", "isH265", "performViewSlideDownAnimator", "targetHeight", "delay", "performViewSlideUpAnim", "Landroid/animation/Animator;", "resolveUrlJumpInfo", "jumpInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UrlJumpInfo;", "setFollowTextVisibility", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "needShow", "setRichTitle", "titleTextView", "setTimeTextForTextView", "timeMS", "updateTodayShowCountForSoftAd", "newValue", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsHelperImpl
  implements IVideoFeedsHelper
{
  public int calculateCommentViewGroupHeight(@Nullable Activity paramActivity)
  {
    return VideoFeedsHelper.f(paramActivity);
  }
  
  @Nullable
  public Object[] calculateVideoAreaHeight(@Nullable Activity paramActivity, int paramInt1, int paramInt2)
  {
    return VideoFeedsHelper.d(paramActivity, paramInt1, paramInt2);
  }
  
  public void changeVisibilityWithAlphaAnimation(@Nullable View paramView, int paramInt1, int paramInt2)
  {
    VideoFeedsHelper.b(paramView, paramInt1, paramInt2);
  }
  
  public void changeVisibilityWithObjectAnimator(@Nullable View paramView, int paramInt)
  {
    VideoFeedsHelper.b(paramView, paramInt);
  }
  
  @Nullable
  public String commonCountToString(int paramInt)
  {
    return VideoFeedsHelper.e(paramInt);
  }
  
  public void commonSetCountToTextView(@Nullable TextView paramTextView, int paramInt, @Nullable String paramString)
  {
    VideoFeedsHelper.a(paramTextView, paramInt, paramString);
  }
  
  public void commonSetCountToTextViewAsync(@Nullable TextView paramTextView, int paramInt, @Nullable String paramString)
  {
    VideoFeedsHelper.b(paramTextView, paramInt, paramString);
  }
  
  public int computeXYaxis(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, int paramInt)
  {
    return VideoFeedsHelper.b(paramActivity, paramVideoInfo, paramInt);
  }
  
  @Nullable
  public String fileSizeToString(long paramLong)
  {
    return VideoFeedsHelper.c(paramLong);
  }
  
  @Nullable
  public int[] getLogoMarginSize(@Nullable Activity paramActivity, @Nullable VideoInfo paramVideoInfo, boolean paramBoolean, int paramInt)
  {
    return VideoFeedsHelper.a(paramActivity, paramVideoInfo, paramBoolean, paramInt);
  }
  
  public int getMainFeedsKingCardAutoPlayConfig()
  {
    return VideoFeedsHelper.j();
  }
  
  @Nullable
  public int[] getScreenSize(@Nullable Activity paramActivity)
  {
    return VideoFeedsHelper.c(paramActivity);
  }
  
  public int getTodayShowCountForSoftAd(@Nullable AppRuntime paramAppRuntime)
  {
    return VideoFeedsHelper.a(paramAppRuntime);
  }
  
  @NotNull
  public Intent getVideoFeedsPlayActivityIntent(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = VideoFeedsHelper.c(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "VideoFeedsHelper.getVide…ayActivityIntent(context)");
    return paramContext;
  }
  
  public void hideBottomUIMenu(@Nullable Activity paramActivity)
  {
    VideoFeedsPlayActivity.a(paramActivity);
  }
  
  public void hideBottomUIMenuImmersived(@Nullable Activity paramActivity)
  {
    VideoFeedsHelper.h(paramActivity);
  }
  
  public void hideNavigationBar(@Nullable Activity paramActivity)
  {
    VideoFeedsHelper.i(paramActivity);
  }
  
  public boolean isFullScreenDisplay(@Nullable Activity paramActivity)
  {
    return VideoFeedsHelper.a(paramActivity);
  }
  
  public boolean isIntentAvailable(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    return VideoFeedsHelper.a(paramContext, paramIntent);
  }
  
  public boolean isPlayFeedsActivity(@Nullable Activity paramActivity)
  {
    return VideoFeedsHelper.j(paramActivity);
  }
  
  public boolean isSystemAutoRotateOpen(@Nullable Context paramContext)
  {
    return VideoFeedsHelper.b(paramContext);
  }
  
  public boolean isVideoFeedsPlayActivity(@Nullable Activity paramActivity)
  {
    return paramActivity instanceof VideoFeedsPlayActivity;
  }
  
  @Nullable
  public String modifyVideoUrlForKingCard(@Nullable String paramString)
  {
    return VideoFeedsHelper.c(paramString);
  }
  
  public void openVideoFeedsPlayActivity(@Nullable Context paramContext, @Nullable Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    VideoFeedsHelper.a(paramContext, paramBundle, paramBoolean, paramInt);
  }
  
  public void openVideoFeedsPlayActivityForDebug(@Nullable Activity paramActivity, @Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    VideoFeedsHelper.a(paramActivity, paramString1, paramString2, paramBoolean);
  }
  
  public void performViewSlideDownAnimator(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    VideoFeedsHelper.a(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void performViewSlideDownAnimator(@Nullable View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    VideoFeedsHelper.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @Nullable
  public Animator performViewSlideUpAnim(@Nullable View paramView, int paramInt)
  {
    return VideoFeedsHelper.c(paramView, paramInt);
  }
  
  public void resolveUrlJumpInfo(@Nullable Context paramContext, @Nullable UrlJumpInfo paramUrlJumpInfo)
  {
    VideoFeedsHelper.a(paramContext, paramUrlJumpInfo);
  }
  
  public void setFollowTextVisibility(@NotNull VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    if ((paramVideoItemHolder instanceof ShortVideoItemHolder))
    {
      Object localObject = paramVideoItemHolder.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).al == true))
        {
          paramVideoItemHolder = ((ShortVideoItemHolder)paramVideoItemHolder).k;
          if (paramVideoItemHolder != null)
          {
            int i;
            if (paramBoolean) {
              i = 0;
            } else {
              i = 8;
            }
            paramVideoItemHolder.setVisibility(i);
          }
        }
      }
    }
  }
  
  public void setRichTitle(@Nullable VideoInfo paramVideoInfo, @Nullable TextView paramTextView)
  {
    VideoFeedsHelper.a(paramVideoInfo, paramTextView);
  }
  
  public void setTimeTextForTextView(@Nullable TextView paramTextView, long paramLong)
  {
    VideoFeedsHelper.a(paramTextView, paramLong);
  }
  
  public void updateTodayShowCountForSoftAd(@Nullable AppRuntime paramAppRuntime, int paramInt)
  {
    VideoFeedsHelper.a(paramAppRuntime, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsHelperImpl
 * JD-Core Version:    0.7.0.1
 */