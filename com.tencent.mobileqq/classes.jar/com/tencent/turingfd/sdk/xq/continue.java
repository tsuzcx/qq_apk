package com.tencent.turingfd.sdk.xq;

import java.util.LinkedList;

public class continue<E>
{
  public int limit;
  public LinkedList<E> qg = new LinkedList();
  
  public continue(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public E getFirst()
  {
    return this.qg.getFirst();
  }
  
  public E getLast()
  {
    return this.qg.getLast();
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public void offer(E paramE)
  {
    if (this.qg.size() >= this.limit) {
      this.qg.poll();
    }
    this.qg.offer(paramE);
  }
  
  public int size()
  {
    return this.qg.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.continue
 * JD-Core Version:    0.7.0.1
 */