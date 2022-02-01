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
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    paramContext = (View)localLinearLayout;
    Object localObject1 = paramContext.getLayoutParams();
    int i;
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label605;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label62:
      paramContext = (View)localLinearLayout;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label624;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label85:
      j = LayoutAttrsKt.getDp(208);
      if (paramContext.getLayoutParams() == null) {
        break label629;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label115:
      localObject1 = ((View)localLinearLayout).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(20);
      }
      localLinearLayout.setId(2131371557);
      localLinearLayout.setOrientation(1);
      localViewGroup1 = (ViewGroup)localLinearLayout;
      localObject2 = new RelativeLayout(localViewGroup1.getContext());
      ((RelativeLayout)localObject2).setTag(localViewGroup1);
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label648;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label220:
      if (paramContext.getLayoutParams() == null) {
        break label653;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label243:
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label672;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label266:
      j = LayoutAttrsKt.getDp(25);
      if (paramContext.getLayoutParams() == null) {
        break label677;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label295:
      ((RelativeLayout)localObject2).setGravity(16);
      localObject1 = ((View)localObject2).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(10);
      }
      localViewGroup2 = (ViewGroup)localObject2;
      localObject3 = new ImageView(localViewGroup2.getContext());
      ((ImageView)localObject3).setTag(localViewGroup2);
      ((ImageView)localObject3).setId(2131371565);
      paramContext = (View)localObject3;
      j = LayoutAttrsKt.getDp(20);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label696;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label407:
      if (paramContext.getLayoutParams() == null) {
        break label701;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label430:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label720;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label453:
      j = LayoutAttrsKt.getDp(20);
      if (paramContext.getLayoutParams() == null) {
        break label725;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label482:
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label744;
      }
      i = paramContext.width;
      label504:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label753;
      }
    }
    int k;
    label605:
    label624:
    label753:
    for (int j = paramContext.height;; j = ((View)localObject4).getHeight())
    {
      localObject5 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject4).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label762;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label762;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject5).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label62;
      i = 0;
      break label85;
      label629:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label115;
      i = 0;
      break label220;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label243;
      i = 0;
      break label266;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label295;
      i = 0;
      break label407;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label430;
      i = 0;
      break label453;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label482;
      i = ((View)localObject4).getWidth();
      break label504;
    }
    label648:
    label653:
    label672:
    label677:
    label696:
    label701:
    label720:
    label725:
    label744:
    label762:
    ((RelativeLayout.LayoutParams)localObject5).addRule(9, -1);
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localObject1 = ((View)localObject3).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(11);
    }
    ((ImageView)localObject3).setImageResource(2130841172);
    localViewGroup2.addView((View)localObject3);
    ViewGroup localViewGroup2 = (ViewGroup)localObject2;
    Object localObject3 = new TextView(localViewGroup2.getContext());
    ((TextView)localObject3).setTag(localViewGroup2);
    ((TextView)localObject3).setId(2131371564);
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label1173;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label920:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1193;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label943:
      if (paramContext.getLayoutParams() == null) {
        break label1198;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label967:
      ((TextView)localObject3).setTextSize(14.0F);
      ((TextView)localObject3).setText(2131706809);
      if (!("#060606" instanceof Integer)) {
        break label1218;
      }
      ((TextView)localObject3).setTextColor(((TextView)localObject3).getResources().getColor(((Number)"#060606").intValue()));
      label1010:
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.leftMargin = LayoutAttrsKt.getDp(3);
      }
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1231;
      }
      i = paramContext.width;
      label1072:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1240;
      }
    }
    label1173:
    label1193:
    label1198:
    label1218:
    label1231:
    label1240:
    for (j = paramContext.height;; j = ((View)localObject4).getHeight())
    {
      localObject5 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject4).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label1249;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1249;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject5).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label920;
      i = 0;
      break label943;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label967;
      ((TextView)localObject3).setTextColor(Color.parseColor("#060606"));
      break label1010;
      i = ((View)localObject4).getWidth();
      break label1072;
    }
    label1249:
    ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131371565);
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localViewGroup2.addView((View)localObject3);
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new ImageView(localViewGroup2.getContext());
    ((ImageView)localObject3).setTag(localViewGroup2);
    ((ImageView)localObject3).setId(2131371556);
    paramContext = (View)localObject3;
    j = LayoutAttrsKt.getDp(20);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label1539;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1364:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1558;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1387:
      j = LayoutAttrsKt.getDp(20);
      if (paramContext.getLayoutParams() == null) {
        break label1563;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1416:
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1582;
      }
      i = paramContext.width;
      label1438:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1591;
      }
    }
    label1539:
    label1558:
    label1563:
    label1582:
    label1591:
    for (j = paramContext.height;; j = ((View)localObject4).getHeight())
    {
      localObject5 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject4).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label1600;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1600;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject5).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label1364;
      i = 0;
      break label1387;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1416;
      i = ((View)localObject4).getWidth();
      break label1438;
    }
    label1600:
    ((RelativeLayout.LayoutParams)localObject5).addRule(11, -1);
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localObject1 = ((View)localObject3).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject3).setImageResource(2130848767);
    localViewGroup2.addView((View)localObject3);
    localViewGroup1.addView((View)localObject2);
    ViewGroup localViewGroup1 = (ViewGroup)localLinearLayout;
    Object localObject2 = new LinearLayout(localViewGroup1.getContext());
    ((LinearLayout)localObject2).setTag(localViewGroup1);
    paramContext = (View)localObject2;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label2257;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label1760:
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2276;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1783:
      if (paramContext.getLayoutParams() == null) {
        break label2281;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label1807:
      ((LinearLayout)localObject2).setOrientation(0);
      localViewGroup2 = (ViewGroup)localObject2;
      localObject3 = new LinearLayout(localViewGroup2.getContext());
      ((LinearLayout)localObject3).setTag(localViewGroup2);
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2301;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1864:
      if (paramContext.getLayoutParams() == null) {
        break label2306;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label1887:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label2325;
      }
      i = paramContext.width;
      label1902:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label2334;
      }
      j = paramContext.height;
      label1917:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2343;
      }
      i = paramContext.gravity;
      label1963:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.leftMargin = LayoutAttrsKt.getDp(10);
      }
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2348;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2043:
      if (paramContext.getLayoutParams() == null) {
        break label2353;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label2066:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      ((ImageView)localObject5).setId(2131371558);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(50);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2372;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label2136:
      if (paramContext.getLayoutParams() == null) {
        break label2377;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label2159:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2396;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2182:
      j = LayoutAttrsKt.getDp(50);
      if (paramContext.getLayoutParams() == null) {
        break label2401;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label2718;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label2420;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      i = 0;
      break;
      label2257:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label1760;
      label2276:
      i = 0;
      break label1783;
      label2281:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label1807;
      label2301:
      i = 0;
      break label1864;
      label2306:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label1887;
      label2325:
      i = ((LinearLayout)localObject3).getWidth();
      break label1902;
      label2334:
      j = ((LinearLayout)localObject3).getHeight();
      break label1917;
      label2343:
      i = -1;
      break label1963;
      label2348:
      i = 0;
      break label2043;
      label2353:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label2066;
      label2372:
      i = 0;
      break label2136;
      label2377:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label2159;
      label2396:
      i = 0;
      break label2182;
      label2401:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label2420:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(31);
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    Object localObject4 = (ViewGroup)localObject3;
    Object localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    ((TextView)localObject5).setId(2131371560);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label2558:
      if (paramContext.getLayoutParams() == null) {
        break label2784;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label2582:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2804;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2605:
      if (paramContext.getLayoutParams() == null) {
        break label2809;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
    }
    for (;;)
    {
      ((TextView)localObject5).setTextSize(14.0F);
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(18);
      }
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label3097;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label2829;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label2718:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label2558;
      label2784:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label2582;
      label2804:
      i = 0;
      break label2605;
      label2809:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label2829:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((TextView)localObject5).setMaxLines(1);
    ((TextView)localObject5).setMaxEms(4);
    ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
    if (("#484848" instanceof Integer))
    {
      ((TextView)localObject5).setTextColor(((TextView)localObject5).getResources().getColor(((Number)"#484848").intValue()));
      label2907:
      ((ViewGroup)localObject4).addView((View)localObject5);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      ((ImageView)localObject5).setId(2131371559);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(54);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3171;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label2981:
      if (paramContext.getLayoutParams() == null) {
        break label3176;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label3004:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3195;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3027:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label3200;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label3703;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label3219;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label3097:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      ((TextView)localObject5).setTextColor(Color.parseColor("#484848"));
      break label2907;
      label3171:
      i = 0;
      break label2981;
      label3176:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label3004;
      label3195:
      i = 0;
      break label3027;
      label3200:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label3219:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(2);
    }
    ((ImageView)localObject5).setImageResource(2130841146);
    ((ViewGroup)localObject4).addView((View)localObject5);
    localViewGroup2.addView((View)localObject3);
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new LinearLayout(localViewGroup2.getContext());
    ((LinearLayout)localObject3).setTag(localViewGroup2);
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label3366:
      if (paramContext.getLayoutParams() == null) {
        break label3769;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label3389:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label3788;
      }
      i = paramContext.width;
      label3404:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label3797;
      }
      j = paramContext.height;
      label3419:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label3806;
      }
      i = paramContext.gravity;
      label3465:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3811;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3504:
      if (paramContext.getLayoutParams() == null) {
        break label3816;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label3527:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3835;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label3584:
      if (paramContext.getLayoutParams() == null) {
        break label3840;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label3608:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3860;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3631:
      if (paramContext.getLayoutParams() == null) {
        break label3865;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
    }
    for (;;)
    {
      ((ImageView)localObject5).setImageResource(2130841172);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label4203;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label3885;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label3703:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label3366;
      label3769:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label3389;
      label3788:
      i = ((LinearLayout)localObject3).getWidth();
      break label3404;
      label3797:
      j = ((LinearLayout)localObject3).getHeight();
      break label3419;
      label3806:
      i = -1;
      break label3465;
      label3811:
      i = 0;
      break label3504;
      label3816:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label3527;
      label3835:
      i = 0;
      break label3584;
      label3840:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label3608;
      label3860:
      i = 0;
      break label3631;
      label3865:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label3885:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((ImageView)localObject5).setRotation(30.0F);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.bottomMargin = LayoutAttrsKt.getDp(-7);
    }
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(23);
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = (ViewGroup)localObject3;
    localObject1 = new ImageView(paramContext.getContext());
    ((ImageView)localObject1).setTag(paramContext);
    ((ImageView)localObject1).setId(2131371553);
    localObject4 = (View)localObject1;
    j = LayoutAttrsKt.getDp(50);
    localObject5 = ((View)localObject4).getLayoutParams();
    if (localObject5 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label4076:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4269;
      }
      ((View)localObject4).getLayoutParams().width = j;
      ((View)localObject4).getLayoutParams().height = i;
      label4102:
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4289;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label4127:
      j = LayoutAttrsKt.getDp(50);
      if (((View)localObject4).getLayoutParams() == null) {
        break label4294;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getTag();
      if (!(localObject5 instanceof FrameLayout)) {
        break label4591;
      }
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 != null) {
        break label4314;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4203:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label4076;
      label4269:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label4102;
      label4289:
      i = 0;
      break label4127;
      label4294:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4314:
    localObject5 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject5);
    ((FrameLayout.LayoutParams)localObject5).gravity = 1;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    paramContext.addView((View)localObject1);
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    ((TextView)localObject5).setId(2131371555);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label4411:
      if (paramContext.getLayoutParams() == null) {
        break label4659;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label4435:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label4679;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label4458:
      if (paramContext.getLayoutParams() == null) {
        break label4684;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
    }
    for (;;)
    {
      ((TextView)localObject5).setTextSize(14.0F);
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(22);
      }
      ((TextView)localObject5).setMaxLines(1);
      ((TextView)localObject5).setMaxEms(4);
      ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label4952;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label4704;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4591:
      if (!(localObject5 instanceof LinearLayout)) {
        break;
      }
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject5 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject5);
      ((LinearLayout.LayoutParams)localObject5).gravity = 1;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      break;
      i = 0;
      break label4411;
      label4659:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label4435;
      label4679:
      i = 0;
      break label4458;
      label4684:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label4704:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (("#7c4f01" instanceof Integer))
    {
      ((TextView)localObject5).setTextColor(((TextView)localObject5).getResources().getColor(((Number)"#7c4f01").intValue()));
      label4762:
      ((ViewGroup)localObject4).addView((View)localObject5);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      ((ImageView)localObject5).setId(2131371554);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(54);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5026;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label4836:
      if (paramContext.getLayoutParams() == null) {
        break label5031;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label4859:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5050;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label4882:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label5055;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label5610;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label5074;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4952:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      ((TextView)localObject5).setTextColor(Color.parseColor("#7c4f01"));
      break label4762;
      label5026:
      i = 0;
      break label4836;
      label5031:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label4859;
      label5050:
      i = 0;
      break label4882;
      label5055:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label5074:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject5).setImageResource(2130841146);
    ((ViewGroup)localObject4).addView((View)localObject5);
    localViewGroup2.addView((View)localObject3);
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new LinearLayout(localViewGroup2.getContext());
    ((LinearLayout)localObject3).setTag(localViewGroup2);
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5222:
      if (paramContext.getLayoutParams() == null) {
        break label5676;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label5245:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label5695;
      }
      i = paramContext.width;
      label5260:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label5704;
      }
      j = paramContext.height;
      label5275:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label5713;
      }
      i = paramContext.gravity;
      label5321:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.rightMargin = LayoutAttrsKt.getDp(12);
      }
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5718;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5401:
      if (paramContext.getLayoutParams() == null) {
        break label5723;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label5424:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      ((ImageView)localObject5).setId(2131371561);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(50);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5742;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5494:
      if (paramContext.getLayoutParams() == null) {
        break label5747;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5517:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5766;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5540:
      j = LayoutAttrsKt.getDp(50);
      if (paramContext.getLayoutParams() == null) {
        break label5771;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label6117;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label5790;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label5610:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label5222;
      label5676:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label5245;
      label5695:
      i = ((LinearLayout)localObject3).getWidth();
      break label5260;
      label5704:
      j = ((LinearLayout)localObject3).getHeight();
      break label5275;
      label5713:
      i = -1;
      break label5321;
      label5718:
      i = 0;
      break label5401;
      label5723:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label5424;
      label5742:
      i = 0;
      break label5494;
      label5747:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5517;
      label5766:
      i = 0;
      break label5540;
      label5771:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label5790:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(33);
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    ((TextView)localObject5).setId(2131371563);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5928:
      if (paramContext.getLayoutParams() == null) {
        break label6183;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label5952:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6203;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5975:
      if (paramContext.getLayoutParams() == null) {
        break label6208;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label5999:
      ((TextView)localObject5).setTextSize(14.0F);
      if (!("#8d4811" instanceof Integer)) {
        break label6228;
      }
      ((TextView)localObject5).setTextColor(((TextView)localObject5).getResources().getColor(((Number)"#8d4811").intValue()));
    }
    for (;;)
    {
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(18);
      }
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label6480;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label6241;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label6117:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label5928;
      label6183:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label5952;
      label6203:
      i = 0;
      break label5975;
      label6208:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label5999;
      label6228:
      ((TextView)localObject5).setTextColor(Color.parseColor("#8d4811"));
    }
    label6241:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((TextView)localObject5).setMaxLines(1);
    ((TextView)localObject5).setMaxEms(4);
    ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
    ((ViewGroup)localObject4).addView((View)localObject5);
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    ((ImageView)localObject5).setId(2131371562);
    paramContext = (View)localObject5;
    j = LayoutAttrsKt.getDp(54);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label6364:
      if (paramContext.getLayoutParams() == null) {
        break label6546;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label6387:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6565;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label6410:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label6570;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label6702;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label6589;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label6480:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label6364;
      label6546:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label6387;
      label6565:
      i = 0;
      break label6410;
      label6570:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label6589:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 81;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    for (;;)
    {
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(2);
      }
      ((ImageView)localObject5).setImageResource(2130841146);
      ((ViewGroup)localObject4).addView((View)localObject5);
      localViewGroup2.addView((View)localObject3);
      localViewGroup1.addView((View)localObject2);
      return (View)localLinearLayout;
      label6702:
      if ((localObject1 instanceof LinearLayout))
      {
        localObject1 = paramContext.getLayoutParams();
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((LinearLayout.LayoutParams)localObject1).gravity = 81;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.PopularityListLayoutKt
 * JD-Core Version:    0.7.0.1
 */