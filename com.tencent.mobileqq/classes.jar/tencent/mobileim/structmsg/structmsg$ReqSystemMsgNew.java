package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqSystemMsgNew
  extends MessageMicro<ReqSystemMsgNew>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 72, 80, 88 }, new String[] { "msg_num", "latest_friend_seq", "latest_group_seq", "version", "checktype", "flag", "language", "is_get_frd_ribbon", "is_get_grp_ribbon", "friend_msg_type_flag", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), null, Integer.valueOf(0), Boolean.valueOf(true), Boolean.valueOf(true), Long.valueOf(0L), Integer.valueOf(0) }, ReqSystemMsgNew.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public structmsg.FlagInfo flag = new structmsg.FlagInfo();
  public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
  public final PBBoolField is_get_frd_ribbon = PBField.initBool(true);
  public final PBBoolField is_get_grp_ribbon = PBField.initBool(true);
  public final PBUInt32Field language = PBField.initUInt32(0);
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.ReqSystemMsgNew
 * JD-Core Version:    0.7.0.1
 */