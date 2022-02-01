package cooperation.qzone;

import anvx;
import java.util.Arrays;

public class LoopQueue<T>
{
  private int DEFAULT_SIZE = 10;
  private int capacity;
  private Object[] elementData;
  private int front;
  private int rear;
  
  public LoopQueue()
  {
    this.capacity = this.DEFAULT_SIZE;
    this.elementData = new Object[this.capacity];
  }
  
  public LoopQueue(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("size不能小于1,size=" + paramInt);
    }
    this.capacity = paramInt;
    this.elementData = new Object[this.capacity];
  }
  
  public LoopQueue(T paramT)
  {
    this();
    this.elementData[0] = paramT;
    this.rear += 1;
  }
  
  public LoopQueue(T paramT, int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("initSize不能小于1,initSize=" + paramInt);
    }
    if (paramT == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    this.capacity = paramInt;
    this.elementData = new Object[this.capacity];
    this.elementData[0] = paramT;
    this.rear += 1;
  }
  
  public void add(T paramT)
  {
    try
    {
      if ((this.rear == this.front) && (this.elementData[this.front] != null)) {
        throw new IndexOutOfBoundsException(anvx.a(2131705857));
      }
    }
    finally {}
    if (paramT == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    Object[] arrayOfObject = this.elementData;
    int i = this.rear;
    this.rear = (i + 1);
    arrayOfObject[i] = paramT;
    if (this.rear == this.capacity) {}
    for (i = 0;; i = this.rear)
    {
      this.rear = i;
      return;
    }
  }
  
  public void clear()
  {
    try
    {
      Arrays.fill(this.elementData, null);
      this.front = 0;
      this.rear = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public T element()
  {
    try
    {
      if (isEmpty()) {
        throw new IndexOutOfBoundsException(anvx.a(2131705856));
      }
    }
    finally {}
    Object localObject2 = this.elementData[this.front];
    return localObject2;
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	cooperation/qzone/LoopQueue:rear	I
    //   6: aload_0
    //   7: getfield 60	cooperation/qzone/LoopQueue:front	I
    //   10: if_icmpne +23 -> 33
    //   13: aload_0
    //   14: getfield 22	cooperation/qzone/LoopQueue:elementData	[Ljava/lang/Object;
    //   17: aload_0
    //   18: getfield 49	cooperation/qzone/LoopQueue:rear	I
    //   21: aaload
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +9 -> 33
    //   27: iconst_1
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -6 -> 29
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	LoopQueue
    //   28	7	1	bool	boolean
    //   22	2	2	localObject1	Object
    //   38	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	38	finally
  }
  
  /* Error */
  public boolean isFull()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 90	cooperation/qzone/LoopQueue:size	()I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 20	cooperation/qzone/LoopQueue:capacity	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpne +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	LoopQueue
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  public T remove()
  {
    try
    {
      if (isEmpty()) {
        throw new IndexOutOfBoundsException(anvx.a(2131705858));
      }
    }
    finally {}
    Object localObject2 = this.elementData[this.front];
    Object[] arrayOfObject = this.elementData;
    int i = this.front;
    this.front = (i + 1);
    arrayOfObject[i] = null;
    if (this.front == this.capacity) {}
    for (i = 0;; i = this.front)
    {
      this.front = i;
      return localObject2;
    }
  }
  
  /* Error */
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 83	cooperation/qzone/LoopQueue:isEmpty	()Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 49	cooperation/qzone/LoopQueue:rear	I
    //   23: aload_0
    //   24: getfield 60	cooperation/qzone/LoopQueue:front	I
    //   27: if_icmple +16 -> 43
    //   30: aload_0
    //   31: getfield 49	cooperation/qzone/LoopQueue:rear	I
    //   34: aload_0
    //   35: getfield 60	cooperation/qzone/LoopQueue:front	I
    //   38: isub
    //   39: istore_1
    //   40: goto -25 -> 15
    //   43: aload_0
    //   44: getfield 20	cooperation/qzone/LoopQueue:capacity	I
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 60	cooperation/qzone/LoopQueue:front	I
    //   52: istore_2
    //   53: aload_0
    //   54: getfield 49	cooperation/qzone/LoopQueue:rear	I
    //   57: istore_3
    //   58: iload_1
    //   59: iload_2
    //   60: iload_3
    //   61: isub
    //   62: isub
    //   63: istore_1
    //   64: goto -49 -> 15
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	LoopQueue
    //   14	50	1	i	int
    //   52	10	2	j	int
    //   57	5	3	k	int
    //   6	3	4	bool	boolean
    //   67	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	67	finally
    //   19	40	67	finally
    //   43	58	67	finally
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (isEmpty())
        {
          localObject1 = "[]";
          return localObject1;
        }
        int i;
        if (this.front < this.rear)
        {
          localObject1 = new StringBuilder("[");
          i = this.front;
          if (i < this.rear)
          {
            ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
            i += 1;
          }
          else
          {
            i = ((StringBuilder)localObject1).length();
            localObject1 = "]";
          }
        }
        else
        {
          localObject1 = new StringBuilder("[");
          i = this.front;
          if (i < this.capacity)
          {
            ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
            i += 1;
            continue;
            if (i < this.rear)
            {
              ((StringBuilder)localObject1).append(this.elementData[i].toString() + "->");
              i += 1;
            }
            else
            {
              i = ((StringBuilder)localObject1).length();
              localObject1 = "]";
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.LoopQueue
 * JD-Core Version:    0.7.0.1
 */