package com.tencent.mobileqq.kandian.biz.ugc.databinding;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableArrayList<T>
  extends ArrayList<T>
  implements ObservableList<T>
{
  private transient ListChangeRegistry a = new ListChangeRegistry();
  
  private void a(int paramInt1, int paramInt2)
  {
    ListChangeRegistry localListChangeRegistry = this.a;
    if (localListChangeRegistry != null) {
      localListChangeRegistry.b(this, paramInt1, paramInt2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ListChangeRegistry localListChangeRegistry = this.a;
    if (localListChangeRegistry != null) {
      localListChangeRegistry.c(this, paramInt1, paramInt2);
    }
  }
  
  public void add(int paramInt, T paramT)
  {
    super.add(paramInt, paramT);
    a(paramInt, 1);
  }
  
  public boolean add(T paramT)
  {
    super.add(paramT);
    a(size() - 1, 1);
    return true;
  }
  
  public boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    boolean bool = super.addAll(paramInt, paramCollection);
    if (bool) {
      a(paramInt, paramCollection.size());
    }
    return bool;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    int i = size();
    boolean bool = super.addAll(paramCollection);
    if (bool) {
      a(i, size() - i);
    }
    return bool;
  }
  
  public void addOnListChangedCallback(ObservableList.OnListChangedCallback paramOnListChangedCallback)
  {
    if (this.a == null) {
      this.a = new ListChangeRegistry();
    }
    this.a.a(paramOnListChangedCallback);
  }
  
  public void clear()
  {
    int i = size();
    super.clear();
    if (i != 0) {
      b(0, i);
    }
  }
  
  public T remove(int paramInt)
  {
    Object localObject = super.remove(paramInt);
    b(paramInt, 1);
    return localObject;
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      remove(i);
      return true;
    }
    return false;
  }
  
  public void removeOnListChangedCallback(ObservableList.OnListChangedCallback paramOnListChangedCallback)
  {
    ListChangeRegistry localListChangeRegistry = this.a;
    if (localListChangeRegistry != null) {
      localListChangeRegistry.b(paramOnListChangedCallback);
    }
  }
  
  protected void removeRange(int paramInt1, int paramInt2)
  {
    super.removeRange(paramInt1, paramInt2);
    b(paramInt1, paramInt2 - paramInt1);
  }
  
  public T set(int paramInt, T paramT)
  {
    paramT = super.set(paramInt, paramT);
    ListChangeRegistry localListChangeRegistry = this.a;
    if (localListChangeRegistry != null) {
      localListChangeRegistry.a(this, paramInt, 1);
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList
 * JD-Core Version:    0.7.0.1
 */