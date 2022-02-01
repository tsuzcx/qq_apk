package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$ShadowInfoCtl
  extends MessageMicro<ShadowInfoCtl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_sys_id", "uint32_op_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ShadowInfoCtl.class);
  public final PBRepeatField<Integer> rpt_sys_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ShadowInfoCtl
 * JD-Core Version:    0.7.0.1
 */