package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgBox$ReportReq
  extends MessageMicro<ReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "guild_id", "channel_id", "msg_seq" }, new Object[] { localLong, localLong, localLong }, ReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msg_box.MsgBox.ReportReq
 * JD-Core Version:    0.7.0.1
 */