package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetGroupMsgReq
  extends MessageMicro<PbGetGroupMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "group_code", "begin_seq", "end_seq", "filter", "member_seq", "public_group", "shield_flag", "save_traffic_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, PbGetGroupMsgReq.class);
  public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field end_seq = PBField.initUInt64(0L);
  public final PBEnumField filter = PBField.initEnum(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBBoolField public_group = PBField.initBool(false);
  public final PBUInt32Field save_traffic_flag = PBField.initUInt32(0);
  public final PBUInt32Field shield_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetGroupMsgReq
 * JD-Core Version:    0.7.0.1
 */