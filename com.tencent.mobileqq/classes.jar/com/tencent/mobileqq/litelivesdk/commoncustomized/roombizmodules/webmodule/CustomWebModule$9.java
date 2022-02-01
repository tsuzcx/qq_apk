package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.litepages.room.webmodule.event.ScreenModeEvent;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App;
import com.tencent.qphone.base.util.QLog;

class CustomWebModule$9
  implements Observer<ScreenModeEvent>
{
  CustomWebModule$9(CustomWebModule paramCustomWebModule) {}
  
  public void a(@Nullable ScreenModeEvent paramScreenModeEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("screenModeEvent isLandscape = ");
    ((StringBuilder)localObject).append(paramScreenModeEvent.isLandscape);
    QLog.d("IliveCustomWebModule", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((CustomWebModule)localObject).jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp = ((CustomWebModule)localObject).a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleJsApp.b(paramScreenModeEvent.isLandscape);
    }
    if (this.a.getAudienceRoomPager() != null)
    {
      localObject = this.a.getAudienceRoomPager();
      if (paramScreenModeEvent.isLandscape)
      {
        ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        return;
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        ((IAudienceRoomPager)localObject).setScrollForbidden(true);
        return;
      }
      ((IAudienceRoomPager)localObject).setScrollForbidden(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.9
 * JD-Core Version:    0.7.0.1
 */