package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x76$OneMemorialDayInfo
  extends MessageMicro<OneMemorialDayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_greetings = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_main_wording_event = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_main_wording_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_friend_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_memorial_time = PBField.initUInt32(0);
  public final PBUInt64Field uint32_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120 }, new String[] { "uint64_uin", "uint32_type", "uint32_memorial_time", "bytes_main_wording_nick", "bytes_main_wording_event", "bytes_sub_wording", "bytes_greetings", "uint32_friend_gender" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, OneMemorialDayInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo
 * JD-Core Version:    0.7.0.1
 */