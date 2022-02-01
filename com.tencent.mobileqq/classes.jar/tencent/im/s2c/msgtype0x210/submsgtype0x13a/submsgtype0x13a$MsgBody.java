package tencent.im.s2c.msgtype0x210.submsgtype0x13a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x13a$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_push_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public submsgtype0x13a.SystemNotify msg_system_notify = new submsgtype0x13a.SystemNotify();
  public final PBUInt32Field uint32_push_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_push_type", "bytes_push_data", "uint32_timestamp", "msg_system_notify" }, new Object[] { localInteger, localByteStringMicro, localInteger, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody
 * JD-Core Version:    0.7.0.1
 */