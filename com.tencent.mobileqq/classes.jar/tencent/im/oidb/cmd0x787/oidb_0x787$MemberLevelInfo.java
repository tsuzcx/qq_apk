package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787$MemberLevelInfo
  extends MessageMicro<MemberLevelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_honor = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_job = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_need_field = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flagex3_grocery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_global_group_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_membership = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rich_card_name_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ringtone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torchbearer_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106, 112, 120, 128, 136, 144, 152, 160, 170, 176, 186, 192 }, new String[] { "uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "str_name", "bytes_nick_name", "bytes_special_title", "uint32_special_title_expire_time", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_glamour_level", "uint32_torchbearer_flag", "uint32_global_group_level", "uint32_title_id", "uint32_global_group_point", "uint32_rich_card_name_ver", "uint32_ringtone_id", "bytes_group_honor", "uint32_membership", "bytes_msg_need_field", "uint32_cmduin_flagex3_grocery" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0) }, MemberLevelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo
 * JD-Core Version:    0.7.0.1
 */