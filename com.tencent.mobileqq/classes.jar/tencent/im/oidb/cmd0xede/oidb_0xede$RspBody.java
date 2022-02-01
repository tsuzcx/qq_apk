package tencent.im.oidb.cmd0xede;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xede$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0xede.GroupInfo> rpt_group_info = PBField.initRepeatMessage(oidb_0xede.GroupInfo.class);
  public final PBBytesField str_alliance_admin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_info_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_alliance_admin_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_alliance_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_next_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72, 82, 88 }, new String[] { "uint64_group_code", "uint32_type", "uint32_result", "str_err_msg", "rpt_group_info", "uint64_next_group_code", "uint32_group_info_size", "uint64_alliance_id", "uint64_alliance_admin_uin", "str_alliance_admin_name", "uint64_alliance_create_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xede.oidb_0xede.RspBody
 * JD-Core Version:    0.7.0.1
 */