package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder
{
  private final ArrayList<Object> list;
  
  public SpreadBuilder(int paramInt)
  {
    this.list = new ArrayList(paramInt);
  }
  
  public void add(Object paramObject)
  {
    this.list.add(paramObject);
  }
  
  public void addSpread(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        localObject = this.list;
        ((ArrayList)localObject).ensureCapacity(((ArrayList)localObject).size() + paramObject.length);
        Collections.addAll(this.list, paramObject);
      }
    }
    else
    {
      if ((paramObject instanceof Collection))
      {
        this.list.addAll((Collection)paramObject);
        return;
      }
      if ((paramObject instanceof Iterable))
      {
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext())
        {
          localObject = paramObject.next();
          this.list.add(localObject);
        }
      }
      if (!(paramObject instanceof Iterator)) {
        break label155;
      }
      paramObject = (Iterator)paramObject;
      while (paramObject.hasNext()) {
        this.list.add(paramObject.next());
      }
    }
    return;
    label155:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Don't know how to spread ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    paramObject = new UnsupportedOperationException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    return this.list.toArray(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.SpreadBuilder
 * JD-Core Version:    0.7.0.1
 */