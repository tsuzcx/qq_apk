package tencent.im.oidb.cmd0xefe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xefe$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "mute_friend", "whitelist", "update_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatField<Long> mute_friend = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBInt64Field update_time = PBField.initInt64(0L);
  public final PBRepeatField<Long> whitelist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.RspBody
 * JD-Core Version:    0.7.0.1
 */