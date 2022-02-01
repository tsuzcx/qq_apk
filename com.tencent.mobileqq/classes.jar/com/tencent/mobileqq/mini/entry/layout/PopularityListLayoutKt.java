package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildPopularityListLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "qqmini_impl_release"}, k=2, mv={1, 1, 16})
public final class PopularityListLayoutKt
{
  @NotNull
  public static final View buildPopularityListLayout(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject2 = new LinearLayout(paramContext);
    View localView1 = (View)localObject2;
    paramContext = localView1.getLayoutParams();
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
    int j = LayoutAttrsKt.getDp(208);
    if (localView1.getLayoutParams() != null)
    {
      localView1.getLayoutParams().width = i;
      localView1.getLayoutParams().height = j;
    }
    else
    {
      localView1.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    Object localObject1 = localView1.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(20);
    }
    ((LinearLayout)localObject2).setId(2131371177);
    ((LinearLayout)localObject2).setOrientation(1);
    localObject2 = (ViewGroup)localObject2;
    Object localObject3 = new RelativeLayout(((ViewGroup)localObject2).getContext());
    ((RelativeLayout)localObject3).setTag(localObject2);
    View localView2 = (View)localObject3;
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = -1;
      localView2.getLayoutParams().height = i;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    paramContext = localView2.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(25);
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = i;
      localView2.getLayoutParams().height = j;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    ((RelativeLayout)localObject3).setGravity(16);
    localObject1 = localView2.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(10);
    }
    localObject3 = (ViewGroup)localObject3;
    Object localObject4 = new ImageView(((ViewGroup)localObject3).getContext());
    ((ImageView)localObject4).setTag(localObject3);
    ((ImageView)localObject4).setId(2131371185);
    Object localObject5 = (View)localObject4;
    j = LayoutAttrsKt.getDp(20);
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject5).getLayoutParams() != null)
    {
      ((View)localObject5).getLayoutParams().width = j;
      ((View)localObject5).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(20);
    if (((View)localObject5).getLayoutParams() != null)
    {
      ((View)localObject5).getLayoutParams().width = i;
      ((View)localObject5).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject5).getWidth();
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject5).getHeight();
    }
    Object localObject6 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (RelativeLayout.LayoutParams)paramContext;
    int k;
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
          ((RelativeLayout.LayoutParams)localObject6).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject6).addRule(9, -1);
    ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(11);
    }
    ((ImageView)localObject4).setImageResource(2130841048);
    ((ViewGroup)localObject3).addView((View)localObject5);
    paramContext = new TextView(((ViewGroup)localObject3).getContext());
    paramContext.setTag(localObject3);
    paramContext.setId(2131371184);
    localObject4 = (View)paramContext;
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
    paramContext.setTextSize(14.0F);
    paramContext.setText(2131706831);
    if (("#060606" instanceof Integer)) {
      paramContext.setTextColor(paramContext.getResources().getColor(((Number)"#060606").intValue()));
    } else {
      paramContext.setTextColor(Color.parseColor("#060606"));
    }
    localObject1 = ((View)localObject4).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(3);
    }
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject4).getWidth();
    }
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject4).getHeight();
    }
    localObject5 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject4).getLayoutParams();
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
          ((RelativeLayout.LayoutParams)localObject5).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131371185);
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject4 = new ImageView(((ViewGroup)localObject3).getContext());
    ((ImageView)localObject4).setTag(localObject3);
    ((ImageView)localObject4).setId(2131371176);
    localObject5 = (View)localObject4;
    j = LayoutAttrsKt.getDp(20);
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject5).getLayoutParams() != null)
    {
      ((View)localObject5).getLayoutParams().width = j;
      ((View)localObject5).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(20);
    if (((View)localObject5).getLayoutParams() != null)
    {
      ((View)localObject5).getLayoutParams().width = i;
      ((View)localObject5).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((View)localObject5).getWidth();
    }
    paramContext = ((View)localObject5).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((View)localObject5).getHeight();
    }
    localObject6 = new RelativeLayout.LayoutParams(i, j);
    localObject1 = ((View)localObject5).getLayoutParams();
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
          ((RelativeLayout.LayoutParams)localObject6).addRule(i, paramContext[j]);
          j += 1;
          i += 1;
        }
      }
    }
    ((RelativeLayout.LayoutParams)localObject6).addRule(11, -1);
    ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject4).setImageResource(2130848647);
    ((ViewGroup)localObject3).addView((View)localObject5);
    ((ViewGroup)localObject2).addView(localView2);
    paramContext = new LinearLayout(((ViewGroup)localObject2).getContext());
    paramContext.setTag(localObject2);
    localView2 = (View)paramContext;
    localObject1 = localView2.getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
    } else {
      i = 0;
    }
    if (localView2.getLayoutParams() != null)
    {
      localView2.getLayoutParams().width = -1;
      localView2.getLayoutParams().height = i;
    }
    else
    {
      localView2.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
    }
    localObject1 = localView2.getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
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
    paramContext.setOrientation(0);
    localObject3 = (ViewGroup)paramContext;
    localObject5 = new LinearLayout(((ViewGroup)localObject3).getContext());
    ((LinearLayout)localObject5).setTag(localObject3);
    localObject4 = (View)localObject5;
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = 0;
      ((View)localObject4).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((LinearLayout)localObject5).getWidth();
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((LinearLayout)localObject5).getHeight();
    }
    localObject6 = new LinearLayout.LayoutParams(i, j, 1.0F);
    localObject1 = ((LinearLayout)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    if (paramContext != null) {
      i = paramContext.gravity;
    } else {
      i = -1;
    }
    ((LinearLayout.LayoutParams)localObject6).gravity = i;
    ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject1 = ((View)localObject4).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(10);
    }
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ((LinearLayout)localObject5).setOrientation(1);
    localObject5 = (ViewGroup)localObject5;
    paramContext = new ImageView(((ViewGroup)localObject5).getContext());
    paramContext.setTag(localObject5);
    paramContext.setId(2131371178);
    localObject6 = (View)paramContext;
    j = LayoutAttrsKt.getDp(50);
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
    j = LayoutAttrsKt.getDp(50);
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject6).getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(31);
    }
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = new TextView(((ViewGroup)localObject5).getContext());
    ((TextView)localObject6).setTag(localObject5);
    ((TextView)localObject6).setId(2131371180);
    View localView3 = (View)localObject6;
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = -2;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = -2;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    ((TextView)localObject6).setTextSize(14.0F);
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(18);
    }
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    ((TextView)localObject6).setMaxLines(1);
    ((TextView)localObject6).setMaxEms(4);
    ((TextView)localObject6).setEllipsize(TextUtils.TruncateAt.END);
    if (("#484848" instanceof Integer)) {
      ((TextView)localObject6).setTextColor(((TextView)localObject6).getResources().getColor(((Number)"#484848").intValue()));
    } else {
      ((TextView)localObject6).setTextColor(Color.parseColor("#484848"));
    }
    ((ViewGroup)localObject5).addView(localView3);
    localObject6 = new ImageView(((ViewGroup)localObject5).getContext());
    ((ImageView)localObject6).setTag(localObject5);
    ((ImageView)localObject6).setId(2131371179);
    localView3 = (View)localObject6;
    j = LayoutAttrsKt.getDp(54);
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = j;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(28);
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = j;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(2);
    }
    ((ImageView)localObject6).setImageResource(2130841021);
    ((ViewGroup)localObject5).addView(localView3);
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject5 = new LinearLayout(((ViewGroup)localObject3).getContext());
    ((LinearLayout)localObject5).setTag(localObject3);
    localObject4 = (View)localObject5;
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = 0;
      ((View)localObject4).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((LinearLayout)localObject5).getWidth();
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((LinearLayout)localObject5).getHeight();
    }
    localObject6 = new LinearLayout.LayoutParams(i, j, 1.0F);
    localObject1 = ((LinearLayout)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    if (paramContext != null) {
      i = paramContext.gravity;
    } else {
      i = -1;
    }
    ((LinearLayout.LayoutParams)localObject6).gravity = i;
    ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ((LinearLayout)localObject5).setOrientation(1);
    localObject5 = (ViewGroup)localObject5;
    paramContext = new ImageView(((ViewGroup)localObject5).getContext());
    paramContext.setTag(localObject5);
    localObject6 = (View)paramContext;
    localObject1 = ((View)localObject6).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
    } else {
      i = 0;
    }
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = -2;
      ((View)localObject6).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    localObject1 = ((View)localObject6).getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
    } else {
      i = 0;
    }
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = -2;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    paramContext.setImageResource(2130841048);
    localObject1 = ((View)localObject6).getTag();
    if ((localObject1 instanceof FrameLayout))
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      if (localObject1 != null)
      {
        localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((FrameLayout.LayoutParams)localObject1).gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((localObject1 instanceof LinearLayout))
    {
      localObject1 = ((View)localObject6).getLayoutParams();
      if (localObject1 != null)
      {
        localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    paramContext.setRotation(30.0F);
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.bottomMargin = LayoutAttrsKt.getDp(-7);
    }
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(23);
    }
    ((ViewGroup)localObject5).addView((View)localObject6);
    paramContext = new ImageView(((ViewGroup)localObject5).getContext());
    paramContext.setTag(localObject5);
    paramContext.setId(2131371173);
    paramContext = (View)paramContext;
    j = LayoutAttrsKt.getDp(50);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).height;
    } else {
      i = 0;
    }
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null) {
      i = ((ViewGroup.LayoutParams)localObject1).width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(50);
    if (paramContext.getLayoutParams() != null)
    {
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    else
    {
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    localObject1 = paramContext.getTag();
    if ((localObject1 instanceof FrameLayout))
    {
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null)
      {
        localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((FrameLayout.LayoutParams)localObject1).gravity = 1;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((localObject1 instanceof LinearLayout))
    {
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null)
      {
        localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((LinearLayout.LayoutParams)localObject1).gravity = 1;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    ((ViewGroup)localObject5).addView(paramContext);
    localObject6 = new TextView(((ViewGroup)localObject5).getContext());
    ((TextView)localObject6).setTag(localObject5);
    ((TextView)localObject6).setId(2131371175);
    localView3 = (View)localObject6;
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = -2;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = -2;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    ((TextView)localObject6).setTextSize(14.0F);
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(22);
    }
    ((TextView)localObject6).setMaxLines(1);
    ((TextView)localObject6).setMaxEms(4);
    ((TextView)localObject6).setEllipsize(TextUtils.TruncateAt.END);
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    if (("#7c4f01" instanceof Integer)) {
      ((TextView)localObject6).setTextColor(((TextView)localObject6).getResources().getColor(((Number)"#7c4f01").intValue()));
    } else {
      ((TextView)localObject6).setTextColor(Color.parseColor("#7c4f01"));
    }
    ((ViewGroup)localObject5).addView(localView3);
    localObject6 = new ImageView(((ViewGroup)localObject5).getContext());
    ((ImageView)localObject6).setTag(localObject5);
    ((ImageView)localObject6).setId(2131371174);
    localView3 = (View)localObject6;
    j = LayoutAttrsKt.getDp(54);
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = j;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(28);
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = j;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject6).setImageResource(2130841021);
    ((ViewGroup)localObject5).addView(localView3);
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject5 = new LinearLayout(((ViewGroup)localObject3).getContext());
    ((LinearLayout)localObject5).setTag(localObject3);
    localObject4 = (View)localObject5;
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = 0;
      ((View)localObject4).getLayoutParams().height = i;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = ((LinearLayout)localObject5).getWidth();
    }
    paramContext = ((LinearLayout)localObject5).getLayoutParams();
    if (paramContext != null) {
      j = paramContext.height;
    } else {
      j = ((LinearLayout)localObject5).getHeight();
    }
    localObject6 = new LinearLayout.LayoutParams(i, j, 1.0F);
    localObject1 = ((LinearLayout)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
      paramContext = null;
    }
    paramContext = (LinearLayout.LayoutParams)paramContext;
    if (paramContext != null) {
      i = paramContext.gravity;
    } else {
      i = -1;
    }
    ((LinearLayout.LayoutParams)localObject6).gravity = i;
    ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject1 = ((View)localObject4).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(12);
    }
    paramContext = ((View)localObject4).getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (((View)localObject4).getLayoutParams() != null)
    {
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
    }
    else
    {
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
    }
    ((LinearLayout)localObject5).setOrientation(1);
    localObject5 = (ViewGroup)localObject5;
    paramContext = new ImageView(((ViewGroup)localObject5).getContext());
    paramContext.setTag(localObject5);
    paramContext.setId(2131371181);
    localObject6 = (View)paramContext;
    j = LayoutAttrsKt.getDp(50);
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
    j = LayoutAttrsKt.getDp(50);
    if (((View)localObject6).getLayoutParams() != null)
    {
      ((View)localObject6).getLayoutParams().width = i;
      ((View)localObject6).getLayoutParams().height = j;
    }
    else
    {
      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = ((View)localObject6).getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject1 = ((View)localObject6).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(33);
    }
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = new TextView(((ViewGroup)localObject5).getContext());
    ((TextView)localObject6).setTag(localObject5);
    ((TextView)localObject6).setId(2131371183);
    localView3 = (View)localObject6;
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = -2;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = -2;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    ((TextView)localObject6).setTextSize(14.0F);
    if (("#8d4811" instanceof Integer)) {
      ((TextView)localObject6).setTextColor(((TextView)localObject6).getResources().getColor(((Number)"#8d4811").intValue()));
    } else {
      ((TextView)localObject6).setTextColor(Color.parseColor("#8d4811"));
    }
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(18);
    }
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 1;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    ((TextView)localObject6).setMaxLines(1);
    ((TextView)localObject6).setMaxEms(4);
    ((TextView)localObject6).setEllipsize(TextUtils.TruncateAt.END);
    ((ViewGroup)localObject5).addView(localView3);
    localObject6 = new ImageView(((ViewGroup)localObject5).getContext());
    ((ImageView)localObject6).setTag(localObject5);
    ((ImageView)localObject6).setId(2131371182);
    localView3 = (View)localObject6;
    j = LayoutAttrsKt.getDp(54);
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.height;
    } else {
      i = 0;
    }
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = j;
      localView3.getLayoutParams().height = i;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
    }
    paramContext = localView3.getLayoutParams();
    if (paramContext != null) {
      i = paramContext.width;
    } else {
      i = 0;
    }
    j = LayoutAttrsKt.getDp(28);
    if (localView3.getLayoutParams() != null)
    {
      localView3.getLayoutParams().width = i;
      localView3.getLayoutParams().height = j;
    }
    else
    {
      localView3.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    paramContext = localView3.getTag();
    if ((paramContext instanceof FrameLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 81;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    else if ((paramContext instanceof LinearLayout))
    {
      paramContext = localView3.getLayoutParams();
      if (paramContext != null)
      {
        paramContext = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramContext);
        paramContext.gravity = 81;
        localView3.setLayoutParams((ViewGroup.LayoutParams)paramContext);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
    }
    localObject1 = localView3.getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(2);
    }
    ((ImageView)localObject6).setImageResource(2130841021);
    ((ViewGroup)localObject5).addView(localView3);
    ((ViewGroup)localObject3).addView((View)localObject4);
    ((ViewGroup)localObject2).addView(localView2);
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.PopularityListLayoutKt
 * JD-Core Version:    0.7.0.1
 */