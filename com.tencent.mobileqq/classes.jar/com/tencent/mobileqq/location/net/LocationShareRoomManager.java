package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class LocationShareRoomManager
{
  private static volatile LocationShareRoomManager jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareRoomManager;
  public LocationRoom.RoomKey a;
  public RoomOperateHandler a;
  public RoomQueryHandler a;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private LocationRoom.RoomKey b;
  
  private LocationShareRoomManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler = new RoomOperateHandler();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler = new RoomQueryHandler();
  }
  
  public static LocationShareRoomManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareRoomManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareRoomManager == null) {
          jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareRoomManager = new LocationShareRoomManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqLocationNetLocationShareRoomManager;
  }
  
  public LocationRoom.RoomKey a()
  {
    return this.b;
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
    this.jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(i, paramInt, paramString);
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
    this.b = paramRoomKey;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareRoomManager
 * JD-Core Version:    0.7.0.1
 */