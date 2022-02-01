package com.tencent.mobileqq.pic;

public class PicInfoInterface
  implements LoggerInterface
{
  public PicInfoInterface.ErrInfo a;
  
  public String a()
  {
    return null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new PicInfoInterface.ErrInfo();
    }
    PicInfoInterface.ErrInfo localErrInfo = this.a;
    localErrInfo.a = paramString1;
    localErrInfo.b = paramString2;
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicInfoInterface
 * JD-Core Version:    0.7.0.1
 */