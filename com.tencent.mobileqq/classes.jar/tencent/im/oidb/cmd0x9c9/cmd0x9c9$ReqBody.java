package tencent.im.oidb.cmd0x9c9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9c9$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hometown = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_hometown_district = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_location_district = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reqbody_5ea = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reqbody_9c7 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stranger_declare = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_college = PBField.initString("");
  public final PBStringField str_company = PBField.initString("");
  public final PBStringField str_nick = PBField.initString("");
  public final PBStringField str_stranger_nick = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guide_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interest_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_love_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qzone_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stranger_profile_flag = PBField.initUInt32(0);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 160018, 160072, 160170, 160176, 160258, 160296, 160330, 160346, 192018, 192066, 208026, 216274, 216282, 216288, 216296, 322488, 322496, 323968, 334448, 335896, 335984, 480010, 480018 }, new String[] { "str_nick", "uint32_gender", "str_college", "uint32_constellation", "bytes_location", "uint32_age", "bytes_location_district", "bytes_hometown_district", "bytes_hometown", "str_company", "bytes_birthday", "str_stranger_nick", "bytes_stranger_declare", "uint32_love_status", "uint32_profession", "uint32_qzone_visible", "uint32_interest_visible", "uint32_stranger_profile_flag", "uint32_gift_visible", "uint32_face_flag", "uint32_guide_flag", "bytes_reqbody_5ea", "bytes_reqbody_9c7" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, "", localByteStringMicro5, "", localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody
 * JD-Core Version:    0.7.0.1
 */