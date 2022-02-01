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
    label263:
    label287:
    label310:
    label334:
    label471:
    label494:
    View localView;
    if (localLayoutParams != null)
    {
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label713;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localRelativeLayout;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label732;
      }
      i = localLayoutParams.width;
      j = LayoutAttrsKt.getDp(16);
      if (paramContext.getLayoutParams() == null) {
        break label737;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      localLayoutParams = ((View)localRelativeLayout).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(17);
      }
      localLayoutParams = ((View)localRelativeLayout).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.bottomMargin = LayoutAttrsKt.getDp(12);
      }
      localRelativeLayout.setGravity(16);
      localViewGroup = (ViewGroup)localRelativeLayout;
      localObject = new TextView(localViewGroup.getContext());
      ((TextView)localObject).setTag(localViewGroup);
      ((TextView)localObject).setId(2131371516);
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label756;
      }
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label761;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label781;
      }
      i = localLayoutParams.width;
      if (paramContext.getLayoutParams() == null) {
        break label786;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      localLayoutParams = ((View)localObject).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.leftMargin = LayoutAttrsKt.getDp(14);
      }
      ((TextView)localObject).setTextSize(12.0F);
      ((TextView)localObject).setTextColor(((TextView)localObject).getResources().getColor(2131167040));
      localViewGroup.addView((View)localObject);
      localViewGroup = (ViewGroup)localRelativeLayout;
      localObject = new ImageView(localViewGroup.getContext());
      ((ImageView)localObject).setTag(localViewGroup);
      ((ImageView)localObject).setId(2131371515);
      paramContext = (View)localObject;
      j = LayoutAttrsKt.getDp(30);
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label806;
      }
      i = localLayoutParams.height;
      if (paramContext.getLayoutParams() == null) {
        break label811;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localObject;
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams == null) {
        break label830;
      }
      i = localLayoutParams.width;
      label517:
      if (paramContext.getLayoutParams() == null) {
        break label835;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label540:
      ((ImageView)localObject).setImageResource(2130850557);
      localLayoutParams = ((View)localObject).getLayoutParams();
      paramContext = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.rightMargin = LayoutAttrsKt.getDp(7);
      }
      localView = (View)localObject;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label854;
      }
      i = paramContext.width;
      label610:
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label863;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label713:
    label732:
    label863:
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
        break label872;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label872;
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
      label737:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label116;
      label756:
      i = 0;
      break label263;
      label761:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label287;
      i = 0;
      break label310;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label334;
      i = 0;
      break label471;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label494;
      i = 0;
      break label517;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label540;
      i = localView.getWidth();
      break label610;
    }
    label781:
    label786:
    label806:
    label811:
    label830:
    label835:
    label854:
    label872:
    localLayoutParams1.addRule(11, -1);
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject).setVisibility(8);
    localViewGroup.addView((View)localObject);
    return (View)localRelativeLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.ModeInfoLayoutKt
 * JD-Core Version:    0.7.0.1
 */