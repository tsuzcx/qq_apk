package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

class GameRoomFloatView$4
  extends WerewolvesObserver
{
  GameRoomFloatView$4(GameRoomFloatView paramGameRoomFloatView) {}
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_msg_type.get();
    if (i != 2)
    {
      if (i != 3) {
        return;
      }
      QQToast.makeText(this.a.c, HardCodeUtil.a(2131903058), 0).show();
      paramMsgBody = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramMsgBody != null) && ((paramMsgBody instanceof QQAppInterface)))
      {
        paramMsgBody = (QQAppInterface)paramMsgBody;
        SharedPreUtils.a(this.a.c, paramMsgBody.getCurrentAccountUin(), false, System.currentTimeMillis());
      }
    }
    else
    {
      paramMsgBody = (submsgtype0xdd.MsgBody.WifiPOIInfo)paramMsgBody.msg_poi_info.get();
      String str = paramMsgBody.bytes_uid.get().toStringUtf8();
      this.a.a(HotChatInfo.createHotChat(paramMsgBody, false, 0), paramMsgBody.uint32_group_code.get(), str, paramMsgBody.bytes_name.get().toStringUtf8());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView.4
 * JD-Core Version:    0.7.0.1
 */