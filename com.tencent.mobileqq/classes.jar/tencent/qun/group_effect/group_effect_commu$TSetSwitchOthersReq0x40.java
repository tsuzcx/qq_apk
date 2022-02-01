package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_effect_commu$TSetSwitchOthersReq0x40
  extends MessageMicro<TSetSwitchOthersReq0x40>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "forbid_others" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TSetSwitchOthersReq0x40.class);
  public final PBInt32Field forbid_others = PBField.initInt32(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TSetSwitchOthersReq0x40
 * JD-Core Version:    0.7.0.1
 */