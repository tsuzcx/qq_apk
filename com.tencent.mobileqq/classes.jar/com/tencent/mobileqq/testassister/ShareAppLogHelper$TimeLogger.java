package com.tencent.mobileqq.testassister;

import com.tencent.qphone.base.util.QLog;

class ShareAppLogHelper$TimeLogger
{
  private long a;
  private String b;
  
  public ShareAppLogHelper$TimeLogger(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ShareAppLogHelper.TimeLogger", 4, new Object[] { this.b, " costTime: ", Long.valueOf(l - this.a) });
      }
    }
    else
    {
      this.a = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.TimeLogger
 * JD-Core Version:    0.7.0.1
 */