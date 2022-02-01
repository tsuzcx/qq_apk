package com.tencent.turingfd.sdk.ams.ga;

import java.util.LinkedList;

public class private<E>
{
  public LinkedList<E> Xc = new LinkedList();
  public int limit;
  
  public private(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void offer(E paramE)
  {
    if (this.Xc.size() >= this.limit) {
      this.Xc.poll();
    }
    this.Xc.offer(paramE);
  }
  
  public int size()
  {
    return this.Xc.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.private
 * JD-Core Version:    0.7.0.1
 */