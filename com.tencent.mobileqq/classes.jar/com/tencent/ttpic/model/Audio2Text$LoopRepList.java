package com.tencent.ttpic.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text$LoopRepList<T>
  extends CopyOnWriteArrayList<T>
{
  private int mCapacity;
  private int mCurrent;
  
  public Audio2Text$LoopRepList(int paramInt)
  {
    this.mCapacity = paramInt;
    this.mCurrent = 0;
  }
  
  public boolean add(T paramT)
  {
    if (size() >= this.mCapacity)
    {
      if (this.mCurrent >= this.mCapacity) {
        this.mCurrent = 0;
      }
      int i = this.mCurrent;
      this.mCurrent = (i + 1);
      super.set(i, paramT);
      return true;
    }
    return super.add(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.model.Audio2Text.LoopRepList
 * JD-Core Version:    0.7.0.1
 */