package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x406$GroupFee
  extends MessageMicro<GroupFee>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "string_project_id", "string_project_name", "uint32_project_cost", "uint32_project_paid_user", "uint32_project_npaid_user", "uint64_project_start_time", "uint64_project_close_time", "uint32_project_status", "uint32_project_paid" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GroupFee.class);
  public final PBStringField string_project_id = PBField.initString("");
  public final PBStringField string_project_name = PBField.initString("");
  public final PBUInt32Field uint32_project_cost = PBField.initUInt32(0);
  public final PBUInt32Field uint32_project_npaid_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_project_paid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_project_paid_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_project_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_project_close_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_project_start_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x406.cmd0x406.GroupFee
 * JD-Core Version:    0.7.0.1
 */