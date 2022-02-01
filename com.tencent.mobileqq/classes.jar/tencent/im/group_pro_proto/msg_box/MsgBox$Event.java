package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgBox$Event
  extends MessageMicro<Event>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field event_random = PBField.initUInt64(0L);
  public final PBUInt64Field event_type = PBField.initUInt64(0L);
  public final PBUInt64Field from_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "event_type", "msg_seq", "from_tinyid", "event_random" }, new Object[] { localLong, localLong, localLong, localLong }, Event.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msg_box.MsgBox.Event
 * JD-Core Version:    0.7.0.1
 */