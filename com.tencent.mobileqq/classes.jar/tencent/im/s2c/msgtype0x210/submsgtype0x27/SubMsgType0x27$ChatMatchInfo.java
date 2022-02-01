package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$ChatMatchInfo
  extends MessageMicro<ChatMatchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_c2c_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64, 72, 82 }, new String[] { "bytes_sig", "uint64_uin", "uint64_match_uin", "bytes_tips_wording", "uint32_left_chat_time", "uint64_time_stamp", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint32_match_count", "bytes_nick" }, new Object[] { localByteStringMicro1, localLong, localLong, localByteStringMicro2, localInteger, localLong, localInteger, localInteger, localInteger, localByteStringMicro3 }, ChatMatchInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ChatMatchInfo
 * JD-Core Version:    0.7.0.1
 */