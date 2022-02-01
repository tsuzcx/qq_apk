package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x972$ExtensionRequestInfo
  extends MessageMicro<ExtensionRequestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBInt32Field radius = PBField.initInt32(0);
  public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Float localFloat = Float.valueOf(0.0F);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region" }, new Object[] { localByteStringMicro1, localFloat, localFloat, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, ExtensionRequestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x972.oidb_0x972.ExtensionRequestInfo
 * JD-Core Version:    0.7.0.1
 */