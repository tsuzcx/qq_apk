package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common.Event;

public final class msg_event$AddReq
  extends MessageMicro<AddReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public common.Event event = new common.Event();
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "guild_id", "channel_id", "msg_seq", "event" }, new Object[] { localLong, localLong, localLong, null }, AddReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.eventflow.msg_event.AddReq
 * JD-Core Version:    0.7.0.1
 */