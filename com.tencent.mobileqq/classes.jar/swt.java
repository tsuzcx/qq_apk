import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/TiktokVideoItemHolder;", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "accountNameLayout", "Landroid/view/ViewGroup;", "getAccountNameLayout", "()Landroid/view/ViewGroup;", "setAccountNameLayout", "(Landroid/view/ViewGroup;)V", "sideBarMask", "getSideBarMask", "()Landroid/view/View;", "setSideBarMask", "stressFollowLayout", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout;", "getStressFollowLayout", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout;", "setStressFollowLayout", "(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowLayout;)V", "videoFeedsInfoContent", "getVideoFeedsInfoContent", "setVideoFeedsInfoContent", "videoFeedsStressFollowHelper", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsStressFollowHelper;", "writeCommentAvator", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;", "getWriteCommentAvator", "()Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;", "setWriteCommentAvator", "(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyHeadImageView;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class swt
  extends swr
{
  @NotNull
  private VideoFeedsStressFollowLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout;
  @NotNull
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  @JvmField
  @NotNull
  public soh a;
  @NotNull
  private View d;
  @NotNull
  private View e;
  @NotNull
  private ViewGroup y;
  
  public swt(@NotNull View paramView)
  {
    super(paramView);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
    if (localObject != null) {
      ((ReadInJoyNickNameTextView)localObject).setPrefix("@");
    }
    localObject = paramView.findViewById(2131380901);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…_iv_write_comment_avator)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)localObject);
    localObject = paramView.findViewById(2131380902);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…eo_feeds_ll_account_name)");
    this.y = ((ViewGroup)localObject);
    localObject = paramView.findViewById(2131378113);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.stress_follow_layout)");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout = ((VideoFeedsStressFollowLayout)localObject);
    localObject = paramView.findViewById(2131380907);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.v…o_feeds_ll_inner_content)");
    this.e = ((View)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout;
    ViewGroup localViewGroup = this.i;
    if (localViewGroup == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_Soh = new soh((VideoFeedsStressFollowLayout)localObject, (View)localViewGroup);
    paramView = paramView.findViewById(2131380909);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.video_feeds_sidebar_mask)");
    this.d = paramView;
    float f = Aladdin.getConfig(263).getFloatFromString("tiktok_bar_mask_alpha", 0.4F);
    this.d.setAlpha(f);
  }
  
  @NotNull
  public final VideoFeedsStressFollowLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsStressFollowLayout;
  }
  
  @NotNull
  public final ReadInJoyHeadImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  }
  
  @NotNull
  public final View b()
  {
    return this.d;
  }
  
  @NotNull
  public final View c()
  {
    return this.e;
  }
  
  @NotNull
  public final ViewGroup e()
  {
    return this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swt
 * JD-Core Version:    0.7.0.1
 */