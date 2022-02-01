package com.tencent.mobileqq.kandian.biz.xtab.badge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/badge/NumBadgeDisplay;", "Lcom/tencent/mobileqq/kandian/biz/xtab/badge/IRIJXTabBadgeDisplay;", "", "badgeContainer", "Landroid/widget/RelativeLayout;", "(Landroid/widget/RelativeLayout;)V", "calculateTextForDisplay", "", "num", "maxNum", "createLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "createNumBadgeView", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "hide", "", "withAnim", "", "show", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class NumBadgeDisplay
  implements IRIJXTabBadgeDisplay<Long>
{
  private final RelativeLayout a;
  
  public NumBadgeDisplay(@NotNull RelativeLayout paramRelativeLayout)
  {
    this.a = paramRelativeLayout;
  }
  
  private final RelativeLayout.LayoutParams a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  private final TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setGravity(17);
    paramContext.setTextSize(11.0F);
    paramContext.setTextColor(-1);
    paramContext.setSingleLine(true);
    paramContext.setBackgroundResource(2130843337);
    return paramContext;
  }
  
  private final String a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong2);
      localStringBuilder.append('+');
      return localStringBuilder.toString();
    }
    return String.valueOf(paramLong1);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "badgeContainer.context");
    localObject = a((Context)localObject);
    ((TextView)localObject).setText((CharSequence)a(this, paramLong, 0L, 2, null));
    this.a.addView((View)localObject, (ViewGroup.LayoutParams)a());
    ((TextView)localObject).setTranslationX(LayoutAttrsKt.getDp(15));
    ((TextView)localObject).setTranslationY(LayoutAttrsKt.getDp(-8));
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.badge.NumBadgeDisplay
 * JD-Core Version:    0.7.0.1
 */