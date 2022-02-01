package com.tencent.mtt.supportui.utils;

public class CommonTool
{
  public static boolean hasPositiveItem(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        if (paramArrayOfFloat[i] > 0.0F) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.CommonTool
 * JD-Core Version:    0.7.0.1
 */