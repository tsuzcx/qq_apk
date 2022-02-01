package com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services;

import com.tencent.TMG.utils.QLog;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.odroom.ODRoomSwitchProto.RcmdRoomSwitchRsp;

class ODRoomSwitchService$1
  implements ChannelCallback
{
  ODRoomSwitchService$1(ODRoomSwitchService paramODRoomSwitchService, ODRoomSwitchService.IGetNeighborRoomListener paramIGetNeighborRoomListener) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    ODRoomSwitchProto.RcmdRoomSwitchRsp localRcmdRoomSwitchRsp = new ODRoomSwitchProto.RcmdRoomSwitchRsp();
    try
    {
      localRcmdRoomSwitchRsp.mergeFrom(paramArrayOfByte);
      int i = localRcmdRoomSwitchRsp.ret.get();
      if (i == 0)
      {
        paramArrayOfByte = ODRoomSwitchService.a(this.b, localRcmdRoomSwitchRsp);
        this.a.a(paramArrayOfByte);
        return;
      }
      this.a.a(i, "get rooms onRecv data error");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ODRoomSwitchService", 0, "InvalidProtocolBufferMicroException ", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */