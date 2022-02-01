package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x8fc$MemberInfo
  extends MessageMicro<MemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comm_rich_card_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_honor = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_job = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField member_card_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Oidb_0x8fc.CardNameElem> rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc.CardNameElem.class);
  public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flag_ex3_grocery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flag_ex3_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ringtone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tribe_point = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138, 144, 154, 160, 168 }, new String[] { "uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "bytes_special_title", "uint32_special_title_expire_time", "bytes_uin_name", "member_card_name", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_tribe_level", "uint32_tribe_point", "rpt_rich_card_name", "bytes_comm_rich_card_name", "uint32_ringtone_id", "bytes_group_honor", "uint32_cmduin_flag_ex3_grocery", "uint32_cmduin_flag_ex3_mask" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localInteger, localByteStringMicro7, localInteger, localInteger, null, localByteStringMicro8, localInteger, localByteStringMicro9, localInteger, localInteger }, MemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo
 * JD-Core Version:    0.7.0.1
 */