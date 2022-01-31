package com.tencent.tavkit.utils;

import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;

public class Utils
{
  public static boolean isRectValid(CGRect paramCGRect)
  {
    return (paramCGRect != null) && (isSizeValid(paramCGRect.size));
  }
  
  public static boolean isSizeValid(CGSize paramCGSize)
  {
    return (paramCGSize != null) && (paramCGSize.width != 0.0F) && (paramCGSize.height != 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.utils.Utils
 * JD-Core Version:    0.7.0.1
 */