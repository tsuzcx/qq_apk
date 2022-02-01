package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildModuleInfoLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "qqmini_impl_release"}, k=2, mv={1, 1, 16})
public final class ModeInfoLayoutKt
{
  @NotNull
  public static final View buildModuleInfoLayout(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject1 = new RelativeLayout(paramContext);
    View localView1 = (View)localObject1;
    paramContext = localView1.getLayoutParams();
    int k = 0;
    int i;
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView1.getLayoutParams() != null)
    {
      localView1.getLayoutParams().width = -1;
      localView1.getLayoutParams().height = i;
    }
    else
    {
      localView1.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    paramContext = localView1.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    int j = LayoutAttrsKt.getDp(16);
    if (localView1.getLayoutParams() != null)
    {
      localView1.getLayoutParams().width = i;
      localView1.getLayoutParams().height = j;
    }
    else
    {
      localView1.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
    paramContext = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(17);
    }
    localLayoutParams = localView1.getLayoutParams();
    paramContext = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.bottomMargin = LayoutAttrsKt.getDp(12);
    }
    ((RelativeLayout)localObject1).setGravity(16);
    localObject1 = (ViewGroup)localObject1;
    Object localObject2 = new TextView(((ViewGroup)localObject1).getContext());
    ((TextView)localObject2).setTag(localObject1);
    ((TextView)localObject2).setId(2131371136);
    View localView2 = (View)localObject2;
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = -2;
      localView2.getLayoutParams().height = i;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = i;
      localView2.getLayoutParams().height = -2;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    localLayoutParams = localView2.getLayoutParams();
    paramContext = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(14);
    }
    ((TextView)localObject2).setTextSize(12.0F);
    ((TextView)localObject2).setTextColor(((TextView)localObject2).getResources().getColor(2131167063));
    ((ViewGroup)localObject1).addView(localView2);
    localObject2 = new ImageView(((ViewGroup)localObject1).getContext());
    ((ImageView)localObject2).setTag(localObject1);
    ((ImageView)localObject2).setId(2131371135);
    localView2 = (View)localObject2;
    j = LayoutAttrsKt.getDp(30);
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = j;
      localView2.getLayoutParams().height = i;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = i;
      localView2.getLayoutParams().height = -1;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ((ImageView)localObject2).setImageResource(2130850483);
    localLayoutParams = localView2.getLayoutParams();
    paramContext = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(7);
    }
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = localView2.getWidth();
    }
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = localView2.getHeight();
    }
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
    localLayoutParams = localView2.getLayoutParams();
    paramContext = localLayoutParams;
    if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        int m = paramContext.length;
        i = 0;
        j = k;
        while (j < m)
        {
          localLayoutParams1.addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    localLayoutParams1.addRule(11, -1);
    localView2.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject2).setVisibility(8);
    ((ViewGroup)localObject1).addView(localView2);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.ModeInfoLayoutKt
 * JD-Core Version:    0.7.0.1
 */