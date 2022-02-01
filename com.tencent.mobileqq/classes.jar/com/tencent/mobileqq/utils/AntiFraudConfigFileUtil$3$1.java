package com.tencent.mobileqq.utils;

class AntiFraudConfigFileUtil$3$1
  implements Runnable
{
  AntiFraudConfigFileUtil$3$1(AntiFraudConfigFileUtil.3 param3, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.e.a.b(this.a, this.b);
    String str = SecUtil.getFileMd5(this.e.a.a(this.a));
    if (!this.c.equalsIgnoreCase(str))
    {
      this.e.a.a(this.a, this.c, this.d);
      return;
    }
    this.e.a.a(this.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil.3.1
 * JD-Core Version:    0.7.0.1
 */