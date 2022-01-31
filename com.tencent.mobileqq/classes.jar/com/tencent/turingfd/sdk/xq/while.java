package com.tencent.turingfd.sdk.xq;

import java.util.LinkedList;

public class while<E>
{
  public LinkedList<E> Kb = new LinkedList();
  public int limit;
  
  public while(int paramInt)
  {
    this.limit = paramInt;
  }
  
  public void offer(E paramE)
  {
    if (this.Kb.size() >= this.limit) {
      this.Kb.poll();
    }
    this.Kb.offer(paramE);
  }
  
  public int size()
  {
    return this.Kb.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.while
 * JD-Core Version:    0.7.0.1
 */