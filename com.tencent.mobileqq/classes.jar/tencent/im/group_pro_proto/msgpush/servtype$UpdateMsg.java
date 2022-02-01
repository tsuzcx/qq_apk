package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$UpdateMsg
  extends MessageMicro<UpdateMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_orig_msg_uncountable = PBField.initBool(false);
  public final PBUInt64Field uint64_event_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_event_version = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_msg_seq", "bool_orig_msg_uncountable", "uint64_event_type", "uint64_event_version" }, new Object[] { localLong, Boolean.valueOf(false), localLong, localLong }, UpdateMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.UpdateMsg
 * JD-Core Version:    0.7.0.1
 */