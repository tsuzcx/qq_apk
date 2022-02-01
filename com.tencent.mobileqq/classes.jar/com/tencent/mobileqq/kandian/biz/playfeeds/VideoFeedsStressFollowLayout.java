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
  public static final VideoFeedsStressFollowLayout.Companion a = new VideoFeedsStressFollowLayout.Companion(null);
  private static final float o = 0.48F;
  private final float b = DisplayUtils.a((Context)BaseApplication.getContext(), 48.0F);
  private int c;
  private final View d;
  private final View e;
  private final View f;
  private final View g;
  private final ScalingFrameLayout h;
  private final View i;
  private final TextView j;
  private final TextView k;
  private final ArrayList<VideoFeedsStressFollowLayout.OnFollowActionListener> l = new ArrayList();
  private StressState m = StressState.Shrink;
  private VideoInfo n;
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(getContext()).inflate(2131626401, (ViewGroup)this, true);
    setBackgroundResource(2130844305);
    paramContext = findViewById(2131435785);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.d = paramContext;
    paramContext = findViewById(2131433290);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.h = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131434942);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.e = paramContext;
    paramContext = findViewById(2131434950);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.f = paramContext;
    paramContext = findViewById(2131434952);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.g = paramContext;
    paramContext = findViewById(2131435794);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.i = paramContext;
    paramContext = findViewById(2131448606);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.j = ((TextView)paramContext);
    paramContext = findViewById(2131448470);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.k = ((TextView)paramContext);
    this.i.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131626401, (ViewGroup)this, true);
    setBackgroundResource(2130844305);
    paramContext = findViewById(2131435785);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.d = paramContext;
    paramContext = findViewById(2131433290);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.h = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131434942);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.e = paramContext;
    paramContext = findViewById(2131434950);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.f = paramContext;
    paramContext = findViewById(2131434952);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.g = paramContext;
    paramContext = findViewById(2131435794);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.i = paramContext;
    paramContext = findViewById(2131448606);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.j = ((TextView)paramContext);
    paramContext = findViewById(2131448470);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.k = ((TextView)paramContext);
    this.i.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
  }
  
  public VideoFeedsStressFollowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131626401, (ViewGroup)this, true);
    setBackgroundResource(2130844305);
    paramContext = findViewById(2131435785);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.info_view)");
    this.d = paramContext;
    paramContext = findViewById(2131433290);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.fl_scaling_layout)");
    this.h = ((ScalingFrameLayout)paramContext);
    paramContext = findViewById(2131434942);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_avatar_bg)");
    this.e = paramContext;
    paramContext = findViewById(2131434950);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_imageview)");
    this.f = paramContext;
    paramContext = findViewById(2131434952);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.header_account_icon_living)");
    this.g = paramContext;
    paramContext = findViewById(2131435794);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.inner_account_follow_button)");
    this.i = paramContext;
    paramContext = findViewById(2131448606);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_nickname)");
    this.j = ((TextView)paramContext);
    paramContext = findViewById(2131448470);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_follow_count)");
    this.k = ((TextView)paramContext);
    this.i.setOnClickListener((View.OnClickListener)new VideoFeedsStressFollowLayout.1(this));
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
  
  public final void a(float paramFloat)
  {
    if (this.c == 0) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.width = ((int)(this.c * paramFloat + this.b));
    setLayoutParams(localLayoutParams);
    float f1 = RangesKt.coerceAtLeast(paramFloat - o, 0.0F) / (1.0F - o);
    this.d.setAlpha(f1);
    this.h.setScale(1.2F - 0.2F * paramFloat);
    int i1;
    if (paramFloat == 0.0F) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    if (this.i.getVisibility() != i1) {
      this.i.setVisibility(i1);
    }
  }
  
  public final void a(@NotNull VideoFeedsStressFollowLayout.OnFollowActionListener paramOnFollowActionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFollowActionListener, "onFollowActionListener");
    this.l.add(paramOnFollowActionListener);
  }
  
  public final boolean a()
  {
    VideoInfo localVideoInfo = this.n;
    return (localVideoInfo != null) && (!localVideoInfo.al);
  }
  
  public final boolean b()
  {
    VideoInfo localVideoInfo = this.n;
    return (localVideoInfo != null) && (localVideoInfo.Z == true);
  }
  
  @NotNull
  public final StressState getState()
  {
    return this.m;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c == 0)
    {
      this.c = ((int)(getMeasuredWidth() - this.b));
      float f1;
      if (this.m == StressState.Stretched) {
        f1 = 1.0F;
      } else {
        f1 = 0.0F;
      }
      a(f1);
    }
  }
  
  public final void setStressState(@NotNull StressState paramStressState)
  {
    Intrinsics.checkParameterIsNotNull(paramStressState, "state");
    if (this.m == paramStressState) {
      return;
    }
    this.m = paramStressState;
    VideoInfo localVideoInfo = this.n;
    if (localVideoInfo != null) {
      localVideoInfo.aP = paramStressState;
    }
    if (this.m == StressState.Stretched) {
      a(1.0F);
    } else {
      a(0.0F);
    }
    post((Runnable)new VideoFeedsStressFollowLayout.setStressState.1(this));
  }
  
  public final void setVideoInfo(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    this.n = paramVideoInfo;
    this.j.setText((CharSequence)paramVideoInfo.r);
    TextView localTextView = this.k;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    localTextView.setText((CharSequence)localBaseApplication.getResources().getString(2131915399, new Object[] { a(paramVideoInfo.Y) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStressFollowLayout
 * JD-Core Version:    0.7.0.1
 */