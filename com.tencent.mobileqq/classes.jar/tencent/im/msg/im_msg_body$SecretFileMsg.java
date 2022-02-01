package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$SecretFileMsg
  extends MessageMicro<SecretFileMsg>
{
  public static final int TYPE_C2C = 0;
  public static final int TYPE_DISCU = 4;
  public static final int TYPE_GROUP = 2;
  public static final int TYPE_NEARBA = 3;
  public static final int TYPE_WPA = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public im_msg_body.ElemFlags2 elem_flags2 = new im_msg_body.ElemFlags2();
  public im_msg_body.NotOnlineImage not_online_image = new im_msg_body.NotOnlineImage();
  public final PBStringField str_fromphonenum = PBField.initString("");
  public final PBUInt32Field uint32_encrypt_prehead_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_encrypt_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_left_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_opertype = PBField.initUInt32(0);
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
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 80, 88, 98, 106, 112, 122 }, new String[] { "bytes_file_key", "uint64_from_uin", "uint64_to_uin", "uint32_status", "uint32_ttl", "uint32_type", "uint32_encrypt_prehead_length", "uint32_encrypt_type", "bytes_encrypt_key", "uint32_read_times", "uint32_left_time", "not_online_image", "elem_flags2", "uint32_opertype", "str_fromphonenum" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro2, localInteger, localInteger, null, null, localInteger, "" }, SecretFileMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.SecretFileMsg
 * JD-Core Version:    0.7.0.1
 */