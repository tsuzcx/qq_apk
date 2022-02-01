package tencent.im.oidb.cmd0xe63;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe63$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_online_status_visible_to_all_frd", "rpt_uint64_uin_can_see_my_online_status", "rpt_uint64_uin_online_status_visible_to_me", "rpt_uint32_smart_status" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBBoolField bool_online_status_visible_to_all_frd = PBField.initBool(false);
  public final PBRepeatField<Integer> rpt_uint32_smart_status = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uin_can_see_my_online_status = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uin_online_status_visible_to_me = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe63.oidb_cmd0xe63.RspBody
 * JD-Core Version:    0.7.0.1
 */