package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;

class WeiyunSaveTipsHelperImpl$1
  implements Runnable
{
  WeiyunSaveTipsHelperImpl$1(WeiyunSaveTipsHelperImpl paramWeiyunSaveTipsHelperImpl, Activity paramActivity, int paramInt, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      QQToast.makeText(this.a.getApplicationContext(), 2, 2131895162, 1).show(this.b);
      return;
    }
    QQToast.makeText(this.a.getApplicationContext(), 2, 2131888251, 1).showTouchableToast(this.b, 2131629721, new WeiyunSaveTipsHelperImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */