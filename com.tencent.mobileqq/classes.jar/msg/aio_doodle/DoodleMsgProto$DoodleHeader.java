package msg.aio_doodle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DoodleMsgProto$DoodleHeader
  extends MessageMicro<DoodleHeader>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField float_comp_factor_max = PBField.initFloat(0.0F);
  public final PBFloatField float_comp_factor_min = PBField.initFloat(0.0F);
  public final PBFloatField float_draw_area_height = PBField.initFloat(0.0F);
  public final PBFloatField float_draw_area_width = PBField.initFloat(0.0F);
  public final PBFloatField float_line_width_max = PBField.initFloat(0.0F);
  public final PBFloatField float_line_width_min = PBField.initFloat(0.0F);
  public final PBBytesField tytes_doodle_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_Version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_line_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 45, 53, 61, 69, 77, 85 }, new String[] { "uint32_Version", "tytes_doodle_md5", "uint32_time", "uint32_line_count", "float_line_width_max", "float_line_width_min", "float_comp_factor_max", "float_comp_factor_min", "float_draw_area_width", "float_draw_area_height" }, new Object[] { localInteger, localByteStringMicro, localInteger, localInteger, localFloat, localFloat, localFloat, localFloat, localFloat, localFloat }, DoodleHeader.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msg.aio_doodle.DoodleMsgProto.DoodleHeader
 * JD-Core Version:    0.7.0.1
 */