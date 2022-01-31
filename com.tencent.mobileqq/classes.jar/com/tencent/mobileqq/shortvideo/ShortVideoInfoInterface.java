package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;

public class ShortVideoInfoInterface
  implements LoggerInterface
{
  protected PicInfoInterface.ErrInfo a;
  
  public String a()
  {
    return null;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new PicInfoInterface.ErrInfo();
    }
    this.a.a = paramString1;
    this.a.b = paramString2;
    Logger.b(this, paramString1, paramString2);
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoInfoInterface
 * JD-Core Version:    0.7.0.1
 */