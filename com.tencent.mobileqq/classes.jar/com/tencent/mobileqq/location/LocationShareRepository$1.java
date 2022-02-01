package com.tencent.mobileqq.location;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.UserLocationsUpdateBean;
import java.util.List;

class LocationShareRepository$1
  implements OnUpdateUserLocationListener
{
  LocationShareRepository$1(LocationShareRepository paramLocationShareRepository) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    LocationShareRepository.a(this.a).a(paramRoomKey);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    LocationShareRepository.a(this.a).a(paramRoomKey, paramInt1, paramInt2);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    UserLocationsUpdateBean localUserLocationsUpdateBean = new UserLocationsUpdateBean();
    localUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    localUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramVenue;
    localUserLocationsUpdateBean.jdField_a_of_type_JavaUtilList = paramList;
    LocationShareRepository.a(this.a).a.postValue(localUserLocationsUpdateBean);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    LocationShareRepository.a(this.a).a(paramRoomKey, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository.1
 * JD-Core Version:    0.7.0.1
 */