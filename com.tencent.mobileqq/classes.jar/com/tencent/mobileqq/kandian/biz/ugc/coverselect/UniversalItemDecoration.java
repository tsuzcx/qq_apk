package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.util.SparseArray;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class UniversalItemDecoration
  extends RecyclerView.ItemDecoration
{
  private final Paint a = new Paint(1);
  private final SparseArray<UniversalItemDecoration.Decoration> b = new SparseArray();
  
  public UniversalItemDecoration()
  {
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public static final UniversalItemDecoration.Decoration a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public static final UniversalItemDecoration.Decoration a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    UniversalItemDecoration.Decoration localDecoration = new UniversalItemDecoration.Decoration();
    localDecoration.e = paramInt5;
    paramInt5 = (paramInt3 - 1) * paramInt4 / paramInt3;
    int i = paramInt4 - paramInt5;
    localDecoration.c = paramInt4;
    if (paramInt1 % paramInt3 == 0)
    {
      localDecoration.b = paramInt5;
    }
    else if ((paramInt1 + 1) % paramInt3 == 0)
    {
      localDecoration.a = paramInt5;
    }
    else
    {
      localDecoration.a = i;
      localDecoration.b = i;
    }
    if (paramInt1 / paramInt3 == paramInt2 / paramInt3)
    {
      localDecoration.d = paramInt4;
      return localDecoration;
    }
    localDecoration.d = 0;
    return localDecoration;
  }
  
  @Nullable
  public abstract UniversalItemDecoration.Decoration a(int paramInt, @NotNull RecyclerView paramRecyclerView);
  
  public void getItemOffsets(@NotNull Rect paramRect, @NotNull View paramView, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    paramView.setTag(Integer.valueOf(i));
    paramView = a(i, paramRecyclerView);
    if (paramView != null)
    {
      paramRect.set(paramView.a, paramView.c, paramView.b, paramView.d);
      paramRect = paramView;
    }
    else
    {
      paramRect = new UniversalItemDecoration.Decoration();
    }
    this.b.put(i, paramRect);
  }
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      int k = ((Integer)paramState.getTag()).intValue();
      UniversalItemDecoration.Decoration localDecoration = (UniversalItemDecoration.Decoration)this.b.get(k);
      this.a.setColor(localDecoration.e);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramState.getLayoutParams();
      k = paramState.getBottom() + localLayoutParams.bottomMargin;
      int m = paramState.getLeft() - localLayoutParams.leftMargin;
      int n = paramState.getRight() + localLayoutParams.rightMargin;
      int i1 = paramState.getTop() - localLayoutParams.topMargin;
      float f2 = m - localDecoration.a;
      float f1 = k;
      paramCanvas.drawRect(f2, f1, localDecoration.b + n, k + localDecoration.d, this.a);
      f2 = m - localDecoration.a;
      float f3 = i1 - localDecoration.c;
      float f4 = localDecoration.b + n;
      float f5 = i1;
      paramCanvas.drawRect(f2, f3, f4, f5, this.a);
      paramCanvas.drawRect(m - localDecoration.a, f5, m, f1, this.a);
      paramCanvas.drawRect(n, f5, n + localDecoration.b, f1, this.a);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.UniversalItemDecoration
 * JD-Core Version:    0.7.0.1
 */