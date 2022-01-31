package tencent.im.oidb.cmd0x8ed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8ed$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_room_id", "uint64_judge_uin", "uint64_owner_uin", "rpt_uint64_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatField rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody
 * JD-Core Version:    0.7.0.1
 */