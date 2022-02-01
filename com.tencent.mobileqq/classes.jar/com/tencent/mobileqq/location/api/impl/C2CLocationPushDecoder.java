package com.tencent.mobileqq.location.api.impl;

import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
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
    LocationHandler localLocationHandler = LocationHandler.a();
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
    try
    {
      localPushExtInfo.mergeFrom(paramMsgBody);
      long l = localPushExtInfo.peer_uin.get();
      localLocationHandler.a.a(0, String.valueOf(l));
      return;
    }
    catch (Exception paramMsgBody)
    {
      QLog.e("C2CLocationPushDecoder", 1, "onPushRoomMemberChanged: failed. ", paramMsgBody);
    }
  }
  
  public static void a(submsgtype0x125.MsgBody paramMsgBody, int paramInt)
  {
    LocationHandler localLocationHandler = LocationHandler.a();
    long l1 = paramMsgBody.uint64_oper_uin.get();
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
    for (;;)
    {
      try
      {
        localPushExtInfo.mergeFrom(paramMsgBody);
        long l2 = localPushExtInfo.peer_uin.get();
        paramMsgBody = new LocationRoom.RoomKey(0, String.valueOf(l2));
        localLocationHandler.a.a(0, String.valueOf(l2));
        switch (paramInt)
        {
        case 101: 
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("C2CLocationPushDecoder", 2, new Object[] { "[venue] c2c onPushRoomVenueChanged: invoked. roomKey: ", paramMsgBody + " opt: " + paramInt + " optUin: " + l1 });
          return;
        }
      }
      catch (Exception paramMsgBody)
      {
        QLog.e("C2CLocationPushDecoder", 1, "[venue] c2c onPushRoomVenueChanged: failed. opt: " + paramInt + " optUin: " + l1, paramMsgBody);
        return;
      }
      localLocationHandler.a(paramMsgBody, String.valueOf(l1));
      continue;
      localLocationHandler.b(paramMsgBody);
      continue;
      localLocationHandler.c(paramMsgBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.C2CLocationPushDecoder
 * JD-Core Version:    0.7.0.1
 */