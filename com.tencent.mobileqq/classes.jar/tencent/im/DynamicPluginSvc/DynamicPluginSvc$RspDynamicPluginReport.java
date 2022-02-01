package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicPluginSvc$RspDynamicPluginReport
  extends MessageMicro<RspDynamicPluginReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, RspDynamicPluginReport.class);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc.RspDynamicPluginReport
 * JD-Core Version:    0.7.0.1
 */