package com.tencent.mobileqq.wink.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.view.View;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/utils/AdapterUtils;", "", "()V", "SNAP_TO_CENTER", "", "currentIndex", "getCurrentIndex", "()Ljava/lang/Integer;", "setCurrentIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "scroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "llm", "Landroid/support/v7/widget/LinearLayoutManager;", "scroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "position", "scrollToPosition", "targetPosition", "smoothScroll", "", "fixScrollTime", "snapPosition", "scrollToPositionAndLayoutCenter", "scrollToPositionAndLayoutEnd", "scrollToPositionAndLayoutStart", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AdapterUtils
{
  public static final AdapterUtils a = new AdapterUtils();
  @Nullable
  private static Integer b;
  
  @JvmStatic
  public static final void a(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    a(paramRecyclerView, paramInt1, paramInt2, true, false);
  }
  
  @JvmStatic
  public static final void a(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramRecyclerView, paramInt1, paramInt2, paramBoolean1, paramBoolean2, 2);
  }
  
  @JvmStatic
  public static final void a(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    if (paramRecyclerView == null) {
      return;
    }
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 != null)
    {
      localObject1 = (LinearLayoutManager)localObject1;
      Object localObject2 = (LinearSmoothScroller)new AdapterUtils.scrollToPosition.scroller.1((LinearLayoutManager)localObject1, paramInt3, paramBoolean2, paramRecyclerView, paramRecyclerView.getContext());
      if (paramBoolean1)
      {
        b = Integer.valueOf(paramInt1);
        paramRecyclerView.post((Runnable)new AdapterUtils.scrollToPosition.1((LinearSmoothScroller)localObject2, paramInt2, paramRecyclerView, (LinearLayoutManager)localObject1));
        return;
      }
      int i = 0;
      if (paramInt3 == 2)
      {
        localObject2 = ((LinearLayoutManager)localObject1).findViewByPosition(((LinearLayoutManager)localObject1).findFirstCompletelyVisibleItemPosition());
        paramInt1 = i;
        if (localObject2 != null) {
          paramInt1 = paramRecyclerView.getWidth() / 2;
        }
      }
      else
      {
        for (paramInt3 = ((View)localObject2).getWidth() / 2;; paramInt3 = ((View)localObject2).getWidth())
        {
          paramInt1 -= paramInt3;
          break;
          paramInt1 = i;
          if (paramInt3 != 1) {
            break;
          }
          localObject2 = ((LinearLayoutManager)localObject1).findViewByPosition(((LinearLayoutManager)localObject1).findFirstCompletelyVisibleItemPosition());
          paramInt1 = i;
          if (localObject2 == null) {
            break;
          }
          paramInt1 = paramRecyclerView.getWidth();
        }
      }
      ((LinearLayoutManager)localObject1).scrollToPositionWithOffset(paramInt2, paramInt1);
      return;
    }
    paramRecyclerView = new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    for (;;)
    {
      throw paramRecyclerView;
    }
  }
  
  private final void a(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager, LinearSmoothScroller paramLinearSmoothScroller, int paramInt)
  {
    if (!paramLinearLayoutManager.isSmoothScrolling())
    {
      paramLinearLayoutManager.startSmoothScroll((RecyclerView.SmoothScroller)paramLinearSmoothScroller);
      return;
    }
    paramRecyclerView.postDelayed((Runnable)new AdapterUtils.scroll.1(paramRecyclerView, paramLinearLayoutManager, paramLinearSmoothScroller, paramInt), 200L);
  }
  
  @JvmStatic
  public static final void b(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b(paramRecyclerView, paramInt1, paramInt2, true, false);
  }
  
  @JvmStatic
  public static final void b(@Nullable RecyclerView paramRecyclerView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramRecyclerView, paramInt1, paramInt2, paramBoolean1, paramBoolean2, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.AdapterUtils
 * JD-Core Version:    0.7.0.1
 */