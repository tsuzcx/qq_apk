package com.tencent.widget.itemtouchhelper;

import ammi;
import ammj;
import amml;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class ItemTouchHelper$Callback
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new ammi();
  private static final ItemTouchUIUtil jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil = new ItemTouchUIUtilImpl.Honeycomb();
  private static final Interpolator b = new ammj();
  private int jdField_a_of_type_Int = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil = new ItemTouchUIUtilImpl.Lollipop();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0xC0C0C;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i << 2;
    }
    return paramInt1 | i << 1 & 0xFFF3F3F3 | (i << 1 & 0xC0C0C) << 2;
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = paramRecyclerView.getResources().getDimensionPixelSize(2131559508);
    }
    return this.jdField_a_of_type_Int;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    return c(0, paramInt2 | paramInt1) | c(1, paramInt2) | c(2, paramInt1);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    return paramInt2 << paramInt1 * 8;
  }
  
  public float a(float paramFloat)
  {
    return paramFloat;
  }
  
  public float a(RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.5F;
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    float f1 = 1.0F;
    paramInt3 = a(paramRecyclerView);
    int i = Math.abs(paramInt2);
    int j = (int)Math.signum(paramInt2);
    float f2 = Math.min(1.0F, i * 1.0F / paramInt1);
    paramInt1 = (int)(paramInt3 * j * b.getInterpolation(f2));
    if (paramLong > 2000L) {}
    for (;;)
    {
      f2 = paramInt1;
      paramInt3 = (int)(jdField_a_of_type_AndroidViewAnimationInterpolator.getInterpolation(f1) * f2);
      paramInt1 = paramInt3;
      if (paramInt3 == 0)
      {
        if (paramInt2 <= 0) {
          break;
        }
        paramInt1 = 1;
      }
      return paramInt1;
      f1 = (float)paramLong / 2000.0F;
    }
    return -1;
  }
  
  public abstract int a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder);
  
  public long a(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    paramRecyclerView = paramRecyclerView.getItemAnimator();
    if (paramRecyclerView == null)
    {
      if (paramInt == 8) {
        return 200L;
      }
      return 250L;
    }
    if (paramInt == 8) {
      return paramRecyclerView.getMoveDuration();
    }
    return paramRecyclerView.getRemoveDuration();
  }
  
  public RecyclerView.ViewHolder a(RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt1, int paramInt2)
  {
    int m = paramViewHolder.itemView.getWidth();
    int n = paramViewHolder.itemView.getHeight();
    Object localObject2 = null;
    int i = -1;
    int i1 = paramInt1 - paramViewHolder.itemView.getLeft();
    int i2 = paramInt2 - paramViewHolder.itemView.getTop();
    int i3 = paramList.size();
    int j = 0;
    Object localObject1;
    int k;
    if (j < i3)
    {
      localObject1 = (RecyclerView.ViewHolder)paramList.get(j);
      if (i1 <= 0) {
        break label346;
      }
      k = ((RecyclerView.ViewHolder)localObject1).itemView.getRight() - (paramInt1 + m);
      if ((k >= 0) || (((RecyclerView.ViewHolder)localObject1).itemView.getRight() <= paramViewHolder.itemView.getRight())) {
        break label346;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label346;
      }
      i = k;
      localObject2 = localObject1;
      label143:
      if (i1 >= 0) {
        break label359;
      }
      k = ((RecyclerView.ViewHolder)localObject1).itemView.getLeft() - paramInt1;
      if ((k <= 0) || (((RecyclerView.ViewHolder)localObject1).itemView.getLeft() >= paramViewHolder.itemView.getLeft())) {
        break label359;
      }
      k = Math.abs(k);
      if (k <= i) {
        break label359;
      }
      localObject2 = localObject1;
      i = k;
    }
    label346:
    label359:
    for (;;)
    {
      if (i2 < 0)
      {
        k = ((RecyclerView.ViewHolder)localObject1).itemView.getTop() - paramInt2;
        if ((k > 0) && (((RecyclerView.ViewHolder)localObject1).itemView.getTop() < paramViewHolder.itemView.getTop()))
        {
          k = Math.abs(k);
          if (k > i)
          {
            localObject2 = localObject1;
            i = k;
          }
        }
      }
      for (;;)
      {
        if (i2 > 0)
        {
          k = ((RecyclerView.ViewHolder)localObject1).itemView.getBottom() - (paramInt2 + n);
          if ((k < 0) && (((RecyclerView.ViewHolder)localObject1).itemView.getBottom() > paramViewHolder.itemView.getBottom()))
          {
            k = Math.abs(k);
            if (k > i) {
              i = k;
            }
          }
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject1;
          break;
          return localObject2;
          break label143;
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil.a(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      amml localamml = (amml)paramList.get(i);
      localamml.c();
      int k = paramCanvas.save();
      a(paramCanvas, paramRecyclerView, localamml.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localamml.e, localamml.f, localamml.jdField_b_of_type_Int, false);
      paramCanvas.restoreToCount(k);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      a(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
  }
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil.a(paramViewHolder.itemView);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler)) {
      ((ItemTouchHelper.ViewDropHandler)localLayoutManager).a(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
    }
    do
    {
      do
      {
        return;
        if (localLayoutManager.canScrollHorizontally())
        {
          if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
            paramRecyclerView.scrollToPosition(paramInt2);
          }
          if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
            paramRecyclerView.scrollToPosition(paramInt2);
          }
        }
      } while (!localLayoutManager.canScrollVertically());
      if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    } while (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) < paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    paramRecyclerView.scrollToPosition(paramInt2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return (b(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0;
  }
  
  public abstract boolean a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2);
  
  public float b(float paramFloat)
  {
    return paramFloat;
  }
  
  public float b(RecyclerView.ViewHolder paramViewHolder)
  {
    return 0.5F;
  }
  
  final int b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return d(a(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil.b(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      amml localamml = (amml)paramList.get(i);
      int k = paramCanvas.save();
      b(paramCanvas, paramRecyclerView, localamml.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localamml.e, localamml.f, localamml.jdField_b_of_type_Int, false);
      paramCanvas.restoreToCount(k);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      b(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
    paramInt = 0;
    i = j - 1;
    if (i >= 0)
    {
      paramCanvas = (amml)paramList.get(i);
      if ((paramCanvas.c) && (!paramCanvas.a)) {
        paramList.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break;
      if (!paramCanvas.c)
      {
        paramInt = 1;
        continue;
        if (paramInt != 0) {
          paramRecyclerView.invalidate();
        }
        return;
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      jdField_a_of_type_ComTencentWidgetItemtouchhelperItemTouchUIUtil.b(paramViewHolder.itemView);
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    return true;
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0x303030;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 = (i ^ 0xFFFFFFFF) & paramInt1;
    if (paramInt2 == 0) {
      return paramInt1 | i >> 2;
    }
    return paramInt1 | i >> 1 & 0xFFCFCFCF | (i >> 1 & 0x303030) >> 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
 * JD-Core Version:    0.7.0.1
 */