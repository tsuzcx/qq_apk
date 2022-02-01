package com.tencent.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.SoInfo;

public class Coffee
{
  @SoInfo(libName="image_filter_common")
  private static native String getDESSignKey();
  
  public static String getSignkey()
  {
    try
    {
      String str = getDESSignKey();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(localUnsatisfiedLinkError);
    }
    return "UnsatisfiedLinkError";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.Coffee
 * JD-Core Version:    0.7.0.1
 */