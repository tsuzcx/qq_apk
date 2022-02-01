package tencent.im.s2c.msgtype0x210.submsgtype0x66;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x66$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_notify_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_push_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_push_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uint32_type", "bytes_push_data", "uint32_timestamp", "bytes_notify_text", "uint32_push_flag" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x66.submsgtype0x66.MsgBody
 * JD-Core Version:    0.7.0.1
 */