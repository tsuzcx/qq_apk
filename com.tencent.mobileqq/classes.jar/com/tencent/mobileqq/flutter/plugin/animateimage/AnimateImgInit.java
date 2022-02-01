package com.tencent.mobileqq.flutter.plugin.animateimage;

import com.peterlmeng.animate_image.AnimateImgInitInterface;

public class AnimateImgInit
  implements AnimateImgInitInterface
{
  private final String a;
  
  public AnimateImgInit(String paramString)
  {
    this.a = paramString;
  }
  
  public String getPagLibPath()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.animateimage.AnimateImgInit
 * JD-Core Version:    0.7.0.1
 */