package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import com.tencent.ilivesdk.domain.factory.BaseObserver;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$11
  extends BaseObserver<Long>
{
  CustomWebModule$11(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable Long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playStatus this=");
    localStringBuilder.append(this.a.hashCode());
    localStringBuilder.append(";time position = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", mPause=");
    localStringBuilder.append(CustomWebModule.b(this.a));
    QLog.d("IliveCustomWebModule", 1, localStringBuilder.toString());
    if (CustomWebModule.b(this.a)) {
      return;
    }
    if (paramLong != null) {
      CustomWebModule.a(this.a, paramLong.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.11
 * JD-Core Version:    0.7.0.1
 */