package rx.internal.util;

import java.util.Queue;
import rx.functions.Action0;

class ObjectPool$1
  implements Action0
{
  ObjectPool$1(ObjectPool paramObjectPool) {}
  
  public void call()
  {
    int j = 0;
    int i = 0;
    int k = this.this$0.pool.size();
    if (k < this.this$0.minSize)
    {
      j = this.this$0.maxSize;
      while (i < j - k)
      {
        this.this$0.pool.add(this.this$0.createObject());
        i += 1;
      }
    }
    if (k > this.this$0.maxSize)
    {
      int m = this.this$0.maxSize;
      i = j;
      while (i < k - m)
      {
        this.this$0.pool.poll();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.util.ObjectPool.1
 * JD-Core Version:    0.7.0.1
 */