package com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.BubblePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/UiUtils$Companion;", "", "()V", "createContent", "Landroid/widget/TextView;", "ctx", "Landroid/content/Context;", "showProfileSignGuideAsDropDown", "", "view", "Landroid/view/View;", "xoff", "", "yoff", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class UiUtils$Companion
{
  private final TextView createContent(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    int i = ViewUtils.b(5.0F);
    paramContext.setPadding(i, 0, i, 0);
    paramContext.setTextColor(-1);
    paramContext.setGravity(17);
    paramContext.setText(2131708476);
    return paramContext;
  }
  
  public final void showProfileSignGuideAsDropDown(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    Companion localCompanion = (Companion)this;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
    localBubblePopupWindow.setContentView((View)localCompanion.createContent(localContext));
    localBubblePopupWindow.setOnDismissListener(null);
    localBubblePopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    localBubblePopupWindow.setOutsideTouchable(true);
    localBubblePopupWindow.setFocusable(false);
    localBubblePopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.UiUtils.Companion
 * JD-Core Version:    0.7.0.1
 */