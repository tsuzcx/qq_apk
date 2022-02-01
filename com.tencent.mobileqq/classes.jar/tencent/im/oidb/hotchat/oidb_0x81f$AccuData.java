package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x81f$AccuData
  extends MessageMicro<AccuData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_accu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_accu_value = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_accu_type", "uint32_accu_value" }, new Object[] { localInteger, localInteger }, AccuData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x81f.AccuData
 * JD-Core Version:    0.7.0.1
 */