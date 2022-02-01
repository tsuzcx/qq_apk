package tencent.im.c2c.msgtype0xa6.submsgtype0xc1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0xc1$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0xc1.NotOnlineImage not_online_image = new SubMsgType0xc1.NotOnlineImage();
  public final PBUInt32Field uint32_encrypt_prehead_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_encrypt_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98 }, new String[] { "bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image" }, new Object[] { localByteStringMicro1, localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro2, localInteger, localInteger, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.c2c.msgtype0xa6.submsgtype0xc1.SubMsgType0xc1.MsgBody
 * JD-Core Version:    0.7.0.1
 */