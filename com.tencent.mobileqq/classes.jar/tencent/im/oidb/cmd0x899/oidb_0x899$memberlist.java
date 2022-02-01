package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x899$memberlist
  extends MessageMicro<memberlist>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rich_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uin_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flagex2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_speak_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_privilege = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_arch_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_flagex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_mobile_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 138, 144, 154 }, new String[] { "uint64_member_uin", "uint32_uin_flag", "uint32_uin_flagex", "uint32_uin_mobile_flag", "uint32_uin_arch_flag", "uint32_join_time", "uint32_old_msg_seq", "uint32_new_msg_seq", "uint32_last_speak_time", "uint32_level", "uint32_point", "uint32_shutup_timestap", "uint32_flagex2", "bytes_special_title", "uint32_special_title_expire_time", "uint32_active_day", "bytes_uin_key", "uint32_privilege", "bytes_rich_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, memberlist.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x899.oidb_0x899.memberlist
 * JD-Core Version:    0.7.0.1
 */