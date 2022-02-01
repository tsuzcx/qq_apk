package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspSystemMsg
  extends MessageMicro<RspSystemMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "head", "msgs", "unread_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "msg_display" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, RspSystemMsg.class);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBStringField msg_display = PBField.initString("");
  public final PBRepeatMessageField<structmsg.StructMsg> msgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBUInt32Field unread_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.RspSystemMsg
 * JD-Core Version:    0.7.0.1
 */