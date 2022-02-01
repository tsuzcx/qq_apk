package tencent.im.label.comm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm$LabelInfo
  extends MessageMicro<LabelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_photo_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<PersonalityTagComm.PraiseUserInfo> rpt_last_praise_uins_info = PBField.initRepeatMessage(PersonalityTagComm.PraiseUserInfo.class);
  public final PBRepeatMessageField<PersonalityTagComm.LabelPhoto> rpt_msg_photo = PBField.initRepeatMessage(PersonalityTagComm.LabelPhoto.class);
  public final PBStringField str_bg_color = PBField.initString("");
  public final PBStringField str_cover_photo_url = PBField.initString("");
  public final PBStringField str_fg_color = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_category = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_photo_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_praise = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90, 96, 104, 112, 122 }, new String[] { "uint32_add_time", "uint64_id", "uint32_category", "str_text", "str_fg_color", "str_bg_color", "str_cover_photo_url", "uint32_praise_count", "uint32_photo_count", "rpt_msg_photo", "bytes_photo_cookie", "uint32_unread_praise", "uint32_mod_time", "uint32_praise_flag", "rpt_last_praise_uins_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, LabelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.LabelInfo
 * JD-Core Version:    0.7.0.1
 */