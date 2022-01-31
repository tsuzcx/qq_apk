package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype21$GroupConfessContext
  extends MessageMicro<GroupConfessContext>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_confess_to_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_confessor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_confess_to_nick_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 82 }, new String[] { "uint64_confessor_uin", "uint64_confess_to_uin", "uint64_send_uin", "uint32_confessor_sex", "bytes_confess_to_nick", "bytes_topic", "uint32_topic_id", "uint64_confess_time", "uint32_confess_to_nick_type", "bytes_confessor_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3 }, GroupConfessContext.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext
 * JD-Core Version:    0.7.0.1
 */