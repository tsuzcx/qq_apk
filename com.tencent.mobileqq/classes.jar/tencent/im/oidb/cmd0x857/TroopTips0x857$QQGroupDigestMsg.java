package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$QQGroupDigestMsg
  extends MessageMicro<QQGroupDigestMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field digest_oper = PBField.initUInt64(0L);
  public final PBInt32Field ext_info = PBField.initInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field lastest_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt64Field msg_sender = PBField.initUInt64(0L);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field op_time = PBField.initUInt32(0);
  public final PBInt32Field op_type = PBField.initInt32(0);
  public final PBBytesField oper_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sender_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 74, 82, 88 }, new String[] { "group_code", "msg_seq", "msg_random", "op_type", "msg_sender", "digest_oper", "op_time", "lastest_msg_seq", "oper_nick", "sender_nick", "ext_info" }, new Object[] { localLong, localInteger, localInteger, localInteger, localLong, localLong, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, QQGroupDigestMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg
 * JD-Core Version:    0.7.0.1
 */