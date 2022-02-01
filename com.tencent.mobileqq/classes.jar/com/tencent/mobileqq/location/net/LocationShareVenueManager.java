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
  private static volatile LocationShareVenueManager a;
  private VenueOperateHandler b = new VenueOperateHandler();
  private LocationShareVenueManager.VenueOptResultCallback c;
  
  public static LocationShareVenueManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new LocationShareVenueManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (LocationHandler.a().b(paramRoomKey).l()) {
      QQToast.makeText(BaseApplication.getContext(), 2131891407, 0).show();
    }
  }
  
  void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((LocationShareVenueManager.VenueOptResultCallback)localObject).a();
      if ((localObject != null) && (paramRoomKey.equals(((Pair)localObject).first)) && (paramVenue.equals(((Pair)localObject).second)))
      {
        this.c.a(paramRoomKey, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.c = null;
      }
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationShareVenueManager.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey != null) && ((paramVenue != null) || (paramVenueOptResultCallback == null)))
    {
      this.c = paramVenueOptResultCallback;
      this.b.a(paramRoomKey, paramVenue);
      return;
    }
    paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 1, false, -1);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, String paramString)
  {
    paramRoomKey = LocationHandler.a().b(paramRoomKey);
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramRoomKey.l()) && (!localAppInterface.getAccount().equals(paramString))) {
      QQToast.makeText(BaseApplication.getContext(), 2131891405, 0).show();
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.b.b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey)
  {
    if (LocationHandler.a().b(paramRoomKey).l()) {
      QQToast.makeText(BaseApplication.getContext(), 2131891406, 0).show();
    }
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, LocationShareVenueManager.VenueOptResultCallback paramVenueOptResultCallback)
  {
    if ((paramRoomKey != null) && ((paramVenue != null) || (paramVenueOptResultCallback == null)))
    {
      this.c = paramVenueOptResultCallback;
      this.b.b(paramRoomKey, paramVenue);
      return;
    }
    paramVenueOptResultCallback.a(paramRoomKey, paramVenue, 3, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareVenueManager
 * JD-Core Version:    0.7.0.1
 */