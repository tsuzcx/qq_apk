package com.tencent.mobileqq.location.ui;

import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler.VenueOptResultCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LocationShareController$7
  implements LocationHandler.VenueOptResultCallback
{
  LocationShareController$7(LocationShareController paramLocationShareController, LocationRoom.Venue paramVenue) {}
  
  public Pair<LocationRoom.RoomKey, LocationRoom.Venue> a()
  {
    return new Pair(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramRoomKey + " venue: " + paramVenue + " mRoomKey: " + LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramRoomKey.equals(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController))) || (paramVenue == null)) {
      return;
    }
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVenueOprating(false);
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVisibility(8);
    if (paramBoolean)
    {
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVenue(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), 2, "集合点设置成功", 0).a();
      ReportController.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), 1, "设置失败，请稍后重试", 0).a();
      if (LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a() != null) {
        LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      ReportController.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), 1, "你已离开共享会话", 0).a();
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).finish();
      break;
      QQToast.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), 1, "已有人设置集合点", 0).a();
      break;
      LocationShareController.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
    }
    label389:
    ReportController.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.7
 * JD-Core Version:    0.7.0.1
 */