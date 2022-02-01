package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x791$DTNearbyEntranceExtendConfig
  extends MessageMicro<DTNearbyEntranceExtendConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_has_hintWord = PBField.initBool(false);
  public final PBBoolField bool_has_waterMarkURLStr = PBField.initBool(false);
  public final PBBytesField str_hintWord = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_waterMarkURLStr = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "bool_has_waterMarkURLStr", "str_waterMarkURLStr", "bool_has_hintWord", "str_hintWord" }, new Object[] { Boolean.valueOf(false), localByteStringMicro1, Boolean.valueOf(false), localByteStringMicro2 }, DTNearbyEntranceExtendConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceExtendConfig
 * JD-Core Version:    0.7.0.1
 */