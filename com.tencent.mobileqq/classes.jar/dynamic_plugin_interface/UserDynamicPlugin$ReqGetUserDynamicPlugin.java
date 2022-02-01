package dynamic_plugin_interface;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserDynamicPlugin$ReqGetUserDynamicPlugin
  extends MessageMicro<ReqGetUserDynamicPlugin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "platform", "plugin_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqGetUserDynamicPlugin.class);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt32Field plugin_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dynamic_plugin_interface.UserDynamicPlugin.ReqGetUserDynamicPlugin
 * JD-Core Version:    0.7.0.1
 */