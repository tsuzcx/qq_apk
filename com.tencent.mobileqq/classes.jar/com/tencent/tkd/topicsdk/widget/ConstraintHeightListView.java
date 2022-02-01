package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ConstraintHeightListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mMaxHeight", "", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class ConstraintHeightListView
  extends ListView
{
  private float a = 100.0F;
  
  public ConstraintHeightListView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.a;
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "array");
    int j = paramContext.getIndexCount();
    while (i < j)
    {
      int k = paramContext.getIndex(i);
      if (k == R.styleable.b) {
        this.a = paramContext.getDimension(k, -1.0F);
      }
      i += 1;
    }
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = getMeasuredHeight();
    float f2 = this.a;
    if ((f1 > f2) && (f2 > -1)) {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ConstraintHeightListView
 * JD-Core Version:    0.7.0.1
 */