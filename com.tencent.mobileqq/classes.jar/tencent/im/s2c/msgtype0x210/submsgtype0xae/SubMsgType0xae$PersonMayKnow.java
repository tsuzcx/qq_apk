package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xae$PersonMayKnow
  extends MessageMicro<PersonMayKnow>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_main_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_soure_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0xae.AddFriendSource msg_android_source = new SubMsgType0xae.AddFriendSource();
  public SubMsgType0xae.AddFriendSource msg_ios_source = new SubMsgType0xae.AddFriendSource();
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_game_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 64, 74, 82, 90, 96, 106 }, new String[] { "uint64_uin", "bytes_name", "uint32_age", "uint32_sex", "bytes_main_reason", "bytes_soure_reason", "bytes_alghrithm", "uint32_source", "msg_ios_source", "msg_android_source", "bytes_msg", "uint32_game_source", "bytes_role_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, null, null, localByteStringMicro5, localInteger, localByteStringMicro6 }, PersonMayKnow.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow
 * JD-Core Version:    0.7.0.1
 */