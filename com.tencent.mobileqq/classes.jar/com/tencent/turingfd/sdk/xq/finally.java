package com.tencent.turingfd.sdk.xq;

import java.util.LinkedList;

public class finally<E>
{
  public LinkedList<E> Xf = new LinkedList();
  public int limit;
  
  public finally(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public E getFirst()
  {
    return this.Xf.getFirst();
  }
  
  public E getLast()
  {
    return this.Xf.getLast();
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public void offer(E paramE)
  {
    if (this.Xf.size() >= this.limit) {
      this.Xf.poll();
    }
    this.Xf.offer(paramE);
  }
  
  public int size()
  {
    return this.Xf.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.finally
 * JD-Core Version:    0.7.0.1
 */