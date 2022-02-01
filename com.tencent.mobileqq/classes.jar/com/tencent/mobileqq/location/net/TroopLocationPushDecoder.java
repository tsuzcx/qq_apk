package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.location.qq_lbs_share.PushExtInfo;

public class TroopLocationPushDecoder
{
  static void a(TroopLbsSharePushInfo paramTroopLbsSharePushInfo)
  {
    LocationHandler localLocationHandler = LocationHandler.a();
    long l = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    localLocationHandler.a.a(1, String.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onPushRoomMemberChanged: invoked. ", " troopUin: ", Long.valueOf(l) });
    }
  }
  
  public static void a(TroopLbsSharePushInfo paramTroopLbsSharePushInfo, int paramInt)
  {
    LocationHandler localLocationHandler = LocationHandler.a();
    long l1 = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    long l2 = paramTroopLbsSharePushInfo.b;
    paramTroopLbsSharePushInfo = new LocationRoom.RoomKey(1, String.valueOf(l1));
    localLocationHandler.a.a(1, String.valueOf(l1));
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLocationPushDecoder", 2, new Object[] { "[venue] troop onPushRoomVenueChanged: invoked. roomKey: ", paramTroopLbsSharePushInfo + " opt: " + paramInt + " optUin: " + l2 });
      }
      return;
      localLocationHandler.a(paramTroopLbsSharePushInfo, String.valueOf(l2));
      continue;
      localLocationHandler.b(paramTroopLbsSharePushInfo);
      continue;
      localLocationHandler.c(paramTroopLbsSharePushInfo);
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onDecodeTroopLbsUserQuitRoom: invoked. ", " operateUin: ", Long.valueOf(paramLong1), " sessionUin: ", Long.valueOf(paramLong2) });
    }
    if (paramLong1 == paramAppRuntime.getLongAccountUin()) {
      LocationHandler.a().a(new LocationRoom.RoomKey(1, String.valueOf(paramLong2)), false);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, TroopLbsSharePushInfo paramTroopLbsSharePushInfo)
  {
    int i = 4;
    LocationHandler localLocationHandler = LocationHandler.a();
    long l = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    int j = paramTroopLbsSharePushInfo.jdField_a_of_type_Int;
    if (j == 4)
    {
      localLocationHandler.notifyUI(5, true, new Object[] { Integer.valueOf(1), String.valueOf(l) });
      ((ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateNormalClose(1, l);
      LocationProtoUtil.a(paramAppRuntime, 1, String.valueOf(l), false);
    }
    for (;;)
    {
      localLocationHandler.notifyUI(3, true, new Object[] { paramTroopLbsSharePushInfo });
      return;
      if ((j == 1) || (j == 2))
      {
        LocationProtoUtil.a(paramAppRuntime, 1, String.valueOf(l), true);
      }
      else
      {
        if (j == 5)
        {
          try
          {
            byte[] arrayOfByte = paramTroopLbsSharePushInfo.jdField_a_of_type_ArrayOfByte;
            qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
            localPushExtInfo.mergeFrom(arrayOfByte);
            j = localPushExtInfo.client_type.get();
            i = j;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
          localLocationHandler.notifyUI(6, true, new Object[] { Integer.valueOf(1), String.valueOf(l), Integer.valueOf(i) });
          ((ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyUserSwitchPhone(1, l);
          continue;
        }
        if (j == 3) {
          a(paramAppRuntime, paramTroopLbsSharePushInfo.b, l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.TroopLocationPushDecoder
 * JD-Core Version:    0.7.0.1
 */