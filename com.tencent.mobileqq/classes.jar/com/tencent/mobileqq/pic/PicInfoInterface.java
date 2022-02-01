package com.tencent.mobileqq.pic;

public class PicInfoInterface
  implements LoggerInterface
{
  public PicInfoInterface.ErrInfo H;
  
  public String a()
  {
    return null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.H == null) {
      this.H = new PicInfoInterface.ErrInfo();
    }
    PicInfoInterface.ErrInfo localErrInfo = this.H;
    localErrInfo.a = paramString1;
    localErrInfo.b = paramString2;
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicInfoInterface
 * JD-Core Version:    0.7.0.1
 */