package msf.registerproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy$GroupList
  extends MessageMicro<GroupList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "group_code", "group_seq", "member_seq", "mask", "redpack_time", "has_msg", "group_flag", "group_type", "group_name_seq", "group_member_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupList.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBInt64Field group_flag = PBField.initInt64(0L);
  public final PBUInt32Field group_member_seq = PBField.initUInt32(0);
  public final PBUInt32Field group_name_seq = PBField.initUInt32(0);
  public final PBUInt64Field group_seq = PBField.initUInt64(0L);
  public final PBUInt64Field group_type = PBField.initUInt64(0L);
  public final PBBoolField has_msg = PBField.initBool(false);
  public final PBUInt64Field mask = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBUInt64Field redpack_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.registerproxy.register_proxy.GroupList
 * JD-Core Version:    0.7.0.1
 */