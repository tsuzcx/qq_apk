package com.tencent.qplus.swingworker;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ScheduleLinkedBlockingQueue$Itr
  implements Iterator<E>
{
  private ScheduleLinkedBlockingQueue.Node<E> current;
  private E currentElement;
  private ScheduleLinkedBlockingQueue.Node<E> lastRet;
  
  ScheduleLinkedBlockingQueue$Itr(ScheduleLinkedBlockingQueue paramScheduleLinkedBlockingQueue)
  {
    paramScheduleLinkedBlockingQueue.fullyLock();
    try
    {
      this.current = ScheduleLinkedBlockingQueue.access$0(paramScheduleLinkedBlockingQueue).next;
      if (this.current != null) {
        this.currentElement = this.current.item;
      }
      return;
    }
    finally
    {
      paramScheduleLinkedBlockingQueue.fullyUnlock();
    }
  }
  
  private ScheduleLinkedBlockingQueue.Node<E> nextNode(ScheduleLinkedBlockingQueue.Node<E> paramNode)
  {
    for (Object localObject = paramNode;; localObject = paramNode)
    {
      paramNode = ((ScheduleLinkedBlockingQueue.Node)localObject).next;
      if (paramNode == localObject) {
        localObject = ScheduleLinkedBlockingQueue.access$0(this.this$0).next;
      }
      do
      {
        do
        {
          return localObject;
          localObject = paramNode;
        } while (paramNode == null);
        localObject = paramNode;
      } while (paramNode.item != null);
    }
  }
  
  public boolean hasNext()
  {
    return this.current != null;
  }
  
  public E next()
  {
    this.this$0.fullyLock();
    try
    {
      if (this.current == null) {
        throw new NoSuchElementException();
      }
    }
    finally
    {
      this.this$0.fullyUnlock();
    }
    Object localObject3 = this.currentElement;
    this.lastRet = this.current;
    this.current = nextNode(this.current);
    if (this.current == null) {}
    for (Object localObject2 = null;; localObject2 = this.current.item)
    {
      this.currentElement = localObject2;
      this.this$0.fullyUnlock();
      return localObject3;
    }
  }
  
  public void remove()
  {
    if (this.lastRet == null) {
      throw new IllegalStateException();
    }
    this.this$0.fullyLock();
    for (;;)
    {
      try
      {
        ScheduleLinkedBlockingQueue.Node localNode3 = this.lastRet;
        this.lastRet = null;
        localObject3 = ScheduleLinkedBlockingQueue.access$0(this.this$0);
        ScheduleLinkedBlockingQueue.Node localNode1 = ((ScheduleLinkedBlockingQueue.Node)localObject3).next;
        if (localNode1 == null) {
          return;
        }
        if (localNode1 == localNode3)
        {
          this.this$0.unlink(localNode1, (ScheduleLinkedBlockingQueue.Node)localObject3);
          continue;
        }
        localNode2 = localObject1.next;
      }
      finally
      {
        this.this$0.fullyUnlock();
      }
      ScheduleLinkedBlockingQueue.Node localNode2;
      Object localObject3 = localObject1;
      Object localObject2 = localNode2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ScheduleLinkedBlockingQueue.Itr
 * JD-Core Version:    0.7.0.1
 */