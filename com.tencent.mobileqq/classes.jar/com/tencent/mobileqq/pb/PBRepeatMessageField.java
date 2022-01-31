package com.tencent.mobileqq.pb;

import java.io.IOException;
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
    MessageMicro localMessageMicro;
    for (int i = 0;; i = localMessageMicro.computeSizeDirectly(paramInt, localMessageMicro) + i)
    {
      if (!paramList.hasNext()) {
        return i;
      }
      localMessageMicro = (MessageMicro)paramList.next();
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
    Class localClass = paramPBField.get(0).getClass();
    int j = paramPBField.value.size() - localList.size();
    int i;
    if (j > 0)
    {
      i = 0;
      if (i < j) {}
    }
    for (;;)
    {
      for (;;)
      {
        i = 0;
        while (i < localList.size())
        {
          ((MessageMicro)localList.get(i)).copyFrom((MessageMicro)paramPBField.value.get(i));
          i += 1;
        }
        break;
        try
        {
          localList.add((MessageMicro)localClass.newInstance());
          i += 1;
        }
        catch (InstantiationException localInstantiationException)
        {
          for (;;)
          {
            localInstantiationException.printStackTrace();
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
      if (j < 0) {
        localList.subList(-j, localList.size()).clear();
      }
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
    return !isEmpty();
  }
  
  public boolean isEmpty()
  {
    return this.value.isEmpty();
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)this.helper.newInstance();
      paramCodedInputStreamMicro.readMessage(localMessageMicro);
      add(localMessageMicro);
      return;
    }
    catch (InstantiationException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
    }
  }
  
  protected List<T> readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
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
    throws IOException
  {
    writeToDirectly(paramCodedOutputStreamMicro, paramInt, this.value);
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, List<T> paramList)
    throws IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.PBRepeatMessageField
 * JD-Core Version:    0.7.0.1
 */