package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/widget/RIJBlackWhiteModeLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchDrawCanvas", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "drawCanvas", "dispatchDraw", "canvas", "draw", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public class RIJBlackWhiteModeLinearLayout
  extends LinearLayout
{
  private final Function1<Canvas, Unit> a = (Function1)new RIJBlackWhiteModeLinearLayout.drawCanvas.1(this);
  private final Function1<Canvas, Unit> b = (Function1)new RIJBlackWhiteModeLinearLayout.dispatchDrawCanvas.1(this);
  
  public RIJBlackWhiteModeLinearLayout(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public RIJBlackWhiteModeLinearLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RIJBlackWhiteModeLinearLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.b);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RIJBlackWhiteModeLinearLayout
 * JD-Core Version:    0.7.0.1
 */