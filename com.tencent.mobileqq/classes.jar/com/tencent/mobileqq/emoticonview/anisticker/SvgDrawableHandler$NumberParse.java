package com.tencent.mobileqq.emoticonview.anisticker;

import java.util.ArrayList;

class SvgDrawableHandler$NumberParse
{
  private int nextCmd;
  private ArrayList<Float> numbers;
  
  public SvgDrawableHandler$NumberParse(ArrayList<Float> paramArrayList, int paramInt)
  {
    this.numbers = paramArrayList;
    this.nextCmd = paramInt;
  }
  
  public int getNextCmd()
  {
    return this.nextCmd;
  }
  
  public float getNumber(int paramInt)
  {
    return ((Float)this.numbers.get(paramInt)).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.SvgDrawableHandler.NumberParse
 * JD-Core Version:    0.7.0.1
 */