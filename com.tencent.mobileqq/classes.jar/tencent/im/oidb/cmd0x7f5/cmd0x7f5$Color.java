package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7f5$Color
  extends MessageMicro<Color>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_b = PBField.initUInt32(0);
  public final PBUInt32Field uint32_g = PBField.initUInt32(0);
  public final PBUInt32Field uint32_r = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_r", "uint32_g", "uint32_b" }, new Object[] { localInteger, localInteger, localInteger }, Color.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.Color
 * JD-Core Version:    0.7.0.1
 */