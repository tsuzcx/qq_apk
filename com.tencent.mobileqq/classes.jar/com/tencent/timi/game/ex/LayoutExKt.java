package com.tencent.timi.game.ex;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dp", "", "", "getDp", "(F)I", "(I)I", "dpf", "getDpf", "(F)F", "(I)F", "match_parent", "Landroid/view/View;", "getMatch_parent", "(Landroid/view/View;)I", "value", "paddings", "getPaddings", "setPaddings", "(Landroid/view/View;I)V", "textSizeDp", "Landroid/widget/TextView;", "getTextSizeDp", "(Landroid/widget/TextView;)F", "setTextSizeDp", "(Landroid/widget/TextView;F)V", "wrap_content", "getWrap_content", "frameLayout", "Landroid/widget/FrameLayout;", "Landroid/view/ViewGroup;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "imageView", "Landroid/widget/ImageView;", "lParams", "Landroid/widget/FrameLayout$LayoutParams;", "w", "h", "Landroid/widget/LinearLayout$LayoutParams;", "Landroid/widget/LinearLayout;", "Landroid/widget/RelativeLayout$LayoutParams;", "Landroid/widget/RelativeLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "linearLayout", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "relativeLayout", "textView", "view", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class LayoutExKt
{
  public static final float a(int paramInt)
  {
    float f = paramInt;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return Utils.b(f, localBaseApplication.getResources());
  }
  
  public static final int a(float paramFloat)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return Utils.a(paramFloat, localBaseApplication.getResources());
  }
  
  public static final int a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$wrap_content");
    return -2;
  }
  
  public static final void a(@NotNull TextView paramTextView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "$this$textSizeDp");
    paramTextView.setTextSize(1, paramFloat);
  }
  
  public static final float b(float paramFloat)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return Utils.b(paramFloat, localBaseApplication.getResources());
  }
  
  public static final int b(int paramInt)
  {
    float f = paramInt;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplication.getContext()");
    return Utils.a(f, localBaseApplication.getResources());
  }
  
  public static final int b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$match_parent");
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ex.LayoutExKt
 * JD-Core Version:    0.7.0.1
 */