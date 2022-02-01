package com.tencent.mobileqq.location.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.callback.IShareLocationCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.location.net.RoomOperateHandler;
import com.tencent.mobileqq.location.net.RoomQueryHandler;
import com.tencent.mobileqq.location.net.TroopLocationPushDecoder;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share.PushExtInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

public class LocationShareServiceImpl
  implements ILocationShareService
{
  private static final String TAG = "LocationShareServiceImpl";
  private List<IShareLocationCallback> shareLocationCallbacks;
  
  private static void onDecodeC2cLbsUserQuitRoom(AppRuntime paramAppRuntime, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" operateUin = [");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], sessionUin = [");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("LocationShareServiceImpl", 2, new Object[] { "onDecodeC2cLbsUserQuitRoom: invoked. ", localStringBuilder.toString() });
    }
    if (paramLong1 == paramAppRuntime.getLongAccountUin()) {
      LocationShareLocationManager.a().a(new LocationRoom.RoomKey(0, String.valueOf(paramLong2)), false);
    }
  }
  
  public void addErrorShareStateCallback(IShareLocationCallback paramIShareLocationCallback)
  {
    try
    {
      if (!this.shareLocationCallbacks.contains(paramIShareLocationCallback)) {
        this.shareLocationCallbacks.add(paramIShareLocationCallback);
      }
      return;
    }
    finally
    {
      paramIShareLocationCallback = finally;
      throw paramIShareLocationCallback;
    }
  }
  
  public void addLocationUpdateListener(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    LocationHandler.a().a(paramOnUpdateUserLocationListener);
  }
  
  public boolean isCurrentUserSharing()
  {
    return LocationShareLocationManager.a().a();
  }
  
  public boolean isSessionSharingLocation(int paramInt, String paramString)
  {
    return LocationProtoUtil.a(paramInt, paramString);
  }
  
  public void launchShareUi(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    LocationShareFragment.a(paramActivity, paramInt1, paramString, paramInt2);
  }
  
  public void notifyStateError(int paramInt, String paramString, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = this.shareLocationCallbacks.iterator();
      while (localIterator.hasNext())
      {
        IShareLocationCallback localIShareLocationCallback = (IShareLocationCallback)localIterator.next();
        localIShareLocationCallback.a(paramInt, paramString, paramBoolean);
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareServiceImpl", 2, new Object[] { "[callback] notifyStateError: invoked. ", " callback: ", localIShareLocationCallback.getClass() });
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void notifyStateNormalClose(int paramInt, long paramLong)
  {
    try
    {
      Iterator localIterator = this.shareLocationCallbacks.iterator();
      while (localIterator.hasNext())
      {
        IShareLocationCallback localIShareLocationCallback = (IShareLocationCallback)localIterator.next();
        localIShareLocationCallback.a(paramInt, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareServiceImpl", 2, new Object[] { "[callback] notifyStateNormalClose: invoked. ", " callback: ", localIShareLocationCallback.getClass() });
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void notifyUserSwitchPhone(int paramInt, long paramLong)
  {
    try
    {
      Iterator localIterator = this.shareLocationCallbacks.iterator();
      while (localIterator.hasNext())
      {
        IShareLocationCallback localIShareLocationCallback = (IShareLocationCallback)localIterator.next();
        localIShareLocationCallback.b(paramInt, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareServiceImpl", 2, new Object[] { "[callback] notifyUserSwitchPhone: invoked. ", " callback: ", localIShareLocationCallback.getClass() });
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.shareLocationCallbacks = new ArrayList();
  }
  
  public void onDestroy()
  {
    this.shareLocationCallbacks.clear();
  }
  
  public void processC2CPush(byte[] paramArrayOfByte)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    submsgtype0x125.MsgBody localMsgBody = new submsgtype0x125.MsgBody();
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int j;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localMsgBody.bytes_ext_info.get().toByteArray();
        qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
        localPushExtInfo.mergeFrom(paramArrayOfByte);
        long l = localPushExtInfo.peer_uin.get();
        int i = localPushExtInfo.client_type.get();
        j = localMsgBody.uint32_msg_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareServiceImpl", 2, new Object[] { "processC2C: invoked. ", " optType: ", Integer.valueOf(j) });
        }
        if (j != 4) {
          break label313;
        }
        LocationHandler.a().notifyUI(5, true, new Object[] { Integer.valueOf(0), String.valueOf(l) });
        ((ILocationShareService)localAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateNormalClose(0, l);
        LocationProtoUtil.a(localAppRuntime, 0, String.valueOf(l), false);
        continue;
        if (j == 5)
        {
          LocationHandler.a().notifyUI(6, true, new Object[] { Integer.valueOf(0), String.valueOf(l), Integer.valueOf(i) });
          ((ILocationShareService)localAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyUserSwitchPhone(0, l);
        }
        else if (j == 3)
        {
          onDecodeC2cLbsUserQuitRoom(localAppRuntime, localMsgBody.uint64_oper_uin.get(), l);
          continue;
          LocationProtoUtil.a(localAppRuntime, 0, String.valueOf(l), true);
        }
        LocationHandler.a().notifyUI(4, true, new Object[] { localMsgBody });
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("LocationShareServiceImpl", 1, "processC2C: failed. ", paramArrayOfByte);
      }
      return;
      label313:
      if (j != 1) {
        if (j != 2) {}
      }
    }
  }
  
  public void processTroopPush(TroopLbsSharePushInfo paramTroopLbsSharePushInfo)
  {
    TroopLocationPushDecoder.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramTroopLbsSharePushInfo);
  }
  
  public void removeErrorShareStateCallback(IShareLocationCallback paramIShareLocationCallback)
  {
    try
    {
      this.shareLocationCallbacks.remove(paramIShareLocationCallback);
      return;
    }
    finally
    {
      paramIShareLocationCallback = finally;
      throw paramIShareLocationCallback;
    }
  }
  
  public void removeLocationUpdateListener(OnUpdateUserLocationListener paramOnUpdateUserLocationListener)
  {
    LocationHandler.a().b(paramOnUpdateUserLocationListener);
  }
  
  public void requestOperateRoom(int paramInt1, int paramInt2, String paramString)
  {
    LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(paramInt1, paramInt2, paramString);
  }
  
  public void requestQueryRoom(int paramInt, String paramString)
  {
    LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.a(paramInt, paramString);
  }
  
  public void stopLocationSharing(int paramInt, String paramString, boolean paramBoolean)
  {
    paramString = new LocationRoom.RoomKey(paramInt, paramString);
    LocationShareLocationManager.a().a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.LocationShareServiceImpl
 * JD-Core Version:    0.7.0.1
 */