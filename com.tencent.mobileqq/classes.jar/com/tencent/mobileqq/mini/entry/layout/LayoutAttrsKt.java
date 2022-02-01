package com.tencent.mobileqq.mini.entry.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
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
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.mini.entry.desktop.widget.DragRecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"HORIZONTAL", "", "VERTICAL", "value", "", "_background", "Landroid/view/View;", "get_background", "(Landroid/view/View;)Ljava/lang/Object;", "set_background", "(Landroid/view/View;Ljava/lang/Object;)V", "", "_clipChildren", "Landroid/view/ViewGroup;", "get_clipChildren", "(Landroid/view/ViewGroup;)Z", "set_clipChildren", "(Landroid/view/ViewGroup;Z)V", "_clipPadding", "get_clipPadding", "set_clipPadding", "_text", "Landroid/widget/TextView;", "get_text", "(Landroid/widget/TextView;)Ljava/lang/Object;", "set_text", "(Landroid/widget/TextView;Ljava/lang/Object;)V", "dp", "getDp", "(I)I", "", "", "(Ljava/lang/Number;)F", "drawableLeft", "getDrawableLeft", "(Landroid/widget/TextView;)I", "setDrawableLeft", "(Landroid/widget/TextView;I)V", "drawablePadding", "getDrawablePadding", "setDrawablePadding", "layout_above", "getLayout_above", "(Landroid/view/View;)I", "setLayout_above", "(Landroid/view/View;I)V", "layout_alignParentLeft", "getLayout_alignParentLeft", "(Landroid/view/View;)Z", "setLayout_alignParentLeft", "(Landroid/view/View;Z)V", "layout_alignParentRight", "getLayout_alignParentRight", "setLayout_alignParentRight", "layout_alignParentTop", "getLayout_alignParentTop", "setLayout_alignParentTop", "layout_below", "getLayout_below", "setLayout_below", "layout_centerHorizontal", "getLayout_centerHorizontal", "setLayout_centerHorizontal", "layout_centerInParent", "getLayout_centerInParent", "setLayout_centerInParent", "layout_gravity", "getLayout_gravity", "setLayout_gravity", "layout_height", "getLayout_height", "setLayout_height", "layout_marginBottom", "getLayout_marginBottom", "setLayout_marginBottom", "layout_marginLeft", "getLayout_marginLeft", "setLayout_marginLeft", "layout_marginRight", "getLayout_marginRight", "setLayout_marginRight", "layout_marginTop", "getLayout_marginTop", "setLayout_marginTop", "layout_toLeftOf", "getLayout_toLeftOf", "setLayout_toLeftOf", "layout_toRightOf", "getLayout_toRightOf", "setLayout_toRightOf", "layout_weight", "Landroid/widget/LinearLayout;", "getLayout_weight", "(Landroid/widget/LinearLayout;)F", "setLayout_weight", "(Landroid/widget/LinearLayout;F)V", "layout_width", "getLayout_width", "setLayout_width", "padding_bottom", "getPadding_bottom", "setPadding_bottom", "padding_left", "getPadding_left", "setPadding_left", "padding_right", "getPadding_right", "setPadding_right", "padding_top", "getPadding_top", "setPadding_top", "sp", "getSp", "(I)F", "src", "Landroid/widget/ImageView;", "getSrc", "(Landroid/widget/ImageView;)I", "setSrc", "(Landroid/widget/ImageView;I)V", "textColor", "getTextColor", "setTextColor", "DragRecyclerView", "Lcom/tencent/mobileqq/mini/entry/desktop/widget/DragRecyclerView;", "build", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "FrameLayout", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "ImageView", "LinearLayout", "RelativeLayout", "Landroid/widget/RelativeLayout;", "TextView", "View", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class LayoutAttrsKt
{
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;
  
  @NotNull
  public static final DragRecyclerView DragRecyclerView(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super DragRecyclerView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$DragRecyclerView");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    DragRecyclerView localDragRecyclerView = new DragRecyclerView(paramViewGroup.getContext());
    localDragRecyclerView.setTag(paramViewGroup);
    paramFunction1.invoke(localDragRecyclerView);
    paramViewGroup.addView((View)localDragRecyclerView);
    return localDragRecyclerView;
  }
  
  @NotNull
  public static final FrameLayout FrameLayout(@NotNull Context paramContext, @NotNull Function1<? super FrameLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$FrameLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    paramContext = new FrameLayout(paramContext);
    paramFunction1.invoke(paramContext);
    return paramContext;
  }
  
  @NotNull
  public static final FrameLayout FrameLayout(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super FrameLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$FrameLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    FrameLayout localFrameLayout = new FrameLayout(paramViewGroup.getContext());
    localFrameLayout.setTag(paramViewGroup);
    paramFunction1.invoke(localFrameLayout);
    paramViewGroup.addView((View)localFrameLayout);
    return localFrameLayout;
  }
  
  @NotNull
  public static final ImageView ImageView(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super ImageView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$ImageView");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    ImageView localImageView = new ImageView(paramViewGroup.getContext());
    localImageView.setTag(paramViewGroup);
    paramFunction1.invoke(localImageView);
    paramViewGroup.addView((View)localImageView);
    return localImageView;
  }
  
  @NotNull
  public static final LinearLayout LinearLayout(@NotNull Context paramContext, @NotNull Function1<? super LinearLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$LinearLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    paramContext = new LinearLayout(paramContext);
    paramFunction1.invoke(paramContext);
    return paramContext;
  }
  
  @NotNull
  public static final LinearLayout LinearLayout(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super LinearLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$LinearLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setTag(paramViewGroup);
    paramFunction1.invoke(localLinearLayout);
    paramViewGroup.addView((View)localLinearLayout);
    return localLinearLayout;
  }
  
  @NotNull
  public static final RelativeLayout RelativeLayout(@NotNull Context paramContext, @NotNull Function1<? super RelativeLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "$this$RelativeLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    paramContext = new RelativeLayout(paramContext);
    paramFunction1.invoke(paramContext);
    return paramContext;
  }
  
  @NotNull
  public static final RelativeLayout RelativeLayout(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super RelativeLayout, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$RelativeLayout");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    RelativeLayout localRelativeLayout = new RelativeLayout(paramViewGroup.getContext());
    localRelativeLayout.setTag(paramViewGroup);
    paramFunction1.invoke(localRelativeLayout);
    paramViewGroup.addView((View)localRelativeLayout);
    return localRelativeLayout;
  }
  
  @NotNull
  public static final TextView TextView(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super TextView, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$TextView");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    TextView localTextView = new TextView(paramViewGroup.getContext());
    localTextView.setTag(paramViewGroup);
    paramFunction1.invoke(localTextView);
    paramViewGroup.addView((View)localTextView);
    return localTextView;
  }
  
  @NotNull
  public static final View View(@NotNull ViewGroup paramViewGroup, @NotNull Function1<? super View, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$View");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "build");
    View localView = new View(paramViewGroup.getContext());
    localView.setTag(paramViewGroup);
    paramFunction1.invoke(localView);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public static final float getDp(@NotNull Number paramNumber)
  {
    Intrinsics.checkParameterIsNotNull(paramNumber, "$this$dp");
    float f = ((Float)paramNumber).floatValue();
    paramNumber = Resources.getSystem();
    Intrinsics.checkExpressionValueIsNotNull(paramNumber, "Resources.getSystem()");
    return TypedValue.applyDimension(1, f, paramNumber.getDisplayMetrics());
  }
  
  public static final int getDp(int paramInt)
  {
    float f = paramInt;
    Resources localResources = Resources.getSystem();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "Resources.getSystem()");
    return (int)TypedValue.applyDimension(1, f, localResources.getDisplayMetrics());
  }
  
  public static final int getDrawableLeft(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$drawableLeft");
    return 0;
  }
  
  public static final int getDrawablePadding(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$drawablePadding");
    return 0;
  }
  
  public static final int getLayout_above(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_above");
    return 0;
  }
  
  public static final boolean getLayout_alignParentLeft(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentLeft");
    return false;
  }
  
  public static final boolean getLayout_alignParentRight(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentRight");
    return false;
  }
  
  public static final boolean getLayout_alignParentTop(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentTop");
    return false;
  }
  
  public static final int getLayout_below(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_below");
    return 0;
  }
  
  public static final boolean getLayout_centerHorizontal(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_centerHorizontal");
    return false;
  }
  
  public static final boolean getLayout_centerInParent(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_centerInParent");
    return false;
  }
  
  public static final int getLayout_gravity(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_gravity");
    return 0;
  }
  
  public static final int getLayout_height(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_height");
    return 0;
  }
  
  public static final int getLayout_marginBottom(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginBottom");
    return 0;
  }
  
  public static final int getLayout_marginLeft(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginLeft");
    return 0;
  }
  
  public static final int getLayout_marginRight(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginRight");
    return 0;
  }
  
  public static final int getLayout_marginTop(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginTop");
    return 0;
  }
  
  public static final int getLayout_toLeftOf(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_toLeftOf");
    return 0;
  }
  
  public static final int getLayout_toRightOf(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_toRightOf");
    return 0;
  }
  
  public static final float getLayout_weight(@NotNull LinearLayout paramLinearLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "$this$layout_weight");
    return 1.0F;
  }
  
  public static final int getLayout_width(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_width");
    return paramView.getLayoutParams().width;
  }
  
  public static final int getPadding_bottom(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_bottom");
    return paramView.getPaddingBottom();
  }
  
  public static final int getPadding_left(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_left");
    return paramView.getPaddingLeft();
  }
  
  public static final int getPadding_right(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_right");
    return paramView.getPaddingRight();
  }
  
  public static final int getPadding_top(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_top");
    return paramView.getPaddingTop();
  }
  
  public static final float getSp(int paramInt)
  {
    float f = paramInt;
    Resources localResources = Resources.getSystem();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "Resources.getSystem()");
    return TypedValue.applyDimension(2, f, localResources.getDisplayMetrics());
  }
  
  public static final int getSrc(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "$this$src");
    return -1;
  }
  
  @NotNull
  public static final Object getTextColor(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$textColor");
    return "";
  }
  
  @NotNull
  public static final Object get_background(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$_background");
    return "";
  }
  
  public static final boolean get_clipChildren(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$_clipChildren");
    return true;
  }
  
  public static final boolean get_clipPadding(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$_clipPadding");
    return false;
  }
  
  @Nullable
  public static final Object get_text(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$_text");
    paramTextView = paramTextView.getText();
    if (paramTextView != null) {
      return paramTextView.toString();
    }
    return null;
  }
  
  @RequiresApi(21)
  public static final void setDrawableLeft(@NotNull TextView paramTextView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$drawableLeft");
    paramTextView.setCompoundDrawables(paramTextView.getContext().getDrawable(paramInt), null, null, null);
  }
  
  @RequiresApi(21)
  public static final void setDrawablePadding(@NotNull TextView paramTextView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$drawablePadding");
    paramTextView.setCompoundDrawablePadding(getDp(paramInt));
  }
  
  public static final void setLayout_above(@NotNull View paramView, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_above");
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label145;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label145:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label153;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label153;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label153:
    localLayoutParams1.addRule(2, paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_alignParentLeft(@NotNull View paramView, boolean paramBoolean)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentLeft");
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label150;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label150:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label158;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label158;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label158:
    localLayoutParams1.addRule(9, -1);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_alignParentRight(@NotNull View paramView, boolean paramBoolean)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentRight");
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label150;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label150:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label158;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label158;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label158:
    localLayoutParams1.addRule(11, -1);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_alignParentTop(@NotNull View paramView, boolean paramBoolean)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_alignParentTop");
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label150;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label150:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label158;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label158;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label158:
    localLayoutParams1.addRule(9, -1);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_below(@NotNull View paramView, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_below");
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label145;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label145:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label153;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label153;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label153:
    localLayoutParams1.addRule(3, paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_centerHorizontal(@NotNull View paramView, boolean paramBoolean)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_centerHorizontal");
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label150;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label150:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label158;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label158;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label158:
    localLayoutParams1.addRule(14, -1);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_centerInParent(@NotNull View paramView, boolean paramBoolean)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_centerInParent");
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label150;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label150:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label158;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label158;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label158:
    localLayoutParams1.addRule(13, -1);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_gravity(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_gravity");
    Object localObject = paramView.getTag();
    if ((localObject instanceof FrameLayout))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
      localObject = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
      ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    while (!(localObject instanceof LinearLayout)) {
      return;
    }
    localObject = paramView.getLayoutParams();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    localObject = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject);
    ((LinearLayout.LayoutParams)localObject).gravity = paramInt;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public static final void setLayout_height(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_height");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null) {}
    int j;
    for (int i = localLayoutParams.width;; i = 0)
    {
      j = paramInt;
      if (paramInt > 0) {
        j = getDp(paramInt);
      }
      if (paramView.getLayoutParams() == null) {
        break;
      }
      paramView.getLayoutParams().width = i;
      paramView.getLayoutParams().height = j;
      return;
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, j));
  }
  
  public static final void setLayout_marginBottom(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginBottom");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.bottomMargin = getDp(paramInt);
    }
  }
  
  public static final void setLayout_marginLeft(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginLeft");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.leftMargin = getDp(paramInt);
    }
  }
  
  public static final void setLayout_marginRight(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginRight");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.rightMargin = getDp(paramInt);
    }
  }
  
  public static final void setLayout_marginTop(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_marginTop");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      paramView.topMargin = getDp(paramInt);
    }
  }
  
  public static final void setLayout_toLeftOf(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_toLeftOf");
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label141;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label141:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label149;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label149;
      }
      int k = localObject.length;
      j = 0;
      i = 0;
      while (j < k)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label149:
    localLayoutParams1.addRule(0, paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_toRightOf(@NotNull View paramView, int paramInt)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_toRightOf");
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramView.getLayoutParams();
      if (localObject == null) {
        break label145;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    label145:
    for (int j = ((ViewGroup.LayoutParams)localObject).height;; j = paramView.getHeight())
    {
      localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label153;
      }
      localObject = ((RelativeLayout.LayoutParams)localObject).getRules();
      if (localObject == null) {
        break label153;
      }
      int m = localObject.length;
      j = 0;
      i = k;
      while (j < m)
      {
        localLayoutParams1.addRule(i, localObject[j]);
        j += 1;
        i += 1;
      }
      i = paramView.getWidth();
      break;
    }
    label153:
    localLayoutParams1.addRule(1, paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
  }
  
  public static final void setLayout_weight(@NotNull LinearLayout paramLinearLayout, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "$this$layout_weight");
    Object localObject = paramLinearLayout.getLayoutParams();
    int j;
    label41:
    LinearLayout.LayoutParams localLayoutParams1;
    if (localObject != null)
    {
      i = ((ViewGroup.LayoutParams)localObject).width;
      localObject = paramLinearLayout.getLayoutParams();
      if (localObject == null) {
        break label116;
      }
      j = ((ViewGroup.LayoutParams)localObject).height;
      localLayoutParams1 = new LinearLayout.LayoutParams(i, j, paramFloat);
      ViewGroup.LayoutParams localLayoutParams = paramLinearLayout.getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams)) {
        localObject = null;
      }
      localObject = (LinearLayout.LayoutParams)localObject;
      if (localObject == null) {
        break label124;
      }
    }
    label116:
    label124:
    for (int i = ((LinearLayout.LayoutParams)localObject).gravity;; i = -1)
    {
      localLayoutParams1.gravity = i;
      paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams1);
      return;
      i = paramLinearLayout.getWidth();
      break;
      j = paramLinearLayout.getHeight();
      break label41;
    }
  }
  
  public static final void setLayout_width(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$layout_width");
    int i = paramInt;
    if (paramInt > 0) {
      i = getDp(paramInt);
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null) {}
    for (paramInt = localLayoutParams.height; paramView.getLayoutParams() != null; paramInt = 0)
    {
      paramView.getLayoutParams().width = i;
      paramView.getLayoutParams().height = paramInt;
      return;
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(i, paramInt));
  }
  
  public static final void setPadding_bottom(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_bottom");
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), getDp(paramInt));
  }
  
  public static final void setPadding_left(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_left");
    paramView.setPadding(getDp(paramInt), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static final void setPadding_right(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_right");
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), getDp(paramInt), paramView.getPaddingBottom());
  }
  
  public static final void setPadding_top(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$padding_top");
    paramView.setPadding(paramView.getPaddingLeft(), getDp(paramInt), paramView.getPaddingRight(), paramView.getPaddingBottom());
  }
  
  public static final void setSrc(@NotNull ImageView paramImageView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "$this$src");
    paramImageView.setImageResource(paramInt);
  }
  
  public static final void setTextColor(@NotNull TextView paramTextView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$textColor");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if ((paramObject instanceof Integer)) {
      paramTextView.setTextColor(paramTextView.getResources().getColor(((Number)paramObject).intValue()));
    }
    while (!(paramObject instanceof String)) {
      return;
    }
    paramTextView.setTextColor(Color.parseColor((String)paramObject));
  }
  
  public static final void set_background(@NotNull View paramView, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$_background");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    if ((paramObject instanceof String)) {
      paramView.setBackgroundColor(Color.parseColor((String)paramObject));
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    paramView.setBackgroundResource(((Number)paramObject).intValue());
  }
  
  public static final void set_clipChildren(@NotNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$_clipChildren");
    paramViewGroup.setClipChildren(paramBoolean);
  }
  
  public static final void set_clipPadding(@NotNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "$this$_clipPadding");
    paramViewGroup.setClipToPadding(paramBoolean);
  }
  
  public static final void set_text(@NotNull TextView paramTextView, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$_text");
    if ((paramObject instanceof Integer)) {
      paramTextView.setText(((Number)paramObject).intValue());
    }
    while (!(paramObject instanceof String)) {
      return;
    }
    paramTextView.setText((CharSequence)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt
 * JD-Core Version:    0.7.0.1
 */