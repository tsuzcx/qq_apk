package com.tencent.mobileqq.location.net;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class LocationShareVenueManager
{
  private static volatile LocationShareVenueManager jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager;
  private LocationShareVenueManager.VenueOptResultCallback jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback;
  private VenueOperateHandler jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler = new VenueOperateHandler();
  
  public static LocationShareVenueManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager == null) {
          jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager = new LocationShareVenueManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager;
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (LocationHandler.a().a(paramRoomKey).b()) {
      QQToast.a(BaseApplication.getContext(), 2131693831, 0).a();
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback;
    if (localObject != null)
    {
      localObject = ((LocationShareVenueManager.VenueOptResultCallback)localObject).a();
      if ((localObject != null) && (paramRoomKey.equals(((Pair)localObject).first)) && (paramVenue.equals(((Pair)localObject).second)))
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback.a(paramRoomKey, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback = null;
      }
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationShareVenueManager.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey != null) && ((paramVenue != null) || (paramVenueOptResultCallback == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback = paramVenueOptResultCallback;
      this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.a(paramRoomKey, paramVenue);
      return;
    }
    paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 1, false, -1);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    paramRoomKey = LocationHandler.a().a(paramRoomKey);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramRoomKey.b()) && (!localAppInterface.getAccount().equals(paramString))) {
      QQToast.a(BaseApplication.getContext(), 2131693829, 0).a();
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey)
  {
    if (LocationHandler.a().a(paramRoomKey).b()) {
      QQToast.a(BaseApplication.getContext(), 2131693830, 0).a();
    }
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationShareVenueManager.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey != null) && ((paramVenue != null) || (paramVenueOptResultCallback == null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareVenueManager$VenueOptResultCallback = paramVenueOptResultCallback;
      this.jdField_a_of_type_ComTencentMobileqqLocationNetVenueOperateHandler.b(paramRoomKey, paramVenue);
      return;
    }
    paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 3, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareVenueManager
 * JD-Core Version:    0.7.0.1
 */