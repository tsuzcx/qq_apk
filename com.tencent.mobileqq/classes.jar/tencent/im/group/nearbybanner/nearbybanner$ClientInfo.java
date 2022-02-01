package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbybanner$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_lcd_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lcd_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_lcd_height", "uint32_lcd_width", "bytes_client_version", "uint32_os" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ClientInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.ClientInfo
 * JD-Core Version:    0.7.0.1
 */