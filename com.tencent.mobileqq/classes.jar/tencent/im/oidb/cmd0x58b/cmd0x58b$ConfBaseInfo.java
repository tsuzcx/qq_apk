package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58b$ConfBaseInfo
  extends MessageMicro<ConfBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_conf_meeting_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_meeting_origin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_info_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qidian_conf_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_inherit_owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "uint64_conf_uin", "uint32_err_code", "bytes_conf_name", "uint32_create_time", "uint64_owner_uin", "uint32_info_seq", "uint32_last_info_time", "uint32_msg_seq", "uint32_last_msg_time", "uint32_member_num", "uint32_flag", "uint64_inherit_owner_uin", "uint64_group_code", "uint64_group_uin", "uint32_conf_meeting_origin", "uint32_qidian_conf_type", "uint32_conf_meeting_option" }, new Object[] { localLong, localInteger, localByteStringMicro, localInteger, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localLong, localLong, localLong, localInteger, localInteger, localInteger }, ConfBaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.ConfBaseInfo
 * JD-Core Version:    0.7.0.1
 */