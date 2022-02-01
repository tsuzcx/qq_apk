package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NewLabelEditCtrl;", "Lcom/tencent/mobileqq/nearby/profilecard/LabelEditCtrl;", "()V", "createLabelItem", "Landroid/view/View;", "tagIdx", "", "tag", "Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;", "itemCount", "initItem", "Lcom/tencent/mobileqq/nearby/profilecard/LabelContainer;", "itemView", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewLabelEditCtrl
  extends LabelEditCtrl
{
  @NotNull
  protected View a(int paramInt1, @Nullable InterestTag paramInterestTag, int paramInt2)
  {
    paramInterestTag = super.a(paramInt1, paramInterestTag, paramInt2);
    ViewGroup localViewGroup = (ViewGroup)paramInterestTag.findViewById(2131436826);
    float f = UIUtils.a(localViewGroup.getContext(), 17.5F);
    paramInt2 = localViewGroup.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Drawable localDrawable = localViewGroup.getChildAt(paramInt1).getBackground();
      if ((localDrawable != null) && ((localDrawable instanceof GradientDrawable))) {
        ((GradientDrawable)localDrawable).setCornerRadius(f);
      }
      paramInt1 += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramInterestTag, "super.createLabelItem(ta…}\n            }\n        }");
    return paramInterestTag;
  }
  
  @NotNull
  protected LabelContainer a(@NotNull View paramView, int paramInt1, @Nullable InterestTag paramInterestTag, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramView.findViewById(2131445137).setBackgroundResource(0);
    paramView = super.a(paramView, paramInt1, paramInterestTag, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "super.initItem(itemView, tagIdx, tag, itemCount)");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewLabelEditCtrl
 * JD-Core Version:    0.7.0.1
 */