package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/FlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "allLinesView", "Ljava/util/ArrayList;", "", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "lineHeights", "", "maxLineCounts", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class FlowLayout
  extends ViewGroup
{
  private final ArrayList<List<View>> a = new ArrayList();
  private final int b = 3;
  private final ArrayList<Integer> c = new ArrayList();
  
  public FlowLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = ((Collection)this.a).size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      Object localObject1 = this.a.get(paramInt1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "allLinesView[i]");
      localObject1 = (List)localObject1;
      paramInt2 = getPaddingLeft();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        View localView = (View)((Iterator)localObject1).next();
        Object localObject2 = this.c.get(paramInt1);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "lineHeights[i]");
        paramInt4 = ((Number)localObject2).intValue();
        int i = localView.getMeasuredWidth() + paramInt2;
        localView.layout(paramInt2, paramInt4, i, localView.getMeasuredHeight() + paramInt4);
        paramInt2 = getPaddingLeft() + i;
      }
      getPaddingLeft();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.clear();
    this.c.clear();
    int j = getPaddingTop();
    List localList = (List)new ArrayList();
    int i = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i5 = getChildCount();
    int n = 0;
    int m = 0;
    int i1 = 0;
    int k = 0;
    while (n < i5)
    {
      View localView = getChildAt(n);
      measureChild(localView, paramInt1, paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      i2 = localView.getMeasuredHeight();
      int i6 = localView.getMeasuredWidth() + localView.getPaddingLeft() + getPaddingRight();
      int i4 = m + i6;
      if (i4 > i - getPaddingLeft() - getPaddingRight())
      {
        k = Math.max(k, m);
        m = localView.getPaddingRight() + i6;
        if (this.c.size() >= this.b)
        {
          i2 = m;
          break label303;
        }
        this.c.add(Integer.valueOf(j));
        i1 = j + (i1 + getPaddingTop());
        this.a.add(localList);
        localList = (List)new ArrayList();
        localList.add(localView);
        j = i2;
        i2 = i1;
      }
      else
      {
        m = Math.max(i1, i2);
        localList.add(localView);
        i1 = i4;
        i2 = j;
        j = m;
        m = i1;
      }
      n += 1;
      i1 = j;
      j = i2;
    }
    int i2 = m;
    label303:
    n = k;
    m = j;
    if (this.c.size() < this.b)
    {
      this.a.add(localList);
      n = Math.max(k, i2);
      this.c.add(Integer.valueOf(j));
      m = j + i1;
    }
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if (paramInt1 == 1073741824)
    {
      paramInt1 = i;
    }
    else
    {
      paramInt1 = getPaddingLeft();
      paramInt1 = getPaddingRight() + (n + paramInt1);
    }
    if (paramInt2 == 1073741824) {
      paramInt2 = i3;
    } else {
      paramInt2 = m + getPaddingTop() + getPaddingBottom();
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.FlowLayout
 * JD-Core Version:    0.7.0.1
 */