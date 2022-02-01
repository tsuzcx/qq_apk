package com.tencent.ttpic.model;

public class MemRandomValue
{
  public static final MemRandomValue EMPTY = new MemRandomValue();
  public int curValue;
  public int lastValue;
  
  public MemRandomValue()
  {
    this(-1, -1);
  }
  
  public MemRandomValue(int paramInt1, int paramInt2)
  {
    this.lastValue = paramInt1;
    this.curValue = paramInt2;
  }
  
  public boolean isAssigned()
  {
    return this.lastValue >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.MemRandomValue
 * JD-Core Version:    0.7.0.1
 */