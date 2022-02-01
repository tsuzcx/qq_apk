package com.tencent.mobileqq.pb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PBRepeatMessageField<T extends MessageMicro<T>>
  extends PBField<List<T>>
{
  private final Class<T> helper;
  private List<T> value = Collections.emptyList();
  
  public PBRepeatMessageField(Class<T> paramClass)
  {
    this.helper = paramClass;
  }
  
  public void add(T paramT)
  {
    get().add(paramT);
  }
  
  public void addAll(Collection<T> paramCollection)
  {
    get().addAll(paramCollection);
  }
  
  public void clear(Object paramObject)
  {
    this.value = Collections.emptyList();
  }
  
  public int computeSize(int paramInt)
  {
    return computeSizeDirectly(paramInt, this.value);
  }
  
  protected int computeSizeDirectly(int paramInt, List<T> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    for (;;)
    {
      if (!paramList.hasNext()) {
        return i;
      }
      MessageMicro localMessageMicro = (MessageMicro)paramList.next();
      i += localMessageMicro.computeSizeDirectly(paramInt, localMessageMicro);
    }
  }
  
  protected void copyFrom(PBField<List<T>> paramPBField)
  {
    paramPBField = (PBRepeatMessageField)paramPBField;
    if (paramPBField.isEmpty())
    {
      this.value = Collections.emptyList();
      return;
    }
    List localList = get();
    int j = 0;
    Class localClass = paramPBField.get(0).getClass();
    int k = paramPBField.value.size() - localList.size();
    if (k > 0)
    {
      i = 0;
      for (;;)
      {
        if (i >= k)
        {
          i = j;
          break;
        }
        try
        {
          localList.add((MessageMicro)localClass.newInstance());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        catch (InstantiationException localInstantiationException)
        {
          localInstantiationException.printStackTrace();
        }
        i += 1;
      }
    }
    int i = j;
    if (k < 0)
    {
      localList.subList(-k, localList.size()).clear();
      i = j;
    }
    for (;;)
    {
      if (i >= localList.size()) {
        return;
      }
      ((MessageMicro)localList.get(i)).copyFrom((MessageMicro)paramPBField.value.get(i));
      i += 1;
    }
  }
  
  public T get(int paramInt)
  {
    return (MessageMicro)this.value.get(paramInt);
  }
  
  public List<T> get()
  {
    List localList = Collections.emptyList();
    if (this.value == localList) {
      this.value = new ArrayList();
    }
    return this.value;
  }
  
  public boolean has()
  {
    return isEmpty() ^ true;
  }
  
  public boolean isEmpty()
  {
    return this.value.isEmpty();
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)this.helper.newInstance();
      paramCodedInputStreamMicro.readMessage(localMessageMicro);
      add(localMessageMicro);
      return;
    }
    catch (IllegalAccessException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
      return;
    }
    catch (InstantiationException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
    }
  }
  
  protected List<T> readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    throw new RuntimeException("PBRepeatField not support readFromDirectly method.");
  }
  
  public void remove(int paramInt)
  {
    get().remove(paramInt);
  }
  
  public void set(int paramInt, T paramT)
  {
    this.value.set(paramInt, paramT);
  }
  
  public void set(List<T> paramList)
  {
    this.value = paramList;
  }
  
  public int size()
  {
    return this.value.size();
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    writeToDirectly(paramCodedOutputStreamMicro, paramInt, this.value);
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, List<T> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      MessageMicro localMessageMicro = (MessageMicro)paramList.next();
      localMessageMicro.writeToDirectly(paramCodedOutputStreamMicro, paramInt, localMessageMicro);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBRepeatMessageField
 * JD-Core Version:    0.7.0.1
 */