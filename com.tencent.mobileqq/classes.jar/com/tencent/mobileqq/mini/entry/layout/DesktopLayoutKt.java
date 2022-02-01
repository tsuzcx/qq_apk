package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    paramContext = (View)localFrameLayout;
    Object localObject1 = paramContext.getLayoutParams();
    int i;
    label62:
    label85:
    label108:
    label242:
    Object localObject7;
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label827;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localFrameLayout;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label846;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      if (paramContext.getLayoutParams() == null) {
        break label851;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new ImageView(paramContext.getContext());
      ((ImageView)localObject1).setTag(paramContext);
      ((ImageView)localObject1).setId(2131371480);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label870;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label165:
      if (((View)localObject2).getLayoutParams() == null) {
        break label875;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label191:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label895;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label216:
      if (((View)localObject2).getLayoutParams() == null) {
        break label900;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = -1;
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      paramContext.addView((View)localObject1);
      localObject2 = (ViewGroup)localFrameLayout;
      localObject3 = new LinearLayout(((ViewGroup)localObject2).getContext());
      ((LinearLayout)localObject3).setTag(localObject2);
      ((LinearLayout)localObject3).setId(2131371521);
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label920;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label317:
      if (paramContext.getLayoutParams() == null) {
        break label925;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label340:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label944;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label363:
      if (paramContext.getLayoutParams() == null) {
        break label949;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label386:
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.bottomMargin = LayoutAttrsKt.getDp(65);
      }
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new RelativeLayout(((ViewGroup)localObject4).getContext());
      ((RelativeLayout)localObject5).setTag(localObject4);
      ((RelativeLayout)localObject5).setId(2131371208);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label968;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label491:
      if (paramContext.getLayoutParams() == null) {
        break label973;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label514:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label992;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label537:
      j = LayoutAttrsKt.getDp(45);
      if (paramContext.getLayoutParams() == null) {
        break label997;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label566:
      ((ViewGroup)localObject5).setClipChildren(false);
      localObject6 = (ViewGroup)localObject5;
      localObject7 = new TextView(((ViewGroup)localObject6).getContext());
      ((TextView)localObject7).setTag(localObject6);
      ((TextView)localObject7).setId(2131371474);
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1016;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label633:
      if (paramContext.getLayoutParams() == null) {
        break label1021;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label657:
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1041;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label680:
      if (paramContext.getLayoutParams() == null) {
        break label1046;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label704:
      localObject8 = (View)localObject7;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1066;
      }
      i = paramContext.width;
      label726:
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1075;
      }
    }
    int k;
    label900:
    label920:
    label925:
    label944:
    label1075:
    for (int j = paramContext.height;; j = ((View)localObject8).getHeight())
    {
      localObject9 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject8).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label1084;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1084;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject9).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      label827:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label62;
      label846:
      i = 0;
      break label85;
      label851:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label108;
      label870:
      i = 0;
      break label165;
      label875:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label191;
      label895:
      i = 0;
      break label216;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label242;
      i = 0;
      break label317;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label340;
      i = 0;
      break label363;
      label949:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label386;
      label968:
      i = 0;
      break label491;
      label973:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label514;
      label992:
      i = 0;
      break label537;
      label997:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label566;
      label1016:
      i = 0;
      break label633;
      label1021:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label657;
      i = 0;
      break label680;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label704;
      i = ((View)localObject8).getWidth();
      break label726;
    }
    label1041:
    label1046:
    label1066:
    label1084:
    ((RelativeLayout.LayoutParams)localObject9).addRule(13, -1);
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    if (("QQ小程序" instanceof Integer))
    {
      ((TextView)localObject7).setText(((Number)"QQ小程序").intValue());
      ((TextView)localObject7).setTextColor(((TextView)localObject7).getResources().getColor(2131167040));
      ((TextView)localObject7).setTextSize(17.0F);
      ((ViewGroup)localObject6).addView((View)localObject7);
      localObject6 = (ViewGroup)localObject5;
      localObject7 = new RelativeLayout(((ViewGroup)localObject6).getContext());
      ((RelativeLayout)localObject7).setTag(localObject6);
      ((RelativeLayout)localObject7).setId(2131371427);
      paramContext = (View)localObject7;
      j = LayoutAttrsKt.getDp(80);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1425;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1219:
      if (paramContext.getLayoutParams() == null) {
        break label1430;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1242:
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1449;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1265:
      j = LayoutAttrsKt.getDp(30);
      if (paramContext.getLayoutParams() == null) {
        break label1454;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1294:
      localObject8 = (View)localObject7;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1473;
      }
      i = paramContext.width;
      label1316:
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1482;
      }
    }
    label1425:
    label1430:
    label1449:
    label1454:
    label1473:
    label1482:
    for (j = paramContext.height;; j = ((View)localObject8).getHeight())
    {
      localObject9 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject8).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label1491;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1491;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject9).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      ((TextView)localObject7).setText((CharSequence)"QQ小程序");
      break;
      i = 0;
      break label1219;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label1242;
      i = 0;
      break label1265;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1294;
      i = ((View)localObject8).getWidth();
      break label1316;
    }
    label1491:
    ((RelativeLayout.LayoutParams)localObject9).addRule(11, -1);
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    Object localObject8 = (View)localObject7;
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1636;
      }
    }
    label1636:
    for (j = paramContext.height;; j = ((View)localObject8).getHeight())
    {
      localObject9 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject8).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label1645;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1645;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject9).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = ((View)localObject8).getWidth();
      break;
    }
    label1645:
    ((RelativeLayout.LayoutParams)localObject9).addRule(13, -1);
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    localObject1 = ((View)localObject7).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    paramContext = (View)localObject7;
    localObject1 = Integer.valueOf(2130850666);
    if ((localObject1 instanceof String))
    {
      paramContext.setBackgroundColor(Color.parseColor((String)localObject1));
      ((ViewGroup)localObject7).setClipChildren(false);
      ((RelativeLayout)localObject7).setGravity(16);
      localObject8 = (ViewGroup)localObject7;
      localObject9 = new RelativeLayout(((ViewGroup)localObject8).getContext());
      ((RelativeLayout)localObject9).setTag(localObject8);
      ((RelativeLayout)localObject9).setId(2131371462);
      paramContext = (View)localObject9;
      j = LayoutAttrsKt.getDp(22);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2025;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1817:
      if (paramContext.getLayoutParams() == null) {
        break label2030;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1840:
      paramContext = (View)localObject9;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2049;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1863:
      j = LayoutAttrsKt.getDp(22);
      if (paramContext.getLayoutParams() == null) {
        break label2054;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1892:
      localObject10 = (View)localObject9;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2073;
      }
      i = paramContext.width;
      label1914:
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2082;
      }
    }
    label2049:
    label2054:
    label2073:
    label2082:
    for (j = paramContext.height;; j = ((View)localObject10).getHeight())
    {
      localObject11 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject10).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2091;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2091;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject11).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      paramContext.setBackgroundResource(((Number)localObject1).intValue());
      break;
      label2025:
      i = 0;
      break label1817;
      label2030:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label1840;
      i = 0;
      break label1863;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1892;
      i = ((View)localObject10).getWidth();
      break label1914;
    }
    label2091:
    ((RelativeLayout.LayoutParams)localObject11).addRule(9, -1);
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    Object localObject10 = (View)localObject9;
    paramContext = ((View)localObject10).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2236;
      }
    }
    label2236:
    for (j = paramContext.height;; j = ((View)localObject10).getHeight())
    {
      localObject11 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject10).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2245;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2245;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject11).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = ((View)localObject10).getWidth();
      break;
    }
    label2245:
    ((RelativeLayout.LayoutParams)localObject11).addRule(13, -1);
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject1 = ((View)localObject9).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.leftMargin = LayoutAttrsKt.getDp(10);
    }
    ((ViewGroup)localObject9).setClipChildren(false);
    paramContext = (ViewGroup)localObject9;
    localObject1 = new ImageView(paramContext.getContext());
    ((ImageView)localObject1).setTag(paramContext);
    ((ImageView)localObject1).setId(2131371461);
    localObject10 = (View)localObject1;
    j = LayoutAttrsKt.getDp(22);
    Object localObject11 = ((View)localObject10).getLayoutParams();
    if (localObject11 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject11).height;
      if (((View)localObject10).getLayoutParams() == null) {
        break label2639;
      }
      ((View)localObject10).getLayoutParams().width = j;
      ((View)localObject10).getLayoutParams().height = i;
      label2402:
      localObject10 = (View)localObject1;
      localObject11 = ((View)localObject10).getLayoutParams();
      if (localObject11 == null) {
        break label2659;
      }
      i = ((ViewGroup.LayoutParams)localObject11).width;
      label2427:
      j = LayoutAttrsKt.getDp(22);
      if (((View)localObject10).getLayoutParams() == null) {
        break label2664;
      }
      ((View)localObject10).getLayoutParams().width = i;
      ((View)localObject10).getLayoutParams().height = j;
      label2459:
      ((ImageView)localObject1).setImageResource(2130841149);
      ((ImageView)localObject1).setVisibility(0);
      paramContext.addView((View)localObject1);
      localObject10 = (ViewGroup)localObject9;
      localObject11 = new TextView(((ViewGroup)localObject10).getContext());
      ((TextView)localObject11).setTag(localObject10);
      ((TextView)localObject11).setId(2131371463);
      localView = (View)localObject11;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2684;
      }
      i = paramContext.width;
      label2538:
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2693;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label2693:
    for (j = paramContext.height;; j = localView.getHeight())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localObject1 = localView.getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2702;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2702;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        localLayoutParams.addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      label2639:
      ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label2402;
      label2659:
      i = 0;
      break label2427;
      label2664:
      ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label2459;
      label2684:
      i = localView.getWidth();
      break label2538;
    }
    label2702:
    localLayoutParams.addRule(9, -1);
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    View localView = (View)localObject11;
    paramContext = localView.getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2847;
      }
    }
    label2847:
    for (j = paramContext.height;; j = localView.getHeight())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localObject1 = localView.getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label2856;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2856;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        localLayoutParams.addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = localView.getWidth();
      break;
    }
    label2856:
    localLayoutParams.addRule(11, -1);
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localObject1 = ((View)localObject11).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(-10);
    }
    localObject1 = ((View)localObject11).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(-8);
    }
    ((TextView)localObject11).setVisibility(0);
    ((ViewGroup)localObject10).addView((View)localObject11);
    ((ViewGroup)localObject8).addView((View)localObject9);
    localObject8 = (ViewGroup)localObject7;
    Object localObject9 = new ImageView(((ViewGroup)localObject8).getContext());
    ((ImageView)localObject9).setTag(localObject8);
    ((ImageView)localObject9).setId(2131371458);
    paramContext = (View)localObject9;
    j = LayoutAttrsKt.getDp(22);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label3244;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label3069:
      paramContext = (View)localObject9;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3263;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3092:
      j = LayoutAttrsKt.getDp(22);
      if (paramContext.getLayoutParams() == null) {
        break label3268;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label3121:
      localObject10 = (View)localObject9;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3287;
      }
      i = paramContext.width;
      label3143:
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3296;
      }
    }
    label3244:
    label3263:
    label3268:
    label3287:
    label3296:
    for (j = paramContext.height;; j = ((View)localObject10).getHeight())
    {
      localObject11 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject10).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label3305;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label3305;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject11).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label3069;
      i = 0;
      break label3092;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label3121;
      i = ((View)localObject10).getWidth();
      break label3143;
    }
    label3305:
    ((RelativeLayout.LayoutParams)localObject11).addRule(11, -1);
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject10 = (View)localObject9;
    paramContext = ((View)localObject10).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3450;
      }
    }
    label3450:
    for (j = paramContext.height;; j = ((View)localObject10).getHeight())
    {
      localObject11 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject10).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label3459;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label3459;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject11).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = ((View)localObject10).getWidth();
      break;
    }
    label3459:
    ((RelativeLayout.LayoutParams)localObject11).addRule(13, -1);
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject1 = ((View)localObject9).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(10);
    }
    ((ImageView)localObject9).setImageResource(2130841131);
    ((ViewGroup)localObject8).addView((View)localObject9);
    ((ViewGroup)localObject6).addView((View)localObject7);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = (ViewGroup)localObject3;
    localObject1 = new DragRecyclerView(paramContext.getContext());
    ((DragRecyclerView)localObject1).setTag(paramContext);
    ((DragRecyclerView)localObject1).setId(2131371209);
    Object localObject4 = (View)localObject1;
    Object localObject5 = ((View)localObject4).getLayoutParams();
    if (localObject5 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject5).height;
      if (((View)localObject4).getLayoutParams() == null) {
        break label3986;
      }
      ((View)localObject4).getLayoutParams().width = -1;
      ((View)localObject4).getLayoutParams().height = i;
      label3638:
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4006;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label3663:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4011;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
      label3689:
      ((ViewGroup)localObject1).setClipChildren(false);
      ((ViewGroup)localObject1).setClipToPadding(false);
      ((DragRecyclerView)localObject1).setOverScrollMode(2);
      localObject4 = (View)localObject1;
      ((View)localObject4).setPadding(LayoutAttrsKt.getDp(20), ((View)localObject4).getPaddingTop(), ((View)localObject4).getPaddingRight(), ((View)localObject4).getPaddingBottom());
      localObject4 = (View)localObject1;
      ((View)localObject4).setPadding(((View)localObject4).getPaddingLeft(), ((View)localObject4).getPaddingTop(), LayoutAttrsKt.getDp(20), ((View)localObject4).getPaddingBottom());
      paramContext.addView((View)localObject1);
      ((ViewGroup)localObject2).addView((View)localObject3);
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new LinearLayout(paramContext.getContext());
      ((LinearLayout)localObject1).setTag(paramContext);
      ((LinearLayout)localObject1).setId(2131371518);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4031;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label3853:
      if (((View)localObject2).getLayoutParams() == null) {
        break label4036;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label3879:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4056;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label3904:
      j = LayoutAttrsKt.getDp(65);
      if (((View)localObject2).getLayoutParams() == null) {
        break label4061;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getTag();
      if (!(localObject3 instanceof FrameLayout)) {
        break label4507;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 != null) {
        break label4081;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      i = 0;
      break;
      label3986:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label3638;
      label4006:
      i = 0;
      break label3663;
      label4011:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label3689;
      label4031:
      i = 0;
      break label3853;
      label4036:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label3879;
      label4056:
      i = 0;
      break label3904;
      label4061:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4081:
    Object localObject3 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).gravity = 80;
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    Object localObject2 = (View)localObject1;
    localObject3 = Integer.valueOf(2130838980);
    if ((localObject3 instanceof String))
    {
      ((View)localObject2).setBackgroundColor(Color.parseColor((String)localObject3));
      label4148:
      ((LinearLayout)localObject1).setGravity(17);
      localObject2 = (ViewGroup)localObject1;
      localObject3 = new ImageView(((ViewGroup)localObject2).getContext());
      ((ImageView)localObject3).setTag(localObject2);
      ((ImageView)localObject3).setId(2131371519);
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4588;
      }
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label4216:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4593;
      }
      ((View)localObject4).getLayoutParams().width = -2;
      ((View)localObject4).getLayoutParams().height = i;
      label4243:
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4614;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label4268:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4619;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
      label4294:
      ((ImageView)localObject3).setImageResource(2130841132);
      ((ViewGroup)localObject2).addView((View)localObject3);
      paramContext.addView((View)localObject1);
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new LinearLayout(paramContext.getContext());
      ((LinearLayout)localObject1).setTag(paramContext);
      ((LinearLayout)localObject1).setId(2131365660);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4639;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label4379:
      if (((View)localObject2).getLayoutParams() == null) {
        break label4644;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label4405:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4664;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label4430:
      j = LayoutAttrsKt.getDp(65);
      if (((View)localObject2).getLayoutParams() == null) {
        break label4669;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getTag();
      if (!(localObject3 instanceof FrameLayout)) {
        break label5444;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 != null) {
        break label4689;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4507:
      if (!(localObject3 instanceof LinearLayout)) {
        break;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
      ((LinearLayout.LayoutParams)localObject3).gravity = 80;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break;
      ((View)localObject2).setBackgroundResource(((Number)localObject3).intValue());
      break label4148;
      label4588:
      i = 0;
      break label4216;
      label4593:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label4243;
      label4614:
      i = 0;
      break label4268;
      label4619:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label4294;
      label4639:
      i = 0;
      break label4379;
      label4644:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label4405;
      label4664:
      i = 0;
      break label4430;
      label4669:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4689:
    localObject3 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).gravity = 80;
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = (View)localObject1;
    localObject3 = Integer.valueOf(2130841134);
    if ((localObject3 instanceof String))
    {
      ((View)localObject2).setBackgroundColor(Color.parseColor((String)localObject3));
      label4756:
      ((LinearLayout)localObject1).setGravity(17);
      ((LinearLayout)localObject1).setVisibility(8);
      localObject2 = (ViewGroup)localObject1;
      localObject3 = new TextView(((ViewGroup)localObject2).getContext());
      ((TextView)localObject3).setTag(localObject2);
      ((TextView)localObject3).setId(2131365653);
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label5525;
      }
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label4831:
      if (((View)localObject4).getLayoutParams() == null) {
        break label5530;
      }
      ((View)localObject4).getLayoutParams().width = -2;
      ((View)localObject4).getLayoutParams().height = i;
      label4858:
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label5551;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label4883:
      if (((View)localObject4).getLayoutParams() == null) {
        break label5556;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -2;
      label4910:
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setText(2131711975);
      ((TextView)localObject3).setCompoundDrawables(((TextView)localObject3).getContext().getDrawable(2130841136), null, null, null);
      ((TextView)localObject3).setCompoundDrawablePadding(LayoutAttrsKt.getDp(12));
      if (!("#FFFFFF" instanceof Integer)) {
        break label5577;
      }
      ((TextView)localObject3).setTextColor(((TextView)localObject3).getResources().getColor(((Number)"#FFFFFF").intValue()));
      label4985:
      ((ViewGroup)localObject2).addView((View)localObject3);
      paramContext.addView((View)localObject1);
      localObject2 = (ViewGroup)localFrameLayout;
      localObject3 = new RelativeLayout(((ViewGroup)localObject2).getContext());
      ((RelativeLayout)localObject3).setTag(localObject2);
      ((RelativeLayout)localObject3).setId(2131371476);
      paramContext = (View)localObject3;
      j = LayoutAttrsKt.getDp(66);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5591;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5069:
      if (paramContext.getLayoutParams() == null) {
        break label5596;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5092:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5615;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5115:
      if (paramContext.getLayoutParams() == null) {
        break label5620;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label5139:
      ((RelativeLayout)localObject3).setVisibility(4);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      ((ImageView)localObject5).setId(2131371475);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(48);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5640;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5210:
      if (paramContext.getLayoutParams() == null) {
        break label5645;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5233:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5664;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5256:
      j = LayoutAttrsKt.getDp(48);
      if (paramContext.getLayoutParams() == null) {
        break label5669;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label5285:
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null) {
        paramContext.topMargin = LayoutAttrsKt.getDp(8);
      }
      localObject6 = (View)localObject5;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label5688;
      }
      i = paramContext.width;
      label5348:
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label5697;
      }
    }
    label5525:
    label5530:
    label5551:
    label5556:
    label5688:
    label5697:
    for (j = paramContext.height;; j = ((View)localObject6).getHeight())
    {
      localObject7 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject6).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label5706;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label5706;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      label5444:
      if (!(localObject3 instanceof LinearLayout)) {
        break;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
      ((LinearLayout.LayoutParams)localObject3).gravity = 80;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break;
      ((View)localObject2).setBackgroundResource(((Number)localObject3).intValue());
      break label4756;
      i = 0;
      break label4831;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label4858;
      i = 0;
      break label4883;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label4910;
      label5577:
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFFFF"));
      break label4985;
      label5591:
      i = 0;
      break label5069;
      label5596:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5092;
      label5615:
      i = 0;
      break label5115;
      label5620:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label5139;
      i = 0;
      break label5210;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5233;
      i = 0;
      break label5256;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label5285;
      i = ((View)localObject6).getWidth();
      break label5348;
    }
    label5640:
    label5645:
    label5664:
    label5669:
    label5706:
    ((RelativeLayout.LayoutParams)localObject7).addRule(14, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    ((ImageView)localObject5).setImageResource(2130848774);
    ((ViewGroup)localObject4).addView((View)localObject5);
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    ((ImageView)localObject5).setId(2131371477);
    paramContext = (View)localObject5;
    j = LayoutAttrsKt.getDp(15);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label6005;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5830:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6024;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5853:
      j = LayoutAttrsKt.getDp(15);
      if (paramContext.getLayoutParams() == null) {
        break label6029;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label5882:
      localObject6 = (View)localObject5;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6048;
      }
      i = paramContext.width;
      label5904:
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6057;
      }
    }
    label6024:
    label6029:
    label6048:
    label6057:
    for (j = paramContext.height;; j = ((View)localObject6).getHeight())
    {
      localObject7 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject6).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label6066;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label6066;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = 0;
      break;
      label6005:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5830;
      i = 0;
      break label5853;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label5882;
      i = ((View)localObject6).getWidth();
      break label5904;
    }
    label6066:
    ((RelativeLayout.LayoutParams)localObject7).addRule(9, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    Object localObject6 = (View)localObject5;
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6211;
      }
    }
    label6211:
    for (j = paramContext.height;; j = ((View)localObject6).getHeight())
    {
      localObject7 = new RelativeLayout.LayoutParams(i, j);
      localObject1 = ((View)localObject6).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        paramContext = null;
      }
      paramContext = (RelativeLayout.LayoutParams)paramContext;
      if (paramContext == null) {
        break label6220;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label6220;
      }
      i = 0;
      k = paramContext.length;
      j = 0;
      while (j < k)
      {
        ((RelativeLayout.LayoutParams)localObject7).addRule(i, paramContext[j]);
        j += 1;
        i += 1;
      }
      i = ((View)localObject6).getWidth();
      break;
    }
    label6220:
    ((RelativeLayout.LayoutParams)localObject7).addRule(11, -1);
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.topMargin = LayoutAttrsKt.getDp(4);
    }
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null) {
      paramContext.rightMargin = LayoutAttrsKt.getDp(4);
    }
    ((ImageView)localObject5).setImageResource(2130841139);
    ((ViewGroup)localObject4).addView((View)localObject5);
    ((ViewGroup)localObject2).addView((View)localObject3);
    return (View)localFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.DesktopLayoutKt
 * JD-Core Version:    0.7.0.1
 */