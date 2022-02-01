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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildModuleInfoLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ModeInfoLayoutKt
{
  @NotNull
  public static final View buildModuleInfoLayout(@NotNull Context paramContext)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramContext = (View)localRelativeLayout;
    ViewGroup.LayoutParams localLayoutParams = paramContext.getLayoutParams();
    int i;
    label64:
    label87:
    label116:
    ViewGroup localViewGroup;
    Object localObject;
    label275:
    label299:
    label322:
    label346:
    label495:
    View localView;
    if (localLayoutParams != null)
    {
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label741;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localRelativeLayout;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label760;
      }
      i = localLayoutParams.width;
      j = LayoutAttrsKt.getDp(16);
      if (paramContext.getLayoutParams() == null) {
        break label765;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      localLayoutParams = ((View)localRelativeLayout).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(17);
        paramContext = Unit.INSTANCE;
      }
      localLayoutParams = ((View)localRelativeLayout).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.bottomMargin = LayoutAttrsKt.getDp(12);
        paramContext = Unit.INSTANCE;
      }
      localRelativeLayout.setGravity(16);
      localViewGroup = (ViewGroup)localRelativeLayout;
      localObject = new TextView(localViewGroup.getContext());
      ((TextView)localObject).setTag(localViewGroup);
      paramContext = Unit.INSTANCE;
      ((TextView)localObject).setId(2131371237);
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label784;
      }
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label789;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label809;
      }
      i = localLayoutParams.width;
      if (paramContext.getLayoutParams() == null) {
        break label814;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      localLayoutParams = ((View)localObject).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.leftMargin = LayoutAttrsKt.getDp(14);
        paramContext = Unit.INSTANCE;
      }
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setTextColor(((TextView)localObject).getResources().getColor(2131167110));
      localViewGroup.addView((View)localObject);
      paramContext = Unit.INSTANCE;
      localViewGroup = (ViewGroup)localRelativeLayout;
      localObject = new ImageView(localViewGroup.getContext());
      ((ImageView)localObject).setTag(localViewGroup);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject).setId(2131371236);
      paramContext = (View)localObject;
      j = LayoutAttrsKt.getDp(30);
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label834;
      }
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label839;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label518:
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label858;
      }
      i = localLayoutParams.width;
      label541:
      if (paramContext.getLayoutParams() == null) {
        break label863;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label564:
      ((ImageView)localObject).setImageResource(2130850159);
      localLayoutParams = ((View)localObject).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.rightMargin = LayoutAttrsKt.getDp(7);
        paramContext = Unit.INSTANCE;
      }
      localView = (View)localObject;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label882;
      }
      i = paramContext.width;
      label638:
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label891;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label741:
    label760:
    label891:
    for (int j = paramContext.height;; j = localView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams = localView.getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label904;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label904;
      }
      int m = paramContext.length;
      i = 0;
      j = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label64;
      i = 0;
      break label87;
      label765:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label116;
      i = 0;
      break label275;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label299;
      i = 0;
      break label322;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label346;
      i = 0;
      break label495;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label518;
      i = 0;
      break label541;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label564;
      i = localView.getWidth();
      break label638;
    }
    label784:
    label789:
    label809:
    label814:
    label834:
    label839:
    label858:
    label863:
    label882:
    paramContext = Unit.INSTANCE;
    label904:
    localLayoutParams1.addRule(11, -1);
    paramContext = Unit.INSTANCE;
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject).setVisibility(8);
    localViewGroup.addView((View)localObject);
    paramContext = Unit.INSTANCE;
    return (View)localRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.ModeInfoLayoutKt
 * JD-Core Version:    0.7.0.1
 */