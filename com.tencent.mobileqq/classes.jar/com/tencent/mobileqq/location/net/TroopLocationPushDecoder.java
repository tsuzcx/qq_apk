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
  public static void a(TroopLbsSharePushInfo paramTroopLbsSharePushInfo)
  {
    long l = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    LocationShareRoomManager.a().a.a(1, String.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onPushRoomMemberChanged: invoked. ", " troopUin: ", Long.valueOf(l) });
    }
  }
  
  public static void a(TroopLbsSharePushInfo paramTroopLbsSharePushInfo, int paramInt)
  {
    long l1 = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    long l2 = paramTroopLbsSharePushInfo.b;
    paramTroopLbsSharePushInfo = new LocationRoom.RoomKey(1, String.valueOf(l1));
    LocationShareRoomManager.a().a.a(1, String.valueOf(l1));
    switch (paramInt)
    {
    default: 
      break;
    case 103: 
      LocationShareVenueManager.a().b(paramTroopLbsSharePushInfo);
      break;
    case 102: 
      LocationShareVenueManager.a().a(paramTroopLbsSharePushInfo);
      break;
    case 101: 
      LocationShareVenueManager.a().a(paramTroopLbsSharePushInfo, String.valueOf(l2));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTroopLbsSharePushInfo);
      localStringBuilder.append(" opt: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" optUin: ");
      localStringBuilder.append(l2);
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "[venue] troop onPushRoomVenueChanged: invoked. roomKey: ", localStringBuilder.toString() });
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, TroopLbsSharePushInfo paramTroopLbsSharePushInfo)
  {
    long l1 = paramTroopLbsSharePushInfo.jdField_a_of_type_Long;
    int j = paramTroopLbsSharePushInfo.jdField_a_of_type_Int;
    int i = 4;
    Integer localInteger = Integer.valueOf(1);
    if (j == 4)
    {
      LocationHandler.a().notifyUI(5, true, new Object[] { localInteger, String.valueOf(l1) });
      ((ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyStateNormalClose(1, l1);
      LocationProtoUtil.a(paramAppRuntime, 1, String.valueOf(l1), false);
    }
    else if ((j != 1) && (j != 2))
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
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        LocationHandler.a().notifyUI(6, true, new Object[] { localInteger, String.valueOf(l1), Integer.valueOf(i) });
        ((ILocationShareService)paramAppRuntime.getRuntimeService(ILocationShareService.class, "")).notifyUserSwitchPhone(1, l1);
      }
      else if (j == 3)
      {
        long l2 = paramTroopLbsSharePushInfo.b;
        if (QLog.isColorLevel()) {
          QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onDecodeTroopLbsUserQuitRoom: invoked. ", " operateUin: ", Long.valueOf(l2), " sessionUin: ", Long.valueOf(l1) });
        }
        if (l2 == paramAppRuntime.getLongAccountUin()) {
          LocationShareLocationManager.a().a(new LocationRoom.RoomKey(1, String.valueOf(l1)), false);
        }
      }
    }
    else
    {
      LocationProtoUtil.a(paramAppRuntime, 1, String.valueOf(l1), true);
    }
    LocationHandler.a().notifyUI(3, true, new Object[] { paramTroopLbsSharePushInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.TroopLocationPushDecoder
 * JD-Core Version:    0.7.0.1
 */