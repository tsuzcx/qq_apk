package com.tencent.mobileqq.vipgift;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class VipGiftManager$3
  implements AsyncBack
{
  VipGiftManager$3(VipGiftManager paramVipGiftManager, long paramLong1, String paramString1, long paramLong2, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("checkUpAndNotifyByBid loaded,code:");
      paramString.append(paramInt);
      paramString.append(",cost:");
      paramString.append(System.currentTimeMillis() - this.a);
      QLog.d("VipGiftManager", 2, paramString.toString());
    }
    if (this.b.equalsIgnoreCase("280")) {
      this.e.a("https://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    }
    if ((paramInt != 0) && (8 != paramInt) && (5 != paramInt))
    {
      if (this.e.a(5L, this.c))
      {
        paramString = this.d;
        if (paramString != null) {
          this.e.a(paramString, this.c);
        }
      }
    }
    else if (this.e.a(2L, this.c)) {
      this.e.a(this.b, this.c);
    }
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpAndNotifyByBid progress:");
      localStringBuilder.append(paramInt);
      QLog.d("VipGiftManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipgift.VipGiftManager.3
 * JD-Core Version:    0.7.0.1
 */