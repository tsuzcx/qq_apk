package com.tencent.videocut.render;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/render/AbsListRender$renderAllItems$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AbsListRender$renderAllItems$1
  implements ListUpdateCallback
{
  AbsListRender$renderAllItems$1(List paramList1, List paramList2) {}
  
  public void onChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Pair)))
    {
      Object localObject1 = (Pair)paramObject;
      if (((((Pair)localObject1).getFirst() instanceof Integer)) && ((((Pair)localObject1).getSecond() instanceof Integer)))
      {
        paramObject = this.a;
        Object localObject2 = this.b;
        Object localObject3 = ((Pair)localObject1).getSecond();
        if (localObject3 != null)
        {
          localObject2 = ((List)localObject2).get(((Integer)localObject3).intValue());
          localObject3 = this.c;
          localObject1 = ((Pair)localObject1).getFirst();
          if (localObject1 != null)
          {
            paramObject.b(localObject2, ((List)localObject3).get(((Integer)localObject1).intValue()));
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
    }
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    Object localObject2 = (Iterable)RangesKt.until(0, paramInt2);
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramInt2 = ((IntIterator)localObject2).nextInt();
      ((Collection)localObject1).add(this.b.get(paramInt2 + paramInt1));
    }
    localObject1 = (List)localObject1;
    AbsListRender.a(this.a, (List)localObject1);
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    this.a.a(this.c.get(paramInt1), paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    Object localObject2 = (Iterable)RangesKt.until(0, paramInt2);
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramInt2 = ((IntIterator)localObject2).nextInt();
      ((Collection)localObject1).add(this.c.get(paramInt2 + paramInt1));
    }
    localObject1 = (List)localObject1;
    AbsListRender.b(this.a, (List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AbsListRender.renderAllItems.1
 * JD-Core Version:    0.7.0.1
 */