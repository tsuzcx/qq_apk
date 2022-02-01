package tencent.im.s2c.msgtype0x210.submsgtype0x115;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x115$NotifyItem
  extends MessageMicro<NotifyItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_event_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timeout_s = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_ime", "uint32_timeout_s", "uint64_timestamp", "uint32_event_type", "uint32_interval", "bytes_wording" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localInteger, localInteger, localByteStringMicro }, NotifyItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x115.SubMsgType0x115.NotifyItem
 * JD-Core Version:    0.7.0.1
 */