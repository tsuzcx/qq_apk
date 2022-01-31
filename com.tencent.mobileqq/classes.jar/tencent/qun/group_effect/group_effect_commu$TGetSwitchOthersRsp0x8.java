package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class group_effect_commu$TGetSwitchOthersRsp0x8
  extends MessageMicro<TGetSwitchOthersRsp0x8>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ret", "forbid_others" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TGetSwitchOthersRsp0x8.class);
  public final PBInt32Field forbid_others = PBField.initInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TGetSwitchOthersRsp0x8
 * JD-Core Version:    0.7.0.1
 */