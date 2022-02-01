package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x938$ClientConfig
  extends MessageMicro<ClientConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_card_url_g = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_card_url_h = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_list_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_next_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_show_list", "uint32_show_card", "uint64_next_time", "bytes_card_url_h", "bytes_card_url_g", "bytes_list_jump_url" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ClientConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.ClientConfig
 * JD-Core Version:    0.7.0.1
 */