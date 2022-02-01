package com.tencent.mobileqq.location.window;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LocationFloatWindowController$1
  implements OnUpdateUserLocationListener
{
  LocationFloatWindowController$1(LocationFloatWindowController paramLocationFloatWindowController) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramRoomKey + " mRoomKey: " + LocationFloatWindowController.a(this.a));
    }
    QQToast.a(BaseApplication.getContext(), "已在其他设备进行共享", 0).a();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(LocationFloatWindowController.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramRoomKey = QBaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramRoomKey == null) || (paramRoomKey.isFinishing()));
      LocationDialogUtil.a(paramRoomKey);
      return;
    } while ((paramInt1 != 10101) || (paramRoomKey == null) || (paramRoomKey.isFinishing()));
    LocationDialogUtil.b(paramRoomKey);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if (!paramRoomKey.equals(LocationFloatWindowController.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramRoomKey, " mRoomKey: ", LocationFloatWindowController.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (LocationItem)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, 16, 16);
        LocationFloatWindowController.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    LocationFloatWindowController.a(this.a).a(paramRoomKey);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(LocationFloatWindowController.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (QBaseActivity.sTopActivity == null)) {
      return;
    }
    LocationDialogUtil.a(QBaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController.1
 * JD-Core Version:    0.7.0.1
 */