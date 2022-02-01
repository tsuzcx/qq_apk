package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$LifeOnlineAccount
  extends MessageMicro<LifeOnlineAccount>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField gdt_cli_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField gdt_imp_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ack = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bitmap = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
  public final PBBytesField view_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74 }, new String[] { "uint64_unique_id", "uint32_op", "uint32_show_time", "uint32_report", "uint32_ack", "uint64_bitmap", "gdt_imp_data", "gdt_cli_data", "view_id" }, new Object[] { localLong, localInteger, localInteger, localInteger, localInteger, localLong, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, LifeOnlineAccount.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.LifeOnlineAccount
 * JD-Core Version:    0.7.0.1
 */