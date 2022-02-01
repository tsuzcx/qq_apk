package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$ReqNextSystemMsg
  extends MessageMicro<ReqNextSystemMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72 }, new String[] { "msg_num", "following_friend_seq", "following_group_seq", "checktype", "flag", "language", "version", "friend_msg_type_flag", "uint32_req_msg_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ReqNextSystemMsg.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public structmsg.FlagInfo flag = new structmsg.FlagInfo();
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public final PBUInt64Field friend_msg_type_flag = PBField.initUInt64(0L);
  public final PBUInt32Field language = PBField.initUInt32(0);
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.ReqNextSystemMsg
 * JD-Core Version:    0.7.0.1
 */