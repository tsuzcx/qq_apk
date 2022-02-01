package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildDesktopEntryLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "qqmini_impl_release"}, k=2, mv={1, 1, 16})
public final class DesktopLayoutKt
{
  @NotNull
  public static final View buildDesktopEntryLayout(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new FrameLayout(paramContext);
    View localView1 = (View)paramContext;
    Object localObject1 = localView1.getLayoutParams();
    int i;
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
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
    localObject1 = localView1.getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
    } else {
      i = 0;
    }
    if (localView1.getLayoutParams() != null)
    {
      localView1.getLayoutParams().width = i;
      localView1.getLayoutParams().height = -1;
    }
    else
    {
      localView1.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ViewGroup localViewGroup = (ViewGroup)paramContext;
    paramContext = new ImageView(localViewGroup.getContext());
    paramContext.setTag(localViewGroup);
    paramContext.setId(2131438441);
    localObject1 = (View)paramContext;
    Object localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).height;
    } else {
      i = 0;
    }
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = -1;
      ((View)localObject1).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject2 = ((View)localObject1).getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).width;
    } else {
      i = 0;
    }
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = i;
      ((View)localObject1).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    localViewGroup.addView((View)localObject1);
    Object localObject3 = new LinearLayout(localViewGroup.getContext());
    ((LinearLayout)localObject3).setTag(localViewGroup);
    ((LinearLayout)localObject3).setId(2131438482);
    localObject2 = (View)localObject3;
    paramContext = ((View)localObject2).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject2).getLayoutParams() != null)
    {
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    paramContext = ((View)localObject2).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (((View)localObject2).getLayoutParams() != null)
    {
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    localObject1 = ((View)localObject2).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.bottomMargin = LayoutAttrsKt.getDp(65);
    }
    ((LinearLayout)localObject3).setOrientation(1);
    localObject3 = (ViewGroup)localObject3;
    paramContext = new RelativeLayout(((ViewGroup)localObject3).getContext());
    paramContext.setTag(localObject3);
    paramContext.setId(2131438171);
    Object localObject4 = (View)paramContext;
    localObject1 = ((View)localObject4).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = -1;
      ((View)localObject4).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject1 = ((View)localObject4).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
    } else {
      i = 0;
    }
    int j = LayoutAttrsKt.getDp(45);
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    Object localObject5 = (ViewGroup)paramContext;
    ((ViewGroup)localObject5).setClipChildren(false);
    Object localObject6 = new TextView(((ViewGroup)localObject5).getContext());
    ((TextView)localObject6).setTag(localObject5);
    ((TextView)localObject6).setId(2131438435);
    Object localObject7 = (View)localObject6;
    paramContext = ((View)localObject7).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject7).getLayoutParams() != null)
    {
      ((View)localObject7).getLayoutParams().width = -2;
      ((View)localObject7).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    paramContext = ((View)localObject7).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (((View)localObject7).getLayoutParams() != null)
    {
      ((View)localObject7).getLayoutParams().width = i;
      ((View)localObject7).getLayoutParams().height = -2;
    }
    else
    {
      ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    paramContext = ((View)localObject7).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject7).getWidth();
    }
    paramContext = ((View)localObject7).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject7).getHeight();
    }
    Object localObject8 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject7).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        j = 0;
        i = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject8).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject8).addRule(13, -1);
    ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    if (("QQ小程序" instanceof Integer)) {
      ((TextView)localObject6).setText(((Number)"QQ小程序").intValue());
    } else {
      ((TextView)localObject6).setText((CharSequence)"QQ小程序");
    }
    ((TextView)localObject6).setTextColor(((TextView)localObject6).getResources().getColor(2131168001));
    ((TextView)localObject6).setTextSize(17.0F);
    ((ViewGroup)localObject5).addView((View)localObject7);
    localObject8 = new RelativeLayout(((ViewGroup)localObject5).getContext());
    ((RelativeLayout)localObject8).setTag(localObject5);
    ((RelativeLayout)localObject8).setId(2131438388);
    localObject6 = (View)localObject8;
    j = LayoutAttrsKt.getDp(80);
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = j;
      ((View)localObject6).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(30);
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject6).getWidth();
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject6).getHeight();
    }
    localObject7 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        i = 0;
        j = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject7).addRule(11, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject6).getWidth();
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject6).getHeight();
    }
    localObject7 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        j = 0;
        i = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject7).addRule(13, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    paramContext = Integer.valueOf(2130852390);
    if ((paramContext instanceof String)) {
      ((View)localObject6).setBackgroundColor(Color.parseColor((String)paramContext));
    } else {
      ((View)localObject6).setBackgroundResource(((Number)paramContext).intValue());
    }
    localObject7 = (ViewGroup)localObject8;
    ((ViewGroup)localObject7).setClipChildren(false);
    ((RelativeLayout)localObject8).setGravity(16);
    Object localObject9 = new RelativeLayout(((ViewGroup)localObject7).getContext());
    ((RelativeLayout)localObject9).setTag(localObject7);
    ((RelativeLayout)localObject9).setId(2131438423);
    localObject8 = (View)localObject9;
    j = LayoutAttrsKt.getDp(22);
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject8).getLayoutParams() != null)
    {
      ((View)localObject8).getLayoutParams().width = j;
      ((View)localObject8).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(22);
    if (((View)localObject8).getLayoutParams() != null)
    {
      ((View)localObject8).getLayoutParams().width = i;
      ((View)localObject8).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject8).getWidth();
    }
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject8).getHeight();
    }
    Object localObject10 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject8).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        i = 0;
        j = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject10).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject10).addRule(9, -1);
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject8).getWidth();
    }
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject8).getHeight();
    }
    localObject10 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject8).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        j = 0;
        i = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject10).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject10).addRule(13, -1);
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    localObject1 = ((View)localObject8).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(10);
    }
    localObject9 = (ViewGroup)localObject9;
    ((ViewGroup)localObject9).setClipChildren(false);
    paramContext = new ImageView(((ViewGroup)localObject9).getContext());
    paramContext.setTag(localObject9);
    paramContext.setId(2131438422);
    localObject1 = (View)paramContext;
    j = LayoutAttrsKt.getDp(22);
    localObject10 = ((View)localObject1).getLayoutParams();
    if (localObject10 != null) {
      i = ((ViewGroup.LayoutParams)localObject10).height;
    } else {
      i = 0;
    }
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = j;
      ((View)localObject1).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    localObject10 = ((View)localObject1).getLayoutParams();
    if (localObject10 != null) {
      i = ((ViewGroup.LayoutParams)localObject10).width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(22);
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = i;
      ((View)localObject1).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext.setImageResource(2130841815);
    paramContext.setVisibility(0);
    ((ViewGroup)localObject9).addView((View)localObject1);
    localObject10 = new TextView(((ViewGroup)localObject9).getContext());
    ((TextView)localObject10).setTag(localObject9);
    ((TextView)localObject10).setId(2131438424);
    View localView2 = (View)localObject10;
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
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localObject1 = localView2.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        j = paramContext.length;
        i = 0;
        k = 0;
        while (k < j)
        {
          localLayoutParams.addRule(i, paramContext[k]);
          k += 1;
          i += 1;
        }
      }
    }
    localLayoutParams.addRule(9, -1);
    localView2.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
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
    localLayoutParams = new RelativeLayout.LayoutParams(i, j);
    localObject1 = localView2.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        j = paramContext.length;
        k = 0;
        i = 0;
        while (k < j)
        {
          localLayoutParams.addRule(i, paramContext[k]);
          k += 1;
          i += 1;
        }
      }
    }
    localLayoutParams.addRule(11, -1);
    localView2.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localObject1 = localView2.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(-10);
    }
    localObject1 = localView2.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(-8);
    }
    ((TextView)localObject10).setVisibility(0);
    ((ViewGroup)localObject9).addView(localView2);
    ((ViewGroup)localObject7).addView((View)localObject8);
    localObject8 = new ImageView(((ViewGroup)localObject7).getContext());
    ((ImageView)localObject8).setTag(localObject7);
    ((ImageView)localObject8).setId(2131438419);
    localObject9 = (View)localObject8;
    j = LayoutAttrsKt.getDp(22);
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject9).getLayoutParams() != null)
    {
      ((View)localObject9).getLayoutParams().width = j;
      ((View)localObject9).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject9).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(22);
    if (((View)localObject9).getLayoutParams() != null)
    {
      ((View)localObject9).getLayoutParams().width = i;
      ((View)localObject9).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject9).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject9).getWidth();
    }
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject9).getHeight();
    }
    localObject10 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject9).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        j = 0;
        i = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject10).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject10).addRule(11, -1);
    ((View)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject9).getWidth();
    }
    paramContext = ((View)localObject9).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject9).getHeight();
    }
    localObject10 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject9).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        k = paramContext.length;
        j = 0;
        i = 0;
        while (j < k)
        {
          ((RelativeLayout.LayoutParams)localObject10).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject10).addRule(13, -1);
    ((View)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    localObject1 = ((View)localObject9).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject8).setImageResource(2130841797);
    ((ViewGroup)localObject7).addView((View)localObject9);
    ((ViewGroup)localObject5).addView((View)localObject6);
    ((ViewGroup)localObject3).addView((View)localObject4);
    paramContext = new DragRecyclerView(((ViewGroup)localObject3).getContext());
    paramContext.setTag(localObject3);
    paramContext.setId(2131438172);
    localObject1 = (View)paramContext;
    localObject4 = ((View)localObject1).getLayoutParams();
    if (localObject4 != null) {
      i = ((ViewGroup.LayoutParams)localObject4).height;
    } else {
      i = 0;
    }
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = -1;
      ((View)localObject1).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject4 = ((View)localObject1).getLayoutParams();
    if (localObject4 != null) {
      i = ((ViewGroup.LayoutParams)localObject4).width;
    } else {
      i = 0;
    }
    if (((View)localObject1).getLayoutParams() != null)
    {
      ((View)localObject1).getLayoutParams().width = i;
      ((View)localObject1).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    localObject4 = (ViewGroup)paramContext;
    int k = 0;
    ((ViewGroup)localObject4).setClipChildren(false);
    ((ViewGroup)localObject4).setClipToPadding(false);
    paramContext.setOverScrollMode(2);
    ((View)localObject1).setPadding(LayoutAttrsKt.getDp(20), ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
    ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingTop(), LayoutAttrsKt.getDp(20), ((View)localObject1).getPaddingBottom());
    ((ViewGroup)localObject3).addView((View)localObject1);
    localViewGroup.addView((View)localObject2);
    localObject1 = new LinearLayout(localViewGroup.getContext());
    ((LinearLayout)localObject1).setTag(localViewGroup);
    ((LinearLayout)localObject1).setId(2131438479);
    paramContext = (View)localObject1;
    localObject2 = paramContext.getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).height;
    } else {
      i = 0;
    }
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject2 = paramContext.getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(65);
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    localObject2 = paramContext.getTag();
    if ((localObject2 instanceof FrameLayout))
    {
      localObject2 = paramContext.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 80;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((localObject2 instanceof LinearLayout))
    {
      localObject2 = paramContext.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject2 = Integer.valueOf(2130838959);
    if ((localObject2 instanceof String)) {
      paramContext.setBackgroundColor(Color.parseColor((String)localObject2));
    } else {
      paramContext.setBackgroundResource(((Number)localObject2).intValue());
    }
    ((LinearLayout)localObject1).setGravity(17);
    localObject1 = (ViewGroup)localObject1;
    localObject2 = new ImageView(((ViewGroup)localObject1).getContext());
    ((ImageView)localObject2).setTag(localObject1);
    ((ImageView)localObject2).setId(2131438480);
    localObject3 = (View)localObject2;
    localObject4 = ((View)localObject3).getLayoutParams();
    if (localObject4 != null) {
      i = ((ViewGroup.LayoutParams)localObject4).height;
    } else {
      i = 0;
    }
    if (((View)localObject3).getLayoutParams() != null)
    {
      ((View)localObject3).getLayoutParams().width = -2;
      ((View)localObject3).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    localObject4 = ((View)localObject3).getLayoutParams();
    if (localObject4 != null) {
      i = ((ViewGroup.LayoutParams)localObject4).width;
    } else {
      i = 0;
    }
    if (((View)localObject3).getLayoutParams() != null)
    {
      ((View)localObject3).getLayoutParams().width = i;
      ((View)localObject3).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ((ImageView)localObject2).setImageResource(2130841798);
    ((ViewGroup)localObject1).addView((View)localObject3);
    localViewGroup.addView(paramContext);
    localObject1 = new LinearLayout(localViewGroup.getContext());
    ((LinearLayout)localObject1).setTag(localViewGroup);
    ((LinearLayout)localObject1).setId(2131431719);
    paramContext = (View)localObject1;
    localObject2 = paramContext.getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).height;
    } else {
      i = 0;
    }
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject2 = paramContext.getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(65);
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    localObject2 = paramContext.getTag();
    if ((localObject2 instanceof FrameLayout))
    {
      localObject2 = paramContext.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 80;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((localObject2 instanceof LinearLayout))
    {
      localObject2 = paramContext.getLayoutParams();
      if (localObject2 != null)
      {
        localObject2 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject2 = Integer.valueOf(2130841800);
    if ((localObject2 instanceof String)) {
      paramContext.setBackgroundColor(Color.parseColor((String)localObject2));
    } else {
      paramContext.setBackgroundResource(((Number)localObject2).intValue());
    }
    ((LinearLayout)localObject1).setGravity(17);
    ((LinearLayout)localObject1).setVisibility(8);
    localObject2 = (ViewGroup)localObject1;
    localObject3 = new TextView(((ViewGroup)localObject2).getContext());
    ((TextView)localObject3).setTag(localObject2);
    ((TextView)localObject3).setId(2131431712);
    localObject4 = (View)localObject3;
    localObject1 = ((View)localObject4).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = -2;
      ((View)localObject4).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    localObject1 = ((View)localObject4).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -2;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    ((TextView)localObject3).setGravity(17);
    ((TextView)localObject3).setText(2131909575);
    localObject5 = ((TextView)localObject3).getContext().getDrawable(2130841802);
    localObject1 = null;
    ((TextView)localObject3).setCompoundDrawables((Drawable)localObject5, null, null, null);
    ((TextView)localObject3).setCompoundDrawablePadding(LayoutAttrsKt.getDp(12));
    if (("#FFFFFF" instanceof Integer)) {
      ((TextView)localObject3).setTextColor(((TextView)localObject3).getResources().getColor(((Number)"#FFFFFF").intValue()));
    } else {
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFFFF"));
    }
    ((ViewGroup)localObject2).addView((View)localObject4);
    localViewGroup.addView(paramContext);
    paramContext = new RelativeLayout(localViewGroup.getContext());
    paramContext.setTag(localViewGroup);
    paramContext.setId(2131438437);
    localObject3 = (View)paramContext;
    j = LayoutAttrsKt.getDp(66);
    localObject2 = ((View)localObject3).getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).height;
    } else {
      i = 0;
    }
    if (((View)localObject3).getLayoutParams() != null)
    {
      ((View)localObject3).getLayoutParams().width = j;
      ((View)localObject3).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    localObject2 = ((View)localObject3).getLayoutParams();
    if (localObject2 != null) {
      i = ((ViewGroup.LayoutParams)localObject2).width;
    } else {
      i = 0;
    }
    if (((View)localObject3).getLayoutParams() != null)
    {
      ((View)localObject3).getLayoutParams().width = i;
      ((View)localObject3).getLayoutParams().height = -2;
    }
    else
    {
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    paramContext.setVisibility(4);
    localObject4 = (ViewGroup)paramContext;
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    ((ImageView)localObject5).setId(2131438436);
    localObject6 = (View)localObject5;
    j = LayoutAttrsKt.getDp(48);
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = j;
      ((View)localObject6).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(48);
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    localObject2 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(8);
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject6).getWidth();
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject6).getHeight();
    }
    localObject7 = new RelativeLayout.LayoutParams(i, j);
    localObject2 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject2;
    if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    int m;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        m = paramContext.length;
        j = 0;
        i = 0;
        while (j < m)
        {
          ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject7).addRule(14, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    ((ImageView)localObject5).setImageResource(2130850319);
    ((ViewGroup)localObject4).addView((View)localObject6);
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    ((ImageView)localObject5).setId(2131438438);
    localObject6 = (View)localObject5;
    j = LayoutAttrsKt.getDp(15);
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = j;
      ((View)localObject6).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(15);
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject6).getWidth();
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject6).getHeight();
    }
    localObject7 = new RelativeLayout.LayoutParams(i, j);
    localObject2 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject2;
    if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        m = paramContext.length;
        j = 0;
        i = 0;
        while (j < m)
        {
          ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject7).addRule(9, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject6).getWidth();
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject6).getHeight();
    }
    localObject7 = new RelativeLayout.LayoutParams(i, j);
    localObject2 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject2;
    if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext = paramContext.getRules();
      if (paramContext != null)
      {
        m = paramContext.length;
        i = 0;
        j = k;
        while (j < m)
        {
          ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject7).addRule(11, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    localObject2 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(4);
    }
    paramContext = ((View)localObject6).getLayoutParams();
    if (!(paramContext instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = (Context)localObject1;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(4);
    }
    ((ImageView)localObject5).setImageResource(2130841805);
    ((ViewGroup)localObject4).addView((View)localObject6);
    localViewGroup.addView((View)localObject3);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.DesktopLayoutKt
 * JD-Core Version:    0.7.0.1
 */