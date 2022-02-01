package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.litepages.room.webmodule.event.ScrollByWebEvent;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$4
  implements Observer<ScrollByWebEvent>
{
  CustomWebModule$4(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ScrollByWebEvent paramScrollByWebEvent)
  {
    QLog.d("IliveCustomWebModule", 1, "ontouch  scroll by web" + paramScrollByWebEvent.scrollByWeb);
    CustomWebModule.b(this.a, paramScrollByWebEvent.scrollByWeb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.4
 * JD-Core Version:    0.7.0.1
 */