package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 40, 50, 56 }, new String[] { "uint64_group_code", "uint64_begin_uin", "uint64_data_time", "rpt_uin_list", "opt_filter", "uint32_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0) }, ReqBody.class);
  public oidb_0x787.Filter opt_filter = new oidb_0x787.Filter();
  public final PBRepeatField rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_begin_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_data_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody
 * JD-Core Version:    0.7.0.1
 */