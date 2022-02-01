package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView.OnSetNickNameListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsAccessibilityHelper;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelper;", "()V", "requestTitleFocus", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setAccountDescription", "view", "Landroid/view/View;", "description", "", "setAvatarDescription", "setCommentDescription", "count", "", "setContentDescription", "setDianZanDescription", "isDianZan", "", "setLikeDescription", "setVideoPauseOrRestart", "isPause", "setVideoTime", "time", "", "tryToInitSwitchVideoForAccessibility", "tryToSetNickListener", "v", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView;", "listener", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView$OnSetNickNameListener;", "tryToSetSwitchVideoForAccessibilityListener", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "Landroid/view/View$OnClickListener;", "tryToSetVideoFeedsRVAccessibilityDelegate", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "VideoFeedsRVAccessibilityDelegate", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsAccessibilityHelper
  implements IVideoFeedsAccessibilityHelper
{
  public static final VideoFeedsAccessibilityHelper a = new VideoFeedsAccessibilityHelper();
  
  @Nullable
  public View a(@Nullable View paramView)
  {
    if ((AppSetting.d) && (paramView != null))
    {
      paramView = paramView.findViewById(2131361862);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      return paramView;
    }
    return null;
  }
  
  public void a(@Nullable RecyclerView.ViewHolder paramViewHolder)
  {
    if (AppSetting.d)
    {
      if (paramViewHolder == null) {
        return;
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramViewHolder))
      {
        AccessibilityUtil.a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdBottomRecommendFromADVideoItemHolder(paramViewHolder));
        return;
      }
      if ((paramViewHolder instanceof VideoItemHolder)) {
        AccessibilityUtil.a((View)((VideoItemHolder)paramViewHolder).v);
      }
    }
  }
  
  public void a(@Nullable RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView != null)
    {
      if (!AppSetting.d) {
        return;
      }
      paramRecyclerView.setAccessibilityDelegateCompat((RecyclerViewAccessibilityDelegate)new VideoFeedsAccessibilityHelper.VideoFeedsRVAccessibilityDelegate(paramRecyclerView));
    }
  }
  
  public void a(@Nullable View paramView, int paramInt)
  {
    if (!AppSetting.d) {
      return;
    }
    a(paramView, VideoFeedsHelper.b(paramInt, HardCodeUtil.a(2131715926)));
  }
  
  public void a(@Nullable View paramView, long paramLong)
  {
    if (!AppSetting.d) {
      return;
    }
    Object localObject = VideoFeedsHelper.a(paramLong);
    if (localObject != null)
    {
      localObject = ((StringBuilder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "timeStr.toString()");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715924));
      localStringBuilder.append((String)localObject);
      a(paramView, localStringBuilder.toString());
    }
  }
  
  public void a(@Nullable View paramView, @Nullable String paramString)
  {
    if (paramView == null) {
      return;
    }
    paramView.setContentDescription((CharSequence)paramString);
  }
  
  public void a(@Nullable View paramView, boolean paramBoolean)
  {
    if (!AppSetting.d) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 2131715961;
    } else {
      i = 2131715963;
    }
    a(paramView, HardCodeUtil.a(i));
  }
  
  public void a(@Nullable AbsReadInJoyNickNameTextView paramAbsReadInJoyNickNameTextView, @Nullable AbsReadInJoyNickNameTextView.OnSetNickNameListener paramOnSetNickNameListener)
  {
    if (AppSetting.d)
    {
      if (paramAbsReadInJoyNickNameTextView == null) {
        return;
      }
      if (paramOnSetNickNameListener == null) {
        Intrinsics.throwNpe();
      }
      paramAbsReadInJoyNickNameTextView.setOnSetNickNameListener(paramOnSetNickNameListener);
    }
  }
  
  public final void a(@Nullable ShortVideoItemHolder paramShortVideoItemHolder, @Nullable View.OnClickListener paramOnClickListener)
  {
    if ((AppSetting.d) && (paramShortVideoItemHolder != null))
    {
      if (paramShortVideoItemHolder.a == null) {
        return;
      }
      View localView = paramShortVideoItemHolder.a;
      if (localView == null) {
        Intrinsics.throwNpe();
      }
      localView.setOnClickListener(paramOnClickListener);
      paramOnClickListener = paramShortVideoItemHolder.a;
      if (paramOnClickListener == null) {
        Intrinsics.throwNpe();
      }
      paramOnClickListener.setTag(paramShortVideoItemHolder);
    }
  }
  
  public void b(@Nullable View paramView, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (!AppSetting.d) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715943));
      localStringBuilder.append(paramString);
      a(paramView, localStringBuilder.toString());
    }
  }
  
  public void c(@Nullable View paramView, @Nullable String paramString)
  {
    if (AppSetting.d)
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return;
      }
      a(paramView, Intrinsics.stringPlus(paramString, HardCodeUtil.a(2131715939)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */