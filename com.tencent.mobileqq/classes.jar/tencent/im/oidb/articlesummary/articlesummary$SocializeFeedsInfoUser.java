package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public final class articlesummary$SocializeFeedsInfoUser
  extends MessageMicro<SocializeFeedsInfoUser>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_person_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_uin_type = PBField.initEnum(0);
  public final PBRepeatMessageField<oidb_cmd0xb57.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0xb57.MedalInfo.class);
  public final PBUInt32Field uint32_star_style = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_uin", "enum_uin_type", "uint32_star_style", "bytes_person_desc", "rpt_msg_medal_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, SocializeFeedsInfoUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser
 * JD-Core Version:    0.7.0.1
 */