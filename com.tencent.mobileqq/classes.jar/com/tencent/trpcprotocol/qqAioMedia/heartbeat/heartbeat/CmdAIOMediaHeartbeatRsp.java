package com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.aio.media.aio_media.ResultInfo;

public final class CmdAIOMediaHeartbeatRsp
  extends MessageMicro<CmdAIOMediaHeartbeatRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_result", "interval" }, new Object[] { null, Integer.valueOf(0) }, CmdAIOMediaHeartbeatRsp.class);
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqAioMedia.heartbeat.heartbeat.CmdAIOMediaHeartbeatRsp
 * JD-Core Version:    0.7.0.1
 */