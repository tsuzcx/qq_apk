package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_friend$ReqHeartBeat
  extends MessageMicro<ReqHeartBeat>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "session_id", "uin_list" }, new Object[] { "", Long.valueOf(0L) }, ReqHeartBeat.class);
  public final PBStringField session_id = PBField.initString("");
  public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.ReqHeartBeat
 * JD-Core Version:    0.7.0.1
 */