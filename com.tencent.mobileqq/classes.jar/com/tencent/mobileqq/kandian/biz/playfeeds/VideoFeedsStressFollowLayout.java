package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.ScalingFrameLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarBgView", "Landroid/view/View;", "avatarView", "followBtn", "followClickListeners", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsStressFollowLayout$OnFollowActionListener;", "Lkotlin/collections/ArrayList;", "followCountTextView", "Landroid/widget/TextView;", "infoView", "liveMaskView", "nickNameTextView", "nowStressState", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/StressState;", "scalingLayout", "Lcom/tencent/mobileqq/kandian/base/view/widget/ScalingFrameLayout;", "shrinkWidth", "", "stretchWidth", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "addFollowButtonClick", "", "onFollowActionListener", "canDoAnim", "", "getFormatFollowCount", "", "count", "getState", "isShowStressFollowed", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setStressState", "state", "setVideoInfo", "info", "updateStretchPercent", "percent", "Companion", "OnFollowActionListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsStressFollowLayout
  extends FrameLayout
{
  public static final VideoFeedsStressFollowLayout.Companion a;
  private static final float jdField_b_of_type_Float = 0.48F;
  private final float jdField_a_of_type_Float = DisplayUtils.a((Context)BaseApplication.getContext(), 48.0F);
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final ScalingFrameLayout jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetScalingFrameLayout;
  private StressState jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = StressState.Shrink;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private final ArrayList<VideoFeedsStressFollowLayout.OnFollowActionListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final View jdField_b_of_type_AndroidViewView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final View c;
  private final View d;
  private final View e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsStressFollowLayout$Companion = new VideoFeedsStressFollowLayout.Companion(null);
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131560355, (ViewGroup)this, true);
    setBackgroundResource(2130843351);
    paramContext = findViewById(2131368851);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131366937);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368088);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368096);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368098);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131368860);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131379784);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131379688);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131560355, (ViewGroup)this, true);
    setBackgroundResource(2130843351);
    paramContext = findViewById(2131368851);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131366937);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368088);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368096);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368098);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131368860);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131379784);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131379688);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131560355, (ViewGroup)this, true);
    setBackgroundResource(2130843351);
    paramContext = findViewById(2131368851);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131366937);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetScalingFrameLayout = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131368088);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(2131368096);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.c = paramContext;
    paramContext = findViewById(2131368098);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.d = paramContext;
    paramContext = findViewById(2131368860);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.e = paramContext;
    paramContext = findViewById(2131379784);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(2131379688);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.e.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  private final String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Float.valueOf(paramInt / 10000.0F);
    localObject = String.format("%.1fW", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
  
  @NotNull
  public final StressState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState;
  }
  
  public final void a(float paramFloat)
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = ((int)(this.jdField_a_of_type_Int * paramFloat + this.jdField_a_of_type_Float));
    setLayoutParams(localLayoutParams);
    float f = RangesKt.coerceAtLeast(paramFloat - jdField_b_of_type_Float, 0.0F) / (1.0F - jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidViewView.setAlpha(f);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetScalingFrameLayout.setScale(1.2F - 0.2F * paramFloat);
    int i;
    if (paramFloat == 0.0F) {
      i = 8;
    } else {
      i = 0;
    }
    if (this.e.getVisibility() != i) {
      this.e.setVisibility(i);
    }
  }
  
  public final void a(@NotNull VideoFeedsStressFollowLayout.OnFollowActionListener paramOnFollowActionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFollowActionListener, "onFollowActionListener");
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnFollowActionListener);
  }
  
  public final boolean a()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    return (localVideoInfo != null) && (!localVideoInfo.p);
  }
  
  public final boolean b()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    return (localVideoInfo != null) && (localVideoInfo.j == true);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = ((int)(getMeasuredWidth() - this.jdField_a_of_type_Float));
      float f;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState == StressState.Stretched) {
        f = 1.0F;
      } else {
        f = 0.0F;
      }
      a(f);
    }
  }
  
  public final void setStressState(@NotNull StressState paramStressState)
  {
    Intrinsics.checkParameterIsNotNull(paramStressState, "state");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState == paramStressState) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = paramStressState;
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (localVideoInfo != null) {
      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = paramStressState;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState == StressState.Stretched) {
      a(1.0F);
    } else {
      a(0.0F);
    }
    post((Runnable)new VideoFeedsStressFollowLayout.setStressState.1(this));
  }
  
  public final void setVideoInfo(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramVideoInfo.k);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    localTextView.setText((CharSequence)localBaseApplication.getResources().getString(2131717925, new Object[] { a(paramVideoInfo.n) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout
 * JD-Core Version:    0.7.0.1
 */