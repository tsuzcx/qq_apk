package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.ScrollByWebEvent;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$5
  implements Observer<ScrollByWebEvent>
{
  CustomWebModule$5(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ScrollByWebEvent paramScrollByWebEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ontouch ScrollByWebEvent scroll by web");
    localStringBuilder.append(paramScrollByWebEvent.scrollByWeb);
    QLog.d("IliveCustomWebModule", 1, localStringBuilder.toString());
    CustomWebModule.b(this.a, paramScrollByWebEvent.scrollByWeb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.5
 * JD-Core Version:    0.7.0.1
 */