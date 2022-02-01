package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent;
import com.tencent.ilive.litepages.room.webmodule.js.NormalJavascriptInterface;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$8
  implements Observer<ScreenModeEvent>
{
  CustomWebModule$8(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ScreenModeEvent paramScreenModeEvent)
  {
    QLog.d("IliveCustomWebModule", 1, "screenModeEvent isLandscape = " + paramScreenModeEvent.isLandscape);
    NormalJavascriptInterface.setLandscape(paramScreenModeEvent.isLandscape);
    AudienceRoomViewPager localAudienceRoomViewPager;
    if (this.a.getAudienceRoomPager() != null)
    {
      localAudienceRoomViewPager = (AudienceRoomViewPager)this.a.getAudienceRoomPager().getViewPager();
      if (paramScreenModeEvent.isLandscape) {
        localAudienceRoomViewPager.setScrollForbidden(true);
      }
    }
    else
    {
      return;
    }
    localAudienceRoomViewPager.setScrollForbidden(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.8
 * JD-Core Version:    0.7.0.1
 */