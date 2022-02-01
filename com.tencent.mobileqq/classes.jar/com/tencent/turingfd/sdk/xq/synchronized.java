package com.tencent.turingfd.sdk.xq;

import java.util.LinkedList;

public class synchronized<E>
{
  public int a;
  public LinkedList<E> b = new LinkedList();
  
  public synchronized(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(E paramE)
  {
    if (this.b.size() >= this.a) {
      this.b.poll();
    }
    this.b.offer(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.synchronized
 * JD-Core Version:    0.7.0.1
 */