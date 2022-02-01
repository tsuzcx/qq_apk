package com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/FooterItemHolder;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseItemHolder;", "view", "Landroid/view/View;", "itemType", "", "(Landroid/view/View;I)V", "loadingLayout", "Landroid/view/ViewGroup;", "loadingProgressBar", "Landroid/widget/ProgressBar;", "loadingTextView", "Landroid/widget/TextView;", "onScroll", "", "adapter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "isCenter", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FooterItemHolder
  extends BaseItemHolder
{
  @JvmField
  @NotNull
  public ViewGroup a;
  @JvmField
  @NotNull
  public ProgressBar b;
  @JvmField
  @NotNull
  public TextView c;
  
  public FooterItemHolder(@NotNull View paramView, int paramInt)
  {
    super(paramView, paramInt);
    View localView = paramView.findViewById(2131437648);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.loading_layout)");
    this.a = ((ViewGroup)localView);
    localView = paramView.findViewById(2131437660);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.loading_textview)");
    this.c = ((TextView)localView);
    paramView = paramView.findViewById(2131437654);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.loading_progress)");
    this.b = ((ProgressBar)paramView);
  }
  
  public void a(@NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter, @NotNull LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoFeedsAdapter, "adapter");
    Intrinsics.checkParameterIsNotNull(paramLinearLayoutManager, "layoutManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.FooterItemHolder
 * JD-Core Version:    0.7.0.1
 */