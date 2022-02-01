package com.tencent.mobileqq.location.ui;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.RoomOperateHandler;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LocationShareController$1
  implements OnUpdateUserLocationListener
{
  LocationShareController$1(LocationShareController paramLocationShareController) {}
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramRoomKey + " mRoomKey: " + LocationShareController.a(this.a));
    }
    QQToast.a(LocationShareController.a(this.a), "已在其他设备进行共享", 0).a();
    LocationShareController.a(this.a).finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(LocationShareController.a(this.a))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 10100) {
            break;
          }
          if ((paramInt2 == 2) && (LocationShareController.a(this.a).a() == 1))
          {
            if (LocationShareController.a(this.a) != null)
            {
              LocationShareController.a(this.a).a.a(1, LocationShareController.a(this.a).a(), LocationShareController.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((LocationShareController.a(this.a) == null) || (LocationShareController.a(this.a).isFinishing()));
        LocationDialogUtil.a(LocationShareController.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((LocationShareController.a(this.a) != null) && (!LocationShareController.a(this.a).isFinishing()))
      {
        LocationDialogUtil.b(LocationShareController.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey });
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if ((!paramRoomKey.equals(LocationShareController.a(this.a))) || (LocationShareController.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      LocationItem localLocationItem = (LocationItem)paramVenue.next();
      Bitmap localBitmap = this.a.a(localLocationItem.a());
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        LocationShareController.a(this.a).a(localLocationItem.a(), localBitmap);
      }
    }
    LocationShareController.a(this.a).a(paramList);
    LocationShareController.a(this.a).a(paramRoomKey);
  }
  
  public void b(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(LocationShareController.a(this.a))) {
      return;
    }
    if (LocationShareController.a(this.a).a() != null) {}
    for (int i = 1;; i = 0)
    {
      LocationShareController.a(this.a).a(null);
      if ((paramInt == 2) || (paramInt == 1) || (i != 0)) {
        break;
      }
      LocationDialogUtil.a(LocationShareController.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.1
 * JD-Core Version:    0.7.0.1
 */