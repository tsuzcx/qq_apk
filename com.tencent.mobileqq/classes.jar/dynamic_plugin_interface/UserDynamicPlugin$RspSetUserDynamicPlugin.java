package dynamic_plugin_interface;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserDynamicPlugin$RspSetUserDynamicPlugin
  extends MessageMicro<RspSetUserDynamicPlugin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, RspSetUserDynamicPlugin.class);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dynamic_plugin_interface.UserDynamicPlugin.RspSetUserDynamicPlugin
 * JD-Core Version:    0.7.0.1
 */