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
  private View jdField_a_of_type_AndroidViewView;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  
  public EmptyBadgeDisplay(@NotNull RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
  }
  
  private final ImageView a()
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
    localImageView.setImageResource(2130850766);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setTranslationX(LayoutAttrsKt.getDp(15));
    localImageView.setTranslationY(LayoutAttrsKt.getDp(-8));
    return localImageView;
  }
  
  private final RelativeLayout.LayoutParams a()
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
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)a());
      paramObject = a();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)paramObject);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.EmptyBadgeDisplay
 * JD-Core Version:    0.7.0.1
 */