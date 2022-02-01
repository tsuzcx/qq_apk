package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicPluginSvc$ReqDynamicPluginReport
  extends MessageMicro<ReqDynamicPluginReport>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field plugin_id = PBField.initUInt32(0);
  public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plugin_id", "plugin_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ReqDynamicPluginReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc.ReqDynamicPluginReport
 * JD-Core Version:    0.7.0.1
 */