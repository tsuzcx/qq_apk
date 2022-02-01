package com.tencent.mobileqq.location.ui;

import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler.VenueOptResultCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LocationShareController$8
  implements LocationHandler.VenueOptResultCallback
{
  LocationShareController$8(LocationShareController paramLocationShareController, LocationRoom.Venue paramVenue) {}
  
  public Pair<LocationRoom.RoomKey, LocationRoom.Venue> a()
  {
    return new Pair(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramRoomKey + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramRoomKey.equals(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController))) || (LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a() == null) || (paramVenue == null) || (!LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a().equals(paramVenue))) {
      return;
    }
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVenueOprating(false);
    LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVisibility(8);
    if (paramBoolean)
    {
      LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).setVenue(null);
      LocationShareController.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController);
      ReportController.b(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController), 1, "移除失败，请稍后重试", 0).a();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      ReportController.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.8
 * JD-Core Version:    0.7.0.1
 */