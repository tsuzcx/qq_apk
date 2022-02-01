package com.tencent.mobileqq.kandian.base.video.player;

import android.text.TextUtils;

public class BusiType
{
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 3)
      {
        if (paramInt == 7) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == 2) || ((paramInt == 6) && (!TextUtils.isEmpty(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.BusiType
 * JD-Core Version:    0.7.0.1
 */