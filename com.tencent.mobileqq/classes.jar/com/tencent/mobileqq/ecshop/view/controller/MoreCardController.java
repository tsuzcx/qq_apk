package com.tencent.mobileqq.ecshop.view.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.ecshop.utils.QQShopPicUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/view/controller/MoreCardController;", "Lcom/tencent/mobileqq/ecshop/view/controller/CardController;", "parent", "Landroid/view/ViewGroup;", "adStyle", "", "itemWidth", "", "(Landroid/view/ViewGroup;Ljava/lang/String;I)V", "adCardMore", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "adCardMoreText", "Landroid/widget/TextView;", "itemView", "Landroid/view/View;", "getItemView", "getLayoutId", "type", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class MoreCardController
  implements CardController
{
  private final View a;
  private final RelativeLayout b;
  private final TextView c;
  
  public MoreCardController(@NotNull ViewGroup paramViewGroup, @NotNull String paramString, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(CardController.DefaultImpls.a(this, null, 1, null), paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "LayoutInflater.from(pare…ayoutId(), parent, false)");
    this.a = paramViewGroup;
    this.b = ((RelativeLayout)this.a.findViewById(2131427655));
    this.c = ((TextView)this.a.findViewById(2131427656));
    paramViewGroup = this.a.getLayoutParams();
    if (paramViewGroup != null) {
      paramViewGroup.width = paramInt;
    }
    paramViewGroup = this.b;
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "adCardMore");
    QQShopPicUtil.a((View)paramViewGroup, 30.0F);
    if (Intrinsics.areEqual("small", paramString)) {
      this.c.setTextSize(1, ViewUtils.dip2px(14.0F));
    }
  }
  
  public int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return 2131627834;
  }
  
  @NotNull
  public View a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.MoreCardController
 * JD-Core Version:    0.7.0.1
 */