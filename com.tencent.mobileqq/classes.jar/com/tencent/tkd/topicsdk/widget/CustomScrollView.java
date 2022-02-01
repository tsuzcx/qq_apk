package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/CustomScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxScrollViewHeight", "", "getMaxScrollViewHeight", "()I", "setMaxScrollViewHeight", "(I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CustomScrollView
  extends ScrollView
{
  private int a;
  
  public CustomScrollView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.a, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public final void setMaxScrollViewHeight(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.CustomScrollView
 * JD-Core Version:    0.7.0.1
 */