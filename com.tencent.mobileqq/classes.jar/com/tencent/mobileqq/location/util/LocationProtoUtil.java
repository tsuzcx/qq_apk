package com.tencent.mobileqq.location.util;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class LocationProtoUtil
{
  @NonNull
  public static qq_lbs_share.RoomKey a(AppRuntime paramAppRuntime, int paramInt, long paramLong)
  {
    qq_lbs_share.RoomKey localRoomKey = new qq_lbs_share.RoomKey();
    if (paramInt == 0)
    {
      localRoomKey.aio_type.set(2);
      localRoomKey.id1.set(Math.min(paramLong, paramAppRuntime.getLongAccountUin()));
      localRoomKey.id2.set(Math.max(paramLong, paramAppRuntime.getLongAccountUin()));
    }
    for (;;)
    {
      localRoomKey.setHasFlag(true);
      return localRoomKey;
      if (paramInt == 1)
      {
        localRoomKey.aio_type.set(1);
        localRoomKey.id1.set(paramLong);
        localRoomKey.id2.set(0L);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      paramAppRuntime = (IFriendExtensionService)paramAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
      paramString = paramAppRuntime.getExtensionInfo(paramString);
      if (paramString != null)
      {
        if (!paramBoolean) {
          break label84;
        }
        paramInt = 1;
        paramString.isSharingLocation = paramInt;
        paramAppRuntime.saveExtensionInfo(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("LocationProtoUtil", 2, new Object[] { "updateShareLocationProfileFlag: invoked. saved share state. ", " ei.isSharingLocation: ", Integer.valueOf(paramString.isSharingLocation) });
        }
      }
    }
    label84:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = 0;
          break;
        } while (paramInt != 1);
        paramAppRuntime = (ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramString = paramAppRuntime.getTroopInfo(paramString);
      } while (paramString == null);
      paramString.setIsSharingLocation(paramBoolean);
      paramAppRuntime.saveTroopInfo(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LocationProtoUtil", 2, "updateShareLocationProfileFlag: invoked. saved TroopInfo & lastShareLbsMsgUniseq");
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return a(paramString);
    }
    if (paramInt == 1) {
      return b(paramString);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    ExtensionInfo localExtensionInfo = ((IFriendExtensionService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendExtensionService.class, "")).getExtensionInfo(paramString);
    if (localExtensionInfo == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isC2cSharingLocation: invoked. ", " isSharingLocation: ", Integer.valueOf(localExtensionInfo.isSharingLocation), " friendUin: ", paramString });
    }
    if (localExtensionInfo.isSharingLocation == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(qq_lbs_share.ResultInfo paramResultInfo)
  {
    boolean bool = true;
    if (paramResultInfo == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "rspSuccess: invoked. ", " resultInfo.uint32_result: ", Integer.valueOf(paramResultInfo.uint32_result.get()), " resultInfo.bytes_errmsg: ", paramResultInfo.bytes_errmsg.get().toStringUtf8(), " resultInfo.uint64_svr_time: ", Long.valueOf(paramResultInfo.uint64_svr_time.get()) });
    }
    if (paramResultInfo.uint32_result.get() == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(String paramString)
  {
    paramString = ((ITroopInfoService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isGroupSharingLocation: invoked. ", " ti: ", Boolean.valueOf(paramString.isSharingLocation()) });
    }
    return paramString.isSharingLocation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.util.LocationProtoUtil
 * JD-Core Version:    0.7.0.1
 */