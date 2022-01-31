package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6b6$SendFlowerReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gift_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recv_user_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_send_user_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ticketid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_count = PBField.initInt32(0);
  public final PBInt32Field int32_discount_amount = PBField.initInt32(0);
  public final PBUInt32Field uint32_custom_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gift_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_play_rule = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 82, 90, 96 }, new String[] { "int32_count", "uint64_to_uin", "uint32_play_rule", "uint32_custom_flag", "uint32_product_id", "uint32_gift_id", "uint32_gift_num", "bytes_gift_text", "bytes_send_user_name", "bytes_recv_user_name", "bytes_ticketid", "int32_discount_amount" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, SendFlowerReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerReq
 * JD-Core Version:    0.7.0.1
 */