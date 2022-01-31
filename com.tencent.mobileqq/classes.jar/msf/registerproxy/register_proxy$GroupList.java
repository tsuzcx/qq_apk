package msf.registerproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy$GroupList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "group_code", "group_seq", "member_seq", "mask", "redpack_time", "has_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, GroupList.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_seq = PBField.initUInt64(0L);
  public final PBBoolField has_msg = PBField.initBool(false);
  public final PBUInt64Field mask = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBUInt64Field redpack_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.registerproxy.register_proxy.GroupList
 * JD-Core Version:    0.7.0.1
 */