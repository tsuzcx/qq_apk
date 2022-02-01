package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$JoinGuild
  extends MessageMicro<JoinGuild>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_member_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_member_tinyid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24, 32, 40 }, new String[] { "uint64_member_id", "uint32_member_type", "uint64_member_tinyid" }, new Object[] { localLong, Integer.valueOf(0), localLong }, JoinGuild.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.JoinGuild
 * JD-Core Version:    0.7.0.1
 */