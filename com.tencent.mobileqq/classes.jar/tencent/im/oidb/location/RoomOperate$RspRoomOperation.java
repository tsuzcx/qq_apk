package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class RoomOperate$RspRoomOperation
  extends MessageMicro<RspRoomOperation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspRoomOperation.class);
  public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.RspRoomOperation
 * JD-Core Version:    0.7.0.1
 */