package cooperation.qzone;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneResLoader;
import java.util.Arrays;

public class LoopQueue<T>
{
  private int DEFAULT_SIZE = 10;
  private int capacity;
  private Object[] elementData;
  private int front = 0;
  private int rear = 0;
  
  public LoopQueue()
  {
    this.capacity = this.DEFAULT_SIZE;
    this.elementData = new Object[this.capacity];
  }
  
  public LoopQueue(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.capacity = paramInt;
      this.elementData = new Object[this.capacity];
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size不能小于1,size=");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public LoopQueue(T paramT)
  {
    this();
    this.elementData[0] = paramT;
    this.rear += 1;
  }
  
  public LoopQueue(T paramT, int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramT != null)
      {
        this.capacity = paramInt;
        this.elementData = new Object[this.capacity];
        this.elementData[0] = paramT;
        this.rear += 1;
        return;
      }
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    paramT = new StringBuilder();
    paramT.append("initSize不能小于1,initSize=");
    paramT.append(paramInt);
    throw new IllegalArgumentException(paramT.toString());
  }
  
  public void add(T paramT)
  {
    try
    {
      if ((this.rear == this.front) && (this.elementData[this.front] != null)) {
        throw new IndexOutOfBoundsException(HardCodeUtil.a(((IQzoneResLoader)QRoute.api(IQzoneResLoader.class)).getStringId(2)));
      }
      if (paramT != null)
      {
        Object[] arrayOfObject = this.elementData;
        int i = this.rear;
        this.rear = (i + 1);
        arrayOfObject[i] = paramT;
        if (this.rear == this.capacity) {
          i = 0;
        } else {
          i = this.rear;
        }
        this.rear = i;
        return;
      }
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    finally {}
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
  
  public boolean isEmpty()
  {
    try
    {
      if (this.rear == this.front)
      {
        Object localObject1 = this.elementData[this.rear];
        if (localObject1 == null)
        {
          bool = true;
          break label34;
        }
      }
      boolean bool = false;
      label34:
      return bool;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public boolean isFull()
  {
    try
    {
      int i = size();
      int j = this.capacity;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public T remove()
  {
    try
    {
      if (!isEmpty())
      {
        Object localObject1 = this.elementData[this.front];
        Object[] arrayOfObject = this.elementData;
        int i = this.front;
        this.front = (i + 1);
        arrayOfObject[i] = null;
        if (this.front == this.capacity) {
          i = 0;
        } else {
          i = this.front;
        }
        this.front = i;
        return localObject1;
      }
      throw new IndexOutOfBoundsException(HardCodeUtil.a(((IQzoneResLoader)QRoute.api(IQzoneResLoader.class)).getStringId(3)));
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      boolean bool = isEmpty();
      if (bool) {
        return 0;
      }
      if (this.rear > this.front)
      {
        i = this.rear;
        j = this.front;
      }
      else
      {
        i = this.capacity;
        j = this.front;
        int k = this.rear;
        j -= k;
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        int j;
        for (;;)
        {
          throw localObject;
        }
      }
    }
    return i - j;
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        if (isEmpty()) {
          return "[]";
        }
        if (this.front < this.rear)
        {
          localObject1 = new StringBuilder("[");
          i = this.front;
          if (i < this.rear)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.elementData[i].toString());
            localStringBuilder.append("->");
            ((StringBuilder)localObject1).append(localStringBuilder.toString());
            i += 1;
            continue;
          }
          i = ((StringBuilder)localObject1).length();
          localObject1 = ((StringBuilder)localObject1).delete(i - 2, i);
          ((StringBuilder)localObject1).append("]");
          localObject1 = ((StringBuilder)localObject1).toString();
          return localObject1;
        }
        localObject1 = new StringBuilder("[");
        i = this.front;
        if (i >= this.capacity) {
          continue;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.elementData[i].toString());
        localStringBuilder.append("->");
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
        i += 1;
        continue;
      }
      finally
      {
        Object localObject1;
        StringBuilder localStringBuilder;
        continue;
        throw localObject2;
        continue;
        int i = 0;
        continue;
      }
      if (i >= this.rear) {
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.elementData[i].toString());
      localStringBuilder.append("->");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      i += 1;
    }
    i = ((StringBuilder)localObject1).length();
    localObject1 = ((StringBuilder)localObject1).delete(i - 2, i);
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.LoopQueue
 * JD-Core Version:    0.7.0.1
 */