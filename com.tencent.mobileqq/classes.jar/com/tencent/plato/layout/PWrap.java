package com.tencent.plato.layout;

public enum PWrap
{
  NO_WRAP(0),  WRAP(1),  WRAP_REVERSE(2);
  
  private int mIntValue;
  
  private PWrap(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static PWrap fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return NO_WRAP;
    case 1: 
      return WRAP;
    }
    return WRAP_REVERSE;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.layout.PWrap
 * JD-Core Version:    0.7.0.1
 */