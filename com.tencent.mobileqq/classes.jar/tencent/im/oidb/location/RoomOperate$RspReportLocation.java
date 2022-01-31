package tencent.im.oidb.location;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RoomOperate$RspReportLocation
  extends MessageMicro<RspReportLocation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_result", "req_interval" }, new Object[] { null, Integer.valueOf(0) }, RspReportLocation.class);
  public qq_lbs_share.ResultInfo msg_result = new qq_lbs_share.ResultInfo();
  public final PBUInt32Field req_interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.location.RoomOperate.RspReportLocation
 * JD-Core Version:    0.7.0.1
 */