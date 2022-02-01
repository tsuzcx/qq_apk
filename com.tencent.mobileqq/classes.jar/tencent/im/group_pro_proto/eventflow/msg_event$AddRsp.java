package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common.Event;

public final class msg_event$AddRsp
  extends MessageMicro<AddRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "event_version", "events" }, new Object[] { Long.valueOf(0L), null }, AddRsp.class);
  public final PBUInt64Field event_version = PBField.initUInt64(0L);
  public final PBRepeatMessageField<common.Event> events = PBField.initRepeatMessage(common.Event.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.eventflow.msg_event.AddRsp
 * JD-Core Version:    0.7.0.1
 */