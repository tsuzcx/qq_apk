package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_event$GetRsp
  extends MessageMicro<GetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field begin_time = PBField.initUInt64(0L);
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBUInt64Field err_code = PBField.initUInt64(0L);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<msg_event.MsgEvent> msg_events = PBField.initRepeatMessage(msg_event.MsgEvent.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "err_code", "err_msg", "msg_events", "cookie", "begin_time", "end_time" }, new Object[] { localLong, localByteStringMicro1, null, localByteStringMicro2, localLong, localLong }, GetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.eventflow.msg_event.GetRsp
 * JD-Core Version:    0.7.0.1
 */