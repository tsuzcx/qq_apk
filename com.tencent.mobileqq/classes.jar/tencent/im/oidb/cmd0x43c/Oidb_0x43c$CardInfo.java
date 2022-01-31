package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$CardInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bind_mbl = PBField.initString("");
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField card_src = PBField.initEnum(1);
  public final PBStringField company = PBField.initString("");
  public final PBRepeatField descs = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field last_update_time = PBField.initUInt32(0);
  public final PBRepeatMessageField mobile_info = PBField.initRepeatMessage(Oidb_0x43c.MobileInfo.class);
  public final PBRepeatField mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField name = PBField.initString("");
  public Oidb_0x43c.OCRInfo ocr_info = new Oidb_0x43c.OCRInfo();
  public final PBStringField pic_url = PBField.initString("");
  public final PBRepeatMessageField uin_info = PBField.initRepeatMessage(Oidb_0x43c.UinInfo.class);
  public final PBRepeatField uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106, 114 }, new String[] { "card_id", "pic_url", "name", "company", "uins", "mobiles", "descs", "bind_uin", "card_src", "last_update_time", "ocr_info", "mobile_info", "uin_info", "bind_mbl" }, new Object[] { localByteStringMicro, "", "", "", Long.valueOf(0L), "", "", Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, null, null, "" }, CardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo
 * JD-Core Version:    0.7.0.1
 */