package com.tencent.mobileqq.kandian.glue.viola;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class ViolaAccessHelper$4$1
  implements AsyncBack
{
  ViolaAccessHelper$4$1(ViolaAccessHelper.4 param4) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downOffline  code ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  param ");
      localStringBuilder.append(paramString);
      QLog.d("ViolaAccessHelper", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      if (paramString == null)
      {
        if (this.a.c != null) {
          this.a.c.a();
        }
      }
      else
      {
        if (paramString.contains("url"))
        {
          QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - this.a.d) });
          return;
        }
        long l1 = System.currentTimeMillis();
        long l2 = this.a.d;
        if (this.a.c != null) {
          this.a.c.a();
        }
        QLog.d("ViolaAccessHelper", 2, new Object[] { "checkUpByBusinessId load success. no update. cost=", Long.valueOf(l1 - l2) });
      }
    }
    else if (this.a.c != null) {
      this.a.c.b();
    }
  }
  
  public void progress(int paramInt)
  {
    if (this.a.c != null) {
      this.a.c.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.4.1
 * JD-Core Version:    0.7.0.1
 */