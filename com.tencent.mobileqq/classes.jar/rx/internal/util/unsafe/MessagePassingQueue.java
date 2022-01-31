package rx.internal.util.unsafe;

abstract interface MessagePassingQueue<M>
{
  public abstract boolean isEmpty();
  
  public abstract boolean offer(M paramM);
  
  public abstract M peek();
  
  public abstract M poll();
  
  public abstract int size();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.unsafe.MessagePassingQueue
 * JD-Core Version:    0.7.0.1
 */