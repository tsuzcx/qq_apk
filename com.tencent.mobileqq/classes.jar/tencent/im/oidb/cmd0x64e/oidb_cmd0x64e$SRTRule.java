package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x64e$SRTRule
  extends MessageMicro<SRTRule>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_app_package_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_h5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> uint32_click_number = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> uint32_feeds_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_network_type", "uint32_click_number", "uint32_feeds_type", "bytes_h5", "bytes_schema", "bytes_app_package_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SRTRule.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule
 * JD-Core Version:    0.7.0.1
 */