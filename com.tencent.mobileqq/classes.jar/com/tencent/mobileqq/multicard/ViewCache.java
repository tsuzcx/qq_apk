package com.tencent.mobileqq.multicard;

import java.util.LinkedList;
import java.util.List;

public class ViewCache<T>
{
  private List<T> a = new LinkedList();
  
  public T a()
  {
    if (this.a.size() == 0) {
      return null;
    }
    return this.a.remove(0);
  }
  
  public void a(T paramT)
  {
    if (!this.a.contains(paramT)) {
      this.a.add(paramT);
    }
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public int c()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.ViewCache
 * JD-Core Version:    0.7.0.1
 */