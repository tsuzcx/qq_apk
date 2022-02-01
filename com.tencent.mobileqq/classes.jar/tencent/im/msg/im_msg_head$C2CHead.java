package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_head$C2CHead
  extends MessageMicro<C2CHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_auth_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_auth_pic_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_auth_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_phone_number = PBField.initString("");
  public final PBUInt32Field uint32_cc_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cc_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 72, 80, 90 }, new String[] { "uint64_to_uin", "uint64_from_uin", "uint32_cc_type", "uint32_cc_cmd", "bytes_auth_pic_sig", "bytes_auth_sig", "bytes_auth_buf", "uint32_server_time", "uint32_client_time", "uint32_rand", "string_phone_number" }, new Object[] { localLong, localLong, localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, localInteger, "" }, C2CHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_head.C2CHead
 * JD-Core Version:    0.7.0.1
 */