package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class DynamicPluginSvc$ReqDynamicPluginStat
  extends MessageMicro<ReqDynamicPluginStat>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "old_user" }, new Object[] { Boolean.valueOf(false) }, ReqDynamicPluginStat.class);
  public final PBBoolField old_user = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc.ReqDynamicPluginStat
 * JD-Core Version:    0.7.0.1
 */