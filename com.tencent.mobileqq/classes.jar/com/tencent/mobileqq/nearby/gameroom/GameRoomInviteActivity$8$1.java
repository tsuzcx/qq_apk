package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class GameRoomInviteActivity$8$1
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$8$1(GameRoomInviteActivity.8 param8) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.poi_info;
      String str = paramRspBody.bytes_uid.get().toStringUtf8();
      this.a.b.gotoGameChatPie(HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), str, paramRspBody.bytes_name.get().toStringUtf8());
      return;
    }
    this.a.b.handle8e4Error(paramInt, paramRspBody, HardCodeUtil.a(2131903057));
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("start game failed! code = ");
      paramRspBody.append(paramInt);
      QLog.d("GameRoomInviteActivity", 2, paramRspBody.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.8.1
 * JD-Core Version:    0.7.0.1
 */