package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype24$LimitChatEnter
  extends MessageMicro<LimitChatEnter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_match_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_c2c_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_expired_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_match_ts = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ready_ts = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58 }, new String[] { "bytes_tips_wording", "uint32_left_chat_time", "uint64_match_ts", "uint32_match_expired_time", "uint32_c2c_expired_time", "uint64_ready_ts", "bytes_match_nick" }, new Object[] { localByteStringMicro1, localInteger, localLong, localInteger, localInteger, localLong, localByteStringMicro2 }, LimitChatEnter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter
 * JD-Core Version:    0.7.0.1
 */