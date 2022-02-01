package tencent.im.oidb.channel_button;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class channel_button$RedPoint
  extends MessageMicro<RedPoint>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_red_point = PBField.initBool(false);
  public final PBStringField str_title_text = PBField.initString("");
  public final PBUInt32Field uint32_bg_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_title_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 800 }, new String[] { "bool_red_point", "uint64_start_time", "uint64_end_time", "uint32_type", "str_title_text", "uint32_title_color", "uint32_bg_color", "uint64_seq" }, new Object[] { Boolean.valueOf(false), localLong, localLong, localInteger, "", localInteger, localInteger, localLong }, RedPoint.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.channel_button.channel_button.RedPoint
 * JD-Core Version:    0.7.0.1
 */