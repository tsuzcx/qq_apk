package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;
import sun.misc.Unsafe;

public final class MpscLinkedQueue<E>
  extends BaseLinkedQueue<E>
{
  public MpscLinkedQueue()
  {
    this.consumerNode = new LinkedQueueNode();
    xchgProducerNode(this.consumerNode);
  }
  
  public final boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("null elements not allowed");
    }
    paramE = new LinkedQueueNode(paramE);
    xchgProducerNode(paramE).soNext(paramE);
    return true;
  }
  
  public final E peek()
  {
    LinkedQueueNode localLinkedQueueNode1 = this.consumerNode;
    LinkedQueueNode localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
    if (localLinkedQueueNode2 != null) {
      return localLinkedQueueNode2.lpValue();
    }
    if (localLinkedQueueNode1 != lvProducerNode())
    {
      do
      {
        localLinkedQueueNode2 = localLinkedQueueNode1.lvNext();
      } while (localLinkedQueueNode2 == null);
      return localLinkedQueueNode2.lpValue();
    }
    return null;
  }
  
  public final E poll()
  {
    Object localObject = lpConsumerNode();
    LinkedQueueNode localLinkedQueueNode = ((LinkedQueueNode)localObject).lvNext();
    if (localLinkedQueueNode != null)
    {
      localObject = localLinkedQueueNode.getAndNullValue();
      spConsumerNode(localLinkedQueueNode);
      return localObject;
    }
    if (localObject != lvProducerNode())
    {
      do
      {
        localLinkedQueueNode = ((LinkedQueueNode)localObject).lvNext();
      } while (localLinkedQueueNode == null);
      localObject = localLinkedQueueNode.getAndNullValue();
      this.consumerNode = localLinkedQueueNode;
      return localObject;
    }
    return null;
  }
  
  protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> paramLinkedQueueNode)
  {
    LinkedQueueNode localLinkedQueueNode;
    do
    {
      localLinkedQueueNode = this.producerNode;
    } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, localLinkedQueueNode, paramLinkedQueueNode));
    return (LinkedQueueNode)localLinkedQueueNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.unsafe.MpscLinkedQueue
 * JD-Core Version:    0.7.0.1
 */