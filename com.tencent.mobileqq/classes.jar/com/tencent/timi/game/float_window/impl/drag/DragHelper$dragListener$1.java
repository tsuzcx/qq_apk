package com.tencent.timi.game.float_window.impl.drag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/float_window/impl/drag/DragHelper$dragListener$1", "Lcom/tencent/timi/game/float_window/impl/drag/IDragListener;", "onAnimationEnd", "", "onAnimationStart", "onDrag", "draggableView", "Lcom/tencent/timi/game/float_window/impl/drag/IDraggableView;", "nowCenterX", "", "nowCenterY", "onDragEnd", "onDragStart", "onDragUp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DragHelper$dragListener$1
  implements IDragListener
{
  public void a()
  {
    this.a.f().incrementAndGet();
  }
  
  public void a(@NotNull IDraggableView paramIDraggableView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDraggableView, "draggableView");
    this.a.a(paramIDraggableView);
    paramIDraggableView = paramIDraggableView.a();
    this.a.a(((Number)paramIDraggableView.getFirst()).intValue());
    this.a.b(((Number)paramIDraggableView.getSecond()).intValue());
  }
  
  public void a(@NotNull IDraggableView paramIDraggableView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramIDraggableView, "draggableView");
    IDraggableView localIDraggableView = this.a.a();
    if (localIDraggableView != null)
    {
      boolean bool2 = this.a.e();
      boolean bool1 = true;
      if (!bool2)
      {
        if (Math.abs(Math.abs(paramInt1) - Math.abs(this.a.b())) > paramIDraggableView.getOuterWidth() / 2) {
          this.a.a(true);
        } else if (Math.abs(Math.abs(paramInt2) - Math.abs(this.a.c())) > paramIDraggableView.getOuterHeight() / 2) {
          this.a.a(true);
        }
        if (this.a.e()) {
          this.a.g();
        }
      }
      else if (this.a.f().get() == 0)
      {
        Object localObject1 = (Iterable)this.a.d();
        paramIDraggableView = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if ((Intrinsics.areEqual((IDraggableView)localObject2, localIDraggableView) ^ true)) {
            paramIDraggableView.add(localObject2);
          }
        }
        paramIDraggableView = ((Iterable)paramIDraggableView).iterator();
        while (paramIDraggableView.hasNext())
        {
          localObject1 = (IDraggableView)paramIDraggableView.next();
          localObject2 = ((IDraggableView)localObject1).a();
          Pair localPair = localIDraggableView.a();
          paramInt2 = ((IDraggableView)localObject1).getOuterWidth() / 2 + localIDraggableView.getOuterWidth() / 2 - Math.abs(Math.abs(((Number)((Pair)localObject2).getFirst()).intValue()) - Math.abs(((Number)localPair.getFirst()).intValue()));
          int i = ((IDraggableView)localObject1).getOuterHeight() / 2 + localIDraggableView.getOuterHeight() / 2 - Math.abs(Math.abs(((Number)((Pair)localObject2).getSecond()).intValue()) - Math.abs(((Number)localPair.getSecond()).intValue()));
          if ((paramInt2 > 0) && (i > 0))
          {
            paramInt1 = ((IDraggableView)localObject1).getOuterWidth() * ((IDraggableView)localObject1).getOuterHeight() / 2;
            paramInt2 *= i;
            if ((paramInt1 < paramInt2) || (localIDraggableView.getOuterWidth() * localIDraggableView.getOuterHeight() / 2 < paramInt2)) {
              bool1 = false;
            }
          }
        }
        this.a.a(bool1);
        this.a.g();
      }
    }
  }
  
  public void b()
  {
    this.a.f().decrementAndGet();
  }
  
  public void b(@NotNull IDraggableView paramIDraggableView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDraggableView, "draggableView");
    this.a.a(false);
    this.a.a((IDraggableView)null);
    this.a.g();
  }
  
  public void c(@NotNull IDraggableView paramIDraggableView)
  {
    Intrinsics.checkParameterIsNotNull(paramIDraggableView, "draggableView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.drag.DragHelper.dragListener.1
 * JD-Core Version:    0.7.0.1
 */