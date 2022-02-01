package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6b6$SendFlowerRsp
  extends MessageMicro<SendFlowerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_imagent_package = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_midas_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_product_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_give_stock = PBField.initInt64(0L);
  public final PBUInt32Field uint32_balance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_product_id", "bytes_midas_json", "int64_give_stock", "uint32_balance", "bytes_product_name", "bytes_imagent_package" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, SendFlowerRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerRsp
 * JD-Core Version:    0.7.0.1
 */