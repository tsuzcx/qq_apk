package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6e5$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 96, 104 }, new String[] { "uint64_uin", "rpt_interest_label_list", "rpt_uint32_default_interest_label_id_list", "rpt_uint64_last_interest_label_id_list" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField rpt_interest_label_list = PBField.initRepeatMessage(oidb_cmd0x6e5.InterestLabelInfo.class);
  public final PBRepeatField rpt_uint32_default_interest_label_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint64_last_interest_label_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.RspBody
 * JD-Core Version:    0.7.0.1
 */