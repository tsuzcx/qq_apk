package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_admin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_owner_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x787.LevelName> rpt_msg_level_name = PBField.initRepeatMessage(oidb_0x787.LevelName.class);
  public final PBRepeatMessageField<oidb_0x787.MemberLevelInfo> rpt_msg_member_level_info = PBField.initRepeatMessage(oidb_0x787.MemberLevelInfo.class);
  public final PBUInt32Field uint32_level_name_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_show_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_to_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_data_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 104 }, new String[] { "uint64_group_code", "rpt_msg_member_level_info", "rpt_msg_level_name", "uint64_end_uin", "uint64_data_time", "uint32_user_show_flag", "uint32_sys_show_flag", "uint32_time_to_update", "bytes_owner_name", "bytes_admin_name", "uint32_seq", "uint32_office_mode", "uint32_level_name_seq" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.RspBody
 * JD-Core Version:    0.7.0.1
 */