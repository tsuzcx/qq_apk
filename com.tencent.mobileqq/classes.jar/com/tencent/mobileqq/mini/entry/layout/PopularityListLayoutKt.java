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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildPopularityListLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
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
        break label621;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label62:
      paramContext = (View)localLinearLayout;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label640;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label85:
      j = LayoutAttrsKt.getDp(208);
      if (paramContext.getLayoutParams() == null) {
        break label645;
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
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(20);
        paramContext = Unit.INSTANCE;
      }
      localLinearLayout.setId(2131371116);
      localLinearLayout.setOrientation(1);
      localViewGroup1 = (ViewGroup)localLinearLayout;
      localObject2 = new RelativeLayout(localViewGroup1.getContext());
      ((RelativeLayout)localObject2).setTag(localViewGroup1);
      paramContext = Unit.INSTANCE;
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label664;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label228:
      if (paramContext.getLayoutParams() == null) {
        break label669;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label251:
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label688;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label274:
      j = LayoutAttrsKt.getDp(25);
      if (paramContext.getLayoutParams() == null) {
        break label693;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label303:
      ((RelativeLayout)localObject2).setGravity(16);
      localObject1 = ((View)localObject2).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(10);
        paramContext = Unit.INSTANCE;
      }
      localViewGroup2 = (ViewGroup)localObject2;
      localObject3 = new ImageView(localViewGroup2.getContext());
      ((ImageView)localObject3).setTag(localViewGroup2);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject3).setId(2131371124);
      paramContext = (View)localObject3;
      j = LayoutAttrsKt.getDp(20);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label712;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label423:
      if (paramContext.getLayoutParams() == null) {
        break label717;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label446:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label736;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label469:
      j = LayoutAttrsKt.getDp(20);
      if (paramContext.getLayoutParams() == null) {
        break label741;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label498:
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label760;
      }
      i = paramContext.width;
      label520:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label769;
      }
    }
    int k;
    label640:
    label769:
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
        break label782;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label782;
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
      label621:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label62;
      i = 0;
      break label85;
      label645:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label115;
      label664:
      i = 0;
      break label228;
      label669:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label251;
      label688:
      i = 0;
      break label274;
      label693:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label303;
      label712:
      i = 0;
      break label423;
      label717:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label446;
      label736:
      i = 0;
      break label469;
      label741:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label498;
      label760:
      i = ((View)localObject4).getWidth();
      break label520;
    }
    paramContext = Unit.INSTANCE;
    label782:
    ((RelativeLayout.LayoutParams)localObject5).addRule(9, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localObject1 = ((View)localObject3).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.leftMargin = LayoutAttrsKt.getDp(11);
      paramContext = Unit.INSTANCE;
    }
    ((ImageView)localObject3).setImageResource(2130840974);
    localViewGroup2.addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    ViewGroup localViewGroup2 = (ViewGroup)localObject2;
    Object localObject3 = new TextView(localViewGroup2.getContext());
    ((TextView)localObject3).setTag(localViewGroup2);
    paramContext = Unit.INSTANCE;
    ((TextView)localObject3).setId(2131371123);
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label1213;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label956:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1233;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label979:
      if (paramContext.getLayoutParams() == null) {
        break label1238;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label1003:
      ((TextView)localObject3).setTextSize(14.0F);
      ((TextView)localObject3).setText(2131705688);
      if (!("#060606" instanceof Integer)) {
        break label1258;
      }
      ((TextView)localObject3).setTextColor(((TextView)localObject3).getResources().getColor(((Number)"#060606").intValue()));
      label1046:
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.leftMargin = LayoutAttrsKt.getDp(3);
        paramContext = Unit.INSTANCE;
      }
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1271;
      }
      i = paramContext.width;
      label1112:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1280;
      }
    }
    label1280:
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
        break label1293;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1293;
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
      label1213:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label956;
      label1233:
      i = 0;
      break label979;
      label1238:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label1003;
      label1258:
      ((TextView)localObject3).setTextColor(Color.parseColor("#060606"));
      break label1046;
      label1271:
      i = ((View)localObject4).getWidth();
      break label1112;
    }
    paramContext = Unit.INSTANCE;
    label1293:
    ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131371124);
    paramContext = Unit.INSTANCE;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localViewGroup2.addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new ImageView(localViewGroup2.getContext());
    ((ImageView)localObject3).setTag(localViewGroup2);
    paramContext = Unit.INSTANCE;
    ((ImageView)localObject3).setId(2131371115);
    paramContext = (View)localObject3;
    j = LayoutAttrsKt.getDp(20);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label1595;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1420:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1614;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1443:
      j = LayoutAttrsKt.getDp(20);
      if (paramContext.getLayoutParams() == null) {
        break label1619;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1472:
      localObject4 = (View)localObject3;
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1638;
      }
      i = paramContext.width;
      label1494:
      paramContext = ((View)localObject4).getLayoutParams();
      if (paramContext == null) {
        break label1647;
      }
    }
    label1595:
    label1614:
    label1619:
    label1638:
    label1647:
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
        break label1660;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1660;
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
      break label1420;
      i = 0;
      break label1443;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1472;
      i = ((View)localObject4).getWidth();
      break label1494;
    }
    paramContext = Unit.INSTANCE;
    label1660:
    ((RelativeLayout.LayoutParams)localObject5).addRule(11, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    localObject1 = ((View)localObject3).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
      paramContext = Unit.INSTANCE;
    }
    ((ImageView)localObject3).setImageResource(2130848408);
    localViewGroup2.addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    localViewGroup1.addView((View)localObject2);
    paramContext = Unit.INSTANCE;
    ViewGroup localViewGroup1 = (ViewGroup)localLinearLayout;
    Object localObject2 = new LinearLayout(localViewGroup1.getContext());
    ((LinearLayout)localObject2).setTag(localViewGroup1);
    paramContext = Unit.INSTANCE;
    paramContext = (View)localObject2;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label2353;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label1840:
      paramContext = (View)localObject2;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2372;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1863:
      if (paramContext.getLayoutParams() == null) {
        break label2377;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label1887:
      ((LinearLayout)localObject2).setOrientation(0);
      localViewGroup2 = (ViewGroup)localObject2;
      localObject3 = new LinearLayout(localViewGroup2.getContext());
      ((LinearLayout)localObject3).setTag(localViewGroup2);
      paramContext = Unit.INSTANCE;
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2397;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1948:
      if (paramContext.getLayoutParams() == null) {
        break label2402;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label1971:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label2421;
      }
      i = paramContext.width;
      label1986:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label2430;
      }
      j = paramContext.height;
      label2001:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2439;
      }
      i = paramContext.gravity;
      label2047:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      paramContext = Unit.INSTANCE;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.leftMargin = LayoutAttrsKt.getDp(10);
        paramContext = Unit.INSTANCE;
      }
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2444;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2135:
      if (paramContext.getLayoutParams() == null) {
        break label2449;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label2158:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject5).setId(2131371117);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(50);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2468;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label2232:
      if (paramContext.getLayoutParams() == null) {
        break label2473;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label2255:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2492;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2278:
      j = LayoutAttrsKt.getDp(50);
      if (paramContext.getLayoutParams() == null) {
        break label2497;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label2835;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label2516;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      i = 0;
      break;
      label2353:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label1840;
      label2372:
      i = 0;
      break label1863;
      label2377:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label1887;
      label2397:
      i = 0;
      break label1948;
      label2402:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label1971;
      label2421:
      i = ((LinearLayout)localObject3).getWidth();
      break label1986;
      label2430:
      j = ((LinearLayout)localObject3).getHeight();
      break label2001;
      label2439:
      i = -1;
      break label2047;
      label2444:
      i = 0;
      break label2135;
      label2449:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label2158;
      label2468:
      i = 0;
      break label2232;
      label2473:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label2255;
      label2492:
      i = 0;
      break label2278;
      label2497:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label2516:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    Unit localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(31);
      paramContext = Unit.INSTANCE;
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    Object localObject4 = (ViewGroup)localObject3;
    Object localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    paramContext = Unit.INSTANCE;
    ((TextView)localObject5).setId(2131371119);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label2671:
      if (paramContext.getLayoutParams() == null) {
        break label2906;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label2695:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2926;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label2718:
      if (paramContext.getLayoutParams() == null) {
        break label2931;
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
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(18);
        paramContext = Unit.INSTANCE;
      }
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label3232;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label2951;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label2835:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label2671;
      label2906:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label2695;
      label2926:
      i = 0;
      break label2718;
      label2931:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label2951:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((TextView)localObject5).setMaxLines(1);
    ((TextView)localObject5).setMaxEms(4);
    ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
    if (("#484848" instanceof Integer))
    {
      ((TextView)localObject5).setTextColor(((TextView)localObject5).getResources().getColor(((Number)"#484848").intValue()));
      label3034:
      ((ViewGroup)localObject4).addView((View)localObject5);
      paramContext = Unit.INSTANCE;
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject5).setId(2131371118);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(54);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3311;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label3116:
      if (paramContext.getLayoutParams() == null) {
        break label3316;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label3139:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3335;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3162:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label3340;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label3872;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label3359;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label3232:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      ((TextView)localObject5).setTextColor(Color.parseColor("#484848"));
      break label3034;
      label3311:
      i = 0;
      break label3116;
      label3316:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label3139;
      label3335:
      i = 0;
      break label3162;
      label3340:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label3359:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(2);
      paramContext = Unit.INSTANCE;
    }
    ((ImageView)localObject5).setImageResource(2130840941);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    localViewGroup2.addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new LinearLayout(localViewGroup2.getContext());
    ((LinearLayout)localObject3).setTag(localViewGroup2);
    paramContext = Unit.INSTANCE;
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label3527:
      if (paramContext.getLayoutParams() == null) {
        break label3943;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label3550:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label3962;
      }
      i = paramContext.width;
      label3565:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label3971;
      }
      j = paramContext.height;
      label3580:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label3980;
      }
      i = paramContext.gravity;
      label3626:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      paramContext = Unit.INSTANCE;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3985;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3669:
      if (paramContext.getLayoutParams() == null) {
        break label3990;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label3692:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label4009;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label3753:
      if (paramContext.getLayoutParams() == null) {
        break label4014;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label3777:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label4034;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3800:
      if (paramContext.getLayoutParams() == null) {
        break label4039;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
    }
    for (;;)
    {
      ((ImageView)localObject5).setImageResource(2130840974);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label4399;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label4059;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label3872:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label3527;
      label3943:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label3550;
      label3962:
      i = ((LinearLayout)localObject3).getWidth();
      break label3565;
      label3971:
      j = ((LinearLayout)localObject3).getHeight();
      break label3580;
      label3980:
      i = -1;
      break label3626;
      label3985:
      i = 0;
      break label3669;
      label3990:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label3692;
      label4009:
      i = 0;
      break label3753;
      label4014:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label3777;
      label4034:
      i = 0;
      break label3800;
      label4039:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label4059:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((ImageView)localObject5).setRotation(30.0F);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.bottomMargin = LayoutAttrsKt.getDp(-7);
      paramContext = Unit.INSTANCE;
    }
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.leftMargin = LayoutAttrsKt.getDp(23);
      paramContext = Unit.INSTANCE;
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    paramContext = (ViewGroup)localObject3;
    localObject1 = new ImageView(paramContext.getContext());
    ((ImageView)localObject1).setTag(paramContext);
    localObject4 = Unit.INSTANCE;
    ((ImageView)localObject1).setId(2131371112);
    localObject4 = (View)localObject1;
    j = LayoutAttrsKt.getDp(50);
    localObject5 = ((View)localObject4).getLayoutParams();
    if (localObject5 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label4272:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4470;
      }
      ((View)localObject4).getLayoutParams().width = j;
      ((View)localObject4).getLayoutParams().height = i;
      label4298:
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4490;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label4323:
      j = LayoutAttrsKt.getDp(50);
      if (((View)localObject4).getLayoutParams() == null) {
        break label4495;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getTag();
      if (!(localObject5 instanceof FrameLayout)) {
        break label4809;
      }
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 != null) {
        break label4515;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4399:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label4272;
      label4470:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label4298;
      label4490:
      i = 0;
      break label4323;
      label4495:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4515:
    localObject5 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject5);
    ((FrameLayout.LayoutParams)localObject5).gravity = 1;
    localUnit = Unit.INSTANCE;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    paramContext.addView((View)localObject1);
    paramContext = Unit.INSTANCE;
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    paramContext = Unit.INSTANCE;
    ((TextView)localObject5).setId(2131371114);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label4625:
      if (paramContext.getLayoutParams() == null) {
        break label4882;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label4649:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label4902;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label4672:
      if (paramContext.getLayoutParams() == null) {
        break label4907;
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
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(22);
        paramContext = Unit.INSTANCE;
      }
      ((TextView)localObject5).setMaxLines(1);
      ((TextView)localObject5).setMaxEms(4);
      ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label5188;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label4927;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4809:
      if (!(localObject5 instanceof LinearLayout)) {
        break;
      }
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject5 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject5);
      ((LinearLayout.LayoutParams)localObject5).gravity = 1;
      localUnit = Unit.INSTANCE;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      break;
      i = 0;
      break label4625;
      label4882:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label4649;
      label4902:
      i = 0;
      break label4672;
      label4907:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
    }
    label4927:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    if (("#7c4f01" instanceof Integer))
    {
      ((TextView)localObject5).setTextColor(((TextView)localObject5).getResources().getColor(((Number)"#7c4f01").intValue()));
      label4990:
      ((ViewGroup)localObject4).addView((View)localObject5);
      paramContext = Unit.INSTANCE;
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject5).setId(2131371113);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(54);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5267;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5072:
      if (paramContext.getLayoutParams() == null) {
        break label5272;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5095:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5291;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5118:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label5296;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label5884;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label5315;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label5188:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      ((TextView)localObject5).setTextColor(Color.parseColor("#7c4f01"));
      break label4990;
      label5267:
      i = 0;
      break label5072;
      label5272:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5095;
      label5291:
      i = 0;
      break label5118;
      label5296:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label5315:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(10);
      paramContext = Unit.INSTANCE;
    }
    ((ImageView)localObject5).setImageResource(2130840941);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    localViewGroup2.addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    localViewGroup2 = (ViewGroup)localObject2;
    localObject3 = new LinearLayout(localViewGroup2.getContext());
    ((LinearLayout)localObject3).setTag(localViewGroup2);
    paramContext = Unit.INSTANCE;
    paramContext = (View)localObject3;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5484:
      if (paramContext.getLayoutParams() == null) {
        break label5955;
      }
      paramContext.getLayoutParams().width = 0;
      paramContext.getLayoutParams().height = i;
      label5507:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label5974;
      }
      i = paramContext.width;
      label5522:
      paramContext = ((LinearLayout)localObject3).getLayoutParams();
      if (paramContext == null) {
        break label5983;
      }
      j = paramContext.height;
      label5537:
      localObject4 = new LinearLayout.LayoutParams(i, j, 1.0F);
      localObject1 = ((LinearLayout)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (LinearLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label5992;
      }
      i = paramContext.gravity;
      label5583:
      ((LinearLayout.LayoutParams)localObject4).gravity = i;
      paramContext = Unit.INSTANCE;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.rightMargin = LayoutAttrsKt.getDp(12);
        paramContext = Unit.INSTANCE;
      }
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5997;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5671:
      if (paramContext.getLayoutParams() == null) {
        break label6002;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label5694:
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject5).setId(2131371120);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(50);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6021;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5768:
      if (paramContext.getLayoutParams() == null) {
        break label6026;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5791:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6045;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5814:
      j = LayoutAttrsKt.getDp(50);
      if (paramContext.getLayoutParams() == null) {
        break label6050;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label6417;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label6069;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label5884:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label5484;
      label5955:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(0, i));
      break label5507;
      label5974:
      i = ((LinearLayout)localObject3).getWidth();
      break label5522;
      label5983:
      j = ((LinearLayout)localObject3).getHeight();
      break label5537;
      label5992:
      i = -1;
      break label5583;
      label5997:
      i = 0;
      break label5671;
      label6002:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label5694;
      label6021:
      i = 0;
      break label5768;
      label6026:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5791;
      label6045:
      i = 0;
      break label5814;
      label6050:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label6069:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(33);
      paramContext = Unit.INSTANCE;
    }
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new TextView(((ViewGroup)localObject4).getContext());
    ((TextView)localObject5).setTag(localObject4);
    paramContext = Unit.INSTANCE;
    ((TextView)localObject5).setId(2131371122);
    paramContext = (View)localObject5;
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label6224:
      if (paramContext.getLayoutParams() == null) {
        break label6488;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label6248:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6508;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label6271:
      if (paramContext.getLayoutParams() == null) {
        break label6513;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label6295:
      ((TextView)localObject5).setTextSize(14.0F);
      if (!("#8d4811" instanceof Integer)) {
        break label6533;
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
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(18);
        paramContext = Unit.INSTANCE;
      }
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label6798;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label6546;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label6417:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label6224;
      label6488:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label6248;
      label6508:
      i = 0;
      break label6271;
      label6513:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label6295;
      label6533:
      ((TextView)localObject5).setTextColor(Color.parseColor("#8d4811"));
    }
    label6546:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 1;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((TextView)localObject5).setMaxLines(1);
    ((TextView)localObject5).setMaxEms(4);
    ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    paramContext = Unit.INSTANCE;
    ((ImageView)localObject5).setId(2131371121);
    paramContext = (View)localObject5;
    j = LayoutAttrsKt.getDp(54);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label6682:
      if (paramContext.getLayoutParams() == null) {
        break label6869;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label6705:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6888;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label6728:
      j = LayoutAttrsKt.getDp(28);
      if (paramContext.getLayoutParams() == null) {
        break label6893;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
    }
    for (;;)
    {
      paramContext = (View)localObject5;
      localObject1 = paramContext.getTag();
      if (!(localObject1 instanceof FrameLayout)) {
        break label7046;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 != null) {
        break label6912;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label6798:
      if (!(localObject1 instanceof LinearLayout)) {
        break;
      }
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localUnit = Unit.INSTANCE;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      break;
      i = 0;
      break label6682;
      label6869:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label6705;
      label6888:
      i = 0;
      break label6728;
      label6893:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label6912:
    localObject1 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((FrameLayout.LayoutParams)localObject1).gravity = 81;
    localUnit = Unit.INSTANCE;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    for (;;)
    {
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(2);
        paramContext = Unit.INSTANCE;
      }
      ((ImageView)localObject5).setImageResource(2130840941);
      ((ViewGroup)localObject4).addView((View)localObject5);
      paramContext = Unit.INSTANCE;
      localViewGroup2.addView((View)localObject3);
      paramContext = Unit.INSTANCE;
      localViewGroup1.addView((View)localObject2);
      paramContext = Unit.INSTANCE;
      return (View)localLinearLayout;
      label7046:
      if ((localObject1 instanceof LinearLayout))
      {
        localObject1 = paramContext.getLayoutParams();
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        localObject1 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        ((LinearLayout.LayoutParams)localObject1).gravity = 81;
        localUnit = Unit.INSTANCE;
        paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.PopularityListLayoutKt
 * JD-Core Version:    0.7.0.1
 */