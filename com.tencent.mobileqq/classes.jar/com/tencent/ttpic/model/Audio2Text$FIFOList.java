package com.tencent.ttpic.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text$FIFOList<T>
  extends CopyOnWriteArrayList<T>
{
  private int mCapacity;
  
  public Audio2Text$FIFOList(int paramInt)
  {
    this.mCapacity = paramInt;
  }
  
  public boolean add(T paramT)
  {
    if (size() >= this.mCapacity)
    {
      remove(0);
      return super.add(paramT);
    }
    return super.add(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text.FIFOList
 * JD-Core Version:    0.7.0.1
 */