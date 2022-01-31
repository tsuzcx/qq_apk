package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGetDiscussMsgReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "discuss_uin", "end_seq", "begin_seq", "last_get_time", "discuss_info_seq", "filter", "member_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, PbGetDiscussMsgReq.class);
  public final PBUInt64Field begin_seq = PBField.initUInt64(0L);
  public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field end_seq = PBField.initUInt64(0L);
  public final PBEnumField filter = PBField.initEnum(0);
  public final PBUInt64Field last_get_time = PBField.initUInt64(0L);
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetDiscussMsgReq
 * JD-Core Version:    0.7.0.1
 */