package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "heap", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@InternalCoroutinesApi
public abstract interface ThreadSafeHeapNode
{
  @Nullable
  public abstract ThreadSafeHeap<?> getHeap();
  
  public abstract int getIndex();
  
  public abstract void setHeap(@Nullable ThreadSafeHeap<?> paramThreadSafeHeap);
  
  public abstract void setIndex(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ThreadSafeHeapNode
 * JD-Core Version:    0.7.0.1
 */