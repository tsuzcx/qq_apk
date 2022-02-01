package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class LocationShareRoomManager
{
  private static volatile LocationShareRoomManager d;
  public LocationRoom.RoomKey a;
  public RoomOperateHandler b = new RoomOperateHandler();
  public RoomQueryHandler c = new RoomQueryHandler();
  private volatile boolean e = false;
  private LocationRoom.RoomKey f;
  
  public static LocationShareRoomManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new LocationShareRoomManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  public void a(int paramInt, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("Q.LocationShare", 2, "[LocationManager] createOrJoinRoom: invoked.");
    }
    if (paramInt == 0)
    {
      if (LocationProtoUtil.a(paramString)) {}
    }
    else
    {
      do
      {
        i = 1;
        break label95;
        if (paramInt != 1) {
          break;
        }
      } while (!LocationProtoUtil.b(paramString));
      break label95;
      QLog.d("Q.LocationShare", 1, new Object[] { "createOrJoinRoom: invoked. (进入已关闭的房间，需要兜底逻辑[弹窗、刷新本地标志等]) ", " operateType: ", Integer.valueOf(0), " mLocationShareFragment.sessionUinType: ", Integer.valueOf(paramInt) });
      i = 0;
    }
    label95:
    this.b.a(i, paramInt, paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (LocationProtoUtil.a(paramInt1, paramString))
    {
      paramInt1 = LocationHandler.a(paramInt2);
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramInt3);
      ReportController.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", paramInt1, 0, paramString.toString(), "0", "0", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    this.f = paramRoomKey;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(paramBoolean) });
    }
    this.e = paramBoolean;
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.e) });
    }
    return this.e;
  }
  
  public LocationRoom.RoomKey c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareRoomManager
 * JD-Core Version:    0.7.0.1
 */