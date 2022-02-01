package tencent.im.oidb.cmd0x798;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x798$Info
  extends MessageMicro<Info>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_flag", "uint32_type", "uint32_count" }, new Object[] { localInteger, localInteger, localInteger }, Info.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x798.oidb_0x798.Info
 * JD-Core Version:    0.7.0.1
 */