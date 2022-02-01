package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7f5$Wifi
  extends MessageMicro<Wifi>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_mac = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_rssi = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_mac", "uint32_rssi" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, Wifi.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.Wifi
 * JD-Core Version:    0.7.0.1
 */