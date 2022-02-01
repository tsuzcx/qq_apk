package com.tencent.mobileqq.location;

import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.VenueOptBean;
import com.tencent.mobileqq.location.net.LocationShareVenueManager.VenueOptResultCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class LocationShareViewModel$2
  implements LocationShareVenueManager.VenueOptResultCallback
{
  LocationShareViewModel$2(LocationShareViewModel paramLocationShareViewModel, LocationRoom.Venue paramVenue) {}
  
  public Pair<LocationRoom.RoomKey, LocationRoom.Venue> a()
  {
    return new Pair(LocationShareViewModel.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[venue] setVenue: onResult. roomKey: ");
      ((StringBuilder)localObject).append(paramRoomKey);
      ((StringBuilder)localObject).append(" venue: ");
      ((StringBuilder)localObject).append(paramVenue);
      ((StringBuilder)localObject).append(" mRoomKey: ");
      ((StringBuilder)localObject).append(LocationShareViewModel.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel));
      ((StringBuilder)localObject).append(" optType: ");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" errorCode: ");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.LocationShare", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    if (paramRoomKey.equals(LocationShareViewModel.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel)))
    {
      if (paramVenue == null) {
        return;
      }
      if (!paramBoolean) {
        if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
          ReportController.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
        }
      }
      paramRoomKey = new VenueOptBean();
      paramRoomKey.b = 1;
      paramRoomKey.c = 2;
      paramRoomKey.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue;
      paramRoomKey.jdField_a_of_type_Boolean = paramBoolean;
      paramRoomKey.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel.c.postValue(paramRoomKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewModel.2
 * JD-Core Version:    0.7.0.1
 */