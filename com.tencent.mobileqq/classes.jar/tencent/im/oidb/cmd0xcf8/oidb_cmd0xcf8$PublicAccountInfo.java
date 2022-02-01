package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xcf8$PublicAccountInfo
  extends MessageMicro<PublicAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 40, 48, 56, 64, 72, 80, 88, 96, 106, 114, 120 }, new String[] { "name", "display_number", "summary", "is_recv_msg", "is_recv_push", "certified_grade", "is_sync_lbs", "group_id", "show_flag", "account_flag", "luin", "config_group_info", "config_group_info_new", "account_flag2" }, new Object[] { "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, Long.valueOf(0L) }, PublicAccountInfo.class);
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
  public final PBUInt32Field certified_grade = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigGroupInfo> config_group_info_new = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigGroupInfo.class);
  public final PBStringField display_number = PBField.initString("");
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBBoolField is_recv_msg = PBField.initBool(false);
  public final PBBoolField is_recv_push = PBField.initBool(false);
  public final PBBoolField is_sync_lbs = PBField.initBool(false);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field show_flag = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.PublicAccountInfo
 * JD-Core Version:    0.7.0.1
 */