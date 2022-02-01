package com.tencent.mobileqq.ecshop.view.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/MoreCardController;", "Lcom/tencent/mobileqq/ecshop/view/controller/CardController;", "parent", "Landroid/view/ViewGroup;", "adStyle", "", "(Landroid/view/ViewGroup;Ljava/lang/String;)V", "adCardMore", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "adCardMoreText", "Landroid/widget/TextView;", "itemView", "Landroid/view/View;", "getItemView", "getLayoutId", "", "type", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class MoreCardController
  implements CardController
{
  private final View jdField_a_of_type_AndroidViewView;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public MoreCardController(@NotNull ViewGroup paramViewGroup, @NotNull String paramString)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(CardController.DefaultImpls.a(this, null, 1, null), paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(pare…ayoutId(), parent, false)");
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362076));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362077));
    paramViewGroup = QQShopPicUtil.a;
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "adCardMore");
    paramViewGroup.a((View)localRelativeLayout, 30.0F);
    if (Intrinsics.areEqual("small", paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.5F);
    }
  }
  
  public int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return 2131561476;
  }
  
  @NotNull
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.MoreCardController
 * JD-Core Version:    0.7.0.1
 */