package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView.OnSetNickNameListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAccessibilityHelper;", "", "requestTitleFocus", "", "holder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "setAccountDescription", "view", "Landroid/view/View;", "description", "", "setAvatarDescription", "setCommentDescription", "count", "", "setContentDescription", "setDianZanDescription", "isDianZan", "", "setLikeDescription", "setVideoPauseOrRestart", "isPause", "setVideoTime", "time", "", "tryToInitSwitchVideoForAccessibility", "tryToSetNickListener", "v", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView;", "listener", "Lcom/tencent/mobileqq/kandian/biz/common/widget/AbsReadInJoyNickNameTextView$OnSetNickNameListener;", "tryToSetVideoFeedsRVAccessibilityDelegate", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsAccessibilityHelper
{
  public abstract void a(@Nullable View paramView, int paramInt);
  
  public abstract void a(@Nullable AbsReadInJoyNickNameTextView paramAbsReadInJoyNickNameTextView, @Nullable AbsReadInJoyNickNameTextView.OnSetNickNameListener paramOnSetNickNameListener);
  
  public abstract void b(@Nullable View paramView, @Nullable String paramString);
  
  public abstract void c(@Nullable View paramView, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper
 * JD-Core Version:    0.7.0.1
 */