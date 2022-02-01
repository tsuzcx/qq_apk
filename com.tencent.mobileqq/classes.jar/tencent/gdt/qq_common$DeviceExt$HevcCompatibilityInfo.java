package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_common$DeviceExt$HevcCompatibilityInfo
  extends MessageMicro<HevcCompatibilityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field max_fps = PBField.initUInt32(0);
  public final PBUInt64Field max_luma_samples = PBField.initUInt64(0L);
  public final PBEnumField video_player_type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "video_player_type", "max_luma_samples", "max_fps" }, new Object[] { localInteger, Long.valueOf(0L), localInteger }, HevcCompatibilityInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.HevcCompatibilityInfo
 * JD-Core Version:    0.7.0.1
 */