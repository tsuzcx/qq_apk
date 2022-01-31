package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm$LabelDuplicate
  extends MessageMicro<LabelDuplicate>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_ori_label", "uint64_ori_label_id", "rpt_uint64_all_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, LabelDuplicate.class);
  public final PBRepeatField<Long> rpt_uint64_all_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_is_ori_label = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ori_label_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.LabelDuplicate
 * JD-Core Version:    0.7.0.1
 */