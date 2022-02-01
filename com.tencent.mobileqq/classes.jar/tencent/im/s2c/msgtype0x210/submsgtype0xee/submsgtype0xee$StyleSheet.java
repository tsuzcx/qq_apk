package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xee$StyleSheet
  extends MessageMicro<StyleSheet>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_style_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_ark_enable = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_scene = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "enum_style_type", "uint32_ark_enable", "uint64_scene", "uint32_duration", "uint64_end_time" }, new Object[] { localInteger, localInteger, localLong, localInteger, localLong }, StyleSheet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.StyleSheet
 * JD-Core Version:    0.7.0.1
 */