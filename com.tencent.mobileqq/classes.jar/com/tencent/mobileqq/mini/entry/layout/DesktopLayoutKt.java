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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildDesktopEntryLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
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
    label247:
    label376:
    Object localObject7;
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label852;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      paramContext = (View)localFrameLayout;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label871;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      if (paramContext.getLayoutParams() == null) {
        break label876;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new ImageView(paramContext.getContext());
      ((ImageView)localObject1).setTag(paramContext);
      localObject2 = Unit.INSTANCE;
      ((ImageView)localObject1).setId(2131371040);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label895;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label170:
      if (((View)localObject2).getLayoutParams() == null) {
        break label900;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label196:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label920;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label221:
      if (((View)localObject2).getLayoutParams() == null) {
        break label925;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = -1;
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
      paramContext.addView((View)localObject1);
      paramContext = Unit.INSTANCE;
      localObject2 = (ViewGroup)localFrameLayout;
      localObject3 = new LinearLayout(((ViewGroup)localObject2).getContext());
      ((LinearLayout)localObject3).setTag(localObject2);
      paramContext = Unit.INSTANCE;
      ((LinearLayout)localObject3).setId(2131371081);
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label945;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label330:
      if (paramContext.getLayoutParams() == null) {
        break label950;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label353:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label969;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      if (paramContext.getLayoutParams() == null) {
        break label974;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -1;
      label399:
      localObject1 = ((View)localObject3).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.bottomMargin = LayoutAttrsKt.getDp(65);
        paramContext = Unit.INSTANCE;
      }
      ((LinearLayout)localObject3).setOrientation(1);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new RelativeLayout(((ViewGroup)localObject4).getContext());
      ((RelativeLayout)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((RelativeLayout)localObject5).setId(2131370777);
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label993;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label512:
      if (paramContext.getLayoutParams() == null) {
        break label998;
      }
      paramContext.getLayoutParams().width = -1;
      paramContext.getLayoutParams().height = i;
      label535:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1017;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label558:
      j = LayoutAttrsKt.getDp(45);
      if (paramContext.getLayoutParams() == null) {
        break label1022;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label587:
      ((ViewGroup)localObject5).setClipChildren(false);
      localObject6 = (ViewGroup)localObject5;
      localObject7 = new TextView(((ViewGroup)localObject6).getContext());
      ((TextView)localObject7).setTag(localObject6);
      paramContext = Unit.INSTANCE;
      ((TextView)localObject7).setId(2131371034);
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1041;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label658:
      if (paramContext.getLayoutParams() == null) {
        break label1046;
      }
      paramContext.getLayoutParams().width = -2;
      paramContext.getLayoutParams().height = i;
      label682:
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1066;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label705:
      if (paramContext.getLayoutParams() == null) {
        break label1071;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label729:
      localObject8 = (View)localObject7;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1091;
      }
      i = paramContext.width;
      label751:
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1100;
      }
    }
    int k;
    label900:
    label920:
    label925:
    label945:
    label950:
    label969:
    label1100:
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
        break label1113;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1113;
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
      label852:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label62;
      label871:
      i = 0;
      break label85;
      label876:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label108;
      label895:
      i = 0;
      break label170;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label196;
      i = 0;
      break label221;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label247;
      i = 0;
      break label330;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label353;
      i = 0;
      break label376;
      label974:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label399;
      label993:
      i = 0;
      break label512;
      label998:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label535;
      label1017:
      i = 0;
      break label558;
      label1022:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label587;
      i = 0;
      break label658;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label682;
      i = 0;
      break label705;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label729;
      i = ((View)localObject8).getWidth();
      break label751;
    }
    label1041:
    label1046:
    label1066:
    label1071:
    label1091:
    paramContext = Unit.INSTANCE;
    label1113:
    ((RelativeLayout.LayoutParams)localObject9).addRule(13, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    if (("QQ小程序" instanceof Integer))
    {
      ((TextView)localObject7).setText(((Number)"QQ小程序").intValue());
      ((TextView)localObject7).setTextColor(((TextView)localObject7).getResources().getColor(2131166997));
      ((TextView)localObject7).setTextSize(17.0F);
      ((ViewGroup)localObject6).addView((View)localObject7);
      paramContext = Unit.INSTANCE;
      localObject6 = (ViewGroup)localObject5;
      localObject7 = new RelativeLayout(((ViewGroup)localObject6).getContext());
      ((RelativeLayout)localObject7).setTag(localObject6);
      paramContext = Unit.INSTANCE;
      ((RelativeLayout)localObject7).setId(2131370995);
      paramContext = (View)localObject7;
      j = LayoutAttrsKt.getDp(80);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1466;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1260:
      if (paramContext.getLayoutParams() == null) {
        break label1471;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1283:
      paramContext = (View)localObject7;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label1490;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1306:
      j = LayoutAttrsKt.getDp(30);
      if (paramContext.getLayoutParams() == null) {
        break label1495;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1335:
      localObject8 = (View)localObject7;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1514;
      }
      i = paramContext.width;
      label1357:
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1523;
      }
    }
    label1466:
    label1471:
    label1490:
    label1495:
    label1514:
    label1523:
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
        break label1536;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1536;
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
      break label1260;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label1283;
      i = 0;
      break label1306;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1335;
      i = ((View)localObject8).getWidth();
      break label1357;
    }
    paramContext = Unit.INSTANCE;
    label1536:
    ((RelativeLayout.LayoutParams)localObject9).addRule(11, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    Object localObject8 = (View)localObject7;
    paramContext = ((View)localObject8).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject8).getLayoutParams();
      if (paramContext == null) {
        break label1685;
      }
    }
    label1685:
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
        break label1698;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label1698;
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
    paramContext = Unit.INSTANCE;
    label1698:
    ((RelativeLayout.LayoutParams)localObject9).addRule(13, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    localObject1 = ((View)localObject7).getLayoutParams();
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
    paramContext = (View)localObject7;
    localObject1 = Integer.valueOf(2130850245);
    if ((localObject1 instanceof String))
    {
      paramContext.setBackgroundColor(Color.parseColor((String)localObject1));
      ((ViewGroup)localObject7).setClipChildren(false);
      ((RelativeLayout)localObject7).setGravity(16);
      localObject8 = (ViewGroup)localObject7;
      localObject9 = new RelativeLayout(((ViewGroup)localObject8).getContext());
      ((RelativeLayout)localObject9).setTag(localObject8);
      paramContext = Unit.INSTANCE;
      ((RelativeLayout)localObject9).setId(2131371030);
      paramContext = (View)localObject9;
      j = LayoutAttrsKt.getDp(22);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2090;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label1882:
      if (paramContext.getLayoutParams() == null) {
        break label2095;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label1905:
      paramContext = (View)localObject9;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label2114;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label1928:
      j = LayoutAttrsKt.getDp(22);
      if (paramContext.getLayoutParams() == null) {
        break label2119;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label1957:
      localObject10 = (View)localObject9;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2138;
      }
      i = paramContext.width;
      label1979:
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2147;
      }
    }
    label2090:
    label2095:
    label2114:
    label2119:
    label2138:
    label2147:
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
        break label2160;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2160;
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
      i = 0;
      break label1882;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label1905;
      i = 0;
      break label1928;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label1957;
      i = ((View)localObject10).getWidth();
      break label1979;
    }
    paramContext = Unit.INSTANCE;
    label2160:
    ((RelativeLayout.LayoutParams)localObject11).addRule(9, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    Object localObject10 = (View)localObject9;
    paramContext = ((View)localObject10).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label2309;
      }
    }
    label2309:
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
        break label2322;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2322;
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
    paramContext = Unit.INSTANCE;
    label2322:
    ((RelativeLayout.LayoutParams)localObject11).addRule(13, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject1 = ((View)localObject9).getLayoutParams();
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
    ((ViewGroup)localObject9).setClipChildren(false);
    paramContext = (ViewGroup)localObject9;
    localObject1 = new ImageView(paramContext.getContext());
    ((ImageView)localObject1).setTag(paramContext);
    localObject10 = Unit.INSTANCE;
    ((ImageView)localObject1).setId(2131371029);
    localObject10 = (View)localObject1;
    j = LayoutAttrsKt.getDp(22);
    Object localObject11 = ((View)localObject10).getLayoutParams();
    if (localObject11 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject11).height;
      if (((View)localObject10).getLayoutParams() == null) {
        break label2737;
      }
      ((View)localObject10).getLayoutParams().width = j;
      ((View)localObject10).getLayoutParams().height = i;
      label2492:
      localObject10 = (View)localObject1;
      localObject11 = ((View)localObject10).getLayoutParams();
      if (localObject11 == null) {
        break label2757;
      }
      i = ((ViewGroup.LayoutParams)localObject11).width;
      label2517:
      j = LayoutAttrsKt.getDp(22);
      if (((View)localObject10).getLayoutParams() == null) {
        break label2762;
      }
      ((View)localObject10).getLayoutParams().width = i;
      ((View)localObject10).getLayoutParams().height = j;
      label2549:
      ((ImageView)localObject1).setImageResource(2130840944);
      ((ImageView)localObject1).setVisibility(0);
      paramContext.addView((View)localObject1);
      paramContext = Unit.INSTANCE;
      localObject10 = (ViewGroup)localObject9;
      localObject11 = new TextView(((ViewGroup)localObject10).getContext());
      ((TextView)localObject11).setTag(localObject10);
      paramContext = Unit.INSTANCE;
      ((TextView)localObject11).setId(2131371031);
      localView = (View)localObject11;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2782;
      }
      i = paramContext.width;
      label2636:
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2791;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    label2737:
    label2757:
    label2762:
    label2782:
    label2791:
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
        break label2804;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2804;
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
      ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label2492;
      i = 0;
      break label2517;
      ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label2549;
      i = localView.getWidth();
      break label2636;
    }
    paramContext = Unit.INSTANCE;
    label2804:
    localLayoutParams.addRule(9, -1);
    paramContext = Unit.INSTANCE;
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    View localView = (View)localObject11;
    paramContext = localView.getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = localView.getLayoutParams();
      if (paramContext == null) {
        break label2953;
      }
    }
    label2953:
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
        break label2966;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label2966;
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
    paramContext = Unit.INSTANCE;
    label2966:
    localLayoutParams.addRule(11, -1);
    paramContext = Unit.INSTANCE;
    localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localObject1 = ((View)localObject11).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(-10);
      paramContext = Unit.INSTANCE;
    }
    localObject1 = ((View)localObject11).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.rightMargin = LayoutAttrsKt.getDp(-8);
      paramContext = Unit.INSTANCE;
    }
    ((TextView)localObject11).setVisibility(0);
    ((ViewGroup)localObject10).addView((View)localObject11);
    paramContext = Unit.INSTANCE;
    ((ViewGroup)localObject8).addView((View)localObject9);
    paramContext = Unit.INSTANCE;
    localObject8 = (ViewGroup)localObject7;
    Object localObject9 = new ImageView(((ViewGroup)localObject8).getContext());
    ((ImageView)localObject9).setTag(localObject8);
    paramContext = Unit.INSTANCE;
    ((ImageView)localObject9).setId(2131371026);
    paramContext = (View)localObject9;
    j = LayoutAttrsKt.getDp(22);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label3378;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label3203:
      paramContext = (View)localObject9;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label3397;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label3226:
      j = LayoutAttrsKt.getDp(22);
      if (paramContext.getLayoutParams() == null) {
        break label3402;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label3255:
      localObject10 = (View)localObject9;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3421;
      }
      i = paramContext.width;
      label3277:
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3430;
      }
    }
    label3378:
    label3397:
    label3402:
    label3421:
    label3430:
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
        break label3443;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label3443;
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
      break label3203;
      i = 0;
      break label3226;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label3255;
      i = ((View)localObject10).getWidth();
      break label3277;
    }
    paramContext = Unit.INSTANCE;
    label3443:
    ((RelativeLayout.LayoutParams)localObject11).addRule(11, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject10 = (View)localObject9;
    paramContext = ((View)localObject10).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject10).getLayoutParams();
      if (paramContext == null) {
        break label3592;
      }
    }
    label3592:
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
        break label3605;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label3605;
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
    paramContext = Unit.INSTANCE;
    label3605:
    ((RelativeLayout.LayoutParams)localObject11).addRule(13, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject1 = ((View)localObject9).getLayoutParams();
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
    ((ImageView)localObject9).setImageResource(2130840931);
    ((ViewGroup)localObject8).addView((View)localObject9);
    paramContext = Unit.INSTANCE;
    ((ViewGroup)localObject6).addView((View)localObject7);
    paramContext = Unit.INSTANCE;
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    paramContext = (ViewGroup)localObject3;
    localObject1 = new DragRecyclerView(paramContext.getContext());
    ((DragRecyclerView)localObject1).setTag(paramContext);
    Object localObject4 = Unit.INSTANCE;
    ((DragRecyclerView)localObject1).setId(2131370778);
    localObject4 = (View)localObject1;
    Object localObject5 = ((View)localObject4).getLayoutParams();
    if (localObject5 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject5).height;
      if (((View)localObject4).getLayoutParams() == null) {
        break label4171;
      }
      ((View)localObject4).getLayoutParams().width = -1;
      ((View)localObject4).getLayoutParams().height = i;
      label3809:
      localObject4 = (View)localObject1;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4191;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label3834:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4196;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
      label3860:
      ((ViewGroup)localObject1).setClipChildren(false);
      ((ViewGroup)localObject1).setClipToPadding(false);
      ((DragRecyclerView)localObject1).setOverScrollMode(2);
      localObject4 = (View)localObject1;
      ((View)localObject4).setPadding(LayoutAttrsKt.getDp(20), ((View)localObject4).getPaddingTop(), ((View)localObject4).getPaddingRight(), ((View)localObject4).getPaddingBottom());
      localObject4 = (View)localObject1;
      ((View)localObject4).setPadding(((View)localObject4).getPaddingLeft(), ((View)localObject4).getPaddingTop(), LayoutAttrsKt.getDp(20), ((View)localObject4).getPaddingBottom());
      paramContext.addView((View)localObject1);
      paramContext = Unit.INSTANCE;
      ((ViewGroup)localObject2).addView((View)localObject3);
      paramContext = Unit.INSTANCE;
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new LinearLayout(paramContext.getContext());
      ((LinearLayout)localObject1).setTag(paramContext);
      localObject2 = Unit.INSTANCE;
      ((LinearLayout)localObject1).setId(2131371078);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4216;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label4038:
      if (((View)localObject2).getLayoutParams() == null) {
        break label4221;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label4064:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4241;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label4089:
      j = LayoutAttrsKt.getDp(65);
      if (((View)localObject2).getLayoutParams() == null) {
        break label4246;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getTag();
      if (!(localObject3 instanceof FrameLayout)) {
        break label4716;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 != null) {
        break label4266;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      i = 0;
      break;
      label4171:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label3809;
      label4191:
      i = 0;
      break label3834;
      label4196:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label3860;
      label4216:
      i = 0;
      break label4038;
      label4221:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label4064;
      label4241:
      i = 0;
      break label4089;
      label4246:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4266:
    Object localObject3 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).gravity = 80;
    localObject4 = Unit.INSTANCE;
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    Object localObject2 = (View)localObject1;
    localObject3 = Integer.valueOf(2130838779);
    if ((localObject3 instanceof String))
    {
      ((View)localObject2).setBackgroundColor(Color.parseColor((String)localObject3));
      label4338:
      ((LinearLayout)localObject1).setGravity(17);
      localObject2 = (ViewGroup)localObject1;
      localObject3 = new ImageView(((ViewGroup)localObject2).getContext());
      ((ImageView)localObject3).setTag(localObject2);
      localObject4 = Unit.INSTANCE;
      ((ImageView)localObject3).setId(2131371079);
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4802;
      }
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label4411:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4807;
      }
      ((View)localObject4).getLayoutParams().width = -2;
      ((View)localObject4).getLayoutParams().height = i;
      label4438:
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label4828;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label4463:
      if (((View)localObject4).getLayoutParams() == null) {
        break label4833;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -1;
      label4489:
      ((ImageView)localObject3).setImageResource(2130840932);
      ((ViewGroup)localObject2).addView((View)localObject3);
      localObject2 = Unit.INSTANCE;
      paramContext.addView((View)localObject1);
      paramContext = Unit.INSTANCE;
      paramContext = (ViewGroup)localFrameLayout;
      localObject1 = new LinearLayout(paramContext.getContext());
      ((LinearLayout)localObject1).setTag(paramContext);
      localObject2 = Unit.INSTANCE;
      ((LinearLayout)localObject1).setId(2131365374);
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4853;
      }
      i = ((ViewGroup.LayoutParams)localObject3).height;
      label4588:
      if (((View)localObject2).getLayoutParams() == null) {
        break label4858;
      }
      ((View)localObject2).getLayoutParams().width = -1;
      ((View)localObject2).getLayoutParams().height = i;
      label4614:
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        break label4878;
      }
      i = ((ViewGroup.LayoutParams)localObject3).width;
      label4639:
      j = LayoutAttrsKt.getDp(65);
      if (((View)localObject2).getLayoutParams() == null) {
        break label4883;
      }
      ((View)localObject2).getLayoutParams().width = i;
      ((View)localObject2).getLayoutParams().height = j;
    }
    for (;;)
    {
      localObject2 = (View)localObject1;
      localObject3 = ((View)localObject2).getTag();
      if (!(localObject3 instanceof FrameLayout)) {
        break label5689;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 != null) {
        break label4903;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      label4716:
      if (!(localObject3 instanceof LinearLayout)) {
        break;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
      ((LinearLayout.LayoutParams)localObject3).gravity = 80;
      localObject4 = Unit.INSTANCE;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break;
      ((View)localObject2).setBackgroundResource(((Number)localObject3).intValue());
      break label4338;
      label4802:
      i = 0;
      break label4411;
      label4807:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label4438;
      label4828:
      i = 0;
      break label4463;
      label4833:
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -1));
      break label4489;
      label4853:
      i = 0;
      break label4588;
      label4858:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-1, i));
      break label4614;
      label4878:
      i = 0;
      break label4639;
      label4883:
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
    }
    label4903:
    localObject3 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).gravity = 80;
    localObject4 = Unit.INSTANCE;
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = (View)localObject1;
    localObject3 = Integer.valueOf(2130840933);
    if ((localObject3 instanceof String))
    {
      ((View)localObject2).setBackgroundColor(Color.parseColor((String)localObject3));
      label4975:
      ((LinearLayout)localObject1).setGravity(17);
      ((LinearLayout)localObject1).setVisibility(8);
      localObject2 = (ViewGroup)localObject1;
      localObject3 = new TextView(((ViewGroup)localObject2).getContext());
      ((TextView)localObject3).setTag(localObject2);
      localObject4 = Unit.INSTANCE;
      ((TextView)localObject3).setId(2131365366);
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label5775;
      }
      i = ((ViewGroup.LayoutParams)localObject5).height;
      label5055:
      if (((View)localObject4).getLayoutParams() == null) {
        break label5780;
      }
      ((View)localObject4).getLayoutParams().width = -2;
      ((View)localObject4).getLayoutParams().height = i;
      label5082:
      localObject4 = (View)localObject3;
      localObject5 = ((View)localObject4).getLayoutParams();
      if (localObject5 == null) {
        break label5801;
      }
      i = ((ViewGroup.LayoutParams)localObject5).width;
      label5107:
      if (((View)localObject4).getLayoutParams() == null) {
        break label5806;
      }
      ((View)localObject4).getLayoutParams().width = i;
      ((View)localObject4).getLayoutParams().height = -2;
      label5134:
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setText(2131710881);
      ((TextView)localObject3).setCompoundDrawables(((TextView)localObject3).getContext().getDrawable(2130840935), null, null, null);
      ((TextView)localObject3).setCompoundDrawablePadding(LayoutAttrsKt.getDp(12));
      if (!("#FFFFFF" instanceof Integer)) {
        break label5827;
      }
      ((TextView)localObject3).setTextColor(((TextView)localObject3).getResources().getColor(((Number)"#FFFFFF").intValue()));
      label5209:
      ((ViewGroup)localObject2).addView((View)localObject3);
      localObject2 = Unit.INSTANCE;
      paramContext.addView((View)localObject1);
      paramContext = Unit.INSTANCE;
      localObject2 = (ViewGroup)localFrameLayout;
      localObject3 = new RelativeLayout(((ViewGroup)localObject2).getContext());
      ((RelativeLayout)localObject3).setTag(localObject2);
      paramContext = Unit.INSTANCE;
      ((RelativeLayout)localObject3).setId(2131371036);
      paramContext = (View)localObject3;
      j = LayoutAttrsKt.getDp(66);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5841;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5306:
      if (paramContext.getLayoutParams() == null) {
        break label5846;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5329:
      paramContext = (View)localObject3;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5865;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5352:
      if (paramContext.getLayoutParams() == null) {
        break label5870;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = -2;
      label5376:
      ((RelativeLayout)localObject3).setVisibility(4);
      localObject4 = (ViewGroup)localObject3;
      localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
      ((ImageView)localObject5).setTag(localObject4);
      paramContext = Unit.INSTANCE;
      ((ImageView)localObject5).setId(2131371035);
      paramContext = (View)localObject5;
      j = LayoutAttrsKt.getDp(48);
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5890;
      }
      i = ((ViewGroup.LayoutParams)localObject1).height;
      label5451:
      if (paramContext.getLayoutParams() == null) {
        break label5895;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label5474:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label5914;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label5497:
      j = LayoutAttrsKt.getDp(48);
      if (paramContext.getLayoutParams() == null) {
        break label5919;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label5526:
      localObject1 = ((View)localObject5).getLayoutParams();
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        paramContext = null;
      }
      paramContext = (ViewGroup.MarginLayoutParams)paramContext;
      if (paramContext != null)
      {
        paramContext.topMargin = LayoutAttrsKt.getDp(8);
        paramContext = Unit.INSTANCE;
      }
      localObject6 = (View)localObject5;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label5938;
      }
      i = paramContext.width;
      label5593:
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label5947;
      }
    }
    label5689:
    label5947:
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
        break label5960;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label5960;
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
      if (!(localObject3 instanceof LinearLayout)) {
        break;
      }
      localObject3 = ((View)localObject2).getLayoutParams();
      if (localObject3 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject3 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject3);
      ((LinearLayout.LayoutParams)localObject3).gravity = 80;
      localObject4 = Unit.INSTANCE;
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      break;
      ((View)localObject2).setBackgroundResource(((Number)localObject3).intValue());
      break label4975;
      i = 0;
      break label5055;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, i));
      break label5082;
      i = 0;
      break label5107;
      ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label5134;
      label5827:
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFFFF"));
      break label5209;
      label5841:
      i = 0;
      break label5306;
      label5846:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5329;
      label5865:
      i = 0;
      break label5352;
      label5870:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, -2));
      break label5376;
      i = 0;
      break label5451;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label5474;
      i = 0;
      break label5497;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label5526;
      i = ((View)localObject6).getWidth();
      break label5593;
    }
    label5775:
    label5780:
    label5801:
    label5806:
    label5938:
    paramContext = Unit.INSTANCE;
    label5890:
    label5895:
    label5914:
    label5919:
    label5960:
    ((RelativeLayout.LayoutParams)localObject7).addRule(14, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    ((ImageView)localObject5).setImageResource(2130848415);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    localObject4 = (ViewGroup)localObject3;
    localObject5 = new ImageView(((ViewGroup)localObject4).getContext());
    ((ImageView)localObject5).setTag(localObject4);
    paramContext = Unit.INSTANCE;
    ((ImageView)localObject5).setId(2131371037);
    paramContext = (View)localObject5;
    j = LayoutAttrsKt.getDp(15);
    localObject1 = paramContext.getLayoutParams();
    if (localObject1 != null)
    {
      i = ((ViewGroup.LayoutParams)localObject1).height;
      if (paramContext.getLayoutParams() == null) {
        break label6271;
      }
      paramContext.getLayoutParams().width = j;
      paramContext.getLayoutParams().height = i;
      label6096:
      paramContext = (View)localObject5;
      localObject1 = paramContext.getLayoutParams();
      if (localObject1 == null) {
        break label6290;
      }
      i = ((ViewGroup.LayoutParams)localObject1).width;
      label6119:
      j = LayoutAttrsKt.getDp(15);
      if (paramContext.getLayoutParams() == null) {
        break label6295;
      }
      paramContext.getLayoutParams().width = i;
      paramContext.getLayoutParams().height = j;
      label6148:
      localObject6 = (View)localObject5;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6314;
      }
      i = paramContext.width;
      label6170:
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6323;
      }
    }
    label6290:
    label6295:
    label6314:
    label6323:
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
        break label6336;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label6336;
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
      label6271:
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(j, i));
      break label6096;
      i = 0;
      break label6119;
      paramContext.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
      break label6148;
      i = ((View)localObject6).getWidth();
      break label6170;
    }
    paramContext = Unit.INSTANCE;
    label6336:
    ((RelativeLayout.LayoutParams)localObject7).addRule(9, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    Object localObject6 = (View)localObject5;
    paramContext = ((View)localObject6).getLayoutParams();
    if (paramContext != null)
    {
      i = paramContext.width;
      paramContext = ((View)localObject6).getLayoutParams();
      if (paramContext == null) {
        break label6485;
      }
    }
    label6485:
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
        break label6498;
      }
      paramContext = paramContext.getRules();
      if (paramContext == null) {
        break label6498;
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
    paramContext = Unit.INSTANCE;
    label6498:
    ((RelativeLayout.LayoutParams)localObject7).addRule(11, -1);
    paramContext = Unit.INSTANCE;
    ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
    localObject1 = ((View)localObject5).getLayoutParams();
    paramContext = (Context)localObject1;
    if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
      paramContext = null;
    }
    paramContext = (ViewGroup.MarginLayoutParams)paramContext;
    if (paramContext != null)
    {
      paramContext.topMargin = LayoutAttrsKt.getDp(4);
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
      paramContext.rightMargin = LayoutAttrsKt.getDp(4);
      paramContext = Unit.INSTANCE;
    }
    ((ImageView)localObject5).setImageResource(2130840938);
    ((ViewGroup)localObject4).addView((View)localObject5);
    paramContext = Unit.INSTANCE;
    ((ViewGroup)localObject2).addView((View)localObject3);
    paramContext = Unit.INSTANCE;
    return (View)localFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.DesktopLayoutKt
 * JD-Core Version:    0.7.0.1
 */