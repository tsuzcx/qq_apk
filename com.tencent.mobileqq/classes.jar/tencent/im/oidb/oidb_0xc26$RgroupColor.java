package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc26$RgroupColor
  extends MessageMicro<RgroupColor>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_b = PBField.initUInt32(0);
  public final PBUInt32Field uint32_g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { localInteger, localInteger, localInteger }, RgroupColor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.RgroupColor
 * JD-Core Version:    0.7.0.1
 */