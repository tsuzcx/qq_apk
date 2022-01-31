package com.tencent.plato.layout;

public enum PDisplay
{
  FLEX(0),  NONE(1);
  
  private int mIntValue;
  
  private PDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static PDisplay fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return FLEX;
    }
    return NONE;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.layout.PDisplay
 * JD-Core Version:    0.7.0.1
 */