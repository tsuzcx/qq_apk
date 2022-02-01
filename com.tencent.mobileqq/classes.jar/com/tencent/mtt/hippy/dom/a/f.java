package com.tencent.mtt.hippy.dom.a;

public enum f
{
  private f() {}
  
  public static f a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return a;
    case 1: 
      return b;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.a.f
 * JD-Core Version:    0.7.0.1
 */