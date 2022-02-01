package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc26$MayKnowPerson
  extends MessageMicro<MayKnowPerson>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_additive = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_catelogue = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mobile_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_richbuffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xc26.AddFriendSource msg_android_source = new oidb_0xc26.AddFriendSource();
  public oidb_0xc26.AddFriendSource msg_ios_source = new oidb_0xc26.AddFriendSource();
  public final PBRepeatMessageField<oidb_0xc26.Label> rpt_msg_labels = PBField.initRepeatMessage(oidb_0xc26.Label.class);
  public final PBStringField str_token = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_online_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qzone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sourceid = PBField.initUInt32(0);
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
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 152, 162, 168 }, new String[] { "uint64_uin", "msg_ios_source", "msg_android_source", "bytes_reason", "bytes_additive", "bytes_nick", "bytes_remark", "bytes_country", "bytes_province", "bytes_city", "uint32_age", "bytes_catelogue", "bytes_alghrithm", "bytes_richbuffer", "uint32_qzone", "uint32_gender", "bytes_mobile_name", "str_token", "uint32_online_state", "rpt_msg_labels", "uint32_sourceid" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localInteger, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localInteger, localInteger, localByteStringMicro11, "", localInteger, null, localInteger }, MayKnowPerson.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.MayKnowPerson
 * JD-Core Version:    0.7.0.1
 */