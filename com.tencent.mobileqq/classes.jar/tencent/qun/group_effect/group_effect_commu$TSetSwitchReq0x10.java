package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu$TSetSwitchReq0x10
  extends MessageMicro<TSetSwitchReq0x10>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field forbid_self = PBField.initUInt64(0L);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "forbid_self" }, new Object[] { localLong, localLong }, TSetSwitchReq0x10.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TSetSwitchReq0x10
 * JD-Core Version:    0.7.0.1
 */