package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class AbstractIterator<T>
  implements Iterator<T>, KMappedMarker
{
  private T nextValue;
  private State state = State.NotReady;
  
  private final boolean tryToComputeNext()
  {
    this.state = State.Failed;
    computeNext();
    return this.state == State.Ready;
  }
  
  protected abstract void computeNext();
  
  protected final void done()
  {
    this.state = State.Done;
  }
  
  public boolean hasNext()
  {
    boolean bool = false;
    if (this.state != State.Failed) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    State localState = this.state;
    switch (AbstractIterator.WhenMappings.$EnumSwitchMapping$0[localState.ordinal()])
    {
    default: 
      bool = tryToComputeNext();
    case 1: 
      return bool;
    }
    return true;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw ((Throwable)new NoSuchElementException());
    }
    this.state = State.NotReady;
    return this.nextValue;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  protected final void setNext(T paramT)
  {
    this.nextValue = paramT;
    this.state = State.Ready;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.AbstractIterator
 * JD-Core Version:    0.7.0.1
 */