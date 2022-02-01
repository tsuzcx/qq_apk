package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$SetAdmin
  extends MessageMicro<SetAdmin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_operate_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_admin_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_admin_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_chan_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guild_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_guild_id", "uint64_chan_id", "uint64_operator_id", "uint64_admin_id", "uint64_admin_tinyid", "uint32_operate_type" }, new Object[] { localLong, localLong, localLong, localLong, localLong, Integer.valueOf(0) }, SetAdmin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.SetAdmin
 * JD-Core Version:    0.7.0.1
 */