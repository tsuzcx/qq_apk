package tencent.qun.group_effect;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_effect_commu$TSetGlobalEffectReq0x20
  extends MessageMicro<TSetGlobalEffectReq0x20>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "global_effect_id" }, new Object[] { Integer.valueOf(0) }, TSetGlobalEffectReq0x20.class);
  public final PBUInt32Field global_effect_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.qun.group_effect.group_effect_commu.TSetGlobalEffectReq0x20
 * JD-Core Version:    0.7.0.1
 */