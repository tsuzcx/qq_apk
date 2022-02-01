package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect$UserConfig
  extends MessageMicro<UserConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field effect_id = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field set_mode = PBField.initUInt64(0L);
  public final PBUInt64Field status = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_code", "effect_id", "status", "set_mode" }, new Object[] { localLong, Integer.valueOf(0), localLong, localLong }, UserConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect.UserConfig
 * JD-Core Version:    0.7.0.1
 */