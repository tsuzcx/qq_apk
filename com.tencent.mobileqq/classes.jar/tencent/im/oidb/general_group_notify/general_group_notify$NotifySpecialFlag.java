package tencent.im.oidb.general_group_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class general_group_notify$NotifySpecialFlag
  extends MessageMicro<NotifySpecialFlag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "opt_uint32_is_hrtx" }, new Object[] { Integer.valueOf(0) }, NotifySpecialFlag.class);
  public final PBUInt32Field opt_uint32_is_hrtx = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.general_group_notify.general_group_notify.NotifySpecialFlag
 * JD-Core Version:    0.7.0.1
 */