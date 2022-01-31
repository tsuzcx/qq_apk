package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x84c$CAdcodeInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBBytesField adname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field begtime = PBField.initUInt64(0L);
  public final PBBytesField cityname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field endtime = PBField.initUInt64(0L);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField merchant_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field redpack_num = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "adcode", "redpack_num", "begtime", "endtime", "adname", "cityname", "icon", "merchant_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, CAdcodeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.CAdcodeInfo
 * JD-Core Version:    0.7.0.1
 */