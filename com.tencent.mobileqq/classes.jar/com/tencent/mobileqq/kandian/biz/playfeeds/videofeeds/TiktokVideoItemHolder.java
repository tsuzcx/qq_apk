package com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/TiktokVideoItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "accountNameLayout", "Landroid/view/ViewGroup;", "getAccountNameLayout", "()Landroid/view/ViewGroup;", "setAccountNameLayout", "(Landroid/view/ViewGroup;)V", "shareCountText", "Landroid/widget/TextView;", "getShareCountText", "()Landroid/widget/TextView;", "setShareCountText", "(Landroid/widget/TextView;)V", "sideBarMask", "getSideBarMask", "()Landroid/view/View;", "setSideBarMask", "stressFollowLayout", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;", "getStressFollowLayout", "()Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;", "setStressFollowLayout", "(Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;)V", "videoFeedsInfoContent", "getVideoFeedsInfoContent", "setVideoFeedsInfoContent", "videoFeedsStressFollowHelper", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowHelper;", "writeCommentAvator", "Lcom/tencent/mobileqq/kandian/biz/common/widget/ReadInJoyHeadImageView;", "getWriteCommentAvator", "()Lcom/tencent/mobileqq/kandian/biz/common/widget/ReadInJoyHeadImageView;", "setWriteCommentAvator", "(Lcom/tencent/mobileqq/kandian/biz/common/widget/ReadInJoyHeadImageView;)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TiktokVideoItemHolder
  extends ShortVideoItemHolder
{
  @JvmField
  @NotNull
  public VideoFeedsStressFollowHelper m;
  @NotNull
  private ReadInJoyHeadImageView n;
  @NotNull
  private ViewGroup o;
  @NotNull
  private VideoFeedsStressFollowLayout p;
  @NotNull
  private View q;
  @NotNull
  private View r;
  @NotNull
  private TextView s;
  
  public TiktokVideoItemHolder(@NotNull View paramView)
  {
    super(paramView);
    Object localObject = this.aJ;
    if (localObject != null) {
      ((AbsReadInJoyNickNameTextView)localObject).setPrefix("@");
    }
    localObject = paramView.findViewById(2131449569);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…_iv_write_comment_avator)");
    this.n = ((ReadInJoyHeadImageView)localObject);
    localObject = paramView.findViewById(2131449571);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…eo_feeds_ll_account_name)");
    this.o = ((ViewGroup)localObject);
    localObject = paramView.findViewById(2131446431);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.stress_follow_layout)");
    this.p = ((VideoFeedsStressFollowLayout)localObject);
    localObject = paramView.findViewById(2131449576);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…o_feeds_ll_inner_content)");
    this.r = ((View)localObject);
    localObject = this.p;
    ViewGroup localViewGroup = this.aH;
    if (localViewGroup == null) {
      Intrinsics.throwNpe();
    }
    this.m = new VideoFeedsStressFollowHelper((VideoFeedsStressFollowLayout)localObject, (View)localViewGroup);
    localObject = paramView.findViewById(2131449578);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.video_feeds_sidebar_mask)");
    this.q = ((View)localObject);
    a(this.r);
    paramView = paramView.findViewById(2131433599);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.footer_share_count_text)");
    this.s = ((TextView)paramView);
    float f = Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F);
    this.q.setAlpha(f);
  }
  
  @NotNull
  public final ReadInJoyHeadImageView F()
  {
    return this.n;
  }
  
  @NotNull
  public final ViewGroup G()
  {
    return this.o;
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout H()
  {
    return this.p;
  }
  
  @NotNull
  public final View I()
  {
    return this.q;
  }
  
  @NotNull
  public final View J()
  {
    return this.r;
  }
  
  @NotNull
  public final TextView K()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */