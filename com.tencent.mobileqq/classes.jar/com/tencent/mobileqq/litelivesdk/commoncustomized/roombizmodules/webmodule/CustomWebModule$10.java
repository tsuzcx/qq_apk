package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import com.tencent.ilivesdk.domain.factory.BaseObserver;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$10
  extends BaseObserver<Long>
{
  CustomWebModule$10(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable Long paramLong)
  {
    QLog.d("IliveCustomWebModule", 1, "playStatus this=" + this.a.hashCode() + ";time position = " + paramLong + ", mPause=" + CustomWebModule.b(this.a));
    if (CustomWebModule.b(this.a)) {}
    while (paramLong == null) {
      return;
    }
    CustomWebModule.b(this.a, paramLong.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.10
 * JD-Core Version:    0.7.0.1
 */