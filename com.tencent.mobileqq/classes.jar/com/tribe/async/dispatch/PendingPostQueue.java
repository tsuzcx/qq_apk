package com.tribe.async.dispatch;

final class PendingPostQueue
  implements SimpleQueue<PendingPost>
{
  private PendingPost mHead;
  private PendingPost mTail;
  
  public void dump() {}
  
  public void enqueue(PendingPost paramPendingPost)
  {
    if (paramPendingPost != null) {}
    try
    {
      if (this.mTail != null)
      {
        this.mTail.next = paramPendingPost;
        this.mTail = paramPendingPost;
      }
      else
      {
        if (this.mHead != null) {
          break label53;
        }
        this.mTail = paramPendingPost;
        this.mHead = paramPendingPost;
      }
      notifyAll();
      return;
      label53:
      throw new IllegalStateException("Head present, but no tail");
    }
    finally
    {
      label73:
      break label73;
    }
    throw new NullPointerException("null cannot be enqueued");
    throw paramPendingPost;
  }
  
  public PendingPost poll()
  {
    try
    {
      PendingPost localPendingPost = this.mHead;
      if (this.mHead != null)
      {
        this.mHead = this.mHead.next;
        if (this.mHead == null) {
          this.mTail = null;
        }
      }
      return localPendingPost;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public PendingPost poll(int paramInt)
  {
    try
    {
      if (this.mHead == null) {
        wait(paramInt);
      }
      PendingPost localPendingPost = poll();
      return localPendingPost;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.dispatch.PendingPostQueue
 * JD-Core Version:    0.7.0.1
 */