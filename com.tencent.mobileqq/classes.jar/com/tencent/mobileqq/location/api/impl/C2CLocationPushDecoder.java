package com.tencent.mobileqq.location.api.impl;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.location.net.LocationShareVenueManager;
import com.tencent.mobileqq.location.net.RoomQueryHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.location.qq_lbs_share.PushExtInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

public class C2CLocationPushDecoder
{
  public static void a(submsgtype0x125.MsgBody paramMsgBody)
  {
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
    try
    {
      localPushExtInfo.mergeFrom(paramMsgBody);
      long l = localPushExtInfo.peer_uin.get();
      LocationShareRoomManager.a().c.a(0, String.valueOf(l));
      return;
    }
    catch (Exception paramMsgBody)
    {
      QLog.e("C2CLocationPushDecoder", 1, "onPushRoomMemberChanged: failed. ", paramMsgBody);
    }
  }
  
  public static void a(submsgtype0x125.MsgBody paramMsgBody, int paramInt)
  {
    long l1 = paramMsgBody.uint64_oper_uin.get();
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    Object localObject = new qq_lbs_share.PushExtInfo();
    for (;;)
    {
      try
      {
        ((qq_lbs_share.PushExtInfo)localObject).mergeFrom(paramMsgBody);
        long l2 = ((qq_lbs_share.PushExtInfo)localObject).peer_uin.get();
        paramMsgBody = new LocationRoom.RoomKey(0, String.valueOf(l2));
        LocationShareRoomManager.a().c.a(0, String.valueOf(l2));
        switch (paramInt)
        {
        case 103: 
          LocationShareVenueManager.a().b(paramMsgBody);
          break;
        case 102: 
          LocationShareVenueManager.a().a(paramMsgBody);
          break;
        case 101: 
          LocationShareVenueManager.a().a(paramMsgBody, String.valueOf(l1));
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramMsgBody);
            ((StringBuilder)localObject).append(" opt: ");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(" optUin: ");
            ((StringBuilder)localObject).append(l1);
            QLog.d("C2CLocationPushDecoder", 2, new Object[] { "[venue] c2c onPushRoomVenueChanged: invoked. roomKey: ", ((StringBuilder)localObject).toString() });
            return;
          }
          break;
        }
      }
      catch (Exception paramMsgBody)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[venue] c2c onPushRoomVenueChanged: failed. opt: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" optUin: ");
        ((StringBuilder)localObject).append(l1);
        QLog.e("C2CLocationPushDecoder", 1, ((StringBuilder)localObject).toString(), paramMsgBody);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.C2CLocationPushDecoder
 * JD-Core Version:    0.7.0.1
 */