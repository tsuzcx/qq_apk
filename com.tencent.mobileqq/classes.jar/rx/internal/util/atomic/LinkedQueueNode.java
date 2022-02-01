package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicReference;

public final class LinkedQueueNode<E>
  extends AtomicReference<LinkedQueueNode<E>>
{
  private static final long serialVersionUID = 2404266111789071508L;
  private E value;
  
  public LinkedQueueNode() {}
  
  public LinkedQueueNode(E paramE)
  {
    spValue(paramE);
  }
  
  public E getAndNullValue()
  {
    Object localObject = lpValue();
    spValue(null);
    return localObject;
  }
  
  public E lpValue()
  {
    return this.value;
  }
  
  public LinkedQueueNode<E> lvNext()
  {
    return (LinkedQueueNode)get();
  }
  
  public void soNext(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    lazySet(paramLinkedQueueNode);
  }
  
  public void spValue(E paramE)
  {
    this.value = paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.atomic.LinkedQueueNode
 * JD-Core Version:    0.7.0.1
 */