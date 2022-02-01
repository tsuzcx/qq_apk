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
  @NotNull
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  @JvmField
  @NotNull
  public VideoFeedsStressFollowHelper a;
  @NotNull
  private VideoFeedsStressFollowLayout jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout;
  @NotNull
  private View d;
  @NotNull
  private View e;
  @NotNull
  private TextView f;
  @NotNull
  private ViewGroup z;
  
  public TiktokVideoItemHolder(@NotNull View paramView)
  {
    super(paramView);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetAbsReadInJoyNickNameTextView;
    if (localObject != null) {
      ((AbsReadInJoyNickNameTextView)localObject).setPrefix("@");
    }
    localObject = paramView.findViewById(2131380611);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…_iv_write_comment_avator)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)localObject);
    localObject = paramView.findViewById(2131380613);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…eo_feeds_ll_account_name)");
    this.z = ((ViewGroup)localObject);
    localObject = paramView.findViewById(2131377945);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.stress_follow_layout)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout = ((VideoFeedsStressFollowLayout)localObject);
    localObject = paramView.findViewById(2131380618);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…o_feeds_ll_inner_content)");
    this.e = ((View)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout;
    ViewGroup localViewGroup = this.j;
    if (localViewGroup == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowHelper = new VideoFeedsStressFollowHelper((VideoFeedsStressFollowLayout)localObject, (View)localViewGroup);
    localObject = paramView.findViewById(2131380620);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.video_feeds_sidebar_mask)");
    this.d = ((View)localObject);
    a(this.e);
    paramView = paramView.findViewById(2131367145);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.footer_share_count_text)");
    this.f = ((TextView)paramView);
    float f1 = Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F);
    this.d.setAlpha(f1);
  }
  
  @NotNull
  public final ReadInJoyHeadImageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView;
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout;
  }
  
  @NotNull
  public final View c()
  {
    return this.d;
  }
  
  @NotNull
  public final View d()
  {
    return this.e;
  }
  
  @NotNull
  public final ViewGroup f()
  {
    return this.z;
  }
  
  @NotNull
  public final TextView k()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder
 * JD-Core Version:    0.7.0.1
 */