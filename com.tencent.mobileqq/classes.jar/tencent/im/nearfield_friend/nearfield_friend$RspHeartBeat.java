package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearfield_friend$RspHeartBeat
  extends MessageMicro<RspHeartBeat>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "uin_list" }, new Object[] { null, Long.valueOf(0L) }, RspHeartBeat.class);
  public nearfield_friend.ResultInfo result = new nearfield_friend.ResultInfo();
  public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.RspHeartBeat
 * JD-Core Version:    0.7.0.1
 */