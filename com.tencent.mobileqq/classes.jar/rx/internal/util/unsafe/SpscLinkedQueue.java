package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

public final class SpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public SpscLinkedQueue()
  {
    spProducerNode(new LinkedQueueNode());
    spConsumerNode(this.producerNode);
    this.consumerNode.soNext(null);
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("null elements not allowed");
    }
    paramE = new LinkedQueueNode(paramE);
    this.producerNode.soNext(paramE);
    this.producerNode = paramE;
    return true;
  }
  
  public E peek()
  {
    LinkedQueueNode localLinkedQueueNode = this.consumerNode.lvNext();
    if (localLinkedQueueNode != null) {
      return localLinkedQueueNode.lpValue();
    }
    return null;
  }
  
  public E poll()
  {
    LinkedQueueNode localLinkedQueueNode = this.consumerNode.lvNext();
    if (localLinkedQueueNode != null)
    {
      Object localObject = localLinkedQueueNode.getAndNullValue();
      this.consumerNode = localLinkedQueueNode;
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.util.unsafe.SpscLinkedQueue
 * JD-Core Version:    0.7.0.1
 */