package com.tencent.mobileqq.winkpublish.preview.itemtouchhelper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

public abstract class ItemTouchHelper$Callback
{
  private static final ItemTouchUIUtil a = new ItemTouchUIUtilImpl.Honeycomb();
  private static final Interpolator b = new ItemTouchHelper.Callback.1();
  private static final Interpolator c = new ItemTouchHelper.Callback.2();
  private int d = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new ItemTouchUIUtilImpl.Lollipop();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0xC0C0C;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {}
    for (paramInt2 = i << 2;; paramInt2 = (paramInt2 & 0xC0C0C) << 2)
    {
      return paramInt1 | paramInt2;
      paramInt2 = i << 1;
      paramInt1 |= 0xFFF3F3F3 & paramInt2;
    }
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    if (this.d == -1) {
      this.d = paramRecyclerView.getResources().getDimensionPixelSize(2131297705);
    }
    return this.d;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = c(0, paramInt2 | paramInt1);
    paramInt2 = c(1, paramInt2);
    return c(2, paramInt1) | paramInt2 | i;
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
  
  public int a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    paramInt3 = a(paramRecyclerView);
    int i = Math.abs(paramInt2);
    int j = (int)Math.signum(paramInt2);
    float f2 = i;
    float f1 = 1.0F;
    f2 = Math.min(1.0F, f2 * 1.0F / paramInt1);
    paramInt1 = (int)(j * paramInt3 * c.getInterpolation(f2));
    if (paramLong <= 2000L) {
      f1 = (float)paramLong / 2000.0F;
    }
    paramInt3 = (int)(paramInt1 * b.getInterpolation(f1));
    paramInt1 = paramInt3;
    if (paramInt3 == 0)
    {
      if (paramInt2 > 0) {
        return 1;
      }
      paramInt1 = -1;
    }
    return paramInt1;
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
  
  public RecyclerView.ViewHolder a(RecyclerView.ViewHolder paramViewHolder, List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
  {
    int n = paramViewHolder.itemView.getWidth();
    int i1 = paramViewHolder.itemView.getHeight();
    int i2 = paramInt1 - paramViewHolder.itemView.getLeft();
    int i3 = paramInt2 - paramViewHolder.itemView.getTop();
    int i4 = paramList.size();
    Object localObject2 = null;
    int i = -1;
    int k = 0;
    while (k < i4)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
      if (i2 > 0)
      {
        j = localViewHolder.itemView.getRight() - (paramInt1 + n);
        if ((j < 0) && (localViewHolder.itemView.getRight() > paramViewHolder.itemView.getRight()))
        {
          j = Math.abs(j);
          if (j > i)
          {
            localObject2 = localViewHolder;
            break label146;
          }
        }
      }
      int j = i;
      label146:
      Object localObject1 = localObject2;
      i = j;
      int m;
      if (i2 < 0)
      {
        m = localViewHolder.itemView.getLeft() - paramInt1;
        localObject1 = localObject2;
        i = j;
        if (m > 0)
        {
          localObject1 = localObject2;
          i = j;
          if (localViewHolder.itemView.getLeft() < paramViewHolder.itemView.getLeft())
          {
            m = Math.abs(m);
            localObject1 = localObject2;
            i = j;
            if (m > j)
            {
              i = m;
              localObject1 = localViewHolder;
            }
          }
        }
      }
      localObject2 = localObject1;
      j = i;
      if (i3 < 0)
      {
        m = localViewHolder.itemView.getTop() - paramInt2;
        localObject2 = localObject1;
        j = i;
        if (m > 0)
        {
          localObject2 = localObject1;
          j = i;
          if (localViewHolder.itemView.getTop() < paramViewHolder.itemView.getTop())
          {
            m = Math.abs(m);
            localObject2 = localObject1;
            j = i;
            if (m > i)
            {
              j = m;
              localObject2 = localViewHolder;
            }
          }
        }
      }
      if (i3 > 0)
      {
        i = localViewHolder.itemView.getBottom() - (paramInt2 + i1);
        if ((i < 0) && (localViewHolder.itemView.getBottom() > paramViewHolder.itemView.getBottom()))
        {
          i = Math.abs(i);
          if (i > j)
          {
            localObject2 = localViewHolder;
            break label404;
          }
        }
      }
      i = j;
      label404:
      k += 1;
    }
    return localObject2;
  }
  
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    a.a(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      localRecoverAnimation.c();
      int k = paramCanvas.save();
      a(paramCanvas, paramRecyclerView, localRecoverAnimation.h, localRecoverAnimation.l, localRecoverAnimation.m, localRecoverAnimation.i, false);
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
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler))
    {
      ((ItemTouchHelper.ViewDropHandler)localLayoutManager).a(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
      return;
    }
    if (localLayoutManager.canScrollHorizontally())
    {
      if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
      if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    }
    if (localLayoutManager.canScrollVertically())
    {
      if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
      if (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
        paramRecyclerView.scrollToPosition(paramInt2);
      }
    }
  }
  
  public boolean a()
  {
    return true;
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
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    a.b(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
  {
    int k = paramList.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
      int m = paramCanvas.save();
      b(paramCanvas, paramRecyclerView, localRecoverAnimation.h, localRecoverAnimation.l, localRecoverAnimation.m, localRecoverAnimation.i, false);
      paramCanvas.restoreToCount(m);
      i += 1;
    }
    if (paramViewHolder != null)
    {
      i = paramCanvas.save();
      b(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
      paramCanvas.restoreToCount(i);
    }
    paramInt = k - 1;
    i = j;
    while (paramInt >= 0)
    {
      paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
      if ((paramCanvas.o) && (!paramCanvas.k)) {
        paramList.remove(paramInt);
      } else if (!paramCanvas.o) {
        i = 1;
      }
      paramInt -= 1;
    }
    if (i != 0) {
      paramRecyclerView.invalidate();
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null) {
      a.b(paramViewHolder.itemView);
    }
  }
  
  public void b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    a.a(paramViewHolder.itemView);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean b(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    return true;
  }
  
  public int c()
  {
    return 0;
  }
  
  final int c(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return d(a(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
  }
  
  public int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1 & 0x303030;
    if (i == 0) {
      return paramInt1;
    }
    paramInt1 &= (i ^ 0xFFFFFFFF);
    if (paramInt2 == 0) {}
    for (paramInt2 = i >> 2;; paramInt2 = (paramInt2 & 0x303030) >> 2)
    {
      return paramInt1 | paramInt2;
      paramInt2 = i >> 1;
      paramInt1 |= 0xFFCFCFCF & paramInt2;
    }
  }
  
  boolean d(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return (c(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.preview.itemtouchhelper.ItemTouchHelper.Callback
 * JD-Core Version:    0.7.0.1
 */