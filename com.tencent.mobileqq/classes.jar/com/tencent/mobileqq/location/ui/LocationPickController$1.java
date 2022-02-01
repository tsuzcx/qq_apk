package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LocationPickController$1
  implements OnUpdateUserLocationListener
{
  LocationPickController$1(LocationPickController paramLocationPickController) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramRoomKey + " mRoomKey: " + LocationPickController.a(this.a));
    }
    QQToast.a(LocationPickController.a(this.a), "已在其他设备进行共享", 0).a();
    LocationPickController.a(this.a).setResult(1);
    LocationPickController.a(this.a).finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(LocationPickController.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((LocationPickController.a(this.a) == null) || (LocationPickController.a(this.a).isFinishing()));
      LocationPickController.a(this.a).setResult(1);
      LocationDialogUtil.a(LocationPickController.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (LocationPickController.a(this.a) == null) || (LocationPickController.a(this.a).isFinishing()));
    LocationPickController.a(this.a).setResult(1);
    LocationDialogUtil.b(LocationPickController.a(this.a));
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if ((!paramRoomKey.equals(LocationPickController.a(this.a))) || (LocationPickController.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (LocationItem)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        LocationPickController.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    LocationPickController.a(this.a).a(paramRoomKey);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(LocationPickController.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    LocationPickController.a(this.a).setResult(1);
    LocationDialogUtil.a(LocationPickController.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.1
 * JD-Core Version:    0.7.0.1
 */