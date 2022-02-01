package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomRsp;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class VoiceRoomService$1
  implements ChannelCallback
{
  VoiceRoomService$1(VoiceRoomService paramVoiceRoomService, EnterExitRoomCallback paramEnterExitRoomCallback, int paramInt) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    VoiceRoomService.c(this.c).getLogger().e("AbstractCustomRoomService", "onError,isTimeout[%s] code[%d] msg[%s]", new Object[] { String.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString });
    if (this.b > 0)
    {
      ThreadCenter.postDefaultUITask(new VoiceRoomService.1.1(this), 1000L);
      return;
    }
    this.a.onFail(paramInt, paramString);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    pbenterroom.EnterRoomRsp localEnterRoomRsp = new pbenterroom.EnterRoomRsp();
    try
    {
      localEnterRoomRsp.mergeFrom(paramArrayOfByte);
      if ((localEnterRoomRsp.result.get() == 0) && (VoiceRoomService.a(this.c, localEnterRoomRsp, VoiceRoomService.a(this.c))))
      {
        VoiceRoomService.a(this.c, this.a);
        return;
      }
      onError(false, localEnterRoomRsp.result.get(), localEnterRoomRsp.err_msg.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label74:
      break label74;
    }
    VoiceRoomService.b(this.c).getLogger().e("AbstractCustomRoomService", "enterRoom,Exception:", new Object[0]);
    onError(false, -1, "enterRoom Exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomService.1
 * JD-Core Version:    0.7.0.1
 */