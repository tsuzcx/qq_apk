package tencent.im.s2c.msgtype0x210.submsgtype0x126;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x126$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 802 }, new String[] { "uint64_msg_seq", "uint32_msg_type", "str_msg_info", "bytes_ext_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody
 * JD-Core Version:    0.7.0.1
 */