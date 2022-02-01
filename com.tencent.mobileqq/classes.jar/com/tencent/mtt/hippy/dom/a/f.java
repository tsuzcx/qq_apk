package com.tencent.mtt.hippy.dom.a;

public enum f
{
  private f() {}
  
  public static f a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return c;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown enum value: ");
        localStringBuilder.append(paramInt);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return b;
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.a.f
 * JD-Core Version:    0.7.0.1
 */