package com.tencent.mtt.supportui.utils;

public class CommonTool
{
  public static boolean hasPositiveItem(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramArrayOfFloat != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayOfFloat.length)
      {
        if (paramArrayOfFloat[i] > 0.0F) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.CommonTool
 * JD-Core Version:    0.7.0.1
 */