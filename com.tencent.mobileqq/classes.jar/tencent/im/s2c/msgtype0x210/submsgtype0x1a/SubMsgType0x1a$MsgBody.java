package tencent.im.s2c.msgtype0x210.submsgtype0x1a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x1a$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_desc = PBField.initString("");
  public final PBUInt32Field uint32_capture_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 80 }, new String[] { "bytes_file_key", "uint32_from_uin", "uint32_to_uin", "uint32_status", "uint32_ttl", "string_desc", "uint32_type", "uint32_capture_times", "uint64_from_uin", "uint64_to_uin" }, new Object[] { localByteStringMicro, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localLong, localLong }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x1a.SubMsgType0x1a.MsgBody
 * JD-Core Version:    0.7.0.1
 */