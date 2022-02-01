package com.tencent.timi.game.float_window.impl.drag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/drag/DragHelper;", "", "()V", "animatingNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "getAnimatingNum", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setAnimatingNum", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "dragListener", "Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "getDragListener", "()Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "setDragListener", "(Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;)V", "draggableViewList", "", "Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "getDraggableViewList", "()Ljava/util/List;", "setDraggableViewList", "(Ljava/util/List;)V", "draggingView", "getDraggingView", "()Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "setDraggingView", "(Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;)V", "isFloating", "", "()Z", "setFloating", "(Z)V", "originX", "", "getOriginX", "()I", "setOriginX", "(I)V", "originY", "getOriginY", "setOriginY", "getExtraPadding", "draggable", "registerDraggableView", "", "reorder", "unregisterDraggableView", "Companion", "DragHelper", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DragHelper
{
  public static final DragHelper.Companion a = new DragHelper.Companion(null);
  @NotNull
  private static final DragHelper i = DragHelper.DragHelper.a.a();
  @Nullable
  private IDraggableView b;
  private int c;
  private int d;
  @NotNull
  private List<IDraggableView> e = (List)new ArrayList();
  private boolean f;
  @NotNull
  private AtomicInteger g = new AtomicInteger(0);
  @NotNull
  private IDragListener h = (IDragListener)new DragHelper.dragListener.1(this);
  
  @Nullable
  public final IDraggableView a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@Nullable IDraggableView paramIDraggableView)
  {
    this.b = paramIDraggableView;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int b(@Nullable IDraggableView paramIDraggableView)
  {
    int k = 0;
    int m = 0;
    if (paramIDraggableView != null)
    {
      Object localObject2 = (Iterable)this.e;
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        IDraggableView localIDraggableView = (IDraggableView)localObject3;
        boolean bool = Intrinsics.areEqual(localIDraggableView, paramIDraggableView);
        k = 1;
        if (((bool ^ true)) && (((Number)localIDraggableView.a().getFirst()).intValue() * ((Number)paramIDraggableView.a().getFirst()).intValue() >= 0) && (((Number)localIDraggableView.a().getSecond()).intValue() * ((Number)paramIDraggableView.a().getSecond()).intValue() >= 0))
        {
          j = k;
          if ((Intrinsics.areEqual(localIDraggableView, this.b) ^ true)) {
            break label182;
          }
          if (!this.f)
          {
            j = k;
            break label182;
          }
        }
        j = 0;
        label182:
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      int j = m;
      for (;;)
      {
        k = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (IDraggableView)((Iterator)localObject1).next();
        if (Math.abs(((Number)paramIDraggableView.a().getSecond()).intValue()) < Math.abs(((Number)((IDraggableView)localObject2).a().getSecond()).intValue())) {
          j += ((IDraggableView)localObject2).getOuterHeight();
        }
      }
    }
    return k;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  @NotNull
  public final List<IDraggableView> d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  @NotNull
  public final AtomicInteger f()
  {
    return this.g;
  }
  
  public final void g()
  {
    Object localObject2 = (Iterable)this.e;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((Intrinsics.areEqual((IDraggableView)localObject3, this.b) ^ true)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IDraggableView)((Iterator)localObject1).next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.drag.DragHelper
 * JD-Core Version:    0.7.0.1
 */