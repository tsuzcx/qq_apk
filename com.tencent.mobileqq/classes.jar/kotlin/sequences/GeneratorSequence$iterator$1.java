package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class GeneratorSequence$iterator$1
  implements Iterator<T>, KMappedMarker
{
  @Nullable
  private T nextItem;
  private int nextState = -2;
  
  private final void calcNext()
  {
    Object localObject1;
    if (this.nextState == -2)
    {
      localObject1 = GeneratorSequence.access$getGetInitialValue$p(this.this$0).invoke();
      this.nextItem = localObject1;
      if (this.nextItem != null) {
        break label73;
      }
    }
    label73:
    for (int i = 0;; i = 1)
    {
      this.nextState = i;
      return;
      localObject1 = GeneratorSequence.access$getGetNextValue$p(this.this$0);
      Object localObject2 = this.nextItem;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((Function1)localObject1).invoke(localObject2);
      break;
    }
  }
  
  @Nullable
  public final T getNextItem()
  {
    return this.nextItem;
  }
  
  public final int getNextState()
  {
    return this.nextState;
  }
  
  public boolean hasNext()
  {
    if (this.nextState < 0) {
      calcNext();
    }
    return this.nextState == 1;
  }
  
  @NotNull
  public T next()
  {
    if (this.nextState < 0) {
      calcNext();
    }
    if (this.nextState == 0) {
      throw ((Throwable)new NoSuchElementException());
    }
    Object localObject = this.nextItem;
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    this.nextState = -1;
    return localObject;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final void setNextItem(@Nullable T paramT)
  {
    this.nextItem = paramT;
  }
  
  public final void setNextState(int paramInt)
  {
    this.nextState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.sequences.GeneratorSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */