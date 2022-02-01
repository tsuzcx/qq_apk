package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/EmptyBadgeDisplay;", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJXTabBadgeDisplay;", "", "badgeContainer", "Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "emptyBadgeView", "Landroid/view/View;", "createEmptyBadgeView", "Landroid/widget/ImageView;", "createEmptyViewLp", "Landroid/widget/RelativeLayout$LayoutParams;", "hide", "", "withAnim", "", "show", "badgeData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class EmptyBadgeDisplay
  implements IRIJXTabBadgeDisplay<Object>
{
  private View a;
  private final RelativeLayout b;
  
  public EmptyBadgeDisplay(@NotNull RelativeLayout paramRelativeLayout)
  {
    this.b = paramRelativeLayout;
  }
  
  private final ImageView a()
  {
    ImageView localImageView = new ImageView(this.b.getContext());
    localImageView.setImageResource(2130852588);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setTranslationX(LayoutAttrsKt.getDp(15));
    localImageView.setTranslationY(LayoutAttrsKt.getDp(-8));
    return localImageView;
  }
  
  private final RelativeLayout.LayoutParams b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(LayoutAttrsKt.getDp(6), LayoutAttrsKt.getDp(6));
    localLayoutParams.topMargin = LayoutAttrsKt.getDp(4);
    localLayoutParams.rightMargin = LayoutAttrsKt.getDp(4);
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  public void a(@NotNull Object paramObject, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "badgeData");
    if (this.a == null)
    {
      this.a = ((View)a());
      paramObject = b();
      this.b.addView(this.a, (ViewGroup.LayoutParams)paramObject);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.removeView(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.EmptyBadgeDisplay
 * JD-Core Version:    0.7.0.1
 */