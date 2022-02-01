package com.tencent.tfd.sdk.wxa;

import java.util.LinkedList;

public class private<E>
{
  public LinkedList<E> Ic = new LinkedList();
  public int limit;
  
  public private(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void offer(E paramE)
  {
    if (this.Ic.size() >= this.limit) {
      this.Ic.poll();
    }
    this.Ic.offer(paramE);
  }
  
  public int size()
  {
    return this.Ic.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.private
 * JD-Core Version:    0.7.0.1
 */