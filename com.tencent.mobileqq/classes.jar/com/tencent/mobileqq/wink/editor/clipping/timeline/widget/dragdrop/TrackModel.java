package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "", "()V", "blocks", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragViewModel;", "getBlocks", "()Ljava/util/List;", "bottom", "", "getBottom", "()I", "setBottom", "(I)V", "index", "getIndex", "setIndex", "isEmptyTrack", "", "()Z", "leftMargin", "getLeftMargin", "setLeftMargin", "rightMargin", "getRightMargin", "setRightMargin", "top", "getTop", "setTop", "trackType", "getTrackType", "setTrackType", "canPutBlock", "dragViewModel", "start", "end", "canPutBlock$qq_wink_impl_release", "containBlock", "id", "", "putBlock", "", "removeBlockById", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TrackModel
{
  public static final TrackModel.Companion a = new TrackModel.Companion(null);
  @NotNull
  private final List<DragViewModel> b = (List)new ArrayList();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  @NotNull
  public final List<DragViewModel> a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@NotNull DragViewModel paramDragViewModel)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "dragViewModel");
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((DragViewModel)localObject).e(), paramDragViewModel.e())) {
        break label57;
      }
    }
    Object localObject = null;
    label57:
    if (localObject == null) {
      this.b.add(paramDragViewModel);
    }
  }
  
  public final boolean a(@NotNull DragViewModel paramDragViewModel, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramDragViewModel, "dragViewModel");
    boolean bool1 = g();
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    Iterator localIterator = this.b.iterator();
    DragViewModel localDragViewModel;
    do
    {
      bool1 = bool2;
      if (!localIterator.hasNext()) {
        break;
      }
      localDragViewModel = (DragViewModel)localIterator.next();
    } while ((!(Intrinsics.areEqual(localDragViewModel.e(), paramDragViewModel.e()) ^ true)) || (RangesKt.coerceAtLeast(paramInt1, localDragViewModel.b()) >= RangesKt.coerceAtMost(paramInt2, localDragViewModel.c())));
    bool1 = false;
    return bool1;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (Intrinsics.areEqual(((DragViewModel)localObject).e(), paramString))
      {
        paramString = localObject;
        break label56;
      }
    }
    paramString = null;
    label56:
    paramString = (DragViewModel)paramString;
    if (paramString != null)
    {
      this.b.remove(paramString);
      return true;
    }
    return false;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final boolean b(@Nullable String paramString)
  {
    Object localObject = (Iterable)this.b;
    boolean bool1 = localObject instanceof Collection;
    boolean bool2 = false;
    if ((bool1) && (((Collection)localObject).isEmpty())) {
      return false;
    }
    localObject = ((Iterable)localObject).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (!Intrinsics.areEqual(paramString, ((DragViewModel)((Iterator)localObject).next()).e()));
    bool1 = true;
    return bool1;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public final void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final int e()
  {
    return this.f;
  }
  
  public final void e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public final void f(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final boolean g()
  {
    return this.b.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.TrackModel
 * JD-Core Version:    0.7.0.1
 */