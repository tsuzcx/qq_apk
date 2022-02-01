package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicPluginSvc$RspDynamicPluginStat
  extends MessageMicro<RspDynamicPluginStat>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "list_data", "ret", "old_user" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false) }, RspDynamicPluginStat.class);
  public final PBRepeatMessageField<DynamicPluginSvc.PluginData> list_data = PBField.initRepeatMessage(DynamicPluginSvc.PluginData.class);
  public final PBBoolField old_user = PBField.initBool(false);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc.RspDynamicPluginStat
 * JD-Core Version:    0.7.0.1
 */