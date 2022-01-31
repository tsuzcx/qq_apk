package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$PluginGroup
  extends MessageMicro<PluginGroup>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "res_id" }, new Object[] { Integer.valueOf(0) }, PluginGroup.class);
  public final PBRepeatField<Integer> res_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig.PluginGroup
 * JD-Core Version:    0.7.0.1
 */